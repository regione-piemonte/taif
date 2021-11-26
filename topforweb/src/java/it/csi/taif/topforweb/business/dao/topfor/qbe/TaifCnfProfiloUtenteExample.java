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
 * Rappresenta l'esempio corrispondente al DTO [TaifCnfProfiloUtenteDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifCnfProfiloUtenteExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idProfiloUtente;

	/**
	 * @generated
	 */
	public void setIdProfiloUtente(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idProfiloUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdProfiloUtente() {
		return idProfiloUtente;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk profiloUtente;

	/**
	 * @generated
	 */
	public void setProfiloUtente(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		profiloUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getProfiloUtente() {
		return profiloUtente;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk mtdFlgAttivo;

	/**
	 * @generated
	 */
	public void setMtdFlgAttivo(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		mtdFlgAttivo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getMtdFlgAttivo() {
		return mtdFlgAttivo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk fkProcedura;

	/**
	 * @generated
	 */
	public void setFkProcedura(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		fkProcedura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getFkProcedura() {
		return fkProcedura;
	}

}
