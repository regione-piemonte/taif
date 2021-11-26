/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.util;
/**
 * Costanti dell'applicativo
 * @generated
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "topfor";

	/*PROTECTED REGION ID(R-1074371075) ENABLED START*/
	public static final String itaLang = "ITA";
	public static final String fraLang = "FRA";
	public static final String iLang = "I";
	public static final String fLang = "F";

	public static final int GESTORE_SUPERADMIN = 0;
	public static final int GESTORE_PIEMONTE = 1;
	public static final int GESTORE_LIGURIA = 2;
	public static final int GESTORE_VDA = 3;
	public static final int GESTORE_ASDEFS = 4;
	public static final int GESTORE_SEFSAM = 5;

	public static final String TIPO_ACCESSO_ITA = "I";
	public static final String TIPO_ACCESSO_FRA = "F";

	public static final String blank = " ";
	public static final String one = "1";
	public static final String zero = "0";
	public static final String two = "2";
	public static final String three = "3";
	public static final String four = "4";
	public static final String five = "5";
	public static final String six = "6";
	public static final int zeroInt = 0;
	public static final int oneInt = 1;
	public static final int twoInt = 2;
	public static final int fiveInt = 5;
	public static final int sixInt = 6;
	public static final int sevenInt = 7;
	public static final int eightInt = 8;
	public static final int nineInt = 9;

	public static final String TIPO_ACCESSO_OPERATORE_IT = "1";
	public static final String TIPO_ACCESSO_OPERATORE_FR = "2";
	public static final String TIPO_ACCESSO_GESTORE_IT = "3";
	public static final String TIPO_ACCESSO_GESTORE_FR = "4";
	public static final String TIPO_ACCESSO_LIBERO_IT = "5";
	public static final String TIPO_ACCESSO_LIBERO_FR = "6";

	public static final String ID_CORSO_DENOMINAZIONE_ALTRO = "2";

	public static final int ID_STATO_OPERATORE_PUBBLICO = 1;
	public static final int ID_STATO_OPERATORE_NON_PUBBLICO = 0;

	public static final String STATO_OPERATORE_RB_SI = "pubSi";
	public static final String STATO_OPERATORE_RB_NO = "pubNo";

	public static final String STATO_OPERATORE_PUBBLICO_ITA = "PUBBLICO";
	public static final String STATO_OPERATORE_PUBBLICO_FRA = "PUBLIC";
	public static final String STATO_OPERATORE_NON_PUBBLICO_ITA = "NON PUBBLICO";
	public static final String STATO_OPERATORE_NON_PUBBLICO_FRA = "PAS PUBLIC";

	public static final String ID_STATO_SCHEDA_BOZZA = "1";
	public static final String ID_STATO_SCHEDA_VALIDATA = "2";
	public static final String ID_STATO_SCHEDA_NON_VALIDATA = "3";

	public static final int CNF_TIPO_MAIL_TOPFORWEB = 0;
	public static final int MAIL_NORMALE = 1;
	public static final int MAIL_PEC = 2;

	public static final String STATO_SCHEDA_VALIDATA_ITA = "PUBBLICO";
	public static final String STATO_SCHEDA_VALIDATA_FRA = "PUBLIC";
	public static final String STATO_SCHEDA_BOZZA_ITA = "NON PUBBLICO";
	public static final String STATO_SCHEDA_BOZZA_FRA = "PAS PUBLIC";

	public static final String SI_VALUE = "SI";
	public static final String NO_VALUE = "NO";

	public static final String FLAG_ALTRO_CORSO = "2";

	public static final String ESITO_FREQUENZA_CON_PROFITTO = "P";
	public static final String ESITO_FREQUENZA = "F";
	public static final String ESITO_FREQUENZA_CON_PROFITTO_DESC_ITA = "FREQUENZA CON PROFITTO";
	public static final String ESITO_FREQUENZA_DESC_ITA = "FREQUENZA";
	public static final String ESITO_FREQUENZA_CON_PROFITTO_DESC_FRA = "FRÉQUENCE AVEC PROFIT";
	public static final String ESITO_FREQUENZA_DESC_FRA = "FRÉQUENCE";

	public static final String codiciProvince[] = {"001", "002", "003", "004", "005", "006", "096", "103", "008", "009",
			"010", "011", "007"};

	public static final String TESTO_MAIL_STATICO_BLANK = " ";
	public static final String TESTO_MAIL_STATICO_EMPTY_STRING = "";
	public static final String TESTO_MAIL_STATICO_1 = "\t\n";
	public static final String TESTO_MAIL_STATICO_2 = "Sono stati modificati i seguenti campi:";
	public static final String TESTO_MAIL_STATICO_3 = "Per maggiori informazioni";
	public static final String TESTO_MAIL_STATICO_4 = "Motivazione del rifiuto:";
	public static final String TESTO_MAIL_STATICO_5 = "Nella sezione ";
	public static final String TESTO_MAIL_STATICO_6 = "sono state apportate le seguenti modifiche:";

	public static final String LABEL_SEZIONE_1 = "1. Dati Anagrafici ";
	public static final String LABEL_SEZIONE_2 = "2. Corsi finanziati da Regione ";
	public static final String LABEL_SEZIONE_3 = "3. Altri Corsi ";
	public static final String LABEL_SEZIONE_4 = "4. Qualifiche ";
	public static final String LABEL_SEZIONE_5 = "5. Riconoscimenti ";
	/*PROTECTED REGION END*/
}
