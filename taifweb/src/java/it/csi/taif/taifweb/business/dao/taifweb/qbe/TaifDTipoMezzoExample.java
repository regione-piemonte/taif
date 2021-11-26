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
 * Rappresenta l'esempio corrispondente al DTO [TaifDTipoMezzoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifDTipoMezzoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idTipoMezzo;

	/**
	 * @generated
	 */
	public void setIdTipoMezzo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idTipoMezzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdTipoMezzo() {
		return idTipoMezzo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkCategoriaMezzo;

	/**
	 * @generated
	 */
	public void setFkCategoriaMezzo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkCategoriaMezzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkCategoriaMezzo() {
		return fkCategoriaMezzo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk tipoMezzo;

	/**
	 * @generated
	 */
	public void setTipoMezzo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		tipoMezzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getTipoMezzo() {
		return tipoMezzo;
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

}
