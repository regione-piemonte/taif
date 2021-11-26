/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager.validation;

/**
 * Costanti per il riferimento ai campi.
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 * @author 71908 (Ansoumana Mane)
 */
public final class FieldList {
	
	// Login
	public static final String LOGIN_USER = "appDatalogin.user";
	public static final String LOGIN_PASS = "appDatalogin.password";
    
	//Profilo
	
	public static final String PROFILO = "appDatacurrentUser.user";
    // Scheda 1.1
    public static final String DATI_AZIENDALI_CODICE_FISCALE = "appDataanagraficaAziendale.codiceFiscale";
    public static final String DATI_AZIENDALI_PARTITA_IVA = "appDataanagraficaAziendale.partitaIva";
    public static final String DATI_AZIENDALI_DESCRIZIONE = "appDataanagraficaAziendale.descrizione";
    public static final String DATI_AZIENDALI_ATTIVITA_PRINCIPALE = "appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale";
    public static final String DATI_AZIENDALI_ATTIVITA_SECONDARIA = "appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale";
    public static final String DATI_AZIENDALI_FORMA_GIURIDICA = "appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale";
    public static final String DATI_AZIENDALI_NOTE = "appDataanagraficaAziendale.note";
    public static final String DATI_AZIENDALI_PROVINCIA_CCIAA = "appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale";
    public static final String DATI_AZIENDALI_NUMERO_CCIAA = "appDataanagraficaAziendale.numeroCCIAA";
    public static final String DATI_AZIENDALI_PEC = "appDataanagraficaAziendale.pec";
    public static final String DATI_AZIENDALI_EMAIL = "appDataanagraficaAziendale.email";
    public static final String DATI_AZIENDALI_TELEFONO = "appDataanagraficaAziendale.telefono";
    public static final String DATI_AZIENDALI_CELLULARE = "appDataanagraficaAziendale.cellulare";
    public static final String DATI_AZIENDALI_MARCA_DA_BOLLO = "appDataanagraficaAziendale.marcaDaBollo";
    public static final String DATI_AZIENDALI_PRIVACY = "appDataanagraficaAziendale.privacy";
    public static final String SEDE_TIPO_SEDE = "appDataelencoSediDatiAnagraficiAnagrafeAziendale.sitoInternet";
    public static final String SEDE_COMUNE = "appDataelencoSediDatiAnagraficiAnagrafeAziendale.comune";
    public static final String SEDE_CAP = "appDataelencoSediDatiAnagraficiAnagrafeAziendale.cap";
    public static final String SEDE_INDIRIZZO = "appDataelencoSediDatiAnagraficiAnagrafeAziendale.indirizzo";
    public static final String SEDE_CIVICO = "appDataelencoSediDatiAnagraficiAnagrafeAziendale.civico";
    public static final String SEDE_TELEFONO = "appDataelencoSediDatiAnagraficiAnagrafeAziendale.telefono";
                                                   
    public static final String SEDE_LEGALE_COMUNE = "appDataelencoSediDatiAnagraficiAnagrafeAziendale.comune";
    public static final String SEDE_LEGALE_CAP = "appDatasedeLegaleAnagrafeAziendale.cap";
    public static final String SEDE_LEGALE_INDIRIZZO = "appDatasedeLegaleAnagrafeAziendale.indirizzo";
    public static final String SEDE_LEGALE_CIVICO = "appDatasedeLegaleAnagrafeAziendale.numeroCivico";
    public static final String SEDE_LEGALE_TELEFONO = "appDataelencoSediDatiAnagraficiAnagrafeAziendale.telefono";
    
    
    
    // Scheda 1.2
    
