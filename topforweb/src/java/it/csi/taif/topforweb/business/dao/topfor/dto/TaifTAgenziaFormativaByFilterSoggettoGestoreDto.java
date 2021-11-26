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
 * DTO specifico della query modellata nel finder byFilterSoggettoGestore.
 * @generated
 */
public class TaifTAgenziaFormativaByFilterSoggettoGestoreDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idAgenzia;

	/**
	 * @generated
	 */
	public void setIdAgenzia(Integer val) {

		idAgenzia = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAgenzia() {

		return idAgenzia;

	}

	/*	 
	 * @generated
	 */
	private String dsAgenziaFormativa;

	/**
	 * @generated
	 */
	public void setDsAgenziaFormativa(String val) {

		dsAgenziaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getDsAgenziaFormativa() {

		return dsAgenziaFormativa;

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
