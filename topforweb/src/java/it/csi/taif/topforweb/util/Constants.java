/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "topforweb";

	/**
	 * nome dell'attributo di sessione in cui viene memorizzato il valore corrente del
	 * captcha 
	 */
	public static final String CAPTCHA_SESSION_NAME = "current_captcha_value";

	/*PROTECTED REGION ID(R1581691183) ENABLED START*/
	//public static final String TIPOLOGIA_ALBO_IMPRESE = "AIFO";
	public static final String TIPOLOGIA_ELENCO_OPERATORI = "ELOP";

	public static final String ICONA_CANCELLA = "iconaCancella";
	public static final String ICONA_DETTAGLIO = "iconaDettaglio";
	public static final String ICONA_ATTESTATO = "iconaAttestato";
	public static final String ICONA_PDF = "iconaPdf";

	public static final String WIZARD_OPERATORE = "cpInserimentoOperatore_wzpOperatore_selectedMultiPanel";
	public static final String WIZARD_SEL_1 = "cpInserimentoOperatore_wzpOperatore_selectedMultiPanel";
	public static final String WIZARD_VAL_1 = "cpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore";

	public static final String WIZARD_SEL_2 = "cpInserimentoOperatore_wzpOperatore_selectedMultiPanel";
	public static final String WIZARD_VAL_2 = "cpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore";

	public static final String WIZARD_SEL_3 = "cpInserimentoOperatore_wzpOperatore_selectedMultiPanel";
	public static final String WIZARD_VAL_3 = "cpInserimentoOperatore_wzpOperatore_selectedMultiPanel";

	public static final String WIZARD_VAL_4 = "cpInserimentoOperatore_wzpOperatore_selectedMultiPanel";
	public static final String WIZARD_SEL_4 = "cpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore";

	public static final String WIZARD_VAL_5 = "cpInserimentoOperatore_wzpOperatore_selectedMultiPanel";
	public static final String WIZARD_SEL_5 = "cpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore";

	public static final String ID_CORSO_FINANZIATO_TO_DELETE = "idCorsoFinanziatoRegioneToDelete";

	public static final String INDEX_UTENTE = "Utente Taif";
	public static final String INDEX_USERNAME_ADMIN = "admin@taif";
	public static final String INDEX_PSW = "taif";
	public static final String INDEX_FRUITORE = "taif";
	public static final String INDEX_REPOSITORY = "primary";
	public static final String INDEX_DEFAULT_PREFIX = "cm:";
	public static final String INDEX_PREFIX = "taif:";
	public static final String INDEX_PREFIX_NAME = "cm:content";
	public static final String INDEX_PREFIX_MODEL = "cm:contentmodel";
	public static final String INDEX_PREFIX_FOLDER = "cm:folder";
	public static final String INDEX_PREFIX_NAME_SHORT = "cm:name";
	public static final String INDEX_PREFIX_CONTAINS = "cm:contains";
	public static final String INDEX_ROOT = "/app:company_home/cm:taif";
	public static final String INDEX_TYPE_TEXT = "d:text";
	public static final String INDEX_FOLDER_SUFFIX = "/cm:";
	public static final String INDEX_METADATO_SUFFIX = "@cm\\:";
	public static final String INDEX_ALLEGATO_NAME = "taif:allegato";
	public static final String INDEX_ENCODING = "UTF-8";
	public static final String INDEX_TAIF_PREFIX_MODEL = "taif:model";
	public static final String INDEX_TAIF_TIPO_PROCEDURA = "ELOP";

	public static final String ERR_SERV = " [cod. 110]";
	public static final String ERR_GEN = " [cod. 100]";
	public static final String ERR_INDEX = " [cod. 101]";
	public static final String ERR_MTOM = " [cod. 102]";
	public static final String ERR_AAEP = " [cod. 103]";
	public static final String ERR_LIMAMM = " [cod. 104]";

	public static final String ESTENSIONE_ALLEGATO_PDF = "pdf";
	public static final int ID_ESTENSIONE_ALLEGATO_PDF = 1;
	public static final int ID_TIPO_ALLEGATO_ATTESTATO = 9; // taif_cnf_tipo_allegato

	public static final String LANGUAGE_FR = "fr";
	public static final String LANGUAGE_IT = "it";

	public static final String TRACCIATO_FR = "F";
	public static final String TRACCIATO_IT = "I";

	public static final String NAZIONALITA_ITALIA = "I";
	public static final String NAZIONALITA_FRANCIA = "F";

	public static final String LINGUA_DATI_FRA = "FRA";
	public static final String LINGUA_DATI_ITA = "ITA";

	public static final String NAZIONE_IT = "IT";
	public static final String NAZIONE_FR = "FR";

	public static final String NESSUN_DATO = "Nessun dato";

	public static final String INDEX_ID_ALLEGATO_SELEZIONATO = "ID_ALLEGATO_SELEZIONATO";

	public static final String blank = " ";

	public static final String SI_VALUE = "SI";
	public static final String NO_VALUE = "NO";
	public static final String FIRMA_FORMAT_DATA = "dd/MM/yyyy";

	public static final String MIMETYPE_DEFAULT = "application/octet-stream";

	public static final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_IT = //NOSONAR  Reason:EIAS
			"OK_GESTORE_IT"; //NOSONAR  Reason:EIAS
	public static final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_FR = //NOSONAR  Reason:EIAS
			"OK_GESTORE_FR"; //NOSONAR  Reason:EIAS
	public static final String EXECUTEINIT_OUTCOME_CODE__GESTORE_KO = //NOSONAR  Reason:EIAS
			"initKO"; //NOSONAR  Reason:EIAS
	public static final String EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_IT = //NOSONAR  Reason:EIAS
			"OK_OPERATORE_IT"; //NOSONAR  Reason:EIAS
	public static final String EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_FR = //NOSONAR  Reason:EIAS
			"OK_OPERATORE_FR"; //NOSONAR  Reason:EIAS
	public static final String EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT = //NOSONAR  Reason:EIAS
			"OK_LIBERO_IT"; //NOSONAR  Reason:EIAS
	public static final String EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_FR = //NOSONAR  Reason:EIAS
			"OK_LIBERO_FR"; //NOSONAR  Reason:EIAS
	public static final String IDENTIFICAPROFILO_OUTCOME_CODE__INITKO = //NOSONAR  Reason:EIAS
			"initKO"; //NOSONAR  Reason:EIAS

	public static final String NULL_VALUE_ISTAT_PROVINCIA = "000";
	public static final String NULL_VALUE_PROVINCIA = "---- Tutte ----";

	public static final String NULL_VALUE_ID_AMBITO_FORMATIVO = "0";
	public static final String NULL_VALUE_AMBITO_FORMATIVO = "---- Tutti ----";

	/*PROTECTED REGION END*/
}
