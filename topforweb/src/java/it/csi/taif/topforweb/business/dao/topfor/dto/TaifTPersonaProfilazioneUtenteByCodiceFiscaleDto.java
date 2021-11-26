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
 * DTO specifico della query modellata nel finder profilazioneUtenteByCodiceFiscale.
 * @generated
 */
public class TaifTPersonaProfilazioneUtenteByCodiceFiscaleDto implements Serializable {

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
	private Integer idTitolo;

	/**
	 * @generated
	 */
	public void setIdTitolo(Integer val) {

		idTitolo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTitolo() {

		return idTitolo;

	}

	/*	 
	 * @generated
	 */
	private Integer idTitoloFra;

	/**
	 * @generated
	 */
	public void setIdTitoloFra(Integer val) {

		idTitoloFra = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTitoloFra() {

		return idTitoloFra;

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
	private String codiceFiscale;

	/**
	 * @generated
	 */
	public void setCodiceFiscale(String val) {

		codiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getCodiceFiscale() {

		return codiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private String rsiMsa;

	/**
	 * @generated
	 */
	public void setRsiMsa(String val) {

		rsiMsa = val;

	}
	/**
	 * @generated
	 */
	public String getRsiMsa() {

		return rsiMsa;

	}

	/*	 
	 * @generated
	 */
	private String cognome;

	/**
	 * @generated
	 */
	public void setCognome(String val) {

		cognome = val;

	}
	/**
	 * @generated
	 */
	public String getCognome() {

		return cognome;

	}

	/*	 
	 * @generated
	 */
	private String nome;

	/**
	 * @generated
	 */
	public void setNome(String val) {

		nome = val;

	}
	/**
	 * @generated
	 */
	public String getNome() {

		return nome;

	}

	/*	 
	 * @generated
	 */
	private String sesso;

	/**
	 * @generated
	 */
	public void setSesso(String val) {

		sesso = val;

	}
	/**
	 * @generated
	 */
	public String getSesso() {

		return sesso;

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
	private String cap;

	/**
	 * @generated
	 */
	public void setCap(String val) {

		cap = val;

	}
	/**
	 * @generated
	 */
	public String getCap() {

		return cap;

	}

	/*	 
	 * @generated
	 */
	private String telefon;

	/**
	 * @generated
	 */
	public void setTelefon(String val) {

		telefon = val;

	}
	/**
	 * @generated
	 */
	public String getTelefon() {

		return telefon;

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
	private String mail;

	/**
	 * @generated
	 */
	public void setMail(String val) {

		mail = val;

	}
	/**
	 * @generated
	 */
	public String getMail() {

		return mail;

	}

	/*	 
	 * @generated
	 */
	private String altriStudi;

	/**
	 * @generated
	 */
	public void setAltriStudi(String val) {

		altriStudi = val;

	}
	/**
	 * @generated
	 */
	public String getAltriStudi() {

		return altriStudi;

	}

	/*	 
	 * @generated
	 */
	private Integer idProfiloUtente;

	/**
	 * @generated
	 */
	public void setIdProfiloUtente(Integer val) {

		idProfiloUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdProfiloUtente() {

		return idProfiloUtente;

	}

	/*	 
	 * @generated
	 */
	private String profiloUtente;

	/**
	 * @generated
	 */
	public void setProfiloUtente(String val) {

		profiloUtente = val;

	}
	/**
	 * @generated
	 */
	public String getProfiloUtente() {

		return profiloUtente;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flagUtenteAttivo;

	/**
	 * @generated
	 */
	public void setFlagUtenteAttivo(java.math.BigDecimal val) {

		flagUtenteAttivo = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagUtenteAttivo() {

		return flagUtenteAttivo;

	}

	/*	 
	 * @generated
	 */
	private Integer idProceduraUtente;

	/**
	 * @generated
	 */
	public void setIdProceduraUtente(Integer val) {

		idProceduraUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdProceduraUtente() {

		return idProceduraUtente;

	}

	/*	 
	 * @generated
	 */
	private Integer idConfigUtente;

	/**
	 * @generated
	 */
	public void setIdConfigUtente(Integer val) {

		idConfigUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdConfigUtente() {

		return idConfigUtente;

	}

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
