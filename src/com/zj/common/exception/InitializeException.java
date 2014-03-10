package com.zj.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class InitializeException extends Exception {
	private static final Log log = LogFactory.getLog(InitializeException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -4951127921830270562L;

	public InitializeException() {
		super();
	}

	public InitializeException(String msg, Throwable cause) {
		super(msg, cause);
		log.info( msg);
	}

	public InitializeException(String msg) {
		super(msg);
		log.info( msg);
	}
	
}
