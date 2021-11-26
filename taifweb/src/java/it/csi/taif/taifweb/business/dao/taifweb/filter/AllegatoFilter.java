/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class AllegatoFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idPratica;
	private int idCorso;
	private int idPersona;
	private int tipoAllegato;
	private String nomeAllegayo;
	private String tipoInvio;
	
	public int getIdPratica() {
		return idPratica;
	}
	public void setIdPratica(int idPratica) {
		this.idPratica = idPratica;
	}
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getTipoAllegato() {
		return tipoAllegato;
	}
	public void setTipoAllegato(int tipoAllegato) {
		this.tipoAllegato = tipoAllegato;
	}
	public String getNomeAllegayo() {
		return nomeAllegayo;
	}
	public void setNomeAllegayo(String nomeAllegayo) {
		this.nomeAllegayo = nomeAllegayo;
	}
	public String getTipoInvio() {
		return tipoInvio;
	}
	public void setTipoInvio(String tipoInvio) {
		this.tipoInvio = tipoInvio;
	}
	

	
	

}
