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
public class TaifTCommercializzazioneMetadata extends DAOMetadata {

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
	 * DAO: [taifTCommercializzazione]
	 * tabella: [TAIF_T_COMMERCIALIZZAZIONE].
	 */
	public TaifTCommercializzazioneMetadata() {
		columnNames = new String[]{"ID_COMMERCIALIZZAZIONE", "FK_AZIENDA", "FK_SPECIE", "FK_PROVENIENZA",
				"FK_DESTINAZIONE", "FK_ASSORTIMENTO", "FK_UNITA_DI_MISURA", "VENDUTO_MEDIO", "FLG_TAGLIATO_ACQUISTATO",
				"DATA_INSERIMENTO", "DATA_AGGIORNAMENTO", "FK_CONFIG_UTENTE", "NOTE"};
		propertyNames = new String[]{"idCommercializzazione", "fkAzienda", "fkSpecie", "fkProvenienza",
				"fkDestinazione", "fkAssortimento", "fkUnitaDiMisura", "vendutoMedio", "flgTagliatoAcquistato",
				"dataInserimento", "dataAggiornamento", "fkConfigUtente", "note"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTCommercializzazione] fa riferimento
	 * (TAIF_T_COMMERCIALIZZAZIONE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_COMMERCIALIZZAZIONE";
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
