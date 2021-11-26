/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder findByIdTipoContratto.
 * @generated
 */
public class TaifRAziendaFrTipoContrFindByIdTipoContrattoDto implements Serializable {

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
	private Integer idTipoContr;

	/**
	 * @generated
	 */
	public void setIdTipoContr(Integer val) {

		idTipoContr = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoContr() {

		return idTipoContr;

	}

	/*	 
	 * @generated
	 */
	private Integer addetti;

	/**
	 * @generated
	 */
	public void setAddetti(Integer val) {

		addetti = val;

	}
	/**
	 * @generated
	 */
	public Integer getAddetti() {

		return addetti;

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
