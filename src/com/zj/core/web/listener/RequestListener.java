package com.zj.core.web.listener;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author zhujian
 *	request监听器
 */
public class RequestListener implements  ServletRequestListener,ServletRequestAttributeListener {
	private static final Log log = LogFactory.getLog(RequestListener.class);
	
	public void requestDestroyed(ServletRequestEvent event) {
	}
	/**
	 * 当请求一个网页时会调用
	 */
	public void requestInitialized(ServletRequestEvent event) {
		log.debug("###################### request Listener start#########################");
		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		String fallUrl = request.getRequestURI();
		Map<String,String[]> parameters = request.getParameterMap();
		log.debug("fallUrl = "+fallUrl);
		for(Iterator<Entry<String, String[]>> it = parameters.entrySet().iterator();it.hasNext();){
			Entry<String,String[]> entry = it.next();
			log.debug("--parameter : [key="+entry.getKey()+",value="+Arrays.asList(entry.getValue()).toString());
		}
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			log.debug("request header --- "+headers.nextElement());
		}
		log.debug("request content-type is "+request.getHeader("Content-Type"));
		log.debug("host = "+request.getRemoteHost());
		log.debug("addr = "+request.getRemoteAddr());
		log.debug("user = "+request.getRemoteUser());
		log.debug("###################### request Listener end#########################");
		Enumeration<String> headernames = request.getHeaderNames();
		request.getParameterMap();
	}

	public void attributeAdded(ServletRequestAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void attributeRemoved(ServletRequestAttributeEvent event) {
		// TODO Auto-generated method stub
	}

	public void attributeReplaced(ServletRequestAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
