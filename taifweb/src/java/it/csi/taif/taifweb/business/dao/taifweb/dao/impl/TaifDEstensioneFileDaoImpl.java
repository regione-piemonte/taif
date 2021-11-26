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

/*PROTECTED REGION ID(R1164122097) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDEstensioneFile.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - estensioneFileVisible (datagen::CustomFinder)
 *   - estensioneFileAmm (datagen::CustomFinder)
 *   - estensionePerTipoDocumentoSelezionato (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDEstensioneFileDaoImpl extends AbstractDAO implements TaifDEstensioneFileDao {
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
	 * Cache del DAO.
	 * @generated
	 */
	protected SimpleCache cache;

	/**
	 * Restutuisce la cache del DAO
	 * @generated
	 */
	public SimpleCache getCache() {
		return cache;
	}

	/**
	 * Imposta la cache del DAO
	 * @param cache
	 * @generated
	 */
	public void setCache(SimpleCache cache) {
		this.cache = cache;
	}

	/**
	 * Metodo di inserimento del DAO taifDEstensioneFile. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDEstensioneFilePk
	 * @generated
	 */

	public TaifDEstensioneFilePk insert(TaifDEstensioneFileDto dto)

	{
		LOG.debug("[TaifDEstensioneFileDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ESTENSIONE_FILE,ESTENSIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_ESTENSIONE_FILE , :ESTENSIONE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ESTENSIONE_FILE]
		params.addValue("ID_ESTENSIONE_FILE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ESTENSIONE]
		params.addValue("ESTENSIONE", dto.getEstensione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdEstensioneFile(newKey);
		LOG.debug("[TaifDEstensioneFileDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_ESTENSIONE_FILE table.
	 * @generated
	 */
	public void update(TaifDEstensioneFileDto dto) throws TaifDEstensioneFileDaoException {
		LOG.debug("[TaifDEstensioneFileDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET ESTENSIONE = :ESTENSIONE ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE  WHERE ID_ESTENSIONE_FILE = :ID_ESTENSIONE_FILE ";

		if (dto.getIdEstensioneFile() == null) {
			LOG.error("[TaifDEstensioneFileDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDEstensioneFileDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ESTENSIONE_FILE]
		params.addValue("ID_ESTENSIONE_FILE", dto.getIdEstensioneFile(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ESTENSIONE]
		params.addValue("ESTENSIONE", dto.getEstensione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDEstensioneFileDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_ESTENSIONE_FILE table.
	 * @generated
	 */

	public void delete(TaifDEstensioneFilePk pk) throws TaifDEstensioneFileDaoException {
		LOG.debug("[TaifDEstensioneFileDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ESTENSIONE_FILE = :ID_ESTENSIONE_FILE ";

		if (pk == null) {
			LOG.error("[TaifDEstensioneFileDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDEstensioneFileDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ESTENSIONE_FILE]
		params.addValue("ID_ESTENSIONE_FILE", pk.getIdEstensioneFile(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDEstensioneFileDaoImpl::delete] END");
	}

	protected TaifDEstensioneFileDaoRowMapper findByPrimaryKeyRowMapper = new TaifDEstensioneFileDaoRowMapper(null,
			TaifDEstensioneFileDto.class, this);

	protected TaifDEstensioneFileDaoRowMapper findAllRowMapper = new TaifDEstensioneFileDaoRowMapper(null,
			TaifDEstensioneFileDto.class, this);

	protected TaifDEstensioneFileDaoRowMapper estensioneFileVisibleRowMapper = new TaifDEstensioneFileDaoRowMapper(null,
			TaifDEstensioneFileEstensioneFileVisibleDto.class, this);

	protected TaifDEstensioneFileDaoRowMapper estensioneFileAmmRowMapper = new TaifDEstensioneFileDaoRowMapper(null,
			TaifDEstensioneFileEstensioneFileAmmDto.class, this);

	protected TaifDEstensioneFileDaoRowMapper estensionePerTipoDocumentoSelezionatoRowMapper = new TaifDEstensioneFileDaoRowMapper(
			null, TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_ESTENSIONE_FILE";
	}

	/** 
	 * Returns all rows from the TAIF_D_ESTENSIONE_FILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDEstensioneFileDto findByPrimaryKey(TaifDEstensioneFilePk pk) throws TaifDEstensioneFileDaoException {
		LOG.debug("[TaifDEstensioneFileDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ESTENSIONE_FILE,ESTENSIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName()
						+ " WHERE ID_ESTENSIONE_FILE = :ID_ESTENSIONE_FILE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ESTENSIONE_FILE]
		params.addValue("ID_ESTENSIONE_FILE", pk.getIdEstensioneFile(), java.sql.Types.INTEGER);

		List<TaifDEstensioneFileDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDEstensioneFileDto res = (TaifDEstensioneFileDto) cache.get(pk);
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put(pk, list.get(0));
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDEstensioneFileDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDEstensioneFileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDEstensioneFileDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDEstensioneFileDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ESTENSIONE_FILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDEstensioneFileDto> findAll() throws TaifDEstensioneFileDaoException {
		LOG.debug("[TaifDEstensioneFileDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ESTENSIONE_FILE,ESTENSIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDEstensioneFileDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDEstensioneFileDto> res = (List<TaifDEstensioneFileDto>) cache
					.get("findAll_taifDEstensioneFile_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDEstensioneFile_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDEstensioneFileDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDEstensioneFileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDEstensioneFileDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDEstensioneFileDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder estensioneFileVisible con Qdef
		 * @generated
		 */

	public List<TaifDEstensioneFileEstensioneFileVisibleDto> findEstensioneFileVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDEstensioneFileDaoException {
		LOG.debug("[TaifDEstensioneFileDaoImpl::findEstensioneFileVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ext.ID_ESTENSIONE_FILE as id, ext.ESTENSIONE as extens, ext.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_ESTENSIONE_FILE ext");

		sql.append(" WHERE ");

		sql.append("ext.mtd_flg_visibile=:visibile ");
		/*PROTECTED REGION ID(R-548835214) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDEstensioneFileEstensioneFileVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, estensioneFileVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDEstensioneFileDaoImpl::findEstensioneFileVisible] ERROR esecuzione query", ex);
			throw new TaifDEstensioneFileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDEstensioneFileDaoImpl", "findEstensioneFileVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDEstensioneFileDaoImpl::findEstensioneFileVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder estensioneFileAmm con Qdef
		 * @generated
		 */

	public List<TaifDEstensioneFileEstensioneFileAmmDto> findEstensioneFileAmm(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifDEstensioneFileDaoException {
		LOG.debug("[TaifDEstensioneFileDaoImpl::findEstensioneFileAmm] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT amm.ID_TIPO_ALLEGATO as id_tipo_allegato, ext.ESTENSIONE as estensione");

		sql.append(" FROM TAIF_D_ESTENSIONE_FILE ext, TAIF_CNF_ESTENS_AMM amm");

		sql.append(" WHERE ");

		sql.append("ext.estensione = :estensioneFile and amm.id_estensione_file = ext.id_estensione_file");
		/*PROTECTED REGION ID(R949563011) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("estensioneFile", input.getEstensioneFile());

		/*PROTECTED REGION END*/

		List<TaifDEstensioneFileEstensioneFileAmmDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, estensioneFileAmmRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDEstensioneFileDaoImpl::findEstensioneFileAmm] ERROR esecuzione query", ex);
			throw new TaifDEstensioneFileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDEstensioneFileDaoImpl", "findEstensioneFileAmm", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDEstensioneFileDaoImpl::findEstensioneFileAmm] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder estensionePerTipoDocumentoSelezionato con Qdef
		 * @generated
		 */

	public List<TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto> findEstensionePerTipoDocumentoSelezionato(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifDEstensioneFileDaoException {
		LOG.debug("[TaifDEstensioneFileDaoImpl::findEstensionePerTipoDocumentoSelezionato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT f.ESTENSIONE as estensione");

		sql.append(" FROM TAIF_D_ESTENSIONE_FILE f, TAIF_CNF_ESTENS_AMM a");

		sql.append(" WHERE ");

		sql.append("a.id_tipo_allegato = :idTipoAllegato and f.id_estensione_file = a.id_estensione_file;");
		/*PROTECTED REGION ID(R-177789720) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTipoAllegato", new Integer(input.getIdTipoAllegatoSelezionato()));
		/*PROTECTED REGION END*/

		List<TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, estensionePerTipoDocumentoSelezionatoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDEstensioneFileDaoImpl::findEstensionePerTipoDocumentoSelezionato] ERROR esecuzione query",
					ex);
			throw new TaifDEstensioneFileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDEstensioneFileDaoImpl", "findEstensionePerTipoDocumentoSelezionato",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifDEstensioneFileDaoImpl::findEstensionePerTipoDocumentoSelezionato] END");
		}
		return list;
	}

}
