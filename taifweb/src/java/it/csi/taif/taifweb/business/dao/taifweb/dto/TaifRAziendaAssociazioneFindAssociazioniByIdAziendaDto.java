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
 * DTO specifico della query modellata nel finder findAssociazioniByIdAzienda.
 * @generated
 */
public class TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto implements Serializable {

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
	private Integer idAssociazione;

	/**
	 * @generated
	 */
	public void setIdAssociazione(Integer val) {

		idAssociazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAssociazione() {

		return idAssociazione;

	}

	/*	 
	 * @generated
	 */
	private String nomeAltraAssociazione;

	/**
	 * @generated
	 */
	public void setNomeAltraAssociazione(String val) {

		nomeAltraAssociazione = val;

	}
	/**
	 * @generated
	 */
	public String getNomeAltraAssociazione() {

		return nomeAltraAssociazione;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimento() {

		if (dataInserimento != null) {
			return new java.sql.Timestamp(dataInserimento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String associazione;

	/**
	 * @generated
	 */
	public void setAssociazione(String val) {

		associazione = val;

	}
	/**
	 * @generated
	 */
	public String getAssociazione() {

		return associazione;

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
