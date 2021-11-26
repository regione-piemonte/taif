/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class PersonaAziendaFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idAzienda;
	private int idRuolo;
	private int idMansione;
	private int idTipoContratto;
	private int idTipoInquadramento;
	private int flagDeterminato;
	private int giorni;
	private int idConfigUtente;
	

	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public int getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}
	public int getIdMansione() {
		return idMansione;
	}
	public void setIdMansione(int idMansione) {
		this.idMansione = idMansione;
	}
	public int getIdTipoContratto() {
		return idTipoContratto;
	}
	public void setIdTipoContratto(int idTipoContratto) {
		this.idTipoContratto = idTipoContratto;
	}
	public int getIdTipoInquadramento() {
		return idTipoInquadramento;
	}
	public void setIdTipoInquadramento(int idTipoInquadramento) {
		this.idTipoInquadramento = idTipoInquadramento;
	}
	public int getFlagDeterminato() {
		return flagDeterminato;
	}
	public void setFlagDeterminato(int flagDeterminato) {
		this.flagDeterminato = flagDeterminato;
	}
	public int getGiorni() {
		return giorni;
	}
	public void setGiorni(int giorni) {
		this.giorni = giorni;
	}
	public int getIdConfigUtente() {
		return idConfigUtente;
	}
	public void setIdConfigUtente(int idConfigUtente) {
		this.idConfigUtente = idConfigUtente;
	}
	
	

}
