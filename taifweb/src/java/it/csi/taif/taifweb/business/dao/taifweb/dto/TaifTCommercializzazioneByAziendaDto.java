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
 * DTO specifico della query modellata nel finder byAzienda.
 * @generated
 */
public class TaifTCommercializzazioneByAziendaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer id;

	/**
	 * @generated
	 */
	public void setId(Integer val) {

		id = val;

	}
	/**
	 * @generated
	 */
	public Integer getId() {

		return id;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal venduto;

	/**
	 * @generated
	 */
	public void setVenduto(java.math.BigDecimal val) {

		venduto = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getVenduto() {

		return venduto;

	}

	/*	 
	 * @generated
	 */
	private String note;

	/**
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}
	/**
	 * @generated
	 */
	public String getNote() {

		return note;

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
	private Integer idSpecie;

	/**
	 * @generated
	 */
	public void setIdSpecie(Integer val) {

		idSpecie = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdSpecie() {

		return idSpecie;

	}

	/*	 
	 * @generated
	 */
	private Integer idProvenienza;

	/**
	 * @generated
	 */
	public void setIdProvenienza(Integer val) {

		idProvenienza = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdProvenienza() {

		return idProvenienza;

	}

	/*	 
	 * @generated
	 */
	private Integer idDestinazione;

	/**
	 * @generated
	 */
	public void setIdDestinazione(Integer val) {

		idDestinazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdDestinazione() {

		return idDestinazione;

	}

	/*	 
	 * @generated
	 */
	private Integer idAssortimento;

	/**
	 * @generated
	 */
	public void setIdAssortimento(Integer val) {

		idAssortimento = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAssortimento() {

		return idAssortimento;

	}

	/*	 
	 * @generated
	 */
	private Integer idUnMis;

	/**
	 * @generated
	 */
	public void setIdUnMis(Integer val) {

		idUnMis = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdUnMis() {

		return idUnMis;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal vendutoMedio;

	/**
	 * @generated
	 */
	public void setVendutoMedio(java.math.BigDecimal val) {

		vendutoMedio = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getVendutoMedio() {

		return vendutoMedio;

	}

	/*	 
	 * @generated
	 */
	private String flgTagliato;

	/**
	 * @generated
	 */
	public void setFlgTagliato(String val) {

		flgTagliato = val;

	}
	/**
	 * @generated
	 */
	public String getFlgTagliato() {

		return flgTagliato;

	}

	/*	 
	 * @generated
	 */
	private Integer idUtente;

	/**
	 * @generated
	 */
	public void setIdUtente(Integer val) {

		idUtente = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdUtente() {

		return idUtente;

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
