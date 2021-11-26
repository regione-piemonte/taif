#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpHomeGestore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpHomeGestore() {
	var contentPanelName = "cpHomeGestore";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpHomeGestore(){
/*PROTECTED REGION ID(R1989887897) ENABLED START*/
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

function initUIStructCpHomeGestore(){
	var contentPanelName = "cpHomeGestore";
	var structure =
      {
        name: "p_fpHomeGestore", panels: [
        {
          name: "p_fpHomeGestoreUserInfo", panels: [
          {
            name: "p_uipHomeGestore", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpHomeGestoreBody", panels: [
          {
            name: "p_stdHome", panels: [
            ]
          }
,          {
            name: "p_wpNuovaOperatoreForestaleGestore", panels: []
          }
,          {
            name: "p_wpRicercaOperatoreForestaleGestore", panels: []
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

	initStdEnrichments4CpHomeGestore();
	initCustomEnrichments4CpHomeGestore();
	initUIStructCpHomeGestore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpHomeGestore");

});



