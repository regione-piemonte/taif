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
 * RowMapper specifico del DAO TaifDAmbitoFormativoDao
 * @generated
 */
public class TaifDAmbitoFormativoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDAmbitoFormativoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDAmbitoFormativoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDAmbitoFormativoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDAmbitoFormativoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAmbitoFormativoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDAmbitoFormativoDto) {
			return mapRow_internal((TaifDAmbitoFormativoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDAmbitoFormativoByVisibleDto) {
			return mapRow_internal((TaifDAmbitoFormativoByVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDAmbitoFormativoDto mapRow_internal(TaifDAmbitoFormativoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDAmbitoFormativoDto dto = objectToFill;

		// colonna [ID_AMBITO_FORMATIVO]
		if (mapAllColumns || columnsToReadMap.get("ID_AMBITO_FORMATIVO") != null)
			dto.setIdAmbitoFormativo((Integer) rs.getObject("ID_AMBITO_FORMATIVO"));

		// colonna [AMBITO_FORMATIVO]
		if (mapAllColumns || columnsToReadMap.get("AMBITO_FORMATIVO") != null)
			dto.setAmbitoFormativo(rs.getString("AMBITO_FORMATIVO"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDAmbitoFormativoByVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAmbitoFormativoByVisibleDto
	 * @generated
	 */

	public TaifDAmbitoFormativoByVisibleDto mapRow_internal(TaifDAmbitoFormativoByVisibleDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDAmbitoFormativoByVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("AMBITO") != null)
			dto.setAmbito(rs.getString("ambito"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
