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
 * Data transfer object relativo al DAO TaifTPersonaDao.
 * @generated
 */
public class TaifTPersonaDto extends TaifTPersonaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_TITOLO_STUDIO
	 * @generated
	 */
	protected Integer fkTitoloStudio;

	/**
	 * Imposta il valore della proprieta' fkTitoloStudio associata alla
	 * colonna FK_TITOLO_STUDIO.
	 * @generated
	 */
	public void setFkTitoloStudio(Integer val) {

		fkTitoloStudio = val;

	}

	/**
	 * Legge il valore della proprieta' fkTitoloStudio associata alla
	 * @generated
	 */
	public Integer getFkTitoloStudio() {

		return fkTitoloStudio;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TITOLO_STUDIO_FRA
	 * @generated
	 */
	protected Integer fkTitoloStudioFra;

	/**
	 * Imposta il valore della proprieta' fkTitoloStudioFra associata alla
	 * colonna FK_TITOLO_STUDIO_FRA.
	 * @generated
	 */
	public void setFkTitoloStudioFra(Integer val) {

		fkTitoloStudioFra = val;

	}

	/**
	 * Legge il valore della proprieta' fkTitoloStudioFra associata alla
	 * @generated
	 */
	public Integer getFkTitoloStudioFra() {

		return fkTitoloStudioFra;

	}

	/**
	 * store della proprieta' associata alla colonna FK_NAZIONE
	 * @generated
	 */
	protected Integer fkNazione;

	/**
	 * Imposta il valore della proprieta' fkNazione associata alla
	 * colonna FK_NAZIONE.
	 * @generated
	 */
	public void setFkNazione(Integer val) {

		fkNazione = val;

	}

	/**
	 * Legge il valore della proprieta' fkNazione associata alla
	 * @generated
	 */
	public Integer getFkNazione() {

		return fkNazione;

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
	 * store della proprieta' associata alla colonna N_RSI_MSA
	 * @generated
	 */
	protected String nRsiMsa;

	/**
	 * Imposta il valore della proprieta' nRsiMsa associata alla
	 * colonna N_RSI_MSA.
	 * @generated
	 */
	public void setNRsiMsa(String val) {

		nRsiMsa = val;

	}

	/**
	 * Legge il valore della proprieta' nRsiMsa associata alla
	 * @generated
	 */
	public String getNRsiMsa() {

		return nRsiMsa;

	}

	/**
	 * store della proprieta' associata alla colonna COGNOME
	 * @generated
	 */
	protected String cognome;

	/**
	 * Imposta il valore della proprieta' cognome associata alla
	 * colonna COGNOME.
	 * @generated
	 */
	public void setCognome(String val) {

		cognome = val;

	}

	/**
	 * Legge il valore della proprieta' cognome associata alla
	 * @generated
	 */
	public String getCognome() {

		return cognome;

	}

	/**
	 * store della proprieta' associata alla colonna NOME
	 * @generated
	 */
	protected String nome;

	/**
	 * Imposta il valore della proprieta' nome associata alla
	 * colonna NOME.
	 * @generated
	 */
	public void setNome(String val) {

		nome = val;

	}

	/**
	 * Legge il valore della proprieta' nome associata alla
	 * @generated
	 */
	public String getNome() {

		return nome;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SESSO
	 * @generated
	 */
	protected String flgSesso;

	/**
	 * Imposta il valore della proprieta' flgSesso associata alla
	 * colonna FLG_SESSO.
	 * @generated
	 */
	public void setFlgSesso(String val) {

		flgSesso = val;

	}

	/**
	 * Legge il valore della proprieta' flgSesso associata alla
	 * @generated
	 */
	public String getFlgSesso() {

		return flgSesso;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_NASCITA
	 * @generated
	 */
	protected java.sql.Date dataNascita;

	/**
	 * Imposta il valore della proprieta' dataNascita associata alla
	 * colonna DATA_NASCITA.
	 * @generated
	 */
	public void setDataNascita(java.sql.Date val) {

		if (val != null) {
			dataNascita = new java.sql.Date(val.getTime());
		} else {
			dataNascita = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataNascita associata alla
	 * @generated
	 */
	public java.sql.Date getDataNascita() {

		if (dataNascita != null) {
			return new java.sql.Date(dataNascita.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_COMUNE_NASCITA
	 * @generated
	 */
	protected String istatComuneNascita;

	/**
	 * Imposta il valore della proprieta' istatComuneNascita associata alla
	 * colonna ISTAT_COMUNE_NASCITA.
	 * @generated
	 */
	public void setIstatComuneNascita(String val) {

		istatComuneNascita = val;

	}

	/**
	 * Legge il valore della proprieta' istatComuneNascita associata alla
	 * @generated
	 */
	public String getIstatComuneNascita() {

		return istatComuneNascita;

	}

	/**
	 * store della proprieta' associata alla colonna COMUNE_ESTERO_NASCITA
	 * @generated
	 */
	protected String comuneEsteroNascita;

	/**
	 * Imposta il valore della proprieta' comuneEsteroNascita associata alla
	 * colonna COMUNE_ESTERO_NASCITA.
	 * @generated
	 */
	public void setComuneEsteroNascita(String val) {

		comuneEsteroNascita = val;

	}

	/**
	 * Legge il valore della proprieta' comuneEsteroNascita associata alla
	 * @generated
	 */
	public String getComuneEsteroNascita() {

		return comuneEsteroNascita;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_COMUNE_RES
	 * @generated
	 */
	protected String istatComuneRes;

	/**
	 * Imposta il valore della proprieta' istatComuneRes associata alla
	 * colonna ISTAT_COMUNE_RES.
	 * @generated
	 */
	public void setIstatComuneRes(String val) {

		istatComuneRes = val;

	}

	/**
	 * Legge il valore della proprieta' istatComuneRes associata alla
	 * @generated
	 */
	public String getIstatComuneRes() {

		return istatComuneRes;

	}

	/**
	 * store della proprieta' associata alla colonna COMUNE_ESTERO_RES
	 * @generated
	 */
	protected String comuneEsteroRes;

	/**
	 * Imposta il valore della proprieta' comuneEsteroRes associata alla
	 * colonna COMUNE_ESTERO_RES.
	 * @generated
	 */
	public void setComuneEsteroRes(String val) {

		comuneEsteroRes = val;

	}

	/**
	 * Legge il valore della proprieta' comuneEsteroRes associata alla
	 * @generated
	 */
	public String getComuneEsteroRes() {

		return comuneEsteroRes;

	}

	/**
	 * store della proprieta' associata alla colonna INDIRIZZO_RES
	 * @generated
	 */
	protected String indirizzoRes;

	/**
	 * Imposta il valore della proprieta' indirizzoRes associata alla
	 * colonna INDIRIZZO_RES.
	 * @generated
	 */
	public void setIndirizzoRes(String val) {

		indirizzoRes = val;

	}

	/**
	 * Legge il valore della proprieta' indirizzoRes associata alla
	 * @generated
	 */
	public String getIndirizzoRes() {

		return indirizzoRes;

	}

	/**
	 * store della proprieta' associata alla colonna CIVICO_RES
	 * @generated
	 */
	protected String civicoRes;

	/**
	 * Imposta il valore della proprieta' civicoRes associata alla
	 * colonna CIVICO_RES.
	 * @generated
	 */
	public void setCivicoRes(String val) {

		civicoRes = val;

	}

	/**
	 * Legge il valore della proprieta' civicoRes associata alla
	 * @generated
	 */
	public String getCivicoRes() {

		return civicoRes;

	}

	/**
	 * store della proprieta' associata alla colonna CAP_RES
	 * @generated
	 */
	protected String capRes;

	/**
	 * Imposta il valore della proprieta' capRes associata alla
	 * colonna CAP_RES.
	 * @generated
	 */
	public void setCapRes(String val) {

		capRes = val;

	}

	/**
	 * Legge il valore della proprieta' capRes associata alla
	 * @generated
	 */
	public String getCapRes() {

		return capRes;

	}

	/**
	 * store della proprieta' associata alla colonna TELEFONO
	 * @generated
	 */
	protected String telefono;

	/**
	 * Imposta il valore della proprieta' telefono associata alla
	 * colonna TELEFONO.
	 * @generated
	 */
	public void setTelefono(String val) {

		telefono = val;

	}

	/**
	 * Legge il valore della proprieta' telefono associata alla
	 * @generated
	 */
	public String getTelefono() {

		return telefono;

	}

	/**
	 * store della proprieta' associata alla colonna CELLULARE
	 * @generated
	 */
	protected String cellulare;

	/**
	 * Imposta il valore della proprieta' cellulare associata alla
	 * colonna CELLULARE.
	 * @generated
	 */
	public void setCellulare(String val) {

		cellulare = val;

	}

	/**
	 * Legge il valore della proprieta' cellulare associata alla
	 * @generated
	 */
	public String getCellulare() {

		return cellulare;

	}

	/**
	 * store della proprieta' associata alla colonna MAIL
	 * @generated
	 */
	protected String mail;

	/**
	 * Imposta il valore della proprieta' mail associata alla
	 * colonna MAIL.
	 * @generated
	 */
	public void setMail(String val) {

		mail = val;

	}

	/**
	 * Legge il valore della proprieta' mail associata alla
	 * @generated
	 */
	public String getMail() {

		return mail;

	}

	/**
	 * store della proprieta' associata alla colonna ALTRI_STUDI
	 * @generated
	 */
	protected String altriStudi;

	/**
	 * Imposta il valore della proprieta' altriStudi associata alla
	 * colonna ALTRI_STUDI.
	 * @generated
	 */
	public void setAltriStudi(String val) {

		altriStudi = val;

	}

	/**
	 * Legge il valore della proprieta' altriStudi associata alla
	 * @generated
	 */
	public String getAltriStudi() {

		return altriStudi;

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
	 * store della proprieta' associata alla colonna PWD
	 * @generated
	 */
	protected String pwd;

	/**
	 * Imposta il valore della proprieta' pwd associata alla
	 * colonna PWD.
	 * @generated
	 */
	public void setPwd(String val) {

		pwd = val;

	}

	/**
	 * Legge il valore della proprieta' pwd associata alla
	 * @generated
	 */
	public String getPwd() {

		return pwd;

	}

	/**
	 * Crea una istanza di TaifTPersonaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTPersonaPk
	 * @generated
	 */
	public TaifTPersonaPk createPk() {
		return new TaifTPersonaPk(idPersona);
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
