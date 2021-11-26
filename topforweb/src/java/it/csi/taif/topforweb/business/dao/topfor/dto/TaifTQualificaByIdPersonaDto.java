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
public class TaifTQualificaByIdPersonaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idQualifica;

	/**
	 * @generated
	 */
	public void setIdQualifica(Integer val) {

		idQualifica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdQualifica() {

		return idQualifica;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoQualifica;

	/**
	 * @generated
	 */
	public void setIdTipoQualifica(Integer val) {

		idTipoQualifica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoQualifica() {

		return idTipoQualifica;

	}

	/*	 
	 * @generated
	 */
	private String ragioneSociale;

	/**
	 * @generated
	 */
	public void setRagioneSociale(String val) {

		ragioneSociale = val;

	}
	/**
	 * @generated
	 */
	public String getRagioneSociale() {

		return ragioneSociale;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataRilascio;

	/**
	 * @generated
	 */
	public void setDataRilascio(java.sql.Date val) {

		if (val != null) {
			dataRilascio = new java.sql.Date(val.getTime());
		} else {
			dataRilascio = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataRilascio() {

		if (dataRilascio != null) {
			return new java.sql.Date(dataRilascio.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String tipoQualifica;

	/**
	 * @generated
	 */
	public void setTipoQualifica(String val) {

		tipoQualifica = val;

	}
	/**
	 * @generated
	 */
	public String getTipoQualifica() {

		return tipoQualifica;

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
