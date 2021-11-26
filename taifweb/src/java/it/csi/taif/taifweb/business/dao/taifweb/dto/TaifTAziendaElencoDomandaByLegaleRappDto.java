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
 * DTO specifico della query modellata nel finder elencoDomandaByLegaleRapp.
 * @generated
 */
public class TaifTAziendaElencoDomandaByLegaleRappDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idAzienda;

	/**
	 * @generated
	 */
	public void setIdAzienda(Integer val) {

		idAzienda = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAzienda() {

		return idAzienda;

	}

	/*	 
	 * @generated
	 */
	private String ragioneSociale;

	/**
	 * @generated
	 */
	public void setRagioneSociale(String val) {

		ragioneSociale = val;

	}
	/**
	 * @generated
	 */
	public String getRagioneSociale() {

		return ragioneSociale;

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
	private Integer idSogettoGestore;

	/**
	 * @generated
	 */
	public void setIdSogettoGestore(Integer val) {

		idSogettoGestore = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdSogettoGestore() {

		return idSogettoGestore;

	}

	/*	 
	 * @generated
	 */
	private String statoPraticaItalia;

	/**
	 * @generated
	 */
	public void setStatoPraticaItalia(String val) {

		statoPraticaItalia = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPraticaItalia() {

		return statoPraticaItalia;

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
	private String codiceAlbo;

	/**
	 * @generated
	 */
	public void setCodiceAlbo(String val) {

		codiceAlbo = val;

	}
	/**
	 * @generated
	 */
	public String getCodiceAlbo() {

		return codiceAlbo;

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
