#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpElencoAziendeGestore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoAziendeGestore() {
	var contentPanelName = "cpElencoAziendeGestore";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpElencoAziendeGestore(){
/*PROTECTED REGION ID(R157799156) ENABLED START*/
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

function initUIStructCpElencoAziendeGestore(){
	var contentPanelName = "cpElencoAziendeGestore";
	var structure =
      {
        name: "p_fpElencoAziendeGestore", panels: [
        {
          name: "p_fpElencoAziendeGestoreUserInfo", panels: [
          {
            name: "p_uipElencoAziendeGestore", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpElencoAziendeGestoreBody", panels: [
          {
            name: "p_stdHome", panels: [
            ]
          }
,          {
            name: "p_wpElencoAziendeGestore", panels: []
          }
,          {
            name: "p_cpElencoAziendeGestoreFun", panels: []
          }
,          {
            name: "p_cpElencoAziendeGestoreNav", panels: []
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

	initStdEnrichments4CpElencoAziendeGestore();
	initCustomEnrichments4CpElencoAziendeGestore();
	initUIStructCpElencoAziendeGestore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoAziendeGestore");

});



