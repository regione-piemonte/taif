/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import it.csi.taif.taifweb.business.helper.dto.MetadatiIndex;
import it.csi.taif.taifweb.dto.allegato.Allegato;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;

public final class MetadatiIndexFactory {

	public static MetadatiIndex createMetadatiForRootFolder(Integer idPersona, Integer idAzienda, Integer idPratica) {
		
		final MetadatiIndex dto = new MetadatiIndex();
		dto.setIdAzienda(ConvertUtil.convertToString(idAzienda));
		dto.setIdPersona(ConvertUtil.convertToString(idPersona));
		dto.setIdPratica(ConvertUtil.convertToString(idPratica));
		dto.setTipoProcedura(Constants.TIPOLOGIA_ALBO_IMPRESE);
		return dto;
		
	}

	public static MetadatiIndex createMetadati(int idPratica, Allegato allegato) {

		final MetadatiIndex dto = new MetadatiIndex();
		dto.setIdAllegato(""+allegato.getIdAllegato());
		dto.setIdTipologia(""+allegato.getIdTipoAllegato());
		dto.setIdPratica(""+idPratica);
		//dto.setIdPersona(idPersona);
		//dto.setIdCorso(idCorso);
				
		return dto;
	}
	
}
