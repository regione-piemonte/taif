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
 * Data transfer object relativo al DAO TaifTCorsoDao.
 * @generated
 */
public class TaifTCorsoDto extends TaifTCorsoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_AGENZIA_FORMATIVA
	 * @generated
	 */
	protected Integer fkAgenziaFormativa;

	/**
	 * Imposta il valore della proprieta' fkAgenziaFormativa associata alla
	 * colonna FK_AGENZIA_FORMATIVA.
	 * @generated
	 */
	public void setFkAgenziaFormativa(Integer val) {

		fkAgenziaFormativa = val;

	}

	/**
	 * Legge il valore della proprieta' fkAgenziaFormativa associata alla
	 * @generated
	 */
	public Integer getFkAgenziaFormativa() {

		return fkAgenziaFormativa;

	}

	/**
	 * store della proprieta' associata alla colonna FK_UNITA_FORMATIVA
	 * @generated
	 */
	protected Integer fkUnitaFormativa;

	/**
	 * Imposta il valore della proprieta' fkUnitaFormativa associata alla
	 * colonna FK_UNITA_FORMATIVA.
	 * @generated
	 */
	public void setFkUnitaFormativa(Integer val) {

		fkUnitaFormativa = val;

	}

	/**
	 * Legge il valore della proprieta' fkUnitaFormativa associata alla
	 * @generated
	 */
	public Integer getFkUnitaFormativa() {

		return fkUnitaFormativa;

	}

	/**
	 * store della proprieta' associata alla colonna CORSO
	 * @generated
	 */
	protected String corso;

	/**
	 * Imposta il valore della proprieta' corso associata alla
	 * colonna CORSO.
	 * @generated
	 */
	public void setCorso(String val) {

		corso = val;

	}

	/**
	 * Legge il valore della proprieta' corso associata alla
	 * @generated
	 */
	public String getCorso() {

		return corso;

	}

	/**
	 * store della proprieta' associata alla colonna CODICE_PSR
	 * @generated
	 */
	protected java.math.BigDecimal codicePsr;

	/**
	 * Imposta il valore della proprieta' codicePsr associata alla
	 * colonna CODICE_PSR.
	 * @generated
	 */
	public void setCodicePsr(java.math.BigDecimal val) {

		codicePsr = val;

	}

	/**
	 * Legge il valore della proprieta' codicePsr associata alla
	 * @generated
	 */
	public java.math.BigDecimal getCodicePsr() {

		return codicePsr;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INIZIO
	 * @generated
	 */
	protected java.sql.Timestamp dataInizio;

	/**
	 * Imposta il valore della proprieta' dataInizio associata alla
	 * colonna DATA_INIZIO.
	 * @generated
	 */
	public void setDataInizio(java.sql.Timestamp val) {

		if (val != null) {
			dataInizio = new java.sql.Timestamp(val.getTime());
		} else {
			dataInizio = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInizio associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInizio() {

		if (dataInizio != null) {
			return new java.sql.Timestamp(dataInizio.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_FINE
	 * @generated
	 */
	protected java.sql.Timestamp dataFine;

	/**
	 * Imposta il valore della proprieta' dataFine associata alla
	 * colonna DATA_FINE.
	 * @generated
	 */
	public void setDataFine(java.sql.Timestamp val) {

		if (val != null) {
			dataFine = new java.sql.Timestamp(val.getTime());
		} else {
			dataFine = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFine associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataFine() {

		if (dataFine != null) {
			return new java.sql.Timestamp(dataFine.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna NRO_ORE
	 * @generated
	 */
	protected java.math.BigDecimal nroOre;

	/**
	 * Imposta il valore della proprieta' nroOre associata alla
	 * colonna NRO_ORE.
	 * @generated
	 */
	public void setNroOre(java.math.BigDecimal val) {

		nroOre = val;

	}

	/**
	 * Legge il valore della proprieta' nroOre associata alla
	 * @generated
	 */
	public java.math.BigDecimal getNroOre() {

		return nroOre;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_SEDE
	 * @generated
	 */
	protected String istatSede;

	/**
	 * Imposta il valore della proprieta' istatSede associata alla
	 * colonna ISTAT_SEDE.
	 * @generated
	 */
	public void setIstatSede(String val) {

		istatSede = val;

	}

	/**
	 * Legge il valore della proprieta' istatSede associata alla
	 * @generated
	 */
	public String getIstatSede() {

		return istatSede;

	}

	/**
	 * store della proprieta' associata alla colonna COMUNE_ESTERO_SEDE
	 * @generated
	 */
	protected String comuneEsteroSede;

	/**
	 * Imposta il valore della proprieta' comuneEsteroSede associata alla
	 * colonna COMUNE_ESTERO_SEDE.
	 * @generated
	 */
	public void setComuneEsteroSede(String val) {

		comuneEsteroSede = val;

	}

	/**
	 * Legge il valore della proprieta' comuneEsteroSede associata alla
	 * @generated
	 */
	public String getComuneEsteroSede() {

		return comuneEsteroSede;

	}

	/**
	 * store della proprieta' associata alla colonna INDIRIZZO
	 * @generated
	 */
	protected String indirizzo;

	/**
	 * Imposta il valore della proprieta' indirizzo associata alla
	 * colonna INDIRIZZO.
	 * @generated
	 */
	public void setIndirizzo(String val) {

		indirizzo = val;

	}

	/**
	 * Legge il valore della proprieta' indirizzo associata alla
	 * @generated
	 */
	public String getIndirizzo() {

		return indirizzo;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_ALTRO_CORSO
	 * @generated
	 */
	protected java.math.BigDecimal flgAltroCorso;

	/**
	 * Imposta il valore della proprieta' flgAltroCorso associata alla
	 * colonna FLG_ALTRO_CORSO.
	 * @generated
	 */
	public void setFlgAltroCorso(java.math.BigDecimal val) {

		flgAltroCorso = val;

	}

	/**
	 * Legge il valore della proprieta' flgAltroCorso associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgAltroCorso() {

		return flgAltroCorso;

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
	 * store della proprieta' associata alla colonna MTD_ORDINAMENTO
	 * @generated
	 */
	protected java.math.BigDecimal mtdOrdinamento;

	/**
	 * Imposta il valore della proprieta' mtdOrdinamento associata alla
	 * colonna MTD_ORDINAMENTO.
	 * @generated
	 */
	public void setMtdOrdinamento(java.math.BigDecimal val) {

		mtdOrdinamento = val;

	}

	/**
	 * Legge il valore della proprieta' mtdOrdinamento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdOrdinamento() {

		return mtdOrdinamento;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_FLG_VISIBILE
	 * @generated
	 */
	protected java.math.BigDecimal mtdFlgVisibile;

	/**
	 * Imposta il valore della proprieta' mtdFlgVisibile associata alla
	 * colonna MTD_FLG_VISIBILE.
	 * @generated
	 */
	public void setMtdFlgVisibile(java.math.BigDecimal val) {

		mtdFlgVisibile = val;

	}

	/**
	 * Legge il valore della proprieta' mtdFlgVisibile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdFlgVisibile() {

		return mtdFlgVisibile;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_FLG_ITA_FRA
	 * @generated
	 */
	protected String mtdFlgItaFra;

	/**
	 * Imposta il valore della proprieta' mtdFlgItaFra associata alla
	 * colonna MTD_FLG_ITA_FRA.
	 * @generated
	 */
	public void setMtdFlgItaFra(String val) {

		mtdFlgItaFra = val;

	}

	/**
	 * Legge il valore della proprieta' mtdFlgItaFra associata alla
	 * @generated
	 */
	public String getMtdFlgItaFra() {

		return mtdFlgItaFra;

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
	 * Crea una istanza di TaifTCorsoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTCorsoPk
	 * @generated
	 */
	public TaifTCorsoPk createPk() {
		return new TaifTCorsoPk(idCorso);
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
