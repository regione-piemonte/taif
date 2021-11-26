/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder findByFilter.
 * @generated
 */
public class TaifTRiconoscimentoFindByFilterDto implements Serializable {

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
	private Integer idUnForm;

	/**
	 * @generated
	 */
	public void setIdUnForm(Integer val) {

		idUnForm = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdUnForm() {

		return idUnForm;

	}

	/*	 
	 * @generated
	 */
	private Integer idAgForm;

	/**
	 * @generated
	 */
	public void setIdAgForm(Integer val) {

		idAgForm = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAgForm() {

		return idAgForm;

	}

	/*	 
	 * @generated
	 */
	private Integer idPers;

	/**
	 * @generated
	 */
	public void setIdPers(Integer val) {

		idPers = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPers() {

		return idPers;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date data;

	/**
	 * @generated
	 */
	public void setData(java.sql.Date val) {

		if (val != null) {
			data = new java.sql.Date(val.getTime());
		} else {
			data = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getData() {

		if (data != null) {
			return new java.sql.Date(data.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String note;

	/**
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}
	/**
	 * @generated
	 */
	public String getNote() {

		return note;

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
