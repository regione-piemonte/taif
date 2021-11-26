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
public class TaifTPraticaMetadata extends DAOMetadata {

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
	 * DAO: [taifTPratica]
	 * tabella: [TAIF_T_PRATICA].
	 */
	public TaifTPraticaMetadata() {
		columnNames = new String[]{"ID_PRATICA", "FK_SOGGETTO_GESTORE", "FK_AZIENDA", "DATA_PRESENTAZIONE",
				"DATA_ISCRIZIONE_ALBO", "NUMERO_ALBO", "FLG_SEZIONE", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO",
				"DENOMINAZIONE_ALTRO_ALBO", "FK_CONFIG_UTENTE"};
		propertyNames = new String[]{"idPratica", "fkSoggettoGestore", "fkAzienda", "dataPresentazione",
				"dataIscrizioneAlbo", "numeroAlbo", "flgSezione", "dataInserimento", "dataAggiornamento",
				"denominazioneAltroAlbo", "fkConfigUtente"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTPratica] fa riferimento
	 * (TAIF_T_PRATICA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_PRATICA";
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
