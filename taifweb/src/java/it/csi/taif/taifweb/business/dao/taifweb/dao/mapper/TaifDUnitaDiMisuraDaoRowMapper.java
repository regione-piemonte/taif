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
 * RowMapper specifico del DAO TaifDUnitaDiMisuraDao
 * @generated
 */
public class TaifDUnitaDiMisuraDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDUnitaDiMisuraDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDUnitaDiMisuraDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDUnitaDiMisuraDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDUnitaDiMisuraDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDUnitaDiMisuraDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDUnitaDiMisuraDto) {
			return mapRow_internal((TaifDUnitaDiMisuraDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDUnitaDiMisuraByVisibleFilterDto) {
			return mapRow_internal((TaifDUnitaDiMisuraByVisibleFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDUnitaDiMisuraByVisibleUnitaMisuraDto) {
			return mapRow_internal((TaifDUnitaDiMisuraByVisibleUnitaMisuraDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDUnitaDiMisuraDto mapRow_internal(TaifDUnitaDiMisuraDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDUnitaDiMisuraDto dto = objectToFill;

		// colonna [ID_UNITA_DI_MISURA]
		if (mapAllColumns || columnsToReadMap.get("ID_UNITA_DI_MISURA") != null)
			dto.setIdUnitaDiMisura((Integer) rs.getObject("ID_UNITA_DI_MISURA"));

		// colonna [UNITA_DI_MISURA]
		if (mapAllColumns || columnsToReadMap.get("UNITA_DI_MISURA") != null)
			dto.setUnitaDiMisura(rs.getString("UNITA_DI_MISURA"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDUnitaDiMisuraByVisibleFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDUnitaDiMisuraByVisibleFilterDto
	 * @generated
	 */

	public TaifDUnitaDiMisuraByVisibleFilterDto mapRow_internal(TaifDUnitaDiMisuraByVisibleFilterDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDUnitaDiMisuraByVisibleFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("UM") != null)
			dto.setUm(rs.getString("um"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDUnitaDiMisuraByVisibleUnitaMisuraDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDUnitaDiMisuraByVisibleUnitaMisuraDto
	 * @generated
	 */

	public TaifDUnitaDiMisuraByVisibleUnitaMisuraDto mapRow_internal(
			TaifDUnitaDiMisuraByVisibleUnitaMisuraDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDUnitaDiMisuraByVisibleUnitaMisuraDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("UM") != null)
			dto.setUm(rs.getString("um"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
