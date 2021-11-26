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

/*PROTECTED REGION ID(R1993287633) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTAgenziaFormativa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTAgenziaFormativaDaoImpl extends AbstractDAO implements TaifTAgenziaFormativaDao {
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
	 * Metodo di inserimento del DAO taifTAgenziaFormativa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAgenziaFormativaPk
	 * @generated
	 */

	public TaifTAgenziaFormativaPk insert(TaifTAgenziaFormativaDto dto)

	{
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AGENZIA_FORMATIVA,CODICE_FISCALE,PARTITA_IVA,RAGIONE_SOCIALE,CODICE_PSR,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,ISTAT_SEDE,COMUNE_ESTERO,INDIRIZZO,CAP,FK_CONFIG_UTENTE,FLG_VISIBILE,MTD_ORDINAMENTO ) VALUES (  :ID_AGENZIA_FORMATIVA , :CODICE_FISCALE , :PARTITA_IVA , :RAGIONE_SOCIALE , :CODICE_PSR , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :ISTAT_SEDE , :COMUNE_ESTERO , :INDIRIZZO , :CAP , :FK_CONFIG_UTENTE , :FLG_VISIBILE , :MTD_ORDINAMENTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AGENZIA_FORMATIVA]
		params.addValue("ID_AGENZIA_FORMATIVA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTITA_IVA]
		params.addValue("PARTITA_IVA", dto.getPartitaIva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RAGIONE_SOCIALE]
		params.addValue("RAGIONE_SOCIALE", dto.getRagioneSociale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_PSR]
		params.addValue("CODICE_PSR", dto.getCodicePsr(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ISTAT_SEDE]
		params.addValue("ISTAT_SEDE", dto.getIstatSede(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_VISIBILE]
		params.addValue("FLG_VISIBILE", dto.getFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAgenziaFormativa(newKey);
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_AGENZIA_FORMATIVA table.
	 * @generated
	 */
	public void update(TaifTAgenziaFormativaDto dto) throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET CODICE_FISCALE = :CODICE_FISCALE ,PARTITA_IVA = :PARTITA_IVA ,RAGIONE_SOCIALE = :RAGIONE_SOCIALE ,CODICE_PSR = :CODICE_PSR ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,ISTAT_SEDE = :ISTAT_SEDE ,COMUNE_ESTERO = :COMUNE_ESTERO ,INDIRIZZO = :INDIRIZZO ,CAP = :CAP ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,FLG_VISIBILE = :FLG_VISIBILE ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO  WHERE ID_AGENZIA_FORMATIVA = :ID_AGENZIA_FORMATIVA ";

		if (dto.getIdAgenziaFormativa() == null) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTAgenziaFormativaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AGENZIA_FORMATIVA]
		params.addValue("ID_AGENZIA_FORMATIVA", dto.getIdAgenziaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTITA_IVA]
		params.addValue("PARTITA_IVA", dto.getPartitaIva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RAGIONE_SOCIALE]
		params.addValue("RAGIONE_SOCIALE", dto.getRagioneSociale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_PSR]
		params.addValue("CODICE_PSR", dto.getCodicePsr(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ISTAT_SEDE]
		params.addValue("ISTAT_SEDE", dto.getIstatSede(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_VISIBILE]
		params.addValue("FLG_VISIBILE", dto.getFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_AGENZIA_FORMATIVA table.
	 * @generated
	 */

	public void delete(TaifTAgenziaFormativaPk pk) throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_AGENZIA_FORMATIVA = :ID_AGENZIA_FORMATIVA ";

		if (pk == null) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTAgenziaFormativaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AGENZIA_FORMATIVA]
		params.addValue("ID_AGENZIA_FORMATIVA", pk.getIdAgenziaFormativa(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::delete] END");
	}

	protected TaifTAgenziaFormativaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTAgenziaFormativaDaoRowMapper(null,
			TaifTAgenziaFormativaDto.class, this);

	protected TaifTAgenziaFormativaDaoRowMapper findAllRowMapper = new TaifTAgenziaFormativaDaoRowMapper(null,
			TaifTAgenziaFormativaDto.class, this);

	protected TaifTAgenziaFormativaDaoRowMapper byFilterRowMapper = new TaifTAgenziaFormativaDaoRowMapper(null,
			TaifTAgenziaFormativaByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_AGENZIA_FORMATIVA";
	}

	/** 
	 * Returns all rows from the TAIF_T_AGENZIA_FORMATIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAgenziaFormativaDto findByPrimaryKey(TaifTAgenziaFormativaPk pk)
			throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AGENZIA_FORMATIVA,CODICE_FISCALE,PARTITA_IVA,RAGIONE_SOCIALE,CODICE_PSR,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,ISTAT_SEDE,COMUNE_ESTERO,INDIRIZZO,CAP,FK_CONFIG_UTENTE,FLG_VISIBILE,MTD_ORDINAMENTO FROM "
						+ getTableName() + " WHERE ID_AGENZIA_FORMATIVA = :ID_AGENZIA_FORMATIVA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AGENZIA_FORMATIVA]
		params.addValue("ID_AGENZIA_FORMATIVA", pk.getIdAgenziaFormativa(), java.sql.Types.INTEGER);

		List<TaifTAgenziaFormativaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTAgenziaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAgenziaFormativaDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_AGENZIA_FORMATIVA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAgenziaFormativaDto> findAll() throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AGENZIA_FORMATIVA,CODICE_FISCALE,PARTITA_IVA,RAGIONE_SOCIALE,CODICE_PSR,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,ISTAT_SEDE,COMUNE_ESTERO,INDIRIZZO,CAP,FK_CONFIG_UTENTE,FLG_VISIBILE,MTD_ORDINAMENTO FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_AGENZIA_FORMATIVA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTAgenziaFormativaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTAgenziaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAgenziaFormativaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAgenziaFormativaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTAgenziaFormativaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AgenziaFormativaFilter input)
			throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT agFormativa.ID_AGENZIA_FORMATIVA as id, agFormativa.CODICE_FISCALE as codiceFisc, agFormativa.PARTITA_IVA as piva, agFormativa.RAGIONE_SOCIALE as ragSoc, agFormativa.CODICE_PSR as psr, agFormativa.ISTAT_SEDE as istatSede, agFormativa.COMUNE_ESTERO as estero");

		sql.append(" FROM TAIF_T_AGENZIA_FORMATIVA agFormativa");

		sql.append(" WHERE ");

		sql.append(
				"agFormativa.partita_iva=:piva or agFormativa.codice_fiscale=:codiceFiscale or agFormativa.ragione_sociale=:ragioneSociale or agFormativa.codice_psr=:codicePsr");
		/*PROTECTED REGION ID(R1157991111) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("piva", input.getPartitaIva());
		paramMap.addValue("codiceFiscale", input.getCodiceFiscale());
		paramMap.addValue("ragioneSociale", input.getRagioneSociale());
		paramMap.addValue("codicePsr", input.getCodicePsr());

		/*PROTECTED REGION END*/

		List<TaifTAgenziaFormativaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTAgenziaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAgenziaFormativaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByFilter] END");
		}
		return list;
	}

}
