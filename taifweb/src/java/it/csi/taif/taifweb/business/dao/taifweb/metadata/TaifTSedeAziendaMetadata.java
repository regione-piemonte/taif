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
public class TaifTSedeAziendaMetadata extends DAOMetadata {

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
	 * DAO: [taifTSedeAzienda]
	 * tabella: [TAIF_T_SEDE_AZIENDA].
	 */
	public TaifTSedeAziendaMetadata() {
		columnNames = new String[]{"ID_SEDE", "FK_AZIENDA", "FK_TIPO_SEDE", "ISTAT_COMUNE", "COMUNE_ESTERO",
				"INDIRIZZO", "CIVICO", "CAP", "TELEFONO", "CELLULARE", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO",
				"FK_CONFIG_UTENTE"};
		propertyNames = new String[]{"idSede", "fkAzienda", "fkTipoSede", "istatComune", "comuneEstero", "indirizzo",
				"civico", "cap", "telefono", "cellulare", "dataInserimento", "dataAggiornamento", "fkConfigUtente"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTSedeAzienda] fa riferimento
	 * (TAIF_T_SEDE_AZIENDA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_SEDE_AZIENDA";
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
