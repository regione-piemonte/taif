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
 * Primary Key del DTO TaifDNazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDNazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_NAZIONE
	 * @generated
	 */
	protected Integer idNazione;

	/**
	 * Imposta il valore della proprieta' idNazione associata alla
	 * colonna ID_NAZIONE.
	 * @generated
	 */
	public void setIdNazione(Integer val) {

		idNazione = val;

	}

	/**
	 * Legge il valore della proprieta' idNazione associata alla
	 * @generated
	 */
	public Integer getIdNazione() {

		return idNazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDNazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDNazionePk(

			final Integer idNazione

	) {

		this.setIdNazione(idNazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDNazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDNazionePk)) {
			return false;
		}

		final TaifDNazionePk _cast = (TaifDNazionePk) _other;

		if (idNazione == null ? _cast.getIdNazione() != null : !idNazione.equals(_cast.getIdNazione())) {
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

		if (idNazione != null) {
			_hashCode = 29 * _hashCode + idNazione.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifDNazionePk: ");
		ret.append("idNazione=" + idNazione);

		return ret.toString();
	}
}
