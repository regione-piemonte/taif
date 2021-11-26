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
 * RowMapper specifico del DAO TaifDTipoStrutturaDao
 * @generated
 */
public class TaifDTipoStrutturaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoStrutturaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoStrutturaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoStrutturaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoStrutturaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoStrutturaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoStrutturaDto) {
			return mapRow_internal((TaifDTipoStrutturaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoStrutturaTipoStrutturaVisibleDto) {
			return mapRow_internal((TaifDTipoStrutturaTipoStrutturaVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoStrutturaDto mapRow_internal(TaifDTipoStrutturaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoStrutturaDto dto = objectToFill;

		// colonna [ID_TIPO_STRUTTURA]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_STRUTTURA") != null)
			dto.setIdTipoStruttura((Integer) rs.getObject("ID_TIPO_STRUTTURA"));

		// colonna [TIPO_STRUTTURA]
		if (mapAllColumns || columnsToReadMap.get("TIPO_STRUTTURA") != null)
			dto.setTipoStruttura(rs.getString("TIPO_STRUTTURA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoStrutturaTipoStrutturaVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoStrutturaTipoStrutturaVisibleDto
	 * @generated
	 */

	public TaifDTipoStrutturaTipoStrutturaVisibleDto mapRow_internal(
			TaifDTipoStrutturaTipoStrutturaVisibleDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDTipoStrutturaTipoStrutturaVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOSTRU") != null)
			dto.setTipoStru(rs.getString("tipoStru"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
