/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder findByVisible.
 * @generated
 */
public class TaifDTipoInquadramentoFindByVisibleDto implements Serializable {

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
	private String tipo;

	/**
	 * @generated
	 */
	public void setTipo(String val) {

		tipo = val;

	}
	/**
	 * @generated
	 */
	public String getTipo() {

		return tipo;

	}

	/*	 
	 * @generated
	 */
	private String ordin;

	/**
	 * @generated
	 */
	public void setOrdin(String val) {

		ordin = val;

	}
	/**
	 * @generated
	 */
	public String getOrdin() {

		return ordin;

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
