/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.dto.domanda.Albo;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.GenericUtil;

public class SceltaAlboAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1994812825794707257L;

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String idAlbo;
	// private DummyMgr dummyMgr;
	private TaifMgr taifMgr;

	private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	public String execute() throws Exception {
		LOGGER.debug("[SceltaAlboAction::execute] BEGIN");
		LOGGER.debug("ID ALBO ???? *" + this.getIdAlbo() + "*");
		Albo albo = this.taifMgr.getAlboSogettoGestore(Integer.parseInt(this.getIdAlbo()));
		this.request.getSession().setAttribute("appDataalbo", albo);
		this.request.getSession().setAttribute("appDatabackDomanda", null);
		this.setTracciato();
		// Pulisco la sessione da precedenti inserimenti/modifiche
		this.cleanSession();
		return SUCCESS;
	}

	private void cleanSession() {
		this.request.getSession().setAttribute("appDataidAzienda", null);
		this.request.getSession().setAttribute("appDataidPratica", null);
		this.request.getSession().setAttribute("appDataidDomandaSelezionata", null);
		// Sezione 1.1
		this.request.getSession().setAttribute("appDataanagraficaAziendale", null);
		this.request.getSession().setAttribute("appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale", null);
		this.request.getSession().setAttribute("appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale", null);
		this.request.getSession().setAttribute("appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale", null);
		this.request.getSession().setAttribute("appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale", null);
		this.request.getSession().setAttribute("appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale", null);
		this.request.getSession().setAttribute("widg_rbsDatiAnagraficiAltreSedi2", null);
		this.request.getSession().setAttribute("appDatasedeLegaleDatiAnagraficiAnagrafeAziendale", null);
		this.request.getSession().setAttribute("appDataelencoSediDatiAnagraficiAnagrafeAziendale", null);
		this.request.getSession().setAttribute("appDataidSedeDatiAnagraficiAnagrafeAziendale", null);
		this.request.getSession().setAttribute("appDatasedeLegaleAnagrafeAziendale", null);
		// Sezione 1.2
		this.request.getSession().setAttribute("appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("widg_rbsDatiAnagraficiAltroConducente", null);
		this.request.getSession().setAttribute("appDataelencoQualificheAltroTitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("appDataelencoCorsiSostenutiTitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("appDatatitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("appDataaltroTitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale", null);
		this.request.getSession().setAttribute("appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale", null);
		// Sezione 2.1
		this.request.getSession().setAttribute("appDatafatturatoCategorieDiImpresa", null);
		this.request.getSession().setAttribute("appDataidCategorieImpresaSelezionati", null);
		this.request.getSession().setAttribute("appDataidCategorieImpresaSelezionato", null);
		this.request.getSession().setAttribute("widg_rbsDatiSocioEconomiciAltriAlbi", null);
		// Sezione 2.2
		this.request.getSession().setAttribute("appDataassociazioniECertificazioni", null);
		this.request.getSession().setAttribute("widg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso", null);
		this.request.getSession().setAttribute("appDataelencoAltriAlbi", null);
		this.request.getSession().setAttribute("appDataidFormeOrganizzative", null);
		this.request.getSession().setAttribute("appDataassociazioniECertificazioni", null);
		this.request.getSession().setAttribute("appDataelencoCertificazioni", null);
		this.request.getSession().setAttribute("CpDomanda_mpDatiSocioEconomiciAltriAlbi_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_selectedMultiPanel", null);
		// Sezione 3.1
		this.request.getSession().setAttribute("appDataelencoAttivitaUltimoAnno", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnnoSelezionate", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno1", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno2", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno3", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno4", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno5", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno6", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno7", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno8", null);
		this.request.getSession().setAttribute("appDataattivitaUltimoAnno9", null);
		this.request.getSession().setAttribute("appDataidAttivitaUltimoAnno", null);
		this.request.getSession().setAttribute("appDataidAttivitaUltimoAnnoFr", null);
		this.request.getSession().setAttribute("appDataelencoAttivitaUltimoAnnoFr", null);
		this.request.getSession().setAttribute("appDatagestioneAttivitaUltimoAnno", null);
		this.request.getSession().setAttribute("CpDomanda_mpAttivitaUltimoAnno1_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_mpAttivitaUltimoAnno2_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_mpAttivitaUltimoAnno3_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_mpAttivitaUltimoAnno4_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_mpAttivitaUltimoAnno5_selectedMultiPanel", null);
		
		// Sezione 3.2
		this.request.getSession().setAttribute("widg_rbsAttivitaLavoriPA", null);
		this.request.getSession().setAttribute("appDataelencoLavoriPA", null);
		// Sezione 3.3
		this.request.getSession().setAttribute("widg_rbsAttivitaLegname", null);
		this.request.getSession().setAttribute("appDataelencoLegnamiAssortimentiTrattati", null);
		this.request.getSession().setAttribute("appDatapercentualeCommercioFr", null);
		this.request.getSession().setAttribute("appDataelencoLegnamiAssortimentiTrattati", null);
		// Sezione 4
		this.request.getSession().setAttribute("appDataelencoCapannoni", null);
		this.request.getSession().setAttribute("appDataelencoPiazzaliStoccaggio", null);
		// Sezione 5.1
		this.request.getSession().setAttribute("appDataelencoCaschiForestaliAttrezzature", null);
		this.request.getSession().setAttribute("appDataelencoPantaloniAntitaglioAttrezzature", null);
		this.request.getSession().setAttribute("appDataelencoScarponiRinforzatiAttrezzature", null);
		// Sezione 5.2
		this.request.getSession().setAttribute("appDataelencoMacchineCippatrici", null);
		this.request.getSession().setAttribute("appDataelencoMacchineGruACavo", null);
		this.request.getSession().setAttribute("appDataelencoMacchineMovimentoTerra", null);
		this.request.getSession().setAttribute("appDataelencoMacchinePle", null);
		this.request.getSession().setAttribute("appDataelencoMacchineRimorchi", null);
		this.request.getSession().setAttribute("appDataelencoMacchineSegheriaMobile", null);
		this.request.getSession().setAttribute("appDataelencoMacchineSpeciali", null);
		this.request.getSession().setAttribute("appDataelencoMacchineTrattrici", null);
		this.request.getSession().setAttribute("appDataelencoMacchineTrinciaForestali", null);
		this.request.getSession().setAttribute("appDataelencoMacchineVerricelli", null);
		this.request.getSession().setAttribute("appDataelencoMezziDiTrasporto", null);
		this.request.getSession().setAttribute("appDataelencoAltriMezzi", null);
		this.request.getSession().setAttribute("appDataelencoMacchineSpecialiFr", null);
		this.request.getSession().setAttribute("appDataelencoMacchineRimorchiFr", null);
		this.request.getSession().setAttribute("appDataelencoMacchineMovimentoTerraFr", null);
		// Sezione 6
		this.request.getSession().setAttribute("widg_rbsPersonale", null);
		this.request.getSession().setAttribute("appDataelencoPersonaleSuggerito", null);
		this.request.getSession().setAttribute("appDatapersonaleDaCercare", null);
		this.request.getSession().setAttribute("appDataelencoPersonale", null);
		this.request.getSession().setAttribute("appDatagestioneAltroPersonaleFr", null);
		this.request.getSession().setAttribute("appDataelencoAltroPersonaleTipoContrattoFr", null);
		this.request.getSession().setAttribute("appDataelencoAltroPersonaleTipoMansioneFr", null);
		this.request.getSession().setAttribute("CpDomanda_mpAltroPersonale_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_mpAltroPersonaleFr_selectedMultiPanel", null);
		
		// Tab dei wizard
		this.request.getSession().setAttribute("CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_wzpDomandaAttivita_selectedMultiPanel", null);
		this.request.getSession().setAttribute("CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel", null);
		
		
		// Riepilogo
		
		// Documenti
		
		// this.request.getSession().setAttribute("appDataidAzienda", null);

	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}

	public HttpServletResponse getResponse() {
		return this.response;
	}

	public String getIdAlbo() {
		this.idAlbo = (String) this.request.getParameter("idAlboSel");
		return this.idAlbo;
	}

	public void setIdAlbo(String idAlbo) {
		this.idAlbo = idAlbo;
	}

	/*
	 * public DummyMgr getDummyMgr() { return dummyMgr; }
	 * 
	 * public void setDummyMgr(DummyMgr dummyMgr) { this.dummyMgr = dummyMgr; }
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	public void setTracciato() {

		this.request.getSession().setAttribute("appDatatracciato",
				GenericUtil.getTracciatoFromSoggettoGestore(getIdAlbo()));

	}

}
