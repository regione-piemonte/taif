/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import java.util.ArrayList;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStoricoStatoByidPraticaITDto;
import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.domanda.DettaglioStato;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.DateUtil;
import it.csi.taif.taifweb.util.GenericUtil;

public final class DettaglioStatoFactory {
	
	public static DettaglioStato createDettaglioStato(TaifTStoricoStatoByidPraticaITDto dto, ArrayList<CodeDescription> elencoStati, int count) {
		
		DettaglioStato result = new DettaglioStato();
		if(dto!=null) {
			result.setRownum(count);
			//result.setDataInserimento(dto.getDataInserimentoStato().toString());
			result.setDataInserimento(ConvertUtil.convertToString(dto.getDataInserimentoStato(),DateUtil.DATE_FORMAT_PATTERN_TRADITIONAL));
			result.setElencoStatiDomanda(elencoStati);
			result.setIdStatoDomanda(ConvertUtil.convertToString(dto.getIdStatoPratica()));
			result.setDsStatoDomanda(dto.getStatoPratica());
			result.setNumeroProtocollo(dto.getNumeroProtocollo());
			result.setDataProtocollo(ConvertUtil.convertToString(dto.getDataProtocollo()));
			result.setDataUltimaModifica(ConvertUtil.convertToString(dto.getDataUltimaModifica()));
			result.setOperatoreUltimaModifica(dto.getOperatoreCognome()+" "+dto.getOperatoreNome());
			result.setNote(dto.getNote());
			result.setEsisteDB(true);
			GenericUtil.stampaVO(result, true);
		}
		return result;
		
	}
	
}
