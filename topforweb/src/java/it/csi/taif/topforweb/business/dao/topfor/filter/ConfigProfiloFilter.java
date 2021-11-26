/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.filter;

import java.io.Serializable;

public class ConfigProfiloFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codiceFiscale;
	private String profiloUtente;
	private int idProcedura;
	private int flagAttivo;
	private String dataTracciato;
	
	
	
	public String getProfiloUtente() {
		return profiloUtente;
	}
	public void setProfiloUtente(String profiloUtente) {
		this.profiloUtente = profiloUtente;
	}
	public int getIdProcedura() {
		return idProcedura;
	}
	public void setIdProcedura(int idProcedura) {
		this.idProcedura = idProcedura;
	}
	public int getFlagAttivo() {
		return flagAttivo;
	}
	public void setFlagAttivo(int flagAttivo) {
		this.flagAttivo = flagAttivo;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getDataTracciato() {
	    return dataTracciato;
	}
	public void setDataTracciato(String dataTracciato) {
	    this.dataTracciato = dataTracciato;
	}
	
	
}
