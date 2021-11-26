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
 * Rappresenta l'esempio corrispondente al DTO [TaifROpfoCorsoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifROpfoCorsoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idCorso;

	/**
	 * @generated
	 */
	public void setIdCorso(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idCorso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdCorso() {
		return idCorso;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idPersona;

	/**
	 * @generated
	 */
	public void setIdPersona(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idPersona = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdPersona() {
		return idPersona;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk flgEsito;

	/**
	 * @generated
	 */
	public void setFlgEsito(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		flgEsito = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFlgEsito() {
		return flgEsito;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk descrizioneAltro;

	/**
	 * @generated
	 */
	public void setDescrizioneAltro(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		descrizioneAltro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDescrizioneAltro() {
		return descrizioneAltro;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataAggiornamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataAggiornamento() {
		return dataAggiornamento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataInserimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkConfigUtente;

	/**
	 * @generated
	 */
	public void setFkConfigUtente(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkConfigUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkConfigUtente() {
		return fkConfigUtente;
	}

}
