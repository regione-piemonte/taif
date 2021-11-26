/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.validation;

/**
 * Costanti per il riferimento ai campi.
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 * @author 71908 (Ansoumana Mane)
 */
public final class FieldList {
	
	// Login
	public static final String LOGIN_USER = "appDatalogin.user";
	public static final String LOGIN_PASS = "appDatalogin.password";
    
	//Profilo
	
	public static final String PROFILO = "appDatacurrentUser.user";
	// Scheda 1
        public static final String OPERATORE_FOREST_CODICE_FISCALE = "appDatadatiOperatore.codiceFiscaleOperatore";
        public static final String OPERATORE_FOREST_NOME ="appDatadatiOperatore.nomeOperatore";
        public static final String OPERATORE_FOREST_COGNOME ="appDatadatiOperatore.cognomeOperatore";
        public static final String OPERATORE_FOREST_DATA_NASCITA ="appDatadatiOperatore.dataNascitaOperatore";
        public static final String OPERATORE_FOREST_CAP ="appDatatitolareRappresentanteLegale.cap";
        public static final String OPERATORE_FOREST_INDIRIZZO ="appDatadatiOperatore.indirizzoResidenzaOperatore";
        public static final String OPERATORE_FOREST_CIVICO ="appDatadatiOperatore.civicoResidenzaOperatore";
        public static final String OPERATORE_FOREST_TELEFONO ="appDatadatiOperatore.telefonoOperatore";
        public static final String OPERATORE_FOREST_EMAIL ="appDatatitolareRappresentanteLegale.email";
        public static final String OPERATORE_FOREST_ID_STATO_NASCITA="appDataidNazioneNascitaSelezionata";
        public static final String OPERATORE_PRIVACY="appDataPrivacy";
        public static final String OPERATORE_CONSENSO_PUBBLICAZIONE="appDataConsensoPubblicazione";
        public static final String OPERATORE_FOREST_COM_REZIDENZA="";
        public static final String OPERATORE_FOREST_COM_NASCITA="widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascita";
        public static final String OPERATORE_FOREST_ID_STATO_OP="appDatadatiOperatore.statoOperatore";
        public static final String OPERATORE_FOREST_CELLULARE ="appDatadatiOperatore.cellulareOperatore";
        public static final String OPERATORE_FOREST_PUBBLICABILITA ="appDatadatiOperatore.cellulareOperatore";
        public static final String OPERATORE_RADIO_PUB_SEL="widg_rbPubblicabilitaGroup";
    
    
    
    // Scheda 2
    public static final String ESITO_CORSO_FINANZIATO_REGIONE="appDatacorsoSelezionatoInserimento.esitoCorso";
    public static final String AGENZIA_FORMATIVA_CORSO_FINANZIATO_REGIONE="appDatacorsoSelezionatoInserimento.agenziaFormativa";
    public static final String UNITA_FORMATIVA_CORSO_FINANZIATO_REGIONE="appDatacorsoSelezionatoInserimento.unitaFormativa";
    public static final String TITOLO_CORSO_FINANZIATO_REGIONE="appDatacorsoSelezionatoInserimento.titoloCorso";
    
    // Scheda 3
    public static final String ID_CORSO_ALTRI_CORSI="appDataaltroCorsoSelezionatoInserimento.idCorsoProfessionale";
    public static final String ESITO_ALTRO_CORSO="appDataaltroCorsoSelezionatoInserimento.esitoCorso";
    public static final String DESCRIZIONE_CORSO_ALTRI_CORSI="appDataaltroCorsoSelezionatoInserimento.descrizioneAltroCorso";
    public static final String TITOLO_CORSO_ALTRI_CORSI="appDataaltroCorsoSelezionatoInserimento.idCorsoProfessionale";
    public static final String ATTESTATO_SCADENZA_ALTRO_CORSO="appDataaltroCorsoSelezionatoInserimento.attestatoConScandeza";
    public static final String UPLOAD_ATTESTATO_ALTRO_CORSO="widg_updFileAttestatoAltriCorsi";
    
    // Scheda 4
    public static final String QUALIFICHE_QUALIFICA="appDataqualificaSelezionataInserimento.idQualifica";
    public static final String QUALIFICHE_AGENZIA_FORMATIVA="appDataqualificaSelezionataInserimento.agenziaFormativa";
    public static final String QUALIFICHE_DATA_QUALIFICA="appDataqualificaSelezionataInserimento.dataQualifica";
   
    // Scheda 5
    public static final String RICONOSCIMENTI_AGENZIA_FORMATIVA="appDatariconoscimentoSelezionatoInserimento.agenziaFormativa";
    public static final String RICONOSCIMENTI_UNITA_FORMATIVA="appDatariconoscimentoSelezionatoInserimento.unitaFormativa";
    public static final String RICONOSCIMENTI_DATA_RICONOSCIMENTO="appDatariconoscimentoSelezionatoInserimento.dataRiconoscimento";
    public static final String RICONOSCIMENTI_NOTE="appDatariconoscimentoSelezionatoInserimento.note";
   

    
    /**
     * Constructor.
     */
    private FieldList() {
        /* NOP */
    }

}
