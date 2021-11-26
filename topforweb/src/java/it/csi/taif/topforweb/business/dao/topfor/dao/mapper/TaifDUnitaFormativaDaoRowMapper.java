/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.mapper;

import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.impl.BaseDaoRowMapper;
import it.csi.taif.topforweb.business.dao.topfor.dao.impl.*;
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

		if (dtoInstance instanceof TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto) {
			return mapRow_internal((TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDUnitaFormativaByFilterAgenziaFormativaDto) {
			return mapRow_internal((TaifDUnitaFormativaByFilterAgenziaFormativaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDUnitaFormativaByAmbitoFormativoDto) {
			return mapRow_internal((TaifDUnitaFormativaByAmbitoFormativoDto) dtoInstance, rs, row);
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
	 * Metodo specifico di mapping relativo al DTO custom TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto
	 * @generated
	 */

	public TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto mapRow_internal(
			TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDUNITAFORMATIVA") != null)
			dto.setIdUnitaFormativa((Integer) rs.getObject("idUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEUNITAFORMATIVA") != null)
			dto.setDenominazioneUnitaFormativa(rs.getString("denominazioneUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA") != null)
			dto.setSigla(rs.getString("sigla"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDUnitaFormativaByFilterAgenziaFormativaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDUnitaFormativaByFilterAgenziaFormativaDto
	 * @generated
	 */

	public TaifDUnitaFormativaByFilterAgenziaFormativaDto mapRow_internal(
			TaifDUnitaFormativaByFilterAgenziaFormativaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDUnitaFormativaByFilterAgenziaFormativaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDUNITAFORMATIVA") != null)
			dto.setIdUnitaFormativa((Integer) rs.getObject("idUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("DSUNITAFORMATIVA") != null)
			dto.setDsUnitaFormativa(rs.getString("dsUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA") != null)
			dto.setSigla(rs.getString("sigla"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDUnitaFormativaByAmbitoFormativoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDUnitaFormativaByAmbitoFormativoDto
	 * @generated
	 */

	public TaifDUnitaFormativaByAmbitoFormativoDto mapRow_internal(TaifDUnitaFormativaByAmbitoFormativoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDUnitaFormativaByAmbitoFormativoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDUNITAFORMATIVA") != null)
			dto.setIdUnitaFormativa((Integer) rs.getObject("idUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEUNITAFORMATIVA") != null)
			dto.setDenominazioneUnitaFormativa(rs.getString("denominazioneUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA") != null)
			dto.setSigla(rs.getString("sigla"));

		return dto;
	}

}
