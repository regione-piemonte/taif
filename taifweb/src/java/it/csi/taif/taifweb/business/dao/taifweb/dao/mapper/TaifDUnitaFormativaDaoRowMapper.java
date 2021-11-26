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
 * RowMapper specifico del DAO TaifDUnitaFormativaDao
 * @generated
 */
public class TaifDUnitaFormativaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDUnitaFormativaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDUnitaFormativaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDUnitaFormativaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDUnitaFormativaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDUnitaFormativaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDUnitaFormativaDto) {
			return mapRow_internal((TaifDUnitaFormativaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDUnitaFormativaByFilterDto) {
			return mapRow_internal((TaifDUnitaFormativaByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDUnitaFormativaDto mapRow_internal(TaifDUnitaFormativaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDUnitaFormativaDto dto = objectToFill;

		// colonna [ID_UNITA_FORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("ID_UNITA_FORMATIVA") != null)
			dto.setIdUnitaFormativa((Integer) rs.getObject("ID_UNITA_FORMATIVA"));

		// colonna [FK_AMBITO_FORMATIVO]
		if (mapAllColumns || columnsToReadMap.get("FK_AMBITO_FORMATIVO") != null)
			dto.setFkAmbitoFormativo((Integer) rs.getObject("FK_AMBITO_FORMATIVO"));

		// colonna [FK_SOGGETTO_GESTORE]
		if (mapAllColumns || columnsToReadMap.get("FK_SOGGETTO_GESTORE") != null)
			dto.setFkSoggettoGestore((Integer) rs.getObject("FK_SOGGETTO_GESTORE"));

		// colonna [UNITA_FORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("UNITA_FORMATIVA") != null)
			dto.setUnitaFormativa(rs.getString("UNITA_FORMATIVA"));

		// colonna [SIGLA]
		if (mapAllColumns || columnsToReadMap.get("SIGLA") != null)
			dto.setSigla(rs.getString("SIGLA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDUnitaFormativaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDUnitaFormativaByFilterDto
	 * @generated
	 */

	public TaifDUnitaFormativaByFilterDto mapRow_internal(TaifDUnitaFormativaByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDUnitaFormativaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("AMBITO") != null)
			dto.setAmbito((Integer) rs.getObject("ambito"));

		if (mapAllColumns || columnsToReadMap.get("GESTORE") != null)
			dto.setGestore((Integer) rs.getObject("gestore"));

		if (mapAllColumns || columnsToReadMap.get("UNITA") != null)
			dto.setUnita(rs.getString("unita"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA") != null)
			dto.setSigla(rs.getString("sigla"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