    public static final String TITOLARE_RAPP_CODICE_FISCALE = "appDatatitolareRappresentanteLegale.codiceFiscale";
    public static final String TITOLARE_RAPP_NOME ="appDatatitolareRappresentanteLegale.nome";
    public static final String TITOLARE_RAPP_COGNOME ="appDatatitolareRappresentanteLegale.cognome";
    public static final String TITOLARE_RAPP_DATA_NASCITA ="appDatatitolareRappresentanteLegale.dataNascita";
    public static final String TITOLARE_RAPP_CAP ="appDatatitolareRappresentanteLegale.cap";
    public static final String TITOLARE_RAPP_INDIRIZZO ="appDatatitolareRappresentanteLegale.indirizzo";
    public static final String TITOLARE_RAPP_CIVICO ="appDatatitolareRappresentanteLegale.civico";
    public static final String TITOLARE_RAPP_TELEFONO ="appDatatitolareRappresentanteLegale.telefono";
    public static final String TITOLARE_RAPP_EMAIL ="appDatatitolareRappresentanteLegale.email";
    public static final String TITOLARE_RAPP_ALTRI_STUDI="appDatatitolareRappresentanteLegale.altriStudi";
    public static final String TITOLARE_ID_STATO_NASCITA="appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale";
    public static final String TITOLARE_ID_TITOLO_STUDI="appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale";
    public static final String TITOLARE_COM_REZIDENZA="widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza";
    public static final String TITOLARE_COM_NASCITA="widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascita";
    public static final String RADIO_SEL="widg_rbsDatiAnagraficiAltroConducente";
   
    
    
    public static final String CONDUTTORE_AZ_CODICE_FISCALE = "appDataaltroTitolareRappresentanteLegale.codiceFiscale";
    public static final String CONDUTTORE_AZ_NOME ="appDataaltroTitolareRappresentanteLegale.nome";
    public static final String CONDUTTORE_AZ_COGNOME ="appDataaltroTitolareRappresentanteLegale.cognome";
    public static final String CONDUTTORE_AZ_DATA_NASCITA ="appDataaltroTitolareRappresentanteLegale.dataNascita";
    public static final String CONDUTTORE_AZ_CAP ="appDataaltroTitolareRappresentanteLegale.cap";
    public static final String CONDUTTORE_AZ_INDIRIZZO ="appDataaltroTitolareRappresentanteLegale.indirizzo";
    public static final String CONDUTTORE_AZ_CIVICO ="appDataaltroTitolareRappresentanteLegale.civico";
    public static final String CONDUTTORE_AZ_CELLULARE ="appDataaltroTitolareRappresentanteLegale.cellulare";
    public static final String CONDUTTORE_AZ_EMAIL ="appDataaltroTitolareRappresentanteLegale.email";
    public static final String CONDUTTORE_AZ_ALTRI_STUDI="appDataaltroTitolareRappresentanteLegale.altriStudi";
    public static final String CONDUTTORE_AZ_ID_STATO_NASCITA="appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale";
    public static final String CONDUTTORE_AZ_ID_TITOLO_STUDI="appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale";
    public static final String CONDUTTORE_AZ_COM_REZIDENZA="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneResidenza";
    public static final String CONDUTTORE_AZ_COM_NASCITA="widg_tfDatiAnagraficiTitolareAltroRappresentanteLegaleComuneNascita";
    
    
    // Scheda 2.1
    public static final String FATTURATO_ANNO_INIZIO_ATTIVITA="appDatafatturatoCategorieDiImpresa.annoInizioAttivita";
    public static final String FATTURATO_TOTALE_ULTIMO_ANNO="appDatafatturatoCategorieDiImpresa.fatturatoUltimoAnno";
    public static final String ELENCO_CATEGORIE_IMPRESE="appDataelencoCategorieImpresa";
    public static final String ELENCO_CATEGORIE_IMPRESE_SELEZIONATE="appDataidCategorieImpresaSelezionati";
    public static final String CATEGORIE_ALTRE="appDataelencoCategorieImpresa4altro";
    
    // Scheda 2.2
    
