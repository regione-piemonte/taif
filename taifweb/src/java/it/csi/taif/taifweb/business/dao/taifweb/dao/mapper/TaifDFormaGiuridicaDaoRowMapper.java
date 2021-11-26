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
 * RowMapper specifico del DAO TaifDFormaGiuridicaDao
 * @generated
 */
public class TaifDFormaGiuridicaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDFormaGiuridicaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDFormaGiuridicaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDFormaGiuridicaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDFormaGiuridicaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDFormaGiuridicaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDFormaGiuridicaDto) {
			return mapRow_internal((TaifDFormaGiuridicaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDFormaGiuridicaByFilterDto) {
			return mapRow_internal((TaifDFormaGiuridicaByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDFormaGiuridicaByFormaGiuridicaDto) {
			return mapRow_internal((TaifDFormaGiuridicaByFormaGiuridicaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDFormaGiuridicaDto mapRow_internal(TaifDFormaGiuridicaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDFormaGiuridicaDto dto = objectToFill;

		// colonna [ID_FORMA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("ID_FORMA_GIURIDICA") != null)
			dto.setIdFormaGiuridica((Integer) rs.getObject("ID_FORMA_GIURIDICA"));

		// colonna [FORMA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("FORMA_GIURIDICA") != null)
			dto.setFormaGiuridica(rs.getString("FORMA_GIURIDICA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDFormaGiuridicaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDFormaGiuridicaByFilterDto
	 * @generated
	 */

	public TaifDFormaGiuridicaByFilterDto mapRow_internal(TaifDFormaGiuridicaByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDFormaGiuridicaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("FORMA") != null)
			dto.setForma(rs.getString("forma"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDFormaGiuridicaByFormaGiuridicaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDFormaGiuridicaByFormaGiuridicaDto
	 * @generated
	 */

	public TaifDFormaGiuridicaByFormaGiuridicaDto mapRow_internal(TaifDFormaGiuridicaByFormaGiuridicaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDFormaGiuridicaByFormaGiuridicaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("FORMA") != null)
			dto.setForma(rs.getString("forma"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
