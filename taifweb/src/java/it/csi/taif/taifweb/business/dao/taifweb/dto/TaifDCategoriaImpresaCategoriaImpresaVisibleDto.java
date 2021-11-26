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
 * DTO specifico della query modellata nel finder categoriaImpresaVisible.
 * @generated
 */
public class TaifDCategoriaImpresaCategoriaImpresaVisibleDto implements Serializable {

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
	private String categoria;

	/**
	 * @generated
	 */
	public void setCategoria(String val) {

		categoria = val;

	}
	/**
	 * @generated
	 */
	public String getCategoria() {

		return categoria;

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
	private java.math.BigDecimal flagVis;

	/**
	 * @generated
	 */
	public void setFlagVis(java.math.BigDecimal val) {

		flagVis = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagVis() {

		return flagVis;

	}

	/*	 
	 * @generated
	 */
	private String flagIta;

	/**
	 * @generated
	 */
	public void setFlagIta(String val) {

		flagIta = val;

	}
	/**
	 * @generated
	 */
	public String getFlagIta() {

		return flagIta;

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
