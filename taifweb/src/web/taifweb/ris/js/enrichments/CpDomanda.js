#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/**
 * Arricchimenti standard per il ContentPanel [CpDomanda] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDomanda() {
	var contentPanelName = "CpDomanda";
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendaleCodiceFiscale]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleCodiceFiscale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendaleCodiceFiscale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendale", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleCodiceFiscale);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendalePartitaIva]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendalePartitaIva =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendalePartitaIva',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendale", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendalePartitaIva);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendaleNSiret]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleNSiret =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendaleNSiret',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendale", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleNSiret);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendaleNtva]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleNtva =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendaleNtva',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendale", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleNtva);


	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica]: autonarrowing
	var addNarrowingToCbDatiAnagraficiAnagrafeAziendaleFormaGiuridica =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendaleAltriDati", addNarrowingToCbDatiAnagraficiAnagrafeAziendaleFormaGiuridica);


	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia]: autonarrowing
	var addNarrowingToCbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiIscrizioneCCIAA", addNarrowingToCbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia);


	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiCCIAANumero]
	var addBasicEnrichmentToTfDatiAnagraficiCCIAANumero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiCCIAANumero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiIscrizioneCCIAA", addBasicEnrichmentToTfDatiAnagraficiCCIAANumero);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendaleEmail]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendaleEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendaleContatti", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleEmail);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendalePec]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendalePec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendalePec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendaleContatti", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendalePec);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendaleTelefono]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleTelefono =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendaleTelefono',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendaleContatti", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleTelefono);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendaleCellulare]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleCellulare =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendaleCellulare',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendaleContatti", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleCellulare);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendaleSitoInternet]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleSitoInternet =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendaleSitoInternet',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendaleContatti", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleSitoInternet);
	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiComuneSedeLegale]: autonarrowing
	var addNarrowingToCbDatiAnagraficiComuneSedeLegale =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiComuneSedeLegale',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiSedeLegale", addNarrowingToCbDatiAnagraficiComuneSedeLegale);


	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiComuneSedeLegale]
	var addBasicEnrichmentToTfDatiAnagraficiComuneSedeLegale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiComuneSedeLegale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiSedeLegale", addBasicEnrichmentToTfDatiAnagraficiComuneSedeLegale);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiCapSedeLegale]
	var addBasicEnrichmentToTfDatiAnagraficiCapSedeLegale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiCapSedeLegale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiSedeLegale", addBasicEnrichmentToTfDatiAnagraficiCapSedeLegale);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiIndirizzoSedeLegale]
	var addBasicEnrichmentToTfDatiAnagraficiIndirizzoSedeLegale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiIndirizzoSedeLegale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiSedeLegale", addBasicEnrichmentToTfDatiAnagraficiIndirizzoSedeLegale);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiCivicoSedeLegale]
	var addBasicEnrichmentToTfDatiAnagraficiCivicoSedeLegale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiCivicoSedeLegale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiSedeLegale", addBasicEnrichmentToTfDatiAnagraficiCivicoSedeLegale);

	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo]
	var addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo", addBasicEnrichmentToTfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleCognome]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleCognome);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleNome]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleNome);
	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita]: autonarrowing
	var addNarrowingToCbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addNarrowingToCbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita);


	/// arricchimento per guigen::ComboBox [cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita]: autonarrowing
	var addNarrowingToCmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addNarrowingToCmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita);


	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta);
	/// arricchimento per guigen::ComboBox [cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza]: autonarrowing
	var addNarrowingToCmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addNarrowingToCmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza);


	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale]
	var addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addBasicEnrichmentToTfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale);
	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio]: autonarrowing
	var addNarrowingToCbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiTitolareRappresentanteLegale", addNarrowingToCbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio);


	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleNome]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleNome);
	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita]: autonarrowing
	var addNarrowingToCbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addNarrowingToCbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita);


	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta);
	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita]: autonarrowing
	var addNarrowingToCbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addNarrowingToCbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita);


	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza]: autonarrowing
	var addNarrowingToCbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addNarrowingToCbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza);


	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare);
	/// arricchimento di base per guigen::TextField [tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale]
	var addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addBasicEnrichmentToTfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale);
	/// arricchimento per guigen::ComboBox [cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio]: autonarrowing
	var addNarrowingToCbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAnagraficiConduttoreAzienda", addNarrowingToCbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio);


	/// arricchimento di base per guigen::TextField [tfDatiSocioEconomiciFatturatoAnnoInizioAttivita]
	var addBasicEnrichmentToTfDatiSocioEconomiciFatturatoAnnoInizioAttivita =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiSocioEconomiciFatturatoAnnoInizioAttivita',
			 	false,
			 	'void',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiSocioEconomiciFatturato", addBasicEnrichmentToTfDatiSocioEconomiciFatturatoAnnoInizioAttivita);
	/// arricchimento di base per guigen::TextField [tfDatiSocioEconomiciFatturatoUltimoAnno]
	var addBasicEnrichmentToTfDatiSocioEconomiciFatturatoUltimoAnno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatiSocioEconomiciFatturatoUltimoAnno',
			 	false,
			 	'void',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiSocioEconomiciFatturato", addBasicEnrichmentToTfDatiSocioEconomiciFatturatoUltimoAnno);


	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1", addBasicEnrichmentToTfAttivitaUltimoAnno1);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione);
	/// arricchimento per guigen::ComboBox [cbUnitaMisuraTagliUtilizzazioneInRegione]: autonarrowing
	var addNarrowingToCbUnitaMisuraTagliUtilizzazioneInRegione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbUnitaMisuraTagliUtilizzazioneInRegione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addNarrowingToCbUnitaMisuraTagliUtilizzazioneInRegione);


	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti);
	/// arricchimento per guigen::ComboBox [cbUnitaMisuraTaglioPioppetoInRegione]: autonarrowing
	var addNarrowingToCbUnitaMisuraTaglioPioppetoInRegione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbUnitaMisuraTaglioPioppetoInRegione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addNarrowingToCbUnitaMisuraTaglioPioppetoInRegione);


	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari);
	/// arricchimento per guigen::ComboBox [cbUnitaMisuraTagliIntercalariInRegione]: autonarrowing
	var addNarrowingToCbUnitaMisuraTagliIntercalariInRegione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbUnitaMisuraTagliIntercalariInRegione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addNarrowingToCbUnitaMisuraTagliIntercalariInRegione);


	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoInRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione);
	/// arricchimento per guigen::ComboBox [cbUnitaMisuraTagliUtilizzazioneFuoriRegione]: autonarrowing
	var addNarrowingToCbUnitaMisuraTagliUtilizzazioneFuoriRegione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbUnitaMisuraTagliUtilizzazioneFuoriRegione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addNarrowingToCbUnitaMisuraTagliUtilizzazioneFuoriRegione);


	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti);
	/// arricchimento per guigen::ComboBox [cbUnitaMisuraTaglioPioppetoFuoriRegione]: autonarrowing
	var addNarrowingToCbUnitaMisuraTaglioPioppetoFuoriRegione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbUnitaMisuraTaglioPioppetoFuoriRegione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addNarrowingToCbUnitaMisuraTaglioPioppetoFuoriRegione);


	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari);
	/// arricchimento per guigen::ComboBox [cbUnitaMisuraTagliIntercalariFuoriRegione]: autonarrowing
	var addNarrowingToCbUnitaMisuraTagliIntercalariFuoriRegione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbUnitaMisuraTagliIntercalariFuoriRegione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addNarrowingToCbUnitaMisuraTagliIntercalariFuoriRegione);


	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale]
	var addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", addBasicEnrichmentToTfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno2]
	var addBasicEnrichmentToTfAttivitaUltimoAnno2 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno2',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno2", addBasicEnrichmentToTfAttivitaUltimoAnno2);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnnoEttariRealizzati]
	var addBasicEnrichmentToTfAttivitaUltimoAnnoEttariRealizzati =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnnoEttariRealizzati',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno2", addBasicEnrichmentToTfAttivitaUltimoAnnoEttariRealizzati);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno3]
	var addBasicEnrichmentToTfAttivitaUltimoAnno3 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno3',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno3", addBasicEnrichmentToTfAttivitaUltimoAnno3);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno3Realizzazione]
	var addBasicEnrichmentToTfAttivitaUltimoAnno3Realizzazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno3Realizzazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno3", addBasicEnrichmentToTfAttivitaUltimoAnno3Realizzazione);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno3Manutenzione]
	var addBasicEnrichmentToTfAttivitaUltimoAnno3Manutenzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno3Manutenzione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno3", addBasicEnrichmentToTfAttivitaUltimoAnno3Manutenzione);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno4]
	var addBasicEnrichmentToTfAttivitaUltimoAnno4 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno4',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno4", addBasicEnrichmentToTfAttivitaUltimoAnno4);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno5]
	var addBasicEnrichmentToTfAttivitaUltimoAnno5 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno5',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno5", addBasicEnrichmentToTfAttivitaUltimoAnno5);

	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno6]
	var addBasicEnrichmentToTfAttivitaUltimoAnno6 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno6',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno6", addBasicEnrichmentToTfAttivitaUltimoAnno6);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno7]
	var addBasicEnrichmentToTfAttivitaUltimoAnno7 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno7',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno7", addBasicEnrichmentToTfAttivitaUltimoAnno7);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno8]
	var addBasicEnrichmentToTfAttivitaUltimoAnno8 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno8',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno8", addBasicEnrichmentToTfAttivitaUltimoAnno8);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnnoAltro9]
	var addBasicEnrichmentToTfAttivitaUltimoAnnoAltro9 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnnoAltro9',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno9", addBasicEnrichmentToTfAttivitaUltimoAnnoAltro9);
	/// arricchimento di base per guigen::TextField [tfAttivitaUltimoAnno9]
	var addBasicEnrichmentToTfAttivitaUltimoAnno9 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAttivitaUltimoAnno9',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaUltimoAnno9", addBasicEnrichmentToTfAttivitaUltimoAnno9);
	/// arricchimento di base per guigen::TextField [tfClientiFr1]
	var addBasicEnrichmentToTfClientiFr1 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfClientiFr1',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpClientiFr", addBasicEnrichmentToTfClientiFr1);
	/// arricchimento di base per guigen::TextField [tfClientiFr2]
	var addBasicEnrichmentToTfClientiFr2 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfClientiFr2',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpClientiFr", addBasicEnrichmentToTfClientiFr2);
	/// arricchimento di base per guigen::TextField [tfClientiFr3]
	var addBasicEnrichmentToTfClientiFr3 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfClientiFr3',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpClientiFr", addBasicEnrichmentToTfClientiFr3);


	/// arricchimento di base per guigen::TextField [tfPercentualeCommercioFr]
	var addBasicEnrichmentToTfPercentualeCommercioFr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPercentualeCommercioFr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAttivitaLegnameFr", addBasicEnrichmentToTfPercentualeCommercioFr);























	/// arricchimento per guigen::ComboBox [cmbRicercaAltroPersonale]: suggestion con interazioen server-side
	var addSuggestionsToCmbRicercaAltroPersonale =
		function(){
			uiNRichLib.addComboSuggestionNRich(
				'/taifweb/base/domanda/CpDomanda!handleCmbRicercaAltroPersonale_KEY_PRESSED.do',
				'widg_cmbRicercaAltroPersonale',
				'appDatapersonaleDaCercare',
				'code',
				'description',
				'',
				'',
				'',
				'',
				false, null);
			};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAltroPersonale", addSuggestionsToCmbRicercaAltroPersonale);


	/// arricchimento di base per guigen::TextField [tfAltroPersonaleNbreDeSalaries]
	var addBasicEnrichmentToTfAltroPersonaleNbreDeSalaries =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAltroPersonaleNbreDeSalaries',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAltroPersonaleFr", addBasicEnrichmentToTfAltroPersonaleNbreDeSalaries);
	/// arricchimento di base per guigen::TextField [tfAltroPersonaleEquivalentTempsPlein]
	var addBasicEnrichmentToTfAltroPersonaleEquivalentTempsPlein =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAltroPersonaleEquivalentTempsPlein',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAltroPersonaleFr", addBasicEnrichmentToTfAltroPersonaleEquivalentTempsPlein);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDomanda(){
