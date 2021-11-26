/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager;

import java.util.ArrayList;

import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.domanda.Albo;
import it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno;
import it.csi.taif.taifweb.dto.domanda.Attivita;
import it.csi.taif.taifweb.dto.domanda.AziendaAAEP;
import it.csi.taif.taifweb.dto.domanda.Capannone;
import it.csi.taif.taifweb.dto.domanda.CategoriaImpresa;
import it.csi.taif.taifweb.dto.domanda.Certificazione;
import it.csi.taif.taifweb.dto.domanda.Domanda;
import it.csi.taif.taifweb.dto.domanda.FormaOrganizzativa;
import it.csi.taif.taifweb.dto.domanda.LavoroPA;
import it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato;
import it.csi.taif.taifweb.dto.domanda.MacchinaMezzo;
import it.csi.taif.taifweb.dto.domanda.MaterialePropagazione;
import it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale;
import it.csi.taif.taifweb.dto.domanda.Personale;
import it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio;
import it.csi.taif.taifweb.dto.domanda.Sede;
import it.csi.taif.taifweb.dto.gestore.Azienda;
import it.csi.taif.taifweb.util.ListUtils;


public class DummyMgr {
	
	public ArrayList<CodeDescription> getElencoAziende(){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription aziendaUno = new CodeDescription();
		aziendaUno.setCode("1");
		aziendaUno.setDescription("Prova azienda Marco Rossi pavimentazioni");
		result.add(aziendaUno);
		
		CodeDescription aziendaDue = new CodeDescription();
		aziendaDue.setCode("2");
		aziendaDue.setDescription("Prova azienda Marco Rossi e figli");
		result.add(aziendaDue);
		
		CodeDescription aziendaTre = new CodeDescription();
		aziendaTre.setCode("3");
		aziendaTre.setDescription("Prova azienda Marco Rossi SRL");
		result.add(aziendaTre);
		
		CodeDescription aziendaQuattro = new CodeDescription();
		aziendaQuattro.setCode("4");
		aziendaQuattro.setDescription("Prova azienda Marco Rossi calcestruzzi");
		result.add(aziendaQuattro);
		
		return result;
	}
	
	public ArrayList<Domanda> getElencoDomande(){
		ArrayList<Domanda> result = new ArrayList<Domanda>();
		
		Domanda domandaUno  = new Domanda();
		domandaUno.setIdDomanda(1);
		domandaUno.setIdAlbo(1);
		domandaUno.setDsAlbo("Piemonte");
		domandaUno.setDsDomanda("Marco Rossi deforestazioni");
		domandaUno.setData("20/04/2018");
		domandaUno.setIdStato(1);
		domandaUno.setDsStato("Bozza");
		result.add(domandaUno);
		
		Domanda domandaDue = new Domanda();
		domandaDue.setIdDomanda(2);
		domandaDue.setIdAlbo(2);
		domandaDue.setDsAlbo("Liguria");
		domandaDue.setNumeroAlbo("23");
		domandaDue.setDsDomanda("Marco Rossi tagli");
		domandaDue.setData("28/04/2018");
		domandaDue.setIdStato(2);
		domandaDue.setDsStato("Inviata");
		result.add(domandaDue);
		
		Domanda domandaTre  = new Domanda();
		domandaTre.setIdDomanda(3);
		domandaTre.setIdAlbo(3);
		domandaTre.setDsAlbo("Valle d'Aosta");
		domandaTre.setNumeroAlbo("30");
		domandaTre.setDsDomanda("Marco Rossi rimboschimenti");
		domandaTre.setData("10/05/2018");
		domandaTre.setIdStato(3);
		domandaTre.setDsStato("Presa in carico");
		result.add(domandaTre);
		
		
		return result;
	}
	
	public ArrayList<CodeDescription> getElencoStati(){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription cdUno = new CodeDescription();
		cdUno.setCode("1");
		cdUno.setDescription("Italia");
		result.add(cdUno);
		
		CodeDescription cdDue = new CodeDescription();
		cdDue.setCode("2");
		cdDue.setDescription("Francia");
		result.add(cdDue);
		
		CodeDescription cdTre = new CodeDescription();
		cdTre.setCode("3");
		cdTre.setDescription("Spagna");
		result.add(cdTre);
		
		CodeDescription cdQuattro = new CodeDescription();
		cdQuattro.setCode("4");
		cdQuattro.setDescription("Svizzera");
		result.add(cdQuattro);
		
		CodeDescription cdCinque = new CodeDescription();
		cdQuattro.setCode("5");
		cdQuattro.setDescription("Etiopia");
		result.add(cdCinque);
		
		return result;
	} 
	
	public ArrayList<CodeDescription> getElencoProvince(){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription cdUno = new CodeDescription();
		cdUno.setCode("1");
		cdUno.setDescription("Torino");
		result.add(cdUno);
		
		CodeDescription cdDue = new CodeDescription();
		cdDue.setCode("2");
		cdDue.setDescription("Asti");
		result.add(cdDue);
		
		CodeDescription cdTre = new CodeDescription();
		cdTre.setCode("3");
		cdTre.setDescription("Alessandria");
		result.add(cdTre);
		
		CodeDescription cdQuattro = new CodeDescription();
		cdQuattro.setCode("4");
		cdQuattro.setDescription("Cuneo");
		result.add(cdQuattro);
		
		return result;
	} 
	
