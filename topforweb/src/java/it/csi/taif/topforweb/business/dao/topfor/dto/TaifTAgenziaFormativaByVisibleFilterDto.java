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
 * DTO specifico della query modellata nel finder byVisibleFilter.
 * @generated
 */
public class TaifTAgenziaFormativaByVisibleFilterDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idAgenziaFormativa;

	/**
	 * @generated
	 */
	public void setIdAgenziaFormativa(Integer val) {

		idAgenziaFormativa = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAgenziaFormativa() {

		return idAgenziaFormativa;

	}

	/*	 
	 * @generated
	 */
	private String denominazioneAgenziaFormativa;

	/**
	 * @generated
	 */
	public void setDenominazioneAgenziaFormativa(String val) {

		denominazioneAgenziaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazioneAgenziaFormativa() {

		return denominazioneAgenziaFormativa;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ordin;

	/**
	 * @generated
	 */
	public void setOrdin(java.math.BigDecimal val) {

		ordin = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getOrdin() {

		return ordin;

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