/*PROTECTED REGION ID(R1564877761) ENABLED START*/
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

function initUIStructCpDomanda(){
	var contentPanelName = "CpDomanda";
	var structure =
      {
        name: "p_fpDomanda", panels: [
        {
          name: "p_fpDomandaUserInfo", panels: [
          {
            name: "p_uipDomanda", panels: [
            ]
          }
,          {
            name: "p_menuPanel", panels: []
          }
          ]
        }
,        {
          name: "p_fpDomandaBody", panels: [
          {
            name: "p_smpDomanda", panels: [
            ]
          }
,          {
            name: "p_wpAlboDomanda", panels: []
          }
,          {
            name: "p_wzpDomanda", panels: [
            {
              name: "p_fpWizard1DatiAnagrafici", panels: [
              {
                name: "p_wzpDomandaDatiAnagrafici", panels: [
                {
                  name: "p_fpWizardDatiAnagraficiSub1", panels: [
                  {
                    name: "p_smpDomanda1.1", panels: [
                    ]
                  }
,                  {
                    name: "p_wpDatiAnagraficiSezione1.1", panels: []
                  }
,                  {
                    name: "p_wpDatiAnagraficiAnagrafeAziendale", panels: []
                  }
,                  {
                    name: "p_wpDatiAnagraficiAnagrafeAziendaleAltriDati", panels: []
                  }
,                  {
                    name: "p_mpDatiAnagraficiIscrizioneCCIAA", panels: [
                    {
                      name: "p_fpDatiAnagraficiIscrizioneCCIAA", panels: [
                      {
                        name: "p_wpDatiAnagraficiIscrizioneCCIAA", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_wpDatiAnagraficiAnagrafeAziendaleContatti", panels: []
                  }
,                  {
                    name: "p_wpDatiAnagraficiSedeLegale", panels: []
                  }
,                  {
                    name: "p_wpRadioAltreSedi", panels: []
                  }
,                  {
                    name: "p_mpDatiAnagraficiSedi", panels: [
                    {
                      name: "p_fpDatiAnagraficiSedi", panels: [
                      {
                        name: "p_wpDatiAnagraficiSedi", panels: []
                      }
,                      {
                        name: "p_cmdAggiungiSede", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo", panels: [
                    {
                      name: "p_fpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo", panels: [
                      {
                        name: "p_wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpDatiAnagraficiConsensoPrivacy", panels: [
                    {
                      name: "p_fpDatiAnagraficiConsensoPrivacy", panels: [
                      {
                        name: "p_wpConsensoPrivacy", panels: []
                      }
                      ]
                    }
                    ]
                  }
                  ]
                }
,                {
                  name: "p_fpWizardDatiAnagraficiSub2", panels: [
                  {
                    name: "p_smpDomanda1.2", panels: [
                    ]
                  }
,                  {
                    name: "p_wpDatiAnagraficiSezione1.2", panels: []
                  }
,                  {
                    name: "p_wpDatiAnagraficiTitolareRappresentanteLegale", panels: []
                  }
,                  {
                    name: "p_wpDatiAnagraficiRequisitiProfessionaliForestali", panels: []
                  }
,                  {
                    name: "p_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente", panels: [
                    {
                      name: "p_fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente", panels: [
                      {
                        name: "p_wpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpDatiAnagraficiConduttoreAzienda", panels: [
                    {
                      name: "p_fpDatiAnagraficiConduttoreAzienda", panels: [
                      {
                        name: "p_wpDatiAnagraficiConduttoreAzienda", panels: []
                      }
,                      {
                        name: "p_wpDatiAnagraficiAltriRequisitiProfessionaliForestali", panels: []
                      }
                      ]
                    }
                    ]
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_fpWizard2DatiSocioEconomici", panels: [
              {
                name: "p_wzpDomandaDatiSocioEconomici", panels: [
                {
                  name: "p_fpWizardDatiSocioEconomiciSub1", panels: [
                  {
                    name: "p_smpDomanda2.1", panels: [
                    ]
                  }
,                  {
                    name: "p_wpDatiSocioEconomici2.1", panels: []
                  }
,                  {
                    name: "p_wpDatiSocioEconomiciFatturato", panels: []
                  }
,                  {
                    name: "p_wpDatiSocioEconomiciCategorieDiImpresa", panels: []
                  }
                  ]
                }
,                {
                  name: "p_fpWizardDatiSocioEconomiciSub2", panels: [
                  {
                    name: "p_smpDomanda2.2", panels: [
                    ]
                  }
,                  {
                    name: "p_wpDatiSocioEconomici2.2", panels: []
                  }
,                  {
                    name: "p_wpDatiSocioEconomiciAltriAlbi", panels: []
                  }
,                  {
                    name: "p_mpDatiSocioEconomiciAltriAlbi", panels: [
                    {
                      name: "p_fpDatiSocioEconomiciAltriAlbi", panels: [
                      {
                        name: "p_wpDatiSocioEconomiciAltriAlbi", panels: []
                      }
,                      {
                        name: "p_cmdAggiungiAltroAlbo", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_wpDatiSocioEconomiciFormeOrganizzative", panels: []
                  }
,                  {
                    name: "p_wpDatiSocioEconomiciCertificazioniQualitaProcesso", panels: []
                  }
,                  {
                    name: "p_mpDatiSocioEconomiciCertificazioniQualitaProcesso", panels: [
                    {
                      name: "p_fpDatiSocioEconomiciCertificazioniQualitaProcesso", panels: [
                      {
                        name: "p_wpDatiSocioEconomiciCertificazioni", panels: []
                      }
,                      {
                        name: "p_cmdAggiungiCertificazioneQualitaProcesso", panels: []
                      }
                      ]
                    }
                    ]
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_fpWizard3Attivita", panels: [
              {
                name: "p_wzpDomandaAttivita", panels: [
                {
                  name: "p_fpWizardAttivitaSub1", panels: [
                  {
                    name: "p_mpAttivitaIt", panels: [
                    {
                      name: "p_fpAttivitaIt", panels: [
                      {
                        name: "p_wpAttivitaUltimoAnno", panels: []
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno1", panels: []
                      }
,                      {
                        name: "p_mpAttivitaUltimoAnno1", panels: [
                        {
                          name: "p_fpAttivitaUltimoAnno1", panels: [
                          {
                            name: "p_wpAttivitaUltimoAnno1InRegione", panels: []
                          }
,                          {
                            name: "p_wpAttivitaUltimoAnno1ElencoInRegione", panels: []
                          }
,                          {
                            name: "p_wpAttivitaUltimoAnno1ElencoFuoriRegione", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno2", panels: []
                      }
,                      {
                        name: "p_mpAttivitaUltimoAnno2", panels: [
                        {
                          name: "p_fpAttivitaUltimoAnno2", panels: [
                          {
                            name: "p_wpAttivitaUltimoAnno2", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno3", panels: []
                      }
,                      {
                        name: "p_mpAttivitaUltimoAnno3", panels: [
                        {
                          name: "p_fpAttivitaUltimoAnno3", panels: [
                          {
                            name: "p_wpAttivitaUltimoAnno3", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno4", panels: []
                      }
,                      {
                        name: "p_mpAttivitaUltimoAnno4", panels: [
                        {
                          name: "p_fpAttivitaUltimoAnno4", panels: [
                          {
                            name: "p_wpAttivitaUltimoAnno4", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno5", panels: []
                      }
,                      {
                        name: "p_mpAttivitaUltimoAnno5", panels: [
                        {
                          name: "p_fpAttivitaUltimoAnno5", panels: [
                          {
                            name: "p_wpAttivitaUltimoAnno5", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiArboricolturaDaLegno", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno6", panels: []
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno7", panels: []
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno8", panels: []
                      }
,                      {
                        name: "p_wpAttivitaUltimoAnno9", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpAttivitaFr", panels: [
                    {
                      name: "p_fpAttivitaFr", panels: [
                      {
                        name: "p_wpAttivitaUFr", panels: []
                      }
,                      {
                        name: "p_wpClientiFr", panels: []
                      }
                      ]
                    }
                    ]
                  }
                  ]
                }
,                {
                  name: "p_fpWizardAttivitaSub2", panels: [
                  {
                    name: "p_mpAttivitaLavoriPAIt", panels: [
                    {
                      name: "p_fpAttivitaLavoriPAIt", panels: [
                      {
                        name: "p_wpAttivitaLavoriPA", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpAttivitaLavoriPA", panels: [
                    {
                      name: "p_fpAttivitaLavoriPA", panels: [
                      {
                        name: "p_wpAttivitaLavoriPA", panels: []
                      }
,                      {
                        name: "p_cmdAggiungiLavoroPA", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpAttivitaLavoriPAFr", panels: [
                    {
                      name: "p_fpAttivitaLavoriPAFr", panels: [
                      {
                        name: "p_wpAttivitaLavoriPAFr", panels: []
                      }
                      ]
                    }
                    ]
                  }
                  ]
                }
,                {
                  name: "p_fpWizardAttivitaSub3", panels: [
                  {
                    name: "p_wpAttivitaLegname", panels: []
                  }
,                  {
                    name: "p_mpAttivitaLegname", panels: [
                    {
                      name: "p_fpAttivitaLegname", panels: [
                      {
                        name: "p_wpAttivitaLegname", panels: []
                      }
,                      {
                        name: "p_cmdAggiungiLegname", panels: []
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpAttivitaLegnameFr", panels: [
                    {
                      name: "p_fpAttivitaLegnameFr", panels: [
                      {
                        name: "p_wpAttivitaLegnameFr", panels: []
                      }
,                      {
                        name: "p_cmdAggiungiLegnameFr", panels: []
                      }
                      ]
                    }
                    ]
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_fpWizard4Strutture", panels: [
              {
                name: "p_fpWizardStrutture", panels: [
                {
                  name: "p_wpStruttureCapannoni", panels: []
                }
,                {
                  name: "p_mpStruttureCapannoni", panels: [
                  {
                    name: "p_fpStruttureCapannoni", panels: [
                    {
                      name: "p_wpElencoCapannoni", panels: []
                    }
,                    {
                      name: "p_cmdAggiungiCapannoni", panels: []
                    }
                    ]
                  }
                  ]
                }
,                {
                  name: "p_wpStrutturePiazzaliStoccaggio", panels: []
                }
,                {
                  name: "p_mpStrutturePiazzaliStoccaggio", panels: [
                  {
                    name: "p_fpStrutturePiazzaliStoccaggio", panels: [
                    {
                      name: "p_wpElencoPiazzaliStoccaggio", panels: []
                    }
,                    {
                      name: "p_cmdAggiungiPiazzaliStoccaggio", panels: []
                    }
                    ]
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_fpWizard5Attrezzature", panels: [
              {
                name: "p_wzpDomandaAttrezzatture", panels: [
                {
                  name: "p_fpWizardAttrezzatureSub1", panels: [
                  {
                    name: "p_mpAttrezzatureIt", panels: [
                    {
                      name: "p_fpAttrezzatureIt", panels: [
                      {
                        name: "p_wpAttrezzatureCascoForestale", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureCascoForestale", panels: [
                        {
                          name: "p_fpAttrezzatureCascoForestale", panels: [
                          {
                            name: "p_wpElencoAttrezzatureCascoForestale", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaCascoForestale", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureScarponiRinforzati", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureScarponiRinforzati", panels: [
                        {
                          name: "p_fpAttrezzatureScarponiRinforzati", panels: [
                          {
                            name: "p_wpElencoAttrezzatureScarponiRinforzati", panels: []
                          }
,                          {
                            name: "p_cmdAggiungAttrezzaturaScarponiRinforzati", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzaturePantaloniAntitaglio", panels: []
                      }
,                      {
                        name: "p_mpAttrezzaturePantaloniAntitaglio", panels: [
                        {
                          name: "p_fpAttrezzaturePantaloniAntitaglio", panels: [
                          {
                            name: "p_wpElencoAttrezzaturePantaloniAntitaglio", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaPantaloniAntitaglio", panels: []
                          }
                          ]
                        }
                        ]
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpAttrezzatureFr", panels: [
                    {
                      name: "p_fpAttrezzatureFr", panels: [
                      {
                        name: "p_wpAttrezzatureFr", panels: []
                      }
                      ]
                    }
                    ]
                  }
                  ]
                }
,                {
                  name: "p_pWizardAttrezzatureSub2", panels: [
                  {
                    name: "p_mpMacchineMezziIt", panels: [
                    {
                      name: "p_fpMacchineMezziIt", panels: [
                      {
                        name: "p_wpAttrezzatureMacchineTrattrici", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineTrattrici", panels: [
                        {
                          name: "p_fpAttrezzatureMacchinaElencoTrattrici", panels: [
                          {
                            name: "p_wpElencoMacchinaTrattrici", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaTrattrice", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineSpeciali", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineSpeciali", panels: [
                        {
                          name: "p_fpAttrezzatureMacchineSpeciali", panels: [
                          {
                            name: "p_wpElencoMacchineSpeciali", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaSpeciale", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineMovimentoATerra", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineMovimentoATerra", panels: [
                        {
                          name: "p_fpAttrezzatureMacchineMovimentoATerra", panels: [
                          {
                            name: "p_wpElencoMacchineMovimentoATerra", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaMovimentoATerra", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineRimorchi", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineRimorchi", panels: [
                        {
                          name: "p_fpAttrezzatureMacchinaElencoRimorchi", panels: [
                          {
                            name: "p_wpElencoMacchinaRimorchi", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaRimorchi", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineVerricelli", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineVerricelli", panels: [
                        {
                          name: "p_fpAttrezzatureMacchinaElencoVerricelli", panels: [
                          {
                            name: "p_wpElencoMacchinaVerricelli", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaVerricelli", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchinePle", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchinePle", panels: [
                        {
                          name: "p_fpAttrezzatureMacchinaElencoPle", panels: [
                          {
                            name: "p_wpElencoMacchinaPle", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaPle", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineTrinciaForestale", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineTrinciaForestale", panels: [
                        {
                          name: "p_fpAttrezzatureMacchinaElencoTrinciaForestale", panels: [
                          {
                            name: "p_wpElencoMacchinaTrinciaForestale", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaTrinciaForestale", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineSegherieMobili", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineSegherieMobili", panels: [
                        {
                          name: "p_fpAttrezzatureMacchineSegherieMobili", panels: [
                          {
                            name: "p_wpElencoMacchineSegherieMobili", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaSegherieMobili", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineGruACavo", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineGruACavo", panels: [
                        {
                          name: "p_fpAttrezzatureMacchineGruACavo", panels: [
                          {
                            name: "p_wpElencoMacchineGruACavo", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaGruACavo", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineCippatrici", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineCippatrici", panels: [
                        {
                          name: "p_fpAttrezzatureMacchineCippatrici", panels: [
                          {
                            name: "p_wpElencoMacchineCippatrici", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaCippatrici", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMezziDiTrasporto", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMezziDiTrasporto", panels: [
                        {
                          name: "p_fpAttrezzatureMezziDiTrasporto", panels: [
                          {
                            name: "p_wpElencoMezziDiTrasporto", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMezziDiTrasporto", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureAltriMezzi", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureAltriMezzi", panels: [
                        {
                          name: "p_fpAttrezzatureAltriMezzi", panels: [
                          {
                            name: "p_wpElencoAltriMezzi", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaAltriMezzi", panels: []
                          }
                          ]
                        }
                        ]
                      }
                      ]
                    }
                    ]
                  }
,                  {
                    name: "p_mpMacchineMezziFr", panels: [
                    {
                      name: "p_fpMacchineMezziFr", panels: [
                      {
                        name: "p_wpAttrezzatureMacchineSpecialiFr", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineSpecialiFr", panels: [
                        {
                          name: "p_fpAttrezzatureMacchineSpecialiFr", panels: [
                          {
                            name: "p_wpElencoMacchineSpecialiFr", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaSpecialeFr", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineMovimentoATerraFr", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineMovimentoATerraFr", panels: [
                        {
                          name: "p_fpAttrezzatureMacchineMovimentoATerraFr", panels: [
                          {
                            name: "p_wpElencoMacchineMovimentoATerraFr", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaMovimentoATerraFr", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineGrumier", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineGrumier", panels: [
                        {
                          name: "p_fpAttrezzatureMacchinaElencoGrumier", panels: [
                          {
                            name: "p_wpElencoMacchinaGrumier", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaGrumier", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineRimorchiFr", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineRimorchiFr", panels: [
                        {
                          name: "p_fpAttrezzatureMacchinaElencoRimorchiFr", panels: [
                          {
                            name: "p_wpElencoMacchinaRimorchiFr", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaRimorchiFr", panels: []
                          }
                          ]
                        }
                        ]
                      }
,                      {
                        name: "p_wpAttrezzatureMacchineSemi", panels: []
                      }
,                      {
                        name: "p_mpAttrezzatureMacchineSemi", panels: [
                        {
                          name: "p_fpAttrezzatureMacchinaElencoSemi", panels: [
                          {
                            name: "p_wpElencoMacchinaSemi", panels: []
                          }
,                          {
                            name: "p_cmdAggiungiAttrezzaturaMacchinaSemi", panels: []
                          }
                          ]
                        }
                        ]
                      }
                      ]
                    }
                    ]
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_fpWizard6Personale", panels: [
              {
                name: "p_wpPersonale", panels: []
              }
,              {
                name: "p_mpAltroPersonale", panels: [
                {
                  name: "p_fpAltroPersonale", panels: [
                  {
                    name: "p_wpRicercaAltroPersonale", panels: []
                  }
,                  {
                    name: "p_wpAltroPersonale", panels: []
                  }
,                  {
                    name: "p_cmdAggiungiPersonale", panels: []
                  }
                  ]
                }
                ]
              }
,              {
                name: "p_mpAltroPersonaleFr", panels: [
                {
                  name: "p_fpAltroPersonaleFr", panels: [
                  {
                    name: "p_wpAltroPersonaleFr", panels: []
                  }
,                  {
                    name: "p_wpAltroPersonaleTipoContrattoFr", panels: []
                  }
,                  {
                    name: "p_wpAltroPersonaleTipoMansioneFr", panels: []
                  }
                  ]
                }
                ]
              }
              ]
            }
            ]
          }
,          {
            name: "p_cmdWizardDomanda", panels: []
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

	initStdEnrichments4CpDomanda();
	initCustomEnrichments4CpDomanda();
	initUIStructCpDomanda();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("CpDomanda");

});