    public static final String RADIO_INSCRIZIONE_ALBI= "widg_rbsDatiSocioEconomiciAltriAlbi";
    public static final String ELENCO_FORME_ORGANIZ= "appDataelencoFormeOrganizzative";
    public static final String ELENCO_ALTRI_ALBI= "appDataelencoAltriAlbi";
    public static final String RADIO_CERTIFICAZIONI= "widg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso";
    public static final String ELENCO_CERTIFICAZIONI= "appDataelencoCertificazioni";
    
   
    
    // Scheda 3.1
    public static final String ATT1_REG_TAGLI_UTILIZ= "appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTagliDiUtilizzazione";
    public static final String ATT1_REG_TAGLI_UTILIZ_TERZI= "appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTagliDiUtilizzazioneContoTerzi";
    public static final String ATT1_REG_TAGLI_PIOPPETI = "appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTaglioPioppeti";
    public static final String ATT1_REG_TAGLI_PIOPPETI_TERZI = "appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTaglioPioppetiContoTerzi";
    public static final String ATT1_REG_TAGLI_INTERC="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTagliIntercalari";
    public static final String ATT1_REG_TAGLI_INTERC_TERZI ="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTagliIntercalariContoTerzi";
    public static final String ATT1_FUORI_TAGLI_UTILIZ="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTagliDiUtilizzazione";
    public static final String ATT1_FUORI_TAGLI_UTILIZ_TERZI ="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTagliDiUtilizzazioneContoTerzi";
    public static final String ATT1_FUORI_TAGLI_PIOPPETI ="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTaglioPioppeti";
    public static final String ATT1_FUORI_TAGLI_PIOPPETI_TERZI = "appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTaglioPioppetiContoTerzi";
    public static final String ATT1_FUORI_TAGLI_INTERC="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTagliIntercalari";
    public static final String ATT1_FUORI_TAGLI_INTERC_TERZI ="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTagliIntercalariContoTerzi";
    public static final String ATT2_ETTARI_REAL="appDatagestioneAttivitaUltimoAnno.attivita2.ettariRealizzati";
    public static final String ATT2_PERCENTUALE="appDatagestioneAttivitaUltimoAnno.attivita2.percentuale";
    public static final String ATT3_REALIZZAZIONE= "appDatagestioneAttivitaUltimoAnno.attivita3.realizzazione";
    public static final String ATT3_MANUTENZIONE="appDatagestioneAttivitaUltimoAnno.attivita3.manutenzione";
    public static final String ATT3_PERCENTUALE= "appDatagestioneAttivitaUltimoAnno.attivita3.percentuale";
    public static final String ATT4_PROPAGAZIONE="appDatagestioneAttivitaUltimoAnno.attivita4";
    public static final String ATT4_PROPAGAZIONE_ID="appDataidMaterialiPropagazione"; 
    public static final String ATT4_PERCENTUALE="appDatagestioneAttivitaUltimoAnno.attivita4.percentuale";
    public static final String ATT4_PROPAGAZIONE_ELENCO="appDatagestioneAttivitaUltimoAnno.attivita4.appDataelencoMaterialePropagazione";
    public static final String ATT4_PROPAGAZIONE_LISTA="appDataelencoMaterialePropagazione";
    public static final String ATT5_ARB_LEGNO="appDataelencoArboricolturaDaLegno";
    public static final String ATT5_REALIZZAZIONE="appDataelencoArboricolturaDaLegno.realizzazione";
    public static final String ATT5_MANUTENZIONE="appDataelencoArboricolturaDaLegno.manutenzione";
    public static final String ATT5_CONDUZIONE="appDataelencoArboricolturaDaLegno.conduzione";
    public static final String ATT5_PERCENTUALE="appDatagestioneAttivitaUltimoAnno.attivita5.percentuale";
    public static final String ATT6_PERCENTUALE="appDatagestioneAttivitaUltimoAnno.attivita6.percentuale";
    public static final String ATT7_PERCENTUALE="appDatagestioneAttivitaUltimoAnno.attivita7.percentuale";
    public static final String ATT8_PERCENTUALE="appDatagestioneAttivitaUltimoAnno.attivita8.percentuale";
    public static final String ATT9_PERCENTUALE="appDatagestioneAttivitaUltimoAnno.attivita9.percentuale";
    public static final String ATT1_PERCENTUALE="appDatagestioneAttivitaUltimoAnno.attivita1.percentuale";
    public static final String ATT_FR_PERCENTUALE="appDataelencoAttivitaUltimoAnnoFr.percentuale";
    public static final String ATT_FR_VOLUME="appDataelencoAttivitaUltimoAnnoFr.volume";
   
