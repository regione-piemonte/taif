/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.helper.dto.factory;

import it.csi.taif.topforweb.business.helper.dto.MetadatiIndex;
import it.csi.taif.topforweb.dto.allegato.Allegato;
import it.csi.taif.topforweb.util.ConvertUtil;

public final class MetadatiIndexFactory {

	public static MetadatiIndex createMetadatiForRootFolder(String tipoProcedura, Integer idPersona, Integer idAzienda) {
		
		final MetadatiIndex dto = new MetadatiIndex();
		dto.setIdAzienda(ConvertUtil.convertToString(idAzienda));
		dto.setIdPersona(ConvertUtil.convertToString(idPersona));
		dto.setTipoProcedura(tipoProcedura);
		return dto;
		
	}
	
	public static MetadatiIndex createMetadati(int idCorso, int idPersona, Allegato allegato) {

		final MetadatiIndex dto = new MetadatiIndex();
		dto.setIdAllegato(""+allegato.getIdAllegato());
		dto.setIdTipologia(""+allegato.getIdTipoAllegato());
		//dto.setIdPratica(""+idPratica);
		dto.setIdPersona(idPersona+"");
		dto.setIdCorso(idCorso+"");
				
		return dto;
	}

	
}
