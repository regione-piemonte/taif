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
 * Rappresenta l'esempio corrispondente al DTO [TaifDStatoOpfoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifDStatoOpfoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idStatoOpfo;

	/**
	 * @generated
	 */
	public void setIdStatoOpfo(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idStatoOpfo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdStatoOpfo() {
		return idStatoOpfo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk statoOpfoIta;

	/**
	 * @generated
	 */
	public void setStatoOpfoIta(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		statoOpfoIta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getStatoOpfoIta() {
		return statoOpfoIta;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk statoOpfoFra;

	/**
	 * @generated
	 */
	public void setStatoOpfoFra(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		statoOpfoFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getStatoOpfoFra() {
		return statoOpfoFra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk mtdOrdinamento;

	/**
	 * @generated
	 */
	public void setMtdOrdinamento(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		mtdOrdinamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getMtdOrdinamento() {
		return mtdOrdinamento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk mtdFlgVisibile;

	/**
	 * @generated
	 */
	public void setMtdFlgVisibile(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		mtdFlgVisibile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getMtdFlgVisibile() {
		return mtdFlgVisibile;
	}

}