	public ArrayList<CodeDescription> getElencoTitoliDiStudio(){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription cdUno = new CodeDescription();
		cdUno.setCode("1");
		cdUno.setDescription("Laurea");
		result.add(cdUno);
		
		CodeDescription cdDue = new CodeDescription();
		cdDue.setCode("2");
		cdDue.setDescription("Diploma di scuola media inferiore");
		result.add(cdDue);
		
		CodeDescription cdTre = new CodeDescription();
		cdTre.setCode("3");
		cdTre.setDescription("Diploma di scuola media superiore");
		result.add(cdTre);
		
		CodeDescription cdQuattro = new CodeDescription();
		cdQuattro.setCode("4");
		cdQuattro.setDescription("Laurea Specialistica");
		result.add(cdQuattro);
		
		return result;
	} 
	
	public ArrayList<CodeDescription> getElencoTipoSede(){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription cdUno = new CodeDescription();
		cdUno.setCode("1");
		cdUno.setDescription("Sede Legale");
		result.add(cdUno);
		
		CodeDescription cdDue = new CodeDescription();
		cdDue.setCode("2");
		cdDue.setDescription("Sede Operativa");
		result.add(cdDue);
		
		return result;
	} 
	
	public ArrayList<Sede> getElencoSedi(){
		ArrayList<Sede> result = new ArrayList<Sede>();
		Sede uno = new Sede();
		uno.setIdSede(3);
		uno.setElencoTipoSede(this.getElencoTipoSede());
		uno.setIdTipoSede(2);
		uno.setDsComune("Torino");
		uno.setIndirizzo("Via Alfieri");
		uno.setNumeroCivico("10");
		uno.setCap("10100");
		uno.setTelefono("0113169000");
		uno.setRownum(1);
		result.add(uno);
		
		Sede due = new Sede();
		due.setIdSede(2);
		due.setElencoTipoSede(this.getElencoTipoSede());
		due.setIdTipoSede(2);
		due.setDsComune("Torino");
		due.setIndirizzo("Corso Enrico Tazzoli");
		due.setNumeroCivico("215/12");
		due.setCap("10100");
		due.setTelefono("0113168888");
		due.setRownum(2);
		result.add(due);
		return result;
	}
	
	public ArrayList<Sede> getSedeLegale(){
		ArrayList<Sede> result = new ArrayList<Sede>();
		Sede uno = new Sede();
		uno.setIdSede(1);
		uno.setDsComune("Torino");
		uno.setIndirizzo("Corso Unione Sovietica");
		uno.setNumeroCivico("216");
		uno.setCap("10100");
		uno.setTelefono("0113169617");
		result.add(uno);
		
		return result;
	}
	
	public ArrayList<CodeDescription> getGenericList(int numElements){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		for (int i = 1; i < numElements+1; i++) {
			CodeDescription cd = new CodeDescription();
			cd.setCode(""+i);
			cd.setDescription("Elemento "+i);
			result.add(cd);
		}
		return result;
	}
	
	public Sede addNuovaSede(ArrayList<Sede> sedi) {
		Sede result = new Sede();
		result.setElencoTipoSede(this.getElencoTipoSede());
		result.setRownum(ListUtils.getMaxRowNumListaSedi(sedi)+1);
		return result;
	}

	public Albo getAlbo(int i) {
		Albo result = new Albo();
		result.setIdAlbo(i);
		switch (i) {
		case 1:
			result.setDsAlbo("Regione Piemonte");
			result.setDsAlboEstesa("Albo imprese forestali del Piemonte");
			break;
		case 2:
			result.setDsAlbo("Regione Liguria");
			result.setDsAlboEstesa("Albo imprese forestali della Liguria");
			break;
		case 3:
			result.setDsAlbo("Regione Valle d'Aosta");
			result.setDsAlboEstesa("Albo imprese forestali della Valle d'Aosta");
			break;
		case 4:
			result.setDsAlbo("Rhône Alpes");
			result.setDsAlboEstesa("Albo imprese forestali della Rhône Alpes");
			break;
		case 5:
			result.setDsAlbo("Provence Alpes Côte d'Azur");
			result.setDsAlboEstesa("Albo imprese forestali della Provence Alpes Côte d'Azur");
			break;
		default:
			break;
		}
		result.setCssAlbo("logoAlbo"+i);
		return result;
	}

