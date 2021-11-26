/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

public class TaifTPersonaUpdateTitolare implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer fkTitoloStudio;
	protected Integer fkTitoloStudioFra;
	protected Integer fkNazione;
	protected String nRsiMsa;
	protected String flgSesso;
	protected java.sql.Date dataNascita;
	protected String istatComuneNascita;
	protected String comuneEsteroNascita;
	protected String istatComuneRes;
	protected String comuneEsteroRes;
	protected String indirizzoRes;
	protected String civicoRes;
	protected String capRes;
	protected String telefono;
	protected String cellulare;
	protected String mail;
	protected String altriStudi;
	protected java.sql.Timestamp dataAggiornamento;
	protected Integer fkConfigUtente;
	public void setFkTitoloStudio(Integer fkTitoloStudio) {
		this.fkTitoloStudio = fkTitoloStudio;
	}
	public void setFkTitoloStudioFra(Integer fkTitoloStudioFra) {
		this.fkTitoloStudioFra = fkTitoloStudioFra;
	}
	public void setFkNazione(Integer fkNazione) {
		this.fkNazione = fkNazione;
	}
	public void setnRsiMsa(String nRsiMsa) {
		this.nRsiMsa = nRsiMsa;
	}
	public void setFlgSesso(String flgSesso) {
		this.flgSesso = flgSesso;
	}
	public void setDataNascita(java.sql.Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public void setIstatComuneNascita(String istatComuneNascita) {
		this.istatComuneNascita = istatComuneNascita;
	}
	public void setComuneEsteroNascita(String comuneEsteroNascita) {
		this.comuneEsteroNascita = comuneEsteroNascita;
	}
	public void setIstatComuneRes(String istatComuneRes) {
		this.istatComuneRes = istatComuneRes;
	}
	public void setComuneEsteroRes(String comuneEsteroRes) {
		this.comuneEsteroRes = comuneEsteroRes;
	}
	public void setIndirizzoRes(String indirizzoRes) {
		this.indirizzoRes = indirizzoRes;
	}
	public void setCivicoRes(String civicoRes) {
		this.civicoRes = civicoRes;
	}
	public void setCapRes(String capRes) {
		this.capRes = capRes;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setAltriStudi(String altriStudi) {
		this.altriStudi = altriStudi;
	}
	public void setDataAggiornamento(java.sql.Timestamp dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}
	public void setFkConfigUtente(Integer fkConfigUtente) {
		this.fkConfigUtente = fkConfigUtente;
	}

	
	
}
