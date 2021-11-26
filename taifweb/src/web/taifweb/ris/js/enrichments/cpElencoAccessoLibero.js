#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [cpElencoAccessoLibero] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoAccessoLibero() {
	var contentPanelName = "cpElencoAccessoLibero";

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
function initCustomEnrichments4CpElencoAccessoLibero(){
/*PROTECTED REGION ID(R2074291009) ENABLED START*/
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

function initUIStructCpElencoAccessoLibero(){
	var contentPanelName = "cpElencoAccessoLibero";
	var structure =
      {
        name: "p_fpElencoAziendeAccessoLibero", panels: [
        {
          name: "p_stdElencoRicercaLibera", panels: [
          ]
        }
,        {
          name: "p_fpElencoAziendeAccessoLiberoUserInfo", panels: [
          {
            name: "p_uipElencoAziendeAccessoLibero", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpElencoAziendeAccessoLiberoBody", panels: [
          {
            name: "p_stdHome", panels: [
            ]
          }
,          {
            name: "p_wpElencoAziendeAccessoLibero", panels: []
          }
,          {
            name: "p_cpElencoAziendeAccessoLibero", panels: []
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

	initStdEnrichments4CpElencoAccessoLibero();
	initCustomEnrichments4CpElencoAccessoLibero();
	initUIStructCpElencoAccessoLibero();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoAccessoLibero");

});



