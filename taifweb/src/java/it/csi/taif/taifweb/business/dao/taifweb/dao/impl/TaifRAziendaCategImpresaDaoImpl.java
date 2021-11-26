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

/*PROTECTED REGION ID(R1028195581) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifRAziendaCategImpresa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byIdAzienda (datagen::CustomFinder)
 *   - byIdCategImpresa (datagen::CustomFinder)
 *   - byIdAziendaIdCategoria (datagen::CustomFinder)
 *   - findCategoriaImpresaByIdAzienda (datagen::CustomFinder)
 *   - findDettaglioCategoriaImpresaByIdAzienda (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - aziendaCategoriaImpresa (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifRAziendaCategImpresaDaoImpl extends AbstractDAO implements TaifRAziendaCategImpresaDao {
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
	 * Metodo di inserimento del DAO taifRAziendaCategImpresa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAziendaCategImpresaPk
	 * @generated
	 */

	public TaifRAziendaCategImpresaPk insert(TaifRAziendaCategImpresaDto dto)

	{
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AZIENDA,ID_CATEGORIA,AZIENDA_CATEGIMPRESA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_AZIENDA , :ID_CATEGORIA , :AZIENDA_CATEGIMPRESA , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA]
		params.addValue("ID_CATEGORIA", dto.getIdCategoria(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [AZIENDA_CATEGIMPRESA]
		params.addValue("AZIENDA_CATEGIMPRESA", dto.getAziendaCategimpresa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_R_AZIENDA_CATEGIMPRESA table.
	 * @generated
	 */
	public void update(TaifRAziendaCategImpresaDto dto) throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET AZIENDA_CATEGIMPRESA = :AZIENDA_CATEGIMPRESA ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_CATEGORIA = :ID_CATEGORIA ";

		if (dto.getIdAzienda() == null || dto.getIdCategoria() == null) {
			LOG.error("[TaifRAziendaCategImpresaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifRAziendaCategImpresaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA]
		params.addValue("ID_CATEGORIA", dto.getIdCategoria(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [AZIENDA_CATEGIMPRESA]
		params.addValue("AZIENDA_CATEGIMPRESA", dto.getAziendaCategimpresa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_R_AZIENDA_CATEGIMPRESA table.
	 * @generated
	 */
	public void updateColumnsAziendaCategoriaImpresa(TaifRAziendaCategImpresaDto dto)
			throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::updateColumnsAziendaCategoriaImpresa] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET AZIENDA_CATEGIMPRESA = :AZIENDA_CATEGIMPRESA ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_CATEGORIA = :ID_CATEGORIA ";

		if (dto.getIdAzienda() == null || dto.getIdCategoria() == null) {
			LOG.error(
					"[TaifRAziendaCategImpresaDaoImpl::updateColumnsAziendaCategoriaImpresa] ERROR chiave primaria non impostata");
			throw new TaifRAziendaCategImpresaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [AZIENDA_CATEGIMPRESA]
		params.addValue("AZIENDA_CATEGIMPRESA", dto.getAziendaCategimpresa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA]
		params.addValue("ID_CATEGORIA", dto.getIdCategoria(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::updateColumnsAziendaCategoriaImpresa] END");
	}

	/** 
	 * Deletes a single row in the TAIF_R_AZIENDA_CATEGIMPRESA table.
	 * @generated
	 */

	public void delete(TaifRAziendaCategImpresaPk pk) throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_CATEGORIA = :ID_CATEGORIA ";

		if (pk == null) {
			LOG.error("[TaifRAziendaCategImpresaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifRAziendaCategImpresaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA]
		params.addValue("ID_CATEGORIA", pk.getIdCategoria(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::delete] END");
	}

	protected TaifRAziendaCategImpresaDaoRowMapper findAllRowMapper = new TaifRAziendaCategImpresaDaoRowMapper(null,
			TaifRAziendaCategImpresaDto.class, this);

	protected TaifRAziendaCategImpresaDaoRowMapper byIdAziendaRowMapper = new TaifRAziendaCategImpresaDaoRowMapper(null,
			TaifRAziendaCategImpresaByIdAziendaDto.class, this);

	protected TaifRAziendaCategImpresaDaoRowMapper byIdCategImpresaRowMapper = new TaifRAziendaCategImpresaDaoRowMapper(
			null, TaifRAziendaCategImpresaByIdCategImpresaDto.class, this);

	protected TaifRAziendaCategImpresaDaoRowMapper byIdAziendaIdCategoriaRowMapper = new TaifRAziendaCategImpresaDaoRowMapper(
			null, TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto.class, this);

	protected TaifRAziendaCategImpresaDaoRowMapper findCategoriaImpresaByIdAziendaRowMapper = new TaifRAziendaCategImpresaDaoRowMapper(
			null, TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto.class, this);

	protected TaifRAziendaCategImpresaDaoRowMapper findDettaglioCategoriaImpresaByIdAziendaRowMapper = new TaifRAziendaCategImpresaDaoRowMapper(
			null, TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto.class, this);

	protected TaifRAziendaCategImpresaDaoRowMapper findByPrimaryKeyRowMapper = new TaifRAziendaCategImpresaDaoRowMapper(
			null, TaifRAziendaCategImpresaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_AZIENDA_CATEGIMPRESA";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_AZIENDA_CATEGIMPRESA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAziendaCategImpresaDto> findAll() throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,ID_CATEGORIA,AZIENDA_CATEGIMPRESA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_AZIENDA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifRAziendaCategImpresaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaCategImpresaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifRAziendaCategImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaCategImpresaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azCategImpresa.ID_AZIENDA as idAzienda, azCategImpresa.ID_CATEGORIA as idcategImpresa, azCategImpresa.DATA_INSERIMENTO as dataInserimento, azCategImpresa.AZIENDA_CATEGIMPRESA as aziendaCategImpresa, azCategImpresa.DATA_AGGIORNAMENTO as dataAggiornamento, azCategImpresa.FK_CONFIG_UTENTE as fkConfigUtente");

		sql.append(" FROM TAIF_R_AZIENDA_CATEGIMPRESA azCategImpresa");

		sql.append(" WHERE ");

		sql.append("azCategImpresa.id_azienda=:idAzienda");
		/*PROTECTED REGION ID(R-137363913) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaCategImpresaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaCategImpresaDaoImpl::findByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifRAziendaCategImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaCategImpresaDaoImpl", "findByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdCategImpresa con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaByIdCategImpresaDto> findByIdCategImpresa(java.lang.Integer input)
			throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findByIdCategImpresa] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azCategImpresa.ID_AZIENDA as idAzienda, azCategImpresa.ID_CATEGORIA as idCategImpresa, azCategImpresa.AZIENDA_CATEGIMPRESA as aziendaCategImpresa, azCategImpresa.DATA_INSERIMENTO as dataInserimento");

		sql.append(" FROM TAIF_R_AZIENDA_CATEGIMPRESA azCategImpresa");

		sql.append(" WHERE ");

		sql.append("azCategImpresa.id_categoria=:idCategoria");
		/*PROTECTED REGION ID(R-611518546) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idCategoria", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaCategImpresaByIdCategImpresaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdCategImpresaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaCategImpresaDaoImpl::findByIdCategImpresa] ERROR esecuzione query", ex);
			throw new TaifRAziendaCategImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaCategImpresaDaoImpl", "findByIdCategImpresa", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findByIdCategImpresa] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAziendaIdCategoria con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto> findByIdAziendaIdCategoria(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaImpresaFilter input)
			throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findByIdAziendaIdCategoria] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azCategImpresa.ID_AZIENDA as idAzienda, azCategImpresa.ID_CATEGORIA as idCategImpresa, azCategImpresa.AZIENDA_CATEGIMPRESA as aziendaCategImpresa, azCategImpresa.DATA_INSERIMENTO as dataInserimento");

		sql.append(" FROM TAIF_R_AZIENDA_CATEGIMPRESA azCategImpresa");

		sql.append(" WHERE ");

		sql.append("azCategImpresa.id_azienda=:idAzienda and azCategImpresa.id_categoria=:idCategoria");
		/*PROTECTED REGION ID(R154091713) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("idCategoria", input.getIdCategoria());

		/*PROTECTED REGION END*/

		List<TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaIdCategoriaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaCategImpresaDaoImpl::findByIdAziendaIdCategoria] ERROR esecuzione query", ex);
			throw new TaifRAziendaCategImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaCategImpresaDaoImpl", "findByIdAziendaIdCategoria", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findByIdAziendaIdCategoria] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findCategoriaImpresaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> findFindCategoriaImpresaByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findFindCategoriaImpresaByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azCategImpresa.ID_AZIENDA as idAzienda, azCategImpresa.ID_CATEGORIA as idcategImpresa, azCategImpresa.DATA_INSERIMENTO as dataInserimento, azCategImpresa.AZIENDA_CATEGIMPRESA as aziendaCategImpresa, azCategImpresa.DATA_AGGIORNAMENTO as dataAggiornamento, azCategImpresa.FK_CONFIG_UTENTE as fkConfigUtente, dCategoriaImpresa.CATEGORIA_IMPRESA as categoriaImpresa");

		sql.append(" FROM TAIF_R_AZIENDA_CATEGIMPRESA azCategImpresa, TAIF_D_CATEGORIA_IMPRESA dCategoriaImpresa");

		sql.append(" WHERE ");

		sql.append("azCategImpresa.ID_CATEGORIA = dCategoriaImpresa.ID_CATEGORIA");

		sql.append(" AND ");

		sql.append(
				"azCategImpresa.id_azienda=:idAzienda and dCategoriaImpresa.mtd_flg_visibile=:flagVisibile and  dCategoriaImpresa.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R-1496587894) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findCategoriaImpresaByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaCategImpresaDaoImpl::findFindCategoriaImpresaByIdAzienda] ERROR esecuzione query",
					ex);
			throw new TaifRAziendaCategImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaCategImpresaDaoImpl", "findFindCategoriaImpresaByIdAzienda",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findFindCategoriaImpresaByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findDettaglioCategoriaImpresaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto> findFindDettaglioCategoriaImpresaByIdAzienda(
			java.lang.Integer input) throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findFindDettaglioCategoriaImpresaByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT categoria.CATEGORIA_IMPRESA as categoriaImpresa, categoria.ID_CATEGORIA as idCategoria");

		sql.append(" FROM TAIF_R_AZIENDA_CATEGIMPRESA categImpresa, TAIF_D_CATEGORIA_IMPRESA categoria");

		sql.append(" WHERE ");

		sql.append("categImpresa.ID_CATEGORIA = categoria.ID_CATEGORIA");

		sql.append(" AND ");

		sql.append(
				"categImpresa.id_azienda=:idAziendaSelezionata GROUP BY categoria.categoria_impresa, categoria.id_categoria ORDER BY categoria.id_categoria;");
		/*PROTECTED REGION ID(R-1116932323) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAziendaSelezionata", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findDettaglioCategoriaImpresaByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error(
					"[TaifRAziendaCategImpresaDaoImpl::findFindDettaglioCategoriaImpresaByIdAzienda] ERROR esecuzione query",
					ex);
			throw new TaifRAziendaCategImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaCategImpresaDaoImpl", "findFindDettaglioCategoriaImpresaByIdAzienda",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findFindDettaglioCategoriaImpresaByIdAzienda] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the TAIF_R_AZIENDA_CATEGIMPRESA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAziendaCategImpresaDto findByPrimaryKey(TaifRAziendaCategImpresaPk pk)
			throws TaifRAziendaCategImpresaDaoException {
		LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,ID_CATEGORIA,AZIENDA_CATEGIMPRESA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_CATEGORIA = :ID_CATEGORIA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA]
		params.addValue("ID_CATEGORIA", pk.getIdCategoria(), java.sql.Types.INTEGER);

		List<TaifRAziendaCategImpresaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaCategImpresaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifRAziendaCategImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaCategImpresaDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaCategImpresaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
