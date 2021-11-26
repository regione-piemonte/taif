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
 * DTO specifico della query modellata nel finder byCodiceAttivita.
 * @generated
 */
public class TaifDAttivitaAtecoApeByCodiceAttivitaDto implements Serializable {

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
	private String codice;

	/**
	 * @generated
	 */
	public void setCodice(String val) {

		codice = val;

	}
	/**
	 * @generated
	 */
	public String getCodice() {

		return codice;

	}

	/*	 
	 * @generated
	 */
	private String attivita;

	/**
	 * @generated
	 */
	public void setAttivita(String val) {

		attivita = val;

	}
	/**
	 * @generated
	 */
	public String getAttivita() {

		return attivita;

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
