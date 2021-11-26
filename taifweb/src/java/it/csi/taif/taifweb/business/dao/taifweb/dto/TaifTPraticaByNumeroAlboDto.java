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
 * DTO specifico della query modellata nel finder byNumeroAlbo.
 * @generated
 */
public class TaifTPraticaByNumeroAlboDto implements Serializable {

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
	private Integer soggetto;

	/**
	 * @generated
	 */
	public void setSoggetto(Integer val) {

		soggetto = val;

	}
	/**
	 * @generated
	 */
	public Integer getSoggetto() {

		return soggetto;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataAgg;

	/**
	 * @generated
	 */
	public void setDataAgg(java.sql.Timestamp val) {

		if (val != null) {
			dataAgg = new java.sql.Timestamp(val.getTime());
		} else {
			dataAgg = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataAgg() {

		if (dataAgg != null) {
			return new java.sql.Timestamp(dataAgg.getTime());
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
