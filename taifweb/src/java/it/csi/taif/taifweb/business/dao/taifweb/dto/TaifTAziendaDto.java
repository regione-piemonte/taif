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
 * Data transfer object relativo al DAO TaifTAziendaDao.
 * @generated
 */
public class TaifTAziendaDto extends TaifTAziendaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_ATTIVITA_PRIMARIA
	 * @generated
	 */
	protected Integer fkAttivitaPrimaria;

	/**
	 * Imposta il valore della proprieta' fkAttivitaPrimaria associata alla
	 * colonna FK_ATTIVITA_PRIMARIA.
	 * @generated
	 */
	public void setFkAttivitaPrimaria(Integer val) {

		fkAttivitaPrimaria = val;

	}

	/**
	 * Legge il valore della proprieta' fkAttivitaPrimaria associata alla
	 * @generated
	 */
	public Integer getFkAttivitaPrimaria() {

		return fkAttivitaPrimaria;

	}

	/**
	 * store della proprieta' associata alla colonna FK_ATTIVITA_SECONDARIA
	 * @generated
	 */
	protected Integer fkAttivitaSecondaria;

	/**
	 * Imposta il valore della proprieta' fkAttivitaSecondaria associata alla
	 * colonna FK_ATTIVITA_SECONDARIA.
	 * @generated
	 */
	public void setFkAttivitaSecondaria(Integer val) {

		fkAttivitaSecondaria = val;

	}

	/**
	 * Legge il valore della proprieta' fkAttivitaSecondaria associata alla
	 * @generated
	 */
	public Integer getFkAttivitaSecondaria() {

		return fkAttivitaSecondaria;

	}

	/**
	 * store della proprieta' associata alla colonna FK_ATTIVITA_APE
	 * @generated
	 */
	protected Integer fkAttivitaApe;

	/**
	 * Imposta il valore della proprieta' fkAttivitaApe associata alla
	 * colonna FK_ATTIVITA_APE.
	 * @generated
	 */
	public void setFkAttivitaApe(Integer val) {

		fkAttivitaApe = val;

	}

	/**
	 * Legge il valore della proprieta' fkAttivitaApe associata alla
	 * @generated
	 */
	public Integer getFkAttivitaApe() {

		return fkAttivitaApe;

	}

	/**
	 * store della proprieta' associata alla colonna FK_FORMA_GIURIDICA_ITA
	 * @generated
	 */
	protected Integer fkFormaGiuridicaIta;

	/**
	 * Imposta il valore della proprieta' fkFormaGiuridicaIta associata alla
	 * colonna FK_FORMA_GIURIDICA_ITA.
	 * @generated
	 */
	public void setFkFormaGiuridicaIta(Integer val) {

		fkFormaGiuridicaIta = val;

	}

	/**
	 * Legge il valore della proprieta' fkFormaGiuridicaIta associata alla
	 * @generated
	 */
	public Integer getFkFormaGiuridicaIta() {

		return fkFormaGiuridicaIta;

	}

	/**
	 * store della proprieta' associata alla colonna FK_FORMA_GIURIDICA_FRA
	 * @generated
	 */
	protected Integer fkFormaGiuridicaFra;

	/**
	 * Imposta il valore della proprieta' fkFormaGiuridicaFra associata alla
	 * colonna FK_FORMA_GIURIDICA_FRA.
	 * @generated
	 */
	public void setFkFormaGiuridicaFra(Integer val) {

		fkFormaGiuridicaFra = val;

	}

	/**
	 * Legge il valore della proprieta' fkFormaGiuridicaFra associata alla
	 * @generated
	 */
	public Integer getFkFormaGiuridicaFra() {

		return fkFormaGiuridicaFra;

	}

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
	 * store della proprieta' associata alla colonna N_SIRET
	 * @generated
	 */
	protected String nSiret;

	/**
	 * Imposta il valore della proprieta' nSiret associata alla
	 * colonna N_SIRET.
	 * @generated
	 */
	public void setNSiret(String val) {

		nSiret = val;

	}

	/**
	 * Legge il valore della proprieta' nSiret associata alla
	 * @generated
	 */
	public String getNSiret() {

		return nSiret;

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
	 * store della proprieta' associata alla colonna N_TVA
	 * @generated
	 */
	protected String nTva;

	/**
	 * Imposta il valore della proprieta' nTva associata alla
	 * colonna N_TVA.
	 * @generated
	 */
	public void setNTva(String val) {

		nTva = val;

	}

	/**
	 * Legge il valore della proprieta' nTva associata alla
	 * @generated
	 */
	public String getNTva() {

		return nTva;

	}

	/**
	 * store della proprieta' associata alla colonna CCIAA_NUMERO
	 * @generated
	 */
	protected String cciaaNumero;

	/**
	 * Imposta il valore della proprieta' cciaaNumero associata alla
	 * colonna CCIAA_NUMERO.
	 * @generated
	 */
	public void setCciaaNumero(String val) {

		cciaaNumero = val;

	}

	/**
	 * Legge il valore della proprieta' cciaaNumero associata alla
	 * @generated
	 */
	public String getCciaaNumero() {

		return cciaaNumero;

	}

	/**
	 * store della proprieta' associata alla colonna CCIAA_SIGLA_PROV
	 * @generated
	 */
	protected String cciaaSiglaProv;

	/**
	 * Imposta il valore della proprieta' cciaaSiglaProv associata alla
	 * colonna CCIAA_SIGLA_PROV.
	 * @generated
	 */
	public void setCciaaSiglaProv(String val) {

		cciaaSiglaProv = val;

	}

	/**
	 * Legge il valore della proprieta' cciaaSiglaProv associata alla
	 * @generated
	 */
	public String getCciaaSiglaProv() {

		return cciaaSiglaProv;

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
	 * store della proprieta' associata alla colonna N_MARCA_BOLLO
	 * @generated
	 */
	protected String nMarcaBollo;

	/**
	 * Imposta il valore della proprieta' nMarcaBollo associata alla
	 * colonna N_MARCA_BOLLO.
	 * @generated
	 */
	public void setNMarcaBollo(String val) {

		nMarcaBollo = val;

	}

	/**
	 * Legge il valore della proprieta' nMarcaBollo associata alla
	 * @generated
	 */
	public String getNMarcaBollo() {

		return nMarcaBollo;

	}

	/**
	 * store della proprieta' associata alla colonna DESCR_ALTRA_FORMA_GIURIDICA
	 * @generated
	 */
	protected String descrAltraFormaGiuridica;

	/**
	 * Imposta il valore della proprieta' descrAltraFormaGiuridica associata alla
	 * colonna DESCR_ALTRA_FORMA_GIURIDICA.
	 * @generated
	 */
	public void setDescrAltraFormaGiuridica(String val) {

		descrAltraFormaGiuridica = val;

	}

	/**
	 * Legge il valore della proprieta' descrAltraFormaGiuridica associata alla
	 * @generated
	 */
	public String getDescrAltraFormaGiuridica() {

		return descrAltraFormaGiuridica;

	}

	/**
	 * store della proprieta' associata alla colonna EMAIL
	 * @generated
	 */
	protected String email;

	/**
	 * Imposta il valore della proprieta' email associata alla
	 * colonna EMAIL.
	 * @generated
	 */
	public void setEmail(String val) {

		email = val;

	}

	/**
	 * Legge il valore della proprieta' email associata alla
	 * @generated
	 */
	public String getEmail() {

		return email;

	}

	/**
	 * store della proprieta' associata alla colonna PEC
	 * @generated
	 */
	protected String pec;

	/**
	 * Imposta il valore della proprieta' pec associata alla
	 * colonna PEC.
	 * @generated
	 */
	public void setPec(String val) {

		pec = val;

	}

	/**
	 * Legge il valore della proprieta' pec associata alla
	 * @generated
	 */
	public String getPec() {

		return pec;

	}

	/**
	 * store della proprieta' associata alla colonna SITO_WEB
	 * @generated
	 */
	protected String sitoWeb;

	/**
	 * Imposta il valore della proprieta' sitoWeb associata alla
	 * colonna SITO_WEB.
	 * @generated
	 */
	public void setSitoWeb(String val) {

		sitoWeb = val;

	}

	/**
	 * Legge il valore della proprieta' sitoWeb associata alla
	 * @generated
	 */
	public String getSitoWeb() {

		return sitoWeb;

	}

	/**
	 * store della proprieta' associata alla colonna ANNO_INIZIO
	 * @generated
	 */
	protected java.math.BigDecimal annoInizio;

	/**
	 * Imposta il valore della proprieta' annoInizio associata alla
	 * colonna ANNO_INIZIO.
	 * @generated
	 */
	public void setAnnoInizio(java.math.BigDecimal val) {

		annoInizio = val;

	}

	/**
	 * Legge il valore della proprieta' annoInizio associata alla
	 * @generated
	 */
	public java.math.BigDecimal getAnnoInizio() {

		return annoInizio;

	}

	/**
	 * store della proprieta' associata alla colonna FATTURATO
	 * @generated
	 */
	protected java.math.BigDecimal fatturato;

	/**
	 * Imposta il valore della proprieta' fatturato associata alla
	 * colonna FATTURATO.
	 * @generated
	 */
	public void setFatturato(java.math.BigDecimal val) {

		fatturato = val;

	}

	/**
	 * Legge il valore della proprieta' fatturato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFatturato() {

		return fatturato;

	}

	/**
	 * store della proprieta' associata alla colonna PERC_COMMERCIO_FRA
	 * @generated
	 */
	protected java.math.BigDecimal percCommercioFra;

	/**
	 * Imposta il valore della proprieta' percCommercioFra associata alla
	 * colonna PERC_COMMERCIO_FRA.
	 * @generated
	 */
	public void setPercCommercioFra(java.math.BigDecimal val) {

		percCommercioFra = val;

	}

	/**
	 * Legge il valore della proprieta' percCommercioFra associata alla
	 * @generated
	 */
	public java.math.BigDecimal getPercCommercioFra() {

		return percCommercioFra;

	}

	/**
	 * store della proprieta' associata alla colonna CLIENT1_FRA
	 * @generated
	 */
	protected String client1Fra;

	/**
	 * Imposta il valore della proprieta' client1Fra associata alla
	 * colonna CLIENT1_FRA.
	 * @generated
	 */
	public void setClient1Fra(String val) {

		client1Fra = val;

	}

	/**
	 * Legge il valore della proprieta' client1Fra associata alla
	 * @generated
	 */
	public String getClient1Fra() {

		return client1Fra;

	}

	/**
	 * store della proprieta' associata alla colonna CLIENT2_FRA
	 * @generated
	 */
	protected String client2Fra;

	/**
	 * Imposta il valore della proprieta' client2Fra associata alla
	 * colonna CLIENT2_FRA.
	 * @generated
	 */
	public void setClient2Fra(String val) {

		client2Fra = val;

	}

	/**
	 * Legge il valore della proprieta' client2Fra associata alla
	 * @generated
	 */
	public String getClient2Fra() {

		return client2Fra;

	}

	/**
	 * store della proprieta' associata alla colonna CLIENT3_FRA
	 * @generated
	 */
	protected String client3Fra;

	/**
	 * Imposta il valore della proprieta' client3Fra associata alla
	 * colonna CLIENT3_FRA.
	 * @generated
	 */
	public void setClient3Fra(String val) {

		client3Fra = val;

	}

	/**
	 * Legge il valore della proprieta' client3Fra associata alla
	 * @generated
	 */
	public String getClient3Fra() {

		return client3Fra;

	}

	/**
	 * store della proprieta' associata alla colonna NBRE_SALARIES_FRA
	 * @generated
	 */
	protected Integer nbreSalariesFra;

	/**
	 * Imposta il valore della proprieta' nbreSalariesFra associata alla
	 * colonna NBRE_SALARIES_FRA.
	 * @generated
	 */
	public void setNbreSalariesFra(Integer val) {

		nbreSalariesFra = val;

	}

	/**
	 * Legge il valore della proprieta' nbreSalariesFra associata alla
	 * @generated
	 */
	public Integer getNbreSalariesFra() {

		return nbreSalariesFra;

	}

	/**
	 * store della proprieta' associata alla colonna TEMPS_PLEIN_FRA
	 * @generated
	 */
	protected java.math.BigDecimal tempsPleinFra;

	/**
	 * Imposta il valore della proprieta' tempsPleinFra associata alla
	 * colonna TEMPS_PLEIN_FRA.
	 * @generated
	 */
	public void setTempsPleinFra(java.math.BigDecimal val) {

		tempsPleinFra = val;

	}

	/**
	 * Legge il valore della proprieta' tempsPleinFra associata alla
	 * @generated
	 */
	public java.math.BigDecimal getTempsPleinFra() {

		return tempsPleinFra;

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
	 * Crea una istanza di TaifTAziendaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTAziendaPk
	 * @generated
	 */
	public TaifTAziendaPk createPk() {
		return new TaifTAziendaPk(idAzienda);
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
