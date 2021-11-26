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
public class TaifCnfMailMetadata extends DAOMetadata {

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
	 * DAO: [taifCnfMail]
	 * tabella: [TAIF_CNF_MAIL].
	 */
	public TaifCnfMailMetadata() {
		columnNames = new String[]{"ID_MAIL", "HOST", "PORTA", "USER_ID", "PASSWORD", "PROTOCOLLO", "MITTENTE",
				"DES_TIPO_POSTA"};
		propertyNames = new String[]{"idMail", "host", "porta", "userId", "password", "protocollo", "mittente",
				"desTipoPosta"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifCnfMail] fa riferimento
	 * (TAIF_CNF_MAIL).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_MAIL";
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
