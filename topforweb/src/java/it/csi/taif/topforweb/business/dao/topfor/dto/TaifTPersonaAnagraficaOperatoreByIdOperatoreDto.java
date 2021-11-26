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
 * DTO specifico della query modellata nel finder anagraficaOperatoreByIdOperatore.
 * @generated
 */
public class TaifTPersonaAnagraficaOperatoreByIdOperatoreDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idSoggettoGestore;

	/**
	 * @generated
	 */
	public void setIdSoggettoGestore(Integer val) {

		idSoggettoGestore = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdSoggettoGestore() {

		return idSoggettoGestore;

	}

	/*	 
	 * @generated
	 */
	private String denominazioneSoggettoGestore;

	/**
	 * @generated
	 */
	public void setDenominazioneSoggettoGestore(String val) {

		denominazioneSoggettoGestore = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazioneSoggettoGestore() {

		return denominazioneSoggettoGestore;

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
	private java.sql.Date dataNascita;

	/**
	 * @generated
	 */
	public void setDataNascita(java.sql.Date val) {

		if (val != null) {
			dataNascita = new java.sql.Date(val.getTime());
		} else {
			dataNascita = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataNascita() {

		if (dataNascita != null) {
			return new java.sql.Date(dataNascita.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer idNazione;

	/**
	 * @generated
	 */
	public void setIdNazione(Integer val) {

		idNazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdNazione() {

		return idNazione;

	}

	/*	 
	 * @generated
	 */
	private String istatComuneNascita;

	/**
	 * @generated
	 */
	public void setIstatComuneNascita(String val) {

		istatComuneNascita = val;

	}
	/**
	 * @generated
	 */
	public String getIstatComuneNascita() {

		return istatComuneNascita;

	}

	/*	 
	 * @generated
	 */
	private String comuneEsteroNascita;

	/**
	 * @generated
	 */
	public void setComuneEsteroNascita(String val) {

		comuneEsteroNascita = val;

	}
	/**
	 * @generated
	 */
	public String getComuneEsteroNascita() {

		return comuneEsteroNascita;

	}

	/*	 
	 * @generated
	 */
	private String istatComuneResidenza;

	/**
	 * @generated
	 */
	public void setIstatComuneResidenza(String val) {

		istatComuneResidenza = val;

	}
	/**
	 * @generated
	 */
	public String getIstatComuneResidenza() {

		return istatComuneResidenza;

	}

	/*	 
	 * @generated
	 */
	private String comuneEsteroResidenza;

	/**
	 * @generated
	 */
	public void setComuneEsteroResidenza(String val) {

		comuneEsteroResidenza = val;

	}
	/**
	 * @generated
	 */
	public String getComuneEsteroResidenza() {

		return comuneEsteroResidenza;

	}

	/*	 
	 * @generated
	 */
	private String indirizzoResidenza;

	/**
	 * @generated
	 */
	public void setIndirizzoResidenza(String val) {

		indirizzoResidenza = val;

	}
	/**
	 * @generated
	 */
	public String getIndirizzoResidenza() {

		return indirizzoResidenza;

	}

	/*	 
	 * @generated
	 */
	private String civicoResidenza;

	/**
	 * @generated
	 */
	public void setCivicoResidenza(String val) {

		civicoResidenza = val;

	}
	/**
	 * @generated
	 */
	public String getCivicoResidenza() {

		return civicoResidenza;

	}

	/*	 
	 * @generated
	 */
	private String capResidenza;

	/**
	 * @generated
	 */
	public void setCapResidenza(String val) {

		capResidenza = val;

	}
	/**
	 * @generated
	 */
	public String getCapResidenza() {

		return capResidenza;

	}

	/*	 
	 * @generated
	 */
	private String telefono;

	/**
	 * @generated
	 */
	public void setTelefono(String val) {

		telefono = val;

	}
	/**
	 * @generated
	 */
	public String getTelefono() {

		return telefono;

	}

	/*	 
	 * @generated
	 */
	private String cellulare;

	/**
	 * @generated
	 */
	public void setCellulare(String val) {

		cellulare = val;

	}
	/**
	 * @generated
	 */
	public String getCellulare() {

		return cellulare;

	}

	/*	 
	 * @generated
	 */
	private String mailPersonale;

	/**
	 * @generated
	 */
	public void setMailPersonale(String val) {

		mailPersonale = val;

	}
	/**
	 * @generated
	 */
	public String getMailPersonale() {

		return mailPersonale;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flagPubblico;

	/**
	 * @generated
	 */
	public void setFlagPubblico(java.math.BigDecimal val) {

		flagPubblico = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagPubblico() {

		return flagPubblico;

	}

	/*	 
	 * @generated
	 */
	private String statoOpfoIta;

	/**
	 * @generated
	 */
	public void setStatoOpfoIta(String val) {

		statoOpfoIta = val;

	}
	/**
	 * @generated
	 */
	public String getStatoOpfoIta() {

		return statoOpfoIta;

	}

	/*	 
	 * @generated
	 */
	private String urlPrivacy;

	/**
	 * @generated
	 */
	public void setUrlPrivacy(String val) {

		urlPrivacy = val;

	}
	/**
	 * @generated
	 */
	public String getUrlPrivacy() {

		return urlPrivacy;

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