    // Scheda 3.2
    
    public static final String  LAVORI_PA_COMMITENTE="appDataelencoLavoriPA.committente";
    public static final String  LAVORI_PA_INTERVENTO="appDataelencoLavoriPA.idOggettoIntervento";
    public static final String  LAVORI_PA_IMPORTO="appDataelencoLavoriPA.importoComplessivo";
    public static final String  LAVORI_PA_ALTRO="appDataelencoLavoriPA.altro";
 
    // Scheda 3.3
    public static final String  LEGNAME_COMM_SPECIE="appDataelencoLegnamiAssortimentiTrattati.idSpecie";
    public static final String  LEGNAME_COMM_PROVENIENZA="appDataelencoLegnamiAssortimentiTrattati.idProvenienza";
    public static final String  LEGNAME_COMM_ASSORTIMENTO="appDataelencoLegnamiAssortimentiTrattati.idAssortimento";
    public static final String  LEGNAME_COMM_TA="appDataelencoLegnamiAssortimentiTrattati.idTA";
    public static final String  LEGNAME_COMM_VEOL_VENDUTO="appDataelencoLegnamiAssortimentiTrattati.volumeVendutoMedioAnnuo";
    public static final String  LEGNAME_COMM_UM="appDataelencoLegnamiAssortimentiTrattati.idUnitaMisura";
    public static final String  LEGNAME_COMM_DESTINAZIONE="appDataelencoLegnamiAssortimentiTrattati.idDestinazione";
    public static final String  LEGNAME_COMM_FR_PERCENTUALE="appDatapercentualeCommercioFr";
    public static final String  LEGNAME_COMM_ALTRO="appDataelencoLegnamiAssortimentiTrattati.altro";
    
    // Scheda 4
    public static final String  CAPANNONE_FUNZIONE="appDataelencoCapannoni.funzioneCapannone";
    public static final String  CAPANNONE_DIMENSIONE="appDataelencoCapannoni.dimensioneCapannone";
    public static final String  CAPANNONE_ANNO="appDataelencoCapannoni.annoCostruzioneORiattamentoCapannone";
    
    public static final String  STOCCAGGIO_DIMENSIONE="appDataelencoPiazzaliStoccaggio.dimensionePiazzale";
    public static final String  STOCCAGGIO_ANNO="appDataelencoPiazzaliStoccaggio.annoCostruzioneORiattamentoPiazzale";
   
    // Scheda 5.1
    
    public static final String  ATTREZZATURA_CASCO_TIPO ="appDataelencoCaschiForestaliAttrezzature.tipologia";
    public static final String  ATTREZZATURA_CASCO_QUANTITA ="appDataelencoCaschiForestaliAttrezzature.quantita";
    public static final String  ATTREZZATURA_CASCO_ANNO ="appDataelencoCaschiForestaliAttrezzature.annoScadenza";
    
    public static final String  ATTREZZATURA_SCARPONI_TIPO ="appDataelencoScarponiRinforzatiAttrezzature.tipologia";
    public static final String  ATTREZZATURA_SCARPONI_QUANTITA ="appDataelencoScarponiRinforzatiAttrezzature.quantita";
    public static final String  ATTREZZATURA_SCARPONI_ANNO ="appDataelencoScarponiRinforzatiAttrezzature.annoScadenza";
    
