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
 * DTO specifico della query modellata nel finder byIdMateriale.
 * @generated
 */
public class TaifRAttivDetMaterialeByIdMaterialeDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idMatt;

	/**
	 * @generated
	 */
	public void setIdMatt(Integer val) {

		idMatt = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdMatt() {

		return idMatt;

	}

	/*	 
	 * @generated
	 */
	private String materiale;

	/**
	 * @generated
	 */
	public void setMateriale(String val) {

		materiale = val;

	}
	/**
	 * @generated
	 */
	public String getMateriale() {

		return materiale;

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
