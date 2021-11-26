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
 * Rappresenta l'esempio corrispondente al DTO [TaifDTipoCarrelloDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifDTipoCarrelloExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idTipoCarrello;

	/**
	 * @generated
	 */
	public void setIdTipoCarrello(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idTipoCarrello = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdTipoCarrello() {
		return idTipoCarrello;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk tipoCarrello;

	/**
	 * @generated
	 */
	public void setTipoCarrello(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		tipoCarrello = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getTipoCarrello() {
		return tipoCarrello;
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

}
