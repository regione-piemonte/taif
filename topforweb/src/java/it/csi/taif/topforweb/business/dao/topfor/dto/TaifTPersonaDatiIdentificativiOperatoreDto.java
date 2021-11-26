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
 * DTO specifico della query modellata nel finder datiIdentificativiOperatore.
 * @generated
 */
public class TaifTPersonaDatiIdentificativiOperatoreDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pubblico;

	/**
	 * @generated
	 */
	public void setPubblico(java.math.BigDecimal val) {

		pubblico = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPubblico() {

		return pubblico;

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
	private Integer idTitoloStudio;

	/**
	 * @generated
	 */
	public void setIdTitoloStudio(Integer val) {

		idTitoloStudio = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTitoloStudio() {

		return idTitoloStudio;

	}

	/*	 
	 * @generated
	 */
	private String titoloStudioIta;

	/**
	 * @generated
	 */
	public void setTitoloStudioIta(String val) {

		titoloStudioIta = val;

	}
	/**
	 * @generated
	 */
	public String getTitoloStudioIta() {

		return titoloStudioIta;

	}

	/*	 
	 * @generated
	 */
	private Integer idTitoloStudioFra;

	/**
	 * @generated
	 */
	public void setIdTitoloStudioFra(Integer val) {

		idTitoloStudioFra = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTitoloStudioFra() {

		return idTitoloStudioFra;

	}

	/*	 
	 * @generated
	 */
	private String titoloStudioFra;

	/**
	 * @generated
	 */
	public void setTitoloStudioFra(String val) {

		titoloStudioFra = val;

	}
	/**
	 * @generated
	 */
	public String getTitoloStudioFra() {

		return titoloStudioFra;

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
	private String emailPersonale;

	/**
	 * @generated
	 */
	public void setEmailPersonale(String val) {

		emailPersonale = val;

	}
	/**
	 * @generated
	 */
	public String getEmailPersonale() {

		return emailPersonale;

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
	private String elencoAppartenenza;

	/**
	 * @generated
	 */
	public void setElencoAppartenenza(String val) {

		elencoAppartenenza = val;

	}
	/**
	 * @generated
	 */
	public String getElencoAppartenenza() {

		return elencoAppartenenza;

	}

	/*	 
	 * @generated
	 */
	private String statoSchedaIta;

	/**
	 * @generated
	 */
	public void setStatoSchedaIta(String val) {

		statoSchedaIta = val;

	}
	/**
	 * @generated
	 */
	public String getStatoSchedaIta() {

		return statoSchedaIta;

	}

	/*	 
	 * @generated
	 */
	private String statoSchedaFra;

	/**
	 * @generated
	 */
	public void setStatoSchedaFra(String val) {

		statoSchedaFra = val;

	}
	/**
	 * @generated
	 */
	public String getStatoSchedaFra() {

		return statoSchedaFra;

	}

	/*	 
	 * @generated
	 */
	private String nazioneNascitaIta;

	/**
	 * @generated
	 */
	public void setNazioneNascitaIta(String val) {

		nazioneNascitaIta = val;

	}
	/**
	 * @generated
	 */
	public String getNazioneNascitaIta() {

		return nazioneNascitaIta;

	}

	/*	 
	 * @generated
	 */
	private String nazioneNascitaFra;

	/**
	 * @generated
	 */
	public void setNazioneNascitaFra(String val) {

		nazioneNascitaFra = val;

	}
	/**
	 * @generated
	 */
	public String getNazioneNascitaFra() {

		return nazioneNascitaFra;

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
