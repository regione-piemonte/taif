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
 * RowMapper specifico del DAO TaifDTipoAttivitaDao
 * @generated
 */
public class TaifDTipoAttivitaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoAttivitaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoAttivitaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoAttivitaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoAttivitaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoAttivitaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoAttivitaDto) {
			return mapRow_internal((TaifDTipoAttivitaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoAttivitaByFilterDto) {
			return mapRow_internal((TaifDTipoAttivitaByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoAttivitaDto mapRow_internal(TaifDTipoAttivitaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoAttivitaDto dto = objectToFill;

		// colonna [ID_TIPO_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_ATTIVITA") != null)
			dto.setIdTipoAttivita((Integer) rs.getObject("ID_TIPO_ATTIVITA"));

		// colonna [TIPO_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("TIPO_ATTIVITA") != null)
			dto.setTipoAttivita(rs.getString("TIPO_ATTIVITA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoAttivitaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoAttivitaByFilterDto
	 * @generated
	 */

	public TaifDTipoAttivitaByFilterDto mapRow_internal(TaifDTipoAttivitaByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTipoAttivitaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
