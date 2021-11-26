/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.qbe;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [TaifTAllegatoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifTAllegatoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idAllegato;

	/**
	 * @generated
	 */
	public void setIdAllegato(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdAllegato() {
		return idAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk fkPratica;

	/**
	 * @generated
	 */
	public void setFkPratica(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		fkPratica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFkPratica() {
		return fkPratica;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk fkCorso;

	/**
	 * @generated
	 */
	public void setFkCorso(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		fkCorso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFkCorso() {
		return fkCorso;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk fkPersona;

	/**
	 * @generated
	 */
	public void setFkPersona(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		fkPersona = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFkPersona() {
		return fkPersona;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk fkEstensioneFile;

	/**
	 * @generated
	 */
	public void setFkEstensioneFile(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		fkEstensioneFile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFkEstensioneFile() {
		return fkEstensioneFile;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk fkTipoAllegato;

	/**
	 * @generated
	 */
	public void setFkTipoAllegato(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		fkTipoAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFkTipoAllegato() {
		return fkTipoAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk nomeFile;

	/**
	 * @generated
	 */
	public void setNomeFile(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		nomeFile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getNomeFile() {
		return nomeFile;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk dimensioneFileKb;

	/**
	 * @generated
	 */
	public void setDimensioneFileKb(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		dimensioneFileKb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getDimensioneFileKb() {
		return dimensioneFileKb;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk flgTipoInvio;

	/**
	 * @generated
	 */
	public void setFlgTipoInvio(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		flgTipoInvio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFlgTipoInvio() {
		return flgTipoInvio;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk flgScadenza;

	/**
	 * @generated
	 */
	public void setFlgScadenza(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		flgScadenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFlgScadenza() {
		return flgScadenza;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk dataUpload;

	/**
	 * @generated
	 */
	public void setDataUpload(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		dataUpload = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getDataUpload() {
		return dataUpload;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk note;

	/**
	 * @generated
	 */
	public void setNote(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		note = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getNote() {
		return note;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk estensioneFile;

	/**
	 * @generated
	 */
	public void setEstensioneFile(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		estensioneFile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getEstensioneFile() {
		return estensioneFile;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		dataInserimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		dataAggiornamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getDataAggiornamento() {
		return dataAggiornamento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk fkConfigUtente;

	/**
	 * @generated
	 */
	public void setFkConfigUtente(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		fkConfigUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFkConfigUtente() {
		return fkConfigUtente;
	}

}
