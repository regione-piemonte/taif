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
 * Rappresenta l'esempio corrispondente al DTO [TaifViewElencoCorsoPersonaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifViewElencoCorsoPersonaExample extends AbstractExample {

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
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk arrayToString;

	/**
	 * @generated
	 */
	public void setArrayToString(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		arrayToString = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getArrayToString() {
		return arrayToString;
	}

}
