/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dto;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byUnitaFormativaPersona.
 * @generated
 */
public class TaifTAgenziaFormativaByUnitaFormativaPersonaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private String ragioneSociale;

	/**
	 * @generated
	 */
	public void setRagioneSociale(String val) {

		ragioneSociale = val;

	}
	/**
	 * @generated
	 */
	public String getRagioneSociale() {

		return ragioneSociale;

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
	private String istatSede;

	/**
	 * @generated
	 */
	public void setIstatSede(String val) {

		istatSede = val;

	}
	/**
	 * @generated
	 */
	public String getIstatSede() {

		return istatSede;

	}

	/*	 
	 * @generated
	 */
	private String denominazioneBreve;

	/**
	 * @generated
	 */
	public void setDenominazioneBreve(String val) {

		denominazioneBreve = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazioneBreve() {

		return denominazioneBreve;

	}

	/*	 
	 * @generated
	 */
	private String cognomePersona;

	/**
	 * @generated
	 */
	public void setCognomePersona(String val) {

		cognomePersona = val;

	}
	/**
	 * @generated
	 */
	public String getCognomePersona() {

		return cognomePersona;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataNascita;

	/**
	 * @generated
	 */
	public void setDataNascita(java.sql.Date val) {

		if (val != null) {
			dataNascita = new java.sql.Date(val.getTime());
		} else {
			dataNascita = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataNascita() {

		if (dataNascita != null) {
			return new java.sql.Date(dataNascita.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String istatComuneNascita;

	/**
	 * @generated
	 */
	public void setIstatComuneNascita(String val) {

		istatComuneNascita = val;

	}
	/**
	 * @generated
	 */
	public String getIstatComuneNascita() {

		return istatComuneNascita;

	}

	/*	 
	 * @generated
	 */
	private String comuneEsteroNascita;

	/**
	 * @generated
	 */
	public void setComuneEsteroNascita(String val) {

		comuneEsteroNascita = val;

	}
	/**
	 * @generated
	 */
	public String getComuneEsteroNascita() {

		return comuneEsteroNascita;

	}

	/*	 
	 * @generated
	 */
	private String nomePersona;

	/**
	 * @generated
	 */
	public void setNomePersona(String val) {

		nomePersona = val;

	}
	/**
	 * @generated
	 */
	public String getNomePersona() {

		return nomePersona;

	}

	/*	 
	 * @generated
	 */
	private String corso;

	/**
	 * @generated
	 */
	public void setCorso(String val) {

		corso = val;

	}
	/**
	 * @generated
	 */
	public String getCorso() {

		return corso;

	}

	/*	 
	 * @generated
	 */
	private String sigla;

	/**
	 * @generated
	 */
	public void setSigla(String val) {

		sigla = val;

	}
	/**
	 * @generated
	 */
	public String getSigla() {

		return sigla;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataInizioCorso;

	/**
	 * @generated
	 */
	public void setDataInizioCorso(java.sql.Timestamp val) {

		if (val != null) {
			dataInizioCorso = new java.sql.Timestamp(val.getTime());
		} else {
			dataInizioCorso = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInizioCorso() {

		if (dataInizioCorso != null) {
			return new java.sql.Timestamp(dataInizioCorso.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataFineCorso;

	/**
	 * @generated
	 */
	public void setDataFineCorso(java.sql.Timestamp val) {

		if (val != null) {
			dataFineCorso = new java.sql.Timestamp(val.getTime());
		} else {
			dataFineCorso = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataFineCorso() {

		if (dataFineCorso != null) {
			return new java.sql.Timestamp(dataFineCorso.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal numeroOre;

	/**
	 * @generated
	 */
	public void setNumeroOre(java.math.BigDecimal val) {

		numeroOre = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getNumeroOre() {

		return numeroOre;

	}

	/*	 
	 * @generated
	 */
	private String denominazione;

	/**
	 * @generated
	 */
	public void setDenominazione(String val) {

		denominazione = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazione() {

		return denominazione;

	}

	/*	 
	 * @generated
	 */
	private String flagEsito;

	/**
	 * @generated
	 */
	public void setFlagEsito(String val) {

		flagEsito = val;

	}
	/**
	 * @generated
	 */
	public String getFlagEsito() {

		return flagEsito;

	}

	/*	 
	 * @generated
	 */
	private String referente;

	/**
	 * @generated
	 */
	public void setReferente(String val) {

		referente = val;

	}
	/**
	 * @generated
	 */
	public String getReferente() {

		return referente;

	}

	/*	 
	 * @generated
	 */
	private String unitaFormativa;

	/**
	 * @generated
	 */
	public void setUnitaFormativa(String val) {

		unitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getUnitaFormativa() {

		return unitaFormativa;

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
