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
 * DTO specifico della query modellata nel finder byStatoPratica.
 * @generated
 */
public class TaifTStoricoStatoByStatoPraticaDto implements Serializable {

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
	private String numProtocollo;

	/**
	 * @generated
	 */
	public void setNumProtocollo(String val) {

		numProtocollo = val;

	}
	/**
	 * @generated
	 */
	public String getNumProtocollo() {

		return numProtocollo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataProt;

	/**
	 * @generated
	 */
	public void setDataProt(java.sql.Date val) {

		if (val != null) {
			dataProt = new java.sql.Date(val.getTime());
		} else {
			dataProt = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataProt() {

		if (dataProt != null) {
			return new java.sql.Date(dataProt.getTime());
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
