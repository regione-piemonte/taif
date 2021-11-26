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
 * DTO specifico della query modellata nel finder byFilter.
 * @generated
 */
public class TaifTSoggettoGestoreByFilterDto implements Serializable {

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
	private String codiceGestore;

	/**
	 * @generated
	 */
	public void setCodiceGestore(String val) {

		codiceGestore = val;

	}
	/**
	 * @generated
	 */
	public String getCodiceGestore() {

		return codiceGestore;

	}

	/*	 
	 * @generated
	 */
	private String denominazionebreve;

	/**
	 * @generated
	 */
	public void setDenominazionebreve(String val) {

		denominazionebreve = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazionebreve() {

		return denominazionebreve;

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
