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
 * Rappresenta l'esempio corrispondente al DTO [TaifApplSchedaOkDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifApplSchedaOkExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idAzienda;

	/**
	 * @generated
	 */
	public void setIdAzienda(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idAzienda = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdAzienda() {
		return idAzienda;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez11ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez11ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez11ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez11ItaOk() {
		return flgSez11ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez12ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez12ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez12ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez12ItaOk() {
		return flgSez12ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez21ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez21ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez21ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez21ItaOk() {
		return flgSez21ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez22ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez22ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez22ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez22ItaOk() {
		return flgSez22ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez31ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez31ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez31ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez31ItaOk() {
		return flgSez31ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez32ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez32ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez32ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez32ItaOk() {
		return flgSez32ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez33ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez33ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez33ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez33ItaOk() {
		return flgSez33ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez4ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez4ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez4ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez4ItaOk() {
		return flgSez4ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez51ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez51ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez51ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez51ItaOk() {
		return flgSez51ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez52ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez52ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez52ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez52ItaOk() {
		return flgSez52ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez6ItaOk;

	/**
	 * @generated
	 */
	public void setFlgSez6ItaOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez6ItaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez6ItaOk() {
		return flgSez6ItaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez11FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez11FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez11FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez11FraOk() {
		return flgSez11FraOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez12FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez12FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez12FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez12FraOk() {
		return flgSez12FraOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez21FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez21FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez21FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez21FraOk() {
		return flgSez21FraOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez22FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez22FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez22FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez22FraOk() {
		return flgSez22FraOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez31FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez31FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez31FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez31FraOk() {
		return flgSez31FraOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez33FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez33FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez33FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez33FraOk() {
		return flgSez33FraOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez4FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez4FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez4FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez4FraOk() {
		return flgSez4FraOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez52FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez52FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez52FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez52FraOk() {
		return flgSez52FraOk;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgSez6FraOk;

	/**
	 * @generated
	 */
	public void setFlgSez6FraOk(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgSez6FraOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgSez6FraOk() {
		return flgSez6FraOk;
	}

}
