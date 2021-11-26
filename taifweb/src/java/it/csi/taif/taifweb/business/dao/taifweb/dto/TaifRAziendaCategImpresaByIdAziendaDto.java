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
 * DTO specifico della query modellata nel finder byIdAzienda.
 * @generated
 */
public class TaifRAziendaCategImpresaByIdAziendaDto implements Serializable {

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
	private Integer idcategImpresa;

	/**
	 * @generated
	 */
	public void setIdcategImpresa(Integer val) {

		idcategImpresa = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdcategImpresa() {

		return idcategImpresa;

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
	private String aziendaCategImpresa;

	/**
	 * @generated
	 */
	public void setAziendaCategImpresa(String val) {

		aziendaCategImpresa = val;

	}
	/**
	 * @generated
	 */
	public String getAziendaCategImpresa() {

		return aziendaCategImpresa;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer fkConfigUtente;

	/**
	 * @generated
	 */
	public void setFkConfigUtente(Integer val) {

		fkConfigUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getFkConfigUtente() {

		return fkConfigUtente;

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
