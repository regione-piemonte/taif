/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto;

import java.io.Serializable;

public class ApiManagerDto implements Serializable{
	
	private static final long serialVersionUID = 8854892265338235722L;
	
	private String consumerSecret;
	private String consumerKey;
	private String url;
	
	public String getConsumerSecret() {
		return consumerSecret;
	}
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}
	public String getConsumerKey() {
		return consumerKey;
	}
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
