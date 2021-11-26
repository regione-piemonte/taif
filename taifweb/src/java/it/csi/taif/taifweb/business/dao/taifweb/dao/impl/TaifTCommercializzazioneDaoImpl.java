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

/*PROTECTED REGION ID(R-1001039283) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTCommercializzazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byAzienda (datagen::CustomFinder)
 *   - specieByIdSpecieVisible (datagen::CustomFinder)
 *   - provenienzaByIdProvenienzaVisible (datagen::CustomFinder)
 *   - assortimentoByIdAssortimentoVisible (datagen::CustomFinder)
 *   - commUmByIdUnitaMisuraVisible (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - peridAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTCommercializzazioneDaoImpl extends AbstractDAO implements TaifTCommercializzazioneDao {
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
	 * Metodo di inserimento del DAO taifTCommercializzazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTCommercializzazionePk
	 * @generated
	 */

	public TaifTCommercializzazionePk insert(TaifTCommercializzazioneDto dto)

	{
		LOG.debug("[TaifTCommercializzazioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_COMMERCIALIZZAZIONE,FK_AZIENDA,FK_SPECIE,FK_PROVENIENZA,FK_DESTINAZIONE,FK_ASSORTIMENTO,FK_UNITA_DI_MISURA,VENDUTO_MEDIO,FLG_TAGLIATO_ACQUISTATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,NOTE ) VALUES (  :ID_COMMERCIALIZZAZIONE , :FK_AZIENDA , :FK_SPECIE , :FK_PROVENIENZA , :FK_DESTINAZIONE , :FK_ASSORTIMENTO , :FK_UNITA_DI_MISURA , :VENDUTO_MEDIO , :FLG_TAGLIATO_ACQUISTATO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE , :NOTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMMERCIALIZZAZIONE]
		params.addValue("ID_COMMERCIALIZZAZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SPECIE]
		params.addValue("FK_SPECIE", dto.getFkSpecie(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PROVENIENZA]
		params.addValue("FK_PROVENIENZA", dto.getFkProvenienza(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_DESTINAZIONE]
		params.addValue("FK_DESTINAZIONE", dto.getFkDestinazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ASSORTIMENTO]
		params.addValue("FK_ASSORTIMENTO", dto.getFkAssortimento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_DI_MISURA]
		params.addValue("FK_UNITA_DI_MISURA", dto.getFkUnitaDiMisura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [VENDUTO_MEDIO]
		params.addValue("VENDUTO_MEDIO", dto.getVendutoMedio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_TAGLIATO_ACQUISTATO]
		params.addValue("FLG_TAGLIATO_ACQUISTATO", dto.getFlgTagliatoAcquistato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdCommercializzazione(newKey);
		LOG.debug("[TaifTCommercializzazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_COMMERCIALIZZAZIONE table.
	 * @generated
	 */
	public void update(TaifTCommercializzazioneDto dto) throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_SPECIE = :FK_SPECIE ,FK_PROVENIENZA = :FK_PROVENIENZA ,FK_DESTINAZIONE = :FK_DESTINAZIONE ,FK_ASSORTIMENTO = :FK_ASSORTIMENTO ,FK_UNITA_DI_MISURA = :FK_UNITA_DI_MISURA ,VENDUTO_MEDIO = :VENDUTO_MEDIO ,FLG_TAGLIATO_ACQUISTATO = :FLG_TAGLIATO_ACQUISTATO ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,NOTE = :NOTE  WHERE ID_COMMERCIALIZZAZIONE = :ID_COMMERCIALIZZAZIONE ";

		if (dto.getIdCommercializzazione() == null) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTCommercializzazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMMERCIALIZZAZIONE]
		params.addValue("ID_COMMERCIALIZZAZIONE", dto.getIdCommercializzazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SPECIE]
		params.addValue("FK_SPECIE", dto.getFkSpecie(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PROVENIENZA]
		params.addValue("FK_PROVENIENZA", dto.getFkProvenienza(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_DESTINAZIONE]
		params.addValue("FK_DESTINAZIONE", dto.getFkDestinazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ASSORTIMENTO]
		params.addValue("FK_ASSORTIMENTO", dto.getFkAssortimento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_DI_MISURA]
		params.addValue("FK_UNITA_DI_MISURA", dto.getFkUnitaDiMisura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [VENDUTO_MEDIO]
		params.addValue("VENDUTO_MEDIO", dto.getVendutoMedio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_TAGLIATO_ACQUISTATO]
		params.addValue("FLG_TAGLIATO_ACQUISTATO", dto.getFlgTagliatoAcquistato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTCommercializzazioneDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_COMMERCIALIZZAZIONE table.
	 * @generated
	 */
	public void updateColumnsPeridAzienda(TaifTCommercializzazioneDto dto) throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::updateColumnsPeridAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_SPECIE = :FK_SPECIE ,FK_PROVENIENZA = :FK_PROVENIENZA ,FK_DESTINAZIONE = :FK_DESTINAZIONE ,FK_ASSORTIMENTO = :FK_ASSORTIMENTO ,FK_UNITA_DI_MISURA = :FK_UNITA_DI_MISURA ,VENDUTO_MEDIO = :VENDUTO_MEDIO ,FLG_TAGLIATO_ACQUISTATO = :FLG_TAGLIATO_ACQUISTATO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,NOTE = :NOTE  WHERE ID_COMMERCIALIZZAZIONE = :ID_COMMERCIALIZZAZIONE ";

		if (dto.getIdCommercializzazione() == null) {
			LOG.error(
					"[TaifTCommercializzazioneDaoImpl::updateColumnsPeridAzienda] ERROR chiave primaria non impostata");
			throw new TaifTCommercializzazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_SPECIE]
		params.addValue("FK_SPECIE", dto.getFkSpecie(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PROVENIENZA]
		params.addValue("FK_PROVENIENZA", dto.getFkProvenienza(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_DESTINAZIONE]
		params.addValue("FK_DESTINAZIONE", dto.getFkDestinazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ASSORTIMENTO]
		params.addValue("FK_ASSORTIMENTO", dto.getFkAssortimento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_DI_MISURA]
		params.addValue("FK_UNITA_DI_MISURA", dto.getFkUnitaDiMisura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [VENDUTO_MEDIO]
		params.addValue("VENDUTO_MEDIO", dto.getVendutoMedio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_TAGLIATO_ACQUISTATO]
		params.addValue("FLG_TAGLIATO_ACQUISTATO", dto.getFlgTagliatoAcquistato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_COMMERCIALIZZAZIONE]
		params.addValue("ID_COMMERCIALIZZAZIONE", dto.getIdCommercializzazione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTCommercializzazioneDaoImpl::updateColumnsPeridAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_COMMERCIALIZZAZIONE table.
	 * @generated
	 */

	public void delete(TaifTCommercializzazionePk pk) throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_COMMERCIALIZZAZIONE = :ID_COMMERCIALIZZAZIONE ";

		if (pk == null) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTCommercializzazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMMERCIALIZZAZIONE]
		params.addValue("ID_COMMERCIALIZZAZIONE", pk.getIdCommercializzazione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTCommercializzazioneDaoImpl::delete] END");
	}

	protected TaifTCommercializzazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifTCommercializzazioneDaoRowMapper(
			null, TaifTCommercializzazioneDto.class, this);

	protected TaifTCommercializzazioneDaoRowMapper findAllRowMapper = new TaifTCommercializzazioneDaoRowMapper(null,
			TaifTCommercializzazioneDto.class, this);

	protected TaifTCommercializzazioneDaoRowMapper byFilterRowMapper = new TaifTCommercializzazioneDaoRowMapper(null,
			TaifTCommercializzazioneByFilterDto.class, this);

	protected TaifTCommercializzazioneDaoRowMapper byAziendaRowMapper = new TaifTCommercializzazioneDaoRowMapper(null,
			TaifTCommercializzazioneByAziendaDto.class, this);

	protected TaifTCommercializzazioneDaoRowMapper specieByIdSpecieVisibleRowMapper = new TaifTCommercializzazioneDaoRowMapper(
			null, TaifTCommercializzazioneSpecieByIdSpecieVisibleDto.class, this);

	protected TaifTCommercializzazioneDaoRowMapper provenienzaByIdProvenienzaVisibleRowMapper = new TaifTCommercializzazioneDaoRowMapper(
			null, TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto.class, this);

	protected TaifTCommercializzazioneDaoRowMapper assortimentoByIdAssortimentoVisibleRowMapper = new TaifTCommercializzazioneDaoRowMapper(
			null, TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto.class, this);

	protected TaifTCommercializzazioneDaoRowMapper commUmByIdUnitaMisuraVisibleRowMapper = new TaifTCommercializzazioneDaoRowMapper(
			null, TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_COMMERCIALIZZAZIONE";
	}

	/** 
	 * Returns all rows from the TAIF_T_COMMERCIALIZZAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTCommercializzazioneDto findByPrimaryKey(TaifTCommercializzazionePk pk)
			throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_COMMERCIALIZZAZIONE,FK_AZIENDA,FK_SPECIE,FK_PROVENIENZA,FK_DESTINAZIONE,FK_ASSORTIMENTO,FK_UNITA_DI_MISURA,VENDUTO_MEDIO,FLG_TAGLIATO_ACQUISTATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,NOTE FROM "
						+ getTableName() + " WHERE ID_COMMERCIALIZZAZIONE = :ID_COMMERCIALIZZAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMMERCIALIZZAZIONE]
		params.addValue("ID_COMMERCIALIZZAZIONE", pk.getIdCommercializzazione(), java.sql.Types.INTEGER);

		List<TaifTCommercializzazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTCommercializzazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCommercializzazioneDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTCommercializzazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_COMMERCIALIZZAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTCommercializzazioneDto> findAll() throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_COMMERCIALIZZAZIONE,FK_AZIENDA,FK_SPECIE,FK_PROVENIENZA,FK_DESTINAZIONE,FK_ASSORTIMENTO,FK_UNITA_DI_MISURA,VENDUTO_MEDIO,FLG_TAGLIATO_ACQUISTATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,NOTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_COMMERCIALIZZAZIONE ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTCommercializzazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTCommercializzazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCommercializzazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCommercializzazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CommercializzazioneFilter input)
			throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT comm.ID_COMMERCIALIZZAZIONE as id, comm.VENDUTO_MEDIO as venduto, comm.NOTE as note");

		sql.append(" FROM TAIF_T_COMMERCIALIZZAZIONE comm");

		sql.append(" WHERE ");

		sql.append(
				"comm.fk_specie=:specie and comm.fk_provenienza=:provenienza and comm.fk_destinazione=:destinazione and comm.fk_assortimento=:assortimento  and comm.flg_tagliato_acquistato=:tagliato ");
		/*PROTECTED REGION ID(R-1899246834) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("provenienza", input.getIdProvenienza());
		paramMap.addValue("destinazione", input.getIdDestinazione());
		paramMap.addValue("assortimento", input.getIdAssortimento());
		paramMap.addValue("tagliato", input.getFlgTagliatoAcq());

		/*PROTECTED REGION END*/

		List<TaifTCommercializzazioneByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTCommercializzazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCommercializzazioneDaoImpl", "findByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTCommercializzazioneDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAzienda con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneByAziendaDto> findByAzienda(java.lang.Integer input)
			throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::findByAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT comm.ID_COMMERCIALIZZAZIONE as id, comm.VENDUTO_MEDIO as venduto, comm.NOTE as note, comm.FK_AZIENDA as idAzienda, comm.FK_SPECIE as idSpecie, comm.FK_PROVENIENZA as idProvenienza, comm.FK_DESTINAZIONE as idDestinazione, comm.FK_ASSORTIMENTO as idAssortimento, comm.FK_UNITA_DI_MISURA as idUnMis, comm.VENDUTO_MEDIO as vendutoMedio, comm.FLG_TAGLIATO_ACQUISTATO as flgTagliato, comm.FK_CONFIG_UTENTE as idUtente");

		sql.append(" FROM TAIF_T_COMMERCIALIZZAZIONE comm");

		sql.append(" WHERE ");

		sql.append("comm.FK_AZIENDA=:idAzienda");
		/*PROTECTED REGION ID(R559606100) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTCommercializzazioneByAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::findByAzienda] ERROR esecuzione query", ex);
			throw new TaifTCommercializzazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCommercializzazioneDaoImpl", "findByAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTCommercializzazioneDaoImpl::findByAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder specieByIdSpecieVisible con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneSpecieByIdSpecieVisibleDto> findSpecieByIdSpecieVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.SpecieFilter input)
			throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::findSpecieByIdSpecieVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT specieTab.NOME_SPECIE as nomeSpecie");

		sql.append(" FROM TAIF_T_COMMERCIALIZZAZIONE commercializzazioneTab, TAIF_D_SPECIE specieTab");

		sql.append(" WHERE ");

		sql.append("commercializzazioneTab.FK_SPECIE = specieTab.ID_SPECIE");

		sql.append(" AND ");

		sql.append(
				"commercializzazioneTab.fk_specie=:idSpecie and specieTab.mtd_flg_visibile=:flagVisibile and specieTab.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R-242940543) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idSpecie", input.getIdSpecie());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTCommercializzazioneSpecieByIdSpecieVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, specieByIdSpecieVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::findSpecieByIdSpecieVisible] ERROR esecuzione query", ex);
			throw new TaifTCommercializzazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCommercializzazioneDaoImpl", "findSpecieByIdSpecieVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTCommercializzazioneDaoImpl::findSpecieByIdSpecieVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder provenienzaByIdProvenienzaVisible con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto> findProvenienzaByIdProvenienzaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ProvenienzaFilter input)
			throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::findProvenienzaByIdProvenienzaVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT provenienzaDestinTab.PROV_DESTIN as provenienza");

		sql.append(" FROM TAIF_T_COMMERCIALIZZAZIONE commercializzazioneTab, TAIF_D_PROV_DESTIN provenienzaDestinTab");

		sql.append(" WHERE ");

		sql.append("commercializzazioneTab.FK_PROVENIENZA = provenienzaDestinTab.ID_PROV_DESTIN");

		sql.append(" AND ");

		sql.append(
				"commercializzazioneTab.fk_provenienza=:idProvenienza and provenienzaDestinTab.mtd_flg_visibile=:flagVisibile and provenienzaDestinTab.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R-1505399153) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idProvenienza", input.getIdProvenienza());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, provenienzaByIdProvenienzaVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::findProvenienzaByIdProvenienzaVisible] ERROR esecuzione query",
					ex);
			throw new TaifTCommercializzazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCommercializzazioneDaoImpl", "findProvenienzaByIdProvenienzaVisible",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTCommercializzazioneDaoImpl::findProvenienzaByIdProvenienzaVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder assortimentoByIdAssortimentoVisible con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto> findAssortimentoByIdAssortimentoVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AssortimentoFilter input)
			throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::findAssortimentoByIdAssortimentoVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT asortimentoTab.ASSORTIMENTO as assortimento");

		sql.append(" FROM TAIF_T_COMMERCIALIZZAZIONE commercializzazioneTab, TAIF_D_ASSORTIMENTO asortimentoTab");

		sql.append(" WHERE ");

		sql.append("commercializzazioneTab.FK_ASSORTIMENTO = asortimentoTab.ID_ASSORTIMENTO");

		sql.append(" AND ");

		sql.append(
				"commercializzazioneTab.fk_assortimento=:idAssortimento and asortimentoTab.mtd_flg_visibile=:flagVisibile and asortimentoTab.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R818477763) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAssortimento", input.getIdAssortimento());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, assortimentoByIdAssortimentoVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error(
					"[TaifTCommercializzazioneDaoImpl::findAssortimentoByIdAssortimentoVisible] ERROR esecuzione query",
					ex);
			throw new TaifTCommercializzazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCommercializzazioneDaoImpl", "findAssortimentoByIdAssortimentoVisible",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTCommercializzazioneDaoImpl::findAssortimentoByIdAssortimentoVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder commUmByIdUnitaMisuraVisible con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto> findCommUmByIdUnitaMisuraVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaMisuraFilter input)
			throws TaifTCommercializzazioneDaoException {
		LOG.debug("[TaifTCommercializzazioneDaoImpl::findCommUmByIdUnitaMisuraVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT umTab.UNITA_DI_MISURA as unitaMisura");

		sql.append(" FROM TAIF_T_COMMERCIALIZZAZIONE commercializzazioneTab, TAIF_D_UNITA_DI_MISURA umTab");

		sql.append(" WHERE ");

		sql.append("commercializzazioneTab.FK_UNITA_DI_MISURA = umTab.ID_UNITA_DI_MISURA");

		sql.append(" AND ");

		sql.append("commercializzazioneTab.fk_unita_di_misura=:idUnitaMisura and umTab.mtd_flg_visibile=:flagVisibile");
		/*PROTECTED REGION ID(R72660895) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idUnitaMisura", input.getIdUnitaMisura());
		paramMap.addValue("flagVisibile", input.getFlagVisible());

		/*PROTECTED REGION END*/

		List<TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, commUmByIdUnitaMisuraVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCommercializzazioneDaoImpl::findCommUmByIdUnitaMisuraVisible] ERROR esecuzione query", ex);
			throw new TaifTCommercializzazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCommercializzazioneDaoImpl", "findCommUmByIdUnitaMisuraVisible",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTCommercializzazioneDaoImpl::findCommUmByIdUnitaMisuraVisible] END");
		}
		return list;
	}

}
