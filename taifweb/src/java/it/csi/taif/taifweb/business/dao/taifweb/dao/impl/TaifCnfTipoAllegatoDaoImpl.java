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

/*PROTECTED REGION ID(R-1401365423) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifCnfTipoAllegato.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byProcedura (datagen::CustomFinder)
 *   - byAllegatoFilter (datagen::CustomFinder)
 *   - allegatiObbligatori (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifCnfTipoAllegatoDaoImpl extends AbstractDAO implements TaifCnfTipoAllegatoDao {
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

	protected TaifCnfTipoAllegatoDaoRowMapper findByPrimaryKeyRowMapper = new TaifCnfTipoAllegatoDaoRowMapper(null,
			TaifCnfTipoAllegatoDto.class, this);

	protected TaifCnfTipoAllegatoDaoRowMapper findAllRowMapper = new TaifCnfTipoAllegatoDaoRowMapper(null,
			TaifCnfTipoAllegatoDto.class, this);

	protected TaifCnfTipoAllegatoDaoRowMapper byProceduraRowMapper = new TaifCnfTipoAllegatoDaoRowMapper(null,
			TaifCnfTipoAllegatoByProceduraDto.class, this);

	protected TaifCnfTipoAllegatoDaoRowMapper byAllegatoFilterRowMapper = new TaifCnfTipoAllegatoDaoRowMapper(null,
			TaifCnfTipoAllegatoByAllegatoFilterDto.class, this);

	protected TaifCnfTipoAllegatoDaoRowMapper allegatiObbligatoriRowMapper = new TaifCnfTipoAllegatoDaoRowMapper(null,
			TaifCnfTipoAllegatoAllegatiObbligatoriDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_TIPO_ALLEGATO";
	}

	/** 
	 * Returns all rows from the TAIF_CNF_TIPO_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfTipoAllegatoDto findByPrimaryKey(TaifCnfTipoAllegatoPk pk) throws TaifCnfTipoAllegatoDaoException {
		LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_ALLEGATO,FK_PROCEDURA,TIPO_ALLEGATO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA,FLG_CONTESTO,FLG_FIRMA,FLG_DOWNLOAD,FLG_UPLOAD,FLG_INVIO,ACTA_OGGETTO,ACTA_FLG_ALLEGATI,ACTA_STATO_DI_EFFICACIA FROM "
						+ getTableName() + " WHERE ID_TIPO_ALLEGATO = :ID_TIPO_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_ALLEGATO]
		params.addValue("ID_TIPO_ALLEGATO", pk.getIdTipoAllegato(), java.sql.Types.INTEGER);

		List<TaifCnfTipoAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifCnfTipoAllegatoDto res = (TaifCnfTipoAllegatoDto) cache.get(pk);
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
			LOG.error("[TaifCnfTipoAllegatoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifCnfTipoAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfTipoAllegatoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_TIPO_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfTipoAllegatoDto> findAll() throws TaifCnfTipoAllegatoDaoException {
		LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_ALLEGATO,FK_PROCEDURA,TIPO_ALLEGATO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA,FLG_CONTESTO,FLG_FIRMA,FLG_DOWNLOAD,FLG_UPLOAD,FLG_INVIO,ACTA_OGGETTO,ACTA_FLG_ALLEGATI,ACTA_STATO_DI_EFFICACIA FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifCnfTipoAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifCnfTipoAllegatoDto> res = (List<TaifCnfTipoAllegatoDto>) cache
					.get("findAll_taifCnfTipoAllegato_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifCnfTipoAllegato_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfTipoAllegatoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifCnfTipoAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfTipoAllegatoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byProcedura con Qdef
		 * @generated
		 */

	public List<TaifCnfTipoAllegatoByProceduraDto> findByProcedura(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifCnfTipoAllegatoDaoException {
		LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findByProcedura] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipoAllegatoTable.ID_TIPO_ALLEGATO as idTipoAllegato, tipoAllegatoTable.FK_PROCEDURA as idProcedura, tipoAllegatoTable.TIPO_ALLEGATO as tipoAllegato, tipoAllegatoTable.FLG_FIRMA as flagFirma, tipoAllegatoTable.FLG_DOWNLOAD as flagDownload, tipoAllegatoTable.FLG_UPLOAD as flagUpload, tipoAllegatoTable.FLG_INVIO as flagInvio, proceduraTable.NOME_PROCEDURA as nomeProcedura");

		sql.append(" FROM TAIF_CNF_TIPO_ALLEGATO tipoAllegatoTable, TAIF_CNF_PROCEDURA proceduraTable");

		sql.append(" WHERE ");

		sql.append("tipoAllegatoTable.FK_PROCEDURA = proceduraTable.ID_PROCEDURA");

		sql.append(" AND ");

		sql.append("tipoAllegato.fk_procedura=:idProcedura");
		/*PROTECTED REGION ID(R1629660584) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idProcedura", input.getIdprocedura());

		/*PROTECTED REGION END*/

		List<TaifCnfTipoAllegatoByProceduraDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byProceduraRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfTipoAllegatoDaoImpl::findByProcedura] ERROR esecuzione query", ex);
			throw new TaifCnfTipoAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfTipoAllegatoDaoImpl", "findByProcedura", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findByProcedura] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAllegatoFilter con Qdef
		 * @generated
		 */

	public List<TaifCnfTipoAllegatoByAllegatoFilterDto> findByAllegatoFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifCnfTipoAllegatoDaoException {
		LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findByAllegatoFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipoAllegatoTable.ID_TIPO_ALLEGATO as idTipoAllegato, tipoAllegatoTable.FK_PROCEDURA as idProcedura, tipoAllegatoTable.TIPO_ALLEGATO as tipoAllegato, tipoAllegatoTable.FLG_FIRMA as flagFirma, tipoAllegatoTable.FLG_DOWNLOAD as flagDownload, tipoAllegatoTable.FLG_UPLOAD as flagUpload, tipoAllegatoTable.FLG_INVIO as flagInvio");

		sql.append(" FROM TAIF_CNF_TIPO_ALLEGATO tipoAllegatoTable");

		sql.append(" WHERE ");

		sql.append(
				"tipoAllegatoTable.fk_procedura=:idProcedura and  tipoAllegatoTable.mtd_flg_visibile=:flagVisible and tipoAllegatoTable.mtd_flg_ita_fra=:flagItaFra and tipoAllegatoTable.flg_contesto in (:flgContesto, 'X') and (tipoAllegatoTable.flg_firma=:flagFirma OR tipoAllegatoTable.flg_firma is null)");
		/*PROTECTED REGION ID(R-1210400792) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		paramMap.addValue("idProcedura", input.getIdprocedura());
		paramMap.addValue("flagVisible", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());
		paramMap.addValue("flgContesto", input.getFlagContesto());
		paramMap.addValue("flagFirma", input.getFlagFirma());

		if (input.getFlagDownload() == 1) {
			sql.append(" and tipoAllegatoTable.flg_download=:flagDownload ");
			paramMap.addValue("flagDownload", input.getFlagDownload());
		}
		if (input.getFlagUplod() == 1) {
			sql.append(" and tipoAllegatoTable.flg_upload=:flagUpload ");
			paramMap.addValue("flagUpload", input.getFlagUplod());
		}

		/*PROTECTED REGION END*/

		List<TaifCnfTipoAllegatoByAllegatoFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAllegatoFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfTipoAllegatoDaoImpl::findByAllegatoFilter] ERROR esecuzione query", ex);
			throw new TaifCnfTipoAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfTipoAllegatoDaoImpl", "findByAllegatoFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findByAllegatoFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder allegatiObbligatori con Qdef
		 * @generated
		 */

	public List<TaifCnfTipoAllegatoAllegatiObbligatoriDto> findAllegatiObbligatori(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifCnfTipoAllegatoDaoException {
		LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findAllegatiObbligatori] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT a.ID_TIPO_ALLEGATO");

		sql.append(" FROM TAIF_CNF_TIPO_ALLEGATO a");

		sql.append(" WHERE ");

		sql.append("FLG_UPLOAD = 1");
		/*PROTECTED REGION ID(R995823163) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND FK_PROCEDURA = 1");
		sql.append(" AND FLG_CONTESTO in (:flagContesto,'X')");
		sql.append(" AND (FLG_FIRMA = :flagFirma OR FLG_FIRMA is null)");
		sql.append(" AND mtd_flg_ita_fra = :flagItaFra");
		sql.append(" AND mtd_flg_visibile = 1");
		sql.append(" EXCEPT");
		sql.append(" SELECT FK_TIPO_ALLEGATO FROM taif_t_allegato");
		sql.append(" WHERE FK_PRATICA =:idPratica");
		sql.append(" AND flg_tipo_invio is null");

		paramMap.addValue("flagContesto", input.getFlagContesto());
		paramMap.addValue("flagFirma", input.getFlagFirma());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());
		paramMap.addValue("idPratica", input.getIdPratica());

		/*PROTECTED REGION END*/

		List<TaifCnfTipoAllegatoAllegatiObbligatoriDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allegatiObbligatoriRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfTipoAllegatoDaoImpl::findAllegatiObbligatori] ERROR esecuzione query", ex);
			throw new TaifCnfTipoAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfTipoAllegatoDaoImpl", "findAllegatiObbligatori", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifCnfTipoAllegatoDaoImpl::findAllegatiObbligatori] END");
		}
		return list;
	}

}
