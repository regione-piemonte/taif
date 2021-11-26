/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.model.view.domain.helper.view;



import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.dto.domanda.Capannone;
import it.csi.taif.taifweb.dto.domanda.CpDomandaModel;
import it.csi.taif.taifweb.dto.domanda.LavoroPA;
import it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato;
import it.csi.taif.taifweb.dto.domanda.Personale;
import it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio;
import it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale;
import it.csi.taif.taifweb.presentation.model.view.helper.AbstractViewHelper;
import it.csi.taif.taifweb.presentation.model.view.helper.ConfigVisibility;
import it.csi.taif.taifweb.presentation.model.view.helper.ViewOperationEnum;
import it.csi.taif.taifweb.presentation.model.view.state.ElementState;
import it.csi.taif.taifweb.presentation.model.view.state.ViewState;
import it.csi.taif.taifweb.presentation.taifweb.action.CommandExecutionException;
import it.csi.taif.taifweb.util.Constants;

public final class DomandaViewHelper extends AbstractViewHelper {
    
    public final static String CPNAME = "cpDomanda";
    public final static String DOMANDA_VIEW_STATE = "DOMANDA_VIEW_STATE";

    final static String FILE_PROPERTIES_NAME = "visibility-cp_domanda.properties";
    protected static final Logger log =  
			Logger.getLogger(Constants.APPLICATION_CODE + ".presentation.model.view.domain.helper.view"); 
    public static void updateView(CpDomandaModel theModel, String cpName) throws Exception {
        final ViewState vs = getViewState(theModel);

        final Collection<ElementState> values = vs.getViewState();
        for (ElementState value : values) {
            updateView(theModel, cpName, value);
        } 
    }
    
    public static void updateView(CpDomandaModel theModel, String cpName, ConfigVisibility config) throws CommandExecutionException  {
        if(config!=null)AbstractViewHelper.updateView(theModel, cpName, config);    
    }

    public static ViewState getViewState(CpDomandaModel theModel) {
        return getViewState(theModel, DOMANDA_VIEW_STATE);
    }

    
    public static ConfigVisibility initScheda1_1(CpDomandaModel theModel) {
	
	String servizioAeep = (String) ActionContext.getContext().getSession().get("servizioAeep");
    	StringBuilder sb = new StringBuilder("1.1-");
    	
    	boolean isItalia = Constants.TRACCIATO_IT.equals(theModel.getAppDatatracciato());
    	
    	//Integer idProfilo = (Integer)ActionContext.getContext().getSession().get("idProfilo");
    	Integer idProfilo = Integer.parseInt(theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo());
    	
	if (theModel.getAppDataidAzienda() == null) {
	    sb.append("I-");
	} else {
	    if(servizioAeep != null) {
		if(servizioAeep.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.SI)) {
			sb.append("I-");
		}
	    }else{
		  sb.append("M-");
	    }
	  
	}
    	
        sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        if(servizioAeep != null) {
        if(servizioAeep.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.SI))
            {
                config.getActivate().add("mpDatiAnagraficiSedi.fpDatiAnagraficiSedi"); 
                config.getShow().add("fpDatiAnagraficiSedi"); 
                //CpDomanda_mpDatiAnagraficiSedi_fpDatiAnagraficiSedi
            }
        }
        if(theModel.getAppDataalbo() != null) {
            if(theModel.getAppDataalbo().getIdAlbo()==3) {
            	config.getDeactivate().add("mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo");
            }
        }
        
        if(isItalia && (theModel.getAppDataalbo().getIdAlbo() == 1) ) {
        	if(idProfilo==1) {
        	    config.getHide().add("btnCercaAnagraficaAziendaAeep");
        	}else {
        	    config.getShow().add("btnCercaAnagraficaAziendaAeep");
        	}
    } 
    return config;
    }

    public static ConfigVisibility initScheda1_2(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("1.2-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        
        boolean isItalia = Constants.TRACCIATO_IT.equals(theModel.getAppDatatracciato());
        
        Integer idProfilo = (Integer)ActionContext.getContext().getSession().get("idProfilo");
        TitolareRappresentanteLegale trl = theModel.getAppDatatitolareRappresentanteLegale();
        //TAIF-23
        if(trl!=null) {
        	String idStatoNascita = theModel.getAppDatatitolareRappresentanteLegale().getIdStatoNascita();
        	if(idStatoNascita!=null && !idStatoNascita.equalsIgnoreCase(Constants.ID_STATO_ITALIA)) {
        		log.info("[DomandaViewHelper::initScheda1_2] TITOLARE MOSTRA COMUNE NASCITA ESTERO");
            	config.getShow().add("tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta");
            	config.getHide().add("cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita");
        	}else {
        		log.info("[DomandaViewHelper::initScheda1_2] TITOLARE MOSTRA COMUNE NASCITA ITA");
        		config.getShow().add("cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita");
            	config.getHide().add("tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta");
            }
        	
        	TitolareRappresentanteLegale conduttore = theModel.getAppDataaltroTitolareRappresentanteLegale();

        	visibilityConduttore(conduttore, config);
        } else {
        	log.info("[DomandaViewHelper::initScheda1_2] TITOLARE NULL: MOSTRA COMUNE NASCITA ITA TITOLARE E CONDUTTORE ");
        	config.getShow().add("cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita");
        	config.getHide().add("tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta");
        	config.getShow().add("cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita");
        	config.getHide().add("tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta");
        }
        	
       
        	
        if(isItalia) {
        	config.getHide().add("btnCercaTitolareAnagraficaFr");
        	if(idProfilo==1) {
        	    config.getHide().add("btnCercaTitolareAnagrafica");
        	    config.getDeactivate().add("wpDatiAnagraficiTitolareRappresentanteLegale.tfDatiAnagraficiTitolareRappresentanteLegaleCognome");
        	    config.getDeactivate().add("wpDatiAnagraficiTitolareRappresentanteLegale.tfDatiAnagraficiTitolareRappresentanteLegaleNome");
        	  
        	}else {
        	    config.getShow().add("btnCercaTitolareAnagrafica");
        	    config.getActivate().add("wpDatiAnagraficiTitolareRappresentanteLegale.tfDatiAnagraficiTitolareRappresentanteLegaleCognome");
        	    config.getActivate().add("wpDatiAnagraficiTitolareRappresentanteLegale.tfDatiAnagraficiTitolareRappresentanteLegaleNome");
        	}
        } else {
        	
        	config.getHide().add("btnCercaTitolareAnagrafica");
        	if(idProfilo==1) {
        	    config.getHide().add("btnCercaTitolareAnagraficaFr");  
        	}else {
        	    config.getShow().add("btnCercaTitolareAnagraficaFr");
        	}
        }
        
        
        return config;
    }
    
    public static ConfigVisibility initConduttoreScheda1_2(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("1.2-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        
        	TitolareRappresentanteLegale conduttore = theModel.getAppDataaltroTitolareRappresentanteLegale();
            visibilityConduttore(conduttore, config);

        
        return config;
    }
    
    public static void visibilityConduttore(TitolareRappresentanteLegale conduttore, ConfigVisibility config) {
    	if(conduttore!=null) {
        	String idStatoNascitaConduttore = conduttore.getIdStatoNascita();
        	if( idStatoNascitaConduttore!=null && !idStatoNascitaConduttore.equalsIgnoreCase(Constants.ID_STATO_ITALIA)) {
        		log.info("[DomandaViewHelper::visibilityConduttore] CONDUTTORE MOSTRA COMUNE NASCITA ESTERO");
        		config.getShow().add("tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta");
            	config.getHide().add("cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita");
        		
        	}else {
        		log.info("[DomandaViewHelper::visibilityConduttore] CONDUTTORE MOSTRA COMUNE NASCITA ITA");
        		config.getShow().add("cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita");
            	config.getHide().add("tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta");
            }
    	} else {
    		log.info("[DomandaViewHelper::visibilityConduttore] CONDUTTORE NULL MOSTRA COMUNE NASCITA ITA");
    		config.getShow().add("cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita");
        	config.getHide().add("tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta");
        }
    }
    public static ConfigVisibility initScheda2_1(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("2.1-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
                
        return config;
    }
    
    public static ConfigVisibility initScheda2_2(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("2.2-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
                
        return config;
    }
    
    public static ConfigVisibility initScheda3_1(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("3.1-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        
//        if(Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
//        	if(theModel.getAppDataelencoAttivitaUltimoAnno()!=null && !theModel.getAppDataelencoAttivitaUltimoAnno().isEmpty()) {
//        		config.getActivate().add("mpAttivitaUltimoAnno1.fpAttivitaUltimoAnno1");
//        	}
//        	else {
//        		config.getDeactivate().add("mpAttivitaUltimoAnno1");
//        	}
//        }
                
//        else {
//        	
//        }
        
        return config;
    }
    
    public static ConfigVisibility initScheda3_2(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("3.2-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        
        boolean lavoriEmpty = true;
        
        if(Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
        	ArrayList<LavoroPA> lavori = theModel.getAppDataelencoLavoriPA();
        	if(lavori!=null && !lavori.isEmpty()){
        		if(lavori.size()>0 && lavori.get(0).getIdOggettoIntervento()!=0) {
        			lavoriEmpty = false;
        		}
        	}
        }
        
        
        if(lavoriEmpty) {
        	config.getDeactivate().add("mpAttivitaLavoriPA");
        }
        else {
        	config.getActivate().add("mpAttivitaLavoriPA.fpAttivitaLavoriPA");
        }
        return config;
    }
    
    public static ConfigVisibility initScheda3_3(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("3.3-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        
        boolean legnamiEmpty = true;
        
        ArrayList<LegnameAssortimentoTrattato> list = theModel.getAppDataelencoLegnamiAssortimentiTrattati();
        
        if(list!=null && !list.isEmpty()){
    		if(list.size()>0 && list.get(0).getIdAssortimento()!=0) {
    			legnamiEmpty = false;
    		}
    	}
        
        if(!legnamiEmpty) {
        	if(Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
        		config.getActivate().add("mpAttivitaLegname.fpAttivitaLegname");
        		config.getDeactivate().add("mpAttivitaLegnameFr");
        	}
        	else {
        		config.getActivate().add("mpAttivitaLegnameFr.fpAttivitaLegnameFr");
        		config.getDeactivate().add("mpAttivitaLegname");
        	}
        }
        else {
        	config.getDeactivate().add("mpAttivitaLegnameFr");
        	config.getDeactivate().add("mpAttivitaLegname");
        }
                
        return config;
    }
    
    public static ConfigVisibility initScheda4(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("4-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        ArrayList<Capannone> capannoni = theModel.getAppDataelencoCapannoni();
        ArrayList<PiazzaleStoccaggio> piazzali =theModel.getAppDataelencoPiazzaliStoccaggio();
        
        if(capannoni!=null&&capannoni.size()>0&&capannoni.get(0).getIdCapannone()!=0) {
        	config.getActivate().add("mpStruttureCapannoni.fpStruttureCapannoni");
        }
        else {
        	config.getDeactivate().add("mpStruttureCapannoni");
        }
        
        if(piazzali!=null&&piazzali.size()>0&&piazzali.get(0).getIdPiazzaleStoccaggio()!=0) {
        	config.getActivate().add("mpStrutturePiazzaliStoccaggio.fpStrutturePiazzaliStoccaggio");
        }
        else {
        	config.getDeactivate().add("mpStrutturePiazzaliStoccaggio");
        }
                
        return config;
    }
    
    public static ConfigVisibility initScheda5_1(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("5.1-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        
        if(Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
        	
        	config.getActivate().add("mpAttrezzatureIt.fpAttrezzatureIt");
        	
        	if(theModel.getAppDataelencoCaschiForestaliAttrezzature()!=null && 
        			theModel.getAppDataelencoCaschiForestaliAttrezzature().size()>0 &&
        			theModel.getAppDataelencoCaschiForestaliAttrezzature().get(0).getIdTipoMezzoDiProtezioneIndividuale()!=0) {
        		config.getActivate().add("mpAttrezzatureCascoForestale.fpAttrezzatureCascoForestale");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureCascoForestale");
        	}
        	
        	if(theModel.getAppDataelencoScarponiRinforzatiAttrezzature()!=null && 
        			theModel.getAppDataelencoScarponiRinforzatiAttrezzature().size()>0 &&
        			theModel.getAppDataelencoScarponiRinforzatiAttrezzature().get(0).getIdTipoMezzoDiProtezioneIndividuale()!=0) {
        		config.getActivate().add("mpAttrezzatureScarponiRinforzati.fpAttrezzatureScarponiRinforzati");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureScarponiRinforzati");
        	}
        	
        	if(theModel.getAppDataelencoPantaloniAntitaglioAttrezzature()!=null && 
        			theModel.getAppDataelencoPantaloniAntitaglioAttrezzature().size()>0 &&
        			theModel.getAppDataelencoPantaloniAntitaglioAttrezzature().get(0).getIdTipoMezzoDiProtezioneIndividuale()!=0) {
        		config.getActivate().add("mpAttrezzaturePantaloniAntitaglio.fpAttrezzaturePantaloniAntitaglio");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzaturePantaloniAntitaglio");
        	}
        	
        	
        	config.getDeactivate().add("mpAttrezzatureFr");
        }
        else {
        	config.getActivate().add("mpAttrezzatureFr.fpAttrezzatureFr");
        	config.getDeactivate().add("mpAttrezzatureIt");
        }
        
        return config;
    }
    
    public static ConfigVisibility initScheda5_2(CpDomandaModel theModel) {
    	StringBuilder sb = new StringBuilder("5.2-");
    	sb.append(theModel.getAppDatatracciato());
        
        final String key = sb.toString();
        ConfigVisibility config = getConfigVisibility(key);
        
        if(Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
        	if(theModel.getAppDataelencoMacchineTrattrici()!=null && !theModel.getAppDataelencoMacchineTrattrici().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineTrattrici.fpAttrezzatureMacchinaElencoTrattrici");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineTrattrici");
        	}
        	
        	if(theModel.getAppDataelencoMacchineSpeciali()!=null && !theModel.getAppDataelencoMacchineSpeciali().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineSpeciali.fpAttrezzatureMacchineSpeciali");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineSpeciali");
        	}
        	
        	if(theModel.getAppDataelencoMacchineMovimentoTerra()!=null && !theModel.getAppDataelencoMacchineMovimentoTerra().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineMovimentoATerra.fpAttrezzatureMacchineMovimentoATerra");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineMovimentoATerra");
        	}
        	
        	if(theModel.getAppDataelencoMacchineRimorchi()!=null && !theModel.getAppDataelencoMacchineRimorchi().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineRimorchi.fpAttrezzatureMacchinaElencoRimorchi");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineRimorchi");
        	}
        	
        	if(theModel.getAppDataelencoMacchineVerricelli()!=null && !theModel.getAppDataelencoMacchineVerricelli().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineVerricelli.fpAttrezzatureMacchinaElencoVerricelli");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineVerricelli");
        	}
        	
        	if(theModel.getAppDataelencoMacchinePle()!=null && !theModel.getAppDataelencoMacchinePle().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchinePle.fpAttrezzatureMacchinaElencoPle");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchinePle");
        	}
        	
        	if(theModel.getAppDataelencoMacchineTrinciaForestali()!=null && !theModel.getAppDataelencoMacchineTrinciaForestali().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineTrinciaForestale.fpAttrezzatureMacchinaElencoTrinciaForestale");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineTrinciaForestale");
        	}
        	
        	if(theModel.getAppDataelencoMacchineSegheriaMobile()!=null && !theModel.getAppDataelencoMacchineSegheriaMobile().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineSegherieMobili.fpAttrezzatureMacchineSegherieMobili");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineSegherieMobili");
        	}
        	
        	if(theModel.getAppDataelencoMacchineGruACavo()!=null && !theModel.getAppDataelencoMacchineGruACavo().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineGruACavo.fpAttrezzatureMacchineGruACavo");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineGruACavo");
        	}
        	
        	if(theModel.getAppDataelencoMezziDiTrasporto()!=null && !theModel.getAppDataelencoMezziDiTrasporto().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMezziDiTrasporto.fpAttrezzatureMezziDiTrasporto");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMezziDiTrasporto");
        	}
        	

        	if(theModel.getAppDataelencoAltriMezzi()!=null && !theModel.getAppDataelencoAltriMezzi().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureAltriMezzi.fpAttrezzatureAltriMezzi");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureAltriMezzi");
        	}
        }
        else {
        	
        	if(theModel.getAppDataelencoMacchineSpecialiFr()!=null && !theModel.getAppDataelencoMacchineSpecialiFr().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineSpecialiFr.fpAttrezzatureMacchineSpecialiFr");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineSpecialiFr");
        	}
        	
        	if(theModel.getAppDataelencoMacchineMovimentoTerraFr()!=null && !theModel.getAppDataelencoMacchineMovimentoTerraFr().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineMovimentoATerraFr.fpAttrezzatureMacchineMovimentoATerraFr");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineMovimentoATerraFr");
        	}
        	
        	if(theModel.getAppDataelencoMacchineGrumier()!=null && !theModel.getAppDataelencoMacchineGrumier().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineGrumier.fpAttrezzatureMacchinaElencoGrumier");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineGrumier");
        	}
        	
        	if(theModel.getAppDataelencoMacchineRimorchiFr()!=null && !theModel.getAppDataelencoMacchineRimorchiFr().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineRimorchiFr.fpAttrezzatureMacchinaElencoRimorchiFr");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineRimorchiFr");
        	}
        	
        	if(theModel.getAppDataelencoMacchineSemi()!=null && !theModel.getAppDataelencoMacchineSemi().isEmpty()) {
        		config.getActivate().add("mpAttrezzatureMacchineSemi.fpAttrezzatureMacchinaElencoSemi");
        	}
        	else {
        		config.getDeactivate().add("mpAttrezzatureMacchineSemi");
        	}
        }
      
        return config;
    }
    
            public static ConfigVisibility initScheda6(CpDomandaModel theModel) {
        	StringBuilder sb = new StringBuilder("6-");
        	sb.append(theModel.getAppDatatracciato());
        
        	final String key = sb.toString();
        	ConfigVisibility config = getConfigVisibility(key);
        
        	if (Constants.TRACCIATO_IT.equalsIgnoreCase(theModel.getAppDatatracciato())) {
        
        	    ArrayList<Personale> personale = theModel.getAppDataelencoPersonale();
        
        	  /*  if (personale != null && !personale.isEmpty()) {
        		config.getShow().add("tblAltroPersonale");
        	    } else {
        		config.getHide().add("tblAltroPersonale");
        	    }*/
        
        	    if (theModel.getAppDataelencoPersonale() != null && !theModel.getAppDataelencoPersonale().isEmpty()) {
        		config.getActivate().add("mpAltroPersonale.fpAltroPersonale");
        	    } else {
        		config.getDeactivate().add("mpAltroPersonale");
        	    }
        	} 
//        	else {
//        	    if (theModel.getAppDataelencoPersonale() != null && !theModel.getAppDataelencoPersonale().isEmpty()) {
//        		config.getActivate().add("mpAltroPersonaleFr.fpAltroPersonaleFr");
//        	    } else {
//        		config.getDeactivate().add("mpAltroPersonaleFr");
//        	    }
//        	}
        
        	return config;
            }
     
    
    public static ConfigVisibility getConfigVisibility(String key){
        ConfigVisibility result = new ConfigVisibility();
        
        // Clean
        ArrayList<String> clean = getValuesList(key+"-"+ViewOperationEnum.CLEAN.getName(), FILE_PROPERTIES_NAME);
        // Activate
        ArrayList<String> activate = getValuesList(key+"-"+ViewOperationEnum.ACTIVATE.getName(), FILE_PROPERTIES_NAME);
        // Deactivate
        ArrayList<String> deactivate = getValuesList(key+"-"+ViewOperationEnum.DEACTIVATE.getName(), FILE_PROPERTIES_NAME);
        // On
        ArrayList<String> on = getValuesList(key+"-"+ViewOperationEnum.ON.getName(), FILE_PROPERTIES_NAME);
        // Off
        ArrayList<String> off = getValuesList(key+"-"+ViewOperationEnum.OFF.getName(), FILE_PROPERTIES_NAME);
        // Hide
        ArrayList<String> hide = getValuesList(key+"-"+ViewOperationEnum.HIDE.getName(), FILE_PROPERTIES_NAME);
        // Show
        ArrayList<String> show = getValuesList(key+"-"+ViewOperationEnum.SHOW.getName(), FILE_PROPERTIES_NAME);
            
        result.setActivate(activate);
        result.setClean(clean);
        result.setDeactivate(deactivate);
        result.setHide(hide);
        result.setOff(off);
        result.setOn(on);
        result.setShow(show);
        return result;
    }
    
    /**
     * Constructor.
     */
    private DomandaViewHelper() {
        /* NOP */
    }

}
