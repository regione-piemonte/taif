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
 * DTO specifico della query modellata nel finder elencoCertificazioni.
 * @generated
 */
public class TaifTCertificazioneElencoCertificazioniDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idCertificazione;

	/**
	 * @generated
	 */
	public void setIdCertificazione(Integer val) {

		idCertificazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdCertificazione() {

		return idCertificazione;

	}

	/*	 
	 * @generated
	 */
	private Integer fkTipoCertificazione;

	/**
	 * @generated
	 */
	public void setFkTipoCertificazione(Integer val) {

		fkTipoCertificazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getFkTipoCertificazione() {

		return fkTipoCertificazione;

	}

	/*	 
	 * @generated
	 */
	private String numero;

	/**
	 * @generated
	 */
	public void setNumero(String val) {

		numero = val;

	}
	/**
	 * @generated
	 */
	public String getNumero() {

		return numero;

	}

	/*	 
	 * @generated
	 */
	private String enteCertificatore;

	/**
	 * @generated
	 */
	public void setEnteCertificatore(String val) {

		enteCertificatore = val;

	}
	/**
	 * @generated
	 */
	public String getEnteCertificatore() {

		return enteCertificatore;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal anno;

	/**
	 * @generated
	 */
	public void setAnno(java.math.BigDecimal val) {

		anno = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAnno() {

		return anno;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimento() {

		if (dataInserimento != null) {
			return new java.sql.Timestamp(dataInserimento.getTime());
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
	private java.sql.Timestamp dataScadenza;

	/**
	 * @generated
	 */
	public void setDataScadenza(java.sql.Timestamp val) {

		if (val != null) {
			dataScadenza = new java.sql.Timestamp(val.getTime());
		} else {
			dataScadenza = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataScadenza() {

		if (dataScadenza != null) {
			return new java.sql.Timestamp(dataScadenza.getTime());
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
	private String descrizioneAltro;

	/**
	 * @generated
	 */
	public void setDescrizioneAltro(String val) {

		descrizioneAltro = val;

	}
	/**
	 * @generated
	 */
	public String getDescrizioneAltro() {

		return descrizioneAltro;

	}

	/*	 
	 * @generated
	 */
	private String tipoCertificazione;

	/**
	 * @generated
	 */
	public void setTipoCertificazione(String val) {

		tipoCertificazione = val;

	}
	/**
	 * @generated
	 */
	public String getTipoCertificazione() {

		return tipoCertificazione;

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
