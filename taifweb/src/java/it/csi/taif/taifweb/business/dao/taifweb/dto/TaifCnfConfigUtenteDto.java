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
 * Data transfer object relativo al DAO TaifCnfConfigUtenteDao.
 * @generated
 */
public class TaifCnfConfigUtenteDto extends TaifCnfConfigUtentePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_PROFILO_UTENTE
	 * @generated
	 */
	protected Integer fkProfiloUtente;

	/**
	 * Imposta il valore della proprieta' fkProfiloUtente associata alla
	 * colonna FK_PROFILO_UTENTE.
	 * @generated
	 */
	public void setFkProfiloUtente(Integer val) {

		fkProfiloUtente = val;

	}

	/**
	 * Legge il valore della proprieta' fkProfiloUtente associata alla
	 * @generated
	 */
	public Integer getFkProfiloUtente() {

		return fkProfiloUtente;

	}

	/**
	 * store della proprieta' associata alla colonna FK_PERSONA
	 * @generated
	 */
	protected Integer fkPersona;

	/**
	 * Imposta il valore della proprieta' fkPersona associata alla
	 * colonna FK_PERSONA.
	 * @generated
	 */
	public void setFkPersona(Integer val) {

		fkPersona = val;

	}

	/**
	 * Legge il valore della proprieta' fkPersona associata alla
	 * @generated
	 */
	public Integer getFkPersona() {

		return fkPersona;

	}

	/**
	 * store della proprieta' associata alla colonna FK_SOGGETTO_GESTORE
	 * @generated
	 */
	protected Integer fkSoggettoGestore;

	/**
	 * Imposta il valore della proprieta' fkSoggettoGestore associata alla
	 * colonna FK_SOGGETTO_GESTORE.
	 * @generated
	 */
	public void setFkSoggettoGestore(Integer val) {

		fkSoggettoGestore = val;

	}

	/**
	 * Legge il valore della proprieta' fkSoggettoGestore associata alla
	 * @generated
	 */
	public Integer getFkSoggettoGestore() {

		return fkSoggettoGestore;

	}

	/**
	 * store della proprieta' associata alla colonna NR_ACCESSI
	 * @generated
	 */
	protected Integer nrAccessi;

	/**
	 * Imposta il valore della proprieta' nrAccessi associata alla
	 * colonna NR_ACCESSI.
	 * @generated
	 */
	public void setNrAccessi(Integer val) {

		nrAccessi = val;

	}

	/**
	 * Legge il valore della proprieta' nrAccessi associata alla
	 * @generated
	 */
	public Integer getNrAccessi() {

		return nrAccessi;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_PRIMO_ACCESSO
	 * @generated
	 */
	protected java.sql.Timestamp dataPrimoAccesso;

	/**
	 * Imposta il valore della proprieta' dataPrimoAccesso associata alla
	 * colonna DATA_PRIMO_ACCESSO.
	 * @generated
	 */
	public void setDataPrimoAccesso(java.sql.Timestamp val) {

		if (val != null) {
			dataPrimoAccesso = new java.sql.Timestamp(val.getTime());
		} else {
			dataPrimoAccesso = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataPrimoAccesso associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataPrimoAccesso() {

		if (dataPrimoAccesso != null) {
			return new java.sql.Timestamp(dataPrimoAccesso.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ULTIMO_ACCESSO
	 * @generated
	 */
	protected java.sql.Timestamp dataUltimoAccesso;

	/**
	 * Imposta il valore della proprieta' dataUltimoAccesso associata alla
	 * colonna DATA_ULTIMO_ACCESSO.
	 * @generated
	 */
	public void setDataUltimoAccesso(java.sql.Timestamp val) {

		if (val != null) {
			dataUltimoAccesso = new java.sql.Timestamp(val.getTime());
		} else {
			dataUltimoAccesso = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUltimoAccesso associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataUltimoAccesso() {

		if (dataUltimoAccesso != null) {
			return new java.sql.Timestamp(dataUltimoAccesso.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Crea una istanza di TaifCnfConfigUtentePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifCnfConfigUtentePk
	 * @generated
	 */
	public TaifCnfConfigUtentePk createPk() {
		return new TaifCnfConfigUtentePk(idConfigUtente);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