	public ArrayList<CategoriaImpresa> getElencoCategorieImpresa() {
		ArrayList<CategoriaImpresa> result = new ArrayList<CategoriaImpresa>();
		
		CategoriaImpresa catUno = new CategoriaImpresa();
		catUno.setIdCategoria(1);
		catUno.setDsCategoria("Categoria I");
		catUno.setNomeCategoria("Imprese e ditte di utilizzazione forestale");
		catUno.setAltroVisibile(false);
		result.add(catUno);
		
		CategoriaImpresa catDue = new CategoriaImpresa();
		catDue.setIdCategoria(2);
		catDue.setDsCategoria("Categoria II");
		catDue.setNomeCategoria("Imprese agricole");
		catDue.setAltroVisibile(false);
		result.add(catDue);
		
		CategoriaImpresa catTre = new CategoriaImpresa();
		catTre.setIdCategoria(3);
		catTre.setDsCategoria("Categoria III");
		catTre.setNomeCategoria("Imprese e ditte di commercializzazione e vendita del legno e dei prodotti di prima trasformazione");
		catTre.setAltroVisibile(false);
		result.add(catTre);
		
		CategoriaImpresa catQuattro = new CategoriaImpresa();
		catQuattro.setIdCategoria(4);
		catQuattro.setDsCategoria("Categoria IV");
		catQuattro.setNomeCategoria("Imprese e ditte di di prima trasformazione del legno");
		catQuattro.setAltroVisibile(false);
		result.add(catQuattro);
		
		CategoriaImpresa catCinque = new CategoriaImpresa();
		catCinque.setIdCategoria(5);
		catCinque.setDsCategoria("Categoria V");
		catCinque.setNomeCategoria("Imprese o ditte, anche individuali, che...");
		catCinque.setAltroVisibile(true);
		result.add(catCinque);
		
		return result;
	}

	public Albo addNuovoAlbo(ArrayList<Albo> appDataelencoAltriAlbi) {
		Albo result = new Albo();
		result.setRownum(ListUtils.getMaxRowNumListaAlbi(appDataelencoAltriAlbi)+1);
		return result;
	}
	
	public ArrayList<Certificazione> getElencoCertificazioni(){
		ArrayList<Certificazione> result = new ArrayList<Certificazione>();
		Certificazione uno = new Certificazione();
		uno.setIdCertificazione(1);
		uno.setDsTipoCertificazione("Certificazione Uno");
		uno.setNumero("6789");
		uno.setEnteCertificatore("Ente di prova");
		uno.setAnnoRilascio("2017");
		uno.setDataScadenza("01/01/2020");
		uno.setRownum(1);
		uno.setElencoTipoCertificazione(this.getElencoTipoCertificazioni());
		uno.setIdTipoCertificazione(1);
		result.add(uno);
		return result;
	}
	
	public Certificazione addNuovaCertificazione(ArrayList<Certificazione> appDataelencoCertificazioni) {
		Certificazione result = new Certificazione();
		result.setElencoTipoCertificazione(this.getElencoTipoCertificazioni());
		result.setRownum(ListUtils.getMaxRowNumListaCertificazioni(appDataelencoCertificazioni)+1);
		return result;
	}
	
	
	public ArrayList<CodeDescription> getElencoTipoCertificazioni(){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription cdUno = new CodeDescription();
		cdUno.setCode("1");
		cdUno.setDescription("Certificazione Uno");
		result.add(cdUno);
		
		CodeDescription cdDue = new CodeDescription();
		cdDue.setCode("2");
		cdDue.setDescription("Certificazione Due");
		result.add(cdDue);
		
		return result;
	}

	public ArrayList<FormaOrganizzativa> getElencoFormeOrganizzative() {
		ArrayList<FormaOrganizzativa> result = new ArrayList<FormaOrganizzativa>();
		FormaOrganizzativa uno = new FormaOrganizzativa();
		uno.setIdFormaOrganizzativa(1);
		uno.setDsFormaOrganizzativa("AREB");
		uno.setAltroVisibile(false);
		uno.setRownum(1);
		result.add(uno);
		
		FormaOrganizzativa due = new FormaOrganizzativa();
		due.setIdFormaOrganizzativa(2);
		due.setDsFormaOrganizzativa("Confagricoltura");
		due.setAltroVisibile(false);
		due.setRownum(2);
		result.add(due);
		
		FormaOrganizzativa tre = new FormaOrganizzativa();
		tre.setIdFormaOrganizzativa(3);
		tre.setDsFormaOrganizzativa("Coldiretti");
		tre.setAltroVisibile(false);
		tre.setRownum(3);
		result.add(tre);
		
		FormaOrganizzativa quattro = new FormaOrganizzativa();
		quattro.setIdFormaOrganizzativa(4);
		quattro.setDsFormaOrganizzativa("C.I.A.");
		quattro.setAltroVisibile(false);
		quattro.setRownum(4);
		result.add(quattro);
		
		FormaOrganizzativa cinque= new FormaOrganizzativa();
		cinque.setIdFormaOrganizzativa(5);
		cinque.setDsFormaOrganizzativa("Associazione artigiana");
		cinque.setAltroVisibile(true);
		cinque.setAltro("Prova testo libero");
		cinque.setRownum(5);
		result.add(cinque);
		
		FormaOrganizzativa sei = new FormaOrganizzativa();
		sei.setIdFormaOrganizzativa(6);
		sei.setDsFormaOrganizzativa("Consorzio");
		sei.setAltroVisibile(true);
		sei.setRownum(6);
		result.add(sei);
		
		FormaOrganizzativa sette = new FormaOrganizzativa();
		sette.setIdFormaOrganizzativa(7);
		sette.setDsFormaOrganizzativa("Altro");
		sette.setAltroVisibile(true);
		sette.setRownum(7);
		result.add(sette);
		
		return result;
	}

