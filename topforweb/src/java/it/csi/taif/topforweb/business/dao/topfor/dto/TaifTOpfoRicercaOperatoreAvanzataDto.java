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
 * DTO specifico della query modellata nel finder ricercaOperatoreAvanzata.
 * @generated
 */
public class TaifTOpfoRicercaOperatoreAvanzataDto implements Serializable {

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
	private Integer idPersona;

	/**
	 * @generated
	 */
	public void setIdPersona(Integer val) {

		idPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPersona() {

		return idPersona;

	}

	/*	 
	 * @generated
	 */
	private String codiceFiscale;

	/**
	 * @generated
	 */
	public void setCodiceFiscale(String val) {

		codiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getCodiceFiscale() {

		return codiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private String nRsiMsa;

	/**
	 * @generated
	 */
	public void setNRsiMsa(String val) {

		nRsiMsa = val;

	}
	/**
	 * @generated
	 */
	public String getNRsiMsa() {

		return nRsiMsa;

	}

	/*	 
	 * @generated
	 */
	private String cognomeOperatore;

	/**
	 * @generated
	 */
	public void setCognomeOperatore(String val) {

		cognomeOperatore = val;

	}
	/**
	 * @generated
	 */
	public String getCognomeOperatore() {

		return cognomeOperatore;

	}

	/*	 
	 * @generated
	 */
	private String nomeOperatore;

	/**
	 * @generated
	 */
	public void setNomeOperatore(String val) {

		nomeOperatore = val;

	}
	/**
	 * @generated
	 */
	public String getNomeOperatore() {

		return nomeOperatore;

	}

	/*	 
	 * @generated
	 */
	private String elencoCorso;

	/**
	 * @generated
	 */
	public void setElencoCorso(String val) {

		elencoCorso = val;

	}
	/**
	 * @generated
	 */
	public String getElencoCorso() {

		return elencoCorso;

	}

	/*	 
	 * @generated
	 */
	private String urlPrivacy;

	/**
	 * @generated
	 */
	public void setUrlPrivacy(String val) {

		urlPrivacy = val;

	}
	/**
	 * @generated
	 */
	public String getUrlPrivacy() {

		return urlPrivacy;

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
