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
 * DTO specifico della query modellata nel finder byConfigUtente.
 * @generated
 */
public class TaifTPersonaByConfigUtenteDto implements Serializable {

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
	private Integer nazione;

	/**
	 * @generated
	 */
	public void setNazione(Integer val) {

		nazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getNazione() {

		return nazione;

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
	private String com;

	/**
	 * @generated
	 */
	public void setCom(String val) {

		com = val;

	}
	/**
	 * @generated
	 */
	public String getCom() {

		return com;

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
	private String comRes;

	/**
	 * @generated
	 */
	public void setComRes(String val) {

		comRes = val;

	}
	/**
	 * @generated
	 */
	public String getComRes() {

		return comRes;

	}

	/*	 
	 * @generated
	 */
	private String ind;

	/**
	 * @generated
	 */
	public void setInd(String val) {

		ind = val;

	}
	/**
	 * @generated
	 */
	public String getInd() {

		return ind;

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
	private String tel;

	/**
	 * @generated
	 */
	public void setTel(String val) {

		tel = val;

	}
	/**
	 * @generated
	 */
	public String getTel() {

		return tel;

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
	private Integer configUtente;

	/**
	 * @generated
	 */
	public void setConfigUtente(Integer val) {

		configUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getConfigUtente() {

		return configUtente;

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
