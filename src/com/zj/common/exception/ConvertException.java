package com.zj.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author zj
 *	
 * 项目名称：baseProject
 *
 * 类名称：ConvertException
 *
 * 包名称：com.zj.common.exception
 *
 * Operate Time: 2013-6-11 下午08:42:18
 *
 * remark (备注):
 *
 * 文件名称：ConvertException.java
 *
 */
public class ConvertException extends ServiceException {
	private static final Log log = LogFactory.getLog(ConvertException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -3527744367910124313L;

	public ConvertException(String msg, Throwable cause) {
		super(msg, cause);
		log.info(msg);
	}

	public ConvertException(String msg) {
		super(msg);
		log.info(msg);
	}

}
