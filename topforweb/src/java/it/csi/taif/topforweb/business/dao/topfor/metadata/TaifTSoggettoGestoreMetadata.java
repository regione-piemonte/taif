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
public class TaifTSoggettoGestoreMetadata extends DAOMetadata {

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
	 * DAO: [taifTSoggettoGestore]
	 * tabella: [TAIF_T_SOGGETTO_GESTORE].
	 */
	public TaifTSoggettoGestoreMetadata() {
		columnNames = new String[]{"ID_SOGGETTO_GESTORE", "CODICE", "DENOMINAZIONE_BREVE", "DENOMINAZIONE",
				"ISTAT_COMUNE", "COMUNE_ESTERO", "INDIRIZZO", "CIVICO", "CAP", "TELEFONO", "CELLULARE", "MAIL", "PEC",
				"REFERENTE", "MTD_ORDINAMENTO", "MTD_FLG_VISIBILE", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO",
				"URL_DOC_PRIVACY"};
		propertyNames = new String[]{"idSoggettoGestore", "codice", "denominazioneBreve", "denominazione",
				"istatComune", "comuneEstero", "indirizzo", "civico", "cap", "telefono", "cellulare", "mail", "pec",
				"referente", "mtdOrdinamento", "mtdFlgVisibile", "dataInserimento", "dataAggiornamento",
				"urlDocPrivacy"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTSoggettoGestore] fa riferimento
	 * (TAIF_T_SOGGETTO_GESTORE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_SOGGETTO_GESTORE";
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
