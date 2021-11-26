#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpIstanzeTaglioPresentate] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpIstanzeTaglioPresentate() {
	var contentPanelName = "cpIstanzeTaglioPresentate";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpIstanzeTaglioPresentate(){
/*PROTECTED REGION ID(R-595200122) ENABLED START*/
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

function initUIStructCpIstanzeTaglioPresentate(){
	var contentPanelName = "cpIstanzeTaglioPresentate";
	var structure =
      {
        name: "p_fpIstanzeTaglioPresentate", panels: [
        {
          name: "p_fpIstanzeTaglioPresentateUserInfo", panels: [
          {
            name: "p_uipIstanzeTaglioPresentate", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpIstanzeTaglioPresentateBody", panels: [
          {
            name: "p_stdIstanzeTaglioPresentate", panels: [
            ]
          }
,          {
            name: "p_wpIstanzeTaglioPresentate", panels: []
          }
,          {
            name: "p_cpInstanzeTaglioPresentate", panels: []
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

	initStdEnrichments4CpIstanzeTaglioPresentate();
	initCustomEnrichments4CpIstanzeTaglioPresentate();
	initUIStructCpIstanzeTaglioPresentate();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpIstanzeTaglioPresentate");

});