    public static final String  ATTREZZATURA_PANTALONI_TIPO ="appDataelencoPantaloniAntitaglioAttrezzature.tipologia";
    public static final String  ATTREZZATURA_PANTALONI_QUANTITA ="appDataelencoPantaloniAntitaglioAttrezzature.quantita";
    public static final String  ATTREZZATURA_PANTALONI_ANNO ="appDataelencoPantaloniAntitaglioAttrezzature.annoScadenza";
    // Scheda 5.2
  
    public static final String  MEZZI_TRATTICE_ANNO ="appDataelencoMacchineTrattrici.annoImmatricolazione";
    public static final String  MEZZI_TRATTICE_POTENZA ="appDataelencoMacchineTrattrici.potenza";
    public static final String  MEZZI_TRATTICE_TRAZIONE ="appDataelencoMacchineTrattrici.idTipoTrazione";
    public static final String  MEZZI_TRATTICE_NOLEGGIO ="appDataelencoMacchineTrattrici.idTipoNoleggio";
    
    public static final String  MEZZI_SECIALE_TIPO ="appDataelencoMacchineSpeciali.idTipoMacchinaMezzo";
    public static final String  MEZZI_SECIALE_ANNO ="appDataelencoMacchineSpeciali.annoImmatricolazione";
    public static final String  MEZZI_SECIALE_POTENZA ="appDataelencoMacchineSpeciali.potenza";
    public static final String  MEZZI_SECIALE_NOLEGGIO ="appDataelencoMacchineSpeciali.idTipoNoleggio";
    
    public static final String  MEZZI_TERRA_TIPO ="appDataelencoMacchineMovimentoTerra.idTipoMacchinaMezzo";
    public static final String  MEZZI_TERRA_ANNO ="appDataelencoMacchineMovimentoTerra.annoImmatricolazione";
    public static final String  MEZZI_TERRA_POTENZA ="appDataelencoMacchineMovimentoTerra.potenza";
    public static final String  MEZZI_TERRA_TRAZIONE ="appDataelencoMacchineMovimentoTerra.idTipoTrazione";
    public static final String  MEZZI_TERRA_NOLEGGIO ="appDataelencoMacchineMovimentoTerra.idTipoNoleggio";
    
    public static final String  MEZZI_RIMORCHI_ANNO ="appDataelencoMacchineRimorchi.annoImmatricolazione";
    public static final String  MEZZI_RIMORCHI_POTENZA ="appDataelencoMacchineRimorchi.potenza";
    public static final String  MEZZI_RIMORCHI_TRAZIONE ="appDataelencoMacchineRimorchi.idTipoTrazione";
    public static final String  MEZZI_RIMORCHI_NOLEGGIO ="appDataelencoMacchineRimorchi.idTipoNoleggio";
    
    public static final String  MEZZI_VERRICELLI_ANNO ="appDataelencoMacchineVerricelli.annoImmatricolazione";
    public static final String  MEZZI_VERRICELLI_POTENZA ="appDataelencoMacchineVerricelli.potenza";
    public static final String  MEZZI_VERRICELLI_COMANDO ="appDataelencoMacchineVerricelli.comandatoADistanza";
    public static final String  MEZZI_VERRICELLI_NOLEGGIO ="appDataelencoMacchineVerricelli.idTipoNoleggio";
    

    public static final String  MEZZI_PLE_ANNO ="appDataelencoMacchinePle.annoImmatricolazione";
    public static final String  MEZZI_PLE_POTENZA ="appDataelencoMacchinePle.potenza";
    public static final String  MEZZI_PLE_NOLEGGIO ="appDataelencoMacchinePle.idTipoNoleggio";
    
