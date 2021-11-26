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
 * RowMapper specifico del DAO TaifViewElencoCorsoPersonaDao
 * @generated
 */
public class TaifViewElencoCorsoPersonaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifViewElencoCorsoPersonaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifViewElencoCorsoPersonaDaoRowMapper(String[] columnsToRead, Class dtoClass,
			TaifViewElencoCorsoPersonaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifViewElencoCorsoPersonaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifViewElencoCorsoPersonaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifViewElencoCorsoPersonaDto) {
			return mapRow_internal((TaifViewElencoCorsoPersonaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifViewElencoCorsoPersonaCorsiPerPersonaDto) {
			return mapRow_internal((TaifViewElencoCorsoPersonaCorsiPerPersonaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifViewElencoCorsoPersonaDto mapRow_internal(TaifViewElencoCorsoPersonaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifViewElencoCorsoPersonaDto dto = objectToFill;

		// colonna [ID_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("ID_PERSONA"));

		// colonna [ARRAY_TO_STRING]
		if (mapAllColumns || columnsToReadMap.get("ARRAY_TO_STRING") != null)
			dto.setArrayToString(rs.getString("ARRAY_TO_STRING"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifViewElencoCorsoPersonaCorsiPerPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifViewElencoCorsoPersonaCorsiPerPersonaDto
	 * @generated
	 */

	public TaifViewElencoCorsoPersonaCorsiPerPersonaDto mapRow_internal(
			TaifViewElencoCorsoPersonaCorsiPerPersonaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifViewElencoCorsoPersonaCorsiPerPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("CORSIPERPERSONA") != null)
			dto.setCorsiPerPersona(rs.getString("corsiPerPersona"));

		return dto;
	}

}
