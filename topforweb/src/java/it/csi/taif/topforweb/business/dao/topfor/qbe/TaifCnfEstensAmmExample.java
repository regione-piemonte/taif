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
 * Rappresenta l'esempio corrispondente al DTO [TaifCnfEstensAmmDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifCnfEstensAmmExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idEstensioneFile;

	/**
	 * @generated
	 */
	public void setIdEstensioneFile(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idEstensioneFile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdEstensioneFile() {
		return idEstensioneFile;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.business.dao.qbe.FieldChk idTipoAllegato;

	/**
	 * @generated
	 */
	public void setIdTipoAllegato(it.csi.taif.topforweb.business.dao.qbe.FieldChk chk) {
		idTipoAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.topforweb.business.dao.qbe.FieldChk getIdTipoAllegato() {
		return idTipoAllegato;
	}

}
