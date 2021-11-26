/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class LavoroPaFilter implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int flagVisibile;
	private String flagItaFr;
	private String commitente;
	private int tipoLavoro;
	private int idAzienda;
	
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
	public String getCommitente() {
		return commitente;
	}
	public void setCommitente(String commitente) {
		this.commitente = commitente;
	}
	public int getTipoLavoro() {
		return tipoLavoro;
	}
	public void setTipoLavoro(int tipoLavoro) {
		this.tipoLavoro = tipoLavoro;
	}
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	
	

}
