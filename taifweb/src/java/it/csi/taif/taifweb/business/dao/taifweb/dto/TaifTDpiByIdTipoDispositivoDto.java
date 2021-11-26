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
 * DTO specifico della query modellata nel finder byIdTipoDispositivo.
 * @generated
 */
public class TaifTDpiByIdTipoDispositivoDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idDpi;

	/**
	 * @generated
	 */
	public void setIdDpi(Integer val) {

		idDpi = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdDpi() {

		return idDpi;

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
	private String tipologia;

	/**
	 * @generated
	 */
	public void setTipologia(String val) {

		tipologia = val;

	}
	/**
	 * @generated
	 */
	public String getTipologia() {

		return tipologia;

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
	private Integer idTipoDpi;

	/**
	 * @generated
	 */
	public void setIdTipoDpi(Integer val) {

		idTipoDpi = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoDpi() {

		return idTipoDpi;

	}

	/*	 
	 * @generated
	 */
	private String tipoDpi;

	/**
	 * @generated
	 */
	public void setTipoDpi(String val) {

		tipoDpi = val;

	}
	/**
	 * @generated
	 */
	public String getTipoDpi() {

		return tipoDpi;

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
