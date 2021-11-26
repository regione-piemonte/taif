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
 * RowMapper specifico del DAO TaifDAttivitaAtecoApeDao
 * @generated
 */
public class TaifDAttivitaAtecoApeDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDAttivitaAtecoApeDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDAttivitaAtecoApeDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDAttivitaAtecoApeDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDAttivitaAtecoApeDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAttivitaAtecoApeDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDAttivitaAtecoApeDto) {
			return mapRow_internal((TaifDAttivitaAtecoApeDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDAttivitaAtecoApeByFilterDto) {
			return mapRow_internal((TaifDAttivitaAtecoApeByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDAttivitaAtecoApeByCodiceAttivitaDto) {
			return mapRow_internal((TaifDAttivitaAtecoApeByCodiceAttivitaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDAttivitaAtecoApeDto mapRow_internal(TaifDAttivitaAtecoApeDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDAttivitaAtecoApeDto dto = objectToFill;

		// colonna [ID_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("ID_ATTIVITA") != null)
			dto.setIdAttivita((Integer) rs.getObject("ID_ATTIVITA"));

		// colonna [CODICE]
		if (mapAllColumns || columnsToReadMap.get("CODICE") != null)
			dto.setCodice(rs.getString("CODICE"));

		// colonna [ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("ATTIVITA") != null)
			dto.setAttivita(rs.getString("ATTIVITA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDAttivitaAtecoApeByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAttivitaAtecoApeByFilterDto
	 * @generated
	 */

	public TaifDAttivitaAtecoApeByFilterDto mapRow_internal(TaifDAttivitaAtecoApeByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDAttivitaAtecoApeByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("ATT") != null)
			dto.setAtt(rs.getString("att"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDAttivitaAtecoApeByCodiceAttivitaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDAttivitaAtecoApeByCodiceAttivitaDto
	 * @generated
	 */

	public TaifDAttivitaAtecoApeByCodiceAttivitaDto mapRow_internal(
			TaifDAttivitaAtecoApeByCodiceAttivitaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDAttivitaAtecoApeByCodiceAttivitaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("CODICE") != null)
			dto.setCodice(rs.getString("codice"));

		if (mapAllColumns || columnsToReadMap.get("ATTIVITA") != null)
			dto.setAttivita(rs.getString("attivita"));

		return dto;
	}

}
