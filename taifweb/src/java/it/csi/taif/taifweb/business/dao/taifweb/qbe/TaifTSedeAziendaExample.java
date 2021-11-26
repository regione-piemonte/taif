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
 * Rappresenta l'esempio corrispondente al DTO [TaifTSedeAziendaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifTSedeAziendaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idSede;

	/**
	 * @generated
	 */
	public void setIdSede(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idSede = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdSede() {
		return idSede;
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
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkTipoSede;

	/**
	 * @generated
	 */
	public void setFkTipoSede(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkTipoSede = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkTipoSede() {
		return fkTipoSede;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk istatComune;

	/**
	 * @generated
	 */
	public void setIstatComune(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		istatComune = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIstatComune() {
		return istatComune;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk comuneEstero;

	/**
	 * @generated
	 */
	public void setComuneEstero(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		comuneEstero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getComuneEstero() {
		return comuneEstero;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk indirizzo;

	/**
	 * @generated
	 */
	public void setIndirizzo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		indirizzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk civico;

	/**
	 * @generated
	 */
	public void setCivico(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		civico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCivico() {
		return civico;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk cap;

	/**
	 * @generated
	 */
	public void setCap(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		cap = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCap() {
		return cap;
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

}
