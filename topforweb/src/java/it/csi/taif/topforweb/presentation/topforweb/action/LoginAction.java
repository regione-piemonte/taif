/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import it.csi.taif.topforweb.util.Constants;

public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8449836113703434106L;
	
	private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");
	
	private String location;
	private HttpServletRequest request;
    private HttpServletResponse response;
	
	
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}



	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		
		
	}



	public String execute() throws Exception {
		LOGGER.debug("[LoginAction::execute] BEGIN");
		
		return SUCCESS;
	}



	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRequest(HttpServletRequest request) {
		 this.request = request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletRequest getRequest() {
        return this.request;
    }
	
	public HttpServletResponse getResponse() {
        return this.response;
    }
	
}
