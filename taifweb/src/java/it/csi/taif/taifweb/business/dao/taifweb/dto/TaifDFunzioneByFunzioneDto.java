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
 * DTO specifico della query modellata nel finder byFunzione.
 * @generated
 */
public class TaifDFunzioneByFunzioneDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idFunzione;

	/**
	 * @generated
	 */
	public void setIdFunzione(Integer val) {

		idFunzione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdFunzione() {

		return idFunzione;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoStruttura;

	/**
	 * @generated
	 */
	public void setIdTipoStruttura(Integer val) {

		idTipoStruttura = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoStruttura() {

		return idTipoStruttura;

	}

	/*	 
	 * @generated
	 */
	private String funz;

	/**
	 * @generated
	 */
	public void setFunz(String val) {

		funz = val;

	}
	/**
	 * @generated
	 */
	public String getFunz() {

		return funz;

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
