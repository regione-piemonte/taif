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
 * Data transfer object relativo al DAO TaifTAttivitaSvoltaDettDao.
 * @generated
 */
public class TaifTAttivitaSvoltaDettDto extends TaifTAttivitaSvoltaDettPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_UNITA_DI_MISURA
	 * @generated
	 */
	protected Integer fkUnitaDiMisura;

	/**
	 * Imposta il valore della proprieta' fkUnitaDiMisura associata alla
	 * colonna FK_UNITA_DI_MISURA.
	 * @generated
	 */
	public void setFkUnitaDiMisura(Integer val) {

		fkUnitaDiMisura = val;

	}

	/**
	 * Legge il valore della proprieta' fkUnitaDiMisura associata alla
	 * @generated
	 */
	public Integer getFkUnitaDiMisura() {

		return fkUnitaDiMisura;

	}

	/**
	 * store della proprieta' associata alla colonna VALORE1
	 * @generated
	 */
	protected java.math.BigDecimal valore1;

	/**
	 * Imposta il valore della proprieta' valore1 associata alla
	 * colonna VALORE1.
	 * @generated
	 */
	public void setValore1(java.math.BigDecimal val) {

		valore1 = val;

	}

	/**
	 * Legge il valore della proprieta' valore1 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getValore1() {

		return valore1;

	}

	/**
	 * store della proprieta' associata alla colonna VALORE2
	 * @generated
	 */
	protected java.math.BigDecimal valore2;

	/**
	 * Imposta il valore della proprieta' valore2 associata alla
	 * colonna VALORE2.
	 * @generated
	 */
	public void setValore2(java.math.BigDecimal val) {

		valore2 = val;

	}

	/**
	 * Legge il valore della proprieta' valore2 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getValore2() {

		return valore2;

	}

	/**
	 * store della proprieta' associata alla colonna VALORE3
	 * @generated
	 */
	protected java.math.BigDecimal valore3;

	/**
	 * Imposta il valore della proprieta' valore3 associata alla
	 * colonna VALORE3.
	 * @generated
	 */
	public void setValore3(java.math.BigDecimal val) {

		valore3 = val;

	}

	/**
	 * Legge il valore della proprieta' valore3 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getValore3() {

		return valore3;

	}

	/**
	 * store della proprieta' associata alla colonna PERC_CONTO_TERZI
	 * @generated
	 */
	protected java.math.BigDecimal percContoTerzi;

	/**
	 * Imposta il valore della proprieta' percContoTerzi associata alla
	 * colonna PERC_CONTO_TERZI.
	 * @generated
	 */
	public void setPercContoTerzi(java.math.BigDecimal val) {

		percContoTerzi = val;

	}

	/**
	 * Legge il valore della proprieta' percContoTerzi associata alla
	 * @generated
	 */
	public java.math.BigDecimal getPercContoTerzi() {

		return percContoTerzi;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INSERIMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataInserimento;

	/**
	 * Imposta il valore della proprieta' dataInserimento associata alla
	 * colonna DATA_INSERIMENTO.
	 * @generated
	 */
	public void setDataInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInserimento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimento() {

		if (dataInserimento != null) {
			return new java.sql.Timestamp(dataInserimento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_AGGIORNAMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataAggiornamento;

	/**
	 * Imposta il valore della proprieta' dataAggiornamento associata alla
	 * colonna DATA_AGGIORNAMENTO.
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
	 * Legge il valore della proprieta' dataAggiornamento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FK_CONFIG_UTENTE
	 * @generated
	 */
	protected Integer fkConfigUtente;

	/**
	 * Imposta il valore della proprieta' fkConfigUtente associata alla
	 * colonna FK_CONFIG_UTENTE.
	 * @generated
	 */
	public void setFkConfigUtente(Integer val) {

		fkConfigUtente = val;

	}

	/**
	 * Legge il valore della proprieta' fkConfigUtente associata alla
	 * @generated
	 */
	public Integer getFkConfigUtente() {

		return fkConfigUtente;

	}

	/**
	 * Crea una istanza di TaifTAttivitaSvoltaDettPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTAttivitaSvoltaDettPk
	 * @generated
	 */
	public TaifTAttivitaSvoltaDettPk createPk() {
		return new TaifTAttivitaSvoltaDettPk(idAttivita, progressivo);
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
