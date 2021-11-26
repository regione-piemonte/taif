/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class TipoMezzoFilter implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private int  idCategoriaMezzo;
	private int  idAzienda;
	private int  idTipoMezzo;
	private String tipoMezzo;
	private int flagVisibile;
	private String flagItaFr;
	private String categoriaMezzo;
	
	public int getIdCategoriaMezzo() {
		return idCategoriaMezzo;
	}
	public void setIdCategoriaMezzo(int idCategoriaMezzo) {
		this.idCategoriaMezzo = idCategoriaMezzo;
	}
	public String getTipoMezzo() {
		return tipoMezzo;
	}
	public void setTipoMezzo(String tipoMezzo) {
		this.tipoMezzo = tipoMezzo;
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
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	
	public int getIdTipoMezzo() {
		return idTipoMezzo;
	}
	public void setIdTipoMezzo(int idTipoMezzo) {
		this.idTipoMezzo = idTipoMezzo;
	}
	public String getCategoriaMezzo() {
		return categoriaMezzo;
	}
	public void setCategoriaMezzo(String categoriaMezzo) {
		this.categoriaMezzo = categoriaMezzo;
	}
	
	
	
	
}
