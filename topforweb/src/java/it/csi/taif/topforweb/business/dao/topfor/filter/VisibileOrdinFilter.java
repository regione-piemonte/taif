/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.filter;

import java.io.Serializable;

public class VisibileOrdinFilter implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private int flagVisibile;
	private String flagItaFr;
	
	public int getFlagVisibile() {
		return flagVisibile;
	}
	public void setFlagVisibile(int flagVisibile) {
		this.flagVisibile = flagVisibile;
	}
	public String getFlagItaFr() {
		return flagItaFr;
	}
	public void setFlagItaFr(String flagItaFr) {
		this.flagItaFr = flagItaFr;
	}

}
