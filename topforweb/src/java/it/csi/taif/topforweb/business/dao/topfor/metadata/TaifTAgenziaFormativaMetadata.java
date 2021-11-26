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
public class TaifTAgenziaFormativaMetadata extends DAOMetadata {

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
	 * DAO: [taifTAgenziaFormativa]
	 * tabella: [TAIF_T_AGENZIA_FORMATIVA].
	 */
	public TaifTAgenziaFormativaMetadata() {
		columnNames = new String[]{"ID_AGENZIA_FORMATIVA", "CODICE_FISCALE", "PARTITA_IVA", "RAGIONE_SOCIALE",
				"CODICE_PSR", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO", "ISTAT_SEDE", "COMUNE_ESTERO", "INDIRIZZO",
				"CAP", "FK_CONFIG_UTENTE", "FLG_VISIBILE", "MTD_ORDINAMENTO"};
		propertyNames = new String[]{"idAgenziaFormativa", "codiceFiscale", "partitaIva", "ragioneSociale", "codicePsr",
				"dataInserimento", "dataAggiornamento", "istatSede", "comuneEstero", "indirizzo", "cap",
				"fkConfigUtente", "flgVisibile", "mtdOrdinamento"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTAgenziaFormativa] fa riferimento
	 * (TAIF_T_AGENZIA_FORMATIVA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_AGENZIA_FORMATIVA";
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
