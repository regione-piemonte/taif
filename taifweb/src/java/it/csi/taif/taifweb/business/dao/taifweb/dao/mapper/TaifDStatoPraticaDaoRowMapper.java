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
 * RowMapper specifico del DAO TaifDStatoPraticaDao
 * @generated
 */
public class TaifDStatoPraticaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDStatoPraticaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDStatoPraticaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDStatoPraticaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDStatoPraticaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDStatoPraticaDto) {
			return mapRow_internal((TaifDStatoPraticaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDStatoPraticaByFilterDto) {
			return mapRow_internal((TaifDStatoPraticaByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoPraticaByFilterStatoPraticaItaDto) {
			return mapRow_internal((TaifDStatoPraticaByFilterStatoPraticaItaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoPraticaByFilterStatoPraticaFraDto) {
			return mapRow_internal((TaifDStatoPraticaByFilterStatoPraticaFraDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoPraticaElencoStatiPraticaItaliaDto) {
			return mapRow_internal((TaifDStatoPraticaElencoStatiPraticaItaliaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoPraticaElencoStatiPraticaFranceDto) {
			return mapRow_internal((TaifDStatoPraticaElencoStatiPraticaFranceDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto) {
			return mapRow_internal((TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoPraticaElencoSottoStatiPraticaFranceDto) {
			return mapRow_internal((TaifDStatoPraticaElencoSottoStatiPraticaFranceDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDStatoPraticaDto mapRow_internal(TaifDStatoPraticaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDStatoPraticaDto dto = objectToFill;

		// colonna [ID_STATO_PRATICA]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_PRATICA") != null)
			dto.setIdStatoPratica((Integer) rs.getObject("ID_STATO_PRATICA"));

		// colonna [FK_STATO_PADRE]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_PADRE") != null)
			dto.setFkStatoPadre((Integer) rs.getObject("FK_STATO_PADRE"));

		// colonna [STATO_PRATICA_ITA]
		if (mapAllColumns || columnsToReadMap.get("STATO_PRATICA_ITA") != null)
			dto.setStatoPraticaIta(rs.getString("STATO_PRATICA_ITA"));

		// colonna [STATO_PRATICA_FRA]
		if (mapAllColumns || columnsToReadMap.get("STATO_PRATICA_FRA") != null)
			dto.setStatoPraticaFra(rs.getString("STATO_PRATICA_FRA"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoPraticaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaByFilterDto
	 * @generated
	 */

	public TaifDStatoPraticaByFilterDto mapRow_internal(TaifDStatoPraticaByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDStatoPraticaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDPADRE") != null)
			dto.setIdPadre((Integer) rs.getObject("idPadre"));

		if (mapAllColumns || columnsToReadMap.get("ITA") != null)
			dto.setIta(rs.getString("ita"));

		if (mapAllColumns || columnsToReadMap.get("FRA") != null)
			dto.setFra(rs.getString("fra"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoPraticaByFilterStatoPraticaItaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaByFilterStatoPraticaItaDto
	 * @generated
	 */

	public TaifDStatoPraticaByFilterStatoPraticaItaDto mapRow_internal(
			TaifDStatoPraticaByFilterStatoPraticaItaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDStatoPraticaByFilterStatoPraticaItaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDPADRE") != null)
			dto.setIdPadre((Integer) rs.getObject("idPadre"));

		if (mapAllColumns || columnsToReadMap.get("ITA") != null)
			dto.setIta(rs.getString("ita"));

		if (mapAllColumns || columnsToReadMap.get("FRA") != null)
			dto.setFra(rs.getString("fra"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoPraticaByFilterStatoPraticaFraDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaByFilterStatoPraticaFraDto
	 * @generated
	 */

	public TaifDStatoPraticaByFilterStatoPraticaFraDto mapRow_internal(
			TaifDStatoPraticaByFilterStatoPraticaFraDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDStatoPraticaByFilterStatoPraticaFraDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDPADRE") != null)
			dto.setIdPadre((Integer) rs.getObject("idPadre"));

		if (mapAllColumns || columnsToReadMap.get("ITA") != null)
			dto.setIta(rs.getString("ita"));

		if (mapAllColumns || columnsToReadMap.get("FRA") != null)
			dto.setFra(rs.getString("fra"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoPraticaElencoStatiPraticaItaliaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaElencoStatiPraticaItaliaDto
	 * @generated
	 */

	public TaifDStatoPraticaElencoStatiPraticaItaliaDto mapRow_internal(
			TaifDStatoPraticaElencoStatiPraticaItaliaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDStatoPraticaElencoStatiPraticaItaliaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICA") != null)
			dto.setStatoPratica(rs.getString("statoPratica"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoPraticaElencoStatiPraticaFranceDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaElencoStatiPraticaFranceDto
	 * @generated
	 */

	public TaifDStatoPraticaElencoStatiPraticaFranceDto mapRow_internal(
			TaifDStatoPraticaElencoStatiPraticaFranceDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDStatoPraticaElencoStatiPraticaFranceDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICA") != null)
			dto.setStatoPratica(rs.getString("statoPratica"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto
	 * @generated
	 */

	public TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto mapRow_internal(
			TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICA") != null)
			dto.setStatoPratica(rs.getString("statoPratica"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoPraticaElencoSottoStatiPraticaFranceDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoPraticaElencoSottoStatiPraticaFranceDto
	 * @generated
	 */

	public TaifDStatoPraticaElencoSottoStatiPraticaFranceDto mapRow_internal(
			TaifDStatoPraticaElencoSottoStatiPraticaFranceDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDStatoPraticaElencoSottoStatiPraticaFranceDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICA") != null)
			dto.setStatoPratica(rs.getString("statoPratica"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
