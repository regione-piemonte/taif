/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO TaifVApplSchedaOkRealeDao.
 * @generated
 */
public class TaifVApplSchedaOkRealeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_AZIENDA
	 * @generated
	 */
	protected Integer idAzienda;

	/**
	 * Imposta il valore della proprieta' idAzienda associata alla
	 * colonna ID_AZIENDA.
	 * @generated
	 */
	public void setIdAzienda(Integer val) {

		idAzienda = val;

	}

	/**
	 * Legge il valore della proprieta' idAzienda associata alla
	 * @generated
	 */
	public Integer getIdAzienda() {

		return idAzienda;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_1_1_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez11ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez11ItaOk associata alla
	 * colonna FLG_SEZ_1_1_ITA_OK.
	 * @generated
	 */
	public void setFlgSez11ItaOk(java.math.BigDecimal val) {

		flgSez11ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez11ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez11ItaOk() {

		return flgSez11ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_1_2_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez12ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez12ItaOk associata alla
	 * colonna FLG_SEZ_1_2_ITA_OK.
	 * @generated
	 */
	public void setFlgSez12ItaOk(java.math.BigDecimal val) {

		flgSez12ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez12ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez12ItaOk() {

		return flgSez12ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_2_1_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez21ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez21ItaOk associata alla
	 * colonna FLG_SEZ_2_1_ITA_OK.
	 * @generated
	 */
	public void setFlgSez21ItaOk(java.math.BigDecimal val) {

		flgSez21ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez21ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez21ItaOk() {

		return flgSez21ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_2_2_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez22ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez22ItaOk associata alla
	 * colonna FLG_SEZ_2_2_ITA_OK.
	 * @generated
	 */
	public void setFlgSez22ItaOk(java.math.BigDecimal val) {

		flgSez22ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez22ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez22ItaOk() {

		return flgSez22ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_3_1_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez31ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez31ItaOk associata alla
	 * colonna FLG_SEZ_3_1_ITA_OK.
	 * @generated
	 */
	public void setFlgSez31ItaOk(java.math.BigDecimal val) {

		flgSez31ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez31ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez31ItaOk() {

		return flgSez31ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_3_2_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez32ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez32ItaOk associata alla
	 * colonna FLG_SEZ_3_2_ITA_OK.
	 * @generated
	 */
	public void setFlgSez32ItaOk(java.math.BigDecimal val) {

		flgSez32ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez32ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez32ItaOk() {

		return flgSez32ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_3_3_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez33ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez33ItaOk associata alla
	 * colonna FLG_SEZ_3_3_ITA_OK.
	 * @generated
	 */
	public void setFlgSez33ItaOk(java.math.BigDecimal val) {

		flgSez33ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez33ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez33ItaOk() {

		return flgSez33ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_4_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez4ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez4ItaOk associata alla
	 * colonna FLG_SEZ_4_ITA_OK.
	 * @generated
	 */
	public void setFlgSez4ItaOk(java.math.BigDecimal val) {

		flgSez4ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez4ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez4ItaOk() {

		return flgSez4ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_5_1_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez51ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez51ItaOk associata alla
	 * colonna FLG_SEZ_5_1_ITA_OK.
	 * @generated
	 */
	public void setFlgSez51ItaOk(java.math.BigDecimal val) {

		flgSez51ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez51ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez51ItaOk() {

		return flgSez51ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_5_2_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez52ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez52ItaOk associata alla
	 * colonna FLG_SEZ_5_2_ITA_OK.
	 * @generated
	 */
	public void setFlgSez52ItaOk(java.math.BigDecimal val) {

		flgSez52ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez52ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez52ItaOk() {

		return flgSez52ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_6_ITA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez6ItaOk;

	/**
	 * Imposta il valore della proprieta' flgSez6ItaOk associata alla
	 * colonna FLG_SEZ_6_ITA_OK.
	 * @generated
	 */
	public void setFlgSez6ItaOk(java.math.BigDecimal val) {

		flgSez6ItaOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez6ItaOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez6ItaOk() {

		return flgSez6ItaOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_1_1_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez11FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez11FraOk associata alla
	 * colonna FLG_SEZ_1_1_FRA_OK.
	 * @generated
	 */
	public void setFlgSez11FraOk(java.math.BigDecimal val) {

		flgSez11FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez11FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez11FraOk() {

		return flgSez11FraOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_1_2_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez12FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez12FraOk associata alla
	 * colonna FLG_SEZ_1_2_FRA_OK.
	 * @generated
	 */
	public void setFlgSez12FraOk(java.math.BigDecimal val) {

		flgSez12FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez12FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez12FraOk() {

		return flgSez12FraOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_2_1_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez21FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez21FraOk associata alla
	 * colonna FLG_SEZ_2_1_FRA_OK.
	 * @generated
	 */
	public void setFlgSez21FraOk(java.math.BigDecimal val) {

		flgSez21FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez21FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez21FraOk() {

		return flgSez21FraOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_2_2_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez22FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez22FraOk associata alla
	 * colonna FLG_SEZ_2_2_FRA_OK.
	 * @generated
	 */
	public void setFlgSez22FraOk(java.math.BigDecimal val) {

		flgSez22FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez22FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez22FraOk() {

		return flgSez22FraOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_3_1_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez31FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez31FraOk associata alla
	 * colonna FLG_SEZ_3_1_FRA_OK.
	 * @generated
	 */
	public void setFlgSez31FraOk(java.math.BigDecimal val) {

		flgSez31FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez31FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez31FraOk() {

		return flgSez31FraOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_3_3_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez33FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez33FraOk associata alla
	 * colonna FLG_SEZ_3_3_FRA_OK.
	 * @generated
	 */
	public void setFlgSez33FraOk(java.math.BigDecimal val) {

		flgSez33FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez33FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez33FraOk() {

		return flgSez33FraOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_4_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez4FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez4FraOk associata alla
	 * colonna FLG_SEZ_4_FRA_OK.
	 * @generated
	 */
	public void setFlgSez4FraOk(java.math.BigDecimal val) {

		flgSez4FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez4FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez4FraOk() {

		return flgSez4FraOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_5_2_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez52FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez52FraOk associata alla
	 * colonna FLG_SEZ_5_2_FRA_OK.
	 * @generated
	 */
	public void setFlgSez52FraOk(java.math.BigDecimal val) {

		flgSez52FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez52FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez52FraOk() {

		return flgSez52FraOk;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZ_6_FRA_OK
	 * @generated
	 */
	protected java.math.BigDecimal flgSez6FraOk;

	/**
	 * Imposta il valore della proprieta' flgSez6FraOk associata alla
	 * colonna FLG_SEZ_6_FRA_OK.
	 * @generated
	 */
	public void setFlgSez6FraOk(java.math.BigDecimal val) {

		flgSez6FraOk = val;

	}

	/**
	 * Legge il valore della proprieta' flgSez6FraOk associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgSez6FraOk() {

		return flgSez6FraOk;

	}

}
