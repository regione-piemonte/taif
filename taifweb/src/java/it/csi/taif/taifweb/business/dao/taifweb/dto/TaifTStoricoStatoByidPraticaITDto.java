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
 * DTO specifico della query modellata nel finder byidPraticaIT.
 * @generated
 */
public class TaifTStoricoStatoByidPraticaITDto implements Serializable {

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
	private java.sql.Timestamp dataInserimentoStato;

	/**
	 * @generated
	 */
	public void setDataInserimentoStato(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimentoStato = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimentoStato = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimentoStato() {

		if (dataInserimentoStato != null) {
			return new java.sql.Timestamp(dataInserimentoStato.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String numeroProtocollo;

	/**
	 * @generated
	 */
	public void setNumeroProtocollo(String val) {

		numeroProtocollo = val;

	}
	/**
	 * @generated
	 */
	public String getNumeroProtocollo() {

		return numeroProtocollo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataProtocollo;

	/**
	 * @generated
	 */
	public void setDataProtocollo(java.sql.Date val) {

		if (val != null) {
			dataProtocollo = new java.sql.Date(val.getTime());
		} else {
			dataProtocollo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataProtocollo() {

		if (dataProtocollo != null) {
			return new java.sql.Date(dataProtocollo.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataUltimaModifica;

	/**
	 * @generated
	 */
	public void setDataUltimaModifica(java.sql.Timestamp val) {

		if (val != null) {
			dataUltimaModifica = new java.sql.Timestamp(val.getTime());
		} else {
			dataUltimaModifica = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataUltimaModifica() {

		if (dataUltimaModifica != null) {
			return new java.sql.Timestamp(dataUltimaModifica.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String note;

	/**
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}
	/**
	 * @generated
	 */
	public String getNote() {

		return note;

	}

	/*	 
	 * @generated
	 */
	private String statoPratica;

	/**
	 * @generated
	 */
	public void setStatoPratica(String val) {

		statoPratica = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPratica() {

		return statoPratica;

	}

	/*	 
	 * @generated
	 */
	private String operatoreCognome;

	/**
	 * @generated
	 */
	public void setOperatoreCognome(String val) {

		operatoreCognome = val;

	}
	/**
	 * @generated
	 */
	public String getOperatoreCognome() {

		return operatoreCognome;

	}

	/*	 
	 * @generated
	 */
	private String operatoreNome;

	/**
	 * @generated
	 */
	public void setOperatoreNome(String val) {

		operatoreNome = val;

	}
	/**
	 * @generated
	 */
	public String getOperatoreNome() {

		return operatoreNome;

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
