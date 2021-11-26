#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpRicercaOperatoreForestaleGestore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaOperatoreForestaleGestore() {
	var contentPanelName = "cpRicercaOperatoreForestaleGestore";
	



	/// arricchimento di base per guigen::TextField [tRicercaCognome]
	var addBasicEnrichmentToTRicercaCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tRicercaCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaOperatoreForestaleGestore", addBasicEnrichmentToTRicercaCognome);

	/// arricchimento per guigen::Calendar [calPeriodoSvolgimentoRicercaOperatoreDa]: aggiunta datepicker
	var addDateToCalPeriodoSvolgimentoRicercaOperatoreDa = function(){
		uiNRichLib.addDatePickerNRich("widg_calPeriodoSvolgimentoRicercaOperatoreDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaOperatoreForestaleGestore", addDateToCalPeriodoSvolgimentoRicercaOperatoreDa);
	/// arricchimento per guigen::Calendar [calPeriodoSvolgimentoRicercaOperatoreA]: aggiunta datepicker
	var addDateToCalPeriodoSvolgimentoRicercaOperatoreA = function(){
		uiNRichLib.addDatePickerNRich("widg_calPeriodoSvolgimentoRicercaOperatoreA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaOperatoreForestaleGestore", addDateToCalPeriodoSvolgimentoRicercaOperatoreA);


	/// arricchimento per guigen::ComboBox [cbProvinciaRicerca]: autonarrowing
	var addNarrowingToCbProvinciaRicerca =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvinciaRicerca',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaOperatoreForestaleGestore", addNarrowingToCbProvinciaRicerca);


	/// arricchimento per guigen::ComboBox [cbComuniRicerca]: autonarrowing
	var addNarrowingToCbComuniRicerca =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComuniRicerca',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaOperatoreForestaleGestore", addNarrowingToCbComuniRicerca);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaOperatoreForestaleGestore(){
/*PROTECTED REGION ID(R391250271) ENABLED START*/
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

function initUIStructCpRicercaOperatoreForestaleGestore(){
	var contentPanelName = "cpRicercaOperatoreForestaleGestore";
	var structure =
      {
        name: "p_fpRicercaOperatoreForestaleGestore", panels: [
        {
          name: "p_fpRicercaOperatoreForestaleGestoreUserInfo", panels: [
          {
            name: "p_uipRicercaOperatoreForestaleGestore", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpRicercaOperatoreForestaleGestoreBody", panels: [
          {
            name: "p_stdHome", panels: [
            ]
          }
,          {
            name: "p_wpRicercaOperatoreForestaleGestore", panels: []
          }
,          {
            name: "p_cpRicercaOperatoreForestaleGestore", panels: []
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

	initStdEnrichments4CpRicercaOperatoreForestaleGestore();
	initCustomEnrichments4CpRicercaOperatoreForestaleGestore();
	initUIStructCpRicercaOperatoreForestaleGestore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaOperatoreForestaleGestore");

});



