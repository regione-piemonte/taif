/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoByIdPraticaDto;
import it.csi.taif.taifweb.util.service.integration.acta.ActaStatoPraticaEnum;

public class Test {

	public static void main(String[] args) {
		
//		System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())); 
//		System.out.println(DateUtil.getTimestampDataCorrente());
		
//		Range<Integer> ita = Range.between(5, 7);
//		Range<Integer> fra = Range.between(12, 14);
//		
//		int id = 11;
//		
//		if(ita.contains(id) ||fra.contains(id)) {
//			System.out.println("OK");
//		}
//		else {
//			System.out.println("KO");
//		}
		
//		Locale it = Locale.ITALIAN;
//		
//		Locale.setDefault(it);
//				
//		System.out.println(Locale.getDefault());
//		
//		Locale fr = Locale.FRENCH;
//		
//		Locale.setDefault(fr);
//		
//		System.out.println(Locale.getDefault());
		
		//System.out.println(StatoDomandaEnum.getNextElement(2));
		
//		ArrayList<Integer> idTipoAllegato = new ArrayList<Integer>();
//		idTipoAllegato.add(2);
//		idTipoAllegato.add(6);
//		idTipoAllegato.add(7);
//		idTipoAllegato.add(10);
//		
//		Integer idSoggettoGestgore = 1;
//		
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		
//		for (Integer id : idTipoAllegato) {
//			if(id == Constants.ID_TIPO_ALLEGATO_MARCA_DA_BOLLO_VDA || idSoggettoGestgore != Constants.ID_ALBO_VALLE_D_AOSTA) {
//				result.add(id);
//			}
//		}
//		
//		for (Integer integer : result) {
//			System.out.println(integer);
//		}
		
//		String s = "Si comunica che il Sig. ##valueTitolareCognome## ##valueTitolareNome##, Titolare";
//		
//		s = s.replaceFirst("##valueTitolareNome##", null);
//		
//		System.out.println(s);
		
		//System.out.println(between(4, 1, 4));
		
//		System.out.println(GenericUtil.getMimeTypeFromFileName("pippo.mp4"));
//		System.out.println(GenericUtil.getFileExtension("pippo"));
//		
//		EnumMimeTypeType emtt = EnumMimeTypeType.fromValue(GenericUtil.getMimeTypeFromFileName("pippo.p7m"));
//		System.out.println(emtt.value());
//		System.out.println(emtt.name());
//		
//		List<TaifTAllegatoByIdPraticaDto> list = new ArrayList<TaifTAllegatoByIdPraticaDto>();
//		
//		TaifTAllegatoByIdPraticaDto uno = new TaifTAllegatoByIdPraticaDto();
//		uno.setIdAllegato(1);
//		uno.setTipoallegatoActaFlgAllegati("S");
//		list.add(uno);
//		
//		TaifTAllegatoByIdPraticaDto due = new TaifTAllegatoByIdPraticaDto();
//		due.setIdAllegato(2);
//		due.setTipoallegatoActaFlgAllegati("S");
//		list.add(due);
//		
//		TaifTAllegatoByIdPraticaDto tre = new TaifTAllegatoByIdPraticaDto();
//		tre.setIdAllegato(3);
//		tre.setTipoallegatoActaFlgAllegati("N");
//		list.add(tre);
//		
//		TaifTAllegatoByIdPraticaDto quattro = new TaifTAllegatoByIdPraticaDto();
//		quattro.setIdAllegato(4);
//		quattro.setTipoallegatoActaFlgAllegati("S");
//		list.add(quattro);
//		
//		
//		TaifTAllegatoByIdPraticaDto padre = ActaUtils.getDocumentoPadre(list);
//		GenericUtil.stampaVO(padre, true);
//		System.out.println("-----------------");
//		List<TaifTAllegatoByIdPraticaDto> allegati = ActaUtils.getAllegati(list);
//		
//		for (TaifTAllegatoByIdPraticaDto dto : allegati) {
//			GenericUtil.stampaVO(dto, true);
//		}
		
//		String s = "FR35411643596";
//		
//		System.out.println(StringUtils.isStringValid(s, RegexConstants.TVA_FRANCESE));
		
//		String data = "10/10/2019 15:32:10"; 
//		
//		
//		Timestamp t = DateUtil.getTimestampDataCorrente();
//		String formattedDate = new SimpleDateFormat(DateUtil.DATE_FORMAT_NO_SPACE).format(t);
//		System.out.println(t);
//		System.out.println(formattedDate);
//		System.out.println(DateUtil.buildTimestamp(formattedDate, DateUtil.DATE_FORMAT_NO_SPACE));
		
		int sottoFascicolo = ActaStatoPraticaEnum.getSottoFascicoloByIdStatoPratica(8).getNrSottoFasciolo();
		
		System.out.println("Numero Sottofascicolo *"+sottoFascicolo+"*");
		
	}
	
	
	
}
