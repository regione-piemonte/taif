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
public class TaifTAttivitaSvoltaDettMetadata extends DAOMetadata {

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
	 * DAO: [taifTAttivitaSvoltaDett]
	 * tabella: [TAIF_T_ATTIVITA_SVOLTA_DETT].
	 */
	public TaifTAttivitaSvoltaDettMetadata() {
		columnNames = new String[]{"ID_ATTIVITA", "PROGRESSIVO", "FK_UNITA_DI_MISURA", "VALORE1", "VALORE2", "VALORE3",
				"PERC_CONTO_TERZI", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO", "FK_CONFIG_UTENTE"};
		propertyNames = new String[]{"idAttivita", "progressivo", "fkUnitaDiMisura", "valore1", "valore2", "valore3",
				"percContoTerzi", "dataInserimento", "dataAggiornamento", "fkConfigUtente"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTAttivitaSvoltaDett] fa riferimento
	 * (TAIF_T_ATTIVITA_SVOLTA_DETT).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_ATTIVITA_SVOLTA_DETT";
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
