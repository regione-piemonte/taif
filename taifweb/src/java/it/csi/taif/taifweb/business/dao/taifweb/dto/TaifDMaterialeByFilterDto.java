/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder byFilter.
 * @generated
 */
public class TaifDMaterialeByFilterDto implements Serializable {

	/*	 
	 * @generated
	 */
	private String mMateriale;

	
	/**
	 * @generated
	 */
	public void setMMateriale(String val) {

		mMateriale = val;

	}
	/**
	 * @generated
	 */
	public String getMMateriale() {

		return mMateriale;

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
