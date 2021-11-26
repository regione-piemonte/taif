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
 * DTO specifico della query modellata nel finder intestazioneRiepilogo.
 * @generated
 */
public class TaifTAziendaIntestazioneRiepilogoDto implements Serializable {

	/*	 
	 * @generated
	 */
	private String ragioneSocialeAzienda;

	/**
	 * @generated
	 */
	public void setRagioneSocialeAzienda(String val) {

		ragioneSocialeAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getRagioneSocialeAzienda() {

		return ragioneSocialeAzienda;

	}

	/*	 
	 * @generated
	 */
	private String codiceFiscaleAzienda;

	/**
	 * @generated
	 */
	public void setCodiceFiscaleAzienda(String val) {

		codiceFiscaleAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getCodiceFiscaleAzienda() {

		return codiceFiscaleAzienda;

	}

	/*	 
	 * @generated
	 */
	private String pivaAzienda;

	/**
	 * @generated
	 */
	public void setPivaAzienda(String val) {

		pivaAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getPivaAzienda() {

		return pivaAzienda;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String statoPraticaItalia;

	/**
	 * @generated
	 */
	public void setStatoPraticaItalia(String val) {

		statoPraticaItalia = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPraticaItalia() {

		return statoPraticaItalia;

	}

	/*	 
	 * @generated
	 */
	private String statoPraticaFrance;

	/**
	 * @generated
	 */
	public void setStatoPraticaFrance(String val) {

		statoPraticaFrance = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPraticaFrance() {

		return statoPraticaFrance;

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
