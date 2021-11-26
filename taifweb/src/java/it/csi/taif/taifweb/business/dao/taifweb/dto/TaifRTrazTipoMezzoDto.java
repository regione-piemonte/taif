/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO TaifRTrazTipoMezzoDao.
 * @generated
 */
public class TaifRTrazTipoMezzoDto extends TaifRTrazTipoMezzoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea una istanza di TaifRTrazTipoMezzoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifRTrazTipoMezzoPk
	 * @generated
	 */
	public TaifRTrazTipoMezzoPk createPk() {
		return new TaifRTrazTipoMezzoPk(idTipoMezzo, idTrazione);
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
