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
 * DTO specifico della query modellata nel finder byAziendaUtente.
 * @generated
 */
public class TaifRPersonaAziendaByAziendaUtenteDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idPersona;

	/**
	 * @generated
	 */
	public void setIdPersona(Integer val) {

		idPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPersona() {

		return idPersona;

	}

	/*	 
	 * @generated
	 */
	private Integer idAzienda;

	/**
	 * @generated
	 */
	public void setIdAzienda(Integer val) {

		idAzienda = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAzienda() {

		return idAzienda;

	}

	/*	 
	 * @generated
	 */
	private Integer idRuolo;

	/**
	 * @generated
	 */
	public void setIdRuolo(Integer val) {

		idRuolo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdRuolo() {

		return idRuolo;

	}

	/*	 
	 * @generated
	 */
	private Integer idMansione;

	/**
	 * @generated
	 */
	public void setIdMansione(Integer val) {

		idMansione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdMansione() {

		return idMansione;

	}

	/*	 
	 * @generated
	 */
	private Integer idContratto;

	/**
	 * @generated
	 */
	public void setIdContratto(Integer val) {

		idContratto = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdContratto() {

		return idContratto;

	}

	/*	 
	 * @generated
	 */
	private Integer idInquad;

	/**
	 * @generated
	 */
	public void setIdInquad(Integer val) {

		idInquad = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdInquad() {

		return idInquad;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flagIndeterminato;

	/**
	 * @generated
	 */
	public void setFlagIndeterminato(java.math.BigDecimal val) {

		flagIndeterminato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagIndeterminato() {

		return flagIndeterminato;

	}

	/*	 
	 * @generated
	 */
	private Integer ggDeterminato;

	/**
	 * @generated
	 */
	public void setGgDeterminato(Integer val) {

		ggDeterminato = val;

	}
	/**
	 * @generated
	 */
	public Integer getGgDeterminato() {

		return ggDeterminato;

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
