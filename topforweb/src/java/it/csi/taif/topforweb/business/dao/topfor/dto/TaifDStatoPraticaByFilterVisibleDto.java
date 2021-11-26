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
public class TaifDStatoPraticaByFilterVisibleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idStatoPratica;

	/**
	 * @generated
	 */
	public void setIdStatoPratica(Integer val) {

		idStatoPratica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdStatoPratica() {

		return idStatoPratica;

	}

	/*	 
	 * @generated
	 */
	private String statoPraticaIta;

	/**
	 * @generated
	 */
	public void setStatoPraticaIta(String val) {

		statoPraticaIta = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPraticaIta() {

		return statoPraticaIta;

	}

	/*	 
	 * @generated
	 */
	private String statoPraticaFra;

	/**
	 * @generated
	 */
	public void setStatoPraticaFra(String val) {

		statoPraticaFra = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPraticaFra() {

		return statoPraticaFra;

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
