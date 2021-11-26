/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager;

import java.util.ArrayList;

import it.csi.taif.topforweb.dto.common.CodeDescription;
import it.csi.taif.topforweb.util.ListUtils;


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
}