    public static final String  MEZZI_TRINCIA_ANNO ="appDataelencoMacchineTrinciaForestali.annoImmatricolazione";
    public static final String  MEZZI_TRINCIA_POTENZA ="appDataelencoMacchineTrinciaForestali.potenza";
    public static final String  MEZZI_TRINCIA_NOLEGGIO ="appDataelencoMacchineTrinciaForestali.idTipoNoleggio";
    
    public static final String  MEZZI_SEGHERIE_TIPO ="appDataelencoMacchineSegheriaMobile.idTipoMacchinaMezzo";
    public static final String  MEZZI_SEGHERIE_ANNO ="appDataelencoMacchineSegheriaMobile.annoImmatricolazione";
    public static final String  MEZZI_SEGHERIE_POTENZA ="appDataelencoMacchineSegheriaMobile.potenza";
    public static final String  MEZZI_SEGHERIE_NOLEGGIO ="appDataelencoMacchineSegheriaMobile.idTipoNoleggio";
    public static final String  MEZZI_SEGHERIE_ALIM ="appDataelencoMacchineSegheriaMobile.idTipoAlimentazione";
    
    public static final String  MEZZI_GRU_TIPO ="appDataelencoMacchineGruACavo.idTipoMacchinaMezzo";
    public static final String  MEZZI_GRU_ANNO ="appDataelencoMacchineGruACavo.annoImmatricolazione";
    public static final String  MEZZI_GRU_POTENZA ="appDataelencoMacchineGruACavo.potenza";
    public static final String  MEZZI_GRU_PORTATA ="appDataelencoMacchineGruACavo.portata";
    public static final String  MEZZI_GRU_CARELLO ="appDataelencoMacchineGruACavo.idTipoCarrello";
    public static final String  MEZZI_GRU_NOLEGGIO ="appDataelencoMacchineGruACavo.idTipoNoleggio";
    
    public static final String  MEZZI_CIPPATRICI_ALIM ="appDataelencoMacchineCippatrici.idTipoAlimentazione";
    public static final String  MEZZI_CIPPATRICI_ANNO ="appDataelencoMacchineCippatrici.annoImmatricolazione";
    public static final String  MEZZI_CIPPATRICI_POTENZA ="appDataelencoMacchineCippatrici.potenza";
    public static final String  MEZZI_CIPPATRICI_NOLEGGIO ="appDataelencoMacchineCippatrici.idTipoNoleggio";
    
    public static final String  MEZZI_TRANSP_TIPO ="appDataelencoMezziDiTrasporto.idTipoMacchinaMezzo";
    public static final String  MEZZI_TRANSP_ANNO ="appDataelencoMezziDiTrasporto.annoImmatricolazione";
    public static final String  MEZZI_TRANSP_POTENZA ="appDataelencoMezziDiTrasporto.potenza";
    public static final String  MEZZI_TRANSP_PORTATA ="appDataelencoMezziDiTrasporto.portata";
    public static final String  MEZZI_TRANSP_NOLEGGIO ="appDataelencoMezziDiTrasporto.idTipoNoleggio";
    
    public static final String  MEZZI_SECIALE_FR_TIPO ="appDataelencoMacchineSpecialiFr.idTipoMacchinaMezzo";
    public static final String  MEZZI_SECIALE_FR_ANNO ="appDataelencoMacchineSpecialiFr.annoImmatricolazione";
    public static final String  MEZZI_SECIALE_FR_POTENZA ="appDataelencoMacchineSpecialiFr.potenza";
    public static final String  MEZZI_SECIALE_FR_NOLEGGIO ="appDataelencoMacchineSpecialiFr.idTipoNoleggio";
    
