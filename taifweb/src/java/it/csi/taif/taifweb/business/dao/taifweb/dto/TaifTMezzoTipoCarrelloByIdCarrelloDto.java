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
 * DTO specifico della query modellata nel finder tipoCarrelloByIdCarrello.
 * @generated
 */
public class TaifTMezzoTipoCarrelloByIdCarrelloDto implements Serializable {

	/*	 
	 * @generated
	 */
	private String tipoMezzo;

	/**
	 * @generated
	 */
	public void setTipoMezzo(String val) {

		tipoMezzo = val;

	}
	/**
	 * @generated
	 */
	public String getTipoMezzo() {

		return tipoMezzo;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoTrazione;

	/**
	 * @generated
	 */
	public void setIdTipoTrazione(Integer val) {

		idTipoTrazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoTrazione() {

		return idTipoTrazione;

	}

	/*	 
	 * @generated
	 */
	private Integer idMezzo;

	/**
	 * @generated
	 */
	public void setIdMezzo(Integer val) {

		idMezzo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdMezzo() {

		return idMezzo;

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
