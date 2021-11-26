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

/*PROTECTED REGION ID(R-926848859) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDStatoPratica.
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
public class TaifDStatoPraticaDaoImpl extends AbstractDAO implements TaifDStatoPraticaDao {
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
	 * Metodo di inserimento del DAO taifDStatoPratica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDStatoPraticaPk
	 * @generated
	 */

	public TaifDStatoPraticaPk insert(TaifDStatoPraticaDto dto)

	{
		LOG.debug("[TaifDStatoPraticaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_STATO_PRATICA,FK_STATO_PADRE,STATO_PRATICA_ITA,STATO_PRATICA_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_STATO_PRATICA , :FK_STATO_PADRE , :STATO_PRATICA_ITA , :STATO_PRATICA_FRA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_PRATICA]
		params.addValue("ID_STATO_PRATICA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_PADRE]
		params.addValue("FK_STATO_PADRE", dto.getFkStatoPadre(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [STATO_PRATICA_ITA]
		params.addValue("STATO_PRATICA_ITA", dto.getStatoPraticaIta(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [STATO_PRATICA_FRA]
		params.addValue("STATO_PRATICA_FRA", dto.getStatoPraticaFra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdStatoPratica(newKey);
		LOG.debug("[TaifDStatoPraticaDaoImpl::insert] END");
		return dto.createPk();

	}

	protected TaifDStatoPraticaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper findAllRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper byFilterVisibleRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaByFilterVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_STATO_PRATICA";
	}

	/** 
	 * Returns all rows from the TAIF_D_STATO_PRATICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDStatoPraticaDto findByPrimaryKey(TaifDStatoPraticaPk pk) throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_PRATICA,FK_STATO_PADRE,STATO_PRATICA_ITA,STATO_PRATICA_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
						+ getTableName() + " WHERE ID_STATO_PRATICA = :ID_STATO_PRATICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_PRATICA]
		params.addValue("ID_STATO_PRATICA", pk.getIdStatoPratica(), java.sql.Types.INTEGER);

		List<TaifDStatoPraticaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_STATO_PRATICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDStatoPraticaDto> findAll() throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_PRATICA,FK_STATO_PADRE,STATO_PRATICA_ITA,STATO_PRATICA_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDStatoPraticaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findByFilterVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoPratica.ID_STATO_PRATICA as idStatoPratica, statoPratica.STATO_PRATICA_ITA as statoPraticaIta, statoPratica.STATO_PRATICA_FRA as statoPraticaFra, statoPratica.MTD_ORDINAMENTO as idOrdin");

		sql.append(" FROM TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R-7076342) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifDStatoPraticaByFilterVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findByFilterVisible] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findByFilterVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findByFilterVisible] END");
		}
		return list;
	}

}
