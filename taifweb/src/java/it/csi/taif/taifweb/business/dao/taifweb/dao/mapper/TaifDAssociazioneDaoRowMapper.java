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
 * RowMapper specifico del DAO TaifDAssociazioneDao
 * @generated
 */
public class TaifDAssociazioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDAssociazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDAssociazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDAssociazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDAssociazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAssociazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDAssociazioneDto) {
			return mapRow_internal((TaifDAssociazioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDAssociazioneByVisibleOrdinDto) {
			return mapRow_internal((TaifDAssociazioneByVisibleOrdinDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDAssociazioneDto mapRow_internal(TaifDAssociazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDAssociazioneDto dto = objectToFill;

		// colonna [ID_ASSOCIAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_ASSOCIAZIONE") != null)
			dto.setIdAssociazione((Integer) rs.getObject("ID_ASSOCIAZIONE"));

		// colonna [ASSOCIAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ASSOCIAZIONE") != null)
			dto.setAssociazione(rs.getString("ASSOCIAZIONE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDAssociazioneByVisibleOrdinDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAssociazioneByVisibleOrdinDto
	 * @generated
	 */

	public TaifDAssociazioneByVisibleOrdinDto mapRow_internal(TaifDAssociazioneByVisibleOrdinDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDAssociazioneByVisibleOrdinDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("ASSOCIAZIONE") != null)
			dto.setAssociazione(rs.getString("associazione"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
