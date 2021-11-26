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
 * Rappresenta l'esempio corrispondente al DTO [TaifTMezzoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifTMezzoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idMezzo;

	/**
	 * @generated
	 */
	public void setIdMezzo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idMezzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdMezzo() {
		return idMezzo;
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
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkAlimentazione;

	/**
	 * @generated
	 */
	public void setFkAlimentazione(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkAlimentazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkAlimentazione() {
		return fkAlimentazione;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkTipoCarrello;

	/**
	 * @generated
	 */
	public void setFkTipoCarrello(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkTipoCarrello = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkTipoCarrello() {
		return fkTipoCarrello;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkTipoMezzo;

	/**
	 * @generated
	 */
	public void setFkTipoMezzo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkTipoMezzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkTipoMezzo() {
		return fkTipoMezzo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkTrazione;

	/**
	 * @generated
	 */
	public void setFkTrazione(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkTrazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkTrazione() {
		return fkTrazione;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk anno;

	/**
	 * @generated
	 */
	public void setAnno(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		anno = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getAnno() {
		return anno;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk potenzaKw;

	/**
	 * @generated
	 */
	public void setPotenzaKw(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		potenzaKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getPotenzaKw() {
		return potenzaKw;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk portataKg;

	/**
	 * @generated
	 */
	public void setPortataKg(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		portataKg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getPortataKg() {
		return portataKg;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgComandatoDistanza;

	/**
	 * @generated
	 */
	public void setFlgComandatoDistanza(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgComandatoDistanza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgComandatoDistanza() {
		return flgComandatoDistanza;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgNoleggio;

	/**
	 * @generated
	 */
	public void setFlgNoleggio(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgNoleggio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgNoleggio() {
		return flgNoleggio;
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
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk descrAltro;

	/**
	 * @generated
	 */
	public void setDescrAltro(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		descrAltro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDescrAltro() {
		return descrAltro;
	}

}
