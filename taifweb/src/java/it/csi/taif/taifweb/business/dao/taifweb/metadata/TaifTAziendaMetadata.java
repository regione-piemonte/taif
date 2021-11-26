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
public class TaifTAziendaMetadata extends DAOMetadata {

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
	 * DAO: [taifTAzienda]
	 * tabella: [TAIF_T_AZIENDA].
	 */
	public TaifTAziendaMetadata() {
		columnNames = new String[]{"ID_AZIENDA", "FK_ATTIVITA_PRIMARIA", "FK_ATTIVITA_SECONDARIA", "FK_ATTIVITA_APE",
				"FK_FORMA_GIURIDICA_ITA", "FK_FORMA_GIURIDICA_FRA", "CODICE_FISCALE", "N_SIRET", "PARTITA_IVA", "N_TVA",
				"CCIAA_NUMERO", "CCIAA_SIGLA_PROV", "RAGIONE_SOCIALE", "N_MARCA_BOLLO", "DESCR_ALTRA_FORMA_GIURIDICA",
				"EMAIL", "PEC", "SITO_WEB", "ANNO_INIZIO", "FATTURATO", "PERC_COMMERCIO_FRA", "CLIENT1_FRA",
				"CLIENT2_FRA", "CLIENT3_FRA", "NBRE_SALARIES_FRA", "TEMPS_PLEIN_FRA", "DATA_INSERIMENTO",
				"DATA_AGGIORNAMENTO", "FK_CONFIG_UTENTE"};
		propertyNames = new String[]{"idAzienda", "fkAttivitaPrimaria", "fkAttivitaSecondaria", "fkAttivitaApe",
				"fkFormaGiuridicaIta", "fkFormaGiuridicaFra", "codiceFiscale", "nSiret", "partitaIva", "nTva",
				"cciaaNumero", "cciaaSiglaProv", "ragioneSociale", "nMarcaBollo", "descrAltraFormaGiuridica", "email",
				"pec", "sitoWeb", "annoInizio", "fatturato", "percCommercioFra", "client1Fra", "client2Fra",
				"client3Fra", "nbreSalariesFra", "tempsPleinFra", "dataInserimento", "dataAggiornamento",
				"fkConfigUtente"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [taifTAzienda] fa riferimento
	 * (TAIF_T_AZIENDA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_AZIENDA";
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
