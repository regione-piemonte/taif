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
 * DTO specifico della query modellata nel finder findCertificazioniByIdAzienda.
 * @generated
 */
public class TaifTCertificazioneFindCertificazioniByIdAziendaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idCertificazione;

	/**
	 * @generated
	 */
	public void setIdCertificazione(Integer val) {

		idCertificazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdCertificazione() {

		return idCertificazione;

	}

	/*	 
	 * @generated
	 */
	private String numeroCertificazione;

	/**
	 * @generated
	 */
	public void setNumeroCertificazione(String val) {

		numeroCertificazione = val;

	}
	/**
	 * @generated
	 */
	public String getNumeroCertificazione() {

		return numeroCertificazione;

	}

	/*	 
	 * @generated
	 */
	private String enteCertificatore;

	/**
	 * @generated
	 */
	public void setEnteCertificatore(String val) {

		enteCertificatore = val;

	}
	/**
	 * @generated
	 */
	public String getEnteCertificatore() {

		return enteCertificatore;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal annoCertificazione;

	/**
	 * @generated
	 */
	public void setAnnoCertificazione(java.math.BigDecimal val) {

		annoCertificazione = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAnnoCertificazione() {

		return annoCertificazione;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataScadenza;

	/**
	 * @generated
	 */
	public void setDataScadenza(java.sql.Timestamp val) {

		if (val != null) {
			dataScadenza = new java.sql.Timestamp(val.getTime());
		} else {
			dataScadenza = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataScadenza() {

		if (dataScadenza != null) {
			return new java.sql.Timestamp(dataScadenza.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String altraCertificazione;

	/**
	 * @generated
	 */
	public void setAltraCertificazione(String val) {

		altraCertificazione = val;

	}
	/**
	 * @generated
	 */
	public String getAltraCertificazione() {

		return altraCertificazione;

	}

	/*	 
	 * @generated
	 */
	private String tipoCertificazione;

	/**
	 * @generated
	 */
	public void setTipoCertificazione(String val) {

		tipoCertificazione = val;

	}
	/**
	 * @generated
	 */
	public String getTipoCertificazione() {

		return tipoCertificazione;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoCertificazione;

	/**
	 * @generated
	 */
	public void setIdTipoCertificazione(Integer val) {

		idTipoCertificazione = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoCertificazione() {

		return idTipoCertificazione;

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
