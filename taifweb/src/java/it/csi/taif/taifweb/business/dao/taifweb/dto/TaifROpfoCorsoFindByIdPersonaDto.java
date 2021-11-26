/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder findByIdPersona.
 * @generated
 */
public class TaifROpfoCorsoFindByIdPersonaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idcorso;

	/**
	 * @generated
	 */
	public void setIdcorso(Integer val) {

		idcorso = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdcorso() {

		return idcorso;

	}

	/*	 
	 * @generated
	 */
	private Integer idpers;

	/**
	 * @generated
	 */
	public void setIdpers(Integer val) {

		idpers = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdpers() {

		return idpers;

	}

	/*	 
	 * @generated
	 */
	private String desc;

	/**
	 * @generated
	 */
	public void setDesc(String val) {

		desc = val;

	}
	/**
	 * @generated
	 */
	public String getDesc() {

		return desc;

	}

	/*	 
	 * @generated
	 */
	private String esito;

	/**
	 * @generated
	 */
	public void setEsito(String val) {

		esito = val;

	}
	/**
	 * @generated
	 */
	public String getEsito() {

		return esito;

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
