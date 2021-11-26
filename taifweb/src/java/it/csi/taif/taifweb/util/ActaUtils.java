/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util;

import java.util.ArrayList;
import java.util.List;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoByIdPraticaDto;
import it.doqui.acta.actasrv.dto.acaris.type.common.EnumPropertyFilter;
import it.doqui.acta.actasrv.dto.acaris.type.common.EnumQueryOperator;
import it.doqui.acta.actasrv.dto.acaris.type.common.PropertyFilterType;
import it.doqui.acta.actasrv.dto.acaris.type.common.QueryConditionType;
import it.doqui.acta.actasrv.dto.acaris.type.common.QueryNameType;
public class ActaUtils {
	
	public static PropertyFilterType getPropertyFilterNone() {
		return getPropertyFilter(EnumPropertyFilter.NONE, null, null, null);
	}

	public static PropertyFilterType getPropertyFilterAll() {
		return getPropertyFilter(EnumPropertyFilter.ALL, null, null, null);
	}

	public static PropertyFilterType getPropertyFilterList(String[] className, String[] propertyName,
			PropertyFilterType prevFilter) {
		return getPropertyFilter(EnumPropertyFilter.LIST, className, propertyName, prevFilter);
	}

	private static PropertyFilterType getPropertyFilter(EnumPropertyFilter type, String[] className, String[] propertyName,
			PropertyFilterType prevFilter) {
		PropertyFilterType filter = null;
		if (type != null) {
			if (type.value().equals(EnumPropertyFilter.LIST.value())) {
				filter = (prevFilter != null) ? prevFilter : new PropertyFilterType();
				filter.setFilterType(type);
				List<QueryNameType> properties = new ArrayList<QueryNameType>();
				QueryNameType property = null;
				if (className.length == propertyName.length) {
					if (prevFilter != null && prevFilter.getFilterType().value().equals(EnumPropertyFilter.LIST.value())
							&& prevFilter.getPropertyListLength() > 0) {
						for (int j = 0; j < prevFilter.getPropertyListLength(); j++) {
							properties.add(prevFilter.getPropertyList(j));
						}
					}
					for (int i = 0; i < propertyName.length; i++) {
						property = new QueryNameType();
						property.setClassName(className[i]);
						property.setPropertyName(propertyName[i]);
						properties.add(property);
					}
					filter.setPropertyList(properties.toArray(new QueryNameType[0]));
				} else
					return null;

			} else {
				filter = new PropertyFilterType();
				filter.setFilterType(type);
			}
		}
		return filter;
	}

	public static QueryConditionType[] getCriteria(EnumQueryOperator[] operator, String[] propertyName, String[] value) {
		QueryConditionType[] criteria = null;
		if ((operator != null && operator.length > 0) && (propertyName != null && propertyName.length > 0)
				&& (value != null && value.length > 0)
				&& (operator.length == propertyName.length && operator.length == value.length)) {
			List<QueryConditionType> criteri = new ArrayList<QueryConditionType>();
			QueryConditionType criterio = null;
			for (int i = 0; i < propertyName.length; i++) {
				criterio = new QueryConditionType();
				criterio.setOperator(operator[i]);
				criterio.setPropertyName(propertyName[i]);
				criterio.setValue(value[i]);
				criteri.add(criterio);
			}
			criteria = criteri.toArray(new QueryConditionType[0]);
		}
		return criteria;
	}
	
	public static TaifTAllegatoByIdPraticaDto getDocumentoPadre(List<TaifTAllegatoByIdPraticaDto> list) {
		for (TaifTAllegatoByIdPraticaDto dto : list) {
			if(dto.getTipoallegatoActaFlgAllegati().equals(Constants.FLAG_NO)) {
				return dto;
			}
		}
		return null;
	}
	
	public static List<TaifTAllegatoByIdPraticaDto> getAllegati(List<TaifTAllegatoByIdPraticaDto> list){
		List<TaifTAllegatoByIdPraticaDto> result = new ArrayList<TaifTAllegatoByIdPraticaDto>();
		for (TaifTAllegatoByIdPraticaDto dto : list) {
			if(!Constants.FLAG_NO.equalsIgnoreCase(dto.getTipoallegatoActaFlgAllegati())){
				result.add(dto);
			}
		}
		return result;
	}
	
}
