/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.metadata;

import it.csi.taif.taifweb.business.dao.metadata.DAOMetadata;

/**
 * @generated
 */
public class TaifDAttivitaAtecoViewMetadata extends DAOMetadata {

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
	 * DAO: [taifDAttivitaAtecoView]
	 * tabella: [TAIF_APPL_SCHEDA_OK].
	 */
	public TaifDAttivitaAtecoViewMetadata() {
		columnNames = new String[]{"ID_AZIENDA", "FLG_SEZ_1_1_ITA_OK", "FLG_SEZ_1_2_ITA_OK", "FLG_SEZ_2_1_ITA_OK",
				"FLG_SEZ_2_2_ITA_OK", "FLG_SEZ_3_1_ITA_OK", "FLG_SEZ_3_2_ITA_OK", "FLG_SEZ_3_3_ITA_OK",
				"FLG_SEZ_4_ITA_OK", "FLG_SEZ_5_1_ITA_OK", "FLG_SEZ_5_2_ITA_OK", "FLG_SEZ_6_ITA_OK",
				"FLG_SEZ_1_1_FRA_OK", "FLG_SEZ_1_2_FRA_OK", "FLG_SEZ_2_1_FRA_OK", "FLG_SEZ_2_2_FRA_OK",
				"FLG_SEZ_3_1_FRA_OK", "FLG_SEZ_3_3_FRA_OK", "FLG_SEZ_4_FRA_OK", "FLG_SEZ_5_2_FRA_OK",
				"FLG_SEZ_6_FRA_OK"};
		propertyNames = new String[]{"idAzienda", "flgSez11ItaOk", "flgSez12ItaOk", "flgSez21ItaOk", "flgSez22ItaOk",
				"flgSez31ItaOk", "flgSez32ItaOk", "flgSez33ItaOk", "flgSez4ItaOk", "flgSez51ItaOk", "flgSez52ItaOk",
				"flgSez6ItaOk", "flgSez11FraOk", "flgSez12FraOk", "flgSez21FraOk", "flgSez22FraOk", "flgSez31FraOk",
				"flgSez33FraOk", "flgSez4FraOk", "flgSez52FraOk", "flgSez6FraOk"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifDAttivitaAtecoView] fa riferimento
	 * (TAIF_APPL_SCHEDA_OK).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_APPL_SCHEDA_OK";
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
