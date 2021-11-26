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
 * RowMapper specifico del DAO TaifDTipoMansioneDao
 * @generated
 */
public class TaifDTipoMansioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoMansioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoMansioneDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoMansioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoMansioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMansioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoMansioneDto) {
			return mapRow_internal((TaifDTipoMansioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoMansioneByVisibleOrdinDto) {
			return mapRow_internal((TaifDTipoMansioneByVisibleOrdinDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoMansioneByTipoMansioneDto) {
			return mapRow_internal((TaifDTipoMansioneByTipoMansioneDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoMansioneByIdTipoMansioneDto) {
			return mapRow_internal((TaifDTipoMansioneByIdTipoMansioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoMansioneDto mapRow_internal(TaifDTipoMansioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoMansioneDto dto = objectToFill;

		// colonna [ID_TIPO_MANSIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_MANSIONE") != null)
			dto.setIdTipoMansione((Integer) rs.getObject("ID_TIPO_MANSIONE"));

		// colonna [TIPO_MANSIONE]
		if (mapAllColumns || columnsToReadMap.get("TIPO_MANSIONE") != null)
			dto.setTipoMansione(rs.getString("TIPO_MANSIONE"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		// colonna [MTD_FLG_ITA_FRA]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_ITA_FRA") != null)
			dto.setMtdFlgItaFra(rs.getString("MTD_FLG_ITA_FRA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoMansioneByVisibleOrdinDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMansioneByVisibleOrdinDto
	 * @generated
	 */

	public TaifDTipoMansioneByVisibleOrdinDto mapRow_internal(TaifDTipoMansioneByVisibleOrdinDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoMansioneByVisibleOrdinDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoMansioneByTipoMansioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMansioneByTipoMansioneDto
	 * @generated
	 */

	public TaifDTipoMansioneByTipoMansioneDto mapRow_internal(TaifDTipoMansioneByTipoMansioneDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoMansioneByTipoMansioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOMANSIONE") != null)
			dto.setTipoMansione(rs.getString("tipoMansione"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("FLAGLANG") != null)
			dto.setFlagLang(rs.getString("flagLang"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoMansioneByIdTipoMansioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMansioneByIdTipoMansioneDto
	 * @generated
	 */

	public TaifDTipoMansioneByIdTipoMansioneDto mapRow_internal(TaifDTipoMansioneByIdTipoMansioneDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoMansioneByIdTipoMansioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOMANSIONE") != null)
			dto.setTipoMansione(rs.getString("tipoMansione"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("FLAGLANG") != null)
			dto.setFlagLang(rs.getString("flagLang"));

		return dto;
	}

}
