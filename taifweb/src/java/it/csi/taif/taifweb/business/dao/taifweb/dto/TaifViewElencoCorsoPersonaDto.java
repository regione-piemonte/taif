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
 * Data transfer object relativo al DAO TaifViewElencoCorsoPersonaDao.
 * @generated
 */
public class TaifViewElencoCorsoPersonaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA
	 * @generated
	 */
	protected Integer idPersona;

	/**
	 * Imposta il valore della proprieta' idPersona associata alla
	 * colonna ID_PERSONA.
	 * @generated
	 */
	public void setIdPersona(Integer val) {

		idPersona = val;

	}

	/**
	 * Legge il valore della proprieta' idPersona associata alla
	 * @generated
	 */
	public Integer getIdPersona() {

		return idPersona;

	}

	/**
	 * store della proprieta' associata alla colonna ARRAY_TO_STRING
	 * @generated
	 */
	protected String arrayToString;

	/**
	 * Imposta il valore della proprieta' arrayToString associata alla
	 * colonna ARRAY_TO_STRING.
	 * @generated
	 */
	public void setArrayToString(String val) {

		arrayToString = val;

	}

	/**
	 * Legge il valore della proprieta' arrayToString associata alla
	 * @generated
	 */
	public String getArrayToString() {

		return arrayToString;

	}

}
