/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager.db;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.UserTransaction;

import org.apache.commons.lang3.Range;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.jta.JtaTransactionManager;

import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifApplSchedaOkDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfAttribAmmessoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfConfigUtenteDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfEstensAmmDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfMailDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfParamActaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfParamApimgrDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfProfiloUtenteDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfTipoAllegatoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifCnfTipoMailDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDAlimentazioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDAmbitoFormativoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDAssociazioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDAssortimentoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDAttivitaAtecoApeDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDCategoriaImpresaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDCategoriaMezzoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDEstensioneFileDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDFormaGiuridicaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDFunzioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDMaterialeDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDNazioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDProvDestinDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDRuoloDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDSpecieDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDStatoOpfoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDStatoPraticaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoAttivitaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoCarrelloDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoCertificazioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoContrattoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoDpiDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoInquadramentoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoLavoroPaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoMansioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoMezzoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoQualificaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoSedeAziendaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoStrutturaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTitoloStudioDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTrazioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDUnitaDiMisuraDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDUnitaFormativaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifRAttivDetMaterialeDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifRAziendaAssociazioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifRAziendaCategImpresaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifRAziendaFrTipoContrDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifRAziendaFrTipoMansDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifROpfoCorsoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifRPersonaAziendaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifRTrazTipoMezzoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTAgenziaFormativaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTAllegatoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTAttivitaSvoltaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTAttivitaSvoltaDettDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTAziendaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTAziendaExtDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTCertificazioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTCommercializzazioneDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTCorsoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTDpiDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTLavoroPaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTMezzoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTPersonaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTPraticaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTQualificaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTRiconoscimentoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTSedeAziendaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTSoggettoGestoreDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTStoricoStatoDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTStrutturaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifVApplSchedaOkRealeDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifVElencoQualificaPersonaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifVElencoRiconoscimentoPersonaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifViewElencoCorsoPersonaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.DaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifApplSchedaOkDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDStatoPraticaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoDpiDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoSedeAziendaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDUnitaDiMisuraDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifRAttivDetMaterialeDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifRPersonaAziendaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifTAttivitaSvoltaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifTAttivitaSvoltaDettDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifTPersonaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AllegatoObbligatorioFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AssortimentoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AttivitaProgressivoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.CategoriaMezzoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.CertificazioneFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloPersona;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ContrattoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoQualificaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.DispositiviFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.FormaGiuridicaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.FunzioneVisibleFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.InquadramentoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.LavoroPaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.MansioneFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.MaterialeFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaAziendaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaSoggettogestoreFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PraticaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ProvenienzaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.RuoloFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SoggettoGestoreFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SpecieFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.StrutturaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaFormativaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaMisuraFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.helper.dto.factory.DettaglioStatoFactory;
import it.csi.taif.taifweb.business.helper.dto.factory.RiepilogoFactory;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.business.manager.message.MsgMgr;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.business.manager.validation.ValidationMgr;
import it.csi.taif.taifweb.dto.allegato.Allegato;
import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.common.LoginInfo;
import it.csi.taif.taifweb.dto.common.ProfiloUtenteTaif;
import it.csi.taif.taifweb.dto.common.UserInfo;
import it.csi.taif.taifweb.dto.domanda.Albo;
import it.csi.taif.taifweb.dto.domanda.AnagraficaAziendale;
import it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno;
import it.csi.taif.taifweb.dto.domanda.AssociazioniECertificazioni;
import it.csi.taif.taifweb.dto.domanda.Attivita;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno1;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno2;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno3;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno4;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno5;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno6;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno7;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno8;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno9;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnnoFr;
import it.csi.taif.taifweb.dto.domanda.Capannone;
import it.csi.taif.taifweb.dto.domanda.CategoriaImpresa;
import it.csi.taif.taifweb.dto.domanda.Certificazione;
import it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr;
import it.csi.taif.taifweb.dto.domanda.DettaglioStato;
import it.csi.taif.taifweb.dto.domanda.Domanda;
import it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa;
import it.csi.taif.taifweb.dto.domanda.FormaOrganizzativa;
import it.csi.taif.taifweb.dto.domanda.GestioneAttivitaUltimoAnno;
import it.csi.taif.taifweb.dto.domanda.GestioneMacchineMezzi;
import it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr;
import it.csi.taif.taifweb.dto.domanda.Intervento;
import it.csi.taif.taifweb.dto.domanda.LavoroPA;
import it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato;
import it.csi.taif.taifweb.dto.domanda.MacchinaMezzo;
import it.csi.taif.taifweb.dto.domanda.MaterialePropagazione;
import it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale;
import it.csi.taif.taifweb.dto.domanda.Personale;
import it.csi.taif.taifweb.dto.domanda.PersonaleFr;
import it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio;
import it.csi.taif.taifweb.dto.domanda.Riepilogo;
import it.csi.taif.taifweb.dto.domanda.Sede;
import it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.exception.ServiceException;
import it.csi.taif.taifweb.exception.ValidationException;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.DateUtil;
import it.csi.taif.taifweb.util.GenericUtil;
import it.csi.taif.taifweb.util.ListUtils;
import it.csi.taif.taifweb.util.StringUtils;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;
import it.doqui.acta.actasrv.dto.acaris.type.common.ObjectIdType;

public class DbMgr {

	private static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	private JtaTransactionManager txManager;

	private ServiceMgr serviceMgr;

	private List<TaifCnfAttribAmmessoByFilterDto> listAttributi;
	private DozerBeanMapper dozerBeanMapper;
	private TaifDMaterialeDao taifDMaterialeDao;
	private TaifDTitoloStudioDao taifDTitoloStudioDao;
	private TaifDTipoAttivitaDao taifDTipoAttivitaDao;
	private TaifTSedeAziendaDao taifTSedeAziendaDao;
	private TaifDSpecieDao taifDSpecieDao;
	private TaifDProvDestinDao taifDProvDestinDao;
	private TaifTCommercializzazioneDao taifTCommercializzazioneDao;
	private TaifDAssortimentoDao taifDAssortimentoDao;
	private TaifDUnitaDiMisuraDao taifDUnitaDiMisuraDao;
	private TaifDFunzioneDao taifDFunzioneDao;
	private TaifTStrutturaDao taifTStrutturaDao;
	private TaifTCorsoDao taifTCorsoDao;
	private TaifTPersonaDao taifTPersonaDao;
	private TaifTQualificaDao taifTQualificaDao;
	private TaifDCategoriaImpresaDao taifDCategoriaImpresaDao;
	private TaifTPraticaDao taifTPraticaDao;
	private TaifTCertificazioneDao taifTCertificazioneDao;
	private TaifDAssociazioneDao taifDAssociazioneDao;
	private TaifTAttivitaSvoltaDao taifTAttivitaSvoltaDao;
	private TaifRAttivDetMaterialeDao taifRAttivDetMaterialeDao;
	private TaifTLavoroPaDao taifTLavoroPaDao;
	private TaifDTipoDpiDao taifDTipoDpiDao;
	private TaifTDpiDao taifTDpiDao;
	private TaifDTipoMezzoDao taifDTipoMezzoDao;
	private TaifDTrazioneDao taifDTrazioneDao;
	private TaifDAlimentazioneDao taifDAlimentazioneDao;
	private TaifTMezzoDao taifTMezzoDao;
	private TaifDTipoCarrelloDao taifDTipoCarrelloDao;
	private TaifDCategoriaMezzoDao taifDCategoriaMezzoDao;
	private TaifCnfAttribAmmessoDao taifCnfAttribAmmessoDao;
	private TaifDRuoloDao taifDRuoloDao;
	private TaifDTipoMansioneDao taifDTipoMansioneDao;
	private TaifDTipoContrattoDao taifDTipoContrattoDao;
	private TaifRPersonaAziendaDao taifRPersonaAziendaDao;
	private TaifDTipoInquadramentoDao taifDTipoInquadramentoDao;
	private TaifDAmbitoFormativoDao taifDAmbitoFormativoDao;
	private TaifDAttivitaAtecoApeDao taifDAttivitaAtecoApeDao;
	private TaifTAziendaDao taifTAziendaDao;
	private TaifTAziendaExtDao taifTAziendaExtDao;
	private TaifDEstensioneFileDao taifDEstensioneFileDao;
	private TaifDFormaGiuridicaDao taifDFormaGiuridicaDao;
	private TaifDNazioneDao taifDNazioneDao;
	private TaifDStatoOpfoDao taifDStatoOpfoDao;
	private TaifDStatoPraticaDao taifDStatoPraticaDao;
	private TaifDTipoCertificazioneDao taifDTipoCertificazioneDao;
	private TaifDTipoLavoroPaDao taifDTipoLavoroPaDao;
	private TaifDTipoQualificaDao taifDTipoQualificaDao;
	private TaifDTipoSedeAziendaDao taifDTipoSedeAziendaDao;
	private TaifDTipoStrutturaDao taifDTipoStrutturaDao;
	private TaifDUnitaDiMisuraDao taifDUnDiMisuraDao;
	private TaifDUnitaFormativaDao taifDUnitaFormativaDao;
	private TaifTAgenziaFormativaDao taifTAgenziaFormativaDao;
	private TaifRAziendaCategImpresaDao taifRAziendaCategImpresaDao;
	private TaifRAziendaAssociazioneDao taifRAziendaAssociazioneDao;
	private TaifApplSchedaOkDao taifApplSchedaOkDao;
	private TaifTStoricoStatoDao taifTStoricoStatoDao;
	private TaifTAttivitaSvoltaDettDao taifTAttivitaSvoltaDettDao;
	private TaifRAziendaFrTipoContrDao taifRAziendaFrTipoContrDao;
	private TaifRAziendaFrTipoMansDao taifRAziendaFrTipoMansDao;
	private TaifCnfConfigUtenteDao taifCnfConfigUtenteDao;
	private TaifTSoggettoGestoreDao taifTSoggettoGestoreDao;
	private TaifCnfProfiloUtenteDao taifCnfProfiloUtenteDao;
	private TaifTAllegatoDao taifTAllegatoDao;
	private TaifCnfTipoAllegatoDao taifCnfTipoAllegatoDao;
	private TaifRTrazTipoMezzoDao taifRTrazTipoMezzoDao;
	private TaifROpfoCorsoDao taifROpfoCorsoDao;
	private TaifCnfEstensAmmDao taifCnfEstensAmmDao;
	private TaifCnfParamApimgrDao taifCnfParamApimgrDao;
	private TaifCnfMailDao taifCnfMailDao;
	private TaifCnfTipoMailDao taifCnfTipoMailDao;
	private TaifViewElencoCorsoPersonaDao taifViewElencoCorsoPersonaDao;
	private TaifCnfParamActaDao taifCnfParamActaDao;
	private TaifTRiconoscimentoDao taifTRiconoscimentoDao;
	private TaifVApplSchedaOkRealeDao taifVApplSchedaOkRealeDao;
	private TaifVElencoQualificaPersonaDao taifVElencoQualificaPersonaDao;
	private TaifVElencoRiconoscimentoPersonaDao taifVElencoRiconoscimentoPersonaDao; 

	public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
		this.dozerBeanMapper.setMappingFiles(Arrays.asList("dozer-mapping.xml", "dozer-two-mapping.xml",
				"dozer-three-mapping.xml", "dozer-four-mapping.xml")); //
	}

	@Autowired
	private ContrattoFilter contrattoFilter;

	@Autowired
	private StatoPraticaFilter statoPraticaFilter;

	@Autowired
	private MansioneFilter mansioneFilter;

	@Autowired
	private InquadramentoFilter inquadramentoFilter;

	@Autowired
	private FunzioneVisibleFilter funzioneVisibleFilter;

	@Autowired
	private AziendaVisibleFilter aziendaVisibleFilter;
	@Autowired
	private ValidationMgr validationMgr;

	/**
	 * @return the serviceMgr
	 */
	public ServiceMgr getServiceMgr() {
		return serviceMgr;
	}

	/**
	 * @param serviceMgr
	 *            the serviceMgr to set
	 */
	public void setServiceMgr(ServiceMgr serviceMgr) {
		this.serviceMgr = serviceMgr;
	}

	private MsgMgr msgMgr;

	public MsgMgr getMsgMgr() {
		return this.msgMgr;
	}

	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public void setFunzioneVisibleFilter(FunzioneVisibleFilter funzioneVisibleFilter) {
		this.funzioneVisibleFilter = funzioneVisibleFilter;
	}

	public void setTaifDMaterialeDao(TaifDMaterialeDao taifDMaterialeDao) {
		this.taifDMaterialeDao = taifDMaterialeDao;
	}

	public void setTaifDTitoloStudioDao(TaifDTitoloStudioDao taifDTitoloStudioDao) {
		this.taifDTitoloStudioDao = taifDTitoloStudioDao;
	}

	public void setTaifTSedeAziendaDao(TaifTSedeAziendaDao taifTSedeAziendaDao) {
		this.taifTSedeAziendaDao = taifTSedeAziendaDao;
	}

	public void setTaifDSpecieDao(TaifDSpecieDao taifDSpecieDao) {
		this.taifDSpecieDao = taifDSpecieDao;
	}

	public void setTaifDProvDestinDao(TaifDProvDestinDao taifDProvDestinDao) {
		this.taifDProvDestinDao = taifDProvDestinDao;
	}

	public void setTaifTCommercializzazioneDao(TaifTCommercializzazioneDao taifTCommercializzazioneDao) {
		this.taifTCommercializzazioneDao = taifTCommercializzazioneDao;
	}

	public void setTaifDAssortimentoDao(TaifDAssortimentoDao taifDAssortimentoDao) {
		this.taifDAssortimentoDao = taifDAssortimentoDao;
	}

	public void setTaifDUnitaDiMisuraDao(TaifDUnitaDiMisuraDao taifDUnitaDiMisuraDao) {
		this.taifDUnitaDiMisuraDao = taifDUnitaDiMisuraDao;
	}

	public void setTaifDFunzioneDao(TaifDFunzioneDao taifDFunzioneDao) {
		this.taifDFunzioneDao = taifDFunzioneDao;
	}

	public void setTaifTStrutturaDao(TaifTStrutturaDao taifTStrutturaDao) {
		this.taifTStrutturaDao = taifTStrutturaDao;
	}

	public void setTaifTCorsoDao(TaifTCorsoDao taifTCorsoDao) {
		this.taifTCorsoDao = taifTCorsoDao;
	}

	public void setTaifTPersonaDao(TaifTPersonaDao taifTPersonaDao) {
		this.taifTPersonaDao = taifTPersonaDao;
	}

	public void setTaifTQualificaDao(TaifTQualificaDao taifTQualificaDao) {
		this.taifTQualificaDao = taifTQualificaDao;
	}

	public void setTaifDCategoriaImpresaDao(TaifDCategoriaImpresaDao taifDCategoriaImpresaDao) {
		this.taifDCategoriaImpresaDao = taifDCategoriaImpresaDao;
	}

	public void setTaifTPraticaDao(TaifTPraticaDao taifTPraticaDao) {
		this.taifTPraticaDao = taifTPraticaDao;
	}

	public void setTaifTCertificazioneDao(TaifTCertificazioneDao taifTCertificazioneDao) {
		this.taifTCertificazioneDao = taifTCertificazioneDao;
	}

	public void setTaifDAssociazioneDao(TaifDAssociazioneDao taifDAssociazioneDao) {
		this.taifDAssociazioneDao = taifDAssociazioneDao;
	}

	public void setTaifTAttivitaSvoltaDao(TaifTAttivitaSvoltaDao taifTAttivitaSvoltaDao) {
		this.taifTAttivitaSvoltaDao = taifTAttivitaSvoltaDao;
	}

	public void setTaifRAttivDetMaterialeDao(TaifRAttivDetMaterialeDao taifRAttivDetMaterialeDao) {
		this.taifRAttivDetMaterialeDao = taifRAttivDetMaterialeDao;
	}

	public void setTaifTLavoroPaDao(TaifTLavoroPaDao taifTLavoroPaDao) {
		this.taifTLavoroPaDao = taifTLavoroPaDao;
	}

	public void setTaifDTipoDpiDao(TaifDTipoDpiDao taifDTipoDpiDao) {
		this.taifDTipoDpiDao = taifDTipoDpiDao;
	}

	public void setTaifTDpiDao(TaifTDpiDao taifTDpiDao) {
		this.taifTDpiDao = taifTDpiDao;
	}

	public void setTaifDTipoMezzoDao(TaifDTipoMezzoDao taifDTipoMezzoDao) {
		this.taifDTipoMezzoDao = taifDTipoMezzoDao;
	}

	public void setTaifDTrazioneDao(TaifDTrazioneDao taifDTrazioneDao) {
		this.taifDTrazioneDao = taifDTrazioneDao;
	}

	public void setTaifDAlimentazioneDao(TaifDAlimentazioneDao taifDAlimentazioneDao) {
		this.taifDAlimentazioneDao = taifDAlimentazioneDao;
	}

	public void setTaifTMezzoDao(TaifTMezzoDao taifTMezzoDao) {
		this.taifTMezzoDao = taifTMezzoDao;
	}

	public void setTaifDTipoCarrelloDao(TaifDTipoCarrelloDao taifDTipoCarrelloDao) {
		this.taifDTipoCarrelloDao = taifDTipoCarrelloDao;
	}

	public void setTaifDCategoriaMezzoDao(TaifDCategoriaMezzoDao taifDCategoriaMezzoDao) {
		this.taifDCategoriaMezzoDao = taifDCategoriaMezzoDao;
	}

	public void setTaifCnfAttribAmmessoDao(TaifCnfAttribAmmessoDao taifCnfAttribAmmessoDao) {
		this.taifCnfAttribAmmessoDao = taifCnfAttribAmmessoDao;
	}

	public void setTaifDRuoloDao(TaifDRuoloDao taifDRuoloDao) {
		this.taifDRuoloDao = taifDRuoloDao;
	}

	public void setTaifDTipoMansioneDao(TaifDTipoMansioneDao taifDTipoMansioneDao) {
		this.taifDTipoMansioneDao = taifDTipoMansioneDao;
	}

	public void setTaifDTipoContrattoDao(TaifDTipoContrattoDao taifDTipoContrattoDao) {
		this.taifDTipoContrattoDao = taifDTipoContrattoDao;
	}

	public void setTaifRPersonaAziendaDao(TaifRPersonaAziendaDao taifRPersonaAziendaDao) {
		this.taifRPersonaAziendaDao = taifRPersonaAziendaDao;
	}

	public void setTaifDTipoInquadramentoDao(TaifDTipoInquadramentoDao taifDTipoInquadramentoDao) {
		this.taifDTipoInquadramentoDao = taifDTipoInquadramentoDao;
	}

	/*
	 * @param taifCnfParamApimgrDao the taifCnfParamApimgrDao to set
	 */
	public void setTaifCnfParamApimgrDao(TaifCnfParamApimgrDao taifCnfParamApimgrDao) {
		this.taifCnfParamApimgrDao = taifCnfParamApimgrDao;
	}

	public TaifCnfParamActaDao getTaifCnfParamActaDao() {
		return taifCnfParamActaDao;
	}

	public void setTaifCnfParamActaDao(TaifCnfParamActaDao taifCnfParamActaDao) {
		this.taifCnfParamActaDao = taifCnfParamActaDao;
	}

	/*
	 * public void setListAttributi(List<TaifCnfAttribAmmessoByFilterDto>
	 * listAttributi) { this.listAttributi = listAttributi; }
	 */

	/*
	 * public void setListAttributi(List<TaifCnfAttribAmmessoByFilterDto>
	 * listAttributi) { this.listAttributi = listAttributi; }
	 */

	public void setAziendaVisibleFilter(AziendaVisibleFilter aziendaVisibleFilter) {
		this.aziendaVisibleFilter = aziendaVisibleFilter;
	}

	public void setTaifCnfProfiloUtenteDao(TaifCnfProfiloUtenteDao taifCnfProfiloUtenteDao) {
		this.taifCnfProfiloUtenteDao = taifCnfProfiloUtenteDao;
	}

	public void setTaifDAmbitoFormativoDao(TaifDAmbitoFormativoDao taifDAmbitoFormativoDao) {
		this.taifDAmbitoFormativoDao = taifDAmbitoFormativoDao;
	}

	public void setListAttributi(List<TaifCnfAttribAmmessoByFilterDto> listAttributi) {
		this.listAttributi = listAttributi;
	}

	public void setTaifDAttivitaAtecoApeDao(TaifDAttivitaAtecoApeDao taifDAttivitaAtecoApeDao) {
		this.taifDAttivitaAtecoApeDao = taifDAttivitaAtecoApeDao;
	}

	public void setTaifDTipoAttivitaDao(TaifDTipoAttivitaDao taifDTipoAttivitaDao) {
		this.taifDTipoAttivitaDao = taifDTipoAttivitaDao;
	}

	/*
	 * public void setListAttributi(List<TaifCnfAttribAmmessoByFilterDto>
	 * listAttributi) { this.listAttributi = listAttributi; }
	 */

	public void setTaifTAziendaDao(TaifTAziendaDao taifTAziendaDao) {
		this.taifTAziendaDao = taifTAziendaDao;
	}

	public void setTaifDEstensioneFileDao(TaifDEstensioneFileDao taifDEstensioneFileDao) {
		this.taifDEstensioneFileDao = taifDEstensioneFileDao;
	}

	public void setTaifDFormaGiuridicaDao(TaifDFormaGiuridicaDao taifDFormaGiuridicaDao) {
		this.taifDFormaGiuridicaDao = taifDFormaGiuridicaDao;
	}

	public void setTaifDNazioneDao(TaifDNazioneDao taifDNazioneDao) {
		this.taifDNazioneDao = taifDNazioneDao;
	}

	public void setTaifDStatoOpfoDao(TaifDStatoOpfoDao taifDStatoOpfoDao) {
		this.taifDStatoOpfoDao = taifDStatoOpfoDao;
	}

	public void setTaifDStatoPraticaDao(TaifDStatoPraticaDao taifDStatoPraticaDao) {
		this.taifDStatoPraticaDao = taifDStatoPraticaDao;
	}

	public void setTaifDTipoCertificazioneDao(TaifDTipoCertificazioneDao taifDTipoCertificazioneDao) {
		this.taifDTipoCertificazioneDao = taifDTipoCertificazioneDao;
	}

	public void setTaifDTipoLavoroPaDao(TaifDTipoLavoroPaDao taifDTipoLavoroPaDao) {
		this.taifDTipoLavoroPaDao = taifDTipoLavoroPaDao;
	}

	public void setTaifDTipoQualificaDao(TaifDTipoQualificaDao taifDTipoQualificaDao) {
		this.taifDTipoQualificaDao = taifDTipoQualificaDao;
	}

	public void setTaifDTipoSedeAziendaDao(TaifDTipoSedeAziendaDao taifDTipoSedeAziendaDao) {
		this.taifDTipoSedeAziendaDao = taifDTipoSedeAziendaDao;
	}

	public void setTaifDTipoStrutturaDao(TaifDTipoStrutturaDao taifDTipoStrutturaDao) {
		this.taifDTipoStrutturaDao = taifDTipoStrutturaDao;
	}

	public void setTaifDUnDiMisuraDao(TaifDUnitaDiMisuraDao taifDUnDiMisuraDao) {
		this.taifDUnDiMisuraDao = taifDUnDiMisuraDao;
	}

	public void setTaifDUnitaFormativaDao(TaifDUnitaFormativaDao taifDUnitaFormativaDao) {
		this.taifDUnitaFormativaDao = taifDUnitaFormativaDao;
	}

	public void setTaifTAgenziaFormativaDao(TaifTAgenziaFormativaDao taifTAgenziaFormativaDao) {
		this.taifTAgenziaFormativaDao = taifTAgenziaFormativaDao;
	}

	public void setTaifRAziendaCategoriaImpresaDao(TaifRAziendaCategImpresaDao taifRAziendaCategImpresaDao) {
		this.taifRAziendaCategImpresaDao = taifRAziendaCategImpresaDao;
	}

	public void setTaifRAziendaAssociazioneDao(TaifRAziendaAssociazioneDao taifRAziendaAssociazioneDao) {
		this.taifRAziendaAssociazioneDao = taifRAziendaAssociazioneDao;
	}

	public void setTaifApplSchedaOkDao(TaifApplSchedaOkDao taifApplSchedaOkDao) {
		this.taifApplSchedaOkDao = taifApplSchedaOkDao;
	}

	public void setTaifTStoricoStatoDao(TaifTStoricoStatoDao taifTStoricoStatoDao) {
		this.taifTStoricoStatoDao = taifTStoricoStatoDao;
	}

	public void setTaifTAttivitaSvoltaDettDao(TaifTAttivitaSvoltaDettDao taifTAttivitaSvoltaDettDao) {
		this.taifTAttivitaSvoltaDettDao = taifTAttivitaSvoltaDettDao;
	}

	public void setTaifRAziendaFrTipoContrDao(TaifRAziendaFrTipoContrDao taifRAziendaFrTipoContrDao) {
		this.taifRAziendaFrTipoContrDao = taifRAziendaFrTipoContrDao;
	}

	public void setTaifRAziendaFrTipoMansDao(TaifRAziendaFrTipoMansDao taifRAziendaFrTipoMansDao) {
		this.taifRAziendaFrTipoMansDao = taifRAziendaFrTipoMansDao;
	}

	public void setTaifTSoggettoGestoreDao(TaifTSoggettoGestoreDao taifTSoggettoGestoreDao) {
		this.taifTSoggettoGestoreDao = taifTSoggettoGestoreDao;
	}

	public void setTaifCnfConfigUtenteDao(TaifCnfConfigUtenteDao taifCnfConfigUtenteDao) {
		this.taifCnfConfigUtenteDao = taifCnfConfigUtenteDao;
	}

	public void setTaifRAziendaCategImpresaDao(TaifRAziendaCategImpresaDao taifRAziendaCategImpresaDao) {
		this.taifRAziendaCategImpresaDao = taifRAziendaCategImpresaDao;
	}

	public void setTaifTAllegatoDao(TaifTAllegatoDao taifTAllegatoDao) {
		this.taifTAllegatoDao = taifTAllegatoDao;
	}

	public void setTaifCnfTipoAllegatoDao(TaifCnfTipoAllegatoDao taifCnfTipoAllegatoDao) {
		this.taifCnfTipoAllegatoDao = taifCnfTipoAllegatoDao;
	}

	public void setTaifRTrazTipoMezzoDao(TaifRTrazTipoMezzoDao taifRTrazTipoMezzoDao) {
		this.taifRTrazTipoMezzoDao = taifRTrazTipoMezzoDao;
	}

	public void setTaifROpfoCorsoDao(TaifROpfoCorsoDao taifROpfoCorsoDao) {
		this.taifROpfoCorsoDao = taifROpfoCorsoDao;
	}

	public void setContrattoFilter(ContrattoFilter contrattoFilter) {
		this.contrattoFilter = contrattoFilter;
	}

	public void setStatoPraticaFilter(StatoPraticaFilter statoPraticaFilter) {
		this.statoPraticaFilter = statoPraticaFilter;
	}

	public void setMansioneFilter(MansioneFilter mansioneFilter) {
		this.mansioneFilter = mansioneFilter;
	}

	public void setInquadramentoFilter(InquadramentoFilter inquadramentoFilter) {
		this.inquadramentoFilter = inquadramentoFilter;
	}

	public JtaTransactionManager getTxManager() {
		return txManager;
	}

	public void setTxManager(JtaTransactionManager txManager) {
		this.txManager = txManager;
	}

	/**
	 * @return the taifTAziendaExtDao
	 */
	public TaifTAziendaExtDao getTaifTAziendaExtDao() {
		return taifTAziendaExtDao;
	}

	/**
	 * @param taifTAziendaExtDao
	 *            the taifTAziendaExtDao to set
	 */
	public void setTaifTAziendaExtDao(TaifTAziendaExtDao taifTAziendaExtDao) {
		this.taifTAziendaExtDao = taifTAziendaExtDao;
	}

	/**
	 * @param taifCnfEstensAmmDao
	 *            the taifCnfEstensAmmDao to set
	 */
	public void setTaifCnfEstensAmmDao(TaifCnfEstensAmmDao taifCnfEstensAmmDao) {
		this.taifCnfEstensAmmDao = taifCnfEstensAmmDao;
	}

	public void setTaifViewElencoCorsoPersonaDao(TaifViewElencoCorsoPersonaDao taifViewElencoCorsoPersonaDao) {
		this.taifViewElencoCorsoPersonaDao = taifViewElencoCorsoPersonaDao;
	}
	
	

	/**
	 * @param taifVElencoQualificaPersonaDao the taifVElencoQualificaPersonaDao to set
	 */
	public void setTaifVElencoQualificaPersonaDao(TaifVElencoQualificaPersonaDao taifVElencoQualificaPersonaDao) {
		this.taifVElencoQualificaPersonaDao = taifVElencoQualificaPersonaDao;
	}

	/**
	 * @param taifVElencoRiconoscimentoPersonaDao the taifVElencoRiconoscimentoPersonaDao to set
	 */
	public void setTaifVElencoRiconoscimentoPersonaDao(
			TaifVElencoRiconoscimentoPersonaDao taifVElencoRiconoscimentoPersonaDao) {
		this.taifVElencoRiconoscimentoPersonaDao = taifVElencoRiconoscimentoPersonaDao;
	}

	// String nazione;
	int idConfigUtente;

	TaifRAziendaFrTipoMansDto aziendaFrTipoMansDto;
	TaifRAziendaFrTipoContrDto aziendaFrTipoContrDto;

	/**
	 * @param taifCnfMailDao
	 *            the taifCnfMailDao to set
	 */
	public void setTaifCnfMailDao(TaifCnfMailDao taifCnfMailDao) {
		this.taifCnfMailDao = taifCnfMailDao;
	}

	/**
	 * @param taifCnfTipoMailDao
	 *            the taifCnfTipoMailDao to set
	 */
	public void setTaifCnfTipoMailDao(TaifCnfTipoMailDao taifCnfTipoMailDao) {
		this.taifCnfTipoMailDao = taifCnfTipoMailDao;
	}

	/**
	 * @return the taifTRiconoscimentoDao
	 */
	public TaifTRiconoscimentoDao getTaifTRiconoscimentoDao() {
		return taifTRiconoscimentoDao;
	}

	/**
	 * @param taifTRiconoscimentoDao
	 *            the taifTRiconoscimentoDao to set
	 */
	public void setTaifTRiconoscimentoDao(TaifTRiconoscimentoDao taifTRiconoscimentoDao) {
		this.taifTRiconoscimentoDao = taifTRiconoscimentoDao;
	}

	/**
	 * @return the taifVApplSchedaOkRealeDao
	 */
	public TaifVApplSchedaOkRealeDao getTaifVApplSchedaOkRealeDao() {
		return taifVApplSchedaOkRealeDao;
	}

	/**
	 * @param taifVApplSchedaOkRealeDao
	 *            the taifVApplSchedaOkRealeDao to set
	 */
	public void setTaifVApplSchedaOkRealeDao(TaifVApplSchedaOkRealeDao taifVApplSchedaOkRealeDao) {
		this.taifVApplSchedaOkRealeDao = taifVApplSchedaOkRealeDao;
	}

	/*
	 * INIZIO METODI DI BUSINESS
	 *
	 */
	public ArrayList<CodeDescription> getElencoMateriali(MaterialeFilter visibile) throws DbManagerException {
		log.debug("[DbMgr::getElencoMateriali] BEGIN");
		try {
			ArrayList<CodeDescription> destList = new ArrayList<CodeDescription>();
			List<TaifDMaterialeByVisibleOrdinDto> list = taifDMaterialeDao.findByVisibleOrdin(visibile);
			for (TaifDMaterialeByVisibleOrdinDto taifDMaterialeDto : list) {
				CodeDescription result = dozerBeanMapper.map(taifDMaterialeDto, CodeDescription.class);
				destList.add(result);
			}
			return destList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoMateriali] END");
		}
	}

	// getElencoTitoliDiStudio : TaifDTitoloStudioDto

	public ArrayList<CodeDescription> getElencoTitoliDiStudio(VisibileOrdinFilter visibileFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoTitoliDiStudio] BEGIN");
		try {
			ArrayList<CodeDescription> destList = new ArrayList<CodeDescription>();
			List<TaifDTitoloStudioByFilterDto> list = taifDTitoloStudioDao.findByFilter(visibileFilter);
			for (TaifDTitoloStudioByFilterDto taifDTitoloStudioDto : list) {
				CodeDescription result = dozerBeanMapper.map(taifDTitoloStudioDto, CodeDescription.class);
				destList.add(result);
			}
			return destList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTitoliDiStudio] END");
		}
	}

	// getElencoStati() :
	public ArrayList<Sede> getSedeLegale(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getSedeLegale] BEGIN");
		try {
			ArrayList<Sede> sedeLegale = new ArrayList<Sede>();
			List<TaifTSedeAziendaByIdAziendaDto> sedeList = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
			for (TaifTSedeAziendaByIdAziendaDto sedeLeg : sedeList) {
				Sede sede = dozerBeanMapper.map(sedeLeg, Sede.class);
				sedeLegale.add(sede);
			}
			return sedeLegale;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getSedeLegale] END");
		}
	}

	public ArrayList<Sede> getElencoSedi(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getElencoSedi] BEGIN");
		try {
			ArrayList<Sede> sedeLegale = new ArrayList<Sede>();
			List<TaifTSedeAziendaByIdAziendaDto> sedeList = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
			for (TaifTSedeAziendaByIdAziendaDto sedeLeg : sedeList) {
				Sede sede = dozerBeanMapper.map(sedeLeg, Sede.class);
				sedeLegale.add(sede);
			}
			return sedeLegale;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoSedi] END");
		}
	}

	public ArrayList<CodeDescription> getCorsiSostenutiTitolare(CorsoQualificaFilter corsoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getCorsiSostenuti] BEGIN");
		try {
			ArrayList<CodeDescription> corsiList = new ArrayList<CodeDescription>();

			List<TaifTCorsoFindCorsiElencoOperatoriDto> corsoList = taifTCorsoDao
					.findFindCorsiElencoOperatori(corsoFilter);
			for (TaifTCorsoFindCorsiElencoOperatoriDto corso : corsoList) {
				corsiList.add(dozerBeanMapper.map(corso, CodeDescription.class));
			}

			return corsiList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCorsiSostenuti] END");
		}
	}
	
	public ArrayList<CodeDescription> getCorsiSostenutiFromUnitaFormativa(CorsoQualificaFilter corsoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getCorsiSostenuti] BEGIN");

		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		try {
			List<TaifTCorsoByFilterDto> list = taifTCorsoDao
					.findByFilter(corsoFilter);
			List<TaifTCorsoByFilterDto> listPSR =  new ArrayList<TaifTCorsoByFilterDto>();
			List<TaifTCorsoByFilterDto> listFuoriPSR =  new ArrayList<TaifTCorsoByFilterDto>();

			for (TaifTCorsoByFilterDto dto : list) {
				
				if(StringUtils.isNotEmpty(dto.getUSigla())){
					listPSR.add(dto);
				} else {
					listFuoriPSR.add(dto);
				}

			}
			Collections.sort(listPSR, new Comparator<TaifTCorsoByFilterDto>() {
				public int compare(TaifTCorsoByFilterDto a, TaifTCorsoByFilterDto b) {
			        return a.getUSigla().compareToIgnoreCase(b.getUSigla());
			    }
			});

			for (TaifTCorsoByFilterDto dto : listPSR) {
				CodeDescription cd = new CodeDescription();
				cd.setCode(ConvertUtil.convertToString(dto.getIdCorso()));
				StringBuilder desc = new StringBuilder();
				if (StringUtils.isNotEmpty(dto.getUSigla()))
					;
				{
					desc.append(dto.getUSigla());
					desc.append(" - ");
				}
				if (StringUtils.isNotEmpty(dto.getUUnitaFormativa())) {
					desc.append(dto.getUUnitaFormativa());
				}
				cd.setDescription(desc.toString());
				result.add(cd);
			}
			
			for (TaifTCorsoByFilterDto dto : listFuoriPSR) {
				if (StringUtils.isEmpty(dto.getUSigla()))
				{
					log.debug("[DbMgr::getCorsiSostenuti] SIGLA: " + dto.getUSigla());
					log.info("[DbMgr::getCorsiSostenuti] SIGLA: " + dto.getUSigla());

					CodeDescription cd = new CodeDescription();
					cd.setCode(ConvertUtil.convertToString(dto.getIdCorso()));
					StringBuilder desc = new StringBuilder();
					
						desc.append(" - ");
					
					if (StringUtils.isNotEmpty(dto.getUUnitaFormativa())) {
						desc.append(dto.getUUnitaFormativa());
					}
					cd.setDescription(desc.toString());
					result.add(cd);
				}
			}
			return result;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCorsiSostenuti] END");
		}
	}


	//
	public ArrayList<CodeDescription> getQualificheTitolare(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::getQualificheTitolare] BEGIN");
		try {
			ArrayList<CodeDescription> corsiList = new ArrayList<CodeDescription>();
			List<TaifTQualificaByPersonaDto> qualificaList = taifTQualificaDao.findByPersona(idPersona);
			for (TaifTQualificaByPersonaDto taifTPersonaDto : qualificaList) {
				CodeDescription result = dozerBeanMapper.map(taifTPersonaDto, CodeDescription.class);
				corsiList.add(result);
			}
			return corsiList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getQualificheTitolare] END");
		}
	}

	public ArrayList<CodeDescription> getAltriCorsiSostenutiTitolare(CorsoQualificaFilter corsoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getCorsiSostenuti] BEGIN");
		try {
			ArrayList<CodeDescription> corsiList = new ArrayList<CodeDescription>();
			List<TaifTQualificaFindQualificaElencoOperatoriDto> qualificaList = taifTQualificaDao
					.findFindQualificaElencoOperatori(corsoFilter);
			for (TaifTQualificaFindQualificaElencoOperatoriDto taifTCorsoDto : qualificaList) {
				corsiList.add(dozerBeanMapper.map(taifTCorsoDto, CodeDescription.class));
			}
			return corsiList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCorsiSostenuti] END");
		}
	}

	public ArrayList<CodeDescription> getAltreQualificheTitolare(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::getQualificheTitolare] BEGIN");
		try {
			ArrayList<CodeDescription> corsiList = new ArrayList<CodeDescription>();
			List<TaifTQualificaByPersonaDto> qualificaList = taifTQualificaDao.findByPersona(idPersona);
			for (TaifTQualificaByPersonaDto taifTPersonaDto : qualificaList) {
				CodeDescription result = dozerBeanMapper.map(taifTPersonaDto, CodeDescription.class);
				corsiList.add(result);
			}
			return corsiList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getQualificheTitolare] END");
		}
	}

	public ArrayList<CategoriaImpresa> getElencoCategorieImpresa(VisibileOrdinFilter impresaFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoCategorieImpresa] BEGIN");
		try {
			ArrayList<CategoriaImpresa> elencoCatImp = new ArrayList<CategoriaImpresa>();
			List<TaifDCategoriaImpresaCategoriaImpresaVisibleDto> impreseList = taifDCategoriaImpresaDao
					.findCategoriaImpresaVisible(impresaFilter);
			int rownum = 0;
			for (TaifDCategoriaImpresaCategoriaImpresaVisibleDto categoriaDto : impreseList) {

				CategoriaImpresa obj = dozerBeanMapper.map(categoriaDto, CategoriaImpresa.class);
				// FIXME
				// Da Verificare se gestire l'id schianato nel codice o gestirlo con un
				// campo sul db

				boolean altroVisibile = false;
				if (categoriaDto.getId() == 5 || categoriaDto.getId() == 10) {
					altroVisibile = true;
				}

				// obj.setAltroVisibile(categoriaDto.getId()==5);
				obj.setAltroVisibile(altroVisibile);
				obj.setRownum(rownum);
				rownum++;
				elencoCatImp.add(obj);
			}

			return elencoCatImp;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCategorieImpresa] END");
		}
	}

	public ArrayList<Albo> getElencoAltriAlbi(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getElencoAltriAlbi] BEGIN");
		try {
			ArrayList<Albo> elencoAlbi = new ArrayList<Albo>();
			List<TaifTPraticaByIdAziendaAlboDto> praticaList = taifTPraticaDao.findByIdAziendaAlbo(idAzienda);
			for (TaifTPraticaByIdAziendaAlboDto praticaDto : praticaList) {
				if (praticaDto.getIdSoggettoGestione() == 0) {
					elencoAlbi.add(dozerBeanMapper.map(praticaDto, Albo.class));
				}
			}
			return elencoAlbi;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAltriAlbi] END");
		}
	}

	public ArrayList<TaifTPraticaByIdAziendaAlboDto> getElencoAltriAlbiBeToFe(ArrayList<Albo> albiList)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoAltriAlbiBeToFe] BEGIN");
		ArrayList<TaifTPraticaByIdAziendaAlboDto> backPraticaList = new ArrayList<TaifTPraticaByIdAziendaAlboDto>();
		try {
			for (Albo alboDto : albiList) {
				backPraticaList.add(dozerBeanMapper.map(alboDto, TaifTPraticaByIdAziendaAlboDto.class));
			}
			return backPraticaList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAltriAlbiBeToFe] END");
		}
	}

	public ArrayList<Certificazione> getElencoCertificazioni() throws DbManagerException {
		log.debug("[DbMgr::getElencoCertificazioni] BEGIN");
		try {
			ArrayList<Certificazione> certificazioneList = new ArrayList<Certificazione>();
			List<TaifTCertificazioneElencoCertificazioniDto> certList = taifTCertificazioneDao
					.findElencoCertificazioni(null);
			for (TaifTCertificazioneElencoCertificazioniDto certificazioneDto : certList) {
				certificazioneList.add(dozerBeanMapper.map(certificazioneDto, Certificazione.class));
			}
			return certificazioneList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCertificazioni] END");
		}
	}
	//

	public ArrayList<Certificazione> getElencoCertificazioniforAzienda(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getElencoCertificazioniforAzienda] BEGIN");
		try {
			ArrayList<Certificazione> certificazioneList = new ArrayList<Certificazione>();
			List<TaifTCertificazioneByAziendaDto> certList = taifTCertificazioneDao.findByAzienda(idAzienda);
			for (TaifTCertificazioneByAziendaDto certificazioneDto : certList) {
				certificazioneList.add(dozerBeanMapper.map(certificazioneDto, Certificazione.class));
			}
			return certificazioneList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCertificazioniforAzienda] END");
		}
	}

	public ArrayList<TaifTCertificazioneByAziendaDto> getElencoCertificazioniforAziendaFeToBe(
			ArrayList<Certificazione> certificazioni) throws DbManagerException {
		log.debug("[DbMgr::getElencoCertificazioniforAziendaFeToBe] BEGIN");
		try {
			ArrayList<TaifTCertificazioneByAziendaDto> backCertificazioneList = new ArrayList<TaifTCertificazioneByAziendaDto>();
			for (Certificazione certificazioneDto : certificazioni) {
				backCertificazioneList
						.add(dozerBeanMapper.map(certificazioneDto, TaifTCertificazioneByAziendaDto.class));
			}
			return backCertificazioneList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCertificazioniforAziendaFeToBe] END");
		}
	}

	public ArrayList<TaifTCertificazioneElencoCertificazioniDto> getElencoCertificazioniFeToBe(
			ArrayList<Certificazione> certificazioniList) throws DbManagerException {
		log.debug("[DbMgr::getElencoCertificazioni] BEGIN");
		try {
			ArrayList<TaifTCertificazioneElencoCertificazioniDto> backCertificazioneList = new ArrayList<TaifTCertificazioneElencoCertificazioniDto>();
			for (Certificazione certificazione : certificazioniList) {
				if (certificazione.getAnnoRilascio() instanceof String) {
					BigDecimal annoBig = new BigDecimal(certificazione.getAnnoRilascio());
				}
				backCertificazioneList
						.add(dozerBeanMapper.map(certificazione, TaifTCertificazioneElencoCertificazioniDto.class));
			}
			return backCertificazioneList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCertificazioni] END");
		}
	}

	//
	public ArrayList<FormaOrganizzativa> getElencoFormeOrganizzative(VisibileOrdinFilter orgFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoFormeOrganizzative] BEGIN");
		try {
			ArrayList<FormaOrganizzativa> formeList = new ArrayList<FormaOrganizzativa>();
			List<TaifDAssociazioneByVisibleOrdinDto> associazioneList = taifDAssociazioneDao
					.findByVisibleOrdin(orgFilter);
			int rownum = 0;
			for (TaifDAssociazioneByVisibleOrdinDto associazioneDto : associazioneList) {
				// FIXME
				FormaOrganizzativa obj = dozerBeanMapper.map(associazioneDto, FormaOrganizzativa.class);
				// Da Verificare se gestire l'id schianato nel codice o gestirlo con un
				// campo sul db

				boolean altroVisible = false;
				int id = associazioneDto.getId();

				Range<Integer> ita = Range.between(5, 7);
				Range<Integer> fra = Range.between(12, 14);

				if (ita.contains(id) || fra.contains(id)) {
					altroVisible = true;
				}
				obj.setAltroVisibile(altroVisible);
				obj.setRownum(rownum);
				rownum++;
				formeList.add(obj);
			}
			return formeList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormeOrganizzative] END");
		}
	}

	public ArrayList<TaifDAssociazioneByVisibleOrdinDto> getElencoFormeOrganizzativeFeToBe(
			ArrayList<FormaOrganizzativa> formeOrganizzative) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormeOrganizzative] BEGIN");
		try {
			ArrayList<TaifDAssociazioneByVisibleOrdinDto> associazioneList = new ArrayList<TaifDAssociazioneByVisibleOrdinDto>();
			for (FormaOrganizzativa forme : formeOrganizzative) {

				associazioneList.add(dozerBeanMapper.map(forme, TaifDAssociazioneByVisibleOrdinDto.class));
			}
			return associazioneList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormeOrganizzative] END");
		}
	}

	public ArrayList<Attivita> getElencoAttivitaUltimoAnno(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getElencoAttivitaUltimoAnno] BEGIN");
		try {
			ArrayList<Attivita> feAttivitaList = new ArrayList<Attivita>();
			List<TaifTAttivitaSvoltaByIdAziendaDto> certList = taifTAttivitaSvoltaDao.findByIdAzienda(idAzienda);
			for (TaifTAttivitaSvoltaByIdAziendaDto tipoAttivitaDto : certList) {
				feAttivitaList.add(dozerBeanMapper.map(tipoAttivitaDto, Attivita.class));
			}
			return feAttivitaList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAttivitaUltimoAnno] END");
		}
	}

	public ArrayList<MaterialePropagazione> getElencoMaterialiPropagazione(MaterialeFilter ordinFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoMaterialiPropagazione] BEGIN");
		try {
			ArrayList<MaterialePropagazione> feAttivitaList = new ArrayList<MaterialePropagazione>();
			List<TaifDMaterialeByVisibleOrdinDto> certList = taifDMaterialeDao.findByVisibleOrdin(ordinFilter);
			for (TaifDMaterialeByVisibleOrdinDto propagazioneDto : certList) {
				MaterialePropagazione dto = dozerBeanMapper.map(propagazioneDto, MaterialePropagazione.class);
				log.info("[DbMgr::getElencoMaterialiPropagazione] propagazioneDto.getId(): " + propagazioneDto.getId());
				if (propagazioneDto.getId() == 6) {
					log.info("[DbMgr::getElencoMaterialiPropagazione] è entrato in propagazioneDto.getId() == " + propagazioneDto.getId());

					dto.setAltroVisibile(true);
				}
				feAttivitaList.add(dto);

			}
			return feAttivitaList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoMaterialiPropagazione] END");
		}
	}

	public ArrayList<ArboricolturaDaLegno> getElencoArboricolturaDaLegno(Integer idAttivita) throws DbManagerException {
		log.debug("[DbMgr::getElencoArboricolturaDaLegno] BEGIN");
		try {
			ArrayList<ArboricolturaDaLegno> feAttivitaList = new ArrayList<ArboricolturaDaLegno>();
			List<TaifRAttivDetMaterialeByIdAttivitaDto> certList = taifRAttivDetMaterialeDao
					.findByIdAttivita(idAttivita);
			for (TaifRAttivDetMaterialeByIdAttivitaDto materialeDto : certList) {
				feAttivitaList.add(dozerBeanMapper.map(materialeDto, ArboricolturaDaLegno.class));
			}
			return feAttivitaList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoArboricolturaDaLegno] END");
		}
	}

	public ArrayList<LavoroPA> getElencoLavoriPA(VisibileOrdinFilter visibileOrdinFilter) throws DbManagerException {
		log.debug("[DbMgr::getElencoLavoriPA] BEGIN");
		try {
			ArrayList<LavoroPA> feAttivitaList = new ArrayList<LavoroPA>();
			List<TaifTLavoroPaByFilterDto> certList = taifTLavoroPaDao.findByFilter(visibileOrdinFilter);
			for (TaifTLavoroPaByFilterDto lavoroDto : certList) {
				feAttivitaList.add(dozerBeanMapper.map(lavoroDto, LavoroPA.class));
			}
			return feAttivitaList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoLavoriPA] END");
		}
	}

	public ArrayList<LavoroPA> getElencoLavoriPAByAzienda(LavoroPaFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoLavoriPA] BEGIN");
		try {
			ArrayList<LavoroPA> feAttivitaList = new ArrayList<LavoroPA>();
			List<TaifTLavoroPaByAziendaDto> certList = taifTLavoroPaDao.findByAzienda(filter);
			for (TaifTLavoroPaByAziendaDto lavoroDto : certList) {
				feAttivitaList.add(dozerBeanMapper.map(lavoroDto, LavoroPA.class));
			}
			return feAttivitaList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoLavoriPA] END");
		}
	}

	public List<TaifTLavoroPaDto> getElencoLavoriPAFeToBe(ArrayList<LavoroPA> feAttivitaList)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoLavoriPA] BEGIN");
		try {
			List<TaifTLavoroPaDto> backLavoroPaList = new ArrayList<TaifTLavoroPaDto>();
			for (LavoroPA feLavoroPa : feAttivitaList) {
				backLavoroPaList.add(dozerBeanMapper.map(feLavoroPa, TaifTLavoroPaDto.class));
			}
			return backLavoroPaList;
		} finally {
			log.debug("[DbMgr::getElencoLavoriPA] END");
		}
	}

	public ArrayList<LegnameAssortimentoTrattato> getElencoLegnami(VisibileOrdinFilter ordinFilter, int idAzienda)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoLegnami] BEGIN");
		try {

			ArrayList<BeLegnameAssortimentoTrattatoDto> listLegname = new ArrayList<BeLegnameAssortimentoTrattatoDto>();
			ArrayList<LegnameAssortimentoTrattato> listFeLegname = new ArrayList<LegnameAssortimentoTrattato>();

			List<TaifTCommercializzazioneByAziendaDto> listCommercializzazione = new ArrayList<TaifTCommercializzazioneByAziendaDto>();
			listCommercializzazione = taifTCommercializzazioneDao.findByAzienda(idAzienda);

			for (TaifTCommercializzazioneByAziendaDto taifTComm : listCommercializzazione) {

				BeLegnameAssortimentoTrattatoDto beLegname = new BeLegnameAssortimentoTrattatoDto();

				beLegname.setIdLegname(taifTComm.getId());

				beLegname.setIdSpecie(taifTComm.getIdSpecie());
				beLegname.setDescrizioneSpecie(
						taifDSpecieDao.findByPrimaryKey(new TaifDSpeciePk(taifTComm.getIdSpecie())).getNomeSpecie());

				beLegname.setListSpecie(taifDSpecieDao.findByFilter(ordinFilter));

				beLegname.setIdProvenienza(taifTComm.getIdProvenienza());
				beLegname.setDescrizioneProvenienza(taifDProvDestinDao
						.findByPrimaryKey(new TaifDProvDestinPk(taifTComm.getIdAssortimento())).getProvDestin());
				beLegname.setListProvenienza(this.getProvenienzaMateriale(ordinFilter));

				beLegname.setIdAssortimento(taifTComm.getIdAssortimento());
				beLegname.setDescrizioneAssortimento(taifDAssortimentoDao
						.findByPrimaryKey(new TaifDAssortimentoPk(taifTComm.getIdAssortimento())).getAssortimento());
				beLegname.setListAssortimento(this.getAssortimento(ordinFilter));

				beLegname.setFlagTagliatoAcquistato(taifTComm.getFlgTagliato());
				beLegname.setVendutoAnno(taifTComm.getVendutoMedio().toString());

				beLegname.setIdUnitaMisura(taifTComm.getIdUnMis());
				beLegname.setDescrizioneUnitaMisura(taifDUnitaDiMisuraDao
						.findByPrimaryKey(new TaifDUnitaDiMisuraPk(taifTComm.getIdUnMis())).getUnitaDiMisura());
				// beLegname.setListUnitaMisura(this.getUnitaMisura(ordinFilter.getFlagVisibile()));
				beLegname.setNote(taifTComm.getNote());

				beLegname.setIdDestinazione(taifTComm.getIdDestinazione());
				beLegname.setListDestinazione(this.getDestinazioneMateriale(ordinFilter));
				beLegname.setListDestinazione(this.getDestinazioneMateriale(ordinFilter));

				listLegname.add(beLegname);

			}

			for (BeLegnameAssortimentoTrattatoDto legnameDto : listLegname) {
				listFeLegname.add(dozerBeanMapper.map(legnameDto, LegnameAssortimentoTrattato.class));
			}

			for (LegnameAssortimentoTrattato feLegname : listFeLegname) {
				feLegname.setElencoSpecie(this.getElencoSpecie(ordinFilter));
				feLegname.setElencoAssortimenti(this.getAssortimento(ordinFilter));
				feLegname.setElencoProvenienze(this.getProvenienzaMateriale(ordinFilter));
				feLegname.setElencoDestinazioni(this.getDestinazioneMateriale(ordinFilter));
				feLegname.setElencoTA(this.getTagliatoAcquistato());
				feLegname.setElencoUnitaMisura(this.getUnitaMisura(ordinFilter.getFlagVisibile()));

			}

			return listFeLegname;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoLegnami] END");
		}
	}

	// per integrare beam LegnameAssortimentoTrattato
	public ArrayList<CodeDescription> getElencoSpecie(VisibileOrdinFilter ordinFilter) throws DbManagerException {
		log.debug("[DbMgr::getElencoSpecie] BEGIN");
		try {
			ArrayList<CodeDescription> listSpecie = new ArrayList<CodeDescription>();

			List<TaifDSpecieByFilterDto> specieList = taifDSpecieDao.findByFilter(ordinFilter);
			for (TaifDSpecieByFilterDto taifTPersonaDto : specieList) {
				listSpecie.add(dozerBeanMapper.map(taifTPersonaDto, CodeDescription.class));
			}
			return listSpecie;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoSpecie] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAssortimento(VisibileOrdinFilter ordinFilter) throws DbManagerException {
		log.debug("[DbMgr::getElencoAssortimento] BEGIN");
		try {
			ArrayList<CodeDescription> listAssortimento = new ArrayList<CodeDescription>();

			List<TaifDAssortimentoByVisibleFilterDto> assortList = taifDAssortimentoDao
					.findByVisibleFilter(ordinFilter);
			for (TaifDAssortimentoByVisibleFilterDto assortDto : assortList) {
				listAssortimento.add(dozerBeanMapper.map(assortDto, CodeDescription.class));
			}
			return listAssortimento;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAssortimento] END");
		}
	}

	public ArrayList<CodeDescription> getProvenienzaMateriale(VisibileOrdinFilter ordinFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listProvenienza = new ArrayList<CodeDescription>();

			List<TaifDProvDestinByFilterDto> provenienzaList = taifDProvDestinDao.findByFilter(ordinFilter);
			for (TaifDProvDestinByFilterDto taifProvenienza : provenienzaList) {
				listProvenienza.add(dozerBeanMapper.map(taifProvenienza, CodeDescription.class));
			}
			return listProvenienza;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public ArrayList<CodeDescription> getCommercializzazione() throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listCommercializz = new ArrayList<CodeDescription>();

			List<TaifTCommercializzazioneDto> commList = taifTCommercializzazioneDao.findAll();
			for (TaifTCommercializzazioneDto commercializz : commList) {
				listCommercializz.add(dozerBeanMapper.map(commercializz, CodeDescription.class));
			}
			return listCommercializz;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public ArrayList<CodeDescription> getAssortimento(VisibileOrdinFilter ordinFilter) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listAssortimento = new ArrayList<CodeDescription>();

			List<TaifDAssortimentoByVisibleFilterDto> assortimentoList = taifDAssortimentoDao
					.findByVisibleFilter(ordinFilter);
			for (TaifDAssortimentoByVisibleFilterDto assortimento : assortimentoList) {
				listAssortimento.add(dozerBeanMapper.map(assortimento, CodeDescription.class));
			}
			return listAssortimento;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}

	}

	public ArrayList<CodeDescription> getUnitaMisura(Integer flagVisibile) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listUnitaMisura = new ArrayList<CodeDescription>();

			List<TaifDUnitaDiMisuraByVisibleFilterDto> unitaMisuraList = taifDUnitaDiMisuraDao
					.findByVisibleFilter(flagVisibile);
			for (TaifDUnitaDiMisuraByVisibleFilterDto unitaMisuraDto : unitaMisuraList) {
				listUnitaMisura.add(dozerBeanMapper.map(unitaMisuraDto, CodeDescription.class));
			}
			return listUnitaMisura;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public ArrayList<CodeDescription> getDestinazioneMateriale(VisibileOrdinFilter ordinFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listDest = new ArrayList<CodeDescription>();

			List<TaifDProvDestinByFilterDto> destinazioneList = taifDProvDestinDao.findByFilter(ordinFilter);
			for (TaifDProvDestinByFilterDto taifDest : destinazioneList) {
				listDest.add(dozerBeanMapper.map(taifDest, CodeDescription.class));
			}
			return listDest;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public ArrayList<CodeDescription> getTagliatoAcquistato() throws DbManagerException {
		log.debug("[DbMgr::getTagliatoAcquistato] BEGIN");
		// try {
		// ArrayList<CodeDescription> listTagliato= new ArrayList<CodeDescription>();
		// CodeDescription code= new CodeDescription();
		// List<TaifTCommercializzazioneDto> commList =
		// taifTCommercializzazioneDao.findAll();
		// for (TaifTCommercializzazioneDto tagliato : commList) {
		// code.setCode(tagliato.getIdCommercializzazione().toString());
		// code.setDescription(tagliato.getFlgTagliatoAcquistato());
		// listTagliato.add(code);
		// }
		// return listTagliato;
		// }
		// catch(DaoException e) {
		// throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		// } finally {
		// log.debug("[DbMgr::getProvenienzaMateriale] END");
		// }
		return ListUtils.createGenericListOfCodeDescription(Constants.TAGLIATO, Constants.ACQUISTATO);

	}
	// getElencoCapannoni

	public ArrayList<Capannone> getElencoCapannoni(Integer idAzienda, VisibileOrdinFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoCapannoni] BEGIN");
		try {

			ArrayList<BeCapannoneDto> beCapannone = new ArrayList<BeCapannoneDto>();
			ArrayList<Capannone> capannoneList = new ArrayList<Capannone>();

			TaifDFunzionePk pk = new TaifDFunzionePk();

			List<TaifTStrutturaFindByAziendaDto> listStru = taifTStrutturaDao.findFindByAzienda(idAzienda);
			for (TaifTStrutturaFindByAziendaDto taifTStrutturaFindByAziendaDto : listStru) {
				// pk.setIdFunzione(taifTStrutturaFindByAziendaDto.getFunz());
				TaifDFunzioneDto funzione = taifDFunzioneDao
						.findByPrimaryKey(new TaifDFunzionePk(taifTStrutturaFindByAziendaDto.getFunz()));
				if (taifTStrutturaFindByAziendaDto.getFunz() != 5) {
					BeCapannoneDto capannone = new BeCapannoneDto();
					capannone.setIdCapannone(taifTStrutturaFindByAziendaDto.getId());
					capannone.setFunzioneCapannone(funzione.getFunzione());
					capannone.setIdFunzioneCapannone(taifTStrutturaFindByAziendaDto.getFunz());
					capannone.setAnnoCostruzioneORiattamentoCapannone(
							taifTStrutturaFindByAziendaDto.getAnno().toString());
					capannone.setDimensioneCapannone(taifTStrutturaFindByAziendaDto.getDim().toString());
					beCapannone.add(capannone);
				}
			}
			int i = 1;
			ArrayList<CodeDescription> cd = this.getFunzioneCapannone(filter);
			for (BeCapannoneDto capannoneDto : beCapannone) {
				Capannone dto = dozerBeanMapper.map(capannoneDto, Capannone.class);
				dto.setRownum(i);
				dto.setElencoFunzioni(cd);
				capannoneList.add(dto);
				i++;
			}
			return capannoneList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCapannoni] END");
		}
	}

	public ArrayList<CodeDescription> getFunzioneCapannone(VisibileOrdinFilter ordinFilter) throws DbManagerException {
		log.debug("[DbMgr::getFunzioneCapannone] BEGIN");
		try {
			ArrayList<CodeDescription> listFunzione = new ArrayList<CodeDescription>();

			List<TaifDFunzioneByVisibleFilterDto> funzioneList = taifDFunzioneDao.findByVisibleFilter(ordinFilter);
			for (TaifDFunzioneByVisibleFilterDto funzioneDao : funzioneList) {
				listFunzione.add(dozerBeanMapper.map(funzioneDao, CodeDescription.class));
			}
			return listFunzione;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getFunzioneCapannone] END");
		}
	}

	// getElencoPiazzaliStoccaggio

	public ArrayList<CodeDescription> getElencoPiazzaliStoccaggio(VisibileOrdinFilter ordinFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoPiazzaliStoccaggio] BEGIN");
		try {

			ArrayList<CodeDescription> listFunzione = new ArrayList<CodeDescription>();

			List<TaifDFunzioneByVisibleFilterDto> funzioneList = taifDFunzioneDao.findByVisibleFilter(ordinFilter);
			for (TaifDFunzioneByVisibleFilterDto funzioneDao : funzioneList) {
				if (funzioneDao.getIdStru() == 2) {
					listFunzione.add(dozerBeanMapper.map(funzioneDao, CodeDescription.class));
				}
			}
			return listFunzione;

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoPiazzaliStoccaggio] END");
		}
	}

	public ArrayList<MezzoDiProtezioneIndividuale> getElencoCaschiForestali(VisibileOrdinFilter visibileFilter,
			Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getElencoCapannoni] BEGIN");
		try {

			List<MezzoDiProtezioneIndividuale> protezioneElenco = new ArrayList<MezzoDiProtezioneIndividuale>();
			List<TaifTDpiByAziendaDto> listDispositiviProtezioneList = taifTDpiDao.findByAzienda(idAzienda);
			for (TaifTDpiByAziendaDto taifTDpiByAziendaDto : listDispositiviProtezioneList) {
				if (taifTDpiByAziendaDto.getIdTipoDpi() == Constants.oneInt) {
					protezioneElenco.add(dozerBeanMapper.map(taifTDpiByAziendaDto, MezzoDiProtezioneIndividuale.class));
				}
			}
			return (ArrayList<MezzoDiProtezioneIndividuale>) protezioneElenco;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCapannoni] END");
		}
	}

	public ArrayList<MezzoDiProtezioneIndividuale> getElencoPantaloniAntitaglio(VisibileOrdinFilter visibileFilter,
			Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getElencoCapannoni] BEGIN");
		try {

			List<MezzoDiProtezioneIndividuale> protezioneElenco = new ArrayList<MezzoDiProtezioneIndividuale>();
			List<TaifTDpiByAziendaDto> listDispositiviProtezioneList = taifTDpiDao.findByAzienda(idAzienda);
			for (TaifTDpiByAziendaDto taifTDpiByAziendaDto : listDispositiviProtezioneList) {
				if (taifTDpiByAziendaDto.getIdTipoDpi() == Constants.threInt) {
					protezioneElenco.add(dozerBeanMapper.map(taifTDpiByAziendaDto, MezzoDiProtezioneIndividuale.class));
				}
			}
			return (ArrayList<MezzoDiProtezioneIndividuale>) protezioneElenco;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCapannoni] END");
		}
	}

	public ArrayList<MezzoDiProtezioneIndividuale> getElencoScarponiRinforzati(VisibileOrdinFilter visibileFilter,
			Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getElencoCapannoni] BEGIN");
		try {

			List<MezzoDiProtezioneIndividuale> protezioneElenco = new ArrayList<MezzoDiProtezioneIndividuale>();
			List<TaifTDpiByAziendaDto> listDispositiviProtezioneList = taifTDpiDao.findByAzienda(idAzienda);
			for (TaifTDpiByAziendaDto taifTDpiByAziendaDto : listDispositiviProtezioneList) {
				if (taifTDpiByAziendaDto.getIdTipoDpi() == Constants.twoInt) {
					protezioneElenco.add(dozerBeanMapper.map(taifTDpiByAziendaDto, MezzoDiProtezioneIndividuale.class));
				}
			}
			return (ArrayList<MezzoDiProtezioneIndividuale>) protezioneElenco;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCapannoni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoDpi(Integer visibile) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoTipo = new ArrayList<CodeDescription>();

			List<TaifDTipoDpiByVisibleDto> funzioneList = taifDTipoDpiDao.findByVisible(visibile);
			for (TaifDTipoDpiByVisibleDto tipoDto : funzioneList) {
				listElencoTipo.add(dozerBeanMapper.map(tipoDto, CodeDescription.class));
			}
			return listElencoTipo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}
	//

	public ArrayList<CodeDescription> getElencoTipoMezzo(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoTipo = new ArrayList<CodeDescription>();

			List<TaifDTipoMezzoByVisibileOrdinDto> tipoMezzoList = taifDTipoMezzoDao.findByVisibileOrdin(filter);
			for (TaifDTipoMezzoByVisibileOrdinDto mezzoDto : tipoMezzoList) {
				listElencoTipo.add(dozerBeanMapper.map(mezzoDto, CodeDescription.class));
			}
			return listElencoTipo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public ArrayList<CodeDescription> getElencoCategoriaMezzo(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoTipo = new ArrayList<CodeDescription>();

			List<TaifDCategoriaMezzoByVisibileOrdinDto> categoriaList = taifDCategoriaMezzoDao
					.findByVisibileOrdin(filter);
			for (TaifDCategoriaMezzoByVisibileOrdinDto categoriaDto : categoriaList) {
				listElencoTipo.add(dozerBeanMapper.map(categoriaDto, CodeDescription.class));
			}
			return listElencoTipo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoMezzoCategoria(TipoMezzoFilter filter, String categoria)
			throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoTipo = new ArrayList<CodeDescription>();

			CategoriaMezzoFilter categoriaMezzoFilter = new CategoriaMezzoFilter();
			categoriaMezzoFilter.setFlagItaFr(filter.getFlagItaFr());
			categoriaMezzoFilter.setFlagVisibile(filter.getFlagVisibile());
			categoriaMezzoFilter.setCategoriaMezzo(categoria);

			filter.setIdCategoriaMezzo(
					taifDCategoriaMezzoDao.findByCategoriaMezzo(categoriaMezzoFilter).get(0).getId());

			List<TaifDTipoMezzoByVisibileCategoriaDto> tipoMezzoList = taifDTipoMezzoDao
					.findByVisibileCategoria(filter);
			for (TaifDTipoMezzoByVisibileCategoriaDto mezzoDto : tipoMezzoList) {
				listElencoTipo.add(dozerBeanMapper.map(mezzoDto, CodeDescription.class));
			}
			return listElencoTipo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public int getIdMezzoByTipoMezzo(TipoMezzoFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getIdMezzoByTipoMezzo] BEGIN");
		try {
			int idTipomezzo = 0;
			List<TaifDTipoMezzoByTipoMezzoDto> tipoMezzoList = taifDTipoMezzoDao.findByTipoMezzo(filter);
			if (tipoMezzoList != null & !tipoMezzoList.isEmpty()) {
				idTipomezzo = tipoMezzoList.get(0).getId();
			}
			return idTipomezzo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getIdMezzoByTipoMezzo] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoTrazione(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoTrazione = new ArrayList<CodeDescription>();

			List<TaifDTrazioneByVisibileOrdinDto> tipoMezzoList = taifDTrazioneDao.findByVisibileOrdin(filter);
			for (TaifDTrazioneByVisibileOrdinDto tipoDto : tipoMezzoList) {
				listElencoTrazione.add(dozerBeanMapper.map(tipoDto, CodeDescription.class));
			}
			return listElencoTrazione;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	// getElencoTipoTrazioniPerTipoMezzo
	public ArrayList<CodeDescription> getElencoTipoTrazioniPerTipoMezzo(TipoMezzoFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoTrazione = new ArrayList<CodeDescription>();
			filter.setIdTipoMezzo(getIdMezzoByTipoMezzo(filter));
			List<TaifDTrazioneByTrazTrazioneDto> tipoMezzoList = taifDTrazioneDao.findByTrazTrazione(filter);
			for (TaifDTrazioneByTrazTrazioneDto tipoDto : tipoMezzoList) {
				listElencoTrazione.add(dozerBeanMapper.map(tipoDto, CodeDescription.class));
			}
			return listElencoTrazione;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}
	//

	public ArrayList<CodeDescription> getElencoTipoMezzoByCategoria(TipoMezzoFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoTipoMezzoByCategoria] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoTipoMacchine = new ArrayList<CodeDescription>();

			filter.setIdTipoMezzo(getIdMezzoByTipoMezzo(filter));
			List<TaifDTipoMezzoByCategoriaMezzoDto> tipoMezzoList = taifDTipoMezzoDao.findByCategoriaMezzo(filter);
			for (TaifDTipoMezzoByCategoriaMezzoDto tipoDto : tipoMezzoList) {
				listElencoTipoMacchine.add(dozerBeanMapper.map(tipoDto, CodeDescription.class));
			}
			return listElencoTipoMacchine;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipoMezzoByCategoria] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAlimentazione(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoAlimentazione = new ArrayList<CodeDescription>();

			List<TaifDAlimentazioneByVisibileDto> tipoAlimList = taifDAlimentazioneDao.findByVisibile(filter);
			for (TaifDAlimentazioneByVisibileDto alimDto : tipoAlimList) {
				listElencoAlimentazione.add(dozerBeanMapper.map(alimDto, CodeDescription.class));
			}
			return listElencoAlimentazione;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoCarrello(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoCarello = new ArrayList<CodeDescription>();

			List<TaifDTipoCarrelloByVisibileDto> tipoCarelloList = taifDTipoCarrelloDao
					.findByVisibile(filter.getFlagVisibile());
			for (TaifDTipoCarrelloByVisibileDto carelloDto : tipoCarelloList) {
				listElencoCarello.add(dozerBeanMapper.map(carelloDto, CodeDescription.class));
			}
			return listElencoCarello;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public ArrayList<MacchinaMezzo> getElencoMacchineCategoria(TipoMezzoFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoMacchineTipo] BEGIN");
		try {

			VisibileOrdinFilter visible = new VisibileOrdinFilter();
			visible.setFlagItaFr(filter.getFlagItaFr());
			visible.setFlagVisibile(filter.getFlagVisibile());
			List<MacchinaMezzo> macchinaElenco = new ArrayList<MacchinaMezzo>();
			BeMacchinaMezzoDto macchina = new BeMacchinaMezzoDto();
			List<TaifTMezzoByTipoMezzoAziendaDto> tipoTrattriceList = taifTMezzoDao.findByTipoMezzoAzienda(filter);
			for (TaifTMezzoByTipoMezzoAziendaDto mezzo : tipoTrattriceList) {
				macchina.setIdMacchinaMezzo(mezzo.getId());
				macchina.setDescMacchinaMezzo(mezzo.getTipoMezzo());
				// TipoMezzoFilter filter, String categoria
				macchina.setListTipoMacchinaMezzo(getElencoTipoMezzoCategoria(filter, filter.getCategoriaMezzo()));
				macchina.setAttrTipoMezzoOrd(0);
				listAttributi = getAttributForMezzo(mezzo.getIdTipoMezzo());
				for (TaifCnfAttribAmmessoByFilterDto attr : listAttributi) {
					if (attr.getAttributo().equals(Constants.attrNoleggio)) {
						if (mezzo.getNoleggio() != null && !(mezzo.getNoleggio().equals(Constants.blank))) {
							macchina.setNoleggio(mezzo.getNoleggio().intValue());
						} else {
							macchina.setNoleggio(Constants.oneInt);
						}
						macchina.setAttrNoleggioOrd(attr.getOrdin().intValue());
					}
					if (attr.getAttributo().equals(Constants.attrPotenza)) {
						if (mezzo.getPotenza() != null && mezzo.getPotenza().intValue() > 0) {
							macchina.setPotenza(String.valueOf(mezzo.getPotenza()));
						} else {
							macchina.setPotenza(Constants.zero);
						}
						macchina.setAttrPotenzaOrd(attr.getOrdin().intValue());
					}

					if (attr.getAttributo().equals(Constants.attrTrazione)) {
						if (mezzo.getIdTipoTrazione() != null && !(mezzo.getIdTipoTrazione().equals(Constants.blank))) {
							macchina.setIdTipoTrazione(mezzo.getIdTipoTrazione());
						} else {
							macchina.setIdTipoTrazione(Constants.oneInt);
						}
						macchina.setDescTipoTrazione(taifDTrazioneDao
								.findByPrimaryKey(new TaifDTrazionePk(mezzo.getIdTipoTrazione())).getTrazione());
						macchina.setListTipoTrazione(getElencoTipoTrazione(visible));
						macchina.setAttrTrazioneOrd(attr.getOrdin().intValue());
					}

					if (attr.getAttributo().equals(Constants.attrComando)) {
						if (mezzo.getComando() != null && !(mezzo.getComando().equals(Constants.blank))) {
							macchina.setComandatoDistanza(mezzo.getComando().toString());
						} else {
							macchina.setComandatoDistanza(Constants.blank);
						}
						macchina.setAttrComandoOrd(attr.getOrdin().intValue());
					}
					if (attr.getAttributo().equals(Constants.attrAnno)) {
						if (mezzo.getAnno() != null && !(mezzo.getAnno().equals(Constants.blank))) {
							macchina.setAnnoImmatricolazione(mezzo.getAnno().intValue());
						}
						macchina.setAttrAnnoOrd(attr.getOrdin().intValue());
					}
					if (attr.getAttributo().equals(Constants.attrAlim)) {
						if (mezzo.getIdAlimentazione() != null
								&& !(mezzo.getIdAlimentazione().equals(Constants.blank))) {
							macchina.setIdTipoAlimentazione(mezzo.getIdAlimentazione());
						} else {
							macchina.setIdTipoAlimentazione(Constants.oneInt);
						}
						macchina.setDescTipoAlimentazione(taifDAlimentazioneDao
								.findByPrimaryKey(new TaifDAlimentazionePk(mezzo.getIdAlimentazione()))
								.getAlimentazione());
						macchina.setListTipoAlimentazione(getElencoAlimentazione(visible));
						macchina.setAttrAlimOrd(attr.getOrdin().intValue());
					}
					if (attr.getAttributo().equals(Constants.attrPortata)) {
						if (mezzo.getPortata() != null && mezzo.getPortata().intValue() > 0) {
							macchina.setPortata(String.valueOf(mezzo.getPortata()));
						} else {
							macchina.setPortata(Constants.zero);
						}
						macchina.setAttrPortataOrd(attr.getOrdin().intValue());
					}

					if (attr.getAttributo().equals(Constants.attrCarrello)) {
						if (mezzo.getIdTipoCarrel() != null && !(mezzo.getIdTipoCarrel().equals(Constants.blank))) {
							macchina.setIdTipoCarrello(mezzo.getIdTipoCarrel());
						} else {
							macchina.setIdTipoCarrello(Constants.oneInt);
						}
						macchina.setDescTipoCarrello(taifDTipoCarrelloDao
								.findByPrimaryKey(new TaifDTipoCarrelloPk(mezzo.getIdTipoCarrel())).getTipoCarrello());
						macchina.setListTipoCarrello(getElencoTipoCarrello(visible));
						macchina.setAttrCarrelloOrd(attr.getOrdin().intValue());
					}
				}

				macchinaElenco.add(dozerBeanMapper.map(mezzo, MacchinaMezzo.class));
			}
			return (ArrayList<MacchinaMezzo>) macchinaElenco;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoMacchineTipo] END");
		}
	}

	public List<TaifCnfAttribAmmessoByFilterDto> getAttributForMezzo(Integer idTipoMezzo) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			List<TaifCnfAttribAmmessoByFilterDto> attrAmmessiList = taifCnfAttribAmmessoDao.findByFilter(idTipoMezzo);

			return attrAmmessiList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	// getElencoMacchineTrattrici
	public ArrayList<MacchinaMezzo> getElencoMacchine(TipoMezzoFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoMacchineTipo] BEGIN");
		try {

			VisibileOrdinFilter visible = new VisibileOrdinFilter();
			visible.setFlagItaFr(filter.getFlagItaFr());
			visible.setFlagVisibile(filter.getFlagVisibile());

			List<MacchinaMezzo> macchinaElenco = new ArrayList<MacchinaMezzo>();
			BeMacchinaMezzoDto macchina = new BeMacchinaMezzoDto();

			List<TaifTMezzoByTipoMezzoAziendaDto> tipoTrattriceList = taifTMezzoDao.findByTipoMezzoAzienda(filter);
			for (TaifTMezzoByTipoMezzoAziendaDto mezzo : tipoTrattriceList) {

				macchina.setIdMacchinaMezzo(mezzo.getId());
				macchina.setDescMacchinaMezzo(mezzo.getTipoMezzo());
				listAttributi = getAttributForMezzo(mezzo.getIdTipoMezzo());

				for (TaifCnfAttribAmmessoByFilterDto attr : listAttributi) {
					if (attr.getAttributo().equals(Constants.attrNoleggio)) {
						if (mezzo.getNoleggio() != null && !(mezzo.getNoleggio().equals(Constants.blank))) {
							macchina.setNoleggio(mezzo.getNoleggio().intValue());
						} else {
							macchina.setNoleggio(Constants.oneInt);
						}
						macchina.setAttrNoleggioOrd(attr.getOrdin().intValue());
					}

					if (attr.getAttributo().equals(Constants.attrPotenza)) {
						if (mezzo.getPotenza() != null && mezzo.getPotenza().intValue() > 0) {
							macchina.setPotenza(String.valueOf(mezzo.getPotenza()));
						} else {
							macchina.setPotenza(Constants.zero);
						}
						macchina.setAttrPotenzaOrd(attr.getOrdin().intValue());
					}

					if (attr.getAttributo().equals(Constants.attrTrazione)) {
						if (mezzo.getIdTipoTrazione() != null && !(mezzo.getIdTipoTrazione().equals(Constants.blank))) {
							macchina.setIdTipoTrazione(mezzo.getIdTipoTrazione());
						} else {
							macchina.setIdTipoTrazione(Constants.oneInt);
						}
						macchina.setDescTipoTrazione(taifDTrazioneDao
								.findByPrimaryKey(new TaifDTrazionePk(mezzo.getIdTipoTrazione())).getTrazione());
						macchina.setListTipoTrazione(getElencoTipoTrazione(visible));
						macchina.setAttrTrazioneOrd(attr.getOrdin().intValue());
					}

					if (attr.getAttributo().equals(Constants.attrComando)) {
						if (mezzo.getComando() != null && !(mezzo.getComando().equals(Constants.blank))) {
							macchina.setComandatoDistanza(mezzo.getComando().toString());
						} else {
							macchina.setComandatoDistanza(Constants.blank);
						}
						macchina.setAttrComandoOrd(attr.getOrdin().intValue());
					}
					if (attr.getAttributo().equals(Constants.attrAnno)) {
						if (mezzo.getAnno() != null && !(mezzo.getAnno().equals(Constants.blank))) {
							macchina.setAnnoImmatricolazione(mezzo.getAnno().intValue());
						}
						macchina.setAttrAnnoOrd(attr.getOrdin().intValue());
					}
					if (attr.getAttributo().equals(Constants.attrAlim)) {
						if (mezzo.getIdAlimentazione() != null
								&& !(mezzo.getIdAlimentazione().equals(Constants.blank))) {
							macchina.setIdTipoAlimentazione(mezzo.getIdAlimentazione());
						} else {
							macchina.setIdTipoAlimentazione(Constants.oneInt);
						}
						macchina.setDescTipoAlimentazione(taifDAlimentazioneDao
								.findByPrimaryKey(new TaifDAlimentazionePk(mezzo.getIdAlimentazione()))
								.getAlimentazione());
						macchina.setListTipoAlimentazione(getElencoAlimentazione(visible));
						macchina.setAttrAlimOrd(attr.getOrdin().intValue());
					}
					if (attr.getAttributo().equals(Constants.attrPortata)) {
						if (mezzo.getPortata() != null && mezzo.getPortata().intValue() > 0) {
							macchina.setPortata(String.valueOf(mezzo.getPortata()));
						} else {
							macchina.setPortata(Constants.zero);
						}
						macchina.setAttrPortataOrd(attr.getOrdin().intValue());
					}

					if (attr.getAttributo().equals(Constants.attrCarrello)) {
						if (mezzo.getIdTipoCarrel() != null && !(mezzo.getIdTipoCarrel().equals(Constants.blank))) {
							macchina.setIdTipoCarrello(mezzo.getIdTipoCarrel());
						} else {
							macchina.setIdTipoCarrello(Constants.oneInt);
						}
						macchina.setDescTipoCarrello(taifDTipoCarrelloDao
								.findByPrimaryKey(new TaifDTipoCarrelloPk(mezzo.getIdTipoCarrel())).getTipoCarrello());
						macchina.setListTipoCarrello(getElencoTipoCarrello(visible));
						macchina.setAttrCarrelloOrd(attr.getOrdin().intValue());
					}

				}
				macchinaElenco.add(dozerBeanMapper.map(macchina, MacchinaMezzo.class));
			}
			return (ArrayList<MacchinaMezzo>) macchinaElenco;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoMacchineTipo] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipologiaPersonale(VisibileOrdinFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoTipologiaPersonale] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoTipo = new ArrayList<CodeDescription>();

			List<TaifDRuoloByVisibileDto> tipoRuolo = taifDRuoloDao.findByVisibile(filter.getFlagVisibile());
			for (TaifDRuoloByVisibileDto ruoloDto : tipoRuolo) {
				listElencoTipo.add(dozerBeanMapper.map(ruoloDto, CodeDescription.class));
			}
			return listElencoTipo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipologiaPersonale] END");
		}
	}

	public int getIdRuolo(RuoloFilter ruolo) throws DbManagerException {
		log.debug("[DbMgr::getIdRuolo] BEGIN");
		try {
			int idRuolo = 0;
			List<TaifDRuoloByRuoloDto> tipoRuolo = taifDRuoloDao.findByRuolo(ruolo);

			if (tipoRuolo != null) {
				idRuolo = tipoRuolo.get(0).getIdRuolo();
			}
			return idRuolo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getIdRuolo] END");
		}

	}

	public ArrayList<CodeDescription> getElencoMansioni(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoMansioni] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoMansioni = new ArrayList<CodeDescription>();

			List<TaifDTipoMansioneByVisibleOrdinDto> mansioniList = taifDTipoMansioneDao.findByVisibleOrdin(filter);
			for (TaifDTipoMansioneByVisibleOrdinDto mansioniDto : mansioniList) {
				listElencoMansioni.add(dozerBeanMapper.map(mansioniDto, CodeDescription.class));
			}
			return listElencoMansioni;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoMansioni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoContratti(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoContratti] BEGIN");
		try {
			ArrayList<CodeDescription> listElencoContratti = new ArrayList<CodeDescription>();

			List<TaifDTipoContrattoByVisibleOrdinDto> tipoContrattiList = taifDTipoContrattoDao
					.findByVisibleOrdin(filter);
			for (TaifDTipoContrattoByVisibleOrdinDto contrattiDto : tipoContrattiList) {
				listElencoContratti.add(dozerBeanMapper.map(contrattiDto, CodeDescription.class));
			}
			return listElencoContratti;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoContratti] END");
		}
	}

	public ArrayList<CodeDescription> getElencoDurateContratti(Integer personaAz) throws DbManagerException {
		log.debug("[DbMgr::getElencoDurateContratti] BEGIN");
		try {
			ArrayList<CodeDescription> listDurateContratti = new ArrayList<CodeDescription>();

			List<TaifRPersonaAziendaByIdAziendaDto> elencoDurateContr = taifRPersonaAziendaDao
					.findByIdAzienda(personaAz);
			for (TaifRPersonaAziendaByIdAziendaDto contrattiDto : elencoDurateContr) {
				listDurateContratti.add(dozerBeanMapper.map(contrattiDto, CodeDescription.class));
			}
			return listDurateContratti;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoDurateContratti] END");
		}
	}

	public ArrayList<CodeDescription> getElencoDurateContratti() throws DbManagerException {
		log.debug("[DbMgr::getElencoDurateContratti] BEGIN");
		try {
			return ListUtils.createGenericListOfCodeDescription("D", "I");
		} finally {
			log.debug("[DbMgr::getElencoDurateContratti] END");
		}
	}

	public List<TaifRPersonaAziendaContrattoByIdPersonaDto> getTipologiaContrattoPersona(Integer personaAz)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoDurateContratti] BEGIN");
		try {

			List<TaifRPersonaAziendaContrattoByIdPersonaDto> elencoDurateContr = taifRPersonaAziendaDao
					.findContrattoByIdPersona(personaAz);

			return elencoDurateContr;

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoDurateContratti] END");
		}
	}

	public ArrayList<CodeDescription> getElencoInquadramenti(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoDurateContratti] BEGIN");
		try {
			ArrayList<CodeDescription> elencoOInquadramenti = new ArrayList<CodeDescription>();

			List<TaifDTipoInquadramentoByVisibleDto> elencoInquadram = taifDTipoInquadramentoDao
					.findByVisible(filter.getFlagVisibile());
			for (TaifDTipoInquadramentoByVisibleDto contrattiDto : elencoInquadram) {
				elencoOInquadramenti.add(dozerBeanMapper.map(contrattiDto, CodeDescription.class));
			}
			return elencoOInquadramenti;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoDurateContratti] END");
		}
	}

	//// getElencoPersonaleAzienda to review
	public ArrayList<Personale> getElencoPersonaleAzienda(Integer idAzienda, VisibileOrdinFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoDurateContratti] BEGIN");
		try {
			ArrayList<Personale> elencoInquadramenti = new ArrayList<Personale>();

			List<TaifRPersonaAziendaByIdAziendaDto> listPersonaleAzienda = taifRPersonaAziendaDao
					.findByIdAzienda(idAzienda);
			int rownum = 0;
			for (TaifRPersonaAziendaByIdAziendaDto persona : listPersonaleAzienda) {
				if (!(persona.getIdRuolo().equals(Integer.valueOf(2))
						|| persona.getIdRuolo().equals(Integer.valueOf(1)))) {

					TaifTPersonaDto personale = taifTPersonaDao.findByPrimaryKey(new TaifTPersonaPk(persona.getId()));
					if (personale != null) {

						Personale personaDto = new Personale();

						personaDto.setIdPersonale(personale.getIdPersona());
						personaDto.setCodiceFiscale(personale.getCodiceFiscale());
						personaDto.setCognome(personale.getCognome());
						personaDto.setNome(personale.getNome());

						personaDto.setIdContratto(persona.getIdContratto());

						personaDto.setIdInquadramento(persona.getIdInquad());
						personaDto.setIdMansione(persona.getIdMansione());
						personaDto.setIdTipologiaPersonale(persona.getIdRuolo());

						personaDto.setDsMansione(taifDTipoMansioneDao
								.findByPrimaryKey(new TaifDTipoMansionePk(persona.getIdMansione())).getTipoMansione());

						personaDto.setDsInquadramento(taifDTipoInquadramentoDao
								.findByPrimaryKey(new TaifDTipoInquadramentoPk(persona.getIdInquad()))
								.getTipoInquadramento());

						if (persona.getDet() != null) {
							personaDto.setGiorniNellAnno(String.valueOf(persona.getDet()));
						} else {
							personaDto.setGiorniNellAnno("");
						}
						if (persona.getFlInd() != null) {
							personaDto.setDsDurataContratto(String.valueOf(persona.getFlInd().intValue()));
							// personaDto.setIdDurataContratto(persona.getFlInd().intValue());
							personaDto.setIdDurataContratto(ConvertUtil.convertToString(persona.getFlInd()));
						}
						personaDto.setElencoMansioni(getElencoMansioni(filter));
						personaDto.setElencoTipologiaPersonale(getElencoTipologiaPersonale(filter));
						personaDto.setElencoContratti(getElencoContratti(filter));
						//personaDto.setElencoDurateContratto(getElencoDurateContratti(personale.getIdPersona()));
						personaDto.setElencoDurateContratto(ListUtils.createGenericListOfCodeDescription(it.csi.taif.taifweb.business.dao.util.Constants.DET,
								it.csi.taif.taifweb.business.dao.util.Constants.INDET));
						personaDto.setElencoInquadramenti(getElencoInquadramenti(filter));
						// Elenco corsi
						String corsi = this.findCorsiPerPersona(personale.getIdPersona());
						personaDto.setCorsi(StringUtils.defaultValue(corsi, it.csi.taif.taifweb.util.Constants.NO_CORSI));
						// Elenco qualifiche
						String qualifiche = this.findQualifichePerPersona(personale.getIdPersona());
						personaDto.setQualifiche(StringUtils.defaultValue(qualifiche, it.csi.taif.taifweb.util.Constants.NO_QUALIFICHE));
						// Elenco riconoscimenti
						String riconoscimenti = this.findRiconoscimentiPerPersona(personale.getIdPersona());
						personaDto.setRiconoscimenti(StringUtils.defaultValue(riconoscimenti, it.csi.taif.taifweb.util.Constants.NO_RICONOSCIMENTI));
						personaDto.setRownum(rownum++);
						elencoInquadramenti.add(personaDto);
					}
				}
			}
			return elencoInquadramenti;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoDurateContratti] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAmbitiFormativi(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getAmbitiFormativi] BEGIN");
		try {
			ArrayList<CodeDescription> elencoAmbitiForm = new ArrayList<CodeDescription>();

			List<TaifDAmbitoFormativoByVisibleDto> elencoAmbiti = taifDAmbitoFormativoDao.findByVisible(filter);
			for (TaifDAmbitoFormativoByVisibleDto ambitoDto : elencoAmbiti) {
				elencoAmbitiForm.add(dozerBeanMapper.map(ambitoDto, CodeDescription.class));
			}
			return elencoAmbitiForm;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAmbitiFormativi] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAttivitaAteco(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoAttivitaAteco] BEGIN");
		try {
			ArrayList<CodeDescription> elencoAttAteco = new ArrayList<CodeDescription>();

			List<TaifDAttivitaAtecoApeByFilterDto> elencoAttivitaAteco = taifDAttivitaAtecoApeDao.findByFilter(filter);
			for (TaifDAttivitaAtecoApeByFilterDto atecoDto : elencoAttivitaAteco) {
				elencoAttAteco.add(dozerBeanMapper.map(atecoDto, CodeDescription.class));
			}
			return elencoAttAteco;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAttivitaAteco] END");
		}
	}

	public ArrayList<CodeDescription> getElencoEstensioneFile(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoEstensioneFile] BEGIN");
		try {
			ArrayList<CodeDescription> elencoEstensione = new ArrayList<CodeDescription>();

			List<TaifDEstensioneFileEstensioneFileVisibleDto> elencoEstensioneFile = taifDEstensioneFileDao
					.findEstensioneFileVisible(filter);
			for (TaifDEstensioneFileEstensioneFileVisibleDto estensDao : elencoEstensioneFile) {
				elencoEstensione.add(dozerBeanMapper.map(estensDao, CodeDescription.class));
			}
			return elencoEstensione;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoEstensioneFile] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAziende() throws DbManagerException {
		log.debug("[DbMgr::getElencoAttivitaAteco] BEGIN");
		try {
			ArrayList<CodeDescription> elencoAziende = new ArrayList<CodeDescription>();

			List<TaifTAziendaDto> aziendeList = taifTAziendaDao.findAll();
			for (TaifTAziendaDto aziendeDto : aziendeList) {
				elencoAziende.add(dozerBeanMapper.map(aziendeDto, CodeDescription.class));
			}
			return elencoAziende;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAttivitaAteco] END");
		}
	}

	public ArrayList<CodeDescription> getElencoFormaGiuridica(FormaGiuridicaFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormaGiuridica] BEGIN");
		try {
			ArrayList<CodeDescription> elencoFormeGiurid = new ArrayList<CodeDescription>();
			List<TaifDFormaGiuridicaByFilterDto> fGiuridicaList = taifDFormaGiuridicaDao.findByFilter(filter);
			for (TaifDFormaGiuridicaByFilterDto fGiuridica : fGiuridicaList) {
				elencoFormeGiurid.add(dozerBeanMapper.map(fGiuridica, CodeDescription.class));
			}
			return elencoFormeGiurid;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormaGiuridica] END");
		}
	}

	public ArrayList<CodeDescription> getElencoNazioniFra(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormaGiuridica] BEGIN");
		try {
			ArrayList<CodeDescription> elencoNazioni = new ArrayList<CodeDescription>();
			List<TaifDNazioneByNazioneFraVisibleDto> nazioneList = taifDNazioneDao.findByNazioneFraVisible(filter);
			for (TaifDNazioneByNazioneFraVisibleDto nazFra : nazioneList) {
				elencoNazioni.add(dozerBeanMapper.map(nazFra, CodeDescription.class));
			}
			return elencoNazioni;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormaGiuridica] END");
		}
	}

	public ArrayList<CodeDescription> getElencoNazioniIta(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormaGiuridica] BEGIN");
		try {
			ArrayList<CodeDescription> elencoNazioni = new ArrayList<CodeDescription>();
			List<TaifDNazioneByNazioneItaVisibleDto> nazioneList = taifDNazioneDao.findByNazioneItaVisible(filter);
			for (TaifDNazioneByNazioneItaVisibleDto nazIta : nazioneList) {
				elencoNazioni.add(dozerBeanMapper.map(nazIta, CodeDescription.class));
			}
			return elencoNazioni;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormaGiuridica] END");
		}
	}

	public ArrayList<CodeDescription> getStatoOperativoIta(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormaGiuridica] BEGIN");
		try {
			ArrayList<CodeDescription> elencoStati = new ArrayList<CodeDescription>();

			List<TaifDStatoOpfoStatoOpfoItaVisibleDto> statiList = taifDStatoOpfoDao.findStatoOpfoItaVisible(filter);
			for (TaifDStatoOpfoStatoOpfoItaVisibleDto stati : statiList) {
				elencoStati.add(dozerBeanMapper.map(stati, CodeDescription.class));
			}
			return elencoStati;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormaGiuridica] END");
		}
	}

	public ArrayList<CodeDescription> getStatoOperativoFra(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormaGiuridica] BEGIN");
		try {
			ArrayList<CodeDescription> elencoStati = new ArrayList<CodeDescription>();

			List<TaifDStatoOpfoStatoOpfoFraVisibleDto> statiList = taifDStatoOpfoDao.findStatoOpfoFraVisible(filter);
			for (TaifDStatoOpfoStatoOpfoFraVisibleDto stati : statiList) {
				elencoStati.add(dozerBeanMapper.map(stati, CodeDescription.class));
			}
			return elencoStati;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormaGiuridica] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoAttivita(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoTipoAttivita] BEGIN");
		try {
			ArrayList<CodeDescription> elencoAttivita = new ArrayList<CodeDescription>();

			List<TaifDTipoAttivitaByFilterDto> tipoAttivitaList = taifDTipoAttivitaDao.findByFilter(filter);
			for (TaifDTipoAttivitaByFilterDto attivita : tipoAttivitaList) {
				elencoAttivita.add(dozerBeanMapper.map(attivita, CodeDescription.class));
			}
			return elencoAttivita;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipoAttivita] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoCertificazioni(VisibileOrdinFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoTipoCertificazioni] BEGIN");
		try {
			ArrayList<CodeDescription> elencoCertificazioni = new ArrayList<CodeDescription>();

			List<TaifDTipoCertificazioneTipoCertificazioneVisibleDto> tipoCertificazioniList = taifDTipoCertificazioneDao
					.findTipoCertificazioneVisible(filter);
			for (TaifDTipoCertificazioneTipoCertificazioneVisibleDto cert : tipoCertificazioniList) {
				elencoCertificazioni.add(dozerBeanMapper.map(cert, CodeDescription.class));
			}
			return elencoCertificazioni;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipoCertificazioni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoLavoroPa(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoTipoLavoroPa] BEGIN");
		try {
			ArrayList<CodeDescription> elencoTipoLavoroPa = new ArrayList<CodeDescription>();

			List<TaifDTipoLavoroPaByFilterDto> tipoLavorPaList = taifDTipoLavoroPaDao.findByFilter(filter);
			for (TaifDTipoLavoroPaByFilterDto lavoro : tipoLavorPaList) {
				elencoTipoLavoroPa.add(dozerBeanMapper.map(lavoro, CodeDescription.class));
			}
			return elencoTipoLavoroPa;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipoLavoroPa] END");
		}
	}
	// taifDTipoQualificaDao

	public ArrayList<CodeDescription> getElencoTipoQualifica(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoTipoQualifica] BEGIN");
		try {
			ArrayList<CodeDescription> elencoTipoQualifica = new ArrayList<CodeDescription>();

			List<TaifDTipoQualificaByVisibileDto> tipoQualifica = taifDTipoQualificaDao.findByVisibile(filter);
			for (TaifDTipoQualificaByVisibileDto qualifica : tipoQualifica) {
				elencoTipoQualifica.add(dozerBeanMapper.map(qualifica, CodeDescription.class));
			}
			return elencoTipoQualifica;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipoQualifica] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoSedeAzienda(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoTipoSedeAzienda] BEGIN");
		try {
			ArrayList<CodeDescription> elencoSedeAzienda = new ArrayList<CodeDescription>();

			List<TaifDTipoSedeAziendaByFilterDto> tipoSedeList = taifDTipoSedeAziendaDao.findByFilter(filter);
			for (TaifDTipoSedeAziendaByFilterDto tipoSede : tipoSedeList) {
				elencoSedeAzienda.add(dozerBeanMapper.map(tipoSede, CodeDescription.class));
			}
			return elencoSedeAzienda;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipoSedeAzienda] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoSedeAziendaNoSedeLegale(VisibileOrdinFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoTipoSedeAzienda] BEGIN");
		try {
			ArrayList<CodeDescription> elencoSedeAzienda = new ArrayList<CodeDescription>();

			List<TaifDTipoSedeAziendaByFilterDto> tipoSedeList = taifDTipoSedeAziendaDao.findByFilter(filter);
			for (TaifDTipoSedeAziendaByFilterDto tipoSede : tipoSedeList) {
				if (!tipoSede.getTipo().equals(Constants.sedeLegale)) {
					elencoSedeAzienda.add(dozerBeanMapper.map(tipoSede, CodeDescription.class));
				}
			}
			return elencoSedeAzienda;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipoSedeAzienda] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoStruttura(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoTipoStruttura] BEGIN");
		try {
			ArrayList<CodeDescription> elencoStrutturaList = new ArrayList<CodeDescription>();

			List<TaifDTipoStrutturaTipoStrutturaVisibleDto> tipoStrutturaList = taifDTipoStrutturaDao
					.findTipoStrutturaVisible(filter);
			for (TaifDTipoStrutturaTipoStrutturaVisibleDto tipoStru : tipoStrutturaList) {
				elencoStrutturaList.add(dozerBeanMapper.map(tipoStru, CodeDescription.class));
			}
			return elencoStrutturaList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoTipoStruttura] END");
		}
	}

	public ArrayList<CodeDescription> getElencoUnitaFormativa(UnitaFormativaFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoUnitaFormativa] BEGIN");
		try {
			ArrayList<CodeDescription> unitaFormativaListDest = new ArrayList<CodeDescription>();

			List<TaifDUnitaFormativaByFilterDto> unitaFormativaList = taifDUnitaFormativaDao.findByFilter(filter);
			for (TaifDUnitaFormativaByFilterDto unitaFormativa : unitaFormativaList) {
				unitaFormativaListDest.add(dozerBeanMapper.map(unitaFormativa, CodeDescription.class));
			}
			return unitaFormativaListDest;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoUnitaFormativa] END");
		}
	}

	// taifTStrutturaDao

	public ArrayList<PiazzaleStoccaggio> getElencoPiazzaliStoccaggio(StrutturaFilter filter) throws DbManagerException {

		log.debug("[DbMgr::getElencoPiazzaliStoccaggio] BEGIN");
		try {

			ArrayList<PiazzaleStoccaggio> elencoPiazzaleStoccaggioDest = new ArrayList<PiazzaleStoccaggio>();

			List<TaifTStrutturaByAziendaFunzioneDto> listStruttura = taifTStrutturaDao.findByAziendaFunzione(filter);
			int i = 1;
			for (TaifTStrutturaByAziendaFunzioneDto azFunzioneStru : listStruttura) {
				PiazzaleStoccaggio piazzaleStoccaggio = new PiazzaleStoccaggio();
				piazzaleStoccaggio.setAnnoCostruzioneORiattamentoPiazzale(String.valueOf(azFunzioneStru.getAnno()));
				piazzaleStoccaggio.setDimensionePiazzale(String.valueOf(azFunzioneStru.getDim()));
				piazzaleStoccaggio.setIdPiazzaleStoccaggio(azFunzioneStru.getId());
				piazzaleStoccaggio.setRownum(i);
				elencoPiazzaleStoccaggioDest.add(piazzaleStoccaggio);
				// elencoPiazzaleStoccaggioDest.add(dozerBeanMapper.map(azFunzioneStru,
				// PiazzaleStoccaggio.class));
				i++;
			}
			return elencoPiazzaleStoccaggioDest;

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoPiazzaliStoccaggio] END");
		}
	}

	// personaToSave = dozerBeanMapper.map(backTitolareLegale,
	// TaifTPersonaDto.class);
	public TaifTPersonaDto getPersonaDtoFromBeTitolareRappresentanteLegaleDto(
			BeTitolareRappresentanteLegaleDto backTitolareLegale) throws DbManagerException {

		log.debug("[DbMgr::getPersonaDtoFromBeTitolareRappresentanteLegaleDto] BEGIN");
		try {

			TaifTPersonaDto taifPersonaDto = new TaifTPersonaDto();
			taifPersonaDto = dozerBeanMapper.map(backTitolareLegale, TaifTPersonaDto.class);
			return taifPersonaDto;

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaDtoFromBeTitolareRappresentanteLegaleDto] END");
		}
	}

	public TaifTAziendaDto getAziendaById(int idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getAziendaById] BEGIN");
		try {
			TaifTAziendaDto aziendaById = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			if (aziendaById == null) {
				aziendaById = new TaifTAziendaDto();
			}
			return aziendaById;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAziendaById] END");
		}
	}

	public AnagraficaAziendale getAnagraficaAziendale(Integer idAzienda, String tracciato) throws DbManagerException {
		log.debug("[DbMgr::getAnagraficaAziendale] BEGIN");
		try {

			BeAnagraficaAziendaleDto beAnagraficaDto = new BeAnagraficaAziendaleDto();
			AnagraficaAziendale anagraficaAziendale = new AnagraficaAziendale();

			TaifTAziendaDto aziendaBe = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));

			beAnagraficaDto.setIdAzienda(aziendaBe.getIdAzienda());
			beAnagraficaDto.setDescrizione(aziendaBe.getDescrAltraFormaGiuridica());
			beAnagraficaDto.setRagioneSociale(aziendaBe.getRagioneSociale());
			beAnagraficaDto.setNote(aziendaBe.getDescrAltraFormaGiuridica());
			beAnagraficaDto.setEmail(aziendaBe.getEmail()); // ragioneSociale
			if (tracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.fLang)) {
				beAnagraficaDto.setIdFormaGiurdica(aziendaBe.getFkFormaGiuridicaFra().toString());
				beAnagraficaDto.setPartitaIva(aziendaBe.getNTva());
				beAnagraficaDto.setCodiceFiscale(aziendaBe.getNSiret());
				beAnagraficaDto.setIdAttivitaPrimaria(aziendaBe.getFkAttivitaApe().toString());
			} else {
				beAnagraficaDto.setIdFormaGiurdica(aziendaBe.getFkFormaGiuridicaIta().toString());
				beAnagraficaDto.setCodiceFiscale(aziendaBe.getCodiceFiscale());
				beAnagraficaDto.setPartitaIva(aziendaBe.getPartitaIva());
				beAnagraficaDto.setIdAttivitaSecondaria(aziendaBe.getFkAttivitaSecondaria().toString());
				beAnagraficaDto.setIdAttivitaPrimaria(aziendaBe.getFkAttivitaPrimaria().toString());
				beAnagraficaDto.setIdProvinciaCCIAA(aziendaBe.getCciaaSiglaProv());
				beAnagraficaDto.setNumeroCCIAA(aziendaBe.getCciaaNumero());
				beAnagraficaDto.setPec(aziendaBe.getPec());
				beAnagraficaDto.setMarcaDaBollo(aziendaBe.getNMarcaBollo());
			}
			// sedeAzienda
			List<TaifTSedeAziendaByIdAziendaDto> sedeAziendaList = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
			for (TaifTSedeAziendaByIdAziendaDto taifTSedeAziendaByIdAziendaDto : sedeAziendaList) {
				if (taifTSedeAziendaByIdAziendaDto.getIdTipo() == Constants.oneInt) {
					beAnagraficaDto.setTelefono(taifTSedeAziendaByIdAziendaDto.getTelefon());
					beAnagraficaDto.setCellulare(taifTSedeAziendaByIdAziendaDto.getCellulare());
				}
			}
			beAnagraficaDto.setSitoInternet(aziendaBe.getSitoWeb());
			anagraficaAziendale = dozerBeanMapper.map(beAnagraficaDto, AnagraficaAziendale.class);
			return anagraficaAziendale;

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAnagraficaAziendale] END");
		}
	}

	public BeAnagraficaAziendaleDto getAnagraficaAziendaleFeToBe(AnagraficaAziendale anagraficaAziendale)
			throws DbManagerException {
		log.debug("[DbMgr::getAnagraficaAziendale] BEGIN");
		try {

			BeAnagraficaAziendaleDto beAnagraficaDto = new BeAnagraficaAziendaleDto();

			beAnagraficaDto = dozerBeanMapper.map(anagraficaAziendale, BeAnagraficaAziendaleDto.class);

			return beAnagraficaDto;

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAnagraficaAziendale] END");
		}
	}

	public ArrayList<Sede> getListSedePerAzienda(Integer idAzienda) throws DbManagerException {

		log.debug("[DbMgr::getSedePerAzienda] BEGIN");

		List<Sede> sedeList = new ArrayList<Sede>();
		List<BeSedeDto> beSedeSource = new ArrayList<BeSedeDto>();

		try {

			List<TaifTSedeAziendaByIdAziendaDto> sediAzienda = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
			for (TaifTSedeAziendaByIdAziendaDto taifTSedeAziendaDto : sediAzienda) {
				BeSedeDto sedeBeDto = new BeSedeDto();
				sedeBeDto.setIdSede(taifTSedeAziendaDto.getId());
				sedeBeDto.setIdTipoSede(taifTSedeAziendaDto.getIdTipo());
				sedeBeDto.setDescrizioneComune(taifTSedeAziendaDto.getComune());
				sedeBeDto.setDescrizioneTipoSede(taifTSedeAziendaDto.getTipoSede());
				sedeBeDto.setCap(taifTSedeAziendaDto.getCap());
				sedeBeDto.setIndirizzo(taifTSedeAziendaDto.getIndirizzo());
				sedeBeDto.setNumeroCivico(taifTSedeAziendaDto.getCivico());
				if (taifTSedeAziendaDto.getTelefon() != null) {
					sedeBeDto.setTelefono(taifTSedeAziendaDto.getTelefon());
				}
				if (taifTSedeAziendaDto.getCellulare() != null) {
					sedeBeDto.setCellulare(taifTSedeAziendaDto.getCellulare());
				}
				if (taifTSedeAziendaDto.getEstero() != null) {
					sedeBeDto.setDescrizioneComune(taifTSedeAziendaDto.getEstero());
				}
				sedeBeDto.setIstatComuneSede(taifTSedeAziendaDto.getIstatComune());

				beSedeSource.add(sedeBeDto);

			}
			for (BeSedeDto sedeTransf : beSedeSource) {
				sedeList.add(dozerBeanMapper.map(sedeTransf, Sede.class));
			}
			return (ArrayList<Sede>) sedeList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getSedePerAzienda] END");
		}

	}

	public List<BeSedeDto> getListSedePerAziendaFeToBe(ArrayList<Sede> feSedeList) throws DbManagerException {

		log.debug("[DbMgr::getListSedePerAziendaFeToBe] BEGIN");
		List<BeSedeDto> beSedeDestination = new ArrayList<BeSedeDto>();

		try {
			for (Sede sedeSource : feSedeList) {
				beSedeDestination.add(dozerBeanMapper.map(sedeSource, BeSedeDto.class));
			}
			return beSedeDestination;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getListSedePerAziendaFeToBe] END");
		}

	}

	public List<Sede> getListSedePerAziendaBeToFe(ArrayList<BeSedeDto> backSedeList) throws DbManagerException {

		log.debug("[DbMgr::getListSedePerAziendaBeToFe] BEGIN");

		List<Sede> sedeList = new ArrayList<Sede>();
		try {
			for (BeSedeDto beSedeDto : backSedeList) {
				sedeList.add(dozerBeanMapper.map(beSedeDto, Sede.class));
			}
			return sedeList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getListSedePerAziendaBeToFe] END");
		}

	}

	public TitolareRappresentanteLegale getTitolareRappresentanteLegalePerAzienda(Integer idAzienda,
			RuoloFilter ruoloFilter) throws DbManagerException {

		log.debug("[DbMgr::getTitolareRappresentanteLegalePerAzienda] BEGIN");

		TitolareRappresentanteLegale titolareLegale = new TitolareRappresentanteLegale();
		BeTitolareRappresentanteLegaleDto beTitolareLegale = new BeTitolareRappresentanteLegaleDto();
		int idPersona = 0;
		try {

			List<TaifRPersonaAziendaByIdAziendaDto> personaAziendaDtoList = taifRPersonaAziendaDao
					.findByIdAzienda(idAzienda);

			int idRuoloLegale = getIdRuolo(ruoloFilter);
			for (TaifRPersonaAziendaByIdAziendaDto persAziendaDto : personaAziendaDtoList) {
				if (persAziendaDto.getIdRuolo() == idRuoloLegale) {
					idPersona = persAziendaDto.getId();
				}
			}
			// dozer da TaifTPersonaDto a BeTitolareRappresentanteLegaleDto
			TaifTPersonaDto personaFind = taifTPersonaDao.findByPrimaryKey(new TaifTPersonaPk(idPersona));

			beTitolareLegale.setCodiceFiscale(personaFind.getCodiceFiscale());
			beTitolareLegale.setCognome(personaFind.getCognome());
			beTitolareLegale.setNome(personaFind.getNome());
			beTitolareLegale.setDataNascita(personaFind.getDataNascita().toString());
			beTitolareLegale.setIdStatoNascita(personaFind.getComuneEsteroNascita()); // stato nascita
			beTitolareLegale.setIdComuneNascita(personaFind.getIstatComuneNascita());
			beTitolareLegale.setIdComuneResidenza(personaFind.getIstatComuneRes());
			beTitolareLegale.setCap(personaFind.getCapRes());
			beTitolareLegale.setCivico(personaFind.getCivicoRes());
			beTitolareLegale.setTelefono(personaFind.getTelefono());
			beTitolareLegale.setEmail(personaFind.getMail());
			beTitolareLegale.setIdTitoloDiStudio(personaFind.getFkTitoloStudio().toString());
			beTitolareLegale.setAltriStudi(personaFind.getAltriStudi());

			titolareLegale = dozerBeanMapper.map(beTitolareLegale, TitolareRappresentanteLegale.class);

			return titolareLegale;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTitolareRappresentanteLegalePerAzienda] END");
		}

	}

	// getTitolareRappresentanteLegalePerAziendaFeToBe
	public BeTitolareRappresentanteLegaleDto getTitolareRappresentanteLegalePerAziendaFeToBe(
			TitolareRappresentanteLegale titolare) throws DbManagerException {

		log.debug("[DbMgr::getTitolareRappresentanteLegalePerAziendaFeToBe] BEGIN");
		BeTitolareRappresentanteLegaleDto beTitolareLegale = new BeTitolareRappresentanteLegaleDto();
		try {
			beTitolareLegale = dozerBeanMapper.map(titolare, BeTitolareRappresentanteLegaleDto.class);
			return beTitolareLegale;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTitolareRappresentanteLegalePerAziendaFeToBe] END");
		}

	}
	// getTitolareRappresentanteLegalePerAziendaFeToBe

	public Integer salvaDatiAziendali(Integer idAzienda, BeAnagraficaAziendaleDto backAnagraficaAziendale,
			List<BeSedeDto> backSediList, Albo albo, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			String dataTracciato, boolean existesezione11) throws DbManagerException {

		log.debug("[DbMgr::salvaDatiAziendali] BEGIN");
		Integer result = idAzienda;
		TaifTAziendaDto taifTAziendaInsert = new TaifTAziendaDto();

		TaifTSedeAziendaDto taifSedeAziendaInsert;
		List<TaifTSedeAziendaDto> listTaifSedeAziendaInsert = new ArrayList<TaifTSedeAziendaDto>();
		UserTransaction utx = txManager.getUserTransaction();

		try {
			utx.begin();
			if (idAzienda != null) {
				if (existesezione11) {
					updateDatiAziendaSedeByIdAzienda(idAzienda, backAnagraficaAziendale, backSediList, albo,
							profiloUtente.getIdConfigUtente(), dataTracciato);
				}
			} else {
				// insert
				taifTAziendaInsert = dozerBeanMapper.map(backAnagraficaAziendale, TaifTAziendaDto.class);

				taifTAziendaInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				taifTAziendaInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				taifTAziendaInsert.setFkConfigUtente(profiloUtente.getIdConfigUtente());
				if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
					taifTAziendaInsert
							.setFkFormaGiuridicaFra(Integer.parseInt(backAnagraficaAziendale.getIdFormaGiurdica()));
					taifTAziendaInsert.setFkFormaGiuridicaIta(new Integer(0));
					taifTAziendaInsert.setNSiret(taifTAziendaInsert.getCodiceFiscale());
					taifTAziendaInsert.setNTva(backAnagraficaAziendale.getPartitaIva());
					taifTAziendaInsert.setFkAttivitaApe(taifTAziendaInsert.getFkAttivitaPrimaria());
					taifTAziendaInsert.setFkAttivitaPrimaria(getCodiceAttivitaApe(Constants.nessunDatoAttivita));
					taifTAziendaInsert.setFkAttivitaSecondaria(getCodiceAttivitaApe(Constants.nessunDatoAttivita));
					taifTAziendaInsert.setCodiceFiscale(null);
					taifTAziendaInsert.setPartitaIva(null);
				} else {
					if (taifTAziendaInsert.getFkAttivitaSecondaria() == null) {
						taifTAziendaInsert.setFkAttivitaSecondaria(getCodiceAttivitaApe(Constants.nessunDatoAttivita));
					}
					taifTAziendaInsert.setFkAttivitaApe(getCodiceAttivitaApe(Constants.nessunDatoAttivita));
					taifTAziendaInsert
							.setFkFormaGiuridicaIta(Integer.parseInt(backAnagraficaAziendale.getIdFormaGiurdica()));
					taifTAziendaInsert.setFkFormaGiuridicaFra(new Integer(0));
					taifTAziendaInsert.setNSiret(null);
					taifTAziendaInsert.setNTva(null);
				}

				TaifTAziendaPk idAziendaInsert = taifTAziendaDao.insert(taifTAziendaInsert);
				result = idAziendaInsert.getIdAzienda();

				TaifTPraticaDto taifTPratica = new TaifTPraticaDto();

				taifTPratica.setFkSoggettoGestore(albo.getIdAlbo());
				taifTPratica.setNumeroAlbo(Constants.blank);
				taifTPratica.setFkAzienda(result);
				String istatComune = Constants.blank;
				for (BeSedeDto sede : backSediList) {
					if (sede.getIdTipoSede() == Constants.oneInt) {
						istatComune = sede.getIstatComuneSede();
					}
				}
				if (getControllSedeIstat(istatComune, albo.getIdAlbo())) {
					taifTPratica.setFlgSezione(Constants.aChar);
				} else {
					taifTPratica.setFlgSezione(Constants.bChar);
				}

				taifTPratica.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				taifTPratica.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				taifTPratica.setFkConfigUtente(profiloUtente.getIdConfigUtente());
				taifTPratica.setDenominazioneAltroAlbo(getCodiceSoggetto(Integer.valueOf(Constants.zero)));
				TaifTPraticaPk taifPraticaPk = taifTPraticaDao.insert(taifTPratica);

				// // Per questioni di praticita' contestualmente alla creazione di una pratica,
				// si
				// // crea anche
				// // la root su Index
				// this.getServiceMgr().indexCreateRootFolder(profiloUtente.getIdPersona(),
				// result, taifPraticaPk.getIdPratica());
				// //
				TaifApplSchedaOkDto taifApplSchedaOkDto = new TaifApplSchedaOkDto();
				taifApplSchedaOkDto.setIdAzienda(result);
				if (dataTracciato.equals(Constants.iLang)) {
					taifApplSchedaOkDto.setFlgSez11ItaOk(new BigDecimal(Constants.one));
					taifApplSchedaOkDto.setFlgSez11FraOk(new BigDecimal(Constants.zero));

				} else {
					taifApplSchedaOkDto.setFlgSez11FraOk(new BigDecimal(Constants.one));
					taifApplSchedaOkDto.setFlgSez11ItaOk(new BigDecimal(Constants.zero));
				}
				taifApplSchedaOkDto.setFlgSez12ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez12FraOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez21ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez22ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez31ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez32ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez33ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez4ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez51ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez52ItaOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez6ItaOk(new BigDecimal(Constants.zero));

				taifApplSchedaOkDto.setFlgSez21FraOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez22FraOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez31FraOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez33FraOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez4FraOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez52FraOk(new BigDecimal(Constants.zero));
				taifApplSchedaOkDto.setFlgSez6FraOk(new BigDecimal(Constants.zero));

				taifApplSchedaOkDao.insert(taifApplSchedaOkDto);

				// taifPraticaPk

				// bozza
				statoPraticaFilter.setFlagVisibile(Integer.parseInt(Constants.one));
				statoPraticaFilter.setFlagItaFr(dataTracciato);
				if (dataTracciato.equalsIgnoreCase(Constants.iLang)) {
					statoPraticaFilter.setStatoPraticaLang(Constants.bozza);
				} else {
					statoPraticaFilter.setStatoPraticaLang(Constants.ebauche);
				}

				Integer idStatoPraticaBozza = getStatoPratica(statoPraticaFilter);

				TaifTStoricoStatoDto storicoStato = new TaifTStoricoStatoDto();
				storicoStato.setIdPratica(taifPraticaPk.getIdPratica());
				storicoStato.setFkConfigUtente(profiloUtente.getIdConfigUtente());
				storicoStato.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				storicoStato.setDataInserimentoStato(new Timestamp(System.currentTimeMillis()));
				storicoStato.setFkStatoPratica(idStatoPraticaBozza);

				taifTStoricoStatoDao.insert(storicoStato);

				if (backSediList.size() > 0) {
					if (idAziendaInsert != null && idAziendaInsert.getIdAzienda() != null) {
						for (BeSedeDto backSedeIns : backSediList) {
							taifSedeAziendaInsert = new TaifTSedeAziendaDto();
							taifSedeAziendaInsert = dozerBeanMapper.map(backSedeIns, TaifTSedeAziendaDto.class);
							// modifica Enrico 15-01-2019
							if (dataTracciato.equals(Constants.iLang)) {
								taifSedeAziendaInsert.setIstatComune(backSedeIns.getIstatComuneSede());
							} else {
								taifSedeAziendaInsert.setComuneEstero(backSedeIns.getDescrizioneComune());
							}
							taifSedeAziendaInsert.setFkAzienda(idAziendaInsert.getIdAzienda());
							taifSedeAziendaInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							taifSedeAziendaInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
							taifSedeAziendaInsert.setFkConfigUtente(profiloUtente.getIdConfigUtente());
							listTaifSedeAziendaInsert.add(taifSedeAziendaInsert);
						}
					}
					for (TaifTSedeAziendaDto taifTSedeAziendaDto : listTaifSedeAziendaInsert) {
						taifTSedeAziendaDao.insert(taifTSedeAziendaDto);
					}
				}
			}
			utx.commit();
		} catch (DaoException e) {
			try {
				result = null;
				utx.rollback();
				log.info("[DbMgr::salvaDatiAziendali] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaDatiAziendali] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} catch (Exception ro) {
			throw new DbManagerException(ro, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaDatiAziendali] END");
		}

		log.debug("[DbMgr::salvaDatiAziendali] END");
		return result;

	}
	// 1.2

	private static boolean getControllSedeIstat(String istatComune, int idAlbo) {

		String[] sourceArrayPiemonte = { "001", "002", "003", "004", "005", "006", "096", "103" };
		String[] sourceArrayLiguria = { "008", "009", "003", "010", "011" };
		String[] sourceArrayAosta = { "007" };
		String[] sourceArrayFrancese = { null };
		List<String> targetList = new ArrayList<String>();

		Integer[] sourceArraySoggetto = { 1, 2, 3 };
		List<Integer> soggettoList = new ArrayList<Integer>(Arrays.asList(sourceArraySoggetto));

		switch (idAlbo) {
		case 1:
			targetList = new ArrayList<String>(Arrays.asList(sourceArrayPiemonte));
			break;
		case 2:
			targetList = new ArrayList<String>(Arrays.asList(sourceArrayLiguria));
			break;
		case 3:
			targetList = new ArrayList<String>(Arrays.asList(sourceArrayAosta));
			break;
		case 4:
			targetList = new ArrayList<String>(Arrays.asList(sourceArrayFrancese));
			break;
		case 5:
			targetList = new ArrayList<String>(Arrays.asList(sourceArrayFrancese));
			break;
		default:
			break;
		}

		boolean result = false;
		for (Integer idSoggetto : soggettoList) {
			if (idSoggetto == idAlbo) {
				if (targetList.contains(istatComune.substring(0, 3))) {
					result = true;
				}
			}
			if (idAlbo == 4 || idAlbo == 5) {
				result = true;
			}
		}
		return result;
	}

	public void salvaTitolareRappresentanteLegale(Integer idAzienda,
			BeTitolareRappresentanteLegaleDto backTitolareLegale, BeTitolareRappresentanteLegaleDto backAltroTitolare,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, TitolareRappresentanteLegale altroTitolare,
			String esisteConduttore, String dataTracciato) throws ManagerException {

		log.info("[DbMgr::salvaTitolareRappresentanteLegale] BEGIN");

		TaifRPersonaAziendaDto personaAzienda = new TaifRPersonaAziendaDto();
		TaifRPersonaAziendaDto personaAziendaC = new TaifRPersonaAziendaDto();
		TaifApplSchedaOkDto taifApplSchedaOkDto = new TaifApplSchedaOkDto();
		UserTransaction utx = txManager.getUserTransaction();
		idConfigUtente = profiloUtente.getIdConfigUtente();

		try {
			utx.begin();
			if (backTitolareLegale != null) {
				TaifTPersonaDto personaToSave = new TaifTPersonaDto();

				personaToSave = dozerBeanMapper.map(backTitolareLegale, TaifTPersonaDto.class);
				if (dataTracciato.equals(Constants.iLang)) {
					log.info("[DbMgr::salvaTitolareRappresentanteLegale]ilang getIdStatoNascita" + backTitolareLegale.getIdStatoNascita());
					personaToSave.setFkTitoloStudioFra(Integer.parseInt(Constants.zero));
					personaToSave.setFkTitoloStudio(Integer.parseInt(backTitolareLegale.getIdTitoloDiStudio()));
					if( backTitolareLegale.getIdStatoNascita().equals(Constants.one)) {
						log.info("[DbMgr::salvaTitolareRappresentanteLegale]ilang getIdComuneNascita" + backTitolareLegale.getIdComuneNascita());
						personaToSave.setIstatComuneNascita(backTitolareLegale.getIdComuneNascita());
					} else {
						log.info("[DbMgr::salvaTitolareRappresentanteLegale]ilang getDsComuneNascitaNoIta" + backTitolareLegale.getDsComuneNascitaNoIta());
						personaToSave.setComuneEsteroNascita(backTitolareLegale.getDsComuneNascitaNoIta()); 
					}
					personaToSave.setIstatComuneRes(backTitolareLegale.getIdComuneResidenza());
				} else {
					log.info("[DbMgr::salvaTitolareRappresentanteLegale] not ilang getIdStatoNascita" + backTitolareLegale.getIdStatoNascita());
					personaToSave.setFkTitoloStudioFra(Integer.parseInt(backTitolareLegale.getIdTitoloDiStudio()));
					personaToSave.setFkTitoloStudio(Integer.parseInt(Constants.zero));
					personaToSave.setComuneEsteroNascita(backTitolareLegale.getDsComuneNascitaNoIta()); 
					personaToSave.setComuneEsteroRes(backTitolareLegale.getIdComuneResidenza());
				}

				personaToSave.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				personaToSave.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				TaifTPersonaPk idLegaleRapp = taifTPersonaDao.insert(personaToSave);

				personaAzienda.setIdAzienda(idAzienda);
				personaAzienda.setIdPersona(idLegaleRapp.getIdPersona());
				personaAzienda.setFkRuolo(Constants.oneInt); // legalerappresentante
				personaAzienda.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				personaAzienda.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				personaAzienda.setFkConfigUtente(idConfigUtente);
				personaAzienda.setFkTipoMansione(getCodiceMansione(getMansioneFilterNessunDato(dataTracciato)));
				personaAzienda.setFkTipoContratto(Integer.parseInt(Constants.zero));
				personaAzienda.setFkTipoInquadramento(getCodiceInquadramento(getInquadramentoFilterNessunDato()));

				taifRPersonaAziendaDao.insert(personaAzienda);
			}
			// gestione Conduttore
			if (dataTracciato.equals(Constants.iLang)) {
				if (esisteConduttore.equals(Constants.NO)) {
					TaifTPersonaDto personaToSaveC = new TaifTPersonaDto();

					// List<TaifTPersonaByCodiceFiscalePersonaDto> conduttoreCodiceFiscale = new
					// ArrayList<TaifTPersonaByCodiceFiscalePersonaDto>();
					// conduttoreCodiceFiscale =
					// findPersonaPerCodiceFiscale(altroTitolare.getCodiceFiscale());

					PersonaFilter personaFilter = new PersonaFilter();
					if (altroTitolare.getCodiceFiscale() != null
							&& StringUtils.isNotEmpty(altroTitolare.getCodiceFiscale())) {
						personaFilter.setCodiceFiscale(altroTitolare.getCodiceFiscale());
					}
					if (altroTitolare.getNrsiMsa() != null && StringUtils.isNotEmpty(altroTitolare.getNrsiMsa())) {
						personaFilter.setnRsimsa(altroTitolare.getNrsiMsa());
					}
					
						personaFilter.setIdNazione(ConvertUtil.toInteger(altroTitolare.getIdStatoNascita()));
					
				
					List<TaifTPersonaByFilterDto> conduttoreCodiceFiscale = findPersonaByFilter(personaFilter);

					if (conduttoreCodiceFiscale != null && !conduttoreCodiceFiscale.isEmpty()) {
						updateTitolareRappresentanteLegale(idAzienda, altroTitolare, conduttoreCodiceFiscale,
								profiloUtente, dataTracciato, 1);
					} else {
						personaToSaveC = dozerBeanMapper.map(backAltroTitolare, TaifTPersonaDto.class);
						personaToSaveC.setAltriStudi(backAltroTitolare.getAltriStudi());
						if (dataTracciato.equals(Constants.iLang)) {
							personaToSaveC.setFkTitoloStudioFra(Integer.parseInt(Constants.zero));
							personaToSaveC
									.setFkTitoloStudio(Integer.parseInt(backAltroTitolare.getIdTitoloDiStudio()));
						} else {
							personaToSaveC
									.setFkTitoloStudioFra(Integer.parseInt(backAltroTitolare.getIdTitoloDiStudio()));
							personaToSaveC.setFkTitoloStudio(Integer.parseInt(Constants.zero));
						}
						
						//taif-23
						if(altroTitolare.getIdStatoNascita().equalsIgnoreCase(Constants.one)) {
							personaToSaveC.setIstatComuneNascita(altroTitolare.getIdComuneNascita());
						} else {
							personaToSaveC.setComuneEsteroNascita(altroTitolare.getDsComuneNascitaNoIta());
						}

						personaToSaveC.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						personaToSaveC.setDataInserimento(new Timestamp(System.currentTimeMillis()));

						TaifTPersonaPk idConduttore = taifTPersonaDao.insert(personaToSaveC);

						personaAziendaC.setIdAzienda(idAzienda);
						personaAziendaC.setIdPersona(idConduttore.getIdPersona());
						personaAziendaC.setFkRuolo(Constants.twoInt);
						personaAziendaC.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						personaAziendaC.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));

						personaAziendaC
								.setFkTipoMansione(getCodiceMansione(getMansioneFilterNessunDato(dataTracciato)));
						personaAziendaC
								.setFkTipoContratto(getCodiceContratto(getContrattoFilterContrattoComm(dataTracciato)));
						personaAziendaC
								.setFkTipoInquadramento(getCodiceInquadramento(getInquadramentoFilterNessunDato()));

						personaAziendaC.setFkConfigUtente(idConfigUtente);
						
						
						taifRPersonaAziendaDao.insert(personaAziendaC);
					}
				}
			}
			taifApplSchedaOkDto = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (dataTracciato.equals(Constants.iLang)) {
				taifApplSchedaOkDto.setFlgSez12ItaOk(new BigDecimal(Constants.one));
				taifApplSchedaOkDto.setFlgSez12FraOk(new BigDecimal(Constants.zero));

			} else {
				taifApplSchedaOkDto.setFlgSez12FraOk(new BigDecimal(Constants.one));
				taifApplSchedaOkDto.setFlgSez12ItaOk(new BigDecimal(Constants.zero));
			}
			taifApplSchedaOkDao.update(taifApplSchedaOkDto);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaTitolareRappresentanteLegale] END");
		}

		log.debug("[DbMgr::salvaTitolareRappresentanteLegale] END");
	}

	private BeTitolareRappresentanteLegaleDto getIdNazioneFromStatoNascita(
			BeTitolareRappresentanteLegaleDto backTitolareLegale) {
		switch (Integer.parseInt(backTitolareLegale.getIdStatoNascita())) {
		case 1:
			backTitolareLegale.setIdNazione(Constants.one);
			break;
		case 2:
			backTitolareLegale.setIdNazione(Constants.two);
			break;
		case 5:
			backTitolareLegale.setIdNazione(Constants.four);
			break;
		default:
			backTitolareLegale.setIdNazione(Constants.three);
		}
		return backTitolareLegale;
	}

	/*
	 * public String getNazioneFromId(int idNazione) { String resultNazione;
	 * 
	 * switch(idNazione) { case 1 : resultNazione= Constants.iLang; break; case 2 :
	 * resultNazione= Constants.fLang; break; default : resultNazione=
	 * Constants.iLang; } return resultNazione; }
	 */
	// be to fe
	public ArrayList<CategoriaImpresa> getCategoriaImpresa(Integer idAzienda) throws DbManagerException {

		log.debug("[DbMgr::getElencoCategorieImpresa] BEGIN");

		ArrayList<CategoriaImpresa> categoriaImpresaList = new ArrayList<CategoriaImpresa>();
		TaifDCategoriaImpresaDto categImpresaDto = new TaifDCategoriaImpresaDto();
		CategoriaImpresa categoriaImpresaSource = new CategoriaImpresa();

		try {

			List<TaifRAziendaCategImpresaByIdAziendaDto> azCategImpresa = taifRAziendaCategImpresaDao
					.findByIdAzienda(idAzienda);

			for (TaifRAziendaCategImpresaByIdAziendaDto taifRAzienda : azCategImpresa) {
				categoriaImpresaSource = new CategoriaImpresa();
				categImpresaDto = taifDCategoriaImpresaDao
						.findByPrimaryKey(new TaifDCategoriaImpresaPk(taifRAzienda.getIdcategImpresa()));
				if (categImpresaDto.getIdCategoria() == 5 || categImpresaDto.getIdCategoria() == 10) {
					categoriaImpresaSource.setAltroVisibile(true);
					categoriaImpresaSource.setAltro(taifRAzienda.getAziendaCategImpresa());
				} else {
					categoriaImpresaSource.setAltroVisibile(false);
					categoriaImpresaSource.setAltro("");
				}
				categoriaImpresaSource.setIdCategoria(categImpresaDto.getIdCategoria());
				categoriaImpresaSource.setDsCategoria(categImpresaDto.getCategoriaImpresa());

				categoriaImpresaList.add(categoriaImpresaSource);
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaDatiAziendali] END");
		}

		return categoriaImpresaList;

	}

	public List<BeCategoriaImpresaDto> getCategoriaImpresaFeToBe(ArrayList<CategoriaImpresa> listCatImpresa)
			throws DbManagerException {

		log.debug("[DbMgr::getCategoriaImpresaFeToBe] BEGIN");
		List<BeCategoriaImpresaDto> beCategoriaImpresaList = new ArrayList<BeCategoriaImpresaDto>();
		try {
			for (CategoriaImpresa catImpresa : listCatImpresa) {
				beCategoriaImpresaList.add(dozerBeanMapper.map(catImpresa, BeCategoriaImpresaDto.class));
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCategoriaImpresaFeToBe] END");
		}
		return beCategoriaImpresaList;
	}

	public void salvaFatturatoECategorieImpresa(Integer idAzienda, List<CategoriaImpresa> elencoCategorieImpresa,
			BeFatturatoCategorieDiImpresaDto fatturato, List<BeCategoriaImpresaDto> backCategoriaImpresaList,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String impresaSelezionalta,
			FatturatoCategorieDiImpresa fatturatoCategorieDiImpresa, String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaFatturatoECategorieImpresa] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		double valueFatturato = 0.0;
		idConfigUtente = profiloUtente.getIdConfigUtente();

		try {
			utx.begin();
			if (idAzienda != null) {
				// update azienda
				List<TaifTPraticaDto> praticaUpdateList = new ArrayList<TaifTPraticaDto>();
				TaifTPraticaDto pratica = new TaifTPraticaDto();
				TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
				aziendaToUpdate.setAnnoInizio(new BigDecimal(Integer.parseInt(fatturato.getAnnoInizioAttivita())));
				String fatturatoStr = fatturato.getFatturatoUltimoAnno();
				valueFatturato = StringUtils.stringToDouble(fatturatoStr);
				aziendaToUpdate.setFatturato(new BigDecimal(valueFatturato));
				aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				aziendaToUpdate.setFkConfigUtente(idConfigUtente); // from session
				taifTAziendaDao.update(aziendaToUpdate);
				// pratica
				List<TaifTPraticaByIdAziendaDto> praticaToUpdateList = taifTPraticaDao.findByIdAzienda(idAzienda);
				for (TaifTPraticaByIdAziendaDto praticaToUpdate : praticaToUpdateList) {
					//praticaToUpdate.setFlagSezione(Constants.aChar);
					praticaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					praticaToUpdate.setFkConfigUtente(idConfigUtente);
					pratica = dozerBeanMapper.map(praticaToUpdate, TaifTPraticaDto.class);
					pratica.setDataIscrizioneAlbo(praticaToUpdate.getDataInscrizioneAlbo());
					pratica.setDataPresentazione(praticaToUpdate.getDataPresentazione());
					praticaUpdateList.add(pratica);
				}
				for (TaifTPraticaDto taifPratica : praticaUpdateList) {
					taifPratica.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					taifPratica.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					taifTPraticaDao.update(taifPratica);
				}

				// taifTpratica

				// R_AZIENDA_CATEGIMPRESA
				List<TaifRAziendaCategImpresaByIdAziendaDto> aziendaCategList = taifRAziendaCategImpresaDao
						.findByIdAzienda(idAzienda);
				List<TaifRAziendaCategImpresaDto> azCatList = new ArrayList<TaifRAziendaCategImpresaDto>();
				if (aziendaCategList.size() == 0) {
					// AziendaCategoria
					TaifRAziendaCategImpresaByIdAziendaDto rCategImpressaDto = new TaifRAziendaCategImpresaByIdAziendaDto();
					for (BeCategoriaImpresaDto backCatImpresa : backCategoriaImpresaList) {
						rCategImpressaDto.setIdAzienda(idAzienda);
						rCategImpressaDto.setIdcategImpresa(backCatImpresa.getIdCategoria());
						if (backCatImpresa.getIdCategoria() == Constants.five
								|| backCatImpresa.getIdCategoria() == Constants.ten) {
							// rCategImpressaDto.setAziendaCategImpresa(fatturato.getAltro());
							rCategImpressaDto.setAziendaCategImpresa(fatturatoCategorieDiImpresa.getAltro());
						}
						rCategImpressaDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						rCategImpressaDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						rCategImpressaDto.setFkConfigUtente(idConfigUtente);
						azCatList.add(dozerBeanMapper.map(rCategImpressaDto, TaifRAziendaCategImpresaDto.class));
					}
					for (TaifRAziendaCategImpresaDto taifRAziendaCategImpresaDto : azCatList) {
						taifRAziendaCategImpresaDao.insert(taifRAziendaCategImpresaDto);
					}

				} else {
					for (TaifRAziendaCategImpresaByIdAziendaDto rAziendaCat : aziendaCategList) {
						for (BeCategoriaImpresaDto backCatImpresa : backCategoriaImpresaList) {
							if (backCatImpresa.getIdCategoria() == rAziendaCat.getIdcategImpresa()) {
								rAziendaCat.setIdAzienda(idAzienda);
								rAziendaCat.setIdcategImpresa(backCatImpresa.getIdCategoria());
								if (backCatImpresa.getDsCategoria() != null) {
									rAziendaCat.setAziendaCategImpresa(backCatImpresa.getDsCategoria());
								}
								// rAziendaCat.setDataInserimento(new Timestamp(System.currentTimeMillis()));
								rAziendaCat.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								rAziendaCat.setFkConfigUtente(idConfigUtente);

								azCatList.add(dozerBeanMapper.map(rAziendaCat, TaifRAziendaCategImpresaDto.class));
							}
						}
					}
					for (TaifRAziendaCategImpresaDto taifRAziendaCategImpresaDto : azCatList) {
						taifRAziendaCategImpresaDao.update(taifRAziendaCategImpresaDto);
					}
				}
				// R_AZIENDA_ASSOCIAZIONI
				TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao
						.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
				if (taifTaifAppl != null) {
					if (dataTracciato.contentEquals(Constants.fLang)) {
						taifTaifAppl.setFlgSez21FraOk(new BigDecimal(Constants.one)); // if flag francese
						taifTaifAppl.setFlgSez21ItaOk(new BigDecimal(Constants.zero));
					} else {
						taifTaifAppl.setFlgSez21ItaOk(new BigDecimal(Constants.one));
						taifTaifAppl.setFlgSez21FraOk(new BigDecimal(Constants.zero)); // if flag francese
					}
					taifApplSchedaOkDao.update(taifTaifAppl);
				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaTitolareRappresentanteLegale] END");
		}

	}

	public void salvaAssociazoniECertificazioni(Integer idAzienda,
			List<TaifTPraticaByIdAziendaAlboDto> backTaifTPraticaByIdAzienda,
			ArrayList<FormaOrganizzativa> formeOrganizzative, List<BeFormaOrganizzativaDto> backAssociazione,
			List<TaifTCertificazioneElencoCertificazioniDto> backCertificazione,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String esisteAlbo, String esisteCertificazione,
			String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaAssociazoniECertificazioni] BEGIN");

		TaifTPraticaDto pratica = new TaifTPraticaDto();
		List<Integer> listIdFormeCheck = new ArrayList<Integer>();
		List<TaifTPraticaDto> praticaUpdateList = new ArrayList<TaifTPraticaDto>();
		List<TaifTCertificazioneDto> listCertificazioneToUpdate = new ArrayList<TaifTCertificazioneDto>();
		CertificazioneFilter certFilter = new CertificazioneFilter();
		UserTransaction utx = txManager.getUserTransaction();
		try {

			idConfigUtente = profiloUtente.getIdConfigUtente();

			utx.begin();
			if (idAzienda != null) {
				// 1.
				List<TaifRAziendaAssociazioneDto> azAsList = new ArrayList<TaifRAziendaAssociazioneDto>();
				for (BeFormaOrganizzativaDto assocOrganiz : backAssociazione) {
					if (assocOrganiz.getIdFormaOrganizzativa() == 0) {
						assocOrganiz.setDsFormaOrganizzativa(Constants.nessunMome);
					}
					listIdFormeCheck.add(assocOrganiz.getIdFormaOrganizzativa());
					azAsList.add(dozerBeanMapper.map(assocOrganiz, TaifRAziendaAssociazioneDto.class));
				}
				// for (TaifRAziendaAssociazioneDto taifRAziendaAssociazioneDto : azAsList) {
				for (FormaOrganizzativa assocOrganiz : formeOrganizzative) {
					if (listIdFormeCheck.contains(assocOrganiz.getIdFormaOrganizzativa())) {
						TaifRAziendaAssociazioneDto taifRAziendaAssociazioneDto = new TaifRAziendaAssociazioneDto();
						taifRAziendaAssociazioneDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						taifRAziendaAssociazioneDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						if (assocOrganiz.getAltro() != null && assocOrganiz.getAltroVisibile()) {
							taifRAziendaAssociazioneDto.setNome(assocOrganiz.getAltro());
						}
						taifRAziendaAssociazioneDto.setIdAzienda(idAzienda);
						taifRAziendaAssociazioneDto.setFkConfigUtente(idConfigUtente);
						taifRAziendaAssociazioneDto.setIdAssociazione(assocOrganiz.getIdFormaOrganizzativa());

						taifRAziendaAssociazioneDao.insert(taifRAziendaAssociazioneDto);
					}
				}

				// 2.(dal Albo)// backTaifTPraticaByIdAzienda-all albi inseriti]
				if (esisteAlbo != null && backTaifTPraticaByIdAzienda != null && esisteAlbo.equals(Constants.SI)) {
					for (TaifTPraticaByIdAziendaAlboDto taifTPraticaByIdAziendaAlboDto : backTaifTPraticaByIdAzienda) {
						insertAltraPratica(idAzienda, taifTPraticaByIdAziendaAlboDto);
					}
				}
				// 3.
				List<TaifTCertificazioneDto> certificazioneList = new ArrayList<TaifTCertificazioneDto>();
				if (esisteCertificazione != null && esisteCertificazione.equals(Constants.SI)
						&& backCertificazione != null) {
					for (TaifTCertificazioneElencoCertificazioniDto certifNewInsert : backCertificazione) {

						certFilter.setIdAzienda(idAzienda);
						certFilter.setTipoCertificazione(certifNewInsert.getFkTipoCertificazione());
						List<TaifTCertificazioneByAziendaTipoCertDto> certificazione = taifTCertificazioneDao
								.findByAziendaTipoCert(certFilter);
						if (certificazione.size() > 0) {
							for (TaifTCertificazioneByAziendaTipoCertDto certEsistente : certificazione) {
								// update ?
							}
						} else {
							certificazioneList.add(dozerBeanMapper.map(certifNewInsert, TaifTCertificazioneDto.class));
						}
					}
					for (TaifTCertificazioneDto certToInsert : certificazioneList) {

						certToInsert.setFkAzienda(idAzienda);
						certToInsert.setFkConfigUtente(idConfigUtente);
						certToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						certToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						taifTCertificazioneDao.insert(certToInsert);
					}

				}
				TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao
						.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
				if (taifTaifAppl != null) {
					if (dataTracciato.contentEquals(Constants.fLang)) {
						taifTaifAppl.setFlgSez22FraOk(new BigDecimal(Constants.one));
						taifTaifAppl.setFlgSez22ItaOk(new BigDecimal(Constants.zero));
					} else {
						taifTaifAppl.setFlgSez22ItaOk(new BigDecimal(Constants.one));
						taifTaifAppl.setFlgSez22FraOk(new BigDecimal(Constants.zero));
					}
					taifApplSchedaOkDao.update(taifTaifAppl);
				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaAssociazoniECertificazioni] END");
		}
	}

	// StatoPraticaFilter
	public Integer getStatoPratica(StatoPraticaFilter statoFilter) throws TaifDStatoPraticaDaoException {
		Integer result = null;
		if (statoFilter.getFlagItaFr().equals(Constants.iLang)) {
			List<TaifDStatoPraticaByFilterStatoPraticaItaDto> listStatoPratica = taifDStatoPraticaDao
					.findByFilterStatoPraticaIta(statoFilter);
			if (listStatoPratica != null) {
				result = listStatoPratica.get(0).getId().intValue();
			}
		} else {
			List<TaifDStatoPraticaByFilterStatoPraticaFraDto> listStatoPratica = taifDStatoPraticaDao
					.findByFilterStatoPraticaFra(statoFilter);
			if (listStatoPratica != null) {
				result = listStatoPratica.get(0).getId().intValue();
			}
		}
		return result;
	}

	public BeFatturatoCategorieDiImpresaDto getFatturatocategoriaFeToBe(FatturatoCategorieDiImpresa fatturato)
			throws DbManagerException {
		log.debug("[DbMgr::getFatturatocategoriaFeToBe] BEGIN");

		BeFatturatoCategorieDiImpresaDto beFatturatoImpresa = new BeFatturatoCategorieDiImpresaDto();

		try {
			beFatturatoImpresa = dozerBeanMapper.map(fatturato, BeFatturatoCategorieDiImpresaDto.class);
			return beFatturatoImpresa;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getFatturatocategoriaFeToBe] END");
		}
	}

	public FatturatoCategorieDiImpresa getFatturatocategoria(BeFatturatoCategorieDiImpresaDto fatturato)
			throws DbManagerException {
		log.debug("[DbMgr::getFatturatocategoria] BEGIN");

		FatturatoCategorieDiImpresa fatturatocategoria = new FatturatoCategorieDiImpresa();
		try {

			fatturatocategoria = dozerBeanMapper.map(fatturato, FatturatoCategorieDiImpresa.class);
			return fatturatocategoria;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getFatturatocategoria] END");
		}
	}

	public void salvaAttivitaUltimoAnno(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, Map<String, Boolean> attivitaMap,
			List<MaterialePropagazione> elencoMaterialePropagazione,
			ArrayList<ArboricolturaDaLegno> elencoArboricoltureLegno, List<String> idMaterialiPropagazione,
			String dataTracciato, String idTaglioUtilizzazioneRegione, String idTaglioPiopettiRegione,
			String idTaglioTagliIntervalariRegione, String idTaglioUtilizzazioneFuori, String idTaglioPiopettiFuori,
			String idTaglioTagliIntercalariFuori, MaterialePropagazione materialePropCinque) throws DbManagerException {
		log.debug("[DbMgr::salvaAttivitaUltimoAnno] BEGIN");

		List<TaifTAttivitaSvoltaDettDto> attivitaDettList = new ArrayList<TaifTAttivitaSvoltaDettDto>();
		List<TaifTAttivitaSvoltaDto> attivitaSvoltaList = new ArrayList<TaifTAttivitaSvoltaDto>();

		AttivitaUltimoAnno1 attivita1 = gestioneAttivitaUltimoAnno.getAttivita1();
		idConfigUtente = profiloUtente.getIdConfigUtente();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			// att1
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att1))
					&& gestioneAttivitaUltimoAnno.getAttivita1() != null) {
				insertAttivita1(idAzienda, gestioneAttivitaUltimoAnno, attivita1, idTaglioUtilizzazioneRegione,
						idTaglioPiopettiRegione, idTaglioTagliIntervalariRegione, idTaglioUtilizzazioneFuori,
						idTaglioPiopettiFuori, idTaglioTagliIntercalariFuori);
			}
			// att2

			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att2))
					&& gestioneAttivitaUltimoAnno.getAttivita2() != null) {

				if (gestioneAttivitaUltimoAnno.getAttivita2().getEttariRealizzati() != null
						&& gestioneAttivitaUltimoAnno.getAttivita2().getEttariRealizzati() != "") {
					insertAttivitaUltimoAnno2(idAzienda, gestioneAttivitaUltimoAnno);
				}
			}
			// att3
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att3))
					&& gestioneAttivitaUltimoAnno.getAttivita3() != null) {

				if (gestioneAttivitaUltimoAnno.getAttivita3().getRealizzazione() != null
						&& gestioneAttivitaUltimoAnno.getAttivita3().getRealizzazione() != "") {
					insertAttivitaUltimoAnno3(idAzienda, gestioneAttivitaUltimoAnno);
				}
			}
			// att4 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att4))
					&& gestioneAttivitaUltimoAnno.getAttivita4() != null) {
				TaifTAttivitaSvoltaDettDto attivitaSvoltaDett41 = new TaifTAttivitaSvoltaDettDto();
				TaifTAttivitaSvoltaDto attivitaSvolta41 = new TaifTAttivitaSvoltaDto();
				TaifRAttivDetMaterialeDto attivitamateriale;
				List<TaifRAttivDetMaterialeDto> attMatList = new ArrayList<TaifRAttivDetMaterialeDto>();

				List<MaterialePropagazione> materialePropagazioneList = elencoMaterialePropagazione; // gestioneAttivitaUltimoAnno.getAttivita4().getElencoMaterialiPropagazione();
				List<String> idMaterialePropagazioneAttivoList = idMaterialiPropagazione;
				if (idMaterialePropagazioneAttivoList.size() > 0) {
					AttivitaUltimoAnno4 attivita4 = gestioneAttivitaUltimoAnno.getAttivita4();

					attivitaSvolta41.setFkAzienda(idAzienda);
					attivitaSvolta41.setFkTipoAttivita(new Integer(Constants.fourInt));

					if (attivita4.getAltro() != null && attivita4.getAltro() != "") {
						attivitaSvolta41.setDescrAltreAttivita(attivita4.getAltro());
					}
					if (attivita4.getPercentuale() != null) {
						attivitaSvolta41.setPercFatturato(new BigDecimal(attivita4.getPercentuale()));
					}

					attivitaSvolta41.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitaSvolta41.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitaSvolta41.setFkConfigUtente(idConfigUtente);
					TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta41);

					attivitaSvoltaDett41.setFkUnitaDiMisura(getIdUnitaMisura(Constants.nessunDatoUnitaMisura));
					attivitaSvoltaDett41.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaDett41.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaDett41.setFkConfigUtente(idConfigUtente);
					attivitaSvoltaDett41.setIdAttivita(idAttSvolta.getIdAttivita());
					attivitaSvoltaDett41.setProgressivo(Constants.oneInt);

					TaifTAttivitaSvoltaDettPk idAttSvoltaDett = taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett41);

					for (MaterialePropagazione materialePropagazione : materialePropagazioneList) {
						for (String idMateriale : idMaterialePropagazioneAttivoList) {
							if (idMateriale
									.equals(String.valueOf(materialePropagazione.getIdMaterialePropagazione()))) {
								attivitamateriale = new TaifRAttivDetMaterialeDto();
								attivitamateriale.setIdMateriale(materialePropagazione.getIdMaterialePropagazione());
								if (materialePropagazione.getIdMaterialePropagazione() == Constants.sixInt) {
									log.info("SALVA ATTIVITA 4 materialePropagazione.getAltro():" + materialePropagazione.getAltro());
									log.info("SALVA ATTIVITA 4 elencoMaterialePropagazione.get(6).getAltro():" + elencoMaterialePropagazione.get(6).getAltro());

									attivitamateriale.setDescrAltroMateriale(elencoMaterialePropagazione.get(6).getAltro());
								}
								attivitamateriale.setFkConfigUtente(idConfigUtente);
								attivitamateriale.setDataInserimento(new Timestamp(System.currentTimeMillis()));
								attivitamateriale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								attivitamateriale.setIdAttivita(idAttSvoltaDett.getIdAttivita());
								attivitamateriale.setProgressivo(idAttSvoltaDett.getProgressivo());

								taifRAttivDetMaterialeDao.insert(attivitamateriale);
							}
						}
					}
				}
			}

			// att5 Arboricoltura Da Legno
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att5))
					&& gestioneAttivitaUltimoAnno.getAttivita5() != null) {
				TaifTAttivitaSvoltaDettDto attivitaSvoltaDett51 = new TaifTAttivitaSvoltaDettDto();
				TaifTAttivitaSvoltaDto attivitaSvolta51 = new TaifTAttivitaSvoltaDto();
				TaifRAttivDetMaterialeDto attivitamateriale;
				// List<TaifRAttivDetMaterialeDto> attMatList = new
				// ArrayList<TaifRAttivDetMaterialeDto>();
				// ArrayList<ArboricolturaDaLegno> arboriculturaList=
				// gestioneAttivitaUltimoAnno.getAttivita5().getElencoArbolicoltureDaLegno();
				AttivitaUltimoAnno5 attivita5 = gestioneAttivitaUltimoAnno.getAttivita5();
				int k = 0;

				attivitaSvolta51.setFkAzienda(idAzienda);
				attivitaSvolta51.setFkTipoAttivita(new Integer(Constants.fiveInt));
				if (attivita5.getAltro() != null && attivita5.getAltro() != "") {
					attivitaSvolta51.setDescrAltreAttivita(attivita5.getAltro());
				}
				if (attivita5.getPercentuale() != null) {
					attivitaSvolta51.setPercFatturato(new BigDecimal(attivita5.getPercentuale()));
				}

				attivitaSvolta51.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvolta51.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvolta51.setFkConfigUtente(idConfigUtente);
				TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta51);

				for (ArboricolturaDaLegno arboricolturaDaLegno : elencoArboricoltureLegno) {
					k++;
					attivitamateriale = new TaifRAttivDetMaterialeDto();
					// if (arboricolturaDaLegno.getAltroVisibile()) {
					// attivitamateriale.setIdMateriale(Integer.parseInt(Constants.idmaterialeArbAltro));
					// if (arboricolturaDaLegno.getAltro() != null) {
					// //attivitamateriale.setDescrAltroMateriale(arboricolturaDaLegno.getAltro());
					// attivitamateriale.setDescrAltroMateriale(materialePropCinque.getAltro());
					// }
					// } else {
					// attivitamateriale.setIdMateriale(Integer.parseInt(Constants.idmaterialeArb));
					// }

					// Prova correzione per ALTRO 16/10/2019
					attivitamateriale.setIdMateriale(arboricolturaDaLegno.getIdTipoMateriale());
					if (arboricolturaDaLegno.getIdTipoMateriale() == 8) {
						attivitamateriale.setDescrAltroMateriale(arboricolturaDaLegno.getAltro());
					}
					// Fine

					attivitamateriale.setFkConfigUtente(idConfigUtente);
					attivitamateriale.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitamateriale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitamateriale.setProgressivo(k);

					attivitaSvoltaDett51.setProgressivo(k);
					attivitaSvoltaDett51.setValore1(new BigDecimal(arboricolturaDaLegno.getRealizzazione()));
					attivitaSvoltaDett51.setValore2(new BigDecimal(arboricolturaDaLegno.getManutenzione()));
					attivitaSvoltaDett51.setValore3(new BigDecimal(arboricolturaDaLegno.getConduzione()));
					attivitaSvoltaDett51.setFkUnitaDiMisura(Constants.fiveInt);
					attivitaSvoltaDett51.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaDett51.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaDett51.setFkConfigUtente(idConfigUtente);
					attivitaSvoltaDett51.setIdAttivita(idAttSvolta.getIdAttivita());

					TaifTAttivitaSvoltaDettPk idAttSvoltaDett = taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett51);

					attivitamateriale.setIdAttivita(idAttSvoltaDett.getIdAttivita());
					taifRAttivDetMaterialeDao.insert(attivitamateriale);

				}

			}

			// att6 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att6))
					&& gestioneAttivitaUltimoAnno.getAttivita6() != null) {

				insertAttivitaUltimoAnno6(idAzienda, gestioneAttivitaUltimoAnno);

			}

			// att7 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att7))
					&& gestioneAttivitaUltimoAnno.getAttivita7() != null) {

				insertAttivitaUltimoAnno7(idAzienda, gestioneAttivitaUltimoAnno);

			}

			// att8 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att8))
					&& gestioneAttivitaUltimoAnno.getAttivita8() != null) {
				insertAttivitaUltimoAnno8(idAzienda, gestioneAttivitaUltimoAnno);

			}

			// att9 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att9))
					&& gestioneAttivitaUltimoAnno.getAttivita9() != null) {
				insertAttivitaUltimoAnno9(idAzienda, gestioneAttivitaUltimoAnno);
			}
			// mancano le attivita franceze !!!
			TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (taifTaifAppl != null) {
				if (dataTracciato.contentEquals(Constants.fLang)) {
					taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.zero));
				} else {
					taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.zero));
				}
				taifApplSchedaOkDao.update(taifTaifAppl);
			}
			// add insert attivita
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaAttivitaUltimoAnno] END");
		}

	}

	public void salvaLavoriPerPAUltimoAnno(Integer idAzienda, ArrayList<LavoroPA> list,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String esistenzaLavoriPA, String dataTracciato)
			throws DbManagerException {

		log.debug("[DbMgr::salvaLavoriPerPAUltimoAnno] BEGIN");
		idConfigUtente = profiloUtente.getIdConfigUtente();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			if (esistenzaLavoriPA.equals(Constants.SI)) {
				List<TaifTLavoroPaDto> lavoroPaDtoList = new ArrayList<TaifTLavoroPaDto>();
				for (LavoroPA backLavoroPa : list) {
					lavoroPaDtoList.add(dozerBeanMapper.map(backLavoroPa, TaifTLavoroPaDto.class));
				}
				for (TaifTLavoroPaDto taifTLavoroPaDto : lavoroPaDtoList) {
					taifTLavoroPaDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					taifTLavoroPaDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					taifTLavoroPaDto.setFkConfigUtente(idConfigUtente);
					taifTLavoroPaDto.setFkAzienda(idAzienda);

					taifTLavoroPaDao.insert(taifTLavoroPaDto);
				}
			}
			TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (taifTaifAppl != null) {
				if (dataTracciato.contentEquals(Constants.fLang)) {
					taifTaifAppl.setFlgSez32ItaOk(new BigDecimal(Constants.zero));
				} else {
					taifTaifAppl.setFlgSez32ItaOk(new BigDecimal(Constants.one));
				}
				taifApplSchedaOkDao.update(taifTaifAppl);
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaLavoriPerPAUltimoAnno] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaLavoriPerPAUltimoAnno] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaLavoriPerPAUltimoAnno] END");
		}
	}

	public void salvaCommercializzazioneLegnameEAssortimentiUltimoAnno(Integer idAzienda,
			ArrayList<LegnameAssortimentoTrattato> listLegnameAssortimento,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String esistenzaAttivitaLegname,
			Integer percentualeCommercioFr, String dataTracciato) throws DbManagerException {

		log.debug("[DbMgr::salvaCommercializzazioneLegnameEAssortimentiUltimoAnno] BEGIN");

		idConfigUtente = profiloUtente.getIdConfigUtente();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			if (esistenzaAttivitaLegname.equals(Constants.SI)) {
				TaifTAziendaDto aziendaFind = new TaifTAziendaDto();
				aziendaFind = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
				if (dataTracciato.equals(Constants.fLang)) {
					aziendaFind.setPercCommercioFra(new BigDecimal(percentualeCommercioFr));
				} else {
					aziendaFind.setPercCommercioFra(null);
				}
				aziendaFind.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				taifTAziendaDao.update(aziendaFind);
				if (listLegnameAssortimento != null && !listLegnameAssortimento.isEmpty()) {
					List<TaifTCommercializzazioneDto> commercializzazioneList = new ArrayList<TaifTCommercializzazioneDto>();
					for (LegnameAssortimentoTrattato beLegnameAssortimento : listLegnameAssortimento) {
						commercializzazioneList
								.add(dozerBeanMapper.map(beLegnameAssortimento, TaifTCommercializzazioneDto.class));
					}
					for (TaifTCommercializzazioneDto commercializzazione : commercializzazioneList) {
						commercializzazione.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						commercializzazione.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						commercializzazione.setFkAzienda(idAzienda);
						commercializzazione.setFkConfigUtente(idConfigUtente);
						taifTCommercializzazioneDao.insert(commercializzazione);
					}
				}
			}
			// insert attivita svolta
			// insertAttivitaOtto(idAzienda, dataTracciato);
			//
			TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (taifTaifAppl != null) {
				if (dataTracciato.contentEquals(Constants.fLang)) {
					taifTaifAppl.setFlgSez33FraOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez33ItaOk(new BigDecimal(Constants.zero));
					if (taifTaifAppl.getFlgSez31FraOk().equals(Constants.zero)) {
						taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.zero));
						taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.one));
					}
				} else {
					taifTaifAppl.setFlgSez33ItaOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez33FraOk(new BigDecimal(Constants.zero));
					if (taifTaifAppl.getFlgSez31ItaOk().equals(Constants.zero)) {
						taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.one));
						taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.zero));
					}
				}

				taifApplSchedaOkDao.update(taifTaifAppl);
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaCommercializzazioneLegnameEAssortimentiUltimoAnno] END");
		}
	}

	// @Transactional(rollbackFor=(SQLException.class))
	public void salvaStrutture(Integer idAzienda, ArrayList<Capannone> capannoni,
			ArrayList<PiazzaleStoccaggio> piazzali, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			boolean esisstecapannone, boolean esistePiazzaSto, String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaStrutture] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		idConfigUtente = profiloUtente.getIdConfigUtente();
		try {
			utx.begin();
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			List<TaifTStrutturaDto> struttureList = new ArrayList<TaifTStrutturaDto>();
			if (esisstecapannone) {
				List<BeCapannoneDto> backCappanoniList = new ArrayList<BeCapannoneDto>();
				for (Capannone cappanone : capannoni) {
					backCappanoniList.add(dozerBeanMapper.map(cappanone, BeCapannoneDto.class));
				}
				/*
				 * for (BeCapannoneDto backCapp : backCappanoniList) {
				 * funzioneVisibleFilter=getFunzioneVisibleFilter(dataTracciato);
				 * funzioneVisibleFilter.setFunzioneName(backCapp.getFunzioneCapannone());//
				 * idFunzione backCapp.setIdFunzioneCapannone(getIdFunzioneStrutture(
				 * getFunzioneVisibleFilter(dataTracciato))); }
				 */
				for (BeCapannoneDto capannoneInsert : backCappanoniList) {
					struttureList.add(dozerBeanMapper.map(capannoneInsert, TaifTStrutturaDto.class));
				}
			}
			if (esistePiazzaSto) {
				List<BePiazzaStoccaggioDto> backPiazzaStoccaggioList = new ArrayList<BePiazzaStoccaggioDto>();
				for (PiazzaleStoccaggio piazza : piazzali) {
					backPiazzaStoccaggioList.add(dozerBeanMapper.map(piazza, BePiazzaStoccaggioDto.class));
				}
				for (BePiazzaStoccaggioDto backPiazza : backPiazzaStoccaggioList) {
					if (dataTracciato.equals(Constants.iLang)) {
						backPiazza.setIdFunzionePiazza(Constants.idFunzionePiazza);
					} else {
						backPiazza.setIdFunzionePiazza(Constants.idFunzionePiazzaFrancese);
					}
				}
				for (BePiazzaStoccaggioDto piazzaInsert : backPiazzaStoccaggioList) {
					struttureList.add(dozerBeanMapper.map(piazzaInsert, TaifTStrutturaDto.class));
				}
			}
			for (TaifTStrutturaDto taifTStrutturaDto : struttureList) {
				taifTStrutturaDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				taifTStrutturaDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				taifTStrutturaDto.setFkAzienda(idAzienda);
				taifTStrutturaDto.setFkConfigUtente(idConfigUtente);

				taifTStrutturaDao.insert(taifTStrutturaDto);
			}
			aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			taifTAziendaDao.update(aziendaToUpdate);
			if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
				schedaToUpdate.setFlgSez4ItaOk(new BigDecimal(Constants.zero));
				schedaToUpdate.setFlgSez4FraOk(new BigDecimal(Constants.oneInt));
			} else {
				schedaToUpdate.setFlgSez4ItaOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez4FraOk(new BigDecimal(Constants.zero));
			}

			taifApplSchedaOkDao.update(schedaToUpdate);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaStrutture] END");
		}
	}

	// @Transactional(rollbackFor = (SQLException.class))
	public void salvaAttrezzaturaAntiInfortunisticaMezziDPI(Integer idAzienda,
			ArrayList<MezzoDiProtezioneIndividuale> caschiForestali,
			ArrayList<MezzoDiProtezioneIndividuale> scarponiRinforzati,
			ArrayList<MezzoDiProtezioneIndividuale> pantaloniAntitaglio, int idConfigUtente,
			Map<String, Boolean> attrezzatureMap, String dataTracciato) throws DbManagerException {

		log.debug("[DbMgr::salvaAttrezzaturaAntiInfortunisticaMezziDPI] BEGIN");

		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<TaifTDpiDto> backDpiList = new ArrayList<TaifTDpiDto>();
			List<TaifTDpiByIdTipoDispositivoDto> backDpiEstesoList = new ArrayList<TaifTDpiByIdTipoDispositivoDto>();
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			List<MezzoDiProtezioneIndividuale> unionOfLists = new ArrayList<MezzoDiProtezioneIndividuale>();
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkCaschi)) {
				for (MezzoDiProtezioneIndividuale caschi : caschiForestali) {
					caschi.setIdTipoMezzoDiProtezioneIndividuale(1);//
				}
				unionOfLists.addAll(caschiForestali);
			}
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkScarponi)) {
				for (MezzoDiProtezioneIndividuale scarponi : scarponiRinforzati) {
					scarponi.setIdTipoMezzoDiProtezioneIndividuale(2);
				}
				unionOfLists.addAll(scarponiRinforzati);
			}
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkPantaloni)) {
				for (MezzoDiProtezioneIndividuale pantaloni : pantaloniAntitaglio) {
					pantaloni.setIdTipoMezzoDiProtezioneIndividuale(3);
				}
				unionOfLists.addAll(pantaloniAntitaglio);
			}
			if (unionOfLists != null && unionOfLists.size() > 0) {
				for (MezzoDiProtezioneIndividuale taifTDpiByIdTipoDispositivoDto : unionOfLists) {
					backDpiEstesoList.add(
							dozerBeanMapper.map(taifTDpiByIdTipoDispositivoDto, TaifTDpiByIdTipoDispositivoDto.class));
				}
				for (TaifTDpiByIdTipoDispositivoDto dispositivi : backDpiEstesoList) {
					backDpiList.add(dozerBeanMapper.map(dispositivi, TaifTDpiDto.class));
				}
				for (TaifTDpiDto dispositiviToInsert : backDpiList) {

					dispositiviToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					dispositiviToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					dispositiviToInsert.setFkAzienda(idAzienda);
					dispositiviToInsert.setFkConfigUtente(idConfigUtente);
					taifTDpiDao.insert(dispositiviToInsert);
				}
			}
			aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			taifTAziendaDao.update(aziendaToUpdate);
			if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
				schedaToUpdate.setFlgSez51ItaOk(new BigDecimal(Constants.zero));
				// schedaToUpdate.setFlgSez51FraOk(new BigDecimal(Constants.oneInt));
			} else {
				schedaToUpdate.setFlgSez51ItaOk(new BigDecimal(Constants.oneInt));
			}

			taifApplSchedaOkDao.update(schedaToUpdate);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaAttrezzaturaAntiInfortunisticaMezziDPI] END");
		}

	}

	// @Transactional(rollbackFor = (SQLException.class))
	public void salvaMacchineEMezzi(Integer idAzienda, GestioneMacchineMezzi gestioneMacchineMezzi, int idConfigUtente,
			Map<String, Boolean> macchineMezziMap, String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaMacchineEMezzi] BEGIN");

		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<MacchinaMezzo> unionOfMacchineLists = new ArrayList<MacchinaMezzo>();
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));

			TipoMezzoFilter tipoMezzoFilter = new TipoMezzoFilter();
			tipoMezzoFilter.setFlagItaFr(dataTracciato);
			tipoMezzoFilter.setFlagVisibile(Constants.oneInt);
			List<TaifTMezzoDto> backMezzoList = new ArrayList<TaifTMezzoDto>();
			if (gestioneMacchineMezzi != null) {
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkTrattici)
						&& gestioneMacchineMezzi.getElencoTrattrici() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoTrattrici(), tipoMezzoFilter,
							Constants.Trattrice);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoTrattrici());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkSpeciali)
						&& gestioneMacchineMezzi.getElencoMacchineSpeciali() != null) {
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMacchineSpeciali());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkTerra)
						&& gestioneMacchineMezzi.getElencoMacchineMovimentoTerra() != null) {
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMacchineMovimentoTerra());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkRimorchi)
						&& gestioneMacchineMezzi.getElencoRimorchi() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoRimorchi(), tipoMezzoFilter,
							Constants.Rimorchio);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoRimorchi());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkVerricelli)
						&& gestioneMacchineMezzi.getElencoVerricelli() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoVerricelli(), tipoMezzoFilter,
							Constants.Verricello);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoVerricelli());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkPle)
						&& gestioneMacchineMezzi.getElencoPiattaformaElevabile() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoPiattaformaElevabile(), tipoMezzoFilter,
							Constants.PLE);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoPiattaformaElevabile());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkTrincia)
						&& gestioneMacchineMezzi.getElencoTrinciaForestale() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoTrinciaForestale(), tipoMezzoFilter,
							Constants.Trincia);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoTrinciaForestale());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkSegherie)
						&& gestioneMacchineMezzi.getElencoSegherieMobili() != null) {
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoSegherieMobili());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkGru)
						&& gestioneMacchineMezzi.getElencoGruACavo() != null) {
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoGruACavo());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkCippatrici)
						&& gestioneMacchineMezzi.getElencoCippatrici() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoCippatrici(), tipoMezzoFilter,
							Constants.Cippatrice);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoCippatrici());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkMezziTra)
						&& gestioneMacchineMezzi.getElencoMezziDiTrasporto() != null) {
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMezziDiTrasporto());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkMezziAltri)
						&& gestioneMacchineMezzi.getElencoAltriMezzi() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoAltriMezzi(), tipoMezzoFilter,
							Constants.Altro);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoAltriMezzi());
				}
			}
			if (unionOfMacchineLists != null && unionOfMacchineLists.size() > 0) {
				for (MacchinaMezzo macchina : unionOfMacchineLists) {
					backMezzoList.add(dozerBeanMapper.map(macchina, TaifTMezzoDto.class));
				}
				for (TaifTMezzoDto mezziToInsert : backMezzoList) {
					mezziToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					mezziToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					mezziToInsert.setFkAzienda(idAzienda);
					mezziToInsert.setFkConfigUtente(idConfigUtente);

					taifTMezzoDao.insert(mezziToInsert);
				}
			}
			aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			aziendaToUpdate.setFkConfigUtente(idConfigUtente);
			taifTAziendaDao.update(aziendaToUpdate);
			if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
				schedaToUpdate.setFlgSez52FraOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez52ItaOk(new BigDecimal(Constants.zero));
			} else {
				schedaToUpdate.setFlgSez52ItaOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez52FraOk(new BigDecimal(Constants.zero));
			}

			taifApplSchedaOkDao.update(schedaToUpdate);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaMacchineEMezzi] END");
		}
	}

	private void valorizzaIdIdMacchinaMezzo(List<MacchinaMezzo> elencoMacchineList, TipoMezzoFilter tipoMezzoFilter,
			String tipoMezzo) throws DbManagerException {
		for (MacchinaMezzo taifTMezzo : elencoMacchineList) {
			tipoMezzoFilter.setTipoMezzo(tipoMezzo);
			taifTMezzo.setIdTipoMacchinaMezzo(getIdMezzoByTipoMezzo(tipoMezzoFilter));
		}
	}

	public void salvaPersonale(Integer idAzienda, ArrayList<Personale> elencoPersonale, int idConfigUtente,
			String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaPersonale] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<TaifRPersonaAziendaDto> persAziendaList = new ArrayList<TaifRPersonaAziendaDto>();
			TaifRPersonaAziendaDto personaAzienda = new TaifRPersonaAziendaDto();
			TaifTPersonaDto personaToInsert = new TaifTPersonaDto();
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (elencoPersonale != null && !elencoPersonale.isEmpty()) {
				for (Personale persona : elencoPersonale) {

					personaToInsert = dozerBeanMapper.map(persona, TaifTPersonaDto.class);

					personaToInsert.setFkConfigUtente(idConfigUtente);
					personaToInsert.setFkNazione(1);
					if (dataTracciato.equals(Constants.iLang)) {
						personaToInsert.setFkTitoloStudio(0);
						personaToInsert.setFkTitoloStudioFra(0);
					} else {
						personaToInsert.setFkTitoloStudio(0);
						personaToInsert.setFkTitoloStudioFra(0);
					}

					personaToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					personaToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));

					TaifTPersonaPk personaPk = taifTPersonaDao.insert(personaToInsert);

					personaAzienda = new TaifRPersonaAziendaDto();
					personaAzienda = dozerBeanMapper.map(persona, TaifRPersonaAziendaDto.class);

					personaAzienda.setIdPersona(personaPk.getIdPersona());
					personaAzienda.setIdAzienda(idAzienda);
					personaAzienda.setFkRuolo(persona.getIdTipologiaPersonale());
					personaAzienda.setFlgTempoDeterminato(new BigDecimal(persona.getIdDurataContratto()));
					if (StringUtils.isNotEmpty(persona.getGiorniNellAnno())
							&& StringUtils.isNotBlank(persona.getGiorniNellAnno())) {
						personaAzienda.setGgTempoDeterminato(Integer.valueOf(persona.getGiorniNellAnno()));
					}
					personaAzienda.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					personaAzienda.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					personaAzienda.setFkConfigUtente(idConfigUtente);

					taifRPersonaAziendaDao.insert(personaAzienda);

					if (dataTracciato.equals(Constants.fraLang)) {// per la parte francese- to do
						aziendaFrTipoContrDto = new TaifRAziendaFrTipoContrDto();

						aziendaFrTipoContrDto.setIdAzienda(idAzienda);
						aziendaFrTipoContrDto.setIdTipoContratto(persona.getIdContratto());
						// aziendaFrTipoContrDto.setNrAddetti(bepersona.get);
						aziendaFrTipoContrDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						aziendaFrTipoContrDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						aziendaFrTipoContrDto.setFkConfigUtente(idConfigUtente);

						taifRAziendaFrTipoContrDao.insert(aziendaFrTipoContrDto);

						aziendaFrTipoMansDto = new TaifRAziendaFrTipoMansDto();
						aziendaFrTipoMansDto.setIdAzienda(idAzienda);
						aziendaFrTipoMansDto.setIdTipoMansione(persona.getIdMansione());
						// aziendaFrTipoMansDto.setNrAddetti(bepersona.get);
						aziendaFrTipoMansDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						aziendaFrTipoMansDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						aziendaFrTipoMansDto.setFkConfigUtente(idConfigUtente);
						taifRAziendaFrTipoContrDao.insert(aziendaFrTipoContrDto);
					}
				}
			}
			// updateAzienda
			aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			aziendaToUpdate.setNbreSalariesFra(elencoPersonale.size());
			taifTAziendaDao.update(aziendaToUpdate);
			// aziendaToUpdate.setTempsPleinFra(val);
			schedaToUpdate.setFlgSez6FraOk(new BigDecimal(Constants.zero));
			schedaToUpdate.setFlgSez6ItaOk(new BigDecimal(Constants.oneInt));

			taifApplSchedaOkDao.update(schedaToUpdate);

			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaPersonale] END");
		}

	}

	// unitaMisura
	public Integer getIdUnitaMisura(String unitaMisura) throws TaifDUnitaDiMisuraDaoException {
		try {
			UnitaMisuraFilter unitaM = new UnitaMisuraFilter();
			if (unitaMisura.equalsIgnoreCase(Constants.nessunDatoUnitaMisura)) {
				unitaM.setFlagVisible(0);
			} else {
				unitaM.setFlagVisible(1);
			}
			unitaM.setUnitaMisura(unitaMisura);
			if (unitaMisura != null) {
				return taifDUnitaDiMisuraDao.findByVisibleUnitaMisura(unitaM).get(0).getId();
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	// getIdDpi
	public Integer getIdDispositivoProt(String mezzoProtezione) throws TaifDTipoDpiDaoException {

		DispositiviFilter dispFilter = new DispositiviFilter();
		dispFilter.setFlagVisibile(1);
		dispFilter.setTipoDpi(mezzoProtezione);
		if (mezzoProtezione != null) {
			return taifDTipoDpiDao.findByDispVisible(dispFilter).get(0).getId();
		} else {
			return 0;
		}
	}

	// getIdDpi
	public String getCodiceSoggetto(int idCodice) throws DbManagerException {
		try {

			TaifTSoggettoGestoreDto soggetto = taifTSoggettoGestoreDao
					.findByPrimaryKey(new TaifTSoggettoGestorePk(idCodice));

			return soggetto.getCodice();
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCodiceSoggetto] END");
		}

	}

	public Albo getAlboSogettoGestore(int idCodice) throws DbManagerException {
		try {
			Albo albo = new Albo();
			TaifTSoggettoGestoreDto soggetto = taifTSoggettoGestoreDao
					.findByPrimaryKey(new TaifTSoggettoGestorePk(idCodice));
			albo = dozerBeanMapper.map(soggetto, Albo.class);
			albo.setIdAlbo(idCodice);
			albo.setCssAlbo("logoAlbo".concat(String.valueOf(idCodice)));
			albo.setDataIscrizione(new Timestamp(System.currentTimeMillis()).toString());

			return albo;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAlboSogettoGestore] END");
		}

	}

	public TaifTSoggettoGestoreDto getSoggettoGestoreById(int idSoggettogestore) throws DbManagerException {
		try {

			TaifTSoggettoGestoreDto soggettoGestore = taifTSoggettoGestoreDao
					.findByPrimaryKey(new TaifTSoggettoGestorePk(idSoggettogestore));

			return soggettoGestore;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getSoggettoGestoreById] END");
		}

	}

	public ArrayList<CodeDescription> getAlbi(SoggettoGestoreFilter filter) throws DbManagerException {
		try {
			ArrayList<CodeDescription> alboList = new ArrayList<CodeDescription>();
			List<TaifTSoggettoGestoreByFilterVisibleDto> soggetto = taifTSoggettoGestoreDao.findByFilterVisible(filter);
			for (TaifTSoggettoGestoreByFilterVisibleDto taifTSoggettoGestoreByFilterDto : soggetto) {
				/*
				 * CodeDescription albo = new CodeDescription();
				 * albo.setCode(taifTSoggettoGestoreByFilterDto.getIdSoggettoGestore()+"");
				 * albo.setDescription(taifTSoggettoGestoreByFilterDto.getDenominazionebreve());
				 * alboList.add(albo);
				 */
				// no funziona
				alboList.add(dozerBeanMapper.map(taifTSoggettoGestoreByFilterDto, CodeDescription.class));
			}
			return alboList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAlbi] END");
		}

	}

	public TaifTPersonaByProfiloPersonaDto getPersonaByCodiceFiscaleandProfilo(ConfigProfiloPersona filter)
			throws DbManagerException {
		try {

			List<TaifTPersonaByProfiloPersonaDto> personaList = taifTPersonaDao.findByProfiloPersona(filter);
			if (personaList != null && !personaList.isEmpty()) {
				return personaList.get(0);
			} else {
				return new TaifTPersonaByProfiloPersonaDto();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaAttrezzaturaAntiInfortunisticaMezziDPI] END");
		}

	}

	public TaifCnfProfiloUtenteByProfiloUtenteDto getProfiloUtenteByProcedura(ConfigProfiloFilter filter)
			throws DbManagerException {

		log.debug("[TaifMgr::findByProfiloUtente] BEGIN");
		try {

			List<TaifCnfProfiloUtenteByProfiloUtenteDto> profiloUtente = taifCnfProfiloUtenteDao
					.findByProfiloUtente(filter);
			return profiloUtente.get(0);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByProfiloUtente] END");
		}

	}

	public Integer getCodiceAttivitaApe(String codiceAttivita) throws DbManagerException {
		try {

			List<TaifDAttivitaAtecoApeByCodiceAttivitaDto> attivitaApeList = taifDAttivitaAtecoApeDao
					.findByCodiceAttivita(codiceAttivita);
			if (attivitaApeList != null && !attivitaApeList.isEmpty()) {
				return attivitaApeList.get(0).getId();
			} else {
				return 0;
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCodiceAttivitaApe] END");
		}

	}

	public Integer getCodiceMansione(MansioneFilter filter) throws DbManagerException {
		try {

			List<TaifDTipoMansioneByTipoMansioneDto> mansioneList = taifDTipoMansioneDao.findByTipoMansione(filter);

			return mansioneList.get(0).getId();
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCodiceMansione] END");
		}

	}

	public Integer getCodiceContratto(ContrattoFilter filter) throws DbManagerException {
		try {

			List<TaifDTipoContrattoByTipoContrattoDto> contrattoList = taifDTipoContrattoDao
					.findByTipoContratto(filter);
			return contrattoList.get(0).getId();
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCodiceContratto] END");
		}

	}

	private String getTipologiaDpi(Integer fkTipoDpi) throws DbManagerException {
		try {

			TaifDTipoDpiDto tipoDpi = taifDTipoDpiDao.findByPrimaryKey(new TaifDTipoDpiPk(fkTipoDpi));
			if (tipoDpi != null) {
				return tipoDpi.getTipoDpi();
			} else {
				return Constants.nessunDatoAttivita;
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCodiceContratto] END");
		}
	}

	public Integer getCodiceInquadramento(InquadramentoFilter filter) throws DbManagerException {
		try {

			List<TaifDTipoInquadramentoByTipoInquadramentoDto> inquadramento = taifDTipoInquadramentoDao
					.findByTipoInquadramento(filter);

			return inquadramento.get(0).getId();
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCodiceInquadramento] END");
		}

	}

	public Integer getIdFunzioneStrutture(FunzioneVisibleFilter filter) throws DbManagerException {
		try {

			List<TaifDFunzioneByFunzioneDto> funzione = taifDFunzioneDao.findByFunzione(filter);
			if (funzione.size() > 0) {
				return funzione.get(0).getIdFunzione();
			} else {
				return 0;
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCodiceInquadramento] END");
		}

	}

	public TaifTPersonaDto getTranslateExample(TitolareRappresentanteLegale titolare) throws DbManagerException {
		try {

			BeTitolareRappresentanteLegaleDto backTitolareLegale = new BeTitolareRappresentanteLegaleDto();
			backTitolareLegale = dozerBeanMapper.map(titolare, BeTitolareRappresentanteLegaleDto.class);
			TaifTPersonaDto personaDto = new TaifTPersonaDto();
			if (backTitolareLegale != null) {
				getIdNazioneFromStatoNascita(backTitolareLegale);
			}
			personaDto = dozerBeanMapper.map(backTitolareLegale, TaifTPersonaDto.class);
			return personaDto;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTranslateExample] END");
		}
	}

	public Integer getIdFormaGiuridica(FormaGiuridicaFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getIdFormaGiuridica] BEGIN");
		try {

			List<TaifDFormaGiuridicaByFormaGiuridicaDto> elencoDurateContr = taifDFormaGiuridicaDao
					.findByFormaGiuridica(filter);
			if (!elencoDurateContr.isEmpty()) {
				return elencoDurateContr.get(0).getId();
			} else {
				return 0;
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getIdFormaGiuridica] END");
		}
	}

	public ArrayList<Domanda> getElencoDomande(String codiceFiscale, String idNazione) throws DbManagerException {
		log.debug("[DbMgr::getElencoDomande] BEGIN");
		try {

			ArrayList<Domanda> listDomanda = new ArrayList<Domanda>();
			List<TaifTAziendaDomandaByCodiceFiscaleDto> elencoPratiche = taifTAziendaDao
					.findDomandaByCodiceFiscale(codiceFiscale);
			if (elencoPratiche != null && elencoPratiche.size() > 0) {
				for (TaifTAziendaDomandaByCodiceFiscaleDto taifTAziendaDomandaByCodiceFiscaleDto : elencoPratiche) {
					Domanda domanda = new Domanda();
					domanda.setIdDomanda(taifTAziendaDomandaByCodiceFiscaleDto.getIdPratica());
					if (taifTAziendaDomandaByCodiceFiscaleDto.getNumeroAlbo() != null) {
						domanda.setNumeroAlbo(taifTAziendaDomandaByCodiceFiscaleDto.getNumeroAlbo());
					}
					domanda.setIdAlbo(taifTAziendaDomandaByCodiceFiscaleDto.getIdSogettoGestore());
					domanda.setDsDomanda(taifTAziendaDomandaByCodiceFiscaleDto.getRagioneSociale());
					if (taifTAziendaDomandaByCodiceFiscaleDto.getIscrizioneAlbo() != null) {
						domanda.setData(taifTAziendaDomandaByCodiceFiscaleDto.getIscrizioneAlbo().toString());
					}
					// domanda.setDsAlbo(val);
					if (idNazione.equals(Constants.one)) {
						List<TaifTStoricoStatoByidPraticaITDto> statoPraticaI = taifTStoricoStatoDao
								.findByidPraticaIT(taifTAziendaDomandaByCodiceFiscaleDto.getIdPratica().intValue());
						if (statoPraticaI != null) {
							domanda.setIdStato(statoPraticaI.get(0).getIdStatoPratica());
							domanda.setDsStato(statoPraticaI.get(0).getStatoPratica());
						}
					} else {
						List<TaifTStoricoStatoByidPraticaFRDto> statoPraticaF = taifTStoricoStatoDao
								.findByidPraticaFR(taifTAziendaDomandaByCodiceFiscaleDto.getIdPratica().intValue());
						if (statoPraticaF != null) {
							domanda.setIdStato(statoPraticaF.get(0).getIdStatoPratica());
							domanda.setDsStato(statoPraticaF.get(0).getStatoPratica());
						}
					}

					listDomanda.add(domanda);
				}
			}
			return listDomanda;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoDomande] END");
		}

	}

	//

	public ArrayList<Domanda> getDomandaByPratica(PraticaFilter filter, String idNazione) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<Domanda> listDomanda = new ArrayList<Domanda>();
			List<TaifTAziendaDomandaAziendaPraticaDto> elencoPratiche = taifTAziendaDao
					.findDomandaAziendaPratica(filter);

			for (TaifTAziendaDomandaAziendaPraticaDto taifTAziendaDomandaAziendaPraticaDto : elencoPratiche) {
				Domanda domanda = new Domanda();
				domanda.setIdDomanda(filter.getIdPratica());
				if (taifTAziendaDomandaAziendaPraticaDto.getNumeroAlbo() != null) {
					domanda.setNumeroAlbo(taifTAziendaDomandaAziendaPraticaDto.getNumeroAlbo());
				}
				domanda.setIdAlbo(taifTAziendaDomandaAziendaPraticaDto.getIdSogettoGestore());
				domanda.setDsDomanda(taifTAziendaDomandaAziendaPraticaDto.getRagioneSociale());
				if (taifTAziendaDomandaAziendaPraticaDto.getIscrizioneAlbo() != null) {
					domanda.setData(taifTAziendaDomandaAziendaPraticaDto.getIscrizioneAlbo().toString());
				}
				if (idNazione.equals(Constants.one)) {
					List<TaifTStoricoStatoByidPraticaITDto> statoPraticaI = taifTStoricoStatoDao
							.findByidPraticaIT(taifTAziendaDomandaAziendaPraticaDto.getIdPratica().intValue());
					if (statoPraticaI != null) {
						domanda.setIdStato(statoPraticaI.get(0).getIdStatoPratica());
						domanda.setDsStato(statoPraticaI.get(0).getStatoPratica());
					}
				} else {
					List<TaifTStoricoStatoByidPraticaFRDto> statoPraticaF = taifTStoricoStatoDao
							.findByidPraticaFR(taifTAziendaDomandaAziendaPraticaDto.getIdPratica().intValue());
					if (statoPraticaF != null) {
						domanda.setIdStato(statoPraticaF.get(0).getIdStatoPratica());
						domanda.setDsStato(statoPraticaF.get(0).getStatoPratica());
					}
				}
				listDomanda.add(domanda);
			}
			return listDomanda;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public TaifTPersonaDto getPersonaFromAziendaUtente(PersonaAziendaFilter personaFilter) throws DbManagerException {
		log.debug("[DbMgr::getPersonaFromAziendaUtente] BEGIN");
		try {
			TaifTPersonaDto personaDto = new TaifTPersonaDto();
			List<TaifRPersonaAziendaByAziendaUtenteDto> personaAzienda = taifRPersonaAziendaDao
					.findByAziendaUtente(personaFilter);
			if (personaAzienda != null) {
				personaDto = taifTPersonaDao.findByPrimaryKey(new TaifTPersonaPk(personaAzienda.get(0).getIdPersona()));
			}
			return personaDto;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaFromAziendaUtente] END");
		}
	}

	public List<TaifRPersonaAziendaByAziendaUtenteDto> getRuoloPersonaFromAziendaUtente(
			PersonaAziendaFilter personaFilter) throws DbManagerException {
		log.debug("[DbMgr::getPersonaFromAziendaUtente] BEGIN");
		try {

			List<TaifRPersonaAziendaByAziendaUtenteDto> personaAziendaList = taifRPersonaAziendaDao
					.findByAziendaUtente(personaFilter);
			return personaAziendaList;

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaFromAziendaUtente] END");
		}
	}

	public ArrayList<TaifTAziendaDomandaByCodiceFiscaleDto> getElencoDomandeTT(String codiceFiscale)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoDomande] BEGIN");
		try {
			ArrayList<TaifTAziendaDomandaByCodiceFiscaleDto> listDomanda = new ArrayList<TaifTAziendaDomandaByCodiceFiscaleDto>();
			listDomanda = (ArrayList<TaifTAziendaDomandaByCodiceFiscaleDto>) taifTAziendaDao
					.findDomandaByCodiceFiscale(codiceFiscale);
			return listDomanda;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoDomande] END");
		}

	}

	public TaifTPraticaDto getPraticByIdPratica(int idPratica) throws DbManagerException {
		log.debug("[DbMgr::getPraticByIdPratica] BEGIN");
		try {
			TaifTPraticaDto praticaPresenta = taifTPraticaDao.findByPrimaryKey(new TaifTPraticaPk(idPratica));
			return praticaPresenta;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPraticByIdPratica] END");
		}

	}

	public String getRuoloById(int idRuolo) throws DbManagerException {
		log.debug("[DbMgr::getIdRuolo] BEGIN");
		try {
			String ruolo = "";
			TaifDRuoloDto tipoRuolo = taifDRuoloDao.findByPrimaryKey(new TaifDRuoloPk(idRuolo));
			if (tipoRuolo != null) {
				ruolo = tipoRuolo.getRuolo();
			}
			return ruolo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getIdRuolo] END");
		}

	}
	// ricerca

	public ArrayList<CodeDescription> getElencoCategorieImpresaRicerca(VisibileOrdinFilter impresaFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoCategorieImpresa] BEGIN");
		try {
			ArrayList<CodeDescription> elencoCatImpRicerca = new ArrayList<CodeDescription>();
			List<TaifDCategoriaImpresaCategoriaImpresaVisibleDto> impreseList = taifDCategoriaImpresaDao
					.findCategoriaImpresaVisible(impresaFilter);
			for (TaifDCategoriaImpresaCategoriaImpresaVisibleDto categoriaDto : impreseList) {
				// String[] divide = categoriaDto.getCategoria().split("-");
				// categoriaDto.setCategoria(divide[0]);
				categoriaDto.setCategoria(categoriaDto.getCategoria());
				elencoCatImpRicerca.add(dozerBeanMapper.map(categoriaDto, CodeDescription.class));
			}
			return elencoCatImpRicerca;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoCategorieImpresa] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAttivitaSvolteRicerca(VisibileOrdinFilter impresaFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoAttivitaSvolteRicerca] BEGIN");
		try {
			ArrayList<CodeDescription> elencoAttSvolteRicerca = new ArrayList<CodeDescription>();
			List<TaifDTipoAttivitaByFilterDto> attivitaList = taifDTipoAttivitaDao.findByFilter(impresaFilter);
			for (TaifDTipoAttivitaByFilterDto attivitaDto : attivitaList) {
				elencoAttSvolteRicerca.add(dozerBeanMapper.map(attivitaDto, CodeDescription.class));
			}
			return elencoAttSvolteRicerca;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAttivitaSvolteRicerca] END");
		}
	}
	// ricercaAziende TO DO

	// findRicercaAziendaAvanzata
	public ArrayList<TaifTAziendaRicercaAziendaAvanzataDto> findRicercaAziendaAvanzata(RicercaAziendaFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::findRicercaAziendaAvanzata] BEGIN");
		try {
			ArrayList<TaifTAziendaRicercaAziendaAvanzataDto> listAziende = new ArrayList<TaifTAziendaRicercaAziendaAvanzataDto>();
			// listAziende = (ArrayList<TaifTAziendaRicercaAziendaAvanzataDto>)
			// taifTAziendaDao.findRicercaAziendaAvanzata(filter, ricercaLibera);
			listAziende = (ArrayList<TaifTAziendaRicercaAziendaAvanzataDto>) taifTAziendaDao
					.findRicercaAziendaAvanzata(filter);
			return listAziende;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRicercaAziendaAvanzata] END");
		}

	}

	public ArrayList<TaifTAziendaRicercaAziendaExportDto> ricercaAziendaExport(RicercaAziendaFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::findRicercaAziendaAvanzata] BEGIN");
		try {
			ArrayList<TaifTAziendaRicercaAziendaExportDto> listAziende = new ArrayList<TaifTAziendaRicercaAziendaExportDto>();
			listAziende = (ArrayList<TaifTAziendaRicercaAziendaExportDto>) taifTAziendaDao
					.findRicercaAziendaExport(filter);
			return listAziende;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRicercaAziendaAvanzata] END");
		}

	}

	public List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> findCategoriaImpresaByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws DbManagerException {
		log.debug("[DbMgr::findCategoriaImpresaByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {

			List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> categImpresa = new ArrayList<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto>();
			categImpresa = taifRAziendaCategImpresaDao.findFindCategoriaImpresaByIdAzienda(aziendaVisibleFilter);
			if (categImpresa == null) {
				categImpresa = new ArrayList<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto>();
			}
			return categImpresa;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCategoriaImpresaByIdAzienda] END");
		}

	}

	public List<TaifTPraticaAltriAlbiByIdAziendaDto> findAltriAlbiByIdAzienda(String idRiga) throws DbManagerException {
		log.debug("[DbMgr::findAltriAlbiByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {

			List<TaifTPraticaAltriAlbiByIdAziendaDto> altriAlbi = new ArrayList<TaifTPraticaAltriAlbiByIdAziendaDto>();
			altriAlbi = taifTPraticaDao.findAltriAlbiByIdAzienda(new Integer(idRiga));
			if (altriAlbi == null) {
				altriAlbi = new ArrayList<TaifTPraticaAltriAlbiByIdAziendaDto>();
			}
			return altriAlbi;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findAltriAlbiByIdAzienda] END");
		}
	}

	public List<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto> findDettaglioCertificazioniByIdAzienda(
			String idRiga) throws DbManagerException {
		log.debug("[DbMgr::findDettaglioCertificazioniByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {

			List<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto> certificazioni = new ArrayList<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto>();
			certificazioni = taifTCertificazioneDao.findDettaglioCertificazioniByIdAzienda(new Integer(idRiga));
			if (certificazioni == null) {
				certificazioni = new ArrayList<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto>();
			}
			return certificazioni;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findDettaglioCertificazioniByIdAzienda] END");
		}
	}

	public List<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto> findDettaglioAttivitaByIdAzienda(
			String idRiga) throws DbManagerException {
		log.debug("[DbMgr::findDettaglioAttivitaByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {

			List<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto> attivita = new ArrayList<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto>();
			attivita = taifTAttivitaSvoltaDao.findDettaglioAttivitaSvoltaByIdAzienda(new Integer(idRiga));
			if (attivita == null) {
				attivita = new ArrayList<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto>();
			}
			return attivita;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findDettaglioAttivitaByIdAzienda] END");
		}
	}

	public List<TaifTMezzoDettaglioMezzoByIdAziendaDto> findDettaglioMezziIdAzienda(String idRiga)
			throws DbManagerException {
		log.debug("[DbMgr::findDettaglioMezziIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {

			List<TaifTMezzoDettaglioMezzoByIdAziendaDto> mezzi = new ArrayList<TaifTMezzoDettaglioMezzoByIdAziendaDto>();
			mezzi = taifTMezzoDao.findDettaglioMezzoByIdAzienda(new Integer(idRiga));
			if (mezzi == null) {
				mezzi = new ArrayList<TaifTMezzoDettaglioMezzoByIdAziendaDto>();
			}
			return mezzi;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findDettaglioMezziIdAzienda] END");
		}
	}

	public List<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto> findDettaglioCategoriaImpresaByIdAzienda(
			String idRiga) throws DbManagerException {
		log.debug("[DbMgr::findDettaglioCategoriaImpresaByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {

			List<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto> categImpresa = new ArrayList<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto>();
			categImpresa = taifRAziendaCategImpresaDao
					.findFindDettaglioCategoriaImpresaByIdAzienda(new Integer(idRiga));
			if (categImpresa == null) {
				categImpresa = new ArrayList<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto>();
			}
			return categImpresa;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCategoriaImpresaByIdAzienda] END");
		}

	}

	public void eliminaAllegato(String idAllegato) throws DbManagerException {
		log.debug("[DbMgr::eliminaAllegato] BEGIN");
		try {
			this.taifTAllegatoDao.delete(new TaifTAllegatoPk(ConvertUtil.convertToInteger(idAllegato)));
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::eliminaAllegato] END");
		}
	}

	public List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> findAssociazioneByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws DbManagerException {
		log.debug("[DbMgr::findAssociazioneByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {
			List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> associazioniList = new ArrayList<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto>();
			associazioniList = taifRAziendaAssociazioneDao.findFindAssociazioniByIdAzienda(aziendaVisibleFilter);
			if (associazioniList == null) {
				associazioniList = new ArrayList<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto>();
			}
			return associazioniList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findAssociazioneByIdAzienda] END");
		}

	}

	public ArrayList<TaifCnfTipoAllegatoByAllegatoFilterDto> getTipoFirmaAllegati(TipoAllegatoFilter visibileFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getTipoFirmaAllegati] BEGIN");
		try {
			ArrayList<TaifCnfTipoAllegatoByAllegatoFilterDto> list = (ArrayList<TaifCnfTipoAllegatoByAllegatoFilterDto>) taifCnfTipoAllegatoDao
					.findByAllegatoFilter(visibileFilter);
			return list;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTipoFirmaAllegati] END");
		}
	}

	public ArrayList<TaifDEstensioneFileEstensioneFileAmmDto> getEstensioneFileAmmessa(
			TipoAllegatoFilter visibileFilter) throws DbManagerException {
		log.debug("[DbMgr::getEstensioneFileAmmessa] BEGIN");
		try {
			ArrayList<TaifDEstensioneFileEstensioneFileAmmDto> list = (ArrayList<TaifDEstensioneFileEstensioneFileAmmDto>) taifDEstensioneFileDao
					.findEstensioneFileAmm(visibileFilter);
			return list;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getEstensioneFileAmmessa] END");
		}
	}

	public ArrayList<TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto> getEstensionePerTipoDocumentoSelezionato(
			TipoAllegatoFilter visibileFilter) throws DbManagerException {
		log.debug("[DbMgr::getEstensioneFileAmmessa] BEGIN");
		try {
			ArrayList<TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto> list = (ArrayList<TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto>) taifDEstensioneFileDao
					.findEstensionePerTipoDocumentoSelezionato(visibileFilter);
			return list;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getEstensioneFileAmmessa] END");
		}
	}

	public List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> findCertificazioniByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws DbManagerException {
		log.debug("[DbMgr::findCertificazioniByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {
			List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> certificazioniList = new ArrayList<TaifTCertificazioneFindCertificazioniByIdAziendaDto>();
			certificazioniList = taifTCertificazioneDao.findFindCertificazioniByIdAzienda(aziendaVisibleFilter);
			if (certificazioniList == null) {
				certificazioniList = new ArrayList<TaifTCertificazioneFindCertificazioniByIdAziendaDto>();
			}
			return certificazioniList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCertificazioniByIdAzienda] END");
		}
	}

	public List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> findAttivitaSvoltaByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws DbManagerException {
		log.debug("[DbMgr::findAttivitaSvoltaByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {
			List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaSvolteList = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
			attivitaSvolteList = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
			if (attivitaSvolteList == null) {
				attivitaSvolteList = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
			}
			return attivitaSvolteList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findAttivitaSvoltaByIdAzienda] END");
		}

	}

	public List<TaifTLavoroPaLavoroPaByAziendaVisibileDto> findLavoroPaByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws DbManagerException {
		log.debug("[DbMgr::findLavoroPaByIdAzienda] BEGIN " + aziendaVisibleFilter.getIdAzienda());
		try {
			List<TaifTLavoroPaLavoroPaByAziendaVisibileDto> lavoroPublicaAdm = new ArrayList<TaifTLavoroPaLavoroPaByAziendaVisibileDto>();
			lavoroPublicaAdm = taifTLavoroPaDao.findLavoroPaByAziendaVisibile(aziendaVisibleFilter);
			if (lavoroPublicaAdm == null) {
				lavoroPublicaAdm = new ArrayList<TaifTLavoroPaLavoroPaByAziendaVisibileDto>();
			}
			return lavoroPublicaAdm;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findLavoroPaByIdAzienda] END");
		}

	}

	public List<TaifTCommercializzazioneByAziendaDto> findCommerciallizazioneByIdAzienda(Integer idAzienda)
			throws DbManagerException {
		log.debug("[DbMgr::findLavoroPaByIdAzienda] BEGIN " + idAzienda);
		try {
			List<TaifTCommercializzazioneByAziendaDto> listCommercializzazione = new ArrayList<TaifTCommercializzazioneByAziendaDto>();
			listCommercializzazione = taifTCommercializzazioneDao.findByAzienda(idAzienda);
			if (listCommercializzazione == null) {
				listCommercializzazione = new ArrayList<TaifTCommercializzazioneByAziendaDto>();
			}
			return listCommercializzazione;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findLavoroPaByIdAzienda] END");
		}

	}

	public List<TaifTCommercializzazioneSpecieByIdSpecieVisibleDto> findSpecieByIdSpecieVisible(
			SpecieFilter specieFilter) throws DbManagerException {
		log.debug("[DbMgr::findSpecieByIdSpecieVisible] BEGIN ");
		try {
			List<TaifTCommercializzazioneSpecieByIdSpecieVisibleDto> listCommercializzazioneFilter = new ArrayList<TaifTCommercializzazioneSpecieByIdSpecieVisibleDto>();
			listCommercializzazioneFilter = taifTCommercializzazioneDao.findSpecieByIdSpecieVisible(specieFilter);
			if (listCommercializzazioneFilter == null) {
				listCommercializzazioneFilter = new ArrayList<TaifTCommercializzazioneSpecieByIdSpecieVisibleDto>();
			}
			return listCommercializzazioneFilter;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findSpecieByIdSpecieVisible] END");
		}

	}

	public List<TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto> findAssortimentoByIdAssortimentoVisible(
			AssortimentoFilter assortimentoFilter) throws DbManagerException {
		log.debug("[DbMgr::findAssortimentoByIdAssortimentoVisible] BEGIN ");
		try {
			List<TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto> listCommercializzazioneFilter = new ArrayList<TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto>();
			listCommercializzazioneFilter = taifTCommercializzazioneDao
					.findAssortimentoByIdAssortimentoVisible(assortimentoFilter);
			if (listCommercializzazioneFilter == null) {
				listCommercializzazioneFilter = new ArrayList<TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto>();
			}
			return listCommercializzazioneFilter;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findAssortimentoByIdAssortimentoVisible] END");
		}

	}

	public List<TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto> findProvenienzaByIdProvenienzaVisible(
			ProvenienzaFilter provenienzaFilter) throws DbManagerException {
		log.debug("[DbMgr::findProvenienzaByIdProvenienzaVisible] BEGIN ");
		try {
			List<TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto> listCommercializzazioneFilter = new ArrayList<TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto>();
			listCommercializzazioneFilter = taifTCommercializzazioneDao
					.findProvenienzaByIdProvenienzaVisible(provenienzaFilter);
			if (listCommercializzazioneFilter == null) {
				listCommercializzazioneFilter = new ArrayList<TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto>();
			}
			return listCommercializzazioneFilter;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findProvenienzaByIdProvenienzaVisible] END");
		}

	}

	public List<TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto> findCommUmByIdUnitaMisuraVisible(
			UnitaMisuraFilter unitaMisuraFilter) throws DbManagerException {
		log.debug("[DbMgr::findCommUmByIdUnitaMisuraVisible] BEGIN ");
		try {
			List<TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto> listCommercializzazioneFilter = new ArrayList<TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto>();
			listCommercializzazioneFilter = taifTCommercializzazioneDao
					.findCommUmByIdUnitaMisuraVisible(unitaMisuraFilter);
			if (listCommercializzazioneFilter == null) {
				listCommercializzazioneFilter = new ArrayList<TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto>();
			}
			return listCommercializzazioneFilter;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCommUmByIdUnitaMisuraVisible] END");
		}

	}

	public List<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto> findFindFunzioneTipoStrutturaByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws DbManagerException {
		log.debug("[DbMgr::findFindFunzioneTipoStrutturaByIdAzienda] BEGIN ");
		try {
			List<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto> listStruttureFilter = new ArrayList<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto>();
			listStruttureFilter = taifTStrutturaDao.findFindFunzioneTipoStrutturaByIdAzienda(aziendaVisibleFilter);
			if (listStruttureFilter == null) {
				listStruttureFilter = new ArrayList<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto>();
			}
			return listStruttureFilter;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findFindFunzioneTipoStrutturaByIdAzienda] END");
		}

	}

	public List<TaifTDpiDpiByAziendaVisibileDto> findDpiByAziendaVisibile(AziendaVisibleFilter aziendaVisibleFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findDpiByAziendaVisibile] BEGIN ");
		try {
			List<TaifTDpiDpiByAziendaVisibileDto> listDispositivi = new ArrayList<TaifTDpiDpiByAziendaVisibileDto>();
			listDispositivi = taifTDpiDao.findDpiByAziendaVisibile(aziendaVisibleFilter);
			if (listDispositivi == null) {
				listDispositivi = new ArrayList<TaifTDpiDpiByAziendaVisibileDto>();
			}
			return listDispositivi;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findDpiByAziendaVisibile] END");
		}

	}

	public List<TaifTMezzoByTipoMezzoAziendaVisibileDto> findByTipoMezzoAziendaVisibile(TipoMezzoFilter tipoMezzoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findDpiByAziendaVisibile] BEGIN ");
		try {
			List<TaifTMezzoByTipoMezzoAziendaVisibileDto> listMezzi = new ArrayList<TaifTMezzoByTipoMezzoAziendaVisibileDto>();
			listMezzi = taifTMezzoDao.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
			if (listMezzi == null) {
				listMezzi = new ArrayList<TaifTMezzoByTipoMezzoAziendaVisibileDto>();
			}
			return listMezzi;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findDpiByAziendaVisibile] END");
		}

	}

	public List<TaifRTrazTipoMezzoByIdTipoMezzoDto> findByIdTipoMezzo(Integer input) throws DbManagerException {
		log.debug("[DbMgr::findByIdTipoMezzo] BEGIN ");
		try {
			List<TaifRTrazTipoMezzoByIdTipoMezzoDto> tipoMezzi = new ArrayList<TaifRTrazTipoMezzoByIdTipoMezzoDto>();
			tipoMezzi = taifRTrazTipoMezzoDao.findByIdTipoMezzo(input);
			if (tipoMezzi == null) {
				tipoMezzi = new ArrayList<TaifRTrazTipoMezzoByIdTipoMezzoDto>();
			}
			return tipoMezzi;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByIdTipoMezzo] END");
		}

	}

	public TaifRTrazTipoMezzoDto findByPrimaryKey(Integer idMezzo, Integer idTrazione) throws DbManagerException {
		log.debug("[DbMgr::findByIdTipoMezzo] BEGIN ");
		try {
			TaifRTrazTipoMezzoDto tipoMezzo = new TaifRTrazTipoMezzoDto();
			tipoMezzo = taifRTrazTipoMezzoDao.findByPrimaryKey(new TaifRTrazTipoMezzoPk(idMezzo, idTrazione));
			if (tipoMezzo == null) {
				tipoMezzo = new TaifRTrazTipoMezzoDto();
			}
			return tipoMezzo;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByIdTipoMezzo] END");
		}

	}

	public List<TaifDCategoriaMezzoByIdTipoMezzoDto> findTipoECategoriaByIdTipoMezzo(TipoMezzoFilter tipoMezzoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findDpiByAziendaVisibile] BEGIN ");
		try {
			List<TaifDCategoriaMezzoByIdTipoMezzoDto> listCategoriaByIdMezzo = new ArrayList<TaifDCategoriaMezzoByIdTipoMezzoDto>();
			listCategoriaByIdMezzo = taifDCategoriaMezzoDao.findByIdTipoMezzo(tipoMezzoFilter);
			if (listCategoriaByIdMezzo == null) {
				listCategoriaByIdMezzo = new ArrayList<TaifDCategoriaMezzoByIdTipoMezzoDto>();
			}
			return listCategoriaByIdMezzo;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findDpiByAziendaVisibile] END");
		}

	}

	public TaifDTrazioneDto findTipoTrazioneByIdTrazione(Integer idTipoTrazione) throws DbManagerException {
		log.debug("[DbMgr::findTipoTrazioneByIdTrazione] BEGIN ");
		try {
			TaifDTrazioneDto tipoTrazione = new TaifDTrazioneDto();
			tipoTrazione = taifDTrazioneDao.findByPrimaryKey(new TaifDTrazionePk(idTipoTrazione));
			if (tipoTrazione == null) {
				tipoTrazione = new TaifDTrazioneDto();
			}
			return tipoTrazione;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findTipoTrazioneByIdTrazione] END");
		}
	}

	public TaifDAlimentazioneDto findTipoAllimentazioneMezzoById(Integer idTipoAlimentazione)
			throws DbManagerException {
		log.debug("[DbMgr::findTipoAllimentazioneMezzoById] BEGIN ");
		try {
			TaifDAlimentazioneDto tipoAlimentazione = new TaifDAlimentazioneDto();
			tipoAlimentazione = taifDAlimentazioneDao.findByPrimaryKey(new TaifDAlimentazionePk(idTipoAlimentazione));
			if (tipoAlimentazione == null) {
				tipoAlimentazione = new TaifDAlimentazioneDto();
			}
			return tipoAlimentazione;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findTipoAllimentazioneMezzoById] END");
		}
	}

	public TaifDTipoCarrelloDto findTipoCarrelloByIdCarello(Integer idTipoCarrello) throws DbManagerException {
		log.debug("[DbMgr::findTipoCarrelloByIdCarello] BEGIN ");
		try {
			TaifDTipoCarrelloDto tipoCarrello = new TaifDTipoCarrelloDto();
			tipoCarrello = taifDTipoCarrelloDao.findByPrimaryKey(new TaifDTipoCarrelloPk(idTipoCarrello));
			if (tipoCarrello == null) {
				tipoCarrello = new TaifDTipoCarrelloDto();
			}
			return tipoCarrello;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findTipoCarrelloByIdCarello] END");
		}
	}

	public List<TaifRPersonaAziendaByIdAziendaDto> getPersonePerIdAzienda(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getElencoDurateContratti] BEGIN");
		try {

			List<TaifRPersonaAziendaByIdAziendaDto> listPersoneAzienda = new ArrayList<TaifRPersonaAziendaByIdAziendaDto>();
			if (listPersoneAzienda != null) {
				listPersoneAzienda = taifRPersonaAziendaDao.findByIdAzienda(idAzienda);
			}
			return listPersoneAzienda;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoDurateContratti] END");
		}
	}

	public TaifTPersonaDto getPersonaByIdPersona(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::getPersonaByIdPersona] BEGIN");
		try {
			TaifTPersonaDto personaByIdPersona = taifTPersonaDao.findByPrimaryKey(new TaifTPersonaPk(idPersona));
			if (personaByIdPersona != null) {
				return personaByIdPersona;
			} else {
				return new TaifTPersonaDto();
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaByIdPersona] END");
		}
	}

	public TaifDTipoContrattoByIdContrattoDto findTipoContrattoByIdAndVisibile(ContrattoFilter contrattoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findTipoContrattoByIdAndVisibile] BEGIN ");
		try {
			List<TaifDTipoContrattoByIdContrattoDto> contratto = taifDTipoContrattoDao
					.findByIdContratto(contrattoFilter);
			if (contratto == null) {
				return new TaifDTipoContrattoByIdContrattoDto();
			}
			return contratto.get(0);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findTipoContrattoByIdAndVisibile] END");
		}
	}

	public TaifDTipoInquadramentoByIdInquadramentoDto findTipoInquadramentoByIdVisibile(InquadramentoFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::findTipoInquadramentoByIdVisibile] BEGIN ");
		try {
			List<TaifDTipoInquadramentoByIdInquadramentoDto> inquadramento = taifDTipoInquadramentoDao
					.findByIdInquadramento(filter);
			if (inquadramento == null) {
				return new TaifDTipoInquadramentoByIdInquadramentoDto();
			}
			return inquadramento.get(0);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findTipoInquadramentoByIdVisibile] END");
		}
	}

	public TitolareRappresentanteLegale findByCodiceFiscalePersona(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::findByCodiceFiscalePersona] BEGIN ");
		TitolareRappresentanteLegale titolareRappLegale = new TitolareRappresentanteLegale();
		try {

			List<TaifTPersonaByCodiceFiscalePersonaDto> personaPerCodiceFiscale = taifTPersonaDao
					.findByCodiceFiscalePersona(codiceFiscale);
			if (personaPerCodiceFiscale != null && personaPerCodiceFiscale.size() > 0) {
				TaifTPersonaByCodiceFiscalePersonaDto dto = personaPerCodiceFiscale.get(0);
				titolareRappLegale = dozerBeanMapper.map(dto, TitolareRappresentanteLegale.class);
			}

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByCodiceFiscalePersona] END");
		}
		return titolareRappLegale;
	}
	public TitolareRappresentanteLegale findLastByCodiceFiscalePersona(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::findLastByCodiceFiscalePersona] BEGIN ");
		TitolareRappresentanteLegale titolareRappLegale = new TitolareRappresentanteLegale();
		try {

			List<TaifTPersonaByCodiceFiscalePersonaDto> personaPerCodiceFiscale = taifTPersonaDao
					.findByCodiceFiscalePersona(codiceFiscale);
			if (personaPerCodiceFiscale != null && personaPerCodiceFiscale.size() > 0) {
				int last = personaPerCodiceFiscale.size() - 1;
				TaifTPersonaByCodiceFiscalePersonaDto dto = personaPerCodiceFiscale.get(last);
				titolareRappLegale = dozerBeanMapper.map(dto, TitolareRappresentanteLegale.class);
			}

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findLastByCodiceFiscalePersona] END");
		}
		return titolareRappLegale;
	}
	public ArrayList<CodeDescription> getElencoStatiPraticaIta(StatoPraticaFilter statoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoStatiPraticaIta] BEGIN ");
		try {
			ArrayList<CodeDescription> destList = new ArrayList<CodeDescription>();
			List<TaifDStatoPraticaElencoStatiPraticaItaliaDto> listStatoPratica = taifDStatoPraticaDao
					.findElencoStatiPraticaItalia(statoFilter);
			for (TaifDStatoPraticaElencoStatiPraticaItaliaDto statoPratica : listStatoPratica) {
				CodeDescription result = dozerBeanMapper.map(statoPratica, CodeDescription.class);
				destList.add(result);
			}
			log.debug("_______ LIST DESTLIST STATI ______ " + destList.size());
			return destList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoStatiPraticaIta] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatiPraticaFra(StatoPraticaFilter statoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoStatiPraticaIta] BEGIN ");
		try {
			ArrayList<CodeDescription> destList = new ArrayList<CodeDescription>();
			List<TaifDStatoPraticaElencoStatiPraticaFranceDto> listStatoPraticaFra = taifDStatoPraticaDao
					.findElencoStatiPraticaFrance(statoFilter);
			for (TaifDStatoPraticaElencoStatiPraticaFranceDto statoPratica : listStatoPraticaFra) {
				CodeDescription result = dozerBeanMapper.map(statoPratica, CodeDescription.class);
				destList.add(result);
			}
			return destList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoStatiPraticaIta] END");
		}
	}

	public ArrayList<CodeDescription> getElencoSottoStatiPraticaIta(StatoPraticaFilter statoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoSottoStatiPraticaIta] BEGIN ");
		try {
			ArrayList<CodeDescription> destList = new ArrayList<CodeDescription>();
			List<TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto> listSottoStatoPraticaIta = taifDStatoPraticaDao
					.findElencoSottoStatiPraticaItalia(statoFilter);
			for (TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto sottoStatoPratica : listSottoStatoPraticaIta) {
				// CodeDescription result = dozerBeanMapper.map(sottoStatoPratica,
				// CodeDescription.class);

				CodeDescription result = new CodeDescription();
				result.setCode(sottoStatoPratica.getId() + "");
				result.setDescription(sottoStatoPratica.getStatoPratica());

				destList.add(result);
			}
			return destList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoSottoStatiPraticaIta] END");
		}
	}

	public ArrayList<CodeDescription> getElencoSottoStatiPraticaFra(StatoPraticaFilter statoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoSottoStatiPraticaFra] BEGIN ");
		try {
			ArrayList<CodeDescription> destList = new ArrayList<CodeDescription>();
			List<TaifDStatoPraticaElencoSottoStatiPraticaFranceDto> listSottoStatoPraticaFra = taifDStatoPraticaDao
					.findElencoSottoStatiPraticaFrance(statoFilter);
			for (TaifDStatoPraticaElencoSottoStatiPraticaFranceDto sottoStatoPratica : listSottoStatoPraticaFra) {
				// CodeDescription result = dozerBeanMapper.map(sottoStatoPratica,
				// CodeDescription.class);

				CodeDescription result = new CodeDescription();
				result.setCode(sottoStatoPratica.getId() + "");
				result.setDescription(sottoStatoPratica.getStatoPratica());

				destList.add(result);
			}
			return destList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoSottoStatiPraticaFra] END");
		}
	}

	public ArrayList<BeFormaOrganizzativaDto> getElencoFormeOrganizzativeFeToBeFinal(
			ArrayList<FormaOrganizzativa> formeOrganizzative) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormeOrganizzative] BEGIN");
		try {
			ArrayList<BeFormaOrganizzativaDto> associazioneList = new ArrayList<BeFormaOrganizzativaDto>();
			for (FormaOrganizzativa forme : formeOrganizzative) {
				if (forme.getIdFormaOrganizzativa() == 5 || forme.getIdFormaOrganizzativa() == 6
						|| forme.getIdFormaOrganizzativa() == 7) {
					forme.setAltroVisibile(true);
				}
				associazioneList.add(dozerBeanMapper.map(forme, BeFormaOrganizzativaDto.class));
			}
			return associazioneList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormeOrganizzative] END");
		}
	}

	public BeSedeDto getSedeLegalePerAziendaFeToBe(Sede feSedeLegale) throws DbManagerException {

		log.debug("[DbMgr::getSedeLegalePerAziendaFeToBe] BEGIN");
		BeSedeDto beSedeLegaleDestination = new BeSedeDto();

		try {
			beSedeLegaleDestination = dozerBeanMapper.map(feSedeLegale, BeSedeDto.class);
			return beSedeLegaleDestination;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getSedeLegalePerAziendaFeToBe] END");
		}

	}

	public Riepilogo getRiepilogo(Integer idAzienda, Integer idAlbo) throws DbManagerException {
		log.debug("[DbMgr::getRiepilogo] BEGIN");
		Riepilogo result = null;
		try {
			List<TaifTAziendaIntestazioneRiepilogoDto> list = this.taifTAziendaExtDao
					.findIntestazioneRiepilogo(idAzienda, idAlbo);
			TaifTAziendaIntestazioneRiepilogoDto dto = null;
			if (list != null && !list.isEmpty()) {
				dto = list.get(0);
			}

			TaifApplSchedaOkDto schedaOk = this.taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));

			if (schedaOk != null) {
				result = RiepilogoFactory.createRiepilogo(schedaOk, dto);
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getRiepilogo] END");
		}
		return result;
	}

	public Riepilogo getRiepilogoByPratica(Integer idPratica) throws DbManagerException {
		log.debug("[DbMgr::getRiepilogoByPratica] BEGIN");
		Riepilogo result = null;
		try {
			List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> list = this.taifTAziendaExtDao
					.findIntestazioneRiepilogoByPratica(idPratica);
			List<TaifApplSchedaOkByPraticaDto> listSchedaOk = this.taifApplSchedaOkDao.findByPratica(idPratica);
			result = RiepilogoFactory.createRiepilogo(list, listSchedaOk);

			// List<TaifVApplSchedaOkRealeDto> listSchedaOk =
			// this.taifVApplSchedaOkRealeDao.findByPratica(idPratica);
			// result = RiepilogoFactory.createRiepilogoVista(list, listSchedaOk);

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getRiepilogoByPratica] END");
		}
		return result;
	}

	public ArrayList<Domanda> findElencoDomandaByLegaleRapp(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::findElencoDomandaByLegaleRapp] BEGIN");
		try {

			ArrayList<Domanda> listDomanda = new ArrayList<Domanda>();
			List<TaifTAziendaElencoDomandaByLegaleRappDto> elencoPratiche = taifTAziendaDao
					.findElencoDomandaByLegaleRapp(codiceFiscale);
			for (TaifTAziendaElencoDomandaByLegaleRappDto forme : elencoPratiche) {
				Domanda domanda = dozerBeanMapper.map(forme, Domanda.class);
				// listDomanda.add(dozerBeanMapper.map(forme, Domanda.class));
				listDomanda.add(domanda);
			}
			return listDomanda;
		} catch (Exception e) {
			log.error(" sssss : ", e);
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findElencoDomandaByLegaleRapp] END");
		}

	}

	public Integer insertAllegato(int idPratica, Allegato allegato, int idConfigUtente) throws DbManagerException {
		log.debug("[DbMgr::insertAllegato] BEGIN");
		try {
			TaifTAllegatoDto taifTAllegato = dozerBeanMapper.map(allegato, TaifTAllegatoDto.class);
			taifTAllegato.setDataAggiornamento(DateUtil.getTimestampDataCorrente());
			taifTAllegato.setDataInserimento(DateUtil.getTimestampDataCorrente());
			taifTAllegato.setDataUpload(DateUtil.getTimestampDataCorrente());
			taifTAllegato.setFkCorso(null);
			taifTAllegato.setFkPersona(null);
			taifTAllegato.setFkPratica(idPratica);
			String estensione = org.apache.commons.lang3.StringUtils.substringAfterLast(allegato.getNomeFile(), ".");
			taifTAllegato.setEstensioneFile(estensione);
			taifTAllegato.setFkEstensioneFile(this.getIdEstensioneFile(estensione, allegato.getIdTipoAllegato()));
			taifTAllegato.setFkConfigUtente(idConfigUtente);

			TaifTAllegatoPk pk = this.taifTAllegatoDao.insert(taifTAllegato);
			return pk.getIdAllegato();
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::insertAllegato] END");
		}
	}

	private Integer getIdEstensioneFile(String estensione, int idTipoAllegato) throws DaoException {
		Integer result = null;
		List<TaifCnfEstensAmmDto> list = this.taifCnfEstensAmmDao.findByEstensioneFileAndTipoAllegato(estensione,
				idTipoAllegato);
		if (list != null && !list.isEmpty()) {
			result = list.get(0).getIdEstensioneFile();
		}
		return result;
	}

	public List<TaifTPersonaByCodiceFiscalePersonaDto> findPersonaPerCodiceFiscale(String codiceFiscale)
			throws DbManagerException, TaifTPersonaDaoException {
		log.debug("[DbMgr::findPersonaPerCodiceFiscale] BEGIN");
		try {
			List<TaifTPersonaByCodiceFiscalePersonaDto> persoanaByCodiceFiscale = taifTPersonaDao
					.findByCodiceFiscalePersona(codiceFiscale);
			return persoanaByCodiceFiscale;
		} finally {
			log.debug("[DbMgr::findPersonaPerCodiceFiscale] END");
		}
	}

	public void update(TaifTPersonaDto personaDto) throws DbManagerException {
		log.debug("[DbMgr::findPersonaPerCodiceFiscale] BEGIN ");
		try {
			taifTPersonaDao.update(personaDto);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findPersonaPerCodiceFiscale] END");
		}
	}

	public void updateColumnsForTitolareRappresentante(Integer idAzienda, TitolareRappresentanteLegale titolare,
			TitolareRappresentanteLegale altroTitolare, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			List<TaifTPersonaByFilterDto> titolarePerCodiceFiscale, String esisteConduttore, String dataTracciato)
			throws ManagerException {

		log.debug("[DbMgr::updateColumnsForTitolareRappresentante] BEGIN");

		TaifRPersonaAziendaDto personaAziendaC = new TaifRPersonaAziendaDto();
		BeTitolareRappresentanteLegaleDto backAltroTitolare = new BeTitolareRappresentanteLegaleDto();
		TaifApplSchedaOkDto taifApplSchedaOkDto = new TaifApplSchedaOkDto();
		UserTransaction utx = txManager.getUserTransaction();

		idConfigUtente = profiloUtente.getIdConfigUtente();

		try {
			utx.begin();
			if (titolare != null) {
				updateTitolareRappresentanteLegale(idAzienda, titolare, titolarePerCodiceFiscale, profiloUtente,
						dataTracciato, 1);
			}
			if (dataTracciato.equals(Constants.iLang)) {
				if (esisteConduttore.equals(Constants.NO)) {

					PersonaFilter personaFilter = new PersonaFilter();
					if (titolare.getCodiceFiscale() != null
							&& StringUtils.isNotEmpty(altroTitolare.getCodiceFiscale())) {
						personaFilter.setCodiceFiscale(altroTitolare.getCodiceFiscale());
					}
					if (titolare.getNrsiMsa() != null && StringUtils.isNotEmpty(titolare.getNrsiMsa())) {
						personaFilter.setCodiceFiscale(titolare.getNrsiMsa());
					}
					
						personaFilter.setIdNazione(ConvertUtil.toInteger(titolare.getIdStatoNascita()));
					
					List<TaifTPersonaByFilterDto> conduttoreCodiceFiscale = findPersonaByFilter(personaFilter);

					TaifTPersonaDto personaToSaveC = new TaifTPersonaDto();
					if (conduttoreCodiceFiscale != null && !conduttoreCodiceFiscale.isEmpty()) {
						log.debug("[DbMgr::updateColumnsForTitolareRappresentante] conduttoreCodiceFiscale NOT NULL OR EMPTY");

						updateTitolareRappresentanteLegale(idAzienda, altroTitolare, conduttoreCodiceFiscale,
								profiloUtente, dataTracciato, 2);
					} else {
						log.debug("[DbMgr::updateColumnsForTitolareRappresentante] conduttoreCodiceFiscale NULL OR EMPTY");

						backAltroTitolare = getTitolareRappresentanteLegalePerAziendaFeToBe(altroTitolare);
						personaToSaveC = dozerBeanMapper.map(backAltroTitolare, TaifTPersonaDto.class);
						personaToSaveC.setAltriStudi(backAltroTitolare.getAltriStudi());
						if (getIdNazioneFromStatoNascita(backAltroTitolare).getIdStatoNascita().equals(Constants.one)) {
							personaToSaveC.setFkTitoloStudioFra(Integer.parseInt(Constants.zero));
							personaToSaveC.setFkTitoloStudio(Integer.parseInt(backAltroTitolare.getIdTitoloDiStudio()));
						} else {
							personaToSaveC
									.setFkTitoloStudioFra(Integer.parseInt(backAltroTitolare.getIdTitoloDiStudio()));
							personaToSaveC.setFkTitoloStudio(Integer.parseInt(Constants.zero));
						}
						personaToSaveC.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						personaToSaveC.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						//taif-23
						if(altroTitolare.getIdStatoNascita().equalsIgnoreCase(Constants.one)) {
							personaToSaveC.setIstatComuneNascita(altroTitolare.getIdComuneNascita());
						} else {
							personaToSaveC.setComuneEsteroNascita(altroTitolare.getDsComuneResidenzaNoIta());
						}
						TaifTPersonaPk idConduttore = taifTPersonaDao.insert(personaToSaveC);

						personaAziendaC.setIdAzienda(idAzienda);
						personaAziendaC.setIdPersona(idConduttore.getIdPersona());
						personaAziendaC.setFkRuolo(Constants.twoInt);
						personaAziendaC.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						personaAziendaC.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));

						personaAziendaC
								.setFkTipoMansione(getCodiceMansione(getMansioneFilterNessunDato(dataTracciato)));
						personaAziendaC.setFkTipoContratto(Integer.parseInt(Constants.zero));
						personaAziendaC
								.setFkTipoInquadramento(getCodiceInquadramento(getInquadramentoFilterNessunDato()));

						personaAziendaC.setFkConfigUtente(idConfigUtente);

						taifRPersonaAziendaDao.insert(personaAziendaC);
					}
				} else {
					// delete a conduttore
					TaifRPersonaAziendaDto conduttoreDto = new TaifRPersonaAziendaDto();
					List<TaifTPersonaByCodiceFiscalePersonaDto> conduttoreCodiceFiscale = new ArrayList<TaifTPersonaByCodiceFiscalePersonaDto>();
					if (altroTitolare != null && altroTitolare.getCodiceFiscale() != null) {
						conduttoreCodiceFiscale = findPersonaPerCodiceFiscale(altroTitolare.getCodiceFiscale());
						if (conduttoreCodiceFiscale != null) {
							for (TaifTPersonaByCodiceFiscalePersonaDto conduttoreRel : conduttoreCodiceFiscale) {
								conduttoreDto = taifRPersonaAziendaDao.findByPrimaryKey(
										new TaifRPersonaAziendaPk(conduttoreRel.getIdPersona(), idAzienda));
								if (conduttoreDto != null && conduttoreDto.getFkRuolo() == Constants.twoInt) {
									taifRPersonaAziendaDao
											.delete(new TaifRPersonaAziendaPk(conduttoreRel.getIdPersona(), idAzienda));
								}
							}
						}
					}
				}
			}
			taifApplSchedaOkDto = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (dataTracciato.equals(Constants.iLang)) {
				taifApplSchedaOkDto.setFlgSez12ItaOk(new BigDecimal(Constants.one));
				taifApplSchedaOkDto.setFlgSez12FraOk(new BigDecimal(Constants.zero));

			} else {
				taifApplSchedaOkDto.setFlgSez12FraOk(new BigDecimal(Constants.one));
				taifApplSchedaOkDto.setFlgSez12ItaOk(new BigDecimal(Constants.zero));
			}
			taifApplSchedaOkDao.update(taifApplSchedaOkDto);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updateColumnsForTitolareRappresentante] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updateColumnsForTitolareRappresentante] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updateColumnsForTitolareRappresentante] END");
		}

		log.debug("[DbMgr::updateColumnsForTitolareRappresentante] END");
	}

	private void updateTitolareRappresentanteLegale(Integer idAzienda, TitolareRappresentanteLegale titolare,
			List<TaifTPersonaByFilterDto> titolarePerCodiceFiscale,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String dataTracciato, int tipoRuolo)
			throws DbManagerException, TaifTPersonaDaoException, TaifRPersonaAziendaDaoException {
		log.debug("[DbMgr::updateTitolareRappresentanteLegale] BEGIN");
		// TaifRPersonaAziendaDto personaAzienda = new TaifRPersonaAziendaDto();
		TaifTPersonaDto personaForUpdate = new TaifTPersonaDto();
		TaifTPersonaDto personaForUpdateAfter = new TaifTPersonaDto();
		idConfigUtente = profiloUtente.getIdConfigUtente();

		Integer idPersona = null;
		Timestamp dataInserimento = null;
		if (titolarePerCodiceFiscale.size() > 1) {
			for (TaifTPersonaByFilterDto taifTPersonaByCodiceFiscalePersonaDto : titolarePerCodiceFiscale) {
				if (taifTPersonaByCodiceFiscalePersonaDto.getCognome().equalsIgnoreCase(titolare.getCognome())
						&& taifTPersonaByCodiceFiscalePersonaDto.getNome().equalsIgnoreCase(titolare.getNome())) {
					personaForUpdate = getPersonaByIdPersona(taifTPersonaByCodiceFiscalePersonaDto.getId());
					idPersona = taifTPersonaByCodiceFiscalePersonaDto.getId();
					break;
				}
			}
		} else {
			personaForUpdate = getPersonaByIdPersona(titolarePerCodiceFiscale.get(0).getId());
			idPersona = titolarePerCodiceFiscale.get(0).getId();

		}
		dataInserimento = personaForUpdate.getDataInserimento();

		personaForUpdateAfter = dozerBeanMapper.map(titolare, TaifTPersonaDto.class);
		if (dataTracciato.equals(Constants.fLang)) {
			personaForUpdateAfter.setNRsiMsa(titolare.getNrsiMsa());
		}
		personaForUpdateAfter.setIdPersona(idPersona);
		personaForUpdateAfter.setFkTitoloStudio(personaForUpdate.getFkTitoloStudio());
		personaForUpdateAfter.setFkTitoloStudioFra(personaForUpdate.getFkTitoloStudioFra());
		if (dataTracciato.equals(Constants.fLang)) {
			personaForUpdateAfter.setFkTitoloStudioFra(Integer.parseInt(titolare.getIdTitoloDiStudio()));
			personaForUpdateAfter.setComuneEsteroNascita(titolare.getDsComuneNascitaNoIta());
			personaForUpdateAfter.setComuneEsteroRes(titolare.getDsComuneResidenzaNoIta());
		} else {
			personaForUpdateAfter.setFkTitoloStudio(Integer.parseInt(titolare.getIdTitoloDiStudio()));
			
			//TAIF-23
			if (titolare.getIdStatoNascita().equals(Constants.one)) {
				log.info("[DbMgr::updateTitolareRappresentanteLegale] STATO ITALIA");
				personaForUpdateAfter.setIstatComuneNascita(titolare.getIdComuneNascita());
			}else {
				log.info("[DbMgr::updateTitolareRappresentanteLegale] STATO ESTERO COMUNE: " + titolare.getDsComuneNascitaNoIta());

				personaForUpdateAfter.setComuneEsteroNascita(titolare.getDsComuneNascitaNoIta());
			}
			personaForUpdateAfter.setIstatComuneRes(titolare.getIdComuneResidenza());
		}
		personaForUpdateAfter.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		personaForUpdateAfter.setFkConfigUtente(idConfigUtente);

		taifTPersonaDao.updateColumnsForTitolareRappresentante(personaForUpdateAfter);

		TaifRPersonaAziendaDto personaAzienda = taifRPersonaAziendaDao
				.findByPrimaryKey(new TaifRPersonaAziendaPk(idPersona, idAzienda));
		if (personaAzienda != null && personaAzienda.getIdAzienda() != null) {

			personaAzienda.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			personaAzienda.setFkConfigUtente(idConfigUtente);

			taifRPersonaAziendaDao.updateColumnsPersonaAzienda(personaAzienda);
		} else {
			personaAzienda = new TaifRPersonaAziendaDto();
			personaAzienda.setIdAzienda(idAzienda);
			personaAzienda.setIdPersona(personaForUpdate.getIdPersona());
			personaAzienda.setFkRuolo(tipoRuolo); // legalerappresentante
			personaAzienda.setDataInserimento(new Timestamp(System.currentTimeMillis()));
			personaAzienda.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			personaAzienda.setFkConfigUtente(idConfigUtente);
			personaAzienda.setFkTipoMansione(getCodiceMansione(getMansioneFilterNessunDato(dataTracciato)));
			personaAzienda.setFkTipoContratto(Integer.parseInt(Constants.zero));
			personaAzienda.setFkTipoInquadramento(getCodiceInquadramento(getInquadramentoFilterNessunDato()));

			taifRPersonaAziendaDao.insert(personaAzienda);
		}
		log.debug("[DbMgr::updateTitolareRappresentanteLegale] END");

	}

	public boolean existeCodiceFiscaleAzienda(String codiceFiscaleAzienda) throws DbManagerException {
		log.debug("[DbMgr::existeCodiceFiscaleAzienda] BEGIN ");
		try {
			boolean esiste = false;
			List<TaifTAziendaByCodiceFiscaleDto> aziendaByCf = taifTAziendaDao
					.findByCodiceFiscale(codiceFiscaleAzienda);
			if (aziendaByCf != null && !aziendaByCf.isEmpty()) {
				esiste = true;
			}
			return esiste;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::existeCodiceFiscaleAzienda] END");
		}
	}

	public boolean existePivaAzienda(String piva) throws DbManagerException {
		log.debug("[DbMgr::existePivaAzienda] BEGIN ");
		try {
			boolean esiste = false;
			List<TaifTAziendaByPivaDto> aziendaByPiva = taifTAziendaDao.findByPiva(piva);
			if (aziendaByPiva != null && !aziendaByPiva.isEmpty()) {
				esiste = true;
			}
			return esiste;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::existePivaAzienda] END");
		}
	}

	public void updateColumnsForPersonaleAzienda(Integer idAzienda, ArrayList<Personale> listForUpdatePersonale,
			int idConfigUtente, String dataTracciato) throws ManagerException {

		log.debug("[DbMgr::updateColumnsForPersonaleAzienda] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();

			List<Integer> personaIdFromFe = new ArrayList<Integer>();
			List<TaifTPersonaByIdAziendaDto> personeEsistentePerAzienda = taifTPersonaDao.findByIdAzienda(idAzienda);
			if (listForUpdatePersonale != null && !listForUpdatePersonale.isEmpty()) {
				for (Personale personale : listForUpdatePersonale) {
					personaIdFromFe.add(personale.getIdPersonale());
				}
				for (TaifTPersonaByIdAziendaDto persEsistente : personeEsistentePerAzienda) {
					if (!(personaIdFromFe.contains(persEsistente.getIdPersona()))) {
						if (persEsistente.getIdRuoloPersona() != 1 && persEsistente.getIdRuoloPersona() != 2) {
							taifRPersonaAziendaDao
									.delete(new TaifRPersonaAziendaPk(persEsistente.getIdPersona(), idAzienda));
						}
					}
				}
				for (Personale personale : listForUpdatePersonale) {
					List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale = findPersonaPerCodiceFiscale(
							personale.getCodiceFiscale());
					updatePersonaAggiuntaPerAzienda(idAzienda, personale, titolarePerCodiceFiscale, idConfigUtente,
							dataTracciato);
				}
			} else {
				for (TaifTPersonaByIdAziendaDto persEsistente : personeEsistentePerAzienda) {
					if (persEsistente.getIdRuoloPersona() != 1 && persEsistente.getIdRuoloPersona() != 2) {
						taifRPersonaAziendaDao
								.delete(new TaifRPersonaAziendaPk(persEsistente.getIdPersona(), idAzienda));
					}
				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updateColumnsForPersonaleAzienda] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updateColumnsForPersonaleAzienda] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updateColumnsForPersonaleAzienda] END");
		}
	}

	private void updatePersonaAggiuntaPerAzienda(Integer idAzienda, Personale persona,
			List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale, int idConfigUtente,
			String dataTracciato) throws DbManagerException, TaifTPersonaDaoException, TaifRPersonaAziendaDaoException,
			TaifApplSchedaOkDaoException {
		TaifTPersonaDto personaForUpdate = new TaifTPersonaDto();
		aziendaFrTipoMansDto = new TaifRAziendaFrTipoMansDto();
		aziendaFrTipoContrDto = new TaifRAziendaFrTipoContrDto();
		TaifApplSchedaOkDto schedaToUpdate = new TaifApplSchedaOkDto();

		Integer idPersona = null;
		try {
			if (titolarePerCodiceFiscale.size() > 1) {
				for (TaifTPersonaByCodiceFiscalePersonaDto taifTPersonaByCodiceFiscalePersonaDto : titolarePerCodiceFiscale) {
					if (taifTPersonaByCodiceFiscalePersonaDto.getCognome().equalsIgnoreCase(persona.getCognome())
							&& taifTPersonaByCodiceFiscalePersonaDto.getNome().equalsIgnoreCase(persona.getNome())) {
						personaForUpdate = getPersonaByIdPersona(taifTPersonaByCodiceFiscalePersonaDto.getIdPersona());
						idPersona = taifTPersonaByCodiceFiscalePersonaDto.getIdPersona();
						break;
					}
				}
			} else {
				personaForUpdate = getPersonaByIdPersona(titolarePerCodiceFiscale.get(0).getIdPersona());
				idPersona = titolarePerCodiceFiscale.get(0).getIdPersona();
			}
			// personaForUpdate = dozerBeanMapper.map(persona, TaifTPersonaDto.class);
			personaForUpdate.setIdPersona(idPersona);
			if (dataTracciato.equals(Constants.fLang)) {
				personaForUpdate.setFkTitoloStudioFra(persona.getIdTipologiaPersonale());
				// personaForUpdate.setFkTitoloStudio(Integer.parseInt(Constants.zero));
			} else {
				personaForUpdate.setFkTitoloStudio(persona.getIdTipologiaPersonale());
				// personaForUpdate.setFkTitoloStudioFra(Integer.parseInt(Constants.zero));
			}
			personaForUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			personaForUpdate.setFkConfigUtente(idConfigUtente);
			taifTPersonaDao.updateColumnsForTitolareRappresentante(personaForUpdate);
			// test persona esiste in azienda
			TaifRPersonaAziendaDto personaAzienda = taifRPersonaAziendaDao
					.findByPrimaryKey(new TaifRPersonaAziendaPk(idPersona, idAzienda));
			if (personaAzienda != null && personaAzienda.getIdAzienda() != null) {

				personaAzienda.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				personaAzienda.setFkConfigUtente(idConfigUtente);
				
				//taif-11
				personaAzienda.setFkRuolo(persona.getIdTipologiaPersonale());
				personaAzienda.setFkTipoMansione(persona.getIdMansione());
				personaAzienda.setFkTipoContratto(persona.getIdContratto());
				personaAzienda.setFlgTempoDeterminato(new BigDecimal(persona.getIdDurataContratto()));
				if (StringUtils.isNotEmpty(persona.getGiorniNellAnno())
						&& StringUtils.isNotBlank(persona.getGiorniNellAnno())) {
					personaAzienda.setGgTempoDeterminato(Integer.valueOf(persona.getGiorniNellAnno()));
				}
				personaAzienda.setFkTipoInquadramento(persona.getIdInquadramento());

				taifRPersonaAziendaDao.updateColumnsPersonaAzienda(personaAzienda);
			} else {
				personaAzienda = new TaifRPersonaAziendaDto();

				personaAzienda.setIdAzienda(idAzienda);
				personaAzienda.setIdPersona(personaForUpdate.getIdPersona());
				personaAzienda.setFkRuolo(persona.getIdTipologiaPersonale());
				personaAzienda.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				personaAzienda.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				personaAzienda.setFkConfigUtente(idConfigUtente);
				personaAzienda.setFkTipoMansione(persona.getIdMansione());
				personaAzienda.setFkTipoContratto(persona.getIdContratto());
				personaAzienda.setFkTipoInquadramento(persona.getIdInquadramento());
				personaAzienda.setFlgTempoDeterminato(new BigDecimal(persona.getIdDurataContratto()));
				if (StringUtils.isNotEmpty(persona.getGiorniNellAnno())
						&& StringUtils.isNotBlank(persona.getGiorniNellAnno())) {
					personaAzienda.setGgTempoDeterminato(Integer.valueOf(persona.getGiorniNellAnno()));
				}
				taifRPersonaAziendaDao.insert(personaAzienda);
			}
			if (dataTracciato.equals(Constants.fraLang)) {// per la parte francese- to do

				TaifRAziendaFrTipoContrDto aziendaFrTipoContrDto = taifRAziendaFrTipoContrDao
						.findByPrimaryKey(new TaifRAziendaFrTipoContrPk(idAzienda, persona.getIdContratto()));

				// aziendaFrTipoContrDto.setIdAzienda(idAzienda);
				// aziendaFrTipoContrDto.setIdTipoContratto(persona.getIdContratto());
				aziendaFrTipoContrDto.setNrAddetti(aziendaFrTipoContrDto.getNrAddetti() + 1);
				aziendaFrTipoContrDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				aziendaFrTipoContrDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				aziendaFrTipoContrDto.setFkConfigUtente(idConfigUtente);

				taifRAziendaFrTipoContrDao.updateColumnsUpdateForIdAziendaContratto(aziendaFrTipoContrDto);

				TaifRAziendaFrTipoMansDto aziendaFrTipoMansDto = taifRAziendaFrTipoMansDao
						.findByPrimaryKey(new TaifRAziendaFrTipoMansPk(idAzienda, persona.getIdMansione()));
				// aziendaFrTipoMansDto.setIdAzienda(idAzienda);
				// aziendaFrTipoMansDto.setIdTipoMansione(persona.getIdMansione());
				aziendaFrTipoMansDto.setNrAddetti(aziendaFrTipoMansDto.getNrAddetti() + 1);
				aziendaFrTipoMansDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				aziendaFrTipoMansDto.setFkConfigUtente(idConfigUtente);

				taifRAziendaFrTipoMansDao.updateColumnsUpdateForIdAziendaMansione(aziendaFrTipoMansDto);
			}
			schedaToUpdate = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (dataTracciato.equals(Constants.iLang)) {
				schedaToUpdate.setFlgSez6FraOk(new BigDecimal(Constants.zero));
				schedaToUpdate.setFlgSez6ItaOk(new BigDecimal(Constants.oneInt));
			} else {
				schedaToUpdate.setFlgSez6FraOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez6ItaOk(new BigDecimal(Constants.zero));
			}
			taifApplSchedaOkDao.update(schedaToUpdate);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}

	}

	public Personale findPersonaByCodiceFiscalePersonaPerContratto(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::findByCodiceFiscalePersonaPerContratto] BEGIN ");
		Personale persona = new Personale();
		try {

			List<TaifTPersonaByCodiceFiscalePersonaPerContrattoDto> personaPerCodiceFiscale = taifTPersonaDao
					.findByCodiceFiscalePersonaPerContratto(codiceFiscale);
			if (personaPerCodiceFiscale != null && !personaPerCodiceFiscale.isEmpty()) {
				if (personaPerCodiceFiscale.size() > 1) {
					TaifTPersonaByCodiceFiscalePersonaPerContrattoDto dto = personaPerCodiceFiscale.get(0);
					persona = dozerBeanMapper.map(dto, Personale.class);
				} else {
					persona = dozerBeanMapper.map(personaPerCodiceFiscale, Personale.class);
				}
			}

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByCodiceFiscalePersonaPerContratto] END");
		}
		return persona;
	}

	public Integer updateDatiAziendaSedeByIdAzienda(Integer idAzienda, BeAnagraficaAziendaleDto backAnagraficaAziendale,
			List<BeSedeDto> backSediList, Albo albo, int idConfigUtente, String dataTracciato)
			throws DbManagerException {

		log.debug("[DbMgr::updateAziendaByIdAzienda] BEGIN ");
		Integer result = idAzienda;
		TaifTSedeAziendaDto taifSedeAziendaUpdate = new TaifTSedeAziendaDto();
		TaifTSedeAziendaDto taifSedeAzienda = new TaifTSedeAziendaDto();
		TaifTSedeAziendaDto taifSedeAziendaInsert = new TaifTSedeAziendaDto();
		List<BeSedeDto> listTaifSedeAziendaInsert = new ArrayList<BeSedeDto>();
		List<BeSedeDto> listTaifSedeAziendaUpdate = new ArrayList<BeSedeDto>();
		try {
			// idConfigUtente = profiloUtente.getIdConfigUtente();

			TaifTAziendaDto aziendaToUpdateById = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			if (aziendaToUpdateById != null) {
				TaifTAziendaDto aziendaToUpdate = new TaifTAziendaDto();

				// aziendaToUpdate = dozerBeanMapper.map(backAnagraficaAziendale,
				// TaifTAziendaDto.class);
				aziendaToUpdateById.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				aziendaToUpdateById.setIdAzienda(idAzienda);

				aziendaToUpdateById.setFkConfigUtente(idConfigUtente);

				if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
					aziendaToUpdateById
							.setFkFormaGiuridicaFra(Integer.parseInt(backAnagraficaAziendale.getIdFormaGiurdica()));
					aziendaToUpdateById.setFkFormaGiuridicaIta(new Integer(0));
					aziendaToUpdateById
							.setFkAttivitaApe(Integer.parseInt(backAnagraficaAziendale.getIdAttivitaPrimaria()));
				} else {
					aziendaToUpdateById
							.setFkFormaGiuridicaIta(Integer.parseInt(backAnagraficaAziendale.getIdFormaGiurdica()));
					aziendaToUpdateById.setFkFormaGiuridicaFra(new Integer(0));
					aziendaToUpdateById.setFkAttivitaApe(getCodiceAttivitaApe(Constants.nessunDatoAttivita));
					aziendaToUpdateById
							.setFkAttivitaPrimaria(Integer.parseInt(backAnagraficaAziendale.getIdAttivitaPrimaria()));
					if (backAnagraficaAziendale.getIdAttivitaSecondaria() != null
							&& !StringUtils.isBlank(backAnagraficaAziendale.getIdAttivitaSecondaria())
							&& StringUtils.isNotEmpty(backAnagraficaAziendale.getIdAttivitaSecondaria())) {
						aziendaToUpdateById.setFkAttivitaSecondaria(
								Integer.parseInt(backAnagraficaAziendale.getIdAttivitaSecondaria()));
					} else {
						aziendaToUpdateById.setFkAttivitaSecondaria(getCodiceAttivitaApe(Constants.nessunDatoAttivita));
					}

					aziendaToUpdateById.setCciaaNumero(backAnagraficaAziendale.getNumeroCCIAA());
					aziendaToUpdateById.setCciaaSiglaProv(backAnagraficaAziendale.getIdProvinciaCCIAA());
					aziendaToUpdateById.setPec(backAnagraficaAziendale.getPec());
					if (backAnagraficaAziendale.getMarcaDaBollo() != null) {
						aziendaToUpdateById.setNMarcaBollo(backAnagraficaAziendale.getMarcaDaBollo());
					}
				}
				aziendaToUpdateById.setDescrAltraFormaGiuridica(backAnagraficaAziendale.getNote());
				aziendaToUpdateById.setEmail(backAnagraficaAziendale.getEmail());
				aziendaToUpdateById.setSitoWeb(backAnagraficaAziendale.getSitoInternet());

				taifTAziendaDao.updateColumnsAziendaByIdAzienda(aziendaToUpdateById);

			}

			List<TaifTSedeAziendaByIdAziendaDto> sedeAziendaList = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
			List<Integer> idSedeAziendaList = new ArrayList<Integer>();
			List<Integer> idSedeAziendaFe = new ArrayList<Integer>();
			for (TaifTSedeAziendaByIdAziendaDto taifTSedeAziendaByIdAziendaDto : sedeAziendaList) {
				idSedeAziendaList.add(taifTSedeAziendaByIdAziendaDto.getId());
			}
			for (BeSedeDto sedeBack : backSediList) {
				idSedeAziendaFe.add(sedeBack.getIdSede());
			}
			for (Integer idSedeEsistente : idSedeAziendaList) {
				if (!idSedeAziendaFe.contains(idSedeEsistente)) {
					TaifTSedeAziendaDto taifSedeAziendaDelete = taifTSedeAziendaDao
							.findByPrimaryKey(new TaifTSedeAziendaPk(idSedeEsistente));
					if (taifSedeAziendaDelete != null) {
						taifTSedeAziendaDao.delete(taifSedeAziendaDelete);
					}
				}

			}
			if (!backSediList.isEmpty()) {
				for (BeSedeDto backSedeIns : backSediList) {
					taifSedeAzienda = taifTSedeAziendaDao
							.findByPrimaryKey(new TaifTSedeAziendaPk(backSedeIns.getIdSede()));
					if (taifSedeAzienda != null) {
						// sede in update
						listTaifSedeAziendaUpdate.add(backSedeIns);
					} else {
						// sede in insert
						listTaifSedeAziendaInsert.add(backSedeIns);
					}
				}
				for (BeSedeDto sedeUpdate : listTaifSedeAziendaUpdate) {
					taifSedeAziendaUpdate = dozerBeanMapper.map(sedeUpdate, TaifTSedeAziendaDto.class);
					taifSedeAziendaUpdate.setIdSede(sedeUpdate.getIdSede());
					taifSedeAziendaUpdate.setIstatComune(sedeUpdate.getIstatComuneSede());
					if (taifSedeAziendaUpdate.getIstatComune() == null) {
						taifSedeAziendaUpdate.setComuneEstero(sedeUpdate.getDescrizioneComune());
					}
					taifSedeAziendaUpdate.setFkAzienda(idAzienda);
					taifSedeAziendaUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					taifSedeAziendaUpdate.setFkConfigUtente(idConfigUtente);

					taifTSedeAziendaDao.updateColumnsUpdateColSediAzienda(taifSedeAziendaUpdate);
				}
				for (BeSedeDto sedeUpdate : listTaifSedeAziendaInsert) {
					taifSedeAziendaInsert = dozerBeanMapper.map(sedeUpdate, TaifTSedeAziendaDto.class);
					taifSedeAziendaInsert.setIstatComune(sedeUpdate.getIstatComuneSede());
					if (taifSedeAziendaInsert.getIstatComune() == null) {
						taifSedeAziendaInsert.setComuneEstero(sedeUpdate.getDescrizioneComune());
					}
					taifSedeAziendaInsert.setFkAzienda(idAzienda);
					taifSedeAziendaInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					taifSedeAziendaInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					taifSedeAziendaInsert.setFkConfigUtente(idConfigUtente);

					taifTSedeAziendaDao.insert(taifSedeAziendaInsert);
				}

			}
			TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (taifTaifAppl != null) {
				if (dataTracciato.contentEquals(Constants.fLang)) {
					taifTaifAppl.setFlgSez11FraOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez11ItaOk(new BigDecimal(Constants.zero));
				} else {
					taifTaifAppl.setFlgSez11ItaOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez11FraOk(new BigDecimal(Constants.zero));
				}
				taifApplSchedaOkDao.update(taifTaifAppl);
			}
		} catch (DaoException e) {
			try {
				result = null;
				log.info("[DbMgr::salvaDatiAziendali] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaDatiAziendali] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} catch (Exception ro) {
			throw new DbManagerException(ro, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaDatiAziendali] END");
		}

		log.debug("[DbMgr::salvaDatiAziendali] END");
		return result;

	}

	// updateTitolareConduttore
	public void updateTitolareConduttoreRiepilogo(Integer idAzienda, TitolareRappresentanteLegale titolare,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale, String dataTracciato)
			throws ManagerException {

		log.debug("[DbMgr::salvaTitolareRappresentanteLegale] BEGIN");
		TaifRPersonaAziendaDto personaAzienda = new TaifRPersonaAziendaDto();
		TaifTPersonaDto personaForUpdate = new TaifTPersonaDto();
		TaifROpfoCorsoDto operatoreCorso = new TaifROpfoCorsoDto();
		UserTransaction utx = txManager.getUserTransaction();

		idConfigUtente = profiloUtente.getIdConfigUtente();

		try {
			utx.begin();
			if (titolare != null) {
				Integer idPersona = null;
				Timestamp dataInserimento = null;
				if (titolarePerCodiceFiscale.size() > 1) {
					for (TaifTPersonaByCodiceFiscalePersonaDto taifTPersonaByCodiceFiscalePersonaDto : titolarePerCodiceFiscale) {
						if (taifTPersonaByCodiceFiscalePersonaDto.getCognome().equalsIgnoreCase(titolare.getCognome())
								&& taifTPersonaByCodiceFiscalePersonaDto.getNome()
										.equalsIgnoreCase(titolare.getNome())) {
							personaForUpdate = getPersonaByIdPersona(
									taifTPersonaByCodiceFiscalePersonaDto.getIdPersona());
							idPersona = taifTPersonaByCodiceFiscalePersonaDto.getIdPersona();
							break;
						}
					}
				} else {
					personaForUpdate = getPersonaByIdPersona(titolarePerCodiceFiscale.get(0).getIdPersona());
					idPersona = titolarePerCodiceFiscale.get(0).getIdPersona();

				}
				dataInserimento = personaForUpdate.getDataInserimento();
				personaForUpdate = dozerBeanMapper.map(titolare, TaifTPersonaDto.class);
				personaForUpdate.setIdPersona(idPersona);
				if (dataTracciato.equals(Constants.fLang)) {
					personaForUpdate.setFkTitoloStudioFra(Integer.parseInt(titolare.getIdTitoloDiStudio()));
					personaForUpdate.setFkTitoloStudio(Integer.parseInt(Constants.zero));
				} else {
					personaForUpdate.setFkTitoloStudio(Integer.parseInt(titolare.getIdTitoloDiStudio()));
					personaForUpdate.setFkTitoloStudioFra(Integer.parseInt(Constants.zero));
				}
				personaForUpdate.setDataInserimento(dataInserimento);
				personaForUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				personaForUpdate.setFkConfigUtente(idConfigUtente);

				taifTPersonaDao.updateColumnsForTitolareRappresentante(personaForUpdate);

				// update rpersonaAzienda

				personaAzienda = taifRPersonaAziendaDao
						.findByPrimaryKey(new TaifRPersonaAziendaPk(personaForUpdate.getIdPersona(), idAzienda));

				personaAzienda.setFkRuolo(Integer.parseInt(Constants.one));
				personaAzienda.setFkConfigUtente(idConfigUtente);
				personaAzienda.setFkTipoMansione(getCodiceMansione(getMansioneFilterNessunDato(dataTracciato)));
				personaAzienda.setFkTipoContratto(Integer.parseInt(Constants.zero));
				personaAzienda.setFkTipoInquadramento(getCodiceInquadramento(getInquadramentoFilterNessunDato()));
				personaAzienda.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));

				taifRPersonaAziendaDao.updateColumnsPersonaAzienda(personaAzienda);
				//// update rpersonaCorso
				// taifROpfoCorsoDao.findByPrimaryKey(new TaifROpfoCorsoPk(idCorso, idPersona));
			}

			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaTitolareRappresentanteLegale] END");
		}

		log.debug("[DbMgr::salvaTitolareRappresentanteLegale] BEGIN");
	}

	public Integer updateLavoriPerPAUltimoAnno(Integer idAzienda, ArrayList<LavoroPA> list,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String esistenzaLavoriPA, String dataTracciato)
			throws DbManagerException {

		log.debug("[DbMgr::updateLavoriPerPAUltimoAnno] BEGIN ");
		Integer result = idAzienda;
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			LavoroPaFilter lavoroPaFilter = new LavoroPaFilter();
			lavoroPaFilter.setIdAzienda(idAzienda);
			lavoroPaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
			if (esistenzaLavoriPA.equals(Constants.SI)) {
				idConfigUtente = profiloUtente.getIdConfigUtente();
				List<Integer> listIdLavori = new ArrayList<Integer>();
				List<TaifTLavoroPaByAziendaDto> lavoroPaEsistente = taifTLavoroPaDao.findByAzienda(lavoroPaFilter);
				for (LavoroPA lavoroPaFromFe : list) {
					listIdLavori.add(lavoroPaFromFe.getIdLavoroPA());
				}
				for (TaifTLavoroPaByAziendaDto taifTLavoroPaByAziendaDto : lavoroPaEsistente) {
					if (!(listIdLavori.contains(taifTLavoroPaByAziendaDto.getId()))) {
						taifTLavoroPaDao.delete(new TaifTLavoroPaPk(taifTLavoroPaByAziendaDto.getId()));
					}
				}
				for (LavoroPA taifTLavoroPa : list) {
					if (taifTLavoroPa.getIdLavoroPA() != 0) {
						// update
						TaifTLavoroPaDto lavoroPa = taifTLavoroPaDao
								.findByPrimaryKey(new TaifTLavoroPaPk(taifTLavoroPa.getIdLavoroPA()));
						lavoroPa.setCommittente(taifTLavoroPa.getCommittente());
						lavoroPa.setFkTipoLavoroPa(taifTLavoroPa.getIdOggettoIntervento());
						lavoroPa.setImporto(new BigDecimal(taifTLavoroPa.getImportoComplessivo()));
						if (taifTLavoroPa.getAltro() != null && !taifTLavoroPa.getAltro().equals(""))
							lavoroPa.setDescrAltro(taifTLavoroPa.getAltro());
						lavoroPa.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						lavoroPa.setFkConfigUtente(idConfigUtente);
						lavoroPa.setFkAzienda(idAzienda);

						taifTLavoroPaDao.updateColumnsPerIdAzienda(lavoroPa);
					} else {
						// insert
						TaifTLavoroPaDto lavoroPaDto = new TaifTLavoroPaDto();
						lavoroPaDto = dozerBeanMapper.map(taifTLavoroPa, TaifTLavoroPaDto.class);
						lavoroPaDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						lavoroPaDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						lavoroPaDto.setFkConfigUtente(idConfigUtente);
						lavoroPaDto.setFkAzienda(idAzienda);

						taifTLavoroPaDao.insert(lavoroPaDto);
					}
				}
			} else {
				List<TaifTLavoroPaByAziendaDto> lavoroDaCancell = taifTLavoroPaDao.findByAzienda(lavoroPaFilter);
				if (lavoroDaCancell != null && !lavoroDaCancell.isEmpty()) {
					for (TaifTLavoroPaByAziendaDto lavoroPaDaCancell : lavoroDaCancell) {
						taifTLavoroPaDao.delete(new TaifTLavoroPaPk(lavoroPaDaCancell.getId()));
					}
				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updateLavoriPerPAUltimoAnno] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updateLavoriPerPAUltimoAnno] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updateLavoriPerPAUltimoAnno] END");
		}
		log.debug("[DbMgr::updateLavoriPerPAUltimoAnno] END");
		return result;

	}

	public TaifApplSchedaOkDto getDatiFromSchedaApplOk(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getDatiFromSchedaApplOk] BEGIN");
		try {
			TaifApplSchedaOkDto listElencoTipo = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			return listElencoTipo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getDatiFromSchedaApplOk] END");
		}
	}

	// mm
	public Integer updateFatturatoECategorieImpresa(Integer idAzienda, List<CategoriaImpresa> elencoCategorieImpresa,
			FatturatoCategorieDiImpresa fatturato, List<CategoriaImpresa> categoriaImpresaList,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String impresaSelezionalta,
			FatturatoCategorieDiImpresa fatturatoCategorieDiImpresa, String dataTracciato) throws DbManagerException {

		log.debug("[DbMgr::updateFatturatoECategorieImpresa] BEGIN ");
		Integer result = idAzienda;

		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			idConfigUtente = profiloUtente.getIdConfigUtente();
			// updateAzienda
			// updateAziendaCategImpresa
			// albi
			TaifTPraticaDto pratica = new TaifTPraticaDto();
			List<TaifTPraticaDto> praticaUpdateList = new ArrayList<TaifTPraticaDto>();
			double valueFatturato = 0.0;
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			if (aziendaToUpdate != null) {
				aziendaToUpdate.setAnnoInizio(new BigDecimal(Integer.parseInt(fatturato.getAnnoInizioAttivita())));
				String fatturatoStr = fatturato.getFatturatoUltimoAnno();
				valueFatturato = StringUtils.stringToDouble(fatturatoStr);
				aziendaToUpdate.setFatturato(new BigDecimal(valueFatturato));
				aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				aziendaToUpdate.setFkConfigUtente(idConfigUtente); // from session
				taifTAziendaDao.updateColumnsAziendaByIdAzienda(aziendaToUpdate);
			}
			// updatePratica
			List<TaifTPraticaByIdAziendaDto> praticaToUpdateList = taifTPraticaDao.findByIdAzienda(idAzienda);
			for (TaifTPraticaByIdAziendaDto praticaToUpdate : praticaToUpdateList) {
				//praticaToUpdate.setFlagSezione(Constants.aChar);
				praticaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				praticaToUpdate.setFkConfigUtente(idConfigUtente);

				pratica = dozerBeanMapper.map(praticaToUpdate, TaifTPraticaDto.class);
				pratica.setDataIscrizioneAlbo(praticaToUpdate.getDataInscrizioneAlbo());
				pratica.setDataPresentazione(praticaToUpdate.getDataPresentazione());
				praticaUpdateList.add(pratica);
			}
			for (TaifTPraticaDto taifPratica : praticaUpdateList) {
				taifPratica.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				taifTPraticaDao.updateColumnsPraticaByIdPratica(taifPratica);
			}
			// R_AZIENDA_CATEGIMPRESA
			List<TaifRAziendaCategImpresaByIdAziendaDto> aziendaCategList = taifRAziendaCategImpresaDao
					.findByIdAzienda(idAzienda);
			List<TaifRAziendaCategImpresaDto> azCatList = new ArrayList<TaifRAziendaCategImpresaDto>();
			if (aziendaCategList == null || aziendaCategList.isEmpty()) {
				// AziendaCategoria insert
				for (CategoriaImpresa backCatImpresa : categoriaImpresaList) {
					TaifRAziendaCategImpresaByIdAziendaDto rCategImpressaDto = new TaifRAziendaCategImpresaByIdAziendaDto();

					rCategImpressaDto.setIdAzienda(idAzienda);
					rCategImpressaDto.setIdcategImpresa(backCatImpresa.getIdCategoria());
					if (backCatImpresa.getIdCategoria() == Constants.five
							|| backCatImpresa.getIdCategoria() == Constants.ten) {
						rCategImpressaDto.setAziendaCategImpresa(backCatImpresa.getNomeCategoria());
					}
					rCategImpressaDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					rCategImpressaDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					rCategImpressaDto.setFkConfigUtente(idConfigUtente);

					azCatList.add(dozerBeanMapper.map(rCategImpressaDto, TaifRAziendaCategImpresaDto.class));

				}
				for (TaifRAziendaCategImpresaDto taifRAziendaCategImpresaDto : azCatList) {
					taifRAziendaCategImpresaDao.insert(taifRAziendaCategImpresaDto);

				}
			} else {
				VisibileOrdinFilter visibileOrdinFilter = new VisibileOrdinFilter();
				visibileOrdinFilter.setFlagItaFr(dataTracciato);
				visibileOrdinFilter
						.setFlagVisibile(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));

				// elencoCategorieImpresa
				for (TaifRAziendaCategImpresaByIdAziendaDto aziendaCategEsistente : aziendaCategList) {
					if (!(impresaSelezionalta.equals(String.valueOf(aziendaCategEsistente.getIdcategImpresa())))) {
						TaifRAziendaCategImpresaDto categoriaFind = taifRAziendaCategImpresaDao.findByPrimaryKey(
								new TaifRAziendaCategImpresaPk(idAzienda, aziendaCategEsistente.getIdcategImpresa()));
						if (categoriaFind != null) {

							taifRAziendaCategImpresaDao.delete(new TaifRAziendaCategImpresaPk(idAzienda,
									aziendaCategEsistente.getIdcategImpresa()));
							// break;
						}
					}
				}

				List<TaifRAziendaCategImpresaByIdAziendaDto> categoriaIMpresaEsistente = taifRAziendaCategImpresaDao
						.findByIdAzienda(idAzienda);
				if (!(categoriaIMpresaEsistente != null && !categoriaIMpresaEsistente.isEmpty())) {
					TaifRAziendaCategImpresaByIdAziendaDto rCategImpressaDto = new TaifRAziendaCategImpresaByIdAziendaDto();
					rCategImpressaDto.setIdAzienda(idAzienda);
					rCategImpressaDto.setIdcategImpresa(Integer.parseInt(impresaSelezionalta));
					if ((rCategImpressaDto.getIdcategImpresa() == Constants.five
							|| rCategImpressaDto.getIdcategImpresa() == Constants.ten)
							&& fatturatoCategorieDiImpresa.getAltro() != null) {
						rCategImpressaDto.setAziendaCategImpresa(fatturatoCategorieDiImpresa.getAltro());
					}
					rCategImpressaDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					rCategImpressaDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					rCategImpressaDto.setFkConfigUtente(idConfigUtente);

					TaifRAziendaCategImpresaDto rAziendaCategDto = dozerBeanMapper.map(rCategImpressaDto,
							TaifRAziendaCategImpresaDto.class);
					taifRAziendaCategImpresaDao.insert(rAziendaCategDto);
				} else {

					TaifRAziendaCategImpresaDto aziendaRCategoriaImpresa = taifRAziendaCategImpresaDao
							.findByPrimaryKey(new TaifRAziendaCategImpresaPk(idAzienda,
									categoriaIMpresaEsistente.get(0).getIdcategImpresa()));
					aziendaRCategoriaImpresa.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					aziendaRCategoriaImpresa.setFkConfigUtente(idConfigUtente);
					aziendaRCategoriaImpresa.setIdCategoria(Integer.parseInt(impresaSelezionalta));
					if (elencoCategorieImpresa.get(4).getAltroVisibile()
							&& ((aziendaRCategoriaImpresa.getIdCategoria() == Constants.fiveInt)
									|| (aziendaRCategoriaImpresa.getIdCategoria() == Constants.ten))) {
						// if (!StringUtils.isBlank(fatturato.getAltro())) {
						if (!StringUtils.isBlank(fatturatoCategorieDiImpresa.getAltro())) {
							aziendaRCategoriaImpresa.setAziendaCategimpresa(fatturatoCategorieDiImpresa.getAltro());
						}
					}
					taifRAziendaCategImpresaDao.updateColumnsAziendaCategoriaImpresa(aziendaRCategoriaImpresa);

				}

			}
			TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (taifTaifAppl != null) {
				if (dataTracciato.contentEquals(Constants.fLang)) {
					taifTaifAppl.setFlgSez21FraOk(new BigDecimal(Constants.one)); // if flag francese
					taifTaifAppl.setFlgSez21ItaOk(new BigDecimal(Constants.zero));
				} else {
					taifTaifAppl.setFlgSez21ItaOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez21FraOk(new BigDecimal(Constants.zero)); // if flag francese
				}
				taifApplSchedaOkDao.update(taifTaifAppl);
			}
			utx.commit();
		} catch (DaoException e) {
			try {
				result = null;
				utx.rollback();
				log.info("[DbMgr::updateFatturatoECategorieImpresa] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updateFatturatoECategorieImpresa] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} catch (Exception ro) {
			throw new DbManagerException(ro, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updateFatturatoECategorieImpresa] END");
		}

		log.debug("[DbMgr::updateFatturatoECategorieImpresa] END");
		return result;

	}

	public MansioneFilter getMansioneFilterNessunDato(String dataTracciato) {

		mansioneFilter.setFlagItaFr(Constants.iLang);
		mansioneFilter.setFlagVisibile(Integer.valueOf(Constants.zero));
		mansioneFilter.setTipoMansione(Constants.nessunDatoMansione);

		return mansioneFilter;
	}

	public ContrattoFilter getContrattoFilterContrattoComm(String dataTracciato) {

		contrattoFilter.setFlagItaFr(dataTracciato);
		contrattoFilter.setFlagVisibile(Integer.valueOf(Constants.one));
		contrattoFilter.setTipoContratto(Constants.tipoContrattoCommercio);

		return contrattoFilter;
	}

	public InquadramentoFilter getInquadramentoFilterNessunDato() {

		inquadramentoFilter.setFlagVisibile(Integer.parseInt(Constants.zero));
		inquadramentoFilter.setTipoInquadramento(Constants.nessunDatoInquadramento);

		return inquadramentoFilter;
	}

	public FunzioneVisibleFilter getFunzioneVisibleFilter(String dataTracciato) {
		funzioneVisibleFilter.setFlagItaFr(dataTracciato);
		funzioneVisibleFilter.setFlagVisibile(Constants.oneInt);

		return funzioneVisibleFilter;
	}

	public ProfiloUtenteTaif getProfiloUtente(String codiceFiscale) throws ManagerException {
		log.debug("[DbMgr::getProfiloUtente] BEGIN ");
		ProfiloUtenteTaif result = null;
		try {
			List<TaifCnfConfigUtenteProfiloByCodiceFiscaleDto> list = this.taifCnfConfigUtenteDao
					.findProfiloByCodiceFiscale(codiceFiscale);
			if (list != null && !list.isEmpty()) {
				TaifCnfConfigUtenteProfiloByCodiceFiscaleDto dto = list.get(0);
				result = dozerBeanMapper.map(dto, ProfiloUtenteTaif.class);
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProfiloUtente] END");
		}
		return result;
	}

	public List<CodeDescription> getElencoPersone() throws ManagerException {
		log.debug("[DbMgr::getElencoPersone] BEGIN ");
		List<CodeDescription> result = new ArrayList<CodeDescription>();
		try {
			List<TaifTPersonaDto> list = this.taifTPersonaDao.findAll();
			if (list != null && !list.isEmpty()) {
				for (TaifTPersonaDto dto : list) {
					result.add(dozerBeanMapper.map(dto, CodeDescription.class));
				}
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoPersone] END");
		}
		return result;
	}

	public Personale getPersonaByCodiceFiscale(String codiceFiscale, VisibileOrdinFilter filter)
			throws ManagerException {
		log.debug("[DbMgr::getPersonaByCodiceFiscale] BEGIN ");
		Personale result = null;
		try {
			List<TaifTPersonaByCodiceFiscalePersonaDto> list = this.findPersonaPerCodiceFiscale(codiceFiscale);
			if (list != null && !list.isEmpty()) {
				TaifTPersonaByCodiceFiscalePersonaDto dto = list.get(0);
				result = dozerBeanMapper.map(dto, Personale.class);
				result.setCodiceFiscaleEditabile(false);
				result.setCognomeEditabile(false);
				result.setNomeEditabile(false);
				result.setElencoMansioni(getElencoMansioni(filter));
				result.setElencoTipologiaPersonale(getElencoTipologiaPersonale(filter));
				result.setElencoContratti(getElencoContratti(filter));
				result.setElencoDurateContratto(getElencoDurateContratti());
				result.setElencoInquadramenti(getElencoInquadramenti(filter));
				
				String corsi = this.findCorsiPerCodiceFiscalePersona(codiceFiscale);
				result.setCorsi(StringUtils.defaultValue(corsi, it.csi.taif.taifweb.util.Constants.NO_CORSI));
				// Elenco qualifiche
				String qualifiche = this.findQualifichePerCodiceFiscalePersona(codiceFiscale);
				result.setQualifiche(StringUtils.defaultValue(qualifiche, it.csi.taif.taifweb.util.Constants.NO_QUALIFICHE));
				// Elenco riconoscimenti
				String riconoscimenti = this.findRiconoscimentiPerCodiceFiscalePersona(codiceFiscale);
				result.setRiconoscimenti(StringUtils.defaultValue(riconoscimenti, it.csi.taif.taifweb.util.Constants.NO_RICONOSCIMENTI));
				result.setRownum(0);

			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaByCodiceFiscale] END");
		}
		return result;
	}

	public UserInfo accessFromUserPassword(LoginInfo info) throws ManagerException {
		log.debug("[DbMgr::accessFromUserPassword] BEGIN ");
		UserInfo result = null;
		try {
			List<TaifTPersonaDto> list = this.taifTPersonaDao.findLoginInfo(info);
			if (list != null && !list.isEmpty()) {
				result = dozerBeanMapper.map(list.get(0), UserInfo.class);
				result.setNazionalita(Constants.fLang);
			} else {
				throw new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.U001));
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::accessFromUserPassword] END");
		}
		return result;
	}

	public List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> getConfigProfiloUtenteByCodiceFiscale(
			ConfigProfiloFilter filtro) throws DbManagerException {
		log.debug("[DbMgr::getProfiloPerCodiceFiscale] BEGIN ");
		List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> persProfilo;
		try {
			persProfilo = taifTPersonaDao.findProfiloUtenteByCodiceFiscale(filtro);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProfiloPerCodiceFiscale] END");
		}
		return persProfilo;
	}

	public List<TaifTPraticaByIdAziendaDto> getPraticaPerIdAzienda(int idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getPraticaPerIdAzienda] BEGIN ");
		List<TaifTPraticaByIdAziendaDto> praticheList;
		List<TaifTPraticaByIdAziendaDto> altrePraticheList = new ArrayList<TaifTPraticaByIdAziendaDto>();
		try {
			praticheList = taifTPraticaDao.findByIdAzienda(idAzienda);
			for (TaifTPraticaByIdAziendaDto taifTPraticaByIdAziendaDto : praticheList) {
				if (taifTPraticaByIdAziendaDto.getIdSoggettoGestore() == 0) {
					altrePraticheList.add(taifTPraticaByIdAziendaDto);
				}
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPraticaPerIdAzienda] END");
		}
		return altrePraticheList;
	}

	public ProfiloUtenteTaif getProfiloUtenteGestore(String codiceFiscale) throws ManagerException {
		log.info("[DbMgr::getProfiloUtente] BEGIN ");
		ProfiloUtenteTaif result = null;
		try {
			List<TaifCnfConfigUtenteProfiloByCodiceFiscaleDto> list = this.taifCnfConfigUtenteDao
					.findProfiloByCodiceFiscale(codiceFiscale);
			if (list != null && !list.isEmpty()) {
				TaifCnfConfigUtenteProfiloByCodiceFiscaleDto dto = list.get(0);
				System.out.println("------------------- PRE DOZER");
				GenericUtil.stampaVO(dto);
				result = dozerBeanMapper.map(dto, ProfiloUtenteTaif.class);
				System.out.println("------------------- POST DOZER");
				GenericUtil.stampaVO(result);
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.info("[DbMgr::getProfiloUtente] END");
		}
		return result;
	}

	public List<TaifRAziendaAssociazioneByIdAziendaDto> getAssociazioniPerIdAzienda(int idAzienda)
			throws DbManagerException {
		log.debug("[DbMgr::getAssociazioniPerIdAzienda] BEGIN ");
		List<TaifRAziendaAssociazioneByIdAziendaDto> associazioniList;
		try {
			associazioniList = taifRAziendaAssociazioneDao.findByIdAzienda(idAzienda);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAssociazioniPerIdAzienda] END");
		}
		return associazioniList;

	}

	public void updateAttivitaUltimoAnno(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, Map<String, Boolean> attivitaMap,
			List<MaterialePropagazione> elencoMaterialePropagazione,
			ArrayList<ArboricolturaDaLegno> elencoArboricoltureLegno, List<String> idMaterialiPropagazione,
			String dataTracciato, String idTaglioUtilizzazioneRegione, String idTaglioPiopettiRegione,
			String idTaglioTagliIntervalariRegione, String idTaglioUtilizzazioneFuori, String idTaglioPiopettiFuori,
			String idTaglioTagliIntercalariFuori, MaterialePropagazione materialePropagazione) {
		log.debug("[DbMgr::updateAttivitaUltimoAnno] BEGIN");

		List<TaifTAttivitaSvoltaDettDto> attivitaDettList = new ArrayList<TaifTAttivitaSvoltaDettDto>();
		List<TaifTAttivitaSvoltaDto> attivitaSvoltaList = new ArrayList<TaifTAttivitaSvoltaDto>();

		idConfigUtente = profiloUtente.getIdConfigUtente();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			// att1
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att1))
					&& gestioneAttivitaUltimoAnno.getAttivita1() != null) {
				List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita1SvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.oneInt);
				AttivitaUltimoAnno1 attivita1 = gestioneAttivitaUltimoAnno.getAttivita1();

				attivita1SvoltaFinded = taifTAttivitaSvoltaDao
						.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
				// TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto -- TaifTAttivitaSvoltaDto
				if (attivita1SvoltaFinded != null && !attivita1SvoltaFinded.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta1 : attivita1SvoltaFinded) {
						TaifTAttivitaSvoltaDto updateAttivitaSvolta1 = new TaifTAttivitaSvoltaDto();
						// azienda, idAttivita, fkTipoAttivita
						updateAttivitaSvolta1.setIdAttivita(attivitaSvolta1.getId());
						updateAttivitaSvolta1.setPercFatturato(new BigDecimal(attivita1.getPercentuale()));
						updateAttivitaSvolta1.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						updateAttivitaSvolta1.setDescrAltreAttivita(attivita1.getAltro());
						updateAttivitaSvolta1.setFkAzienda(idAzienda);
						updateAttivitaSvolta1.setFkTipoAttivita(Constants.oneInt);
						updateAttivitaSvolta1.setFkConfigUtente(idConfigUtente);

						taifTAttivitaSvoltaDao.updateColumnsAttivitaForIdAzienda(updateAttivitaSvolta1);
						if (gestioneAttivitaUltimoAnno.getAttivita1().getInterventoFuoriRegione() != null) {
							Intervento interventoFuoriRegione = new Intervento();
							interventoFuoriRegione = gestioneAttivitaUltimoAnno.getAttivita1()
									.getInterventoFuoriRegione();
							TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett14 = new TaifTAttivitaSvoltaDettDto();
							if (interventoFuoriRegione.getTotaleVolumiTagliDiUtilizzazione() != null
									&& interventoFuoriRegione.getTotaleVolumiTagliDiUtilizzazione() != "") {
								updateAttivitaSvoltaDett14.setValore1(
										new BigDecimal(interventoFuoriRegione.getTotaleVolumiTagliDiUtilizzazione()));
								updateAttivitaSvoltaDett14.setProgressivo(4);
								// att svolta
								updateAttivitaSvoltaDett14
										.setFkUnitaDiMisura(Integer.parseInt(idTaglioUtilizzazioneFuori));
								if ((interventoFuoriRegione
										.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()) != null
										&& (interventoFuoriRegione
												.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()) != "") {
									updateAttivitaSvoltaDett14.setPercContoTerzi(new BigDecimal(interventoFuoriRegione
											.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()));
								}
								updateAttivitaSvoltaDett14
										.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								updateAttivitaSvoltaDett14.setFkConfigUtente(idConfigUtente);
								updateAttivitaSvoltaDett14.setIdAttivita(attivitaSvolta1.getId());
								taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett14);

							}
							TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett15 = new TaifTAttivitaSvoltaDettDto();
							if (interventoFuoriRegione.getTotaleVolumiTaglioPioppeti() != null
									&& interventoFuoriRegione.getTotaleVolumiTaglioPioppeti() != "") {

								updateAttivitaSvoltaDett15.setProgressivo(5);
								updateAttivitaSvoltaDett15.setValore1(
										new BigDecimal(interventoFuoriRegione.getTotaleVolumiTaglioPioppeti()));

								if (interventoFuoriRegione.getPercentualeVolumiTaglioPioppetiContoTerzi() != null
										&& interventoFuoriRegione
												.getPercentualeVolumiTaglioPioppetiContoTerzi() != "") {
									updateAttivitaSvoltaDett15.setPercContoTerzi(new BigDecimal(
											interventoFuoriRegione.getPercentualeVolumiTaglioPioppetiContoTerzi()));
								}
								updateAttivitaSvoltaDett15.setFkUnitaDiMisura(Integer.parseInt(idTaglioPiopettiFuori));

								updateAttivitaSvoltaDett15
										.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								updateAttivitaSvoltaDett15.setFkConfigUtente(idConfigUtente);
								updateAttivitaSvoltaDett15.setIdAttivita(attivitaSvolta1.getId());
								taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett15);

							}
							TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett16 = new TaifTAttivitaSvoltaDettDto();
							if (interventoFuoriRegione.getTotaleVolumiTagliIntercalari() != null
									&& interventoFuoriRegione.getTotaleVolumiTagliIntercalari() != "") {

								updateAttivitaSvoltaDett16.setProgressivo(6);
								updateAttivitaSvoltaDett16.setValore1(
										new BigDecimal(interventoFuoriRegione.getTotaleVolumiTagliIntercalari()));

								if (interventoFuoriRegione.getPercentualeVolumiTagliIntercalariContoTerzi() != null
										&& interventoFuoriRegione
												.getPercentualeVolumiTagliIntercalariContoTerzi() != "") {
									updateAttivitaSvoltaDett16.setPercContoTerzi(new BigDecimal(
											interventoFuoriRegione.getPercentualeVolumiTagliIntercalariContoTerzi()));
								}
								updateAttivitaSvoltaDett16
										.setFkUnitaDiMisura(Integer.parseInt(idTaglioTagliIntercalariFuori));

								updateAttivitaSvoltaDett16
										.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								updateAttivitaSvoltaDett16.setFkConfigUtente(idConfigUtente);
								updateAttivitaSvoltaDett16.setIdAttivita(attivitaSvolta1.getId());
								taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett16);
							}
						}
						if ((gestioneAttivitaUltimoAnno.getAttivita1().getInterventoInRegione()) != null) {
							Intervento interventoRegione = new Intervento();
							interventoRegione = gestioneAttivitaUltimoAnno.getAttivita1().getInterventoInRegione();

							TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett11 = new TaifTAttivitaSvoltaDettDto();
							if (interventoRegione.getTotaleVolumiTagliDiUtilizzazione() != null
									&& interventoRegione.getTotaleVolumiTagliDiUtilizzazione() != "") {
								updateAttivitaSvoltaDett11.setValore1(
										new BigDecimal(interventoRegione.getTotaleVolumiTagliDiUtilizzazione()));
								updateAttivitaSvoltaDett11.setProgressivo(Constants.oneInt);
								updateAttivitaSvoltaDett11
										.setFkUnitaDiMisura(Integer.parseInt(idTaglioUtilizzazioneRegione)); // quintali
								if ((interventoRegione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()) != null
										&& (interventoRegione
												.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()) != "") {
									updateAttivitaSvoltaDett11.setPercContoTerzi(new BigDecimal(
											interventoRegione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()));
								}
								updateAttivitaSvoltaDett11
										.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								updateAttivitaSvoltaDett11.setFkConfigUtente(idConfigUtente);
								updateAttivitaSvoltaDett11.setIdAttivita(attivitaSvolta1.getId());
								taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett11);
							}
							TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett12 = new TaifTAttivitaSvoltaDettDto();
							if (interventoRegione.getTotaleVolumiTaglioPioppeti() != null
									&& interventoRegione.getTotaleVolumiTaglioPioppeti() != "") {
								updateAttivitaSvoltaDett12
										.setValore1(new BigDecimal(interventoRegione.getTotaleVolumiTaglioPioppeti()));
								updateAttivitaSvoltaDett12.setProgressivo(Constants.twoInt);
								updateAttivitaSvoltaDett12
										.setFkUnitaDiMisura(Integer.parseInt(idTaglioPiopettiRegione));
								if ((interventoRegione.getPercentualeVolumiTaglioPioppetiContoTerzi()) != null
										&& (interventoRegione.getPercentualeVolumiTaglioPioppetiContoTerzi()) != "") {
									updateAttivitaSvoltaDett12.setPercContoTerzi(new BigDecimal(
											interventoRegione.getPercentualeVolumiTaglioPioppetiContoTerzi()));
								}
								updateAttivitaSvoltaDett12
										.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								updateAttivitaSvoltaDett12.setFkConfigUtente(idConfigUtente);
								updateAttivitaSvoltaDett12.setIdAttivita(attivitaSvolta1.getId());
								taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett12);
							}
							TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett13 = new TaifTAttivitaSvoltaDettDto();
							if (interventoRegione.getTotaleVolumiTagliIntercalari() != null
									&& interventoRegione.getTotaleVolumiTagliIntercalari() != "") {
								updateAttivitaSvoltaDett13.setValore1(
										new BigDecimal(interventoRegione.getTotaleVolumiTagliIntercalari()));
								updateAttivitaSvoltaDett13.setProgressivo(Constants.threInt);
								updateAttivitaSvoltaDett13
										.setFkUnitaDiMisura(Integer.parseInt(idTaglioTagliIntervalariRegione));
								if ((interventoRegione.getPercentualeVolumiTagliIntercalariContoTerzi()) != null
										&& (interventoRegione.getPercentualeVolumiTagliIntercalariContoTerzi()) != "") {
									updateAttivitaSvoltaDett13.setPercContoTerzi(new BigDecimal(
											interventoRegione.getPercentualeVolumiTagliIntercalariContoTerzi()));
								}
								updateAttivitaSvoltaDett13
										.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								updateAttivitaSvoltaDett13.setFkConfigUtente(idConfigUtente);
								updateAttivitaSvoltaDett13.setIdAttivita(attivitaSvolta1.getId());
								taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett13);
							}
						}
					}
				} else {
					// MM att1 is null in db dovrei inserire = INSERT attivita
					// AttivitaUltimoAnno1 attivita1= gestioneAttivitaUltimoAnno.getAttivita1();
					insertAttivita1(idAzienda, gestioneAttivitaUltimoAnno, attivita1, idTaglioUtilizzazioneRegione,
							idTaglioPiopettiRegione, idTaglioTagliIntervalariRegione, idTaglioUtilizzazioneFuori,
							idTaglioPiopettiFuori, idTaglioTagliIntercalariFuori);
				} // end att upd
			} else {
				List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita1SvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.oneInt);
				attivita1SvoltaBack = taifTAttivitaSvoltaDao.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
				if (attivita1SvoltaBack != null && !attivita1SvoltaBack.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta : attivita1SvoltaBack) {
						List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
								.findByFilterAttivita(attivitaSvolta.getId());
						for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : listAttivitaDettaglio) {
							taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(attivitaDettaglio.getId(),
									attivitaDettaglio.getProgressivo()));
						}
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
					}
				}
			}
			// att2
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att2))
					&& gestioneAttivitaUltimoAnno.getAttivita2() != null) {

				List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita2SvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.twoInt);
				attivita2SvoltaFinded = taifTAttivitaSvoltaDao
						.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
				TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett21 = new TaifTAttivitaSvoltaDettDto();
				TaifTAttivitaSvoltaDto updateAttivitaSvolta21 = new TaifTAttivitaSvoltaDto();
				if (gestioneAttivitaUltimoAnno.getAttivita2().getEttariRealizzati() != null
						&& gestioneAttivitaUltimoAnno.getAttivita2().getEttariRealizzati() != "") {
					AttivitaUltimoAnno2 attivita2Update = gestioneAttivitaUltimoAnno.getAttivita2();
					if (attivita2SvoltaFinded != null & !attivita2SvoltaFinded.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta2 : attivita2SvoltaFinded) {
							updateAttivitaSvoltaDett21.setProgressivo(Constants.oneInt);
							updateAttivitaSvoltaDett21
									.setValore1(new BigDecimal(attivita2Update.getEttariRealizzati()));
							updateAttivitaSvoltaDett21.setFkUnitaDiMisura(Constants.fiveInt);
							updateAttivitaSvoltaDett21
									.setPercContoTerzi(new BigDecimal(attivita2Update.getPercentuale()));

							updateAttivitaSvolta21.setIdAttivita(attivitaSvolta2.getId());
							updateAttivitaSvolta21.setFkAzienda(idAzienda);
							updateAttivitaSvolta21.setFkTipoAttivita(new Integer(Constants.twoInt));
							if (attivita2Update.getAltro() != null && attivita2Update.getAltro() != "") {
								updateAttivitaSvolta21.setDescrAltreAttivita(attivita2Update.getAltro());
							}
							if (attivita2Update.getPercentuale() != null) {
								updateAttivitaSvolta21
										.setPercFatturato(new BigDecimal(attivita2Update.getPercentuale()));
							}

							updateAttivitaSvolta21.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							updateAttivitaSvolta21.setFkConfigUtente(idConfigUtente);
							taifTAttivitaSvoltaDao.updateColumnsAttivitaForIdAzienda(updateAttivitaSvolta21);

							updateAttivitaSvoltaDett21.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							updateAttivitaSvoltaDett21.setFkConfigUtente(idConfigUtente);
							updateAttivitaSvoltaDett21.setIdAttivita(attivitaSvolta2.getId());
							taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett21);
						}
					} else {
						// insert
						insertAttivitaUltimoAnno2(idAzienda, gestioneAttivitaUltimoAnno);

					}
				}
			} else {
				List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita2SvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.twoInt);
				attivita2SvoltaBack = taifTAttivitaSvoltaDao.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
				if (attivita2SvoltaBack != null && !attivita2SvoltaBack.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta : attivita2SvoltaBack) {
						List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
								.findByFilterAttivita(attivitaSvolta.getId());
						for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : listAttivitaDettaglio) {
							taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(attivitaDettaglio.getId(),
									attivitaDettaglio.getProgressivo()));
						}
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
					}

				}
			}
			// att3
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att3))
					&& gestioneAttivitaUltimoAnno.getAttivita3() != null) {

				List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita3SvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.threInt);
				attivita3SvoltaFinded = taifTAttivitaSvoltaDao
						.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
				TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett31 = new TaifTAttivitaSvoltaDettDto();
				TaifTAttivitaSvoltaDto updateAttivitaSvolta31 = new TaifTAttivitaSvoltaDto();
				if (gestioneAttivitaUltimoAnno.getAttivita3().getRealizzazione() != null
						&& gestioneAttivitaUltimoAnno.getAttivita3().getRealizzazione() != "") {
					AttivitaUltimoAnno3 attivita3 = gestioneAttivitaUltimoAnno.getAttivita3();
					if (attivita3SvoltaFinded != null & !attivita3SvoltaFinded.isEmpty()) {
						for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta3 : attivita3SvoltaFinded) {
							updateAttivitaSvoltaDett31.setProgressivo(Constants.oneInt);
							updateAttivitaSvoltaDett31.setValore1(new BigDecimal(attivita3.getRealizzazione()));
							updateAttivitaSvoltaDett31.setValore2(new BigDecimal(attivita3.getManutenzione()));
							updateAttivitaSvoltaDett31.setFkUnitaDiMisura(Constants.sixInt);
							updateAttivitaSvoltaDett31.setPercContoTerzi(new BigDecimal(attivita3.getPercentuale()));
							updateAttivitaSvolta31.setIdAttivita(attivitaSvolta3.getId());
							updateAttivitaSvolta31.setFkAzienda(idAzienda);
							updateAttivitaSvolta31.setFkTipoAttivita(new Integer(Constants.threInt));
							if (attivita3.getAltro() != null && attivita3.getAltro() != "") {
								updateAttivitaSvolta31.setDescrAltreAttivita(attivita3.getAltro());
							}
							if (attivita3.getPercentuale() != null) {
								updateAttivitaSvolta31.setPercFatturato(new BigDecimal(attivita3.getPercentuale()));
							}
							updateAttivitaSvolta31.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							updateAttivitaSvolta31.setFkConfigUtente(idConfigUtente);
							taifTAttivitaSvoltaDao.updateColumnsAttivitaForIdAzienda(updateAttivitaSvolta31);

							updateAttivitaSvoltaDett31.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							updateAttivitaSvoltaDett31.setFkConfigUtente(idConfigUtente);
							updateAttivitaSvoltaDett31.setIdAttivita(attivitaSvolta3.getId());
							taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett31);
						}
					} else {
						// insert
						insertAttivitaUltimoAnno3(idAzienda, gestioneAttivitaUltimoAnno);
					}
				}
			} else {
				List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita3SvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.threInt);
				attivita3SvoltaBack = taifTAttivitaSvoltaDao.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
				if (attivita3SvoltaBack != null && !attivita3SvoltaBack.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta : attivita3SvoltaBack) {
						List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
								.findByFilterAttivita(attivitaSvolta.getId());
						for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : listAttivitaDettaglio) {
							taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(attivitaDettaglio.getId(),
									attivitaDettaglio.getProgressivo()));
						}
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
					}

				}
			}
			// att4 MaterialePropagazione
			updateAttivitaQuatro(idAzienda, gestioneAttivitaUltimoAnno, attivitaMap, elencoMaterialePropagazione,
					idMaterialiPropagazione, dataTracciato);

			// att5 MaterialePropagazione
			updateAttivitaCinque(idAzienda, gestioneAttivitaUltimoAnno, attivitaMap, elencoArboricoltureLegno,
					materialePropagazione, dataTracciato);
			// att6 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att6))
					&& gestioneAttivitaUltimoAnno.getAttivita6() != null) {
				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita6SvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.sixInt);
				attivita6SvoltaFinded = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				if (attivita6SvoltaFinded != null && !attivita6SvoltaFinded.isEmpty()) {
					// update
					for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta6 : attivita6SvoltaFinded) {
						TaifTAttivitaSvoltaDto updateAttivitaSvolta61 = new TaifTAttivitaSvoltaDto();
						AttivitaUltimoAnno6 attivitaSei = gestioneAttivitaUltimoAnno.getAttivita6();
						updateAttivitaSvolta61.setIdAttivita(attivitaSvolta6.getId());
						updateAttivitaSvolta61.setFkAzienda(idAzienda);
						updateAttivitaSvolta61.setFkTipoAttivita(new Integer(Constants.sixInt));
						if (attivitaSei.getAltro() != null && attivitaSei.getAltro() != "") {
							updateAttivitaSvolta61.setDescrAltreAttivita(attivitaSei.getAltro());
						}
						if (attivitaSei.getPercentuale() != null) {
							updateAttivitaSvolta61.setPercFatturato(new BigDecimal(attivitaSei.getPercentuale()));
						}
						updateAttivitaSvolta61.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						updateAttivitaSvolta61.setFkConfigUtente(idConfigUtente);
						taifTAttivitaSvoltaDao.updateColumnsAttivitaForIdAzienda(updateAttivitaSvolta61);
					}
				} else {
					// insert
					insertAttivitaUltimoAnno6(idAzienda, gestioneAttivitaUltimoAnno);
				}
			} else {

				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita6SvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.sixInt);
				attivita6SvoltaBack = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				if (attivita6SvoltaBack != null && !attivita6SvoltaBack.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta : attivita6SvoltaBack) {
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
					}

				}
			}

			// att7 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att7))
					&& gestioneAttivitaUltimoAnno.getAttivita7() != null) {

				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita7SvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.sevenInt);
				AttivitaUltimoAnno7 attivitaSette = gestioneAttivitaUltimoAnno.getAttivita7();
				attivita7SvoltaFinded = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				if (attivita7SvoltaFinded != null && !attivita7SvoltaFinded.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta7 : attivita7SvoltaFinded) {
						TaifTAttivitaSvoltaDto updateAttivitaSvolta71 = new TaifTAttivitaSvoltaDto();
						updateAttivitaSvolta71.setIdAttivita(attivitaSvolta7.getId());
						updateAttivitaSvolta71.setFkAzienda(idAzienda);
						updateAttivitaSvolta71.setFkTipoAttivita(new Integer(Constants.sevenInt));
						if (attivitaSette.getAltro() != null && attivitaSette.getAltro() != "") {
							updateAttivitaSvolta71.setDescrAltreAttivita(attivitaSette.getAltro());
						}
						if (attivitaSette.getPercentuale() != null) {
							updateAttivitaSvolta71.setPercFatturato(new BigDecimal(attivitaSette.getPercentuale()));
						}
						updateAttivitaSvolta71.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						updateAttivitaSvolta71.setFkConfigUtente(idConfigUtente);
						taifTAttivitaSvoltaDao.updateColumnsAttivitaForIdAzienda(updateAttivitaSvolta71);
					}
				} else {
					// insert
					insertAttivitaUltimoAnno7(idAzienda, gestioneAttivitaUltimoAnno);
				}
			} else {

				// delete attivita
				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita7SvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.sevenInt);
				attivita7SvoltaBack = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				if (attivita7SvoltaBack != null && !attivita7SvoltaBack.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta : attivita7SvoltaBack) {
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
					}

				}
			}

			// att8 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att8))
					&& gestioneAttivitaUltimoAnno.getAttivita8() != null) {

				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita8SvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.eightInt);
				attivita8SvoltaFinded = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				AttivitaUltimoAnno8 attivitaEight = gestioneAttivitaUltimoAnno.getAttivita8();
				if (attivita8SvoltaFinded != null && !attivita8SvoltaFinded.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta8 : attivita8SvoltaFinded) {

						TaifTAttivitaSvoltaDto updateAttivitaSvolta81 = new TaifTAttivitaSvoltaDto();

						updateAttivitaSvolta81.setIdAttivita(attivitaSvolta8.getId());
						updateAttivitaSvolta81.setFkAzienda(idAzienda);
						updateAttivitaSvolta81.setFkTipoAttivita(new Integer(Constants.eightInt));
						if (attivitaEight.getAltro() != null && attivitaEight.getAltro() != "") {
							updateAttivitaSvolta81.setDescrAltreAttivita(attivitaEight.getAltro());
						}
						if (attivitaEight.getPercentuale() != null) {
							updateAttivitaSvolta81.setPercFatturato(new BigDecimal(attivitaEight.getPercentuale()));
						}
						updateAttivitaSvolta81.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						updateAttivitaSvolta81.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						updateAttivitaSvolta81.setFkConfigUtente(idConfigUtente);
						taifTAttivitaSvoltaDao.updateColumnsAttivitaForIdAzienda(updateAttivitaSvolta81);
					}
				} else {
					// insert
					insertAttivitaUltimoAnno8(idAzienda, gestioneAttivitaUltimoAnno);

				}
			} else {
				// delete attivita
				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita8SvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.eightInt);
				attivita8SvoltaBack = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				if (attivita8SvoltaBack != null && !attivita8SvoltaBack.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta : attivita8SvoltaBack) {
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
					}

				}
			}

			// att9 MaterialePropagazione
			if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att9))
					&& gestioneAttivitaUltimoAnno.getAttivita9() != null) {
				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita8SvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.nineInt);
				attivita8SvoltaFinded = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				AttivitaUltimoAnno9 attivitaNine = gestioneAttivitaUltimoAnno.getAttivita9();
				if (attivita8SvoltaFinded != null && !attivita8SvoltaFinded.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta9 : attivita8SvoltaFinded) {
						TaifTAttivitaSvoltaDto updateAttivitaSvolta91 = new TaifTAttivitaSvoltaDto();
						updateAttivitaSvolta91.setIdAttivita(attivitaSvolta9.getId());
						updateAttivitaSvolta91.setFkAzienda(idAzienda);
						updateAttivitaSvolta91.setFkTipoAttivita(new Integer(Constants.nineInt));
						if (attivitaNine.getAltro() != null && attivitaNine.getAltro() != "") {
							updateAttivitaSvolta91.setDescrAltreAttivita(attivitaNine.getAltro());
						}
						if (attivitaNine.getPercentuale() != null) {
							updateAttivitaSvolta91.setPercFatturato(new BigDecimal(attivitaNine.getPercentuale()));
						}
						updateAttivitaSvolta91.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						updateAttivitaSvolta91.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						updateAttivitaSvolta91.setFkConfigUtente(idConfigUtente);
						taifTAttivitaSvoltaDao.updateColumnsAttivitaForIdAzienda(updateAttivitaSvolta91);
					}
				} else {
					// insert
					insertAttivitaUltimoAnno9(idAzienda, gestioneAttivitaUltimoAnno);
				}
			} else {
				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivita9SvoltaDb = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.nineInt);
				attivita9SvoltaDb = taifTAttivitaSvoltaDao.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				if (attivita9SvoltaDb != null && !attivita9SvoltaDb.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta : attivita9SvoltaDb) {
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
					}
				}

			}
			// mancano le attivita franceze !!!
			TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (taifTaifAppl != null) {
				if (dataTracciato.contentEquals(Constants.fLang)) {
					taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.zero));
				} else {
					taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.zero));
				}
				taifApplSchedaOkDao.update(taifTaifAppl);
			}
			// add insert attivita
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			// throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaAttivitaUltimoAnno] END");
		}

	}

	public AziendaVisibleFilter getAziendaVisibleFilter(int idAzienda, String tracciato, int idTipoAttivita) {
		aziendaVisibleFilter.setIdAzienda(idAzienda);
		aziendaVisibleFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		aziendaVisibleFilter.setFlagItaFr(tracciato);
		aziendaVisibleFilter.setIdTipoAttivita(idTipoAttivita);
		return aziendaVisibleFilter;
	}

	public void updateAssocECert(Integer idAzienda, List<TaifTPraticaByIdAziendaAlboDto> backTaifTPraticaByIdAzienda,
			 ArrayList<FormaOrganizzativa> formeOrganizzative,
			
			List<TaifTCertificazioneElencoCertificazioniDto> backCertificazione,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String esisteAlbo, String esisteCertificazione,
			String dataTracciato) throws DbManagerException {

		log.debug("[DbMgr::updateAssocECert] BEGIN");
		List<Integer> listIdFormeCheck = new ArrayList<Integer>();
		TaifTPraticaDto pratica = new TaifTPraticaDto();
		List<TaifTPraticaDto> praticaUpdateList = new ArrayList<TaifTPraticaDto>();
		List<TaifTPraticaByIdAziendaDto> altrePraticheList = new ArrayList<TaifTPraticaByIdAziendaDto>();
		List<TaifTCertificazioneDto> listCertificazioneToUpdate = new ArrayList<TaifTCertificazioneDto>();
		List<Integer> listIdPratichePerAzienda = new ArrayList<Integer>();
		CertificazioneFilter certFilter = new CertificazioneFilter();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			idConfigUtente = profiloUtente.getIdConfigUtente();
			utx.begin();
			if (idAzienda != null) {
				// 1.
				// List<TaifRAziendaAssociazioneDto> azAsList= new
				// ArrayList<TaifRAziendaAssociazioneDto>();
				for (FormaOrganizzativa assocOrganiz : formeOrganizzative) {
					if (assocOrganiz.getIdFormaOrganizzativa() == 0) {
						assocOrganiz.setDsFormaOrganizzativa(Constants.nessunMome);
					}
					listIdFormeCheck.add(assocOrganiz.getIdFormaOrganizzativa());
					// azAsList.add(dozerBeanMapper.map(assocOrganiz,TaifRAziendaAssociazioneDto.class
					// ));
				}
				List<TaifRAziendaAssociazioneByIdAziendaDto> aziendaAssociazioneEsistente = taifRAziendaAssociazioneDao
						.findByIdAzienda(idAzienda);
				for (TaifRAziendaAssociazioneByIdAziendaDto taifRAziendaAssociazioneByIdAziendaDto : aziendaAssociazioneEsistente) {
					if (!(listIdFormeCheck.contains(taifRAziendaAssociazioneByIdAziendaDto.getIdAssociazione()))) {
						taifRAziendaAssociazioneDao.delete(new TaifRAziendaAssociazionePk(
								taifRAziendaAssociazioneByIdAziendaDto.getIdAssociazione(), idAzienda));
					}
				}
				List<Integer> listOfCategorie = Arrays.asList(5, 6, 7, 12, 13, 14);
				for (FormaOrganizzativa formaOrganizzativa : formeOrganizzative) {
					if (listIdFormeCheck.contains(formaOrganizzativa.getIdFormaOrganizzativa())) {
						TaifRAziendaAssociazioneDto aziendaAssociazione = taifRAziendaAssociazioneDao.findByPrimaryKey(
								new TaifRAziendaAssociazionePk(formaOrganizzativa.getIdFormaOrganizzativa(),
										idAzienda));
						if (aziendaAssociazione != null && aziendaAssociazione.getIdAssociazione() != null) {
							if (formaOrganizzativa.getIdFormaOrganizzativa() == aziendaAssociazione
									.getIdAssociazione()) {
								aziendaAssociazione.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								aziendaAssociazione.setFkConfigUtente(idConfigUtente);
								if (listOfCategorie.contains(aziendaAssociazione.getIdAssociazione())) {
									if (formaOrganizzativa.getAltroVisibile()) {
										aziendaAssociazione.setNome(formaOrganizzativa.getAltro());
									}
								}
								taifRAziendaAssociazioneDao.updateColumnsAziendaAssociazioni(aziendaAssociazione);
							}
						} else {
							TaifRAziendaAssociazioneDto taifRAziendaAssociazioneDto = new TaifRAziendaAssociazioneDto();
							taifRAziendaAssociazioneDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							taifRAziendaAssociazioneDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
							taifRAziendaAssociazioneDto.setIdAzienda(idAzienda);
							if (formaOrganizzativa.getAltro() != null && formaOrganizzativa.getAltroVisibile()) {
								taifRAziendaAssociazioneDto.setNome(formaOrganizzativa.getAltro());
							}

							taifRAziendaAssociazioneDto.setFkConfigUtente(idConfigUtente);
							taifRAziendaAssociazioneDto.setIdAssociazione(formaOrganizzativa.getIdFormaOrganizzativa());

							taifRAziendaAssociazioneDao.insert(taifRAziendaAssociazioneDto);
						}
					}
				}
				// 2.(dal Albo)// backTaifTPraticaByIdAzienda-all albi inseriti]
				if (esisteAlbo != null && backTaifTPraticaByIdAzienda != null && esisteAlbo.equals(Constants.SI)) {
					List<TaifTPraticaByIdAziendaDto> praticaToUpdateList = taifTPraticaDao.findByIdAzienda(idAzienda);
					for (TaifTPraticaByIdAziendaDto taifTPraticaByIdAziendaDto : praticaToUpdateList) {
						if (taifTPraticaByIdAziendaDto.getIdSoggettoGestore() == 0) {
							altrePraticheList.add(taifTPraticaByIdAziendaDto);
						}
					}
					for (TaifTPraticaByIdAziendaAlboDto praticaDaFe : backTaifTPraticaByIdAzienda) {
						listIdPratichePerAzienda.add(praticaDaFe.getIdPratica());
					}
					for (TaifTPraticaByIdAziendaDto praticaEsiste : altrePraticheList) {
						if (!(listIdPratichePerAzienda.contains(praticaEsiste.getIdPratica()))) {
							taifTPraticaDao.delete(new TaifTPraticaPk(praticaEsiste.getIdPratica()));
						}
					}
					for (TaifTPraticaByIdAziendaAlboDto taifTPraticaByIdAziendaAlboDto : backTaifTPraticaByIdAzienda) {
						TaifTPraticaDto praticaToUpdate = taifTPraticaDao
								.findByPrimaryKey(new TaifTPraticaPk(taifTPraticaByIdAziendaAlboDto.getIdPratica()));
						if (praticaToUpdate != null && praticaToUpdate.getIdPratica() != null) {
							praticaToUpdate.setFkSoggettoGestore(Integer.parseInt(Constants.zero));
							praticaToUpdate.setFkConfigUtente(idConfigUtente);
							praticaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							praticaToUpdate.setDenominazioneAltroAlbo(
									taifTPraticaByIdAziendaAlboDto.getDenominazioneAltroAlbo());
							praticaToUpdate.setNumeroAlbo(taifTPraticaByIdAziendaAlboDto.getNrAlbo());
							praticaToUpdate
									.setDataIscrizioneAlbo(taifTPraticaByIdAziendaAlboDto.getDataInscrizioneAlbo());

							taifTPraticaDao.updateColumnsPraticaByIdPratica(praticaToUpdate);
						} else {
							insertAltraPratica(idAzienda, taifTPraticaByIdAziendaAlboDto);
						}
					}
				}
				// if esisteAlbo = NO
				if (esisteAlbo != null && esisteAlbo.equals(Constants.NO)) {
					List<TaifTPraticaByIdAziendaDto> praticheDaCancellare = getPraticaPerIdAzienda(idAzienda);
					for (TaifTPraticaByIdAziendaDto pratCancel : praticheDaCancellare) {
						taifTPraticaDao.delete(new TaifTPraticaPk(pratCancel.getIdPratica()));
					}

				}
				// 3. 
				List<TaifTCertificazioneDto> certificazioneList = new ArrayList<TaifTCertificazioneDto>();
//				List<Integer> listCertificazioniCheck = new ArrayList<Integer>();
				List<TaifTCertificazioneByAziendaDto> certificazioniEsistente = taifTCertificazioneDao
						.findByAzienda(idAzienda);
//				for (TaifTCertificazioneElencoCertificazioniDto certifNewInsert : backCertificazione) {
//					listCertificazioniCheck.add(certifNewInsert.getIdCertificazione());
//				}
				for (TaifTCertificazioneByAziendaDto taifTCertificazioneByAziendaDto : certificazioniEsistente) {
//					if (!listCertificazioniCheck.contains(taifTCertificazioneByAziendaDto.getId())) {
						taifTCertificazioneDao
								.delete(new TaifTCertificazionePk(taifTCertificazioneByAziendaDto.getId()));
//					}
				}
				if (esisteCertificazione != null && esisteCertificazione.equals(Constants.SI)
						&& backCertificazione != null) {
					
					
					for (TaifTCertificazioneElencoCertificazioniDto certifNewInsert : backCertificazione) {
						certFilter.setIdAzienda(idAzienda);
						certFilter.setTipoCertificazione(certifNewInsert.getFkTipoCertificazione());
						List<TaifTCertificazioneByAziendaTipoCertDto> certificazione = taifTCertificazioneDao
								.findByAziendaTipoCert(certFilter);
						if (certificazione.size() > 0) {
							for (TaifTCertificazioneByAziendaTipoCertDto certEsistente : certificazione) {
//								// update ?
//								TaifTCertificazioneDto certificazioneUpdte = taifTCertificazioneDao
//										.findByPrimaryKey(new TaifTCertificazionePk(certEsistente.getId()));
//								certificazioneUpdte.setFkConfigUtente(idConfigUtente);
//								certificazioneUpdte.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
//								taifTCertificazioneDao.updateColumnsCertificazione(certificazioneUpdte);
							}
						} else {
							certificazioneList.add(dozerBeanMapper.map(certifNewInsert, TaifTCertificazioneDto.class));
						}
					}
					for (TaifTCertificazioneDto certToInsert : certificazioneList) {
						certToInsert.setFkAzienda(idAzienda);
						certToInsert.setFkConfigUtente(idConfigUtente);
						certToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						certToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						taifTCertificazioneDao.insert(certToInsert);
					}
						
					
					
				}
				TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao
						.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
				if (taifTaifAppl != null) {
					if (dataTracciato.contentEquals(Constants.fLang)) {
						taifTaifAppl.setFlgSez22FraOk(new BigDecimal(Constants.one));
						taifTaifAppl.setFlgSez22ItaOk(new BigDecimal(Constants.zero));
					} else {
						taifTaifAppl.setFlgSez22ItaOk(new BigDecimal(Constants.one));
						taifTaifAppl.setFlgSez22FraOk(new BigDecimal(Constants.zero));
					}
					taifApplSchedaOkDao.update(taifTaifAppl);
				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaAssociazoniECertificazioni] END");
		}
	}

	public List<TaifTAziendaDettaglioAziendaByIdAziendaDto> ricercaAziendeById(String idRiga)
			throws DbManagerException {
		log.debug("[DbMgr::ricercaAziendeById] BEGIN ");
		List<TaifTAziendaDettaglioAziendaByIdAziendaDto> aziendaList;
		try {
			aziendaList = taifTAziendaDao.findDettaglioAziendaByIdAzienda(new Integer(idRiga));
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::ricercaAziendeById] END");
		}
		return aziendaList;

	}

	public List<TaifRPersonaAziendaConteggioPersonaDto> conteggioNumeroAddettiByIdAzienda(String idRiga)
			throws DbManagerException {
		log.debug("[DbMgr::conteggioNumeroAddettiByIdAzienda] BEGIN ");
		List<TaifRPersonaAziendaConteggioPersonaDto> conteggio;
		try {
			conteggio = taifRPersonaAziendaDao.findConteggioPersona(new Integer(idRiga));
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::conteggioNumeroAddettiByIdAzienda] END");
		}
		return conteggio;

	}

	public List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> findAttivitaSvoltaAndDettByIdAzienda(
			AziendaVisibleFilter input) throws DbManagerException {
		log.debug("[DbMgr::findAttivitaSvoltaAndDettByIdAzienda] BEGIN ");
		List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivitaSvolta;
		try {
			attivitaSvolta = taifTAttivitaSvoltaDao.findAttivitaSvoltaAndDettByIdAzienda(input);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findAttivitaSvoltaAndDettByIdAzienda] END");
		}
		return attivitaSvolta;
	}

	public List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> findMaterialeByAttivitaProgressivo(
			AttivitaProgressivoFilter input) throws DbManagerException {
		log.debug("[DbMgr::findMaterialeByAttivitaProgressivo] BEGIN ");
		List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> materialeByAttivita;
		try {
			materialeByAttivita = taifRAttivDetMaterialeDao.findByIdAttivitaProgressivo(input);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findMaterialeByAttivitaProgressivo] END");
		}
		return materialeByAttivita;

	}

	public TaifRAttivDetMaterialeDto findByPrimaryKeyMaterialeDett(TaifRAttivDetMaterialePk materialeAttProgressivo)
			throws DbManagerException {
		log.debug("[DbMgr::findByPrimaryKey] BEGIN ");
		TaifRAttivDetMaterialeDto materialeById;
		try {
			materialeById = taifRAttivDetMaterialeDao.findByPrimaryKey(materialeAttProgressivo);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByPrimaryKey] END");
		}
		return materialeById;

	}

	public void updateCommercializzazioneLegnameEAssortimentiUltimoAnno(Integer idAzienda,
			ArrayList<LegnameAssortimentoTrattato> listLegnameAssortimento,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String esistenzaAttivitaLegname,
			Integer percentualeCommercioFr, String dataTracciato) throws DbManagerException {

		log.debug("[DbMgr::updateCommercializzazioneLegnameEAssortimentiUltimoAnno] BEGIN");
		idConfigUtente = profiloUtente.getIdConfigUtente();
		UserTransaction utx = txManager.getUserTransaction();
		AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
				it.csi.taif.taifweb.business.dao.util.Constants.eightInt);
		try {
			utx.begin();
			if (esistenzaAttivitaLegname.equals(Constants.SI)) {
				if (listLegnameAssortimento != null && !listLegnameAssortimento.isEmpty()) {
					List<TaifTCommercializzazioneDto> commercializzazioneList = new ArrayList<TaifTCommercializzazioneDto>();
					for (LegnameAssortimentoTrattato beLegnameAssortimento : listLegnameAssortimento) {
						commercializzazioneList
								.add(dozerBeanMapper.map(beLegnameAssortimento, TaifTCommercializzazioneDto.class));
					}
					List<Integer> listIdLegnaleFromFe = new ArrayList<Integer>();
					List<TaifTCommercializzazioneByAziendaDto> legnameCommEsistenti = taifTCommercializzazioneDao
							.findByAzienda(idAzienda);
					for (TaifTCommercializzazioneDto taifTCommercializzazione : commercializzazioneList) {
						listIdLegnaleFromFe.add(taifTCommercializzazione.getIdCommercializzazione());
					}
					for (TaifTCommercializzazioneByAziendaDto commEsistenti : legnameCommEsistenti) {
						if (!(listIdLegnaleFromFe.contains(commEsistenti.getId()))) {
							taifTCommercializzazioneDao.delete(new TaifTCommercializzazionePk(commEsistenti.getId()));
						}
					}
					//// este ultima commercializzazione si am attivita 8 ?

					TaifTAziendaDto aziendaFind = new TaifTAziendaDto();
					aziendaFind = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));

					if (dataTracciato.equals(Constants.fLang)) {
						aziendaFind.setPercCommercioFra(new BigDecimal(percentualeCommercioFr));
					} else {
						aziendaFind.setPercCommercioFra(null);
					}
					aziendaFind.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					taifTAziendaDao.update(aziendaFind);

					for (TaifTCommercializzazioneDto taifTCommercializzazione : commercializzazioneList) {
						if (taifTCommercializzazione.getIdCommercializzazione() != 0) {
							// update
							TaifTCommercializzazioneDto commercializzUpdate = taifTCommercializzazioneDao
									.findByPrimaryKey(new TaifTCommercializzazionePk(
											taifTCommercializzazione.getIdCommercializzazione()));
							commercializzUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							commercializzUpdate.setFkConfigUtente(idConfigUtente);
							commercializzUpdate.setFkAzienda(idAzienda);
							commercializzUpdate.setFkDestinazione(taifTCommercializzazione.getFkDestinazione());
							commercializzUpdate.setFkProvenienza(taifTCommercializzazione.getFkProvenienza());
							commercializzUpdate.setFkSpecie(taifTCommercializzazione.getFkSpecie());
							commercializzUpdate.setFkUnitaDiMisura(taifTCommercializzazione.getFkUnitaDiMisura());
							if (dataTracciato.equals(Constants.iLang)) {
								commercializzUpdate
										.setFlgTagliatoAcquistato(taifTCommercializzazione.getFlgTagliatoAcquistato());
							} else {
								commercializzUpdate.setFlgTagliatoAcquistato(null);
							}

							if (taifTCommercializzazione.getNote() != null) {
								commercializzUpdate.setNote(taifTCommercializzazione.getNote());
							}
							//taif-10
							commercializzUpdate.setFkAssortimento(taifTCommercializzazione.getFkAssortimento());
							commercializzUpdate.setVendutoMedio(taifTCommercializzazione.getVendutoMedio());
							//fine taif-10
							taifTCommercializzazioneDao.updateColumnsPeridAzienda(commercializzUpdate);

						} else {
							// insert
							taifTCommercializzazione.setDataInserimento(new Timestamp(System.currentTimeMillis()));
							taifTCommercializzazione.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							taifTCommercializzazione.setFkAzienda(idAzienda);
							taifTCommercializzazione.setFkConfigUtente(idConfigUtente);
							taifTCommercializzazioneDao.insert(taifTCommercializzazione);
						}
					}
					// insert attivita svolta - non inserico piu attivita 8
					// insertAttivitaOtto(idAzienda, dataTracciato);
					TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao
							.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
					if (taifTaifAppl != null) {
						if (dataTracciato.contentEquals(Constants.fLang)) {
							taifTaifAppl.setFlgSez33FraOk(new BigDecimal(Constants.one));
							taifTaifAppl.setFlgSez33ItaOk(new BigDecimal(Constants.zero));
							if (taifTaifAppl.getFlgSez31FraOk().equals(Constants.zero)) {
								taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.zero));
								taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.one));
							}
						} else {
							taifTaifAppl.setFlgSez33ItaOk(new BigDecimal(Constants.one));
							taifTaifAppl.setFlgSez33FraOk(new BigDecimal(Constants.zero));
							if (taifTaifAppl.getFlgSez31ItaOk().equals(Constants.zero)) {
								taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.one));
								taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.zero));
							}
						}

						taifApplSchedaOkDao.update(taifTaifAppl);
					}
				}
				// test quante commercializzazioni ho

			} else {
				List<TaifTCommercializzazioneByAziendaDto> legnameDaCancell = taifTCommercializzazioneDao
						.findByAzienda(idAzienda);
				if (legnameDaCancell != null & !legnameDaCancell.isEmpty()) {
					for (TaifTCommercializzazioneByAziendaDto legname : legnameDaCancell) {
						taifTCommercializzazioneDao.delete(new TaifTCommercializzazionePk(legname.getId()));
						//
					}
					// find attivita 8 da cancellare
					List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaOtto = findAttivitaSvoltaByIdAzienda(
							aziendaVisibleFilter);
					if (attivitaOtto.size() > 0) {
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaOtto.get(0).getId()));
					}

				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updateCommercializzazioneLegnameEAssortimentiUltimoAnno] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updateCommercializzazioneLegnameEAssortimentiUltimoAnno] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaCommercializzazioneLegnameEAssortimentiUltimoAnno] END");
		}

	}

	public void updateStrutture(Integer idAzienda, ArrayList<Capannone> capannoni,
			ArrayList<PiazzaleStoccaggio> piazzali, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			boolean esisstecapannone, boolean esistePiazzaSto, String dataTracciato) throws DbManagerException {

		log.debug("[DbMgr::updateStrutture] BEGIN");
		idConfigUtente = profiloUtente.getIdConfigUtente();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			List<Integer> idCappanoneList = new ArrayList<Integer>();
			List<Integer> idPiazzaleList = new ArrayList<Integer>();

			for (Capannone cappanoneFe : capannoni) {
				idCappanoneList.add(cappanoneFe.getIdCapannone());
			}
			for (PiazzaleStoccaggio piazzaliFe : piazzali) {
				idPiazzaleList.add(piazzaliFe.getIdPiazzaleStoccaggio());
			}

			List<TaifTStrutturaFindByAziendaDto> listCappanoneEsistenti = taifTStrutturaDao
					.findFindByAzienda(idAzienda);
			for (TaifTStrutturaFindByAziendaDto strStruttura : listCappanoneEsistenti) {
				if (!(strStruttura.getFunz().equals(Integer.valueOf(5))
						|| (strStruttura.getFunz().equals(Integer.valueOf(10))))) {
					if (!idCappanoneList.contains(strStruttura.getId())) {
						taifTStrutturaDao.delete(new TaifTStrutturaPk(strStruttura.getId()));
					}
				}
				if (strStruttura.getFunz().equals(Integer.valueOf(5))
						|| (strStruttura.getFunz().equals(Integer.valueOf(10)))) {
					if (!idPiazzaleList.contains(strStruttura.getId())) {
						taifTStrutturaDao.delete(new TaifTStrutturaPk(strStruttura.getId()));
					}
				}
			}
			if (esisstecapannone) {
				for (Capannone capannone : capannoni) {
					if (capannone.getIdCapannone() != 0) {
						// update
						TaifTStrutturaDto cappanoneToUpdate = taifTStrutturaDao
								.findByPrimaryKey(new TaifTStrutturaPk(capannone.getIdCapannone()));
						cappanoneToUpdate.setFkFunzione(capannone.getIdFunzione());
						cappanoneToUpdate.setFkAzienda(idAzienda);
						cappanoneToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						cappanoneToUpdate.setFkConfigUtente(idConfigUtente);
						cappanoneToUpdate.setDimensione(Integer.parseInt(capannone.getDimensioneCapannone()));
						cappanoneToUpdate.setAnno(new BigDecimal(capannone.getAnnoCostruzioneORiattamentoCapannone()));
						taifTStrutturaDao.updateColumnsPerIdAzienda(cappanoneToUpdate);
					} else {
						// insert
						TaifTStrutturaDto struToInsert = new TaifTStrutturaDto();
						struToInsert.setFkFunzione(capannone.getIdFunzione());
						struToInsert.setFkAzienda(idAzienda);
						struToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						struToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						struToInsert.setFkConfigUtente(idConfigUtente);
						struToInsert.setDimensione(Integer.parseInt(capannone.getDimensioneCapannone()));
						struToInsert.setAnno(new BigDecimal(capannone.getAnnoCostruzioneORiattamentoCapannone()));

						taifTStrutturaDao.insert(struToInsert);
					}
				}
			}
			if (esistePiazzaSto) {
				for (PiazzaleStoccaggio piazzale : piazzali) {
					if (piazzale.getIdPiazzaleStoccaggio() != 0) {
						// update
						TaifTStrutturaDto piazzaleToUpdate = taifTStrutturaDao
								.findByPrimaryKey(new TaifTStrutturaPk(piazzale.getIdPiazzaleStoccaggio()));
						piazzaleToUpdate.setFkAzienda(idAzienda);
						piazzaleToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						piazzaleToUpdate.setFkConfigUtente(idConfigUtente);
						piazzaleToUpdate.setFkFunzione(Constants.idFunzionePiazza);
						piazzaleToUpdate.setDimensione(Integer.parseInt(piazzale.getDimensionePiazzale()));
						piazzaleToUpdate.setAnno(new BigDecimal(piazzale.getAnnoCostruzioneORiattamentoPiazzale()));
						taifTStrutturaDao.updateColumnsPerIdAzienda(piazzaleToUpdate);
					} else {
						// insert
						TaifTStrutturaDto struToInsert = new TaifTStrutturaDto();

						struToInsert.setFkAzienda(idAzienda);
						struToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						struToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						struToInsert.setFkConfigUtente(idConfigUtente);
						struToInsert.setFkFunzione(Constants.idFunzionePiazza);
						struToInsert.setDimensione(Integer.parseInt(piazzale.getDimensionePiazzale()));
						struToInsert.setAnno(new BigDecimal(piazzale.getAnnoCostruzioneORiattamentoPiazzale()));

						taifTStrutturaDao.insert(struToInsert);
					}
				}
			}

			aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			taifTAziendaDao.update(aziendaToUpdate);

			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
				schedaToUpdate.setFlgSez4ItaOk(new BigDecimal(Constants.zero));
				schedaToUpdate.setFlgSez4FraOk(new BigDecimal(Constants.oneInt));
			} else {
				schedaToUpdate.setFlgSez4ItaOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez4FraOk(new BigDecimal(Constants.zero));
			}

			taifApplSchedaOkDao.update(schedaToUpdate);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updateStrutture] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updateStrutture] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updateStrutture] END");
		}

	}

	public void updateAttrezzaturaAntiInfortunisticaMezziDPI(Integer idAzienda,
			ArrayList<MezzoDiProtezioneIndividuale> caschiForestali,
			ArrayList<MezzoDiProtezioneIndividuale> scarponiRinforzati,
			ArrayList<MezzoDiProtezioneIndividuale> pantaloniAntitaglio, int idConfigUtente,
			Map<String, Boolean> attrezzatureMap, String dataTracciato) throws DbManagerException {

		log.debug("[DbMgr::salvaAttrezzaturaAntiInfortunisticaMezziDPI] BEGIN");

		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<Integer> listOfIdDpi = new ArrayList<Integer>();
			ArrayList<MezzoDiProtezioneIndividuale> listAllmezziProtezione = new ArrayList<MezzoDiProtezioneIndividuale>();
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkScarponi)) {
				listAllmezziProtezione.addAll(scarponiRinforzati);
			}
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkCaschi)) {
				listAllmezziProtezione.addAll(caschiForestali);
			}
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkPantaloni)) {
				listAllmezziProtezione.addAll(pantaloniAntitaglio);
			}

			List<TaifTDpiByAziendaDto> dpiEsitenti = taifTDpiDao.findByAzienda(idAzienda);

			for (MezzoDiProtezioneIndividuale dpi : listAllmezziProtezione) {
				listOfIdDpi.add(dpi.getIdMezzoDiProtezioneIndividuale());
			}
			for (TaifTDpiByAziendaDto taifTDpiByAziendaDto : dpiEsitenti) {
				if (!(listOfIdDpi.contains(taifTDpiByAziendaDto.getIdDpi()))) {
					taifTDpiDao.delete(new TaifTDpiPk(taifTDpiByAziendaDto.getIdDpi()));
				}
			}

			if (caschiForestali != null && !caschiForestali.isEmpty()
					&& attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkCaschi)) {

				TaifTDpiDto cascoForestale = new TaifTDpiDto();
				for (MezzoDiProtezioneIndividuale caschi : caschiForestali) {
					cascoForestale = taifTDpiDao
							.findByPrimaryKey(new TaifTDpiPk(new Integer(caschi.getIdMezzoDiProtezioneIndividuale())));
					if (cascoForestale != null && cascoForestale.getIdDpi() != null) {
						cascoForestale.setTipologia(caschi.getTipologia());
						cascoForestale.setQuantita(Integer.parseInt(caschi.getQuantita()));
						if (caschi.getAnnoScadenza() != null && !StringUtils.isEmpty(caschi.getAnnoScadenza())) {
							cascoForestale.setAnnoScad(new BigDecimal(caschi.getAnnoScadenza()));
						}
						cascoForestale.setFkTipoDpi(Constants.oneInt);
						cascoForestale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						cascoForestale.setFkAzienda(idAzienda);
						cascoForestale.setFkConfigUtente(idConfigUtente);
						taifTDpiDao.updateColumnsPerIdAzienda(cascoForestale);

					} else {
						TaifTDpiDto cascoToInsert = new TaifTDpiDto();
						cascoToInsert.setTipologia(caschi.getTipologia());
						cascoToInsert.setQuantita(Integer.parseInt(caschi.getQuantita()));
						if (caschi.getAnnoScadenza() != null && !StringUtils.isEmpty(caschi.getAnnoScadenza())) {
							cascoToInsert.setAnnoScad(new BigDecimal(caschi.getAnnoScadenza()));
						}
						cascoToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						cascoToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						cascoToInsert.setFkConfigUtente(idAzienda);
						cascoToInsert.setFkTipoDpi(Constants.oneInt);
						cascoToInsert.setFkAzienda(idAzienda);
						cascoToInsert.setFkConfigUtente(idConfigUtente);
						taifTDpiDao.insert(cascoToInsert);
					}
				}
			}
			if (scarponiRinforzati != null && !scarponiRinforzati.isEmpty()
					&& attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkScarponi)) {
				TaifTDpiDto scarponitoUpdate = new TaifTDpiDto();
				for (MezzoDiProtezioneIndividuale scarponi : scarponiRinforzati) {
					scarponitoUpdate = taifTDpiDao.findByPrimaryKey(
							new TaifTDpiPk(new Integer(scarponi.getIdMezzoDiProtezioneIndividuale())));
					if (scarponitoUpdate != null && scarponitoUpdate.getIdDpi() != null) {
						scarponitoUpdate.setTipologia(scarponi.getTipologia());
						scarponitoUpdate.setQuantita(Integer.parseInt(scarponi.getQuantita()));
						if (scarponi.getAnnoScadenza() != null && !StringUtils.isEmpty(scarponi.getAnnoScadenza())) {
							scarponitoUpdate.setAnnoScad(new BigDecimal(scarponi.getAnnoScadenza()));
						}
						scarponitoUpdate.setFkTipoDpi(Constants.twoInt);
						scarponitoUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						scarponitoUpdate.setFkAzienda(idAzienda);
						scarponitoUpdate.setFkConfigUtente(idConfigUtente);
						taifTDpiDao.updateColumnsPerIdAzienda(scarponitoUpdate);

					} else {
						TaifTDpiDto scarponiToInsert = new TaifTDpiDto();
						scarponiToInsert.setTipologia(scarponi.getTipologia());
						scarponiToInsert.setQuantita(Integer.parseInt(scarponi.getQuantita()));
						if (scarponi.getAnnoScadenza() != null && !StringUtils.isEmpty(scarponi.getAnnoScadenza())) {
							scarponiToInsert.setAnnoScad(new BigDecimal(scarponi.getAnnoScadenza()));
						}
						scarponiToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						scarponiToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						scarponiToInsert.setFkConfigUtente(idConfigUtente);
						scarponiToInsert.setFkTipoDpi(Constants.twoInt);
						scarponiToInsert.setFkAzienda(idAzienda);
						taifTDpiDao.insert(scarponiToInsert);
					}
				}
			}
			if (pantaloniAntitaglio != null && !pantaloniAntitaglio.isEmpty()
					&& attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkPantaloni)) {
				TaifTDpiDto pantalonitoUpdate = new TaifTDpiDto();
				for (MezzoDiProtezioneIndividuale pantaloni : pantaloniAntitaglio) {
					pantalonitoUpdate = taifTDpiDao.findByPrimaryKey(
							new TaifTDpiPk(new Integer(pantaloni.getIdMezzoDiProtezioneIndividuale())));
					if (pantalonitoUpdate != null && pantalonitoUpdate.getIdDpi() != null) {
						pantalonitoUpdate.setTipologia(pantaloni.getTipologia());
						pantalonitoUpdate.setQuantita(Integer.parseInt(pantaloni.getQuantita()));
						if (pantaloni.getAnnoScadenza() != null && !StringUtils.isEmpty(pantaloni.getAnnoScadenza())) {
							pantalonitoUpdate.setAnnoScad(new BigDecimal(pantaloni.getAnnoScadenza()));
						}
						pantalonitoUpdate.setFkTipoDpi(Constants.threInt);
						pantalonitoUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						pantalonitoUpdate.setFkConfigUtente(idConfigUtente);
						pantalonitoUpdate.setFkAzienda(idAzienda);
						taifTDpiDao.updateColumnsPerIdAzienda(pantalonitoUpdate);

					} else {
						TaifTDpiDto pantaloniToInsert = new TaifTDpiDto();
						pantaloniToInsert.setTipologia(pantaloni.getTipologia());
						pantaloniToInsert.setQuantita(Integer.parseInt(pantaloni.getQuantita()));
						if (pantaloni.getAnnoScadenza() != null && !StringUtils.isEmpty(pantaloni.getAnnoScadenza())) {
							pantaloniToInsert.setAnnoScad(new BigDecimal(pantaloni.getAnnoScadenza()));
						}
						pantaloniToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						pantaloniToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						pantaloniToInsert.setFkConfigUtente(idConfigUtente);
						pantaloniToInsert.setFkTipoDpi(Constants.threInt);
						pantaloniToInsert.setFkAzienda(idAzienda);
						taifTDpiDao.insert(pantaloniToInsert);
					}
				}
			}

			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));

			aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			taifTAziendaDao.update(aziendaToUpdate);
			if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
				schedaToUpdate.setFlgSez51ItaOk(new BigDecimal(Constants.zero));
				// schedaToUpdate.setFlgSez51FraOk(new BigDecimal(Constants.oneInt));
			} else {
				schedaToUpdate.setFlgSez51ItaOk(new BigDecimal(Constants.oneInt));
			}

			taifApplSchedaOkDao.update(schedaToUpdate);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaAttrezzaturaAntiInfortunisticaMezziDPI] END");
		}

	}

	public List<TaifDTipoMezzoByCategoriaMezzoDto> cercaTipoMezzoPerCategoriaMezzo(TipoMezzoFilter tipoMezzoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::cercaTipoMezzoPerCategoriaMezzo] BEGIN ");
		List<TaifDTipoMezzoByCategoriaMezzoDto> tipoMezzoList;
		try {
			tipoMezzoList = taifDTipoMezzoDao.findByCategoriaMezzo(tipoMezzoFilter);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::cercaTipoMezzoPerCategoriaMezzo] END");
		}
		return tipoMezzoList;
	}

	public List<TaifTMezzoByIdTipoMezzoAziendaDto> findMezzoByIdTipoMezzoAzienda(TipoMezzoFilter tipoMezzoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findMezzoByIdTipoMezzoAzienda] BEGIN ");
		List<TaifTMezzoByIdTipoMezzoAziendaDto> mezzoPerAziendaList;
		try {
			mezzoPerAziendaList = taifTMezzoDao.findByIdTipoMezzoAzienda(tipoMezzoFilter);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findMezzoByIdTipoMezzoAzienda] END");
		}
		return mezzoPerAziendaList;
	}

	public void cambiaStato(Integer idPratica, Integer idStatoDomanda, Integer idConfigUtente)
			throws DbManagerException {
		log.debug("[DbMgr::cambiaStato] BEGIN");
		try {
			List<TaifTStoricoStatoDto> list = this.taifTStoricoStatoDao.findStatoAttivo(idPratica);
			if (list != null && !list.isEmpty()) {

				Timestamp sysdate = DateUtil.getTimestampDataCorrente();

				TaifTStoricoStatoDto dto = list.get(0);
				dto.setDataAggiornamento(sysdate);
				dto.setDataFineStato(DateUtil.getSqlDataCorrente());

				// this.taifTStoricoStatoDao.updateColumnsCambioStato(dto);
				this.taifTStoricoStatoDao.customUpdaterFineStato(dto, ConvertUtil
						.convertToString(dto.getDataInserimentoStato(), DateUtil.DATE_FORMAT_PATTERN_TRADITIONAL));

				TaifTStoricoStatoDto newDto = new TaifTStoricoStatoDto();

				newDto.setDataAggiornamento(sysdate);
				newDto.setDataFineStato(null);
				newDto.setDataInserimentoStato(sysdate);
				// newDto.setDataProtocollo(dto.getDataProtocollo());
				newDto.setFkConfigUtente(idConfigUtente);
				newDto.setFkStatoPratica(idStatoDomanda);
				newDto.setIdPratica(idPratica);
				// newDto.setNote(dto.getNote());
				// newDto.setNumeroProtocollo(dto.getNumeroProtocollo());

				this.taifTStoricoStatoDao.insert(newDto);
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		log.debug("[DbMgr::cambiaStato] BEGIN");
	}

	public void cambiaStato(Integer idPratica, DettaglioStato obj, Integer idConfigUtente) throws DbManagerException {
		log.debug("[DbMgr::cambiaStato] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<TaifTStoricoStatoDto> list = this.taifTStoricoStatoDao.findStatoAttivo(idPratica);
			TaifTPraticaDto praticaDaCambiare = taifTPraticaDao.findByPrimaryKey(new TaifTPraticaPk(idPratica));
			if (list != null && !list.isEmpty()) {

				Timestamp sysdate = DateUtil.getTimestampDataCorrente();

				TaifTStoricoStatoDto dto = list.get(0);

				dto.setDataAggiornamento(sysdate);
				dto.setDataFineStato(DateUtil.getSqlDataCorrente());
				this.taifTStoricoStatoDao.updateColumnsCambioStato(dto);

				TaifTStoricoStatoDto newDto = new TaifTStoricoStatoDto();

				newDto.setDataAggiornamento(sysdate);
				newDto.setDataFineStato(null);
				newDto.setDataInserimentoStato(sysdate);
				newDto.setDataProtocollo(ConvertUtil.convertToSqlDate(obj.getDataProtocollo()));
				newDto.setFkConfigUtente(idConfigUtente);
				newDto.setFkStatoPratica(ConvertUtil.convertToInteger(obj.getIdStatoDomanda()));
				newDto.setIdPratica(idPratica);
				newDto.setNote(obj.getNote());
				newDto.setNumeroProtocollo(obj.getNumeroProtocollo());

				this.taifTStoricoStatoDao.insert(newDto);

				if (obj.getIdStatoDomanda().equals(Constants.four)) {
					if (praticaDaCambiare.getNumeroAlbo() == null
							|| praticaDaCambiare.getNumeroAlbo().trim().length() == 0) {
						Integer maxNumeroAlbo = getMaxNumeroAlboForGestore(praticaDaCambiare.getFkSoggettoGestore());
						praticaDaCambiare.setNumeroAlbo(String.valueOf(maxNumeroAlbo + 1));
						praticaDaCambiare.setDataIscrizioneAlbo(DateUtil.getSqlDataCorrente());
						taifTPraticaDao.updateColumnsPraticaByIdPratica(praticaDaCambiare);
					}

				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		log.debug("[DbMgr::cambiaStato] BEGIN");
	}

	public void updateMacchineEMezzi(Integer idAzienda, GestioneMacchineMezzi gestioneMacchineMezzi, int idConfigUtente,
			Map<String, Boolean> macchineMezziMap, String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaMacchineEMezzi] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<MacchinaMezzo> unionOfMacchineLists = new ArrayList<MacchinaMezzo>();
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			// TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao.findByPrimaryKey(new
			// TaifApplSchedaOkPk(idAzienda));

			TipoMezzoFilter tipoMezzoFilter = new TipoMezzoFilter();
			tipoMezzoFilter.setFlagItaFr(dataTracciato);
			tipoMezzoFilter.setFlagVisibile(Constants.oneInt);

			List<TaifTMezzoDto> backMezzoList = new ArrayList<TaifTMezzoDto>();
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkTrattici)
					&& gestioneMacchineMezzi.getElencoTrattrici() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoTrattrici(), tipoMezzoFilter,
						Constants.Trattrice);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoTrattrici());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkSpeciali)
					&& gestioneMacchineMezzi.getElencoMacchineSpeciali() != null) {
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMacchineSpeciali());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkTerra)
					&& gestioneMacchineMezzi.getElencoMacchineMovimentoTerra() != null) {
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMacchineMovimentoTerra());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkRimorchi)
					&& gestioneMacchineMezzi.getElencoRimorchi() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoRimorchi(), tipoMezzoFilter,
						Constants.Rimorchio);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoRimorchi());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkVerricelli)
					&& gestioneMacchineMezzi.getElencoVerricelli() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoVerricelli(), tipoMezzoFilter,
						Constants.Verricello);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoVerricelli());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkPle)
					&& gestioneMacchineMezzi.getElencoPiattaformaElevabile() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoPiattaformaElevabile(), tipoMezzoFilter,
						Constants.PLE);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoPiattaformaElevabile());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkTrincia)
					&& gestioneMacchineMezzi.getElencoTrinciaForestale() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoTrinciaForestale(), tipoMezzoFilter,
						Constants.Trincia);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoTrinciaForestale());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkSegherie)
					&& gestioneMacchineMezzi.getElencoSegherieMobili() != null) {
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoSegherieMobili());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkGru)
					&& gestioneMacchineMezzi.getElencoGruACavo() != null) {
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoGruACavo());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkCippatrici)
					&& gestioneMacchineMezzi.getElencoCippatrici() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoCippatrici(), tipoMezzoFilter,
						Constants.Cippatrice);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoCippatrici());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkMezziTra)
					&& gestioneMacchineMezzi.getElencoMezziDiTrasporto() != null) {
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMezziDiTrasporto());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkMezziAltri)
					&& gestioneMacchineMezzi.getElencoAltriMezzi() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoAltriMezzi(), tipoMezzoFilter,
						Constants.Altro);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoAltriMezzi());
			}

			List<Integer> listIdMezzo = new ArrayList<Integer>();
			List<TaifTMezzoByIdAziendaDto> mezziEsistenti = taifTMezzoDao.findByIdAzienda(idAzienda);
			for (MacchinaMezzo mezzo : unionOfMacchineLists) {
				listIdMezzo.add(mezzo.getIdMacchinaMezzo());
			}
			for (TaifTMezzoByIdAziendaDto macchinaMezzo : mezziEsistenti) {
				if (!(listIdMezzo.contains(macchinaMezzo.getId()))) {
					taifTMezzoDao.delete(new TaifTMezzoPk(macchinaMezzo.getId()));
				}
			}
			if (unionOfMacchineLists != null && unionOfMacchineLists.size() > 0) {
				for (MacchinaMezzo macchina : unionOfMacchineLists) {
					backMezzoList.add(dozerBeanMapper.map(macchina, TaifTMezzoDto.class));
				}
				for (TaifTMezzoDto mezzi : backMezzoList) {

					TaifTMezzoDto mezzoDaUpdate = taifTMezzoDao.findByPrimaryKey(new TaifTMezzoPk(mezzi.getIdMezzo()));
					if (mezzoDaUpdate != null && mezzoDaUpdate.getIdMezzo() != null) {
						if (mezzi.getFkAlimentazione() != null) {
							mezzoDaUpdate.setFkAlimentazione(mezzi.getFkAlimentazione());
						}
						if (mezzi.getFkTipoCarrello() != null) {
							mezzoDaUpdate.setFkTipoCarrello(mezzi.getFkTipoCarrello());
						}
						if (mezzi.getAnno() != null) {
							mezzoDaUpdate.setAnno(mezzi.getAnno());
						}
						if (mezzi.getFkTrazione() != null) {
							mezzoDaUpdate.setFkTrazione(mezzi.getFkTrazione());
						}
						if (mezzi.getFlgComandatoDistanza() != null) {
							mezzoDaUpdate.setFlgComandatoDistanza(mezzi.getFlgComandatoDistanza());
						}

						if (mezzi.getFlgNoleggio() != null) {
							mezzoDaUpdate.setFlgNoleggio(mezzi.getFlgNoleggio());
						}

						if (mezzi.getFkTipoMezzo() != null) {
							mezzoDaUpdate.setFkTipoMezzo(mezzi.getFkTipoMezzo());
						}

						if (mezzi.getPotenzaKw() != null && mezzi.getPotenzaKw().intValue() > 0) {
							mezzoDaUpdate.setPotenzaKw(mezzi.getPotenzaKw());
						} else {
							mezzoDaUpdate.setPotenzaKw(new Integer(Constants.zeroInt));
						}

						if (mezzi.getPortataKg() != null && mezzi.getPortataKg().intValue() > 0) {
							mezzoDaUpdate.setPortataKg(mezzi.getPortataKg());
						} else {
							mezzoDaUpdate.setPortataKg(new Integer(Constants.zeroInt));
						}
						mezzoDaUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						mezzoDaUpdate.setFkAzienda(idAzienda);
						mezzoDaUpdate.setFkConfigUtente(idConfigUtente);
						mezzoDaUpdate.setDescrAltro(mezzi.getDescrAltro());
						taifTMezzoDao.updateColumnsPerIdAzienda(mezzoDaUpdate);
					} else {
						mezzi.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						mezzi.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						mezzi.setFkAzienda(idAzienda);
						mezzi.setFkConfigUtente(idConfigUtente);
						if (mezzi.getFkTrazione() == null) {
							mezzi.setFkTrazione(Constants.zeroInt);
						}
						if (mezzi.getFkAlimentazione() == null) {
							mezzi.setFkAlimentazione(Constants.zeroInt);
						}
						if (mezzi.getFkTipoCarrello() == null) {
							mezzi.setFkTipoCarrello(Constants.zeroInt);
						}
						if (mezzi.getFlgComandatoDistanza() == null) {
							mezzi.setFlgComandatoDistanza(new BigDecimal(Constants.zeroInt));
						}

						if (mezzi.getPotenzaKw() != null && mezzi.getPotenzaKw().intValue() > 0) {
							mezzi.setPotenzaKw(mezzi.getPotenzaKw());
						} else {
							mezzi.setPotenzaKw(new Integer(Constants.zeroInt));
						}

						if (mezzi.getPortataKg() != null && mezzi.getPortataKg().intValue() > 0) {
							mezzi.setPortataKg(mezzi.getPortataKg());
						} else {
							mezzi.setPortataKg(new Integer(Constants.zeroInt));
						}

						taifTMezzoDao.insert(mezzi);
					}

				}
				aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				aziendaToUpdate.setFkConfigUtente(idConfigUtente);

				taifTAziendaDao.update(aziendaToUpdate);

			}
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
				schedaToUpdate.setFlgSez52ItaOk(new BigDecimal(Constants.zero));
				schedaToUpdate.setFlgSez52FraOk(new BigDecimal(Constants.oneInt));
			} else {
				schedaToUpdate.setFlgSez52ItaOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez52FraOk(new BigDecimal(Constants.zero));
			}
			taifApplSchedaOkDao.update(schedaToUpdate);
			
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaMacchineEMezzi] END");
		}
	}

	public TitolareRappresentanteLegale findPersoneListByIdAziendaIdRuolo(int idAzienda, int idRuolo,
			String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::findPersoneListByIdAzienda] BEGIN ");
		List<TaifTPersonaByIdAziendaDto> personePerAziendaList;
		TitolareRappresentanteLegale legaleRappresentante = new TitolareRappresentanteLegale();
		try {
			personePerAziendaList = taifTPersonaDao.findByIdAzienda(idAzienda);
			if (personePerAziendaList != null && !personePerAziendaList.isEmpty()) {
				for (TaifTPersonaByIdAziendaDto taifTPersonaByIdAziendaDto : personePerAziendaList) {
					if (taifTPersonaByIdAziendaDto.getIdRuoloPersona() == idRuolo) {
						legaleRappresentante = dozerBeanMapper.map(taifTPersonaByIdAziendaDto,
								TitolareRappresentanteLegale.class);
						if (dataTracciato.equals(Constants.iLang)) {
							legaleRappresentante
									.setIdTitoloDiStudio(String.valueOf(taifTPersonaByIdAziendaDto.getIdTitolo()));
						} else {
							legaleRappresentante
									.setIdTitoloDiStudio(String.valueOf(taifTPersonaByIdAziendaDto.getIdStudioFra()));
						}
					}
				}
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findPersoneListByIdAzienda] END");
		}
		return legaleRappresentante;
	}
	// public List<TaifTPersonaByFilterDto> findByFilter(
	// it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter input) throws
	// TaifTPersonaDaoException {

	public Integer findUserCollegatoPerCodiceFiscale(PersonaFilter filterPersona, String tracciato)
			throws DbManagerException {
		log.debug("[DbMgr::findUserCollegatoPerCodiceFiscale] BEGIN ");
		UserTransaction utx = txManager.getUserTransaction();
		List<TaifTPersonaByFilterDto> personaCollegataTrovata;
		Integer idConfigUtente = 0;
		try {
			utx.begin();
			personaCollegataTrovata = taifTPersonaDao.findByFilter(filterPersona);
			if (personaCollegataTrovata != null && !personaCollegataTrovata.isEmpty()) {
				for (TaifTPersonaByFilterDto taifTPersonaByFilterDto : personaCollegataTrovata) {
					// trovata persona
					PersonaSoggettogestoreFilter personaSoggettogestoreFilter = new PersonaSoggettogestoreFilter();
					personaSoggettogestoreFilter.setIdPersona(taifTPersonaByFilterDto.getId());
					personaSoggettogestoreFilter.setIdSoggettoGestore(Constants.zeroInt);
					personaSoggettogestoreFilter.setIdProfilo(filterPersona.getIdProfiloUtente());
					List<TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto> trovatoProfiloPersona = taifCnfConfigUtenteDao
							.findProfiloByIdPersonaIdSoggettoGestore(personaSoggettogestoreFilter);
					if (trovatoProfiloPersona != null && !trovatoProfiloPersona.isEmpty()) {
						// ok
						idConfigUtente = trovatoProfiloPersona.get(0).getIdConfigUtente();
					} else {
						// no trovato profilo persona ma esiste persona
						if (filterPersona.getIdProfiloUtente() != 3 && filterPersona.getIdProfiloUtente() != 4
								&& filterPersona.getIdProfiloUtente() != 5) {
							// no profilo 3,4,5
							idConfigUtente = insertConfigPersonaPerProfilo(filterPersona,
									taifTPersonaByFilterDto.getId());
						}
					}
				}
			} else {
				if (filterPersona.getIdProfiloUtente() != 3 && filterPersona.getIdProfiloUtente() != 4
						&& filterPersona.getIdProfiloUtente() != 5) {
					// insert persona
					TaifTPersonaDto personaToInsert = new TaifTPersonaDto();
					if (filterPersona.getIdNazione() == 1) {
						personaToInsert.setCodiceFiscale(filterPersona.getCodiceFiscale());
					} else {
						personaToInsert.setNRsiMsa(filterPersona.getCodiceFiscale());
					}
					personaToInsert.setNome(filterPersona.getNome());
					personaToInsert.setCognome(filterPersona.getCognome());
					personaToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					personaToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					personaToInsert.setFkTitoloStudio(0);
					personaToInsert.setFkTitoloStudioFra(0);
					personaToInsert.setFkNazione(filterPersona.getIdNazione());
					TaifTPersonaPk personaPk = taifTPersonaDao.insert(personaToInsert);

					idConfigUtente = insertConfigPersonaPerProfilo(filterPersona, personaPk.getIdPersona());

				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::findUserCollegatoPerCodiceFiscale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::findUserCollegatoPerCodiceFiscale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findUserCollegatoPerCodiceFiscale] END");
		}
		return idConfigUtente;
	}

	private int insertConfigPersonaPerProfilo(PersonaFilter filterPersona, int idPersona) {
		TaifCnfConfigUtenteDto configUtenteInsert = new TaifCnfConfigUtenteDto();
		configUtenteInsert.setFkPersona(idPersona);
		configUtenteInsert.setFkSoggettoGestore(Integer.parseInt(Constants.zero));
		configUtenteInsert.setFkProfiloUtente(filterPersona.getIdProfiloUtente());
		configUtenteInsert.setDataPrimoAccesso(new Timestamp(System.currentTimeMillis()));
		configUtenteInsert.setDataUltimoAccesso(new Timestamp(System.currentTimeMillis()));
		configUtenteInsert.setNrAccessi(0);

		Integer idConfigUtente = taifCnfConfigUtenteDao.insert(configUtenteInsert).getIdConfigUtente();
		return idConfigUtente;
	}

	public Integer getIdPraticaByAziendaAndSoggettoGestore(Integer idAzienda, Integer idSoggettoGestore)
			throws DbManagerException {
		log.debug("[DbMgr::getIdPraticaByAziendaAndSoggettoGestore] BEGIN");
		Integer result = null;
		try {
			List<TaifTPraticaDto> list = this.taifTPraticaDao.findByIdAziendaIdSoggettoGestore(idAzienda,
					idSoggettoGestore);
			if (list != null && !list.isEmpty()) {
				result = list.get(0).getIdPratica();
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		log.debug("[DbMgr::cambiaStato] BEGIN");
		return result;
	}

	private void insertAttivitaUltimoAnno2(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno) {
		TaifTAttivitaSvoltaDettDto attivitaSvoltaDett21 = new TaifTAttivitaSvoltaDettDto();
		TaifTAttivitaSvoltaDto attivitaSvolta21 = new TaifTAttivitaSvoltaDto();

		AttivitaUltimoAnno2 attivita2 = gestioneAttivitaUltimoAnno.getAttivita2();

		attivitaSvoltaDett21.setProgressivo(Constants.oneInt);
		attivitaSvoltaDett21.setValore1(new BigDecimal(attivita2.getEttariRealizzati()));
		attivitaSvoltaDett21.setFkUnitaDiMisura(Constants.fiveInt);

		attivitaSvolta21.setFkAzienda(idAzienda);
		attivitaSvolta21.setFkTipoAttivita(new Integer(Constants.twoInt));
		if (attivita2.getAltro() != null && attivita2.getAltro() != "") {
			attivitaSvolta21.setDescrAltreAttivita(attivita2.getAltro());
		}
		if (attivita2.getPercentuale() != null) {
			attivitaSvolta21.setPercFatturato(new BigDecimal(attivita2.getPercentuale()));
		}

		attivitaSvolta21.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta21.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta21.setFkConfigUtente(idConfigUtente);
		TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta21);

		attivitaSvoltaDett21.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaDett21.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaDett21.setFkConfigUtente(idConfigUtente);
		attivitaSvoltaDett21.setIdAttivita(idAttSvolta.getIdAttivita());
		taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett21);
	}

	private void insertAttivitaUltimoAnno3(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno) {
		TaifTAttivitaSvoltaDettDto attivitaSvoltaDett31 = new TaifTAttivitaSvoltaDettDto();
		TaifTAttivitaSvoltaDto attivitaSvolta31 = new TaifTAttivitaSvoltaDto();

		AttivitaUltimoAnno3 attivita3 = gestioneAttivitaUltimoAnno.getAttivita3();

		attivitaSvoltaDett31.setProgressivo(Constants.oneInt);
		attivitaSvoltaDett31.setValore1(new BigDecimal(attivita3.getRealizzazione()));
		attivitaSvoltaDett31.setValore2(new BigDecimal(attivita3.getManutenzione()));
		attivitaSvoltaDett31.setFkUnitaDiMisura(Constants.sixInt);

		attivitaSvolta31.setFkAzienda(idAzienda);
		attivitaSvolta31.setFkTipoAttivita(new Integer(Constants.threInt));
		if (attivita3.getAltro() != null && attivita3.getAltro() != "") {
			attivitaSvolta31.setDescrAltreAttivita(attivita3.getAltro());
		}
		if (attivita3.getPercentuale() != null) {
			attivitaSvolta31.setPercFatturato(new BigDecimal(attivita3.getPercentuale()));
		}

		attivitaSvolta31.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta31.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta31.setFkConfigUtente(idConfigUtente);
		TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta31);

		attivitaSvoltaDett31.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaDett31.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaDett31.setFkConfigUtente(idConfigUtente);
		attivitaSvoltaDett31.setIdAttivita(idAttSvolta.getIdAttivita());
		taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett31);
	}

	private void insertAttivitaUltimoAnno6(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno) {
		TaifTAttivitaSvoltaDto attivitaSvolta61 = new TaifTAttivitaSvoltaDto();
		AttivitaUltimoAnno6 attivitaSei = gestioneAttivitaUltimoAnno.getAttivita6();

		attivitaSvolta61.setFkAzienda(idAzienda);
		attivitaSvolta61.setFkTipoAttivita(new Integer(Constants.sixInt));
		if (attivitaSei.getAltro() != null && attivitaSei.getAltro() != "") {
			attivitaSvolta61.setDescrAltreAttivita(attivitaSei.getAltro());
		}
		if (attivitaSei.getPercentuale() != null) {
			attivitaSvolta61.setPercFatturato(new BigDecimal(attivitaSei.getPercentuale()));
		}

		attivitaSvolta61.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta61.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta61.setFkConfigUtente(idConfigUtente);
		TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta61);
	}

	private void insertAttivitaUltimoAnno7(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno) {
		TaifTAttivitaSvoltaDto attivitaSvolta71 = new TaifTAttivitaSvoltaDto();
		AttivitaUltimoAnno7 attivitaSette = gestioneAttivitaUltimoAnno.getAttivita7();

		attivitaSvolta71.setFkAzienda(idAzienda);
		attivitaSvolta71.setFkTipoAttivita(new Integer(Constants.sevenInt));
		if (attivitaSette.getAltro() != null && attivitaSette.getAltro() != "") {
			attivitaSvolta71.setDescrAltreAttivita(attivitaSette.getAltro());
		}
		if (attivitaSette.getPercentuale() != null) {
			attivitaSvolta71.setPercFatturato(new BigDecimal(attivitaSette.getPercentuale()));
		}
		attivitaSvolta71.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta71.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta71.setFkConfigUtente(idConfigUtente);
		TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta71);
	}

	private void insertAttivitaUltimoAnno8(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno) {
		TaifTAttivitaSvoltaDto attivitaSvolta81 = new TaifTAttivitaSvoltaDto();
		AttivitaUltimoAnno8 attivitaEight = gestioneAttivitaUltimoAnno.getAttivita8();

		attivitaSvolta81.setFkAzienda(idAzienda);
		attivitaSvolta81.setFkTipoAttivita(new Integer(Constants.eightInt));
		if (attivitaEight.getAltro() != null && attivitaEight.getAltro() != "") {
			attivitaSvolta81.setDescrAltreAttivita(attivitaEight.getAltro());
		}
		if (attivitaEight.getPercentuale() != null) {
			attivitaSvolta81.setPercFatturato(new BigDecimal(attivitaEight.getPercentuale()));
		}
		attivitaSvolta81.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta81.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta81.setFkConfigUtente(idConfigUtente);
		TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta81);
	}

	private void insertAttivitaUltimoAnno9(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno) {
		TaifTAttivitaSvoltaDto attivitaSvolta91 = new TaifTAttivitaSvoltaDto();
		AttivitaUltimoAnno9 attivitaNine = gestioneAttivitaUltimoAnno.getAttivita9();

		attivitaSvolta91.setFkAzienda(idAzienda);
		attivitaSvolta91.setFkTipoAttivita(new Integer(Constants.nineInt));
		if (attivitaNine.getAltro() != null && attivitaNine.getAltro() != "") {
			attivitaSvolta91.setDescrAltreAttivita(attivitaNine.getAltro());
		}
		if (attivitaNine.getPercentuale() != null) {
			attivitaSvolta91.setPercFatturato(new BigDecimal(attivitaNine.getPercentuale()));
		}

		attivitaSvolta91.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta91.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta91.setFkConfigUtente(idConfigUtente);
		TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta91);
	}

	public void eliminaDomandaByIdzienda(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::eliminaDomandaByIdzienda] BEGIN");
		Integer result = null;
		log.debug("[DbMgr::salvaStrutture] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();

			//// deletesedeAzienda
			List<TaifTAllegatoByIdPraticaAllDto> allFileAllegatoB = new ArrayList<TaifTAllegatoByIdPraticaAllDto>();
			List<TaifTStoricoStatoByidPraticaFRDto> allStoricoPraticaFr = new ArrayList<TaifTStoricoStatoByidPraticaFRDto>();
			List<TaifTStoricoStatoByidPraticaITDto> allStoricoPraticaIt = new ArrayList<TaifTStoricoStatoByidPraticaITDto>();
			List<TaifTSedeAziendaByIdAziendaDto> allSedeAzienda = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
			if (allSedeAzienda != null && !allSedeAzienda.isEmpty())
				for (TaifTSedeAziendaByIdAziendaDto sedeAzienda : allSedeAzienda) {
					taifTSedeAziendaDao.delete(new TaifTSedeAziendaPk(sedeAzienda.getId()));
				}
			// delete rpersonaAzienda
			List<TaifRPersonaAziendaByIdAziendaDto> allPersPerAzienda = taifRPersonaAziendaDao
					.findByIdAzienda(idAzienda);
			if (allPersPerAzienda != null && !allPersPerAzienda.isEmpty()) {
				for (TaifRPersonaAziendaByIdAziendaDto persAzienda : allPersPerAzienda) {
					taifRPersonaAziendaDao
							.delete(new TaifRPersonaAziendaPk(persAzienda.getId(), persAzienda.getIdAz()));
					// pers, azienda
				}
			}
			// R_AZIENDA_CATEGIMPRESA
			List<TaifRAziendaCategImpresaByIdAziendaDto> allAziendaCategoriaImpresa = taifRAziendaCategImpresaDao
					.findByIdAzienda(idAzienda);
			if (allAziendaCategoriaImpresa != null && !allAziendaCategoriaImpresa.isEmpty()) {
				for (TaifRAziendaCategImpresaByIdAziendaDto aziendaCategImpresa : allAziendaCategoriaImpresa) {
					taifRAziendaCategImpresaDao.delete(new TaifRAziendaCategImpresaPk(
							aziendaCategImpresa.getIdAzienda(), aziendaCategImpresa.getIdcategImpresa()));
					// IdAzienda(idAzienda); //IdCategoria(idCategoria);
				}
			}
			// R_AZIENDA_ASSOCIAZIONI
			List<TaifRAziendaAssociazioneByIdAziendaDto> allAzociazioniAzienda = taifRAziendaAssociazioneDao
					.findByIdAzienda(idAzienda);
			if (allAzociazioniAzienda != null && !allAzociazioniAzienda.isEmpty()) {
				log.info("[DbMgr::eliminaDomandaByIdzienda] TaifRAziendaAssociazioneByIdAziendaDto not null");
				for (TaifRAziendaAssociazioneByIdAziendaDto associazioneAzienda : allAzociazioniAzienda) {
					log.info("[DbMgr::eliminaDomandaByIdzienda] getIdAzienda"+ associazioneAzienda.getIdAzienda());
					log.info("[DbMgr::eliminaDomandaByIdzienda] getIdAssociazione"+ associazioneAzienda.getIdAssociazione());

					taifRAziendaAssociazioneDao.delete(new TaifRAziendaAssociazionePk(
							associazioneAzienda.getIdAssociazione(), associazioneAzienda.getIdAzienda()));
					// IdAssociazione(idAssociazione); //IdAzienda(idAzienda);
				}
			}

			// CERTIFICAZIONI
			List<TaifTCertificazioneByAziendaDto> allCertificazioniAzienda = taifTCertificazioneDao
					.findByAzienda(idAzienda);
			if (allCertificazioniAzienda != null && !allCertificazioniAzienda.isEmpty()) {
				for (TaifTCertificazioneByAziendaDto certificazioni : allCertificazioniAzienda) {
					taifTCertificazioneDao.delete(new TaifTCertificazionePk(certificazioni.getId()));
				}
			}
			// ATTIVITA_SVOLTE //ATTIVITA_SVOLTE_DETTAGLIO // RMateriale
			List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> attivitaSvoltaDettaglio = new ArrayList<TaifTAttivitaSvoltaDettByFilterAttivitaDto>();
			List<TaifTAttivitaSvoltaByIdAziendaDto> attivitaSvoltaByAzienda = taifTAttivitaSvoltaDao
					.findByIdAzienda(idAzienda);
			List<TaifRAttivDetMaterialeByIdAttivitaDto> rmaterialeAttivita = new ArrayList<TaifRAttivDetMaterialeByIdAttivitaDto>();
			if (attivitaSvoltaByAzienda != null && !attivitaSvoltaByAzienda.isEmpty()) {
				for (TaifTAttivitaSvoltaByIdAziendaDto attivitaSvolta : attivitaSvoltaByAzienda) {
					attivitaSvoltaDettaglio = taifTAttivitaSvoltaDettDao.findByFilterAttivita(attivitaSvolta.getId());
					if (attivitaSvoltaDettaglio != null && !attivitaSvoltaDettaglio.isEmpty()) {
						for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : attivitaSvoltaDettaglio) {
							rmaterialeAttivita = taifRAttivDetMaterialeDao.findByIdAttivita(attivitaDettaglio.getId());
							if (rmaterialeAttivita != null && !rmaterialeAttivita.isEmpty()) {
								for (TaifRAttivDetMaterialeByIdAttivitaDto materiale : rmaterialeAttivita) {
									taifRAttivDetMaterialeDao
											.delete(new TaifRAttivDetMaterialePk(materiale.getIdMateriale(),
													materiale.getProgressivo(), materiale.getProgressivo()));
									// IdMateriale IdAttivita Progressivo
								}
							}
							taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(attivitaDettaglio.getId(),
									attivitaDettaglio.getProgressivo()));
							// IdAttivita Progressivo
						}
					}
					taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
				}
			}
			// LAVORI_PA
			List<TaifTLavoroPaLavoroPaByAziendaVisibileDto> lavoroPaList = new ArrayList<TaifTLavoroPaLavoroPaByAziendaVisibileDto>();
			aziendaVisibleFilter.setIdAzienda(idAzienda);
			aziendaVisibleFilter.setFlagVisibile(Constants.oneInt);
			lavoroPaList = taifTLavoroPaDao.findLavoroPaByAziendaVisibile(aziendaVisibleFilter);
			if (lavoroPaList != null && !lavoroPaList.isEmpty()) {
				for (TaifTLavoroPaLavoroPaByAziendaVisibileDto lavoroPa : lavoroPaList) {
					taifTLavoroPaDao.delete(new TaifTLavoroPaPk(lavoroPa.getIdLavoro()));
				}
			}
			// COMMERCIALIZZAZIONER
			List<TaifTCommercializzazioneByAziendaDto> allCommercializzazioneList = taifTCommercializzazioneDao
					.findByAzienda(idAzienda);
			if (allCommercializzazioneList != null && !allCommercializzazioneList.isEmpty()) {
				for (TaifTCommercializzazioneByAziendaDto commerciallizazione : allCommercializzazioneList) {
					taifTCommercializzazioneDao.delete(new TaifTCommercializzazionePk(commerciallizazione.getId()));
				}
			}
			// STRUTTURE
			List<TaifTStrutturaFindByAziendaDto> allStruttureByAzienda = taifTStrutturaDao.findFindByAzienda(idAzienda);
			if (allStruttureByAzienda != null && !allStruttureByAzienda.isEmpty()) {
				for (TaifTStrutturaFindByAziendaDto strutture : allStruttureByAzienda) {
					taifTStrutturaDao.delete(new TaifTStrutturaPk(strutture.getId()));
				}
			}
			// DPI
			List<TaifTDpiByAziendaDto> allDpiPerAzienda = taifTDpiDao.findByAzienda(idAzienda);
			if (allDpiPerAzienda != null && !allDpiPerAzienda.isEmpty()) {
				for (TaifTDpiByAziendaDto dpiAzienda : allDpiPerAzienda) {
					taifTDpiDao.delete(new TaifTDpiPk(dpiAzienda.getIdDpi()));
				}
			}
			// MEZZI
			List<TaifTMezzoByIdAziendaDto> allMezzoPerAzienda = taifTMezzoDao.findByIdAzienda(idAzienda);
			if (allMezzoPerAzienda != null && !allMezzoPerAzienda.isEmpty()) {
				for (TaifTMezzoByIdAziendaDto mezzoAzienda : allMezzoPerAzienda) {
					taifTMezzoDao.delete(new TaifTMezzoPk(mezzoAzienda.getId()));
				}
			}
			//
			List<TaifRAziendaFrTipoContrFindByIdAziendaDto> allContrattiPerAziendaFr = taifRAziendaFrTipoContrDao
					.findFindByIdAzienda(idAzienda);
			if (allContrattiPerAziendaFr != null && !allContrattiPerAziendaFr.isEmpty()) {
				for (TaifRAziendaFrTipoContrFindByIdAziendaDto contrattiAziendaFrancese : allContrattiPerAziendaFr) {
					taifRAziendaFrTipoContrDao.delete(new TaifRAziendaFrTipoContrPk(
							contrattiAziendaFrancese.getIdAzienda(), contrattiAziendaFrancese.getIdTipoContr()));
				}
			}

			List<TaifRAziendaFrTipoMansFindByIdAziendaDto> allMansioniPerAziendaFr = taifRAziendaFrTipoMansDao
					.findFindByIdAzienda(idAzienda);
			if (allMansioniPerAziendaFr != null & !allMansioniPerAziendaFr.isEmpty()) {
				for (TaifRAziendaFrTipoMansFindByIdAziendaDto mansioniAzienda : allMansioniPerAziendaFr) {
					taifRAziendaFrTipoMansDao.delete(new TaifRAziendaFrTipoMansPk(mansioniAzienda.getIdAzienda(),
							mansioniAzienda.getIdTipoMansione()));
				}
			}

			// PRATICA
			// allegato, storico
			List<TaifTPraticaByIdAziendaDto> allPraticheByIdAzienda = taifTPraticaDao.findByIdAzienda(idAzienda);
			if (allPraticheByIdAzienda != null && !allPraticheByIdAzienda.isEmpty()) {
				for (TaifTPraticaByIdAziendaDto praticaAzienda : allPraticheByIdAzienda) {
					// taifAllegati
					allFileAllegatoB = taifTAllegatoDao.findByIdPraticaAll(praticaAzienda.getIdPratica());
					if (allFileAllegatoB != null & !allFileAllegatoB.isEmpty()) {
						for (TaifTAllegatoByIdPraticaAllDto allegato : allFileAllegatoB) {
							taifTAllegatoDao.delete(new TaifTAllegatoPk(allegato.getIdAllegato()));
							serviceMgr.indexDeleteFile(allegato.getIdAllegato().toString());

						}
					}
					// if(tracciato.equals(Constants.iLang)) {
					allStoricoPraticaIt = taifTStoricoStatoDao.findByidPraticaIT(praticaAzienda.getIdPratica());
					// }else {
					allStoricoPraticaFr = taifTStoricoStatoDao.findByidPraticaFR(praticaAzienda.getIdPratica());
					// }
					if (allStoricoPraticaIt != null && !allStoricoPraticaIt.isEmpty()) {
						for (TaifTStoricoStatoByidPraticaITDto storicoIt : allStoricoPraticaIt) {
							taifTStoricoStatoDao.delete(new TaifTStoricoStatoPk(storicoIt.getIdPratica(),
									storicoIt.getDataInserimentoStato()));
						}
					}
					if (allStoricoPraticaFr != null && !allStoricoPraticaFr.isEmpty()) {
						for (TaifTStoricoStatoByidPraticaFRDto toricoFr : allStoricoPraticaFr) {
							taifTStoricoStatoDao.delete(new TaifTStoricoStatoPk(toricoFr.getIdPratica(),
									toricoFr.getDataInserimentoStato()));
						}
					}
					taifTPraticaDao.delete(new TaifTPraticaPk(praticaAzienda.getIdPratica()));
				}
			}
			// scheda_ok
			TaifApplSchedaOkDto schedaApplScheda = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (schedaApplScheda != null) {
				taifApplSchedaOkDao.delete(new TaifApplSchedaOkPk(idAzienda));
			}
			// AZINDA
			if (taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda)) != null) {
				taifTAziendaDao.delete(new TaifTAziendaPk(idAzienda));
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::eliminaDomandaByIdzienda] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::eliminaDomandaByIdzienda] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::eliminaDomandaByIdzienda] END");
		}

	}

	private void insertAttivita1(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			AttivitaUltimoAnno1 attivita1, String idTaglioUtilizzazioneRegione, String idTaglioPiopettiRegione,
			String idTaglioTagliIntervalariRegione, String idTaglioUtilizzazioneFuori, String idTaglioPiopettiFuori,
			String idTaglioTagliIntercalariFuori) {
		TaifTAttivitaSvoltaDto attivitaSvolta1 = new TaifTAttivitaSvoltaDto();

		attivitaSvolta1.setFkAzienda(idAzienda);
		attivitaSvolta1.setFkTipoAttivita(new Integer(Constants.oneInt));
		if (attivita1.getAltro() != null && attivita1.getAltro() != "") {
			attivitaSvolta1.setDescrAltreAttivita(attivita1.getAltro());
		}
		if (attivita1.getPercentuale() != null) {
			attivitaSvolta1.setPercFatturato(new BigDecimal(attivita1.getPercentuale()));
		}
		attivitaSvolta1.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta1.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvolta1.setFkConfigUtente(idConfigUtente);
		TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta1);

		if (gestioneAttivitaUltimoAnno.getAttivita1().getInterventoFuoriRegione() != null) {
			Intervento interventoFuoriRegione = new Intervento();

			interventoFuoriRegione = gestioneAttivitaUltimoAnno.getAttivita1().getInterventoFuoriRegione();
			TaifTAttivitaSvoltaDettDto attivitaSvoltaDett14 = new TaifTAttivitaSvoltaDettDto();
			if (interventoFuoriRegione.getTotaleVolumiTagliDiUtilizzazione() != null
					&& interventoFuoriRegione.getTotaleVolumiTagliDiUtilizzazione() != "") {
				attivitaSvoltaDett14
						.setValore1(new BigDecimal(interventoFuoriRegione.getTotaleVolumiTagliDiUtilizzazione()));
				attivitaSvoltaDett14.setProgressivo(4);
				// att svolta
				attivitaSvoltaDett14.setFkUnitaDiMisura(Integer.parseInt(idTaglioUtilizzazioneFuori));
				if ((interventoFuoriRegione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()) != null
						&& (interventoFuoriRegione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()) != "") {
					attivitaSvoltaDett14.setPercContoTerzi(new BigDecimal(
							interventoFuoriRegione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()));
				}
				attivitaSvoltaDett14.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett14.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett14.setFkConfigUtente(idConfigUtente);
				attivitaSvoltaDett14.setIdAttivita(idAttSvolta.getIdAttivita());
				taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett14);

			}
			TaifTAttivitaSvoltaDettDto attivitaSvoltaDett15 = new TaifTAttivitaSvoltaDettDto();
			if (interventoFuoriRegione.getTotaleVolumiTaglioPioppeti() != null
					&& interventoFuoriRegione.getTotaleVolumiTaglioPioppeti() != "") {

				attivitaSvoltaDett15.setProgressivo(5);
				attivitaSvoltaDett15.setValore1(new BigDecimal(interventoFuoriRegione.getTotaleVolumiTaglioPioppeti()));

				if (interventoFuoriRegione.getPercentualeVolumiTaglioPioppetiContoTerzi() != null
						&& interventoFuoriRegione.getPercentualeVolumiTaglioPioppetiContoTerzi() != "") {
					attivitaSvoltaDett15.setPercContoTerzi(
							new BigDecimal(interventoFuoriRegione.getPercentualeVolumiTaglioPioppetiContoTerzi()));
				}
				attivitaSvoltaDett15.setFkUnitaDiMisura(Integer.parseInt(idTaglioPiopettiFuori));

				attivitaSvoltaDett15.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett15.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett15.setFkConfigUtente(idConfigUtente);
				attivitaSvoltaDett15.setIdAttivita(idAttSvolta.getIdAttivita());
				taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett15);

			}
			TaifTAttivitaSvoltaDettDto attivitaSvoltaDett16 = new TaifTAttivitaSvoltaDettDto();
			if (interventoFuoriRegione.getTotaleVolumiTagliIntercalari() != null
					&& interventoFuoriRegione.getTotaleVolumiTagliIntercalari() != "") {

				attivitaSvoltaDett16.setProgressivo(6);
				attivitaSvoltaDett16
						.setValore1(new BigDecimal(interventoFuoriRegione.getTotaleVolumiTagliIntercalari()));

				if (interventoFuoriRegione.getPercentualeVolumiTagliIntercalariContoTerzi() != null
						&& interventoFuoriRegione.getPercentualeVolumiTagliIntercalariContoTerzi() != "") {
					attivitaSvoltaDett16.setPercContoTerzi(
							new BigDecimal(interventoFuoriRegione.getPercentualeVolumiTagliIntercalariContoTerzi()));
				}
				attivitaSvoltaDett16.setFkUnitaDiMisura(Integer.parseInt(idTaglioTagliIntercalariFuori));

				attivitaSvoltaDett16.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett16.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett16.setFkConfigUtente(idConfigUtente);
				attivitaSvoltaDett16.setIdAttivita(idAttSvolta.getIdAttivita());
				taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett16);
			}
		}
		if ((gestioneAttivitaUltimoAnno.getAttivita1().getInterventoInRegione()) != null) {
			Intervento interventoRegione = new Intervento();
			interventoRegione = gestioneAttivitaUltimoAnno.getAttivita1().getInterventoInRegione();

			TaifTAttivitaSvoltaDettDto attivitaSvoltaDett11 = new TaifTAttivitaSvoltaDettDto();
			if (interventoRegione.getTotaleVolumiTagliDiUtilizzazione() != null
					&& interventoRegione.getTotaleVolumiTagliDiUtilizzazione() != "") {
				attivitaSvoltaDett11
						.setValore1(new BigDecimal(interventoRegione.getTotaleVolumiTagliDiUtilizzazione()));
				attivitaSvoltaDett11.setProgressivo(Constants.oneInt);
				attivitaSvoltaDett11.setFkUnitaDiMisura(Integer.parseInt(idTaglioUtilizzazioneRegione)); // quintali
				if ((interventoRegione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()) != null
						&& (interventoRegione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()) != "") {
					attivitaSvoltaDett11.setPercContoTerzi(
							new BigDecimal(interventoRegione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()));
				}
				attivitaSvoltaDett11.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett11.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett11.setFkConfigUtente(idConfigUtente);
				attivitaSvoltaDett11.setIdAttivita(idAttSvolta.getIdAttivita());
				taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett11);
			}
			TaifTAttivitaSvoltaDettDto attivitaSvoltaDett12 = new TaifTAttivitaSvoltaDettDto();
			if (interventoRegione.getTotaleVolumiTaglioPioppeti() != null
					&& interventoRegione.getTotaleVolumiTaglioPioppeti() != "") {
				attivitaSvoltaDett12.setValore1(new BigDecimal(interventoRegione.getTotaleVolumiTaglioPioppeti()));
				attivitaSvoltaDett12.setProgressivo(Constants.twoInt);
				attivitaSvoltaDett12.setFkUnitaDiMisura(Integer.parseInt(idTaglioPiopettiRegione));
				if ((interventoRegione.getPercentualeVolumiTaglioPioppetiContoTerzi()) != null
						&& (interventoRegione.getPercentualeVolumiTaglioPioppetiContoTerzi()) != "") {
					attivitaSvoltaDett12.setPercContoTerzi(
							new BigDecimal(interventoRegione.getPercentualeVolumiTaglioPioppetiContoTerzi()));
				}
				attivitaSvoltaDett12.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett12.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett12.setFkConfigUtente(idConfigUtente);
				attivitaSvoltaDett12.setIdAttivita(idAttSvolta.getIdAttivita());
				taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett12);
			}
			TaifTAttivitaSvoltaDettDto attivitaSvoltaDett13 = new TaifTAttivitaSvoltaDettDto();
			if (interventoRegione.getTotaleVolumiTagliIntercalari() != null
					&& interventoRegione.getTotaleVolumiTagliIntercalari() != "") {
				attivitaSvoltaDett13.setValore1(new BigDecimal(interventoRegione.getTotaleVolumiTagliIntercalari()));
				attivitaSvoltaDett13.setProgressivo(Constants.threInt);
				attivitaSvoltaDett13.setFkUnitaDiMisura(Integer.parseInt(idTaglioTagliIntervalariRegione));
				if ((interventoRegione.getPercentualeVolumiTagliIntercalariContoTerzi()) != null
						&& (interventoRegione.getPercentualeVolumiTagliIntercalariContoTerzi()) != "") {
					attivitaSvoltaDett13.setPercContoTerzi(
							new BigDecimal(interventoRegione.getPercentualeVolumiTagliIntercalariContoTerzi()));
				}
				attivitaSvoltaDett13.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett13.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett13.setFkConfigUtente(idConfigUtente);
				attivitaSvoltaDett13.setIdAttivita(idAttSvolta.getIdAttivita());
				taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett13);
			}

		}
	}

//	public void findAnagraficaAziendaleSchedaAzienda(Integer idAzienda, String tracciato) throws DbManagerException {
//		log.debug("[DbMgr::findAnagraficaAziendaleSchedaAzienda] BEGIN");
//		Integer result = null;
//		try {
//
//			List<TaifTAllegatoByIdPraticaDto> allAllegatiAzienda = new ArrayList<TaifTAllegatoByIdPraticaDto>();
//			TaifTAziendaDto aziendaTrovata = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
//
//			// pratica
//			List<TaifTPraticaByIdAziendaDto> allPraticheByAzienda = taifTPraticaDao.findByIdAzienda(idAzienda);
//			if (allPraticheByAzienda != null && !allPraticheByAzienda.isEmpty()) {
//				for (TaifTPraticaByIdAziendaDto praticaAzienda : allPraticheByAzienda) {
//					allAllegatiAzienda.addAll(taifTAllegatoDao.findByIdPratica(praticaAzienda.getIdPratica()));
//				}
//			}
//			// sede
//			List<TaifTSedeAziendaByIdAziendaDto> allSedeAzienda = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
//		} catch (DaoException e) {
//			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
//		}
//		log.debug("[DbMgr::findAnagraficaAziendaleSchedaAzienda] BEGIN");
//
//	}

	public ArrayList<Allegato> getElencoAllegati(Integer idPratica) throws DbManagerException {
		log.debug("[DbMgr::getElencoAllegati] BEGIN");
		ArrayList<Allegato> result = new ArrayList<Allegato>();
		try {
			List<TaifTAllegatoByIdPraticaDto> list = this.taifTAllegatoDao.findByIdPratica(idPratica);
			if (list != null && !list.isEmpty()) {
				for (TaifTAllegatoByIdPraticaDto dto : list) {
					if (dto.getTipoInvio() == null) {
						result.add(dozerBeanMapper.map(dto, Allegato.class));
					}
				}
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		log.debug("[DbMgr::getElencoAllegati] BEGIN");
		return result;
	}

	public List<TaifTAllegatoByIdPraticaDto> getElencoAllegatiByPratica(Integer idPratica) throws DbManagerException {
		log.debug("[DbMgr::getElencoAllegati] BEGIN");
		try {
			return this.taifTAllegatoDao.findByIdPratica(idPratica);

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}

		finally {
			log.debug("[DbMgr::getElencoAllegati] BEGIN");
		}
	}
	
	public List<TaifTAllegatoByIdPraticaAllDto> getElencoAllAllegatiByPratica(Integer idPratica) throws DbManagerException {
		log.debug("[DbMgr::getElencoAllegati] BEGIN");
		try {
			return this.taifTAllegatoDao.findByIdPraticaAll(idPratica);

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}

		finally {
			log.debug("[DbMgr::getElencoAllegati] BEGIN");
		}
	}

	public TaifTAllegatoDto getTaifTAllegatoByPk(String idAllegato) throws DbManagerException {
		log.debug("[DbMgr::getTaifTAllegatoByPk] BEGIN");
		try {
			return this.taifTAllegatoDao
					.findByPrimaryKey(new TaifTAllegatoPk(ConvertUtil.convertToInteger(idAllegato)));
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTaifTAllegatoByPk] END");
		}
	}

	public TaifCnfParamApimgrDto getParametriApiManager() throws DbManagerException {
		log.debug("[DbMgr::getParametriApiManager] BEGIN");
		try {
			List<TaifCnfParamApimgrDto> list = this.taifCnfParamApimgrDao.findParametriValidi(null);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				return new TaifCnfParamApimgrDto();
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getParametriApiManager] END");
		}
	}

	public ArrayList<DettaglioAttivitaUltimoAnnoFr> getElencoAttivitaUltimoAnnoFrancese(Integer idAzienda,
			List<Integer> listAttivitaFrancese) throws DbManagerException {
		log.debug("[DbMgr::getElencoAttivitaUltimoAnno] BEGIN");
		try {

			ArrayList<DettaglioAttivitaUltimoAnnoFr> feAttivitaList = new ArrayList<DettaglioAttivitaUltimoAnnoFr>();
			List<TaifTAttivitaSvoltaByIdAziendaDto> certList = taifTAttivitaSvoltaDao.findByIdAzienda(idAzienda);
			for (TaifTAttivitaSvoltaByIdAziendaDto tipoAttivitaDto : certList) {
				if (listAttivitaFrancese.contains(tipoAttivitaDto.getId()))
					feAttivitaList.add(dozerBeanMapper.map(tipoAttivitaDto, DettaglioAttivitaUltimoAnnoFr.class));
			}
			return feAttivitaList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAttivitaUltimoAnno] END");
		}
	}

	public List<TaifDTipoAttivitaByFilterDto> getElencoIdTipoAttivitaFrancese(VisibileOrdinFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoIdTipoAttivitaFrancese] BEGIN");
		try {
			List<TaifDTipoAttivitaByFilterDto> tipoAttivitaList = taifDTipoAttivitaDao.findByFilter(filter);

			return tipoAttivitaList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoIdTipoAttivitaFrancese] END");
		}
	}

	public ArrayList<String> getElencoDSTipoAttivitaFrancese(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoIdTipoAttivitaFrancese] BEGIN");
		try {
			ArrayList<String> elencoAttivita = new ArrayList<String>();

			List<TaifDTipoAttivitaByFilterDto> tipoAttivitaList = taifDTipoAttivitaDao.findByFilter(filter);
			for (TaifDTipoAttivitaByFilterDto attivita : tipoAttivitaList) {
				elencoAttivita.add(String.valueOf(attivita.getId()));
			}
			return elencoAttivita;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoIdTipoAttivitaFrancese] END");
		}
	}

	public void salvaAttivitaUltimoAnnoFrancese(Integer idAzienda,
			GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno, List<String> listIdAttivitaFrancese,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, Map<String, Boolean> attivitaMap,
			String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaAttivitaUltimoAnnoFrancese] BEGIN");

		idConfigUtente = profiloUtente.getIdConfigUtente();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			if (gestioneAttivitaUltimoAnno.getAttivitaFr() != null) {
				insertAttivitaUltimoAnnoFrancese(idAzienda, gestioneAttivitaUltimoAnno, listIdAttivitaFrancese);
			}
			TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (taifTaifAppl != null) {
				if (dataTracciato.contentEquals(Constants.fLang)) {
					taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.zero));
				} else {
					taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.zero));
				}
				taifApplSchedaOkDao.update(taifTaifAppl);
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaAttivitaUltimoAnnoFrancese] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaAttivitaUltimoAnnoFrancese] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaAttivitaUltimoAnnoFrancese] END");
		}

	}

	private void insertAttivitaUltimoAnnoFrancese(Integer idAzienda,
			GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno, List<String> listIdAttivitaFrancese)
			throws Exception {
		TaifTAttivitaSvoltaDettDto attivitaSvoltaDettFrancese = new TaifTAttivitaSvoltaDettDto();
		TaifTAttivitaSvoltaDto attivitaSvoltaFrancese = new TaifTAttivitaSvoltaDto();

		TaifTAziendaDto aziendaFinded = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
		if (gestioneAttivitaUltimoAnno.getAttivitaFr() != null) {
			if (gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente1Fr() != null) {
				aziendaFinded.setClient1Fra(gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente1Fr().trim());
			}
			if (gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente2Fr() != null) {
				aziendaFinded.setClient2Fra(gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente2Fr().trim());
			}
			if (gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente3Fr() != null) {
				aziendaFinded.setClient3Fra(gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente3Fr().trim());
			}
			taifTAziendaDao.update(aziendaFinded);

			List<DettaglioAttivitaUltimoAnnoFr> dettaglioAttFrancese = gestioneAttivitaUltimoAnno.getAttivitaFr()
					.getElencoAttivitaFr();
			for (DettaglioAttivitaUltimoAnnoFr dettaglio : dettaglioAttFrancese) {
				if (listIdAttivitaFrancese.contains(dettaglio.getIdAttivita())) {
					attivitaSvoltaFrancese.setFkAzienda(idAzienda);
					attivitaSvoltaFrancese.setFkTipoAttivita(dettaglio.getIdAttivita());
					if (dettaglio.getPercentuale() != null && StringUtils.isNotBlank(dettaglio.getPercentuale())) {
						attivitaSvoltaFrancese.setPercFatturato(new BigDecimal(dettaglio.getPercentuale().trim()));
					}

					attivitaSvoltaFrancese.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaFrancese.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaFrancese.setFkConfigUtente(idConfigUtente);
					attivitaSvoltaFrancese.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaFrancese.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaFrancese.setFkConfigUtente(idConfigUtente);

					TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvoltaFrancese);

					attivitaSvoltaDettFrancese.setProgressivo(Constants.oneInt);
					attivitaSvoltaDettFrancese.setValore1(new BigDecimal(dettaglio.getVolume().trim()));
					attivitaSvoltaDettFrancese.setFkUnitaDiMisura(Constants.threInt);

					attivitaSvoltaDettFrancese.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaDettFrancese.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaDettFrancese.setFkConfigUtente(idConfigUtente);
					attivitaSvoltaDettFrancese.setIdAttivita(idAttSvolta.getIdAttivita());
					taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDettFrancese);
				}
			}
		}
	}

	public void updateAttivitaUltimoAnnoFrancese(Integer idAzienda,
			GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno, List<String> listIdAttivitaFrancese,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, Map<String, Boolean> attivitaMap,
			String dataTracciato) {
		log.debug("[DbMgr::updateAttivitaUltimoAnnoFrancese] BEGIN");
		idConfigUtente = profiloUtente.getIdConfigUtente();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			if (gestioneAttivitaUltimoAnno.getAttivitaFr() != null) {
				List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivitaFranceseSvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
				AttivitaUltimoAnnoFr attivitaFranceseUpdate = gestioneAttivitaUltimoAnno.getAttivitaFr();
				for (DettaglioAttivitaUltimoAnnoFr dettaglioAttivitaFrancese : attivitaFranceseUpdate
						.getElencoAttivitaFr()) {
					if (listIdAttivitaFrancese.contains(dettaglioAttivitaFrancese.getIdAttivita())) {
						AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
								dettaglioAttivitaFrancese.getIdAttivita());
						attivitaFranceseSvoltaFinded = taifTAttivitaSvoltaDao
								.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
						TaifTAttivitaSvoltaDto attivitaPk = new TaifTAttivitaSvoltaDto();
						if (attivitaFranceseSvoltaFinded != null && !attivitaFranceseSvoltaFinded.isEmpty()) {
							for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaFind : attivitaFranceseSvoltaFinded) {
								attivitaPk = taifTAttivitaSvoltaDao
										.findByPrimaryKey(new TaifTAttivitaSvoltaPk(attivitaFind.getId()));
								attivitaPk.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								attivitaPk.setFkConfigUtente(idConfigUtente);
								if (dettaglioAttivitaFrancese.getPercentuale() != null) {
									attivitaPk.setPercFatturato(
											new BigDecimal(dettaglioAttivitaFrancese.getPercentuale().trim()));
								}
								taifTAttivitaSvoltaDao.update(attivitaPk);

								TaifTAttivitaSvoltaDettDto attSvoltaDett = taifTAttivitaSvoltaDettDao
										.findByPrimaryKey(new TaifTAttivitaSvoltaDettPk(attivitaPk.getIdAttivita(), 1));
								attSvoltaDett.setValore1(new BigDecimal(dettaglioAttivitaFrancese.getVolume().trim()));
								attSvoltaDett.setFkUnitaDiMisura(Constants.fiveInt);
								attSvoltaDett.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								attSvoltaDett.setFkConfigUtente(idConfigUtente);
								taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(attSvoltaDett);
							}
						} else {
							insertForOneAttivitaUltimoAnnoFrancese(idAzienda, dettaglioAttivitaFrancese);
						}
					} else {
						// delete
						AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
								dettaglioAttivitaFrancese.getIdAttivita());
						attivitaFranceseSvoltaFinded = taifTAttivitaSvoltaDao
								.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
						if (attivitaFranceseSvoltaFinded != null && !attivitaFranceseSvoltaFinded.isEmpty()) {
							for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta : attivitaFranceseSvoltaFinded) {
								List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
										.findByFilterAttivita(attivitaSvolta.getId());
								for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : listAttivitaDettaglio) {
									taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(
											attivitaDettaglio.getId(), attivitaDettaglio.getProgressivo()));
								}
								taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
							}
						}
					}
				}
			} else {
				List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivitaFranceseSvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
				AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
						Constants.zeroInt);
				attivitaFranceseSvoltaBack = taifTAttivitaSvoltaDao
						.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
				if (attivitaFranceseSvoltaBack != null && !attivitaFranceseSvoltaBack.isEmpty()) {
					for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta : attivitaFranceseSvoltaBack) {
						List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
								.findByFilterAttivita(attivitaSvolta.getId());
						for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : listAttivitaDettaglio) {
							taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(attivitaDettaglio.getId(),
									attivitaDettaglio.getProgressivo()));
						}
						taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
					}
				}
			}
			TaifTAziendaDto aziendaFinded = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			if (gestioneAttivitaUltimoAnno.getAttivitaFr() != null) {
				if (gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente1Fr() != null) {
					aziendaFinded.setClient1Fra(gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente1Fr().trim());
				}
				if (gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente2Fr() != null) {
					aziendaFinded.setClient2Fra(gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente2Fr().trim());
				}
				if (gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente3Fr() != null) {
					aziendaFinded.setClient3Fra(gestioneAttivitaUltimoAnno.getAttivitaFr().getCliente3Fr().trim());
				}
				aziendaFinded.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				taifTAziendaDao.update(aziendaFinded);
			}
			TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (taifTaifAppl != null) {
				if (dataTracciato.contentEquals(Constants.fLang)) {
					taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.zero));
				} else {
					taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.one));
					taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.zero));
				}
				taifApplSchedaOkDao.update(taifTaifAppl);
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updateAttivitaUltimoAnnoFrancese] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updateAttivitaUltimoAnnoFrancese] Rollback exception ");
			}
			// throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updateAttivitaUltimoAnnoFrancese] END");
		}

	}

	private void insertForOneAttivitaUltimoAnnoFrancese(Integer idAzienda,
			DettaglioAttivitaUltimoAnnoFr dettaglioDaINserire) throws Exception {

		TaifTAttivitaSvoltaDettDto attivitaSvoltaDettFrancese = new TaifTAttivitaSvoltaDettDto();
		TaifTAttivitaSvoltaDto attivitaSvoltaFrancese = new TaifTAttivitaSvoltaDto();

		attivitaSvoltaFrancese.setFkAzienda(idAzienda);
		attivitaSvoltaFrancese.setFkTipoAttivita(dettaglioDaINserire.getIdAttivita());
		if (dettaglioDaINserire.getPercentuale() != null
				&& StringUtils.isNotBlank(dettaglioDaINserire.getPercentuale())) {
			attivitaSvoltaFrancese.setPercFatturato(new BigDecimal(dettaglioDaINserire.getPercentuale().trim()));
		}

		attivitaSvoltaFrancese.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaFrancese.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaFrancese.setFkConfigUtente(idConfigUtente);
		attivitaSvoltaFrancese.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaFrancese.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaFrancese.setFkConfigUtente(idConfigUtente);
		TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvoltaFrancese);

		attivitaSvoltaDettFrancese.setProgressivo(Constants.oneInt);
		attivitaSvoltaDettFrancese.setValore1(new BigDecimal(dettaglioDaINserire.getVolume().trim()));
		attivitaSvoltaDettFrancese.setFkUnitaDiMisura(Constants.threInt);

		attivitaSvoltaDettFrancese.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaDettFrancese.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		attivitaSvoltaDettFrancese.setFkConfigUtente(idConfigUtente);
		attivitaSvoltaDettFrancese.setIdAttivita(idAttSvolta.getIdAttivita());
		taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDettFrancese);
	}

	public void updateMacchineEMezziFrancese(Integer idAzienda, GestioneMacchineMezzi gestioneMacchineMezzi,
			int idConfigUtente2, Map<String, Boolean> macchineMezziMap, String dataTracciato)
			throws DbManagerException {
		// TODO Auto-generated method stub
		log.debug("[DbMgr::salvaMacchineEMezzi] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<MacchinaMezzo> unionOfMacchineLists = new ArrayList<MacchinaMezzo>();
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			// TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao.findByPrimaryKey(new
			// TaifApplSchedaOkPk(idAzienda));

			TipoMezzoFilter tipoMezzoFilter = new TipoMezzoFilter();
			tipoMezzoFilter.setFlagItaFr(dataTracciato);
			tipoMezzoFilter.setFlagVisibile(Constants.oneInt);

			List<TaifTMezzoDto> backMezzoList = new ArrayList<TaifTMezzoDto>();

			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkSpecialiFr)
					&& gestioneMacchineMezzi.getElencoMacchineSpecialiFr() != null) {
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMacchineSpecialiFr());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkTerraFr)
					&& gestioneMacchineMezzi.getElencoMacchineMovimentoTerraFr() != null) {
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMacchineMovimentoTerraFr());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkRimorchiFr)
					&& gestioneMacchineMezzi.getElencoRimorchiFr() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoRimorchiFr(), tipoMezzoFilter,
						Constants.Camion);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoRimorchiFr());
			}

			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkGrumier)
					&& gestioneMacchineMezzi.getElencoGrumier() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoGrumier(), tipoMezzoFilter,
						Constants.Grumier);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoGrumier());
			}
			if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkSemi)
					&& gestioneMacchineMezzi.getElencoSemi() != null) {
				valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoSemi(), tipoMezzoFilter, Constants.Semi);
				unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoSemi());
			}

			List<Integer> listIdMezzo = new ArrayList<Integer>();
			List<TaifTMezzoByIdAziendaDto> mezziEsistenti = taifTMezzoDao.findByIdAzienda(idAzienda);
			for (MacchinaMezzo mezzo : unionOfMacchineLists) {
				listIdMezzo.add(mezzo.getIdMacchinaMezzo());
			}
			for (TaifTMezzoByIdAziendaDto macchinaMezzo : mezziEsistenti) {
				if (!(listIdMezzo.contains(macchinaMezzo.getId()))) {
					taifTMezzoDao.delete(new TaifTMezzoPk(macchinaMezzo.getId()));
				}
			}
			if (unionOfMacchineLists != null && unionOfMacchineLists.size() > 0) {
				for (MacchinaMezzo macchina : unionOfMacchineLists) {
					if (macchina.getIdTipoMacchinaMezzo() == 31) {
						macchina.setIdTipoTrazione(0);
					}
					backMezzoList.add(dozerBeanMapper.map(macchina, TaifTMezzoDto.class));
				}
				for (TaifTMezzoDto mezzi : backMezzoList) {

					TaifTMezzoDto mezzoDaUpdate = taifTMezzoDao.findByPrimaryKey(new TaifTMezzoPk(mezzi.getIdMezzo()));
					if (mezzoDaUpdate != null && mezzoDaUpdate.getIdMezzo() != null) {
						if (mezzi.getFkAlimentazione() != null) {
							mezzoDaUpdate.setFkAlimentazione(mezzi.getFkAlimentazione());
						}
						if (mezzi.getFkTipoCarrello() != null) {
							mezzoDaUpdate.setFkTipoCarrello(mezzi.getFkTipoCarrello());
						}
						if (mezzi.getAnno() != null) {
							mezzoDaUpdate.setAnno(mezzi.getAnno());
						}
						if (mezzi.getFkTrazione() != null) {
							mezzoDaUpdate.setFkTrazione(mezzi.getFkTrazione());
						}
						if (mezzi.getFlgComandatoDistanza() != null) {
							mezzoDaUpdate.setFlgComandatoDistanza(mezzi.getFlgComandatoDistanza());
						}

						if (mezzi.getFlgNoleggio() != null) {
							mezzoDaUpdate.setFlgNoleggio(mezzi.getFlgNoleggio());
						}

						mezzoDaUpdate.setPotenzaKw(mezzi.getPotenzaKw());
						mezzoDaUpdate.setIdMezzo(mezzi.getIdMezzo());
						mezzoDaUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						mezzoDaUpdate.setFkAzienda(idAzienda);
						mezzoDaUpdate.setFkConfigUtente(idConfigUtente);
						taifTMezzoDao.updateColumnsPerIdAzienda(mezzoDaUpdate);
					} else {
						mezzi.setDataInserimento(new Timestamp(System.currentTimeMillis()));
						mezzi.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						mezzi.setFkAzienda(idAzienda);
						mezzi.setFkConfigUtente(idConfigUtente);
						if (mezzi.getFkTrazione() == null) {
							mezzi.setFkTrazione(Constants.zeroInt);
						}
						if (mezzi.getFkAlimentazione() == null) {
							mezzoDaUpdate.setFkAlimentazione(Constants.zeroInt);
						}
						if (mezzi.getFkTipoCarrello() == null) {
							mezzoDaUpdate.setFkTipoCarrello(Constants.zeroInt);
						}
						if (mezzi.getFlgComandatoDistanza() == null) {
							mezzoDaUpdate.setFlgComandatoDistanza(new BigDecimal(Constants.zeroInt));
						}

						taifTMezzoDao.insert(mezzi);
					}

				}
				aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				aziendaToUpdate.setFkConfigUtente(idConfigUtente);

				taifTAziendaDao.update(aziendaToUpdate);

			}
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
				schedaToUpdate.setFlgSez52ItaOk(new BigDecimal(Constants.zero));
				schedaToUpdate.setFlgSez52FraOk(new BigDecimal(Constants.oneInt));
			} else {
				schedaToUpdate.setFlgSez52ItaOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez52FraOk(new BigDecimal(Constants.zero));
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaMacchineEMezzi] END");
		}

	}

	public void salvaMacchineEMezziFrancese(Integer idAzienda, GestioneMacchineMezzi gestioneMacchineMezzi,
			int idConfigUtente2, Map<String, Boolean> macchineMezziMap, String dataTracciato)
			throws DbManagerException {
		// TODO Auto-generated method stub
		log.debug("[DbMgr::salvaMacchineEMezzi] BEGIN");

		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<MacchinaMezzo> unionOfMacchineLists = new ArrayList<MacchinaMezzo>();
			TaifTAziendaDto aziendaToUpdate = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));

			TipoMezzoFilter tipoMezzoFilter = new TipoMezzoFilter();
			tipoMezzoFilter.setFlagItaFr(dataTracciato);
			tipoMezzoFilter.setFlagVisibile(Constants.oneInt);
			List<TaifTMezzoDto> backMezzoList = new ArrayList<TaifTMezzoDto>();
			if (gestioneMacchineMezzi != null) {
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkSpecialiFr)
						&& gestioneMacchineMezzi.getElencoMacchineSpecialiFr() != null) {
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMacchineSpecialiFr());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkTerraFr)
						&& gestioneMacchineMezzi.getElencoMacchineMovimentoTerraFr() != null) {
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoMacchineMovimentoTerraFr());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkRimorchiFr)
						&& gestioneMacchineMezzi.getElencoRimorchiFr() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoRimorchiFr(), tipoMezzoFilter,
							Constants.Camion);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoRimorchiFr());
				}

				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkGrumier)
						&& gestioneMacchineMezzi.getElencoGrumier() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoGrumier(), tipoMezzoFilter,
							Constants.Grumier);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoGrumier());
				}
				if (macchineMezziMap.get(it.csi.taif.taifweb.util.Constants.checkSemi)
						&& gestioneMacchineMezzi.getElencoSemi() != null) {
					valorizzaIdIdMacchinaMezzo(gestioneMacchineMezzi.getElencoSemi(), tipoMezzoFilter, Constants.Semi);
					unionOfMacchineLists.addAll(gestioneMacchineMezzi.getElencoSemi());
				}
			}
			if (unionOfMacchineLists != null && unionOfMacchineLists.size() > 0) {
				for (MacchinaMezzo macchina : unionOfMacchineLists) {
					if (macchina.getIdTipoMacchinaMezzo() == 31) {
						macchina.setIdTipoTrazione(0);
					}
					backMezzoList.add(dozerBeanMapper.map(macchina, TaifTMezzoDto.class));
				}
				for (TaifTMezzoDto mezziToInsert : backMezzoList) {
					mezziToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					mezziToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					mezziToInsert.setFkAzienda(idAzienda);
					mezziToInsert.setFkConfigUtente(idConfigUtente);

					taifTMezzoDao.insert(mezziToInsert);
				}
			}
			aziendaToUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			aziendaToUpdate.setFkConfigUtente(idConfigUtente);
			taifTAziendaDao.update(aziendaToUpdate);
			if (dataTracciato.equalsIgnoreCase(Constants.fLang)) {
				schedaToUpdate.setFlgSez52FraOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez52ItaOk(new BigDecimal(Constants.zero));
			} else {
				schedaToUpdate.setFlgSez52ItaOk(new BigDecimal(Constants.oneInt));
				schedaToUpdate.setFlgSez52FraOk(new BigDecimal(Constants.zero));
			}

			taifApplSchedaOkDao.update(schedaToUpdate);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaTitolareRappresentanteLegale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaTitolareRappresentanteLegale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaMacchineEMezzi] END");
		}
	}

	public List<TaifDTipoContrattoByVisibleOrdinDto> getElencoContrattiPerTracciato(VisibileOrdinFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoContrattiPeTracciato] BEGIN");
		try {
			List<TaifDTipoContrattoByVisibleOrdinDto> tipoContrattiList = taifDTipoContrattoDao
					.findByVisibleOrdin(filter);
			return tipoContrattiList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoContrattiPeTracciato] END");
		}
	}

	public List<TaifDTipoMansioneByVisibleOrdinDto> getElencoMansioniPerTracciato(VisibileOrdinFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoMansioniPerTracciato] BEGIN");
		try {
			List<TaifDTipoMansioneByVisibleOrdinDto> mansioniList = taifDTipoMansioneDao.findByVisibleOrdin(filter);
			return mansioniList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoMansioniPerTracciato] END");
		}
	}

	public List<TaifRAziendaFrTipoContrFindTipoByIdAziendaDto> getContrattoByAziendaFrancese(int idAzienda)
			throws DbManagerException {

		log.debug("[DbMgr::getContrattoByAziendaFrancese] BEGIN");
		try {
			List<TaifRAziendaFrTipoContrFindTipoByIdAziendaDto> contrattoList = taifRAziendaFrTipoContrDao
					.findFindTipoByIdAzienda(idAzienda);
			return contrattoList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getContrattoByAziendaFrancese] END");
		}
	}

	public List<TaifRAziendaFrTipoMansFindTipoByIdAziendaDto> getMansioneByAziendaFrancese(int idAzienda)
			throws DbManagerException {
		log.debug("[DbMgr::getMansioneByAziendaFrancese] BEGIN");
		try {
			List<TaifRAziendaFrTipoMansFindTipoByIdAziendaDto> allMansioniPerAzienda = taifRAziendaFrTipoMansDao
					.findFindTipoByIdAzienda(idAzienda);
			return allMansioniPerAzienda;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getMansioneByAziendaFrancese] END");
		}
	}

	public void updatePersonaleFrancese(Integer idAzienda, GestionePersonaleFr gestionePersonaleFrancese,
			int idConfigUtente, String dataTracciato) throws DbManagerException {
		// tabella Azienda
		// tabella RContrattoFrancese
		// tabellaTMansioneFrancese
		log.debug("[DbMgr::updatePersonaleFrancese] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			TaifTAziendaDto aziendaFindet = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			aziendaFindet.setNbreSalariesFra(gestionePersonaleFrancese.getNumeroTotaleAddetti());
			aziendaFindet.setTempsPleinFra(
					ConvertUtil.convertToBigDecimal(gestionePersonaleFrancese.getNumeroEquivalenti()));
			aziendaFindet.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			taifTAziendaDao.update(aziendaFindet);

			List<PersonaleFr> contrattoPersonale = gestionePersonaleFrancese.getElencoAltroPersonaleTipoContratto();
			for (PersonaleFr personaleFr : contrattoPersonale) {
				TaifRAziendaFrTipoContrDto contrattoPersona = taifRAziendaFrTipoContrDao
						.findByPrimaryKey(new TaifRAziendaFrTipoContrPk(idAzienda, personaleFr.getIdTipologia()));
				if (contrattoPersona != null && contrattoPersona.getIdAzienda() != null) {
					contrattoPersona.setNrAddetti(personaleFr.getNumeroAddetti());
					contrattoPersona.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					contrattoPersona.setFkConfigUtente(idConfigUtente);
					taifRAziendaFrTipoContrDao.updateColumnsUpdateForIdAziendaContratto(contrattoPersona);
				} else {
					TaifRAziendaFrTipoContrDto contrPersona = new TaifRAziendaFrTipoContrDto();
					contrPersona.setNrAddetti(personaleFr.getNumeroAddetti());
					contrPersona.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					contrPersona.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					contrPersona.setIdAzienda(idAzienda);
					contrPersona.setIdTipoContratto(personaleFr.getIdTipologia());
					contrPersona.setFkConfigUtente(idConfigUtente);
					taifRAziendaFrTipoContrDao.insert(contrPersona);
				}
			}
			List<PersonaleFr> mansionePersonale = gestionePersonaleFrancese.getElencoAltroPersonaleTipoMansione();
			for (PersonaleFr mansioneFr : mansionePersonale) {
				TaifRAziendaFrTipoMansDto mansionePersona = taifRAziendaFrTipoMansDao
						.findByPrimaryKey(new TaifRAziendaFrTipoMansPk(idAzienda, mansioneFr.getIdTipologia()));
				if (mansionePersona != null) {
					mansionePersona.setNrAddetti(mansioneFr.getNumeroAddetti());
					mansionePersona.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					mansionePersona.setFkConfigUtente(idConfigUtente);
					taifRAziendaFrTipoMansDao.updateColumnsUpdateForIdAziendaMansione(mansionePersona);
				} else {
					TaifRAziendaFrTipoMansDto mansPersona = new TaifRAziendaFrTipoMansDto();
					mansPersona.setNrAddetti(mansioneFr.getNumeroAddetti());
					mansPersona.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					mansPersona.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					mansPersona.setIdAzienda(idAzienda);
					mansPersona.setIdTipoMansione(mansioneFr.getIdTipologia());
					mansPersona.setFkConfigUtente(idConfigUtente);
					taifRAziendaFrTipoMansDao.insert(mansPersona);
				}
			}
			schedaToUpdate.setFlgSez6FraOk(new BigDecimal(Constants.oneInt));
			schedaToUpdate.setFlgSez6ItaOk(new BigDecimal(Constants.zero));
			taifApplSchedaOkDao.update(schedaToUpdate);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updatePersonaleFrancese] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updatePersonaleFrancese] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updatePersonaleFrancese] END");
		}

	}

	public void salvaPersonaleFrancese(Integer idAzienda, GestionePersonaleFr gestionePersonaleFrancese,
			int idConfigUtente2, String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaPersonaleFrancese] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			TaifApplSchedaOkDto schedaToUpdate = taifApplSchedaOkDao
					.findByPrimaryKey(new TaifApplSchedaOkPk(idAzienda));
			TaifTAziendaDto aziendaFindet = taifTAziendaDao.findByPrimaryKey(new TaifTAziendaPk(idAzienda));
			aziendaFindet.setNbreSalariesFra(gestionePersonaleFrancese.getNumeroTotaleAddetti());
			aziendaFindet.setTempsPleinFra(
					ConvertUtil.convertToBigDecimal(gestionePersonaleFrancese.getNumeroEquivalenti()));
			aziendaFindet.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			taifTAziendaDao.update(aziendaFindet);

			List<PersonaleFr> contrattoPersonale = gestionePersonaleFrancese.getElencoAltroPersonaleTipoContratto();
			for (PersonaleFr personaleFr : contrattoPersonale) {
				TaifRAziendaFrTipoContrDto contrPersona = new TaifRAziendaFrTipoContrDto();
				contrPersona.setNrAddetti(personaleFr.getNumeroAddetti());
				contrPersona.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				contrPersona.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				contrPersona.setIdAzienda(idAzienda);
				contrPersona.setIdTipoContratto(personaleFr.getIdTipologia());
				contrPersona.setFkConfigUtente(idConfigUtente);
				taifRAziendaFrTipoContrDao.insert(contrPersona);
			}
			List<PersonaleFr> mansionePersonale = gestionePersonaleFrancese.getElencoAltroPersonaleTipoMansione();
			for (PersonaleFr mansioneFr : mansionePersonale) {
				TaifRAziendaFrTipoMansDto mansPersona = new TaifRAziendaFrTipoMansDto();
				mansPersona.setNrAddetti(mansioneFr.getNumeroAddetti());
				mansPersona.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				mansPersona.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				mansPersona.setIdAzienda(idAzienda);
				mansPersona.setIdTipoMansione(mansioneFr.getIdTipologia());
				mansPersona.setFkConfigUtente(idConfigUtente);
				taifRAziendaFrTipoMansDao.insert(mansPersona);

			}
			schedaToUpdate.setFlgSez6FraOk(new BigDecimal(Constants.oneInt));
			schedaToUpdate.setFlgSez6ItaOk(new BigDecimal(Constants.zero));
			taifApplSchedaOkDao.update(schedaToUpdate);

			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaPersonaleFrancese] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaPersonaleFrancese] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaPersonaleFrancese] END");
		}

	}

	private void insertAltraPratica(Integer idAzienda, TaifTPraticaByIdAziendaAlboDto taifTPraticaByIdAziendaAlboDto)
			throws DbManagerException {
		TaifTPraticaDto taifTPratica = new TaifTPraticaDto();

		taifTPratica.setFkSoggettoGestore(Integer.parseInt(Constants.zero));
		taifTPratica.setFkAzienda(idAzienda);
		taifTPratica.setFlgSezione(Constants.bChar);
		taifTPratica.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		taifTPratica.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		taifTPratica.setFkConfigUtente(idConfigUtente);
		taifTPratica.setDenominazioneAltroAlbo(getCodiceSoggetto(Integer.valueOf(Constants.zero)));

		taifTPratica.setDenominazioneAltroAlbo(taifTPraticaByIdAziendaAlboDto.getDenominazioneAltroAlbo());
		taifTPratica.setNumeroAlbo(taifTPraticaByIdAziendaAlboDto.getNrAlbo());
		taifTPratica.setDataIscrizioneAlbo(taifTPraticaByIdAziendaAlboDto.getDataInscrizioneAlbo());
		taifTPratica.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		taifTPratica.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
		TaifTPraticaPk taifPraticaPk = taifTPraticaDao.insert(taifTPratica);
	}

	public ArrayList<Domanda> findElencoDomandaByLegaleRappAndProf(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::findElencoDomandaByLegaleRapp] BEGIN");
		try {

			ArrayList<Domanda> listDomanda = new ArrayList<Domanda>();
			List<TaifTAziendaElencoDomandaByLegaleRappAndProfDto> elencoPratiche = taifTAziendaDao
					.findElencoDomandaByLegaleRappAndProf(codiceFiscale);
			for (TaifTAziendaElencoDomandaByLegaleRappAndProfDto forme : elencoPratiche) {
				Domanda domanda = dozerBeanMapper.map(forme, Domanda.class);
				// listDomanda.add(dozerBeanMapper.map(forme, Domanda.class));
				listDomanda.add(domanda);
			}
			return listDomanda;
		} catch (Exception e) {
			log.error(" sssss : ", e);
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findElencoDomandaByLegaleRappAndProf] END");
		}

	}

	public TitolareRappresentanteLegale findByNrSiMsaPersonaFrancese(String nrSimsa) throws DbManagerException {
		log.debug("[DbMgr::findByCodiceFiscalePersona] BEGIN ");
		TitolareRappresentanteLegale titolareRappLegale = new TitolareRappresentanteLegale();
		try {

			List<TaifTPersonaByNrSiMsaPersonaFranceseDto> personaPerCodiceFiscale = taifTPersonaDao
					.findByNrSiMsaPersonaFrancese(nrSimsa);

			if (personaPerCodiceFiscale != null && personaPerCodiceFiscale.size() > 0) {
				TaifTPersonaByNrSiMsaPersonaFranceseDto dto = personaPerCodiceFiscale.get(0);
				titolareRappLegale = dozerBeanMapper.map(dto, TitolareRappresentanteLegale.class);
			}

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByCodiceFiscalePersona] END");
		}
		return titolareRappLegale;
	}

	// personaCollegataTrovata = taifTPersonaDao.findByFilter(filterPersona);

	public List<TaifTPersonaByFilterDto> findPersonaByFilter(PersonaFilter personaFilter) throws DbManagerException {
		log.debug("[DbMgr::findPersonaByFilter] BEGIN ");
		List<TaifTPersonaByFilterDto> personaPerCodiceFiscale = new ArrayList<TaifTPersonaByFilterDto>();
		try {
			personaPerCodiceFiscale = taifTPersonaDao.findByCodiceIdentificativoFilter(personaFilter);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findPersonaByFilter] END");
		}
		return personaPerCodiceFiscale;
	}

	public ArrayList<DettaglioStato> getElencoDettaglioStato(Integer idPratica, String lingua)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoDettaglioStato] BEGIN ");
		ArrayList<DettaglioStato> result = null;
		try {

			List<TaifTStoricoStatoByidPraticaITDto> list = this.taifTStoricoStatoDao.findByidPraticaIT(idPratica);

			if (list != null) {
				result = new ArrayList<DettaglioStato>();
				VisibileOrdinFilter filter = new VisibileOrdinFilter();
				filter.setFlagItaFr(lingua);
				filter.setFlagVisibile(1);
				ArrayList<CodeDescription> elencoStati = this.getElencoStatiPratica(filter);
				int count = 0;
				for (TaifTStoricoStatoByidPraticaITDto dto : list) {
					result.add(DettaglioStatoFactory.createDettaglioStato(dto, elencoStati, count + 1));
					count++;
				}
			}
			return result;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoDettaglioStato] END");
		}
	}

	public void salvaStato(Integer idPratica, DettaglioStato dto, Integer idConfigUtente) throws DbManagerException {
		log.debug("[DbMgr::salvaStato] BEGIN ");
		try {
			// TaifTStoricoStatoDto obj = new TaifTStoricoStatoDto();
			//
			// obj.setNote(dto.getNote());
			// obj.setNumeroProtocollo(dto.getNumeroProtocollo());
			// obj.setDataProtocollo(ConvertUtil.convertToSqlDate(dto.getDataProtocollo()));
			//
			// obj.setDataAggiornamento(DateUtil.getTimestampDataCorrente());
			// obj.setFkConfigUtente(idConfigUtente);
			//
			// obj.setIdPratica(idPratica);
			// obj.setDataInserimentoStato(DateUtil.buildTimestamp(dto.getDataInserimento(),
			// DateUtil.DATE_FORMAT_NO_SPACE));
			// obj.setDataInserimentoStato(dto.getDataInserimento());
			// this.taifTStoricoStatoDao.updateColumnsAggiornaStato(obj);
			GenericUtil.stampaVO(dto, true);
			this.taifTStoricoStatoDao.customUpdaterModificaStato(idPratica, idConfigUtente, dto);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaStatov] END");
		}

	}

	public ArrayList<CodeDescription> getElencoStatiPratica(VisibileOrdinFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoStatiPratica] BEGIN ");
		try {
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();

			List<TaifDStatoPraticaByFilterDto> list = this.taifDStatoPraticaDao.findByFilter(filter);
			if (list != null && !list.isEmpty()) {
				for (TaifDStatoPraticaByFilterDto dto : list) {
					CodeDescription cd = new CodeDescription();
					cd.setCode(ConvertUtil.convertToString(dto.getId()));
					if (Constants.fLang.equals(filter.getFlagItaFr())) {
						cd.setDescription(dto.getFra());
					} else {
						cd.setDescription(dto.getIta());
					}
					result.add(cd);
				}
			}

			return result;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoStatiPratica] END");
		}
	}

	public TaifCnfMailDto getParametriInvioMail() throws DbManagerException {
		log.debug("[DbMgr::getParametriInvioMail] BEGIN ");
		try {
			return this.taifCnfMailDao.findByPrimaryKey(new TaifCnfMailPk(Constants.MAIL_NORMALE));
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getParametriInvioMail] END");
		}
	}

	public Integer findPraticaPerIdAzienda(int idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getPraticaPerIdAzienda] BEGIN ");
		List<TaifTPraticaByIdAziendaDto> praticheList;
		List<TaifTPraticaByIdAziendaDto> praticaPrinc = new ArrayList<TaifTPraticaByIdAziendaDto>();
		Integer statoPratica = null;
		try {
			praticheList = taifTPraticaDao.findByIdAzienda(idAzienda);
			for (TaifTPraticaByIdAziendaDto taifTPraticaByIdAziendaDto : praticheList) {
				if (taifTPraticaByIdAziendaDto.getIdSoggettoGestore() != 0) {
					praticaPrinc.add(taifTPraticaByIdAziendaDto);
				}
			}
			if (!praticaPrinc.isEmpty()) {
				Integer pratica = praticaPrinc.get(0).getIdPratica();
				List<TaifTStoricoStatoByidPraticaITDto> storicoPratica = taifTStoricoStatoDao
						.findByidPraticaIT(pratica);
				statoPratica = storicoPratica.get(0).getIdStatoPratica();
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPraticaPerIdAzienda] END");
		}
		return statoPratica;
	}

	private void updateAttivitaCinque(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			Map<String, Boolean> attivitaMap, ArrayList<ArboricolturaDaLegno> elencoArboricoltureLegno,
			MaterialePropagazione materialePropagazione, String dataTracciato)
			throws TaifTAttivitaSvoltaDaoException, TaifTAttivitaSvoltaDettDaoException, Exception {

		if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att5))
				&& gestioneAttivitaUltimoAnno.getAttivita5() != null) {

			// trova attivitaAzienda

			List<Integer> listIdAttivitaEsistente = new ArrayList<Integer>();
			List<AttivitaProgressivoFilter> listAttivitaDettEsistenteList = new ArrayList<AttivitaProgressivoFilter>();
			AttivitaProgressivoFilter listAttivitaDettEsistente = new AttivitaProgressivoFilter();
			// List<Integer> listIdAttivitaArrivate = new ArrayList<Integer>();
			TaifTAttivitaSvoltaDettDto attivitaSvoltaDett51 = new TaifTAttivitaSvoltaDettDto();

			TaifRAttivDetMaterialeDto attivitamateriale;
			Integer idAttivitaFive = null;
			AttivitaUltimoAnno5 attivita5 = gestioneAttivitaUltimoAnno.getAttivita5();
			// attivita5 che sono salvate gia
			AziendaVisibleFilter aziendaFilter = getAziendaVisibleFilter(idAzienda, dataTracciato, Constants.five);

			List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> findAttivitaSvolta5 = taifTAttivitaSvoltaDao
					.findAttivitaSvoltaByIdAzienda(aziendaFilter);
			if (findAttivitaSvolta5 != null && findAttivitaSvolta5.size() > 0) {
				idAttivitaFive = findAttivitaSvolta5.get(0).getId();
			}
			if (idAttivitaFive != null) {
				// esiste attivita 5 nel db
				List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
						.findByFilterAttivita(idAttivitaFive);
				for (TaifTAttivitaSvoltaDettByFilterAttivitaDto taifTAttivitaSvoltaDettByFilterAttivitaDto : listAttivitaDettaglio) {
					listIdAttivitaEsistente.add(taifTAttivitaSvoltaDettByFilterAttivitaDto.getId());
					listAttivitaDettEsistente.setIdAttivita(taifTAttivitaSvoltaDettByFilterAttivitaDto.getId());
					listAttivitaDettEsistente
							.setProgressivo(taifTAttivitaSvoltaDettByFilterAttivitaDto.getProgressivo());
					listAttivitaDettEsistenteList.add(listAttivitaDettEsistente);
				}
			} else {
				TaifTAttivitaSvoltaDto attivitaSvolta51 = new TaifTAttivitaSvoltaDto();
				attivitaSvolta51.setFkAzienda(idAzienda);
				attivitaSvolta51.setFkTipoAttivita(new Integer(Constants.fiveInt));
				if (attivita5.getAltro() != null && attivita5.getAltro() != "") {
					// attivitaSvolta51.setDescrAltreAttivita(attivita5.getAltro());
					attivitaSvolta51.setDescrAltreAttivita(materialePropagazione.getAltro());
				}
				if (attivita5.getPercentuale() != null) {
					attivitaSvolta51.setPercFatturato(new BigDecimal(attivita5.getPercentuale()));
				}
				attivitaSvolta51.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvolta51.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvolta51.setFkConfigUtente(idConfigUtente);
				TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta51);
				idAttivitaFive = idAttSvolta.getIdAttivita();
			}

			int v = 1;
			int k = 0;
			// for (ArboricolturaDaLegno arboricolturaLegno :
			// attivita5.getElencoArbolicoltureDaLegno()) {
			for (ArboricolturaDaLegno arboricolturaDaLegno : elencoArboricoltureLegno) {
				k++;
				if (arboricolturaDaLegno.getIdArboricolturaDaLegno() == 0) {
					// for (ArboricolturaDaLegno arboricolturaDaLegno : elencoArboricoltureLegno) {
					attivitamateriale = new TaifRAttivDetMaterialeDto();
					if (arboricolturaDaLegno.getIdTipoMateriale()==8) {
						attivitamateriale.setDescrAltroMateriale(arboricolturaDaLegno.getAltro());
					}
					attivitamateriale.setIdMateriale(arboricolturaDaLegno.getIdTipoMateriale());
					attivitamateriale.setFkConfigUtente(idConfigUtente);
					attivitamateriale.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitamateriale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitamateriale.setProgressivo(k);

					attivitaSvoltaDett51.setProgressivo(k);
					attivitaSvoltaDett51.setValore1(new BigDecimal(arboricolturaDaLegno.getRealizzazione()));
					attivitaSvoltaDett51.setValore2(new BigDecimal(arboricolturaDaLegno.getManutenzione()));
					attivitaSvoltaDett51.setValore3(new BigDecimal(arboricolturaDaLegno.getConduzione()));
					attivitaSvoltaDett51.setFkUnitaDiMisura(Constants.fiveInt);
					attivitaSvoltaDett51.setPercContoTerzi(
							(new BigDecimal(gestioneAttivitaUltimoAnno.getAttivita5().getPercentuale())));
					attivitaSvoltaDett51.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaDett51.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					attivitaSvoltaDett51.setFkConfigUtente(idConfigUtente);
					attivitaSvoltaDett51.setIdAttivita(idAttivitaFive);

					TaifTAttivitaSvoltaDettPk idAttSvoltaDett = taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett51);

					attivitamateriale.setIdAttivita(idAttSvoltaDett.getIdAttivita());
					taifRAttivDetMaterialeDao.insert(attivitamateriale);

				} else {

					if (listIdAttivitaEsistente.contains(arboricolturaDaLegno.getIdArboricolturaDaLegno())) {
						// update
						TaifTAttivitaSvoltaDto attivitaSvoltaUpdate = taifTAttivitaSvoltaDao
								.findByPrimaryKey(new TaifTAttivitaSvoltaPk(attivita5.getIdAttivita()));
						attivitaSvoltaUpdate.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						//
						/*
						 * List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio =
						 * taifTAttivitaSvoltaDettDao
						 * .findByFilterAttivita(attivitaSvoltaUpdate.getIdAttivita()); int numeroAtt =
						 * listAttivitaDettaglio.size(); for (TaifTAttivitaSvoltaDettByFilterAttivitaDto
						 * taifTAttivitaSvoltaDettByFilterAttivitaDto : listAttivitaDettaglio) {
						 * TaifTAttivitaSvoltaDettDto attDettaglioDettaglio =
						 * taifTAttivitaSvoltaDettDao.findByPrimaryKey( new
						 * TaifTAttivitaSvoltaDettPk(attivitaSvoltaUpdate.getIdAttivita(), numeroAtt));
						 * }
						 */
						//
						TaifTAttivitaSvoltaDettDto attDettaglioDettaglio = taifTAttivitaSvoltaDettDao.findByPrimaryKey(
								new TaifTAttivitaSvoltaDettPk(attivitaSvoltaUpdate.getIdAttivita(), v));
						attDettaglioDettaglio
								.setValore1(new BigDecimal(arboricolturaDaLegno.getRealizzazione().toString()));
						attDettaglioDettaglio
								.setValore2(new BigDecimal(arboricolturaDaLegno.getManutenzione().toString()));
						attDettaglioDettaglio
								.setValore3(new BigDecimal(arboricolturaDaLegno.getConduzione().toString()));

						attDettaglioDettaglio.setPercContoTerzi(
								(new BigDecimal(gestioneAttivitaUltimoAnno.getAttivita5().getPercentuale())));
						attDettaglioDettaglio.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						attDettaglioDettaglio.setFkConfigUtente(idConfigUtente);
						taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(attDettaglioDettaglio);
						AttivitaProgressivoFilter attivitaProgressivoFilter = new AttivitaProgressivoFilter();
						attivitaProgressivoFilter.setIdAttivita(attivitaSvoltaUpdate.getIdAttivita());
						attivitaProgressivoFilter.setProgressivo(v);
						List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> attivitaRMateriale = taifRAttivDetMaterialeDao
								.findByIdAttivitaProgressivo(attivitaProgressivoFilter);

						TaifRAttivDetMaterialeDto materialeDet = taifRAttivDetMaterialeDao.findByPrimaryKey(
								new TaifRAttivDetMaterialePk(attivitaRMateriale.get(0).getIdMateriale(),
										attivitaSvoltaUpdate.getIdAttivita(), v));
						materialeDet.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
						materialeDet.setDescrAltroMateriale(arboricolturaDaLegno.getAltro());
						taifRAttivDetMaterialeDao.update(materialeDet);
						v++;
					} else {
						// delete
						// not check - delete all
						List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
								.findByFilterAttivita(arboricolturaDaLegno.getIdArboricolturaDaLegno());
						for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : listAttivitaDettaglio) {
							// delete rmateriale
							taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(attivitaDettaglio.getId(),
									attivitaDettaglio.getProgressivo()));
						}
					}
				}
			}
		} else {
			// not check - delete all
			List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita5SvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
			AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
					Constants.fiveInt);
			AttivitaProgressivoFilter attivitaProgressivoFilter = new AttivitaProgressivoFilter();
			attivita5SvoltaBack = taifTAttivitaSvoltaDao.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
			if (attivita5SvoltaBack != null && !attivita5SvoltaBack.isEmpty()) {
				for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta : attivita5SvoltaBack) {
					List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
							.findByFilterAttivita(attivitaSvolta.getId());
					for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : listAttivitaDettaglio) {
						attivitaProgressivoFilter.setIdAttivita(attivitaDettaglio.getId());
						attivitaProgressivoFilter.setProgressivo(attivitaDettaglio.getProgressivo());
						List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> materialeAttivitaList = taifRAttivDetMaterialeDao
								.findByIdAttivitaProgressivo(attivitaProgressivoFilter);
						for (TaifRAttivDetMaterialeByIdAttivitaProgressivoDto matAtt : materialeAttivitaList) {
							taifRAttivDetMaterialeDao.delete(new TaifRAttivDetMaterialePk(matAtt.getIdMateriale(),
									attivitaDettaglio.getId(), attivitaDettaglio.getProgressivo()));
						}
						taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(attivitaDettaglio.getId(),
								attivitaDettaglio.getProgressivo()));
					}
					taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
				}
			}
		}
	}

	public ArrayList<CodeDescription> getUnitaMisuraQuintaliMc(Integer flagVisibile) throws DbManagerException {
		log.debug("[DbMgr::getProvenienzaMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listUnitaMisura = new ArrayList<CodeDescription>();

			List<TaifDUnitaDiMisuraByVisibleFilterDto> unitaMisuraList = taifDUnitaDiMisuraDao
					.findByVisibleFilter(flagVisibile);
			for (TaifDUnitaDiMisuraByVisibleFilterDto unitaMisuraDto : unitaMisuraList) {
				if (unitaMisuraDto.getUm().equals(Constants.quintali) || unitaMisuraDto.getUm().equals(Constants.metric)
						|| unitaMisuraDto.getUm().equals(Constants.tonne)) {
					listUnitaMisura.add(dozerBeanMapper.map(unitaMisuraDto, CodeDescription.class));
				}
			}
			return listUnitaMisura;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvenienzaMateriale] END");
		}
	}

	public String findCorsiPerPersona(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::findCorsiPerPersona] BEGIN ");
		String descrizioneCorsiPersona = null;
		try {
			List<TaifViewElencoCorsoPersonaCorsiPerPersonaDto> personaPerCodiceFiscale = taifViewElencoCorsoPersonaDao
					.findCorsiPerPersona(idPersona);
			if (personaPerCodiceFiscale != null && personaPerCodiceFiscale.size() > 0) {
				descrizioneCorsiPersona = personaPerCodiceFiscale.get(0).getCorsiPerPersona();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCorsiPerPersona] END");
		}
		return descrizioneCorsiPersona;
	}
	
	public String findCorsiPerCodiceFiscalePersona(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::findCorsiPerPersona] BEGIN ");
		String descrizioneCorsiPersona = null;
		try {
			List<TaifViewElencoCorsoPersonaDto> personaPerCodiceFiscale = taifViewElencoCorsoPersonaDao
					.findByCodiceFiscalePersona(codiceFiscale);
			if (personaPerCodiceFiscale != null && personaPerCodiceFiscale.size() > 0) {
				descrizioneCorsiPersona = personaPerCodiceFiscale.get(0).getArrayToString();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCorsiPerPersona] END");
		}
		return descrizioneCorsiPersona;
	}

	public TaifCnfConfigUtenteDto findConfigUtenteByPrimaryKey(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::findConfigUtenteByPrimaryKey] BEGIN ");
		TaifCnfConfigUtenteDto configUtenteDto = new TaifCnfConfigUtenteDto();

		log.debug("[DbMgr::updateColumnsForPersonaleAzienda] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();

			configUtenteDto = taifCnfConfigUtenteDao.findByPrimaryKey(new TaifCnfConfigUtentePk(idPersona));
			int numeroAccessi = configUtenteDto.getNrAccessi();
			configUtenteDto.setNrAccessi(++numeroAccessi);
			configUtenteDto.setDataUltimoAccesso(new Timestamp(System.currentTimeMillis()));
			taifCnfConfigUtenteDao.updateColumnsConfigUtente(configUtenteDto);

			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updatePersonaleFrancese] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updatePersonaleFrancese] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updatePersonaleFrancese] END");
		}

		return configUtenteDto;
	}

	public List<String> getListFlagSezionePerIdAzienda(int idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getPraticaPerIdAzienda] BEGIN ");
		List<String> flagSezioniList = new ArrayList<String>();

		try {
			List<TaifTPraticaByIdAziendaDto> praticheList = taifTPraticaDao.findByIdAzienda(idAzienda);
			for (TaifTPraticaByIdAziendaDto taifTPraticaByIdAziendaDto : praticheList) {
				flagSezioniList.add(taifTPraticaByIdAziendaDto.getFlagSezione());
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPraticaPerIdAzienda] END");
		}
		return flagSezioniList;
	}

	public String findTipoAttivitaById(Integer idTipoAttivita) throws DbManagerException {
		log.debug("[DbMgr::findTipoAttivitaById] BEGIN ");
		String descrizioneAttivita = Constants.blank;
		try {

			TaifDTipoAttivitaDto tipoAttivitaDto = taifDTipoAttivitaDao
					.findByPrimaryKey(new TaifDTipoAttivitaPk(idTipoAttivita));

			if (tipoAttivitaDto != null && tipoAttivitaDto.getTipoAttivita() != null) {
				descrizioneAttivita = tipoAttivitaDto.getTipoAttivita();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findTipoAttivitaById] END");
		}
		return descrizioneAttivita;
	}

	public String findFormaGiuridicaById(Integer idFormaGiuridica) throws DbManagerException {
		log.debug("[DbMgr::findFormaGiuridicaById] BEGIN ");
		String formaGiuridica = Constants.blank;
		try {
			TaifDFormaGiuridicaDto formaGiuridicaDto = taifDFormaGiuridicaDao
					.findByPrimaryKey(new TaifDFormaGiuridicaPk(idFormaGiuridica));
			if (formaGiuridicaDto != null && formaGiuridicaDto.getFormaGiuridica() != null) {
				formaGiuridica = formaGiuridicaDto.getFormaGiuridica();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findFormaGiuridicaById] END");
		}
		return formaGiuridica;
	}

	public TaifTPersonaDto getPersonaRappLegalePerAzienda(int idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getPersonaRappLegalePerAzienda] BEGIN");
		try {
			TaifTPersonaDto personaDto = new TaifTPersonaDto();
			List<TaifRPersonaAziendaRappresentanteLegaleAziendaDto> personaAzienda = taifRPersonaAziendaDao
					.findRappresentanteLegaleAzienda(idAzienda);
			if (personaAzienda != null) {
				personaDto = taifTPersonaDao.findByPrimaryKey(new TaifTPersonaPk(personaAzienda.get(0).getIdPersona()));
			}
			return personaDto;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaRappLegalePerAzienda] END");
		}
	}

	public Integer getPersonaFromCnfUtente(int idConfigUtente) throws DbManagerException {
		log.debug("[DbMgr::getPersonaFromCnfUtente] BEGIN");
		try {
			Integer idPersona = null;
			TaifCnfConfigUtenteDto configUtenteDto = taifCnfConfigUtenteDao
					.findByPrimaryKey(new TaifCnfConfigUtentePk(idConfigUtente));
			if (configUtenteDto != null) {
				idPersona = configUtenteDto.getFkPersona();
			}
			return idPersona;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaFromCnfUtente] END");
		}
	}

	public String getTitoloStudio(int idTitolo) throws DbManagerException {
		log.debug("[DbMgr::getTitoloStudio] BEGIN");
		try {
			String titoloStudio = Constants.blank;
			titoloStudio = taifDTitoloStudioDao.findByPrimaryKey(new TaifDTitoloStudioPk(idTitolo)).getTitoloStudio();

			return titoloStudio;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTitoloStudio] END");
		}
	}

	public Comune getComuneFromIstat(String istatComune) throws DbManagerException, ServiceException {
		log.debug("[DbMgr::getComuneFromIstat] BEGIN");
		try {
			return serviceMgr.limitiAmministrativiGetComuneByIstat(istatComune);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));

		} finally {
			log.debug("[DbMgr::getComuneFromIstat] END");
		}
	}

	public Provincia getProvinciaFromIstat(String istatComune) throws DbManagerException, ServiceException {
		log.debug("[DbMgr::getComuneFromIstat] BEGIN");
		try {
			return serviceMgr.limitiAmministrativiGetProvinciaByIstatComune(istatComune);

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getComuneFromIstat] END");
		}
	}

	public String getFormaGiuridica(int idFormaGiuridica) throws DbManagerException {
		log.debug("[DbMgr::getComuneFromIstat] BEGIN");
		try {
			return taifDFormaGiuridicaDao.findByPrimaryKey(new TaifDFormaGiuridicaPk(idFormaGiuridica))
					.getFormaGiuridica();

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTitoloStudio] END");
		}
	}

	public String getAttivitaAteco(int idTipoAttivita) throws DbManagerException {
		log.debug("[DbMgr::getComuneFromIstat] BEGIN");
		String attivitaDesc = null;
		TaifDAttivitaAtecoApeDto attivitaDto;

		try {
			attivitaDto = taifDAttivitaAtecoApeDao.findByPrimaryKey(new TaifDAttivitaAtecoApePk(idTipoAttivita));
			if (attivitaDto != null) {
				attivitaDesc = attivitaDto.getCodice() + " " + attivitaDto.getAttivita();
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTitoloStudio] END");
		}
		return attivitaDesc;
	}

	public List<TaifRAziendaCategImpresaByIdAziendaDto> getCategoriaImpresaFromId(int idAzienda)
			throws DbManagerException {
		List<TaifRAziendaCategImpresaByIdAziendaDto> aziendaCategorie = new ArrayList<TaifRAziendaCategImpresaByIdAziendaDto>();
		try {
			aziendaCategorie = taifRAziendaCategImpresaDao.findByIdAzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaCategorie;
	}

	public String getDescrizioneCategoriaImpresa(int idCategoria) throws DbManagerException {
		TaifDCategoriaImpresaDto aziendaCategorie = new TaifDCategoriaImpresaDto();
		String tipoCategoria = Constants.blank;
		try {
			aziendaCategorie = taifDCategoriaImpresaDao.findByPrimaryKey(new TaifDCategoriaImpresaPk(idCategoria));
			if (aziendaCategorie != null) {
				tipoCategoria = aziendaCategorie.getCategoriaImpresa();
			}
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return tipoCategoria;
	}

	public String getDescrizioneAssociazioneImpresa(int idAssociazione) throws DbManagerException {
		TaifDAssociazioneDto aziendaAssociazione = new TaifDAssociazioneDto();
		String tipoCategoria = Constants.blank;
		try {
			aziendaAssociazione = taifDAssociazioneDao.findByPrimaryKey(new TaifDAssociazionePk(idAssociazione));
			if (aziendaAssociazione != null) {
				tipoCategoria = aziendaAssociazione.getAssociazione();
			}
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return tipoCategoria;
	}

	public List<TaifTAttivitaSvoltaByIdAziendaDto> getAttivitaSvolte(int idAzienda) throws DbManagerException {
		List<TaifTAttivitaSvoltaByIdAziendaDto> attivitaSvolteList = new ArrayList<TaifTAttivitaSvoltaByIdAziendaDto>();
		try {
			attivitaSvolteList = taifTAttivitaSvoltaDao.findByIdAzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return attivitaSvolteList;
	}

	public List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> getAttivitaSvolteDettaglio(int idAttivitaSvolta)
			throws DbManagerException {
		List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> attivitaSvolteDettaglioList = new ArrayList<TaifTAttivitaSvoltaDettByFilterAttivitaDto>();
		try {
			attivitaSvolteDettaglioList = taifTAttivitaSvoltaDettDao.findByFilterAttivita(idAttivitaSvolta);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return attivitaSvolteDettaglioList;
	}

	public List<TaifRAttivDetMaterialeByIdAttivitaDto> getMaterialeVivaistica(int idAttivitaSvolta)
			throws DbManagerException {
		List<TaifRAttivDetMaterialeByIdAttivitaDto> attivitaSvolteDettaglioList = new ArrayList<TaifRAttivDetMaterialeByIdAttivitaDto>();
		try {
			attivitaSvolteDettaglioList = taifRAttivDetMaterialeDao.findByIdAttivita(idAttivitaSvolta);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return attivitaSvolteDettaglioList;
	}

	public String getUnitaMisuraByIdUnita(int idUnitaMisura) throws DbManagerException {
		try {
			return taifDUnitaDiMisuraDao.findByPrimaryKey(new TaifDUnitaDiMisuraPk(idUnitaMisura)).getUnitaDiMisura();
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public String getMaterialePerId(int idUnitaMisura) throws DbManagerException {
		try {
			return taifDMaterialeDao.findByPrimaryKey(new TaifDMaterialePk(idUnitaMisura)).getMateriale();
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public List<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto> getAttivitaDettaglioMateriale(int idAttivitaSvolta)
			throws DbManagerException {
		List<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto> attivitaDettaglioMaterialeList = new ArrayList<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto>();
		try {
			attivitaDettaglioMaterialeList = taifTAttivitaSvoltaDettDao.findByAttivitaProgressivo(idAttivitaSvolta);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return attivitaDettaglioMaterialeList;
	}

	public List<TaifTStrutturaFindByAziendaDto> getStrutture(int idAzienda) throws DbManagerException {
		List<TaifTStrutturaFindByAziendaDto> aziendaAssociazioni = new ArrayList<TaifTStrutturaFindByAziendaDto>();
		try {
			aziendaAssociazioni = taifTStrutturaDao.findFindByAzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaAssociazioni;
	}

	public String getFunzioneCapannone(int idFunzione) throws DbManagerException {
		try {
			return taifDFunzioneDao.findByPrimaryKey(new TaifDFunzionePk(idFunzione)).getFunzione();
		} catch (DaoException e) {
			throw new DbManagerException();
		}
	}

	public List<TaifTMezzoByIdAziendaDto> getMacchineMezzi(int idAzienda) throws DbManagerException {
		List<TaifTMezzoByIdAziendaDto> dispositiviList = new ArrayList<TaifTMezzoByIdAziendaDto>();
		try {
			dispositiviList = taifTMezzoDao.findByIdAzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return dispositiviList;
	}

	public String getTipoMezzoById(int idTipoMezzo) throws DbManagerException {
		try {
			return taifDTipoMezzoDao.findByPrimaryKey(new TaifDTipoMezzoPk(idTipoMezzo)).getTipoMezzo();
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public String getTipoContratto(int idTipoContratto) throws DbManagerException {
		try {
			return taifDTipoContrattoDao.findByPrimaryKey(new TaifDTipoContrattoPk(idTipoContratto)).getTipoContratto();
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getTipoInquadramento(int idTipoInquadramento) throws DbManagerException {
		try {
			return taifDTipoInquadramentoDao.findByPrimaryKey(new TaifDTipoInquadramentoPk(idTipoInquadramento))
					.getTipoInquadramento();
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getTipoMansione(int idTipoMansione) throws DbManagerException {
		try {
			return taifDTipoMansioneDao.findByPrimaryKey(new TaifDTipoMansionePk(idTipoMansione)).getTipoMansione();
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getRuolo(int idTipoRuolo) throws DbManagerException {
		try {
			return taifDRuoloDao.findByPrimaryKey(new TaifDRuoloPk(idTipoRuolo)).getRuolo();
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public List<TaifTPersonaByIdAziendaDto> getPersonePerAzienda(int idAzienda) throws DbManagerException {
		List<TaifTPersonaByIdAziendaDto> personePerAzienda = new ArrayList<TaifTPersonaByIdAziendaDto>();
		List<TaifTPersonaByIdAziendaDto> personeSenzaTitolare = new ArrayList<TaifTPersonaByIdAziendaDto>();
		try {
			personePerAzienda = taifTPersonaDao.findByIdAzienda(idAzienda);
			for (TaifTPersonaByIdAziendaDto taifTPersona : personePerAzienda) {
				if (taifTPersona.getIdRuoloPersona() != 1 && taifTPersona.getIdRuoloPersona() != 2) {
					personeSenzaTitolare.add(taifTPersona);
				}

			}
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return personeSenzaTitolare;
	}

	public List<TaifTPraticaByIdAziendaDto> pratichePerAzienda(int idAzienda) throws DbManagerException {

		try {

			return taifTPraticaDao.findByIdAzienda(idAzienda);
		} catch (Exception e) {

			throw new DbManagerException();
		}

	}

	public List<TaifTPersonaByIdAziendaDto> getAllPersonePerIdAzienda(int idAzienda) throws DbManagerException {

		List<TaifTPersonaByIdAziendaDto> personePerAzienda = new ArrayList<TaifTPersonaByIdAziendaDto>();
		try {
			personePerAzienda = taifTPersonaDao.findByIdAzienda(idAzienda);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return personePerAzienda;
	}

	public List<TaifTSedeAziendaByIdAziendaDto> getSedePerIdAzienda(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getSedePerIdAzienda] BEGIN");
		try {
			List<TaifTSedeAziendaByIdAziendaDto> sedeList = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
			return sedeList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getSedePerIdAzienda] END");
		}
	}

	public TaifTSedeAziendaByIdAziendaDto getSedeLegalePerIdAzienda(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getSedeLegalePerIdAzienda] BEGIN");
		try {
			TaifTSedeAziendaByIdAziendaDto sedeLegale = new TaifTSedeAziendaByIdAziendaDto();
			List<TaifTSedeAziendaByIdAziendaDto> sedeList = taifTSedeAziendaDao.findByIdAzienda(idAzienda);
			for (TaifTSedeAziendaByIdAziendaDto sede : sedeList) {
				if (sede.getIdTipo() == 1) {
					sedeLegale = sede;
				}
			}
			return sedeLegale;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getSedeLegalePerIdAzienda] END");
		}
	}

	public TaifTPraticaDettaglioPraticaPerInvioDto getDettaglioPraticaPerInvio(Integer idPratica)
			throws DbManagerException {
		log.debug("[DbMgr::getDettaglioPraticaPerInvio] BEGIN");
		try {
			List<TaifTPraticaDettaglioPraticaPerInvioDto> list = taifTPraticaDao
					.findDettaglioPraticaPerInvio(idPratica);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getDettaglioPraticaPerInvio] END");
		}
		return null;
	}

	public TaifCnfTipoMailDto getMail(Integer idStato) throws DbManagerException {
		log.debug("[DbMgr::getMail] BEGIN");
		try {
			List<TaifCnfTipoMailDto> list = taifCnfTipoMailDao.findByStatoPratica(idStato);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getMail] END");
		}
		return null;
	}

	private void updateAttivitaQuatro(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			Map<String, Boolean> attivitaMap, List<MaterialePropagazione> elencoMaterialePropagazione,
			List<String> idMaterialiPropagazione, String dataTracciato)
			throws TaifTAttivitaSvoltaDaoException, TaifDUnitaDiMisuraDaoException, TaifTAttivitaSvoltaDettDaoException,
			DbManagerException, TaifRAttivDetMaterialeDaoException {
		if ((attivitaMap.get(it.csi.taif.taifweb.util.Constants.att4))
				&& gestioneAttivitaUltimoAnno.getAttivita4() != null) {
			List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita4SvoltaFinded = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
			AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
					Constants.fourInt);
			List<String> idMaterialeFindet = new ArrayList<String>();
			List<String> idMaterialeNew = new ArrayList<String>();
			attivita4SvoltaFinded = taifTAttivitaSvoltaDao.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
			if (attivita4SvoltaFinded != null && !attivita4SvoltaFinded.isEmpty()) {
				for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta4 : attivita4SvoltaFinded) {
					TaifTAttivitaSvoltaDettDto updateAttivitaSvoltaDett41 = new TaifTAttivitaSvoltaDettDto();
					TaifTAttivitaSvoltaDto updateAttivitaSvolta41 = new TaifTAttivitaSvoltaDto();

					List<TaifRAttivDetMaterialeDto> attMatList = new ArrayList<TaifRAttivDetMaterialeDto>();
					List<MaterialePropagazione> materialePropagazioneList = elencoMaterialePropagazione; // gestioneAttivitaUltimoAnno.getAttivita4().getElencoMaterialiPropagazione();
					List<String> idMaterialePropagazioneAttivoList = idMaterialiPropagazione;
					AttivitaUltimoAnno4 attivita4 = gestioneAttivitaUltimoAnno.getAttivita4();

					updateAttivitaSvolta41.setFkAzienda(idAzienda);
					updateAttivitaSvolta41.setFkTipoAttivita(new Integer(Constants.fourInt));
					updateAttivitaSvolta41.setIdAttivita(attivitaSvolta4.getId());
					if (attivita4.getAltro() != null && attivita4.getAltro() != "") {
						updateAttivitaSvolta41.setDescrAltreAttivita(attivita4.getAltro());
					}
					if (attivita4.getPercentuale() != null) {
						updateAttivitaSvolta41.setPercFatturato(new BigDecimal(attivita4.getPercentuale()));
					}

					updateAttivitaSvolta41.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					updateAttivitaSvolta41.setFkConfigUtente(idConfigUtente);
					taifTAttivitaSvoltaDao.updateColumnsAttivitaForIdAzienda(updateAttivitaSvolta41);

					updateAttivitaSvoltaDett41.setFkUnitaDiMisura(getIdUnitaMisura(Constants.nessunDatoUnitaMisura));
					updateAttivitaSvoltaDett41.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					updateAttivitaSvoltaDett41.setFkConfigUtente(idConfigUtente);
					updateAttivitaSvoltaDett41.setIdAttivita(attivitaSvolta4.getId());
					updateAttivitaSvoltaDett41.setProgressivo(Constants.oneInt);
					updateAttivitaSvoltaDett41.setPercContoTerzi(new BigDecimal(attivita4.getPercentuale()));

					taifTAttivitaSvoltaDettDao.updateColumnsForIdAzienda(updateAttivitaSvoltaDett41);
					// find materiali

					AttivitaProgressivoFilter attivitaProgressivoFilter = new AttivitaProgressivoFilter();
					attivitaProgressivoFilter.setIdAttivita(attivitaSvolta4.getId());
					attivitaProgressivoFilter.setProgressivo(Constants.oneInt);

					List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> materialeByAttivita = new ArrayList<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto>();
					materialeByAttivita = findMaterialeByAttivitaProgressivo(attivitaProgressivoFilter);
					for (TaifRAttivDetMaterialeByIdAttivitaProgressivoDto materialeFindet : materialeByAttivita) {
						log.info("UPDATE ATTIVITA 4 idMaterialeFindet:" + materialeFindet.getIdMateriale().toString());

						idMaterialeFindet.add(materialeFindet.getIdMateriale().toString());
						//taif-12: se un elemento precedentemente aggiunto al db viene deselezionato deve essere eliminato dal db
						for(String materiale : idMaterialeFindet) {
							if(!idMaterialePropagazioneAttivoList.contains(materiale)) {
								taifRAttivDetMaterialeDao.delete(new TaifRAttivDetMaterialePk(materialeFindet.getIdMateriale(), materialeFindet.getIdAttivita(), materialeFindet.getProgressivo()));
							}
						}
					}
					
					for (String materialeCheck : idMaterialePropagazioneAttivoList) {
						log.info("UPDATE ATTIVITA 4 materialeCheck:" + materialeCheck);

						if (!idMaterialeFindet.contains(materialeCheck)) {
							idMaterialeNew.add(materialeCheck);
						}
					}
					for (MaterialePropagazione materialePropagazione : materialePropagazioneList) {
						log.info("UPDATE ATTIVITA 4 materialePropagazione.getIdMaterialePropagazione():" + materialePropagazione.getIdMaterialePropagazione());

						for (TaifRAttivDetMaterialeByIdAttivitaProgressivoDto materiale : materialeByAttivita) {
							TaifRAttivDetMaterialeDto updateAttivitamateriale = new TaifRAttivDetMaterialeDto();
							if (materiale.getIdMateriale().intValue() == materialePropagazione
									.getIdMaterialePropagazione() && materiale.getIdMateriale().intValue()!=0) {
								updateAttivitamateriale.setIdMateriale(materiale.getIdMateriale());
								if (materialePropagazione.getIdMaterialePropagazione() == Constants.sixInt) {
									log.info("UPDATE ATTIVITA 4 materialePropagazione.getAltro():" + materialePropagazione.getAltro());
									log.info("UPDATE ATTIVITA 4 elencoMaterialePropagazione.get(6).getAltro():" + elencoMaterialePropagazione.get(6).getAltro());

									updateAttivitamateriale
											.setDescrAltroMateriale((elencoMaterialePropagazione.get(6).getAltro()));
								}
								updateAttivitamateriale.setFkConfigUtente(idConfigUtente);
								updateAttivitamateriale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								updateAttivitamateriale.setIdAttivita(updateAttivitaSvoltaDett41.getIdAttivita());
								updateAttivitamateriale.setProgressivo(updateAttivitaSvoltaDett41.getProgressivo());

								taifRAttivDetMaterialeDao.updateColumnsByAttivitaAzienda(updateAttivitamateriale);
							}
						}
					}
					for (MaterialePropagazione materialePropagazione : materialePropagazioneList) {
						for (String idMateriale : idMaterialeNew) {
							if (Integer.parseInt(idMateriale) == materialePropagazione.getIdMaterialePropagazione() && Integer.parseInt(idMateriale)!=0) {
								TaifRAttivDetMaterialeDto attivitamateriale = new TaifRAttivDetMaterialeDto();
								attivitamateriale.setIdMateriale(materialePropagazione.getIdMaterialePropagazione());
								if (materialePropagazione.getIdMaterialePropagazione() == Constants.sixInt) {
									attivitamateriale
											.setDescrAltroMateriale(elencoMaterialePropagazione.get(6).getAltro());
								}
								attivitamateriale.setFkConfigUtente(idConfigUtente);
								attivitamateriale.setDataInserimento(new Timestamp(System.currentTimeMillis()));
								attivitamateriale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
								attivitamateriale.setIdAttivita(updateAttivitaSvoltaDett41.getIdAttivita());
								attivitamateriale.setProgressivo(updateAttivitaSvoltaDett41.getProgressivo());

								taifRAttivDetMaterialeDao.insert(attivitamateriale);
							}
						}
					}
				}

			} else {
				// insert in attivita 4

				TaifTAttivitaSvoltaDettDto attivitaSvoltaDett41 = new TaifTAttivitaSvoltaDettDto();
				TaifTAttivitaSvoltaDto attivitaSvolta41 = new TaifTAttivitaSvoltaDto();

				List<MaterialePropagazione> materialePropagazioneList = elencoMaterialePropagazione; // gestioneAttivitaUltimoAnno.getAttivita4().getElencoMaterialiPropagazione();
				AttivitaUltimoAnno4 attivita4 = gestioneAttivitaUltimoAnno.getAttivita4();

				attivitaSvolta41.setFkAzienda(idAzienda);
				attivitaSvolta41.setFkTipoAttivita(new Integer(Constants.fourInt));

				if (attivita4.getAltro() != null && attivita4.getAltro() != "") {
					attivitaSvolta41.setDescrAltreAttivita(attivita4.getAltro());
				}
				if (attivita4.getPercentuale() != null) {
					attivitaSvolta41.setPercFatturato(new BigDecimal(attivita4.getPercentuale()));
				}

				attivitaSvolta41.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvolta41.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvolta41.setFkConfigUtente(idConfigUtente);
				TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta41);

				attivitaSvoltaDett41.setFkUnitaDiMisura(getIdUnitaMisura(Constants.nessunDatoUnitaMisura));
				attivitaSvoltaDett41.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett41.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				attivitaSvoltaDett41.setFkConfigUtente(idConfigUtente);
				attivitaSvoltaDett41.setIdAttivita(idAttSvolta.getIdAttivita());
				attivitaSvoltaDett41.setProgressivo(Constants.oneInt);

				TaifTAttivitaSvoltaDettPk idAttSvoltaDett = taifTAttivitaSvoltaDettDao.insert(attivitaSvoltaDett41);
				for (MaterialePropagazione materialePropagazione : materialePropagazioneList) {
					log.info("UPDATE AZIENDA - INSERT ATTIVITA 4 materialePropagazione.getIdMaterialePropagazione():" + materialePropagazione.getIdMaterialePropagazione());

					for (String idMateriale : idMaterialiPropagazione) {
						if (Integer.parseInt(idMateriale) == materialePropagazione.getIdMaterialePropagazione()) {
							TaifRAttivDetMaterialeDto attivitamateriale = new TaifRAttivDetMaterialeDto();
							attivitamateriale.setIdMateriale(materialePropagazione.getIdMaterialePropagazione());
							if (materialePropagazione.getIdMaterialePropagazione() == Integer
									.parseInt(Constants.idmaterialeVivai)) {
								attivitamateriale.setDescrAltroMateriale(elencoMaterialePropagazione.get(6).getAltro());
							}
							attivitamateriale.setFkConfigUtente(idConfigUtente);
							attivitamateriale.setDataInserimento(new Timestamp(System.currentTimeMillis()));
							attivitamateriale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
							attivitamateriale.setIdAttivita(idAttSvoltaDett.getIdAttivita());
							attivitamateriale.setProgressivo(idAttSvoltaDett.getProgressivo());

							taifRAttivDetMaterialeDao.insert(attivitamateriale);
						}
					}
				}
			}
		} else {
			List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivita4SvoltaBack = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
			AziendaVisibleFilter aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
					Constants.fourInt);
			AttivitaProgressivoFilter attivitaProgressivoFilter = new AttivitaProgressivoFilter();

			attivita4SvoltaBack = taifTAttivitaSvoltaDao.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
			if (attivita4SvoltaBack != null && !attivita4SvoltaBack.isEmpty()) {
				for (TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto attivitaSvolta : attivita4SvoltaBack) {

					List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> listAttivitaDettaglio = taifTAttivitaSvoltaDettDao
							.findByFilterAttivita(attivitaSvolta.getId());
					for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaDettaglio : listAttivitaDettaglio) {
						attivitaProgressivoFilter.setIdAttivita(attivitaDettaglio.getId());
						attivitaProgressivoFilter.setProgressivo(attivitaDettaglio.getProgressivo());

						List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> materialeAttivitaList = taifRAttivDetMaterialeDao
								.findByIdAttivitaProgressivo(attivitaProgressivoFilter);
						for (TaifRAttivDetMaterialeByIdAttivitaProgressivoDto matAtt : materialeAttivitaList) {
							taifRAttivDetMaterialeDao.delete(new TaifRAttivDetMaterialePk(matAtt.getIdMateriale(),
									attivitaDettaglio.getId(), attivitaDettaglio.getProgressivo()));
						}
						taifTAttivitaSvoltaDettDao.delete(new TaifTAttivitaSvoltaDettPk(attivitaDettaglio.getId(),
								attivitaDettaglio.getProgressivo()));
					}
					taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaSvolta.getId()));
				}
			}
		}
	}

	public TaifDAssortimentoDto getAssortimento(Integer idAssortimento) throws DbManagerException {
		log.debug("[DbMgr::getAssortimento] BEGIN");
		try {
			TaifDAssortimentoDto assortomentoDto = taifDAssortimentoDao
					.findByPrimaryKey(new TaifDAssortimentoPk(idAssortimento));
			return assortomentoDto;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAssortimento] END");
		}
	}

	public TaifDProvDestinDto getProvDestinazia(Integer idProvDest) throws DbManagerException {
		log.debug("[DbMgr::getProvDestinazia] BEGIN");
		try {
			TaifDProvDestinDto provDestinazia = taifDProvDestinDao.findByPrimaryKey(new TaifDProvDestinPk(idProvDest));
			return provDestinazia;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProvDestinazia] END");
		}
	}

	public List<TaifRAziendaFrTipoContrFindByIdAziendaDto> getTipologieContrattoFrancese(Integer idAzienda)
			throws DbManagerException {
		log.debug("[DbMgr::getTipologieContrattoFrancese] BEGIN");
		try {
			List<TaifRAziendaFrTipoContrFindByIdAziendaDto> aziendaContratto = taifRAziendaFrTipoContrDao
					.findFindByIdAzienda(idAzienda);
			return aziendaContratto;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTipologieContrattoFrancese] END");
		}
	}

	public List<TaifRAziendaFrTipoMansFindByIdAziendaDto> getMansioneFrancese(Integer idAzienda)
			throws DbManagerException {
		log.debug("[DbMgr::getMansioneFrancese] BEGIN");
		try {
			List<TaifRAziendaFrTipoMansFindByIdAziendaDto> aziendaMansione = taifRAziendaFrTipoMansDao
					.findFindByIdAzienda(idAzienda);
			return aziendaMansione;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getMansioneFrancese] END");
		}
	}

	public List<Integer> getAllegatiObbligatoriPerPratica(TipoAllegatoFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getAllegatiObbligatori] BEGIN ");
		List<Integer> result = new ArrayList<Integer>();
		try {

			TaifTPraticaDto pratica = this.taifTPraticaDao.findByPrimaryKey(new TaifTPraticaPk(filter.getIdPratica()));

			List<TaifCnfTipoAllegatoAllegatiObbligatoriDto> list = this.taifCnfTipoAllegatoDao
					.findAllegatiObbligatori(filter);
			if (list != null && !list.isEmpty()) {
				for (TaifCnfTipoAllegatoAllegatiObbligatoriDto dto : list) {
					if (dto.getAIdTipoAllegato() != it.csi.taif.taifweb.util.Constants.ID_TIPO_ALLEGATO_MARCA_DA_BOLLO_VDA
							|| pratica
									.getFkSoggettoGestore() == it.csi.taif.taifweb.util.Constants.ID_ALBO_VALLE_D_AOSTA)
						result.add(dto.getAIdTipoAllegato());

				}
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAllegatiObbligatoriPerPratica] END");
		}
		return result;
	}

	public List<TaifTLavoroPaByAziendaDto> getLavoroPa(LavoroPaFilter lavoroPaFilter) throws DbManagerException {
		log.debug("[DbMgr::getMansioneFrancese] BEGIN");
		try {
			List<TaifTLavoroPaByAziendaDto> lavoroPaEsistente = taifTLavoroPaDao.findByAzienda(lavoroPaFilter);

			return lavoroPaEsistente;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getMansioneFrancese] END");
		}
	}

	public String getStatoPratica(Integer idPratica) throws DbManagerException {
		log.debug("[DbMgr::getStatoPratica] BEGIN");
		try {
			List<TaifTStoricoStatoDto> statoPraticaDto = taifTStoricoStatoDao.findStatoAttivo(idPratica);
			String statoPratica = null;
			if (!statoPraticaDto.isEmpty()) {
				statoPratica = taifDStatoPraticaDao
						.findByPrimaryKey(new TaifDStatoPraticaPk(statoPraticaDto.get(0).getFkStatoPratica()))
						.getStatoPraticaIta();
			}
			return statoPratica;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getStatoPratica] END");
		}
	}

	public String getTipoStruttureFromFunzioneStruttura(int idFunzione) throws DbManagerException {
		String tipoStruttura = null;
		try {
			int idTipoStruttura = taifDFunzioneDao.findByPrimaryKey(new TaifDFunzionePk(idFunzione))
					.getFkTipoStruttura();
			TaifDTipoStrutturaDto struttura = taifDTipoStrutturaDao
					.findByPrimaryKey(new TaifDTipoStrutturaPk(idTipoStruttura));
			if (struttura != null) {
				tipoStruttura = struttura.getTipoStruttura();
			}
			return tipoStruttura;
		} catch (DaoException e) {
			throw new DbManagerException();
		}
	}

	public String findCorsiPerPersona(CorsoQualificaFilter corsoFilter) throws DbManagerException {
		log.debug("[DbMgr::getCorsiSostenuti] BEGIN");
		try {
			String corsiList = "";

			List<TaifTCorsoFindCorsiElencoOperatoriDto> corsoList = taifTCorsoDao
					.findFindCorsiElencoOperatori(corsoFilter);
			for (TaifTCorsoFindCorsiElencoOperatoriDto corso : corsoList) {
				corsiList = corsiList.concat(corso.getNomeCorso()).concat(" ; ");
			}

			return corsiList;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getCorsiSostenuti] END");
		}
	}

	private void insertAttivitaOtto(Integer idAzienda, String dataTracciato) throws DbManagerException {
		aziendaVisibleFilter = getAziendaVisibleFilter(idAzienda, dataTracciato,
				it.csi.taif.taifweb.business.dao.util.Constants.eightInt);
		List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaOtto = findAttivitaSvoltaByIdAzienda(
				aziendaVisibleFilter);
		if (!(attivitaOtto != null && attivitaOtto.size() > 0 && attivitaOtto.get(0).getId() != null)) {
			AttivitaUltimoAnno8 attivitaAnnoOtto = new AttivitaUltimoAnno8();
			TaifTAttivitaSvoltaDto attivitaSvolta81 = new TaifTAttivitaSvoltaDto();
			attivitaAnnoOtto.setPercentuale(Constants.zero);
			attivitaAnnoOtto.setAltro(null);

			attivitaSvolta81.setFkAzienda(idAzienda);
			attivitaSvolta81.setFkTipoAttivita(new Integer(Constants.eightInt));
			if (attivitaAnnoOtto.getAltro() != null && attivitaAnnoOtto.getAltro() != "") {
				attivitaSvolta81.setDescrAltreAttivita(attivitaAnnoOtto.getAltro());
			}
			if (attivitaAnnoOtto.getPercentuale() != null) {
				attivitaSvolta81.setPercFatturato(new BigDecimal(attivitaAnnoOtto.getPercentuale()));
			}
			attivitaSvolta81.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			attivitaSvolta81.setDataInserimento(new Timestamp(System.currentTimeMillis()));
			attivitaSvolta81.setFkConfigUtente(idConfigUtente);
			TaifTAttivitaSvoltaPk idAttSvolta = taifTAttivitaSvoltaDao.insert(attivitaSvolta81);
		}
	}

	public Integer getMaxNumeroAlboForGestore(Integer idSoggettoGestore) throws DbManagerException {
		log.debug("[DbMgr::getMaxNumeroAlboForGestore] BEGIN");
		try {
			Integer maxAlbo = null;
			List<TaifTPraticaMaxAlboNumberValueDto> listaOfMaxValue = taifTPraticaDao
					.findMaxAlboNumberValue(idSoggettoGestore);
			if (listaOfMaxValue.size() > 0) {
				maxAlbo = listaOfMaxValue.get(0).getMaxNumeroAlbo();
			}
			return maxAlbo;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getMaxNumeroAlboForGestore] END");
		}
	}

	private TaifCnfParamActaDto prepareParameterActa(String codice, String valore) throws DbManagerException {
		log.debug("[DbMgr::prepareParameterActa] BEGIN");
		try {
			TaifCnfParamActaDto result = null;
			List<TaifCnfParamActaDto> list = this.getTaifCnfParamActaDao().findByCodice(codice);
			if (list != null && !list.isEmpty()) {
				result = list.get(0);
			} else {
				result = new TaifCnfParamActaDto();
				result.setCodice(codice);
			}
			result.setValore(valore);
			return result;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::prepareParameterActa] END");
		}
	}

	private TaifCnfParamActaDto getParameterActa(String codice) throws DbManagerException {
		log.debug("[DbMgr::getParameterActa] BEGIN");
		try {
			List<TaifCnfParamActaDto> list = this.getTaifCnfParamActaDao().findByCodice(codice);
			return list == null ? null : list.get(0);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getParameterActa] END");
		}
	}

	public String getParameterActaValue(String codice) throws DbManagerException {
		log.debug("[DbMgr::getParameterActaValue] BEGIN");
		try {
			return this.getParameterActa(codice).getValore();
		} finally {
			log.debug("[DbMgr::getParameterActaValue] END");
		}
	}

	public void setParameterActa(String codice, String valore) throws DbManagerException {
		log.debug("[DbMgr::setParameterActa] BEGIN");
		try {
			this.getTaifCnfParamActaDao().updateColumnsValoreByCodice(this.prepareParameterActa(codice, valore));
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::setParameterActa] END");
		}
	}

	public void aggiornaIdDocumentoActaAllegato(TaifTAllegatoByIdPraticaDto allegato,
			ObjectIdType objectIdClassficazione, ObjectIdType objectIdDocumento) throws DbManagerException {
		log.debug("[DbMgr::aggiornaIdDocumentoActaAllegato] BEGIN");
		try {
			TaifTAllegatoDto dto = new TaifTAllegatoDto();
			dto.setIdAllegato(allegato.getIdAllegato());
			if (objectIdClassficazione != null) {
				dto.setIdClassificazioneDoqui(objectIdClassficazione.getValue());
			}
			dto.setIdDocDoqui(objectIdDocumento.getValue());
			this.taifTAllegatoDao.updateColumnsIdDocumentoActa(dto);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::aggiornaIdDocumentoActaAllegato] END");
		}
	}

	public TaifTStoricoStatoByStatoPraticaDto getDettaglioStato(Integer idPratica, Integer idStatoDomanda)
			throws DbManagerException {
		log.debug("[DbMgr::getDettaglioStato] END");
		try {
			List<TaifTStoricoStatoByStatoPraticaDto> list = this.taifTStoricoStatoDao.findByStatoPratica(idPratica,
					idStatoDomanda);
			return list == null ? new TaifTStoricoStatoByStatoPraticaDto() : list.get(0);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getDettaglioStato] END");
		}

	}

	public void inserisciProtocollo(TaifTStoricoStatoByStatoPraticaDto dto) throws DbManagerException {
		log.debug("[DbMgr::inserisciProtocollo] BEGIN");
		try {
			TaifTStoricoStatoDto dtoDB = new TaifTStoricoStatoDto();
			dtoDB.setDataProtocollo(dto.getDataProt());
			dtoDB.setNumeroProtocollo(dto.getNumProtocollo());
			dtoDB.setIdPratica(dto.getId());
			dtoDB.setDataInserimentoStato(dto.getDataInserimentoStato());
			;
			this.taifTStoricoStatoDao.updateColumnsInserisciProtocollo(dtoDB);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::inserisciProtocollo] END");
		}
	}

	public void countAllCommLegnameAndDeleteAttivitaEight(AziendaVisibleFilter aziendaVisibleFilter,
			String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::countAllCommLegnameAndDeleteAttivitaEight] BEGIN");

		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			List<TaifTCommercializzazioneByAziendaDto> allCommercializzazioneList = taifTCommercializzazioneDao
					.findByAzienda(aziendaVisibleFilter.getIdAzienda());
			if (allCommercializzazioneList != null && allCommercializzazioneList.size() == 0) {
				List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaOtto = findAttivitaSvoltaByIdAzienda(
						aziendaVisibleFilter);
				if (attivitaOtto.size() > 0) {
					taifTAttivitaSvoltaDao.delete(new TaifTAttivitaSvoltaPk(attivitaOtto.get(0).getId()));
				}
			}
			//
			List<TaifTAttivitaSvoltaByIdAziendaDto> listAttivitaSvoltePerAzienda = taifTAttivitaSvoltaDao
					.findByIdAzienda(aziendaVisibleFilter.getIdAzienda());
			if (listAttivitaSvoltePerAzienda.isEmpty()) {
				TaifApplSchedaOkDto taifTaifAppl = taifApplSchedaOkDao
						.findByPrimaryKey(new TaifApplSchedaOkPk(aziendaVisibleFilter.getIdAzienda()));
				if (taifTaifAppl != null) {
					if (dataTracciato.contentEquals(Constants.iLang)) {
						taifTaifAppl.setFlgSez31ItaOk(new BigDecimal(Constants.zero));
						taifTaifAppl.setFlgSez31FraOk(new BigDecimal(Constants.zero));
					}
					taifApplSchedaOkDao.update(taifTaifAppl);
				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::countAllCommLegnameAndDeleteAttivitaEight] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::countAllCommLegnameAndDeleteAttivitaEight] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));

		} finally {
			log.debug("[DbMgr::countAllCommLegnameAndDeleteAttivitaEight] END");
		}

	}

	public ArrayList<CodeDescription> getRiconoscimentiPersona(CorsoQualificaFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getRiconoscimentiPersona] BEGIN");
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		try {
			List<TaifTRiconoscimentoByCodiceFiscaleDto> list = taifTRiconoscimentoDao
					.findByCodiceFiscale(filter.getCodiceFiscale());
			for (TaifTRiconoscimentoByCodiceFiscaleDto dto : list) {
				CodeDescription cd = new CodeDescription();
				cd.setCode(ConvertUtil.convertToString(dto.getRIdRiconoscimento()));
				StringBuilder desc = new StringBuilder();
				if (StringUtils.isNotEmpty(dto.getUSigla()))
					;
				{
					desc.append(dto.getUSigla());
					desc.append(" - ");
				}
				if (StringUtils.isNotEmpty(dto.getUUnitaFormativa())) {
					desc.append(dto.getUUnitaFormativa());
				}
				cd.setDescription(desc.toString());
				result.add(cd);
			}
			return result;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getRiconoscimentiPersona] END");
		}
	}

	public TaifVApplSchedaOkRealeDto getInfoSchedeAzienda(Integer idAzienda) throws DbManagerException {
		log.debug("[DbMgr::getInfoSchedeAzienda] BEGIN");
		TaifVApplSchedaOkRealeDto result = null;
		try {
			List<TaifVApplSchedaOkRealeDto> list = this.taifVApplSchedaOkRealeDao.findByAzienda(idAzienda);
			if (list != null && !list.isEmpty()) {
				result = list.get(0);
			} else {
				result = new TaifVApplSchedaOkRealeDto();
			}

		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getInfoSchedeAzienda] END");
		}
		return result;
	}
	
	public String findQualifichePerPersona(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::findQualifichePerPersona] BEGIN ");
		String result = null;
		try {
			List<TaifVElencoQualificaPersonaDto> list = taifVElencoQualificaPersonaDao.findByIdPersona(idPersona);
			if (list != null && !list.isEmpty()) {
				result = list.get(0).getArrayToString();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findQualifichePerPersona] END");
		}
		return result;
	}
	
	public String findQualifichePerCodiceFiscalePersona(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::findQualifichePerCodiceFiscalePersona] BEGIN ");
		String result = null;
		try {
			List<TaifVElencoQualificaPersonaDto> list = taifVElencoQualificaPersonaDao.
					findByCodiceFiscalePersona(codiceFiscale);
			if (list != null && !list.isEmpty()) {
				result = list.get(0).getArrayToString();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findQualifichePerCodiceFiscalePersona] END");
		}
		return result;
	}
	
	public String findRiconoscimentiPerPersona(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::findRiconoscimentiPerPersona] BEGIN ");
		String result = null;
		try {
			List<TaifVElencoRiconoscimentoPersonaDto> list = taifVElencoRiconoscimentoPersonaDao.findByIdPersona(idPersona);
			if (list != null && !list.isEmpty()) {
				result = list.get(0).getArrayToString();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRiconoscimentiPerPersona] END");
		}
		return result;
	}
	
	public String findRiconoscimentiPerCodiceFiscalePersona(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::findRiconoscimentiPerCodiceFiscalePersona] BEGIN ");
		String result = null;
		try {
			List<TaifVElencoRiconoscimentoPersonaDto> list = taifVElencoRiconoscimentoPersonaDao
					.findByCodiceFiscalePersona(codiceFiscale);
			if (list != null && !list.isEmpty()) {
				result = list.get(0).getArrayToString();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRiconoscimentiPerCodiceFiscalePersona] END");
		}
		return result;
	}
	
}
