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
 * DTO specifico della query modellata nel finder byFilterAgenziaFormativa.
 * @generated
 */
public class TaifDUnitaFormativaByFilterAgenziaFormativaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idUnitaFormativa;

	/**
	 * @generated
	 */
	public void setIdUnitaFormativa(Integer val) {

		idUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdUnitaFormativa() {

		return idUnitaFormativa;

	}

	/*	 
	 * @generated
	 */
	private String dsUnitaFormativa;

	/**
	 * @generated
	 */
	public void setDsUnitaFormativa(String val) {

		dsUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getDsUnitaFormativa() {

		return dsUnitaFormativa;

	}

	/*	 
	 * @generated
	 */
	private String sigla;

	/**
	 * @generated
	 */
	public void setSigla(String val) {

		sigla = val;

	}
	/**
	 * @generated
	 */
	public String getSigla() {

		return sigla;

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
