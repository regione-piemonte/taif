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
 * RowMapper specifico del DAO TaifVApplSchedaOkRealeDao
 * @generated
 */
public class TaifVApplSchedaOkRealeDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifVApplSchedaOkRealeDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifVApplSchedaOkRealeDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifVApplSchedaOkRealeDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifVApplSchedaOkRealeDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifVApplSchedaOkRealeDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifVApplSchedaOkRealeDto) {
			return mapRow_internal((TaifVApplSchedaOkRealeDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifVApplSchedaOkRealeDto mapRow_internal(TaifVApplSchedaOkRealeDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifVApplSchedaOkRealeDto dto = objectToFill;

		// colonna [ID_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		// colonna [FLG_SEZ_1_1_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_1_1_ITA_OK") != null)
			dto.setFlgSez11ItaOk(rs.getBigDecimal("FLG_SEZ_1_1_ITA_OK"));

		// colonna [FLG_SEZ_1_2_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_1_2_ITA_OK") != null)
			dto.setFlgSez12ItaOk(rs.getBigDecimal("FLG_SEZ_1_2_ITA_OK"));

		// colonna [FLG_SEZ_2_1_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_2_1_ITA_OK") != null)
			dto.setFlgSez21ItaOk(rs.getBigDecimal("FLG_SEZ_2_1_ITA_OK"));

		// colonna [FLG_SEZ_2_2_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_2_2_ITA_OK") != null)
			dto.setFlgSez22ItaOk(rs.getBigDecimal("FLG_SEZ_2_2_ITA_OK"));

		// colonna [FLG_SEZ_3_1_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_1_ITA_OK") != null)
			dto.setFlgSez31ItaOk(rs.getBigDecimal("FLG_SEZ_3_1_ITA_OK"));

		// colonna [FLG_SEZ_3_2_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_2_ITA_OK") != null)
			dto.setFlgSez32ItaOk(rs.getBigDecimal("FLG_SEZ_3_2_ITA_OK"));

		// colonna [FLG_SEZ_3_3_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_3_ITA_OK") != null)
			dto.setFlgSez33ItaOk(rs.getBigDecimal("FLG_SEZ_3_3_ITA_OK"));

		// colonna [FLG_SEZ_4_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_4_ITA_OK") != null)
			dto.setFlgSez4ItaOk(rs.getBigDecimal("FLG_SEZ_4_ITA_OK"));

		// colonna [FLG_SEZ_5_1_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_5_1_ITA_OK") != null)
			dto.setFlgSez51ItaOk(rs.getBigDecimal("FLG_SEZ_5_1_ITA_OK"));

		// colonna [FLG_SEZ_5_2_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_5_2_ITA_OK") != null)
			dto.setFlgSez52ItaOk(rs.getBigDecimal("FLG_SEZ_5_2_ITA_OK"));

		// colonna [FLG_SEZ_6_ITA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_6_ITA_OK") != null)
			dto.setFlgSez6ItaOk(rs.getBigDecimal("FLG_SEZ_6_ITA_OK"));

		// colonna [FLG_SEZ_1_1_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_1_1_FRA_OK") != null)
			dto.setFlgSez11FraOk(rs.getBigDecimal("FLG_SEZ_1_1_FRA_OK"));

		// colonna [FLG_SEZ_1_2_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_1_2_FRA_OK") != null)
			dto.setFlgSez12FraOk(rs.getBigDecimal("FLG_SEZ_1_2_FRA_OK"));

		// colonna [FLG_SEZ_2_1_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_2_1_FRA_OK") != null)
			dto.setFlgSez21FraOk(rs.getBigDecimal("FLG_SEZ_2_1_FRA_OK"));

		// colonna [FLG_SEZ_2_2_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_2_2_FRA_OK") != null)
			dto.setFlgSez22FraOk(rs.getBigDecimal("FLG_SEZ_2_2_FRA_OK"));

		// colonna [FLG_SEZ_3_1_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_1_FRA_OK") != null)
			dto.setFlgSez31FraOk(rs.getBigDecimal("FLG_SEZ_3_1_FRA_OK"));

		// colonna [FLG_SEZ_3_3_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_3_FRA_OK") != null)
			dto.setFlgSez33FraOk(rs.getBigDecimal("FLG_SEZ_3_3_FRA_OK"));

		// colonna [FLG_SEZ_4_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_4_FRA_OK") != null)
			dto.setFlgSez4FraOk(rs.getBigDecimal("FLG_SEZ_4_FRA_OK"));

		// colonna [FLG_SEZ_5_2_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_5_2_FRA_OK") != null)
			dto.setFlgSez52FraOk(rs.getBigDecimal("FLG_SEZ_5_2_FRA_OK"));

		// colonna [FLG_SEZ_6_FRA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_6_FRA_OK") != null)
			dto.setFlgSez6FraOk(rs.getBigDecimal("FLG_SEZ_6_FRA_OK"));

		return dto;
	}

}
