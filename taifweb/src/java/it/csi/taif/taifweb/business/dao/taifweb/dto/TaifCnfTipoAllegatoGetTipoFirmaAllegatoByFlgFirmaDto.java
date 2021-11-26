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
 * DTO specifico della query modellata nel finder getTipoFirmaAllegatoByFlgFirma.
 * @generated
 */
public class TaifCnfTipoAllegatoGetTipoFirmaAllegatoByFlgFirmaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idTipoAllegato;

	/**
	 * @generated
	 */
	public void setIdTipoAllegato(Integer val) {

		idTipoAllegato = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoAllegato() {

		return idTipoAllegato;

	}

	/*	 
	 * @generated
	 */
	private Integer idProcedura;

	/**
	 * @generated
	 */
	public void setIdProcedura(Integer val) {

		idProcedura = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdProcedura() {

		return idProcedura;

	}

	/*	 
	 * @generated
	 */
	private String tipoAllegato;

	/**
	 * @generated
	 */
	public void setTipoAllegato(String val) {

		tipoAllegato = val;

	}
	/**
	 * @generated
	 */
	public String getTipoAllegato() {

		return tipoAllegato;

	}

	/*	 
	 * @generated
	 */
	private String flagFirma;

	/**
	 * @generated
	 */
	public void setFlagFirma(String val) {

		flagFirma = val;

	}
	/**
	 * @generated
	 */
	public String getFlagFirma() {

		return flagFirma;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flagDownload;

	/**
	 * @generated
	 */
	public void setFlagDownload(java.math.BigDecimal val) {

		flagDownload = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagDownload() {

		return flagDownload;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flagUpload;

	/**
	 * @generated
	 */
	public void setFlagUpload(java.math.BigDecimal val) {

		flagUpload = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagUpload() {

		return flagUpload;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flagInvio;

	/**
	 * @generated
	 */
	public void setFlagInvio(java.math.BigDecimal val) {

		flagInvio = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagInvio() {

		return flagInvio;

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
