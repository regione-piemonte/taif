/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class MaterialeFilter  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int flagVisibile;
	private String flagVivaiArb;
	
	
	public int getFlagVisibile() {
		return flagVisibile;
	}
	public void setFlagVisibile(int flagVisibile) {
		this.flagVisibile = flagVisibile;
	}
	public String getFlagVivaiArb() {
		return flagVivaiArb;
	}
	public void setFlagVivaiArb(String flagVivaiArb) {
		this.flagVivaiArb = flagVivaiArb;
	}
	
	
	
	
	

}
