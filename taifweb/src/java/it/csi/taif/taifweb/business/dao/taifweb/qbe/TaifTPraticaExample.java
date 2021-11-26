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
 * Rappresenta l'esempio corrispondente al DTO [TaifTPraticaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifTPraticaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idPratica;

	/**
	 * @generated
	 */
	public void setIdPratica(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idPratica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdPratica() {
		return idPratica;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkSoggettoGestore;

	/**
	 * @generated
	 */
	public void setFkSoggettoGestore(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkSoggettoGestore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkSoggettoGestore() {
		return fkSoggettoGestore;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkAzienda;

	/**
	 * @generated
	 */
	public void setFkAzienda(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkAzienda = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkAzienda() {
		return fkAzienda;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataPresentazione;

	/**
	 * @generated
	 */
	public void setDataPresentazione(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataPresentazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataPresentazione() {
		return dataPresentazione;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataIscrizioneAlbo;

	/**
	 * @generated
	 */
	public void setDataIscrizioneAlbo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataIscrizioneAlbo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataIscrizioneAlbo() {
		return dataIscrizioneAlbo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk numeroAlbo;

	/**
	 * @generated
	 */
	public void setNumeroAlbo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		numeroAlbo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getNumeroAlbo() {
		return numeroAlbo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSezione;

	/**
	 * @generated
	 */
	public void setFlgSezione(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSezione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSezione() {
		return flgSezione;
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
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk denominazioneAltroAlbo;

	/**
	 * @generated
	 */
	public void setDenominazioneAltroAlbo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		denominazioneAltroAlbo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDenominazioneAltroAlbo() {
		return denominazioneAltroAlbo;
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

}
