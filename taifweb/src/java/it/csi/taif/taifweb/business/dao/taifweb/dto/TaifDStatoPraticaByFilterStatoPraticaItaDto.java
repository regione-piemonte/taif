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
 * DTO specifico della query modellata nel finder byFilterStatoPraticaIta.
 * @generated
 */
public class TaifDStatoPraticaByFilterStatoPraticaItaDto implements Serializable {

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
	private Integer idPadre;

	/**
	 * @generated
	 */
	public void setIdPadre(Integer val) {

		idPadre = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPadre() {

		return idPadre;

	}

	/*	 
	 * @generated
	 */
	private String ita;

	/**
	 * @generated
	 */
	public void setIta(String val) {

		ita = val;

	}
	/**
	 * @generated
	 */
	public String getIta() {

		return ita;

	}

	/*	 
	 * @generated
	 */
	private String fra;

	/**
	 * @generated
	 */
	public void setFra(String val) {

		fra = val;

	}
	/**
	 * @generated
	 */
	public String getFra() {

		return fra;

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
