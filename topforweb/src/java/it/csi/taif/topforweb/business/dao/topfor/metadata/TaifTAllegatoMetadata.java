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
public class TaifTAllegatoMetadata extends DAOMetadata {

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
	 * DAO: [taifTAllegato]
	 * tabella: [TAIF_T_ALLEGATO].
	 */
	public TaifTAllegatoMetadata() {
		columnNames = new String[]{"ID_ALLEGATO", "FK_PRATICA", "FK_CORSO", "FK_PERSONA", "FK_ESTENSIONE_FILE",
				"FK_TIPO_ALLEGATO", "NOME_FILE", "DIMENSIONE_FILE_KB", "FLG_TIPO_INVIO", "FLG_SCADENZA", "DATA_UPLOAD",
				"NOTE", "ESTENSIONE_FILE", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO", "FK_CONFIG_UTENTE"};
		propertyNames = new String[]{"idAllegato", "fkPratica", "fkCorso", "fkPersona", "fkEstensioneFile",
				"fkTipoAllegato", "nomeFile", "dimensioneFileKb", "flgTipoInvio", "flgScadenza", "dataUpload", "note",
				"estensioneFile", "dataInserimento", "dataAggiornamento", "fkConfigUtente"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTAllegato] fa riferimento
	 * (TAIF_T_ALLEGATO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_ALLEGATO";
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
