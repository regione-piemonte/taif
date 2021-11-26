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
 * DTO specifico della query modellata nel finder contrattoByIdContrattoVisibile.
 * @generated
 */
public class TaifRPersonaAziendaContrattoByIdContrattoVisibileDto implements Serializable {

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
	private Integer idInquad;

	/**
	 * @generated
	 */
	public void setIdInquad(Integer val) {

		idInquad = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdInquad() {

		return idInquad;

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