	public ArrayList<Albo> getElencoAltriAlbi() {
		ArrayList<Albo> result = new ArrayList<Albo>();
		Albo uno = new Albo();
		uno.setIdAlbo(1);
		uno.setDenominazione("Albo numero uno");
		uno.setNumeroAlbo("123");
		uno.setDataIscrizione("20/10/2014");
		uno.setRownum(1);
		result.add(uno);
		
		return result;
	}

	public LavoroPA addNuovoLavoroPA(ArrayList<LavoroPA> list) {
		LavoroPA result = new LavoroPA();
		result.setRownum(ListUtils.getMaxRowNumListaLavoriPA(list)+1);
		result.setElencoOggettiIntervento(getGenericList(3));
		return result;
	}

	public LegnameAssortimentoTrattato addNuovoLegname(
			ArrayList<LegnameAssortimentoTrattato> list) {
		LegnameAssortimentoTrattato result = new LegnameAssortimentoTrattato();
		result.setRownum(ListUtils.getMaxRowNumListaLegnami(list)+1);
		result.setElencoAssortimenti(getGenericList(3));
		result.setElencoDestinazioni(getGenericList(4));
		result.setElencoProvenienze(getGenericList(8));
		result.setElencoSpecie(getGenericList(3));
		result.setElencoTA(getGenericList(9));
		result.setElencoUnitaMisura(getGenericList(3));
		result.setVolumeVendutoMedioAnnuo("1234");
		//result.setElencoVendutiMedioAnnuo(getGenericList(15));
		return result;
	}
	
	public ArrayList<LavoroPA> getElencoLavoriPA(){
		return new ArrayList<LavoroPA>();
	}
	
	public ArrayList<LegnameAssortimentoTrattato> getElencoLegnami(){
		return new ArrayList<LegnameAssortimentoTrattato>();
	}

	public ArrayList<Attivita> getElencoAttivitaUltimoAnno() {
		ArrayList<Attivita> result = new ArrayList<Attivita>();
		
		Attivita uno = new Attivita();
		uno.setIdAttivita(1);
		uno.setDsAttivita("1 - Tagli di utilizzazione in bosco e/o pioppeto, Tagli intercalari (cure colturali, ripuliture, sfolli , diradamenti) e difesa fitosanitaria");
		uno.setAltroVisibile(false);
		uno.setIconaDettaglioVisibile(true);
		uno.setFatturato("33");
		uno.setRownum(1);
		result.add(uno);
		
		Attivita due = new Attivita();
		due.setIdAttivita(2);
		due.setDsAttivita("2 – Rimboschimenti ed imboschimenti");
		due.setAltroVisibile(false);
		due.setIconaDettaglioVisibile(true);
		due.setFatturato("76");
		due.setRownum(2);
		result.add(due);
		
		Attivita tre = new Attivita();
		tre.setIdAttivita(3);
		tre.setDsAttivita("3 – Viabilità forestale");
		tre.setAltroVisibile(false);
		tre.setIconaDettaglioVisibile(true);
		tre.setFatturato("5");
		tre.setRownum(3);
		result.add(tre);
		
		Attivita quattro = new Attivita();
		quattro.setIdAttivita(4);
		quattro.setDsAttivita("4 – Vivaistica forestale");
		quattro.setAltroVisibile(false);
		quattro.setIconaDettaglioVisibile(true);
		quattro.setFatturato("87");
		quattro.setRownum(4);
		result.add(quattro);
		
		Attivita cinque = new Attivita();
		cinque.setIdAttivita(5);
		cinque.setDsAttivita("5 – Arboricoltura da legno");
		cinque.setAltroVisibile(false);
		cinque.setIconaDettaglioVisibile(true);
		cinque.setFatturato("123");
		cinque.setRownum(5);
		result.add(cinque);
		
		Attivita sei = new Attivita();
		sei.setIdAttivita(6);
		sei.setDsAttivita("6 – Gestione del verde arboreo (escluso quello urbano, potature)");
		sei.setAltroVisibile(false);
		sei.setIconaDettaglioVisibile(false);
		sei.setFatturato("333");
		sei.setRownum(6);
		result.add(sei);
		
		Attivita sette = new Attivita();
		sette.setIdAttivita(7);
		sette.setDsAttivita("7 – Sistemazioni idraulico forestali eseguite con tecniche di ingegneria naturalistica");
		sette.setAltroVisibile(false);
		sette.setIconaDettaglioVisibile(false);
		sette.setFatturato("222");
		sette.setRownum(7);
		result.add(sette);
		
		Attivita otto = new Attivita();
		otto.setIdAttivita(8);
		otto.setDsAttivita("8 – altre attività forestali (specificare)");
		otto.setAltroVisibile(true);
		otto.setIconaDettaglioVisibile(false);
		otto.setFatturato("234");
		otto.setRownum(8);
		result.add(otto);
		
		Attivita nove = new Attivita();
		nove.setIdAttivita(9);
		nove.setDsAttivita("9 - Altre attività non forestali (es. tutte le attività agricole non comprese nei punti precedenti, artigianato, edilizia, gestione del verde urbano, altro)");
		nove.setAltroVisibile(false);
		nove.setIconaDettaglioVisibile(false);
		nove.setFatturato("10");
		nove.setRownum(9);
		result.add(nove);
		
		return result;
	}

