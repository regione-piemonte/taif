/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.domanda;

import java.util.*;

import it.csi.taif.taifweb.dto.*;
import it.csi.taif.taifweb.dto.domanda.*;
import it.csi.taif.taifweb.dto.common.*;
import it.csi.taif.taifweb.dto.gestore.*;
import it.csi.taif.taifweb.dto.allegato.*;
import it.csi.taif.taifweb.dto.allegatodownload.*;

import org.apache.log4j.*;
import it.csi.taif.taifweb.util.*;
import it.csi.taif.taifweb.business.*;

/*PROTECTED REGION ID(R172003148) ENABLED START*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.business.BEException;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifApplSchedaOkDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoAttivitaByFilterDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoContrattoByVisibleOrdinDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoMansioneByVisibleOrdinDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoMezzoByCategoriaMezzoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialeByIdAttivitaProgressivoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialePk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaAssociazioneByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaFrTipoContrFindTipoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaFrTipoMansFindTipoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazioneFindCertificazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoByIdTipoMezzoAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoByTipoMezzoAziendaVisibileDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByProfiloPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaProfiloUtenteByCodiceFiscaleDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifVApplSchedaOkRealeDto;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AttivitaProgressivoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.CommercializzazioneFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloPersona;
import it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoQualificaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.FormaGiuridicaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.LavoroPaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.MaterialeFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SoggettoGestoreFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.StrutturaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter;
import it.csi.taif.taifweb.business.manager.DummyMgr;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.validation.ValidationMgr;
import it.csi.taif.taifweb.business.manager.validation.Validator;
import it.csi.taif.taifweb.dto.ExecResults;
import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.common.ProfiloUtenteTaif;
import it.csi.taif.taifweb.dto.common.UserInfo;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.exception.ValidationException;
import it.csi.taif.taifweb.presentation.model.view.domain.helper.view.DomandaViewHelper;
import it.csi.taif.taifweb.presentation.model.view.helper.ConfigVisibility;
import it.csi.taif.taifweb.presentation.model.view.helper.VisibilityHelper;
import it.csi.taif.taifweb.presentation.taifweb.action.ActivateMultiPanelItemCommand;
import it.csi.taif.taifweb.presentation.taifweb.action.CommandExecutionException;
import it.csi.taif.taifweb.presentation.taifweb.action.OnOffCommand;
import it.csi.taif.taifweb.presentation.taifweb.action.VisibilityCommand;
import it.csi.taif.taifweb.presentation.taifweb.action.domanda.CpDomandaAction;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.GenericUtil;
import it.csi.taif.taifweb.util.ListUtils;
import it.csi.taif.taifweb.util.StringUtils;

/*PROTECTED REGION END*/

public class CPBECpDomanda {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [idDomandaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDDOMANDASELEZIONATA_CODE = "appDataidDomandaSelezionata";

	// ApplicationData: [idAlboSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALBOSELEZIONATO_CODE = "appDataidAlboSelezionato";

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

	// ApplicationData: [elencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASECONDARIADATIANAGRAFICIANAGRAFEANZIENDALE_CODE = "appDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale";

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

	// ApplicationData: [elencoQualificheTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOQUALIFICHETITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoQualificheTitolareRappresentanteLegale";

	// ApplicationData: [elencoQualificheAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOQUALIFICHEALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoQualificheAltroTitolareRappresentanteLegale";

	// ApplicationData: [elencoCorsiSostenutiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSISOSTENUTITITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoCorsiSostenutiTitolareRappresentanteLegale";

	// ApplicationData: [elencoCorsiSostenutiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSISOSTENUTIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale";

	// ApplicationData: [albo, scope:USER_SESSION]
	public static final String APPDATA_ALBO_CODE = "appDataalbo";

	// ApplicationData: [elencoCategorieImpresa, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESA_CODE = "appDataelencoCategorieImpresa";

	// ApplicationData: [idCategorieImpresaSelezionati, scope:USER_SESSION]
	public static final String APPDATA_IDCATEGORIEIMPRESASELEZIONATI_CODE = "appDataidCategorieImpresaSelezionati";

	// ApplicationData: [elencoAltriAlbi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTRIALBI_CODE = "appDataelencoAltriAlbi";

	// ApplicationData: [elencoCertificazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCERTIFICAZIONI_CODE = "appDataelencoCertificazioni";

	// ApplicationData: [elencoFormeOrganizzative, scope:USER_SESSION]
	public static final String APPDATA_ELENCOFORMEORGANIZZATIVE_CODE = "appDataelencoFormeOrganizzative";

	// ApplicationData: [idFormeOrganizzative, scope:USER_SESSION]
	public static final String APPDATA_IDFORMEORGANIZZATIVE_CODE = "appDataidFormeOrganizzative";

	// ApplicationData: [elencoLavoriPA, scope:USER_SESSION]
	public static final String APPDATA_ELENCOLAVORIPA_CODE = "appDataelencoLavoriPA";

	// ApplicationData: [elencoLegnamiAssortimentiTrattati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOLEGNAMIASSORTIMENTITRATTATI_CODE = "appDataelencoLegnamiAssortimentiTrattati";

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

	// ApplicationData: [elencoCapannoni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCAPANNONI_CODE = "appDataelencoCapannoni";

	// ApplicationData: [elencoPiazzaliStoccaggio, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPIAZZALISTOCCAGGIO_CODE = "appDataelencoPiazzaliStoccaggio";

	// ApplicationData: [elencoCaschiForestaliAttrezzature, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCASCHIFORESTALIATTREZZATURE_CODE = "appDataelencoCaschiForestaliAttrezzature";

	// ApplicationData: [elencoPantaloniAntitaglioAttrezzature, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPANTALONIANTITAGLIOATTREZZATURE_CODE = "appDataelencoPantaloniAntitaglioAttrezzature";

	// ApplicationData: [elencoScarponiRinforzatiAttrezzature, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSCARPONIRINFORZATIATTREZZATURE_CODE = "appDataelencoScarponiRinforzatiAttrezzature";

	// ApplicationData: [elencoMacchineCippatrici, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINECIPPATRICI_CODE = "appDataelencoMacchineCippatrici";

	// ApplicationData: [elencoMacchineGruACavo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEGRUACAVO_CODE = "appDataelencoMacchineGruACavo";

	// ApplicationData: [elencoMacchineMovimentoTerra, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEMOVIMENTOTERRA_CODE = "appDataelencoMacchineMovimentoTerra";

	// ApplicationData: [elencoMacchinePle, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEPLE_CODE = "appDataelencoMacchinePle";

	// ApplicationData: [elencoMacchineRimorchi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINERIMORCHI_CODE = "appDataelencoMacchineRimorchi";

	// ApplicationData: [elencoMacchineSegheriaMobile, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINESEGHERIAMOBILE_CODE = "appDataelencoMacchineSegheriaMobile";

	// ApplicationData: [elencoMacchineSpeciali, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINESPECIALI_CODE = "appDataelencoMacchineSpeciali";

	// ApplicationData: [elencoMacchineTrattrici, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINETRATTRICI_CODE = "appDataelencoMacchineTrattrici";

	// ApplicationData: [elencoMacchineTrinciaForestali, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINETRINCIAFORESTALI_CODE = "appDataelencoMacchineTrinciaForestali";

	// ApplicationData: [elencoMacchineVerricelli, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEVERRICELLI_CODE = "appDataelencoMacchineVerricelli";

	// ApplicationData: [elencoMezziDiTrasporto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMEZZIDITRASPORTO_CODE = "appDataelencoMezziDiTrasporto";

	// ApplicationData: [elencoPersonale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPERSONALE_CODE = "appDataelencoPersonale";

	// ApplicationData: [elencoPersonaleSuggerito, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPERSONALESUGGERITO_CODE = "appDataelencoPersonaleSuggerito";

	// ApplicationData: [personaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_PERSONALEDACERCARE_CODE = "appDatapersonaleDaCercare";

	// ApplicationData: [elencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATONASCITADATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [elencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTITOLOSTUDIODATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [idStatoNascitaDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDSTATONASCITADATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [idTitoloStudioDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDTITOLOSTUDIODATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [anagraficaAziendale, scope:USER_SESSION]
	public static final String APPDATA_ANAGRAFICAAZIENDALE_CODE = "appDataanagraficaAziendale";

	// ApplicationData: [altroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataaltroTitolareRappresentanteLegale";

	// ApplicationData: [titolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_TITOLARERAPPRESENTANTELEGALE_CODE = "appDatatitolareRappresentanteLegale";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [fatturatoCategorieDiImpresa, scope:USER_SESSION]
	public static final String APPDATA_FATTURATOCATEGORIEDIIMPRESA_CODE = "appDatafatturatoCategorieDiImpresa";

	// ApplicationData: [associazioniECertificazioni, scope:USER_SESSION]
	public static final String APPDATA_ASSOCIAZIONIECERTIFICAZIONI_CODE = "appDataassociazioniECertificazioni";

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

	// ApplicationData: [gestioneMacchineMezzi, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEMACCHINEMEZZI_CODE = "appDatagestioneMacchineMezzi";

	// ApplicationData: [gestioneFatturatoCategoriaDiImpresa, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEFATTURATOCATEGORIADIIMPRESA_CODE = "appDatagestioneFatturatoCategoriaDiImpresa";

	// ApplicationData: [idStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDSTATONASCITADATIANAGRAFICIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale";

	// ApplicationData: [idTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDTITOLOSTUDIODATIANAGRAFICIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale";

	// ApplicationData: [comuneNascitaAltroTitolareRappresentanteLegaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_COMUNENASCITAALTROTITOLARERAPPRESENTANTELEGALEDACERCARE_CODE = "appDatacomuneNascitaAltroTitolareRappresentanteLegaleDaCercare";

	// ApplicationData: [comuneNascitaTitolareRappresentanteLegaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_COMUNENASCITATITOLARERAPPRESENTANTELEGALEDACERCARE_CODE = "appDatacomuneNascitaTitolareRappresentanteLegaleDaCercare";

	// ApplicationData: [comuneResidenzaAltroTitolareRappresentanteLegaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_COMUNERESIDENZAALTROTITOLARERAPPRESENTANTELEGALEDACERCARE_CODE = "appDatacomuneResidenzaAltroTitolareRappresentanteLegaleDaCercare";

	// ApplicationData: [comuneResidenzaTitolareRappresentanteLegaleDaCercare, scope:USER_SESSION]
	public static final String APPDATA_COMUNERESIDENZATITOLARERAPPRESENTANTELEGALEDACERCARE_CODE = "appDatacomuneResidenzaTitolareRappresentanteLegaleDaCercare";

	// ApplicationData: [elencoComuniNascitaAltroTitolareRappresentante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNINASCITAALTROTITOLARERAPPRESENTANTE_CODE = "appDataelencoComuniNascitaAltroTitolareRappresentante";

	// ApplicationData: [elencoComuniNascitaTitolareRappresentante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNINASCITATITOLARERAPPRESENTANTE_CODE = "appDataelencoComuniNascitaTitolareRappresentante";

	// ApplicationData: [elencoComuniResidenzaAltroTitolareRappresentante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRESIDENZAALTROTITOLARERAPPRESENTANTE_CODE = "appDataelencoComuniResidenzaAltroTitolareRappresentante";

	// ApplicationData: [elencoComuniResidenzaTitolareRappresentante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRESIDENZATITOLARERAPPRESENTANTE_CODE = "appDataelencoComuniResidenzaTitolareRappresentante";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [idComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNENASCITADATIANAGRAFICIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale";

	// ApplicationData: [idComuneNascitaDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNENASCITADATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [idComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNERESIDENZADATIANAGRAFICIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale";

	// ApplicationData: [idComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNERESIDENZADATIANAGRAFICITITOLARERAPPRESENTANTELEGALE_CODE = "appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale";

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [sedeLegaleAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_SEDELEGALEANAGRAFEAZIENDALE_CODE = "appDatasedeLegaleAnagrafeAziendale";

	// ApplicationData: [idComuneSedeLegaleDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESEDELEGALEDATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [elencoComuniDatiAnagraficiAnagrafeAziendale, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIDATIANAGRAFICIANAGRAFEAZIENDALE_CODE = "appDataelencoComuniDatiAnagraficiAnagrafeAziendale";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [backDomanda, scope:USER_SESSION]
	public static final String APPDATA_BACKDOMANDA_CODE = "appDatabackDomanda";

	// ApplicationData: [primoIngresso, scope:USER_SESSION]
	public static final String APPDATA_PRIMOINGRESSO_CODE = "appDataprimoIngresso";

	// ApplicationData: [idPratica, scope:USER_SESSION]
	public static final String APPDATA_IDPRATICA_CODE = "appDataidPratica";

	// ApplicationData: [idAttivitaUltimoAnnoFr, scope:USER_SESSION]
	public static final String APPDATA_IDATTIVITAULTIMOANNOFR_CODE = "appDataidAttivitaUltimoAnnoFr";

	// ApplicationData: [elencoAttivitaUltimoAnnoFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITAULTIMOANNOFR_CODE = "appDataelencoAttivitaUltimoAnnoFr";

	// ApplicationData: [percentualeCommercioFr, scope:USER_SESSION]
	public static final String APPDATA_PERCENTUALECOMMERCIOFR_CODE = "appDatapercentualeCommercioFr";

	// ApplicationData: [elencoAltroPersonaleTipoContrattoFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTROPERSONALETIPOCONTRATTOFR_CODE = "appDataelencoAltroPersonaleTipoContrattoFr";

	// ApplicationData: [elencoAltroPersonaleTipoMansioneFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTROPERSONALETIPOMANSIONEFR_CODE = "appDataelencoAltroPersonaleTipoMansioneFr";

	// ApplicationData: [gestioneAltroPersonaleFr, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEALTROPERSONALEFR_CODE = "appDatagestioneAltroPersonaleFr";

	// ApplicationData: [elencoMacchineGrumier, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEGRUMIER_CODE = "appDataelencoMacchineGrumier";

	// ApplicationData: [elencoMacchineMovimentoTerraFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINEMOVIMENTOTERRAFR_CODE = "appDataelencoMacchineMovimentoTerraFr";

	// ApplicationData: [elencoMacchineRimorchiFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINERIMORCHIFR_CODE = "appDataelencoMacchineRimorchiFr";

	// ApplicationData: [elencoMacchineSemi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINESEMI_CODE = "appDataelencoMacchineSemi";

	// ApplicationData: [elencoMacchineSpecialiFr, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMACCHINESPECIALIFR_CODE = "appDataelencoMacchineSpecialiFr";

	// ApplicationData: [idCategorieImpresaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCATEGORIEIMPRESASELEZIONATO_CODE = "appDataidCategorieImpresaSelezionato";

	// ApplicationData: [elencoUnitaMisura, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAMISURA_CODE = "appDataelencoUnitaMisura";

	// ApplicationData: [idUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIDIUTILIZZAZIONEFUORIREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIDIUTILIZZAZIONEINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTagliIntercalariFuoriRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIINTERCALARIFUORIREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTagliIntercalariInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIINTERCALARIINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIOPIOPPETOFUORIREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTaglioPioppetoInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIOPIOPPETOINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato";

	// ApplicationData: [elencoAltriMezzi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTRIMEZZI_CODE = "appDataelencoAltriMezzi";

	// ApplicationData: [domandaRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_DOMANDARIEPILOGO_CODE = "appDatadomandaRiepilogo";

	// ApplicationData: [elencoIstanzeTaglioPresentate, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISTANZETAGLIOPRESENTATE_CODE = "appDataelencoIstanzeTaglioPresentate";

	// ApplicationData: [idSoggettoGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSOGGETTOGESTORE_CODE = "appDataidSoggettoGestore";

	// ApplicationData: [isVolumeAcquisitoFromPrimpaForSrv, scope:USER_SESSION]
	public static final String APPDATA_ISVOLUMEACQUISITOFROMPRIMPAFORSRV_CODE = "appDataisVolumeAcquisitoFromPrimpaForSrv";

	// ApplicationData: [volumiAcquisitiPrimpaForSrv, scope:USER_SESSION]
	public static final String APPDATA_VOLUMIACQUISITIPRIMPAFORSRV_CODE = "appDatavolumiAcquisitiPrimpaForSrv";

	// ApplicationData: [elencoRiconiscimentiAltroTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCORICONISCIMENTIALTROTITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoRiconiscimentiAltroTitolareRappresentanteLegale";

	// ApplicationData: [elencoRiconiscimentiTitolareRappresentanteLegale, scope:USER_SESSION]
	public static final String APPDATA_ELENCORICONISCIMENTITITOLARERAPPRESENTANTELEGALE_CODE = "appDataelencoRiconiscimentiTitolareRappresentanteLegale";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "CpDomanda";

	public static final String WIZARD_WZPDOMANDA = "wzpDomanda";
	public static final String STEP_WZPDOMANDA_FPWIZARD1DATIANAGRAFICI = CPNAME + "_" + WIZARD_WZPDOMANDA + "_"
			+ "fpWizard1DatiAnagrafici";
	public static final String STEP_WZPDOMANDA_FPWIZARD2DATISOCIOECONOMICI = CPNAME + "_" + WIZARD_WZPDOMANDA + "_"
			+ "fpWizard2DatiSocioEconomici";
	public static final String STEP_WZPDOMANDA_FPWIZARD3ATTIVITA = CPNAME + "_" + WIZARD_WZPDOMANDA + "_"
			+ "fpWizard3Attivita";
	public static final String STEP_WZPDOMANDA_FPWIZARD4STRUTTURE = CPNAME + "_" + WIZARD_WZPDOMANDA + "_"
			+ "fpWizard4Strutture";
	public static final String STEP_WZPDOMANDA_FPWIZARD5ATTREZZATURE = CPNAME + "_" + WIZARD_WZPDOMANDA + "_"
			+ "fpWizard5Attrezzature";
	public static final String STEP_WZPDOMANDA_FPWIZARD6PERSONALE = CPNAME + "_" + WIZARD_WZPDOMANDA + "_"
			+ "fpWizard6Personale";
	public static final String WIZARD_WZPDOMANDADATIANAGRAFICI = "wzpDomandaDatiAnagrafici";
	public static final String STEP_WZPDOMANDADATIANAGRAFICI_FPWIZARDDATIANAGRAFICISUB1 = CPNAME + "_"
			+ WIZARD_WZPDOMANDADATIANAGRAFICI + "_" + "fpWizardDatiAnagraficiSub1";
	public static final String STEP_WZPDOMANDADATIANAGRAFICI_FPWIZARDDATIANAGRAFICISUB2 = CPNAME + "_"
			+ WIZARD_WZPDOMANDADATIANAGRAFICI + "_" + "fpWizardDatiAnagraficiSub2";
	public static final String MULTIPANEL_MPDATIANAGRAFICIISCRIZIONECCIAA = "mpDatiAnagraficiIscrizioneCCIAA";
	public static final String MPI_MPDATIANAGRAFICIISCRIZIONECCIAA_FPDATIANAGRAFICIISCRIZIONECCIAA = CPNAME + "_"
			+ MULTIPANEL_MPDATIANAGRAFICIISCRIZIONECCIAA + "_" + "fpDatiAnagraficiIscrizioneCCIAA";

	public static final String MULTIPANEL_MPDATIANAGRAFICISEDI = "mpDatiAnagraficiSedi";
	public static final String MPI_MPDATIANAGRAFICISEDI_FPDATIANAGRAFICISEDI = CPNAME + "_"
			+ MULTIPANEL_MPDATIANAGRAFICISEDI + "_" + "fpDatiAnagraficiSedi";

	public static final String MULTIPANEL_MPDATIANAGRAFICIANAGRAFEAZIENDALEMARCADABOLLO = "mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo";
	public static final String MPI_MPDATIANAGRAFICIANAGRAFEAZIENDALEMARCADABOLLO_FPDATIANAGRAFICIANAGRAFEAZIENDALEMARCADABOLLO = CPNAME
			+ "_" + MULTIPANEL_MPDATIANAGRAFICIANAGRAFEAZIENDALEMARCADABOLLO + "_"
			+ "fpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo";

	public static final String MULTIPANEL_MPDATIANAGRAFICICONSENSOPRIVACY = "mpDatiAnagraficiConsensoPrivacy";
	public static final String MPI_MPDATIANAGRAFICICONSENSOPRIVACY_FPDATIANAGRAFICICONSENSOPRIVACY = CPNAME + "_"
			+ MULTIPANEL_MPDATIANAGRAFICICONSENSOPRIVACY + "_" + "fpDatiAnagraficiConsensoPrivacy";

	public static final String MULTIPANEL_MPDATIANAGRAFICITITOLARERAPPRESENTANTELEGALEALTROCONDUCENTE = "mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente";
	public static final String MPI_MPDATIANAGRAFICITITOLARERAPPRESENTANTELEGALEALTROCONDUCENTE_FPDATIANAGRAFICITITOLARERAPPRESENTANTELEGALEALTROCONDUCENTE = CPNAME
			+ "_" + MULTIPANEL_MPDATIANAGRAFICITITOLARERAPPRESENTANTELEGALEALTROCONDUCENTE + "_"
			+ "fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente";

	public static final String MULTIPANEL_MPDATIANAGRAFICICONDUTTOREAZIENDA = "mpDatiAnagraficiConduttoreAzienda";
	public static final String MPI_MPDATIANAGRAFICICONDUTTOREAZIENDA_FPDATIANAGRAFICICONDUTTOREAZIENDA = CPNAME + "_"
			+ MULTIPANEL_MPDATIANAGRAFICICONDUTTOREAZIENDA + "_" + "fpDatiAnagraficiConduttoreAzienda";

	public static final String WIZARD_WZPDOMANDADATISOCIOECONOMICI = "wzpDomandaDatiSocioEconomici";
	public static final String STEP_WZPDOMANDADATISOCIOECONOMICI_FPWIZARDDATISOCIOECONOMICISUB1 = CPNAME + "_"
			+ WIZARD_WZPDOMANDADATISOCIOECONOMICI + "_" + "fpWizardDatiSocioEconomiciSub1";
	public static final String STEP_WZPDOMANDADATISOCIOECONOMICI_FPWIZARDDATISOCIOECONOMICISUB2 = CPNAME + "_"
			+ WIZARD_WZPDOMANDADATISOCIOECONOMICI + "_" + "fpWizardDatiSocioEconomiciSub2";

	public static final String MULTIPANEL_MPDATISOCIOECONOMICIALTRIALBI = "mpDatiSocioEconomiciAltriAlbi";
	public static final String MPI_MPDATISOCIOECONOMICIALTRIALBI_FPDATISOCIOECONOMICIALTRIALBI = CPNAME + "_"
			+ MULTIPANEL_MPDATISOCIOECONOMICIALTRIALBI + "_" + "fpDatiSocioEconomiciAltriAlbi";

	public static final String MULTIPANEL_MPDATISOCIOECONOMICICERTIFICAZIONIQUALITAPROCESSO = "mpDatiSocioEconomiciCertificazioniQualitaProcesso";
	public static final String MPI_MPDATISOCIOECONOMICICERTIFICAZIONIQUALITAPROCESSO_FPDATISOCIOECONOMICICERTIFICAZIONIQUALITAPROCESSO = CPNAME
			+ "_" + MULTIPANEL_MPDATISOCIOECONOMICICERTIFICAZIONIQUALITAPROCESSO + "_"
			+ "fpDatiSocioEconomiciCertificazioniQualitaProcesso";

	public static final String WIZARD_WZPDOMANDAATTIVITA = "wzpDomandaAttivita";
	public static final String STEP_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB1 = CPNAME + "_" + WIZARD_WZPDOMANDAATTIVITA
			+ "_" + "fpWizardAttivitaSub1";
	public static final String STEP_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB2 = CPNAME + "_" + WIZARD_WZPDOMANDAATTIVITA
			+ "_" + "fpWizardAttivitaSub2";
	public static final String STEP_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB3 = CPNAME + "_" + WIZARD_WZPDOMANDAATTIVITA
			+ "_" + "fpWizardAttivitaSub3";
	public static final String MULTIPANEL_MPATTIVITAIT = "mpAttivitaIt";
	public static final String MPI_MPATTIVITAIT_FPATTIVITAIT = CPNAME + "_" + MULTIPANEL_MPATTIVITAIT + "_"
			+ "fpAttivitaIt";
	public static final String MULTIPANEL_MPATTIVITAULTIMOANNO1 = "mpAttivitaUltimoAnno1";
	public static final String MPI_MPATTIVITAULTIMOANNO1_FPATTIVITAULTIMOANNO1 = CPNAME + "_"
			+ MULTIPANEL_MPATTIVITAULTIMOANNO1 + "_" + "fpAttivitaUltimoAnno1";

	public static final String MULTIPANEL_MPATTIVITAULTIMOANNO2 = "mpAttivitaUltimoAnno2";
	public static final String MPI_MPATTIVITAULTIMOANNO2_FPATTIVITAULTIMOANNO2 = CPNAME + "_"
			+ MULTIPANEL_MPATTIVITAULTIMOANNO2 + "_" + "fpAttivitaUltimoAnno2";

	public static final String MULTIPANEL_MPATTIVITAULTIMOANNO3 = "mpAttivitaUltimoAnno3";
	public static final String MPI_MPATTIVITAULTIMOANNO3_FPATTIVITAULTIMOANNO3 = CPNAME + "_"
			+ MULTIPANEL_MPATTIVITAULTIMOANNO3 + "_" + "fpAttivitaUltimoAnno3";

	public static final String MULTIPANEL_MPATTIVITAULTIMOANNO4 = "mpAttivitaUltimoAnno4";
	public static final String MPI_MPATTIVITAULTIMOANNO4_FPATTIVITAULTIMOANNO4 = CPNAME + "_"
			+ MULTIPANEL_MPATTIVITAULTIMOANNO4 + "_" + "fpAttivitaUltimoAnno4";

	public static final String MULTIPANEL_MPATTIVITAULTIMOANNO5 = "mpAttivitaUltimoAnno5";
	public static final String MPI_MPATTIVITAULTIMOANNO5_FPATTIVITAULTIMOANNO5 = CPNAME + "_"
			+ MULTIPANEL_MPATTIVITAULTIMOANNO5 + "_" + "fpAttivitaUltimoAnno5";

	public static final String MULTIPANEL_MPATTIVITAFR = "mpAttivitaFr";
	public static final String MPI_MPATTIVITAFR_FPATTIVITAFR = CPNAME + "_" + MULTIPANEL_MPATTIVITAFR + "_"
			+ "fpAttivitaFr";

	public static final String MULTIPANEL_MPATTIVITALAVORIPAIT = "mpAttivitaLavoriPAIt";
	public static final String MPI_MPATTIVITALAVORIPAIT_FPATTIVITALAVORIPAIT = CPNAME + "_"
			+ MULTIPANEL_MPATTIVITALAVORIPAIT + "_" + "fpAttivitaLavoriPAIt";

	public static final String MULTIPANEL_MPATTIVITALAVORIPA = "mpAttivitaLavoriPA";
	public static final String MPI_MPATTIVITALAVORIPA_FPATTIVITALAVORIPA = CPNAME + "_" + MULTIPANEL_MPATTIVITALAVORIPA
			+ "_" + "fpAttivitaLavoriPA";

	public static final String MULTIPANEL_MPATTIVITALAVORIPAFR = "mpAttivitaLavoriPAFr";
	public static final String MPI_MPATTIVITALAVORIPAFR_FPATTIVITALAVORIPAFR = CPNAME + "_"
			+ MULTIPANEL_MPATTIVITALAVORIPAFR + "_" + "fpAttivitaLavoriPAFr";

	public static final String MULTIPANEL_MPATTIVITALEGNAME = "mpAttivitaLegname";
	public static final String MPI_MPATTIVITALEGNAME_FPATTIVITALEGNAME = CPNAME + "_" + MULTIPANEL_MPATTIVITALEGNAME
			+ "_" + "fpAttivitaLegname";

	public static final String MULTIPANEL_MPATTIVITALEGNAMEFR = "mpAttivitaLegnameFr";
	public static final String MPI_MPATTIVITALEGNAMEFR_FPATTIVITALEGNAMEFR = CPNAME + "_"
			+ MULTIPANEL_MPATTIVITALEGNAMEFR + "_" + "fpAttivitaLegnameFr";

	public static final String MULTIPANEL_MPSTRUTTURECAPANNONI = "mpStruttureCapannoni";
	public static final String MPI_MPSTRUTTURECAPANNONI_FPSTRUTTURECAPANNONI = CPNAME + "_"
			+ MULTIPANEL_MPSTRUTTURECAPANNONI + "_" + "fpStruttureCapannoni";

	public static final String MULTIPANEL_MPSTRUTTUREPIAZZALISTOCCAGGIO = "mpStrutturePiazzaliStoccaggio";
	public static final String MPI_MPSTRUTTUREPIAZZALISTOCCAGGIO_FPSTRUTTUREPIAZZALISTOCCAGGIO = CPNAME + "_"
			+ MULTIPANEL_MPSTRUTTUREPIAZZALISTOCCAGGIO + "_" + "fpStrutturePiazzaliStoccaggio";

	public static final String WIZARD_WZPDOMANDAATTREZZATTURE = "wzpDomandaAttrezzatture";
	public static final String STEP_WZPDOMANDAATTREZZATTURE_FPWIZARDATTREZZATURESUB1 = CPNAME + "_"
			+ WIZARD_WZPDOMANDAATTREZZATTURE + "_" + "fpWizardAttrezzatureSub1";
	public static final String STEP_WZPDOMANDAATTREZZATTURE_PWIZARDATTREZZATURESUB2 = CPNAME + "_"
			+ WIZARD_WZPDOMANDAATTREZZATTURE + "_" + "pWizardAttrezzatureSub2";
	public static final String MULTIPANEL_MPATTREZZATUREIT = "mpAttrezzatureIt";
	public static final String MPI_MPATTREZZATUREIT_FPATTREZZATUREIT = CPNAME + "_" + MULTIPANEL_MPATTREZZATUREIT + "_"
			+ "fpAttrezzatureIt";
	public static final String MULTIPANEL_MPATTREZZATURECASCOFORESTALE = "mpAttrezzatureCascoForestale";
	public static final String MPI_MPATTREZZATURECASCOFORESTALE_FPATTREZZATURECASCOFORESTALE = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATURECASCOFORESTALE + "_" + "fpAttrezzatureCascoForestale";

	public static final String MULTIPANEL_MPATTREZZATURESCARPONIRINFORZATI = "mpAttrezzatureScarponiRinforzati";
	public static final String MPI_MPATTREZZATURESCARPONIRINFORZATI_FPATTREZZATURESCARPONIRINFORZATI = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATURESCARPONIRINFORZATI + "_" + "fpAttrezzatureScarponiRinforzati";

	public static final String MULTIPANEL_MPATTREZZATUREPANTALONIANTITAGLIO = "mpAttrezzaturePantaloniAntitaglio";
	public static final String MPI_MPATTREZZATUREPANTALONIANTITAGLIO_FPATTREZZATUREPANTALONIANTITAGLIO = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREPANTALONIANTITAGLIO + "_" + "fpAttrezzaturePantaloniAntitaglio";

	public static final String MULTIPANEL_MPATTREZZATUREFR = "mpAttrezzatureFr";
	public static final String MPI_MPATTREZZATUREFR_FPATTREZZATUREFR = CPNAME + "_" + MULTIPANEL_MPATTREZZATUREFR + "_"
			+ "fpAttrezzatureFr";

	public static final String MULTIPANEL_MPMACCHINEMEZZIIT = "mpMacchineMezziIt";
	public static final String MPI_MPMACCHINEMEZZIIT_FPMACCHINEMEZZIIT = CPNAME + "_" + MULTIPANEL_MPMACCHINEMEZZIIT
			+ "_" + "fpMacchineMezziIt";
	public static final String MULTIPANEL_MPATTREZZATUREMACCHINETRATTRICI = "mpAttrezzatureMacchineTrattrici";
	public static final String MPI_MPATTREZZATUREMACCHINETRATTRICI_FPATTREZZATUREMACCHINAELENCOTRATTRICI = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINETRATTRICI + "_" + "fpAttrezzatureMacchinaElencoTrattrici";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINESPECIALI = "mpAttrezzatureMacchineSpeciali";
	public static final String MPI_MPATTREZZATUREMACCHINESPECIALI_FPATTREZZATUREMACCHINESPECIALI = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINESPECIALI + "_" + "fpAttrezzatureMacchineSpeciali";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINEMOVIMENTOATERRA = "mpAttrezzatureMacchineMovimentoATerra";
	public static final String MPI_MPATTREZZATUREMACCHINEMOVIMENTOATERRA_FPATTREZZATUREMACCHINEMOVIMENTOATERRA = CPNAME
			+ "_" + MULTIPANEL_MPATTREZZATUREMACCHINEMOVIMENTOATERRA + "_" + "fpAttrezzatureMacchineMovimentoATerra";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINERIMORCHI = "mpAttrezzatureMacchineRimorchi";
	public static final String MPI_MPATTREZZATUREMACCHINERIMORCHI_FPATTREZZATUREMACCHINAELENCORIMORCHI = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINERIMORCHI + "_" + "fpAttrezzatureMacchinaElencoRimorchi";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINEVERRICELLI = "mpAttrezzatureMacchineVerricelli";
	public static final String MPI_MPATTREZZATUREMACCHINEVERRICELLI_FPATTREZZATUREMACCHINAELENCOVERRICELLI = CPNAME
			+ "_" + MULTIPANEL_MPATTREZZATUREMACCHINEVERRICELLI + "_" + "fpAttrezzatureMacchinaElencoVerricelli";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINEPLE = "mpAttrezzatureMacchinePle";
	public static final String MPI_MPATTREZZATUREMACCHINEPLE_FPATTREZZATUREMACCHINAELENCOPLE = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINEPLE + "_" + "fpAttrezzatureMacchinaElencoPle";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINETRINCIAFORESTALE = "mpAttrezzatureMacchineTrinciaForestale";
	public static final String MPI_MPATTREZZATUREMACCHINETRINCIAFORESTALE_FPATTREZZATUREMACCHINAELENCOTRINCIAFORESTALE = CPNAME
			+ "_" + MULTIPANEL_MPATTREZZATUREMACCHINETRINCIAFORESTALE + "_"
			+ "fpAttrezzatureMacchinaElencoTrinciaForestale";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINESEGHERIEMOBILI = "mpAttrezzatureMacchineSegherieMobili";
	public static final String MPI_MPATTREZZATUREMACCHINESEGHERIEMOBILI_FPATTREZZATUREMACCHINESEGHERIEMOBILI = CPNAME
			+ "_" + MULTIPANEL_MPATTREZZATUREMACCHINESEGHERIEMOBILI + "_" + "fpAttrezzatureMacchineSegherieMobili";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINEGRUACAVO = "mpAttrezzatureMacchineGruACavo";
	public static final String MPI_MPATTREZZATUREMACCHINEGRUACAVO_FPATTREZZATUREMACCHINEGRUACAVO = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINEGRUACAVO + "_" + "fpAttrezzatureMacchineGruACavo";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINECIPPATRICI = "mpAttrezzatureMacchineCippatrici";
	public static final String MPI_MPATTREZZATUREMACCHINECIPPATRICI_FPATTREZZATUREMACCHINECIPPATRICI = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINECIPPATRICI + "_" + "fpAttrezzatureMacchineCippatrici";

	public static final String MULTIPANEL_MPATTREZZATUREMEZZIDITRASPORTO = "mpAttrezzatureMezziDiTrasporto";
	public static final String MPI_MPATTREZZATUREMEZZIDITRASPORTO_FPATTREZZATUREMEZZIDITRASPORTO = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMEZZIDITRASPORTO + "_" + "fpAttrezzatureMezziDiTrasporto";

	public static final String MULTIPANEL_MPATTREZZATUREALTRIMEZZI = "mpAttrezzatureAltriMezzi";
	public static final String MPI_MPATTREZZATUREALTRIMEZZI_FPATTREZZATUREALTRIMEZZI = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREALTRIMEZZI + "_" + "fpAttrezzatureAltriMezzi";

	public static final String MULTIPANEL_MPMACCHINEMEZZIFR = "mpMacchineMezziFr";
	public static final String MPI_MPMACCHINEMEZZIFR_FPMACCHINEMEZZIFR = CPNAME + "_" + MULTIPANEL_MPMACCHINEMEZZIFR
			+ "_" + "fpMacchineMezziFr";
	public static final String MULTIPANEL_MPATTREZZATUREMACCHINESPECIALIFR = "mpAttrezzatureMacchineSpecialiFr";
	public static final String MPI_MPATTREZZATUREMACCHINESPECIALIFR_FPATTREZZATUREMACCHINESPECIALIFR = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINESPECIALIFR + "_" + "fpAttrezzatureMacchineSpecialiFr";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINEMOVIMENTOATERRAFR = "mpAttrezzatureMacchineMovimentoATerraFr";
	public static final String MPI_MPATTREZZATUREMACCHINEMOVIMENTOATERRAFR_FPATTREZZATUREMACCHINEMOVIMENTOATERRAFR = CPNAME
			+ "_" + MULTIPANEL_MPATTREZZATUREMACCHINEMOVIMENTOATERRAFR + "_"
			+ "fpAttrezzatureMacchineMovimentoATerraFr";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINEGRUMIER = "mpAttrezzatureMacchineGrumier";
	public static final String MPI_MPATTREZZATUREMACCHINEGRUMIER_FPATTREZZATUREMACCHINAELENCOGRUMIER = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINEGRUMIER + "_" + "fpAttrezzatureMacchinaElencoGrumier";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINERIMORCHIFR = "mpAttrezzatureMacchineRimorchiFr";
	public static final String MPI_MPATTREZZATUREMACCHINERIMORCHIFR_FPATTREZZATUREMACCHINAELENCORIMORCHIFR = CPNAME
			+ "_" + MULTIPANEL_MPATTREZZATUREMACCHINERIMORCHIFR + "_" + "fpAttrezzatureMacchinaElencoRimorchiFr";

	public static final String MULTIPANEL_MPATTREZZATUREMACCHINESEMI = "mpAttrezzatureMacchineSemi";
	public static final String MPI_MPATTREZZATUREMACCHINESEMI_FPATTREZZATUREMACCHINAELENCOSEMI = CPNAME + "_"
			+ MULTIPANEL_MPATTREZZATUREMACCHINESEMI + "_" + "fpAttrezzatureMacchinaElencoSemi";

	public static final String MULTIPANEL_MPALTROPERSONALE = "mpAltroPersonale";
	public static final String MPI_MPALTROPERSONALE_FPALTROPERSONALE = CPNAME + "_" + MULTIPANEL_MPALTROPERSONALE + "_"
			+ "fpAltroPersonale";

	public static final String MULTIPANEL_MPALTROPERSONALEFR = "mpAltroPersonaleFr";
	public static final String MPI_MPALTROPERSONALEFR_FPALTROPERSONALEFR = CPNAME + "_" + MULTIPANEL_MPALTROPERSONALEFR
			+ "_" + "fpAltroPersonaleFr";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeSwitchWizardDomanda definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTESWITCHWIZARDDOMANDA_OUTCOME_CODE__OK_GESTORE_PIEMONTE = //NOSONAR  Reason:EIAS
				"Ok_GESTORE_PIEMONTE"; //NOSONAR  Reason:EIAS
		final String EXECUTESWITCHWIZARDDOMANDA_OUTCOME_CODE__OK_GESTORE_NO_PIEMONTE = //NOSONAR  Reason:EIAS
				"Ok_GESTORE_NO_PIEMONTE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1256465417) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.info("TAB SELEZIONATO *" + theModel.getSelectedTabKey() + "* - *" + theModel.getSelectedTabValue()
					+ "*");

			try {
				this.switchTabAndInit(theModel);
			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, EXECUTESWITCHWIZARDDOMANDA_OUTCOME_CODE__OK_GESTORE_NO_PIEMONTE);
			}

			// impostazione del result code 
			result.setResultCode(EXECUTESWITCHWIZARDDOMANDA_OUTCOME_CODE__OK_GESTORE_NO_PIEMONTE);

			String idAlbo = "";
			if (theModel.getAppDataalbo() != null) {
				idAlbo = theModel.getAppDataalbo().getIdAlbo() + "";
			}

			if (ConvertUtil.checkIsNullOrEmpty(idAlbo)
					&& (idAlbo.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.GESTORE_PIEMONTE + "")
							|| idAlbo.equalsIgnoreCase(
									it.csi.taif.taifweb.business.dao.util.Constants.GESTORE_SUPERADMIN + ""))) {
				log.info("[executeSwitchWizardDomanda] idAlbo not null");
				result.setResultCode(EXECUTESWITCHWIZARDDOMANDA_OUTCOME_CODE__OK_GESTORE_PIEMONTE);
			} else if (theModel.getAppDataidSoggettoGestore() != null && theModel.getAppDataidSoggettoGestore()
					.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.GESTORE_PIEMONTE + "")) {
				log.info("[executeSwitchWizardDomanda] AppDataidSoggettoGestore not null");

				result.setResultCode(EXECUTESWITCHWIZARDDOMANDA_OUTCOME_CODE__OK_GESTORE_PIEMONTE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeSwitchWizardDomanda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeSwitchWizardDomanda1 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda1(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTESWITCHWIZARDDOMANDA1_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String EXECUTESWITCHWIZARDDOMANDA1_OUTCOME_CODE__IT = //NOSONAR  Reason:EIAS
				"IT"; //NOSONAR  Reason:EIAS
		final String EXECUTESWITCHWIZARDDOMANDA1_OUTCOME_CODE__NO_IT = //NOSONAR  Reason:EIAS
				"NO_IT"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1616704144) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("TAB SELEZIONATO *" + theModel.getSelectedTabKey() + "* - *" + theModel.getSelectedTabValue()
					+ "*");

			WizardDomandaStatus d = WizardDomandaStatus.getByName(theModel.getSelectedTabValue());
			try {
				switch (d) {
					case WIZARD_VAL_1_1 :
						this.executeInit(theModel);
						result.setResultCode(EXECUTESWITCHWIZARDDOMANDA1_OUTCOME_CODE__OK);
						break;
					case WIZARD_VAL_1_2 :
						this.validationMgr.checkAziendaSalvata(theModel.getAppDataidAzienda());
						this.executeInit1_2(theModel);
						boolean isIta = theModel
								.getAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale() != null
								&& theModel.getAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale()
										.equalsIgnoreCase(Constants.ID_STATO_ITALIA);
						if (isIta) {
							result.setResultCode(EXECUTESWITCHWIZARDDOMANDA1_OUTCOME_CODE__IT);
						} else {
							result.setResultCode(EXECUTESWITCHWIZARDDOMANDA1_OUTCOME_CODE__NO_IT);
						}
						break;
					default :
						this.executeInit(theModel);;
				}
			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, EXECUTESWITCHWIZARDDOMANDA1_OUTCOME_CODE__OK);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeSwitchWizardDomanda1] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAziendaInAaep definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults ricercaAziendaInAaep(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAAZIENDAINAAEP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String RICERCAAZIENDAINAAEP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2009313280) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				String codiceFiscaleAziendaImportata = theModel.getAppDataanagraficaAziendale().getCodiceFiscale();
				if (codiceFiscaleAziendaImportata != null && codiceFiscaleAziendaImportata.trim().length() > 0
						&& !codiceFiscaleAziendaImportata
								.contentEquals(it.csi.taif.taifweb.business.dao.util.Constants.blank)) {
					aziendaImportata = taifMgr.importAziendaFromAAEP(codiceFiscaleAziendaImportata);
					if (aziendaImportata != null && aziendaImportata.getAnagraficaAziendale()
							.getIdAzienda() == it.csi.taif.taifweb.business.dao.util.Constants.zeroInt) {
						caricaDatiAziendaImportata(aziendaImportata, theModel);
					}
				}
			}

			// impostazione del result code 
			result.setResultCode(RICERCAAZIENDAINAAEP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAziendaInAaep] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo expandAltreSediDatiAnagrafici2 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults expandAltreSediDatiAnagrafici2(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPANDALTRESEDIDATIANAGRAFICI2_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String EXPANDALTRESEDIDATIANAGRAFICI2_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1225392269) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String radioValue = theModel.getWidg_rbsDatiAnagraficiAltreSedi2();
			log.debug("----------------- Valore di RADIO --------------------");
			log.debug(radioValue);
			log.debug("------------------------------------------------------");
			if (EXPANDALTRESEDIDATIANAGRAFICI2_OUTCOME_CODE__SI.equals(radioValue)) {
				if (theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale() == null
						|| theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().isEmpty()) {

					ArrayList<Sede> sedi = new ArrayList<Sede>();
					sedi.add(ListUtils.addNuovaSede(1,
							this.taifMgr.getElencoTipoSedeAziendaNoSedeLegale(this.getVisibileOrdinFilter(theModel)),
							this.taifMgr.getElencoComuni()));
					theModel.setAppDataelencoSediDatiAnagraficiAnagrafeAziendale(sedi);

				} else {
					// trovo sedi
				}

			}
			result.setResultCode(radioValue);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::expandAltreSediDatiAnagrafici2] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoSedi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoSedi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOSEDI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2026020596) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (Sede sede : theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale()) {
				if (sede.getRownum() == rowNum) {
					theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().remove(sede);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOSEDI_OUTCOME_CODE__DELETE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoSedi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addSedeOperativa definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addSedeOperativa(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDSEDEOPERATIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2069231440) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().add(ListUtils.addNuovaSede(
					ListUtils.getMaxRowNumListaSedi(theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale()) + 1,
					this.taifMgr.getElencoTipoSedeAziendaNoSedeLegale(this.getVisibileOrdinFilter(theModel)),
					this.taifMgr.getElencoComuni())

			);
			// impostazione del result code 
			result.setResultCode(ADDSEDEOPERATIVA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addSedeOperativa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo deleteSedeOperativa definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults deleteSedeOperativa(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DELETESEDEOPERATIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1283057484) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(DELETESEDEOPERATIVA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::deleteSedeOperativa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaPersonaInAnagraficaFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults ricercaPersonaInAnagraficaFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAPERSONAINANAGRAFICAFR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String RICERCAPERSONAINANAGRAFICAFR_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-561091322) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatatitolareRappresentanteLegale().getNrsiMsa() != null
					&& StringUtils.isNotEmpty(theModel.getAppDatatitolareRappresentanteLegale().getNrsiMsa())
					&& StringUtils.isNotBlank(theModel.getAppDatatitolareRappresentanteLegale().getNrsiMsa())) {
				TitolareRappresentanteLegale titolare = this.taifMgr
						.findByNrSiMsaPersonaFrancese(theModel.getAppDatatitolareRappresentanteLegale().getNrsiMsa());
				theModel.setAppDatatitolareRappresentanteLegale(titolare);
				// impostazione del result code
				result.setResultCode(RICERCAPERSONAINANAGRAFICAFR_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".

				if (theModel.getAppDatatitolareRappresentanteLegale().getNrsiMsa() != null) {
					corsoQualificaFilter
							.setCodiceFiscale(theModel.getAppDatatitolareRappresentanteLegale().getNrsiMsa());
					theModel.setAppDataelencoCorsiSostenutiTitolareRappresentanteLegale(
							taifMgr.getCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));
					theModel.setAppDataelencoQualificheTitolareRappresentanteLegale(
							taifMgr.getAltriCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));
					theModel.setAppDataelencoRiconiscimentiTitolareRappresentanteLegale(
							taifMgr.getRiconoscimentiPersona(getCorsoQualificaFilter(theModel)));
				}
				theModel.setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
						titolare.getIdTitoloDiStudio());
				if (titolare.getDsComuneNascitaNoIta() != null) {
					theModel.getAppDatatitolareRappresentanteLegale()
							.setDsComuneNascitaNoIta(titolare.getDsComuneNascitaNoIta());
				}
				if (titolare.getDsComuneResidenzaNoIta() != null) {
					theModel.getAppDatatitolareRappresentanteLegale()
							.setDsComuneResidenzaNoIta(titolare.getDsComuneResidenzaNoIta());
				}
				if (titolare.getIdStatoNascita() != null) {
					theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
							titolare.getIdStatoNascita());
				}

				theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
						titolare.getIdStatoNascita());

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaPersonaInAnagraficaFr] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaPersonaInAnagrafica definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults ricercaPersonaInAnagrafica(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAPERSONAINANAGRAFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String RICERCAPERSONAINANAGRAFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R379614194) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			TitolareRappresentanteLegale titolare = this.taifMgr.findInAnagraficaByCodiceFiscalePersona(
					theModel.getAppDatatitolareRappresentanteLegale().getCodiceFiscale());
			theModel.setAppDatatitolareRappresentanteLegale(titolare);
			// impostazione del result code 
			result.setResultCode(RICERCAPERSONAINANAGRAFICA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			// value="%{appDatatitolareRappresentanteLegale.idTitoloDiStudio}"

			if (theModel.getAppDatatitolareRappresentanteLegale().getCodiceFiscale() != null) {

				corsoQualificaFilter
						.setCodiceFiscale(theModel.getAppDatatitolareRappresentanteLegale().getCodiceFiscale());
				theModel.setAppDataelencoCorsiSostenutiTitolareRappresentanteLegale(
						taifMgr.getCorsiSostenutiFromUnitaFormativa(getCorsoQualificaFilter(theModel)));
				theModel.setAppDataelencoQualificheTitolareRappresentanteLegale(
						taifMgr.getAltriCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));

				theModel.setAppDataelencoRiconiscimentiTitolareRappresentanteLegale(
						taifMgr.getRiconoscimentiPersona(getCorsoQualificaFilter(theModel)));
			}
			theModel.setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(titolare.getIdTitoloDiStudio());
			theModel.setAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale(titolare.getIdComuneNascita());
			theModel.setAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale(
					titolare.getIdComuneResidenza());
			theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(titolare.getIdStatoNascita());

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaPersonaInAnagrafica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeStatoNascita definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onChangeStatoNascita(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGESTATONASCITA_OUTCOME_CODE__IT = //NOSONAR  Reason:EIAS
				"IT"; //NOSONAR  Reason:EIAS
		final String ONCHANGESTATONASCITA_OUTCOME_CODE__NO_IT = //NOSONAR  Reason:EIAS
				"NO_IT"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1826547560) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (Constants.ID_STATO_ITALIA
					.equals(theModel.getAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale())) {
				result.setResultCode(ONCHANGESTATONASCITA_OUTCOME_CODE__IT);
			}

			else {
				result.setResultCode(ONCHANGESTATONASCITA_OUTCOME_CODE__NO_IT);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onChangeStatoNascita] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo expandAltriConducentiAzienda definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults expandAltriConducentiAzienda(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPANDALTRICONDUCENTIAZIENDA_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String EXPANDALTRICONDUCENTIAZIENDA_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R289763565) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(theModel.getWidg_rbsDatiAnagraficiAltroConducente());

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			this.setVisibility(theModel, DomandaViewHelper.initConduttoreScheda1_2(theModel));
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::expandAltriConducentiAzienda] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAltraPersonaInAnagrafica definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults ricercaAltraPersonaInAnagrafica(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAALTRAPERSONAINANAGRAFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String RICERCAALTRAPERSONAINANAGRAFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1193399498) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			TitolareRappresentanteLegale altroTitolare = this.taifMgr.findInAnagraficaByCodiceFiscalePersona(
					theModel.getAppDataaltroTitolareRappresentanteLegale().getCodiceFiscale());

			theModel.setAppDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale(
					altroTitolare.getIdStatoNascita());
			theModel.setAppDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale(
					altroTitolare.getIdComuneResidenza());
			theModel.setAppDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale(
					altroTitolare.getIdTitoloDiStudio());
			theModel.setAppDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale(
					altroTitolare.getIdComuneNascita());
			theModel.setAppDataaltroTitolareRappresentanteLegale(altroTitolare);

			// impostazione del result code 

			result.setResultCode(RICERCAALTRAPERSONAINANAGRAFICA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			// value="%{appDatatitolareRappresentanteLegale.idTitoloDiStudio}"

			if (theModel.getAppDataaltroTitolareRappresentanteLegale().getCodiceFiscale() != null) {
				corsoQualificaFilter
						.setCodiceFiscale(theModel.getAppDataaltroTitolareRappresentanteLegale().getCodiceFiscale());
				theModel.setAppDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale(
						taifMgr.getCorsiSostenutiFromUnitaFormativa(getCorsoQualificaFilter(theModel)));

				theModel.setAppDataelencoQualificheAltroTitolareRappresentanteLegale(
						taifMgr.getAltriCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));

				theModel.setAppDataelencoRiconiscimentiAltroTitolareRappresentanteLegale(
						taifMgr.getRiconoscimentiPersona(getCorsoQualificaFilter(theModel)));

			}

			// impostazione del result code 
			result.setResultCode(RICERCAALTRAPERSONAINANAGRAFICA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAltraPersonaInAnagrafica] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeStatoNascitaConduttoreAzienda definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onChangeStatoNascitaConduttoreAzienda(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGESTATONASCITACONDUTTOREAZIENDA_OUTCOME_CODE__IT = //NOSONAR  Reason:EIAS
				"IT"; //NOSONAR  Reason:EIAS
		final String ONCHANGESTATONASCITACONDUTTOREAZIENDA_OUTCOME_CODE__NO_IT = //NOSONAR  Reason:EIAS
				"NO_IT"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-457699927) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (Constants.ID_STATO_ITALIA
					.equals(theModel.getAppDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale())) {
				result.setResultCode(ONCHANGESTATONASCITACONDUTTOREAZIENDA_OUTCOME_CODE__IT);
			}

			else {
				result.setResultCode(ONCHANGESTATONASCITACONDUTTOREAZIENDA_OUTCOME_CODE__NO_IT);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onChangeStatoNascitaConduttoreAzienda] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeSwitchWizardDomanda2 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda2(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTESWITCHWIZARDDOMANDA2_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1588074993) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("TAB SELEZIONATO *" + theModel.getSelectedTabKey() + "* - *" + theModel.getSelectedTabValue()
					+ "*");
			// impostazione del result code 
			result.setResultCode(EXECUTESWITCHWIZARDDOMANDA2_OUTCOME_CODE__OK);

			WizardDomandaStatus d = WizardDomandaStatus.getByName(theModel.getSelectedTabValue());
			switch (d) {
				case WIZARD_VAL_2_1 :
					this.executeInit2_1(theModel);
					break;
				case WIZARD_VAL_2_2 :
					this.executeInit2_2(theModel);
					break;
				default :
					this.executeInit2_1(theModel);;
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeSwitchWizardDomanda2] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo expandAltriAlbiDatiSocioEconomici definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults expandAltriAlbiDatiSocioEconomici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPANDALTRIALBIDATISOCIOECONOMICI_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String EXPANDALTRIALBIDATISOCIOECONOMICI_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1399381096) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//result.setResultCode(theModel.getWidg_rbsDatiSocioEconomiciAltriAlbi());

			String radioValue = theModel.getWidg_rbsDatiSocioEconomiciAltriAlbi();
			ArrayList<Albo> albi = new ArrayList<Albo>();
			if (EXPANDALTRIALBIDATISOCIOECONOMICI_OUTCOME_CODE__SI.equals(radioValue)) {
				if (theModel.getAppDataelencoAltriAlbi() == null || theModel.getAppDataelencoAltriAlbi().isEmpty()) {
					albi.add(ListUtils.addNuovoAlbo(1));
					theModel.setAppDataelencoAltriAlbi(albi);
				} else {
					//for (Albo albo : theModel.getAppDataelencoAltriAlbi()) {
					//	albi.add(albo);
					//}
				}

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			ArrayList<FormaOrganizzativa> formaOrganizzativaList = theModel.getAppDataelencoFormeOrganizzative();
			if (formaOrganizzativaList != null) {
				for (FormaOrganizzativa formaOrganizzativa : formaOrganizzativaList) {
					if (formaOrganizzativa.getAltroVisibile()) {
						if ((formaOrganizzativa.getIdFormaOrganizzativa() == 5)
								|| (formaOrganizzativa.getIdFormaOrganizzativa() == 12)) {
							if (theModel.getAppDataassociazioniECertificazioni() != null
									&& theModel.getAppDataassociazioniECertificazioni().getAltro4() != null) {
								formaOrganizzativa
										.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro4());
							}
						}
						if ((formaOrganizzativa.getIdFormaOrganizzativa() == 6)
								|| (formaOrganizzativa.getIdFormaOrganizzativa() == 13)) {
							if (theModel.getAppDataassociazioniECertificazioni() != null
									&& theModel.getAppDataassociazioniECertificazioni().getAltro5() != null) {
								formaOrganizzativa
										.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro5());
							}
						}
						if ((formaOrganizzativa.getIdFormaOrganizzativa() == 7)
								|| (formaOrganizzativa.getIdFormaOrganizzativa() == 14)) {
							if (theModel.getAppDataassociazioniECertificazioni() != null
									&& theModel.getAppDataassociazioniECertificazioni().getAltro6() != null) {
								formaOrganizzativa
										.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro6());
							}
						}

					}
				}
			}

			result.setResultCode(radioValue);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::expandAltriAlbiDatiSocioEconomici] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAltriAlbi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAltriAlbi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOALTRIALBI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1908100645) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();
			//ArrayList<Albo> listToDelete = theModel.getAppDataelencoAltriAlbi();
			for (Albo albo : theModel.getAppDataelencoAltriAlbi()) {
				if (albo.getRownum() == rowNum) {
					theModel.getAppDataelencoAltriAlbi().remove(albo);
					break;
				}
			}
			// impostazione del result code 
			if (theModel.getAppDataelencoAltriAlbi().isEmpty()) {
				theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("NO");
			} else {
				theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("SI");
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpDatiSocioEconomiciAltriAlbi_selectedMultiPanel",
						"CpDomanda_mpDatiSocioEconomiciAltriAlbi_fpDatiSocioEconomiciAltriAlbi");
			}
			if (theModel.getAppDataelencoCertificazioni().isEmpty() || (theModel.getAppDataelencoCertificazioni()
					.size() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
					&& theModel.getAppDataelencoCertificazioni().get(0)
							.getIdCertificazione() == it.csi.taif.taifweb.business.dao.util.Constants.zeroInt)) {
				theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("NO");
			} else {
				theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("SI");
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_selectedMultiPanel",
						"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_fpDatiSocioEconomiciCertificazioniQualitaProcesso");
			}
			result.setResultCode(ONCLICKTABELLAELENCOALTRIALBI_OUTCOME_CODE__DELETE);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoAltriAlbi] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addAltroAlbo definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addAltroAlbo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDALTROALBO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2021573454) ENABLED START*/
			SoggettoGestoreFilter filter = new SoggettoGestoreFilter();
			filter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDataelencoAltriAlbi().add(
					ListUtils.addNuovoAlbo(ListUtils.getMaxRowNumListaAlbi(theModel.getAppDataelencoAltriAlbi()) + 1));
			// impostazione del result code 
			result.setResultCode(ADDALTROALBO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addAltroAlbo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo expandCertificazioniDatiSocioEconomici definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults expandCertificazioniDatiSocioEconomici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPANDCERTIFICAZIONIDATISOCIOECONOMICI_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String EXPANDCERTIFICAZIONIDATISOCIOECONOMICI_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1477431769) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String radioValue = theModel.getWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso();

			// impostazione del result code 
			result.setResultCode(theModel.getWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso());
			ArrayList<FormaOrganizzativa> formaOrganizzativaList = theModel.getAppDataelencoFormeOrganizzative();
			if (formaOrganizzativaList != null) {
				for (FormaOrganizzativa formaOrganizzativa : formaOrganizzativaList) {
					if (formaOrganizzativa.getAltroVisibile()) {
						if ((formaOrganizzativa.getIdFormaOrganizzativa() == 5)
								|| (formaOrganizzativa.getIdFormaOrganizzativa() == 12)) {
							if (theModel.getAppDataassociazioniECertificazioni() != null
									&& theModel.getAppDataassociazioniECertificazioni().getAltro4() != null) {
								formaOrganizzativa
										.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro4());
							}
						}
						if ((formaOrganizzativa.getIdFormaOrganizzativa() == 6)
								|| (formaOrganizzativa.getIdFormaOrganizzativa() == 13)) {
							if (theModel.getAppDataassociazioniECertificazioni() != null
									&& theModel.getAppDataassociazioniECertificazioni().getAltro5() != null) {
								formaOrganizzativa
										.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro5());
							}
						}
						if ((formaOrganizzativa.getIdFormaOrganizzativa() == 7)
								|| (formaOrganizzativa.getIdFormaOrganizzativa() == 14)) {
							if (theModel.getAppDataassociazioniECertificazioni() != null
									&& theModel.getAppDataassociazioniECertificazioni().getAltro6() != null) {
								formaOrganizzativa
										.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro6());
							}
						}

					}
				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			result.setResultCode(radioValue);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::expandCertificazioniDatiSocioEconomici] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoCertificazioniQualitaProcesso definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoCertificazioniQualitaProcesso(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOCERTIFICAZIONIQUALITAPROCESSO_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1465311643) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (Certificazione cert : theModel.getAppDataelencoCertificazioni()) {
				if (cert.getRownum() == rowNum) {
					theModel.getAppDataelencoCertificazioni().remove(cert);
					break;
				}
			}

			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOCERTIFICAZIONIQUALITAPROCESSO_OUTCOME_CODE__DELETE);

			if (theModel.getAppDataelencoAltriAlbi().isEmpty()) {
				theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("NO");
			} else {
				theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("SI");
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpDatiSocioEconomiciAltriAlbi_selectedMultiPanel",
						"CpDomanda_mpDatiSocioEconomiciAltriAlbi_fpDatiSocioEconomiciAltriAlbi");
			}
			if (theModel.getAppDataelencoCertificazioni().isEmpty()) {
				theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("NO");
			} else {
				theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("SI");
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_selectedMultiPanel",
						"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_fpDatiSocioEconomiciCertificazioniQualitaProcesso");
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoCertificazioniQualitaProcesso] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addCertificazioneQualitaProcesso definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addCertificazioneQualitaProcesso(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDCERTIFICAZIONEQUALITAPROCESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R567856250) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			/*theModel.getAppDataelencoCertificazioni()
					.add(this.dummyMgr.addNuovaCertificazione(theModel.getAppDataelencoCertificazioni()));*/
			theModel.getAppDataelencoCertificazioni()
					.add(ListUtils.addNuovaCertificazione(
							ListUtils.getMaxRowNumListaCertificazioni(theModel.getAppDataelencoCertificazioni()) + 1,
							this.taifMgr.getElencoTipoCertificazioni(visibileOrdinFilter)));

			// impostazione del result code 
			result.setResultCode(ADDCERTIFICAZIONEQUALITAPROCESSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::addCertificazioneQualitaProcesso] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeSwitchWizardDomanda3 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda3(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTESWITCHWIZARDDOMANDA3_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1559445842) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("TAB SELEZIONATO *" + theModel.getSelectedTabKey() + "* - *" + theModel.getSelectedTabValue()
					+ "*");
			// impostazione del result code 
			result.setResultCode(EXECUTESWITCHWIZARDDOMANDA3_OUTCOME_CODE__OK);

			WizardDomandaStatus d = WizardDomandaStatus.getByName(theModel.getSelectedTabValue());

			try {

				switch (d) {
					case WIZARD_VAL_3_1 :
						this.executeInit3_1(theModel);
						break;
					case WIZARD_VAL_3_2 :
						//this.validationMgr.checkScheda3_2(theModel.getAppDatatracciato());
						this.executeInit3_2(theModel);
						break;
					case WIZARD_VAL_3_3 :
						this.executeInit3_3(theModel);
					default :
						this.executeInit3_1(theModel);;
				}
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, EXECUTESWITCHWIZARDDOMANDA3_OUTCOME_CODE__OK);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeSwitchWizardDomanda3] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttivitaUltimoAnno definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttivitaUltimoAnno(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTIVITAULTIMOANNO_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2073669369) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (Attivita dto : theModel.getAppDataelencoAttivitaUltimoAnno()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoAttivitaUltimoAnno().remove(dto);
					break;
				}
			}

			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTIVITAULTIMOANNO_OUTCOME_CODE__DETAIL);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttivitaUltimoAnno] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttivitaUltimoAnno1 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno1(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTIVITAULTIMOANNO1_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTIVITAULTIMOANNO1_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-995291066) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getWidg_chbAttivitaUltimoAnno1()) {
				result.setResultCode(OPENATTIVITAULTIMOANNO1_OUTCOME_CODE__OPEN);
				this.setVisibilityConsultaIstanzaTaglioPresentate(theModel);
			} else {
				result.setResultCode(OPENATTIVITAULTIMOANNO1_OUTCOME_CODE__CLOSE);
			}

			//valorizzaCampoAltroPerAttivita(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttivitaUltimoAnno1] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo JumpToIstanzeTaglioPresentate definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults JumpToIstanzeTaglioPresentate(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String JUMPTOISTANZETAGLIOPRESENTATE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String JUMPTOISTANZETAGLIOPRESENTATE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1538081953) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.info("[CpBECpDomanda::JumpToIstanzeTaglioPresentate]BEGIN");

			// impostazione del result code 
			result.setResultCode(JUMPTOISTANZETAGLIOPRESENTATE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			log.info("[CpBECpDomanda::JumpToIstanzeTaglioPresentate]END");

			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::JumpToIstanzeTaglioPresentate] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttivitaUltimoAnno2 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno2(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTIVITAULTIMOANNO2_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTIVITAULTIMOANNO2_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-966661915) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttivitaUltimoAnno2()) {
				result.setResultCode(OPENATTIVITAULTIMOANNO2_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENATTIVITAULTIMOANNO2_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			valorizzaCampoAltroPerAttivita(theModel);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttivitaUltimoAnno2] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttivitaUltimoAnno3 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno3(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTIVITAULTIMOANNO3_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTIVITAULTIMOANNO3_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-938032764) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttivitaUltimoAnno3()) {
				result.setResultCode(OPENATTIVITAULTIMOANNO3_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENATTIVITAULTIMOANNO3_OUTCOME_CODE__CLOSE);
			} // modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			valorizzaCampoAltroPerAttivita(theModel);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttivitaUltimoAnno3] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttivitaUltimoAnno4 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno4(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTIVITAULTIMOANNO4_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTIVITAULTIMOANNO4_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-909403613) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<MaterialePropagazione> materialePropagazioneList = new ArrayList<MaterialePropagazione>();
			materialePropagazioneList = theModel.getAppDataelencoMaterialePropagazione();
			if (theModel.getWidg_chbAttivitaUltimoAnno4()) {
				if (!materialePropagazioneList.isEmpty() && theModel.getAppDataattivitaUltimoAnno4() != null) {
					for (MaterialePropagazione materialePropagazione : materialePropagazioneList) {
						if (materialePropagazione.getIdMaterialePropagazione() == 6) {
							materialePropagazione.setAltroVisibile(true);
							if (materialePropagazioneList.get(6).getAltro() != null) {
								materialePropagazione.setAltro(materialePropagazioneList.get(6).getAltro());
							}
							theModel.getAppDataattivitaUltimoAnno4().setAltro(materialePropagazione.getAltro());
						}
					}
				}
				AttivitaUltimoAnno4 attivitaUltimoAnno4 = new AttivitaUltimoAnno4();
				attivitaUltimoAnno4.setAltroVisibile(true);
				theModel.setAppDataattivitaUltimoAnno4(attivitaUltimoAnno4);
				theModel.setAppDataelencoMaterialePropagazione(materialePropagazioneList);
				result.setResultCode(OPENATTIVITAULTIMOANNO4_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENATTIVITAULTIMOANNO4_OUTCOME_CODE__CLOSE);
			}
			ArrayList<ArboricolturaDaLegno> arboricolturaList = new ArrayList<ArboricolturaDaLegno>();
			// impostazione del result code 
			arboricolturaList = theModel.getAppDataelencoArboricolturaDaLegno();
			if (theModel.getWidg_chbAttivitaUltimoAnno5()) {
				if (!arboricolturaList.isEmpty()) {
					for (ArboricolturaDaLegno arboricolturaDaLegno : arboricolturaList) {
						if (arboricolturaDaLegno.getIdTipoMateriale() == 8
								&& theModel.getAppDataattivitaUltimoAnno5() != null) {
							arboricolturaDaLegno.setAltroVisibile(true);
							theModel.getAppDataattivitaUltimoAnno5().setAltro(arboricolturaDaLegno.getAltro());

						}
					}
				}
			}
			theModel.setAppDataelencoMaterialePropagazione(materialePropagazioneList);
			theModel.setAppDataelencoArboricolturaDaLegno(arboricolturaList);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttivitaUltimoAnno4] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttivitaUltimoAnno5 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttivitaUltimoAnno5(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTIVITAULTIMOANNO5_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTIVITAULTIMOANNO5_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-880774462) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			ArrayList<ArboricolturaDaLegno> arboricolturaList = new ArrayList<ArboricolturaDaLegno>();
			// impostazione del result code 
			arboricolturaList = theModel.getAppDataelencoArboricolturaDaLegno();
			if (theModel.getWidg_chbAttivitaUltimoAnno5()) {
				result.setResultCode(OPENATTIVITAULTIMOANNO5_OUTCOME_CODE__OPEN);
				if (!arboricolturaList.isEmpty()) {
					for (ArboricolturaDaLegno arboricolturaDaLegno : arboricolturaList) {
						if (arboricolturaDaLegno.getIdTipoMateriale() == 8
								&& theModel.getAppDataattivitaUltimoAnno5() != null) {
							arboricolturaDaLegno.setAltroVisibile(true);
							theModel.getAppDataattivitaUltimoAnno5().setAltro(arboricolturaDaLegno.getAltro());
						}
					}
				}
				AttivitaUltimoAnno5 attivitaUltimoAnno5 = new AttivitaUltimoAnno5();
				attivitaUltimoAnno5.setAltroVisibile(true);
				this.setVisibilityConsultaIstanzaTaglioPresentate(theModel);
				theModel.setAppDataattivitaUltimoAnno5(attivitaUltimoAnno5);
				result.setResultCode(OPENATTIVITAULTIMOANNO5_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENATTIVITAULTIMOANNO5_OUTCOME_CODE__CLOSE);
			}

			ArrayList<MaterialePropagazione> materialePropagazioneList = new ArrayList<MaterialePropagazione>();
			materialePropagazioneList = theModel.getAppDataelencoMaterialePropagazione();
			if (theModel.getWidg_chbAttivitaUltimoAnno4() && theModel.getAppDataattivitaUltimoAnno4() != null) {
				if (!materialePropagazioneList.isEmpty()) {
					for (MaterialePropagazione materialePropagazione : materialePropagazioneList) {
						if (materialePropagazione.getIdMaterialePropagazione() == 6) {
							materialePropagazione.setAltroVisibile(true);
							materialePropagazione.setAltro(materialePropagazioneList.get(6).getAltro());
							theModel.getAppDataattivitaUltimoAnno4().setAltro(materialePropagazione.getAltro());
						}
					}
				}
			}
			theModel.setAppDataelencoMaterialePropagazione(materialePropagazioneList);
			theModel.setAppDataelencoArboricolturaDaLegno(arboricolturaList);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttivitaUltimoAnno5] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoArboricolturaDaLegno definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoArboricolturaDaLegno(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOARBORICOLTURADALEGNO_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-520689836) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (ArboricolturaDaLegno dto : theModel.getAppDataelencoArboricolturaDaLegno()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoArboricolturaDaLegno().remove(dto);
					break;
				}
			}

			if (theModel.getAppDataelencoArboricolturaDaLegno().size() > 0) {
				theModel.setWidg_chbAttivitaUltimoAnno5(true);
			} else {
				theModel.setWidg_chbAttivitaUltimoAnno5(false);
				ActionContext.getContext().getSession().put("CpDomanda_mpAttivitaUltimoAnno5_selectedMultiPanel", null);
			}
			if (theModel.getAppDatagestioneAttivitaUltimoAnno() != null) {
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita1() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita1().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno1(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno1(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita2() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita2().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno2(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno2(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita3() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita3().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno3(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno3(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita4() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita4().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno4(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno4(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita6() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita6().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno6(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno6(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita7() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita7().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno7(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno7(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita8() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita8().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno8(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno8(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita9() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita9().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno9(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno9(false);
					}
				}
			}
			// impostazione del result code 

			result.setResultCode(ONCLICKTABELLAELENCOARBORICOLTURADALEGNO_OUTCOME_CODE__DELETE);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoArboricolturaDaLegno] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addArboricolturaDaLegno definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addArboricolturaDaLegno(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDARBORICOLTURADALEGNO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R335612689) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoArboricolturaDaLegno()
					.add(ListUtils.addNuovaArboricolturaDaLegno(
							ListUtils.getMaxRowNumListaArboricolturaDaLegno(
									theModel.getAppDataelencoArboricolturaDaLegno()) + 1,
							this.taifMgr.getElencoMateriali(this.getMaterialeFilter(theModel, "A"))));
			// impostazione del result code 
			result.setResultCode(ADDARBORICOLTURADALEGNO_OUTCOME_CODE__OK);
			valorizzaCampoAltroPerAttivita(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addArboricolturaDaLegno] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo expandLavoriPA definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults expandLavoriPA(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPANDLAVORIPA_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String EXPANDLAVORIPA_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R736601503) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(theModel.getWidg_rbsAttivitaLavoriPA());

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::expandLavoriPA] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoLavoriPA definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoLavoriPA(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOLAVORIPA_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1639848661) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (LavoroPA lavoro : theModel.getAppDataelencoLavoriPA()) {
				if (lavoro.getRownum() == rowNum) {
					theModel.getAppDataelencoLavoriPA().remove(lavoro);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOLAVORIPA_OUTCOME_CODE__DELETE);

			if (theModel.getAppDataelencoLavoriPA().isEmpty()) {
				theModel.setWidg_rbsAttivitaLavoriPA("NO");
			} else {
				theModel.setWidg_rbsAttivitaLavoriPA("SI");
				ActionContext.getContext().getSession().put("CpDomanda_mpAttivitaLavoriPA_selectedMultiPanel",
						"CpDomanda_mpAttivitaLavoriPA_fpAttivitaLavoriPA");
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoLavoriPA] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addLavoroPA definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addLavoroPA(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDLAVOROPA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-482263220) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoLavoriPA()
					.add(ListUtils.addNuovoLavoroPA(
							ListUtils.getMaxRowNumListaLavoriPA(theModel.getAppDataelencoLavoriPA()) + 1,
							this.taifMgr.getElencoTipoLavoroPA()));
			// impostazione del result code 
			result.setResultCode(ADDLAVOROPA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addLavoroPA] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo expandLegnami definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults expandLegnami(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPANDLEGNAMI_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String EXPANDLEGNAMI_OUTCOME_CODE__SI_FR = //NOSONAR  Reason:EIAS
				"SI_FR"; //NOSONAR  Reason:EIAS
		final String EXPANDLEGNAMI_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R659119814) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String r = theModel.getWidg_rbsAttivitaLegname();
			log.debug("------------- RADIO ---------- " + r);
			// impostazione del result code

			String resultCode = EXPANDLEGNAMI_OUTCOME_CODE__NO;

			if (Constants.SI.equals(r)) {
				if (Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
					resultCode = EXPANDLEGNAMI_OUTCOME_CODE__SI;
				} else {
					resultCode = EXPANDLEGNAMI_OUTCOME_CODE__SI_FR;
				}
			}

			result.setResultCode(resultCode);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::expandLegnami] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoLegname definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoLegname(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOLEGNAME_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1543571540) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			this.onClickTabellaElencoLegnameGeneric(theModel);
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOLEGNAME_OUTCOME_CODE__DELETE);

			if (theModel.getAppDataelencoLegnamiAssortimentiTrattati().isEmpty()) {
				theModel.setWidg_rbsAttivitaLegname(Constants.NO);
			} else {
				theModel.setWidg_rbsAttivitaLegname(Constants.SI);
				ActionContext.getContext().getSession().put("CpDomanda_mpAttivitaLegname_selectedMultiPanel",
						"CpDomanda_mpAttivitaLegname_fpAttivitaLegname");
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoLegname] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addLegname definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addLegname(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDLEGNAME_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-663317129) ENABLED START*/

			this.addLegnameGenerico(theModel);

			// impostazione del result code 

			result.setResultCode(ADDLEGNAME_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addLegname] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoLegnameFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoLegnameFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOLEGNAMEFR_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1310421224) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			this.onClickTabellaElencoLegnameGeneric(theModel);
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOLEGNAMEFR_OUTCOME_CODE__DELETE);

			ArrayList<LegnameAssortimentoTrattato> legnamiAssortimentoTrattato = taifMgr
					.getElencoLegnami(visibileOrdinFilter, theModel.getAppDataidAzienda());
			if (legnamiAssortimentoTrattato.size() == 1
					&& legnamiAssortimentoTrattato.get(0).getIdAssortimento() == 0) {
				theModel.setWidg_rbsAttivitaLegname(Constants.NO);
			} else {
				theModel.setWidg_rbsAttivitaLegname(Constants.SI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoLegnameFr] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addLegnameFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addLegnameFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDLEGNAMEFR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2090712757) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			this.addLegnameGenerico(theModel);
			// impostazione del result code 
			result.setResultCode(ADDLEGNAMEFR_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addLegnameFr] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openStruttureCapannoni definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openStruttureCapannoni(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENSTRUTTURECAPANNONI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENSTRUTTURECAPANNONI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-98383410) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbStruttureCapannoni()) {
				result.setResultCode(OPENSTRUTTURECAPANNONI_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENSTRUTTURECAPANNONI_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openStruttureCapannoni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoCapannoni definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoCapannoni(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOCAPANNONI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1739747406) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (Capannone dto : theModel.getAppDataelencoCapannoni()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoCapannoni().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOCAPANNONI_OUTCOME_CODE__DELETE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			valorizzaCheckBoxForSyrutture(theModel);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoCapannoni] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addCapannone definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addCapannone(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDCAPANNONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-960430695) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoCapannoni()
					.add(ListUtils.addNuovoCapannone(
							(ListUtils.getMaxRowNumListaCapannoni(theModel.getAppDataelencoCapannoni()) + 1),
							this.getTaifMgr().getElencoFunzioniCapannone(this.getVisibileOrdinFilter(theModel))));
			// impostazione del result code 
			result.setResultCode(ADDCAPANNONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addCapannone] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openStrutturePiazzaliStoccaggio definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openStrutturePiazzaliStoccaggio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENSTRUTTUREPIAZZALISTOCCAGGIO_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENSTRUTTUREPIAZZALISTOCCAGGIO_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-724596384) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbStrutturePiazzaliStoccaggio()) {
				result.setResultCode(OPENSTRUTTUREPIAZZALISTOCCAGGIO_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENSTRUTTUREPIAZZALISTOCCAGGIO_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openStrutturePiazzaliStoccaggio] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoPiazzaliStoccaggio definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoPiazzaliStoccaggio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOPIAZZALISTOCCAGGIO_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1688525828) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (PiazzaleStoccaggio dto : theModel.getAppDataelencoPiazzaliStoccaggio()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoPiazzaliStoccaggio().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOPIAZZALISTOCCAGGIO_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForSyrutture(theModel);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoPiazzaliStoccaggio] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addPiazzaleStoccaggio definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addPiazzaleStoccaggio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDPIAZZALESTOCCAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1830970499) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoPiazzaliStoccaggio()
					.add(this.taifMgr.addNuovoPiazzaleStoccaggio(theModel.getAppDataelencoPiazzaliStoccaggio()));
			// impostazione del result code 
			result.setResultCode(ADDPIAZZALESTOCCAGGIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addPiazzaleStoccaggio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeSwitchWizardDomanda5 definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults executeSwitchWizardDomanda5(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTESWITCHWIZARDDOMANDA5_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1502187540) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("TAB SELEZIONATO *" + theModel.getSelectedTabKey() + "* - *" + theModel.getSelectedTabValue()
					+ "*");

			WizardDomandaStatus d = WizardDomandaStatus.getByName(theModel.getSelectedTabValue());
			switch (d) {
				case WIZARD_VAL_5_1 :
					this.executeInit5_1(theModel);
					break;
				case WIZARD_VAL_5_2 :
					this.executeInit5_2(theModel);
					break;
				default :
					this.executeInit5_1(theModel);;
			}

			// impostazione del result code 
			result.setResultCode(EXECUTESWITCHWIZARDDOMANDA5_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeSwitchWizardDomanda5] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureCascoForestale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureCascoForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATURECASCOFORESTALE_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATURECASCOFORESTALE_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R560410728) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureCascoForestale()) {
				result.setResultCode(OPENATTREZZATURECASCOFORESTALE_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENATTREZZATURECASCOFORESTALE_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureCascoForestale] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureCascoForestale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureCascoForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATURECASCOFORESTALE_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-43494130) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MezzoDiProtezioneIndividuale dto : theModel.getAppDataelencoCaschiForestaliAttrezzature()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoCaschiForestaliAttrezzature().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATURECASCOFORESTALE_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForDpi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureCascoForestale] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addCascoForestale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addCascoForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDCASCOFORESTALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1667276) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoCaschiForestaliAttrezzature()
					.add(ListUtils.addNuovoMezzoDiProtezioneIndividuale(
							ListUtils.getMaxRowNumListaMezziDiProtezioneIndividuale(
									theModel.getAppDataelencoCaschiForestaliAttrezzature()) + 1,
							this.taifMgr.getElencoTipoDpi()));
			// impostazione del result code 
			result.setResultCode(ADDCASCOFORESTALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addCascoForestale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureScarponiRinforzati definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureScarponiRinforzati(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATURESCARPONIRINFORZATI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATURESCARPONIRINFORZATI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1180174171) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureScarponiRinforzati()) {
				result.setResultCode(OPENATTREZZATURESCARPONIRINFORZATI_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENATTREZZATURESCARPONIRINFORZATI_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureScarponiRinforzati] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureScarponiRinforzati definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureScarponiRinforzati(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATURESCARPONIRINFORZATI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1045063937) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MezzoDiProtezioneIndividuale dto : theModel.getAppDataelencoScarponiRinforzatiAttrezzature()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoScarponiRinforzatiAttrezzature().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATURESCARPONIRINFORZATI_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForDpi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureScarponiRinforzati] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addScarponeRinforzato definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addScarponeRinforzato(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDSCARPONERINFORZATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1956572675) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoScarponiRinforzatiAttrezzature()
					.add(ListUtils.addNuovoMezzoDiProtezioneIndividuale(
							ListUtils.getMaxRowNumListaMezziDiProtezioneIndividuale(
									theModel.getAppDataelencoScarponiRinforzatiAttrezzature()) + 1,
							this.taifMgr.getElencoTipoDpi()));
			// impostazione del result code 
			result.setResultCode(ADDSCARPONERINFORZATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addScarponeRinforzato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzaturePantaloniAntitaglio definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzaturePantaloniAntitaglio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREPANTALONIANTITAGLIO_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREPANTALONIANTITAGLIO_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R28781202) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzaturePantaloniAntitaglio()) {
				result.setResultCode(OPENATTREZZATUREPANTALONIANTITAGLIO_OUTCOME_CODE__OPEN);
			} else {
				result.setResultCode(OPENATTREZZATUREPANTALONIANTITAGLIO_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzaturePantaloniAntitaglio] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzaturePantaloniAntitaglio definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzaturePantaloniAntitaglio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREPANTALONIANTITAGLIO_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R135331244) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MezzoDiProtezioneIndividuale dto : theModel.getAppDataelencoPantaloniAntitaglioAttrezzature()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoPantaloniAntitaglioAttrezzature().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREPANTALONIANTITAGLIO_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForDpi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzaturePantaloniAntitaglio] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addPantaloneAntitaglio definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addPantaloneAntitaglio(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDPANTALONEANTITAGLIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-590737102) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoPantaloniAntitaglioAttrezzature()
					.add(ListUtils.addNuovoMezzoDiProtezioneIndividuale(
							ListUtils.getMaxRowNumListaMezziDiProtezioneIndividuale(
									theModel.getAppDataelencoPantaloniAntitaglioAttrezzature()) + 1,
							this.taifMgr.getElencoTipoDpi()));
			// impostazione del result code 
			result.setResultCode(ADDPANTALONEANTITAGLIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addPantaloneAntitaglio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchinaTrattrici definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaTrattrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINATRATTRICI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINATRATTRICI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1997075996) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setTipoMezzo(Constants.trattrice);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catZero);
			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchinaTrattrici()) {
				result.setResultCode(OPENATTREZZATUREMACCHINATRATTRICI_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineTrattrici().isEmpty()) {

					theModel.getAppDataelencoMacchineTrattrici()
							.add(ListUtils.addNuovaMacchinaTratttice(1,
									this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter),
									this.taifMgr.getElencoTipoNoleggi()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINATRATTRICI_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMacchinaTrattrici] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineTrattrici definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineTrattrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINETRATTRICI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R125726906) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineTrattrici()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineTrattrici().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINETRATTRICI_OUTCOME_CODE__DELETE);

			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineTrattrici] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaTrattrice definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaTrattrice(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINATRATTRICE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-645347140) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setTipoMezzo(Constants.trattrice);

			theModel.getAppDataelencoMacchineTrattrici()
					.add(ListUtils.addNuovaMacchinaTratttice(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineTrattrici()),
							this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter),
							this.taifMgr.getElencoTipoNoleggi()));
			//this.taifMgr.getElencoTipoTrazioni(this.getVisibileOrdinFilter(theModel)),
			// impostazione del result code 
			result.setResultCode(ADDMACCHINATRATTRICE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaTrattrice] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchineSpeciali definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineSpeciali(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINESPECIALI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINESPECIALI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2022101912) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.speciali);

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchineSpeciali()) {
				result.setResultCode(OPENATTREZZATUREMACCHINESPECIALI_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineSpeciali().isEmpty()) {
					theModel.getAppDataelencoMacchineSpeciali()
							.add(ListUtils.addNuovaMacchinaSpeciale(1,
									this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
									this.taifMgr.getElencoTipoNoleggi()));
					//this.taifMgr.getElencoTipoMezzo(this.getVisibileOrdinFilter(theModel)),
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINESPECIALI_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMacchineSpeciali] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineSpeciali definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineSpeciali(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINESPECIALI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1740881806) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			//String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineSpeciali()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineSpeciali().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINESPECIALI_OUTCOME_CODE__DELETE);

			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineSpeciali] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaSpeciale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaSpeciale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINASPECIALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-195929388) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.speciali);

			theModel.getAppDataelencoMacchineSpeciali().add(ListUtils.addNuovaMacchinaSpeciale(
					ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineSpeciali()),
					this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter), this.taifMgr.getElencoTipoNoleggi()));
			//this.taifMgr.getElencoTipoMezzo(this.getVisibileOrdinFilter(theModel)),
			// impostazione del result code 
			result.setResultCode(ADDMACCHINASPECIALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaSpeciale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchineMovimentoATerra definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineMovimentoATerra(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINEMOVIMENTOATERRA_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINEMOVIMENTOATERRA_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1644468309) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catTerra);
			tipoMezzoFilter.setTipoMezzo(Constants.escavatore);

			//Escavatore
			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchineMovimentoATerra()) {
				result.setResultCode(OPENATTREZZATUREMACCHINEMOVIMENTOATERRA_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineMovimentoTerra().isEmpty()) {
					theModel.getAppDataelencoMacchineMovimentoTerra()
							.add(ListUtils.addNuovaMacchinaMovimentoTerra(1,
									this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
									this.taifMgr.getElencoTipoNoleggi(),
									this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINEMOVIMENTOATERRA_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMacchineMovimentoATerra] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineMovimentoATerra definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineMovimentoATerra(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINEMOVIMENTOATERRA_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R850087535) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineMovimentoTerra()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineMovimentoTerra().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINEMOVIMENTOATERRA_OUTCOME_CODE__DELETE);

			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineMovimentoATerra] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaMovimentoATerra definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaMovimentoATerra(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINAMOVIMENTOATERRA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2111393171) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catTerra);
			tipoMezzoFilter.setTipoMezzo(Constants.escavatore);

			theModel.getAppDataelencoMacchineMovimentoTerra().add(ListUtils.addNuovaMacchinaMovimentoTerra(
					ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineMovimentoTerra()),
					this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter), this.taifMgr.getElencoTipoNoleggi(),
					this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINAMOVIMENTOATERRA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaMovimentoATerra] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchinaRimorchi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaRimorchi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINARIMORCHI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINARIMORCHI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R684437777) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setTipoMezzo(Constants.rimorchio);
			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchinaRimorchi()) {
				result.setResultCode(OPENATTREZZATUREMACCHINARIMORCHI_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineRimorchi().isEmpty()) {
					theModel.getAppDataelencoMacchineRimorchi()
							.add(ListUtils.addNuovaMacchinaRimorchi(0, this.taifMgr.getElencoTipoNoleggi(),
									this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINARIMORCHI_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMacchinaRimorchi] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineRimorchi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineRimorchi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINERIMORCHI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1869780301) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineRimorchi()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineRimorchi().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINERIMORCHI_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineRimorchi] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaRimorchi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaRimorchi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINARIMORCHI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R602892405) ENABLED START*/
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setTipoMezzo(Constants.rimorchio);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catZero);
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoMacchineRimorchi()
					.add(ListUtils.addNuovaMacchinaRimorchi(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineRimorchi()),
							this.taifMgr.getElencoTipoNoleggi(),
							this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINARIMORCHI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaRimorchi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchinaVerricelli definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaVerricelli(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINAVERRICELLI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINAVERRICELLI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1139371921) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchinaVerricelli()) {
				result.setResultCode(OPENATTREZZATUREMACCHINAVERRICELLI_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineVerricelli().isEmpty()) {
					theModel.getAppDataelencoMacchineVerricelli()
							.add(ListUtils.addNuovaMacchinaVerricello(0, this.taifMgr.getElencoTipoNoleggi()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINAVERRICELLI_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureMacchinaVerricelli] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineVerricelli definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineVerricelli(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINEVERRICELLI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R978348433) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineVerricelli()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineVerricelli().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINEVERRICELLI_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineVerricelli] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaVerricelli definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaVerricelli(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINAVERRICELLI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2099904211) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoMacchineVerricelli()
					.add(ListUtils.addNuovaMacchinaVerricello(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineVerricelli()),
							this.taifMgr.getElencoTipoNoleggi()));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINAVERRICELLI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaVerricelli] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchinaPle definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaPle(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINAPLE_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINAPLE_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R143725715) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchinaPle()) {
				result.setResultCode(OPENATTREZZATUREMACCHINAPLE_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchinePle().isEmpty()) {
					theModel.getAppDataelencoMacchinePle()
							.add(ListUtils.addNuovaMacchinaPle(0, this.taifMgr.getElencoTipoNoleggi()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINAPLE_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureMacchinaPle] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchinePle definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchinePle(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINEPLE_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1830396495) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchinePle()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchinePle().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINEPLE_OUTCOME_CODE__DELETE);

			valorizzaCheckBoxForMezzi(theModel);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchinePle] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaPle definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaPle(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINAPLE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-381071697) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoMacchinePle()
					.add(ListUtils.addNuovaMacchinaPle(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchinePle()),
							this.taifMgr.getElencoTipoNoleggi()));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINAPLE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaPle] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchinaTrinciaForestale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaTrinciaForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINATRINCIAFORESTALE_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINATRINCIAFORESTALE_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1122897833) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchinaTrinciaForestale()) {
				result.setResultCode(OPENATTREZZATUREMACCHINATRINCIAFORESTALE_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineTrinciaForestali().isEmpty()) {
					theModel.getAppDataelencoMacchineTrinciaForestali()
							.add(ListUtils.addNuovaMacchinaTrinciaForestale(0, this.taifMgr.getElencoTipoNoleggi()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINATRINCIAFORESTALE_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMacchinaTrinciaForestale] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineTrinciaForestale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineTrinciaForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINETRINCIAFORESTALE_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R458811385) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineTrinciaForestali()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineTrinciaForestali().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINETRINCIAFORESTALE_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineTrinciaForestale] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaTrinciaForestale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaTrinciaForestale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINATRINCIAFORESTALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1152777285) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoMacchineTrinciaForestali()
					.add(ListUtils.addNuovaMacchinaTrinciaForestale(
							ListUtils.getMaxRowNumListaMacchinaMezzo(
									theModel.getAppDataelencoMacchineTrinciaForestali()),
							this.taifMgr.getElencoTipoNoleggi()));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINATRINCIAFORESTALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaTrinciaForestale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchineSegherieMobili definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineSegherieMobili(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINESEGHERIEMOBILI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINESEGHERIEMOBILI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1132495350) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catSegherie);
			// impostazione del result code 

			if (theModel.getWidg_chbAttrezzatureMacchineSegherieMobili()) {
				result.setResultCode(OPENATTREZZATUREMACCHINESEGHERIEMOBILI_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineSegheriaMobile().isEmpty()) {
					visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
					theModel.getAppDataelencoMacchineSegheriaMobile()
							.add(ListUtils.addNuovaMacchinaSegheriaMobile(0,
									this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
									this.taifMgr.getElencoTipoAlimentazione(visibileOrdinFilter),
									this.taifMgr.getElencoTipoNoleggi()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINESEGHERIEMOBILI_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMacchineSegherieMobili] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineSegherieMobili definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineSegherieMobili(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINESEGHERIEMOBILI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1383964828) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineSegheriaMobile()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineSegheriaMobile().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINESEGHERIEMOBILI_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineSegherieMobili] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaSegherieMobili definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaSegherieMobili(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINASEGHERIEMOBILI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1205418786) ENABLED START*/
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catSegherie);

			// inserire qui la logica applicativa da eseguire:
			visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
			theModel.getAppDataelencoMacchineSegheriaMobile().add(ListUtils.addNuovaMacchinaSegheriaMobile(
					ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineSegheriaMobile()),
					this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
					this.taifMgr.getElencoTipoAlimentazione(visibileOrdinFilter), this.taifMgr.getElencoTipoNoleggi()));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINASEGHERIEMOBILI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaSegherieMobili] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchineGruACavo definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineGruACavo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINEGRUACAVO_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINEGRUACAVO_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1582643498) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catGru);
			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchineGruACavo()) {
				result.setResultCode(OPENATTREZZATUREMACCHINEGRUACAVO_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineGruACavo().isEmpty()) {
					visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
					theModel.getAppDataelencoMacchineGruACavo()
							.add(ListUtils.addNuovaMacchinaGruACavo(0,
									this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
									this.taifMgr.getElencoTipoNoleggi(),
									this.taifMgr.getElencoTipoCarrello(visibileOrdinFilter)));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINEGRUACAVO_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMacchineGruACavo] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineGruACavo definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineGruACavo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINEGRUACAVO_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1050659920) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineGruACavo()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineGruACavo().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINEGRUACAVO_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineGruACavo] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaGruACavo definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaGruACavo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINAGRUACAVO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-771634670) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catGru);
			visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
			theModel.getAppDataelencoMacchineGruACavo().add(ListUtils.addNuovaMacchinaGruACavo(
					ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineGruACavo()),
					this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter), this.taifMgr.getElencoTipoNoleggi(),
					this.taifMgr.getElencoTipoCarrello(visibileOrdinFilter)));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINAGRUACAVO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaGruACavo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchineCippatrici definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineCippatrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINECIPPATRICI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINECIPPATRICI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R932964354) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchineCippatrici()) {
				result.setResultCode(OPENATTREZZATUREMACCHINECIPPATRICI_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineCippatrici().isEmpty()) {
					theModel.getAppDataelencoMacchineCippatrici()
							.add(ListUtils.addNuovaMacchinaCippatrice(0,
									this.taifMgr.getElencoTipoAlimentazione(this.getVisibileOrdinFilter(theModel)),
									this.taifMgr.getElencoTipoNoleggi()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINECIPPATRICI_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureMacchineCippatrici] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineCippatrici definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineCippatrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINECIPPATRICI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R797854120) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineCippatrici()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineCippatrici().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINECIPPATRICI_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineCippatrici] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaCippatrici definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaCippatrici(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINACIPPATRICI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1919409898) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoMacchineCippatrici()
					.add(ListUtils.addNuovaMacchinaCippatrice(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineCippatrici()),
							this.taifMgr.getElencoTipoAlimentazione(this.getVisibileOrdinFilter(theModel)),
							this.taifMgr.getElencoTipoNoleggi()));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINACIPPATRICI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaCippatrici] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMezziDiTrasporto definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMezziDiTrasporto(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMEZZIDITRASPORTO_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMEZZIDITRASPORTO_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1252726204) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.mezzi);

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMezziDiTrasporto()) {
				result.setResultCode(OPENATTREZZATUREMEZZIDITRASPORTO_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMezziDiTrasporto().isEmpty()) {
					theModel.getAppDataelencoMezziDiTrasporto()
							.add(ListUtils.addNuovoMezzoDiTrasporto(0,
									this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
									this.taifMgr.getElencoTipoNoleggi()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMEZZIDITRASPORTO_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMezziDiTrasporto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMezziDiTrasporto definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMezziDiTrasporto(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMEZZIDITRASPORTO_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R720742626) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMezziDiTrasporto()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMezziDiTrasporto().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMEZZIDITRASPORTO_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezzi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMezziDiTrasporto] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMezziDiTrasporto definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMezziDiTrasporto(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMEZZIDITRASPORTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1171180832) ENABLED START*/
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.mezzi);

			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoMezziDiTrasporto().add(ListUtils.addNuovoMezzoDiTrasporto(
					ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMezziDiTrasporto()),
					this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter), this.taifMgr.getElencoTipoNoleggi()));
			// impostazione del result code 
			result.setResultCode(ADDMEZZIDITRASPORTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMezziDiTrasporto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureAltriMezzi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureAltriMezzi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREALTRIMEZZI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREALTRIMEZZI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R874899731) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.altroMezzo);
			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureAltriMezzi()) {
				result.setResultCode(OPENATTREZZATUREALTRIMEZZI_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoAltriMezzi().isEmpty()) {
					visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
					theModel.getAppDataelencoAltriMezzi()
							.add(ListUtils.addNuovaMacchinaAltriMezzi(0,
									this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
									this.taifMgr.getElencoTipoNoleggi(),
									this.taifMgr.getElencoTipoCarrello(visibileOrdinFilter),
									this.taifMgr.getElencoTipoAlimentazione(visibileOrdinFilter),
									this.taifMgr.getElencoTipoTrazioni(visibileOrdinFilter)));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREALTRIMEZZI_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureAltriMezzi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureAltriMezzi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureAltriMezzi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREALTRIMEZZI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2014269625) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoAltriMezzi()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoAltriMezzi().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREALTRIMEZZI_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezzi(theModel);
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureAltriMezzi] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addAltriMezzi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addAltriMezzi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDALTRIMEZZI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1689254775) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catZero);
			visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
			theModel.getAppDataelencoAltriMezzi().add(ListUtils.addNuovaMacchinaAltriMezzi(
					ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoAltriMezzi()),
					this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter), this.taifMgr.getElencoTipoNoleggi(),
					this.taifMgr.getElencoTipoCarrello(visibileOrdinFilter),
					this.taifMgr.getElencoTipoAlimentazione(visibileOrdinFilter),
					this.taifMgr.getElencoTipoTrazioni(visibileOrdinFilter)));
			// impostazione del result code 
			result.setResultCode(ADDALTRIMEZZI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addAltriMezzi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchineSpecialiFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineSpecialiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINESPECIALIFR_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINESPECIALIFR_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2082136060) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.speciales);

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchineSpecialiFr()) {
				result.setResultCode(OPENATTREZZATUREMACCHINESPECIALIFR_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineSpecialiFr().isEmpty()) {
					theModel.getAppDataelencoMacchineSpecialiFr()
							.add(ListUtils.addNuovaMacchinaSpeciale(1,
									this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
									this.taifMgr.getElencoTipoNoleggiFrancese()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINESPECIALIFR_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureMacchineSpecialiFr] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineSpecialiFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineSpecialiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINESPECIALIFR_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1947025826) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineSpecialiFr()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineSpecialiFr().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINESPECIALIFR_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezziFrancesi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineSpecialiFr] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaSpecialeFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaSpecialeFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINASPECIALEFR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R392307560) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//Machines spéciales
			//Machines de terrassement
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.speciales);

			theModel.getAppDataelencoMacchineSpecialiFr()
					.add(ListUtils.addNuovaMacchinaSpeciale(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineSpecialiFr()),
							this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
							this.taifMgr.getElencoTipoNoleggiFrancese()));

			// impostazione del result code 
			result.setResultCode(ADDMACCHINASPECIALEFR_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaSpecialeFr] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchineMovimentoATerraFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchineMovimentoATerraFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINEMOVIMENTOATERRAFR_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINEMOVIMENTOATERRAFR_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-512031575) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = new TipoMezzoFilter();
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.terrassement);
			tipoMezzoFilter.setTipoMezzo(it.csi.taif.taifweb.business.dao.util.Constants.Chargeur);

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchineMovimentoATerraFr()) {
				result.setResultCode(OPENATTREZZATUREMACCHINEMOVIMENTOATERRAFR_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineMovimentoTerraFr().isEmpty()) {
					theModel.getAppDataelencoMacchineMovimentoTerraFr()
							.add(ListUtils.addNuovaMacchinaMovimentoTerra(1,
									this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
									this.taifMgr.getElencoTipoNoleggiFrancese(),
									this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINEMOVIMENTOATERRAFR_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::openAttrezzatureMacchineMovimentoATerraFr] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineMovimentoATerraFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineMovimentoATerraFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINEMOVIMENTOATERRAFR_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R592223299) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineMovimentoTerraFr()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineMovimentoTerraFr().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINEMOVIMENTOATERRAFR_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezziFrancesi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineMovimentoATerraFr] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaMovimentoATerraFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaMovimentoATerraFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINAMOVIMENTOATERRAFR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2122385215) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.terrassement);
			tipoMezzoFilter.setTipoMezzo(it.csi.taif.taifweb.business.dao.util.Constants.Chargeur);

			theModel.getAppDataelencoMacchineMovimentoTerraFr()
					.add(ListUtils.addNuovaMacchinaMovimentoTerra(
							ListUtils.getMaxRowNumListaMacchinaMezzo(
									theModel.getAppDataelencoMacchineMovimentoTerraFr()),
							this.taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter),
							this.taifMgr.getElencoTipoNoleggiFrancese(),
							this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));
			result.setResultCode(ADDMACCHINAMOVIMENTOATERRAFR_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaMovimentoATerraFr] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchinaGrumier definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaGrumier(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINAGRUMIER_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINAGRUMIER_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2005414519) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchinaGrumier()) {
				result.setResultCode(OPENATTREZZATUREMACCHINAGRUMIER_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineGrumier().isEmpty()) {
					theModel.getAppDataelencoMacchineGrumier()
							.add(ListUtils.addNuovaMacchinaGrumier(0, this.taifMgr.getElencoTipoNoleggiFrancese()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINAGRUMIER_OUTCOME_CODE__CLOSE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureMacchinaGrumier] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineGrumier definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineGrumier(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINEGRUMIER_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-425240665) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			int rowNum = Integer.parseInt(theModel.getIdRiga());
			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineGrumier()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineGrumier().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINEGRUMIER_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezziFrancesi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineGrumier] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaGrumier definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaGrumier(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINAGRUMIER_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2146592347) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDataelencoMacchineGrumier()
					.add(ListUtils.addNuovaMacchinaGrumier(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineGrumier()),
							this.taifMgr.getElencoTipoNoleggiFrancese()));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINAGRUMIER_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaGrumier] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchinaRimorchiFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaRimorchiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINARIMORCHIFR_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINARIMORCHIFR_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R316595813) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setTipoMezzo(Constants.camionRemorque);
			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchinaRimorchiFr()) {
				result.setResultCode(OPENATTREZZATUREMACCHINARIMORCHIFR_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineRimorchiFr().isEmpty()) {
					theModel.getAppDataelencoMacchineRimorchiFr()
							.add(ListUtils.addNuovaMacchinaRimorchi(0, this.taifMgr.getElencoTipoNoleggiFrancese(),
									this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINARIMORCHIFR_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureMacchinaRimorchiFr] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineRimorchiFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineRimorchiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINERIMORCHIFR_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1860651129) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// impostazione del result code 
			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineRimorchiFr()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineRimorchiFr().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINERIMORCHIFR_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezziFrancesi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineRimorchiFr] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaRimorchiFr definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaRimorchiFr(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINARIMORCHIFR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-739095351) ENABLED START*/
			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setTipoMezzo(Constants.camionRemorque);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catZero);
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoMacchineRimorchiFr()
					.add(ListUtils.addNuovaMacchinaRimorchi(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineRimorchiFr()),
							this.taifMgr.getElencoTipoNoleggiFrancese(),
							this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINARIMORCHIFR_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaRimorchiFr] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openAttrezzatureMacchinaSemi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults openAttrezzatureMacchinaSemi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENATTREZZATUREMACCHINASEMI_OUTCOME_CODE__OPEN = //NOSONAR  Reason:EIAS
				"open"; //NOSONAR  Reason:EIAS
		final String OPENATTREZZATUREMACCHINASEMI_OUTCOME_CODE__CLOSE = //NOSONAR  Reason:EIAS
				"close"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1489291250) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getWidg_chbAttrezzatureMacchinaSemi()) {
				result.setResultCode(OPENATTREZZATUREMACCHINASEMI_OUTCOME_CODE__OPEN);
				if (theModel.getAppDataelencoMacchineSemi().isEmpty()) {
					theModel.getAppDataelencoMacchineSemi()
							.add(ListUtils.addNuovaMacchinaSemi(0, this.taifMgr.getElencoTipoNoleggiFrancese()));
				}
			} else {
				result.setResultCode(OPENATTREZZATUREMACCHINASEMI_OUTCOME_CODE__CLOSE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openAttrezzatureMacchinaSemi] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAttrezzatureMacchineSemi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoAttrezzatureMacchineSemi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOATTREZZATUREMACCHINESEMI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1737429680) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			int rowNum = Integer.parseInt(theModel.getIdRiga());
			for (MacchinaMezzo dto : theModel.getAppDataelencoMacchineSemi()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoMacchineSemi().remove(dto);
					break;
				}
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOATTREZZATUREMACCHINESEMI_OUTCOME_CODE__DELETE);
			valorizzaCheckBoxForMezziFrancesi(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoAttrezzatureMacchineSemi] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addMacchinaSemi definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addMacchinaSemi(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDMACCHINASEMI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-578141838) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataelencoMacchineSemi()
					.add(ListUtils.addNuovaMacchinaSemi(
							ListUtils.getMaxRowNumListaMacchinaMezzo(theModel.getAppDataelencoMacchineSemi()),
							this.taifMgr.getElencoTipoNoleggiFrancese()));
			// impostazione del result code 
			result.setResultCode(ADDMACCHINASEMI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addMacchinaSemi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo expandPersonale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults expandPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPANDPERSONALE_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String EXPANDPERSONALE_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		final String EXPANDPERSONALE_OUTCOME_CODE__SI_FR = //NOSONAR  Reason:EIAS
				"SI_FR"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1569344130) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			String resultCode = EXPANDPERSONALE_OUTCOME_CODE__NO;

			if (theModel.getWidg_rbsPersonale().equalsIgnoreCase(Constants.SI)) {
				if (theModel.getAppDatatracciato().equalsIgnoreCase(Constants.TRACCIATO_FR)) {
					resultCode = EXPANDPERSONALE_OUTCOME_CODE__SI_FR;
				} else {
					resultCode = EXPANDPERSONALE_OUTCOME_CODE__SI;
				}
			}

			result.setResultCode(resultCode);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::expandPersonale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo suggestPersonale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults suggestPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SUGGESTPERSONALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R872307598) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(SUGGESTPERSONALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::suggestPersonale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addCodiceFiscaleAltroPersonale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addCodiceFiscaleAltroPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDCODICEFISCALEALTROPERSONALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1436979139) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceFiscaleRicercato = theModel.getAppDatapersonaleDaCercare().getDescription();
			Personale p = this.taifMgr.getPersonaByCodiceFiscale(codiceFiscaleRicercato,
					this.getVisibileOrdinFilter(theModel));
			int r = theModel.getAppDataelencoPersonale().size();
			CorsoQualificaFilter corsoFilter = new CorsoQualificaFilter();
			corsoFilter.setFlagItaFr(theModel.getAppDatatracciato());
			corsoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
			corsoFilter.setCodiceFiscale(codiceFiscaleRicercato);
			if (p != null) {
				if (theModel.getAppDataelencoPersonale() != null) {
					theModel.getAppDataelencoPersonale().add(p);
				} else {
					ArrayList<Personale> persList = new ArrayList<Personale>();
					persList.add(p);
					theModel.setAppDataelencoPersonale(persList);
				}
				int size = theModel.getAppDataelencoPersonale().size();
				if (size > 0) {
					//					theModel.getAppDataelencoPersonale().get(size - 1).setCodiceFiscale(codiceFiscaleRicercato);
					//					theModel.getAppDataelencoPersonale().get(size - 1).setCodiceFiscaleEditabile(false);
					//					theModel.getAppDataelencoPersonale().get(size - 1).setCognomeEditabile(false);
					//					theModel.getAppDataelencoPersonale().get(size - 1).setNomeEditabile(false);
					//					theModel.getAppDataelencoPersonale().get(size - 1).setCorsi(taifMgr.findCorsiPerPersona(corsoFilter));
					theModel.getAppDataelencoPersonale().get(size - 1).setRownum(r++);
				}
			} else {

				Personale newPersona = new Personale();
				newPersona.setCodiceFiscale(codiceFiscaleRicercato);
				newPersona.setElencoContratti(taifMgr.getElencoContratti(visibileOrdinFilter));
				newPersona.setElencoDurateContratto(this.taifMgr.getDurataContratto());
				newPersona.setElencoInquadramenti(taifMgr.getElencoInquadramenti(visibileOrdinFilter));
				newPersona.setElencoMansioni(taifMgr.getElencoMansioni(visibileOrdinFilter));
				newPersona.setElencoTipologiaPersonale(taifMgr.getElencoTipologiaPersonale(visibileOrdinFilter));
				newPersona.setRownum(r++);
				theModel.getAppDataelencoPersonale().add(newPersona);

				int size = theModel.getAppDataelencoPersonale().size();
				if (size > 0) {

					theModel.getAppDataelencoPersonale().get(size - 1).setCodiceFiscale(codiceFiscaleRicercato);
					theModel.getAppDataelencoPersonale().get(size - 1).setCodiceFiscaleEditabile(true);
					theModel.getAppDataelencoPersonale().get(size - 1).setCodiceFiscaleEditabile(true);
					theModel.getAppDataelencoPersonale().get(size - 1).setCognomeEditabile(true);
					theModel.getAppDataelencoPersonale().get(size - 1).setNomeEditabile(true);
					theModel.getAppDataelencoPersonale().get(size - 1)
							.setCorsi(taifMgr.findCorsiPerPersona(corsoFilter));
					theModel.getAppDataelencoPersonale().get(size - 1).setRownum(r++);
				}

			}
			/*if (theModel.getAppDataelencoPersonale().isEmpty()) {
			    theModel.setWidg_rbsPersonale(Constants.NO);
			} else {
			    theModel.setWidg_rbsPersonale(Constants.SI);
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpAltroPersonale_selectedMultiPanel",
						"CpDomanda_mpAltroPersonale_fpAltroPersonale");
			}*/

			// impostazione del result code 
			result.setResultCode(ADDCODICEFISCALEALTROPERSONALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addCodiceFiscaleAltroPersonale] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoPersonale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults onClickTabellaElencoPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOPERSONALE_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R661513992) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			int rowNum = Integer.parseInt(theModel.getIdRiga());
			String colonna = theModel.getIdColonna();

			for (Personale dto : theModel.getAppDataelencoPersonale()) {
				if (dto.getRownum() == rowNum) {
					theModel.getAppDataelencoPersonale().remove(dto);
					break;
				}
			}

			if (theModel.getAppDataelencoPersonale().isEmpty()) {
				theModel.setWidg_rbsPersonale(Constants.NO);
			} else {
				theModel.setWidg_rbsPersonale(Constants.SI);
			}
			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOPERSONALE_OUTCOME_CODE__DELETE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoPersonale] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addPersonale definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults addPersonale(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDPERSONALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1555347307) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
			if (theModel.getAppDataelencoPersonale() == null) {
				theModel.setAppDataelencoPersonale(new ArrayList<Personale>());
			}
			theModel.getAppDataelencoPersonale()
					.add(ListUtils.addNuovoPersonale(
							ListUtils.getMaxRowNumListaPersonale(theModel.getAppDataelencoPersonale()) + 1,
							this.taifMgr.getElencoContratti(visibileOrdinFilter), this.taifMgr.getDurataContratto(),
							this.taifMgr.getElencoInquadramenti(visibileOrdinFilter),
							this.taifMgr.getElencoMansioni(visibileOrdinFilter),
							this.taifMgr.getElencoTipologiaPersonale(visibileOrdinFilter)));
			// impostazione del result code 
			result.setResultCode(ADDPERSONALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addPersonale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goBack definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults goBack(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDADATIANAGRAFICI_FPWIZARDDATIANAGRAFICISUB1 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDADATIANAGRAFICI_FPWIZARDDATIANAGRAFICISUB2 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDADATISOCIOECONOMICI_FPWIZARDDATISOCIOECONOMICISUB1 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDADATISOCIOECONOMICI_FPWIZARDDATISOCIOECONOMICISUB2 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB1 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB2 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB3 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDA_FPWIZARD4STRUTTURE = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomanda_fpWizard4Strutture"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTREZZATTURE_PWIZARDATTREZZATURESUB1 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub1"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTREZZATTURE_PWIZARDATTREZZATURESUB2 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPDOMANDA_WZPDOMANDA_FPWIZARD6PERSONALE = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomanda_fpWizard6Personale"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__RIEPILOGO = //NOSONAR  Reason:EIAS
				"Riepilogo"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1899514592) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			String backDomandaCheck = (String) ActionContext.getContext().getSession().get("backDomandaRiepilogo");
			if (Constants.BACK_DOMANDA_RIEPILOGO.equalsIgnoreCase(theModel.getAppDatabackDomanda())
					|| Constants.BACK_DOMANDA_RIEPILOGO.equalsIgnoreCase(backDomandaCheck)) {
				theModel.setAppDatabackDomanda(null);
				result.setResultCode(GOBACK_OUTCOME_CODE__RIEPILOGO);
				result.setModel(theModel);
				return result;
			}
			//String currentTab = this.salvaDomanda(theModel);
			//String currentTab = ;

			try {
				this.switchTabAndInit(theModel);
			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, GOBACK_OUTCOME_CODE__KO);
			}

			String back = getPreviousElement(theModel.getSelectedTabValue());
			log.debug("PREVIOUS ELEMENT *" + back + "*");
			// impostazione del result code 
			result.setResultCode(back == null ? GOBACK_OUTCOME_CODE__OK : back);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::goBack] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaInBozza definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults salvaInBozza(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAINBOZZA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String SALVAINBOZZA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2116178199) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				String currentTab = this.salvaDomanda(theModel);
				log.debug("SELECTED TAB *" + currentTab + "*");
				this.setVisibilityConsultaIstanzaTaglioPresentate(theModel);
				// impostazione del result code 
				result.setResultCode(SALVAINBOZZA_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, SALVAINBOZZA_OUTCOME_CODE__KO);
			}

			// modifica degli  del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaInBozza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaProsegui definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults salvaProsegui(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDADATIANAGRAFICI_FPWIZARDDATIANAGRAFICISUB1 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDADATIANAGRAFICI_FPWIZARDDATIANAGRAFICISUB2 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDADATISOCIOECONOMICI_FPWIZARDDATISOCIOECONOMICISUB1 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDADATISOCIOECONOMICI_FPWIZARDDATISOCIOECONOMICISUB2 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB1 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB2 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTIVITA_FPWIZARDATTIVITASUB3 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDA_FPWIZARD4STRUTTURE = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomanda_fpWizard4Strutture"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTREZZATTURE_PWIZARDATTREZZATURESUB1 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub1"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDAATTREZZATTURE_PWIZARDATTREZZATURESUB2 = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPDOMANDA_WZPDOMANDA_FPWIZARD6PERSONALE = //NOSONAR  Reason:EIAS
				"CpDomanda_wzpDomanda_fpWizard6Personale"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__NEXT = //NOSONAR  Reason:EIAS
				"Next"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1358356380) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				String currentTab = this.salvaDomanda(theModel);
				String next = getNextElement(currentTab);

				log.debug("NEXT ELEMENT *" + next + "*");

				// impostazione del result code 
				result.setResultCode(next == null ? SALVAPROSEGUI_OUTCOME_CODE__NEXT : next);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, SALVAPROSEGUI_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaProsegui] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goToRiepilogo definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults goToRiepilogo(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOTORIEPILOGO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String GOTORIEPILOGO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1848373370) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getSession().remove("currentContentPanel");
			//theModel.getSession().put("GO_TO_RIEPILOGO", "GO_TO_RIEPILOGO");

			// impostazione del result code 
			result.setResultCode(GOTORIEPILOGO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::goToRiepilogo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo testIndex definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults testIndex(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TESTINDEX_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String TESTINDEX_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1796361815) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::testIndex] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_AZIENDA = //NOSONAR  Reason:EIAS
				"OK_AZIENDA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-30049596) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// TAB 1.1
			log.debug("--------- ENTRO in EXECUTE Init ---------");
			log.debug("--------- VALORE DI BACK *" + theModel.getAppDatabackDomanda() + "*  ---------");
			if (theModel.getAppDataprimoIngresso() == null || !theModel.getAppDataprimoIngresso().booleanValue()) {
				theModel.setAppDataprimoIngresso(true);
			} else {
				if (Constants.BACK_DOMANDA_RIEPILOGO.equalsIgnoreCase(theModel.getAppDatabackDomanda())) {
					this.executeLocalInit(theModel);
				}
			}
			result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK);

			//se entro come utente azienda disabilito campo cf in sez 1.2
			if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo().equalsIgnoreCase("1")) {
				result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_AZIENDA);

			} else {
				result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeEnter definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults executeEnter(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEENTER_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String EXECUTEENTER_OUTCOME_CODE__INSERT = //NOSONAR  Reason:EIAS
				"Insert"; //NOSONAR  Reason:EIAS
		final String EXECUTEENTER_OUTCOME_CODE__OKACQUISIZIONEVOLUMI = //NOSONAR  Reason:EIAS
				"OKACQUISIZIONEVOLUMI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1957820652) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.info("--------- ENTRO in EXECUTE Enter ---------");
			log.info("--------- VALORE DI BACK *" + theModel.getAppDatabackDomanda() + "*  ---------");

			log.info("--------- VALORE DI ID AZIENDA *" + theModel.getAppDataidAzienda() + "*  ---------");

			//			theModel.setAppDataprimoIngresso(false);

			// impostazione del result code 
			if (theModel.getAppDataidAzienda() == null) {
				theModel.getSession().remove(Constants.WIZARD_DOMANDA);
				result.setResultCode(EXECUTEENTER_OUTCOME_CODE__INSERT);
			} else if (theModel.getSession().containsValue("RIENTROISTANZETAGLIO")) { // <-- VT taif 15: se rientro da acquisizione volumi non devo fare il 
				theModel.getSession().remove("RIENTROISTANZETAGLIO"); // clearAppData e devo invece aggiornare i volumi acquisiti
				if (theModel.getAppDatavolumiAcquisitiPrimpaForSrv() != null
						&& theModel.getAppDataisVolumeAcquisitoFromPrimpaForSrv()) {
					log.info(
							"[CPBECpIstanzeTaglioPresentate:: acquisizioneVolumiTaglio] AppDataisVolumeAcquisitoFromPrimpaForSrv "
									+ theModel.getAppDataisVolumeAcquisitoFromPrimpaForSrv());
					log.info("[CPBECpIstanzeTaglioPresentate:: acquisizioneVolumiTaglio] sommaUtilizzazione " + theModel
							.getAppDatavolumiAcquisitiPrimpaForSrv().getTotaleVolumiTagliDiUtilizzazione() != null
									? theModel.getAppDatavolumiAcquisitiPrimpaForSrv()
											.getTotaleVolumiTagliDiUtilizzazione()
									: "null");
					theModel.setAppDataisVolumeAcquisitoFromPrimpaForSrv(false);
					if (ConvertUtil.checkIsNullOrEmpty(
							theModel.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTagliDiUtilizzazione())) {
						theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(theModel
								.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTagliDiUtilizzazione());
					}
					if (ConvertUtil.checkIsNullOrEmpty(
							theModel.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTaglioPioppeti())) {
						theModel.setAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(
								theModel.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTaglioPioppeti());
					}
					if (ConvertUtil.checkIsNullOrEmpty(
							theModel.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTagliIntercalari())) {
						theModel.setAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(
								theModel.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTagliIntercalari());
					}
					if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita1()
							.getInterventoInRegione() == null) {
						theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita1()
								.setInterventoInRegione(theModel.getAppDatavolumiAcquisitiPrimpaForSrv());
					} else {
						theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita1().getInterventoInRegione()
								.setTotaleVolumiTagliDiUtilizzazione(theModel.getAppDatavolumiAcquisitiPrimpaForSrv()
										.getTotaleVolumiTagliDiUtilizzazione());
						theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita1().getInterventoInRegione()
								.setTotaleVolumiTaglioPioppeti(theModel.getAppDatavolumiAcquisitiPrimpaForSrv()
										.getTotaleVolumiTaglioPioppeti());
						theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita1().getInterventoInRegione()
								.setTotaleVolumiTagliIntercalari(theModel.getAppDatavolumiAcquisitiPrimpaForSrv()
										.getTotaleVolumiTagliIntercalari());
					}

				}

				theModel.setWidg_chbAttivitaUltimoAnno1(true);
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita2() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita2().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno2(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno2(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita3() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita3().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno3(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno3(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita4() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita4().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno4(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno4(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita5() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita5().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno5(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno5(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita6() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita6().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno6(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno6(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita7() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita7().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno7(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno7(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita8() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita8().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno8(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno8(false);
					}
				}
				if (theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita9() != null) {
					if (StringUtils.isNotEmpty(
							theModel.getAppDatagestioneAttivitaUltimoAnno().getAttivita9().getPercentuale())) {
						theModel.setWidg_chbAttivitaUltimoAnno9(true);
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno9(false);
					}
				}
				result.setResultCode(EXECUTEENTER_OUTCOME_CODE__OKACQUISIZIONEVOLUMI);

			} else { // <-- taif-15: non arrivo da acquisizione volumi: faccio clearAppData e rieseguo l'init
				result.setResultCode(EXECUTEENTER_OUTCOME_CODE__OK);

			}
			//GenericUtil.stampaVO(locale, true);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeEnter] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo callExecuteLocalInit definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults callExecuteLocalInit(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CALLEXECUTELOCALINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1953579701) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.info("[CPBECpIstanzeTaglioPresentate:: callExecuteLocalInit] BEGIN ");

			this.executeLocalInit(theModel);

			Locale locale = ActionContext.getContext().getLocale();
			theModel.getAppDatacurrentUser().setLingua(GenericUtil.getLinguaFromLocale(locale));
			// impostazione del result code 
			result.setResultCode(CALLEXECUTELOCALINIT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			log.info("[CPBECpIstanzeTaglioPresentate:: callExecuteLocalInit] END ");

			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::callExecuteLocalInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo callExecuteLocalInitInsert definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults callExecuteLocalInitInsert(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CALLEXECUTELOCALINITINSERT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1983884590) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.info("[CPBECpIstanzeTaglioPresentate:: callExecuteLocalInitInsert] BEGIN ");

			this.executeLocalInit(theModel);

			Locale locale = ActionContext.getContext().getLocale();
			theModel.getAppDatacurrentUser().setLingua(GenericUtil.getLinguaFromLocale(locale));
			// impostazione del result code 
			result.setResultCode(CALLEXECUTELOCALINITINSERT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::callExecuteLocalInitInsert] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeRefresh definito in un ExecCommand del
	 * ContentPanel CpDomanda
	 */
	public ExecResults executeRefresh(

			it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEREFRESH_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1186715849) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.info("--------- ENTRO in EXECUTE Refresh  ---------");
			log.info("--------- VALORE DI BACK *" + theModel.getAppDatabackDomanda() + "*  ---------");
			// impostazione del result code 
			result.setResultCode(EXECUTEREFRESH_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeRefresh] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiAnagraficiSedi
	 */
	public static void resetClearStatus_widg_tblDatiAnagraficiSedi(java.util.Map session) {
		session.put("CpDomanda_tblDatiAnagraficiSedi_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti
	 */
	public static void resetClearStatus_widg_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti(
			java.util.Map session) {
		session.put("CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche
	 */
	public static void resetClearStatus_widg_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche(
			java.util.Map session) {
		session.put("CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti
	 */
	public static void resetClearStatus_widg_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti(
			java.util.Map session) {
		session.put("CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti
	 */
	public static void resetClearStatus_widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti(
			java.util.Map session) {
		session.put("CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti_clearStatus",
				Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche
	 */
	public static void resetClearStatus_widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche(
			java.util.Map session) {
		session.put("CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti
	 */
	public static void resetClearStatus_widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti(
			java.util.Map session) {
		session.put("CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti_clearStatus",
				Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiSocioeconomiciCategorieImpresa
	 */
	public static void resetClearStatus_widg_tblDatiSocioeconomiciCategorieImpresa(java.util.Map session) {
		session.put("CpDomanda_tblDatiSocioeconomiciCategorieImpresa_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDatiSocioEconomiciAltriAlbi
	 */
	public static void resetClearStatus_widg_tbDatiSocioEconomiciAltriAlbi(java.util.Map session) {
		session.put("CpDomanda_tbDatiSocioEconomiciAltriAlbi_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDatiSocioeconomiciFormaOrganizzativa
	 */
	public static void resetClearStatus_widg_tblDatiSocioeconomiciFormaOrganizzativa(java.util.Map session) {
		session.put("CpDomanda_tblDatiSocioeconomiciFormaOrganizzativa_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDatiSocioEconomiciCertificazioni
	 */
	public static void resetClearStatus_widg_tbDatiSocioEconomiciCertificazioni(java.util.Map session) {
		session.put("CpDomanda_tbDatiSocioEconomiciCertificazioni_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttivitaUltimoAnno
	 */
	public static void resetClearStatus_widg_tblAttivitaUltimoAnno(java.util.Map session) {
		session.put("CpDomanda_tblAttivitaUltimoAnno_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttivitaUltimoAnno4
	 */
	public static void resetClearStatus_widg_tblAttivitaUltimoAnno4(java.util.Map session) {
		session.put("CpDomanda_tblAttivitaUltimoAnno4_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttivitaUltimoAnno5
	 */
	public static void resetClearStatus_widg_tblAttivitaUltimoAnno5(java.util.Map session) {
		session.put("CpDomanda_tblAttivitaUltimoAnno5_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttivitaFr
	 */
	public static void resetClearStatus_widg_tblAttivitaFr(java.util.Map session) {
		session.put("CpDomanda_tblAttivitaFr_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAttivitaLavoriPA
	 */
	public static void resetClearStatus_widg_tbAttivitaLavoriPA(java.util.Map session) {
		session.put("CpDomanda_tbAttivitaLavoriPA_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAttivitaLegname
	 */
	public static void resetClearStatus_widg_tbAttivitaLegname(java.util.Map session) {
		session.put("CpDomanda_tbAttivitaLegname_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAttivitaLegnameFr
	 */
	public static void resetClearStatus_widg_tbAttivitaLegnameFr(java.util.Map session) {
		session.put("CpDomanda_tbAttivitaLegnameFr_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblStruttureCapannoni
	 */
	public static void resetClearStatus_widg_tblStruttureCapannoni(java.util.Map session) {
		session.put("CpDomanda_tblStruttureCapannoni_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblStrutturePiazzaliStoccaggio
	 */
	public static void resetClearStatus_widg_tblStrutturePiazzaliStoccaggio(java.util.Map session) {
		session.put("CpDomanda_tblStrutturePiazzaliStoccaggio_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttrezzatureCascoForestale
	 */
	public static void resetClearStatus_widg_tblAttrezzatureCascoForestale(java.util.Map session) {
		session.put("CpDomanda_tblAttrezzatureCascoForestale_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttrezzatureScarponiRinforzati
	 */
	public static void resetClearStatus_widg_tblAttrezzatureScarponiRinforzati(java.util.Map session) {
		session.put("CpDomanda_tblAttrezzatureScarponiRinforzati_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttrezzaturePantaloniAntitaglio
	 */
	public static void resetClearStatus_widg_tblAttrezzaturePantaloniAntitaglio(java.util.Map session) {
		session.put("CpDomanda_tblAttrezzaturePantaloniAntitaglio_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchinaTrattrici
	 */
	public static void resetClearStatus_widg_tblMacchinaTrattrici(java.util.Map session) {
		session.put("CpDomanda_tblMacchinaTrattrici_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchineSpeciali
	 */
	public static void resetClearStatus_widg_tblMacchineSpeciali(java.util.Map session) {
		session.put("CpDomanda_tblMacchineSpeciali_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchineMovimentoATerra
	 */
	public static void resetClearStatus_widg_tblMacchineMovimentoATerra(java.util.Map session) {
		session.put("CpDomanda_tblMacchineMovimentoATerra_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchinaRimorchi
	 */
	public static void resetClearStatus_widg_tblMacchinaRimorchi(java.util.Map session) {
		session.put("CpDomanda_tblMacchinaRimorchi_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchinaVerricelli
	 */
	public static void resetClearStatus_widg_tblMacchinaVerricelli(java.util.Map session) {
		session.put("CpDomanda_tblMacchinaVerricelli_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchinaPle
	 */
	public static void resetClearStatus_widg_tblMacchinaPle(java.util.Map session) {
		session.put("CpDomanda_tblMacchinaPle_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchinaTrinciaForestale
	 */
	public static void resetClearStatus_widg_tblMacchinaTrinciaForestale(java.util.Map session) {
		session.put("CpDomanda_tblMacchinaTrinciaForestale_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchineSegherieMobili
	 */
	public static void resetClearStatus_widg_tblMacchineSegherieMobili(java.util.Map session) {
		session.put("CpDomanda_tblMacchineSegherieMobili_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchineGruACavo
	 */
	public static void resetClearStatus_widg_tblMacchineGruACavo(java.util.Map session) {
		session.put("CpDomanda_tblMacchineGruACavo_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchineCippatrici
	 */
	public static void resetClearStatus_widg_tblMacchineCippatrici(java.util.Map session) {
		session.put("CpDomanda_tblMacchineCippatrici_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMezziDiTrasporto
	 */
	public static void resetClearStatus_widg_tblMezziDiTrasporto(java.util.Map session) {
		session.put("CpDomanda_tblMezziDiTrasporto_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAltriMezzi
	 */
	public static void resetClearStatus_widg_tblAltriMezzi(java.util.Map session) {
		session.put("CpDomanda_tblAltriMezzi_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchineSpecialiFr
	 */
	public static void resetClearStatus_widg_tblMacchineSpecialiFr(java.util.Map session) {
		session.put("CpDomanda_tblMacchineSpecialiFr_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchineMovimentoATerraFr
	 */
	public static void resetClearStatus_widg_tblMacchineMovimentoATerraFr(java.util.Map session) {
		session.put("CpDomanda_tblMacchineMovimentoATerraFr_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchinaGrumier
	 */
	public static void resetClearStatus_widg_tblMacchinaGrumier(java.util.Map session) {
		session.put("CpDomanda_tblMacchinaGrumier_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchinaRimorchiFr
	 */
	public static void resetClearStatus_widg_tblMacchinaRimorchiFr(java.util.Map session) {
		session.put("CpDomanda_tblMacchinaRimorchiFr_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblMacchinaSemi
	 */
	public static void resetClearStatus_widg_tblMacchinaSemi(java.util.Map session) {
		session.put("CpDomanda_tblMacchinaSemi_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAltroPersonale
	 */
	public static void resetClearStatus_widg_tblAltroPersonale(java.util.Map session) {
		session.put("CpDomanda_tblAltroPersonale_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAltroPersonaleTipoContrattoFr
	 */
	public static void resetClearStatus_widg_tblAltroPersonaleTipoContrattoFr(java.util.Map session) {
		session.put("CpDomanda_tblAltroPersonaleTipoContrattoFr_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAltroPersonaleTipoMansioneFr
	 */
	public static void resetClearStatus_widg_tblAltroPersonaleTipoMansioneFr(java.util.Map session) {
		session.put("CpDomanda_tblAltroPersonaleTipoMansioneFr_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1203547938) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	@Value("${trattrice}")
	private String trattrice;

	@Value("${speciali}")
	private String speciali;

	@Value("${terra}")
	private String terra;

	@Value("${rimorchio}")
	private String rimorchio;

	@Value("${verricello}")
	private String verricello;

	@Value("${PLE}")
	private String PLE;

	@Value("${trincia}")
	private String trincia;

	@Value("${segherie}")
	private String segherie;

	@Value("${gru}")
	private String gru;

	@Value("${cippatrice}")
	private String cippatrice;

	@Value("${mezzi}")
	private String mezzi;

	private DummyMgr dummyMgr = null;
	@Autowired
	private VisibileOrdinFilter visibileOrdinFilter;
	@Autowired
	private TipoMezzoFilter tipoMezzoFilter;

	@Autowired
	private FormaGiuridicaFilter formaGiuridicaFilter;

	@Autowired
	private CorsoQualificaFilter corsoQualificaFilter;

	@Autowired
	private MaterialeFilter materialeFilter;

	@Autowired
	private LavoroPaFilter lavoroPaFilter;

	@Autowired
	private ConfigProfiloFilter configProfiloFilter;

	@Autowired
	private AziendaVisibleFilter aziendaVisibleFilter;

	@Autowired
	private ImportAziendaAAEP aziendaImportata;

	public void setTrattrice(String trattrice) {
		this.trattrice = trattrice;
	}

	public void setSpeciali(String speciali) {
		this.speciali = speciali;
	}

	public void setTerra(String terra) {
		this.terra = terra;
	}

	public void setRimorchio(String rimorchio) {
		this.rimorchio = rimorchio;
	}

	public void setPLE(String pLE) {
		PLE = pLE;
	}

	public void setSegherie(String segherie) {
		this.segherie = segherie;
	}

	public void setGru(String gru) {
		this.gru = gru;
	}

	public void setCippatrice(String cippatrice) {
		this.cippatrice = cippatrice;
	}

	public void setMezzi(String mezzi) {
		this.mezzi = mezzi;
	}

	public void setVerricello(String verricello) {
		this.verricello = verricello;
	}

	public void setTrincia(String trincia) {
		this.trincia = trincia;
	}

	public void setConfigProfiloFilter(ConfigProfiloFilter configProfiloFilter) {
		this.configProfiloFilter = configProfiloFilter;
	}

	@Autowired
	private TaifMgr taifMgr;

	public DummyMgr getDummyMgr() {
		return dummyMgr;
	}

	public void setDummyMgr(DummyMgr dummyMgr) {
		this.dummyMgr = dummyMgr;
	}

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	private ValidationMgr validationMgr;

	/**
	* @return the validationMgr
	*/
	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	/**
	 * @param validationMgr the validationMgr to set
	 */
	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public void setVisibileOrdinFilter(VisibileOrdinFilter visibileOrdinFilter) {
		this.visibileOrdinFilter = visibileOrdinFilter;
	}

	public void setTipoMezzoFilter(TipoMezzoFilter tipoMezzoFilter) {
		this.tipoMezzoFilter = tipoMezzoFilter;
	}

	public void setFormaGiuridicaFilter(FormaGiuridicaFilter formaGiuridicaFilter) {
		this.formaGiuridicaFilter = formaGiuridicaFilter;
	}

	public void setCorsoQualificaFilter(CorsoQualificaFilter corsoQualificaFilter) {
		this.corsoQualificaFilter = corsoQualificaFilter;
	}

	public void setMaterialeFilter(MaterialeFilter materialeFilter) {
		this.materialeFilter = materialeFilter;
	}

	public void setLavoroPaFilter(LavoroPaFilter lavoroPaFilter) {
		this.lavoroPaFilter = lavoroPaFilter;
	}

	public void setAziendaVisibleFilter(AziendaVisibleFilter aziendaVisibleFilter) {
		this.aziendaVisibleFilter = aziendaVisibleFilter;
	}
	public ImportAziendaAAEP getAziendaImportata() {
		return aziendaImportata;
	}

	public void setAziendaImportata(ImportAziendaAAEP aziendaImportata) {
		this.aziendaImportata = aziendaImportata;
	}

	private String salvaDomanda(CpDomandaModel theModel) throws Exception {

		String selected = (String) theModel.getSession().get(Constants.WIZARD_DOMANDA);
		String subSelected = null;
		log.debug("SELECTED MAIN " + selected);
		log.debug("SELECTED 1 " + theModel.getSession().get(Constants.WIZARD_SEL_1));
		log.debug("SELECTED 2 " + theModel.getSession().get(Constants.WIZARD_SEL_2));
		log.debug("SELECTED 3 " + theModel.getSession().get(Constants.WIZARD_SEL_3));
		log.debug("SELECTED 5 " + theModel.getSession().get(Constants.WIZARD_SEL_5));

		WizardDomandaStatus d = WizardDomandaStatus.getByName(selected);
		WizardDomandaStatus subD = null;
		String result = null;
		String idAlbo = null;
		Integer idProfilo = 0;
		if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif() != null) {
			if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo() != null) {
				idProfilo = ConvertUtil
						.convertToInteger(theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo());
			}
		} else {
			idProfilo = 1;
		}
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = taifMgr
				.getConfigProfiloUtenteByCodiceFiscale(getConfigProfiloUtente(theModel), idProfilo);

		ActionContext.getContext().getSession().put("profiloUtente", profiloUtente);
		this.setProfiloUtente(theModel, profiloUtente);

		String esisteConduttore = theModel.getWidg_rbsDatiAnagraficiAltroConducente();

		//ArrayList<String> listImpreseSelezionate = theModel.getAppDataidCategorieImpresaSelezionati();
		String impresaSelezionalta = theModel.getAppDataidCategorieImpresaSelezionato();
		String esisteAlbo = theModel.getWidg_rbsDatiSocioEconomiciAltriAlbi();
		String esisteCertificazione = theModel.getWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso();
		ArrayList<String> listFormeOrganizzative = theModel.getAppDataidFormeOrganizzative();
		if (ActionContext.getContext().getSession().get("idNazione") == null) {
			int idNazione = profiloUtente.getIdNazione();
		}
		if (ActionContext.getContext().getSession().get("idConfigUtente") == null) {
			int idConfigUtente = profiloUtente.getIdConfigUtente();
		}
		ActionContext.getContext().getSession().put("dataTracciato", theModel.getAppDatatracciato());
		switch (d) {
			case WIZARD_VAL_1 :
				subSelected = (String) theModel.getSession().get(Constants.WIZARD_SEL_1);
				subD = WizardDomandaStatus.getByName(subSelected);
				Integer idAzienda;
				switch (subD) {//appDataidAlboSelezionato
					case WIZARD_VAL_1_1 :
						result = subD.getName();
						log.debug("SALVA 1.1");
						idAzienda = this.taifMgr.salvaDatiAziendali(theModel.getAppDataidAzienda(),
								setDatiAnagraficaAziendale(theModel), setDatiSedeLegaleAzienda(theModel),
								theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale(),
								theModel.getAppDataalbo(), theModel.getAppDatatracciato(),
								theModel.getAppDataalbo().getIdAlbo());
						theModel.setAppDataidAzienda(idAzienda);
						theModel.setAppDataidPratica(this.taifMgr.getIdPraticaByAziendaAndSoggettoGestore(idAzienda,
								theModel.getAppDataalbo().getIdAlbo()));
						this.executeInit1_2(theModel);

						break;
					case WIZARD_VAL_1_2 :
						result = subD.getName();
						this.taifMgr.salvaTitolareRappresentanteLegale(theModel.getAppDataidAzienda(),
								setTitolareRappresentanteLegale(theModel), setConduttoreLegale(theModel), profiloUtente,
								esisteConduttore, theModel.getAppDatatracciato());
						log.debug("SALVA 1.2");
						this.executeInit2_1(theModel);
						break;

					default :
						result = WizardDomandaStatus.WIZARD_VAL_1_1.getName();
						log.debug("SALVA 1.1 DEFAULT");
						idAzienda = this.taifMgr.salvaDatiAziendali(theModel.getAppDataidAzienda(),
								setDatiAnagraficaAziendale(theModel), setDatiSedeLegaleAzienda(theModel),
								theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale(),
								theModel.getAppDataalbo(), theModel.getAppDatatracciato(),
								theModel.getAppDataalbo().getIdAlbo());
						theModel.setAppDataidAzienda(idAzienda);
						theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
								profiloUtente.getIdNazione().toString());
						theModel.setAppDataidPratica(this.taifMgr.getIdPraticaByAziendaAndSoggettoGestore(idAzienda,
								theModel.getAppDataalbo().getIdAlbo()));
						ActionContext.getContext().getSession().put("idConfigUtente",
								profiloUtente.getIdConfigUtente().toString());
						ActionContext.getContext().getSession().put("idNazione",
								profiloUtente.getIdNazione().toString());
						this.executeInit1_2(theModel);
						break;
				}
				break;
			case WIZARD_VAL_2 :
				subSelected = (String) theModel.getSession().get(Constants.WIZARD_SEL_2);
				subD = WizardDomandaStatus.getByName(subSelected);
				switch (subD) {
					case WIZARD_VAL_2_1 :
						result = subD.getName();
						log.debug("SALVA 2.1");
						this.taifMgr.salvaFatturatoECategorieImpresa(theModel.getAppDataidAzienda(),
								theModel.getAppDataelencoCategorieImpresa(), getCategorieImpresa(theModel),
								profiloUtente, impresaSelezionalta, theModel.getAppDatafatturatoCategorieDiImpresa(),
								theModel.getAppDatatracciato());
						this.executeInit2_2(theModel);
						break;
					case WIZARD_VAL_2_2 :
						result = subD.getName();
						log.debug("SALVA 2.2");
						this.taifMgr.salvaAssociazoniECertificazioni(theModel.getAppDataidAzienda(),
								theModel.getAppDataelencoAltriAlbi(), theModel.getAppDataelencoFormeOrganizzative(),
								getFormeOrganizzative(theModel), theModel.getAppDataelencoCertificazioni(),
								profiloUtente, listFormeOrganizzative, esisteAlbo, esisteCertificazione,
								theModel.getAppDatatracciato());
						this.executeInit3_1(theModel);
						break;

					default :
						result = WizardDomandaStatus.WIZARD_VAL_2_1.getName();
						log.debug("SALVA 2.1 DEFAULT");
						this.taifMgr.salvaFatturatoECategorieImpresa(theModel.getAppDataidAzienda(),
								theModel.getAppDataelencoCategorieImpresa(), getCategorieImpresa(theModel),
								profiloUtente, impresaSelezionalta, theModel.getAppDatafatturatoCategorieDiImpresa(),
								theModel.getAppDatatracciato());
						this.executeInit2_2(theModel);
						break;
				}

				break;
			case WIZARD_VAL_3 :
				subSelected = (String) theModel.getSession().get(Constants.WIZARD_SEL_3);
				subD = WizardDomandaStatus.getByName(subSelected);
				Map<String, Boolean> attivitaMap = new HashMap<String, Boolean>();

				switch (subD) {
					case WIZARD_VAL_3_1 :
						result = subD.getName();
						attivitaMap = valorizzaAttivitaMap(theModel);
						this.taifMgr.salvaAttivitaUltimoAnno(theModel.getAppDataidAzienda(),
								theModel.getAppDatagestioneAttivitaUltimoAnno(),
								theModel.getAppDataelencoMaterialePropagazione(),
								theModel.getAppDataelencoArboricolturaDaLegno(),
								theModel.getAppDataidMaterialiPropagazione(),
								theModel.getAppDataidAttivitaUltimoAnnoFr(), attivitaMap, profiloUtente,
								theModel.getAppDatatracciato(),
								theModel.getAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato(),
								theModel.getAppDataelencoMaterialePropagazione());
						log.debug("SALVA 3.1");
						this.executeInit3_1(theModel);
						this.executeInit3_2(theModel);
						break;
					case WIZARD_VAL_3_2 :
						String esistenzaLavoriPA = theModel.getWidg_rbsAttivitaLavoriPA();
						result = subD.getName();
						log.debug("SALVA 3.2");
						// Salvo la scheda solo per il tracciato italiano
						if (Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
							this.taifMgr.salvaLavoriPerPAUltimoAnno(theModel.getAppDataidAzienda(),
									theModel.getAppDataelencoLavoriPA(), profiloUtente, esistenzaLavoriPA,
									theModel.getAppDatatracciato());
							ActionContext.getContext().getSession().put("esistenzaLavoriPA", esistenzaLavoriPA);
						}
						this.executeInit3_3(theModel);
						break;
					case WIZARD_VAL_3_3 :
						String esistenzaAttivitaLegname = theModel.getWidg_rbsAttivitaLegname();
						result = subD.getName();
						log.debug("SALVA 3.3");
						this.taifMgr.salvaCommercializzazioneLegnameEAssortimentiUltimoAnno(
								theModel.getAppDataidAzienda(), theModel.getAppDataelencoLegnamiAssortimentiTrattati(),
								profiloUtente, esistenzaAttivitaLegname, theModel.getAppDatapercentualeCommercioFr(),
								theModel.getAppDatatracciato());
						ActionContext.getContext().getSession().put("esistenzaAttivitaLegname",
								esistenzaAttivitaLegname);
						this.executeInit4(theModel);
						break;

					default :
						result = WizardDomandaStatus.WIZARD_VAL_3_1.getName();
						attivitaMap = valorizzaAttivitaMap(theModel);
						this.taifMgr.salvaAttivitaUltimoAnno(theModel.getAppDataidAzienda(),
								theModel.getAppDatagestioneAttivitaUltimoAnno(),
								theModel.getAppDataelencoMaterialePropagazione(),
								theModel.getAppDataelencoArboricolturaDaLegno(),
								theModel.getAppDataidMaterialiPropagazione(),
								theModel.getAppDataidAttivitaUltimoAnnoFr(), attivitaMap, profiloUtente,
								theModel.getAppDatatracciato(),
								theModel.getAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato(),
								theModel.getAppDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato(),
								theModel.getAppDataelencoMaterialePropagazione());
						log.debug("SALVA 3.1 DEFAULT");
						this.executeInit3_2(theModel);
						break;
				}

				break;
			case WIZARD_VAL_4 :
				result = d.getName();
				log.debug("SALVA 4");
				boolean esisteCapannone = theModel.getWidg_chbStruttureCapannoni();
				boolean esistePiazzaSto = theModel.getWidg_chbStrutturePiazzaliStoccaggio();
				this.taifMgr.salvaStrutture(theModel.getAppDataidAzienda(), theModel.getAppDataelencoCapannoni(),
						theModel.getAppDataelencoPiazzaliStoccaggio(), profiloUtente, esisteCapannone, esistePiazzaSto,
						theModel.getAppDatatracciato());
				this.executeInit5_1(theModel);
				break;
			case WIZARD_VAL_5 :
				subSelected = (String) theModel.getSession().get(Constants.WIZARD_SEL_5);
				subD = WizardDomandaStatus.getByName(subSelected);
				Map<String, Boolean> attrezzatureMap = new HashMap<String, Boolean>();
				Map<String, Boolean> macchineMezziMap = new HashMap<String, Boolean>();

				switch (subD) {
					case WIZARD_VAL_5_1 :
						result = subD.getName();
						// Salvo la scheda solo per il tracciato italiano
						if (Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
							attrezzatureMap = valorizzaAttMap(theModel);
							log.debug("SALVA 5.1");
							this.taifMgr.salvaAttrezzaturaAntiInfortunisticaMezziDPI(theModel.getAppDataidAzienda(),
									theModel.getAppDataelencoCaschiForestaliAttrezzature(),
									theModel.getAppDataelencoScarponiRinforzatiAttrezzature(),
									theModel.getAppDataelencoPantaloniAntitaglioAttrezzature(), profiloUtente,
									attrezzatureMap, theModel.getAppDatatracciato());
						}
						this.executeInit5_2(theModel);
						break;
					case WIZARD_VAL_5_2 :
						result = subD.getName();
						macchineMezziMap = valorizzaMacchinaMezzi(theModel);
						this.taifMgr.salvaMacchineEMezzi(theModel.getAppDataidAzienda(),
								this.getGestioneMacchineMezzi(theModel), profiloUtente, macchineMezziMap,
								theModel.getAppDatatracciato());
						log.debug("SALVA 5.2");
						this.executeInit6(theModel);
						break;

					default :
						result = WizardDomandaStatus.WIZARD_VAL_5_1.getName();
						// Salvo la scheda solo per il tracciato italiano
						if (Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
							log.debug("SALVA 5.1 DEFAULT");
							attrezzatureMap = valorizzaAttMap(theModel);
							this.taifMgr.salvaAttrezzaturaAntiInfortunisticaMezziDPI(theModel.getAppDataidAzienda(),
									theModel.getAppDataelencoCaschiForestaliAttrezzature(),
									theModel.getAppDataelencoScarponiRinforzatiAttrezzature(),
									theModel.getAppDataelencoPantaloniAntitaglioAttrezzature(), profiloUtente,
									attrezzatureMap, theModel.getAppDatatracciato());
						}
						this.executeInit5_2(theModel);
						break;
				}

				break;
			case WIZARD_VAL_6 :
				result = d.getName();
				this.taifMgr.salvaPersonale(theModel.getAppDataidAzienda(), theModel.getAppDataelencoPersonale(),
						this.getGestionePersonaleFrancese(theModel), profiloUtente, theModel.getAppDatatracciato());

				log.debug("SALVA 6");
				break;

			default :
				WizardDomandaStatus.WIZARD_VAL_1_1.getName();
				log.debug("SALVA 1.1 DEFAULT DEFAULT");
				break;
		}

		return result;

	}

	private Map<String, Boolean> valorizzaAttivitaUltimoAnno(CpDomandaModel theModel) {
		Map<String, Boolean> attivitaMap = new HashMap<String, Boolean>();
		attivitaMap.put(Constants.att1, theModel.getWidg_chbAttivitaUltimoAnno1());
		attivitaMap.put(Constants.att2, theModel.getWidg_chbAttivitaUltimoAnno2());
		attivitaMap.put(Constants.att3, theModel.getWidg_chbAttivitaUltimoAnno3());
		attivitaMap.put(Constants.att4, theModel.getWidg_chbAttivitaUltimoAnno4());
		attivitaMap.put(Constants.att5, theModel.getWidg_chbAttivitaUltimoAnno5());
		attivitaMap.put(Constants.att6, theModel.getWidg_chbAttivitaUltimoAnno6());
		attivitaMap.put(Constants.att7, theModel.getWidg_chbAttivitaUltimoAnno7());
		attivitaMap.put(Constants.att8, theModel.getWidg_chbAttivitaUltimoAnno8());
		attivitaMap.put(Constants.att9, theModel.getWidg_chbAttivitaUltimoAnno9());
		return attivitaMap;
	}

	private Map<String, Boolean> valorizzaMacchinaMezziIt(CpDomandaModel theModel) {
		Map<String, Boolean> mezziMap = new HashMap<String, Boolean>();
		mezziMap.put(Constants.checkTrattici, theModel.getWidg_chbAttrezzatureMacchinaTrattrici());
		mezziMap.put(Constants.checkSpeciali, theModel.getWidg_chbAttrezzatureMacchineSpeciali());
		mezziMap.put(Constants.checkTerra, theModel.getWidg_chbAttrezzatureMacchineMovimentoATerra());
		mezziMap.put(Constants.checkRimorchi, theModel.getWidg_chbAttrezzatureMacchinaRimorchi());
		mezziMap.put(Constants.checkVerricelli, theModel.getWidg_chbAttrezzatureMacchinaVerricelli());
		mezziMap.put(Constants.checkPle, theModel.getWidg_chbAttrezzatureMacchinaPle());
		mezziMap.put(Constants.checkTrincia, theModel.getWidg_chbAttrezzatureMacchinaTrinciaForestale());
		mezziMap.put(Constants.checkSegherie, theModel.getWidg_chbAttrezzatureMacchineSegherieMobili());
		mezziMap.put(Constants.checkGru, theModel.getWidg_chbAttrezzatureMacchineGruACavo());
		mezziMap.put(Constants.checkCippatrici, theModel.getWidg_chbAttrezzatureMacchineCippatrici());
		mezziMap.put(Constants.checkMezziTra, theModel.getWidg_chbAttrezzatureMezziDiTrasporto());
		mezziMap.put(Constants.checkMezziAltri, theModel.getWidg_chbAttrezzatureAltriMezzi());
		return mezziMap;
	}

	private AnagraficaAziendale setDatiAnagraficaAziendale(CpDomandaModel theModel) {

		AnagraficaAziendale dto = theModel.getAppDataanagraficaAziendale();
		dto.setIdAttivitaPrimaria(theModel.getAppDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale());
		dto.setIdFormaGiurdica(theModel.getAppDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale());
		if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			dto.setIdAttivitaSecondaria(theModel.getAppDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale());
			dto.setIdProvinciaCCIAA(theModel.getAppDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale());
		}
		return dto;
	}

	private Sede setDatiSedeLegaleAzienda(CpDomandaModel theModel) {
		Sede sedeLegale = theModel.getAppDatasedeLegaleAnagrafeAziendale();
		if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			sedeLegale.setIstatComuneSede(theModel.getAppDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale());
			if (theModel.getAppDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale().equals("")) {
				sedeLegale.setIstatComuneSede("0");
			} else {
				//sedeLegale.setIdSede(
				//		Integer.parseInt(theModel.getAppDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale()));
				sedeLegale.setIstatComuneSede(theModel.getAppDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale());
			}
		}
		return sedeLegale;
	}
	//getAppDatagestioneAttivitaUltimoAnno
	//	private GestioneAttivitaUltimoAnno setAppDatagestioneAttivitaUltimoAnno(CpDomandaModel theModel) {
	//
	//		GestioneAttivitaUltimoAnno dto = theModel.getAppDatagestioneAttivitaUltimoAnno();
	//
	//		dto.setAttivita1(theModel.getAppDataattivitaUltimoAnno1());
	//		dto.setAttivita2(theModel.getAppDataattivitaUltimoAnno2());
	//		dto.setAttivita3(theModel.getAppDataattivitaUltimoAnno3());
	//		dto.setAttivita4(theModel.getAppDataattivitaUltimoAnno4());
	//		dto.setAttivita5(theModel.getAppDataattivitaUltimoAnno5());
	//		dto.setAttivita6(theModel.getAppDataattivitaUltimoAnno6());
	//		dto.setAttivita7(theModel.getAppDataattivitaUltimoAnno7());
	//		dto.setAttivita8(theModel.getAppDataattivitaUltimoAnno8());
	//		dto.setAttivita9(theModel.getAppDataattivitaUltimoAnno9());
	//
	//		return dto;
	//	}

	private TitolareRappresentanteLegale setTitolareRappresentanteLegale(CpDomandaModel theModel) {

		TitolareRappresentanteLegale titolare = theModel.getAppDatatitolareRappresentanteLegale();
		//taif-23
		String statoNascita = theModel.getAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale();
		if (statoNascita.equals(Constants.ID_STATO_ITALIA)) {
			log.info("[CPBECpDOmanda]setTitolareRappresentanteLegale setIdComuneNascita "
					+ theModel.getAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale());

			titolare.setIdComuneNascita(theModel.getAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale());
		} else {
			log.info("[CPBECpDOmanda]setTitolareRappresentanteLegale setDsComuneNascitaNoIta "
					+ theModel.getAppDatatitolareRappresentanteLegale().getDsComuneNascitaNoIta());
			titolare.setDsComuneNascitaNoIta(
					theModel.getAppDatatitolareRappresentanteLegale().getDsComuneNascitaNoIta());
		}
		titolare.setIdStatoNascita(theModel.getAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale());
		titolare.setIdTitoloDiStudio(theModel.getAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale());
		titolare.setIdComuneResidenza(theModel.getAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale());

		return titolare;
	}

	private TitolareRappresentanteLegale setConduttoreLegale(CpDomandaModel theModel) {

		TitolareRappresentanteLegale conduttore = theModel.getAppDataaltroTitolareRappresentanteLegale();
		if (conduttore != null) {
			conduttore.setIdStatoNascita(
					theModel.getAppDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale());
			if (conduttore.getIdStatoNascita().equals(Constants.ID_STATO_ITALIA)) {
				conduttore.setIdComuneNascita(
						theModel.getAppDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale());
			}
			conduttore.setIdComuneResidenza(
					theModel.getAppDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale());
			conduttore.setIdTitoloDiStudio(
					theModel.getAppDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale());

		}
		return conduttore;
	}

	private ArrayList<FormaOrganizzativa> getFormeOrganizzative(CpDomandaModel theModel) {
		ArrayList<String> idFormeOrganizzative = theModel.getAppDataidFormeOrganizzative();

		String altro4 = theModel.getAppDataassociazioniECertificazioni().getAltro4();
		String altro5 = theModel.getAppDataassociazioniECertificazioni().getAltro5();
		String altro6 = theModel.getAppDataassociazioniECertificazioni().getAltro6();
		if (altro4 == null || StringUtils.isEmpty(altro4)) {
			altro4 = theModel.getAppDataelencoFormeOrganizzative().get(4).getAltro();
		}
		if (altro5 == null || StringUtils.isEmpty(altro5)) {
			altro5 = theModel.getAppDataelencoFormeOrganizzative().get(5).getAltro();
		}
		if (altro6 == null || StringUtils.isEmpty(altro6)) {
			altro6 = theModel.getAppDataelencoFormeOrganizzative().get(6).getAltro();
		}
		ArrayList<FormaOrganizzativa> result = new ArrayList<FormaOrganizzativa>();
		if (idFormeOrganizzative != null && idFormeOrganizzative.size() > 0) {
			for (String s : idFormeOrganizzative) {
				FormaOrganizzativa obj = new FormaOrganizzativa();
				int idFormaOrganizzativa = Integer.parseInt(s);
				obj.setIdFormaOrganizzativa(idFormaOrganizzativa);
				switch (idFormaOrganizzativa) {
					case 5 :
						obj.setAltro(altro4);
						obj.setAltroVisibile(true);
						break;
					case 6 :
						obj.setAltro(altro5);
						obj.setAltroVisibile(true);
						break;
					case 7 :
						obj.setAltro(altro6);
						obj.setAltroVisibile(true);
						break;
					case 12 :
						obj.setAltro(altro4);
						obj.setAltroVisibile(true);
						break;
					case 13 :
						obj.setAltro(altro5);
						obj.setAltroVisibile(true);
						break;
					case 14 :
						obj.setAltro(altro6);
						obj.setAltroVisibile(true);
						break;
					default :
						obj.setAltro(null);
						break;
				}
				result.add(obj);
			}
		}
		return result;
	}

	private GestioneFatturatoCategoriaDiImpresa getCategorieImpresa(CpDomandaModel theModel) {
		GestioneFatturatoCategoriaDiImpresa result = new GestioneFatturatoCategoriaDiImpresa();
		//ArrayList<String> idCategorie = theModel.getAppDataidCategorieImpresaSelezionati();
		String idCategoriaSelezionata = theModel.getAppDataidCategorieImpresaSelezionato();
		//ArrayList<String> lista = (ArrayList<String>) theModel.getSession().get("appDataidCategorieImpresaSelezionati");
		String altro = theModel.getAppDatafatturatoCategorieDiImpresa().getAltro();

		String prova = ((FatturatoCategorieDiImpresa) theModel.getSession().get("appDatafatturatoCategorieDiImpresa"))
				.getAnnoInizioAttivita();
		String altro2 = (String) theModel.getSession().get("CpDomanda_appDataelencoCategorieImpresa_4__altro");
		log.debug("--- ALTRO *" + altro + "*");
		log.debug("--- ALTRO2 *" + altro2 + "*");
		log.debug("--- PROVA *" + prova + "*");
		log.debug("--- idCategoriaSelezionata  *" + idCategoriaSelezionata + "*");
		ArrayList<CategoriaImpresa> list = new ArrayList<CategoriaImpresa>();
		if (idCategoriaSelezionata != null) {
			//for (String s : idCategorie) {
			CategoriaImpresa obj = new CategoriaImpresa();
			obj.setIdCategoria(Integer.parseInt(idCategoriaSelezionata));
			if (idCategoriaSelezionata.equalsIgnoreCase("5") || idCategoriaSelezionata.equalsIgnoreCase("10")) {
				String altroCateg5 = theModel.getAppDataelencoCategorieImpresa().get(4).getAltro();
				obj.setAltro(altroCateg5);
				obj.setAltroVisibile(true);
			}
			list.add(obj);
			//}
		}
		result.setFatturato(theModel.getAppDatafatturatoCategorieDiImpresa());
		result.setElencoCategorieImpresa(list);
		return result;
	}

	private String getCurrentElement(CpDomandaModel theModel) {

		String selected = (String) theModel.getSession().get(Constants.WIZARD_DOMANDA);
		String subSelected = null;

		WizardDomandaStatus d = WizardDomandaStatus.getByName(selected);
		WizardDomandaStatus subD = null;

		String result = null;

		switch (d) {
			case WIZARD_VAL_1 :
			case WIZARD_VAL_2 :
			case WIZARD_VAL_3 :
			case WIZARD_VAL_5 :
				subSelected = (String) theModel.getSession().get(d.getName());
				result = WizardDomandaStatus.getSelected(d);
				break;
			case WIZARD_VAL_4 :
			case WIZARD_VAL_6 :
				result = d.getName();
				break;

			default :
				log.debug("SALVA 1.1 DEFAULT DEFAULT");
				result = d.WIZARD_VAL_1_1.getName();
				break;
		}

		return result;

	}

	private String getNextElement(CpDomandaModel theModel) {
		return WizardDomandaStatus.getNextElement(getCurrentElement(theModel));
	}

	private String getPreviousElement(CpDomandaModel theModel) {
		return WizardDomandaStatus.getPreviousElement(getCurrentElement(theModel));
	}

	private String getNextElement(String current) {
		return WizardDomandaStatus.getNextElement(current);
	}

	private String getPreviousElement(String current) {
		return WizardDomandaStatus.getPreviousElement(current);
	}

	private VisibileOrdinFilter getVisibileOrdinFilter(CpDomandaModel theModel) {

		visibileOrdinFilter.setFlagItaFr(theModel.getAppDatatracciato());
		visibileOrdinFilter.setFlagVisibile(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		return visibileOrdinFilter;
	}

	private TipoMezzoFilter getTipoMezzoFilter(CpDomandaModel theModel) {
		resetTipoMezzoFilter();
		tipoMezzoFilter.setFlagItaFr(theModel.getAppDatatracciato());
		tipoMezzoFilter.setFlagVisibile(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		tipoMezzoFilter.setIdAzienda(theModel.getAppDataidAzienda());
		return tipoMezzoFilter;
	}

	private void resetTipoMezzoFilter() {
		tipoMezzoFilter.setCategoriaMezzo(null);
		tipoMezzoFilter.setFlagItaFr(null);
		tipoMezzoFilter.setIdAzienda(0);
		tipoMezzoFilter.setIdCategoriaMezzo(0);
		tipoMezzoFilter.setIdTipoMezzo(0);
		tipoMezzoFilter.setTipoMezzo(null);
	}

	private LavoroPaFilter getLavoroPAFilter(String dataTracciato, int idAzienda) {

		lavoroPaFilter.setFlagItaFr(dataTracciato);
		lavoroPaFilter.setFlagVisibile(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		lavoroPaFilter.setIdAzienda(idAzienda);
		return lavoroPaFilter;
	}

	private ConfigProfiloFilter getConfigProfiloUtenteAzienda() {
		ConfigProfiloFilter profiloAzienda = new ConfigProfiloFilter();
		profiloAzienda.setFlagAttivo(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		profiloAzienda.setIdProcedura(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		profiloAzienda.setProfiloUtente(it.csi.taif.taifweb.business.dao.util.Constants.profiloAzienda);
		return profiloAzienda;
	}

	private ConfigProfiloPersona getConfigProfiloPersona(String codiceFiscalePersona, int idProfilo) {
		ConfigProfiloPersona configFilter = new ConfigProfiloPersona();
		configFilter.setCodiceFiscale(codiceFiscalePersona);
		configFilter.setIdProfiloUtente(idProfilo);
		return configFilter;
	}

	private GestioneMacchineMezzi getGestioneMacchineMezzi(CpDomandaModel theModel) {
		GestioneMacchineMezzi result = theModel.getAppDatagestioneMacchineMezzi();
		if (result == null) {
			result = new GestioneMacchineMezzi();
		}
		if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			result.setElencoTrattrici(theModel.getAppDataelencoMacchineTrattrici());
			result.setElencoMacchineSpeciali(theModel.getAppDataelencoMacchineSpeciali());
			result.setElencoMacchineMovimentoTerra(theModel.getAppDataelencoMacchineMovimentoTerra());
			result.setElencoRimorchi(theModel.getAppDataelencoMacchineRimorchi());
			result.setElencoVerricelli(theModel.getAppDataelencoMacchineVerricelli());
			result.setElencoPiattaformaElevabile(theModel.getAppDataelencoMacchinePle());
			result.setElencoTrinciaForestale(theModel.getAppDataelencoMacchineTrinciaForestali());
			result.setElencoSegherieMobili(theModel.getAppDataelencoMacchineSegheriaMobile());
			result.setElencoGruACavo(theModel.getAppDataelencoMacchineGruACavo());
			result.setElencoCippatrici(theModel.getAppDataelencoMacchineCippatrici());
			result.setElencoMezziDiTrasporto(theModel.getAppDataelencoMezziDiTrasporto());
			result.setElencoAltriMezzi(theModel.getAppDataelencoAltriMezzi());
		} else {
			result.setElencoMacchineSpecialiFr(theModel.getAppDataelencoMacchineSpecialiFr());
			result.setElencoMacchineMovimentoTerraFr(theModel.getAppDataelencoMacchineMovimentoTerraFr());
			result.setElencoRimorchiFr(theModel.getAppDataelencoMacchineRimorchiFr());
			result.setElencoGrumier(theModel.getAppDataelencoMacchineGrumier());
			result.setElencoSemi(theModel.getAppDataelencoMacchineSemi());
		}
		return result;
	}

	public void executeInit1_2(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {
		log.info("[CPBECpDomanda::executeInit1_2] BEGIN");
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = (TaifTPersonaProfiloUtenteByCodiceFiscaleDto) ActionContext
				.getContext().getSession().get("profiloUtente");

		//Integer idProfilo= (Integer) ActionContext.getContext().getSession().get("idProfilo");
		Integer idProfilo = ConvertUtil
				.convertToInteger(theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo());
		//idProfilo = 1;  // Only per TEST MM

		String dataTracciato = theModel.getAppDatatracciato();
		int idAzienda = theModel.getAppDataidAzienda().intValue();
		//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
		ArrayList<CodeDescription> comuni = this.taifMgr.getElencoComuni();
		log.debug("--- COMUNI  " + comuni == null ? "NULL" : "" + comuni.size());
		if (comuni != null) {
			log.debug("[8a]");
			theModel.setAppDataelencoComuniNascitaTitolareRappresentante(comuni);
			theModel.setAppDataelencoComuniResidenzaTitolareRappresentante(comuni);
			theModel.setAppDataelencoComuniNascitaAltroTitolareRappresentante(comuni);
			theModel.setAppDataelencoComuniResidenzaAltroTitolareRappresentante(comuni);
		} else {
			log.debug("[8b]");
			ArrayList<CodeDescription> empty = new ArrayList<CodeDescription>();
			theModel.setAppDataelencoComuniNascitaTitolareRappresentante(empty);
			theModel.setAppDataelencoComuniResidenzaTitolareRappresentante(empty);
			theModel.setAppDataelencoComuniNascitaAltroTitolareRappresentante(empty);
			theModel.setAppDataelencoComuniResidenzaAltroTitolareRappresentante(empty);
		}
		// per update VT 27 Apr2021: la sez 1.2 nella view TaifVApplSchedaOkReale è impostata a 1 di defaulf: entra sempre nell'if anche in insert
		if (scheda != null
				&& (scheda.getFlgSez12ItaOk().byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
						|| scheda.getFlgSez12FraOk()
								.byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt)) {
			//update
			// legale rappresentante appDatatitolareRappresentanteLegale
			TitolareRappresentanteLegale legalerappresentante = taifMgr.findPersoneListByIdAzienda(idAzienda,
					it.csi.taif.taifweb.business.dao.util.Constants.oneInt, dataTracciato);
			theModel.setAppDatatitolareRappresentanteLegale(legalerappresentante);

			if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.fLang)) {
				if (legalerappresentante.getNrsiMsa() != null) {
					theModel.getAppDatatitolareRappresentanteLegale().setNrsiMsa(legalerappresentante.getNrsiMsa());
				} else {
					theModel.getAppDatatitolareRappresentanteLegale()
							.setNrsiMsa(legalerappresentante.getCodiceFiscale());
				}
				if (legalerappresentante.getDsComuneNascitaNoIta() != null) {
					theModel.getAppDatatitolareRappresentanteLegale()
							.setDsComuneNascitaNoIta(legalerappresentante.getDsComuneNascitaNoIta());
				} else {
					theModel.setAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale(
							legalerappresentante.getIdComuneNascita());
				}
				if (legalerappresentante.getDsComuneResidenzaNoIta() != null) {
					theModel.getAppDatatitolareRappresentanteLegale()
							.setDsComuneResidenzaNoIta(legalerappresentante.getDsComuneResidenzaNoIta());
				} else {
					theModel.setAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale(
							legalerappresentante.getIdComuneResidenza());
				}

				theModel.setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
						legalerappresentante.getIdTitoloDiStudio());
			} else {

				theModel.setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
						legalerappresentante.getIdTitoloDiStudio());
				//taif-23
				if (legalerappresentante.getIdComuneNascita() != null) {

					theModel.setAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale(
							legalerappresentante.getIdComuneNascita());
				}
				if (legalerappresentante.getDsComuneNascitaNoIta() != null) {
					theModel.getAppDatatitolareRappresentanteLegale()
							.setDsComuneNascitaNoIta(legalerappresentante.getDsComuneNascitaNoIta());
				}
				//fine taif-23
				theModel.setAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale(
						legalerappresentante.getIdComuneResidenza());

			}
			theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
					legalerappresentante.getIdStatoNascita());

			//corsi
			if (legalerappresentante.getCodiceFiscale() != null) {
				corsoQualificaFilter
						.setCodiceFiscale(theModel.getAppDatatitolareRappresentanteLegale().getCodiceFiscale());
				theModel.setAppDataelencoCorsiSostenutiTitolareRappresentanteLegale(
						taifMgr.getCorsiSostenutiFromUnitaFormativa(getCorsoQualificaFilter(theModel)));
				theModel.setAppDataelencoQualificheTitolareRappresentanteLegale(
						taifMgr.getAltriCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));

				theModel.setAppDataelencoRiconiscimentiTitolareRappresentanteLegale(
						taifMgr.getRiconoscimentiPersona(getCorsoQualificaFilter(theModel)));
			}

			// conduttore azienda

			TitolareRappresentanteLegale conduttore = taifMgr.findPersoneListByIdAzienda(idAzienda,
					it.csi.taif.taifweb.business.dao.util.Constants.twoInt, dataTracciato);
			if (conduttore != null && conduttore.getCodiceFiscale() != null) {
				theModel.setWidg_rbsDatiAnagraficiAltroConducente(it.csi.taif.taifweb.business.dao.util.Constants.NO);

				theModel.setAppDataaltroTitolareRappresentanteLegale(conduttore);
				theModel.setAppDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale(
						conduttore.getIdComuneNascita());
				theModel.setAppDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale(
						conduttore.getIdComuneResidenza());
				theModel.setAppDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale(
						conduttore.getIdStatoNascita());
				theModel.setAppDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale(
						conduttore.getIdTitoloDiStudio());
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente_selectedMultiPanel",
						"CpDomanda_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente_fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente");
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpDatiAnagraficiConduttoreAzienda_selectedMultiPanel",
						"CpDomanda_mpDatiAnagraficiConduttoreAzienda_fpDatiAnagraficiConduttoreAzienda");
			} else {
				theModel.setWidg_rbsDatiAnagraficiAltroConducente(it.csi.taif.taifweb.business.dao.util.Constants.SI);

				log.info("[CPBECpDomanda::executeInit1_2] SONO NELL' ELSE DI CONDUTTORE AZIENDA");
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente_selectedMultiPanel",
						null);
				ActionContext.getContext().getSession()
						.put("CpDomanda_mpDatiAnagraficiConduttoreAzienda_selectedMultiPanel", null);
				theModel.setAppDataaltroTitolareRappresentanteLegale(null);
				theModel.setAppDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale(null);
				theModel.setAppDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale(null);
				theModel.setAppDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale(null);
				theModel.setAppDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale(null);
			}

			// TAIF-27 INSERT PROFILO AZIENDA: Se TitolareRappresentanteLegale (TAIF_T_PERSONA) non è valorizzato vuol dire che siamo in insert 
			//                                 per cui SOLO per l'azienda recupero cf, nome e cognome dal profilo utente
			UserInfo currentUser = theModel.getAppDatacurrentUser();
			if (idProfilo == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
				log.info("[CPBECpDomanda::executeInit1_2] AZIENDA getIdProfiloUtente " + idProfilo);
				if (legalerappresentante.getNome() == null) {
					log.info("[CPBECpDomanda::executeInit1_2] INSERT AZIENDA ");

					corsoQualificaFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
					theModel.setAppDataelencoCorsiSostenutiTitolareRappresentanteLegale(
							taifMgr.getCorsiSostenutiFromUnitaFormativa(getCorsoQualificaFilter(theModel)));
					theModel.setAppDataelencoQualificheTitolareRappresentanteLegale(
							taifMgr.getAltriCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));
					theModel.setAppDataelencoRiconiscimentiTitolareRappresentanteLegale(
							taifMgr.getRiconoscimentiPersona(getCorsoQualificaFilter(theModel)));

					TitolareRappresentanteLegale titolare = this.taifMgr
							.findLastInAnagraficaByCodiceFiscalePersona(theModel.getAppDatacurrentUser().getCodFisc());
					if (titolare.getCodiceFiscale() != null) {
						theModel.setAppDatatitolareRappresentanteLegale(titolare);
						theModel.setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
								titolare.getIdTitoloDiStudio());
						theModel.setAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale(
								titolare.getIdComuneNascita());
						theModel.setAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale(
								titolare.getIdComuneResidenza());
						theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
								titolare.getIdStatoNascita());

						theModel.setWidg_rbsDatiAnagraficiAltroConducente(
								it.csi.taif.taifweb.business.dao.util.Constants.SI);
					} else {
						if (currentUser.getNome() != null) {
							theModel.getAppDatatitolareRappresentanteLegale().setNome(currentUser.getNome());
						}
						if (currentUser.getCognome() != null) {
							theModel.getAppDatatitolareRappresentanteLegale().setCognome(currentUser.getCognome());
						}
						if (currentUser.getCodFisc() != null) {
							theModel.getAppDatatitolareRappresentanteLegale()
									.setCodiceFiscale(currentUser.getCodFisc());
							currentUser.getCodFisc();
						}
					}
				} else {
					log.info("[CPBECpDomanda::executeInit1_2] UPDATE AZIENDA ");

				}
			} else {
				log.info("[CPBECpDomanda::executeInit1_2] NO AZIENDA getIdProfiloUtente " + idProfilo);
			}
			ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			ActionContext.getContext().getSession().put("idProfilo", idProfilo);
		} else {
			//VT CODICE INUTILIZZATO IL FLAG DELLA SEZIONE 1.2 VALE SEMPRE 1 NELLA VIEW
			log.info("[CPBECpDomanda::executeInit1_2] BEGIN INSERT");
			int idNazione = profiloUtente.getIdNazione();
			int idPersona = profiloUtente.getIdPersona();
			VisibileOrdinFilter filter = this.getVisibileOrdinFilter(theModel);
			filter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
			if (idNazione == 1) {
				theModel.setAppDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
						this.taifMgr.getElencoNazioniIta(filter));
			} else {
				log.debug("[6b]");
				theModel.setAppDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
						this.taifMgr.getElencoNazioniFra(filter));
			}
			log.debug("[7]");
			// !=1 --- non inserisco titolare rappresentante
			if (idProfilo != 1) {
				if (theModel.getAppDatatitolareRappresentanteLegale() != null
						&& theModel.getAppDatatitolareRappresentanteLegale().getCodiceFiscale() != null) {
					log.debug("[7a]");
					if (theModel.getAppDatatitolareRappresentanteLegale().getCodiceFiscale() != null) {
						corsoQualificaFilter
								.setCodiceFiscale(theModel.getAppDatatitolareRappresentanteLegale().getCodiceFiscale());
						theModel.setAppDataelencoCorsiSostenutiTitolareRappresentanteLegale(
								taifMgr.getCorsiSostenutiFromUnitaFormativa(getCorsoQualificaFilter(theModel)));
						theModel.setAppDataelencoQualificheTitolareRappresentanteLegale(
								taifMgr.getAltriCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));

						TitolareRappresentanteLegale titolare = this.taifMgr.findInAnagraficaByCodiceFiscalePersona(
								theModel.getAppDatatitolareRappresentanteLegale().getCodiceFiscale());
						theModel.setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
								titolare.getIdTitoloDiStudio());
						theModel.setAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale(
								titolare.getIdComuneNascita());
						theModel.setAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale(
								titolare.getIdComuneResidenza());
						theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
								titolare.getIdStatoNascita());
						theModel.setWidg_rbsDatiAnagraficiAltroConducente(
								it.csi.taif.taifweb.business.dao.util.Constants.SI);
					}
				}
			}
			log.info("[CPBECpDomanda::executeInit1_2] idProfilo " + idProfilo);
			// // ==1 --- inserimento legalerappresentante
			if (idProfilo == 1) {
				if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
					corsoQualificaFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
					theModel.setAppDataelencoCorsiSostenutiTitolareRappresentanteLegale(
							taifMgr.getCorsiSostenutiFromUnitaFormativa(getCorsoQualificaFilter(theModel)));
					theModel.setAppDataelencoQualificheTitolareRappresentanteLegale(
							taifMgr.getAltriCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));

					TitolareRappresentanteLegale titolare = this.taifMgr
							.findInAnagraficaByCodiceFiscalePersona(theModel.getAppDatacurrentUser().getCodFisc());
					theModel.setAppDatatitolareRappresentanteLegale(titolare);
					theModel.setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
							titolare.getIdTitoloDiStudio());
					theModel.setAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale(
							titolare.getIdComuneNascita());
					theModel.setAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale(
							titolare.getIdComuneResidenza());
					theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
							titolare.getIdStatoNascita());

					theModel.setWidg_rbsDatiAnagraficiAltroConducente(
							it.csi.taif.taifweb.business.dao.util.Constants.SI);
				} else {

					corsoQualificaFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
					theModel.setAppDataelencoCorsiSostenutiTitolareRappresentanteLegale(
							taifMgr.getCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));
					theModel.setAppDataelencoQualificheTitolareRappresentanteLegale(
							taifMgr.getAltriCorsiSostenutiTitolare(getCorsoQualificaFilter(theModel)));

					TitolareRappresentanteLegale titolareFrancese = this.taifMgr
							.findByNrSiMsaPersonaFrancese(theModel.getAppDatacurrentUser().getCodFisc());

					theModel.setAppDatatitolareRappresentanteLegale(titolareFrancese);
					theModel.setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
							titolareFrancese.getIdTitoloDiStudio());
					theModel.setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
							titolareFrancese.getIdStatoNascita());

					theModel.getAppDatatitolareRappresentanteLegale()
							.setDsComuneNascitaNoIta(titolareFrancese.getDsComuneNascitaNoIta());
					theModel.getAppDatatitolareRappresentanteLegale()
							.setDsComuneResidenzaNoIta(titolareFrancese.getDsComuneResidenzaNoIta());
				}
			}
			ActionContext.getContext().getSession().put("idProfilo", idProfilo);
		} // end if --insert	- scheda VT END NON UTILIZZATO

		ActionContext.getContext().getSession().put("idProfilo", idProfilo);
		this.setVisibility(theModel, DomandaViewHelper.initScheda1_2(theModel));
		log.debug("[CPBECpDomanda::executeInit1_2] END");
	}
	private CorsoQualificaFilter getCorsoQualificaFilter(CpDomandaModel theModel) {
		corsoQualificaFilter.setFlagItaFr(theModel.getAppDatatracciato());
		corsoQualificaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		return corsoQualificaFilter;
	}

	public void executeInit6(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {

		String dataTracciato = theModel.getAppDatatracciato();

		int idAzienda = theModel.getAppDataidAzienda().intValue();

		visibileOrdinFilter = getVisibileOrdinFilter(theModel);
		//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
		if (scheda != null
				&& (scheda.getFlgSez6ItaOk().byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
						|| scheda.getFlgSez6FraOk()
								.byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt)) {
			// scheda !=1
			if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				ArrayList<Personale> personePerAziendaList = taifMgr.getElencoPersonaleAzienda(idAzienda,
						this.getVisibileOrdinFilter(theModel));
				CorsoQualificaFilter corsoFilter = new CorsoQualificaFilter();
				corsoFilter.setFlagItaFr(dataTracciato);
				corsoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
				int i = 0;
				if (personePerAziendaList != null && !personePerAziendaList.isEmpty()) {
					//					for (Personale personale : personePerAziendaList) {
					//						corsoFilter.setCodiceFiscale(personale.getCodiceFiscale());
					//						personale.setElencoContratti(taifMgr.getElencoContratti(visibileOrdinFilter));
					//						personale.setElencoDurateContratto(taifMgr.getDurataContratto());
					//						personale.setElencoInquadramenti(taifMgr.getElencoInquadramenti(visibileOrdinFilter));
					//						personale.setElencoMansioni(taifMgr.getElencoMansioni(visibileOrdinFilter));
					//						personale.setElencoTipologiaPersonale(taifMgr.getElencoTipologiaPersonale(visibileOrdinFilter));
					//						personale.setCorsi(taifMgr.findCorsiPerPersona(corsoFilter));
					//						personale.setRownum(i++);
					//					}

					theModel.setWidg_rbsPersonale(Constants.SI);
					//ActionContext.getContext().getSession().put("CpDomanda_mpAltroPersonale_selectedMultiPanel",
					//		"CpDomanda_mpAltroPersonale_fpAltroPersonale");

				} else {
					theModel.setWidg_rbsPersonale(Constants.NO);
					//ActionContext.getContext().getSession().put("CpDomanda_mpAltroPersonale_selectedMultiPanel", null);
				}

				theModel.setAppDataelencoPersonale(personePerAziendaList);

			} else {

				//				ActionContext.getContext().getSession().put("CpDomanda_mpAltroPersonale_selectedMultiPanel",
				//						null);
				// tracciato Francese
				ArrayList<PersonaleFr> listPersonaleContratto = new ArrayList<PersonaleFr>();
				ArrayList<PersonaleFr> listPersonaleMansione = new ArrayList<PersonaleFr>();
				ArrayList<PersonaleFr> personaleContrattoList = new ArrayList<PersonaleFr>();
				ArrayList<PersonaleFr> personaleMansioneList = new ArrayList<PersonaleFr>();
				theModel.setAppDatagestioneAltroPersonaleFr(new GestionePersonaleFr());
				List<TaifRAziendaFrTipoContrFindTipoByIdAziendaDto> allContrattiPerAziendaFr = taifMgr
						.getContrattoByAziendaFrancese(idAzienda);

				if (allContrattiPerAziendaFr != null && !allContrattiPerAziendaFr.isEmpty()) {
					for (TaifRAziendaFrTipoContrFindTipoByIdAziendaDto aziendaContratto : allContrattiPerAziendaFr) {
						PersonaleFr personaleContratto = new PersonaleFr();
						personaleContratto.setIdTipologia(aziendaContratto.getIdTipoContr());
						personaleContratto.setDsTipologia(aziendaContratto.getTipoContratto());
						personaleContratto.setNumeroAddetti(aziendaContratto.getNrAdetti());
						personaleContrattoList.add(personaleContratto);
					}
					theModel.setAppDataelencoAltroPersonaleTipoContrattoFr(personaleContrattoList);
				} else {
					List<TaifDTipoContrattoByVisibleOrdinDto> elencoContrattiFrancese = taifMgr
							.getElencoContrattiPerTracciato(visibileOrdinFilter);
					for (TaifDTipoContrattoByVisibleOrdinDto contrattoFrancese : elencoContrattiFrancese) {
						PersonaleFr personaleContratto = new PersonaleFr();
						personaleContratto.setIdTipologia(contrattoFrancese.getId());
						personaleContratto.setDsTipologia(contrattoFrancese.getTipo());
						personaleContratto.setNumeroAddetti(0);
						listPersonaleContratto.add(personaleContratto);
					}
					theModel.setAppDataelencoAltroPersonaleTipoContrattoFr(listPersonaleContratto);
				}
				List<TaifRAziendaFrTipoMansFindTipoByIdAziendaDto> allMansioniPerAziendaFr = taifMgr
						.getMansioneByAziendaFrancese(idAzienda);
				if (allMansioniPerAziendaFr != null && !allMansioniPerAziendaFr.isEmpty()) {
					for (TaifRAziendaFrTipoMansFindTipoByIdAziendaDto aziendaManzione : allMansioniPerAziendaFr) {
						PersonaleFr personaleMansione = new PersonaleFr();
						personaleMansione.setIdTipologia(aziendaManzione.getIdTipoMansione());
						personaleMansione.setDsTipologia(aziendaManzione.getTipoMansione());
						personaleMansione.setNumeroAddetti(aziendaManzione.getNrAdetti());
						personaleMansioneList.add(personaleMansione);
					}
					theModel.setAppDataelencoAltroPersonaleTipoMansioneFr(personaleMansioneList);
				} else {
					List<TaifDTipoMansioneByVisibleOrdinDto> elencoMansioniFrancese = taifMgr
							.getElencoMansioniPerTracciato(visibileOrdinFilter);
					for (TaifDTipoMansioneByVisibleOrdinDto mansioniFrancese : elencoMansioniFrancese) {
						PersonaleFr personaleMansione = new PersonaleFr();
						personaleMansione.setIdTipologia(mansioniFrancese.getId());
						personaleMansione.setDsTipologia(mansioniFrancese.getTipo());
						personaleMansione.setNumeroAddetti(0);
						listPersonaleMansione.add(personaleMansione);
					}
					theModel.setAppDataelencoAltroPersonaleTipoMansioneFr(listPersonaleMansione);
				}

				TaifTAziendaDto aziendaFindet = taifMgr.getAziendaById(idAzienda);
				if (theModel.getAppDatagestioneAltroPersonaleFr() != null) {
					if (aziendaFindet.getTempsPleinFra() != null) {
						theModel.getAppDatagestioneAltroPersonaleFr()
								.setNumeroEquivalenti(String.valueOf(aziendaFindet.getTempsPleinFra()));
					} else {
						theModel.getAppDatagestioneAltroPersonaleFr().setNumeroEquivalenti(String.valueOf(0));
					}
					if (aziendaFindet.getNbreSalariesFra() != null) {
						theModel.getAppDatagestioneAltroPersonaleFr()
								.setNumeroTotaleAddetti(aziendaFindet.getNbreSalariesFra());
					} else {
						theModel.getAppDatagestioneAltroPersonaleFr().setNumeroTotaleAddetti(0);
					}
				}
				//theModel.setWidg_rbsPersonale(Constants.SI);
			}
			ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
		} else {

			if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				// no scheda=1 - insert
				theModel.setAppDataelencoPersonaleSuggerito(new ArrayList<CodeDescription>());
				theModel.setAppDataelencoPersonale(taifMgr.getElencoPersonaleAzienda(theModel.getAppDataidAzienda(),
						this.getVisibileOrdinFilter(theModel)));

				int i = 0;
				if (theModel.getAppDataelencoPersonale() != null && !theModel.getAppDataelencoPersonale().isEmpty()) {
					for (Personale personale : theModel.getAppDataelencoPersonale()) {
						personale.setElencoContratti(taifMgr.getElencoContratti(visibileOrdinFilter));
						personale.setElencoDurateContratto(taifMgr.getDurataContratto());
						personale.setElencoInquadramenti(taifMgr.getElencoInquadramenti(visibileOrdinFilter));
						personale.setElencoMansioni(taifMgr.getElencoMansioni(visibileOrdinFilter));
						personale.setElencoTipologiaPersonale(taifMgr.getElencoTipologiaPersonale(visibileOrdinFilter));
						personale.setRownum(i++);
					}
					theModel.setWidg_rbsPersonale(Constants.SI);
				} else {
					theModel.setWidg_rbsPersonale(Constants.NO);
				}
			} else {
				// tracciato francese
				ArrayList<PersonaleFr> listPersonaleContratto = new ArrayList<PersonaleFr>();
				ArrayList<PersonaleFr> listPersonaleMansione = new ArrayList<PersonaleFr>();
				ArrayList<PersonaleFr> personaleContrattoList = new ArrayList<PersonaleFr>();
				ArrayList<PersonaleFr> personaleMansioneList = new ArrayList<PersonaleFr>();
				theModel.setAppDatagestioneAltroPersonaleFr(new GestionePersonaleFr());
				List<TaifRAziendaFrTipoContrFindTipoByIdAziendaDto> allContrattiPerAziendaFr = taifMgr
						.getContrattoByAziendaFrancese(idAzienda);

				if (allContrattiPerAziendaFr != null && !allContrattiPerAziendaFr.isEmpty()) {
					for (TaifRAziendaFrTipoContrFindTipoByIdAziendaDto aziendaContratto : allContrattiPerAziendaFr) {
						PersonaleFr personaleContratto = new PersonaleFr();
						personaleContratto.setIdTipologia(aziendaContratto.getIdTipoContr());
						personaleContratto.setDsTipologia(aziendaContratto.getTipoContratto());
						personaleContratto.setNumeroAddetti(aziendaContratto.getNrAdetti());
						personaleContrattoList.add(personaleContratto);
					}
					theModel.setAppDataelencoAltroPersonaleTipoContrattoFr(personaleContrattoList);
				} else {
					List<TaifDTipoContrattoByVisibleOrdinDto> elencoContrattiFrancese = taifMgr
							.getElencoContrattiPerTracciato(visibileOrdinFilter);
					for (TaifDTipoContrattoByVisibleOrdinDto contrattoFrancese : elencoContrattiFrancese) {
						PersonaleFr personaleContratto = new PersonaleFr();
						personaleContratto.setIdTipologia(contrattoFrancese.getId());
						personaleContratto.setDsTipologia(contrattoFrancese.getTipo());
						personaleContratto.setNumeroAddetti(0);
						listPersonaleContratto.add(personaleContratto);
					}
					theModel.setAppDataelencoAltroPersonaleTipoContrattoFr(listPersonaleContratto);
				}
				List<TaifRAziendaFrTipoMansFindTipoByIdAziendaDto> allMansioniPerAziendaFr = taifMgr
						.getMansioneByAziendaFrancese(idAzienda);
				if (allMansioniPerAziendaFr != null && !allMansioniPerAziendaFr.isEmpty()) {
					for (TaifRAziendaFrTipoMansFindTipoByIdAziendaDto aziendaManzione : allMansioniPerAziendaFr) {
						PersonaleFr personaleMansione = new PersonaleFr();
						personaleMansione.setIdTipologia(aziendaManzione.getIdTipoMansione());
						personaleMansione.setDsTipologia(aziendaManzione.getTipoMansione());
						personaleMansione.setNumeroAddetti(aziendaManzione.getNrAdetti());
						personaleMansioneList.add(personaleMansione);
					}
					theModel.setAppDataelencoAltroPersonaleTipoMansioneFr(personaleMansioneList);
				} else {
					List<TaifDTipoMansioneByVisibleOrdinDto> elencoMansioniFrancese = taifMgr
							.getElencoMansioniPerTracciato(visibileOrdinFilter);
					for (TaifDTipoMansioneByVisibleOrdinDto mansioniFrancese : elencoMansioniFrancese) {
						PersonaleFr personaleMansione = new PersonaleFr();
						personaleMansione.setIdTipologia(mansioniFrancese.getId());
						personaleMansione.setDsTipologia(mansioniFrancese.getTipo());
						personaleMansione.setNumeroAddetti(0);
						listPersonaleMansione.add(personaleMansione);
					}
					theModel.setAppDataelencoAltroPersonaleTipoMansioneFr(listPersonaleMansione);
				}
				TaifTAziendaDto aziendaFindet = taifMgr.getAziendaById(idAzienda);
				if (theModel.getAppDatagestioneAltroPersonaleFr() != null) {
					if (aziendaFindet.getTempsPleinFra() != null) {
						theModel.getAppDatagestioneAltroPersonaleFr()
								.setNumeroEquivalenti(String.valueOf(aziendaFindet.getTempsPleinFra()));
					} else {
						theModel.getAppDatagestioneAltroPersonaleFr().setNumeroEquivalenti(String.valueOf(0));
					}
					if (aziendaFindet.getNbreSalariesFra() != null) {
						theModel.getAppDatagestioneAltroPersonaleFr()
								.setNumeroTotaleAddetti(aziendaFindet.getNbreSalariesFra());
					} else {
						theModel.getAppDatagestioneAltroPersonaleFr().setNumeroTotaleAddetti(0);
					}
				}

				//theModel.setWidg_rbsPersonale(Constants.SI);
			}
		}

		this.setVisibility(theModel, DomandaViewHelper.initScheda6(theModel));
	}

	public void executeInit5_2(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {

		if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {

			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.catTerra);

			theModel.setAppDataelencoMacchineTrattrici(taifMgr.getElencoMacchine(tipoMezzoFilter, Constants.trattrice));
			theModel.setAppDataelencoMacchineSpeciali(
					taifMgr.getElencoMacchineCategoria(tipoMezzoFilter, Constants.speciali));
			theModel.setAppDataelencoMacchineMovimentoTerra(
					taifMgr.getElencoMacchineCategoria(tipoMezzoFilter, Constants.catTerra));
			theModel.setAppDataelencoMacchineRimorchi(taifMgr.getElencoMacchine(tipoMezzoFilter, Constants.rimorchio));
			theModel.setAppDataelencoMacchineVerricelli(
					taifMgr.getElencoMacchine(tipoMezzoFilter, Constants.verricello));
			theModel.setAppDataelencoMacchinePle(taifMgr.getElencoMacchine(tipoMezzoFilter, Constants.PLE));
			theModel.setAppDataelencoMacchineTrinciaForestali(
					taifMgr.getElencoMacchine(tipoMezzoFilter, Constants.trincia));
			theModel.setAppDataelencoMacchineSegheriaMobile(
					taifMgr.getElencoMacchineCategoria(tipoMezzoFilter, Constants.segherie));
			theModel.setAppDataelencoMacchineGruACavo(
					taifMgr.getElencoMacchineCategoria(tipoMezzoFilter, Constants.gru));
			theModel.setAppDataelencoMacchineCippatrici(
					taifMgr.getElencoMacchine(tipoMezzoFilter, Constants.cippatrice));
			theModel.setAppDataelencoMezziDiTrasporto(
					taifMgr.getElencoMacchineCategoria(tipoMezzoFilter, Constants.mezzi));
			theModel.setAppDataelencoAltriMezzi(taifMgr.getElencoMacchine(tipoMezzoFilter, Constants.altroMezzo));

		} else {

			tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
			tipoMezzoFilter.setCategoriaMezzo(Constants.speciales);

			theModel.setAppDataelencoMacchineSpecialiFr(
					taifMgr.getElencoMacchineCategoria(tipoMezzoFilter, Constants.speciali));
			theModel.setAppDataelencoMacchineMovimentoTerraFr(
					taifMgr.getElencoMacchineCategoria(tipoMezzoFilter, Constants.terra));
			theModel.setAppDataelencoMacchineGrumier(taifMgr.getElencoMacchine(tipoMezzoFilter,
					it.csi.taif.taifweb.business.dao.util.Constants.Grumier));
			theModel.setAppDataelencoMacchineRimorchiFr(
					taifMgr.getElencoMacchine(tipoMezzoFilter, it.csi.taif.taifweb.business.dao.util.Constants.Camion));
			theModel.setAppDataelencoMacchineSemi(
					taifMgr.getElencoMacchine(tipoMezzoFilter, it.csi.taif.taifweb.business.dao.util.Constants.Semi));

		}

		visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);

		int idAzienda = theModel.getAppDataidAzienda().intValue();
		String dataTracciato = theModel.getAppDatatracciato();
		//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
		if (scheda != null) {
			if (scheda.getFlgSez52ItaOk().byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
					|| scheda.getFlgSez52FraOk()
							.byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {

				if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {

					// find macchineTrattrice
					int i = 0;
					ArrayList<MacchinaMezzo> macchinaTrattriceList = new ArrayList<MacchinaMezzo>();
					tipoMezzoFilter.setIdTipoMezzo(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					tipoMezzoFilter.setTipoMezzo(Constants.trattrice);
					List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listTrattrici = taifMgr
							.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
					if (listTrattrici != null && !listTrattrici.isEmpty()) {
						// public ArrayList<CodeDescription> getElencoTipoTrazioniPerTipoMezzo(TipoMezzoFilter filter)throws ManagerException {
						i = 0;
						for (TaifTMezzoByTipoMezzoAziendaVisibileDto trattrici : listTrattrici) {
							MacchinaMezzo macchinaTrattrice = new MacchinaMezzo();
							macchinaTrattrice.setAnnoImmatricolazione(String.valueOf(trattrici.getAnno()));
							macchinaTrattrice.setPotenza(String.valueOf(trattrici.getPotenza()));
							macchinaTrattrice.setIdTipoTrazione(trattrici.getIdTipoTrazione());
							macchinaTrattrice.setIdTipoNoleggio(trattrici.getNoleggio().intValue());
							macchinaTrattrice.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							macchinaTrattrice
									.setElencoTipoTrazione(taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter));
							macchinaTrattrice.setIdMacchinaMezzo(trattrici.getId());
							macchinaTrattrice.setRownum(i);
							i++;
							macchinaTrattriceList.add(macchinaTrattrice);
						}
						if (macchinaTrattriceList != null && !macchinaTrattriceList.isEmpty()) {
							theModel.setAppDataelencoMacchineTrattrici(macchinaTrattriceList);
							theModel.setWidg_chbAttrezzatureMacchinaTrattrici(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchinaTrattrici(false);
						}
					}
					// speciali
					List<TaifTMezzoByIdTipoMezzoAziendaDto> allMacchine = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();

					List<Integer> idTipoMezzoList = new ArrayList<Integer>();
					tipoMezzoFilter.setCategoriaMezzo(Constants.speciali);
					tipoMezzoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					tipoMezzoFilter.setFlagItaFr(dataTracciato);
					tipoMezzoFilter.setIdAzienda(idAzienda);

					List<TaifDTipoMezzoByCategoriaMezzoDto> elencoMacchinePerCategoria = taifMgr
							.cercaTipoMezzoPerCategoriaMezzo(tipoMezzoFilter);
					if (elencoMacchinePerCategoria != null && !elencoMacchinePerCategoria.isEmpty()) {
						for (TaifDTipoMezzoByCategoriaMezzoDto mezzoCategoria : elencoMacchinePerCategoria) {
							idTipoMezzoList.add(mezzoCategoria.getId());
						}
					}
					for (Integer idTipoMezzo : idTipoMezzoList) {
						tipoMezzoFilter.setIdTipoMezzo(idTipoMezzo);
						List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzo = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
						listMezzo = taifMgr.findMezzoByIdTipoMezzoAzienda(tipoMezzoFilter);
						allMacchine.addAll(listMezzo);
					}

					ArrayList<MacchinaMezzo> macchinaSpecialeList = new ArrayList<MacchinaMezzo>();
					if (allMacchine != null && !allMacchine.isEmpty()) {
						i = 0;
						for (TaifTMezzoByIdTipoMezzoAziendaDto speciali : allMacchine) {
							MacchinaMezzo speciale = new MacchinaMezzo();
							speciale.setAnnoImmatricolazione(String.valueOf(speciali.getAnno()));
							speciale.setPotenza(String.valueOf(speciali.getPotenza()));
							speciale.setIdTipoTrazione(speciali.getIdTipoTrazione());
							speciale.setIdTipoNoleggio(speciali.getNoleggio().intValue());
							speciale.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							speciale.setIdTipoMacchinaMezzo(speciali.getIdTipoMezzo());
							speciale.setElencoTipoMacchinaMezzo(taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter));
							speciale.setIdMacchinaMezzo(speciali.getIdMezzo());
							speciale.setRownum(i);
							i++;
							macchinaSpecialeList.add(speciale);
						}
						if (macchinaSpecialeList != null && !macchinaSpecialeList.isEmpty()) {
							theModel.setAppDataelencoMacchineSpeciali(macchinaSpecialeList);
							theModel.setWidg_chbAttrezzatureMacchineSpeciali(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchineSpeciali(false);
						}
					}
					// speciali movimentoTerra

					List<TaifTMezzoByIdTipoMezzoAziendaDto> allTerra = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
					List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzoTerra = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
					List<Integer> idTipoTerraList = new ArrayList<Integer>();
					tipoMezzoFilter.setCategoriaMezzo(Constants.catTerra);
					tipoMezzoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					tipoMezzoFilter.setFlagItaFr(dataTracciato);
					tipoMezzoFilter.setIdAzienda(idAzienda);

					List<TaifDTipoMezzoByCategoriaMezzoDto> elencoMacchineTerraPerCategoria = taifMgr
							.cercaTipoMezzoPerCategoriaMezzo(tipoMezzoFilter);
					if (elencoMacchineTerraPerCategoria != null && !elencoMacchineTerraPerCategoria.isEmpty()) {
						for (TaifDTipoMezzoByCategoriaMezzoDto terraCategoria : elencoMacchineTerraPerCategoria) {
							idTipoTerraList.add(terraCategoria.getId());
						}
					}
					for (Integer idTipoMezzo : idTipoTerraList) {
						tipoMezzoFilter.setIdTipoMezzo(idTipoMezzo);
						List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzo1 = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
						listMezzo1 = taifMgr.findMezzoByIdTipoMezzoAzienda(tipoMezzoFilter);
						allTerra.addAll(listMezzo1);
					}

					ArrayList<MacchinaMezzo> macchinaTerraList = new ArrayList<MacchinaMezzo>();
					if (allTerra != null && !allTerra.isEmpty()) {
						i = 0;
						for (TaifTMezzoByIdTipoMezzoAziendaDto terraMacchine : allTerra) {
							MacchinaMezzo terra = new MacchinaMezzo();
							terra.setAnnoImmatricolazione(String.valueOf(terraMacchine.getAnno()));
							terra.setPotenza(String.valueOf(terraMacchine.getPotenza()));
							terra.setIdTipoTrazione(terraMacchine.getIdTipoTrazione());
							terra.setIdTipoNoleggio(terraMacchine.getNoleggio().intValue());
							terra.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							terra.setIdTipoMacchinaMezzo(terraMacchine.getIdTipoMezzo());
							terra.setIdTipoTrazione(terraMacchine.getIdTipoTrazione());
							terra.setIdMacchinaMezzo(terraMacchine.getIdMezzo());
							terra.setRownum(i);
							i++;
							tipoMezzoFilter.setTipoMezzo(terraMacchine.getTipoMezzo());
							terra.setElencoTipoMacchinaMezzo(taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter));
							terra.setElencoTipoTrazione(taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter));

							macchinaTerraList.add(terra);
						}
						if (macchinaTerraList != null && !macchinaTerraList.isEmpty()) {
							theModel.setAppDataelencoMacchineMovimentoTerra(macchinaTerraList);
							theModel.setWidg_chbAttrezzatureMacchineMovimentoATerra(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchineMovimentoATerra(false);
						}
					}

					// find Rimorchi 
					ArrayList<MacchinaMezzo> rimorchiList = new ArrayList<MacchinaMezzo>();
					tipoMezzoFilter.setIdTipoMezzo(10);
					tipoMezzoFilter.setTipoMezzo(Constants.rimorchio);
					List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listRimorchi = taifMgr
							.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
					if (listRimorchi != null && !listRimorchi.isEmpty()) {
						i = 0;
						for (TaifTMezzoByTipoMezzoAziendaVisibileDto rimorchi : listRimorchi) {
							MacchinaMezzo macchinaRimorchio = new MacchinaMezzo();
							macchinaRimorchio.setAnnoImmatricolazione(String.valueOf(rimorchi.getAnno()));
							macchinaRimorchio.setPotenza(String.valueOf(rimorchi.getPotenza()));
							macchinaRimorchio.setIdTipoTrazione(rimorchi.getIdTipoTrazione());
							macchinaRimorchio.setIdTipoNoleggio(rimorchi.getNoleggio().intValue());
							macchinaRimorchio.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							macchinaRimorchio
									.setElencoTipoTrazione(taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter));
							macchinaRimorchio.setIdMacchinaMezzo(rimorchi.getId());
							macchinaRimorchio.setRownum(i);
							i++;
							rimorchiList.add(macchinaRimorchio);
						}
						if (rimorchiList != null && !rimorchiList.isEmpty()) {
							theModel.setAppDataelencoMacchineRimorchi(rimorchiList);
							theModel.setWidg_chbAttrezzatureMacchinaRimorchi(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchinaRimorchi(false);
						}
					}

					// find Verricelli 
					ArrayList<MacchinaMezzo> vericelliList = new ArrayList<MacchinaMezzo>();
					tipoMezzoFilter.setIdTipoMezzo(11);
					tipoMezzoFilter.setTipoMezzo(Constants.verricello);
					List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listVericelli = taifMgr
							.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
					if (listVericelli != null && !listVericelli.isEmpty()) {
						i = 0;
						for (TaifTMezzoByTipoMezzoAziendaVisibileDto vericello : listVericelli) {
							MacchinaMezzo macchinaVerricello = new MacchinaMezzo();
							macchinaVerricello.setAnnoImmatricolazione(String.valueOf(vericello.getAnno()));
							macchinaVerricello.setPotenza(String.valueOf(vericello.getPotenza()));
							macchinaVerricello.setIdTipoTrazione(vericello.getIdTipoTrazione());
							macchinaVerricello.setIdTipoNoleggio(vericello.getNoleggio().intValue());
							macchinaVerricello.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							if (vericello.getComando().intValueExact() == 1) {
								macchinaVerricello.setComandatoADistanza(true);
							} else {
								macchinaVerricello.setComandatoADistanza(false);
							}
							macchinaVerricello.setIdMacchinaMezzo(vericello.getId());
							macchinaVerricello.setRownum(i);
							i++;
							vericelliList.add(macchinaVerricello);
						}
						if (vericelliList != null && !vericelliList.isEmpty()) {
							theModel.setAppDataelencoMacchineVerricelli(vericelliList);
							theModel.setWidg_chbAttrezzatureMacchinaVerricelli(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchinaVerricelli(false);
						}
					}
					// find PLE 
					ArrayList<MacchinaMezzo> piattaformaPleList = new ArrayList<MacchinaMezzo>();
					tipoMezzoFilter.setIdTipoMezzo(13);
					tipoMezzoFilter.setTipoMezzo(Constants.PLE);
					List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listPiattaforma = taifMgr
							.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
					if (listPiattaforma != null && !listPiattaforma.isEmpty()) {
						i = 0;
						for (TaifTMezzoByTipoMezzoAziendaVisibileDto piattaforma : listPiattaforma) {
							MacchinaMezzo macchinaPLE = new MacchinaMezzo();
							macchinaPLE.setAnnoImmatricolazione(String.valueOf(piattaforma.getAnno()));
							macchinaPLE.setPotenza(String.valueOf(piattaforma.getPotenza()));
							macchinaPLE.setIdTipoNoleggio(piattaforma.getNoleggio().intValueExact());
							macchinaPLE.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							macchinaPLE.setIdMacchinaMezzo(piattaforma.getId());
							macchinaPLE.setRownum(i);
							i++;
							piattaformaPleList.add(macchinaPLE);
						}
						if (piattaformaPleList != null && !piattaformaPleList.isEmpty()) {
							theModel.setAppDataelencoMacchinePle(piattaformaPleList);
							theModel.setWidg_chbAttrezzatureMacchinaPle(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchinaPle(false);
						}
					}
					// findTrincia 
					ArrayList<MacchinaMezzo> trinciaList = new ArrayList<MacchinaMezzo>();
					tipoMezzoFilter.setIdTipoMezzo(12);
					tipoMezzoFilter.setTipoMezzo(Constants.trincia);
					List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listTrinciaForestale = taifMgr
							.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
					if (listTrinciaForestale != null && !listTrinciaForestale.isEmpty()) {
						i = 0;
						for (TaifTMezzoByTipoMezzoAziendaVisibileDto piattaformaF : listTrinciaForestale) {
							MacchinaMezzo trincoaFo = new MacchinaMezzo();
							trincoaFo.setAnnoImmatricolazione(String.valueOf(piattaformaF.getAnno()));
							trincoaFo.setPotenza(String.valueOf(piattaformaF.getPotenza()));
							trincoaFo.setIdTipoNoleggio(piattaformaF.getNoleggio().intValueExact());
							trincoaFo.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							trincoaFo.setIdMacchinaMezzo(piattaformaF.getId());
							trincoaFo.setRownum(i);
							i++;

							trinciaList.add(trincoaFo);
						}
						if (trinciaList != null && !trinciaList.isEmpty()) {
							theModel.setAppDataelencoMacchineTrinciaForestali(trinciaList);
							theModel.setWidg_chbAttrezzatureMacchinaTrinciaForestale(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchinaTrinciaForestale(false);
						}
					}
					// segherie mobili
					List<TaifTMezzoByIdTipoMezzoAziendaDto> allMacchineSegherie = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
					List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzoSegherie = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
					List<Integer> idTipoSegherieList = new ArrayList<Integer>();
					tipoMezzoFilter.setCategoriaMezzo(Constants.catSegherie);
					tipoMezzoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					tipoMezzoFilter.setFlagItaFr(dataTracciato);
					tipoMezzoFilter.setIdAzienda(idAzienda);

					List<TaifDTipoMezzoByCategoriaMezzoDto> elencoSegheriePerCategoria = taifMgr
							.cercaTipoMezzoPerCategoriaMezzo(tipoMezzoFilter);
					if (elencoMacchinePerCategoria != null && !elencoMacchinePerCategoria.isEmpty()) {
						for (TaifDTipoMezzoByCategoriaMezzoDto mezzoCategoria : elencoSegheriePerCategoria) {
							idTipoSegherieList.add(mezzoCategoria.getId());
						}
					}
					i = 0;
					for (Integer idTipoMezzo : idTipoSegherieList) {
						tipoMezzoFilter.setIdTipoMezzo(idTipoMezzo);
						List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzo2 = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
						listMezzo2 = taifMgr.findMezzoByIdTipoMezzoAzienda(tipoMezzoFilter);
						allMacchineSegherie.addAll(listMezzo2);
					}

					ArrayList<MacchinaMezzo> macchinaSegherieList = new ArrayList<MacchinaMezzo>();
					if (allMacchineSegherie != null && !allMacchineSegherie.isEmpty()) {
						i = 0;
						for (TaifTMezzoByIdTipoMezzoAziendaDto segherieMacchina : allMacchineSegherie) {
							MacchinaMezzo segherie = new MacchinaMezzo();
							segherie.setAnnoImmatricolazione(String.valueOf(segherieMacchina.getAnno()));
							segherie.setPotenza(String.valueOf(segherieMacchina.getPotenza()));
							segherie.setIdTipoNoleggio(segherieMacchina.getNoleggio().intValue());
							segherie.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							segherie.setIdTipoMacchinaMezzo(segherieMacchina.getIdTipoMezzo());
							segherie.setElencoTipoMacchinaMezzo(taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter));
							segherie.setElencoTipoAlimentazione(
									taifMgr.getElencoTipoAlimentazione(visibileOrdinFilter));
							segherie.setIdTipoAlimentazione(segherieMacchina.getIdAlimentazione());
							segherie.setIdMacchinaMezzo(segherieMacchina.getIdMezzo());
							segherie.setRownum(i);
							i++;
							macchinaSegherieList.add(segherie);
						}
						if (macchinaSegherieList != null && !macchinaSegherieList.isEmpty()) {
							theModel.setAppDataelencoMacchineSegheriaMobile(macchinaSegherieList);
							theModel.setWidg_chbAttrezzatureMacchineSegherieMobili(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchineSegherieMobili(false);
						}
					}

					// gru a cavo
					ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto> allMacchineGru = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();

					idTipoSegherieList = new ArrayList<Integer>();
					tipoMezzoFilter.setCategoriaMezzo(Constants.catGru);
					tipoMezzoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					tipoMezzoFilter.setFlagItaFr(dataTracciato);
					tipoMezzoFilter.setIdAzienda(idAzienda);

					List<TaifDTipoMezzoByCategoriaMezzoDto> elencoMezziCategoria = taifMgr
							.cercaTipoMezzoPerCategoriaMezzo(tipoMezzoFilter);
					if (elencoMezziCategoria != null && !elencoMezziCategoria.isEmpty()) {
						for (TaifDTipoMezzoByCategoriaMezzoDto mezzoCategoria : elencoMezziCategoria) {
							idTipoSegherieList.add(mezzoCategoria.getId());
						}
					}
					for (Integer idTipoMezzo : idTipoSegherieList) {
						tipoMezzoFilter.setIdTipoMezzo(idTipoMezzo);
						List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzo3 = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
						listMezzo3 = taifMgr.findMezzoByIdTipoMezzoAzienda(tipoMezzoFilter);
						allMacchineGru.addAll(listMezzo3);
					}

					ArrayList<MacchinaMezzo> macchinaGruList = new ArrayList<MacchinaMezzo>();
					if (allMacchineGru != null && !allMacchineGru.isEmpty()) {
						i = 0;
						for (TaifTMezzoByIdTipoMezzoAziendaDto gruMacchina : allMacchineGru) {
							MacchinaMezzo gruCavo = new MacchinaMezzo();
							gruCavo.setAnnoImmatricolazione(String.valueOf(gruMacchina.getAnno()));
							gruCavo.setPotenza(String.valueOf(gruMacchina.getPotenza()));
							gruCavo.setIdTipoNoleggio(gruMacchina.getNoleggio().intValue());
							gruCavo.setPortata(String.valueOf(gruMacchina.getPortata()));
							gruCavo.setIdTipoMacchinaMezzo(gruMacchina.getIdTipoMezzo());
							gruCavo.setIdTipoCarrello(gruMacchina.getIdTipoCarrel());
							gruCavo.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							gruCavo.setElencoTipoMacchinaMezzo(taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter));
							gruCavo.setElencoTipoCarrello(taifMgr.getElencoTipoCarrello(visibileOrdinFilter));
							gruCavo.setIdMacchinaMezzo(gruMacchina.getIdMezzo());
							gruCavo.setRownum(i);
							i++;
							macchinaGruList.add(gruCavo);
						}
						if (macchinaGruList != null && !macchinaGruList.isEmpty()) {
							theModel.setAppDataelencoMacchineGruACavo(macchinaGruList);
							theModel.setWidg_chbAttrezzatureMacchineGruACavo(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchineGruACavo(false);
						}
					}

					// cippatrici
					ArrayList<MacchinaMezzo> macchinaCippatricceList = new ArrayList<MacchinaMezzo>();
					tipoMezzoFilter.setIdTipoMezzo(21);
					tipoMezzoFilter.setTipoMezzo(Constants.cippatrice);
					//taif-19
					tipoMezzoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					tipoMezzoFilter.setFlagItaFr(dataTracciato);
					tipoMezzoFilter.setIdAzienda(idAzienda);
					//fine taif-19
					List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listCippatricci = taifMgr
							.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
					if (listCippatricci != null && !listCippatricci.isEmpty()) {
						i = 0;
						for (TaifTMezzoByTipoMezzoAziendaVisibileDto cipatricci : listCippatricci) {
							MacchinaMezzo cippatricce = new MacchinaMezzo();
							cippatricce.setAnnoImmatricolazione(String.valueOf(cipatricci.getAnno()));
							cippatricce.setPotenza(String.valueOf(cipatricci.getPotenza()));
							if (cipatricci.getIdAlimentazione() != null) {
								cippatricce.setIdTipoAlimentazione(cipatricci.getIdAlimentazione());
							} else {
								cippatricce.setIdTipoAlimentazione(1);
							}
							cippatricce.setIdTipoNoleggio(cipatricci.getNoleggio().intValue());
							cippatricce.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							cippatricce.setElencoTipoAlimentazione(
									taifMgr.getElencoTipoAlimentazione(visibileOrdinFilter));
							cippatricce.setIdMacchinaMezzo(cipatricci.getId());
							cippatricce.setRownum(i);
							i++;
							macchinaCippatricceList.add(cippatricce);
						}
						if (macchinaCippatricceList != null && !macchinaCippatricceList.isEmpty()) {
							theModel.setAppDataelencoMacchineCippatrici(macchinaCippatricceList);
							theModel.setWidg_chbAttrezzatureMacchineCippatrici(true);
						} else {
							theModel.setWidg_chbAttrezzatureMacchineCippatrici(false);
						}
					}

					// MezziTransporto
					List<TaifTMezzoByIdTipoMezzoAziendaDto> allMacchineTrasporto = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
					List<TaifTMezzoByIdTipoMezzoAziendaDto> listTraspMezzo = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
					List<Integer> idTipoTrasportoList = new ArrayList<Integer>();
					tipoMezzoFilter.setCategoriaMezzo(Constants.catTrasp);
					tipoMezzoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					tipoMezzoFilter.setFlagItaFr(dataTracciato);
					tipoMezzoFilter.setIdAzienda(idAzienda);

					List<TaifDTipoMezzoByCategoriaMezzoDto> elencoMezziTrasportoCategoria = taifMgr
							.cercaTipoMezzoPerCategoriaMezzo(tipoMezzoFilter);
					if (elencoMezziCategoria != null && !elencoMezziCategoria.isEmpty()) {
						for (TaifDTipoMezzoByCategoriaMezzoDto mezzoCategoria : elencoMezziTrasportoCategoria) {
							idTipoTrasportoList.add(mezzoCategoria.getId());
						}
					}
					for (Integer idTipoMezzo : idTipoTrasportoList) {
						tipoMezzoFilter.setIdTipoMezzo(idTipoMezzo);
						listTraspMezzo = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
						listTraspMezzo = taifMgr.findMezzoByIdTipoMezzoAzienda(tipoMezzoFilter);
						allMacchineTrasporto.addAll(listTraspMezzo);
					}

					ArrayList<MacchinaMezzo> macchinaTrasportoList = new ArrayList<MacchinaMezzo>();
					if (allMacchineTrasporto != null && !allMacchineTrasporto.isEmpty()) {
						i = 0;
						for (TaifTMezzoByIdTipoMezzoAziendaDto trasportoMacchina : allMacchineTrasporto) {
							MacchinaMezzo trasporto = new MacchinaMezzo();
							trasporto.setAnnoImmatricolazione(String.valueOf(trasportoMacchina.getAnno()));
							trasporto.setPotenza(String.valueOf(trasportoMacchina.getPotenza()));
							trasporto.setIdTipoNoleggio(trasportoMacchina.getNoleggio().intValue());
							trasporto.setPortata(String.valueOf(trasportoMacchina.getPortata()));
							trasporto.setIdTipoMacchinaMezzo(trasportoMacchina.getIdTipoMezzo());

							trasporto.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							trasporto
									.setElencoTipoMacchinaMezzo(taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter));

							trasporto.setIdMacchinaMezzo(trasportoMacchina.getIdMezzo());
							trasporto.setRownum(i);
							i++;

							macchinaTrasportoList.add(trasporto);
						}
						if (macchinaTrasportoList != null && !macchinaTrasportoList.isEmpty()) {
							theModel.setAppDataelencoMezziDiTrasporto(macchinaTrasportoList);
							theModel.setWidg_chbAttrezzatureMezziDiTrasporto(true);
						} else {
							theModel.setWidg_chbAttrezzatureMezziDiTrasporto(false);
						}
					}

					// altre macchine

					ArrayList<MacchinaMezzo> altreMacchinaList = new ArrayList<MacchinaMezzo>();
					List<Integer> idTipoAltroMezzoList = new ArrayList<Integer>();
					tipoMezzoFilter.setTipoMezzo(Constants.altroMezzo);
					tipoMezzoFilter.setCategoriaMezzo(Constants.catZero);
					tipoMezzoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					tipoMezzoFilter.setFlagItaFr(dataTracciato);
					tipoMezzoFilter.setIdAzienda(idAzienda);
					tipoMezzoFilter.setIdTipoMezzo(it.csi.taif.taifweb.business.dao.util.Constants.twentyFive);
					List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listAltriMezzi = taifMgr
							.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);

					if (listAltriMezzi != null && !listAltriMezzi.isEmpty()) {
						i = 0;
						for (TaifTMezzoByTipoMezzoAziendaVisibileDto altreMacchine : listAltriMezzi) {
							MacchinaMezzo altroMezzo = new MacchinaMezzo();
							altroMezzo.setAnnoImmatricolazione(String.valueOf(altreMacchine.getAnno()));
							altroMezzo.setPotenza(String.valueOf(altreMacchine.getPotenza()));
							altroMezzo.setIdTipoNoleggio(altreMacchine.getNoleggio().intValue());
							altroMezzo.setPortata(String.valueOf(altreMacchine.getPortata()));
							altroMezzo.setIdTipoAlimentazione(altreMacchine.getIdAlimentazione());
							altroMezzo.setIdTipoTrazione(altreMacchine.getIdTipoTrazione());
							altroMezzo.setIdTipoMacchinaMezzo(altreMacchine.getIdTipoMezzo());
							altroMezzo.setIdTipoCarrello(altreMacchine.getIdTipoCarrel());
							altroMezzo.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggi());
							altroMezzo
									.setElencoTipoMacchinaMezzo(taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter));
							altroMezzo.setElencoTipoCarrello(taifMgr.getElencoTipoCarrello(visibileOrdinFilter));
							altroMezzo.setIdMacchinaMezzo(altreMacchine.getId());
							altroMezzo
									.setElencoTipoTrazione(taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter));
							altroMezzo.setElencoTipoAlimentazione(
									taifMgr.getElencoTipoAlimentazione(visibileOrdinFilter));
							altroMezzo.setDescrizione(altreMacchine.getDescrizioneAltro());
							altroMezzo.setRownum(i);
							i++;
							altreMacchinaList.add(altroMezzo);
						}
						if (altreMacchinaList != null && !altreMacchinaList.isEmpty()) {
							theModel.setAppDataelencoAltriMezzi(altreMacchinaList);
							theModel.setWidg_chbAttrezzatureAltriMezzi(true);
						} else {
							theModel.setWidg_chbAttrezzatureAltriMezzi(false);
						}
					}

				} else {
					// tracciatoFrancese
					caricaMezziTracciatoFrancese(theModel);
				}
				ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			} // pana aici
		}
		this.setVisibility(theModel, DomandaViewHelper.initScheda5_2(theModel));
	}

	private void caricaMezziTracciatoFrancese(CpDomandaModel theModel) throws Exception {

		// speciali
		int i = 0;
		tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
		tipoMezzoFilter.setCategoriaMezzo(Constants.speciales);

		List<TaifTMezzoByIdTipoMezzoAziendaDto> allMacchine = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();

		List<Integer> idTipoMezzoList = new ArrayList<Integer>();
		List<TaifDTipoMezzoByCategoriaMezzoDto> elencoMacchinePerCategoria = taifMgr
				.cercaTipoMezzoPerCategoriaMezzo(tipoMezzoFilter);

		if (elencoMacchinePerCategoria != null && !elencoMacchinePerCategoria.isEmpty()) {
			for (TaifDTipoMezzoByCategoriaMezzoDto mezzoCategoria : elencoMacchinePerCategoria) {
				idTipoMezzoList.add(mezzoCategoria.getId());
			}
		}
		for (Integer idTipoMezzo : idTipoMezzoList) {
			tipoMezzoFilter.setIdTipoMezzo(idTipoMezzo);
			List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzo = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
			listMezzo = taifMgr.findMezzoByIdTipoMezzoAzienda(tipoMezzoFilter);
			allMacchine.addAll(listMezzo);
		}

		ArrayList<MacchinaMezzo> macchinaSpecialeList = new ArrayList<MacchinaMezzo>();
		if (allMacchine != null && !allMacchine.isEmpty()) {
			i = 0;
			for (TaifTMezzoByIdTipoMezzoAziendaDto speciali : allMacchine) {
				MacchinaMezzo speciale = new MacchinaMezzo();
				speciale.setAnnoImmatricolazione(String.valueOf(speciali.getAnno()));
				speciale.setPotenza(String.valueOf(speciali.getPotenza()));
				speciale.setIdTipoTrazione(speciali.getIdTipoTrazione());
				speciale.setIdTipoNoleggio(speciali.getNoleggio().intValue());
				speciale.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggiFrancese());
				speciale.setIdTipoMacchinaMezzo(speciali.getIdTipoMezzo());
				speciale.setElencoTipoMacchinaMezzo(taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter));
				speciale.setIdMacchinaMezzo(speciali.getIdMezzo());
				speciale.setRownum(i);
				i++;
				macchinaSpecialeList.add(speciale);
			}
			if (macchinaSpecialeList != null && !macchinaSpecialeList.isEmpty()) {
				theModel.setAppDataelencoMacchineSpecialiFr(macchinaSpecialeList);
				theModel.setWidg_chbAttrezzatureMacchineSpecialiFr(true);
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpAttrezzatureMacchineSpecialiFr_selectedMultiPanel",
						"CpDomanda_mpAttrezzatureMacchineSpecialiFr_fpAttrezzatureMacchineSpecialiFr");

			} else {
				theModel.setWidg_chbAttrezzatureMacchineSpecialiFr(false);
				ActionContext.getContext().getSession()
						.put("CpDomanda_mpAttrezzatureMacchineSpecialiFr_selectedMultiPanel", null);
			}
		}
		// speciali movimentoTerra

		List<TaifTMezzoByIdTipoMezzoAziendaDto> allTerraFr = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
		List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzoTerra = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
		List<Integer> idTipoTerraFrList = new ArrayList<Integer>();
		tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
		tipoMezzoFilter.setCategoriaMezzo(Constants.terrassement);
		tipoMezzoFilter.setTipoMezzo(it.csi.taif.taifweb.business.dao.util.Constants.Chargeur);

		List<TaifDTipoMezzoByCategoriaMezzoDto> elencoMacchineTerraPerCategoria = taifMgr
				.cercaTipoMezzoPerCategoriaMezzo(tipoMezzoFilter);
		if (elencoMacchineTerraPerCategoria != null && !elencoMacchineTerraPerCategoria.isEmpty()) {
			for (TaifDTipoMezzoByCategoriaMezzoDto terraCategoria : elencoMacchineTerraPerCategoria) {
				idTipoTerraFrList.add(terraCategoria.getId());
			}
		}
		for (Integer idTipoMezzo : idTipoTerraFrList) {
			tipoMezzoFilter.setIdTipoMezzo(idTipoMezzo);
			List<TaifTMezzoByIdTipoMezzoAziendaDto> listMezzo1 = new ArrayList<TaifTMezzoByIdTipoMezzoAziendaDto>();
			listMezzo1 = taifMgr.findMezzoByIdTipoMezzoAzienda(tipoMezzoFilter);
			allTerraFr.addAll(listMezzo1);
		}

		ArrayList<MacchinaMezzo> macchinaTerraList = new ArrayList<MacchinaMezzo>();
		if (allTerraFr != null && !allTerraFr.isEmpty()) {
			i = 0;
			for (TaifTMezzoByIdTipoMezzoAziendaDto terraMacchine : allTerraFr) {
				MacchinaMezzo terra = new MacchinaMezzo();
				terra.setAnnoImmatricolazione(String.valueOf(terraMacchine.getAnno()));
				terra.setPotenza(String.valueOf(terraMacchine.getPotenza()));
				terra.setIdTipoTrazione(terraMacchine.getIdTipoTrazione());
				terra.setIdTipoNoleggio(terraMacchine.getNoleggio().intValue());
				terra.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggiFrancese());
				terra.setIdTipoMacchinaMezzo(terraMacchine.getIdTipoMezzo());
				terra.setIdMacchinaMezzo(terraMacchine.getIdMezzo());
				terra.setRownum(i);
				i++;
				tipoMezzoFilter.setTipoMezzo(terraMacchine.getTipoMezzo());
				terra.setElencoTipoMacchinaMezzo(taifMgr.getElencoTipoMezzoByCategoria(tipoMezzoFilter));
				terra.setElencoTipoTrazione(taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)); //this.taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter)));

				macchinaTerraList.add(terra);
			}
			if (macchinaTerraList != null && !macchinaTerraList.isEmpty()) {
				theModel.setAppDataelencoMacchineMovimentoTerraFr(macchinaTerraList);
				theModel.setWidg_chbAttrezzatureMacchineMovimentoATerraFr(true);
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpAttrezzatureMacchineMovimentoATerraFr_selectedMultiPanel",
						"CpDomanda_mpAttrezzatureMacchineMovimentoATerraFr_fpAttrezzatureMacchineMovimentoATerraFr");
			} else {
				theModel.setWidg_chbAttrezzatureMacchineMovimentoATerraFr(false);
				ActionContext.getContext().getSession()
						.put("CpDomanda_mpAttrezzatureMacchineMovimentoATerraFr_selectedMultiPanel", null);
			}
		}

		// theModel.setAppDataelencoMacchineGrumier(taifMgr.getElencoMacchine(tipoMezzoFilter, it.csi.taif.taifweb.business.dao.util.Constants.Grumier));
		// theModel.setAppDataelencoMacchineRimorchiFr(taifMgr.getElencoMacchine(tipoMezzoFilter, it.csi.taif.taifweb.business.dao.util.Constants.Camion));
		// theModel.setAppDataelencoMacchineSemi(taifMgr.getElencoMacchine(tipoMezzoFilter, it.csi.taif.taifweb.business.dao.util.Constants.Semi));
		ArrayList<MacchinaMezzo> grumierList = new ArrayList<MacchinaMezzo>();
		tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
		tipoMezzoFilter.setIdTipoMezzo(32);
		tipoMezzoFilter.setTipoMezzo(it.csi.taif.taifweb.business.dao.util.Constants.Grumier);
		List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listGrumier = taifMgr
				.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
		if (listGrumier != null && !listGrumier.isEmpty()) {
			i = 0;
			for (TaifTMezzoByTipoMezzoAziendaVisibileDto grumier : listGrumier) {
				MacchinaMezzo macchinaGrumier = new MacchinaMezzo();
				macchinaGrumier.setAnnoImmatricolazione(String.valueOf(grumier.getAnno()));
				macchinaGrumier.setPotenza(String.valueOf(grumier.getPotenza()));
				macchinaGrumier.setIdTipoNoleggio(grumier.getNoleggio().intValueExact());
				macchinaGrumier.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggiFrancese());
				macchinaGrumier.setIdMacchinaMezzo(grumier.getId());
				macchinaGrumier.setRownum(i);
				i++;
				grumierList.add(macchinaGrumier);
			}
			if (grumierList != null && !grumierList.isEmpty()) {
				theModel.setAppDataelencoMacchineGrumier(grumierList);
				theModel.setWidg_chbAttrezzatureMacchinaGrumier(true);
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpAttrezzatureMacchineGrumier_selectedMultiPanel",
						"CpDomanda_mpAttrezzatureMacchineGrumier_fpAttrezzatureMacchinaElencoGrumier");

			} else {
				theModel.setWidg_chbAttrezzatureMacchinaGrumier(false);
				ActionContext.getContext().getSession()
						.put("CpDomanda_mpAttrezzatureMacchineGrumier_selectedMultiPanel", null);
			}
		}
		// findRimorchiFrancese
		ArrayList<MacchinaMezzo> rimorchiFranceseList = new ArrayList<MacchinaMezzo>();
		tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
		tipoMezzoFilter.setIdTipoMezzo(33);
		tipoMezzoFilter.setTipoMezzo(Constants.camionRemorque);
		List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listRimorchiFrancese = taifMgr
				.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
		if (listRimorchiFrancese != null && !listRimorchiFrancese.isEmpty()) {
			i = 0;
			for (TaifTMezzoByTipoMezzoAziendaVisibileDto rimorchi : listRimorchiFrancese) {
				MacchinaMezzo macchinaRimorchioFr = new MacchinaMezzo();
				macchinaRimorchioFr.setAnnoImmatricolazione(String.valueOf(rimorchi.getAnno()));
				macchinaRimorchioFr.setPotenza(String.valueOf(rimorchi.getPotenza()));
				macchinaRimorchioFr.setIdTipoTrazione(rimorchi.getIdTipoTrazione());
				macchinaRimorchioFr.setIdTipoNoleggio(rimorchi.getNoleggio().intValue());
				macchinaRimorchioFr.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggiFrancese());
				macchinaRimorchioFr.setElencoTipoTrazione(taifMgr.getElencoTipoTrazioniPerTipoMezzo(tipoMezzoFilter));
				macchinaRimorchioFr.setIdMacchinaMezzo(rimorchi.getId());
				macchinaRimorchioFr.setRownum(i);
				i++;
				rimorchiFranceseList.add(macchinaRimorchioFr);
			}
			if (rimorchiFranceseList != null && !rimorchiFranceseList.isEmpty()) {
				theModel.setAppDataelencoMacchineRimorchiFr(rimorchiFranceseList);
				theModel.setWidg_chbAttrezzatureMacchinaRimorchiFr(true);
				ActionContext.getContext().getSession().put(
						"CpDomanda_mpAttrezzatureMacchineRimorchiFr_selectedMultiPanel",
						"CpDomanda_mpAttrezzatureMacchineRimorchiFr_fpAttrezzatureMacchinaElencoRimorchiFr");
			} else {
				theModel.setWidg_chbAttrezzatureMacchinaRimorchiFr(false);
				ActionContext.getContext().getSession()
						.put("CpDomanda_mpAttrezzatureMacchineRimorchiFr_selectedMultiPanel", null);
			}
		}

		// find semi 
		ArrayList<MacchinaMezzo> macchineSemiList = new ArrayList<MacchinaMezzo>();
		tipoMezzoFilter = this.getTipoMezzoFilter(theModel);
		tipoMezzoFilter.setIdTipoMezzo(34);
		tipoMezzoFilter.setTipoMezzo(it.csi.taif.taifweb.business.dao.util.Constants.Semi);
		List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listMacchineSemi = taifMgr
				.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
		if (listMacchineSemi != null && !listMacchineSemi.isEmpty()) {
			i = 0;
			for (TaifTMezzoByTipoMezzoAziendaVisibileDto piattaforma : listMacchineSemi) {
				MacchinaMezzo macchinaSemi = new MacchinaMezzo();
				macchinaSemi.setAnnoImmatricolazione(String.valueOf(piattaforma.getAnno()));
				macchinaSemi.setPotenza(String.valueOf(piattaforma.getPotenza()));
				macchinaSemi.setIdTipoNoleggio(piattaforma.getNoleggio().intValueExact());
				macchinaSemi.setElencoTipoNoleggio(taifMgr.getElencoTipoNoleggiFrancese());
				macchinaSemi.setIdMacchinaMezzo(piattaforma.getId());
				macchinaSemi.setRownum(i);
				i++;
				macchineSemiList.add(macchinaSemi);
			}
			if (macchineSemiList != null && !macchineSemiList.isEmpty()) {
				theModel.setAppDataelencoMacchineSemi(macchineSemiList);
				theModel.setWidg_chbAttrezzatureMacchinaSemi(true);
				ActionContext.getContext().getSession().put("CpDomanda_mpAttrezzatureMacchineSemi_selectedMultiPanel",
						"CpDomanda_mpAttrezzatureMacchineSemi_fpAttrezzatureMacchinaElencoSemi");
			} else {
				theModel.setWidg_chbAttrezzatureMacchinaSemi(false);
				ActionContext.getContext().getSession().put("CpDomanda_mpAttrezzatureMacchineSemi_selectedMultiPanel",
						null);
			}
		}
	}

	public void executeInit5_1(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {
		visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
		theModel.setAppDataelencoCaschiForestaliAttrezzature(
				taifMgr.getElencoCaschiForestali(visibileOrdinFilter, theModel.getAppDataidAzienda()));
		theModel.setAppDataelencoScarponiRinforzatiAttrezzature(
				taifMgr.getElencoScarponiRinforzati(visibileOrdinFilter, theModel.getAppDataidAzienda()));
		theModel.setAppDataelencoPantaloniAntitaglioAttrezzature(
				taifMgr.getElencoPantaloniAntitaglio(visibileOrdinFilter, theModel.getAppDataidAzienda()));

		if (Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {

			if (theModel.getAppDataidAzienda() != null) {
				visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
				int idAzienda = theModel.getAppDataidAzienda().intValue();
				String dataTracciato = theModel.getAppDatatracciato();
				//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
				TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
				int i = 0;
				if (scheda != null) {
					if (scheda.getFlgSez51ItaOk()
							.byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {

						ArrayList<MezzoDiProtezioneIndividuale> caschiForestali = taifMgr
								.getElencoCaschiForestali(visibileOrdinFilter, theModel.getAppDataidAzienda());
						i = 0;
						for (MezzoDiProtezioneIndividuale caschi : caschiForestali) {
							caschi.setRownum(i++);
						}
						theModel.setAppDataelencoCaschiForestaliAttrezzature(caschiForestali);
						if (caschiForestali.size() == 1
								&& caschiForestali.get(0).getIdTipoMezzoDiProtezioneIndividuale() == 0) {
							theModel.setWidg_chbAttrezzatureCascoForestale(false);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpAttrezzatureCascoForestale_selectedMultiPanel",
							//									null);
						} else {
							theModel.setWidg_chbAttrezzatureCascoForestale(true);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpAttrezzatureCascoForestale_selectedMultiPanel",
							//									"CpDomanda_mpAttrezzatureCascoForestale_fpAttrezzatureCascoForestale");
						}
						i = 0;
						ArrayList<MezzoDiProtezioneIndividuale> scarponiRinforzati = taifMgr
								.getElencoScarponiRinforzati(visibileOrdinFilter, theModel.getAppDataidAzienda());
						for (MezzoDiProtezioneIndividuale scarponi : scarponiRinforzati) {
							scarponi.setRownum(i++);
						}

						theModel.setAppDataelencoScarponiRinforzatiAttrezzature(scarponiRinforzati);

						if (scarponiRinforzati.size() == 1
								&& scarponiRinforzati.get(0).getIdTipoMezzoDiProtezioneIndividuale() == 0) {
							theModel.setWidg_chbAttrezzatureScarponiRinforzati(false);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpAttrezzatureScarponiRinforzati_selectedMultiPanel",
							//									null);
						} else {
							theModel.setWidg_chbAttrezzatureScarponiRinforzati(true);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpAttrezzatureScarponiRinforzati_selectedMultiPanel",
							//									"CpDomanda_mpAttrezzatureScarponiRinforzati_fpAttrezzatureScarponiRinforzati");
						}
						i = 0;
						ArrayList<MezzoDiProtezioneIndividuale> pantaloniAntitaglio = taifMgr
								.getElencoPantaloniAntitaglio(visibileOrdinFilter, theModel.getAppDataidAzienda());
						for (MezzoDiProtezioneIndividuale pantaloni : pantaloniAntitaglio) {
							pantaloni.setRownum(i++);
						}

						theModel.setAppDataelencoPantaloniAntitaglioAttrezzature(pantaloniAntitaglio);

						if (pantaloniAntitaglio.size() == 1
								&& pantaloniAntitaglio.get(0).getIdTipoMezzoDiProtezioneIndividuale() == 0) {
							theModel.setWidg_chbAttrezzaturePantaloniAntitaglio(false);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpAttrezzaturePantaloniAntitaglio_selectedMultiPanel",
							//									null);
						} else {
							theModel.setWidg_chbAttrezzaturePantaloniAntitaglio(true);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpAttrezzaturePantaloniAntitaglio_selectedMultiPanel",
							//									"CpDomanda_mpAttrezzaturePantaloniAntitaglio_fpAttrezzaturePantaloniAntitaglio");
						}
						ActionContext.getContext().getSession().put("backDomandaRiepilogo",
								Constants.BACK_DOMANDA_RIEPILOGO);
					}
				}
			}
		}
		this.setVisibility(theModel, DomandaViewHelper.initScheda5_1(theModel));
	}

	public void executeInit4(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {
		if (theModel.getAppDataidAzienda() != null) {
			visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
			int idAzienda = theModel.getAppDataidAzienda().intValue();
			String dataTracciato = theModel.getAppDatatracciato();

			//theModel.setAppDataelencoCapannoni(taifMgr.getElencoCapannoni(this.getVisibileOrdinFilter(theModel), theModel.getAppDataidAzienda()));
			//theModel.setAppDataelencoPiazzaliStoccaggio( taifMgr.getElencoPiazzaliStoccaggio(this.getStrutturaFilter(theModel)));

			//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
			TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
			if (scheda != null) {
				if (scheda.getFlgSez4ItaOk().byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
						|| scheda.getFlgSez4FraOk()
								.byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
					//					List<Integer> listFunzionecapannone = new ArrayList<Integer>();
					ArrayList<Capannone> elencoCapannoni = taifMgr
							.getElencoCapannoni(this.getVisibileOrdinFilter(theModel), theModel.getAppDataidAzienda());
					int i = 0;

					theModel.setAppDataelencoCapannoni(elencoCapannoni);

					if (elencoCapannoni != null && !elencoCapannoni.isEmpty()) {
						for (Capannone capannone : elencoCapannoni) {
							if (capannone.getIdCapannone() != 0) {
								capannone.setRownum(i++);
								capannone.setElencoFunzioni(taifMgr.getElencoFunzioniCapannone(visibileOrdinFilter));
							}
						}
						theModel.setAppDataelencoCapannoni(elencoCapannoni);
						if (elencoCapannoni.size() == 1 && elencoCapannoni.get(0).getIdCapannone() == 0) {
							theModel.setWidg_chbStruttureCapannoni(false);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpStruttureCapannoni_selectedMultiPanel",
							//									null);
						} else {
							theModel.setWidg_chbStruttureCapannoni(true);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpStruttureCapannoni_selectedMultiPanel",
							//									"CpDomanda_mpStruttureCapannoni_fpStruttureCapannoni");
						}
					} else {
						theModel.setWidg_chbStruttureCapannoni(false);
						//						ActionContext.getContext().getSession().put(
						//								"CpDomanda_mpStruttureCapannoni_selectedMultiPanel",
						//								null);
					}

					//piazzali
					ArrayList<PiazzaleStoccaggio> piazzaliStoccaggio = taifMgr
							.getElencoPiazzaliStoccaggio(this.getStrutturaFilter(theModel));
					//					i = 0;

					theModel.setAppDataelencoPiazzaliStoccaggio(piazzaliStoccaggio);

					if (piazzaliStoccaggio != null && !piazzaliStoccaggio.isEmpty()) {
						//						for (PiazzaleStoccaggio piazzaleStoccaggio : piazzaliStoccaggio) {
						//							if (piazzaleStoccaggio.getIdPiazzaleStoccaggio() != 0) {
						//								piazzaleStoccaggio.setRownum(i++);
						//							}
						//						}
						//						theModel.setAppDataelencoPiazzaliStoccaggio(piazzaliStoccaggio);
						if (piazzaliStoccaggio.size() == 1
								&& piazzaliStoccaggio.get(0).getIdPiazzaleStoccaggio() == 0) {
							theModel.setWidg_chbStrutturePiazzaliStoccaggio(false);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpStrutturePiazzaliStoccaggio_selectedMultiPanel",
							//									null);
						} else {
							theModel.setWidg_chbStrutturePiazzaliStoccaggio(true);
							//							ActionContext.getContext().getSession().put(
							//									"CpDomanda_mpStrutturePiazzaliStoccaggio_selectedMultiPanel",
							//									"CpDomanda_mpStrutturePiazzaliStoccaggio_fpStrutturePiazzaliStoccaggio");
						}
					} else {
						//						ActionContext.getContext().getSession().put(
						//								"CpDomanda_mpStrutturePiazzaliStoccaggio_selectedMultiPanel",
						//								null);
						theModel.setWidg_chbStrutturePiazzaliStoccaggio(false);
					}
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							Constants.BACK_DOMANDA_RIEPILOGO);
				} else {
					theModel.setAppDataelencoCapannoni(taifMgr.getElencoCapannoni(this.getVisibileOrdinFilter(theModel),
							theModel.getAppDataidAzienda()));
					theModel.setAppDataelencoPiazzaliStoccaggio(
							taifMgr.getElencoPiazzaliStoccaggio(this.getStrutturaFilter(theModel)));
				}
			}
		}
		this.setVisibility(theModel, DomandaViewHelper.initScheda4(theModel));
	}

	private StrutturaFilter getStrutturaFilter(CpDomandaModel theModel) {
		StrutturaFilter strutturaFilter = new StrutturaFilter();
		strutturaFilter.setIdAzienda(theModel.getAppDataidAzienda());
		strutturaFilter.setIdFunzione(5);
		return strutturaFilter;
	}

	public void executeInit3_3(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {
		if (theModel.getAppDataidAzienda() != null) {
			visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
			int idAzienda = theModel.getAppDataidAzienda().intValue();
			String dataTracciato = theModel.getAppDatatracciato();
			int k = 0;
			//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
			TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
			if (scheda != null) {
				if (scheda.getFlgSez33ItaOk().byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
						|| scheda.getFlgSez33FraOk()
								.byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
					ActionContext.getContext().getSession().put("updateRiepilogoComm", Constants.FLAG_SI);
					ArrayList<LegnameAssortimentoTrattato> legnamiAssortimentoTrattato = taifMgr
							.getElencoLegnami(visibileOrdinFilter, idAzienda);
					// find attivita 8
					aziendaVisibleFilter = getAziendaVisibleFilter(theModel);
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.eightInt);
					AttivitaUltimoAnno8 attivitaAnno8 = new AttivitaUltimoAnno8();
					List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita8SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
					TaifTAziendaDto aziendaDto = taifMgr.getAziendaById(idAzienda);
					if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.fLang)) {
						if (aziendaDto.getPercCommercioFra() != null) {
							theModel.setAppDatapercentualeCommercioFr(aziendaDto.getPercCommercioFra().intValueExact());
						}
					}
					if ((legnamiAssortimentoTrattato != null) && (!legnamiAssortimentoTrattato.isEmpty())) {
						for (LegnameAssortimentoTrattato legnameAssortimento : legnamiAssortimentoTrattato) {
							legnameAssortimento
									.setElencoProvenienze(taifMgr.getProvenienzaMateriale(visibileOrdinFilter));
							legnameAssortimento
									.setElencoDestinazioni(taifMgr.getDestinazioneMateriale(visibileOrdinFilter));
							legnameAssortimento.setElencoSpecie(taifMgr.getElencoSpecie(visibileOrdinFilter));
							if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
								legnameAssortimento.setElencoTA(taifMgr.getTagliatoAquistatoTALista());
							}
							legnameAssortimento
									.setElencoAssortimenti(taifMgr.getElencoAssortimento(visibileOrdinFilter));
							legnameAssortimento.setRownum(k++);
						}

						theModel.setAppDataelencoLegnamiAssortimentiTrattati(legnamiAssortimentoTrattato);
						if (legnamiAssortimentoTrattato.size() == 1
								&& legnamiAssortimentoTrattato.get(0).getIdAssortimento() == 0) {
							theModel.setWidg_rbsAttivitaLegname(Constants.NO);
							/*  if(attivita8SvoltaPerAzienda !=null && attivita8SvoltaPerAzienda.size() >0  && attivita8SvoltaPerAzienda.get(0).getId() != null) {
							theModel.setWidg_rbsAttivitaLegname(Constants.SI);
							//expandLegnami(theModel);
							}else {
							theModel.setWidg_rbsAttivitaLegname(Constants.NO);
							}*/

						} else {
							theModel.setWidg_rbsAttivitaLegname(Constants.SI);
							//ActionContext.getContext().getSession().put(
							//"CpDomanda_mpAttivitaLegname_selectedMultiPanel",
							//"CpDomanda_mpAttivitaLegname_fpAttivitaLegname");
						}

					} else {
						theModel.setWidg_rbsAttivitaLegname(Constants.NO);
						/*  if(attivita8SvoltaPerAzienda !=null  && attivita8SvoltaPerAzienda.size() >0  && attivita8SvoltaPerAzienda.get(0).getId() != null) {
						theModel.setWidg_rbsAttivitaLegname(Constants.SI);
						expandLegnami(theModel);
						}else {
						theModel.setWidg_rbsAttivitaLegname(Constants.NO);
						}*/

					}
				} else {
					ActionContext.getContext().getSession().put("updateRiepilogoComm", Constants.FLAG_NO);
					theModel.setAppDataelencoLegnamiAssortimentiTrattati(
							this.taifMgr.getElencoLegnami(visibileOrdinFilter, idAzienda));
					theModel.setWidg_rbsAttivitaLegname(Constants.NO);

				}
				ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			}
		}
		this.setVisibility(theModel, DomandaViewHelper.initScheda3_3(theModel));

	}

	public void executeInit3_2(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {

		String dataTracciato = theModel.getAppDatatracciato();
		if (theModel.getAppDataidAzienda() != null) {
			int idAzienda = theModel.getAppDataidAzienda().intValue();

		}

		if (theModel.getAppDataidAzienda() != null) {
			int idAzienda = theModel.getAppDataidAzienda().intValue();
			//theModel.setAppDataelencoLavoriPA(
			//		taifMgr.getElencoLavoriPAByAzienda(this.getLavoroPAFilter(dataTracciato, idAzienda)));
			//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
			TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
			int i = 0;
			if (scheda != null) {
				if (scheda.getFlgSez32ItaOk()
						.byteValueExact() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
					LavoroPaFilter lavoroPaFilter = new LavoroPaFilter();
					lavoroPaFilter.setIdAzienda(idAzienda);
					lavoroPaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);

					ArrayList<LavoroPA> lavoroPublicaAmministrazione = taifMgr
							.getElencoLavoriPAByAzienda(lavoroPaFilter);

					if ((lavoroPublicaAmministrazione != null) && (!lavoroPublicaAmministrazione.isEmpty())) {
						for (LavoroPA lavoroPA : lavoroPublicaAmministrazione) {
							lavoroPA.setElencoOggettiIntervento(taifMgr.getElencoTipoLavoroPA());
							lavoroPA.setRownum(i++);
						}
						theModel.setAppDataelencoLavoriPA(lavoroPublicaAmministrazione);
						if (lavoroPublicaAmministrazione.size() == 1
								&& lavoroPublicaAmministrazione.get(0).getIdOggettoIntervento() == 0) {
							theModel.setWidg_rbsAttivitaLavoriPA(Constants.NO);
						} else {
							theModel.setWidg_rbsAttivitaLavoriPA(Constants.SI);
							/*ActionContext.getContext().getSession().put(
									"CpDomanda_mpAttivitaLavoriPA_selectedMultiPanel",
									"CpDomanda_mpAttivitaLavoriPA_fpAttivitaLavoriPA");*/
						}
					} else {
						theModel.setWidg_rbsAttivitaLavoriPA(Constants.NO);
					}
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							Constants.BACK_DOMANDA_RIEPILOGO);
				} else {
					theModel.setAppDataelencoLavoriPA(
							taifMgr.getElencoLavoriPAByAzienda(this.getLavoroPAFilter(dataTracciato, idAzienda)));
					theModel.setWidg_rbsAttivitaLavoriPA(Constants.NO);

				}
			}
		}

		this.setVisibility(theModel, DomandaViewHelper.initScheda3_2(theModel));

	}

	public void executeInit3_1(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {

		Map session = theModel.getSession();
		String previousPage = (String) session.get(it.csi.taif.taifweb.util.Constants.CURRENT_CONTENT_PANEL);

		visibileOrdinFilter = getVisibileOrdinFilter(theModel);

		log.info(" executeInit3_1 :: FLAG " + visibileOrdinFilter.getFlagItaFr());

		String tracciato = theModel.getAppDatatracciato();

		log.info(" executeInit3_1 ::  " + tracciato);

		if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {

			theModel.setAppDataelencoUnitaMisura(this.taifMgr.getElencoUnitaMisuraQuintaliMc());
			theModel.setAppDataelencoAttivitaUltimoAnno(
					taifMgr.getElencoAttivitaUltimoAnno(theModel.getAppDataidAzienda()));

			ArrayList<MaterialePropagazione> materialePropagazioneList = taifMgr
					.getElencoMaterialiPropagazione(this.getMaterialeFilter(theModel, "V"));
			theModel.setAppDataelencoMaterialePropagazione(materialePropagazioneList);

			theModel.setAppDataelencoArboricolturaDaLegno(
					taifMgr.getElencoArboricolturaDaLegno(5, this.getMaterialeFilter(theModel, "A"))); // piopette ?? 

			this.setVisibilityConsultaIstanzaTaglioPresentate(theModel);
			int idAzienda = theModel.getAppDataidAzienda() == null ? 0 : theModel.getAppDataidAzienda();
			//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
			TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
			if (scheda != null) {
				log.info(" executeInit3_1 ::  scheda != null");

				if ((scheda.getFlgSez31ItaOk()
						.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
						|| scheda.getFlgSez31FraOk()
								.byteValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
					log.info(" executeInit3_1 ::  scheda.getFlgSez31ItaOk()...");

					theModel.setAppDatagestioneAttivitaUltimoAnno(new GestioneAttivitaUltimoAnno());

					aziendaVisibleFilter = getAziendaVisibleFilter(theModel);
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
					List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita1SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
					Intervento interventoRegione = new Intervento();
					Intervento interventoFuoriRegione = new Intervento();
					AttivitaUltimoAnno1 attivitaAnno1 = new AttivitaUltimoAnno1();
					theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(
							it.csi.taif.taifweb.business.dao.util.Constants.emptyString);
					theModel.setAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(
							it.csi.taif.taifweb.business.dao.util.Constants.emptyString);
					theModel.setAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(
							it.csi.taif.taifweb.business.dao.util.Constants.emptyString);

					interventoRegione = new Intervento();
					interventoFuoriRegione = new Intervento();
					if (attivita1SvoltaPerAzienda != null && !attivita1SvoltaPerAzienda.isEmpty()) {
						log.info(
								" executeInit3_1 ::  attivita1SvoltaPerAzienda != null && !attivita1SvoltaPerAzienda.isEmpty()");

						for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaUno : attivita1SvoltaPerAzienda) {
							attivitaAnno1 = new AttivitaUltimoAnno1();
							attivitaAnno1.setIdAttivita(1);
							attivitaAnno1.setPercentuale(String.valueOf(attivitaUno.getFatturato()));

							if (attivitaUno.getProgressivoDettaglio() == 1) {

								//								interventoRegione.setTotaleVolumiTagliDiUtilizzazione(
								//										String.valueOf(attivitaUno.getValore1Dettaglio()));
								//								interventoRegione.setPercentualeVolumiTagliDiUtilizzazioneContoTerzi(
								//										String.valueOf(attivitaUno.getPercentualeContoTerzi()));
								//								interventoRegione.setIdUnitaMisuraTagliDiUtilizzazione(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));
								//								theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));

								interventoRegione.setTotaleVolumiTagliDiUtilizzazione(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getValore1Dettaglio(), 0));
								interventoRegione.setPercentualeVolumiTagliDiUtilizzazioneContoTerzi(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getPercentualeContoTerzi(), 0));
								interventoRegione.setIdUnitaMisuraTagliDiUtilizzazione(ConvertUtil.defaultValueInteger(
										attivitaUno.getUnitaMisuraDettaglio(), Constants.ID_UNITA_MISURA_QUINTALI));
								theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(
										ConvertUtil.defaultValueInteger(attivitaUno.getUnitaMisuraDettaglio(),
												Constants.ID_UNITA_MISURA_QUINTALI));

							}
							if (attivitaUno.getProgressivoDettaglio() == 2) {
								//								interventoRegione.setTotaleVolumiTaglioPioppeti(
								//										String.valueOf(attivitaUno.getValore1Dettaglio()));
								//								interventoRegione.setPercentualeVolumiTaglioPioppetiContoTerzi(
								//										String.valueOf(attivitaUno.getPercentualeContoTerzi()));
								//								interventoRegione.setIdUnitaMisuraTaglioPioppeti(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));
								//								theModel.setAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));

								interventoRegione.setTotaleVolumiTaglioPioppeti(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getValore1Dettaglio(), 0));
								interventoRegione.setPercentualeVolumiTaglioPioppetiContoTerzi(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getPercentualeContoTerzi(), 0));
								interventoRegione.setIdUnitaMisuraTaglioPioppeti(ConvertUtil.defaultValueInteger(
										attivitaUno.getUnitaMisuraDettaglio(), Constants.ID_UNITA_MISURA_QUINTALI));
								theModel.setAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(
										ConvertUtil.defaultValueInteger(attivitaUno.getUnitaMisuraDettaglio(),
												Constants.ID_UNITA_MISURA_QUINTALI));
							}
							if (attivitaUno.getProgressivoDettaglio() == 3) {
								//								interventoRegione.setTotaleVolumiTagliIntercalari(
								//										String.valueOf(attivitaUno.getValore1Dettaglio()));
								//								interventoRegione.setPercentualeVolumiTagliIntercalariContoTerzi(
								//										String.valueOf(attivitaUno.getPercentualeContoTerzi()));
								//								interventoRegione.setIdUnitaMisuraTagliIntercalari(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));
								//								theModel.setAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));

								interventoRegione.setTotaleVolumiTagliIntercalari(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getValore1Dettaglio(), 0));
								interventoRegione.setPercentualeVolumiTagliIntercalariContoTerzi(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getPercentualeContoTerzi(), 0));
								interventoRegione.setIdUnitaMisuraTagliIntercalari(ConvertUtil.defaultValueInteger(
										attivitaUno.getUnitaMisuraDettaglio(), Constants.ID_UNITA_MISURA_QUINTALI));
								theModel.setAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(
										ConvertUtil.defaultValueInteger(attivitaUno.getUnitaMisuraDettaglio(),
												Constants.ID_UNITA_MISURA_QUINTALI));

							}
							if (attivitaUno.getProgressivoDettaglio() == 4) {

								//								interventoFuoriRegione.setTotaleVolumiTagliDiUtilizzazione(
								//										String.valueOf(attivitaUno.getValore1Dettaglio()));
								//								interventoFuoriRegione.setPercentualeVolumiTagliDiUtilizzazioneContoTerzi(
								//										String.valueOf(attivitaUno.getPercentualeContoTerzi()));
								//								interventoFuoriRegione.setIdUnitaMisuraTagliDiUtilizzazione(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));
								//								theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));

								interventoFuoriRegione.setTotaleVolumiTagliDiUtilizzazione(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getValore1Dettaglio(), 0));
								interventoFuoriRegione.setPercentualeVolumiTagliDiUtilizzazioneContoTerzi(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getPercentualeContoTerzi(), 0));
								interventoFuoriRegione.setIdUnitaMisuraTagliDiUtilizzazione(
										ConvertUtil.defaultValueInteger(attivitaUno.getUnitaMisuraDettaglio(),
												Constants.ID_UNITA_MISURA_QUINTALI));
								theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato(
										ConvertUtil.defaultValueInteger(attivitaUno.getUnitaMisuraDettaglio(),
												Constants.ID_UNITA_MISURA_QUINTALI));

							}
							if (attivitaUno.getProgressivoDettaglio() == 5) {
								//								interventoFuoriRegione.setTotaleVolumiTaglioPioppeti(
								//										String.valueOf(attivitaUno.getValore1Dettaglio()));
								//								interventoFuoriRegione.setPercentualeVolumiTaglioPioppetiContoTerzi(
								//										String.valueOf(attivitaUno.getPercentualeContoTerzi()));
								//								interventoFuoriRegione.setIdUnitaMisuraTaglioPioppeti(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));
								//								theModel.setAppDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));

								interventoFuoriRegione.setTotaleVolumiTaglioPioppeti(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getValore1Dettaglio(), 0));
								interventoFuoriRegione.setPercentualeVolumiTaglioPioppetiContoTerzi(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getPercentualeContoTerzi(), 0));
								interventoFuoriRegione.setIdUnitaMisuraTaglioPioppeti(ConvertUtil.defaultValueInteger(
										attivitaUno.getUnitaMisuraDettaglio(), Constants.ID_UNITA_MISURA_QUINTALI));
								theModel.setAppDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato(
										ConvertUtil.defaultValueInteger(attivitaUno.getUnitaMisuraDettaglio(),
												Constants.ID_UNITA_MISURA_QUINTALI));
							}
							if (attivitaUno.getProgressivoDettaglio() == 6) {
								//								interventoFuoriRegione.setTotaleVolumiTagliIntercalari(
								//										String.valueOf(attivitaUno.getValore1Dettaglio()));
								//								interventoFuoriRegione.setPercentualeVolumiTagliIntercalariContoTerzi(
								//										String.valueOf(attivitaUno.getPercentualeContoTerzi()));
								//								interventoFuoriRegione.setIdUnitaMisuraTagliIntercalari(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));
								//								theModel.setAppDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato(
								//										String.valueOf(attivitaUno.getUnitaMisuraDettaglio()));

								interventoFuoriRegione.setTotaleVolumiTagliIntercalari(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getValore1Dettaglio(), 0));
								interventoFuoriRegione.setPercentualeVolumiTagliIntercalariContoTerzi(
										ConvertUtil.defaultValueBigDecimal(attivitaUno.getPercentualeContoTerzi(), 0));
								interventoFuoriRegione.setIdUnitaMisuraTagliIntercalari(ConvertUtil.defaultValueInteger(
										attivitaUno.getUnitaMisuraDettaglio(), Constants.ID_UNITA_MISURA_QUINTALI));
								theModel.setAppDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato(
										ConvertUtil.defaultValueInteger(attivitaUno.getUnitaMisuraDettaglio(),
												Constants.ID_UNITA_MISURA_QUINTALI));
							}

						}
						attivitaAnno1.setInterventoFuoriRegione(interventoFuoriRegione);

						attivitaAnno1.setInterventoInRegione(interventoRegione);

						if (theModel.getAppDatavolumiAcquisitiPrimpaForSrv() != null
								&& theModel.getAppDataisVolumeAcquisitoFromPrimpaForSrv()) {
							log.info(
									"[CPBECpIstanzeTaglioPresentate:: acquisizioneVolumiTaglio] AppDataisVolumeAcquisitoFromPrimpaForSrv "
											+ theModel.getAppDataisVolumeAcquisitoFromPrimpaForSrv());
							log.info("[CPBECpIstanzeTaglioPresentate:: acquisizioneVolumiTaglio] sommaUtilizzazione "
									+ theModel.getAppDatavolumiAcquisitiPrimpaForSrv()
											.getTotaleVolumiTagliDiUtilizzazione() != null
													? theModel.getAppDatavolumiAcquisitiPrimpaForSrv()
															.getTotaleVolumiTagliDiUtilizzazione()
													: "null");
							theModel.setAppDataisVolumeAcquisitoFromPrimpaForSrv(false);

							attivitaAnno1.setInterventoInRegione(theModel.getAppDatavolumiAcquisitiPrimpaForSrv());
							theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(theModel
									.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTagliDiUtilizzazione());
							theModel.setAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(
									theModel.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTaglioPioppeti());
							theModel.setAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(theModel
									.getAppDatavolumiAcquisitiPrimpaForSrv().getIdUnitaMisuraTagliIntercalari());
							theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita1(attivitaAnno1);
						}

						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita1(attivitaAnno1);

						theModel.setWidg_chbAttivitaUltimoAnno1(true);
						ActionContext.getContext().getSession().put(
								"CpDomanda_mpAttivitaUltimoAnno1_selectedMultiPanel",
								"CpDomanda_mpAttivitaUltimoAnno1_fpAttivitaUltimoAnno1");
					} else {
						this.inizializeScheda3_1(theModel);
						theModel.setWidg_chbAttivitaUltimoAnno1(false);
						ActionContext.getContext().getSession()
								.put("CpDomanda_mpAttivitaUltimoAnno1_selectedMultiPanel", null);
					}

					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.twoInt);

					AttivitaUltimoAnno2 attivitaAnno2 = new AttivitaUltimoAnno2();
					List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita2SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
					if (attivita2SvoltaPerAzienda != null && !attivita2SvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaAnnoDue : attivita2SvoltaPerAzienda) {
							attivitaAnno2.setEttariRealizzati(String.valueOf(attivitaAnnoDue.getValore1Dettaglio()));
							attivitaAnno2.setPercentuale(String.valueOf(attivitaAnnoDue.getFatturato()));

						}
						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita2(attivitaAnno2);
						theModel.setWidg_chbAttivitaUltimoAnno2(true);
						ActionContext.getContext().getSession().put(
								"CpDomanda_mpAttivitaUltimoAnno2_selectedMultiPanel",
								"CpDomanda_mpAttivitaUltimoAnno2_fpAttivitaUltimoAnno2");
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno2(false);
						ActionContext.getContext().getSession()
								.put("CpDomanda_mpAttivitaUltimoAnno2_selectedMultiPanel", null);
					}
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.threInt);
					AttivitaUltimoAnno3 attivitaAnno3 = new AttivitaUltimoAnno3();
					List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita3SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
					if (attivita3SvoltaPerAzienda != null && !attivita3SvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaAnnoTre : attivita3SvoltaPerAzienda) {
							attivitaAnno3.setManutenzione(String.valueOf(attivitaAnnoTre.getValore2Dettaglio()));
							attivitaAnno3.setRealizzazione(String.valueOf(attivitaAnnoTre.getValore1Dettaglio()));
							attivitaAnno3.setPercentuale(String.valueOf(attivitaAnnoTre.getFatturato()));
						}
						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita3(attivitaAnno3);
						// opernattivita1
						theModel.setWidg_chbAttivitaUltimoAnno3(true);
						ActionContext.getContext().getSession().put(
								"CpDomanda_mpAttivitaUltimoAnno3_selectedMultiPanel",
								"CpDomanda_mpAttivitaUltimoAnno3_fpAttivitaUltimoAnno3");
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno3(false);
						ActionContext.getContext().getSession()
								.put("CpDomanda_mpAttivitaUltimoAnno3_selectedMultiPanel", null);

					}
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.fourInt);

					AttivitaUltimoAnno4 attivitaAnno4 = new AttivitaUltimoAnno4();
					MaterialePropagazione materialePropagazione = new MaterialePropagazione();

					String altroMateriale = "";
					List<Integer> listaProgressivi = new ArrayList<Integer>();
					ArrayList<String> listaIdMateriali = new ArrayList<String>();
					List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita4SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
					if (attivita4SvoltaPerAzienda != null && !attivita4SvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaAnnoFour : attivita4SvoltaPerAzienda) {
							attivitaAnno4.setPercentuale(String.valueOf(attivitaAnnoFour.getFatturato()));
							attivitaAnno4.setElencoMaterialiPropagazione(materialePropagazioneList);

							listaProgressivi.add(attivitaAnnoFour.getProgressivoDettaglio());
						}
						List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> materialeByAttivita = new ArrayList<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto>();
						AttivitaProgressivoFilter attivitaProgressivoFilter = new AttivitaProgressivoFilter();
						attivitaProgressivoFilter.setIdAttivita(attivita4SvoltaPerAzienda.get(0).getId());
						for (Integer progressivo : listaProgressivi) {
							attivitaProgressivoFilter.setProgressivo(progressivo);
							materialeByAttivita = taifMgr.findMaterialeByAttivitaProgressivo(attivitaProgressivoFilter);
							for (TaifRAttivDetMaterialeByIdAttivitaProgressivoDto materiale : materialeByAttivita) {
								log.info("EXECUTE INIT 3.1 ATTIVITA 4 Materiale from DB idMateriale: "
										+ materiale.getIdMateriale());

								listaIdMateriali.add(String.valueOf(materiale.getIdMateriale()));
								if (materiale.getIdMateriale() == 6) {
									altroMateriale = taifMgr
											.findByPrimaryKeyMaterialeDett(
													new TaifRAttivDetMaterialePk(materiale.getIdMateriale(),
															attivitaProgressivoFilter.getIdAttivita(), progressivo))
											.getDescrAltroMateriale();

								}
							}
						}
						if (StringUtils.isNotEmpty(altroMateriale) && StringUtils.isNotBlank(altroMateriale)) {
							log.info("EXECUTE INIT 3.1 ATTIVITA 4 Altro: " + altroMateriale);
							attivitaAnno4.setAltro(altroMateriale);
							attivitaAnno4.setAltroVisibile(true);
							for (MaterialePropagazione matPropagazione : materialePropagazioneList) {
								log.info("EXECUTE INIT 3.1 ATTIVITA 4 Altro: " + altroMateriale);
								if (matPropagazione.getIdMaterialePropagazione() == 6) {
									matPropagazione.setAltro(altroMateriale);
								}
							}

							for (Iterator<MaterialePropagazione> iter = materialePropagazioneList.listIterator(); iter
									.hasNext();) {

								MaterialePropagazione a = iter.next();
								log.info("EXECUTE INIT 3.1 ATTIVITA 4 IdMaterialePropagazione()== "
										+ a.getIdMaterialePropagazione());

								if (a.getIdMaterialePropagazione() == 0) {
									log.info("EXECUTE INIT 3.1 ATTIVITA 4 REMOVE id 0 IdMaterialePropagazione()== "
											+ a.getIdMaterialePropagazione());

									iter.remove();
								}
							}
						}
						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita4(attivitaAnno4);
						theModel.setAppDataidMaterialiPropagazione(listaIdMateriali);
						theModel.setWidg_chbAttivitaUltimoAnno4(true);
						ActionContext.getContext().getSession().put(
								"CpDomanda_mpAttivitaUltimoAnno4_selectedMultiPanel",
								"CpDomanda_mpAttivitaUltimoAnno4_fpAttivitaUltimoAnno4");
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno4(false);
						ActionContext.getContext().getSession()
								.put("CpDomanda_mpAttivitaUltimoAnno4_selectedMultiPanel", null);
					}

					// carico attivita5 

					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.fiveInt);
					int arb = 0;
					AttivitaUltimoAnno5 attivitaAnno5 = new AttivitaUltimoAnno5();
					List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> materialeByAttivitaFive = new ArrayList<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto>();
					ArrayList<ArboricolturaDaLegno> arboricolturaDaLegnoList = new ArrayList<ArboricolturaDaLegno>();
					List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita5SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
					List<Integer> listaProgressivi5 = new ArrayList<Integer>();
					if (attivita5SvoltaPerAzienda != null && !attivita5SvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaAnnoFive : attivita5SvoltaPerAzienda) {

							attivitaAnno5.setPercentuale(String.valueOf(attivitaAnnoFive.getFatturato()));

							attivitaAnno5.setIdAttivita(attivitaAnnoFive.getId());
							if (attivitaAnnoFive.getAltreAttivita() != null) {
								attivitaAnno5.setAltro(attivitaAnnoFive.getAltreAttivita());
							}
							attivitaAnno5.setAltroVisibile(true);
							attivitaAnno5.setElencoArbolicoltureDaLegno(taifMgr.getElencoArboricolturaDaLegno(
									attivitaAnnoFive.getId(), this.getMaterialeFilter(theModel,
											it.csi.taif.taifweb.business.dao.util.Constants.aChar)));

							materialeFilter.setFlagVivaiArb(it.csi.taif.taifweb.business.dao.util.Constants.aChar);
							materialeFilter.setFlagVisibile(1);
							ArboricolturaDaLegno arboricolturaLegno = new ArboricolturaDaLegno();

							arboricolturaLegno.setManutenzione(String.valueOf(attivitaAnnoFive.getValore2Dettaglio()));
							arboricolturaLegno.setRealizzazione(String.valueOf(attivitaAnnoFive.getValore1Dettaglio()));
							arboricolturaLegno.setConduzione(String.valueOf(attivitaAnnoFive.getValore3Dettaglio()));
							arboricolturaLegno.setIdArboricolturaDaLegno(attivitaAnno5.getIdAttivita());
							arboricolturaLegno.setElencoTipoMateriale(taifMgr.getElencoMateriali(materialeFilter));

							AttivitaProgressivoFilter attivitaProgressivoFilter = new AttivitaProgressivoFilter();
							attivitaProgressivoFilter.setIdAttivita(attivitaAnnoFive.getId());
							attivitaProgressivoFilter.setProgressivo(attivitaAnnoFive.getProgressivoDettaglio());
							materialeByAttivitaFive = taifMgr
									.findMaterialeByAttivitaProgressivo(attivitaProgressivoFilter);

							if (materialeByAttivitaFive.get(0).getIdMateriale() == 7) {
								arboricolturaLegno.setIdTipoMateriale(7);
								arboricolturaLegno.setAltro(it.csi.taif.taifweb.business.dao.util.Constants.blank);
							} else {
								arboricolturaLegno.setIdTipoMateriale(8);
								arboricolturaLegno.setAltroVisibile(true);
								arboricolturaLegno
										.setAltro(materialeByAttivitaFive.get(0).getDescrizioneAltroMateriale());
							}
							arboricolturaLegno.setRownum(arb++);
							arboricolturaLegno.setIconaCancellaVisibile(true);
							arboricolturaDaLegnoList.add(arboricolturaLegno);

							listaProgressivi5.add(attivitaAnnoFive.getProgressivoDettaglio());
						}
						attivitaAnno5.setElencoArbolicoltureDaLegno(arboricolturaDaLegnoList);
						theModel.setAppDataelencoArboricolturaDaLegno(arboricolturaDaLegnoList);
						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita5(attivitaAnno5);
						theModel.setWidg_chbAttivitaUltimoAnno5(true);
						ActionContext.getContext().getSession().put(
								"CpDomanda_mpAttivitaUltimoAnno5_selectedMultiPanel",
								"CpDomanda_mpAttivitaUltimoAnno5_fpAttivitaUltimoAnno5");
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno5(false);
						ActionContext.getContext().getSession()
								.put("CpDomanda_mpAttivitaUltimoAnno5_selectedMultiPanel", null);
					}

					// carico attivita6
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.sixInt);
					AttivitaUltimoAnno6 attivitaAnno6 = new AttivitaUltimoAnno6();
					List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita6SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
					if (attivita6SvoltaPerAzienda != null && !attivita6SvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaAnnoSix : attivita6SvoltaPerAzienda) {
							attivitaAnno6.setPercentuale(String.valueOf(attivitaAnnoSix.getFatturato()));
						}
						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita6(attivitaAnno6);

						if (attivitaAnno6 != null) {
							theModel.setWidg_chbAttivitaUltimoAnno6(true);
						}
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno6(false);
					}
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.sevenInt);
					AttivitaUltimoAnno7 attivitaAnno7 = new AttivitaUltimoAnno7();

					List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita7SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
					if (attivita7SvoltaPerAzienda != null && !attivita7SvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaAnnoSeven : attivita7SvoltaPerAzienda) {
							attivitaAnno7.setPercentuale(String.valueOf(attivitaAnnoSeven.getFatturato()));
						}
						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita7(attivitaAnno7);

						if (attivitaAnno7 != null) {
							theModel.setWidg_chbAttivitaUltimoAnno7(true);
						}
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno7(false);
					}
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.eightInt);
					AttivitaUltimoAnno8 attivitaAnno8 = new AttivitaUltimoAnno8();
					List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita8SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
					if (attivita8SvoltaPerAzienda != null && !attivita8SvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaAnnoEight : attivita8SvoltaPerAzienda) {
							attivitaAnno8.setPercentuale(String.valueOf(attivitaAnnoEight.getFatturato()));
							if (attivitaAnnoEight.getAltreAttivita() != null) {
								attivitaAnno8.setPercentuale(String.valueOf(attivitaAnnoEight.getFatturato()));
								attivitaAnno8.setAltro(attivitaAnnoEight.getAltreAttivita());
							}
						}
						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita8(attivitaAnno8);

						if (attivitaAnno8 != null) {
							theModel.setWidg_chbAttivitaUltimoAnno8(true);
						}
					} else {
						theModel.setWidg_chbAttivitaUltimoAnno8(false);
					}
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.nineInt);
					AttivitaUltimoAnno9 attivitaAnno9 = new AttivitaUltimoAnno9();
					List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita9SvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
					if (attivita9SvoltaPerAzienda != null && !attivita9SvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaAnnoNine : attivita9SvoltaPerAzienda) {
							attivitaAnno9.setPercentuale(String.valueOf(attivitaAnnoNine.getFatturato()));
							if (attivitaAnnoNine.getAltreAttivita() != null) {
								attivitaAnno9.setPercentuale(String.valueOf(attivitaAnnoNine.getFatturato()));
								attivitaAnno9.setAltro(attivitaAnnoNine.getAltreAttivita());
							}
						}
						theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivita9(attivitaAnno9);
						theModel.setWidg_chbAttivitaUltimoAnno9(true);

					} else {
						theModel.setWidg_chbAttivitaUltimoAnno9(false);
					}
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							Constants.BACK_DOMANDA_RIEPILOGO);
				} // endapplOk
				else {
					this.inizializeScheda3_1(theModel);
				}
			}

		} else {
			// elenco Francese
			AttivitaUltimoAnnoFr attivitaUltimoAnnoFr = new AttivitaUltimoAnnoFr();

			theModel.setAppDatagestioneAttivitaUltimoAnno(new GestioneAttivitaUltimoAnno());

			visibileOrdinFilter = getVisibileOrdinFilter(theModel);
			List<TaifDTipoAttivitaByFilterDto> listAttivitaFrancese = new ArrayList<TaifDTipoAttivitaByFilterDto>();
			listAttivitaFrancese = taifMgr.getElencoIdTipoAttivitaFrancese(visibileOrdinFilter);

			ArrayList<DettaglioAttivitaUltimoAnnoFr> dettaglioAttivitaUltimoAnnoFrList = new ArrayList<DettaglioAttivitaUltimoAnnoFr>();
			for (TaifDTipoAttivitaByFilterDto attivitaFrancese : listAttivitaFrancese) {
				DettaglioAttivitaUltimoAnnoFr dettaglioAttivitaUltimoAnnoFr = new DettaglioAttivitaUltimoAnnoFr();
				dettaglioAttivitaUltimoAnnoFr.setIdAttivita(attivitaFrancese.getId());
				dettaglioAttivitaUltimoAnnoFr.setPercentuale(it.csi.taif.taifweb.business.dao.util.Constants.blank);
				dettaglioAttivitaUltimoAnnoFr.setDescrizione(attivitaFrancese.getTipo());
				dettaglioAttivitaUltimoAnnoFr.setVolume(it.csi.taif.taifweb.business.dao.util.Constants.blank);
				dettaglioAttivitaUltimoAnnoFrList.add(dettaglioAttivitaUltimoAnnoFr);
			}
			attivitaUltimoAnnoFr.setElencoAttivitaFr(dettaglioAttivitaUltimoAnnoFrList);
			theModel.setAppDataelencoAttivitaUltimoAnnoFr(dettaglioAttivitaUltimoAnnoFrList);
			theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivitaFr(attivitaUltimoAnnoFr);

			int idAzienda = theModel.getAppDataidAzienda() == null ? 0 : theModel.getAppDataidAzienda();
			TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
			if (scheda != null) {
				if ((scheda.getFlgSez31ItaOk()
						.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
						|| scheda.getFlgSez31FraOk()
								.byteValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {

					theModel.setAppDatagestioneAttivitaUltimoAnno(new GestioneAttivitaUltimoAnno());

					aziendaVisibleFilter = getAziendaVisibleFilter(theModel);
					ArrayList<String> newListIdAttivita = new ArrayList<String>();
					aziendaVisibleFilter.setIdTipoAttivita(it.csi.taif.taifweb.business.dao.util.Constants.zeroInt);
					ArrayList<DettaglioAttivitaUltimoAnnoFr> dettaglioAttivitaList = new ArrayList<DettaglioAttivitaUltimoAnnoFr>();
					dettaglioAttivitaList = theModel.getAppDataelencoAttivitaUltimoAnnoFr();
					AttivitaUltimoAnnoFr attivitaFra = new AttivitaUltimoAnnoFr();
					List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivitaFranceseSvoltaPerAzienda = taifMgr
							.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
					if (attivitaFranceseSvoltaPerAzienda != null && !attivitaFranceseSvoltaPerAzienda.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaFrancese : attivitaFranceseSvoltaPerAzienda) {
							for (DettaglioAttivitaUltimoAnnoFr dettAtt : dettaglioAttivitaList) {
								if (attivitaFrancese.getIdTipoAttivita() == dettAtt.getIdAttivita()) {
									dettAtt.setVolume(String.valueOf(attivitaFrancese.getValore1Dettaglio()));
									dettAtt.setPercentuale(String.valueOf(attivitaFrancese.getFatturato()));
									dettAtt.setIdAttivita(attivitaFrancese.getIdTipoAttivita());
									dettAtt.setDescrizione(attivitaFrancese.getTipoAttivita());
									newListIdAttivita.add(String.valueOf(attivitaFrancese.getIdTipoAttivita()));
								}
							}
						}
						attivitaFra.setElencoAttivitaFr(dettaglioAttivitaList);
					}

					TaifTAziendaDto thisAzienda = taifMgr.getAziendaById(idAzienda);
					attivitaFra.setCliente1Fr(thisAzienda.getClient1Fra());
					attivitaFra.setCliente2Fr(thisAzienda.getClient2Fra());
					attivitaFra.setCliente3Fr(thisAzienda.getClient3Fra());
					theModel.getAppDatagestioneAttivitaUltimoAnno().setAttivitaFr(attivitaFra);
					theModel.setAppDataelencoAttivitaUltimoAnnoFr(dettaglioAttivitaList);

					//newListIdAttivita=taifMgr.getElencoDSTipoAttivitaFrancese(visibileOrdinFilter);
					theModel.setAppDataidAttivitaUltimoAnnoFr(newListIdAttivita);

				}
			}
		}
		this.setVisibility(theModel, DomandaViewHelper.initScheda3_1(theModel));
	}

	private void setVisibilityConsultaIstanzaTaglioPresentate(CpDomandaModel theModel)
			throws ManagerException, CommandExecutionException {
		CpDomandaAction action = new CpDomandaAction();
		action.setSession(theModel.getSession());
		List<String> show = new ArrayList<String>();
		List<String> hide = new ArrayList<String>();
		TaifTPraticaByIdAziendaDto pratica = taifMgr.pratichePerAzienda(theModel.getAppDataidAzienda());
		Integer idSoggettoGestore = pratica.getIdSoggettoGestore();
		if (idSoggettoGestore != it.csi.taif.taifweb.business.dao.util.Constants.GESTORE_PIEMONTE) {
			log.info("init 3.1: hide consulta idSoggettoGestore" + idSoggettoGestore);
			hide.add("ptConsultaIstanzaTaglioPresentate");
			hide.add("btnConsultaIstanzaTaglioPresenti");
			VisibilityCommand vcHide = new VisibilityCommand(hide.toArray(new String[0]), false);
			vcHide.doCommand(action);
		} else {
			log.info("init 3.1: show idSoggettoGestore" + idSoggettoGestore);
			show.add("ptConsultaIstanzaTaglioPresentate");
			show.add("btnConsultaIstanzaTaglioPresenti");
			VisibilityCommand vcShow = new VisibilityCommand(show.toArray(new String[0]), true);
			vcShow.doCommand(action);
		}
	}

	private MaterialeFilter getMaterialeFilter(CpDomandaModel theModel, String flag) {
		materialeFilter.setFlagVisibile(1);
		materialeFilter.setFlagVivaiArb(flag);
		return materialeFilter;
	}

	private CommercializzazioneFilter getCommercializzazioneFilter(CpDomandaModel theModel) {
		// TODO Auto-generated method stub
		CommercializzazioneFilter commFilter = new CommercializzazioneFilter();
		commFilter.setIdAzienda(theModel.getAppDataidAzienda());
		// ??? TODO Verificare
		commFilter.setIdSpecie(1);
		return commFilter;
	}

	private FormaGiuridicaFilter getFormaGiuridicaFilter(CpDomandaModel theModel) {
		formaGiuridicaFilter.setFlagItaFr(theModel.getAppDatatracciato());
		formaGiuridicaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		return formaGiuridicaFilter;
	}

	public void executeInit2_2(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws ManagerException {
		theModel.setAppDataelencoAltriAlbi(taifMgr.getElencoAltriAlbi(theModel.getAppDataidAzienda()));
		theModel.setAppDataelencoCertificazioni(taifMgr.getElencoCertificazioniforAzienda(
				this.getVisibileOrdinFilter(theModel), theModel.getAppDataidAzienda()));
		theModel.setAppDataelencoFormeOrganizzative(
				taifMgr.getElencoFormeOrganizzative(this.getVisibileOrdinFilter(theModel)));
		int idAzienda = theModel.getAppDataidAzienda() == null ? 0 : theModel.getAppDataidAzienda();
		//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
		if (scheda != null) {
			log.debug("EXECUTE INIT 2_2 scheda.getFlgSez22ItaOk(): " + scheda.getFlgSez22ItaOk().byteValueExact());
			if ((scheda.getFlgSez22ItaOk().byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
					|| scheda.getFlgSez22FraOk()
							.byteValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {

				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				if (theModel.getAppDataidAzienda() != null) {
					ArrayList<String> listIdAlbi = new ArrayList<String>();
					ArrayList<String> listIdFormeOrganizzative = new ArrayList<String>();
					ArrayList<Albo> listAlbi = new ArrayList<Albo>();

					List<TaifTPraticaByIdAziendaDto> altrePratichePerAzienda = new ArrayList<TaifTPraticaByIdAziendaDto>();
					ArrayList<Certificazione> listCertificati = new ArrayList<Certificazione>();
					ArrayList<FormaOrganizzativa> listFormaOrganizzativa = new ArrayList<FormaOrganizzativa>();
					List<TaifTPraticaByIdAziendaDto> pratichePerAzienda = taifMgr.getPraticaPerIdAzienda(idAzienda);
					int i = 0;
					if (!pratichePerAzienda.isEmpty()) {
						for (TaifTPraticaByIdAziendaDto taifTPraticaByIdAziendaDto : pratichePerAzienda) {
							Albo alboTrovato = new Albo();
							if (taifTPraticaByIdAziendaDto.getDenominazioneAltroAlbo() != null) {
								alboTrovato.setDenominazione(taifTPraticaByIdAziendaDto.getDenominazioneAltroAlbo());
							}
							if (taifTPraticaByIdAziendaDto.getNrAlbo() != null) {
								alboTrovato.setNumeroAlbo(taifTPraticaByIdAziendaDto.getNrAlbo());
							}
							if (taifTPraticaByIdAziendaDto.getDataInscrizioneAlbo() != null) {
								alboTrovato.setDataIscrizione(
										df.format(taifTPraticaByIdAziendaDto.getDataInscrizioneAlbo()));
							}
							if (taifTPraticaByIdAziendaDto.getIdPratica() != null) {
								alboTrovato.setIdAlbo(taifTPraticaByIdAziendaDto.getIdPratica());
							}
							alboTrovato.setRownum(i++);
							listAlbi.add(alboTrovato);
						}
					}
					if (pratichePerAzienda.isEmpty() || (listAlbi.size() == 1 && listAlbi.get(0).getIdAlbo() == 0)) {
						log.info("EXECUTE INIT 2.2 NASCONDI SEZIONA ALTRI ALBI");
						theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("NO");
						ActionContext.getContext().getSession()
								.put("CpDomanda_mpDatiSocioEconomiciAltriAlbi_selectedMultiPanel", null);
					} else {
						log.info("EXECUTE INIT 2.2 VISUALIZZA SEZIONA ALTRI ALBI");

						theModel.setAppDataelencoAltriAlbi(listAlbi);
						theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("SI");
						ActionContext.getContext().getSession().put(
								"CpDomanda_mpDatiSocioEconomiciAltriAlbi_selectedMultiPanel",
								"CpDomanda_mpDatiSocioEconomiciAltriAlbi_fpDatiSocioEconomiciAltriAlbi");
					}

					// formeOrganizzative
					log.info("INIZIO INIT FORME ORGANIZZATIVE");
					log.info("ID AZIENDA: " + idAzienda);
					log.debug("INIZIO INIT FORME ORGANIZZATIVE");
					log.debug("ID AZIENDA: " + idAzienda);
					List<Integer> listOfCategorie = Arrays.asList(5, 6, 7, 12, 13, 14);
					ArrayList<TaifRAziendaAssociazioneByIdAziendaDto> elencoAssociazioni = (ArrayList<TaifRAziendaAssociazioneByIdAziendaDto>) taifMgr
							.getElencoAssociazioniPerIdAzienda(idAzienda);
					log.info("ELENCO ASSOCIAZIONI");
					log.debug("ELENCO ASSOCIAZIONI");

					for (FormaOrganizzativa formaOrganizzativa : theModel.getAppDataelencoFormeOrganizzative()) {
						for (TaifRAziendaAssociazioneByIdAziendaDto taifRAziendaAssociazioneByIdAziendaDto : elencoAssociazioni) {
							log.info("ASSOCIAZIONE: " + taifRAziendaAssociazioneByIdAziendaDto.getNome());
							log.debug("ASSOCIAZIONE: " + taifRAziendaAssociazioneByIdAziendaDto.getNome());

							//formaOrganizzativa.setIdFormaOrganizzativa(taifRAziendaAssociazioneByIdAziendaDto.getIdAssociazione());
							if (formaOrganizzativa.getIdFormaOrganizzativa() == taifRAziendaAssociazioneByIdAziendaDto
									.getIdAssociazione()) {
								log.info("DENTRO AL PRIMO IF");
								log.debug("DENTRO AL PRIMO IF");

								if ((listOfCategorie.contains(formaOrganizzativa.getIdFormaOrganizzativa()))
										&& (taifRAziendaAssociazioneByIdAziendaDto.getNome() != null)) {
									log.info("DENTRO AL SECONDO IF");
									log.debug("DENTRO AL SECONDO IF");

									formaOrganizzativa.setAltro(taifRAziendaAssociazioneByIdAziendaDto.getNome());
									formaOrganizzativa.setAltroVisibile(true);
								}
							}
							listIdFormeOrganizzative
									.add(taifRAziendaAssociazioneByIdAziendaDto.getIdAssociazione().toString());
							listFormaOrganizzativa.add(formaOrganizzativa);
						}
					}
					theModel.setAppDataidFormeOrganizzative(listIdFormeOrganizzative);

					//taif-8: commento porzione di codice che genera l'errore segnalato e che appare superflua in quanto il campo "altro" viene già settato correttamente nel precedente ciclo for
					//					ArrayList<FormaOrganizzativa> formaOrganizzativaList = theModel
					//							.getAppDataelencoFormeOrganizzative();
					//					if (formaOrganizzativaList != null) {
					//						for (FormaOrganizzativa formaOrganizzativa : formaOrganizzativaList) {
					//							if (formaOrganizzativa.getAltroVisibile()) {
					//								if ((formaOrganizzativa.getIdFormaOrganizzativa() == 5)
					//										|| (formaOrganizzativa.getIdFormaOrganizzativa() == 12)) {
					//									if (theModel.getAppDataassociazioniECertificazioni() != null 
					//											&& theModel.getAppDataassociazioniECertificazioni().getAltro4() != null) {
					//										log.info("APPDATA ASSOC E CERT ALTRO 4: " + theModel.getAppDataassociazioniECertificazioni().getAltro4());
					//										formaOrganizzativa
					//												.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro4());
					//										formaOrganizzativa.setAltroVisibile(true);
					//									}
					//								}
					//								if ((formaOrganizzativa.getIdFormaOrganizzativa() == 6)
					//										|| (formaOrganizzativa.getIdFormaOrganizzativa() == 13)) {
					//									if (theModel.getAppDataassociazioniECertificazioni() != null
					//											&& theModel.getAppDataassociazioniECertificazioni().getAltro5() != null) {
					//										log.info("APPDATA ASSOC E CERT ALTRO 5: " + theModel.getAppDataassociazioniECertificazioni().getAltro5());
					//
					//										formaOrganizzativa
					//												.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro5());
					//										formaOrganizzativa.setAltroVisibile(true);
					//									}
					//								}
					//								if ((formaOrganizzativa.getIdFormaOrganizzativa() == 7)
					//										|| (formaOrganizzativa.getIdFormaOrganizzativa() == 14)) {
					//									if (theModel.getAppDataassociazioniECertificazioni() != null
					//											&& theModel.getAppDataassociazioniECertificazioni().getAltro6() != null) {
					//										log.info("APPDATA ASSOC E CERT ALTRO 6: " + theModel.getAppDataassociazioniECertificazioni().getAltro6());
					//
					//										formaOrganizzativa
					//												.setAltro(theModel.getAppDataassociazioniECertificazioni().getAltro6());
					//										formaOrganizzativa.setAltroVisibile(true);
					//									}
					//								}
					//
					//							}
					//						}
					//					}
					log.info("FINE INIT FORME ORGANIZZATIVE");
					log.debug("FINE INIT FORME ORGANIZZATIVE");

					// certificazioni
					AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(theModel);
					List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> certificazioniList = taifMgr
							.findCertificazioniByIdAzienda(aziendaVisibleFilter);
					ArrayList<CodeDescription> elencoCertificazioni = taifMgr
							.getElencoTipoCertificazioni(this.getVisibileOrdinFilter(theModel));
					int j = 0;
					for (TaifTCertificazioneFindCertificazioniByIdAziendaDto certificato : certificazioniList) {
						Certificazione certificazione = new Certificazione();

						certificazione.setElencoTipoCertificazione(elencoCertificazioni);
						certificazione.setIdCertificazione(certificato.getIdCertificazione());
						certificazione.setEnteCertificatore(certificato.getEnteCertificatore());
						certificazione.setDataScadenza(df.format(certificato.getDataScadenza()));
						certificazione.setAnnoRilascio(String.valueOf(certificato.getAnnoCertificazione()));
						certificazione.setNumero(certificato.getNumeroCertificazione());
						certificazione.setIdTipoCertificazione(certificato.getIdTipoCertificazione());
						if (certificazione.getIdTipoCertificazione() == 5
								|| certificazione.getIdTipoCertificazione() == 12) {
							certificazione.setAltro(certificato.getAltraCertificazione());
						}
						certificazione.setRownum(j++);
						listCertificati.add(certificazione);
					}
					if (listCertificati.isEmpty()
							|| (listCertificati.size() == 1 && listCertificati.get(0).getIdCertificazione() == 0)) {
						log.info("EXECUTE INIT 2.2 NASCONDI SEZIONA CERTIFICAZIONI");

						theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("NO");
						ActionContext.getContext().getSession().put(
								"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_selectedMultiPanel", null);
					} else {
						log.info("EXECUTE INIT 2.2 VISUALIZZA SEZIONA CERTIFICAZIONI");

						theModel.setAppDataelencoCertificazioni(listCertificati);
						theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("SI");
						ActionContext.getContext().getSession().put(
								"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_selectedMultiPanel",
								"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_fpDatiSocioEconomiciCertificazioniQualitaProcesso");

					}

				}
				ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			} else {
				log.debug("EXECUTE INIT 2_2 FlgSez22ItaOk: " + scheda.getFlgSez22ItaOk());
				theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("NO");
				theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("NO");
			}
		} else {

			if (!theModel.getAppDataelencoAltriAlbi().isEmpty()) {
				if (theModel.getAppDataelencoAltriAlbi().size() == 1
						&& theModel.getAppDataelencoAltriAlbi().get(0).getIdAlbo() == 0) {
					theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("NO");
					ActionContext.getContext().getSession()
							.put("CpDomanda_mpDatiSocioEconomiciAltriAlbi_selectedMultiPanel", null);
				} else {
					theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi("SI");
					ActionContext.getContext().getSession().put(
							"CpDomanda_mpDatiSocioEconomiciAltriAlbi_selectedMultiPanel",
							"CpDomanda_mpDatiSocioEconomiciAltriAlbi_fpDatiSocioEconomiciAltriAlbi");
				}
			}
			if (!theModel.getAppDataelencoCertificazioni().isEmpty()) {
				if (theModel.getAppDataelencoAltriAlbi().size() == 1
						&& theModel.getAppDataelencoAltriAlbi().get(0).getIdAlbo() == 0) {
					theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("NO");
					ActionContext.getContext().getSession().put(
							"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_selectedMultiPanel", null);
				} else {
					theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso("SI");
					ActionContext.getContext().getSession().put(
							"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_selectedMultiPanel",
							"CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_fpDatiSocioEconomiciCertificazioniQualitaProcesso");
				}
			}
		}
	}

	public void executeInit2_1(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {
		theModel.setAppDataelencoCategorieImpresa(
				taifMgr.getElencoCategorieImpresa(this.getVisibileOrdinFilter(theModel)));
		ArrayList<String> idCategoriaList = new ArrayList<String>();
		int idAzienda = theModel.getAppDataidAzienda() == null ? 0 : theModel.getAppDataidAzienda();
		//TaifApplSchedaOkDto scheda = taifMgr.getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = taifMgr.getInfoSchedeAzienda(idAzienda);
		if (scheda != null) {
			if ((scheda.getFlgSez21ItaOk().byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
					|| scheda.getFlgSez21FraOk()
							.byteValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {

				if (theModel.getAppDataidAzienda() != null) {
					TaifTAziendaDto aziendaTrovata = taifMgr.getAziendaById(idAzienda);

					ArrayList<CategoriaImpresa> categoriaImpresaList = taifMgr.getCategoriaImpresaByAzienda(idAzienda);

					FatturatoCategorieDiImpresa fattImpresa = new FatturatoCategorieDiImpresa();
					if (aziendaTrovata.getAnnoInizio() != null) {
						fattImpresa
								.setAnnoInizioAttivita(String.valueOf(aziendaTrovata.getAnnoInizio().intValueExact()));
					}
					if (aziendaTrovata.getFatturato() != null) {
						fattImpresa.setFatturatoUltimoAnno(String.valueOf(aziendaTrovata.getFatturato()));
						theModel.setAppDatafatturatoCategorieDiImpresa(fattImpresa);
					} else {
						theModel.setAppDatafatturatoCategorieDiImpresa(fattImpresa);
					}
					for (CategoriaImpresa categoriaImpresa : categoriaImpresaList) {
						idCategoriaList.add(String.valueOf(categoriaImpresa.getIdCategoria()));
					}
					//					if (categoriaImpresaList != null && !categoriaImpresaList.isEmpty()) {
					//						theModel.setAppDataidCategorieImpresaSelezionati(idCategoriaList);
					//					}
					//theModel.setAppDataidCategorieImpresaSelezionati(idCategoriaList);
					theModel.setAppDataidCategorieImpresaSelezionato(idCategoriaList.get(0));
					ArrayList<CategoriaImpresa> list = new ArrayList<CategoriaImpresa>();
					for (CategoriaImpresa categoriaImpresa : theModel.getAppDataelencoCategorieImpresa()) {
						for (CategoriaImpresa categoriaVall : categoriaImpresaList) {
							if (categoriaImpresa.getIdCategoria() == categoriaVall.getIdCategoria()) {
								if (categoriaImpresa.getIdCategoria() == 5 || categoriaImpresa.getIdCategoria() == 10) {
									categoriaImpresa.setAltro(categoriaVall.getAltro());
									categoriaImpresa.setAltroVisibile(true);
								}
							}
						}
						list.add(categoriaImpresa);
					}
					theModel.setAppDataelencoCategorieImpresa(list);
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							Constants.BACK_DOMANDA_RIEPILOGO);
				}

			}

		}
		this.setVisibility(theModel, DomandaViewHelper.initScheda2_1(theModel));
	}

	private ArrayList<CodeDescription> suggestComuni(String comuneDaCercare) throws ManagerException {
		ArrayList<CodeDescription> list = this.taifMgr.getElencoComuni();
		ArrayList<CodeDescription> suggs = new ArrayList<CodeDescription>();

		for (int i = 0; i < list.size(); i++) {
			if (comuneDaCercare.toUpperCase()
					.startsWith((list.get(i).getDescription().substring(0, 4).toUpperCase()))) {
				suggs.add(list.get(i));
			}
		}
		return suggs;
	}

	private ArrayList<CodeDescription> suggestPersonale(String codiceFiscaleDaCercare) throws ManagerException {
		List<CodeDescription> list = this.taifMgr.getElencoPersone();
		ArrayList<CodeDescription> suggs = new ArrayList<CodeDescription>();

		for (int i = 0; i < list.size(); i++) {
			if (codiceFiscaleDaCercare.toUpperCase()
					.startsWith((list.get(i).getDescription().substring(0, 4).toUpperCase()))) {
				suggs.add(list.get(i));
			}
		}
		return suggs;
	}

	@Deprecated
	private TaifTPersonaByProfiloPersonaDto getProfiloPersonaAzienda(UserInfo userInfo) throws DbManagerException {
		ConfigProfiloFilter profiloAzienda = getConfigProfiloUtenteAzienda();
		int idProfilo = this.taifMgr.getProfiloUtenteByProcedura(profiloAzienda).getIdProfilo();
		ConfigProfiloPersona configFilter = getConfigProfiloPersona(userInfo.getCodFisc(), idProfilo);
		TaifTPersonaByProfiloPersonaDto personaprofiloAzienda = this.taifMgr
				.getPersonaByCodiceFiscaleandProfilo(configFilter);
		return personaprofiloAzienda;
	}

	private Map<String, Boolean> valorizzaAttMap(CpDomandaModel theModel) {
		Map<String, Boolean> attrezzatureMap = new HashMap<String, Boolean>();
		attrezzatureMap.put(Constants.checkCaschi, theModel.getWidg_chbAttrezzatureCascoForestale());
		attrezzatureMap.put(Constants.checkScarponi, theModel.getWidg_chbAttrezzatureScarponiRinforzati());
		attrezzatureMap.put(Constants.checkPantaloni, theModel.getWidg_chbAttrezzaturePantaloniAntitaglio());
		return attrezzatureMap;

	}

	private void initRadioButtons(CpDomandaModel theModel, String defaultValue) {
		theModel.setWidg_rbsAttivitaLavoriPA(defaultValue);
		theModel.setWidg_rbsAttivitaLegname(defaultValue);
		theModel.setWidg_rbsDatiAnagraficiAltreSedi2(defaultValue);
		theModel.setWidg_rbsDatiAnagraficiAltroConducente(defaultValue);
		theModel.setWidg_rbsDatiSocioEconomiciAltriAlbi(defaultValue);
		theModel.setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso(defaultValue);
		theModel.setWidg_rbsPersonale(defaultValue);
	}

	private void setVisibility(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel, ConfigVisibility cv)
			throws Exception {
		CpDomandaAction action = new CpDomandaAction();
		action.setSession(theModel.getSession());

		VisibilityCommand show = new VisibilityCommand(cv.getShow().toArray(new String[cv.getShow().size()]), true);
		show.doCommand(action);

		VisibilityCommand hide = new VisibilityCommand(cv.getHide().toArray(new String[cv.getHide().size()]), false);
		hide.doCommand(action);

		OnOffCommand on = new OnOffCommand(cv.getOn().toArray(new String[cv.getOn().size()]), true);
		on.doCommand(action);

		OnOffCommand off = new OnOffCommand(cv.getOff().toArray(new String[cv.getOff().size()]), false);
		off.doCommand(action);

		if (cv.getActivate() != null) {
			for (String s : cv.getActivate()) {
				String mpname = org.apache.commons.lang3.StringUtils.substringBefore(s, ".");
				String fpname = org.apache.commons.lang3.StringUtils.substringAfter(s, ".");
				ActivateMultiPanelItemCommand activate = new ActivateMultiPanelItemCommand(CPNAME, mpname, fpname);
				activate.doCommand(action);
			}
		}

		if (cv.getDeactivate() != null) {
			for (String s : cv.getDeactivate()) {
				String mpname = org.apache.commons.lang3.StringUtils.substringBefore(s, ".");
				ActivateMultiPanelItemCommand deactivate = new ActivateMultiPanelItemCommand(CPNAME, mpname, null);
				deactivate.doCommand(action);
			}
		}

	}

	public void executeInit1_1(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {
		int idAzienda = theModel.getAppDataidAzienda() == null ? 0 : theModel.getAppDataidAzienda();
		String dataTracciato = theModel.getAppDatatracciato();
		if (dataTracciato == null) {
			Integer idSoggettoGestore = theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore();
			if (idSoggettoGestore != null) {
				theModel.setAppDatatracciato(
						GenericUtil.getTracciatoFromSoggettoGestore(ConvertUtil.convertToString(idSoggettoGestore)));
			} else {
				theModel.setAppDatatracciato(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
			}
		}

		formaGiuridicaFilter = getFormaGiuridicaFilter(theModel);
		visibileOrdinFilter = this.getVisibileOrdinFilter(theModel);
		//appDatatitolareRappresentanteLegale.nrsiMsa
		if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.fLang)) {
			theModel.setAppDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
					taifMgr.getElencoNazioniFra(visibileOrdinFilter));
		} else {
			theModel.setAppDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale(this.taifMgr.getElencoProvince());
			ArrayList<CodeDescription> comuni = this.taifMgr.getElencoComuni();
			if (comuni != null) {
				theModel.setAppDataelencoComuniDatiAnagraficiAnagrafeAziendale(comuni);
				theModel.setAppDataelencoComuniNascitaTitolareRappresentante(comuni);
				theModel.setAppDataelencoComuniResidenzaTitolareRappresentante(comuni);
				theModel.setAppDataelencoComuniNascitaAltroTitolareRappresentante(comuni);
				theModel.setAppDataelencoComuniResidenzaAltroTitolareRappresentante(comuni);
			} else {
				ArrayList<CodeDescription> empty = new ArrayList<CodeDescription>();
				theModel.setAppDataelencoComuniDatiAnagraficiAnagrafeAziendale(empty);
				theModel.setAppDataelencoComuniNascitaTitolareRappresentante(empty);
				theModel.setAppDataelencoComuniResidenzaTitolareRappresentante(empty);
				theModel.setAppDataelencoComuniNascitaAltroTitolareRappresentante(empty);
				theModel.setAppDataelencoComuniResidenzaAltroTitolareRappresentante(empty);
			}
			ActionContext.getContext().getSession().put("appDataelencoComuniNascitaTitolareRappresentante", comuni);
			theModel.setAppDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
					taifMgr.getElencoNazioniIta(visibileOrdinFilter));
			theModel.setAppDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale(
					this.taifMgr.getElencoAttivitaAteco(visibileOrdinFilter));
		}
		theModel.setAppDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale(
				this.taifMgr.getElencoAttivitaAteco(visibileOrdinFilter));
		theModel.setAppDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale(
				this.taifMgr.getElencoFormaGiuridica(formaGiuridicaFilter));
		theModel.setAppDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
				taifMgr.getElencoTitoliDiStudio(visibileOrdinFilter));

		if (theModel.getAppDataidAzienda() != null) {
			// find azienda for idAzienda
			AnagraficaAziendale aziendaTrovata = taifMgr.getAnagraficaAziendaleFromIdAzienda(idAzienda, dataTracciato);
			ArrayList<Sede> listSedi = new ArrayList<Sede>();
			listSedi = taifMgr.getListSedePerAzienda(idAzienda);
			aziendaTrovata.setPrivacy(true);
			ArrayList<Sede> altreSedi = new ArrayList<Sede>();
			theModel.setAppDatacodiceFiscale(aziendaTrovata.getCodiceFiscale());
			theModel.setAppDatapartitaIva(aziendaTrovata.getPartitaIva());
			theModel.setAppDataanagraficaAziendale(aziendaTrovata);
			theModel.setAppDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale(
					aziendaTrovata.getIdAttivitaPrimaria());
			if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				theModel.getAppDataanagraficaAziendale().setIdProvinciaCCIAA(aziendaTrovata.getIdProvinciaCCIAA());
				theModel.setAppDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale(
						aziendaTrovata.getIdAttivitaSecondaria());
				theModel.setAppDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale(
						aziendaTrovata.getIdProvinciaCCIAA());
			}

			theModel.setAppDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale(
					aziendaTrovata.getIdAttivitaPrimaria());
			theModel.getAppDataanagraficaAziendale().setNumeroCCIAA(aziendaTrovata.getNumeroCCIAA());
			theModel.getAppDataanagraficaAziendale().setTelefono(aziendaTrovata.getTelefono());
			theModel.getAppDataanagraficaAziendale().setCellulare(aziendaTrovata.getCellulare());
			theModel.setAppDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale(aziendaTrovata.getIdFormaGiurdica());
			theModel.getAppDataanagraficaAziendale().setDescrizione(aziendaTrovata.getDescrizione());

			//theModel.getAppDataanagraficaAziendale().setIdFormaGiurdica(aziendaTrovata.getIdFormaGiurdica());
			if (aziendaTrovata.getIdFormaGiurdica().equals(9) || aziendaTrovata.getIdFormaGiurdica().equals(14)) {
				if (aziendaTrovata.getNote() != null) {
					theModel.setAppDatadescrizione(aziendaTrovata.getNote());
				}
			}

			int kk = 0;
			for (Sede sede : listSedi) {
				if (sede.getIdTipoSede() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
					theModel.setAppDatasedeLegaleAnagrafeAziendale(sede);
					theModel.setAppDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale(
							String.valueOf(sede.getIstatComuneSede()));

					theModel.getAppDatasedeLegaleAnagrafeAziendale().setIndirizzo(sede.getIndirizzo());
					theModel.getAppDatasedeLegaleAnagrafeAziendale().setNumeroCivico(sede.getNumeroCivico());
					if (sede.getTelefono() != null) {
						theModel.getAppDatasedeLegaleAnagrafeAziendale().setTelefono(sede.getTelefono());
					}
					if (sede.getCellulare() != null) {
						theModel.getAppDatasedeLegaleAnagrafeAziendale().setCellulare(sede.getCellulare());
					}
					theModel.getAppDatasedeLegaleAnagrafeAziendale().setCap(sede.getCap());
					if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.fLang)) {
						theModel.getAppDatasedeLegaleAnagrafeAziendale().setDsComune(sede.getDsComune());

					}
				} else {
					if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
						sede.setElencoComuni(this.taifMgr.getElencoComuni());
						sede.setElencoTipoSede(
								taifMgr.getElencoTipoSedeAziendaNoSedeLegale(this.getVisibileOrdinFilter(theModel)));
						altreSedi.add(sede);
					}
				}
			}
			theModel.setAppDataelencoSediDatiAnagraficiAnagrafeAziendale(altreSedi);
			//int vv = 0;
			if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				if (altreSedi.isEmpty()) {
					theModel.setWidg_rbsDatiAnagraficiAltreSedi2(Constants.NO);
				} else {

					for (Sede sedeOperativa : altreSedi) {

						theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
								.setIdTipoSede(sedeOperativa.getIdTipoSede());
						theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
								.setIdComune(sedeOperativa.getIstatComuneSede());
						theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
								.setIstatComuneSede(sedeOperativa.getIstatComuneSede());
						theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
								.setDsComune(sedeOperativa.getDsComune());
						theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
								.setIndirizzo(sedeOperativa.getIndirizzo());
						theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
								.setNumeroCivico(sedeOperativa.getNumeroCivico());
						theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
								.setIdSede(sedeOperativa.getIdSede());
						if (sedeOperativa.getTelefono() != null) {
							theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
									.setTelefono(sedeOperativa.getTelefono());
						}
						if (sedeOperativa.getCellulare() != null) {
							theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
									.setCellulare(sedeOperativa.getCellulare());
						}
						sedeOperativa.setRownum(kk);
						kk++;
					}

					ActionContext.getContext().getSession().put("CpDomanda_mpDatiAnagraficiSedi_selectedMultiPanel",
							"CpDomanda_mpDatiAnagraficiSedi_fpDatiAnagraficiSedi");
					theModel.setWidg_rbsDatiAnagraficiAltreSedi2(Constants.SI);
					expandAltreSediDatiAnagrafici2(theModel);

				}
			}
			ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
		}

		if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			String codiceFiscaleAziendaImportata = (String) ActionContext.getContext().getSession()
					.get("codiceFiscaleAzienda");
			if (codiceFiscaleAziendaImportata != null) {
				aziendaImportata = taifMgr.importAziendaFromAAEP(codiceFiscaleAziendaImportata);
				if (aziendaImportata.getAnagraficaAziendale()
						.getIdAzienda() == it.csi.taif.taifweb.business.dao.util.Constants.zeroInt) {
					caricaDatiAziendaImportata(aziendaImportata, theModel);
				}
			}
		}
		log.debug("???? TRACCIATO ???? *" + theModel.getAppDatatracciato() + "*");
		this.setVisibility(theModel, DomandaViewHelper.initScheda1_1(theModel));
	}

	private ConfigProfiloFilter getConfigProfiloUtente(CpDomandaModel theModel) {
		log.debug(":::::::::::: configProfiloFilter :::::::::::: *" + configProfiloFilter + "*");
		configProfiloFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
		configProfiloFilter.setFlagAttivo(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		configProfiloFilter.setIdProcedura(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		configProfiloFilter.setDataTracciato(theModel.getAppDatatracciato());
		return configProfiloFilter;
	}

	private AziendaVisibleFilter getAziendaVisibleFilter(CpDomandaModel theModel) {
		aziendaVisibleFilter.setIdAzienda(theModel.getAppDataidAzienda());
		aziendaVisibleFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		aziendaVisibleFilter.setFlagItaFr(theModel.getAppDatatracciato());
		return aziendaVisibleFilter;
	}

	private void executeLocalInit(CpDomandaModel theModel) throws Exception {
		log.info("     +++++++++++++ theModel.getSession().get(Constants.WIZARD_DOMANDA) +"
				+ theModel.getSession().get(Constants.WIZARD_DOMANDA) + "+");
		log.info("     +++++++++++++ theModel.getSelectedTabKey() +" + theModel.getSelectedTabKey() + "+");
		log.info("     +++++++++++++ theModel.getSelectedTabValue +" + theModel.getSelectedTabValue() + "+");

		String selected = (String) theModel.getSession().get(Constants.WIZARD_DOMANDA);

		WizardDomandaStatus d = WizardDomandaStatus.getByName(selected);

		switch (d) {
			case WIZARD_VAL_1 :
				this.executeInit1_1(theModel);
				break;
			case WIZARD_VAL_2 :
				this.executeInit2_1(theModel);
				break;
			case WIZARD_VAL_3 :
				this.executeInit3_1(theModel);
				break;
			case WIZARD_VAL_4 :
				this.executeInit4(theModel);
				break;
			case WIZARD_VAL_5 :
				if (Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
					this.executeInit5_1(theModel);
				} else {
					this.executeInit5_2(theModel);
				}
				break;
			case WIZARD_VAL_6 :
				this.executeInit6(theModel);
				break;
			default :
				this.executeInit1_1(theModel);
		}

		String tipoAccesso = (String) ActionContext.getContext().getSession().get("tipoAccesso");

		//Integer idProfilo= (Integer)ActionContext.getContext().getSession().get("idProfilo");
		Integer idProfilo = ConvertUtil
				.convertToInteger(theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo());
		//idProfilo = 4;  // Only per TEST MM
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = taifMgr
				.getConfigProfiloUtenteByCodiceFiscale(getConfigProfiloUtente(theModel), idProfilo);
		ActionContext.getContext().getSession().put("profiloUtente", profiloUtente);
		this.setProfiloUtente(theModel, profiloUtente);

	}

	private void valorizzaCheckBoxForMezzi(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) {
		if (!theModel.getAppDataelencoMacchineTrattrici().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchinaTrattrici(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchinaTrattrici(false);
		}
		if (!theModel.getAppDataelencoMacchineMovimentoTerra().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchineMovimentoATerra(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchineMovimentoATerra(false);
		}
		if (!theModel.getAppDataelencoMacchineRimorchi().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchinaRimorchi(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchinaRimorchi(false);
		}
		if (!theModel.getAppDataelencoMacchineVerricelli().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchinaVerricelli(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchinaVerricelli(false);
		}
		if (!theModel.getAppDataelencoMacchinePle().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchinaPle(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchinaPle(false);
		}
		if (!theModel.getAppDataelencoMacchineTrinciaForestali().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchinaTrinciaForestale(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchinaTrinciaForestale(false);
		}
		if (!theModel.getAppDataelencoMacchineSegheriaMobile().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchineSegherieMobili(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchineSegherieMobili(false);
		}
		if (!theModel.getAppDataelencoMacchineGruACavo().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchineGruACavo(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchineGruACavo(false);
		}
		if (!theModel.getAppDataelencoMacchineCippatrici().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchineCippatrici(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchineCippatrici(false);
		}
		if (!theModel.getAppDataelencoMezziDiTrasporto().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMezziDiTrasporto(true);
		} else {
			theModel.setWidg_chbAttrezzatureMezziDiTrasporto(false);
		}
		if (!theModel.getAppDataelencoMacchineSpeciali().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchineSpeciali(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchineSpeciali(false);
		}
		if (!theModel.getAppDataelencoAltriMezzi().isEmpty()) {
			theModel.setWidg_chbAttrezzatureAltriMezzi(true);
		} else {
			theModel.setWidg_chbAttrezzatureAltriMezzi(false);
		}
	}

	private void valorizzaCheckBoxForDpi(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) {
		if (!theModel.getAppDataelencoCaschiForestaliAttrezzature().isEmpty()) {
			if (theModel.getAppDataelencoCaschiForestaliAttrezzature().size() == 1 && theModel
					.getAppDataelencoCaschiForestaliAttrezzature().get(0).getIdMezzoDiProtezioneIndividuale() == 0) {
				theModel.setWidg_chbAttrezzatureCascoForestale(false);
			} else {
				theModel.setWidg_chbAttrezzatureCascoForestale(true);
			}
		}
		if (!theModel.getAppDataelencoScarponiRinforzatiAttrezzature().isEmpty()) {
			if (theModel.getAppDataelencoScarponiRinforzatiAttrezzature().size() == 1 && theModel
					.getAppDataelencoScarponiRinforzatiAttrezzature().get(0).getIdMezzoDiProtezioneIndividuale() == 0) {
				theModel.setWidg_chbAttrezzatureScarponiRinforzati(false);
			} else {
				theModel.setWidg_chbAttrezzatureScarponiRinforzati(true);
			}
		}
		if (!theModel.getAppDataelencoPantaloniAntitaglioAttrezzature().isEmpty()) {
			if (theModel.getAppDataelencoPantaloniAntitaglioAttrezzature().size() == 1
					&& theModel.getAppDataelencoPantaloniAntitaglioAttrezzature().get(0)
							.getIdMezzoDiProtezioneIndividuale() == 0) {
				theModel.setWidg_chbAttrezzaturePantaloniAntitaglio(false);
			} else {
				theModel.setWidg_chbAttrezzaturePantaloniAntitaglio(true);
			}
		}
	}

	private void valorizzaCheckBoxForSyrutture(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) {
		if (!theModel.getAppDataelencoCapannoni().isEmpty()) {
			theModel.setWidg_chbStruttureCapannoni(true);
		} else {
			theModel.setWidg_chbStruttureCapannoni(false);
		}

		if (!theModel.getAppDataelencoPiazzaliStoccaggio().isEmpty()) {
			theModel.setWidg_chbStrutturePiazzaliStoccaggio(true);
		} else {
			theModel.setWidg_chbStrutturePiazzaliStoccaggio(false);
		}
	}

	private void valorizzaCampoAltroPerAttivita(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) {
		ArrayList<ArboricolturaDaLegno> arboricolturaList = new ArrayList<ArboricolturaDaLegno>();
		arboricolturaList = theModel.getAppDataelencoArboricolturaDaLegno();
		if (theModel.getWidg_chbAttivitaUltimoAnno5() && theModel.getAppDataattivitaUltimoAnno5() != null) {
			if (!arboricolturaList.isEmpty()) {
				for (ArboricolturaDaLegno arboricolturaDaLegno : arboricolturaList) {
					if (arboricolturaDaLegno.getIdTipoMateriale() == 8
							&& theModel.getAppDataattivitaUltimoAnno5() != null) {
						arboricolturaDaLegno.setAltroVisibile(true);
						theModel.getAppDataattivitaUltimoAnno5().setAltro(arboricolturaDaLegno.getAltro());

					}
				}
			}
			AttivitaUltimoAnno5 attivitaUltimoAnno5 = new AttivitaUltimoAnno5();
			attivitaUltimoAnno5.setAltroVisibile(true);
			theModel.setAppDataattivitaUltimoAnno5(attivitaUltimoAnno5);
		}

		ArrayList<MaterialePropagazione> materialePropagazioneList = new ArrayList<MaterialePropagazione>();
		materialePropagazioneList = theModel.getAppDataelencoMaterialePropagazione();
		if (theModel.getWidg_chbAttivitaUltimoAnno4() && theModel.getAppDataattivitaUltimoAnno4() != null) {
			if (!materialePropagazioneList.isEmpty()) {
				for (MaterialePropagazione materialePropagazione : materialePropagazioneList) {
					if (materialePropagazione.getIdMaterialePropagazione() == 6) {
						materialePropagazione.setAltroVisibile(true);
						if (materialePropagazioneList.get(6).getAltro() != null) {
							materialePropagazione.setAltro(materialePropagazioneList.get(6).getAltro());
						}
						theModel.getAppDataattivitaUltimoAnno4().setAltro(materialePropagazione.getAltro());
					}
				}
			}
		}
		theModel.setAppDataelencoMaterialePropagazione(materialePropagazioneList);
		theModel.setAppDataelencoArboricolturaDaLegno(arboricolturaList);
	}

	private void switchTabAndInit(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) throws Exception {
		log.debug("[CPBECpDomanda::switchTabAndInit] BEGIN");
		log.debug("[TAB] theModel.getSelectedTabValue() *" + theModel.getSelectedTabValue() + "*");
		WizardDomandaStatus d = WizardDomandaStatus.getByName(theModel.getSelectedTabValue());
		switch (d) {
			case WIZARD_VAL_1 :
				this.executeInit1_1(theModel);
				//				theModel.setSelectedTabKey("CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel");
				//				theModel.setSelectedTabValue("CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1");
				break;
			case WIZARD_VAL_2 :
				this.validationMgr.checkAziendaSalvata(theModel.getAppDataidAzienda()); //only per test
				this.executeInit2_1(theModel);
				//				theModel.setSelectedTabKey("CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel");
				//				theModel.setSelectedTabValue("CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1");
				break;
			case WIZARD_VAL_3 :
				this.validationMgr.checkAziendaSalvata(theModel.getAppDataidAzienda());
				this.executeInit3_1(theModel);
				//				theModel.setSelectedTabKey("CpDomanda_wzpDomandaAttivita_selectedMultiPanel");
				//				theModel.setSelectedTabValue(null);
				break;
			case WIZARD_VAL_4 :
				this.validationMgr.checkAziendaSalvata(theModel.getAppDataidAzienda());
				this.executeInit4(theModel);
				break;
			case WIZARD_VAL_5 :
				this.validationMgr.checkAziendaSalvata(theModel.getAppDataidAzienda());
				this.executeInit5_1(theModel);
				//				theModel.setSelectedTabKey("CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel");
				//				theModel.setSelectedTabValue("CpDomanda_wzpDomandaAttrezzatture_fpWizardAttrezzatureSub1");
				break;
			case WIZARD_VAL_6 :
				this.validationMgr.checkAziendaSalvata(theModel.getAppDataidAzienda());
				this.executeInit6(theModel);
				break;
			default :
				this.executeInit1_1(theModel);
				//				theModel.setSelectedTabKey("CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel");
				//				theModel.setSelectedTabValue("CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1");
		}
		log.debug("[CPBECpDomanda::switchTabAndInit] END");
	}

	private void setProfiloUtente(CpDomandaModel theModel, TaifTPersonaProfiloUtenteByCodiceFiscaleDto p) {
		ProfiloUtenteTaif put = theModel.getAppDatacurrentUser().getProfiloUtenteTaif();
		if (put == null) {
			put = new ProfiloUtenteTaif();
		}
		put.setIdProfilo(ConvertUtil.convertToString(p.getIdProfiloUtente()));
		put.setDsProfilo(p.getProfiloUtente());
		put.setIdSoggettoGestore(p.getIdSoggettoGestore());
		put.setIdConfigUtente(p.getIdConfigUtente());

		theModel.getAppDatacurrentUser().setProfiloUtenteTaif(put);

	}

	private void addLegnameGenerico(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel)
			throws DbManagerException, ManagerException {
		VisibileOrdinFilter visibleFilter = this.getVisibileOrdinFilter(theModel);
		// inserire qui la logica applicativa da eseguire:
		//theModel.getAppDataelencoLegnamiAssortimentiTrattati()
		//		.add(this.dummyMgr.addNuovoLegname(theModel.getAppDataelencoLegnamiAssortimentiTrattati()));
		theModel.getAppDataelencoLegnamiAssortimentiTrattati().add(ListUtils.addNuovoLegnameAssortimentoTrattato(
				ListUtils.getMaxRowNumListaLegnami(theModel.getAppDataelencoLegnamiAssortimentiTrattati()) + 1,
				this.taifMgr.getElencoSpecie(visibleFilter), this.taifMgr.getProvenienzaMateriale(visibleFilter),
				this.taifMgr.getElencoAssortimento(visibleFilter), this.taifMgr.getTagliatoAquistatoTALista(),
				this.taifMgr.getElencoUnitaMisura(), this.taifMgr.getDestinazioneMateriale(visibleFilter)));
	}

	private void onClickTabellaElencoLegnameGeneric(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel)
			throws ManagerException {
		log.debug("ID COLONNA ????? " + theModel.getIdColonna());
		log.debug("ID RIGA ????? " + theModel.getIdRiga());

		int rowNum = Integer.parseInt(theModel.getIdRiga());
		String colonna = theModel.getIdColonna();
		List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaOtto = taifMgr
				.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
		for (LegnameAssortimentoTrattato legname : theModel.getAppDataelencoLegnamiAssortimentiTrattati()) {
			if (legname.getRownum() == rowNum) {
				theModel.getAppDataelencoLegnamiAssortimentiTrattati().remove(legname);
				break;
			}
		}

	}

	private Map<String, Boolean> valorizzaAttivitaUltimoAnnoFrancese(CpDomandaModel theModel) {

		List<String> listIdAttivita = theModel.getAppDataidAttivitaUltimoAnnoFr();

		Map<String, Boolean> attivitaMap = new HashMap<String, Boolean>();
		attivitaMap.put(Constants.att10, false);
		attivitaMap.put(Constants.att11, false);
		attivitaMap.put(Constants.att12, false);
		attivitaMap.put(Constants.att13, false);
		attivitaMap.put(Constants.att14, false);
		attivitaMap.put(Constants.att15, false);
		for (String idTipoAtt : listIdAttivita) {
			if (idTipoAtt.equals("10")) {
				attivitaMap.put(Constants.att10, true);
			}
			if (idTipoAtt.equals("11")) {
				attivitaMap.put(Constants.att11, true);
			}
			if (idTipoAtt.equals("12")) {
				attivitaMap.put(Constants.att12, true);
			}
			if (idTipoAtt.equals("13")) {
				attivitaMap.put(Constants.att13, true);
			}
			if (idTipoAtt.equals("14")) {
				attivitaMap.put(Constants.att14, true);
			}
			if (idTipoAtt.equals("15")) {
				attivitaMap.put(Constants.att15, true);
			}
		}

		return attivitaMap;
	}

	private Map<String, Boolean> valorizzaAttivitaMap(CpDomandaModel theModel) {
		Map<String, Boolean> attivitaMap;
		if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			attivitaMap = valorizzaAttivitaUltimoAnno(theModel);
		} else {
			attivitaMap = valorizzaAttivitaUltimoAnnoFrancese(theModel);
		}
		return attivitaMap;
	}

	private Map<String, Boolean> valorizzaMacchinaMezzi(CpDomandaModel theModel) {
		Map<String, Boolean> attivitaMap;
		if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			attivitaMap = valorizzaMacchinaMezziIt(theModel);
		} else {
			attivitaMap = valorizzaMacchinaMezziFrancese(theModel);
		}
		return attivitaMap;
	}

	private Map<String, Boolean> valorizzaMacchinaMezziFrancese(CpDomandaModel theModel) {
		Map<String, Boolean> mezziMap = new HashMap<String, Boolean>();

		mezziMap.put(Constants.checkSpecialiFr, theModel.getWidg_chbAttrezzatureMacchineSpecialiFr());
		mezziMap.put(Constants.checkTerraFr, theModel.getWidg_chbAttrezzatureMacchineMovimentoATerraFr());
		mezziMap.put(Constants.checkRimorchiFr, theModel.getWidg_chbAttrezzatureMacchinaRimorchiFr());
		mezziMap.put(Constants.checkSemi, theModel.getWidg_chbAttrezzatureMacchinaSemi());
		mezziMap.put(Constants.checkGrumier, theModel.getWidg_chbAttrezzatureMacchinaGrumier());
		return mezziMap;
	}

	private void valorizzaCheckBoxForMezziFrancesi(it.csi.taif.taifweb.dto.domanda.CpDomandaModel theModel) {

		if (!theModel.getAppDataelencoMacchineMovimentoTerraFr().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchineMovimentoATerraFr(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchineMovimentoATerraFr(false);
		}
		if (!theModel.getAppDataelencoMacchineRimorchiFr().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchinaRimorchiFr(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchinaRimorchiFr(false);
		}
		if (!theModel.getAppDataelencoMacchineGrumier().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchinaGrumier(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchinaGrumier(false);
		}
		if (!theModel.getAppDataelencoMacchineSemi().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchinaSemi(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchinaSemi(false);
		}

		if (!theModel.getAppDataelencoMacchineSpecialiFr().isEmpty()) {
			theModel.setWidg_chbAttrezzatureMacchineSpecialiFr(true);
		} else {
			theModel.setWidg_chbAttrezzatureMacchineSpecialiFr(false);
		}
	}

	private GestionePersonaleFr getGestionePersonaleFrancese(CpDomandaModel theModel) {
		GestionePersonaleFr result = theModel.getAppDatagestioneAltroPersonaleFr();
		if (result == null) {
			result = new GestionePersonaleFr();
		}
		if (theModel.getAppDatatracciato().equals(it.csi.taif.taifweb.business.dao.util.Constants.fLang)) {
			result.setElencoAltroPersonaleTipoContratto(theModel.getAppDataelencoAltroPersonaleTipoContrattoFr());
			result.setElencoAltroPersonaleTipoMansione(theModel.getAppDataelencoAltroPersonaleTipoMansioneFr());
		}
		return result;
	}

	private void caricaDatiAziendaImportata(ImportAziendaAAEP aziendaImportata, CpDomandaModel theModel)
			throws ManagerException, BEException {

		String idCodiceAttivita = null;
		String idCodiceAttivitaSec = null;
		String nomeFormaGiuridica = null;

		FormaGiuridicaFilter filter = new FormaGiuridicaFilter();
		filter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
		filter.setFlagVisibile(1);

		AnagraficaAziendale aziendaTrovataAeep = aziendaImportata.getAnagraficaAziendale();
		ArrayList<Sede> listSedi = aziendaImportata.getSediOperative();
		aziendaTrovataAeep.setPrivacy(true);

		ArrayList<Sede> altreSedi = new ArrayList<Sede>();

		theModel.setAppDatacodiceFiscale(aziendaTrovataAeep.getCodiceFiscale());
		theModel.setAppDatapartitaIva(aziendaTrovataAeep.getPartitaIva());
		theModel.setAppDataanagraficaAziendale(aziendaTrovataAeep);

		theModel.getAppDataanagraficaAziendale().setIdProvinciaCCIAA(aziendaTrovataAeep.getIdProvinciaCCIAA());
		if (aziendaTrovataAeep.getIdAttivitaPrimaria() != null) {

			String codiceAttivita = aziendaTrovataAeep.getIdAttivitaPrimaria();

			idCodiceAttivita = taifMgr.getCodiceAttivitaApe(codiceAttivita).toString();

			theModel.setAppDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale(idCodiceAttivita);
		}
		if (aziendaTrovataAeep.getIdAttivitaSecondaria() != null) {

			String codiceAttivitaSec = aziendaTrovataAeep.getIdAttivitaSecondaria();

			idCodiceAttivitaSec = taifMgr.getCodiceAttivitaApe(codiceAttivitaSec).toString();

			theModel.setAppDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale(idCodiceAttivitaSec);
		}

		if (aziendaTrovataAeep.getIdFormaGiurdica() != null) {

			filter.setFormaGiuridica(aziendaTrovataAeep.getIdFormaGiurdica());
			theModel.setAppDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale(
					taifMgr.getIdFormaGiuridica(filter).toString());
		}
		//? attivita secondaria
		//theModel.setAppDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale(idCodiceAttivita);

		theModel.getAppDataanagraficaAziendale().setNumeroCCIAA(aziendaTrovataAeep.getNumeroCCIAA());
		if (aziendaTrovataAeep.getTelefono() != null) {
			theModel.getAppDataanagraficaAziendale().setTelefono(aziendaTrovataAeep.getTelefono());
		}
		if (aziendaTrovataAeep.getCellulare() != null) {
			theModel.getAppDataanagraficaAziendale().setCellulare(aziendaTrovataAeep.getCellulare());
		}
		if (aziendaTrovataAeep.getDescrizione() != null) {
			theModel.getAppDataanagraficaAziendale().setDescrizione(aziendaTrovataAeep.getDescrizione());
		}
		if (aziendaTrovataAeep.getIdProvinciaCCIAA() != null) {
			theModel.setAppDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale(
					aziendaTrovataAeep.getIdProvinciaCCIAA());
		}
		if (aziendaTrovataAeep.getIdFormaGiurdica() != null) {
			theModel.getAppDataanagraficaAziendale().setIdFormaGiurdica(aziendaTrovataAeep.getIdFormaGiurdica());
			if (aziendaTrovataAeep.getIdFormaGiurdica().equals(9)
					|| aziendaTrovataAeep.getIdFormaGiurdica().equals(14)) {
				if (aziendaTrovataAeep.getNote() != null) {
					theModel.setAppDatadescrizione(aziendaTrovataAeep.getNote());
				}
			}
		}
		int kk = 0;
		for (Sede sede : listSedi) {
			if (sede.getIdTipoSede() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
				theModel.setAppDatasedeLegaleAnagrafeAziendale(sede);
				if (sede.getIstatComuneSede() != null) {
					theModel.setAppDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale(
							String.valueOf(sede.getIstatComuneSede()));
				}
				if (sede.getIndirizzo() != null) {
					theModel.getAppDatasedeLegaleAnagrafeAziendale().setIndirizzo(sede.getIndirizzo());
				}
				if (sede.getNumeroCivico() != null) {
					theModel.getAppDatasedeLegaleAnagrafeAziendale().setNumeroCivico(sede.getNumeroCivico());
				}
				if (sede.getTelefono() != null) {
					theModel.getAppDatasedeLegaleAnagrafeAziendale().setTelefono(sede.getTelefono());
				}
				if (sede.getCellulare() != null) {
					theModel.getAppDatasedeLegaleAnagrafeAziendale().setCellulare(sede.getCellulare());
				}
				if (sede.getCap() != null) {
					theModel.getAppDatasedeLegaleAnagrafeAziendale().setCap(sede.getCap());
				}

			} else {
				sede.setElencoComuni(this.taifMgr.getElencoComuni());
				sede.setElencoTipoSede(
						taifMgr.getElencoTipoSedeAziendaNoSedeLegale(this.getVisibileOrdinFilter(theModel)));
				altreSedi.add(sede);
			}
		}

		theModel.setAppDataelencoSediDatiAnagraficiAnagrafeAziendale(altreSedi);
		Albo albo = this.taifMgr.getAlboSogettoGestore(1);
		theModel.setAppDataalbo(albo);
		ActionContext.getContext().getSession().put("servizioAaep", Constants.SI);
		//int vv = 0;
		if (altreSedi.isEmpty()) {
			theModel.setWidg_rbsDatiAnagraficiAltreSedi2(Constants.NO);
		} else {

			for (Sede sedeOperativa : altreSedi) {
				theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
						.setIdTipoSede(sedeOperativa.getIdTipoSede());

				if (sedeOperativa.getIdComune() != null) {
					theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
							.setIdComune(sedeOperativa.getIdComune());
				}
				if (sedeOperativa.getIstatComuneSede() != null) {
					theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
							.setIstatComuneSede(sedeOperativa.getIstatComuneSede());
				}
				if (sedeOperativa.getDsComune() != null) {
					theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
							.setDsComune(sedeOperativa.getDsComune());
				}
				if (sedeOperativa.getIndirizzo() != null) {
					theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
							.setIndirizzo(sedeOperativa.getIndirizzo());
				}
				if (sedeOperativa.getNumeroCivico() != null) {
					theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
							.setNumeroCivico(sedeOperativa.getNumeroCivico());
				}

				theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
						.setIdSede(sedeOperativa.getIdSede());
				if (sedeOperativa.getTelefono() != null) {
					theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
							.setTelefono(sedeOperativa.getTelefono());
				}
				if (sedeOperativa.getCellulare() != null) {
					theModel.getAppDataelencoSediDatiAnagraficiAnagrafeAziendale().get(kk)
							.setCellulare(sedeOperativa.getCellulare());
				}
				sedeOperativa.setRownum(kk);
				kk++;
			}

			ActionContext.getContext().getSession().put("CpDomanda_mpDatiAnagraficiSedi_selectedMultiPanel",
					"CpDomanda_mpDatiAnagraficiSedi_fpDatiAnagraficiSedi");
			theModel.setWidg_rbsDatiAnagraficiAltreSedi2(Constants.SI);
			expandAltreSediDatiAnagrafici2(theModel);

		}
	}

	private void inizializeScheda3_1(CpDomandaModel theModel) {

		final String DEFAULT_UNITA_MISURA = "" + Constants.ID_UNITA_MISURA_QUINTALI;

		AttivitaUltimoAnno1 attivitaAnno1 = new AttivitaUltimoAnno1();

		Intervento in = new Intervento();
		in.setTotaleVolumiTagliDiUtilizzazione(Constants.DEFAULT_ZERO);
		in.setIdUnitaMisuraTagliDiUtilizzazione(DEFAULT_UNITA_MISURA);
		in.setPercentualeVolumiTagliDiUtilizzazioneContoTerzi(Constants.DEFAULT_ZERO);
		in.setTotaleVolumiTaglioPioppeti(Constants.DEFAULT_ZERO);
		in.setIdUnitaMisuraTaglioPioppeti(DEFAULT_UNITA_MISURA);
		in.setPercentualeVolumiTaglioPioppetiContoTerzi(Constants.DEFAULT_ZERO);
		in.setTotaleVolumiTagliIntercalari(Constants.DEFAULT_ZERO);
		in.setIdUnitaMisuraTagliIntercalari(DEFAULT_UNITA_MISURA);
		in.setPercentualeVolumiTagliIntercalariContoTerzi(Constants.DEFAULT_ZERO);

		Intervento fuori = new Intervento();
		fuori.setTotaleVolumiTagliDiUtilizzazione(Constants.DEFAULT_ZERO);
		fuori.setIdUnitaMisuraTagliDiUtilizzazione(DEFAULT_UNITA_MISURA);
		fuori.setPercentualeVolumiTagliDiUtilizzazioneContoTerzi(Constants.DEFAULT_ZERO);
		fuori.setTotaleVolumiTaglioPioppeti(Constants.DEFAULT_ZERO);
		fuori.setIdUnitaMisuraTaglioPioppeti(DEFAULT_UNITA_MISURA);
		fuori.setPercentualeVolumiTaglioPioppetiContoTerzi(Constants.DEFAULT_ZERO);
		fuori.setTotaleVolumiTagliIntercalari(Constants.DEFAULT_ZERO);
		fuori.setIdUnitaMisuraTagliIntercalari(DEFAULT_UNITA_MISURA);
		fuori.setPercentualeVolumiTagliIntercalariContoTerzi(Constants.DEFAULT_ZERO);

		attivitaAnno1.setInterventoFuoriRegione(fuori);
		attivitaAnno1.setInterventoInRegione(in);

		theModel.setAppDataattivitaUltimoAnno1(attivitaAnno1);

		theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(DEFAULT_UNITA_MISURA);
		theModel.setAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(DEFAULT_UNITA_MISURA);
		theModel.setAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(DEFAULT_UNITA_MISURA);

		theModel.setAppDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato(DEFAULT_UNITA_MISURA);
		theModel.setAppDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato(DEFAULT_UNITA_MISURA);
		theModel.setAppDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato(DEFAULT_UNITA_MISURA);
	}

	/*PROTECTED REGION END*/
}
