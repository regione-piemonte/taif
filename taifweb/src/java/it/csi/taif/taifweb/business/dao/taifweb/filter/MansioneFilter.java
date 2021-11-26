/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class MansioneFilter implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idMansione;
	private int flagVisibile;
	private String flagItaFr;
	private String tipoMansione;
	
	
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
	public String getTipoMansione() {
		return tipoMansione;
	}
	public void setTipoMansione(String tipoMansione) {
		this.tipoMansione = tipoMansione;
	}
	public int getIdMansione() {
		return idMansione;
	}
	public void setIdMansione(int idMansione) {
		this.idMansione = idMansione;
	}

	
	
	
	
}
