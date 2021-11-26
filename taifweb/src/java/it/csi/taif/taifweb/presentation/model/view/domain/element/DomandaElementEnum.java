/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.model.view.domain.element;

import it.csi.taif.taifweb.presentation.model.view.ViewElement;

public enum DomandaElementEnum implements ViewElement {
	// @formatter:off
	APPDATA_ID_ISTANZA_SELEZIONATA("appDataidIstanzaSelezionata"),
	APPDATA_INSERISCI_NUOVA_SEDE("appDatainserisciNuovaSede"),
	APPDATA_SELEZIONA_SEDE("appDataselezionaSede"),
	BTN_AGGIUNGI_SOGGETTO_PROPONENTE("btnAggiungiSoggettoProponente"),
	BTN_ALLEGATI_CARICA_DOCUMENTO("btnAllegatiCaricaDocumento"),
	BTN_ALLEGATI_CARICA_DOCUMENTO_FIRMATO("btnAllegatiCaricaDocumentoFirmato"),
	BTN_ALLEGATI_CONFERMA_INVIO_DOCUMENTO_FIRMATO("btnAllegatiConfermaInvioDocumentoFirmato"),
	BTN_ALLEGATI_ELIMINA("btnAllegatiElimina"),
	BTN_ALLEGATI_FIRMA("btnAllegatiFirma"),
	BTN_ALLEGATI_SCARICA("btnAllegatiScarica"),
	BTN_CERCA_INDIRIZZO_SEDE("btnCercaIndirizzoSede"),
	BTN_COMPILA_MODULO("btnCompilaModulo"),
	BTN_COMPILA_MODULO_MODIFICA("btnCompilaModuloModifica"),
	BTN_COMPILA_MODULO_PROCURA("btnCompilaModuloProcura"),
	BTN_DATI_ISTANZA_INSERISCI_NUOVA_SEDE("btnDatiIstanzaInserisciNuovaSede"),
	BTN_DATI_ISTANZA_SELEZIONA_SEDE("btnDatiIstanzaSelezionaSede"),
	BTN_GEOREFERENZAZIONE("btnGeoreferenzazione"),
	BTN_GEOREFERENZIA_SEDE("btnGeoreferenziaSede"),
	BTN_INSERISCI_OGGETTI_TERRITORIO("btnInserisciOggettiTerritorio"),
	BTN_INSERISCI_NUOVA_SEDE("btnInserisciNuovaSede"),
	BTN_INTEGRAZIONI_SCARICA("btnIntegrazioniScarica"),
	BTN_INUTILE_PROSEGUI("btnInutileProsegui"),
	BTN_OGGETTI_TERRITORIO("btnOggettiTerritorio"),
	BTN_RICERCA_SEDI("btnRicercaSedi"),
	BTN_RIMUOVI_SEDE("btnRimuoviSede"),
	BTN_SELEZIONA_SEDI("btnSelezionaSedi"),
	BTN_VISUALIZZA_MODULO("btnVisualizzaModulo"),
	CB_AUTORITA_COMPETENTE("cbAutoritaCompetente"),
	CB_COMUNI("cbComuni"),
	CB_INDIRIZZI_SEDE("cbIndirizziSede"),
	CB_PROVINCIA("cbProvincia"),
	CB_SCHEDE_ALLEGATI("cbSchedeAllegati"),
	CB_SOGGETTO_AZIENDA("cbSoggettoAzienda"),
	CB_TIPOLOGIA_ALLEGATI("cbTipologiaAllegati"),
	CB_TIPOLOGIA_ISTANZA_FIRMATA("cbTipologiaIstanzaFirmata"),
	FP_ALLEGA_ISTANZA_FIRMATA("fpAllegaIstanzaFirmata"),
	FP_ALLEGATI("fpAllegati"),
	FP_DATI_SEDI("fpDatiSedi"),
	FP_RICERCA_SEDI("fpRicercaSedi"),
	FU_ALLEGATI("fuAllegati"),
	FU_ALLEGATI_FIRMATI("fuAllegatiFirmati"),
	MP_ALLEGA_DOCUMENTI("mpAllegaDocumenti"),
	MP_ALLEGA_ISTANZA_FIRMATA("mpAllegaIstanzaFirmata"),
	MP_DATI_SEDI("mpDatiSedi"),
	MP_RICERCA_SEDE("mpRicercaSede"),
	PT_LABEL_CERCA_INDIRIZZO("ptLabelCercaIndirizzo"),
	PT_MESSAGGIO_AVVISO_A("ptMessaggioAvvisoA"),
	PT_MESSAGGIO_AVVISO_B("ptMessaggioAvvisoB"),
	TA_NOTE_ALLEGATI("taNoteAllegati"),
	TA_NOTE_ALLEGATI_FIRMATI("taNoteAllegatiFirmati"),
	TBL_ELENCO_SEDI("tblElencoSedi"),
	TBL_ELENCO_INTEGRAZIONI("tbElencoIntegrazioni"),
	TBL_RISULTATI_RICERCA_SEDI("tblRisultatiRicercaSedi"),
	TF_CIVICO_SEDE("tfCivicoSede"),	
	TF_COORDINATE_X("tfCoordinateX"),
	TF_COORDINATE_Y("tfCoordinateY"),
	TF_DENOMINAZIONE_SEDE("tfDenominazioneSede"),
	TF_INDIRIZZO_NON_TROVATO_SEDE("tfIndirizzoNonTrovatoSede"),
	TF_INDIRIZZO_SEDE("tfIndirizzoSede"),
	TSP_DATI_ISTANZA("tspDatiIstanza"),
	UDP_LABEL_INTEGRAZIONI("udpLabelIntegrazioni")
	;
	// @formatter:on

	private String name;

	private DomandaElementEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
