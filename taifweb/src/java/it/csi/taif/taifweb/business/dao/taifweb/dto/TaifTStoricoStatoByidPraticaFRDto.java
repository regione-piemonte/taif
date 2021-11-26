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
 * DTO specifico della query modellata nel finder byidPraticaFR.
 * @generated
 */
public class TaifTStoricoStatoByidPraticaFRDto implements Serializable {

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
