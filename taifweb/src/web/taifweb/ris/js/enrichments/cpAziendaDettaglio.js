#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpAziendaDettaglio] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAziendaDettaglio() {
	var contentPanelName = "cpAziendaDettaglio";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAziendaDettaglio(){
/*PROTECTED REGION ID(R-909000668) ENABLED START*/
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

function initUIStructCpAziendaDettaglio(){
	var contentPanelName = "cpAziendaDettaglio";
	var structure =
      {
        name: "p_fpAziendaDettaglio", panels: [
        {
          name: "p_fpDettaglioAziendaUserInfo", panels: [
          {
            name: "p_uipDettaglioAzienda", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpDettaglioAziendaBody", panels: [
          {
            name: "p_stdHome", panels: [
            ]
          }
,          {
            name: "p_wpDettaglioAzienda", panels: []
          }
,          {
            name: "p_commandDettaglioAzienda", panels: []
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

	initStdEnrichments4CpAziendaDettaglio();
	initCustomEnrichments4CpAziendaDettaglio();
	initUIStructCpAziendaDettaglio();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpAziendaDettaglio");

});



