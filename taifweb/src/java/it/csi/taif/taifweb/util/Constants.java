/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "taifweb";

	/**
	 * nome dell'attributo di sessione in cui viene memorizzato il valore corrente del
	 * captcha 
	 */
	public static final String CAPTCHA_SESSION_NAME = "current_captcha_value";

	/*PROTECTED REGION ID(R1581691183) ENABLED START*/
	public static final String FLAG_SI = "S";
	public static final String FLAG_NO = "N";
	public static final String NO = "NO";
	public static final String SI = "SI";

	public static final String TIPOLOGIA_ALBO_IMPRESE = "AIFO";
	public static final String TIPOLOGIA_ELENCO_OPERATORI = "ELOP";

	public static final String ICONA_CANCELLA = "iconaCancella";
	public static final String ICONA_DETTAGLIO = "iconaDettaglio";
	public static final String ICONA_PDF = "iconaPdf";
	public static final String ICONA_OPERATORE = "iconaOperatore";
	public static final String ICONA_MODIFICA = "iconaModifica";
	public static final String ICONA_SALVA = "iconaSalva";

	public static final String ID_AZIENDA_GESTORE_TO_DELETE = "idAziendaGestoreToDelete";

	public static final String WIZARD_DOMANDA = "CpDomanda_wzpDomanda_selectedMultiPanel";
	public static final String WIZARD_SEL_1 = "CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel";
	public static final String WIZARD_VAL_1 = "CpDomanda_wzpDomanda_fpWizard1DatiAnagrafici";
	public static final String WIZARD_VAL_1_1 = "CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1";
	public static final String WIZARD_VAL_1_2 = "CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2";
	public static final String WIZARD_SEL_2 = "CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel";
	public static final String WIZARD_VAL_2 = "CpDomanda_wzpDomanda_fpWizard2DatiSocioEconomici";
	public static final String WIZARD_VAL_2_1 = "CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1";
	public static final String WIZARD_VAL_2_2 = "CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2";
	public static final String WIZARD_SEL_3 = "CpDomanda_wzpDomandaAttivita_selectedMultiPanel";
	public static final String WIZARD_VAL_3 = "CpDomanda_wzpDomanda_fpWizard3Attivita";
	public static final String WIZARD_VAL_3_1 = "CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1";
	public static final String WIZARD_VAL_3_2 = "CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2";
	public static final String WIZARD_VAL_3_3 = "CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3";
	public static final String WIZARD_VAL_4 = "CpDomanda_wzpDomanda_fpWizard4Strutture";
	public static final String WIZARD_SEL_5 = "CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel";
	public static final String WIZARD_VAL_5 = "CpDomanda_wzpDomanda_fpWizard5Attrezzature";
	public static final String WIZARD_VAL_5_1 = "CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub1";
	public static final String WIZARD_VAL_5_2 = "CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2";
	public static final String WIZARD_VAL_6 = "CpDomanda_wzpDomanda_fpWizard6Personale";

	public static final int MACCHINA_MEZZO_TRATTRICI = 1;
	public static final int MACCHINA_MEZZO_MACCHINA_SPECIALE = 1;
	public static final int MACCHINA_MEZZO_MACCHINA_MOVIMENTO_TERRA = 1;
	public static final int MACCHINA_MEZZO_RIMORCHI = 10;
	public static final int MACCHINA_MEZZO_VERRICELLI = 11;
	public static final int MACCHINA_MEZZO_PIATTAFORMA_ELEVABILE = 13;
	public static final int MACCHINA_MEZZO_TRINCIA_FORESTALE = 12;
	public static final int MACCHINA_MEZZO_SEGHERIA_MOBILE = 1;
	public static final int MACCHINA_MEZZO_GRU_A_CAVO = 1;
	public static final int MACCHINA_MEZZO_CIPPRATRICE = 21;
	public static final int MACCHINA_MEZZO_DI_TRASPORTO = 1;

	public static final int ID_ALBO_VALLE_D_AOSTA = 3;

	public static final String TIPO_FIRMA_DIGITALE = "D";
	public static final String TIPO_FIRMA_AUTOGRAFA = "A";
	public static final String DESCR_TIPO_FIRMA_DIGITALE = "DIGITALE";
	public static final String DESCR_TIPO_FIRMA_AUTOGRAFA = "AUTOGRAFA";
	public static final String FORMATO_FILE_PDF = "application/pdf";

	public static final String FILTRO_RICERCA_ALTRI_ALBI = "AA";
	public static final String FILTRO_RICERCA_ALTRI_ALBI_TESTO_ITA = "Altri Albi";
	public static final String FILTRO_RICERCA_ALTRI_ALBI_TESTO_FRA = "Autre Annuaires";
	public static final String FILTRO_RICERCA_CERTIFICAZIONI = "C";
	public static final String FILTRO_RICERCA_CERTIFICAZIONI_TESTO_ITA = "Certificazioni";
	public static final String FILTRO_RICERCA_CERTIFICAZIONI_TESTO_FRA = "Certifications";
	public static final String SESSION_FILTRO_RICERCA_AZIENDE = "FILTRO_RICERCA_AZIENDE";

	public static final String ERR_SERV = " [cod. 110]";
	public static final String ERR_GEN = " [cod. 100]";
	public static final String ERR_INDEX = " [cod. 101]";
	public static final String ERR_MTOM = " [cod. 102]";
	public static final String ERR_AAEP = " [cod. 103]";
	public static final String ERR_LIMAMM = " [cod. 104]";
	public static final String ERR_ACTA = " [cod. 105]";
	public static final String ERR_PRIMPAFORSERV = " [cod. 106]";

	public static final String trattrice = "Trattrice";
	public static final String catSpeciale = "Macchine speciali";
	public static final String catTerra = "Macchine movimento terra";
	public static final String catSegherie = "Spaccalegno/segherie";
	public static final String catGru = "Gru a cavo";
	public static final String catTrasp = "Mezzi di trasporto";
	public static final String rimorchio = "Rimorchio";
	public static final String speciali = "Macchine speciali";
	public static final String terra = "Macchine movimento terra";
	public static final String verricello = "Verricello";
	public static final String PLE = "Piattaforma elevabile PLE";
	public static final String trincia = "Trincia forestale";
	public static final String segherie = "Spaccalegno/segherie";
	public static final String gru = "Gru a cavo";
	public static final String cippatrice = "Cippatrice";
	public static final String mezzi = "Mezzi di trasporto";
	public static final String escavatore = "Escavatore";
	public static final String CODICE_TIPO_ALLEGATO_RICEVUTA_VERSAMENTO = "10";
	public static final String DESCR_TIPO_ALLEGATO_RICEVUTA_VERSAMENTO = "Ricevuta versamento marca da bollo";
	public static final String catZero = "0";
	public static final String speciales = "Machines spéciales";
	public static final String terrassement = "Machines de terrassement";
	public static final String camionRemorque = "Camion/Remorque";
	public static final String altroMezzo = "Altro";
	public static final String pdf = "Pdf";

	public static final String att1 = "esisteAttivita1";
	public static final String att2 = "esisteAttivita2";
	public static final String att3 = "esisteAttivita3";
	public static final String att4 = "esisteAttivita4";
	public static final String att5 = "esisteAttivita5";
	public static final String att6 = "esisteAttivita6";
	public static final String att7 = "esisteAttivita7";
	public static final String att8 = "esisteAttivita8";
	public static final String att9 = "esisteAttivita9";
	public static final String att10 = "esisteAttivitaFr10";
	public static final String att11 = "esisteAttivitaFr11";
	public static final String att12 = "esisteAttivitaFr12";
	public static final String att13 = "esisteAttivitaFr13";
	public static final String att14 = "esisteAttivitaFr14";
	public static final String att15 = "esisteAttivitaFr15";

	public static final String checkTrattici = "checkTrattici";
	public static final String checkSpeciali = "checkSpeciali";
	public static final String checkTerra = "checkTerra";
	public static final String checkRimorchi = "checkRimorchi";
	public static final String checkVerricelli = "checkVerricelli";
	public static final String checkPle = "checkPle";
	public static final String checkTrincia = "checkTrincia";
	public static final String checkSegherie = "checkSegherie";
	public static final String checkGru = "checkGru";
	public static final String checkCippatrici = "checkCippatrici";
	public static final String checkMezziTra = "checkMezziTra";
	public static final String checkSpecialiFr = "checkSpecialiFr";
	public static final String checkTerraFr = "checkTerraFr";
	public static final String checkRimorchiFr = "checkRimorchiFr";
	public static final String checkGrumier = "checkGrumier";
	public static final String checkSemi = "checkSemi";
	public static final String checkMezziAltri = "checkMezziAltri";

	public static final String checkCaschi = "checkCaschi";
	public static final String checkScarponi = "checkScarponi";
	public static final String checkPantaloni = "checkPantaloni";

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
	public static final long INDEX_MAX_SIZE = 5242880;

	public static final String INDEX_ID_ALLEGATO_SELEZIONATO = "ID_ALLEGATO_SELEZIONATO";

	public static final String MIMETYPE_DEFAULT = "application/octet-stream";

	public static final String LANGUAGE_FR = "fr";
	public static final String LANGUAGE_IT = "it";

	public static final String TRACCIATO_FR = "F";
	public static final String TRACCIATO_IT = "I";

	public static final String BACK_DOMANDA_RIEPILOGO = "RIEPILOGO";

	public static final int STATO_BOZZA = 1;
	public static final int STATO_PRESENTATA = 2;
	public static final int STATO_PRESA_IN_CARICO = 3;
	public static final int STATO_ISCRITTA = 4;
	public static final int STATO_SOSPESA = 5;
	public static final int STATO_CANCELLATA = 6;
	public static final int STATO_NON_ACCOLTA = 7;
	public static final int STATO_DA_CONFERMARE = 8;
	public static final int STATO_CONFERMATA = 9;
	public static final int STATO_PER_MANCATA_CONFERMA = 10;

	public static final String STATO_PER_MANCATA_CONFERMA_ITA = "Sospesa - Per mancata conferma";

	public static final String ID_STATO_ITALIA = "1";

	public static final String NAZIONALITA_ITALIA = "I";
	public static final String NAZIONALITA_FRANCIA = "F";

	public static final String FIRMA_IT_LUOGO = "luogo e data ";
	public static final String FIRMA_FR_LUOGO = "Fait à ";
	public static final String FIRMA_IT_DATA = "data creazione documento\n";
	public static final String FIRMA_FR_DATA = "le\n";
	public static final String FIRMA_FORMAT_DATA = "dd/MM/yyyy";

	public static final String FIRMA_IT_FIRMA = "firma";
	public static final String FIRMA_FR_FIRMA = "Signature et cachet de l’entreprise";
	public static final String FIRMA_IT_DIGITAL = "firmata digitalmente";
	public static final String FIRMA_FR_DIGITAL = "Signature digitalment";

	public static final int ID_TIPO_ALLEGATO_SCHEDA_AZIENDA = 8;
	public static final int ID_TIPO_ALLEGATO_MARCA_DA_BOLLO_VDA = 10;

	public static final String MAIL_MITTENTE_TAIF = "comunicazioni@taifweb.it";

	public static final String SESSION_INVIO_DOMANDA = "SESSION_INVIO_DOMANDA";
	public static final String MSG_INVIO_DOMANDA = "La domanda e' stata inviata correttamente";

	public static final String SESSION_CHIUDI_RIEPILOGO = "SESSION_CHIUDI_RIEPILOGO";

	public static final String AAEP_ID_TIPO_SEDE_LEGALE = "1";

	public static final String ISTANZA_TAGLI_UTILIZZAZIONE = "S";
	public static final String ISTANZA_TAGLI_PIOPPETI = "P";
	public static final String ISTANZA_TAGLI_INTERCALARI = "I";
	public static final String DS_ISTANZA_TAGLI_UTILIZZAZIONE = "UTILIZZAZIONE";
	public static final String DS_ISTANZA_TAGLI_PIOPPETI = "PIOPPETI";
	public static final String DS_ISTANZA_TAGLI_INTERCALARI = "INTERCALARI";

	public static final String UNITA_MISURA_TONNELLATE = "Tonnellate";
	public static final int ID_UNITA_MISURA_QUINTALI = 1;
	public static final String UNITA_MISURA_QUINTALI = "Quintali";
	public static final String UNITA_MISURA_METRI_CUBI = "Metri Cubi";

	public static final String CURRENT_CONTENT_PANEL = "currentContentPanel";
	public static final String CP_ISTANZE_TAGLIO_PANEL = "cpIstanzeTaglioPresentate";

	public static final String DEFAULT_ZERO = "0";

	public static final String NO_CORSI = "Nessun corso presente";
	public static final String NO_QUALIFICHE = "Nessuna qualifica presente";
	public static final String NO_RICONOSCIMENTI = "Nessun riconoscimento presente";

	public static final String NULL_VALUE_ISTAT_PROVINCIA = "000";
	public static final String NULL_VALUE_PROVINCIA = "---- Tutte ----";

	/*PROTECTED REGION END*/
}
