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
 * DTO specifico della query modellata nel finder byNazioneFraVisible.
 * @generated
 */
public class TaifDNazioneByNazioneFraVisibleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idNazione;

	/**
	 * @generated
	 */
	public void setIdNazione(Integer val) {

		idNazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdNazione() {

		return idNazione;

	}

	/*	 
	 * @generated
	 */
	private String dsNazioneFra;

	/**
	 * @generated
	 */
	public void setDsNazioneFra(String val) {

		dsNazioneFra = val;

	}
	/**
	 * @generated
	 */
	public String getDsNazioneFra() {

		return dsNazioneFra;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ordinamentoFra;

	/**
	 * @generated
	 */
	public void setOrdinamentoFra(java.math.BigDecimal val) {

		ordinamentoFra = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getOrdinamentoFra() {

		return ordinamentoFra;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flgVisible;

	/**
	 * @generated
	 */
	public void setFlgVisible(java.math.BigDecimal val) {

		flgVisible = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlgVisible() {

		return flgVisible;

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
