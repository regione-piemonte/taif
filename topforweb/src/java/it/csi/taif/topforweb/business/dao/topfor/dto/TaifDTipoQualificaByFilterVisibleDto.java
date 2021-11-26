/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dto;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byFilterVisible.
 * @generated
 */
public class TaifDTipoQualificaByFilterVisibleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idQualifica;

	/**
	 * @generated
	 */
	public void setIdQualifica(Integer val) {

		idQualifica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdQualifica() {

		return idQualifica;

	}

	/*	 
	 * @generated
	 */
	private String tipoQualifica;

	/**
	 * @generated
	 */
	public void setTipoQualifica(String val) {

		tipoQualifica = val;

	}
	/**
	 * @generated
	 */
	public String getTipoQualifica() {

		return tipoQualifica;

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