	public ArrayList<MaterialePropagazione> getElencoMaterialiPropagazione() {
		ArrayList<MaterialePropagazione> result = new ArrayList<MaterialePropagazione>();
		
		MaterialePropagazione uno = new MaterialePropagazione();
		uno.setIdMaterialePropagazione(1);
		uno.setDsMaterialePropagazione("Pioppelle");
		uno.setAltroVisibile(false);
		result.add(uno);
		
		MaterialePropagazione due = new MaterialePropagazione();
		due.setIdMaterialePropagazione(2);
		due.setDsMaterialePropagazione("Astoni");
		due.setAltroVisibile(false);
		result.add(due);
		
		MaterialePropagazione tre = new MaterialePropagazione();
		tre.setIdMaterialePropagazione(3);
		tre.setDsMaterialePropagazione("Talee");
		tre.setAltroVisibile(false);
		result.add(tre);
		
		MaterialePropagazione quattro = new MaterialePropagazione();
		quattro.setIdMaterialePropagazione(4);
		quattro.setDsMaterialePropagazione("Specie forestali");
		quattro.setAltroVisibile(false);
		result.add(quattro);
		
		MaterialePropagazione cinque = new MaterialePropagazione();
		cinque.setIdMaterialePropagazione(5);
		cinque.setDsMaterialePropagazione("Latifoglie di pregio");
		cinque.setAltroVisibile(false);
		result.add(cinque);
		
		MaterialePropagazione sei = new MaterialePropagazione();
		sei.setIdMaterialePropagazione(6);
		sei.setDsMaterialePropagazione("Altro");
		sei.setAltroVisibile(true);
		result.add(sei);
		
		return result;
	}
	
	public ArrayList<ArboricolturaDaLegno> getElencoArboricolturaDaLegno(){
		ArrayList<ArboricolturaDaLegno> result = new ArrayList<ArboricolturaDaLegno>();
		
		ArboricolturaDaLegno uno = new ArboricolturaDaLegno();
		uno.setIdArboricolturaDaLegno(1);
		uno.setAltro("Pioppeti");
		uno.setAltroVisibile(false);
		uno.setRownum(1);
		uno.setIconaCancellaVisibile(false);
		result.add(uno);
		
		ArboricolturaDaLegno due = new ArboricolturaDaLegno();
		due.setIdArboricolturaDaLegno(2);
		due.setAltro("");
		due.setAltroVisibile(true);
		due.setIconaCancellaVisibile(true);
		result.add(due);
		
		return result;
	}

	public ArboricolturaDaLegno addNuovaArboricolturaDaLegno(ArrayList<ArboricolturaDaLegno> appDataelencoArboricolturaDaLegno) {
		ArboricolturaDaLegno result = new ArboricolturaDaLegno();
		result.setAltro("");
		result.setAltroVisibile(true);
		result.setIconaCancellaVisibile(true);
		result.setRownum(ListUtils.getMaxRowNumListaArboricolturaDaLegno(appDataelencoArboricolturaDaLegno)+1);
		
		return result;
	}

	public Capannone addNuovoCapannone(ArrayList<Capannone> appDataelencoCapannoni) {
		Capannone result = new Capannone();
		result.setRownum(ListUtils.getMaxRowNumListaCapannoni(appDataelencoCapannoni)+1);
		return result;
	}

	public PiazzaleStoccaggio addNuovoPiazzaleStoccaggio(
			ArrayList<PiazzaleStoccaggio> appDataelencoPiazzaliStoccaggio) {
		PiazzaleStoccaggio result = new PiazzaleStoccaggio();
		result.setRownum(ListUtils.getMaxRowNumListaPiazzaliStoccaggio(appDataelencoPiazzaliStoccaggio)+1);
		return result;
	}

	public ArrayList<Capannone> getElencoCapannoni() {
		ArrayList<Capannone> result = new ArrayList<Capannone>();
		
		Capannone uno = new Capannone();
		uno.setIdCapannone(1);
		uno.setFunzioneCapannone("Funzione 1");
		uno.setDimensioneCapannone("150");
		uno.setAnnoCostruzioneORiattamentoCapannone("1991");
		uno.setRownum(1);
		result.add(uno);
		
		Capannone due = new Capannone();
		due.setIdCapannone(1);
		due.setFunzioneCapannone("Funzione 2");
		due.setDimensioneCapannone("200");
		due.setAnnoCostruzioneORiattamentoCapannone("1998");
		due.setRownum(2);
		result.add(due);
		
		return result;
	}

