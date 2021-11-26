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
 * DTO specifico della query modellata nel finder byFilter.
 * @generated
 */
public class TaifTDpiByFilterDto implements Serializable {

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
	private Integer idAzienda;

	/**
	 * @generated
	 */
	public void setIdAzienda(Integer val) {

		idAzienda = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAzienda() {

		return idAzienda;

	}

	/*	 
	 * @generated
	 */
	private String tipo;

	/**
	 * @generated
	 */
	public void setTipo(String val) {

		tipo = val;

	}
	/**
	 * @generated
	 */
	public String getTipo() {

		return tipo;

	}

	/*	 
	 * @generated
	 */
	private Integer quant;

	/**
	 * @generated
	 */
	public void setQuant(Integer val) {

		quant = val;

	}
	/**
	 * @generated
	 */
	public Integer getQuant() {

		return quant;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal scad;

	/**
	 * @generated
	 */
	public void setScad(java.math.BigDecimal val) {

		scad = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getScad() {

		return scad;

	}

	/*	 
	 * @generated
	 */
	private Integer tipDpi;

	/**
	 * @generated
	 */
	public void setTipDpi(Integer val) {

		tipDpi = val;

	}
	/**
	 * @generated
	 */
	public Integer getTipDpi() {

		return tipDpi;

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
