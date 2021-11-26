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
 * Rappresenta l'esempio corrispondente al DTO [TaifCnfTipoMailDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifCnfTipoMailExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idTipoMail;

	/**
	 * @generated
	 */
	public void setIdTipoMail(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idTipoMail = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdTipoMail() {
		return idTipoMail;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk fkStatoPratica;

	/**
	 * @generated
	 */
	public void setFkStatoPratica(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		fkStatoPratica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFkStatoPratica() {
		return fkStatoPratica;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk flgTipoMail;

	/**
	 * @generated
	 */
	public void setFlgTipoMail(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		flgTipoMail = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFlgTipoMail() {
		return flgTipoMail;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk oggetto;

	/**
	 * @generated
	 */
	public void setOggetto(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		oggetto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getOggetto() {
		return oggetto;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk testo;

	/**
	 * @generated
	 */
	public void setTesto(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		testo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getTesto() {
		return testo;
	}

}
