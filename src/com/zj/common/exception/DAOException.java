package com.zj.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;


/**
 * 
 * @author zj
 *	
 * 项目名称：baseProject
 *
 * 类名称：DAOException
 *
 * 包名称：com.zj.common.exception
 *
 * Operate Time: 2013-4-20 下午06:05:33
 *
 * remark (备注): custom dao exception
 *
 * 文件名称：DAOException.java
 *
 */
public class DAOException extends DataAccessException {
	private static final Log log = LogFactory.getLog(DAOException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -7199624002622616438L;
	public DAOException(String msg) {
		super(msg);
		log.info(msg);
	}
	public DAOException(String msg, Throwable throwable) {
        super(msg, throwable); 
        log.info( msg);
    }
}
