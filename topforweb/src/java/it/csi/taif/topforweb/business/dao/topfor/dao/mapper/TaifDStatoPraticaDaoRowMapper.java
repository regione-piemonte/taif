/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.mapper;

import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.impl.BaseDaoRowMapper;
import it.csi.taif.topforweb.business.dao.topfor.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO TaifDStatoPraticaDao
 * @generated
 */
public class TaifDStatoPraticaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDStatoPraticaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDStatoPraticaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDStatoPraticaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDStatoPraticaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDStatoPraticaDto) {
			return mapRow_internal((TaifDStatoPraticaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDStatoPraticaByFilterVisibleDto) {
			return mapRow_internal((TaifDStatoPraticaByFilterVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDStatoPraticaDto mapRow_internal(TaifDStatoPraticaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDStatoPraticaDto dto = objectToFill;

		// colonna [ID_STATO_PRATICA]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_PRATICA") != null)
			dto.setIdStatoPratica((Integer) rs.getObject("ID_STATO_PRATICA"));

		// colonna [FK_STATO_PADRE]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_PADRE") != null)
			dto.setFkStatoPadre((Integer) rs.getObject("FK_STATO_PADRE"));

		// colonna [STATO_PRATICA_ITA]
		if (mapAllColumns || columnsToReadMap.get("STATO_PRATICA_ITA") != null)
			dto.setStatoPraticaIta(rs.getString("STATO_PRATICA_ITA"));

		// colonna [STATO_PRATICA_FRA]
		if (mapAllColumns || columnsToReadMap.get("STATO_PRATICA_FRA") != null)
			dto.setStatoPraticaFra(rs.getString("STATO_PRATICA_FRA"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoPraticaByFilterVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaByFilterVisibleDto
	 * @generated
	 */

	public TaifDStatoPraticaByFilterVisibleDto mapRow_internal(TaifDStatoPraticaByFilterVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDStatoPraticaByFilterVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSTATOPRATICA") != null)
			dto.setIdStatoPratica((Integer) rs.getObject("idStatoPratica"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICAITA") != null)
			dto.setStatoPraticaIta(rs.getString("statoPraticaIta"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICAFRA") != null)
			dto.setStatoPraticaFra(rs.getString("statoPraticaFra"));

		if (mapAllColumns || columnsToReadMap.get("IDORDIN") != null)
			dto.setIdOrdin(rs.getBigDecimal("idOrdin"));

		return dto;
	}

}
