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
 * DTO specifico della query modellata nel finder maxAlboNumberValue.
 * @generated
 */
public class TaifTPraticaMaxAlboNumberValueDto implements Serializable {

	/**	 
	* @generated
	*/
	private Integer maxNumeroAlbo;

	/**
	* @generated
	*/
	public void setMaxNumeroAlbo(Integer val) {

		maxNumeroAlbo = val;

	}
	/**
	* @generated
	*/
	public Integer getMaxNumeroAlbo() {

		return maxNumeroAlbo;

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
