/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class PersonaSoggettogestoreFilter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSoggettoGestore;
	private int idPersona;
	private int idProfilo;
	
	public int getIdSoggettoGestore() {
		return idSoggettoGestore;
	}
	public void setIdSoggettoGestore(int idSoggettoGestore) {
		this.idSoggettoGestore = idSoggettoGestore;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getIdProfilo() {
		return idProfilo;
	}
	public void setIdProfilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}
	
	
	
	

}
