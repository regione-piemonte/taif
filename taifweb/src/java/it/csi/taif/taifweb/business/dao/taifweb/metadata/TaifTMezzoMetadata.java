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
public class TaifTMezzoMetadata extends DAOMetadata {

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
	 * DAO: [taifTMezzo]
	 * tabella: [TAIF_T_MEZZO].
	 */
	public TaifTMezzoMetadata() {
		columnNames = new String[]{"ID_MEZZO", "FK_AZIENDA", "FK_ALIMENTAZIONE", "FK_TIPO_CARRELLO", "FK_TIPO_MEZZO",
				"FK_TRAZIONE", "ANNO", "POTENZA_KW", "PORTATA_KG", "FLG_COMANDATO_DISTANZA", "FLG_NOLEGGIO",
				"DATA_INSERIMENTO", "DATA_AGGIORNAMENTO", "FK_CONFIG_UTENTE", "DESCR_ALTRO"};
		propertyNames = new String[]{"idMezzo", "fkAzienda", "fkAlimentazione", "fkTipoCarrello", "fkTipoMezzo",
				"fkTrazione", "anno", "potenzaKw", "portataKg", "flgComandatoDistanza", "flgNoleggio",
				"dataInserimento", "dataAggiornamento", "fkConfigUtente", "descrAltro"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTMezzo] fa riferimento
	 * (TAIF_T_MEZZO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_MEZZO";
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
