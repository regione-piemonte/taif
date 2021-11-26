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
import it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter;
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

/*PROTECTED REGION ID(R-1448643845) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTPersona.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byConfigUtente (datagen::CustomFinder)
 *   - byProfiloPersona (datagen::CustomFinder)
 *   - titoloStudioByIdTitoleStudioVisibileIta (datagen::CustomFinder)
 *   - titoloStudioByIdTitoleStudioVisibileFra (datagen::CustomFinder)
 *   - byCodiceFiscalePersona (datagen::CustomFinder)
 *   - byCodiceFiscalePersonaPerContratto (datagen::CustomFinder)
 *   - loginInfo (datagen::CustomFinder)
 *   - profiloUtenteByCodiceFiscale (datagen::CustomFinder)
 *   - byIdAzienda (datagen::CustomFinder)
 *   - byNrSiMsaPersonaFrancese (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - forTitolareRappresentante (datagen::UpdateColumns)
 * - DELETERS:
 *   - deletePersonaByCodiceFiscale (datagen::CustomDeleter)
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTPersonaDaoImpl extends AbstractDAO implements TaifTPersonaDao {
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
	 * Metodo di inserimento del DAO taifTPersona. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTPersonaPk
	 * @generated
	 */

	public TaifTPersonaPk insert(TaifTPersonaDto dto)

	{
		LOG.debug("[TaifTPersonaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA,FK_TITOLO_STUDIO,FK_TITOLO_STUDIO_FRA,FK_NAZIONE,CODICE_FISCALE,N_RSI_MSA,COGNOME,NOME,FLG_SESSO,DATA_NASCITA,ISTAT_COMUNE_NASCITA,COMUNE_ESTERO_NASCITA,ISTAT_COMUNE_RES,COMUNE_ESTERO_RES,INDIRIZZO_RES,CIVICO_RES,CAP_RES,TELEFONO,CELLULARE,MAIL,ALTRI_STUDI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,PWD ) VALUES (  :ID_PERSONA , :FK_TITOLO_STUDIO , :FK_TITOLO_STUDIO_FRA , :FK_NAZIONE , :CODICE_FISCALE , :N_RSI_MSA , :COGNOME , :NOME , :FLG_SESSO , :DATA_NASCITA , :ISTAT_COMUNE_NASCITA , :COMUNE_ESTERO_NASCITA , :ISTAT_COMUNE_RES , :COMUNE_ESTERO_RES , :INDIRIZZO_RES , :CIVICO_RES , :CAP_RES , :TELEFONO , :CELLULARE , :MAIL , :ALTRI_STUDI , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE , :PWD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TITOLO_STUDIO]
		params.addValue("FK_TITOLO_STUDIO", dto.getFkTitoloStudio(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TITOLO_STUDIO_FRA]
		params.addValue("FK_TITOLO_STUDIO_FRA", dto.getFkTitoloStudioFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_NAZIONE]
		params.addValue("FK_NAZIONE", dto.getFkNazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_RSI_MSA]
		params.addValue("N_RSI_MSA", dto.getNRsiMsa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SESSO]
		params.addValue("FLG_SESSO", dto.getFlgSesso(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_NASCITA]
		params.addValue("DATA_NASCITA", dto.getDataNascita(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_NASCITA]
		params.addValue("ISTAT_COMUNE_NASCITA", dto.getIstatComuneNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_NASCITA]
		params.addValue("COMUNE_ESTERO_NASCITA", dto.getComuneEsteroNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_RES]
		params.addValue("ISTAT_COMUNE_RES", dto.getIstatComuneRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_RES]
		params.addValue("COMUNE_ESTERO_RES", dto.getComuneEsteroRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_RES]
		params.addValue("INDIRIZZO_RES", dto.getIndirizzoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO_RES]
		params.addValue("CIVICO_RES", dto.getCivicoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP_RES]
		params.addValue("CAP_RES", dto.getCapRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL]
		params.addValue("MAIL", dto.getMail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ALTRI_STUDI]
		params.addValue("ALTRI_STUDI", dto.getAltriStudi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PWD]
		params.addValue("PWD", dto.getPwd(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdPersona(newKey);
		LOG.debug("[TaifTPersonaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_PERSONA table.
	 * @generated
	 */
	public void update(TaifTPersonaDto dto) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TITOLO_STUDIO = :FK_TITOLO_STUDIO ,FK_TITOLO_STUDIO_FRA = :FK_TITOLO_STUDIO_FRA ,FK_NAZIONE = :FK_NAZIONE ,CODICE_FISCALE = :CODICE_FISCALE ,N_RSI_MSA = :N_RSI_MSA ,COGNOME = :COGNOME ,NOME = :NOME ,FLG_SESSO = :FLG_SESSO ,DATA_NASCITA = :DATA_NASCITA ,ISTAT_COMUNE_NASCITA = :ISTAT_COMUNE_NASCITA ,COMUNE_ESTERO_NASCITA = :COMUNE_ESTERO_NASCITA ,ISTAT_COMUNE_RES = :ISTAT_COMUNE_RES ,COMUNE_ESTERO_RES = :COMUNE_ESTERO_RES ,INDIRIZZO_RES = :INDIRIZZO_RES ,CIVICO_RES = :CIVICO_RES ,CAP_RES = :CAP_RES ,TELEFONO = :TELEFONO ,CELLULARE = :CELLULARE ,MAIL = :MAIL ,ALTRI_STUDI = :ALTRI_STUDI ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,PWD = :PWD  WHERE ID_PERSONA = :ID_PERSONA ";

		if (dto.getIdPersona() == null) {
			LOG.error("[TaifTPersonaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTPersonaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TITOLO_STUDIO]
		params.addValue("FK_TITOLO_STUDIO", dto.getFkTitoloStudio(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TITOLO_STUDIO_FRA]
		params.addValue("FK_TITOLO_STUDIO_FRA", dto.getFkTitoloStudioFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_NAZIONE]
		params.addValue("FK_NAZIONE", dto.getFkNazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_RSI_MSA]
		params.addValue("N_RSI_MSA", dto.getNRsiMsa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SESSO]
		params.addValue("FLG_SESSO", dto.getFlgSesso(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_NASCITA]
		params.addValue("DATA_NASCITA", dto.getDataNascita(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_NASCITA]
		params.addValue("ISTAT_COMUNE_NASCITA", dto.getIstatComuneNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_NASCITA]
		params.addValue("COMUNE_ESTERO_NASCITA", dto.getComuneEsteroNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_RES]
		params.addValue("ISTAT_COMUNE_RES", dto.getIstatComuneRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_RES]
		params.addValue("COMUNE_ESTERO_RES", dto.getComuneEsteroRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_RES]
		params.addValue("INDIRIZZO_RES", dto.getIndirizzoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO_RES]
		params.addValue("CIVICO_RES", dto.getCivicoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP_RES]
		params.addValue("CAP_RES", dto.getCapRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL]
		params.addValue("MAIL", dto.getMail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ALTRI_STUDI]
		params.addValue("ALTRI_STUDI", dto.getAltriStudi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PWD]
		params.addValue("PWD", dto.getPwd(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPersonaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_PERSONA table.
	 * @generated
	 */
	public void updateColumnsForTitolareRappresentante(TaifTPersonaDto dto) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::updateColumnsForTitolareRappresentante] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TITOLO_STUDIO = :FK_TITOLO_STUDIO ,FK_TITOLO_STUDIO_FRA = :FK_TITOLO_STUDIO_FRA ,FK_NAZIONE = :FK_NAZIONE ,N_RSI_MSA = :N_RSI_MSA ,FLG_SESSO = :FLG_SESSO ,DATA_NASCITA = :DATA_NASCITA ,ISTAT_COMUNE_NASCITA = :ISTAT_COMUNE_NASCITA ,COMUNE_ESTERO_NASCITA = :COMUNE_ESTERO_NASCITA ,ISTAT_COMUNE_RES = :ISTAT_COMUNE_RES ,COMUNE_ESTERO_RES = :COMUNE_ESTERO_RES ,INDIRIZZO_RES = :INDIRIZZO_RES ,CIVICO_RES = :CIVICO_RES ,CAP_RES = :CAP_RES ,TELEFONO = :TELEFONO ,CELLULARE = :CELLULARE ,MAIL = :MAIL ,ALTRI_STUDI = :ALTRI_STUDI ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_PERSONA = :ID_PERSONA ";

		if (dto.getIdPersona() == null) {
			LOG.error(
					"[TaifTPersonaDaoImpl::updateColumnsForTitolareRappresentante] ERROR chiave primaria non impostata");
			throw new TaifTPersonaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TITOLO_STUDIO]
		params.addValue("FK_TITOLO_STUDIO", dto.getFkTitoloStudio(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TITOLO_STUDIO_FRA]
		params.addValue("FK_TITOLO_STUDIO_FRA", dto.getFkTitoloStudioFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_NAZIONE]
		params.addValue("FK_NAZIONE", dto.getFkNazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [N_RSI_MSA]
		params.addValue("N_RSI_MSA", dto.getNRsiMsa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SESSO]
		params.addValue("FLG_SESSO", dto.getFlgSesso(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_NASCITA]
		params.addValue("DATA_NASCITA", dto.getDataNascita(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_NASCITA]
		params.addValue("ISTAT_COMUNE_NASCITA", dto.getIstatComuneNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_NASCITA]
		params.addValue("COMUNE_ESTERO_NASCITA", dto.getComuneEsteroNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_RES]
		params.addValue("ISTAT_COMUNE_RES", dto.getIstatComuneRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_RES]
		params.addValue("COMUNE_ESTERO_RES", dto.getComuneEsteroRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_RES]
		params.addValue("INDIRIZZO_RES", dto.getIndirizzoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO_RES]
		params.addValue("CIVICO_RES", dto.getCivicoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP_RES]
		params.addValue("CAP_RES", dto.getCapRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL]
		params.addValue("MAIL", dto.getMail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ALTRI_STUDI]
		params.addValue("ALTRI_STUDI", dto.getAltriStudi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPersonaDaoImpl::updateColumnsForTitolareRappresentante] END");
	}

	/** 
	 * Custom deleter in the TAIF_T_PERSONA table.
	 * @generated
	 */
	public void customDeleterDeletePersonaByCodiceFiscale(java.lang.String filter) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::customDeleterDeletePersonaByCodiceFiscale] START");
		/*PROTECTED REGION ID(R-1038739114) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("CODICE_FISCALE", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPersonaDaoImpl::customDeleterDeletePersonaByCodiceFiscale] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_PERSONA table.
	 * @generated
	 */

	public void delete(TaifTPersonaPk pk) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_PERSONA = :ID_PERSONA ";

		if (pk == null) {
			LOG.error("[TaifTPersonaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTPersonaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPersonaDaoImpl::delete] END");
	}

	protected TaifTPersonaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaDto.class, this);

	protected TaifTPersonaDaoRowMapper findAllRowMapper = new TaifTPersonaDaoRowMapper(null, TaifTPersonaDto.class,
			this);

	protected TaifTPersonaDaoRowMapper byFilterRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByFilterDto.class, this);

	protected TaifTPersonaDaoRowMapper byConfigUtenteRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByConfigUtenteDto.class, this);

	protected TaifTPersonaDaoRowMapper byProfiloPersonaRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByProfiloPersonaDto.class, this);

	protected TaifTPersonaDaoRowMapper titoloStudioByIdTitoleStudioVisibileItaRowMapper = new TaifTPersonaDaoRowMapper(
			null, TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto.class, this);

	protected TaifTPersonaDaoRowMapper titoloStudioByIdTitoleStudioVisibileFraRowMapper = new TaifTPersonaDaoRowMapper(
			null, TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto.class, this);

	protected TaifTPersonaDaoRowMapper byCodiceFiscalePersonaRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByCodiceFiscalePersonaDto.class, this);

	protected TaifTPersonaDaoRowMapper byCodiceFiscalePersonaPerContrattoRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByCodiceFiscalePersonaPerContrattoDto.class, this);

	protected TaifTPersonaDaoRowMapper loginInfoRowMapper = new TaifTPersonaDaoRowMapper(null, TaifTPersonaDto.class,
			this);

	protected TaifTPersonaDaoRowMapper profiloUtenteByCodiceFiscaleRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto.class, this);

	protected TaifTPersonaDaoRowMapper byIdAziendaRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByIdAziendaDto.class, this);

	protected TaifTPersonaDaoRowMapper byNrSiMsaPersonaFranceseRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByNrSiMsaPersonaFranceseDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_PERSONA";
	}

	/** 
	 * Returns all rows from the TAIF_T_PERSONA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTPersonaDto findByPrimaryKey(TaifTPersonaPk pk) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,FK_TITOLO_STUDIO,FK_TITOLO_STUDIO_FRA,FK_NAZIONE,CODICE_FISCALE,N_RSI_MSA,COGNOME,NOME,FLG_SESSO,DATA_NASCITA,ISTAT_COMUNE_NASCITA,COMUNE_ESTERO_NASCITA,ISTAT_COMUNE_RES,COMUNE_ESTERO_RES,INDIRIZZO_RES,CIVICO_RES,CAP_RES,TELEFONO,CELLULARE,MAIL,ALTRI_STUDI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,PWD FROM "
						+ getTableName() + " WHERE ID_PERSONA = :ID_PERSONA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		List<TaifTPersonaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_PERSONA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPersonaDto> findAll() throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,FK_TITOLO_STUDIO,FK_TITOLO_STUDIO_FRA,FK_NAZIONE,CODICE_FISCALE,N_RSI_MSA,COGNOME,NOME,FLG_SESSO,DATA_NASCITA,ISTAT_COMUNE_NASCITA,COMUNE_ESTERO_NASCITA,ISTAT_COMUNE_RES,COMUNE_ESTERO_RES,INDIRIZZO_RES,CIVICO_RES,CAP_RES,TELEFONO,CELLULARE,MAIL,ALTRI_STUDI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,PWD FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_PERSONA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTPersonaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findAll] END");
		}
		return list;
	}
	
	
	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as id, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as nazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as nascita, persona.ISTAT_COMUNE_NASCITA as com, persona.COMUNE_ESTERO_NASCITA as comEstero, persona.ISTAT_COMUNE_RES as comRes, persona.INDIRIZZO_RES as ind, persona.CIVICO_RES as civico, persona.CAP_RES as cap, persona.TELEFONO as tel, persona.CELLULARE as cell, persona.MAIL as mail, persona.ALTRI_STUDI as aStudi, persona.FK_CONFIG_UTENTE as fkConfigUtente");

		sql.append(" FROM TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append(
				"persona.fk_nazione = :nazioneUtente and ( persona.codice_fiscale = :codiceIdentificativo or persona.n_rsi_msa = :codiceIdentificativo )");
		/*PROTECTED REGION ID(R85329669) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceIdentificativo", input.getCodiceFiscale());
		paramMap.addValue("nazioneUtente", input.getIdNazione());

		/*PROTECTED REGION END*/

		List<TaifTPersonaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByFilter] END");
		}
		return list;
	}
	

	/** 
		 * Implementazione del finder ByCodiceIdentificativoFilter
		 */

	public List<TaifTPersonaByFilterDto> findByCodiceIdentificativoFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByCodiceIdentificativoFilter(PersonaFilter)] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as id, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as nazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as nascita, persona.ISTAT_COMUNE_NASCITA as com, persona.COMUNE_ESTERO_NASCITA as comEstero, persona.ISTAT_COMUNE_RES as comRes, persona.INDIRIZZO_RES as ind, persona.CIVICO_RES as civico, persona.CAP_RES as cap, persona.TELEFONO as tel, persona.CELLULARE as cell, persona.MAIL as mail, persona.ALTRI_STUDI as aStudi, persona.FK_CONFIG_UTENTE as fkConfigUtente");

		sql.append(" FROM TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append(
				"persona.codice_fiscale = :codiceIdentificativo or persona.n_rsi_msa = :codiceIdentificativo");

		paramMap.addValue("codiceIdentificativo", input.getCodiceFiscale());

		List<TaifTPersonaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByCodiceIdentificativoFilter(PersonaFilter)", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByCodiceIdentificativoFilter(PersonaFilter)] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byConfigUtente con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByConfigUtenteDto> findByConfigUtente(java.lang.Integer input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByConfigUtente] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as id, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as nazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as nascita, persona.ISTAT_COMUNE_NASCITA as com, persona.COMUNE_ESTERO_NASCITA as comEstero, persona.ISTAT_COMUNE_RES as comRes, persona.INDIRIZZO_RES as ind, persona.CIVICO_RES as civico, persona.CAP_RES as cap, persona.TELEFONO as tel, persona.CELLULARE as cell, persona.MAIL as mail, persona.ALTRI_STUDI as aStudi, persona.FK_CONFIG_UTENTE as configUtente");

		sql.append(" FROM TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append("persona.fk_config_utente=:idCondigUtente");
		/*PROTECTED REGION ID(R-1801909566) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idCondigUtente", input);

		/*PROTECTED REGION END*/

		List<TaifTPersonaByConfigUtenteDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byConfigUtenteRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByConfigUtente] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByConfigUtente", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByConfigUtente] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byProfiloPersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByProfiloPersonaDto> findByProfiloPersona(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloPersona input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByProfiloPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as id, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as idNazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as nascita, persona.ISTAT_COMUNE_NASCITA as istatComuneNascita, persona.COMUNE_ESTERO_NASCITA as comEstero, persona.ISTAT_COMUNE_RES as istatComuneResidenza, persona.INDIRIZZO_RES as indirizzo, persona.CIVICO_RES as civico, persona.CAP_RES as cap, persona.TELEFONO as telefono, persona.CELLULARE as cell, persona.MAIL as mail, persona.ALTRI_STUDI as aStudi, config.ID_CONFIG_UTENTE as idConfigUtente");

		sql.append(" FROM TAIF_T_PERSONA persona, TAIF_CNF_CONFIG_UTENTE config");

		sql.append(" WHERE ");

		sql.append("config.FK_PERSONA = persona.ID_PERSONA");

		sql.append(" AND ");

		sql.append("persona.codice_fiscale=:idCodiceFiscale and config.fk_profilo_utente=:idProfiloUtente");
		/*PROTECTED REGION ID(R-72095836) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idCodiceFiscale", input.getCodiceFiscale());
		paramMap.addValue("idProfiloUtente", input.getIdProfiloUtente());

		/*PROTECTED REGION END*/

		List<TaifTPersonaByProfiloPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byProfiloPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByProfiloPersona] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByProfiloPersona", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByProfiloPersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder titoloStudioByIdTitoleStudioVisibileIta con Qdef
		 * @generated
		 */

	public List<TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto> findTitoloStudioByIdTitoleStudioVisibileIta(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TitoloStudioFilter input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findTitoloStudioByIdTitoleStudioVisibileIta] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as id, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as nazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as nascita, persona.ISTAT_COMUNE_NASCITA as istatComuneNascita, persona.COMUNE_ESTERO_NASCITA as comEstero, persona.ISTAT_COMUNE_RES as istatComuneResidenza, persona.INDIRIZZO_RES as ind, persona.CIVICO_RES as civico, persona.CAP_RES as cap, persona.TELEFONO as tel, persona.CELLULARE as cell, persona.MAIL as mail, persona.ALTRI_STUDI as altriStudi");

		sql.append(" FROM TAIF_T_PERSONA persona, TAIF_D_TITOLO_STUDIO titoloStudio");

		sql.append(" WHERE ");

		sql.append("persona.FK_TITOLO_STUDIO = titoloStudio.ID_TITOLO_STUDIO");

		sql.append(" AND ");

		sql.append(
				"persona.fk_titolo_studio=:idTitoloStudio and titoloStudio.mtd_flg_visibile=:flagVisibile and titoloStudio.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R-951540663) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTitoloStudio", input.getIdTitoloStudio());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, titoloStudioByIdTitoleStudioVisibileItaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findTitoloStudioByIdTitoleStudioVisibileIta] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findTitoloStudioByIdTitoleStudioVisibileIta",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findTitoloStudioByIdTitoleStudioVisibileIta] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder titoloStudioByIdTitoleStudioVisibileFra con Qdef
		 * @generated
		 */

	public List<TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto> findTitoloStudioByIdTitoleStudioVisibileFra(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TitoloStudioFilter input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findTitoloStudioByIdTitoleStudioVisibileFra] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as id, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as nazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as nascita, persona.ISTAT_COMUNE_NASCITA as istatComuneNascita, persona.COMUNE_ESTERO_NASCITA as comEstero, persona.ISTAT_COMUNE_RES as istatComuneResidenza, persona.INDIRIZZO_RES as ind, persona.CIVICO_RES as civico, persona.CAP_RES as cap, persona.TELEFONO as tel, persona.CELLULARE as cell, persona.MAIL as mail, persona.ALTRI_STUDI as altriStudi, titoloStudio.TITOLO_STUDIO as titoloStudioFrancese");

		sql.append(" FROM TAIF_T_PERSONA persona, TAIF_D_TITOLO_STUDIO titoloStudio");

		sql.append(" WHERE ");

		sql.append("persona.FK_TITOLO_STUDIO_FRA = titoloStudio.ID_TITOLO_STUDIO");

		sql.append(" AND ");

		sql.append(
				"persona.fk_titolo_studio=:idTitoloStudio and  titoloStudio.mtd_flg_visibile=:flagVisibile and titoloStudio.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R634955562) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTitoloStudio", input.getIdTitoloStudio());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, titoloStudioByIdTitoleStudioVisibileFraRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findTitoloStudioByIdTitoleStudioVisibileFra] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findTitoloStudioByIdTitoleStudioVisibileFra",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findTitoloStudioByIdTitoleStudioVisibileFra] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceFiscalePersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByCodiceFiscalePersonaDto> findByCodiceFiscalePersona(java.lang.String input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByCodiceFiscalePersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as idPersona, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as idNazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as dataNascita, persona.ISTAT_COMUNE_NASCITA as istatComuneNascita, persona.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, persona.ISTAT_COMUNE_RES as istatComuneResidenza, persona.INDIRIZZO_RES as indirizzoResidenza, persona.CIVICO_RES as civicoResidenza, persona.CAP_RES as cap, persona.TELEFONO as telefono, persona.CELLULARE as cellulare, persona.MAIL as mail, persona.ALTRI_STUDI as aStudi");

		sql.append(" FROM TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append("1=1");
		/*PROTECTED REGION ID(R-298253947) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append(" AND ");
		sql.append("upper(persona.codice_fiscale) like :codiceFiscale");
		String codiceFiscale= "%" + input.toUpperCase() +"%";
		paramMap.addValue("codiceFiscale", codiceFiscale);

		/*PROTECTED REGION END*/

		List<TaifTPersonaByCodiceFiscalePersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscalePersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByCodiceFiscalePersona] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByCodiceFiscalePersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByCodiceFiscalePersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceFiscalePersonaPerContratto con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByCodiceFiscalePersonaPerContrattoDto> findByCodiceFiscalePersonaPerContratto(
			java.lang.String input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByCodiceFiscalePersonaPerContratto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as idPersona, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as idNazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.ALTRI_STUDI as aStudi, personaAzienda.FK_RUOLO as idRuoloPersona, personaAzienda.FK_TIPO_MANSIONE as idMansione, personaAzienda.FK_TIPO_CONTRATTO as idContrattoPersona, personaAzienda.FK_TIPO_INQUADRAMENTO as idInquadramento, personaAzienda.FLG_TEMPO_DETERMINATO as flagTempoDett, personaAzienda.GG_TEMPO_DETERMINATO as ggTempoDett");

		sql.append(" FROM TAIF_T_PERSONA persona, TAIF_R_PERSONA_AZIENDA personaAzienda");

		sql.append(" WHERE ");

		sql.append("persona.ID_PERSONA = personaAzienda.ID_PERSONA");

		sql.append(" AND ");

		sql.append("persona.codice_fiscale=:codiceFiscale");
		/*PROTECTED REGION ID(R-1595328588) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		paramMap.addValue("codiceFiscale", input);
		/*PROTECTED REGION END*/

		List<TaifTPersonaByCodiceFiscalePersonaPerContrattoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscalePersonaPerContrattoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByCodiceFiscalePersonaPerContratto] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByCodiceFiscalePersonaPerContratto", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByCodiceFiscalePersonaPerContratto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder loginInfo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPersonaDto> findLoginInfo(it.csi.taif.taifweb.dto.common.LoginInfo input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findLoginInfo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA,FK_TITOLO_STUDIO,FK_TITOLO_STUDIO_FRA,FK_NAZIONE,CODICE_FISCALE,N_RSI_MSA,COGNOME,NOME,FLG_SESSO,DATA_NASCITA,ISTAT_COMUNE_NASCITA,COMUNE_ESTERO_NASCITA,ISTAT_COMUNE_RES,COMUNE_ESTERO_RES,INDIRIZZO_RES,CIVICO_RES,CAP_RES,TELEFONO,CELLULARE,MAIL,ALTRI_STUDI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,PWD ");
		sql.append(" FROM TAIF_T_PERSONA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R289209113) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append("upper(N_RSI_MSA) = :loginuser AND PWD = (CRYPT(:password, PWD))");

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R500434161) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("loginuser", input.getUser().toUpperCase());
		paramMap.addValue("password", input.getPassword());

		//paramMap.addValue("loginpwd", input.getPassword());

		/*PROTECTED REGION END*/
		List<TaifTPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, loginInfoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findLoginInfo] esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findLoginInfo", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findLoginInfo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder profiloUtenteByCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> findProfiloUtenteByCodiceFiscale(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloFilter input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findProfiloUtenteByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT personaTable.ID_PERSONA as idPersona, personaTable.FK_TITOLO_STUDIO as idTitolo, personaTable.FK_TITOLO_STUDIO_FRA as idStudioFra, personaTable.FK_NAZIONE as idNazione, personaTable.CODICE_FISCALE as codiceFiscale, personaTable.N_RSI_MSA as msa, personaTable.COGNOME as cognome, personaTable.NOME as nome, personaTable.FLG_SESSO as sesso, personaTable.DATA_NASCITA as dataNascita, personaTable.ISTAT_COMUNE_NASCITA as istatComuneNascita, personaTable.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, personaTable.ISTAT_COMUNE_RES as istatComuneResidenza, personaTable.INDIRIZZO_RES as indirizzoResidenza, personaTable.CIVICO_RES as civicoResidenza, personaTable.CAP_RES as cap, personaTable.TELEFONO as telefono, personaTable.CELLULARE as cellulare, personaTable.MAIL as mail, personaTable.ALTRI_STUDI as aStudi, configUtenteTable.FK_PROFILO_UTENTE as idProfiloUtente, profiloUtenteTable.PROFILO_UTENTE as profiloUtente, profiloUtenteTable.MTD_FLG_ATTIVO as flagUtenteAttivo, profiloUtenteTable.FK_PROCEDURA as proceduraUtente, configUtenteTable.ID_CONFIG_UTENTE as idConfigUtente, configUtenteTable.FK_SOGGETTO_GESTORE as idSoggettoGestore");

		sql.append(
				" FROM TAIF_T_PERSONA personaTable, TAIF_CNF_CONFIG_UTENTE configUtenteTable, TAIF_CNF_PROFILO_UTENTE profiloUtenteTable, TAIF_CNF_PROCEDURA proceduraTable");

		sql.append(" WHERE ");

		sql.append(
				"personaTable.ID_PERSONA = configUtenteTable.FK_PERSONA AND configUtenteTable.FK_PROFILO_UTENTE = profiloUtenteTable.ID_PROFILO_UTENTE AND profiloUtenteTable.FK_PROCEDURA = proceduraTable.ID_PROCEDURA");

		sql.append(" AND ");

		sql.append("proceduraTable.id_procedura=:idprocedura and profiloUtenteTable.mtd_flg_attivo=:flagAttivo");
		/*PROTECTED REGION ID(R1837132899) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		

		if (input.getDataTracciato().equals("I")) {
			sql.append(" AND ");
			sql.append("personaTable.codice_fiscale like :codiceFiscale");
		} else {
			sql.append(" AND ");
			sql.append("personaTable.n_rsi_msa like :codiceFiscale");
		}
		
		String codiceFiscale = "%" + input.getCodiceFiscale() + "%";
		paramMap.addValue("codiceFiscale", codiceFiscale);
		paramMap.addValue("idprocedura", input.getIdProcedura());
		paramMap.addValue("flagAttivo", input.getFlagAttivo());

		/*PROTECTED REGION END*/

		List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, profiloUtenteByCodiceFiscaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findProfiloUtenteByCodiceFiscale] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findProfiloUtenteByCodiceFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findProfiloUtenteByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByIdAziendaDto> findByIdAzienda(java.lang.Integer input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as idPersona, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as idStato, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as msa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as dataNascita, persona.ISTAT_COMUNE_NASCITA as istatComuneNascita, persona.COMUNE_ESTERO_NASCITA as comuneEstero, persona.ISTAT_COMUNE_RES as istatComuneresidenza, persona.INDIRIZZO_RES as indirizzoResidenza, persona.CIVICO_RES as civico, persona.CAP_RES as cap, persona.TELEFONO as telefono, persona.CELLULARE as cellulare, persona.MAIL as mail, persona.ALTRI_STUDI as aStudi, personaAzienda.ID_AZIENDA as idAzienda, personaAzienda.FK_RUOLO as idRuoloPersona, persona.COMUNE_ESTERO_RES as comuneEsteroResidenza, personaAzienda.FK_TIPO_MANSIONE as idTipoMansione, personaAzienda.FK_TIPO_CONTRATTO as idTipoContratto, personaAzienda.FK_TIPO_INQUADRAMENTO as idTipoInquadramento, personaAzienda.FLG_TEMPO_DETERMINATO as flagTenpoDeterminato, personaAzienda.GG_TEMPO_DETERMINATO as giorniTempoDeterminato");

		sql.append(" FROM TAIF_T_PERSONA persona, TAIF_R_PERSONA_AZIENDA personaAzienda");

		sql.append(" WHERE ");

		sql.append("persona.ID_PERSONA = personaAzienda.ID_PERSONA");

		sql.append(" AND ");

		sql.append("personaAzienda.id_azienda=:idAzienda");
		/*PROTECTED REGION ID(R-1782092232) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTPersonaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByIdAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byNrSiMsaPersonaFrancese con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByNrSiMsaPersonaFranceseDto> findByNrSiMsaPersonaFrancese(java.lang.String input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByNrSiMsaPersonaFrancese] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as idPersona, persona.FK_TITOLO_STUDIO as idTitolo, persona.FK_TITOLO_STUDIO_FRA as idStudioFra, persona.FK_NAZIONE as idNazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as numeroRsiMsaSa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as dataNascita, persona.ISTAT_COMUNE_NASCITA as istatComuneNascita, persona.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, persona.ISTAT_COMUNE_RES as istatComuneResidenza, persona.INDIRIZZO_RES as indirizzoResidenza, persona.CIVICO_RES as civicoResidenza, persona.CAP_RES as cap, persona.TELEFONO as telefono, persona.CELLULARE as cellulare, persona.MAIL as mail, persona.ALTRI_STUDI as aStudi, persona.COMUNE_ESTERO_RES as comuneEsteroResidenza");

		sql.append(" FROM TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append("1=1");
		/*PROTECTED REGION ID(R-1459172059) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append(" AND ");
		sql.append("upper(persona.n_rsi_msa) like upper(:nRsiMsa)");
		String nRsiMsa = "%" +  input + "%";
		paramMap.addValue("nRsiMsa",nRsiMsa);
		/*PROTECTED REGION END*/
		List<TaifTPersonaByNrSiMsaPersonaFranceseDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byNrSiMsaPersonaFranceseRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByNrSiMsaPersonaFrancese] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByNrSiMsaPersonaFrancese", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByNrSiMsaPersonaFrancese] END");
		}
		return list;
	}

}
