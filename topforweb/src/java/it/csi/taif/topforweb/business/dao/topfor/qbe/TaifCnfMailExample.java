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
 * Rappresenta l'esempio corrispondente al DTO [TaifCnfMailDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifCnfMailExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idMail;

	/**
	 * @generated
	 */
	public void setIdMail(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idMail = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdMail() {
		return idMail;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk host;

	/**
	 * @generated
	 */
	public void setHost(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		host = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getHost() {
		return host;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk porta;

	/**
	 * @generated
	 */
	public void setPorta(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		porta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getPorta() {
		return porta;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk userId;

	/**
	 * @generated
	 */
	public void setUserId(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		userId = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getUserId() {
		return userId;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk password;

	/**
	 * @generated
	 */
	public void setPassword(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		password = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getPassword() {
		return password;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk protocollo;

	/**
	 * @generated
	 */
	public void setProtocollo(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		protocollo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getProtocollo() {
		return protocollo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk mittente;

	/**
	 * @generated
	 */
	public void setMittente(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		mittente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getMittente() {
		return mittente;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk desTipoPosta;

	/**
	 * @generated
	 */
	public void setDesTipoPosta(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		desTipoPosta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getDesTipoPosta() {
		return desTipoPosta;
	}

}
