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
 * RowMapper specifico del DAO TaifDRuoloDao
 * @generated
 */
public class TaifDRuoloDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDRuoloDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDRuoloDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDRuoloDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDRuoloDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDRuoloDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDRuoloDto) {
			return mapRow_internal((TaifDRuoloDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDRuoloByVisibileDto) {
			return mapRow_internal((TaifDRuoloByVisibileDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDRuoloByRuoloDto) {
			return mapRow_internal((TaifDRuoloByRuoloDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDRuoloByidRuoloDto) {
			return mapRow_internal((TaifDRuoloByidRuoloDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDRuoloDto mapRow_internal(TaifDRuoloDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDRuoloDto dto = objectToFill;

		// colonna [ID_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO") != null)
			dto.setIdRuolo((Integer) rs.getObject("ID_RUOLO"));

		// colonna [RUOLO]
		if (mapAllColumns || columnsToReadMap.get("RUOLO") != null)
			dto.setRuolo(rs.getString("RUOLO"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDRuoloByVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDRuoloByVisibileDto
	 * @generated
	 */

	public TaifDRuoloByVisibileDto mapRow_internal(TaifDRuoloByVisibileDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDRuoloByVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("RUOL") != null)
			dto.setRuol(rs.getString("ruol"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDRuoloByRuoloDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDRuoloByRuoloDto
	 * @generated
	 */

	public TaifDRuoloByRuoloDto mapRow_internal(TaifDRuoloByRuoloDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDRuoloByRuoloDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDRUOLO") != null)
			dto.setIdRuolo((Integer) rs.getObject("idRuolo"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDRuoloByidRuoloDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDRuoloByidRuoloDto
	 * @generated
	 */

	public TaifDRuoloByidRuoloDto mapRow_internal(TaifDRuoloByidRuoloDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDRuoloByidRuoloDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDRUOLO") != null)
			dto.setIdRuolo((Integer) rs.getObject("idRuolo"));

		if (mapAllColumns || columnsToReadMap.get("RUOLOPERSONA") != null)
			dto.setRuoloPersona(rs.getString("ruoloPersona"));

		return dto;
	}

}
