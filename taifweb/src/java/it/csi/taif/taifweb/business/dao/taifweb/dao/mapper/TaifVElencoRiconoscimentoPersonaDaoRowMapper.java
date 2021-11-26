/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dao.mapper;

import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.impl.BaseDaoRowMapper;
import it.csi.taif.taifweb.business.dao.taifweb.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO TaifVElencoRiconoscimentoPersonaDao
 * @generated
 */
public class TaifVElencoRiconoscimentoPersonaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifVElencoRiconoscimentoPersonaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifVElencoRiconoscimentoPersonaDaoRowMapper(String[] columnsToRead, Class dtoClass,
			TaifVElencoRiconoscimentoPersonaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifVElencoRiconoscimentoPersonaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifVElencoRiconoscimentoPersonaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifVElencoRiconoscimentoPersonaDto) {
			return mapRow_internal((TaifVElencoRiconoscimentoPersonaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifVElencoRiconoscimentoPersonaDto mapRow_internal(TaifVElencoRiconoscimentoPersonaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifVElencoRiconoscimentoPersonaDto dto = objectToFill;

		// colonna [ID_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("ID_PERSONA"));

		// colonna [ARRAY_TO_STRING]
		if (mapAllColumns || columnsToReadMap.get("ARRAY_TO_STRING") != null)
			dto.setArrayToString(rs.getString("ARRAY_TO_STRING"));

		return dto;
	}

}
