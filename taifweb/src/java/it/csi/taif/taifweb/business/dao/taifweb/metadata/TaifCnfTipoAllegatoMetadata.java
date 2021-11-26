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
public class TaifCnfTipoAllegatoMetadata extends DAOMetadata {

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
	 * DAO: [taifCnfTipoAllegato]
	 * tabella: [TAIF_CNF_TIPO_ALLEGATO].
	 */
	public TaifCnfTipoAllegatoMetadata() {
		columnNames = new String[]{"ID_TIPO_ALLEGATO", "FK_PROCEDURA", "TIPO_ALLEGATO", "MTD_ORDINAMENTO",
				"MTD_FLG_VISIBILE", "MTD_FLG_ITA_FRA", "FLG_CONTESTO", "FLG_FIRMA", "FLG_DOWNLOAD", "FLG_UPLOAD",
				"FLG_INVIO", "ACTA_OGGETTO", "ACTA_FLG_ALLEGATI", "ACTA_STATO_DI_EFFICACIA"};
		propertyNames = new String[]{"idTipoAllegato", "fkProcedura", "tipoAllegato", "mtdOrdinamento",
				"mtdFlgVisibile", "mtdFlgItaFra", "flgContesto", "flgFirma", "flgDownload", "flgUpload", "flgInvio",
				"actaOggetto", "actaFlgAllegati", "actaStatoDiEfficacia"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifCnfTipoAllegato] fa riferimento
	 * (TAIF_CNF_TIPO_ALLEGATO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_TIPO_ALLEGATO";
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
