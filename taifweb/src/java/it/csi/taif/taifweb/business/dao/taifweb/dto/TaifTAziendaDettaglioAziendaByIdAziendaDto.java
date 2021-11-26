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
 * DTO specifico della query modellata nel finder dettaglioAziendaByIdAzienda.
 * @generated
 */
public class TaifTAziendaDettaglioAziendaByIdAziendaDto implements Serializable {

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

	/*	 
	 * @generated
	 */
	private String formagiuridicaita;

	/**
	 * @generated
	 */
	public void setFormagiuridicaita(String val) {

		formagiuridicaita = val;

	}
	/**
	 * @generated
	 */
	public String getFormagiuridicaita() {

		return formagiuridicaita;

	}

	/*	 
	 * @generated
	 */
	private String formagiuridicafra;

	/**
	 * @generated
	 */
	public void setFormagiuridicafra(String val) {

		formagiuridicafra = val;

	}
	/**
	 * @generated
	 */
	public String getFormagiuridicafra() {

		return formagiuridicafra;

	}

	/*	 
	 * @generated
	 */
	private String email;

	/**
	 * @generated
	 */
	public void setEmail(String val) {

		email = val;

	}
	/**
	 * @generated
	 */
	public String getEmail() {

		return email;

	}

	/*	 
	 * @generated
	 */
	private String sitoWeb;

	/**
	 * @generated
	 */
	public void setSitoWeb(String val) {

		sitoWeb = val;

	}
	/**
	 * @generated
	 */
	public String getSitoWeb() {

		return sitoWeb;

	}

	/*	 
	 * @generated
	 */
	private Integer nbreSalariesFra;

	/**
	 * @generated
	 */
	public void setNbreSalariesFra(Integer val) {

		nbreSalariesFra = val;

	}
	/**
	 * @generated
	 */
	public Integer getNbreSalariesFra() {

		return nbreSalariesFra;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal tempsPleinFra;

	/**
	 * @generated
	 */
	public void setTempsPleinFra(java.math.BigDecimal val) {

		tempsPleinFra = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getTempsPleinFra() {

		return tempsPleinFra;

	}

	/*	 
	 * @generated
	 */
	private String indirizzo;

	/**
	 * @generated
	 */
	public void setIndirizzo(String val) {

		indirizzo = val;

	}
	/**
	 * @generated
	 */
	public String getIndirizzo() {

		return indirizzo;

	}

	/*	 
	 * @generated
	 */
	private String civico;

	/**
	 * @generated
	 */
	public void setCivico(String val) {

		civico = val;

	}
	/**
	 * @generated
	 */
	public String getCivico() {

		return civico;

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
	private String sezione;

	/**
	 * @generated
	 */
	public void setSezione(String val) {

		sezione = val;

	}
	/**
	 * @generated
	 */
	public String getSezione() {

		return sezione;

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
