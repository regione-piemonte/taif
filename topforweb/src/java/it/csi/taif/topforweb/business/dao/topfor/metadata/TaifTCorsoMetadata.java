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
public class TaifTCorsoMetadata extends DAOMetadata {

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
	 * DAO: [taifTCorso]
	 * tabella: [TAIF_T_CORSO].
	 */
	public TaifTCorsoMetadata() {
		columnNames = new String[]{"ID_CORSO", "FK_AGENZIA_FORMATIVA", "FK_UNITA_FORMATIVA", "CORSO", "CODICE_PSR",
				"DATA_INIZIO", "DATA_FINE", "NRO_ORE", "ISTAT_SEDE", "COMUNE_ESTERO_SEDE", "INDIRIZZO",
				"FLG_ALTRO_CORSO", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO", "MTD_ORDINAMENTO", "MTD_FLG_VISIBILE",
				"MTD_FLG_ITA_FRA", "FK_CONFIG_UTENTE"};
		propertyNames = new String[]{"idCorso", "fkAgenziaFormativa", "fkUnitaFormativa", "corso", "codicePsr",
				"dataInizio", "dataFine", "nroOre", "istatSede", "comuneEsteroSede", "indirizzo", "flgAltroCorso",
				"dataInserimento", "dataAggiornamento", "mtdOrdinamento", "mtdFlgVisibile", "mtdFlgItaFra",
				"fkConfigUtente"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTCorso] fa riferimento
	 * (TAIF_T_CORSO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_CORSO";
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
