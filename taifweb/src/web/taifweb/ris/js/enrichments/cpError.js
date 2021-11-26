#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpError] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpError() {
	var contentPanelName = "cpError";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpError(){
/*PROTECTED REGION ID(R-1314962947) ENABLED START*/
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

function initUIStructCpError(){
	var contentPanelName = "cpError";
	var structure =
      {
        name: "p_fpError", panels: [
        {
          name: "p_smpError", panels: [
          ]
        }
,        {
          name: "p_wpError", panels: []
        }
        ]
      }
;
	uiEnricherMgr.setPageStructure(contentPanelName, structure);
}



// startup dell arricchimento con JQuery
$( function() {
	uiNRichLib.initStateManager();

	initStdEnrichments4CpError();
	initCustomEnrichments4CpError();
	initUIStructCpError();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpError");

});



