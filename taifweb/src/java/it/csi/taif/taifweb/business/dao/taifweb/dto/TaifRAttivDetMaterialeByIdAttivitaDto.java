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
 * DTO specifico della query modellata nel finder byIdAttivita.
 * @generated
 */
public class TaifRAttivDetMaterialeByIdAttivitaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idAtt;

	/**
	 * @generated
	 */
	public void setIdAtt(Integer val) {

		idAtt = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAtt() {

		return idAtt;

	}

	/*	 
	 * @generated
	 */
	private String materiale;

	/**
	 * @generated
	 */
	public void setMateriale(String val) {

		materiale = val;

	}
	/**
	 * @generated
	 */
	public String getMateriale() {

		return materiale;

	}

	/*	 
	 * @generated
	 */
	private Integer progressivo;

	/**
	 * @generated
	 */
	public void setProgressivo(Integer val) {

		progressivo = val;

	}
	/**
	 * @generated
	 */
	public Integer getProgressivo() {

		return progressivo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp data;

	/**
	 * @generated
	 */
	public void setData(java.sql.Timestamp val) {

		if (val != null) {
			data = new java.sql.Timestamp(val.getTime());
		} else {
			data = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getData() {

		if (data != null) {
			return new java.sql.Timestamp(data.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer idMateriale;

	/**
	 * @generated
	 */
	public void setIdMateriale(Integer val) {

		idMateriale = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdMateriale() {

		return idMateriale;

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
