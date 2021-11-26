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
 * DTO specifico della query modellata nel finder operatoriCorsiPerPersona.
 * @generated
 */
public class TaifTPersonaOperatoriCorsiPerPersonaDto implements Serializable {

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
	private String corso;

	/**
	 * @generated
	 */
	public void setCorso(String val) {

		corso = val;

	}
	/**
	 * @generated
	 */
	public String getCorso() {

		return corso;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataInizioCorso;

	/**
	 * @generated
	 */
	public void setDataInizioCorso(java.sql.Timestamp val) {

		if (val != null) {
			dataInizioCorso = new java.sql.Timestamp(val.getTime());
		} else {
			dataInizioCorso = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInizioCorso() {

		if (dataInizioCorso != null) {
			return new java.sql.Timestamp(dataInizioCorso.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataFineCorso;

	/**
	 * @generated
	 */
	public void setDataFineCorso(java.sql.Timestamp val) {

		if (val != null) {
			dataFineCorso = new java.sql.Timestamp(val.getTime());
		} else {
			dataFineCorso = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataFineCorso() {

		if (dataFineCorso != null) {
			return new java.sql.Timestamp(dataFineCorso.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal numeroOreCorso;

	/**
	 * @generated
	 */
	public void setNumeroOreCorso(java.math.BigDecimal val) {

		numeroOreCorso = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getNumeroOreCorso() {

		return numeroOreCorso;

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
	private String altroDescrizione;

	/**
	 * @generated
	 */
	public void setAltroDescrizione(String val) {

		altroDescrizione = val;

	}
	/**
	 * @generated
	 */
	public String getAltroDescrizione() {

		return altroDescrizione;

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
