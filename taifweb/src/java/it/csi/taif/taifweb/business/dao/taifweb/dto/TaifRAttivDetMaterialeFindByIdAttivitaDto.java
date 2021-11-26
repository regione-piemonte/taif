/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder findByIdAttivita.
 * @generated
 */
public class TaifRAttivDetMaterialeFindByIdAttivitaDto implements Serializable {

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
