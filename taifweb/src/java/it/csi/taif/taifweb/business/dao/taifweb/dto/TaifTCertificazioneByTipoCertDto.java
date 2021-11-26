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
 * DTO specifico della query modellata nel finder byTipoCert.
 * @generated
 */
public class TaifTCertificazioneByTipoCertDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer id;

	/**
	 * @generated
	 */
	public void setId(Integer val) {

		id = val;

	}
	/**
	 * @generated
	 */
	public Integer getId() {

		return id;

	}

	/*	 
	 * @generated
	 */
	private Integer tipoCertificazione;

	/**
	 * @generated
	 */
	public void setTipoCertificazione(Integer val) {

		tipoCertificazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getTipoCertificazione() {

		return tipoCertificazione;

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
	private java.sql.Timestamp data;

	/**
	 * @generated
	 */
	public void setData(java.sql.Timestamp val) {

		if (val != null) {
			data = new java.sql.Timestamp(val.getTime());
		} else {
			data = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getData() {

		if (data != null) {
			return new java.sql.Timestamp(data.getTime());
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
