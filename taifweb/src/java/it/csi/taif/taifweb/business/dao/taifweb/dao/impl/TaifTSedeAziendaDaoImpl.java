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

/*PROTECTED REGION ID(R23530025) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTSedeAzienda.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byIdAzienda (datagen::CustomFinder)
 *   - idMaxValue (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - updateColSediAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTSedeAziendaDaoImpl extends AbstractDAO implements TaifTSedeAziendaDao {
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
	 * Metodo di inserimento del DAO taifTSedeAzienda. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTSedeAziendaPk
	 * @generated
	 */

	public TaifTSedeAziendaPk insert(TaifTSedeAziendaDto dto)

	{
		LOG.debug("[TaifTSedeAziendaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_SEDE,FK_AZIENDA,FK_TIPO_SEDE,ISTAT_COMUNE,COMUNE_ESTERO,INDIRIZZO,CIVICO,CAP,TELEFONO,CELLULARE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_SEDE , :FK_AZIENDA , :FK_TIPO_SEDE , :ISTAT_COMUNE , :COMUNE_ESTERO , :INDIRIZZO , :CIVICO , :CAP , :TELEFONO , :CELLULARE , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SEDE]
		params.addValue("ID_SEDE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_SEDE]
		params.addValue("FK_TIPO_SEDE", dto.getFkTipoSede(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdSede(newKey);
		LOG.debug("[TaifTSedeAziendaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_SEDE_AZIENDA table.
	 * @generated
	 */
	public void update(TaifTSedeAziendaDto dto) throws TaifTSedeAziendaDaoException {
		LOG.debug("[TaifTSedeAziendaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_TIPO_SEDE = :FK_TIPO_SEDE ,ISTAT_COMUNE = :ISTAT_COMUNE ,COMUNE_ESTERO = :COMUNE_ESTERO ,INDIRIZZO = :INDIRIZZO ,CIVICO = :CIVICO ,CAP = :CAP ,TELEFONO = :TELEFONO ,CELLULARE = :CELLULARE ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_SEDE = :ID_SEDE ";

		if (dto.getIdSede() == null) {
			LOG.error("[TaifTSedeAziendaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTSedeAziendaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SEDE]
		params.addValue("ID_SEDE", dto.getIdSede(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_SEDE]
		params.addValue("FK_TIPO_SEDE", dto.getFkTipoSede(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTSedeAziendaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_SEDE_AZIENDA table.
	 * @generated
	 */
	public void updateColumnsUpdateColSediAzienda(TaifTSedeAziendaDto dto) throws TaifTSedeAziendaDaoException {
		LOG.debug("[TaifTSedeAziendaDaoImpl::updateColumnsUpdateColSediAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TIPO_SEDE = :FK_TIPO_SEDE ,ISTAT_COMUNE = :ISTAT_COMUNE ,COMUNE_ESTERO = :COMUNE_ESTERO ,INDIRIZZO = :INDIRIZZO ,CIVICO = :CIVICO ,CAP = :CAP ,TELEFONO = :TELEFONO ,CELLULARE = :CELLULARE ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_SEDE = :ID_SEDE ";

		if (dto.getIdSede() == null) {
			LOG.error(
					"[TaifTSedeAziendaDaoImpl::updateColumnsUpdateColSediAzienda] ERROR chiave primaria non impostata");
			throw new TaifTSedeAziendaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_SEDE]
		params.addValue("FK_TIPO_SEDE", dto.getFkTipoSede(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_SEDE]
		params.addValue("ID_SEDE", dto.getIdSede(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTSedeAziendaDaoImpl::updateColumnsUpdateColSediAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_SEDE_AZIENDA table.
	 * @generated
	 */

	public void delete(TaifTSedeAziendaPk pk) throws TaifTSedeAziendaDaoException {
		LOG.debug("[TaifTSedeAziendaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_SEDE = :ID_SEDE ";

		if (pk == null) {
			LOG.error("[TaifTSedeAziendaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTSedeAziendaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SEDE]
		params.addValue("ID_SEDE", pk.getIdSede(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTSedeAziendaDaoImpl::delete] END");
	}

	protected TaifTSedeAziendaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTSedeAziendaDaoRowMapper(null,
			TaifTSedeAziendaDto.class, this);

	protected TaifTSedeAziendaDaoRowMapper findAllRowMapper = new TaifTSedeAziendaDaoRowMapper(null,
			TaifTSedeAziendaDto.class, this);

	protected TaifTSedeAziendaDaoRowMapper byIdAziendaRowMapper = new TaifTSedeAziendaDaoRowMapper(null,
			TaifTSedeAziendaByIdAziendaDto.class, this);

	protected TaifTSedeAziendaDaoRowMapper idMaxValueRowMapper = new TaifTSedeAziendaDaoRowMapper(null,
			TaifTSedeAziendaIdMaxValueDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_SEDE_AZIENDA";
	}

	/** 
	 * Returns all rows from the TAIF_T_SEDE_AZIENDA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTSedeAziendaDto findByPrimaryKey(TaifTSedeAziendaPk pk) throws TaifTSedeAziendaDaoException {
		LOG.debug("[TaifTSedeAziendaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_SEDE,FK_AZIENDA,FK_TIPO_SEDE,ISTAT_COMUNE,COMUNE_ESTERO,INDIRIZZO,CIVICO,CAP,TELEFONO,CELLULARE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_SEDE = :ID_SEDE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SEDE]
		params.addValue("ID_SEDE", pk.getIdSede(), java.sql.Types.INTEGER);

		List<TaifTSedeAziendaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTSedeAziendaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTSedeAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTSedeAziendaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTSedeAziendaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_SEDE_AZIENDA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTSedeAziendaDto> findAll() throws TaifTSedeAziendaDaoException {
		LOG.debug("[TaifTSedeAziendaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_SEDE,FK_AZIENDA,FK_TIPO_SEDE,ISTAT_COMUNE,COMUNE_ESTERO,INDIRIZZO,CIVICO,CAP,TELEFONO,CELLULARE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_SEDE ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTSedeAziendaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTSedeAziendaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTSedeAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTSedeAziendaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTSedeAziendaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTSedeAziendaByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifTSedeAziendaDaoException {
		LOG.debug("[TaifTSedeAziendaDaoImpl::findByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT sedeAzienda.ID_SEDE as id, sedeAzienda.FK_AZIENDA as idAzienda, sedeAzienda.FK_TIPO_SEDE as idTipo, sedeAzienda.ISTAT_COMUNE as istatComune, sedeAzienda.COMUNE_ESTERO as estero, sedeAzienda.INDIRIZZO as indirizzo, sede.TIPO_SEDE as tipoSede, sedeAzienda.CIVICO as civico, sedeAzienda.CAP as cap, sedeAzienda.TELEFONO as telefon, sedeAzienda.CELLULARE as cellulare, sede.TIPO_SEDE as descrizioneTipoSede, sedeAzienda.COMUNE_ESTERO as comune");

		sql.append(" FROM TAIF_T_SEDE_AZIENDA sedeAzienda, TAIF_D_TIPO_SEDE_AZIENDA sede");

		sql.append(" WHERE ");

		sql.append("sede.ID_TIPO_SEDE = sedeAzienda.FK_TIPO_SEDE");

		sql.append(" AND ");

		sql.append("sedeAzienda.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R78053921) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTSedeAziendaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTSedeAziendaDaoImpl::findByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTSedeAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTSedeAziendaDaoImpl", "findByIdAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTSedeAziendaDaoImpl::findByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder idMaxValue con Qdef
		 * @generated
		 */

	public List<TaifTSedeAziendaIdMaxValueDto> findIdMaxValue(java.lang.Integer input)
			throws TaifTSedeAziendaDaoException {
		LOG.debug("[TaifTSedeAziendaDaoImpl::findIdMaxValue] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT max(id_sede) AS max");

		sql.append(" FROM TAIF_T_SEDE_AZIENDA sede");

		List<TaifTSedeAziendaIdMaxValueDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, idMaxValueRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTSedeAziendaDaoImpl::findIdMaxValue] ERROR esecuzione query", ex);
			throw new TaifTSedeAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTSedeAziendaDaoImpl", "findIdMaxValue", "esecuzione query", sql.toString());
			LOG.debug("[TaifTSedeAziendaDaoImpl::findIdMaxValue] END");
		}
		return list;
	}

}
