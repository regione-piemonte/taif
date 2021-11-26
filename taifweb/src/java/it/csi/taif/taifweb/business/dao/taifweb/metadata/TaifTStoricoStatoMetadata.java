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
public class TaifTStoricoStatoMetadata extends DAOMetadata {

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
	 * DAO: [taifTStoricoStato]
	 * tabella: [TAIF_T_STORICO_STATO].
	 */
	public TaifTStoricoStatoMetadata() {
		columnNames = new String[]{"ID_PRATICA", "DATA_INSERIMENTO_STATO", "FK_STATO_PRATICA", "NUMERO_PROTOCOLLO",
				"DATA_PROTOCOLLO", "DATA_AGGIORNAMENTO", "NOTE", "FK_CONFIG_UTENTE", "DATA_FINE_STATO"};
		propertyNames = new String[]{"idPratica", "dataInserimentoStato", "fkStatoPratica", "numeroProtocollo",
				"dataProtocollo", "dataAggiornamento", "note", "fkConfigUtente", "dataFineStato"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTStoricoStato] fa riferimento
	 * (TAIF_T_STORICO_STATO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_STORICO_STATO";
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
