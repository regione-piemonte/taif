#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpRicercaAziendaGestore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaAziendaGestore() {
	var contentPanelName = "cpRicercaAziendaGestore";

	/// arricchimento di base per guigen::TextField [tRicercaAziendaGestoreNumeroAlbo]
	var addBasicEnrichmentToTRicercaAziendaGestoreNumeroAlbo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaAziendaGestoreNumeroAlbo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", addBasicEnrichmentToTRicercaAziendaGestoreNumeroAlbo);
	/// arricchimento di base per guigen::TextField [tRicercaAziendaGestoreDenominazione]
	var addBasicEnrichmentToTRicercaAziendaGestoreDenominazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaAziendaGestoreDenominazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", addBasicEnrichmentToTRicercaAziendaGestoreDenominazione);
	/// arricchimento di base per guigen::TextField [tRicercaAziendaGestoreTitolareRappresentanteLegale]
	var addBasicEnrichmentToTRicercaAziendaGestoreTitolareRappresentanteLegale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaAziendaGestoreTitolareRappresentanteLegale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", addBasicEnrichmentToTRicercaAziendaGestoreTitolareRappresentanteLegale);
	/// arricchimento di base per guigen::TextField [tRicercaAziendaGestoreCodFiscalePIva]
	var addBasicEnrichmentToTRicercaAziendaGestoreCodFiscalePIva =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaAziendaGestoreCodFiscalePIva',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", addBasicEnrichmentToTRicercaAziendaGestoreCodFiscalePIva);
	/// arricchimento per guigen::ComboBox [cbtRicercaAziendaGestoreProvincia]: autonarrowing
	var addNarrowingToCbtRicercaAziendaGestoreProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbtRicercaAziendaGestoreProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", addNarrowingToCbtRicercaAziendaGestoreProvincia);


	/// arricchimento per guigen::ComboBox [cbtRicercaAziendaGestoreComune]: autonarrowing
	var addNarrowingToCbtRicercaAziendaGestoreComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbtRicercaAziendaGestoreComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", addNarrowingToCbtRicercaAziendaGestoreComune);


	/// arricchimento per guigen::Calendar [calRicercaAziendaGestoreDataIscrizioneAlboDa]: aggiunta datepicker
	var addDateToCalRicercaAziendaGestoreDataIscrizioneAlboDa = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicercaAziendaGestoreDataIscrizioneAlboDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", addDateToCalRicercaAziendaGestoreDataIscrizioneAlboDa);
	/// arricchimento per guigen::Calendar [calRicercaAziendaGestoreDataIscrizioneAlboA]: aggiunta datepicker
	var addDateToCalRicercaAziendaGestoreDataIscrizioneAlboA = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicercaAziendaGestoreDataIscrizioneAlboA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", addDateToCalRicercaAziendaGestoreDataIscrizioneAlboA);







}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaAziendaGestore(){
/*PROTECTED REGION ID(R-89540775) ENABLED START*/
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

function initUIStructCpRicercaAziendaGestore(){
	var contentPanelName = "cpRicercaAziendaGestore";
	var structure =
      {
        name: "p_fpRicercaAziendaGestore", panels: [
        {
          name: "p_fpRicercaAziendaGestoreUserInfo", panels: [
          {
            name: "p_uipRicercaAziendaGestore", panels: [
            ]
          }
,          {
            name: "p_menuPanel", panels: []
          }
          ]
        }
,        {
          name: "p_fpRicercaAziendaGestoreBody", panels: [
          {
            name: "p_stdHome", panels: [
            ]
          }
,          {
            name: "p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione", panels: []
          }
,          {
            name: "p_wpRicercaAziendaGestoreDatiSocioEconomici", panels: []
          }
,          {
            name: "p_cpRicercaAziendaGestore", panels: []
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

	initStdEnrichments4CpRicercaAziendaGestore();
	initCustomEnrichments4CpRicercaAziendaGestore();
	initUIStructCpRicercaAziendaGestore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaAziendaGestore");

});



