#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpOperatoreDettaglio] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpOperatoreDettaglio() {
	var contentPanelName = "cpOperatoreDettaglio";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpOperatoreDettaglio(){
/*PROTECTED REGION ID(R-1721029639) ENABLED START*/
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

function initUIStructCpOperatoreDettaglio(){
	var contentPanelName = "cpOperatoreDettaglio";
	var structure =
      {
        name: "p_fpOperatoreDettaglio", panels: [
        {
          name: "p_fpDettaglioOperatoreUserInfo", panels: [
          {
            name: "p_uipDettaglioOperatore", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpDettaglioOperatoreBody", panels: [
          {
            name: "p_stdMessage", panels: [
            ]
          }
,          {
            name: "p_wpSchedaOperatoreForestale", panels: []
          }
,          {
            name: "p_wpDatiIdentificativiOperatore", panels: []
          }
,          {
            name: "p_wpCorsiFinanziatiRegione", panels: []
          }
,          {
            name: "p_wpAltriCorsi", panels: []
          }
,          {
            name: "p_wpQualifiche", panels: []
          }
,          {
            name: "p_wpRiconoscimenti", panels: []
          }
,          {
            name: "p_cpDettaglioOperatoreNavigaApplicazione", panels: []
          }
,          {
            name: "p_cpDettaglioOperatore", panels: []
          }
,          {
            name: "p_dpEliminaAttestato", panels: [
            ]
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

	initStdEnrichments4CpOperatoreDettaglio();
	initCustomEnrichments4CpOperatoreDettaglio();
	initUIStructCpOperatoreDettaglio();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpOperatoreDettaglio");

});



