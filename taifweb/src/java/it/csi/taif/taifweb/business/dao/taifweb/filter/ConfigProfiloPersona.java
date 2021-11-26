/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class ConfigProfiloPersona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codiceFiscale;
	private int idProfiloUtente;
	
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public int getIdProfiloUtente() {
		return idProfiloUtente;
	}
	public void setIdProfiloUtente(int idProfiloUtente) {
		this.idProfiloUtente = idProfiloUtente;
	}
	
	

}
