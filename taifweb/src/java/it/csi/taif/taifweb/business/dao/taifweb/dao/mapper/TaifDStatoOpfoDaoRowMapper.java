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
 * RowMapper specifico del DAO TaifDStatoOpfoDao
 * @generated
 */
public class TaifDStatoOpfoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDStatoOpfoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDStatoOpfoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDStatoOpfoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDStatoOpfoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoOpfoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDStatoOpfoDto) {
			return mapRow_internal((TaifDStatoOpfoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDStatoOpfoStatoOpfoItaVisibleDto) {
			return mapRow_internal((TaifDStatoOpfoStatoOpfoItaVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoOpfoStatoOpfoFraVisibleDto) {
			return mapRow_internal((TaifDStatoOpfoStatoOpfoFraVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDStatoOpfoDto mapRow_internal(TaifDStatoOpfoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDStatoOpfoDto dto = objectToFill;

		// colonna [ID_STATO_OPFO]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_OPFO") != null)
			dto.setIdStatoOpfo((Integer) rs.getObject("ID_STATO_OPFO"));

		// colonna [STATO_OPFO_ITA]
		if (mapAllColumns || columnsToReadMap.get("STATO_OPFO_ITA") != null)
			dto.setStatoOpfoIta(rs.getString("STATO_OPFO_ITA"));

		// colonna [STATO_OPFO_FRA]
		if (mapAllColumns || columnsToReadMap.get("STATO_OPFO_FRA") != null)
			dto.setStatoOpfoFra(rs.getString("STATO_OPFO_FRA"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoOpfoStatoOpfoItaVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoOpfoStatoOpfoItaVisibleDto
	 * @generated
	 */

	public TaifDStatoOpfoStatoOpfoItaVisibleDto mapRow_internal(TaifDStatoOpfoStatoOpfoItaVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDStatoOpfoStatoOpfoItaVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IT") != null)
			dto.setIt(rs.getString("it"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoOpfoStatoOpfoFraVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoOpfoStatoOpfoFraVisibleDto
	 * @generated
	 */

	public TaifDStatoOpfoStatoOpfoFraVisibleDto mapRow_internal(TaifDStatoOpfoStatoOpfoFraVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDStatoOpfoStatoOpfoFraVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IT") != null)
			dto.setIt(rs.getString("it"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
