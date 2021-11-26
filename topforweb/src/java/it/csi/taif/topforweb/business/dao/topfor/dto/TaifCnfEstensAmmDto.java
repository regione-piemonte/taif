/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dto;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO TaifCnfEstensAmmDao.
 * @generated
 */
public class TaifCnfEstensAmmDto extends TaifCnfEstensAmmPk {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea una istanza di TaifCnfEstensAmmPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifCnfEstensAmmPk
	 * @generated
	 */
	public TaifCnfEstensAmmPk createPk() {
		return new TaifCnfEstensAmmPk(idEstensioneFile, idTipoAllegato);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
