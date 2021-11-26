/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.impl;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.mapper.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.impl.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

/*PROTECTED REGION ID(R-1466101499) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoQualifica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilterVisible (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoQualificaDaoImpl extends AbstractDAO implements TaifDTipoQualificaDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo di inserimento del DAO taifDTipoQualifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoQualificaPk
	 * @generated
	 */

	public TaifDTipoQualificaPk insert(TaifDTipoQualificaDto dto)

	{
		LOG.debug("[TaifDTipoQualificaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_QUALIFICA,TIPO_QUALIFICA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TIPO_QUALIFICA , :TIPO_QUALIFICA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_QUALIFICA]
		params.addValue("ID_TIPO_QUALIFICA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_QUALIFICA]
		params.addValue("TIPO_QUALIFICA", dto.getTipoQualifica(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoQualifica(newKey);
		LOG.debug("[TaifDTipoQualificaDaoImpl::insert] END");
		return dto.createPk();

	}

	protected TaifDTipoQualificaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoQualificaDaoRowMapper(null,
			TaifDTipoQualificaDto.class, this);

	protected TaifDTipoQualificaDaoRowMapper findAllRowMapper = new TaifDTipoQualificaDaoRowMapper(null,
			TaifDTipoQualificaDto.class, this);

	protected TaifDTipoQualificaDaoRowMapper byFilterVisibleRowMapper = new TaifDTipoQualificaDaoRowMapper(null,
			TaifDTipoQualificaByFilterVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_QUALIFICA";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_QUALIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoQualificaDto findByPrimaryKey(TaifDTipoQualificaPk pk) throws TaifDTipoQualificaDaoException {
		LOG.debug("[TaifDTipoQualificaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_QUALIFICA,TIPO_QUALIFICA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TIPO_QUALIFICA = :ID_TIPO_QUALIFICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_QUALIFICA]
		params.addValue("ID_TIPO_QUALIFICA", pk.getIdTipoQualifica(), java.sql.Types.INTEGER);

		List<TaifDTipoQualificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoQualificaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoQualificaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoQualificaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_QUALIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoQualificaDto> findAll() throws TaifDTipoQualificaDaoException {
		LOG.debug("[TaifDTipoQualificaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_QUALIFICA,TIPO_QUALIFICA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoQualificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoQualificaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoQualificaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoQualificaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoQualificaByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDTipoQualificaDaoException {
		LOG.debug("[TaifDTipoQualificaDaoImpl::findByFilterVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tq.ID_TIPO_QUALIFICA as idQualifica, tq.TIPO_QUALIFICA as tipoQualifica");

		sql.append(" FROM TAIF_D_TIPO_QUALIFICA tq");

		sql.append(" WHERE ");

		sql.append("tq.MTD_FLG_VISIBILE=:visibile and tq.MTD_FLG_ITA_FRA=:lingua");
		/*PROTECTED REGION ID(R-1155353586) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ");

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("lingua", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifDTipoQualificaByFilterVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoQualificaDaoImpl::findByFilterVisible] ERROR esecuzione query", ex);
			throw new TaifDTipoQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoQualificaDaoImpl", "findByFilterVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoQualificaDaoImpl::findByFilterVisible] END");
		}
		return list;
	}

}
