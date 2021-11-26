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
public class TaifTRiconoscimentoByIdPersonaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idRiconoscimento;

	/**
	 * @generated
	 */
	public void setIdRiconoscimento(Integer val) {

		idRiconoscimento = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdRiconoscimento() {

		return idRiconoscimento;

	}

	/*	 
	 * @generated
	 */
	private String unitaFormativa;

	/**
	 * @generated
	 */
	public void setUnitaFormativa(String val) {

		unitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getUnitaFormativa() {

		return unitaFormativa;

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
	private String note;

	/**
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}
	/**
	 * @generated
	 */
	public String getNote() {

		return note;

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
