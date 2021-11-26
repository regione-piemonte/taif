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
 * Rappresenta l'esempio corrispondente al DTO [TaifCnfTipoAllegatoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifCnfTipoAllegatoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idTipoAllegato;

	/**
	 * @generated
	 */
	public void setIdTipoAllegato(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idTipoAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdTipoAllegato() {
		return idTipoAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkProcedura;

	/**
	 * @generated
	 */
	public void setFkProcedura(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkProcedura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkProcedura() {
		return fkProcedura;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk tipoAllegato;

	/**
	 * @generated
	 */
	public void setTipoAllegato(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		tipoAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getTipoAllegato() {
		return tipoAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk mtdOrdinamento;

	/**
	 * @generated
	 */
	public void setMtdOrdinamento(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		mtdOrdinamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getMtdOrdinamento() {
		return mtdOrdinamento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk mtdFlgVisibile;

	/**
	 * @generated
	 */
	public void setMtdFlgVisibile(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		mtdFlgVisibile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getMtdFlgVisibile() {
		return mtdFlgVisibile;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk mtdFlgItaFra;

	/**
	 * @generated
	 */
	public void setMtdFlgItaFra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		mtdFlgItaFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getMtdFlgItaFra() {
		return mtdFlgItaFra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgContesto;

	/**
	 * @generated
	 */
	public void setFlgContesto(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgContesto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgContesto() {
		return flgContesto;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgFirma;

	/**
	 * @generated
	 */
	public void setFlgFirma(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgFirma = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgFirma() {
		return flgFirma;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgDownload;

	/**
	 * @generated
	 */
	public void setFlgDownload(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgDownload = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgDownload() {
		return flgDownload;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgUpload;

	/**
	 * @generated
	 */
	public void setFlgUpload(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgUpload = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgUpload() {
		return flgUpload;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgInvio;

	/**
	 * @generated
	 */
	public void setFlgInvio(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgInvio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgInvio() {
		return flgInvio;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk actaOggetto;

	/**
	 * @generated
	 */
	public void setActaOggetto(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		actaOggetto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getActaOggetto() {
		return actaOggetto;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk actaFlgAllegati;

	/**
	 * @generated
	 */
	public void setActaFlgAllegati(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		actaFlgAllegati = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getActaFlgAllegati() {
		return actaFlgAllegati;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk actaStatoDiEfficacia;

	/**
	 * @generated
	 */
	public void setActaStatoDiEfficacia(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		actaStatoDiEfficacia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getActaStatoDiEfficacia() {
		return actaStatoDiEfficacia;
	}

}
