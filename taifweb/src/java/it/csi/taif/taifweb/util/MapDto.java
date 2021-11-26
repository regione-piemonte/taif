/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util;

import java.util.ArrayList;
import java.util.List;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDMaterialeDto;
import it.csi.taif.taifweb.dto.common.CodeDescription;

public final class MapDto {

	public static ArrayList<CodeDescription> mapToElencoMateriali(List<TaifDMaterialeDto> list) {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if(list!=null && !list.isEmpty()) {
			for (final TaifDMaterialeDto dto : list) {
				result.add(mapToCodDescription(dto));
			}
		}
		return result;
	}

	private static CodeDescription mapToCodDescription(TaifDMaterialeDto dto) {
		CodeDescription result = new CodeDescription();
		result.setCode(ConvertUtil.convertToString(dto.getIdMateriale()));
		result.setDescription(dto.getMateriale());
		return result;
	}
	
	
	
}
