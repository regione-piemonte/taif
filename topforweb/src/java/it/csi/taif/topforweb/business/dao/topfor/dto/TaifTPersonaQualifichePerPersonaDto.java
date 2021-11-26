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
 * DTO specifico della query modellata nel finder qualifichePerPersona.
 * @generated
 */
public class TaifTPersonaQualifichePerPersonaDto implements Serializable {

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
	private String codiceFiscalePersona;

	/**
	 * @generated
	 */
	public void setCodiceFiscalePersona(String val) {

		codiceFiscalePersona = val;

	}
	/**
	 * @generated
	 */
	public String getCodiceFiscalePersona() {

		return codiceFiscalePersona;

	}

	/*	 
	 * @generated
	 */
	private String nRsiMsa;

	/**
	 * @generated
	 */
	public void setNRsiMsa(String val) {

		nRsiMsa = val;

	}
	/**
	 * @generated
	 */
	public String getNRsiMsa() {

		return nRsiMsa;

	}

	/*	 
	 * @generated
	 */
	private String cognomePersona;

	/**
	 * @generated
	 */
	public void setCognomePersona(String val) {

		cognomePersona = val;

	}
	/**
	 * @generated
	 */
	public String getCognomePersona() {

		return cognomePersona;

	}

	/*	 
	 * @generated
	 */
	private String nomePersona;

	/**
	 * @generated
	 */
	public void setNomePersona(String val) {

		nomePersona = val;

	}
	/**
	 * @generated
	 */
	public String getNomePersona() {

		return nomePersona;

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
	private String ragioneSocialeAgenzia;

	/**
	 * @generated
	 */
	public void setRagioneSocialeAgenzia(String val) {

		ragioneSocialeAgenzia = val;

	}
	/**
	 * @generated
	 */
	public String getRagioneSocialeAgenzia() {

		return ragioneSocialeAgenzia;

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
