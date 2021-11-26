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
 * DTO specifico della query modellata nel finder byAzienda.
 * @generated
 */
public class TaifTDpiByAziendaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idDpi;

	/**
	 * @generated
	 */
	public void setIdDpi(Integer val) {

		idDpi = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdDpi() {

		return idDpi;

	}

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
	private String tipologia;

	/**
	 * @generated
	 */
	public void setTipologia(String val) {

		tipologia = val;

	}
	/**
	 * @generated
	 */
	public String getTipologia() {

		return tipologia;

	}

	/*	 
	 * @generated
	 */
	private Integer quantita;

	/**
	 * @generated
	 */
	public void setQuantita(Integer val) {

		quantita = val;

	}
	/**
	 * @generated
	 */
	public Integer getQuantita() {

		return quantita;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal annoScadenza;

	/**
	 * @generated
	 */
	public void setAnnoScadenza(java.math.BigDecimal val) {

		annoScadenza = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAnnoScadenza() {

		return annoScadenza;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoDpi;

	/**
	 * @generated
	 */
	public void setIdTipoDpi(Integer val) {

		idTipoDpi = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoDpi() {

		return idTipoDpi;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

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
