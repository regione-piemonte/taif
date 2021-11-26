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
 * RowMapper specifico del DAO TaifDTipoLavoroPaDao
 * @generated
 */
public class TaifDTipoLavoroPaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoLavoroPaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoLavoroPaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoLavoroPaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoLavoroPaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoLavoroPaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoLavoroPaDto) {
			return mapRow_internal((TaifDTipoLavoroPaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoLavoroPaByFilterDto) {
			return mapRow_internal((TaifDTipoLavoroPaByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoLavoroPaDto mapRow_internal(TaifDTipoLavoroPaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoLavoroPaDto dto = objectToFill;

		// colonna [ID_TIPO_LAVORO_PA]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_LAVORO_PA") != null)
			dto.setIdTipoLavoroPa((Integer) rs.getObject("ID_TIPO_LAVORO_PA"));

		// colonna [TIPO_LAVORO_PA]
		if (mapAllColumns || columnsToReadMap.get("TIPO_LAVORO_PA") != null)
			dto.setTipoLavoroPa(rs.getString("TIPO_LAVORO_PA"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoLavoroPaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoLavoroPaByFilterDto
	 * @generated
	 */

	public TaifDTipoLavoroPaByFilterDto mapRow_internal(TaifDTipoLavoroPaByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTipoLavoroPaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
