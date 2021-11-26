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
 * DTO specifico della query modellata nel finder byCorsoPersona.
 * @generated
 */
public class TaifTAllegatoByCorsoPersonaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idAllegato;

	/**
	 * @generated
	 */
	public void setIdAllegato(Integer val) {

		idAllegato = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAllegato() {

		return idAllegato;

	}

	/*	 
	 * @generated
	 */
	private Integer fkCorso;

	/**
	 * @generated
	 */
	public void setFkCorso(Integer val) {

		fkCorso = val;

	}
	/**
	 * @generated
	 */
	public Integer getFkCorso() {

		return fkCorso;

	}

	/*	 
	 * @generated
	 */
	private Integer fkPersona;

	/**
	 * @generated
	 */
	public void setFkPersona(Integer val) {

		fkPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getFkPersona() {

		return fkPersona;

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
