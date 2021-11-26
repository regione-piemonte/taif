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
 * DTO specifico della query modellata nel finder byCodiceFiscalePersonaPerContratto.
 * @generated
 */
public class TaifTPersonaByCodiceFiscalePersonaPerContrattoDto implements Serializable {

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
	private Integer idRuoloPersona;

	/**
	 * @generated
	 */
	public void setIdRuoloPersona(Integer val) {

		idRuoloPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdRuoloPersona() {

		return idRuoloPersona;

	}

	/*	 
	 * @generated
	 */
	private Integer idMansione;

	/**
	 * @generated
	 */
	public void setIdMansione(Integer val) {

		idMansione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdMansione() {

		return idMansione;

	}

	/*	 
	 * @generated
	 */
	private Integer idContrattoPersona;

	/**
	 * @generated
	 */
	public void setIdContrattoPersona(Integer val) {

		idContrattoPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdContrattoPersona() {

		return idContrattoPersona;

	}

	/*	 
	 * @generated
	 */
	private Integer idInquadramento;

	/**
	 * @generated
	 */
	public void setIdInquadramento(Integer val) {

		idInquadramento = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdInquadramento() {

		return idInquadramento;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flagTempoDett;

	/**
	 * @generated
	 */
	public void setFlagTempoDett(java.math.BigDecimal val) {

		flagTempoDett = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagTempoDett() {

		return flagTempoDett;

	}

	/*	 
	 * @generated
	 */
	private Integer ggTempoDett;

	/**
	 * @generated
	 */
	public void setGgTempoDett(Integer val) {

		ggTempoDett = val;

	}
	/**
	 * @generated
	 */
	public Integer getGgTempoDett() {

		return ggTempoDett;

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
