#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [CpRiepilogo] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRiepilogo() {
	var contentPanelName = "CpRiepilogo";

	/// arricchimento per guigen::ComboBox [cbRiepilogoStatiDomandaTest]: autonarrowing
	var addNarrowingToCbRiepilogoStatiDomandaTest =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRiepilogoStatiDomandaTest',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRiepilogoGestioneStatoDomanda", addNarrowingToCbRiepilogoStatiDomandaTest);


	/// arricchimento di base per guigen::TextField [tfRiepilogoNumeroProtocolloTest]
	var addBasicEnrichmentToTfRiepilogoNumeroProtocolloTest =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRiepilogoNumeroProtocolloTest',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRiepilogoGestioneStatoDomanda", addBasicEnrichmentToTfRiepilogoNumeroProtocolloTest);
	/// arricchimento di base per guigen::TextField [tfRiepilogoNoteTest]
	var addBasicEnrichmentToTfRiepilogoNoteTest =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRiepilogoNoteTest',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRiepilogoGestioneStatoDomanda", addBasicEnrichmentToTfRiepilogoNoteTest);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRiepilogo(){
/*PROTECTED REGION ID(R2138361223) ENABLED START*/
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

function initUIStructCpRiepilogo(){
	var contentPanelName = "CpRiepilogo";
	var structure =
      {
        name: "p_fpRiepilogo", panels: [
        {
          name: "p_fpRiepilogoUserInfo", panels: [
          {
            name: "p_uipRiepilogo", panels: [
            ]
          }
,          {
            name: "p_menuPanel", panels: []
          }
          ]
        }
,        {
          name: "p_fpRiepilogoBody", panels: [
          {
            name: "p_smpRiepilogo", panels: [
            ]
          }
,          {
            name: "p_wpRiepilogoIntestazioneStato", panels: []
          }
,          {
            name: "p_mpRiepilogoTabellaStati", panels: [
            {
              name: "p_fpRiepilogoTabellaStati", panels: [
              {
                name: "p_wpRiepilogoTabellaStati", panels: []
              }
,              {
                name: "p_cmdAggiungiStato", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_wpRiepilogoAltiDati", panels: []
          }
,          {
            name: "p_mpRiepilogoGestioneStatoDomanda", panels: [
            {
              name: "p_fpRiepilogoGestioneStatoDomanda", panels: [
              {
                name: "p_wpRiepilogoGestioneStatoDomanda", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_mpRiepilogoStatoDomanda", panels: [
            {
              name: "p_fpRiepilogoStatoDomanda", panels: [
              {
                name: "p_wpRiepilogoStatoDomanda", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_mpRiepilogoMessaggio", panels: [
            {
              name: "p_fpRiepilogoMessaggio", panels: [
              {
                name: "p_wpRiepilogoMessaggio", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_mpSchedaAzienda", panels: [
            {
              name: "p_fpSchedaAzienda", panels: [
              {
                name: "p_wpSchedaAzienda", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cmdpRiepilogoNav", panels: []
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

	initStdEnrichments4CpRiepilogo();
	initCustomEnrichments4CpRiepilogo();
	initUIStructCpRiepilogo();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("CpRiepilogo");

});



