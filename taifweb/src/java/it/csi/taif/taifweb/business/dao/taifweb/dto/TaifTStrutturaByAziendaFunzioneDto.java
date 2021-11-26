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
 * DTO specifico della query modellata nel finder byAziendaFunzione.
 * @generated
 */
public class TaifTStrutturaByAziendaFunzioneDto implements Serializable {

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
	private Integer funz;

	/**
	 * @generated
	 */
	public void setFunz(Integer val) {

		funz = val;

	}
	/**
	 * @generated
	 */
	public Integer getFunz() {

		return funz;

	}

	/*	 
	 * @generated
	 */
	private Integer dim;

	/**
	 * @generated
	 */
	public void setDim(Integer val) {

		dim = val;

	}
	/**
	 * @generated
	 */
	public Integer getDim() {

		return dim;

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

	/*	 
	 * @generated
	 */
	private Integer azienda;

	/**
	 * @generated
	 */
	public void setAzienda(Integer val) {

		azienda = val;

	}
	/**
	 * @generated
	 */
	public Integer getAzienda() {

		return azienda;

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
