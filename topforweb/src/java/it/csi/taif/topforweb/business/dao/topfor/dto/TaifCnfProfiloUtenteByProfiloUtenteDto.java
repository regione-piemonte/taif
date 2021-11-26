/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dto;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byProfiloUtente.
 * @generated
 */
public class TaifCnfProfiloUtenteByProfiloUtenteDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idProfilo;

	/**
	 * @generated
	 */
	public void setIdProfilo(Integer val) {

		idProfilo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdProfilo() {

		return idProfilo;

	}

	/*	 
	 * @generated
	 */
	private String profiloUtente;

	/**
	 * @generated
	 */
	public void setProfiloUtente(String val) {

		profiloUtente = val;

	}
	/**
	 * @generated
	 */
	public String getProfiloUtente() {

		return profiloUtente;

	}

	/*	 
	 * @generated
	 */
	private Integer idProcedura;

	/**
	 * @generated
	 */
	public void setIdProcedura(Integer val) {

		idProcedura = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdProcedura() {

		return idProcedura;

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
