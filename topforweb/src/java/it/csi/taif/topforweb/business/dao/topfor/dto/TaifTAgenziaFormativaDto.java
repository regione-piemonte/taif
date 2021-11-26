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
 * Data transfer object relativo al DAO TaifTAgenziaFormativaDao.
 * @generated
 */
public class TaifTAgenziaFormativaDto extends TaifTAgenziaFormativaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna CODICE_FISCALE
	 * @generated
	 */
	protected String codiceFiscale;

	/**
	 * Imposta il valore della proprieta' codiceFiscale associata alla
	 * colonna CODICE_FISCALE.
	 * @generated
	 */
	public void setCodiceFiscale(String val) {

		codiceFiscale = val;

	}

	/**
	 * Legge il valore della proprieta' codiceFiscale associata alla
	 * @generated
	 */
	public String getCodiceFiscale() {

		return codiceFiscale;

	}

	/**
	 * store della proprieta' associata alla colonna PARTITA_IVA
	 * @generated
	 */
	protected String partitaIva;

	/**
	 * Imposta il valore della proprieta' partitaIva associata alla
	 * colonna PARTITA_IVA.
	 * @generated
	 */
	public void setPartitaIva(String val) {

		partitaIva = val;

	}

	/**
	 * Legge il valore della proprieta' partitaIva associata alla
	 * @generated
	 */
	public String getPartitaIva() {

		return partitaIva;

	}

	/**
	 * store della proprieta' associata alla colonna RAGIONE_SOCIALE
	 * @generated
	 */
	protected String ragioneSociale;

	/**
	 * Imposta il valore della proprieta' ragioneSociale associata alla
	 * colonna RAGIONE_SOCIALE.
	 * @generated
	 */
	public void setRagioneSociale(String val) {

		ragioneSociale = val;

	}

	/**
	 * Legge il valore della proprieta' ragioneSociale associata alla
	 * @generated
	 */
	public String getRagioneSociale() {

		return ragioneSociale;

	}

	/**
	 * store della proprieta' associata alla colonna CODICE_PSR
	 * @generated
	 */
	protected String codicePsr;

	/**
	 * Imposta il valore della proprieta' codicePsr associata alla
	 * colonna CODICE_PSR.
	 * @generated
	 */
	public void setCodicePsr(String val) {

		codicePsr = val;

	}

	/**
	 * Legge il valore della proprieta' codicePsr associata alla
	 * @generated
	 */
	public String getCodicePsr() {

		return codicePsr;

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
	 * store della proprieta' associata alla colonna COMUNE_ESTERO
	 * @generated
	 */
	protected String comuneEstero;

	/**
	 * Imposta il valore della proprieta' comuneEstero associata alla
	 * colonna COMUNE_ESTERO.
	 * @generated
	 */
	public void setComuneEstero(String val) {

		comuneEstero = val;

	}

	/**
	 * Legge il valore della proprieta' comuneEstero associata alla
	 * @generated
	 */
	public String getComuneEstero() {

		return comuneEstero;

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
	 * store della proprieta' associata alla colonna CAP
	 * @generated
	 */
	protected String cap;

	/**
	 * Imposta il valore della proprieta' cap associata alla
	 * colonna CAP.
	 * @generated
	 */
	public void setCap(String val) {

		cap = val;

	}

	/**
	 * Legge il valore della proprieta' cap associata alla
	 * @generated
	 */
	public String getCap() {

		return cap;

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
	 * store della proprieta' associata alla colonna FLG_VISIBILE
	 * @generated
	 */
	protected java.math.BigDecimal flgVisibile;

	/**
	 * Imposta il valore della proprieta' flgVisibile associata alla
	 * colonna FLG_VISIBILE.
	 * @generated
	 */
	public void setFlgVisibile(java.math.BigDecimal val) {

		flgVisibile = val;

	}

	/**
	 * Legge il valore della proprieta' flgVisibile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgVisibile() {

		return flgVisibile;

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
	 * Crea una istanza di TaifTAgenziaFormativaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTAgenziaFormativaPk
	 * @generated
	 */
	public TaifTAgenziaFormativaPk createPk() {
		return new TaifTAgenziaFormativaPk(idAgenziaFormativa);
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
