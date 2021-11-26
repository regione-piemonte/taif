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
public class TaifDNazioneMetadata extends DAOMetadata {

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
	 * DAO: [taifDNazione]
	 * tabella: [TAIF_D_NAZIONE].
	 */
	public TaifDNazioneMetadata() {
		columnNames = new String[]{"ID_NAZIONE", "NAZIONE_ITA", "NAZIONE_FRA", "MTD_ORDINAMENTO_ITA",
				"MTD_ORDINAMENTO_FRA", "MTD_FLG_VISIBILE"};
		propertyNames = new String[]{"idNazione", "nazioneIta", "nazioneFra", "mtdOrdinamentoIta", "mtdOrdinamentoFra",
				"mtdFlgVisibile"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifDNazione] fa riferimento
	 * (TAIF_D_NAZIONE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_NAZIONE";
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
