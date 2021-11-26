#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpInserimentoOperatore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpInserimentoOperatore() {
	var contentPanelName = "cpInserimentoOperatore";
	/// arricchimento di base per guigen::TextField [tInserimentoCodiceFiscale]
	var addBasicEnrichmentToTInserimentoCodiceFiscale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoCodiceFiscale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoCodiceFiscale);
	/// arricchimento di base per guigen::TextField [tfInserimentoOperatoreNrsiMsa]
	var addBasicEnrichmentToTfInserimentoOperatoreNrsiMsa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInserimentoOperatoreNrsiMsa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTfInserimentoOperatoreNrsiMsa);
	/// arricchimento di base per guigen::TextField [tInserimentoCognome]
	var addBasicEnrichmentToTInserimentoCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoCognome);
	/// arricchimento di base per guigen::TextField [tInserimentoNome]
	var addBasicEnrichmentToTInserimentoNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoNome);
	/// arricchimento per guigen::Calendar [calInserimentoDataNascita]: aggiunta datepicker
	var addDateToCalInserimentoDataNascita = function(){
		uiNRichLib.addDatePickerNRich("widg_calInserimentoDataNascita", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addDateToCalInserimentoDataNascita);


	/// arricchimento di base per guigen::TextField [tComuneNascitaEstero]
	var addBasicEnrichmentToTComuneNascitaEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tComuneNascitaEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTComuneNascitaEstero);

	/// arricchimento di base per guigen::TextField [tComuneEsteroResidenza]
	var addBasicEnrichmentToTComuneEsteroResidenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tComuneEsteroResidenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTComuneEsteroResidenza);
	/// arricchimento di base per guigen::TextField [tInserimentoIndirizzo]
	var addBasicEnrichmentToTInserimentoIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoIndirizzo);
	/// arricchimento di base per guigen::TextField [tInserimentoCivico]
	var addBasicEnrichmentToTInserimentoCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoCivico);
	/// arricchimento di base per guigen::TextField [tInserimentoCAP]
	var addBasicEnrichmentToTInserimentoCAP =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoCAP',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoCAP);
	/// arricchimento di base per guigen::TextField [tInserimentoTelefono]
	var addBasicEnrichmentToTInserimentoTelefono =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoTelefono',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoTelefono);
	/// arricchimento di base per guigen::TextField [tInserimentoCellulare]
	var addBasicEnrichmentToTInserimentoCellulare =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoCellulare',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoCellulare);
	/// arricchimento di base per guigen::TextField [tInserimentoEmail]
	var addBasicEnrichmentToTInserimentoEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoEmail);

	/// arricchimento di base per guigen::TextField [tInserimentoMotivazioneRifiutoValidazione]
	var addBasicEnrichmentToTInserimentoMotivazioneRifiutoValidazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tInserimentoMotivazioneRifiutoValidazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoDatiAnagraficiOperatore", addBasicEnrichmentToTInserimentoMotivazioneRifiutoValidazione);





	/// arricchimento di base per guigen::TextField [tfDescrizioniAltriCorsi]
	var addBasicEnrichmentToTfDescrizioniAltriCorsi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDescrizioniAltriCorsi',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoAltriCorsi", addBasicEnrichmentToTfDescrizioniAltriCorsi);




	/// arricchimento per guigen::Calendar [calDataQualifica]: aggiunta datepicker
	var addDateToCalDataQualifica = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataQualifica", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoQualifiche", addDateToCalDataQualifica);


	/// arricchimento di base per guigen::TextField [tfNoteRiconoscimento]
	var addBasicEnrichmentToTfNoteRiconoscimento =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNoteRiconoscimento',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRiconoscimenti", addBasicEnrichmentToTfNoteRiconoscimento);
	/// arricchimento per guigen::Calendar [calDataRiconoscimento]: aggiunta datepicker
	var addDateToCalDataRiconoscimento = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataRiconoscimento", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRiconoscimenti", addDateToCalDataRiconoscimento);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpInserimentoOperatore(){
/*PROTECTED REGION ID(R-1717018867) ENABLED START*/
	/*
	 * definire e registrare qui eventuali arricchimenti custom, nel formato:
	 * var customEnr_n = function(){
	 *	// codice da eseguire all'applicazione dell'arricchimento
	 * };
	 * String customEnr_fragmentID = p_[id del pannello a cui deve essere associato l'arricchimento];
	 * uiEnricherMgr.registerEnrichment(contentPanelName, customEnr_fragmentID, customEnr_n);
	*/

/*PROTECTED REGION END*/
}

