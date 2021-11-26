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
 * DTO specifico della query modellata nel finder byIdPersona.
 * @generated
 */
public class TaifROpfoCorsoByIdPersonaDto implements Serializable {

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
	private Integer idPersona;

	/**
	 * @generated
	 */
	public void setIdPersona(Integer val) {

		idPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPersona() {

		return idPersona;

	}

	/*	 
	 * @generated
	 */
	private String descrizioneAltroCorso;

	/**
	 * @generated
	 */
	public void setDescrizioneAltroCorso(String val) {

		descrizioneAltroCorso = val;

	}
	/**
	 * @generated
	 */
	public String getDescrizioneAltroCorso() {

		return descrizioneAltroCorso;

	}

	/*	 
	 * @generated
	 */
	private String flagEsito;

	/**
	 * @generated
	 */
	public void setFlagEsito(String val) {

		flagEsito = val;

	}
	/**
	 * @generated
	 */
	public String getFlagEsito() {

		return flagEsito;

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
