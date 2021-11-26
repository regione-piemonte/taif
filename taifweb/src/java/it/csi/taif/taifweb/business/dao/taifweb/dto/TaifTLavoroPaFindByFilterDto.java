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
public class TaifTLavoroPaFindByFilterDto implements Serializable {

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
	private String commit;

	/**
	 * @generated
	 */
	public void setCommit(String val) {

		commit = val;

	}
	/**
	 * @generated
	 */
	public String getCommit() {

		return commit;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal importo;

	/**
	 * @generated
	 */
	public void setImporto(java.math.BigDecimal val) {

		importo = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getImporto() {

		return importo;

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
