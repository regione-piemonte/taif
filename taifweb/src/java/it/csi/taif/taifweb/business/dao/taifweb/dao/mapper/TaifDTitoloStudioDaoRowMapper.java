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
 * RowMapper specifico del DAO TaifDTitoloStudioDao
 * @generated
 */
public class TaifDTitoloStudioDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTitoloStudioDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTitoloStudioDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTitoloStudioDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTitoloStudioDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTitoloStudioDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTitoloStudioDto) {
			return mapRow_internal((TaifDTitoloStudioDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTitoloStudioByFilterDto) {
			return mapRow_internal((TaifDTitoloStudioByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTitoloStudioDto mapRow_internal(TaifDTitoloStudioDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTitoloStudioDto dto = objectToFill;

		// colonna [ID_TITOLO_STUDIO]
		if (mapAllColumns || columnsToReadMap.get("ID_TITOLO_STUDIO") != null)
			dto.setIdTitoloStudio((Integer) rs.getObject("ID_TITOLO_STUDIO"));

		// colonna [TITOLO_STUDIO]
		if (mapAllColumns || columnsToReadMap.get("TITOLO_STUDIO") != null)
			dto.setTitoloStudio(rs.getString("TITOLO_STUDIO"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDTitoloStudioByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTitoloStudioByFilterDto
	 * @generated
	 */

	public TaifDTitoloStudioByFilterDto mapRow_internal(TaifDTitoloStudioByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTitoloStudioByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TITOLO") != null)
			dto.setTitolo(rs.getString("titolo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
