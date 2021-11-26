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
 * DTO specifico della query modellata nel finder byIdAzienda.
 * @generated
 */
public class TaifTAttivitaSvoltaByIdAziendaDto implements Serializable {

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
	private String altre;

	/**
	 * @generated
	 */
	public void setAltre(String val) {

		altre = val;

	}
	/**
	 * @generated
	 */
	public String getAltre() {

		return altre;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataIns;

	/**
	 * @generated
	 */
	public void setDataIns(java.sql.Timestamp val) {

		if (val != null) {
			dataIns = new java.sql.Timestamp(val.getTime());
		} else {
			dataIns = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataIns() {

		if (dataIns != null) {
			return new java.sql.Timestamp(dataIns.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoAttivita;

	/**
	 * @generated
	 */
	public void setIdTipoAttivita(Integer val) {

		idTipoAttivita = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoAttivita() {

		return idTipoAttivita;

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
