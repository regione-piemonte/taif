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
 * DTO specifico della query modellata nel finder byidRuolo.
 * @generated
 */
public class TaifDRuoloByidRuoloDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idRuolo;

	/**
	 * @generated
	 */
	public void setIdRuolo(Integer val) {

		idRuolo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdRuolo() {

		return idRuolo;

	}

	/*	 
	 * @generated
	 */
	private String ruoloPersona;

	/**
	 * @generated
	 */
	public void setRuoloPersona(String val) {

		ruoloPersona = val;

	}
	/**
	 * @generated
	 */
	public String getRuoloPersona() {

		return ruoloPersona;

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
