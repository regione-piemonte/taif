/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.helper.dto.factory;


import java.util.ArrayList;
import java.util.List;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaCorsiExtAltriCorsiDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto;
import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.util.ConvertUtil;

public class CorsoProfessionaleFactory {

	

	public static CorsoProfessionale createCorsoProfessionale(TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto dto,
			String nomeComune) {
		CorsoProfessionale result = new CorsoProfessionale();
		if(dto!=null) {
			result.setIdCorsoProfessionale(dto.getIdCorso());
			result.setIdAllegato(dto.getIdAllegato());
			result.setDsAgenziaFormativa(dto.getDsAgenziaFormativa());
			result.setDsUnitaFormativa(dto.getDsUnitaFormativa());
			result.setDsEsitoCorso(dto.getDsEsitoCorso()); //esito
			result.setEsitoCorso(dto.getFlgEsito());
			result.setTitoloCorso(dto.getTitoloCorso());
			result.setSedeCorso(nomeComune);
			result.setPeriodoSvolgimento(dto.getPeriodoSvolgimento());
			result.setNumeroOre(dto.getNOre());
			result.setIconaAttestato(dto.getIdCorso());
			result.setIconaAllegato(dto.getIdAllegato());
			result.setIconaCancella(dto.getIdCorso());
		}
		return result;
	}

	public static ArrayList<CorsoProfessionale> createListAltriCorsiProfessionali(
			List<TaifTPersonaCorsiExtAltriCorsiDto> list) {
		ArrayList<CorsoProfessionale> result = new ArrayList<CorsoProfessionale>();
		if(list!=null && !list.isEmpty()) {
			for (TaifTPersonaCorsiExtAltriCorsiDto dto : list) {
				result.add(createAltroCorsoProfessionale(dto));
			}
		}
		return result;
	}

	private static CorsoProfessionale createAltroCorsoProfessionale(TaifTPersonaCorsiExtAltriCorsiDto dto) {
		CorsoProfessionale result = new CorsoProfessionale();
		String idCorso = ConvertUtil.checkIsNullOrEmpty(dto.getIdCorso()) ? dto.getIdCorso() : "";
		result.setIdCorsoProfessionale(idCorso);
		String titoloCorso = ConvertUtil.checkIsNullOrEmpty(dto.getTitoloCorso()) ? dto.getTitoloCorso() : "";
		result.setTitoloCorso(titoloCorso);
		String descrizioneCorso = ConvertUtil.checkIsNullOrEmpty(dto.getDescrizioneAltroCorso())
				? dto.getDescrizioneAltroCorso()
				: "";
		result.setDescrizioneAltroCorso(descrizioneCorso);
		if (ConvertUtil.checkIsNullOrEmpty(dto.getDescrizioneAltroCorso())) {
			result.setTitoloCorso(dto.getTitoloCorso() + " " + dto.getDescrizioneAltroCorso());
		} else {
			result.setTitoloCorso(dto.getTitoloCorso());
		}
		String esitoCorso = ConvertUtil.checkIsNullOrEmpty(dto.getDsEsitoCorso()) ? dto.getDsEsitoCorso() : "";
		result.setDsEsitoCorso(esitoCorso);
		String scadenza = "";
		if (ConvertUtil.checkIsNullOrEmpty(dto.getAttestatoConScadenza()) && dto.getAttestatoConScadenza()
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.zero)) {
			scadenza = it.csi.taif.topforweb.business.dao.util.Constants.NO_VALUE;
		}
		if (ConvertUtil.checkIsNullOrEmpty(dto.getAttestatoConScadenza()) && dto.getAttestatoConScadenza()
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.one)) {
			scadenza = it.csi.taif.topforweb.business.dao.util.Constants.SI_VALUE;
		}
		result.setDsAttestatoConScadenza(scadenza);
		result.setIconaAttestato(dto.getIdCorso());
		result.setIconaAllegato(dto.getIdAllegato());
		result.setIconaCancella(dto.getIdCorso());
		return result;
	}

}
