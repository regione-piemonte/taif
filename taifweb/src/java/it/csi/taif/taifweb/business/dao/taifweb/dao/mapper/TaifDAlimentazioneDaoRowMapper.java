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
 * RowMapper specifico del DAO TaifDAlimentazioneDao
 * @generated
 */
public class TaifDAlimentazioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDAlimentazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDAlimentazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDAlimentazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDAlimentazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAlimentazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDAlimentazioneDto) {
			return mapRow_internal((TaifDAlimentazioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDAlimentazioneByVisibileDto) {
			return mapRow_internal((TaifDAlimentazioneByVisibileDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDAlimentazioneDto mapRow_internal(TaifDAlimentazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDAlimentazioneDto dto = objectToFill;

		// colonna [ID_ALIMENTAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_ALIMENTAZIONE") != null)
			dto.setIdAlimentazione((Integer) rs.getObject("ID_ALIMENTAZIONE"));

		// colonna [ALIMENTAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ALIMENTAZIONE") != null)
			dto.setAlimentazione(rs.getString("ALIMENTAZIONE"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDAlimentazioneByVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAlimentazioneByVisibileDto
	 * @generated
	 */

	public TaifDAlimentazioneByVisibileDto mapRow_internal(TaifDAlimentazioneByVisibileDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDAlimentazioneByVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CAT") != null)
			dto.setCat(rs.getString("cat"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
