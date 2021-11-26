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
public class TaifTCorsoFindByFilterDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal psr;

	/**
	 * @generated
	 */
	public void setPsr(java.math.BigDecimal val) {

		psr = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPsr() {

		return psr;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ordin;

	/**
	 * @generated
	 */
	public void setOrdin(java.math.BigDecimal val) {

		ordin = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getOrdin() {

		return ordin;

	}

	/*	 
	 * @generated
	 */
	private String id;

	/**
	 * @generated
	 */
	public void setId(String val) {

		id = val;

	}
	/**
	 * @generated
	 */
	public String getId() {

		return id;

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
