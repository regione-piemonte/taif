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
public class TaifCnfConfigUtenteMetadata extends DAOMetadata {

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
	 * DAO: [taifCnfConfigUtente]
	 * tabella: [TAIF_CNF_CONFIG_UTENTE].
	 */
	public TaifCnfConfigUtenteMetadata() {
		columnNames = new String[]{"ID_CONFIG_UTENTE", "FK_PROFILO_UTENTE", "FK_PERSONA", "FK_SOGGETTO_GESTORE",
				"NR_ACCESSI", "DATA_PRIMO_ACCESSO", "DATA_ULTIMO_ACCESSO"};
		propertyNames = new String[]{"idConfigUtente", "fkProfiloUtente", "fkPersona", "fkSoggettoGestore", "nrAccessi",
				"dataPrimoAccesso", "dataUltimoAccesso"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifCnfConfigUtente] fa riferimento
	 * (TAIF_CNF_CONFIG_UTENTE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_CONFIG_UTENTE";
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
