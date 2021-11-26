#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [CpAutenticazione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAutenticazione() {
	var contentPanelName = "CpAutenticazione";
	/// arricchimento di base per guigen::TextField [tfLoginAutenticazione]
	var addBasicEnrichmentToTfLoginAutenticazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLoginAutenticazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAutenticazione", addBasicEnrichmentToTfLoginAutenticazione);
	/// arricchimento di base per guigen::TextField [tfPasswordAutenticazione]
	var addBasicEnrichmentToTfPasswordAutenticazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPasswordAutenticazione',
			 	false,
			 	'void',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAutenticazione", addBasicEnrichmentToTfPasswordAutenticazione);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAutenticazione(){
/*PROTECTED REGION ID(R265189098) ENABLED START*/
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

function initUIStructCpAutenticazione(){
	var contentPanelName = "CpAutenticazione";
	var structure =
      {
        name: "p_fpAutenticazione", panels: [
        {
          name: "p_fpAutenticazioneUserInfo", panels: [
          {
            name: "p_uipAutenticazione", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpAutenticazioneBody", panels: [
          {
            name: "p_smpAutenticazione", panels: [
            ]
          }
,          {
            name: "p_wpDatiAutenticazione", panels: []
          }
,          {
            name: "p_cmdAutenticazione", panels: []
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

	initStdEnrichments4CpAutenticazione();
	initCustomEnrichments4CpAutenticazione();
	initUIStructCpAutenticazione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("CpAutenticazione");

});



