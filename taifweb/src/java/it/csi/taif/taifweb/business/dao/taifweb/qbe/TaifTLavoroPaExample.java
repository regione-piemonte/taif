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
 * Rappresenta l'esempio corrispondente al DTO [TaifTLavoroPaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifTLavoroPaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idLavoroPa;

	/**
	 * @generated
	 */
	public void setIdLavoroPa(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idLavoroPa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdLavoroPa() {
		return idLavoroPa;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkAzienda;

	/**
	 * @generated
	 */
	public void setFkAzienda(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkAzienda = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkAzienda() {
		return fkAzienda;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkTipoLavoroPa;

	/**
	 * @generated
	 */
	public void setFkTipoLavoroPa(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkTipoLavoroPa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkTipoLavoroPa() {
		return fkTipoLavoroPa;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk committente;

	/**
	 * @generated
	 */
	public void setCommittente(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		committente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCommittente() {
		return committente;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk importo;

	/**
	 * @generated
	 */
	public void setImporto(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		importo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getImporto() {
		return importo;
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

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk descrAltro;

	/**
	 * @generated
	 */
	public void setDescrAltro(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		descrAltro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDescrAltro() {
		return descrAltro;
	}

}
