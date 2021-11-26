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
public class TaifTCorsoByFilterDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal psr;

	/**
	 * @generated
	 */
	public void setPsr(java.math.BigDecimal val) {

		psr = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPsr() {

		return psr;

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
	private String id;

	/**
	 * @generated
	 */
	public void setId(String val) {

		id = val;

	}
	/**
	 * @generated
	 */
	public String getId() {

		return id;

	}

	/*	 
	 * @generated
	 */
	private String corso;

	/**
	 * @generated
	 */
	public void setCorso(String val) {

		corso = val;

	}
	/**
	 * @generated
	 */
	public String getCorso() {

		return corso;

	}

	/*	 
	 * @generated
	 */
	private Integer corsiFkUnitaFormativa;

	/**
	 * @generated
	 */
	public void setCorsiFkUnitaFormativa(Integer val) {

		corsiFkUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public Integer getCorsiFkUnitaFormativa() {

		return corsiFkUnitaFormativa;

	}

	/*	 
	 * @generated
	 */
	private String uUnitaFormativa;

	/**
	 * @generated
	 */
	public void setUUnitaFormativa(String val) {

		uUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getUUnitaFormativa() {

		return uUnitaFormativa;

	}

	/*	 
	 * @generated
	 */
	private String uSigla;

	/**
	 * @generated
	 */
	public void setUSigla(String val) {

		uSigla = val;

	}
	/**
	 * @generated
	 */
	public String getUSigla() {

		return uSigla;

	}

	/*	 
	 * @generated
	 */
	private Integer idCorso;

	/**
	 * @generated
	 */
	public void setIdCorso(Integer val) {

		idCorso = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdCorso() {

		return idCorso;

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
