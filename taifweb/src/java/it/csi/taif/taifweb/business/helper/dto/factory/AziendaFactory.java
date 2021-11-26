/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaRicercaAziendaAvanzataDto;
import it.csi.taif.taifweb.dto.gestore.Azienda;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;

public class AziendaFactory {

	public static Azienda createAzienda(TaifTAziendaRicercaAziendaAvanzataDto dto, String linguaDati, Comune comune) {
		Azienda result = new Azienda();
		if (ConvertUtil.checkIsNullOrEmpty(dto.getCodiceFiscaleAzienda())) {
			result.setCodiceFiscale(dto.getCodiceFiscaleAzienda());
		} else if (ConvertUtil.checkIsNullOrEmpty(dto.getPivaAzienda())) {
			result.setCodiceFiscale(dto.getPivaAzienda());
		} else if (ConvertUtil.checkIsNullOrEmpty(dto.getNSiret())) {
			result.setCodiceFiscale(dto.getNSiret());
		} else if (ConvertUtil.checkIsNullOrEmpty(dto.getNTva())) {
			result.setCodiceFiscale(dto.getNTva());
		}
		result.setDenominazione(dto.getDenominazioneAzienda());
		result.setIdAlbo(dto.getIdAlboAppartenenza());
		result.setDsAlbo(dto.getDsAlboAppartenenza());
		result.setIdStato(dto.getIdStatoPratica());
		if (ConvertUtil.checkIsNullOrEmpty(linguaDati)) {
			if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.itaLang)) {
				result.setDsStato(dto.getDsStatoPraticaIta());
			} else {
				result.setDsStato(dto.getDsStatoPraticaFra());
			}
		} else {
			result.setDsStato(dto.getDsStatoPraticaIta());
		}
		result.setIdAlbo(dto.getIdAlboAppartenenza());
		result.setIdAzienda(dto.getId());
		result.setNumeroAlbo(dto.getNumeroAlbo());
		result.setTitolare(dto.getCognomeTitolare() + " " + dto.getNomeTitolare());
		if (ConvertUtil.checkIsNullOrEmpty(dto.getIstatComuneSede())) {
			result.setComune(comune.getNome());
		} else {
			result.setComune(dto.getComuneSedeEstero());
		}
		result.setIdPratica(dto.getIdPratica());
		return result;
	}
	
	

}
