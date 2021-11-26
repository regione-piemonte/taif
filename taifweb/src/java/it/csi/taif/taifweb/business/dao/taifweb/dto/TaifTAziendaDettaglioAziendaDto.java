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
 * DTO specifico della query modellata nel finder dettaglioAzienda.
 * @generated
 */
public class TaifTAziendaDettaglioAziendaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer id;

	/**
	 * @generated
	 */
	public void setId(Integer val) {

		id = val;

	}
	/**
	 * @generated
	 */
	public Integer getId() {

		return id;

	}

	/*	 
	 * @generated
	 */
	private Integer idAlboAppartenenza;

	/**
	 * @generated
	 */
	public void setIdAlboAppartenenza(Integer val) {

		idAlboAppartenenza = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAlboAppartenenza() {

		return idAlboAppartenenza;

	}

	/*	 
	 * @generated
	 */
	private String denominazioneAzienda;

	/**
	 * @generated
	 */
	public void setDenominazioneAzienda(String val) {

		denominazioneAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazioneAzienda() {

		return denominazioneAzienda;

	}

	/*	 
	 * @generated
	 */
	private String codiceFiscaleAzienda;

	/**
	 * @generated
	 */
	public void setCodiceFiscaleAzienda(String val) {

		codiceFiscaleAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getCodiceFiscaleAzienda() {

		return codiceFiscaleAzienda;

	}

	/*	 
	 * @generated
	 */
	private String pivaAzienda;

	/**
	 * @generated
	 */
	public void setPivaAzienda(String val) {

		pivaAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getPivaAzienda() {

		return pivaAzienda;

	}

	/*	 
	 * @generated
	 */
	private String nomeTitolare;

	/**
	 * @generated
	 */
	public void setNomeTitolare(String val) {

		nomeTitolare = val;

	}
	/**
	 * @generated
	 */
	public String getNomeTitolare() {

		return nomeTitolare;

	}

	/*	 
	 * @generated
	 */
	private String cognomeTitolare;

	/**
	 * @generated
	 */
	public void setCognomeTitolare(String val) {

		cognomeTitolare = val;

	}
	/**
	 * @generated
	 */
	public String getCognomeTitolare() {

		return cognomeTitolare;

	}

	/*	 
	 * @generated
	 */
	private String numeroAlbo;

	/**
	 * @generated
	 */
	public void setNumeroAlbo(String val) {

		numeroAlbo = val;

	}
	/**
	 * @generated
	 */
	public String getNumeroAlbo() {

		return numeroAlbo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date iscrizioneAlbo;

	/**
	 * @generated
	 */
	public void setIscrizioneAlbo(java.sql.Date val) {

		if (val != null) {
			iscrizioneAlbo = new java.sql.Date(val.getTime());
		} else {
			iscrizioneAlbo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getIscrizioneAlbo() {

		if (iscrizioneAlbo != null) {
			return new java.sql.Date(iscrizioneAlbo.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer idPratica;

	/**
	 * @generated
	 */
	public void setIdPratica(Integer val) {

		idPratica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPratica() {

		return idPratica;

	}

	/*	 
	 * @generated
	 */
	private String istatComuneSede;

	/**
	 * @generated
	 */
	public void setIstatComuneSede(String val) {

		istatComuneSede = val;

	}
	/**
	 * @generated
	 */
	public String getIstatComuneSede() {

		return istatComuneSede;

	}

	/*	 
	 * @generated
	 */
	private Integer idStatoPratica;

	/**
	 * @generated
	 */
	public void setIdStatoPratica(Integer val) {

		idStatoPratica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdStatoPratica() {

		return idStatoPratica;

	}

	/*	 
	 * @generated
	 */
	private String dsStatoPraticaIta;

	/**
	 * @generated
	 */
	public void setDsStatoPraticaIta(String val) {

		dsStatoPraticaIta = val;

	}
	/**
	 * @generated
	 */
	public String getDsStatoPraticaIta() {

		return dsStatoPraticaIta;

	}

	/*	 
	 * @generated
	 */
	private String dsStatoPraticaFra;

	/**
	 * @generated
	 */
	public void setDsStatoPraticaFra(String val) {

		dsStatoPraticaFra = val;

	}
	/**
	 * @generated
	 */
	public String getDsStatoPraticaFra() {

		return dsStatoPraticaFra;

	}

	/*	 
	 * @generated
	 */
	private String dsAlboAppartenenza;

	/**
	 * @generated
	 */
	public void setDsAlboAppartenenza(String val) {

		dsAlboAppartenenza = val;

	}
	/**
	 * @generated
	 */
	public String getDsAlboAppartenenza() {

		return dsAlboAppartenenza;

	}

	/*	 
	 * @generated
	 */
	private String nSiret;

	/**
	 * @generated
	 */
	public void setNSiret(String val) {

		nSiret = val;

	}
	/**
	 * @generated
	 */
	public String getNSiret() {

		return nSiret;

	}

	/*	 
	 * @generated
	 */
	private String nTva;

	/**
	 * @generated
	 */
	public void setNTva(String val) {

		nTva = val;

	}
	/**
	 * @generated
	 */
	public String getNTva() {

		return nTva;

	}

	/*	 
	 * @generated
	 */
	private String comuneSedeEstero;

	/**
	 * @generated
	 */
	public void setComuneSedeEstero(String val) {

		comuneSedeEstero = val;

	}
	/**
	 * @generated
	 */
	public String getComuneSedeEstero() {

		return comuneSedeEstero;

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
