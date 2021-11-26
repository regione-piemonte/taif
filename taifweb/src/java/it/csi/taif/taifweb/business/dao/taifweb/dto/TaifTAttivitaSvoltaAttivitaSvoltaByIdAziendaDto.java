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
 * DTO specifico della query modellata nel finder attivitaSvoltaByIdAzienda.
 * @generated
 */
public class TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto implements Serializable {

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
	private String tipoAttivita;

	/**
	 * @generated
	 */
	public void setTipoAttivita(String val) {

		tipoAttivita = val;

	}
	/**
	 * @generated
	 */
	public String getTipoAttivita() {

		return tipoAttivita;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal fatturato;

	/**
	 * @generated
	 */
	public void setFatturato(java.math.BigDecimal val) {

		fatturato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFatturato() {

		return fatturato;

	}

	/*	 
	 * @generated
	 */
	private String altreAttivita;

	/**
	 * @generated
	 */
	public void setAltreAttivita(String val) {

		altreAttivita = val;

	}
	/**
	 * @generated
	 */
	public String getAltreAttivita() {

		return altreAttivita;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimento() {

		if (dataInserimento != null) {
			return new java.sql.Timestamp(dataInserimento.getTime());
		} else {
			return null;
		}

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
