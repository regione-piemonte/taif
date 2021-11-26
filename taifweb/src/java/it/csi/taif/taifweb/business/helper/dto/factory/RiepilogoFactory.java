/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import java.math.BigDecimal;
import java.util.List;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifApplSchedaOkByPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifApplSchedaOkDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaIntestazioneRiepilogoByPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaIntestazioneRiepilogoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifVApplSchedaOkRealeDto;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.dto.domanda.Riepilogo;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.GenericUtil;

public final class RiepilogoFactory {
	
	public static final String OK = "verde";
	public static final String KO = "giallo";
	
	public static boolean scheda1Completa = false;
	public static boolean scheda2Completa = false;
	public static boolean scheda3Completa = false;
	public static boolean scheda4Completa = false;
	public static boolean scheda5Completa = false;
	public static boolean scheda6Completa = false;
	
	
	
	



	public static Riepilogo createRiepilogo(TaifApplSchedaOkDto schedaOk, TaifTAziendaIntestazioneRiepilogoDto dto) {
		Riepilogo result = new Riepilogo();
		
		if(dto!=null) {
			result.setStatoDomanda(dto.getStatoPraticaItalia());
			result.setDsDomanda(dto.getRagioneSocialeAzienda()+" - "+dto.getCodiceFiscaleAzienda());
			result.setUltimaModificaDomanda(ConvertUtil.convertToString(dto.getDataAggiornamento()));
		}
		
		StringBuilder css1 = new StringBuilder();
		css1.append("item-1 ");
		
		if(BigDecimal.ONE.equals(schedaOk.getFlgSez11ItaOk())&&
				BigDecimal.ONE.equals(schedaOk.getFlgSez12ItaOk())) {
			css1.append(OK);
			scheda1Completa = true;
		}
		else {
			css1.append(KO);
		}
		
		StringBuilder css2 = new StringBuilder();
		css2.append("item-2 ");
		if(BigDecimal.ONE.equals(schedaOk.getFlgSez21ItaOk())&&
				BigDecimal.ONE.equals(schedaOk.getFlgSez22ItaOk())) {
			css2.append(OK);
			scheda2Completa = true;
		}
		else {
			css2.append(KO);
		}
		
		StringBuilder css3 = new StringBuilder();
		css3.append("item-3 ");
		if(BigDecimal.ONE.equals(schedaOk.getFlgSez31ItaOk())&&
				BigDecimal.ONE.equals(schedaOk.getFlgSez32ItaOk())&&
				BigDecimal.ONE.equals(schedaOk.getFlgSez33ItaOk())) {
			css3.append(OK);
			scheda3Completa = true;
		}
		else {
			css3.append(KO);
		}
		
		StringBuilder css4 = new StringBuilder();
		css4.append("item-4 ");
		if(BigDecimal.ONE.equals(schedaOk.getFlgSez4ItaOk())){
			css4.append(OK);
			scheda4Completa = true;
		}
		else {
			css4.append(KO);
		}
		
		StringBuilder css5 = new StringBuilder();
		css5.append("item-5 ");
		if(BigDecimal.ONE.equals(schedaOk.getFlgSez51ItaOk())&&
				BigDecimal.ONE.equals(schedaOk.getFlgSez52ItaOk())) {
			css5.append(OK);
			scheda5Completa = true;
		}
		else {
			scheda5Completa = false;
			css5.append(KO);
		}
		
		StringBuilder css6 = new StringBuilder();
		css6.append("item-6 ");
		if(BigDecimal.ONE.equals(schedaOk.getFlgSez6ItaOk())){
			css6.append(OK);
			scheda6Completa = true;
		}
		else {
			scheda6Completa = false;
			css6.append(KO);
		}
		
		if(scheda1Completa&&scheda2Completa&&scheda3Completa&&
				scheda4Completa&&scheda5Completa&&scheda6Completa) {
			result.setSchedeComplete(true);
		}		
		result.setCss1(css1.toString());
		result.setCss2(css2.toString());
		result.setCss3(css3.toString());
		result.setCss4(css4.toString());
		result.setCss5(css5.toString());
		result.setCss6(css6.toString());
		
		return result;
	}







