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
public class TaifDStatoPraticaMetadata extends DAOMetadata {

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
	 * DAO: [taifDStatoPratica]
	 * tabella: [TAIF_D_STATO_PRATICA].
	 */
	public TaifDStatoPraticaMetadata() {
		columnNames = new String[]{"ID_STATO_PRATICA", "FK_STATO_PADRE", "STATO_PRATICA_ITA", "STATO_PRATICA_FRA",
				"MTD_ORDINAMENTO", "MTD_FLG_VISIBILE"};
		propertyNames = new String[]{"idStatoPratica", "fkStatoPadre", "statoPraticaIta", "statoPraticaFra",
				"mtdOrdinamento", "mtdFlgVisibile"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifDStatoPratica] fa riferimento
	 * (TAIF_D_STATO_PRATICA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_STATO_PRATICA";
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
