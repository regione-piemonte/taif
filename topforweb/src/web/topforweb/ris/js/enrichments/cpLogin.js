#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpLogin] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpLogin() {
	var contentPanelName = "cpLogin";
	/// arricchimento di base per guigen::TextField [tfLogin]
	var addBasicEnrichmentToTfLogin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLogin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiLogin", addBasicEnrichmentToTfLogin);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpLogin(){
/*PROTECTED REGION ID(R-161339106) ENABLED START*/
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

function initUIStructCpLogin(){
	var contentPanelName = "cpLogin";
	var structure =
      {
        name: "p_fpLogin", panels: [
        {
          name: "p_fpLoginBody", panels: [
          {
            name: "p_stdLogin", panels: [
            ]
          }
,          {
            name: "p_wpDatiLogin", panels: []
          }
,          {
            name: "p_cmdpLogin", panels: []
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

	initStdEnrichments4CpLogin();
	initCustomEnrichments4CpLogin();
	initUIStructCpLogin();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpLogin");

});



