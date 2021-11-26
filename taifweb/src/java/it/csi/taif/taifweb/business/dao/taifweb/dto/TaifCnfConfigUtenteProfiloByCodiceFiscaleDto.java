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
 * DTO specifico della query modellata nel finder profiloByCodiceFiscale.
 * @generated
 */
public class TaifCnfConfigUtenteProfiloByCodiceFiscaleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer puIdProfiloUtente;

	/**
	 * @generated
	 */
	public void setPuIdProfiloUtente(Integer val) {

		puIdProfiloUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getPuIdProfiloUtente() {

		return puIdProfiloUtente;

	}

	/*	 
	 * @generated
	 */
	private String puProfiloUtente;

	/**
	 * @generated
	 */
	public void setPuProfiloUtente(String val) {

		puProfiloUtente = val;

	}
	/**
	 * @generated
	 */
	public String getPuProfiloUtente() {

		return puProfiloUtente;

	}

	/*	 
	 * @generated
	 */
	private Integer cuFkSoggettoGestore;

	/**
	 * @generated
	 */
	public void setCuFkSoggettoGestore(Integer val) {

		cuFkSoggettoGestore = val;

	}
	/**
	 * @generated
	 */
	public Integer getCuFkSoggettoGestore() {

		return cuFkSoggettoGestore;

	}

	/*	 
	 * @generated
	 */
	private Integer cuIdConfigUtente;

	/**
	 * @generated
	 */
	public void setCuIdConfigUtente(Integer val) {

		cuIdConfigUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getCuIdConfigUtente() {

		return cuIdConfigUtente;

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
