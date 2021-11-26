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
 * Rappresenta l'esempio corrispondente al DTO [TaifCnfParamApimgrDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifCnfParamApimgrExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idConfigParamApimgr;

	/**
	 * @generated
	 */
	public void setIdConfigParamApimgr(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idConfigParamApimgr = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdConfigParamApimgr() {
		return idConfigParamApimgr;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk consumerKey;

	/**
	 * @generated
	 */
	public void setConsumerKey(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		consumerKey = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getConsumerKey() {
		return consumerKey;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk consumerSecret;

	/**
	 * @generated
	 */
	public void setConsumerSecret(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		consumerSecret = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getConsumerSecret() {
		return consumerSecret;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk dataInizioValidita;

	/**
	 * @generated
	 */
	public void setDataInizioValidita(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		dataInizioValidita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getDataInizioValidita() {
		return dataInizioValidita;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk dataFineValidita;

	/**
	 * @generated
	 */
	public void setDataFineValidita(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		dataFineValidita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getDataFineValidita() {
		return dataFineValidita;
	}

}
