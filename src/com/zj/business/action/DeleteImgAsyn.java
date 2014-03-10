package com.zj.business.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zj.common.exception.UploadFileException;
import com.zj.common.utils.JSONUtil;
import com.zj.core.control.struts.BaseAction;

@Component("asynDelImg")
@Scope("prototype")
public class DeleteImgAsyn extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2448468493447367942L;
	private static final Log log = LogFactory.getLog(DeleteImgAsyn.class);
	private String imgSrc;
	
	public void deleteImg(){
		Map<String,Object> result = new HashMap<String, Object>();
		String prefix = getWebRootPath();
		String imgPath = imgSrc.substring(prefix.length());
		try {
			preDeleteFile(getBasePath()+imgPath);
			result.put("type", "true");
			result.put("msg", "delete this image success!");
		} catch (UploadFileException e) {
			log.error(e);
			result.put("type", "false");
			result.put("msg", "cannot delete this image!");
		}
		String json = JSONUtil.mapToJson(result);
		sendJSONdata(json);
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}
