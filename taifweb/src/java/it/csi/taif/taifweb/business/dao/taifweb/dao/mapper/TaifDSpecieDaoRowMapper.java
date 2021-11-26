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
 * RowMapper specifico del DAO TaifDSpecieDao
 * @generated
 */
public class TaifDSpecieDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDSpecieDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDSpecieDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDSpecieDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDSpecieDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDSpecieDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDSpecieDto) {
			return mapRow_internal((TaifDSpecieDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDSpecieByFilterDto) {
			return mapRow_internal((TaifDSpecieByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDSpecieDto mapRow_internal(TaifDSpecieDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDSpecieDto dto = objectToFill;

		// colonna [ID_SPECIE]
		if (mapAllColumns || columnsToReadMap.get("ID_SPECIE") != null)
			dto.setIdSpecie((Integer) rs.getObject("ID_SPECIE"));

		// colonna [NOME_SPECIE]
		if (mapAllColumns || columnsToReadMap.get("NOME_SPECIE") != null)
			dto.setNomeSpecie(rs.getString("NOME_SPECIE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDSpecieByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDSpecieByFilterDto
	 * @generated
	 */

	public TaifDSpecieByFilterDto mapRow_internal(TaifDSpecieByFilterDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDSpecieByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
