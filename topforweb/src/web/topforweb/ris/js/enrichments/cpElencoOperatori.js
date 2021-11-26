#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpElencoOperatori] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoOperatori() {
	var contentPanelName = "cpElencoOperatori";

	/// arricchimento di base per guigen::TextField [tfVerificaCaptchaRicercaLibera]
	var addBasicEnrichmentToTfVerificaCaptchaRicercaLibera =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVerificaCaptchaRicercaLibera',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCaptcha", addBasicEnrichmentToTfVerificaCaptchaRicercaLibera);
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpElencoOperatori(){
/*PROTECTED REGION ID(R-2089168482) ENABLED START*/
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

function initUIStructCpElencoOperatori(){
	var contentPanelName = "cpElencoOperatori";
	var structure =
      {
        name: "p_fpElencoOperatori", panels: [
        {
          name: "p_fpElencoOperatoriUserInfo", panels: [
          {
            name: "p_uipElencoOperatore", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpElencoOperatoriBody", panels: [
          {
            name: "p_stdHomeOperatore", panels: [
            ]
          }
,          {
            name: "p_wpElencoOperatore", panels: []
          }
,          {
            name: "p_cpElencoOperatore", panels: []
          }
,          {
            name: "p_mpCaptcha", panels: [
            {
              name: "p_fpCaptcha", panels: [
              {
                name: "p_wpCaptcha", panels: []
              }
              ]
            }
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

	initStdEnrichments4CpElencoOperatori();
	initCustomEnrichments4CpElencoOperatori();
	initUIStructCpElencoOperatori();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoOperatori");

});



