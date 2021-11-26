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
 * RowMapper specifico del DAO TaifDProvDestinDao
 * @generated
 */
public class TaifDProvDestinDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDProvDestinDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDProvDestinDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDProvDestinDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDProvDestinDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDProvDestinDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDProvDestinDto) {
			return mapRow_internal((TaifDProvDestinDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDProvDestinByFilterDto) {
			return mapRow_internal((TaifDProvDestinByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDProvDestinDto mapRow_internal(TaifDProvDestinDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDProvDestinDto dto = objectToFill;

		// colonna [ID_PROV_DESTIN]
		if (mapAllColumns || columnsToReadMap.get("ID_PROV_DESTIN") != null)
			dto.setIdProvDestin((Integer) rs.getObject("ID_PROV_DESTIN"));

		// colonna [PROV_DESTIN]
		if (mapAllColumns || columnsToReadMap.get("PROV_DESTIN") != null)
			dto.setProvDestin(rs.getString("PROV_DESTIN"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDProvDestinByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDProvDestinByFilterDto
	 * @generated
	 */

	public TaifDProvDestinByFilterDto mapRow_internal(TaifDProvDestinByFilterDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDProvDestinByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("PROVENIENZA") != null)
			dto.setProvenienza(rs.getString("provenienza"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
