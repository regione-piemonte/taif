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
 * Primary Key del DTO TaifTCommercializzazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTCommercializzazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_COMMERCIALIZZAZIONE
	 * @generated
	 */
	protected Integer idCommercializzazione;

	/**
	 * Imposta il valore della proprieta' idCommercializzazione associata alla
	 * colonna ID_COMMERCIALIZZAZIONE.
	 * @generated
	 */
	public void setIdCommercializzazione(Integer val) {

		idCommercializzazione = val;

	}

	/**
	 * Legge il valore della proprieta' idCommercializzazione associata alla
	 * @generated
	 */
	public Integer getIdCommercializzazione() {

		return idCommercializzazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTCommercializzazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTCommercializzazionePk(

			final Integer idCommercializzazione

	) {

		this.setIdCommercializzazione(idCommercializzazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTCommercializzazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTCommercializzazionePk)) {
			return false;
		}

		final TaifTCommercializzazionePk _cast = (TaifTCommercializzazionePk) _other;

		if (idCommercializzazione == null
				? _cast.getIdCommercializzazione() != null
				: !idCommercializzazione.equals(_cast.getIdCommercializzazione())) {
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

		if (idCommercializzazione != null) {
			_hashCode = 29 * _hashCode + idCommercializzazione.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCommercializzazionePk: ");
		ret.append("idCommercializzazione=" + idCommercializzazione);

		return ret.toString();
	}
}
