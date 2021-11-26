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
 * Rappresenta l'esempio corrispondente al DTO [TaifDAmbitoFormativoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifDAmbitoFormativoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idAmbitoFormativo;

	/**
	 * @generated
	 */
	public void setIdAmbitoFormativo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idAmbitoFormativo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdAmbitoFormativo() {
		return idAmbitoFormativo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk ambitoFormativo;

	/**
	 * @generated
	 */
	public void setAmbitoFormativo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		ambitoFormativo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getAmbitoFormativo() {
		return ambitoFormativo;
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
