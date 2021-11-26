#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpRicercaAccessoLibero] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaAccessoLibero() {
	var contentPanelName = "cpRicercaAccessoLibero";

	/// arricchimento di base per guigen::TextField [tRicercaAccessoLiberoNumeroAlbo]
	var addBasicEnrichmentToTRicercaAccessoLiberoNumeroAlbo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaAccessoLiberoNumeroAlbo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", addBasicEnrichmentToTRicercaAccessoLiberoNumeroAlbo);
	/// arricchimento di base per guigen::TextField [tRicercaAccessoLiberoDenominazione]
	var addBasicEnrichmentToTRicercaAccessoLiberoDenominazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaAccessoLiberoDenominazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", addBasicEnrichmentToTRicercaAccessoLiberoDenominazione);
	/// arricchimento di base per guigen::TextField [tRicercaAccessoLiberoTitolareRappresentanteLegale]
	var addBasicEnrichmentToTRicercaAccessoLiberoTitolareRappresentanteLegale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaAccessoLiberoTitolareRappresentanteLegale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", addBasicEnrichmentToTRicercaAccessoLiberoTitolareRappresentanteLegale);
	/// arricchimento di base per guigen::TextField [tRicercaAccessoLiberoCodFiscalePIva]
	var addBasicEnrichmentToTRicercaAccessoLiberoCodFiscalePIva =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaAccessoLiberoCodFiscalePIva',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", addBasicEnrichmentToTRicercaAccessoLiberoCodFiscalePIva);
	/// arricchimento per guigen::ComboBox [cbtRicercaAccessoLiberoProvincia]: autonarrowing
	var addNarrowingToCbtRicercaAccessoLiberoProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbtRicercaAccessoLiberoProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", addNarrowingToCbtRicercaAccessoLiberoProvincia);


	/// arricchimento per guigen::ComboBox [cbtRicercaAccessoLiberoComune]: autonarrowing
	var addNarrowingToCbtRicercaAccessoLiberoComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbtRicercaAccessoLiberoComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", addNarrowingToCbtRicercaAccessoLiberoComune);


	/// arricchimento per guigen::Calendar [calRicercaAccessoLiberoDataIscrizioneAlboDa]: aggiunta datepicker
	var addDateToCalRicercaAccessoLiberoDataIscrizioneAlboDa = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicercaAccessoLiberoDataIscrizioneAlboDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", addDateToCalRicercaAccessoLiberoDataIscrizioneAlboDa);
	/// arricchimento per guigen::Calendar [calRicercaAccessoLiberoDataIscrizioneAlboA]: aggiunta datepicker
	var addDateToCalRicercaAccessoLiberoDataIscrizioneAlboA = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicercaAccessoLiberoDataIscrizioneAlboA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", addDateToCalRicercaAccessoLiberoDataIscrizioneAlboA);





}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaAccessoLibero(){
/*PROTECTED REGION ID(R684841536) ENABLED START*/
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

function initUIStructCpRicercaAccessoLibero(){
	var contentPanelName = "cpRicercaAccessoLibero";
	var structure =
      {
        name: "p_fpRicercaAccessoLibero", panels: [
        {
          name: "p_fpRicercaAccessoLiberoUserInfo", panels: [
          {
            name: "p_uipRicercaAccessoLibero", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpAccessoLiberoBody", panels: [
          {
            name: "p_stdHome", panels: [
            ]
          }
,          {
            name: "p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione", panels: []
          }
,          {
            name: "p_wpRicercaAccessoLiberoDatiSocioEconomici", panels: []
          }
,          {
            name: "p_cpRicercaAccessoLibero", panels: []
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

	initStdEnrichments4CpRicercaAccessoLibero();
	initCustomEnrichments4CpRicercaAccessoLibero();
	initUIStructCpRicercaAccessoLibero();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaAccessoLibero");

});



