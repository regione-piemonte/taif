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
 * DTO specifico della query modellata nel finder byIdTipoMezzo.
 * @generated
 */
public class TaifDCategoriaMezzoByIdTipoMezzoDto implements Serializable {

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
	private String cat;

	/**
	 * @generated
	 */
	public void setCat(String val) {

		cat = val;

	}
	/**
	 * @generated
	 */
	public String getCat() {

		return cat;

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
	private Integer idCategoriaMezzo;

	/**
	 * @generated
	 */
	public void setIdCategoriaMezzo(Integer val) {

		idCategoriaMezzo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdCategoriaMezzo() {

		return idCategoriaMezzo;

	}

	/*	 
	 * @generated
	 */
	private String tipoMezzo;

	/**
	 * @generated
	 */
	public void setTipoMezzo(String val) {

		tipoMezzo = val;

	}
	/**
	 * @generated
	 */
	public String getTipoMezzo() {

		return tipoMezzo;

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
