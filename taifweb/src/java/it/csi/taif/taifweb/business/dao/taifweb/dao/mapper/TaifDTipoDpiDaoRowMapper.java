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
 * RowMapper specifico del DAO TaifDTipoDpiDao
 * @generated
 */
public class TaifDTipoDpiDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoDpiDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoDpiDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoDpiDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoDpiDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoDpiDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoDpiDto) {
			return mapRow_internal((TaifDTipoDpiDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoDpiByVisibleDto) {
			return mapRow_internal((TaifDTipoDpiByVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoDpiByDispVisibleDto) {
			return mapRow_internal((TaifDTipoDpiByDispVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoDpiDto mapRow_internal(TaifDTipoDpiDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDTipoDpiDto dto = objectToFill;

		// colonna [ID_TIPO_DPI]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_DPI") != null)
			dto.setIdTipoDpi((Integer) rs.getObject("ID_TIPO_DPI"));

		// colonna [TIPO_DPI]
		if (mapAllColumns || columnsToReadMap.get("TIPO_DPI") != null)
			dto.setTipoDpi(rs.getString("TIPO_DPI"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoDpiByVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoDpiByVisibleDto
	 * @generated
	 */

	public TaifDTipoDpiByVisibleDto mapRow_internal(TaifDTipoDpiByVisibleDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoDpiByVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoDpiByDispVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoDpiByDispVisibleDto
	 * @generated
	 */

	public TaifDTipoDpiByDispVisibleDto mapRow_internal(TaifDTipoDpiByDispVisibleDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTipoDpiByDispVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
