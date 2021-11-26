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
 * RowMapper specifico del DAO TaifCnfParamActaDao
 * @generated
 */
public class TaifCnfParamActaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfParamActaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfParamActaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfParamActaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfParamActaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfParamActaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfParamActaDto) {
			return mapRow_internal((TaifCnfParamActaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfParamActaDto mapRow_internal(TaifCnfParamActaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfParamActaDto dto = objectToFill;

		// colonna [ID_CONFIG_PARAM_ACTA]
		if (mapAllColumns || columnsToReadMap.get("ID_CONFIG_PARAM_ACTA") != null)
			dto.setIdConfigParamActa((Integer) rs.getObject("ID_CONFIG_PARAM_ACTA"));

		// colonna [CODICE]
		if (mapAllColumns || columnsToReadMap.get("CODICE") != null)
			dto.setCodice(rs.getString("CODICE"));

		// colonna [VALORE]
		if (mapAllColumns || columnsToReadMap.get("VALORE") != null)
			dto.setValore(rs.getString("VALORE"));

		return dto;
	}

}
