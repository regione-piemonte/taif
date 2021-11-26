/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class DpiFilter implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idAzienda;
	private int tipoDpi;
	private String tipologia;
	private int quantita;
	private int annoScadenza;
	
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public int getTipoDpi() {
		return tipoDpi;
	}
	public void setTipoDpi(int tipoDpi) {
		this.tipoDpi = tipoDpi;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public int getAnnoScadenza() {
		return annoScadenza;
	}
	public void setAnnoScadenza(int annoScadenza) {
		this.annoScadenza = annoScadenza;
	}
	
	
	
	

}
