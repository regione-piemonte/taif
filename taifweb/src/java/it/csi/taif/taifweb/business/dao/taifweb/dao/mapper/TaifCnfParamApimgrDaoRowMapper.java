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
 * RowMapper specifico del DAO TaifCnfParamApimgrDao
 * @generated
 */
public class TaifCnfParamApimgrDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfParamApimgrDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfParamApimgrDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfParamApimgrDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfParamApimgrDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfParamApimgrDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfParamApimgrDto) {
			return mapRow_internal((TaifCnfParamApimgrDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfParamApimgrDto mapRow_internal(TaifCnfParamApimgrDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfParamApimgrDto dto = objectToFill;

		// colonna [ID_CONFIG_PARAM_APIMGR]
		if (mapAllColumns || columnsToReadMap.get("ID_CONFIG_PARAM_APIMGR") != null)
			dto.setIdConfigParamApimgr((Integer) rs.getObject("ID_CONFIG_PARAM_APIMGR"));

		// colonna [CONSUMER_KEY]
		if (mapAllColumns || columnsToReadMap.get("CONSUMER_KEY") != null)
			dto.setConsumerKey(rs.getString("CONSUMER_KEY"));

		// colonna [CONSUMER_SECRET]
		if (mapAllColumns || columnsToReadMap.get("CONSUMER_SECRET") != null)
			dto.setConsumerSecret(rs.getString("CONSUMER_SECRET"));

		// colonna [DATA_INIZIO_VALIDITA]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_VALIDITA") != null)
			dto.setDataInizioValidita(rs.getDate("DATA_INIZIO_VALIDITA"));

		// colonna [DATA_FINE_VALIDITA]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_VALIDITA") != null)
			dto.setDataFineValidita(rs.getDate("DATA_FINE_VALIDITA"));

		return dto;
	}

}
