#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpElencoOperatoreGestore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoOperatoreGestore() {
	var contentPanelName = "cpElencoOperatoreGestore";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpElencoOperatoreGestore(){
/*PROTECTED REGION ID(R-1837253491) ENABLED START*/
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

function initUIStructCpElencoOperatoreGestore(){
	var contentPanelName = "cpElencoOperatoreGestore";
	var structure =
      {
        name: "p_fpElencoOperatoreForestaleGestore", panels: [
        {
          name: "p_fpElencoOperatoreForestaleGestoreUserInfo", panels: [
          {
            name: "p_uipElencoOperatoreGestore", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpElencoOperatoreForestaleGestoreBody", panels: [
          {
            name: "p_stdHome", panels: [
            ]
          }
,          {
            name: "p_wpElencoOperatoreForestaleGestore", panels: []
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

	initStdEnrichments4CpElencoOperatoreGestore();
	initCustomEnrichments4CpElencoOperatoreGestore();
	initUIStructCpElencoOperatoreGestore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoOperatoreGestore");

});



