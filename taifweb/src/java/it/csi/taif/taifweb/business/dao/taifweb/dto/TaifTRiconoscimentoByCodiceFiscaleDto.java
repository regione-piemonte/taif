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
 * DTO specifico della query modellata nel finder byCodiceFiscale.
 * @generated
 */
public class TaifTRiconoscimentoByCodiceFiscaleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer rIdRiconoscimento;

	/**
	 * @generated
	 */
	public void setRIdRiconoscimento(Integer val) {

		rIdRiconoscimento = val;

	}
	/**
	 * @generated
	 */
	public Integer getRIdRiconoscimento() {

		return rIdRiconoscimento;

	}

	/*	 
	 * @generated
	 */
	private Integer rFkUnitaFormativa;

	/**
	 * @generated
	 */
	public void setRFkUnitaFormativa(Integer val) {

		rFkUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public Integer getRFkUnitaFormativa() {

		return rFkUnitaFormativa;

	}

	/*	 
	 * @generated
	 */
	private Integer rFkPersona;

	/**
	 * @generated
	 */
	public void setRFkPersona(Integer val) {

		rFkPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getRFkPersona() {

		return rFkPersona;

	}

	/*	 
	 * @generated
	 */
	private String uUnitaFormativa;

	/**
	 * @generated
	 */
	public void setUUnitaFormativa(String val) {

		uUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public String getUUnitaFormativa() {

		return uUnitaFormativa;

	}

	/*	 
	 * @generated
	 */
	private String uSigla;

	/**
	 * @generated
	 */
	public void setUSigla(String val) {

		uSigla = val;

	}
	/**
	 * @generated
	 */
	public String getUSigla() {

		return uSigla;

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
