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
 * DTO specifico della query modellata nel finder byProfiloPersona.
 * @generated
 */
public class TaifTPersonaByProfiloPersonaDto implements Serializable {

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
	private Integer idStudioFra;

	/**
	 * @generated
	 */
	public void setIdStudioFra(Integer val) {

		idStudioFra = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdStudioFra() {

		return idStudioFra;

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
	private String msa;

	/**
	 * @generated
	 */
	public void setMsa(String val) {

		msa = val;

	}
	/**
	 * @generated
	 */
	public String getMsa() {

		return msa;

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
	private java.sql.Date nascita;

	/**
	 * @generated
	 */
	public void setNascita(java.sql.Date val) {

		if (val != null) {
			nascita = new java.sql.Date(val.getTime());
		} else {
			nascita = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getNascita() {

		if (nascita != null) {
			return new java.sql.Date(nascita.getTime());
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
	private String comEstero;

	/**
	 * @generated
	 */
	public void setComEstero(String val) {

		comEstero = val;

	}
	/**
	 * @generated
	 */
	public String getComEstero() {

		return comEstero;

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
	private String cell;

	/**
	 * @generated
	 */
	public void setCell(String val) {

		cell = val;

	}
	/**
	 * @generated
	 */
	public String getCell() {

		return cell;

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
	private String aStudi;

	/**
	 * @generated
	 */
	public void setAStudi(String val) {

		aStudi = val;

	}
	/**
	 * @generated
	 */
	public String getAStudi() {

		return aStudi;

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
