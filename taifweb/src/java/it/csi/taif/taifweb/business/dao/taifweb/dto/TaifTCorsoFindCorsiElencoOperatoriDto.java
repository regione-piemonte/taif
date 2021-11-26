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
 * DTO specifico della query modellata nel finder findCorsiElencoOperatori.
 * @generated
 */
public class TaifTCorsoFindCorsiElencoOperatoriDto implements Serializable {

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

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ordinCorso;

	/**
	 * @generated
	 */
	public void setOrdinCorso(java.math.BigDecimal val) {

		ordinCorso = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getOrdinCorso() {

		return ordinCorso;

	}

	/*	 
	 * @generated
	 */
	private String istatSedeCorsi;

	/**
	 * @generated
	 */
	public void setIstatSedeCorsi(String val) {

		istatSedeCorsi = val;

	}
	/**
	 * @generated
	 */
	public String getIstatSedeCorsi() {

		return istatSedeCorsi;

	}

	/*	 
	 * @generated
	 */
	private String nomeCorso;

	/**
	 * @generated
	 */
	public void setNomeCorso(String val) {

		nomeCorso = val;

	}
	/**
	 * @generated
	 */
	public String getNomeCorso() {

		return nomeCorso;

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
