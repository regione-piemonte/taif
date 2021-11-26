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
 * DTO specifico della query modellata nel finder dettaglioMezzoByIdAzienda.
 * @generated
 */
public class TaifTMezzoDettaglioMezzoByIdAziendaDto implements Serializable {

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

	/**	 
	* @generated
	*/
	private Long conteggio;

	/**
	* @generated
	*/
	public void setConteggio(Long val) {

		conteggio = val;

	}
	/**
	* @generated
	*/
	public Long getConteggio() {

		return conteggio;

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
