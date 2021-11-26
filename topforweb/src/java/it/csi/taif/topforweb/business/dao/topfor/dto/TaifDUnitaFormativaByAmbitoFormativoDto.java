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
 * DTO specifico della query modellata nel finder byAmbitoFormativo.
 * @generated
 */
public class TaifDUnitaFormativaByAmbitoFormativoDto implements Serializable {

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
	private String denominazioneUnitaFormativa;

	/**
	 * @generated
	 */
	public void setDenominazioneUnitaFormativa(String val) {

		denominazioneUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazioneUnitaFormativa() {

		return denominazioneUnitaFormativa;

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
