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
 * RowMapper specifico del DAO TaifDTipoInquadramentoDao
 * @generated
 */
public class TaifDTipoInquadramentoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoInquadramentoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoInquadramentoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoInquadramentoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoInquadramentoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoInquadramentoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoInquadramentoDto) {
			return mapRow_internal((TaifDTipoInquadramentoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoInquadramentoByVisibleDto) {
			return mapRow_internal((TaifDTipoInquadramentoByVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoInquadramentoByTipoInquadramentoDto) {
			return mapRow_internal((TaifDTipoInquadramentoByTipoInquadramentoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoInquadramentoByIdInquadramentoDto) {
			return mapRow_internal((TaifDTipoInquadramentoByIdInquadramentoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoInquadramentoDto mapRow_internal(TaifDTipoInquadramentoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoInquadramentoDto dto = objectToFill;

		// colonna [ID_TIPO_INQUADRAMENTO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_INQUADRAMENTO") != null)
			dto.setIdTipoInquadramento((Integer) rs.getObject("ID_TIPO_INQUADRAMENTO"));

		// colonna [TIPO_INQUADRAMENTO]
		if (mapAllColumns || columnsToReadMap.get("TIPO_INQUADRAMENTO") != null)
			dto.setTipoInquadramento(rs.getString("TIPO_INQUADRAMENTO"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoInquadramentoByVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoInquadramentoByVisibleDto
	 * @generated
	 */

	public TaifDTipoInquadramentoByVisibleDto mapRow_internal(TaifDTipoInquadramentoByVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoInquadramentoByVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoInquadramentoByTipoInquadramentoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoInquadramentoByTipoInquadramentoDto
	 * @generated
	 */

	public TaifDTipoInquadramentoByTipoInquadramentoDto mapRow_internal(
			TaifDTipoInquadramentoByTipoInquadramentoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDTipoInquadramentoByTipoInquadramentoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOINQUADRAMENTO") != null)
			dto.setTipoInquadramento(rs.getString("tipoInquadramento"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoInquadramentoByIdInquadramentoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoInquadramentoByIdInquadramentoDto
	 * @generated
	 */

	public TaifDTipoInquadramentoByIdInquadramentoDto mapRow_internal(
			TaifDTipoInquadramentoByIdInquadramentoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDTipoInquadramentoByIdInquadramentoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOINQUADRAMENTO") != null)
			dto.setTipoInquadramento(rs.getString("tipoInquadramento"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
