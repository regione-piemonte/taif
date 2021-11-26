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
 * DTO specifico della query modellata nel finder riconoscimentiPerPersona.
 * @generated
 */
public class TaifTPersonaRiconoscimentiPerPersonaDto implements Serializable {

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
	private String siglaUnitaFormativa;

	/**
	 * @generated
	 */
	public void setSiglaUnitaFormativa(String val) {

		siglaUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getSiglaUnitaFormativa() {

		return siglaUnitaFormativa;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataRiconoscimento;

	/**
	 * @generated
	 */
	public void setDataRiconoscimento(java.sql.Date val) {

		if (val != null) {
			dataRiconoscimento = new java.sql.Date(val.getTime());
		} else {
			dataRiconoscimento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataRiconoscimento() {

		if (dataRiconoscimento != null) {
			return new java.sql.Date(dataRiconoscimento.getTime());
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
