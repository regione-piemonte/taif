/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class FunzioneVisibleFilter implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String flagItaFr;
	private int flagVisibile;
	private String funzioneName;
	
	
	public String getFlagItaFr() {
		return flagItaFr;
	}
	public void setFlagItaFr(String flagItaFr) {
		this.flagItaFr = flagItaFr;
	}
	public int getFlagVisibile() {
		return flagVisibile;
	}
	public void setFlagVisibile(int flagVisibile) {
		this.flagVisibile = flagVisibile;
	}
	public String getFunzioneName() {
		return funzioneName;
	}
	public void setFunzioneName(String funzioneName) {
		this.funzioneName = funzioneName;
	}
	
	
}