function initUIStructCpInserimentoOperatore(){
	var contentPanelName = "cpInserimentoOperatore";
	var structure =
      {
        name: "p_fpInserimentoOperatore", panels: [
        {
          name: "p_fpInserimentoOperatoreUserInfo", panels: [
          {
            name: "p_uipInserimentoOperatore", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpInserimentoOperatoreBody", panels: [
          {
            name: "p_wzpOperatore", panels: [
            {
              name: "p_fpWizardDatiAnagraficiOperatore", panels: [
              {
                name: "p_smpOperatore1.1", panels: [
                ]
              }
,              {
                name: "p_wpInserimentoDatiAnagraficiOperatore", panels: []
              }
,              {
                name: "p_wpConsensoPrivacy", panels: []
              }
,              {
                name: "p_wpConsensoPubblicazione", panels: []
              }
              ]
            }
,            {
              name: "p_fpWizardCorsiFinanziatiRegioneOperatore", panels: [
              {
                name: "p_smpOperatore1.2", panels: [
                ]
              }
,              {
                name: "p_wpInserimentoCorsiFinanziatiRegione", panels: []
              }
,              {
                name: "p_wpInserimentoElencoCorsiFinanziatiRegione", panels: []
              }
,              {
                name: "p_dpConfermaEliminaCorsoFinanziatoRegione", panels: [
                ]
              }
              ]
            }
,            {
              name: "p_fpWizardAltriCorsiOperatore", panels: [
              {
                name: "p_smpOperatore1.3", panels: [
                ]
              }
,              {
                name: "p_wpInserimentoAltriCorsi", panels: []
              }
,              {
                name: "p_wpInserimentoElencoAltriCorsi", panels: []
              }
,              {
                name: "p_dpConfermaEliminaAltroCorso", panels: [
                ]
              }
              ]
            }
,            {
              name: "p_fpWizardQualificheOperatore", panels: [
              {
                name: "p_smpOperatore1.4", panels: [
                ]
              }
,              {
                name: "p_wpInserimentoQualifiche", panels: []
              }
,              {
                name: "p_wpInserimentoElencoQualifiche", panels: []
              }
,              {
                name: "p_dpConfermaEliminaQualifica", panels: [
                ]
              }
              ]
            }
,            {
              name: "p_fpWizardRiconoscimentiOperatore", panels: [
              {
                name: "p_smpOperatore1.2", panels: [
                ]
              }
,              {
                name: "p_wpRiconoscimenti", panels: []
              }
,              {
                name: "p_wpInserimentoRiconoscimenti", panels: []
              }
,              {
                name: "p_dpConfermaEliminaRiconoscimento", panels: [
                ]
              }
              ]
            }
            ]
          }
,          {
            name: "p_cmdWizardOperatore", panels: []
          }
          ]
        }
        ]
      }
;
	uiEnricherMgr.setPageStructure(contentPanelName, structure);
}



// startup dell arricchimento con JQuery
$( function() {
	uiNRichLib.initStateManager();

	initStdEnrichments4CpInserimentoOperatore();
	initCustomEnrichments4CpInserimentoOperatore();
	initUIStructCpInserimentoOperatore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpInserimentoOperatore");

});