	public static Riepilogo createRiepilogo(List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> list,
			List<TaifApplSchedaOkByPraticaDto> listSchedaOk) {
		Riepilogo result = new Riepilogo();
		
		String tracciato = null;
		
		if(list!=null && !list.isEmpty()) {
			TaifTAziendaIntestazioneRiepilogoByPraticaDto dto = list.get(0);
			
			tracciato = GenericUtil.getTracciatoFromSoggettoGestore(ConvertUtil.convertToString(dto.getIdSoggettoGestore()));
			
			result.setIdPratica(dto.getIdPratica());
			result.setIdAzienda(dto.getIdAzienda());
			result.setIdStatoDomanda(dto.getIdStatoPratica());
			result.setStatoDomanda(dto.getStatoPraticaItalia());
			//result.setDsDomanda(dto.getRagioneSocialeAzienda()+" - "+dto.getCodiceFiscaleAzienda());
			result.setDsDomanda(dto.getRagioneSocialeAzienda());
			result.setUltimaModificaDomanda(ConvertUtil.convertToString(dto.getDataAggiornamento()));
			result.setIdSoggettoGestore(ConvertUtil.convertToString(dto.getIdSoggettoGestore()));
			result.setOperatoreUltimaModifica(dto.getOperatoreCognome()+" "+dto.getOperatoreNome());
			result.setDataIscrizioneAlbo(ConvertUtil.convertToString(dto.getDataIscrizioneAlbo()));
			result.setNumeroIscrizioneAlbo(dto.getNumeroIscrizioneAlbo());
			result.setNumeroProtocollo(dto.getNumeroProtocollo());
			result.setDataProtocollo(ConvertUtil.convertToString(dto.getDataProtocollo()));
					
		}
		
		if(listSchedaOk!=null && !listSchedaOk.isEmpty()) {
			TaifApplSchedaOkByPraticaDto schedaOk = listSchedaOk.get(0);
			StringBuilder css1 = new StringBuilder();
			css1.append("item-1 ");
			
			StringBuilder css2 = new StringBuilder();
			css2.append("item-2 ");
			
			StringBuilder css3 = new StringBuilder();
			css3.append("item-3 ");
			
			StringBuilder css4 = new StringBuilder();
			css4.append("item-4 ");
			
			StringBuilder css5 = new StringBuilder();
			css5.append("item-5 ");
			
			StringBuilder css6 = new StringBuilder();
			css6.append("item-6 ");
			
			// TRACCIATO ITALIANO
			if(it.csi.taif.taifweb.util.Constants.TRACCIATO_IT.equalsIgnoreCase(tracciato)) {			
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez11ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getSokFlgSez12ItaOk())) {
					css1.append(OK);
					scheda1Completa = true;
				}
				else {
					scheda1Completa = false;
					css1.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez21ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getSokFlgSez22ItaOk())) {
					css2.append(OK);
					scheda2Completa = true;
				}
				else {
					css2.append(KO);
					scheda2Completa = false;
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez31ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getSokFlgSez32ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getSokFlgSez33ItaOk())) {
					css3.append(OK);
					scheda3Completa = true;
				}
				else {
					scheda3Completa = false;
					css3.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez4ItaOk())){
					css4.append(OK);
					scheda4Completa = true;
				}
				else {
					scheda4Completa = false;
					css4.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez51ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getSokFlgSez52ItaOk())) {
					css5.append(OK);
					scheda5Completa = true;
				}
				else {
					scheda5Completa = false;
					css5.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez6ItaOk())){
					css6.append(OK);
					scheda6Completa = true;
				}
				else {
					scheda5Completa = false;
					css6.append(KO);
				}
				
			}
			// TRACCIATO FRANCESE
			else {
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez11FraOk())&&
						BigDecimal.ONE.equals(schedaOk.getSokFlgSez12FraOk())) {
					css1.append(OK);
					scheda1Completa = true;
				}
				else {
					scheda1Completa = false;
					css1.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez21FraOk())&&
						BigDecimal.ONE.equals(schedaOk.getSokFlgSez22FraOk())) {
					css2.append(OK);
					scheda2Completa = true;
				}
				else {
					css2.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez31FraOk())&&
						BigDecimal.ONE.equals(schedaOk.getSokFlgSez33FraOk())) {
					css3.append(OK);
					scheda3Completa = true;
				}
				else {
					css3.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez4FraOk())){
					css4.append(OK);
					scheda4Completa = true;
				}
				else {
					css4.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez52FraOk())) {
					css5.append(OK);
					scheda5Completa = true;
				}
				else {
					css5.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getSokFlgSez6FraOk())){
					css6.append(OK);
					scheda6Completa = true;
				}
				else {
					css6.append(KO);
				}
			}
			
			if(scheda1Completa&&scheda2Completa&&scheda3Completa&&
					scheda4Completa&&scheda5Completa&&scheda6Completa) {
				result.setSchedeComplete(true);
			}
			
			result.setCss1(css1.toString());
			result.setCss2(css2.toString());
			result.setCss3(css3.toString());
			result.setCss4(css4.toString());
			result.setCss5(css5.toString());
			result.setCss6(css6.toString());
			
			switch (result.getIdStatoDomanda()) {
				case 1:
				case 8:
				case 10:	
					result.setPulsanteDocumentiVisibile(true);
					break;
				default:
					result.setPulsanteDocumentiVisibile(false);
			}
			
		}
		
		return result;
	}
	
	public static Riepilogo createRiepilogoVista(List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> list,
			List<TaifVApplSchedaOkRealeDto> listSchedaOk) {
		Riepilogo result = new Riepilogo();
		
		String tracciato = null;
		
		if(list!=null && !list.isEmpty()) {
			TaifTAziendaIntestazioneRiepilogoByPraticaDto dto = list.get(0);
			
			tracciato = GenericUtil.getTracciatoFromSoggettoGestore(ConvertUtil.convertToString(dto.getIdSoggettoGestore()));
			
			result.setIdPratica(dto.getIdPratica());
			result.setIdAzienda(dto.getIdAzienda());
			result.setIdStatoDomanda(dto.getIdStatoPratica());
			result.setStatoDomanda(dto.getStatoPraticaItalia());
			//result.setDsDomanda(dto.getRagioneSocialeAzienda()+" - "+dto.getCodiceFiscaleAzienda());
			result.setDsDomanda(dto.getRagioneSocialeAzienda());
			result.setUltimaModificaDomanda(ConvertUtil.convertToString(dto.getDataAggiornamento()));
			result.setIdSoggettoGestore(ConvertUtil.convertToString(dto.getIdSoggettoGestore()));
			result.setOperatoreUltimaModifica(dto.getOperatoreCognome()+" "+dto.getOperatoreNome());
			result.setDataIscrizioneAlbo(ConvertUtil.convertToString(dto.getDataIscrizioneAlbo()));
			result.setNumeroIscrizioneAlbo(dto.getNumeroIscrizioneAlbo());
			result.setNumeroProtocollo(dto.getNumeroProtocollo());
			result.setDataProtocollo(ConvertUtil.convertToString(dto.getDataProtocollo()));
					
		}
		
		if(listSchedaOk!=null && !listSchedaOk.isEmpty()) {
			TaifVApplSchedaOkRealeDto schedaOk = listSchedaOk.get(0);
			StringBuilder css1 = new StringBuilder();
			css1.append("item-1 ");
			
			StringBuilder css2 = new StringBuilder();
			css2.append("item-2 ");
			
			StringBuilder css3 = new StringBuilder();
			css3.append("item-3 ");
			
			StringBuilder css4 = new StringBuilder();
			css4.append("item-4 ");
			
			StringBuilder css5 = new StringBuilder();
			css5.append("item-5 ");
			
			StringBuilder css6 = new StringBuilder();
			css6.append("item-6 ");
			
			// TRACCIATO ITALIANO
			if(it.csi.taif.taifweb.util.Constants.TRACCIATO_IT.equalsIgnoreCase(tracciato)) {			
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez11ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getFlgSez12ItaOk())) {
					css1.append(OK);
					scheda1Completa = true;
				}
				else {
					scheda1Completa = false;
					css1.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez21ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getFlgSez22ItaOk())) {
					css2.append(OK);
					scheda2Completa = true;
				}
				else {
					css2.append(KO);
					scheda2Completa = false;
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez31ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getFlgSez32ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getFlgSez33ItaOk())) {
					css3.append(OK);
					scheda3Completa = true;
				}
				else {
					scheda3Completa = false;
					css3.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez4ItaOk())){
					css4.append(OK);
					scheda4Completa = true;
				}
				else {
					scheda4Completa = false;
					css4.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez51ItaOk())&&
						BigDecimal.ONE.equals(schedaOk.getFlgSez52ItaOk())) {
					css5.append(OK);
					scheda5Completa = true;
				}
				else {
					scheda5Completa = false;
					css5.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez6ItaOk())){
					css6.append(OK);
					scheda6Completa = true;
				}
				else {
					scheda5Completa = false;
					css6.append(KO);
				}
				
			}
			// TRACCIATO FRANCESE
			else {
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez11FraOk())&&
						BigDecimal.ONE.equals(schedaOk.getFlgSez12FraOk())) {
					css1.append(OK);
					scheda1Completa = true;
				}
				else {
					scheda1Completa = false;
					css1.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez21FraOk())&&
						BigDecimal.ONE.equals(schedaOk.getFlgSez22FraOk())) {
					css2.append(OK);
					scheda2Completa = true;
				}
				else {
					css2.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez31FraOk())&&
						BigDecimal.ONE.equals(schedaOk.getFlgSez33FraOk())) {
					css3.append(OK);
					scheda3Completa = true;
				}
				else {
					css3.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez4FraOk())){
					css4.append(OK);
					scheda4Completa = true;
				}
				else {
					css4.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez52FraOk())) {
					css5.append(OK);
					scheda5Completa = true;
				}
				else {
					css5.append(KO);
				}
				
				if(BigDecimal.ONE.equals(schedaOk.getFlgSez6FraOk())){
					css6.append(OK);
					scheda6Completa = true;
				}
				else {
					css6.append(KO);
				}
			}
			
			if(scheda1Completa&&scheda2Completa&&scheda3Completa&&
					scheda4Completa&&scheda5Completa&&scheda6Completa) {
				result.setSchedeComplete(true);
			}
			
			result.setCss1(css1.toString());
			result.setCss2(css2.toString());
			result.setCss3(css3.toString());
			result.setCss4(css4.toString());
			result.setCss5(css5.toString());
			result.setCss6(css6.toString());
			
			switch (result.getIdStatoDomanda()) {
				case 1:
				case 8:
				case 10:	
					result.setPulsanteDocumentiVisibile(true);
					break;
				default:
					result.setPulsanteDocumentiVisibile(false);
			}
			
		}
		
		return result;
	}
	
}
