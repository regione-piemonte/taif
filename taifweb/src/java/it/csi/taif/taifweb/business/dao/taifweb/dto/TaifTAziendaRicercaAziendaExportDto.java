/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder ricercaAziendaExport.
 * @generated
 */
public class TaifTAziendaRicercaAziendaExportDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idAzienda;

	/**
	 * @generated
	 */
	public void setIdAzienda(Integer val) {

		idAzienda = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAzienda() {

		return idAzienda;

	}

	/*	 
	 * @generated
	 */
	private Integer idAlboAppartenenza;

	/**
	 * @generated
	 */
	public void setIdAlboAppartenenza(Integer val) {

		idAlboAppartenenza = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAlboAppartenenza() {

		return idAlboAppartenenza;

	}

	/*	 
	 * @generated
	 */
	private String denominazioneAzienda;

	/**
	 * @generated
	 */
	public void setDenominazioneAzienda(String val) {

		denominazioneAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazioneAzienda() {

		return denominazioneAzienda;

	}

	/*	 
	 * @generated
	 */
	private String codiceFiscaleAzienda;

	/**
	 * @generated
	 */
	public void setCodiceFiscaleAzienda(String val) {

		codiceFiscaleAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getCodiceFiscaleAzienda() {

		return codiceFiscaleAzienda;

	}

	/*	 
	 * @generated
	 */
	private String pivaAzienda;

	/**
	 * @generated
	 */
	public void setPivaAzienda(String val) {

		pivaAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getPivaAzienda() {

		return pivaAzienda;

	}

	/*	 
	 * @generated
	 */
	private String numeroAlbo;

	/**
	 * @generated
	 */
	public void setNumeroAlbo(String val) {

		numeroAlbo = val;

	}
	/**
	 * @generated
	 */
	public String getNumeroAlbo() {

		return numeroAlbo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date iscrizioneAlbo;

	/**
	 * @generated
	 */
	public void setIscrizioneAlbo(java.sql.Date val) {

		if (val != null) {
			iscrizioneAlbo = new java.sql.Date(val.getTime());
		} else {
			iscrizioneAlbo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getIscrizioneAlbo() {

		if (iscrizioneAlbo != null) {
			return new java.sql.Date(iscrizioneAlbo.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer idPratica;

	/**
	 * @generated
	 */
	public void setIdPratica(Integer val) {

		idPratica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPratica() {

		return idPratica;

	}

	/*	 
	 * @generated
	 */
	private String istatComuneSede;

	/**
	 * @generated
	 */
	public void setIstatComuneSede(String val) {

		istatComuneSede = val;

	}
	/**
	 * @generated
	 */
	public String getIstatComuneSede() {

		return istatComuneSede;

	}

	/*	 
	 * @generated
	 */
	private String siglaProvincia;

	/**
	 * @generated
	 */
	public void setSiglaProvincia(String val) {

		siglaProvincia = val;

	}
	/**
	 * @generated
	 */
	public String getSiglaProvincia() {

		return siglaProvincia;

	}

	/*	 
	 * @generated
	 */
	private String numeroCciaa;

	/**
	 * @generated
	 */
	public void setNumeroCciaa(String val) {

		numeroCciaa = val;

	}
	/**
	 * @generated
	 */
	public String getNumeroCciaa() {

		return numeroCciaa;

	}

	/*	 
	 * @generated
	 */
	private String altraFormaGiuridica;

	/**
	 * @generated
	 */
	public void setAltraFormaGiuridica(String val) {

		altraFormaGiuridica = val;

	}
	/**
	 * @generated
	 */
	public String getAltraFormaGiuridica() {

		return altraFormaGiuridica;

	}

	/*	 
	 * @generated
	 */
	private Integer numeroSalaries;

	/**
	 * @generated
	 */
	public void setNumeroSalaries(Integer val) {

		numeroSalaries = val;

	}
	/**
	 * @generated
	 */
	public Integer getNumeroSalaries() {

		return numeroSalaries;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal tempoIndeterminato;

	/**
	 * @generated
	 */
	public void setTempoIndeterminato(java.math.BigDecimal val) {

		tempoIndeterminato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getTempoIndeterminato() {

		return tempoIndeterminato;

	}

	/*	 
	 * @generated
	 */
	private String pecAzienda;

	/**
	 * @generated
	 */
	public void setPecAzienda(String val) {

		pecAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getPecAzienda() {

		return pecAzienda;

	}

	/*	 
	 * @generated
	 */
	private String mailAzienda;

	/**
	 * @generated
	 */
	public void setMailAzienda(String val) {

		mailAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getMailAzienda() {

		return mailAzienda;

	}

	/*	 
	 * @generated
	 */
	private String sitoWeb;

	/**
	 * @generated
	 */
	public void setSitoWeb(String val) {

		sitoWeb = val;

	}
	/**
	 * @generated
	 */
	public String getSitoWeb() {

		return sitoWeb;

	}

	/*	 
	 * @generated
	 */
	private String sezione;

	/**
	 * @generated
	 */
	public void setSezione(String val) {

		sezione = val;

	}
	/**
	 * @generated
	 */
	public String getSezione() {

		return sezione;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataIscrizioneAlbo;

	/**
	 * @generated
	 */
	public void setDataIscrizioneAlbo(java.sql.Date val) {

		if (val != null) {
			dataIscrizioneAlbo = new java.sql.Date(val.getTime());
		} else {
			dataIscrizioneAlbo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataIscrizioneAlbo() {

		if (dataIscrizioneAlbo != null) {
			return new java.sql.Date(dataIscrizioneAlbo.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String istatComune;

	/**
	 * @generated
	 */
	public void setIstatComune(String val) {

		istatComune = val;

	}
	/**
	 * @generated
	 */
	public String getIstatComune() {

		return istatComune;

	}

	/*	 
	 * @generated
	 */
	private String indirizzo;

	/**
	 * @generated
	 */
	public void setIndirizzo(String val) {

		indirizzo = val;

	}
	/**
	 * @generated
	 */
	public String getIndirizzo() {

		return indirizzo;

	}

	/*	 
	 * @generated
	 */
	private String civico;

	/**
	 * @generated
	 */
	public void setCivico(String val) {

		civico = val;

	}
	/**
	 * @generated
	 */
	public String getCivico() {

		return civico;

	}

	/*	 
	 * @generated
	 */
	private String cap;

	/**
	 * @generated
	 */
	public void setCap(String val) {

		cap = val;

	}
	/**
	 * @generated
	 */
	public String getCap() {

		return cap;

	}

	/*	 
	 * @generated
	 */
	private String telefono;

	/**
	 * @generated
	 */
	public void setTelefono(String val) {

		telefono = val;

	}
	/**
	 * @generated
	 */
	public String getTelefono() {

		return telefono;

	}

	/*	 
	 * @generated
	 */
	private Integer attivitaPrimaria;

	/**
	 * @generated
	 */
	public void setAttivitaPrimaria(Integer val) {

		attivitaPrimaria = val;

	}
	/**
	 * @generated
	 */
	public Integer getAttivitaPrimaria() {

		return attivitaPrimaria;

	}

	/*	 
	 * @generated
	 */
	private Integer attivitaSecondaria;

	/**
	 * @generated
	 */
	public void setAttivitaSecondaria(Integer val) {

		attivitaSecondaria = val;

	}
	/**
	 * @generated
	 */
	public Integer getAttivitaSecondaria() {

		return attivitaSecondaria;

	}

	/*	 
	 * @generated
	 */
	private String numeroBollo;

	/**
	 * @generated
	 */
	public void setNumeroBollo(String val) {

		numeroBollo = val;

	}
	/**
	 * @generated
	 */
	public String getNumeroBollo() {

		return numeroBollo;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal annoInizio;

	/**
	 * @generated
	 */
	public void setAnnoInizio(java.math.BigDecimal val) {

		annoInizio = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAnnoInizio() {

		return annoInizio;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal fatturato;

	/**
	 * @generated
	 */
	public void setFatturato(java.math.BigDecimal val) {

		fatturato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFatturato() {

		return fatturato;

	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 * @generated
	 */
	public boolean equals(Object _other) {
		return super.equals(_other);
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 * @generated
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
