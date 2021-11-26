/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business;

import java.util.*;

import it.csi.taif.taifweb.dto.*;

import org.apache.log4j.*;
import it.csi.taif.taifweb.util.*;

/*PROTECTED REGION ID(R-1534196706) ENABLED START*/
import javax.servlet.jsp.jstl.core.Config;

import it.csi.iride2.policy.entity.Identita;
import it.csi.taif.taifweb.business.common.ProfiloEnum;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.dto.common.LoginInfo;
import it.csi.taif.taifweb.dto.common.ProfiloUtenteTaif;
import it.csi.taif.taifweb.dto.common.UserInfo;
import it.csi.taif.taifweb.exception.ManagerException;

import com.opensymphony.xwork2.ActionContext;
/*PROTECTED REGION END*/

public class BackEndFacade {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [idAlboSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALBOSELEZIONATO_CODE = "appDataidAlboSelezionato";

	// ApplicationData: [treeElencoAziende, scope:USER_SESSION]
	public static final String APPDATA_TREEELENCOAZIENDE_CODE = "appDatatreeElencoAziende";

	// ApplicationData: [nodoAziendaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_NODOAZIENDASELEZIONATA_CODE = "appDatanodoAziendaSelezionata";

	// ApplicationData: [idDomandaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDDOMANDASELEZIONATA_CODE = "appDataidDomandaSelezionata";

	// ApplicationData: [elencoDomande, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOMANDE_CODE = "appDataelencoDomande";

	// ApplicationData: [albo, scope:USER_SESSION]
	public static final String APPDATA_ALBO_CODE = "appDataalbo";

	// ApplicationData: [elencoAziendeAAEP, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAZIENDEAAEP_CODE = "appDataelencoAziendeAAEP";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [TreeStatus, scope:USER_SESSION]
	public static final String APPDATA_TREESTATUS_CODE = "appDataTreeStatus";

	// ApplicationData: [crumbs, scope:USER_SESSION]
	public static final String APPDATA_CRUMBS_CODE = "appDatacrumbs";

	// ApplicationData: [serviceUrl, scope:USER_SESSION]
	public static final String APPDATA_SERVICEURL_CODE = "appDataserviceUrl";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [elencoDownloadAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOWNLOADALLEGATI_CODE = "appDataelencoDownloadAllegati";

	// ApplicationData: [idPratica, scope:USER_SESSION]
	public static final String APPDATA_IDPRATICA_CODE = "appDataidPratica";

	// ApplicationData: [login, scope:USER_ACTION]
	public static final String APPDATA_LOGIN_CODE = "appDatalogin";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [msgError, scope:USER_ACTION]
	public static final String APPDATA_MSGERROR_CODE = "appDatamsgError";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [backDomanda, scope:USER_SESSION]
	public static final String APPDATA_BACKDOMANDA_CODE = "appDatabackDomanda";

	// ApplicationData: [primoIngresso, scope:USER_SESSION]
	public static final String APPDATA_PRIMOINGRESSO_CODE = "appDataprimoIngresso";

	// ApplicationData: [codiceFiscale, scope:USER_SESSION]
	public static final String APPDATA_CODICEFISCALE_CODE = "appDatacodiceFiscale";

	// ApplicationData: [partitaIva, scope:USER_SESSION]
	public static final String APPDATA_PARTITAIVA_CODE = "appDatapartitaIva";

	// ApplicationData: [descrizione, scope:USER_SESSION]
	public static final String APPDATA_DESCRIZIONE_CODE = "appDatadescrizione";

	// ApplicationData: [idAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_IDATTIVITAPRINCIPALEDATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [elencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITAPRIMARIADATIANAGRAFICIANAGRAFEANZIENDALE_CODE = "appDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale";

	// ApplicationData: [idAttivitaSecondariaDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_IDATTIVITASECONDARIADATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [elencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASECONDARIADATIANAGRAFICIANAGRAFEANZIENDALE_CODE = "appDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale";

	// ApplicationData: [idFormaGiuridicaDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_IDFORMAGIURIDICADATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [elencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOFORMEGIURIDICHEDATIANAGRAFICIANAGRAFEANZIENDALE_CODE = "appDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale";

	// ApplicationData: [note, scope:USER_SESSION]
	public static final String APPDATA_NOTE_CODE = "appDatanote";

	// ApplicationData: [idProvinciaCCIAADatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_IDPROVINCIACCIAADATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [elencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCECCIAADATIANAGRAFICIANAGRAFEANZIENDALE_CODE = "appDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale";

	// ApplicationData: [numeroCCIAA, scope:USER_SESSION]
	public static final String APPDATA_NUMEROCCIAA_CODE = "appDatanumeroCCIAA";

	// ApplicationData: [pec, scope:USER_SESSION]
	public static final String APPDATA_PEC_CODE = "appDatapec";

	// ApplicationData: [email, scope:USER_SESSION]
	public static final String APPDATA_EMAIL_CODE = "appDataemail";

	// ApplicationData: [telefono, scope:USER_SESSION]
	public static final String APPDATA_TELEFONO_CODE = "appDatatelefono";

	// ApplicationData: [cellulare, scope:USER_SESSION]
	public static final String APPDATA_CELLULARE_CODE = "appDatacellulare";

	// ApplicationData: [sitoInternet, scope:USER_SESSION]
	public static final String APPDATA_SITOINTERNET_CODE = "appDatasitoInternet";

	// ApplicationData: [sedeLegaleDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_SEDELEGALEDATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDatasedeLegaleDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [elencoSediDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEDIDATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataelencoSediDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [idSedeDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_IDSEDEDATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataidSedeDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [marcaDaBollo, scope:USER_SESSION]
	public static final String APPDATA_MARCADABOLLO_CODE = "appDatamarcaDaBollo";

	// ApplicationData: [anagraficaAziendale, scope:USER_SESSION]
	public static final String APPDATA_ANAGRAFICAAZIENDALE_CODE = "appDataanagraficaAziendale";

	// ApplicationData: [idComuneSedeLegaleDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESEDELEGALEDATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [elencoComuniDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIDATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataelencoComuniDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [sedeLegaleAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_SEDELEGALEANAGRAFEAZIENDALE_CODE = "appDatasedeLegaleAnagrafeAziendale";

	// ApplicationData: [privacy, scope:USER_SESSION]
	public static final String APPDATA_PRIVACY_CODE = "appDataprivacy";

	// ApplicationData: [idSoggettoGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSOGGETTOGESTORE_CODE = "appDataidSoggettoGestore";

	// ApplicationData: [elencoCorsiSostenutiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSISOSTENUTITITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoCorsiSostenutiTitolareRappresentanteLegale";

	// ApplicationData: [elencoCorsiSostenutiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSISOSTENUTIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale";

	// ApplicationData: [elencoQualificheTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOQUALIFICHETITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoQualificheTitolareRappresentanteLegale";

	// ApplicationData: [elencoQualificheAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOQUALIFICHEALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoQualificheAltroTitolareRappresentanteLegale";

	// ApplicationData: [idStatoNascitaDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDSTATONASCITADATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [elencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATONASCITADATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [idTitoloStudioDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDTITOLOSTUDIODATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [elencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTITOLOSTUDIODATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [titolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_TITOLARERAPPRESENTANTELEGALE_CODE = "appDatatitolareRappresentanteLegale";

	// ApplicationData: [altroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataaltroTitolareRappresentanteLegale";

	// ApplicationData: [idStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDSTATONASCITADATIANAGRAFICIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale";

	// ApplicationData: [idTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDTITOLOSTUDIODATIANAGRAFICIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale";

	// ApplicationData: [elencoComuniNascitaTitolareRappresentante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNINASCITATITOLARERAPPRESENTANTE_CODE = "appDataelencoComuniNascitaTitolareRappresentante";

	// ApplicationData: [comuneNascitaTitolareRappresentanteLegaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_COMUNENASCITATITOLARERAPPRESENTANTELEGALEDACERCARE_CODE = "appDatacomuneNascitaTitolareRappresentanteLegaleDaCercare";

	// ApplicationData: [elencoComuniResidenzaTitolareRappresentante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRESIDENZATITOLARERAPPRESENTANTE_CODE = "appDataelencoComuniResidenzaTitolareRappresentante";

	// ApplicationData: [comuneResidenzaTitolareRappresentanteLegaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_COMUNERESIDENZATITOLARERAPPRESENTANTELEGALEDACERCARE_CODE = "appDatacomuneResidenzaTitolareRappresentanteLegaleDaCercare";

	// ApplicationData: [elencoComuniNascitaAltroTitolareRappresentante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNINASCITAALTROTITOLARERAPPRESENTANTE_CODE = "appDataelencoComuniNascitaAltroTitolareRappresentante";

	// ApplicationData: [comuneNascitaAltroTitolareRappresentanteLegaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_COMUNENASCITAALTROTITOLARERAPPRESENTANTELEGALEDACERCARE_CODE = "appDatacomuneNascitaAltroTitolareRappresentanteLegaleDaCercare";

	// ApplicationData: [elencoComuniResidenzaAltroTitolareRappresentante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRESIDENZAALTROTITOLARERAPPRESENTANTE_CODE = "appDataelencoComuniResidenzaAltroTitolareRappresentante";

	// ApplicationData: [comuneResidenzaAltroTitolareRappresentanteLegaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_COMUNERESIDENZAALTROTITOLARERAPPRESENTANTELEGALEDACERCARE_CODE = "appDatacomuneResidenzaAltroTitolareRappresentanteLegaleDaCercare";

	// ApplicationData: [idComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNENASCITADATIANAGRAFICIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale";

	// ApplicationData: [idComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNERESIDENZADATIANAGRAFICIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale";

	// ApplicationData: [idComuneNascitaDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNENASCITADATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [idComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNERESIDENZADATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [elencoRiconiscimentiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCORICONISCIMENTITITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoRiconiscimentiTitolareRappresentanteLegale";

	// ApplicationData: [elencoRiconiscimentiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCORICONISCIMENTIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoRiconiscimentiAltroTitolareRappresentanteLegale";

	// ApplicationData: [elencoCategorieImpresa, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESA_CODE = "appDataelencoCategorieImpresa";

	// ApplicationData: [idCategorieImpresaSelezionati, scope:USER_SESSION]
	public static final String APPDATA_IDCATEGORIEIMPRESASELEZIONATI_CODE = "appDataidCategorieImpresaSelezionati";

	// ApplicationData: [fatturatoCategorieDiImpresa, scope:USER_SESSION]
	public static final String APPDATA_FATTURATOCATEGORIEDIIMPRESA_CODE = "appDatafatturatoCategorieDiImpresa";

	// ApplicationData: [gestioneFatturatoCategoriaDiImpresa, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEFATTURATOCATEGORIADIIMPRESA_CODE = "appDatagestioneFatturatoCategoriaDiImpresa";

	// ApplicationData: [idCategorieImpresaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCATEGORIEIMPRESASELEZIONATO_CODE = "appDataidCategorieImpresaSelezionato";

	// ApplicationData: [elencoAltriAlbi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTRIALBI_CODE = "appDataelencoAltriAlbi";

	// ApplicationData: [elencoCertificazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCERTIFICAZIONI_CODE = "appDataelencoCertificazioni";

	// ApplicationData: [elencoFormeOrganizzative, scope:USER_SESSION]
	public static final String APPDATA_ELENCOFORMEORGANIZZATIVE_CODE = "appDataelencoFormeOrganizzative";

	// ApplicationData: [idFormeOrganizzative, scope:USER_SESSION]
	public static final String APPDATA_IDFORMEORGANIZZATIVE_CODE = "appDataidFormeOrganizzative";

	// ApplicationData: [associazioniECertificazioni, scope:USER_SESSION]
	public static final String APPDATA_ASSOCIAZIONIECERTIFICAZIONI_CODE = "appDataassociazioniECertificazioni";

	// ApplicationData: [elencoLegnamiAssortimentiTrattati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOLEGNAMIASSORTIMENTITRATTATI_CODE = "appDataelencoLegnamiAssortimentiTrattati";

	// ApplicationData: [percentualeCommercioFr, scope:USER_SESSION]
	public static final String APPDATA_PERCENTUALECOMMERCIOFR_CODE = "appDatapercentualeCommercioFr";

	// ApplicationData: [elencoLavoriPA, scope:USER_SESSION]
	public static final String APPDATA_ELENCOLAVORIPA_CODE = "appDataelencoLavoriPA";

	// ApplicationData: [elencoAttivitaUltimoAnno, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITAULTIMOANNO_CODE = "appDataelencoAttivitaUltimoAnno";

	// ApplicationData: [idAttivitaUltimoAnno, scope:USER_SESSION]
	public static final String APPDATA_IDATTIVITAULTIMOANNO_CODE = "appDataidAttivitaUltimoAnno";

	// ApplicationData: [attivitaUltimoAnnoSelezionate, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNOSELEZIONATE_CODE = "appDataattivitaUltimoAnnoSelezionate";

	// ApplicationData: [elencoMaterialePropagazione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMATERIALEPROPAGAZIONE_CODE = "appDataelencoMaterialePropagazione";

	// ApplicationData: [idMaterialiPropagazione, scope:USER_SESSION]
	public static final String APPDATA_IDMATERIALIPROPAGAZIONE_CODE = "appDataidMaterialiPropagazione";

	// ApplicationData: [elencoArboricolturaDaLegno, scope:USER_SESSION]
	public static final String APPDATA_ELENCOARBORICOLTURADALEGNO_CODE = "appDataelencoArboricolturaDaLegno";

	// ApplicationData: [gestioneAttivitaUltimoAnno, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEATTIVITAULTIMOANNO_CODE = "appDatagestioneAttivitaUltimoAnno";

	// ApplicationData: [attivitaUltimoAnno1, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO1_CODE = "appDataattivitaUltimoAnno1";

	// ApplicationData: [attivitaUltimoAnno2, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO2_CODE = "appDataattivitaUltimoAnno2";

	// ApplicationData: [attivitaUltimoAnno3, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO3_CODE = "appDataattivitaUltimoAnno3";

	// ApplicationData: [attivitaUltimoAnno4, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO4_CODE = "appDataattivitaUltimoAnno4";

	// ApplicationData: [attivitaUltimoAnno5, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO5_CODE = "appDataattivitaUltimoAnno5";

	// ApplicationData: [attivitaUltimoAnno6, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO6_CODE = "appDataattivitaUltimoAnno6";

	// ApplicationData: [attivitaUltimoAnno7, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO7_CODE = "appDataattivitaUltimoAnno7";

	// ApplicationData: [attivitaUltimoAnno8, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO8_CODE = "appDataattivitaUltimoAnno8";

	// ApplicationData: [attivitaUltimoAnno9, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO9_CODE = "appDataattivitaUltimoAnno9";

	// ApplicationData: [idAttivitaUltimoAnnoFr, scope:USER_SESSION]
	public static final String APPDATA_IDATTIVITAULTIMOANNOFR_CODE = "appDataidAttivitaUltimoAnnoFr";

	// ApplicationData: [elencoAttivitaUltimoAnnoFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITAULTIMOANNOFR_CODE = "appDataelencoAttivitaUltimoAnnoFr";

	// ApplicationData: [elencoUnitaMisura, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAMISURA_CODE = "appDataelencoUnitaMisura";

	// ApplicationData: [idUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIDIUTILIZZAZIONEINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTaglioPioppetoInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIOPIOPPETOINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTagliIntercalariInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIINTERCALARIINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIDIUTILIZZAZIONEFUORIREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIOPIOPPETOFUORIREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTagliIntercalariFuoriRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIINTERCALARIFUORIREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato";

	// ApplicationData: [elencoIstanzeTaglioPresentate, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISTANZETAGLIOPRESENTATE_CODE = "appDataelencoIstanzeTaglioPresentate";

	// ApplicationData: [isVolumeAcquisitoFromPrimpaForSrv, scope:USER_SESSION]
	public static final String APPDATA_ISVOLUMEACQUISITOFROMPRIMPAFORSRV_CODE = "appDataisVolumeAcquisitoFromPrimpaForSrv";

	// ApplicationData: [volumiAcquisitiPrimpaForSrv, scope:USER_SESSION]
	public static final String APPDATA_VOLUMIACQUISITIPRIMPAFORSRV_CODE = "appDatavolumiAcquisitiPrimpaForSrv";

	// ApplicationData: [elencoCapannoni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCAPANNONI_CODE = "appDataelencoCapannoni";

	// ApplicationData: [elencoPiazzaliStoccaggio, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPIAZZALISTOCCAGGIO_CODE = "appDataelencoPiazzaliStoccaggio";

	// ApplicationData: [elencoCaschiForestaliAttrezzature, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCASCHIFORESTALIATTREZZATURE_CODE = "appDataelencoCaschiForestaliAttrezzature";

	// ApplicationData: [elencoScarponiRinforzatiAttrezzature, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSCARPONIRINFORZATIATTREZZATURE_CODE = "appDataelencoScarponiRinforzatiAttrezzature";

	// ApplicationData: [elencoPantaloniAntitaglioAttrezzature, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPANTALONIANTITAGLIOATTREZZATURE_CODE = "appDataelencoPantaloniAntitaglioAttrezzature";

	// ApplicationData: [elencoMacchineTrattrici, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINETRATTRICI_CODE = "appDataelencoMacchineTrattrici";

	// ApplicationData: [elencoMacchineSpeciali, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINESPECIALI_CODE = "appDataelencoMacchineSpeciali";

	// ApplicationData: [elencoMacchineMovimentoTerra, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEMOVIMENTOTERRA_CODE = "appDataelencoMacchineMovimentoTerra";

	// ApplicationData: [elencoMacchineRimorchi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINERIMORCHI_CODE = "appDataelencoMacchineRimorchi";

	// ApplicationData: [elencoMacchineVerricelli, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEVERRICELLI_CODE = "appDataelencoMacchineVerricelli";

	// ApplicationData: [elencoMacchinePle, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEPLE_CODE = "appDataelencoMacchinePle";

	// ApplicationData: [elencoMacchineTrinciaForestali, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINETRINCIAFORESTALI_CODE = "appDataelencoMacchineTrinciaForestali";

	// ApplicationData: [elencoMacchineSegheriaMobile, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINESEGHERIAMOBILE_CODE = "appDataelencoMacchineSegheriaMobile";

	// ApplicationData: [elencoMacchineGruACavo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEGRUACAVO_CODE = "appDataelencoMacchineGruACavo";

	// ApplicationData: [elencoMacchineCippatrici, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINECIPPATRICI_CODE = "appDataelencoMacchineCippatrici";

	// ApplicationData: [elencoMezziDiTrasporto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMEZZIDITRASPORTO_CODE = "appDataelencoMezziDiTrasporto";

	// ApplicationData: [gestioneMacchineMezzi, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEMACCHINEMEZZI_CODE = "appDatagestioneMacchineMezzi";

	// ApplicationData: [elencoMacchineSpecialiFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINESPECIALIFR_CODE = "appDataelencoMacchineSpecialiFr";

	// ApplicationData: [elencoMacchineMovimentoTerraFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEMOVIMENTOTERRAFR_CODE = "appDataelencoMacchineMovimentoTerraFr";

	// ApplicationData: [elencoMacchineRimorchiFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINERIMORCHIFR_CODE = "appDataelencoMacchineRimorchiFr";

	// ApplicationData: [elencoMacchineGrumier, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEGRUMIER_CODE = "appDataelencoMacchineGrumier";

	// ApplicationData: [elencoMacchineSemi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINESEMI_CODE = "appDataelencoMacchineSemi";

	// ApplicationData: [elencoAltriMezzi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTRIMEZZI_CODE = "appDataelencoAltriMezzi";

	// ApplicationData: [elencoPersonaleSuggerito, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPERSONALESUGGERITO_CODE = "appDataelencoPersonaleSuggerito";

	// ApplicationData: [personaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_PERSONALEDACERCARE_CODE = "appDatapersonaleDaCercare";

	// ApplicationData: [elencoPersonale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPERSONALE_CODE = "appDataelencoPersonale";

	// ApplicationData: [elencoAltroPersonaleTipoContrattoFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTROPERSONALETIPOCONTRATTOFR_CODE = "appDataelencoAltroPersonaleTipoContrattoFr";

	// ApplicationData: [elencoAltroPersonaleTipoMansioneFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTROPERSONALETIPOMANSIONEFR_CODE = "appDataelencoAltroPersonaleTipoMansioneFr";

	// ApplicationData: [gestioneAltroPersonaleFr, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEALTROPERSONALEFR_CODE = "appDatagestioneAltroPersonaleFr";

	// ApplicationData: [elencoAlbiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBIRICERCAAZIENDA_CODE = "appDataelencoAlbiRicercaAzienda";

	// ApplicationData: [elencoAlbiSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAlbiSelezionatiRicercaAzienda";

	// ApplicationData: [elencoStatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIRICERCAAZIENDA_CODE = "appDataelencoStatiRicercaAzienda";

	// ApplicationData: [elencoSottostatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSOTTOSTATIRICERCAAZIENDA_CODE = "appDataelencoSottostatiRicercaAzienda";

	// ApplicationData: [elencoSezioniRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONIRICERCAAZIENDA_CODE = "appDataelencoSezioniRicercaAzienda";

	// ApplicationData: [elencoCategorieImpresaRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESARICERCAAZIENDA_CODE = "appDataelencoCategorieImpresaRicercaAzienda";

	// ApplicationData: [elencoAssociazioniCertificazioneRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONERICERCAAZIENDA_CODE = "appDataelencoAssociazioniCertificazioneRicercaAzienda";

	// ApplicationData: [elencoAttivitaSvolteRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTERICERCAAZIENDA_CODE = "appDataelencoAttivitaSvolteRicercaAzienda";

	// ApplicationData: [elencoRisultatiRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAAZIENDAGESTORE_CODE = "appDataelencoRisultatiRicercaAziendaGestore";

	// ApplicationData: [elencoComuniRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRICERCAAZIENDAGESTORE_CODE = "appDataelencoComuniRicercaAziendaGestore";

	// ApplicationData: [idComuneSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidComuneSelezionatoRicercaAziendaGestore";

	// ApplicationData: [idStatoPraticaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOPRATICASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidStatoPraticaSelezionatoRicercaAziendaGestore";

	// ApplicationData: [idSottoStatoPraticaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSOTTOSTATOPRATICASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore";

	// ApplicationData: [numeroRisultatiRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_NUMERORISULTATIRICERCAAZIENDAGESTORE_CODE = "appDatanumeroRisultatiRicercaAziendaGestore";

	// ApplicationData: [numeroAlboAzienda, scope:USER_SESSION]
	public static final String APPDATA_NUMEROALBOAZIENDA_CODE = "appDatanumeroAlboAzienda";

	// ApplicationData: [denominazioneAzienda, scope:USER_SESSION]
	public static final String APPDATA_DENOMINAZIONEAZIENDA_CODE = "appDatadenominazioneAzienda";

	// ApplicationData: [titolareLegaleRappresentanteAzienda, scope:USER_SESSION]
	public static final String APPDATA_TITOLARELEGALERAPPRESENTANTEAZIENDA_CODE = "appDatatitolareLegaleRappresentanteAzienda";

	// ApplicationData: [codFisPivaAzienda, scope:USER_SESSION]
	public static final String APPDATA_CODFISPIVAAZIENDA_CODE = "appDatacodFisPivaAzienda";

	// ApplicationData: [dataIscrizioneAlboAziendaDa, scope:USER_SESSION]
	public static final String APPDATA_DATAISCRIZIONEALBOAZIENDADA_CODE = "appDatadataIscrizioneAlboAziendaDa";

	// ApplicationData: [dataIscrizioneAlboAziendaA, scope:USER_SESSION]
	public static final String APPDATA_DATAISCRIZIONEALBOAZIENDAA_CODE = "appDatadataIscrizioneAlboAziendaA";

	// ApplicationData: [elencoSezioniSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoSezioniSelezionatiRicercaAzienda";

	// ApplicationData: [elencoCategorieImpresaSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESASELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoCategorieImpresaSelezionatiRicercaAzienda";

	// ApplicationData: [elencoAssociazioniCertificazioniSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda";

	// ApplicationData: [elencoAttivitaSvolteSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTESELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAttivitaSvolteSelezionatiRicercaAzienda";

	// ApplicationData: [elencoProvinciaRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCIARICERCAAZIENDAGESTORE_CODE = "appDataelencoProvinciaRicercaAziendaGestore";

	// ApplicationData: [idProvinciaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDPROVINCIASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidProvinciaSelezionatoRicercaAziendaGestore";

	// ApplicationData: [domandaRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_DOMANDARIEPILOGO_CODE = "appDatadomandaRiepilogo";

	// ApplicationData: [statoDomanda, scope:USER_SESSION]
	public static final String APPDATA_STATODOMANDA_CODE = "appDatastatoDomanda";

	// ApplicationData: [idStatoDomandaRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_IDSTATODOMANDARIEPILOGO_CODE = "appDataidStatoDomandaRiepilogo";

	// ApplicationData: [elencoStatiDomandaRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIDOMANDARIEPILOGO_CODE = "appDataelencoStatiDomandaRiepilogo";

	// ApplicationData: [elencoGestioneStatiRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOGESTIONESTATIRIEPILOGO_CODE = "appDataelencoGestioneStatiRiepilogo";

	// ApplicationData: [elencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATI_CODE = "appDataelencoAllegati";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [idAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOSELEZIONATO_CODE = "appDataidAllegatoSelezionato";

	// ApplicationData: [elencoTipologieAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOLOGIEALLEGATI_CODE = "appDataelencoTipologieAllegati";

	// ApplicationData: [elencoSottotipologieAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSOTTOTIPOLOGIEALLEGATI_CODE = "appDataelencoSottotipologieAllegati";

	// ApplicationData: [idTipologiaAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOLOGIAALLEGATOSELEZIONATO_CODE = "appDataidTipologiaAllegatoSelezionato";

	// ApplicationData: [idSottotipologiaAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDSOTTOTIPOLOGIAALLEGATOSELEZIONATO_CODE = "appDataidSottotipologiaAllegatoSelezionato";

	// ApplicationData: [tipoProcedura, scope:USER_SESSION]
	public static final String APPDATA_TIPOPROCEDURA_CODE = "appDatatipoProcedura";

	// ApplicationData: [elencoDenominazioneTipoAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCODENOMINAZIONETIPOALLEGATI_CODE = "appDataelencoDenominazioneTipoAllegati";

	// ApplicationData: [elencoAllegatiDownload, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATIDOWNLOAD_CODE = "appDataelencoAllegatiDownload";

	// ApplicationData: [idTipologiaAllegatoDownloadSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOLOGIAALLEGATODOWNLOADSELEZIONATO_CODE = "appDataidTipologiaAllegatoDownloadSelezionato";

	// ApplicationData: [elencoTipologieAllegatiDownload, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOLOGIEALLEGATIDOWNLOAD_CODE = "appDataelencoTipologieAllegatiDownload";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	/// - i metodi relativi a menu e azioni di inizializzazione sono direttamente 
	///   implementati in questa classe
	/// - i metodi relativi ai singoli content panel sono delegati nei rispettivi
	///   bean
	//////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onTableAAEPClicked utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults onTableAAEPClicked(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().onTableAAEPClicked(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onTableClicked utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults onTableClicked(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().onTableClicked(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onTableFrClicked utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults onTableFrClicked(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().onTableFrClicked(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo testActa utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults testActa(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().testActa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaDomanda utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults eliminaDomanda(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().eliminaDomanda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeEnter utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults executeEnter(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().executeEnter(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeRefresh utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults executeRefresh(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().executeRefresh(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeLogin utilizzato in un ExecCommand
	 * del ContentPanel cpLogin
	 */
	public ExecResults executeLogin(

			it.csi.taif.taifweb.dto.home.CpLoginModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpLogin
		return getCPBECpLogin().executeLogin(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpLogin
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.home.CpLoginModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpLogin
		return getCPBECpLogin().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeSwitchWizardDomanda utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().executeSwitchWizardDomanda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeSwitchWizardDomanda1 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda1(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().executeSwitchWizardDomanda1(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAziendaInAaep utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults ricercaAziendaInAaep(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().ricercaAziendaInAaep(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo expandAltreSediDatiAnagrafici2 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults expandAltreSediDatiAnagrafici2(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().expandAltreSediDatiAnagrafici2(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoSedi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoSedi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoSedi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addSedeOperativa utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addSedeOperativa(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addSedeOperativa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo deleteSedeOperativa utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults deleteSedeOperativa(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().deleteSedeOperativa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaPersonaInAnagraficaFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults ricercaPersonaInAnagraficaFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().ricercaPersonaInAnagraficaFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaPersonaInAnagrafica utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults ricercaPersonaInAnagrafica(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().ricercaPersonaInAnagrafica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeStatoNascita utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onChangeStatoNascita(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onChangeStatoNascita(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo expandAltriConducentiAzienda utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults expandAltriConducentiAzienda(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().expandAltriConducentiAzienda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAltraPersonaInAnagrafica utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults ricercaAltraPersonaInAnagrafica(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().ricercaAltraPersonaInAnagrafica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeStatoNascitaConduttoreAzienda utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onChangeStatoNascitaConduttoreAzienda(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onChangeStatoNascitaConduttoreAzienda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeSwitchWizardDomanda2 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda2(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().executeSwitchWizardDomanda2(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo expandAltriAlbiDatiSocioEconomici utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults expandAltriAlbiDatiSocioEconomici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().expandAltriAlbiDatiSocioEconomici(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAltriAlbi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAltriAlbi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAltriAlbi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addAltroAlbo utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addAltroAlbo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addAltroAlbo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo expandCertificazioniDatiSocioEconomici utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults expandCertificazioniDatiSocioEconomici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().expandCertificazioniDatiSocioEconomici(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoCertificazioniQualitaProcesso utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoCertificazioniQualitaProcesso(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoCertificazioniQualitaProcesso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addCertificazioneQualitaProcesso utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addCertificazioneQualitaProcesso(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addCertificazioneQualitaProcesso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeSwitchWizardDomanda3 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda3(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().executeSwitchWizardDomanda3(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttivitaUltimoAnno utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttivitaUltimoAnno(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttivitaUltimoAnno(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttivitaUltimoAnno1 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno1(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttivitaUltimoAnno1(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo JumpToIstanzeTaglioPresentate utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults JumpToIstanzeTaglioPresentate(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().JumpToIstanzeTaglioPresentate(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttivitaUltimoAnno2 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno2(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttivitaUltimoAnno2(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttivitaUltimoAnno3 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno3(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttivitaUltimoAnno3(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttivitaUltimoAnno4 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno4(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttivitaUltimoAnno4(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttivitaUltimoAnno5 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno5(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttivitaUltimoAnno5(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoArboricolturaDaLegno utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoArboricolturaDaLegno(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoArboricolturaDaLegno(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addArboricolturaDaLegno utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addArboricolturaDaLegno(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addArboricolturaDaLegno(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo expandLavoriPA utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults expandLavoriPA(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().expandLavoriPA(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoLavoriPA utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoLavoriPA(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoLavoriPA(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addLavoroPA utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addLavoroPA(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addLavoroPA(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo expandLegnami utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults expandLegnami(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().expandLegnami(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoLegname utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoLegname(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoLegname(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addLegname utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addLegname(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addLegname(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoLegnameFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoLegnameFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoLegnameFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addLegnameFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addLegnameFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addLegnameFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openStruttureCapannoni utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openStruttureCapannoni(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openStruttureCapannoni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoCapannoni utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoCapannoni(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoCapannoni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addCapannone utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addCapannone(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addCapannone(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openStrutturePiazzaliStoccaggio utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openStrutturePiazzaliStoccaggio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openStrutturePiazzaliStoccaggio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoPiazzaliStoccaggio utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoPiazzaliStoccaggio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoPiazzaliStoccaggio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addPiazzaleStoccaggio utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addPiazzaleStoccaggio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addPiazzaleStoccaggio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeSwitchWizardDomanda5 utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda5(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().executeSwitchWizardDomanda5(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureCascoForestale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureCascoForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureCascoForestale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureCascoForestale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureCascoForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureCascoForestale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addCascoForestale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addCascoForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addCascoForestale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureScarponiRinforzati utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureScarponiRinforzati(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureScarponiRinforzati(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureScarponiRinforzati utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureScarponiRinforzati(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureScarponiRinforzati(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addScarponeRinforzato utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addScarponeRinforzato(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addScarponeRinforzato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzaturePantaloniAntitaglio utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzaturePantaloniAntitaglio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzaturePantaloniAntitaglio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzaturePantaloniAntitaglio utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzaturePantaloniAntitaglio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzaturePantaloniAntitaglio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addPantaloneAntitaglio utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addPantaloneAntitaglio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addPantaloneAntitaglio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchinaTrattrici utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaTrattrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchinaTrattrici(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineTrattrici utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineTrattrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineTrattrici(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaTrattrice utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaTrattrice(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaTrattrice(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchineSpeciali utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineSpeciali(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchineSpeciali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineSpeciali utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineSpeciali(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineSpeciali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaSpeciale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaSpeciale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaSpeciale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchineMovimentoATerra utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineMovimentoATerra(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchineMovimentoATerra(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineMovimentoATerra utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineMovimentoATerra(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineMovimentoATerra(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaMovimentoATerra utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaMovimentoATerra(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaMovimentoATerra(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchinaRimorchi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaRimorchi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchinaRimorchi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineRimorchi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineRimorchi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineRimorchi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaRimorchi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaRimorchi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaRimorchi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchinaVerricelli utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaVerricelli(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchinaVerricelli(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineVerricelli utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineVerricelli(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineVerricelli(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaVerricelli utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaVerricelli(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaVerricelli(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchinaPle utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaPle(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchinaPle(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchinePle utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchinePle(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchinePle(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaPle utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaPle(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaPle(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchinaTrinciaForestale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaTrinciaForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchinaTrinciaForestale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineTrinciaForestale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineTrinciaForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineTrinciaForestale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaTrinciaForestale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaTrinciaForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaTrinciaForestale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchineSegherieMobili utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineSegherieMobili(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchineSegherieMobili(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineSegherieMobili utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineSegherieMobili(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineSegherieMobili(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaSegherieMobili utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaSegherieMobili(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaSegherieMobili(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchineGruACavo utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineGruACavo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchineGruACavo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineGruACavo utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineGruACavo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineGruACavo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaGruACavo utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaGruACavo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaGruACavo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchineCippatrici utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineCippatrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchineCippatrici(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineCippatrici utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineCippatrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineCippatrici(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaCippatrici utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaCippatrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaCippatrici(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMezziDiTrasporto utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMezziDiTrasporto(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMezziDiTrasporto(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMezziDiTrasporto utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMezziDiTrasporto(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMezziDiTrasporto(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMezziDiTrasporto utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMezziDiTrasporto(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMezziDiTrasporto(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureAltriMezzi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureAltriMezzi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureAltriMezzi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureAltriMezzi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureAltriMezzi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureAltriMezzi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addAltriMezzi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addAltriMezzi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addAltriMezzi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchineSpecialiFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineSpecialiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchineSpecialiFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineSpecialiFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineSpecialiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineSpecialiFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaSpecialeFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaSpecialeFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaSpecialeFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchineMovimentoATerraFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineMovimentoATerraFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchineMovimentoATerraFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineMovimentoATerraFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineMovimentoATerraFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineMovimentoATerraFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaMovimentoATerraFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaMovimentoATerraFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaMovimentoATerraFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchinaGrumier utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaGrumier(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchinaGrumier(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineGrumier utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineGrumier(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineGrumier(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaGrumier utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaGrumier(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaGrumier(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchinaRimorchiFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaRimorchiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchinaRimorchiFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineRimorchiFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineRimorchiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineRimorchiFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaRimorchiFr utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaRimorchiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaRimorchiFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openAttrezzatureMacchinaSemi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaSemi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().openAttrezzatureMacchinaSemi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAttrezzatureMacchineSemi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineSemi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoAttrezzatureMacchineSemi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addMacchinaSemi utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaSemi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addMacchinaSemi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo expandPersonale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults expandPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().expandPersonale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo suggestPersonale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults suggestPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().suggestPersonale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addCodiceFiscaleAltroPersonale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addCodiceFiscaleAltroPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addCodiceFiscaleAltroPersonale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoPersonale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().onClickTabellaElencoPersonale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addPersonale utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults addPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().addPersonale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goBack utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults goBack(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().goBack(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaInBozza utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults salvaInBozza(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().salvaInBozza(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaProsegui utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults salvaProsegui(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().salvaProsegui(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goToRiepilogo utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults goToRiepilogo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().goToRiepilogo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo testIndex utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults testIndex(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().testIndex(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeEnter utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults executeEnter(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().executeEnter(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo callExecuteLocalInit utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults callExecuteLocalInit(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().callExecuteLocalInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo callExecuteLocalInitInsert utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults callExecuteLocalInitInsert(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().callExecuteLocalInitInsert(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeRefresh utilizzato in un ExecCommand
	 * del ContentPanel CpDomanda
	 */
	public ExecResults executeRefresh(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDomanda
		return getCPBECpDomanda().executeRefresh(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo acquisizioneVolumiTaglio utilizzato in un ExecCommand
	 * del ContentPanel cpIstanzeTaglioPresentate
	 */
	public ExecResults acquisizioneVolumiTaglio(

			it.csi.taif.taifweb.dto.domanda.CpIstanzeTaglioPresentateModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpIstanzeTaglioPresentate
		return getCPBECpIstanzeTaglioPresentate().acquisizioneVolumiTaglio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo tornaIndietro utilizzato in un ExecCommand
	 * del ContentPanel cpIstanzeTaglioPresentate
	 */
	public ExecResults tornaIndietro(

			it.csi.taif.taifweb.dto.domanda.CpIstanzeTaglioPresentateModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpIstanzeTaglioPresentate
		return getCPBECpIstanzeTaglioPresentate().tornaIndietro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaIstanzeTaglioPresentate utilizzato in un ExecCommand
	 * del ContentPanel cpIstanzeTaglioPresentate
	 */
	public ExecResults caricaIstanzeTaglioPresentate(

			it.csi.taif.taifweb.dto.domanda.CpIstanzeTaglioPresentateModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpIstanzeTaglioPresentate
		return getCPBECpIstanzeTaglioPresentate().caricaIstanzeTaglioPresentate(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadComuni utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAziendaGestore
	 */
	public ExecResults loadComuni(

			it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAziendaGestore
		return getCPBECpRicercaAziendaGestore().loadComuni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadSottoStatoPratica utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAziendaGestore
	 */
	public ExecResults loadSottoStatoPratica(

			it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAziendaGestore
		return getCPBECpRicercaAziendaGestore().loadSottoStatoPratica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAziende utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAziendaGestore
	 */
	public ExecResults ricercaAziende(

			it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAziendaGestore
		return getCPBECpRicercaAziendaGestore().ricercaAziende(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAziendaGestore
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAziendaGestore
		return getCPBECpRicercaAziendaGestore().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAziendeGestore utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults onClickTabellaElencoAziendeGestore(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAziendeGestore
		return getCPBECpElencoAziendeGestore().onClickTabellaElencoAziendeGestore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo exportRicercaAzienda utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults exportRicercaAzienda(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAziendeGestore
		return getCPBECpElencoAziendeGestore().exportRicercaAzienda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo nuovaRicerca utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults nuovaRicerca(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAziendeGestore
		return getCPBECpElencoAziendeGestore().nuovaRicerca(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroRicerca utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults indietroRicerca(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAziendeGestore
		return getCPBECpElencoAziendeGestore().indietroRicerca(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaAziendaGestore utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults eliminaAziendaGestore(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAziendeGestore
		return getCPBECpElencoAziendeGestore().eliminaAziendaGestore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadAllegatiDownload utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults loadAllegatiDownload(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().loadAllegatiDownload(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadSottoTipoAllegato utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults loadSottoTipoAllegato(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().loadSottoTipoAllegato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadAllegato utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults loadAllegato(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().loadAllegato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onTableClick utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults onTableClick(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().onTableClick(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goBackDocumentazione utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults goBackDocumentazione(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().goBackDocumentazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inviaDomanda utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults inviaDomanda(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().inviaDomanda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo confermaInvioDocumentazione utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults confermaInvioDocumentazione(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().confermaInvioDocumentazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaDocumento utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults eliminaDocumento(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().eliminaDocumento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeEnter utilizzato in un ExecCommand
	 * del ContentPanel CpDocumentazione
	 */
	public ExecResults executeEnter(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpDocumentazione
		return getCPBECpDocumentazione().executeEnter(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo openModificaStato utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults openModificaStato(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().openModificaStato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaStati utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults onClickTabellaStati(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().onClickTabellaStati(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo chiudiTabellaStati utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults chiudiTabellaStati(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().chiudiTabellaStati(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addStato utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults addStato(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().addStato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo modificaStatoTest utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults modificaStatoTest(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().modificaStatoTest(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goBack utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults goBack(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().goBack(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo chiudiRiepilogo utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults chiudiRiepilogo(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().chiudiRiepilogo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goToDocumenti utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults goToDocumenti(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().goToDocumenti(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeEnter utilizzato in un ExecCommand
	 * del ContentPanel CpRiepilogo
	 */
	public ExecResults executeEnter(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel CpRiepilogo
		return getCPBECpRiepilogo().executeEnter(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo showError utilizzato in un ExecCommand
	 * del ContentPanel cpError
	 */
	public ExecResults showError(

			it.csi.taif.taifweb.dto.common.CpErrorModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpError
		return getCPBECpError().showError(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadComuni utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAccessoLibero
	 */
	public ExecResults loadComuni(

			it.csi.taif.taifweb.dto.libero.CpRicercaAccessoLiberoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAccessoLibero
		return getCPBECpRicercaAccessoLibero().loadComuni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAziende utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAccessoLibero
	 */
	public ExecResults ricercaAziende(

			it.csi.taif.taifweb.dto.libero.CpRicercaAccessoLiberoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAccessoLibero
		return getCPBECpRicercaAccessoLibero().ricercaAziende(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAccessoLibero
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.libero.CpRicercaAccessoLiberoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAccessoLibero
		return getCPBECpRicercaAccessoLibero().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onTableClicked utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAccessoLibero
	 */
	public ExecResults onTableClicked(

			it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAccessoLibero
		return getCPBECpElencoAccessoLibero().onTableClicked(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo exportRicercaAzienda utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAccessoLibero
	 */
	public ExecResults exportRicercaAzienda(

			it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAccessoLibero
		return getCPBECpElencoAccessoLibero().exportRicercaAzienda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo nuovaRicerca utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAccessoLibero
	 */
	public ExecResults nuovaRicerca(

			it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAccessoLibero
		return getCPBECpElencoAccessoLibero().nuovaRicerca(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaAziendaAccessoLibero utilizzato in un ExecCommand
	 * del ContentPanel cpElencoAccessoLibero
	 */
	public ExecResults eliminaAziendaAccessoLibero(

			it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoAccessoLibero
		return getCPBECpElencoAccessoLibero().eliminaAziendaAccessoLibero(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroDettaglioAzienda utilizzato in un ExecCommand
	 * del ContentPanel cpAziendaDettaglio
	 */
	public ExecResults indietroDettaglioAzienda(

			it.csi.taif.taifweb.dto.libero.CpAziendaDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAziendaDettaglio
		return getCPBECpAziendaDettaglio().indietroDettaglioAzienda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpAziendaDettaglio
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.libero.CpAziendaDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAziendaDettaglio
		return getCPBECpAziendaDettaglio().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goToNuovaDomanda definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults goToNuovaDomanda(

			it.csi.taif.taifweb.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOTONUOVADOMANDA_OUTCOME_CODE__AZIENDA = //NOSONAR  Reason:EIAS
				"Azienda"; //NOSONAR  Reason:EIAS
		final String GOTONUOVADOMANDA_OUTCOME_CODE__GESTORE = //NOSONAR  Reason:EIAS
				"Gestore"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R844521088) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(this.executeGoHome(theModel));

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::goToNuovaDomanda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goToHome definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults goToHome(

			it.csi.taif.taifweb.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOTOHOME_OUTCOME_CODE__AZIENDA = //NOSONAR  Reason:EIAS
				"Azienda"; //NOSONAR  Reason:EIAS
		final String GOTOHOME_OUTCOME_CODE__GESTORE = //NOSONAR  Reason:EIAS
				"Gestore"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2115341402) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug(
					"-------------- TIPO ACCESSO IN MENU HOME ---- *" + theModel.getSession().get("tipoAccesso") + "*");

			// impostazione del result code 
			result.setResultCode(this.executeGoHome(theModel));

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::goToHome] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo identificaProfilo definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults identificaProfilo(

			it.csi.taif.taifweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IDENTIFICAPROFILO_OUTCOME_CODE__LIBEROIT = //NOSONAR  Reason:EIAS
				"liberoIT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__LIBERONO_IT = //NOSONAR  Reason:EIAS
				"liberoNO_IT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__AZIENDAIT = //NOSONAR  Reason:EIAS
				"aziendaIT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__AZIENDANO_IT = //NOSONAR  Reason:EIAS
				"aziendaNO_IT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__PROFESSIONISTAIT = //NOSONAR  Reason:EIAS
				"professionistaIT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__PROFESSIONISTANO_IT = //NOSONAR  Reason:EIAS
				"professionistaNO_IT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__GESTOREIT = //NOSONAR  Reason:EIAS
				"gestoreIT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__GESTORENO_IT = //NOSONAR  Reason:EIAS
				"gestoreNO_IT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__GESTOREKO = //NOSONAR  Reason:EIAS
				"gestoreKO"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__AZIENZAKO = //NOSONAR  Reason:EIAS
				"azienzaKO"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__PROFESSIONISTAKO = //NOSONAR  Reason:EIAS
				"professionistaKO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1532503971) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			Locale l = ActionContext.getContext().getLocale();
			//			Locale.setDefault(Locale.FRANCE);
			//			
			log.info("TIPO ACCESSO: *" + theModel.getTipoAccesso());
			//this.getTaifMgr().testActa();
			log.info("CURRENT USER: *" + theModel.getAppDatacurrentUser());
			log.info("LOGIN: " + theModel.getLogin());
			//			StringBuilder token = new StringBuilder();
			//			token.append("RCRLBR77HL219V");
			//			token.append("/");
			//			token.append("RICERCA");
			//			token.append("/");
			//			token.append("LIBERA");
			//			token.append("/INFOCERT/");
			//			token.append(DateUtil.getTokenDataCorrente());
			//			token.append("/16/JqUoGcC+E9q0jQKl1zeRew==");
			//			//Identita identita = new Identita(token.toString());
			//			if (ActionContext.getContext().getSession().containsValue(token.toString())) {
			//				log.info("SESSION CONTIENE IDENTITA");
			//				ActionContext.getContext().getSession().remove(IRIDE_ID_SESSIONATTR);
			//			}
			if (theModel.getAppDatacurrentUser() == null) {
				log.info("AppDatacurrentUser NULL");
				theModel.setAppDatacurrentUser(new UserInfo());
			}
			theModel.getAppDatacurrentUser().setTipoAccesso(theModel.getTipoAccesso());
			ProfiloEnum profiloEnum = ProfiloEnum.getByProfilo(theModel.getTipoAccesso());
			ActionContext.getContext().getSession().put("tipoAccesso", theModel.getTipoAccesso());
			String code = IDENTIFICAPROFILO_OUTCOME_CODE__AZIENDAIT;
			ProfiloUtenteTaif profiloUtenteTaif = new ProfiloUtenteTaif();
			Locale locale = null;
			switch (profiloEnum) {
				case AZIENDA_IT :
					System.out.println("------------- AZIENDA IT");
					log.info("Entro AZIENDA_IT");
					code = this.identificaAzienda(theModel, IDENTIFICAPROFILO_OUTCOME_CODE__AZIENDAIT);
					profiloUtenteTaif.setIdProfilo(it.csi.taif.taifweb.business.dao.util.Constants.one);
					theModel.getAppDatacurrentUser().setProfiloUtenteTaif(profiloUtenteTaif);
					locale = Locale.ITALY;
					break;
				case AZIENDA_FR :
					System.out.println("------------- AZIENDA FR");
					log.info("Entro AZIENDA_FR");
					code = IDENTIFICAPROFILO_OUTCOME_CODE__AZIENDANO_IT;
					profiloUtenteTaif.setIdProfilo(it.csi.taif.taifweb.business.dao.util.Constants.one);
					theModel.getAppDatacurrentUser().setProfiloUtenteTaif(profiloUtenteTaif);
					locale = Locale.FRANCE;
					break;
				case GESTORE_FR :
					System.out.println("------------- GESTORE FR");
					log.info("Entro GESTORE_FR");
					code = IDENTIFICAPROFILO_OUTCOME_CODE__GESTORENO_IT;
					locale = Locale.FRANCE;
					break;
				case GESTORE_IT :
					System.out.println("------------- GESTORE IT");
					log.info("Entro GESTORE_IT");
					code = this.identificaGestore(theModel, IDENTIFICAPROFILO_OUTCOME_CODE__GESTOREIT);
					locale = Locale.ITALY;
					break;
				case PROFESSIONISTA_IT :
					System.out.println("------------- PROFESSIONISTA IT");
					log.info("EntroPROFESSIONISTA_IT");
					code = this.identificaProfessionista(theModel, IDENTIFICAPROFILO_OUTCOME_CODE__PROFESSIONISTAIT);
					profiloUtenteTaif.setIdProfilo(it.csi.taif.taifweb.business.dao.util.Constants.two);
					theModel.getAppDatacurrentUser().setProfiloUtenteTaif(profiloUtenteTaif);
					locale = Locale.ITALY;
					break;
				case PROFESSIONISTA_FR :
					log.debug("Entro PROFESSIONISTA_FR");
					code = IDENTIFICAPROFILO_OUTCOME_CODE__PROFESSIONISTANO_IT;
					profiloUtenteTaif.setIdProfilo(it.csi.taif.taifweb.business.dao.util.Constants.two);
					theModel.getAppDatacurrentUser().setProfiloUtenteTaif(profiloUtenteTaif);
					locale = Locale.FRANCE;
					break;
				case LIBERO_IT :
					log.info("Entro LIBERO_IT");
					code = IDENTIFICAPROFILO_OUTCOME_CODE__LIBEROIT;
					locale = Locale.ITALY;
					String liberoIt = "WasLibero";
					ActionContext.getContext().getSession().put("WasLibero", liberoIt);
					break;
				case LIBERO_FR :
					log.info("Entro LIBERO_FR");
					code = IDENTIFICAPROFILO_OUTCOME_CODE__LIBERONO_IT;
					String liberoFr = "WasLibero";
					ActionContext.getContext().getSession().put("WasLibero", liberoFr);

					locale = Locale.FRANCE;
					break;
			}
			//theModel.getSession().put(Config.FMT_LOCALE, locale);
			log.info("CODE = *" + code + "*");
			log.info("LOCALE = *" + Locale.getDefault() + "*");
			ActionContext.getContext().getSession().put("code", code);

			result.setResultCode(code);
			result.setModel(theModel);
			log.info("___________ ESCO da IDENTIFICA PROFILO prima del FINALLY");
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::identificaProfilo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property relative ai bean spring associati agli specifici content panel
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	private it.csi.taif.taifweb.business.home.CPBECpHome cPBECpHome = null;

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public void setCPBECpHome(it.csi.taif.taifweb.business.home.CPBECpHome bean) {
		this.cPBECpHome = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public it.csi.taif.taifweb.business.home.CPBECpHome getCPBECpHome() {
		return this.cPBECpHome;
	}

	/**
	 * riferimento al CPBE del content panel cpLogin
	 */
	private it.csi.taif.taifweb.business.home.CPBECpLogin cPBECpLogin = null;

	/**
	 * riferimento al CPBE del content panel cpLogin
	 */
	public void setCPBECpLogin(it.csi.taif.taifweb.business.home.CPBECpLogin bean) {
		this.cPBECpLogin = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpLogin
	 */
	public it.csi.taif.taifweb.business.home.CPBECpLogin getCPBECpLogin() {
		return this.cPBECpLogin;
	}

	/**
	 * riferimento al CPBE del content panel CpDomanda
	 */
	private it.csi.taif.taifweb.business.domanda.CPBECpDomanda cPBECpDomanda = null;

	/**
	 * riferimento al CPBE del content panel CpDomanda
	 */
	public void setCPBECpDomanda(it.csi.taif.taifweb.business.domanda.CPBECpDomanda bean) {
		this.cPBECpDomanda = bean;
	}

	/**
	 * riferimento al CPBE del content panel CpDomanda
	 */
	public it.csi.taif.taifweb.business.domanda.CPBECpDomanda getCPBECpDomanda() {
		return this.cPBECpDomanda;
	}

	/**
	 * riferimento al CPBE del content panel cpIstanzeTaglioPresentate
	 */
	private it.csi.taif.taifweb.business.domanda.CPBECpIstanzeTaglioPresentate cPBECpIstanzeTaglioPresentate = null;

	/**
	 * riferimento al CPBE del content panel cpIstanzeTaglioPresentate
	 */
	public void setCPBECpIstanzeTaglioPresentate(
			it.csi.taif.taifweb.business.domanda.CPBECpIstanzeTaglioPresentate bean) {
		this.cPBECpIstanzeTaglioPresentate = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpIstanzeTaglioPresentate
	 */
	public it.csi.taif.taifweb.business.domanda.CPBECpIstanzeTaglioPresentate getCPBECpIstanzeTaglioPresentate() {
		return this.cPBECpIstanzeTaglioPresentate;
	}

	/**
	 * riferimento al CPBE del content panel cpHomeGestore
	 */
	private it.csi.taif.taifweb.business.gestore.CPBECpHomeGestore cPBECpHomeGestore = null;

	/**
	 * riferimento al CPBE del content panel cpHomeGestore
	 */
	public void setCPBECpHomeGestore(it.csi.taif.taifweb.business.gestore.CPBECpHomeGestore bean) {
		this.cPBECpHomeGestore = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpHomeGestore
	 */
	public it.csi.taif.taifweb.business.gestore.CPBECpHomeGestore getCPBECpHomeGestore() {
		return this.cPBECpHomeGestore;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAziendaGestore
	 */
	private it.csi.taif.taifweb.business.gestore.CPBECpRicercaAziendaGestore cPBECpRicercaAziendaGestore = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaAziendaGestore
	 */
	public void setCPBECpRicercaAziendaGestore(it.csi.taif.taifweb.business.gestore.CPBECpRicercaAziendaGestore bean) {
		this.cPBECpRicercaAziendaGestore = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAziendaGestore
	 */
	public it.csi.taif.taifweb.business.gestore.CPBECpRicercaAziendaGestore getCPBECpRicercaAziendaGestore() {
		return this.cPBECpRicercaAziendaGestore;
	}

	/**
	 * riferimento al CPBE del content panel cpElencoAziendeGestore
	 */
	private it.csi.taif.taifweb.business.gestore.CPBECpElencoAziendeGestore cPBECpElencoAziendeGestore = null;

	/**
	 * riferimento al CPBE del content panel cpElencoAziendeGestore
	 */
	public void setCPBECpElencoAziendeGestore(it.csi.taif.taifweb.business.gestore.CPBECpElencoAziendeGestore bean) {
		this.cPBECpElencoAziendeGestore = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpElencoAziendeGestore
	 */
	public it.csi.taif.taifweb.business.gestore.CPBECpElencoAziendeGestore getCPBECpElencoAziendeGestore() {
		return this.cPBECpElencoAziendeGestore;
	}

	/**
	 * riferimento al CPBE del content panel CpDocumentazione
	 */
	private it.csi.taif.taifweb.business.common.CPBECpDocumentazione cPBECpDocumentazione = null;

	/**
	 * riferimento al CPBE del content panel CpDocumentazione
	 */
	public void setCPBECpDocumentazione(it.csi.taif.taifweb.business.common.CPBECpDocumentazione bean) {
		this.cPBECpDocumentazione = bean;
	}

	/**
	 * riferimento al CPBE del content panel CpDocumentazione
	 */
	public it.csi.taif.taifweb.business.common.CPBECpDocumentazione getCPBECpDocumentazione() {
		return this.cPBECpDocumentazione;
	}

	/**
	 * riferimento al CPBE del content panel CpRiepilogo
	 */
	private it.csi.taif.taifweb.business.common.CPBECpRiepilogo cPBECpRiepilogo = null;

	/**
	 * riferimento al CPBE del content panel CpRiepilogo
	 */
	public void setCPBECpRiepilogo(it.csi.taif.taifweb.business.common.CPBECpRiepilogo bean) {
		this.cPBECpRiepilogo = bean;
	}

	/**
	 * riferimento al CPBE del content panel CpRiepilogo
	 */
	public it.csi.taif.taifweb.business.common.CPBECpRiepilogo getCPBECpRiepilogo() {
		return this.cPBECpRiepilogo;
	}

	/**
	 * riferimento al CPBE del content panel cpError
	 */
	private it.csi.taif.taifweb.business.common.CPBECpError cPBECpError = null;

	/**
	 * riferimento al CPBE del content panel cpError
	 */
	public void setCPBECpError(it.csi.taif.taifweb.business.common.CPBECpError bean) {
		this.cPBECpError = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpError
	 */
	public it.csi.taif.taifweb.business.common.CPBECpError getCPBECpError() {
		return this.cPBECpError;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAccessoLibero
	 */
	private it.csi.taif.taifweb.business.libero.CPBECpRicercaAccessoLibero cPBECpRicercaAccessoLibero = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaAccessoLibero
	 */
	public void setCPBECpRicercaAccessoLibero(it.csi.taif.taifweb.business.libero.CPBECpRicercaAccessoLibero bean) {
		this.cPBECpRicercaAccessoLibero = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAccessoLibero
	 */
	public it.csi.taif.taifweb.business.libero.CPBECpRicercaAccessoLibero getCPBECpRicercaAccessoLibero() {
		return this.cPBECpRicercaAccessoLibero;
	}

	/**
	 * riferimento al CPBE del content panel cpElencoAccessoLibero
	 */
	private it.csi.taif.taifweb.business.libero.CPBECpElencoAccessoLibero cPBECpElencoAccessoLibero = null;

	/**
	 * riferimento al CPBE del content panel cpElencoAccessoLibero
	 */
	public void setCPBECpElencoAccessoLibero(it.csi.taif.taifweb.business.libero.CPBECpElencoAccessoLibero bean) {
		this.cPBECpElencoAccessoLibero = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpElencoAccessoLibero
	 */
	public it.csi.taif.taifweb.business.libero.CPBECpElencoAccessoLibero getCPBECpElencoAccessoLibero() {
		return this.cPBECpElencoAccessoLibero;
	}

	/**
	 * riferimento al CPBE del content panel cpAziendaDettaglio
	 */
	private it.csi.taif.taifweb.business.libero.CPBECpAziendaDettaglio cPBECpAziendaDettaglio = null;

	/**
	 * riferimento al CPBE del content panel cpAziendaDettaglio
	 */
	public void setCPBECpAziendaDettaglio(it.csi.taif.taifweb.business.libero.CPBECpAziendaDettaglio bean) {
		this.cPBECpAziendaDettaglio = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpAziendaDettaglio
	 */
	public it.csi.taif.taifweb.business.libero.CPBECpAziendaDettaglio getCPBECpAziendaDettaglio() {
		return this.cPBECpAziendaDettaglio;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1264235389) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	private TaifMgr taifMgr;

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	//taif-18 professionista
	private String identificaProfessionista(GlobalHomeModel theModel, String resultCode)
			throws BEException, ManagerException {
		log.info("BEGIN IDENTIFICA PROFESSIONISTA");
		final String IDENTIFICAPROFILO_OUTCOME_CODE__PROFESSIONISTAKO = //NOSONAR  Reason:EIAS
				"professionistaKO"; //NOSONAR  Reason:EIAS

		//		SecurityHelper sh = new SecurityHelper();
		//		Identita identita = sh.getCurrentUser(theModel.getSession());
		//		String codiceFiscale = identita.getCodFiscale();
		String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
		ProfiloUtenteTaif pu = this.getTaifMgr().getProfiloUtente(codiceFiscale);

		System.out.println("_____________ Current User *" + theModel.getAppDatacurrentUser() + "*");
		GenericUtil.stampaVO(theModel.getAppDatacurrentUser());

		GenericUtil.stampaVO(pu);

		boolean isNotProfessionista = pu != null
				&& (pu.getIdProfilo().equalsIgnoreCase("1") || pu.getIdProfilo().equalsIgnoreCase("3")
						|| pu.getIdProfilo().equalsIgnoreCase("4") || pu.getIdProfilo().equalsIgnoreCase("5"));
		if (isNotProfessionista) {
			return IDENTIFICAPROFILO_OUTCOME_CODE__PROFESSIONISTAKO;
		} else {

			theModel.getAppDatacurrentUser().setProfiloUtenteTaif(pu);
			return resultCode;
		}
	}

	//taif-18 azienda
	private String identificaAzienda(GlobalHomeModel theModel, String resultCode) throws BEException, ManagerException {
		log.info("BEGIN IDENTIFICA AZIENDA");
		final String IDENTIFICAPROFILO_OUTCOME_CODE__AZIENDAKO = //NOSONAR  Reason:EIAS
				"azienzaKO"; //NOSONAR  Reason:EIAS

		//		SecurityHelper sh = new SecurityHelper();
		//		Identita identita = sh.getCurrentUser(theModel.getSession());
		//		String codiceFiscale = identita.getCodFiscale();
		String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();

		ProfiloUtenteTaif pu = this.getTaifMgr().getProfiloUtente(codiceFiscale);

		System.out.println("_____________ Current User *" + theModel.getAppDatacurrentUser() + "*");
		GenericUtil.stampaVO(theModel.getAppDatacurrentUser());

		GenericUtil.stampaVO(pu);

		boolean isNotAzienda = pu != null
				&& (pu.getIdProfilo().equalsIgnoreCase("2") || pu.getIdProfilo().equalsIgnoreCase("3")
						|| pu.getIdProfilo().equalsIgnoreCase("4") || pu.getIdProfilo().equalsIgnoreCase("5"));
		if (isNotAzienda) {
			return IDENTIFICAPROFILO_OUTCOME_CODE__AZIENDAKO;
		} else {

			theModel.getAppDatacurrentUser().setProfiloUtenteTaif(pu);
			return resultCode;
		}
	}

	public String identificaGestore(it.csi.taif.taifweb.dto.GlobalHomeModel theModel, String resultCode)
			throws Exception {
		log.info("BEGIN IDENTIFICA GESTORE");
		final String IDENTIFICAPROFILO_OUTCOME_CODE__GESTOREKO = //NOSONAR  Reason:EIAS
				"gestoreKO"; //NOSONAR  Reason:EIAS
		//
		//		SecurityHelper sh = new SecurityHelper();
		//		Identita identita = sh.getCurrentUser(theModel.getSession());
		//		String codiceFiscale = identita.getCodFiscale();
		String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
		ProfiloUtenteTaif pu = this.getTaifMgr().getProfiloUtenteGestore(codiceFiscale);

		System.out.println("_____________ Current User *" + theModel.getAppDatacurrentUser() + "*");
		GenericUtil.stampaVO(theModel.getAppDatacurrentUser());

		GenericUtil.stampaVO(pu);

		if (pu == null || (!pu.getIdProfilo().equals("3") && !pu.getIdProfilo().equals("4")
				&& !pu.getIdProfilo().equals("5"))) {
			return IDENTIFICAPROFILO_OUTCOME_CODE__GESTOREKO;
		} else {

			theModel.getAppDatacurrentUser().setProfiloUtenteTaif(pu);
			return resultCode;
		}

	}

	private String executeGoHome(GlobalMenuModel theModel) {

		String result = null;

		final String HOME_AZIENDA = "Azienda";
		final String HOME_GESTORE = "Gestore";

		String tipoAccesso = (String) theModel.getSession().get("tipoAccesso");

		Integer i = Integer.valueOf(tipoAccesso);

		switch (i) {
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_AZIENDA_FRA :
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_AZIENDA_ITA :
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_PROFESSIONISTA_FRA :
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_PROFESSIONISTA_ITA :
				result = HOME_AZIENDA;
				break;
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_FRA :
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_ITA :
				result = HOME_GESTORE;
				break;
			default :
				result = HOME_AZIENDA;
				break;
		}
		return result;
	}

	/*PROTECTED REGION END*/
}
