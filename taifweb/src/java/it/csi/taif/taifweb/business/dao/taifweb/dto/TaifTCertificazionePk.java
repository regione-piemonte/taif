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
 * Primary Key del DTO TaifTCertificazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTCertificazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CERTIFICAZIONE
	 * @generated
	 */
	protected Integer idCertificazione;

	/**
	 * Imposta il valore della proprieta' idCertificazione associata alla
	 * colonna ID_CERTIFICAZIONE.
	 * @generated
	 */
	public void setIdCertificazione(Integer val) {

		idCertificazione = val;

	}

	/**
	 * Legge il valore della proprieta' idCertificazione associata alla
	 * @generated
	 */
	public Integer getIdCertificazione() {

		return idCertificazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTCertificazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTCertificazionePk(

			final Integer idCertificazione

	) {

		this.setIdCertificazione(idCertificazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTCertificazionePk sono equals se i valori di tutti i campi coincidono.
	 * 
	 * @param _other
	 * @return boolean se i due oggetti sono uguali
	 */
	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof TaifTCertificazionePk)) {
			return false;
		}

		final TaifTCertificazionePk _cast = (TaifTCertificazionePk) _other;

		if (idCertificazione == null
				? _cast.getIdCertificazione() != null
				: !idCertificazione.equals(_cast.getIdCertificazione())) {
			return false;
		}

		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode() {
		int _hashCode = 0;

		if (idCertificazione != null) {
			_hashCode = 29 * _hashCode + idCertificazione.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazionePk: ");
		ret.append("idCertificazione=" + idCertificazione);

		return ret.toString();
	}
}
