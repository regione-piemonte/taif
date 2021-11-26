/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class CategoriaMezzoFilter implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idCategoriaMezzo;
	private int flagVisibile;
	private String flagItaFr;
	private String categoriaMezzo;
	
	public String getCategoriaMezzo() {
		return categoriaMezzo;
	}
	public void setCategoriaMezzo(String categoriaMezzo) {
		this.categoriaMezzo = categoriaMezzo;
	}
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
	public int getIdCategoriaMezzo() {
		return idCategoriaMezzo;
	}
	public void setIdCategoriaMezzo(int idCategoriaMezzo) {
		this.idCategoriaMezzo = idCategoriaMezzo;
	}
	
	
}
