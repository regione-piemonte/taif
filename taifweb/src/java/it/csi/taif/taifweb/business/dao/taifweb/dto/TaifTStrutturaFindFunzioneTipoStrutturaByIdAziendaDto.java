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
 * DTO specifico della query modellata nel finder findFunzioneTipoStrutturaByIdAzienda.
 * @generated
 */
public class TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idStruttura;

	/**
	 * @generated
	 */
	public void setIdStruttura(Integer val) {

		idStruttura = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdStruttura() {

		return idStruttura;

	}

	/*	 
	 * @generated
	 */
	private Integer dimensioneStruttura;

	/**
	 * @generated
	 */
	public void setDimensioneStruttura(Integer val) {

		dimensioneStruttura = val;

	}
	/**
	 * @generated
	 */
	public Integer getDimensioneStruttura() {

		return dimensioneStruttura;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal annoStruttura;

	/**
	 * @generated
	 */
	public void setAnnoStruttura(java.math.BigDecimal val) {

		annoStruttura = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAnnoStruttura() {

		return annoStruttura;

	}

	/*	 
	 * @generated
	 */
	private String tipoStruttura;

	/**
	 * @generated
	 */
	public void setTipoStruttura(String val) {

		tipoStruttura = val;

	}
	/**
	 * @generated
	 */
	public String getTipoStruttura() {

		return tipoStruttura;

	}

	/*	 
	 * @generated
	 */
	private String funzioneStruttura;

	/**
	 * @generated
	 */
	public void setFunzioneStruttura(String val) {

		funzioneStruttura = val;

	}
	/**
	 * @generated
	 */
	public String getFunzioneStruttura() {

		return funzioneStruttura;

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
