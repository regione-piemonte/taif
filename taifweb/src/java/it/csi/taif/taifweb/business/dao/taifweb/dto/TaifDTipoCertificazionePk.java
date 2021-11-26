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
 * Primary Key del DTO TaifDTipoCertificazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoCertificazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CERTIFICAZIONE
	 * @generated
	 */
	protected Integer idTipoCertificazione;

	/**
	 * Imposta il valore della proprieta' idTipoCertificazione associata alla
	 * colonna ID_TIPO_CERTIFICAZIONE.
	 * @generated
	 */
	public void setIdTipoCertificazione(Integer val) {

		idTipoCertificazione = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoCertificazione associata alla
	 * @generated
	 */
	public Integer getIdTipoCertificazione() {

		return idTipoCertificazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoCertificazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoCertificazionePk(

			final Integer idTipoCertificazione

	) {

		this.setIdTipoCertificazione(idTipoCertificazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoCertificazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoCertificazionePk)) {
			return false;
		}

		final TaifDTipoCertificazionePk _cast = (TaifDTipoCertificazionePk) _other;

		if (idTipoCertificazione == null
				? _cast.getIdTipoCertificazione() != null
				: !idTipoCertificazione.equals(_cast.getIdTipoCertificazione())) {
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

		if (idTipoCertificazione != null) {
			_hashCode = 29 * _hashCode + idTipoCertificazione.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoCertificazionePk: ");
		ret.append("idTipoCertificazione=" + idTipoCertificazione);

		return ret.toString();
	}
}
