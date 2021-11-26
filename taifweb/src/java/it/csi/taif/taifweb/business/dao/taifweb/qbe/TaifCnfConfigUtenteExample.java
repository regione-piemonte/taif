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
 * Rappresenta l'esempio corrispondente al DTO [TaifCnfConfigUtenteDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifCnfConfigUtenteExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idConfigUtente;

	/**
	 * @generated
	 */
	public void setIdConfigUtente(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idConfigUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdConfigUtente() {
		return idConfigUtente;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkProfiloUtente;

	/**
	 * @generated
	 */
	public void setFkProfiloUtente(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkProfiloUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkProfiloUtente() {
		return fkProfiloUtente;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkPersona;

	/**
	 * @generated
	 */
	public void setFkPersona(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkPersona = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkPersona() {
		return fkPersona;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkSoggettoGestore;

	/**
	 * @generated
	 */
	public void setFkSoggettoGestore(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkSoggettoGestore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkSoggettoGestore() {
		return fkSoggettoGestore;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk nrAccessi;

	/**
	 * @generated
	 */
	public void setNrAccessi(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		nrAccessi = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getNrAccessi() {
		return nrAccessi;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataPrimoAccesso;

	/**
	 * @generated
	 */
	public void setDataPrimoAccesso(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataPrimoAccesso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataPrimoAccesso() {
		return dataPrimoAccesso;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataUltimoAccesso;

	/**
	 * @generated
	 */
	public void setDataUltimoAccesso(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataUltimoAccesso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataUltimoAccesso() {
		return dataUltimoAccesso;
	}

}
