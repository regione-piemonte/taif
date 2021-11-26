#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [CpDocumentazione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDocumentazione() {
	var contentPanelName = "CpDocumentazione";




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDocumentazione(){
/*PROTECTED REGION ID(R945037696) ENABLED START*/
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

function initUIStructCpDocumentazione(){
	var contentPanelName = "CpDocumentazione";
	var structure =
      {
        name: "p_fpDocumentazione", panels: [
        {
          name: "p_fpDocumentazioneUserInfo", panels: [
          {
            name: "p_uipDocumentazione", panels: [
            ]
          }
,          {
            name: "p_menuPanel", panels: []
          }
          ]
        }
,        {
          name: "p_fpDocumentazioneBody", panels: [
          {
            name: "p_smpDocumentazione", panels: [
            ]
          }
,          {
            name: "p_wpLabelDownloadDocumenti", panels: []
          }
,          {
            name: "p_wpDownloadDocumenti", panels: []
          }
,          {
            name: "p_wpTabellaDownloadAllegati", panels: []
          }
,          {
            name: "p_wpDocumentiFirmati", panels: []
          }
,          {
            name: "p_mpElencoAllegatiFirmati", panels: [
            {
              name: "p_fpElencoAllegatiFirmati", panels: [
              {
                name: "p_wpElencoAllegatiFirmati", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cmdpDocumentazioneFun", panels: []
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

	initStdEnrichments4CpDocumentazione();
	initCustomEnrichments4CpDocumentazione();
	initUIStructCpDocumentazione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("CpDocumentazione");

});



