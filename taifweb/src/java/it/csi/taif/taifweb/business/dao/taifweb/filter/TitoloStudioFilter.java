/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class TitoloStudioFilter implements Serializable {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idTitoloStudio;
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
	public int getIdTitoloStudio() {
		return idTitoloStudio;
	}
	public void setIdTitoloStudio(int idTitoloStudio) {
		this.idTitoloStudio = idTitoloStudio;
	}
	

	
	
}
