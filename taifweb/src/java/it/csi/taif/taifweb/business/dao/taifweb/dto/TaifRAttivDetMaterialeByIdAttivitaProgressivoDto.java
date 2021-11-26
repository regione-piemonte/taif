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
 * DTO specifico della query modellata nel finder byIdAttivitaProgressivo.
 * @generated
 */
public class TaifRAttivDetMaterialeByIdAttivitaProgressivoDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idMateriale;

	/**
	 * @generated
	 */
	public void setIdMateriale(Integer val) {

		idMateriale = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdMateriale() {

		return idMateriale;

	}

	/*	 
	 * @generated
	 */
	private Integer progressivo;

	/**
	 * @generated
	 */
	public void setProgressivo(Integer val) {

		progressivo = val;

	}
	/**
	 * @generated
	 */
	public Integer getProgressivo() {

		return progressivo;

	}

	/*	 
	 * @generated
	 */
	private Integer idAttivita;

	/**
	 * @generated
	 */
	public void setIdAttivita(Integer val) {

		idAttivita = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAttivita() {

		return idAttivita;

	}

	/*	 
	 * @generated
	 */
	private String descrizioneAltroMateriale;

	/**
	 * @generated
	 */
	public void setDescrizioneAltroMateriale(String val) {

		descrizioneAltroMateriale = val;

	}
	/**
	 * @generated
	 */
	public String getDescrizioneAltroMateriale() {

		return descrizioneAltroMateriale;

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
