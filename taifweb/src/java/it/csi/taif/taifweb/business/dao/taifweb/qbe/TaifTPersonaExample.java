/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.qbe;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.qbe.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [TaifTPersonaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifTPersonaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idPersona;

	/**
	 * @generated
	 */
	public void setIdPersona(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idPersona = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdPersona() {
		return idPersona;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkTitoloStudio;

	/**
	 * @generated
	 */
	public void setFkTitoloStudio(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkTitoloStudio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkTitoloStudio() {
		return fkTitoloStudio;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkTitoloStudioFra;

	/**
	 * @generated
	 */
	public void setFkTitoloStudioFra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkTitoloStudioFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkTitoloStudioFra() {
		return fkTitoloStudioFra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkNazione;

	/**
	 * @generated
	 */
	public void setFkNazione(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkNazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkNazione() {
		return fkNazione;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk codiceFiscale;

	/**
	 * @generated
	 */
	public void setCodiceFiscale(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		codiceFiscale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk nRsiMsa;

	/**
	 * @generated
	 */
	public void setNRsiMsa(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		nRsiMsa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getNRsiMsa() {
		return nRsiMsa;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk cognome;

	/**
	 * @generated
	 */
	public void setCognome(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		cognome = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCognome() {
		return cognome;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk nome;

	/**
	 * @generated
	 */
	public void setNome(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		nome = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getNome() {
		return nome;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSesso;

	/**
	 * @generated
	 */
	public void setFlgSesso(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSesso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSesso() {
		return flgSesso;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataNascita;

	/**
	 * @generated
	 */
	public void setDataNascita(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataNascita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataNascita() {
		return dataNascita;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk istatComuneNascita;

	/**
	 * @generated
	 */
	public void setIstatComuneNascita(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		istatComuneNascita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIstatComuneNascita() {
		return istatComuneNascita;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk comuneEsteroNascita;

	/**
	 * @generated
	 */
	public void setComuneEsteroNascita(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		comuneEsteroNascita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getComuneEsteroNascita() {
		return comuneEsteroNascita;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk istatComuneRes;

	/**
	 * @generated
	 */
	public void setIstatComuneRes(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		istatComuneRes = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIstatComuneRes() {
		return istatComuneRes;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk comuneEsteroRes;

	/**
	 * @generated
	 */
	public void setComuneEsteroRes(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		comuneEsteroRes = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getComuneEsteroRes() {
		return comuneEsteroRes;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk indirizzoRes;

	/**
	 * @generated
	 */
	public void setIndirizzoRes(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		indirizzoRes = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIndirizzoRes() {
		return indirizzoRes;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk civicoRes;

	/**
	 * @generated
	 */
	public void setCivicoRes(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		civicoRes = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCivicoRes() {
		return civicoRes;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk capRes;

	/**
	 * @generated
	 */
	public void setCapRes(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		capRes = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCapRes() {
		return capRes;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk telefono;

	/**
	 * @generated
	 */
	public void setTelefono(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		telefono = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getTelefono() {
		return telefono;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk cellulare;

	/**
	 * @generated
	 */
	public void setCellulare(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		cellulare = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCellulare() {
		return cellulare;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk mail;

	/**
	 * @generated
	 */
	public void setMail(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		mail = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getMail() {
		return mail;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk altriStudi;

	/**
	 * @generated
	 */
	public void setAltriStudi(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		altriStudi = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getAltriStudi() {
		return altriStudi;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataInserimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataAggiornamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataAggiornamento() {
		return dataAggiornamento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkConfigUtente;

	/**
	 * @generated
	 */
	public void setFkConfigUtente(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkConfigUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkConfigUtente() {
		return fkConfigUtente;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk pwd;

	/**
	 * @generated
	 */
	public void setPwd(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		pwd = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getPwd() {
		return pwd;
	}

}