    public static final String  MEZZI_TERRA_FR_TIPO ="appDataelencoMacchineMovimentoTerraFr.idTipoMacchinaMezzo";
    public static final String  MEZZI_TERRA_FR_ANNO ="appDataelencoMacchineMovimentoTerraFr.annoImmatricolazione";
    public static final String  MEZZI_TERRA_FR_POTENZA ="appDataelencoMacchineMovimentoTerraFr.potenza";
    public static final String  MEZZI_TERRA_FR_TRAZIONE ="appDataelencoMacchineMovimentoTerraFr.idTipoTrazione";
    public static final String  MEZZI_TERRA_FR_NOLEGGIO ="appDataelencoMacchineMovimentoTerraFr.idTipoNoleggio";
    
    public static final String  MEZZI_RIMORCHI_FR_ANNO ="appDataelencoMacchineRimorchiFr.annoImmatricolazione";
    public static final String  MEZZI_RIMORCHI_FR_POTENZA ="appDataelencoMacchineRimorchiFr.potenza";
    public static final String  MEZZI_RIMORCHI_FR_TRAZIONE ="appDataelencoMacchineRimorchiFr.idTipoTrazione";
    public static final String  MEZZI_RIMORCHI_FR_NOLEGGIO ="appDataelencoMacchineRimorchiFr.idTipoNoleggio";
    
    public static final String  MEZZI_GRUMIER_FR_ANNO ="appDataelencoMacchineGrumier.annoImmatricolazione";
    public static final String  MEZZI_GRUMIER_FR_POTENZA ="appDataelencoMacchineGrumier.potenza";
    public static final String  MEZZI_GRUMIER_FR_TRAZIONE ="appDataelencoMacchineGrumier.idTipoTrazione";
    public static final String  MEZZI_GRUMIER_FR_NOLEGGIO ="appDataelencoMacchineGrumier.idTipoNoleggio";
    
    public static final String  MEZZI_SEMI_FR_ANNO ="appDataelencoMacchineSemi.annoImmatricolazione";
    public static final String  MEZZI_SEMI_FR_POTENZA ="appDataelencoMacchineSemi.potenza";
    public static final String  MEZZI_SEMI_FR_TRAZIONE ="appDataelencoMacchineSemi.idTipoTrazione";
    public static final String  MEZZI_SEMI_FR_NOLEGGIO ="appDataelencoMacchineSemi.idTipoNoleggio";
    
    public static final String  ALTRI_MEZZI_DESCRIZIONE ="appDataelencoAltriMezzi.descrizione";
    public static final String  ALTRI_MEZZI_ANNO ="appDataelencoAltriMezzi.annoImmatricolazione";
    public static final String  ALTRI_MEZZI_POTENZA ="appDataelencoAltriMezzi.potenza";
    public static final String  ALTRI_MEZZI_TRAZIONE ="appDataelencoAltriMezzi.idTipoTrazione";
    public static final String  ALTRI_MEZZI_ALIM ="appDataelencoAltriMezzi.idTipoAlimentazione";
    public static final String  ALTRI_MEZZI_PORTATA ="appDataelencoAltriMezzi.portata";
    public static final String  ALTRI_MEZZI_CARELLO ="appDataelencoAltriMezzi.idTipoCarrello";
    public static final String  ALTRI_MEZZI_NOLEGGIO ="appDataelencoAltriMezzi.idTipoNoleggio";
    

    
    // Scheda 6
    public static final String  PERSONALE_TOTALE_ADDETTI ="appDatagestioneAltroPersonaleFr.numeroTotaleAddetti";
    public static final String  PERSONALE_TOTALE_CONTRATTI ="appDataelencoAltroPersonaleTipoContrattoF.numeroAddetti"; 
    public static final String  PERSONALE_TOTALE_MANSIONI ="appDataelencoAltroPersonaleTipoMansioneFr.numeroAddetti";
    
    // Documentazione
    public static final String DOCUMENTAZIONE_TIPO_FIRMA = "appDataidTipologiaAllegatoSelezionato";
    
    public static final String  STATI_PROTOCOLO ="appDataelencoGestioneStatiRiepilogo.numeroProtocollo";
    
    
    /**
     * Constructor.
     */
    private FieldList() {
        /* NOP */
    }

}
