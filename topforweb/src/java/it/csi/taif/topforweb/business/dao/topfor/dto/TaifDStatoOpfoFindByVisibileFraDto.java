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
 * DTO specifico della query modellata nel finder findByVisibileFra.
 * @generated
 */
public class TaifDStatoOpfoFindByVisibileFraDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idStatoOperatore;

	/**
	 * @generated
	 */
	public void setIdStatoOperatore(Integer val) {

		idStatoOperatore = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdStatoOperatore() {

		return idStatoOperatore;

	}

	/*	 
	 * @generated
	 */
	private String statoOperatoreFra;

	/**
	 * @generated
	 */
	public void setStatoOperatoreFra(String val) {

		statoOperatoreFra = val;

	}
	/**
	 * @generated
	 */
	public String getStatoOperatoreFra() {

		return statoOperatoreFra;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idOrdin;

	/**
	 * @generated
	 */
	public void setIdOrdin(java.math.BigDecimal val) {

		idOrdin = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdOrdin() {

		return idOrdin;

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
