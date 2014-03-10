package com.zj.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zj.common.exception.DAOException;
import com.zj.common.utils.PageInfo;

public class MySQLHibernateDAO extends CommonDAOImpl {
	private static final Log log = LogFactory.getLog(MySQLHibernateDAO.class);
	@SuppressWarnings("unchecked")
	@Override
	public <T> PageInfo<T> querySQL(String sql, int pageSize, int pageNum,
			String dbname) throws DAOException {
		log.info(">>>>>>>start MySQLHibernateDAO.querySQL()...");
		log.info(">>>>>>>parameters => sqlStatement="+sql+" , pageSize="+pageSize+" , pageNum="+pageNum+" , dbname="+dbname);
		Long stime = System.currentTimeMillis();
		PageInfo<T> pageinfo = new PageInfo<T>();
		if(pageSize > 1000){
            throw new DAOException("分页查询异常：" + "单页查询数量过大>1000");
        }

        pageinfo.setPageNum(pageNum);
        pageinfo.setPageSize(pageSize);
        if(pageNum < 1){
            pageinfo.setPageNum(1);
            pageNum = 1;
            log.info("分页查询警告：" + "分页页码未设置，默认取第一页");
        }
        if(pageSize < 1){
            pageinfo.setPageSize(1000);
            pageSize = 1000;
            log.info("分页查询警告：" + "单页数量未设置，默认取前1000条记录");
        }

        // /计算总条数
        String tmp;
        int orderpoint = sql.toLowerCase().indexOf("order by");
        if(orderpoint > 0){
            tmp = sql.substring(0, orderpoint - 1);
        }
        else{
            tmp = sql;
        }
        String countSql = "select count(*) n from ( select * from (" + tmp + "))";
        List<Map<String,Object>> list_temp = querySQL(countSql,dbname);
        int rowCount = Integer.parseInt(((Map<String,Object>)list_temp.get(0)).get("N").toString());
        pageinfo.setRowCount(rowCount);

        pageinfo.setPageCount((rowCount + pageSize) / pageSize);
        if(rowCount % pageSize == 0){
            pageinfo.setPageCount(pageinfo.getPageCount() - 1);
        }
     // 计算需要返回的行数
        int startn = (pageNum - 1) * pageSize;
        int endn = pageNum * pageSize + 1;
        String sqlQ = sql + " limit "+startn +","+endn;
        log.info(">>>>>> sql = "+sqlQ);
        list_temp = querySQL(sqlQ, dbname);
        pageinfo.setObjectList((List<T>) list_temp);
        double usedtime = (System.currentTimeMillis() - stime) / 1000.0;
        if(usedtime > 3000){
        	log.warn("MySQLHibernateDAO.querySQL() used time=" + usedtime + " s");
        }
		return pageinfo;
	}
}
