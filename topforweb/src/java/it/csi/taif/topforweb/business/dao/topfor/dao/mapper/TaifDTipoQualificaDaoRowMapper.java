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
 * RowMapper specifico del DAO TaifDTipoQualificaDao
 * @generated
 */
public class TaifDTipoQualificaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoQualificaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoQualificaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoQualificaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoQualificaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoQualificaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoQualificaDto) {
			return mapRow_internal((TaifDTipoQualificaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoQualificaByFilterVisibleDto) {
			return mapRow_internal((TaifDTipoQualificaByFilterVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoQualificaDto mapRow_internal(TaifDTipoQualificaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoQualificaDto dto = objectToFill;

		// colonna [ID_TIPO_QUALIFICA]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_QUALIFICA") != null)
			dto.setIdTipoQualifica((Integer) rs.getObject("ID_TIPO_QUALIFICA"));

		// colonna [TIPO_QUALIFICA]
		if (mapAllColumns || columnsToReadMap.get("TIPO_QUALIFICA") != null)
			dto.setTipoQualifica(rs.getString("TIPO_QUALIFICA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoQualificaByFilterVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoQualificaByFilterVisibleDto
	 * @generated
	 */

	public TaifDTipoQualificaByFilterVisibleDto mapRow_internal(TaifDTipoQualificaByFilterVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoQualificaByFilterVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDQUALIFICA") != null)
			dto.setIdQualifica((Integer) rs.getObject("idQualifica"));

		if (mapAllColumns || columnsToReadMap.get("TIPOQUALIFICA") != null)
			dto.setTipoQualifica(rs.getString("tipoQualifica"));

		return dto;
	}

}
