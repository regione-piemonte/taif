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
public class TaifRAttivDetMaterialeMetadata extends DAOMetadata {

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
	 * DAO: [taifRAttivDetMateriale]
	 * tabella: [TAIF_R_ATTIVDET_MATERIALE].
	 */
	public TaifRAttivDetMaterialeMetadata() {
		columnNames = new String[]{"ID_MATERIALE", "ID_ATTIVITA", "PROGRESSIVO", "DESCR_ALTRO_MATERIALE",
				"DATA_INSERIMENTO", "DATA_AGGIORNAMENTO", "FK_CONFIG_UTENTE"};
		propertyNames = new String[]{"idMateriale", "idAttivita", "progressivo", "descrAltroMateriale",
				"dataInserimento", "dataAggiornamento", "fkConfigUtente"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifRAttivDetMateriale] fa riferimento
	 * (TAIF_R_ATTIVDET_MATERIALE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_ATTIVDET_MATERIALE";
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
