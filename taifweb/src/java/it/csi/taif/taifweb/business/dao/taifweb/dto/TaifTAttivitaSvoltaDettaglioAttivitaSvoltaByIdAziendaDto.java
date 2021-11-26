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
 * DTO specifico della query modellata nel finder dettaglioAttivitaSvoltaByIdAzienda.
 * @generated
 */
public class TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private String tipoAttivita;

	/**
	 * @generated
	 */
	public void setTipoAttivita(String val) {

		tipoAttivita = val;

	}
	/**
	 * @generated
	 */
	public String getTipoAttivita() {

		return tipoAttivita;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal fatturato;

	/**
	 * @generated
	 */
	public void setFatturato(java.math.BigDecimal val) {

		fatturato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFatturato() {

		return fatturato;

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
