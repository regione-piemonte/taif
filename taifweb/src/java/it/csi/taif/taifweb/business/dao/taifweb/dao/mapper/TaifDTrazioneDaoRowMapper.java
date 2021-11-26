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
 * RowMapper specifico del DAO TaifDTrazioneDao
 * @generated
 */
public class TaifDTrazioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTrazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTrazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTrazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTrazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTrazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTrazioneDto) {
			return mapRow_internal((TaifDTrazioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTrazioneByVisibileOrdinDto) {
			return mapRow_internal((TaifDTrazioneByVisibileOrdinDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTrazioneByTrazTrazioneDto) {
			return mapRow_internal((TaifDTrazioneByTrazTrazioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTrazioneDto mapRow_internal(TaifDTrazioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDTrazioneDto dto = objectToFill;

		// colonna [ID_TRAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TRAZIONE") != null)
			dto.setIdTrazione((Integer) rs.getObject("ID_TRAZIONE"));

		// colonna [TRAZIONE]
		if (mapAllColumns || columnsToReadMap.get("TRAZIONE") != null)
			dto.setTrazione(rs.getString("TRAZIONE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDTrazioneByVisibileOrdinDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTrazioneByVisibileOrdinDto
	 * @generated
	 */

	public TaifDTrazioneByVisibileOrdinDto mapRow_internal(TaifDTrazioneByVisibileOrdinDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTrazioneByVisibileOrdinDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CAT") != null)
			dto.setCat(rs.getString("cat"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTrazioneByTrazTrazioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTrazioneByTrazTrazioneDto
	 * @generated
	 */

	public TaifDTrazioneByTrazTrazioneDto mapRow_internal(TaifDTrazioneByTrazTrazioneDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTrazioneByTrazTrazioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDTRAZIONE") != null)
			dto.setIdTrazione((Integer) rs.getObject("idTrazione"));

		if (mapAllColumns || columnsToReadMap.get("TRAZIONE") != null)
			dto.setTrazione(rs.getString("trazione"));

		if (mapAllColumns || columnsToReadMap.get("ORDINAMENTO") != null)
			dto.setOrdinamento(rs.getBigDecimal("ordinamento"));

		return dto;
	}

}
