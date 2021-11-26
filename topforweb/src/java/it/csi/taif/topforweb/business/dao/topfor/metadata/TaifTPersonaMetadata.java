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
public class TaifTPersonaMetadata extends DAOMetadata {

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
	 * DAO: [taifTPersona]
	 * tabella: [TAIF_T_PERSONA].
	 */
	public TaifTPersonaMetadata() {
		columnNames = new String[]{"ID_PERSONA", "FK_TITOLO_STUDIO", "FK_TITOLO_STUDIO_FRA", "FK_NAZIONE",
				"CODICE_FISCALE", "N_RSI_MSA", "COGNOME", "NOME", "FLG_SESSO", "DATA_NASCITA", "ISTAT_COMUNE_NASCITA",
				"COMUNE_ESTERO_NASCITA", "ISTAT_COMUNE_RES", "COMUNE_ESTERO_RES", "INDIRIZZO_RES", "CIVICO_RES",
				"CAP_RES", "TELEFONO", "CELLULARE", "MAIL", "ALTRI_STUDI", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO",
				"FK_CONFIG_UTENTE", "PWD"};
		propertyNames = new String[]{"idPersona", "fkTitoloStudio", "fkTitoloStudioFra", "fkNazione", "codiceFiscale",
				"nRsiMsa", "cognome", "nome", "flgSesso", "dataNascita", "istatComuneNascita", "comuneEsteroNascita",
				"istatComuneRes", "comuneEsteroRes", "indirizzoRes", "civicoRes", "capRes", "telefono", "cellulare",
				"mail", "altriStudi", "dataInserimento", "dataAggiornamento", "fkConfigUtente", "pwd"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTPersona] fa riferimento
	 * (TAIF_T_PERSONA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_PERSONA";
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
