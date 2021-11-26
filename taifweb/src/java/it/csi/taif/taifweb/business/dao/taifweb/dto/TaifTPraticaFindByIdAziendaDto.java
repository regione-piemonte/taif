/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder findByIdAzienda.
 * @generated
 */
public class TaifTPraticaFindByIdAziendaDto implements Serializable {

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
	private String nrAlbo;

	/**
	 * @generated
	 */
	public void setNrAlbo(String val) {

		nrAlbo = val;

	}
	/**
	 * @generated
	 */
	public String getNrAlbo() {

		return nrAlbo;

	}

	/*	 
	 * @generated
	 */
	private String denom;

	/**
	 * @generated
	 */
	public void setDenom(String val) {

		denom = val;

	}
	/**
	 * @generated
	 */
	public String getDenom() {

		return denom;

	}

	/*	 
	 * @generated
	 */
	private Integer gestore;

	/**
	 * @generated
	 */
	public void setGestore(Integer val) {

		gestore = val;

	}
	/**
	 * @generated
	 */
	public Integer getGestore() {

		return gestore;

	}

	/*	 
	 * @generated
	 */
	private String sezione;

	/**
	 * @generated
	 */
	public void setSezione(String val) {

		sezione = val;

	}
	/**
	 * @generated
	 */
	public String getSezione() {

		return sezione;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataInscr;

	/**
	 * @generated
	 */
	public void setDataInscr(java.sql.Date val) {

		if (val != null) {
			dataInscr = new java.sql.Date(val.getTime());
		} else {
			dataInscr = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataInscr() {

		if (dataInscr != null) {
			return new java.sql.Date(dataInscr.getTime());
		} else {
			return null;
		}

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
