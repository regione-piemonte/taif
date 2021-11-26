/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.metadata;

import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class TaifCnfParamApimgrMetadata extends DAOMetadata {

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
	 * DAO: [taifCnfParamApimgr]
	 * tabella: [TAIF_CNF_PARAM_APIMGR].
	 */
	public TaifCnfParamApimgrMetadata() {
		columnNames = new String[]{"ID_CONFIG_PARAM_APIMGR", "CONSUMER_KEY", "CONSUMER_SECRET", "DATA_INIZIO_VALIDITA",
				"DATA_FINE_VALIDITA"};
		propertyNames = new String[]{"idConfigParamApimgr", "consumerKey", "consumerSecret", "dataInizioValidita",
				"dataFineValidita"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifCnfParamApimgr] fa riferimento
	 * (TAIF_CNF_PARAM_APIMGR).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_PARAM_APIMGR";
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