	public ArrayList<PiazzaleStoccaggio> getElencoPiazzaliStoccaggio() {
		ArrayList<PiazzaleStoccaggio> result = new ArrayList<PiazzaleStoccaggio>();
		
		PiazzaleStoccaggio uno = new PiazzaleStoccaggio();
		uno.setIdPiazzaleStoccaggio(1);
		uno.setDimensionePiazzale("166");
		uno.setAnnoCostruzioneORiattamentoPiazzale("1980");
		uno.setRownum(1);
		result.add(uno);
				
		return result;
	}

	public ArrayList<MezzoDiProtezioneIndividuale> getElencoCaschiForestali() {
		ArrayList<MezzoDiProtezioneIndividuale> result = new ArrayList<MezzoDiProtezioneIndividuale>();
		MezzoDiProtezioneIndividuale uno  = new MezzoDiProtezioneIndividuale();
		uno.setIdTipoMezzoDiProtezioneIndividuale(1);
		uno.setElencoTipoMezzoDiProtezioneIndividuale(this.getGenericList(3));
		uno.setQuantita("4");
		uno.setAnnoScadenza("2020");
		uno.setRownum(1);
		result.add(uno);
		
		return result;
	}

	public ArrayList<MezzoDiProtezioneIndividuale> getElencoScarponiRinforzati() {
		ArrayList<MezzoDiProtezioneIndividuale> result = new ArrayList<MezzoDiProtezioneIndividuale>();
		MezzoDiProtezioneIndividuale uno  = new MezzoDiProtezioneIndividuale();
		uno.setIdTipoMezzoDiProtezioneIndividuale(4);
		uno.setElencoTipoMezzoDiProtezioneIndividuale(this.getGenericList(5));
		uno.setQuantita("1");
		uno.setAnnoScadenza("2032");
		uno.setRownum(1);
		result.add(uno);
		
		return result;
	}

	public ArrayList<MezzoDiProtezioneIndividuale> getElencoPantaloniAntitaglio() {
		ArrayList<MezzoDiProtezioneIndividuale> result = new ArrayList<MezzoDiProtezioneIndividuale>();
		MezzoDiProtezioneIndividuale uno  = new MezzoDiProtezioneIndividuale();
		uno.setIdTipoMezzoDiProtezioneIndividuale(2);
		uno.setElencoTipoMezzoDiProtezioneIndividuale(this.getGenericList(2));
		uno.setQuantita("5");
		uno.setAnnoScadenza("2019");
		uno.setRownum(1);
		result.add(uno);
		
		MezzoDiProtezioneIndividuale due  = new MezzoDiProtezioneIndividuale();
		due.setIdTipoMezzoDiProtezioneIndividuale(1);
		due.setElencoTipoMezzoDiProtezioneIndividuale(this.getGenericList(2));
		due.setQuantita("2");
		due.setAnnoScadenza("2022");
		due.setRownum(2);
		result.add(due);
		
		return result;
	}

	public MezzoDiProtezioneIndividuale addNuovoScarponeRinforzato(
			ArrayList<MezzoDiProtezioneIndividuale> list) {
		MezzoDiProtezioneIndividuale result = new MezzoDiProtezioneIndividuale();
		result.setRownum(ListUtils.getMaxRowNumListaMezziDiProtezioneIndividuale(list)+1);
		result.setElencoTipoMezzoDiProtezioneIndividuale(this.getGenericList(5));
		return result;
	}

	public MezzoDiProtezioneIndividuale addNuovoPantaloneAntitaglio(
			ArrayList<MezzoDiProtezioneIndividuale> list) {
		MezzoDiProtezioneIndividuale result = new MezzoDiProtezioneIndividuale();
		result.setRownum(ListUtils.getMaxRowNumListaMezziDiProtezioneIndividuale(list)+1);
		result.setElencoTipoMezzoDiProtezioneIndividuale(this.getGenericList(2));
		return result;
	}

	public MezzoDiProtezioneIndividuale addNuovoCascoForestale(
			ArrayList<MezzoDiProtezioneIndividuale> list) {
		MezzoDiProtezioneIndividuale result = new MezzoDiProtezioneIndividuale();
		result.setRownum(ListUtils.getMaxRowNumListaMezziDiProtezioneIndividuale(list)+1);
		result.setElencoTipoMezzoDiProtezioneIndividuale(this.getGenericList(3));
		return result;
	}

