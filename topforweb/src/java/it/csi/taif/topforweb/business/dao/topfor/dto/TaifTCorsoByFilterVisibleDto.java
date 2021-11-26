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
 * DTO specifico della query modellata nel finder byFilterVisible.
 * @generated
 */
public class TaifTCorsoByFilterVisibleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idCorso;

	/**
	 * @generated
	 */
	public void setIdCorso(Integer val) {

		idCorso = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdCorso() {

		return idCorso;

	}

	/*	 
	 * @generated
	 */
	private String dsCorso;

	/**
	 * @generated
	 */
	public void setDsCorso(String val) {

		dsCorso = val;

	}
	/**
	 * @generated
	 */
	public String getDsCorso() {

		return dsCorso;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flgAltroCorso;

	/**
	 * @generated
	 */
	public void setFlgAltroCorso(java.math.BigDecimal val) {

		flgAltroCorso = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlgAltroCorso() {

		return flgAltroCorso;

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
