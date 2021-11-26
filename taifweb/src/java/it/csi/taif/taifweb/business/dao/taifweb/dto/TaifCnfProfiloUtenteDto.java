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
 * Data transfer object relativo al DAO TaifCnfProfiloUtenteDao.
 * @generated
 */
public class TaifCnfProfiloUtenteDto extends TaifCnfProfiloUtentePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna PROFILO_UTENTE
	 * @generated
	 */
	protected String profiloUtente;

	/**
	 * Imposta il valore della proprieta' profiloUtente associata alla
	 * colonna PROFILO_UTENTE.
	 * @generated
	 */
	public void setProfiloUtente(String val) {

		profiloUtente = val;

	}

	/**
	 * Legge il valore della proprieta' profiloUtente associata alla
	 * @generated
	 */
	public String getProfiloUtente() {

		return profiloUtente;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_FLG_ATTIVO
	 * @generated
	 */
	protected java.math.BigDecimal mtdFlgAttivo;

	/**
	 * Imposta il valore della proprieta' mtdFlgAttivo associata alla
	 * colonna MTD_FLG_ATTIVO.
	 * @generated
	 */
	public void setMtdFlgAttivo(java.math.BigDecimal val) {

		mtdFlgAttivo = val;

	}

	/**
	 * Legge il valore della proprieta' mtdFlgAttivo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdFlgAttivo() {

		return mtdFlgAttivo;

	}

	/**
	 * store della proprieta' associata alla colonna FK_PROCEDURA
	 * @generated
	 */
	protected Integer fkProcedura;

	/**
	 * Imposta il valore della proprieta' fkProcedura associata alla
	 * colonna FK_PROCEDURA.
	 * @generated
	 */
	public void setFkProcedura(Integer val) {

		fkProcedura = val;

	}

	/**
	 * Legge il valore della proprieta' fkProcedura associata alla
	 * @generated
	 */
	public Integer getFkProcedura() {

		return fkProcedura;

	}

	/**
	 * Crea una istanza di TaifCnfProfiloUtentePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifCnfProfiloUtentePk
	 * @generated
	 */
	public TaifCnfProfiloUtentePk createPk() {
		return new TaifCnfProfiloUtentePk(idProfiloUtente);
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