	public ArrayList<MacchinaMezzo> getElencoMacchineTrattrici() {
		ArrayList<MacchinaMezzo> result = new ArrayList<MacchinaMezzo>();
		
		MacchinaMezzo uno = new MacchinaMezzo();
		uno.setAnnoImmatricolazione("2000");
		uno.setPotenza("1220");
		uno.setElencoTipoTrazione(getGenericList(3));
		uno.setIdTipoTrazione(2);
		uno.setElencoTipoNoleggio(getGenericList(7));
		uno.setIdTipoNoleggio(5);
		result.add(uno);
		
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaTratttice(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoTrazione(getGenericList(3));
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaSpeciale(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoMacchinaMezzo(getGenericList(8));
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public ArrayList<MacchinaMezzo> getElencoMacchineSpeciali() {
		ArrayList<MacchinaMezzo> result = new ArrayList<MacchinaMezzo>();
		
		MacchinaMezzo uno = new MacchinaMezzo();
		uno.setAnnoImmatricolazione("2004");
		uno.setPotenza("222");
		uno.setElencoTipoMacchinaMezzo(getGenericList(8));
		uno.setIdTipoMacchinaMezzo(4);
		uno.setElencoTipoNoleggio(getGenericList(7));
		uno.setIdTipoNoleggio(5);
		result.add(uno);
		
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaCippatrice(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoAlimentazione(this.getGenericList(8));
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaGruACavo(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoMacchinaMezzo(getGenericList(5));
		result.setElencoTipoCarrello(this.getGenericList(2));
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaMovimentoTerra(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoAlimentazione(this.getGenericList(8));
		result.setElencoTipoNoleggio(this.getGenericList(7));
		result.setElencoTipoTrazione(this.getGenericList(6));
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaPle(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaRimorchi(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoNoleggio(this.getGenericList(7));
		result.setElencoTipoTrazione(this.getGenericList(6));
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaSegheriaMobile(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoMacchinaMezzo(getGenericList(5));
		result.setElencoTipoAlimentazione(this.getGenericList(8));
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaTrinciaForestale(
			ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public MacchinaMezzo addNuovaMacchinaVerricello(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public MacchinaMezzo addNuovoMezzoDiTrasporto(ArrayList<MacchinaMezzo> list) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(ListUtils.getMaxRowNumListaMacchinaMezzo(list)+1);
		result.setElencoTipoMacchinaMezzo(getGenericList(5));
		result.setElencoTipoNoleggio(this.getGenericList(7));
		return result;
	}

	public Personale addNuovoPersonale(ArrayList<Personale> list) {
		Personale result = new Personale();
		result.setRownum(ListUtils.getMaxRowNumListaPersonale(list)+1);
		result.setCodiceFiscaleEditabile(true);
		result.setCognomeEditabile(true);
		result.setNomeEditabile(true);
		result.setElencoContratti(this.getGenericList(2));
		result.setElencoDurateContratto(this.getGenericList(5));
		result.setElencoInquadramenti(this.getGenericList(4));
		result.setElencoMansioni(this.getGenericList(8));
		result.setElencoTipologiaPersonale(this.getGenericList(3));
		return result;
	}

	public ArrayList<CodeDescription> getElencoAlbi() {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		CodeDescription uno = new CodeDescription();
		uno.setCode("1");
		uno.setDescription("Piemonte");
		result.add(uno);
	
		
		CodeDescription due = new CodeDescription();
		due.setCode("2");
		due.setDescription("Liguria");
		result.add(due);
		
		CodeDescription tre = new CodeDescription();
		tre.setCode("3");
		tre.setDescription("VdA");
		result.add(tre);
		
		CodeDescription quattro = new CodeDescription();
		quattro.setCode("4");
		quattro.setDescription("Rhones Alpes");
		result.add(quattro);
		
		CodeDescription cinque = new CodeDescription();
		cinque.setCode("5");
		cinque.setDescription("PACdA");
		result.add(cinque);
		
		return result;
	}

	public ArrayList<CodeDescription> getElencoSottostati() {
		return getGenericList(7);
	}

	public ArrayList<CodeDescription> getElencoSezioni() {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription uno = new CodeDescription();
		uno.setCode("1");
		uno.setDescription("A");
		result.add(uno);
		
		CodeDescription due = new CodeDescription();
		due.setCode("2");
		due.setDescription("B");
		result.add(due);
		
		return result;
	}

	public ArrayList<CodeDescription> getElencoCategorieImpresaRicerca() {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription uno = new CodeDescription();
		uno.setCode("1");
		uno.setDescription("I");
		result.add(uno);
		
		CodeDescription due = new CodeDescription();
		due.setCode("2");
		due.setDescription("II");
		result.add(due);
		
		CodeDescription tre = new CodeDescription();
		tre.setCode("3");
		tre.setDescription("III");
		result.add(tre);
		
		CodeDescription quattro = new CodeDescription();
		quattro.setCode("4");
		quattro.setDescription("IV");
		result.add(quattro);
		
		CodeDescription cinque = new CodeDescription();
		cinque.setCode("5");
		cinque.setDescription("V");
		result.add(cinque);
		
		return result;
	}

	public ArrayList<CodeDescription> getElencoAssociazioniCertificazioni() {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription uno = new CodeDescription();
		uno.setCode("1");
		uno.setDescription("Altri albi");
		result.add(uno);
		
		CodeDescription due = new CodeDescription();
		due.setCode("2");
		due.setDescription("Certificazioni");
		result.add(due);
		
		return result;
	}

	public ArrayList<CodeDescription> getElencoAttivitaSvolte() {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription uno = new CodeDescription();
		uno.setCode("1");
		uno.setDescription("1 - Tagli di utilizzazione in bosco e/o pioppeto, Tagli intercalari e difesa fitosanitaria");
		result.add(uno);
		
		CodeDescription due = new CodeDescription();
		due.setCode("2");
		due.setDescription("2 - Rimboschimenti ed imboschimenti");
		result.add(due);
		
		CodeDescription tre = new CodeDescription();
		tre.setCode("3");
		tre.setDescription("3 - Viabilità forestale");
		result.add(tre);
		
		CodeDescription quattro = new CodeDescription();
		quattro.setCode("4");
		quattro.setDescription("4 - Vivaistica");
		result.add(quattro);
		
		CodeDescription cinque = new CodeDescription();
		cinque.setCode("5");
		cinque.setDescription("5 - Arboricoltura da legno");
		result.add(cinque);
		
		CodeDescription sei = new CodeDescription();
		sei.setCode("6");
		sei.setDescription("6 - Gestione del verde arboreo (escluso quello urbano, potature)");
		result.add(sei);
		
		CodeDescription sette = new CodeDescription();
		sette.setCode("7");
		sette.setDescription("7 - Sistemazioni idraulico forestali eseguite con tecniche di ingegneria naturalistica");
		result.add(sette);
		
		CodeDescription otto = new CodeDescription();
		otto.setCode("8");
		otto.setDescription("8 - Altre attività forestali");
		result.add(otto);
		
		CodeDescription nove = new CodeDescription();
		nove.setCode("9");
		nove.setDescription("9 - Altre attività non forestali");
		result.add(nove);
		
		return result;
	}

	public ArrayList<Azienda> ricercaAziende() {
		ArrayList<Azienda> result = new ArrayList<Azienda>();
		
		Azienda uno = new Azienda();
		uno.setIdAzienda(1);
		uno.setIdAlbo(1);
		uno.setDsAlbo("Regione Piemonte");
		uno.setNumeroAlbo("12345");
		uno.setCodiceFiscale("FSRNRC77H14L219V");
		uno.setDenominazione("Azienda di prova 1");
		uno.setTitolare("Mario Rossi");
		uno.setComune("Torino");
		uno.setIdStato(2);
		uno.setDsStato("Presa in carico");
		result.add(uno);
		
		Azienda due = new Azienda();
		due.setIdAzienda(2);
		due.setIdAlbo(2);
		due.setDsAlbo("Regione Liguria");
		due.setNumeroAlbo("789");
		due.setCodiceFiscale("FSRNRC77H14L219C");
		due.setDenominazione("Azienda di prova 2");
		due.setTitolare("Carlo Verdi");
		due.setComune("Grugliasco");
		due.setIdStato(1);
		due.setDsStato("Bozza");
		result.add(due);
		
		Azienda tre = new Azienda();
		tre.setIdAzienda(3);
		tre.setIdAlbo(1);
		tre.setDsAlbo("Regione Piemonte");
		tre.setNumeroAlbo("45698");
		tre.setCodiceFiscale("FSRNRC77H14L219X");
		tre.setDenominazione("Azienda di prova 3");
		tre.setTitolare("Luca Bianchi");
		tre.setComune("Torino");
		tre.setIdStato(3);
		tre.setDsStato("Iscritta");
		result.add(tre);
		
		Azienda quattro = new Azienda();
		quattro.setIdAzienda(4);
		quattro.setIdAlbo(3);
		quattro.setDsAlbo("Regione Valle d'Aosta");
		quattro.setNumeroAlbo("98745");
		quattro.setCodiceFiscale("FSRNRC77H14L219T");
		quattro.setDenominazione("Azienda di prova 4");
		quattro.setTitolare("Franco Nero");
		quattro.setComune("Collegno");
		quattro.setIdStato(1);
		quattro.setDsStato("Bozza");
		result.add(quattro);
		
		return result;
	}
	
	public ArrayList<CodeDescription> getElencoStatiDomanda(){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		
		CodeDescription cdUno = new CodeDescription();
		cdUno.setCode("1");
		cdUno.setDescription("Inviata");
		result.add(cdUno);
		
		CodeDescription cdDue = new CodeDescription();
		cdDue.setCode("2");
		cdDue.setDescription("Presa in carico");
		result.add(cdDue);
		
		CodeDescription cdTre = new CodeDescription();
		cdTre.setCode("3");
		cdTre.setDescription("Accettata");
		result.add(cdTre);
		
		CodeDescription cdQuattro = new CodeDescription();
		cdQuattro.setCode("4");
		cdQuattro.setDescription("Respinta");
		result.add(cdQuattro);
		
		CodeDescription cdCinque = new CodeDescription();
		cdQuattro.setCode("5");
		cdQuattro.setDescription("Bozza");
		result.add(cdCinque);
		
		return result;
	}

	public ArrayList<AziendaAAEP> getElencoAziendeAAEP() {
		ArrayList<AziendaAAEP> result = new ArrayList<AziendaAAEP>();
		
		AziendaAAEP aziendaUno = new AziendaAAEP();
		aziendaUno.setCodiceFiscale("FSRNRC77H14L219V");
		aziendaUno.setCodiceAteco("COD ATECO PROVA 1");
		aziendaUno.setDescrizioneAteco("DESCRIZIONE AtecoS AAEP NUMERO UNO");
		aziendaUno.setRagioneSociale("AZIENDA DI PROVA AAEP NUMERO UNO");
		
		result.add(aziendaUno);	
		return result;
	} 
}
