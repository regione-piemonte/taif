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
 * DTO specifico della query modellata nel finder byIdTipoMezzoAzienda.
 * @generated
 */
public class TaifTMezzoByIdTipoMezzoAziendaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idMezzo;

	/**
	 * @generated
	 */
	public void setIdMezzo(Integer val) {

		idMezzo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdMezzo() {

		return idMezzo;

	}

	/*	 
	 * @generated
	 */
	private String tipoMezzo;

	/**
	 * @generated
	 */
	public void setTipoMezzo(String val) {

		tipoMezzo = val;

	}
	/**
	 * @generated
	 */
	public String getTipoMezzo() {

		return tipoMezzo;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal anno;

	/**
	 * @generated
	 */
	public void setAnno(java.math.BigDecimal val) {

		anno = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAnno() {

		return anno;

	}

	/*	 
	 * @generated
	 */
	private Integer potenza;

	/**
	 * @generated
	 */
	public void setPotenza(Integer val) {

		potenza = val;

	}
	/**
	 * @generated
	 */
	public Integer getPotenza() {

		return potenza;

	}

	/*	 
	 * @generated
	 */
	private Integer portata;

	/**
	 * @generated
	 */
	public void setPortata(Integer val) {

		portata = val;

	}
	/**
	 * @generated
	 */
	public Integer getPortata() {

		return portata;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal comando;

	/**
	 * @generated
	 */
	public void setComando(java.math.BigDecimal val) {

		comando = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getComando() {

		return comando;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal noleggio;

	/**
	 * @generated
	 */
	public void setNoleggio(java.math.BigDecimal val) {

		noleggio = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getNoleggio() {

		return noleggio;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataInsert;

	/**
	 * @generated
	 */
	public void setDataInsert(java.sql.Timestamp val) {

		if (val != null) {
			dataInsert = new java.sql.Timestamp(val.getTime());
		} else {
			dataInsert = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInsert() {

		if (dataInsert != null) {
			return new java.sql.Timestamp(dataInsert.getTime());
		} else {
			return null;
		}

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
	private Integer idAlimentazione;

	/**
	 * @generated
	 */
	public void setIdAlimentazione(Integer val) {

		idAlimentazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAlimentazione() {

		return idAlimentazione;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoCarrel;

	/**
	 * @generated
	 */
	public void setIdTipoCarrel(Integer val) {

		idTipoCarrel = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoCarrel() {

		return idTipoCarrel;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoMezzo;

	/**
	 * @generated
	 */
	public void setIdTipoMezzo(Integer val) {

		idTipoMezzo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoMezzo() {

		return idTipoMezzo;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoTrazione;

	/**
	 * @generated
	 */
	public void setIdTipoTrazione(Integer val) {

		idTipoTrazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoTrazione() {

		return idTipoTrazione;

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
