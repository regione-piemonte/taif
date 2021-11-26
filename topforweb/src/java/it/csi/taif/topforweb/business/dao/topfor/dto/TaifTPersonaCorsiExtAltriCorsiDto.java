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
 * DTO specifico della query modellata nel finder altriCorsi.
 * @generated
 */
public class TaifTPersonaCorsiExtAltriCorsiDto implements Serializable {
	
	/*	 
	 * @generated
	 */
	private String idCorso;

	/**
	 * @generated
	 */
	public void setIdCorso(String val) {

		idCorso = val;

	}
	
	/**
	 * @generated
	 */
	public String getIdCorso() {

		return idCorso;

	}
	
	
	/*	 
	 * @generated
	 */
	private String titoloCorso;

	/**
	 * @generated
	 */
	public void setTitoloCorso(String val) {

		titoloCorso = val;

	}
	/**
	 * @generated
	 */
	public String getTitoloCorso() {

		return titoloCorso;

	}

	/*	 
	 * @generated
	 */
	private String descrizioneAltroCorso;

	/**
	 * @generated
	 */
	public void setDescrizioneAltroCorso(String val) {

		descrizioneAltroCorso = val;

	}
	/**
	 * @generated
	 */
	public String getDescrizioneAltroCorso() {

		return descrizioneAltroCorso;

	}

	/*	 
	 * @generated
	 */
	private String idAllegato;

	/**
	 * @generated
	 */
	public void setIdAllegato(String val) {

		idAllegato = val;

	}
	/**
	 * @generated
	 */
	public String getIdAllegato() {

		return idAllegato;

	}

	/*	 
	 * @generated
	 */
	private String attestatoConScadenza;

	/**
	 * @generated
	 */
	public void setAttestatoConScadenza(String val) {

		attestatoConScadenza = val;

	}
	/**
	 * @generated
	 */
	public String getAttestatoConScadenza() {

		return attestatoConScadenza;

	}
	
	/*	 
	 * @generated
	 */
	private String dsEsitoCorso;

	/**
	 * @generated
	 */
	public void setDsEsitoCorso(String val) {

		dsEsitoCorso = val;

	}
	/**
	 * @generated
	 */
	public String getDsEsitoCorso() {

		return dsEsitoCorso;

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
