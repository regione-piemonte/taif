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
 * RowMapper specifico del DAO TaifDAssortimentoDao
 * @generated
 */
public class TaifDAssortimentoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDAssortimentoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDAssortimentoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDAssortimentoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDAssortimentoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAssortimentoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDAssortimentoDto) {
			return mapRow_internal((TaifDAssortimentoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDAssortimentoByVisibleFilterDto) {
			return mapRow_internal((TaifDAssortimentoByVisibleFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDAssortimentoDto mapRow_internal(TaifDAssortimentoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDAssortimentoDto dto = objectToFill;

		// colonna [ID_ASSORTIMENTO]
		if (mapAllColumns || columnsToReadMap.get("ID_ASSORTIMENTO") != null)
			dto.setIdAssortimento((Integer) rs.getObject("ID_ASSORTIMENTO"));

		// colonna [ASSORTIMENTO]
		if (mapAllColumns || columnsToReadMap.get("ASSORTIMENTO") != null)
			dto.setAssortimento(rs.getString("ASSORTIMENTO"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDAssortimentoByVisibleFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAssortimentoByVisibleFilterDto
	 * @generated
	 */

	public TaifDAssortimentoByVisibleFilterDto mapRow_internal(TaifDAssortimentoByVisibleFilterDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDAssortimentoByVisibleFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("ASS") != null)
			dto.setAss(rs.getString("ass"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
