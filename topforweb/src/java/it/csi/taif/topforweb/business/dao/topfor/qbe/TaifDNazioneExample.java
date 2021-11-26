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
 * Rappresenta l'esempio corrispondente al DTO [TaifDNazioneDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifDNazioneExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idNazione;

	/**
	 * @generated
	 */
	public void setIdNazione(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idNazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdNazione() {
		return idNazione;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk nazioneIta;

	/**
	 * @generated
	 */
	public void setNazioneIta(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		nazioneIta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getNazioneIta() {
		return nazioneIta;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk nazioneFra;

	/**
	 * @generated
	 */
	public void setNazioneFra(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		nazioneFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getNazioneFra() {
		return nazioneFra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk mtdOrdinamentoIta;

	/**
	 * @generated
	 */
	public void setMtdOrdinamentoIta(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		mtdOrdinamentoIta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getMtdOrdinamentoIta() {
		return mtdOrdinamentoIta;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk mtdOrdinamentoFra;

	/**
	 * @generated
	 */
	public void setMtdOrdinamentoFra(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		mtdOrdinamentoFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getMtdOrdinamentoFra() {
		return mtdOrdinamentoFra;
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
