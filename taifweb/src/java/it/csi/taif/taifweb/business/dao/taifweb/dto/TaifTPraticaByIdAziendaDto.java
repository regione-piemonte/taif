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
 * DTO specifico della query modellata nel finder byIdAzienda.
 * @generated
 */
public class TaifTPraticaByIdAziendaDto implements Serializable {

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
	private String nrAlbo;

	/**
	 * @generated
	 */
	public void setNrAlbo(String val) {

		nrAlbo = val;

	}
	/**
	 * @generated
	 */
	public String getNrAlbo() {

		return nrAlbo;

	}

	/*	 
	 * @generated
	 */
	private String denominazioneAltroAlbo;

	/**
	 * @generated
	 */
	public void setDenominazioneAltroAlbo(String val) {

		denominazioneAltroAlbo = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazioneAltroAlbo() {

		return denominazioneAltroAlbo;

	}

	/*	 
	 * @generated
	 */
	private Integer idSoggettoGestore;

	/**
	 * @generated
	 */
	public void setIdSoggettoGestore(Integer val) {

		idSoggettoGestore = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdSoggettoGestore() {

		return idSoggettoGestore;

	}

	/*	 
	 * @generated
	 */
	private String flagSezione;

	/**
	 * @generated
	 */
	public void setFlagSezione(String val) {

		flagSezione = val;

	}
	/**
	 * @generated
	 */
	public String getFlagSezione() {

		return flagSezione;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataInscrizioneAlbo;

	/**
	 * @generated
	 */
	public void setDataInscrizioneAlbo(java.sql.Date val) {

		if (val != null) {
			dataInscrizioneAlbo = new java.sql.Date(val.getTime());
		} else {
			dataInscrizioneAlbo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataInscrizioneAlbo() {

		if (dataInscrizioneAlbo != null) {
			return new java.sql.Date(dataInscrizioneAlbo.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer fkConfigUtente;

	/**
	 * @generated
	 */
	public void setFkConfigUtente(Integer val) {

		fkConfigUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getFkConfigUtente() {

		return fkConfigUtente;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataPresentazione;

	/**
	 * @generated
	 */
	public void setDataPresentazione(java.sql.Date val) {

		if (val != null) {
			dataPresentazione = new java.sql.Date(val.getTime());
		} else {
			dataPresentazione = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataPresentazione() {

		if (dataPresentazione != null) {
			return new java.sql.Date(dataPresentazione.getTime());
		} else {
			return null;
		}

	}

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
