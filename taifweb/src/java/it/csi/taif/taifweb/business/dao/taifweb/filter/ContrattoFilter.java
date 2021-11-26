/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class ContrattoFilter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idContratto;
	private int flagVisibile;
	private String flagItaFr;
	private String tipoContratto;
	
	
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
	public String getTipoContratto() {
		return tipoContratto;
	}
	public void setTipoContratto(String tipoContratto) {
		this.tipoContratto = tipoContratto;
	}
	public int getIdContratto() {
		return idContratto;
	}
	public void setIdContratto(int idContratto) {
		this.idContratto = idContratto;
	}
	

}
