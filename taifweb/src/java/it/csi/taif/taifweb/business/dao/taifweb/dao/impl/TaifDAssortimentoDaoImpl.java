/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dao.impl;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.dao.mapper.*;
import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.taifweb.qbe.*;
import it.csi.taif.taifweb.business.dao.taifweb.metadata.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import it.csi.taif.taifweb.business.dao.impl.*;
import it.csi.taif.taifweb.business.dao.util.*;
import it.csi.taif.taifweb.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R1354492305) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDAssortimento.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibleFilter (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDAssortimentoDaoImpl extends AbstractDAO implements TaifDAssortimentoDao {
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
	 * Metodo di inserimento del DAO taifDAssortimento. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAssortimentoPk
	 * @generated
	 */

	public TaifDAssortimentoPk insert(TaifDAssortimentoDto dto)

	{
		LOG.debug("[TaifDAssortimentoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ASSORTIMENTO,ASSORTIMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_ASSORTIMENTO , :ASSORTIMENTO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSORTIMENTO]
		params.addValue("ID_ASSORTIMENTO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ASSORTIMENTO]
		params.addValue("ASSORTIMENTO", dto.getAssortimento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAssortimento(newKey);
		LOG.debug("[TaifDAssortimentoDaoImpl::insert] END");
		return dto.createPk();

	}

	protected TaifDAssortimentoDaoRowMapper findByPrimaryKeyRowMapper = new TaifDAssortimentoDaoRowMapper(null,
			TaifDAssortimentoDto.class, this);

	protected TaifDAssortimentoDaoRowMapper findAllRowMapper = new TaifDAssortimentoDaoRowMapper(null,
			TaifDAssortimentoDto.class, this);

	protected TaifDAssortimentoDaoRowMapper byVisibleFilterRowMapper = new TaifDAssortimentoDaoRowMapper(null,
			TaifDAssortimentoByVisibleFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_ASSORTIMENTO";
	}

	/** 
	 * Returns all rows from the TAIF_D_ASSORTIMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAssortimentoDto findByPrimaryKey(TaifDAssortimentoPk pk) throws TaifDAssortimentoDaoException {
		LOG.debug("[TaifDAssortimentoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ASSORTIMENTO,ASSORTIMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_ASSORTIMENTO = :ID_ASSORTIMENTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSORTIMENTO]
		params.addValue("ID_ASSORTIMENTO", pk.getIdAssortimento(), java.sql.Types.INTEGER);

		List<TaifDAssortimentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAssortimentoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDAssortimentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAssortimentoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAssortimentoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ASSORTIMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAssortimentoDto> findAll() throws TaifDAssortimentoDaoException {
		LOG.debug("[TaifDAssortimentoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ASSORTIMENTO,ASSORTIMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDAssortimentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAssortimentoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDAssortimentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAssortimentoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAssortimentoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibleFilter con Qdef
		 * @generated
		 */

	public List<TaifDAssortimentoByVisibleFilterDto> findByVisibleFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAssortimentoDaoException {
		LOG.debug("[TaifDAssortimentoDaoImpl::findByVisibleFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT assort.ID_ASSORTIMENTO as id, assort.ASSORTIMENTO as ass, assort.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_ASSORTIMENTO assort");

		sql.append(" WHERE ");

		sql.append("assort.MTD_FLG_VISIBILE=:visibile and assort.MTD_FLG_ITA_FRA=:flagItaFr");
		/*PROTECTED REGION ID(R1705235961) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDAssortimentoByVisibleFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAssortimentoDaoImpl::findByVisibleFilter] ERROR esecuzione query", ex);
			throw new TaifDAssortimentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAssortimentoDaoImpl", "findByVisibleFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDAssortimentoDaoImpl::findByVisibleFilter] END");
		}
		return list;
	}

}
