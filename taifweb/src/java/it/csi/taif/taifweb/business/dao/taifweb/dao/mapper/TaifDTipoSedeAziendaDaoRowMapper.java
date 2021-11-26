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
 * RowMapper specifico del DAO TaifDTipoSedeAziendaDao
 * @generated
 */
public class TaifDTipoSedeAziendaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoSedeAziendaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoSedeAziendaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoSedeAziendaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoSedeAziendaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoSedeAziendaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoSedeAziendaDto) {
			return mapRow_internal((TaifDTipoSedeAziendaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoSedeAziendaByFilterDto) {
			return mapRow_internal((TaifDTipoSedeAziendaByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoSedeAziendaDto mapRow_internal(TaifDTipoSedeAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoSedeAziendaDto dto = objectToFill;

		// colonna [ID_TIPO_SEDE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_SEDE") != null)
			dto.setIdTipoSede((Integer) rs.getObject("ID_TIPO_SEDE"));

		// colonna [TIPO_SEDE]
		if (mapAllColumns || columnsToReadMap.get("TIPO_SEDE") != null)
			dto.setTipoSede(rs.getString("TIPO_SEDE"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoSedeAziendaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoSedeAziendaByFilterDto
	 * @generated
	 */

	public TaifDTipoSedeAziendaByFilterDto mapRow_internal(TaifDTipoSedeAziendaByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTipoSedeAziendaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		return dto;
	}

}
