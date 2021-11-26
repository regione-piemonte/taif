/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder findByAgenziaFormativa.
 * @generated
 */
public class TaifTQualificaFindByAgenziaFormativaDto implements Serializable {

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
	private Integer idTipoQual;

	/**
	 * @generated
	 */
	public void setIdTipoQual(Integer val) {

		idTipoQual = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoQual() {

		return idTipoQual;

	}

	/*	 
	 * @generated
	 */
	private Integer agForm;

	/**
	 * @generated
	 */
	public void setAgForm(Integer val) {

		agForm = val;

	}
	/**
	 * @generated
	 */
	public Integer getAgForm() {

		return agForm;

	}

	/*	 
	 * @generated
	 */
	private Integer pers;

	/**
	 * @generated
	 */
	public void setPers(Integer val) {

		pers = val;

	}
	/**
	 * @generated
	 */
	public Integer getPers() {

		return pers;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date ril;

	/**
	 * @generated
	 */
	public void setRil(java.sql.Date val) {

		if (val != null) {
			ril = new java.sql.Date(val.getTime());
		} else {
			ril = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getRil() {

		if (ril != null) {
			return new java.sql.Date(ril.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp inser;

	/**
	 * @generated
	 */
	public void setInser(java.sql.Timestamp val) {

		if (val != null) {
			inser = new java.sql.Timestamp(val.getTime());
		} else {
			inser = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getInser() {

		if (inser != null) {
			return new java.sql.Timestamp(inser.getTime());
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
