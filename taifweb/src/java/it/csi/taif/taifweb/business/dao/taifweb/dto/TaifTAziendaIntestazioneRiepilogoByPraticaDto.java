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
 * DTO specifico della query modellata nel finder intestazioneRiepilogoByPratica.
 * @generated
 */
public class TaifTAziendaIntestazioneRiepilogoByPraticaDto implements Serializable {

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
	private String ragioneSocialeAzienda;

	/**
	 * @generated
	 */
	public void setRagioneSocialeAzienda(String val) {

		ragioneSocialeAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getRagioneSocialeAzienda() {

		return ragioneSocialeAzienda;

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
	private String nSiret;

	/**
	 * @generated
	 */
	public void setNSiret(String val) {

		nSiret = val;

	}
	/**
	 * @generated
	 */
	public String getNSiret() {

		return nSiret;

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
	private String statoPraticaItalia;

	/**
	 * @generated
	 */
	public void setStatoPraticaItalia(String val) {

		statoPraticaItalia = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPraticaItalia() {

		return statoPraticaItalia;

	}

	/*	 
	 * @generated
	 */
	private String statoPraticaFrance;

	/**
	 * @generated
	 */
	public void setStatoPraticaFrance(String val) {

		statoPraticaFrance = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPraticaFrance() {

		return statoPraticaFrance;

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
	private java.sql.Timestamp dataAggiornamentoPratica;

	/**
	 * @generated
	 */
	public void setDataAggiornamentoPratica(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamentoPratica = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamentoPratica = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamentoPratica() {

		if (dataAggiornamentoPratica != null) {
			return new java.sql.Timestamp(dataAggiornamentoPratica.getTime());
		} else {
			return null;
		}

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
	private Integer idStatoPratica;

	/**
	 * @generated
	 */
	public void setIdStatoPratica(Integer val) {

		idStatoPratica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdStatoPratica() {

		return idStatoPratica;

	}

	/*	 
	 * @generated
	 */
	private String operatoreCognome;

	/**
	 * @generated
	 */
	public void setOperatoreCognome(String val) {

		operatoreCognome = val;

	}
	/**
	 * @generated
	 */
	public String getOperatoreCognome() {

		return operatoreCognome;

	}

	/*	 
	 * @generated
	 */
	private String operatoreNome;

	/**
	 * @generated
	 */
	public void setOperatoreNome(String val) {

		operatoreNome = val;

	}
	/**
	 * @generated
	 */
	public String getOperatoreNome() {

		return operatoreNome;

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
	private String numeroIscrizioneAlbo;

	/**
	 * @generated
	 */
	public void setNumeroIscrizioneAlbo(String val) {

		numeroIscrizioneAlbo = val;

	}
	/**
	 * @generated
	 */
	public String getNumeroIscrizioneAlbo() {

		return numeroIscrizioneAlbo;

	}

	/*	 
	 * @generated
	 */
	private String numeroProtocollo;

	/**
	 * @generated
	 */
	public void setNumeroProtocollo(String val) {

		numeroProtocollo = val;

	}
	/**
	 * @generated
	 */
	public String getNumeroProtocollo() {

		return numeroProtocollo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataProtocollo;

	/**
	 * @generated
	 */
	public void setDataProtocollo(java.sql.Date val) {

		if (val != null) {
			dataProtocollo = new java.sql.Date(val.getTime());
		} else {
			dataProtocollo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataProtocollo() {

		if (dataProtocollo != null) {
			return new java.sql.Date(dataProtocollo.getTime());
		} else {
			return null;
		}

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
