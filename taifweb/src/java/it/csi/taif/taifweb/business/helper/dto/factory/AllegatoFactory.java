/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.*;

import org.apache.commons.lang3.StringUtils;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDettaglioPraticaPerInvioDto;
import it.csi.taif.taifweb.dto.allegato.Allegato;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.DateUtil;
public final class AllegatoFactory {
	
	public static Allegato createAllegato(TaifTPraticaDettaglioPraticaPerInvioDto dto, int size) {
		Allegato result = new Allegato();
		if(dto!= null) {
			result.setIdTipoAllegato(Constants.ID_TIPO_ALLEGATO_SCHEDA_AZIENDA);
			result.setNomeFile(getNomeFile(dto));
			result.setDimensioneFileKb(ConvertUtil.convertToString(size));
		}
		return result;
	}
	
	private static String getNomeFile(TaifTPraticaDettaglioPraticaPerInvioDto dto) {
		StringBuffer nomeFile = new StringBuffer();
		if(StringUtils.isNotEmpty(dto.getAzCodiceFiscale())) {
			nomeFile.append(dto.getAzCodiceFiscale());
		}
		else {
			nomeFile.append(dto.getAzNSiret());
		}
		/*TAIF-21 CODICE_FISCALE - Scheda Azienda ANNO.MESE.pdf"*/
		nomeFile.append(" - Scheda Azienda ");
       nomeFile.append(DateUtil.getAnnoCorrente()).append(".").append(DateUtil.getMeseCorrente()).append(".pdf");
        return nomeFile.toString();
	}
	
}
