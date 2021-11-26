/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;


public class AziendaFrTipoContrFilter implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idAzienda;
	private int idTipoContratto;
	private int nrAddetti;
	private int idConfigUtente;
	
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public int getIdTipoContratto() {
		return idTipoContratto;
	}
	public void setIdTipoContratto(int idTipoContratto) {
		this.idTipoContratto = idTipoContratto;
	}
	public int getNrAddetti() {
		return nrAddetti;
	}
	public void setNrAddetti(int nrAddetti) {
		this.nrAddetti = nrAddetti;
	}
	public int getIdConfigUtente() {
		return idConfigUtente;
	}
	public void setIdConfigUtente(int idConfigUtente) {
		this.idConfigUtente = idConfigUtente;
	}
	

}
