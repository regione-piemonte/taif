/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.metadata;

import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class TaifCnfTipoMailMetadata extends DAOMetadata {

	/**
	 * contiene l'elenco dei nomi delle property del DTO associato al DAO a cui
	 * questi metadati fanno riferimento
	 */
	private final String[] propertyNames;

	/**
	 * contiene l'elenco dei nomi delle colonne della tabella associata al DAO a cui
	 * questi metadati fanno riferimento
	 */
	private final String[] columnNames;

	/**
	 * Contiene i metadati relativi a:
	 * DAO: [taifCnfTipoMail]
	 * tabella: [TAIF_CNF_TIPO_MAIL].
	 */
	public TaifCnfTipoMailMetadata() {
		columnNames = new String[]{"ID_TIPO_MAIL", "FK_STATO_PRATICA", "FLG_TIPO_MAIL", "OGGETTO", "TESTO"};
		propertyNames = new String[]{"idTipoMail", "fkStatoPratica", "flgTipoMail", "oggetto", "testo"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifCnfTipoMail] fa riferimento
	 * (TAIF_CNF_TIPO_MAIL).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_TIPO_MAIL";
	}

	/**
	 * Method 'getColumnNames'
	 * Restutuisce l'insieme dei nomi delle colonne gestite dal DAO.
	 * @return String[]
	 * @generated
	 */
	public String[] getColumnNames() {
		String ris[] = new String[columnNames.length];
		System.arraycopy(columnNames, 0, ris, 0, columnNames.length);
		return ris;
	}

}
