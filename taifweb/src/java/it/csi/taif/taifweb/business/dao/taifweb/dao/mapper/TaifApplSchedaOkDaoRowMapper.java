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
 * RowMapper specifico del DAO TaifApplSchedaOkDao
 * @generated
 */
public class TaifApplSchedaOkDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifApplSchedaOkDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifApplSchedaOkDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifApplSchedaOkDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifApplSchedaOkDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifApplSchedaOkDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifApplSchedaOkDto) {
			return mapRow_internal((TaifApplSchedaOkDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifApplSchedaOkByPraticaDto) {
			return mapRow_internal((TaifApplSchedaOkByPraticaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifApplSchedaOkDto mapRow_internal(TaifApplSchedaOkDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifApplSchedaOkDto dto = objectToFill;

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

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifApplSchedaOkByPraticaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifApplSchedaOkByPraticaDto
	 * @generated
	 */

	public TaifApplSchedaOkByPraticaDto mapRow_internal(TaifApplSchedaOkByPraticaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifApplSchedaOkByPraticaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setSokIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_1_1_ITA_OK") != null)
			dto.setSokFlgSez11ItaOk(rs.getBigDecimal("FLG_SEZ_1_1_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_1_2_ITA_OK") != null)
			dto.setSokFlgSez12ItaOk(rs.getBigDecimal("FLG_SEZ_1_2_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_2_1_ITA_OK") != null)
			dto.setSokFlgSez21ItaOk(rs.getBigDecimal("FLG_SEZ_2_1_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_2_2_ITA_OK") != null)
			dto.setSokFlgSez22ItaOk(rs.getBigDecimal("FLG_SEZ_2_2_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_1_ITA_OK") != null)
			dto.setSokFlgSez31ItaOk(rs.getBigDecimal("FLG_SEZ_3_1_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_2_ITA_OK") != null)
			dto.setSokFlgSez32ItaOk(rs.getBigDecimal("FLG_SEZ_3_2_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_3_ITA_OK") != null)
			dto.setSokFlgSez33ItaOk(rs.getBigDecimal("FLG_SEZ_3_3_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_4_ITA_OK") != null)
			dto.setSokFlgSez4ItaOk(rs.getBigDecimal("FLG_SEZ_4_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_5_1_ITA_OK") != null)
			dto.setSokFlgSez51ItaOk(rs.getBigDecimal("FLG_SEZ_5_1_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_5_2_ITA_OK") != null)
			dto.setSokFlgSez52ItaOk(rs.getBigDecimal("FLG_SEZ_5_2_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_6_ITA_OK") != null)
			dto.setSokFlgSez6ItaOk(rs.getBigDecimal("FLG_SEZ_6_ITA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_1_1_FRA_OK") != null)
			dto.setSokFlgSez11FraOk(rs.getBigDecimal("FLG_SEZ_1_1_FRA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_1_2_FRA_OK") != null)
			dto.setSokFlgSez12FraOk(rs.getBigDecimal("FLG_SEZ_1_2_FRA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_2_1_FRA_OK") != null)
			dto.setSokFlgSez21FraOk(rs.getBigDecimal("FLG_SEZ_2_1_FRA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_2_2_FRA_OK") != null)
			dto.setSokFlgSez22FraOk(rs.getBigDecimal("FLG_SEZ_2_2_FRA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_1_FRA_OK") != null)
			dto.setSokFlgSez31FraOk(rs.getBigDecimal("FLG_SEZ_3_1_FRA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_3_3_FRA_OK") != null)
			dto.setSokFlgSez33FraOk(rs.getBigDecimal("FLG_SEZ_3_3_FRA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_4_FRA_OK") != null)
			dto.setSokFlgSez4FraOk(rs.getBigDecimal("FLG_SEZ_4_FRA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_5_2_FRA_OK") != null)
			dto.setSokFlgSez52FraOk(rs.getBigDecimal("FLG_SEZ_5_2_FRA_OK"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SEZ_6_FRA_OK") != null)
			dto.setSokFlgSez6FraOk(rs.getBigDecimal("FLG_SEZ_6_FRA_OK"));

		return dto;
	}

}
