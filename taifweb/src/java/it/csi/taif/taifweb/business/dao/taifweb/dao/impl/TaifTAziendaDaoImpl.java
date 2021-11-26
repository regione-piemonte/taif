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
import it.csi.taif.taifweb.dto.domanda.Attivita;
import it.csi.taif.taifweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;

/*PROTECTED REGION ID(R1354699407) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.taif.taifweb.util.ConvertUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTAzienda.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byCodiceFiscale (datagen::CustomFinder)
 *   - byPiva (datagen::CustomFinder)
 *   - domandaByCodiceFiscale (datagen::CustomFinder)
 *   - domandaAziendaPratica (datagen::CustomFinder)
 *   - ricercaAziendaAvanzata (datagen::CustomFinder)
 *   - ricercaAziendaExport (datagen::CustomFinder)
 *   - elencoDomandaByLegaleRapp (datagen::CustomFinder)
 *   - intestazioneRiepilogo (datagen::CustomFinder)
 *   - intestazioneRiepilogoByPratica (datagen::CustomFinder)
 *   - dettaglioAziendaByIdAzienda (datagen::CustomFinder)
 *   - elencoDomandaByLegaleRappAndProf (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - aziendaByIdAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTAziendaDaoImpl extends AbstractDAO implements TaifTAziendaDao {
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
	 * Metodo di inserimento del DAO taifTAzienda. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAziendaPk
	 * @generated
	 */

	public TaifTAziendaPk insert(TaifTAziendaDto dto)

	{
		LOG.debug("[TaifTAziendaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AZIENDA,FK_ATTIVITA_PRIMARIA,FK_ATTIVITA_SECONDARIA,FK_ATTIVITA_APE,FK_FORMA_GIURIDICA_ITA,FK_FORMA_GIURIDICA_FRA,CODICE_FISCALE,N_SIRET,PARTITA_IVA,N_TVA,CCIAA_NUMERO,CCIAA_SIGLA_PROV,RAGIONE_SOCIALE,N_MARCA_BOLLO,DESCR_ALTRA_FORMA_GIURIDICA,EMAIL,PEC,SITO_WEB,ANNO_INIZIO,FATTURATO,PERC_COMMERCIO_FRA,CLIENT1_FRA,CLIENT2_FRA,CLIENT3_FRA,NBRE_SALARIES_FRA,TEMPS_PLEIN_FRA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_AZIENDA , :FK_ATTIVITA_PRIMARIA , :FK_ATTIVITA_SECONDARIA , :FK_ATTIVITA_APE , :FK_FORMA_GIURIDICA_ITA , :FK_FORMA_GIURIDICA_FRA , :CODICE_FISCALE , :N_SIRET , :PARTITA_IVA , :N_TVA , :CCIAA_NUMERO , :CCIAA_SIGLA_PROV , :RAGIONE_SOCIALE , :N_MARCA_BOLLO , :DESCR_ALTRA_FORMA_GIURIDICA , :EMAIL , :PEC , :SITO_WEB , :ANNO_INIZIO , :FATTURATO , :PERC_COMMERCIO_FRA , :CLIENT1_FRA , :CLIENT2_FRA , :CLIENT3_FRA , :NBRE_SALARIES_FRA , :TEMPS_PLEIN_FRA , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_PRIMARIA]
		params.addValue("FK_ATTIVITA_PRIMARIA", dto.getFkAttivitaPrimaria(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_SECONDARIA]
		params.addValue("FK_ATTIVITA_SECONDARIA", dto.getFkAttivitaSecondaria(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_APE]
		params.addValue("FK_ATTIVITA_APE", dto.getFkAttivitaApe(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_FORMA_GIURIDICA_ITA]
		params.addValue("FK_FORMA_GIURIDICA_ITA", dto.getFkFormaGiuridicaIta(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_FORMA_GIURIDICA_FRA]
		params.addValue("FK_FORMA_GIURIDICA_FRA", dto.getFkFormaGiuridicaFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_SIRET]
		params.addValue("N_SIRET", dto.getNSiret(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTITA_IVA]
		params.addValue("PARTITA_IVA", dto.getPartitaIva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_TVA]
		params.addValue("N_TVA", dto.getNTva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CCIAA_NUMERO]
		params.addValue("CCIAA_NUMERO", dto.getCciaaNumero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CCIAA_SIGLA_PROV]
		params.addValue("CCIAA_SIGLA_PROV", dto.getCciaaSiglaProv(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RAGIONE_SOCIALE]
		params.addValue("RAGIONE_SOCIALE", dto.getRagioneSociale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_MARCA_BOLLO]
		params.addValue("N_MARCA_BOLLO", dto.getNMarcaBollo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRA_FORMA_GIURIDICA]
		params.addValue("DESCR_ALTRA_FORMA_GIURIDICA", dto.getDescrAltraFormaGiuridica(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [EMAIL]
		params.addValue("EMAIL", dto.getEmail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PEC]
		params.addValue("PEC", dto.getPec(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SITO_WEB]
		params.addValue("SITO_WEB", dto.getSitoWeb(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ANNO_INIZIO]
		params.addValue("ANNO_INIZIO", dto.getAnnoInizio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FATTURATO]
		params.addValue("FATTURATO", dto.getFatturato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PERC_COMMERCIO_FRA]
		params.addValue("PERC_COMMERCIO_FRA", dto.getPercCommercioFra(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CLIENT1_FRA]
		params.addValue("CLIENT1_FRA", dto.getClient1Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CLIENT2_FRA]
		params.addValue("CLIENT2_FRA", dto.getClient2Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CLIENT3_FRA]
		params.addValue("CLIENT3_FRA", dto.getClient3Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NBRE_SALARIES_FRA]
		params.addValue("NBRE_SALARIES_FRA", dto.getNbreSalariesFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TEMPS_PLEIN_FRA]
		params.addValue("TEMPS_PLEIN_FRA", dto.getTempsPleinFra(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAzienda(newKey);
		LOG.debug("[TaifTAziendaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_AZIENDA table.
	 * @generated
	 */
	public void update(TaifTAziendaDto dto) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_ATTIVITA_PRIMARIA = :FK_ATTIVITA_PRIMARIA ,FK_ATTIVITA_SECONDARIA = :FK_ATTIVITA_SECONDARIA ,FK_ATTIVITA_APE = :FK_ATTIVITA_APE ,FK_FORMA_GIURIDICA_ITA = :FK_FORMA_GIURIDICA_ITA ,FK_FORMA_GIURIDICA_FRA = :FK_FORMA_GIURIDICA_FRA ,CODICE_FISCALE = :CODICE_FISCALE ,N_SIRET = :N_SIRET ,PARTITA_IVA = :PARTITA_IVA ,N_TVA = :N_TVA ,CCIAA_NUMERO = :CCIAA_NUMERO ,CCIAA_SIGLA_PROV = :CCIAA_SIGLA_PROV ,RAGIONE_SOCIALE = :RAGIONE_SOCIALE ,N_MARCA_BOLLO = :N_MARCA_BOLLO ,DESCR_ALTRA_FORMA_GIURIDICA = :DESCR_ALTRA_FORMA_GIURIDICA ,EMAIL = :EMAIL ,PEC = :PEC ,SITO_WEB = :SITO_WEB ,ANNO_INIZIO = :ANNO_INIZIO ,FATTURATO = :FATTURATO ,PERC_COMMERCIO_FRA = :PERC_COMMERCIO_FRA ,CLIENT1_FRA = :CLIENT1_FRA ,CLIENT2_FRA = :CLIENT2_FRA ,CLIENT3_FRA = :CLIENT3_FRA ,NBRE_SALARIES_FRA = :NBRE_SALARIES_FRA ,TEMPS_PLEIN_FRA = :TEMPS_PLEIN_FRA ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_AZIENDA = :ID_AZIENDA ";

		if (dto.getIdAzienda() == null) {
			LOG.error("[TaifTAziendaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTAziendaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_PRIMARIA]
		params.addValue("FK_ATTIVITA_PRIMARIA", dto.getFkAttivitaPrimaria(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_SECONDARIA]
		params.addValue("FK_ATTIVITA_SECONDARIA", dto.getFkAttivitaSecondaria(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_APE]
		params.addValue("FK_ATTIVITA_APE", dto.getFkAttivitaApe(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_FORMA_GIURIDICA_ITA]
		params.addValue("FK_FORMA_GIURIDICA_ITA", dto.getFkFormaGiuridicaIta(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_FORMA_GIURIDICA_FRA]
		params.addValue("FK_FORMA_GIURIDICA_FRA", dto.getFkFormaGiuridicaFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_SIRET]
		params.addValue("N_SIRET", dto.getNSiret(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTITA_IVA]
		params.addValue("PARTITA_IVA", dto.getPartitaIva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_TVA]
		params.addValue("N_TVA", dto.getNTva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CCIAA_NUMERO]
		params.addValue("CCIAA_NUMERO", dto.getCciaaNumero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CCIAA_SIGLA_PROV]
		params.addValue("CCIAA_SIGLA_PROV", dto.getCciaaSiglaProv(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RAGIONE_SOCIALE]
		params.addValue("RAGIONE_SOCIALE", dto.getRagioneSociale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_MARCA_BOLLO]
		params.addValue("N_MARCA_BOLLO", dto.getNMarcaBollo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRA_FORMA_GIURIDICA]
		params.addValue("DESCR_ALTRA_FORMA_GIURIDICA", dto.getDescrAltraFormaGiuridica(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [EMAIL]
		params.addValue("EMAIL", dto.getEmail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PEC]
		params.addValue("PEC", dto.getPec(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SITO_WEB]
		params.addValue("SITO_WEB", dto.getSitoWeb(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ANNO_INIZIO]
		params.addValue("ANNO_INIZIO", dto.getAnnoInizio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FATTURATO]
		params.addValue("FATTURATO", dto.getFatturato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PERC_COMMERCIO_FRA]
		params.addValue("PERC_COMMERCIO_FRA", dto.getPercCommercioFra(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CLIENT1_FRA]
		params.addValue("CLIENT1_FRA", dto.getClient1Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CLIENT2_FRA]
		params.addValue("CLIENT2_FRA", dto.getClient2Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CLIENT3_FRA]
		params.addValue("CLIENT3_FRA", dto.getClient3Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NBRE_SALARIES_FRA]
		params.addValue("NBRE_SALARIES_FRA", dto.getNbreSalariesFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TEMPS_PLEIN_FRA]
		params.addValue("TEMPS_PLEIN_FRA", dto.getTempsPleinFra(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAziendaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_AZIENDA table.
	 * @generated
	 */
	public void updateColumnsAziendaByIdAzienda(TaifTAziendaDto dto) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::updateColumnsAziendaByIdAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_ATTIVITA_PRIMARIA = :FK_ATTIVITA_PRIMARIA ,FK_ATTIVITA_SECONDARIA = :FK_ATTIVITA_SECONDARIA ,FK_ATTIVITA_APE = :FK_ATTIVITA_APE ,FK_FORMA_GIURIDICA_ITA = :FK_FORMA_GIURIDICA_ITA ,FK_FORMA_GIURIDICA_FRA = :FK_FORMA_GIURIDICA_FRA ,N_SIRET = :N_SIRET ,N_TVA = :N_TVA ,CCIAA_NUMERO = :CCIAA_NUMERO ,CCIAA_SIGLA_PROV = :CCIAA_SIGLA_PROV ,N_MARCA_BOLLO = :N_MARCA_BOLLO ,DESCR_ALTRA_FORMA_GIURIDICA = :DESCR_ALTRA_FORMA_GIURIDICA ,EMAIL = :EMAIL ,PEC = :PEC ,SITO_WEB = :SITO_WEB ,ANNO_INIZIO = :ANNO_INIZIO ,FATTURATO = :FATTURATO ,PERC_COMMERCIO_FRA = :PERC_COMMERCIO_FRA ,CLIENT1_FRA = :CLIENT1_FRA ,CLIENT2_FRA = :CLIENT2_FRA ,CLIENT3_FRA = :CLIENT3_FRA ,NBRE_SALARIES_FRA = :NBRE_SALARIES_FRA ,TEMPS_PLEIN_FRA = :TEMPS_PLEIN_FRA ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_AZIENDA = :ID_AZIENDA ";

		if (dto.getIdAzienda() == null) {
			LOG.error("[TaifTAziendaDaoImpl::updateColumnsAziendaByIdAzienda] ERROR chiave primaria non impostata");
			throw new TaifTAziendaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_PRIMARIA]
		params.addValue("FK_ATTIVITA_PRIMARIA", dto.getFkAttivitaPrimaria(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_SECONDARIA]
		params.addValue("FK_ATTIVITA_SECONDARIA", dto.getFkAttivitaSecondaria(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ATTIVITA_APE]
		params.addValue("FK_ATTIVITA_APE", dto.getFkAttivitaApe(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_FORMA_GIURIDICA_ITA]
		params.addValue("FK_FORMA_GIURIDICA_ITA", dto.getFkFormaGiuridicaIta(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_FORMA_GIURIDICA_FRA]
		params.addValue("FK_FORMA_GIURIDICA_FRA", dto.getFkFormaGiuridicaFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [N_SIRET]
		params.addValue("N_SIRET", dto.getNSiret(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_TVA]
		params.addValue("N_TVA", dto.getNTva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CCIAA_NUMERO]
		params.addValue("CCIAA_NUMERO", dto.getCciaaNumero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CCIAA_SIGLA_PROV]
		params.addValue("CCIAA_SIGLA_PROV", dto.getCciaaSiglaProv(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_MARCA_BOLLO]
		params.addValue("N_MARCA_BOLLO", dto.getNMarcaBollo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRA_FORMA_GIURIDICA]
		params.addValue("DESCR_ALTRA_FORMA_GIURIDICA", dto.getDescrAltraFormaGiuridica(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [EMAIL]
		params.addValue("EMAIL", dto.getEmail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PEC]
		params.addValue("PEC", dto.getPec(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SITO_WEB]
		params.addValue("SITO_WEB", dto.getSitoWeb(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ANNO_INIZIO]
		params.addValue("ANNO_INIZIO", dto.getAnnoInizio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FATTURATO]
		params.addValue("FATTURATO", dto.getFatturato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PERC_COMMERCIO_FRA]
		params.addValue("PERC_COMMERCIO_FRA", dto.getPercCommercioFra(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CLIENT1_FRA]
		params.addValue("CLIENT1_FRA", dto.getClient1Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CLIENT2_FRA]
		params.addValue("CLIENT2_FRA", dto.getClient2Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CLIENT3_FRA]
		params.addValue("CLIENT3_FRA", dto.getClient3Fra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NBRE_SALARIES_FRA]
		params.addValue("NBRE_SALARIES_FRA", dto.getNbreSalariesFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TEMPS_PLEIN_FRA]
		params.addValue("TEMPS_PLEIN_FRA", dto.getTempsPleinFra(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAziendaDaoImpl::updateColumnsAziendaByIdAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_AZIENDA table.
	 * @generated
	 */

	public void delete(TaifTAziendaPk pk) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_AZIENDA = :ID_AZIENDA ";

		if (pk == null) {
			LOG.error("[TaifTAziendaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTAziendaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAziendaDaoImpl::delete] END");
	}

	protected TaifTAziendaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaDto.class, this);

	protected TaifTAziendaDaoRowMapper findAllRowMapper = new TaifTAziendaDaoRowMapper(null, TaifTAziendaDto.class,
			this);

	protected TaifTAziendaDaoRowMapper byCodiceFiscaleRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaByCodiceFiscaleDto.class, this);

	protected TaifTAziendaDaoRowMapper byPivaRowMapper = new TaifTAziendaDaoRowMapper(null, TaifTAziendaByPivaDto.class,
			this);

	protected TaifTAziendaDaoRowMapper domandaByCodiceFiscaleRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaDomandaByCodiceFiscaleDto.class, this);

	protected TaifTAziendaDaoRowMapper domandaAziendaPraticaRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaDomandaAziendaPraticaDto.class, this);

	protected TaifTAziendaDaoRowMapper ricercaAziendaAvanzataRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaRicercaAziendaAvanzataDto.class, this);

	protected TaifTAziendaDaoRowMapper ricercaAziendaExportRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaRicercaAziendaExportDto.class, this);

	protected TaifTAziendaDaoRowMapper elencoDomandaByLegaleRappRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaElencoDomandaByLegaleRappDto.class, this);

	protected TaifTAziendaDaoRowMapper intestazioneRiepilogoRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaIntestazioneRiepilogoDto.class, this);

	protected TaifTAziendaDaoRowMapper intestazioneRiepilogoByPraticaRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaIntestazioneRiepilogoByPraticaDto.class, this);

	protected TaifTAziendaDaoRowMapper dettaglioAziendaByIdAziendaRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaDettaglioAziendaByIdAziendaDto.class, this);

	protected TaifTAziendaDaoRowMapper elencoDomandaByLegaleRappAndProfRowMapper = new TaifTAziendaDaoRowMapper(null,
			TaifTAziendaElencoDomandaByLegaleRappAndProfDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_AZIENDA";
	}

	/** 
	 * Returns all rows from the TAIF_T_AZIENDA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAziendaDto findByPrimaryKey(TaifTAziendaPk pk) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,FK_ATTIVITA_PRIMARIA,FK_ATTIVITA_SECONDARIA,FK_ATTIVITA_APE,FK_FORMA_GIURIDICA_ITA,FK_FORMA_GIURIDICA_FRA,CODICE_FISCALE,N_SIRET,PARTITA_IVA,N_TVA,CCIAA_NUMERO,CCIAA_SIGLA_PROV,RAGIONE_SOCIALE,N_MARCA_BOLLO,DESCR_ALTRA_FORMA_GIURIDICA,EMAIL,PEC,SITO_WEB,ANNO_INIZIO,FATTURATO,PERC_COMMERCIO_FRA,CLIENT1_FRA,CLIENT2_FRA,CLIENT3_FRA,NBRE_SALARIES_FRA,TEMPS_PLEIN_FRA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_AZIENDA = :ID_AZIENDA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		List<TaifTAziendaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_AZIENDA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAziendaDto> findAll() throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,FK_ATTIVITA_PRIMARIA,FK_ATTIVITA_SECONDARIA,FK_ATTIVITA_APE,FK_FORMA_GIURIDICA_ITA,FK_FORMA_GIURIDICA_FRA,CODICE_FISCALE,N_SIRET,PARTITA_IVA,N_TVA,CCIAA_NUMERO,CCIAA_SIGLA_PROV,RAGIONE_SOCIALE,N_MARCA_BOLLO,DESCR_ALTRA_FORMA_GIURIDICA,EMAIL,PEC,SITO_WEB,ANNO_INIZIO,FATTURATO,PERC_COMMERCIO_FRA,CLIENT1_FRA,CLIENT2_FRA,CLIENT3_FRA,NBRE_SALARIES_FRA,TEMPS_PLEIN_FRA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_AZIENDA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTAziendaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTAziendaByCodiceFiscaleDto> findByCodiceFiscale(java.lang.String input)
			throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as id, azienda.FK_ATTIVITA_PRIMARIA as prim, azienda.FK_ATTIVITA_SECONDARIA as sec, azienda.CODICE_FISCALE as cd, azienda.RAGIONE_SOCIALE as rs, azienda.DESCR_ALTRA_FORMA_GIURIDICA as desc, azienda.PARTITA_IVA as piva");

		sql.append(" FROM TAIF_T_AZIENDA azienda");

		sql.append(" WHERE ");

		sql.append("azienda.codice_fiscale=:codiceFiscale");
		/*PROTECTED REGION ID(R-348350379) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/

		List<TaifTAziendaByCodiceFiscaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findByCodiceFiscale] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findByCodiceFiscale", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byPiva con Qdef
		 * @generated
		 */

	public List<TaifTAziendaByPivaDto> findByPiva(java.lang.String input) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findByPiva] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as id, azienda.FK_ATTIVITA_PRIMARIA as prim, azienda.FK_ATTIVITA_SECONDARIA as sec, azienda.CODICE_FISCALE as cd, azienda.RAGIONE_SOCIALE as rs, azienda.DESCR_ALTRA_FORMA_GIURIDICA as desc, azienda.PARTITA_IVA as piva");

		sql.append(" FROM TAIF_T_AZIENDA azienda");

		sql.append(" WHERE ");

		sql.append("azienda.partita_iva=:piva");
		/*PROTECTED REGION ID(R-25354269) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("piva", input);

		/*PROTECTED REGION END*/

		List<TaifTAziendaByPivaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byPivaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findByPiva] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findByPiva", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findByPiva] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder domandaByCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTAziendaDomandaByCodiceFiscaleDto> findDomandaByCodiceFiscale(java.lang.String input)
			throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findDomandaByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as id, azienda.CODICE_FISCALE as codiceFiscale, azienda.RAGIONE_SOCIALE as ragioneSociale, azienda.DESCR_ALTRA_FORMA_GIURIDICA as descrizione, azienda.PARTITA_IVA as piva, pratica.NUMERO_ALBO as numeroAlbo, pratica.DATA_ISCRIZIONE_ALBO as iscrizioneAlbo, pratica.FK_SOGGETTO_GESTORE as idSogettoGestore, pratica.ID_PRATICA as idPratica");

		sql.append(" FROM TAIF_T_AZIENDA azienda, TAIF_T_PRATICA pratica");

		sql.append(" WHERE ");

		sql.append("pratica.FK_AZIENDA = azienda.ID_AZIENDA");

		sql.append(" AND ");

		sql.append("azienda.codice_fiscale=:codiceFiscale");
		/*PROTECTED REGION ID(R674007693) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/

		List<TaifTAziendaDomandaByCodiceFiscaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, domandaByCodiceFiscaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findDomandaByCodiceFiscale] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findDomandaByCodiceFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findDomandaByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder domandaAziendaPratica con Qdef
		 * @generated
		 */

	public List<TaifTAziendaDomandaAziendaPraticaDto> findDomandaAziendaPratica(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PraticaFilter input) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findDomandaAziendaPratica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as id, azienda.CODICE_FISCALE as codiceFiscale, azienda.RAGIONE_SOCIALE as ragioneSociale, azienda.DESCR_ALTRA_FORMA_GIURIDICA as descrizione, azienda.PARTITA_IVA as piva, pratica.NUMERO_ALBO as numeroAlbo, pratica.DATA_ISCRIZIONE_ALBO as iscrizioneAlbo, pratica.FK_SOGGETTO_GESTORE as idSogettoGestore, pratica.ID_PRATICA as idPratica");

		sql.append(" FROM TAIF_T_AZIENDA azienda, TAIF_T_PRATICA pratica");

		sql.append(" WHERE ");

		sql.append("pratica.FK_AZIENDA = azienda.ID_AZIENDA");

		sql.append(" AND ");

		sql.append("pratica.id_pratica=:idPratica and  pratica.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R488688394) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("idPratica", input.getIdPratica());

		/*PROTECTED REGION END*/

		List<TaifTAziendaDomandaAziendaPraticaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, domandaAziendaPraticaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findDomandaAziendaPratica] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findDomandaAziendaPratica", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findDomandaAziendaPratica] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder ricercaAziendaAvanzata con Qdef
		 * @generated
		 */

	public List<TaifTAziendaRicercaAziendaAvanzataDto> findRicercaAziendaAvanzata(
			it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter input)
			throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as id, pratica.FK_SOGGETTO_GESTORE as idAlboAppartenenza, azienda.RAGIONE_SOCIALE as denominazioneAzienda, azienda.CODICE_FISCALE as codiceFiscaleAzienda, azienda.PARTITA_IVA as pivaAzienda, persona.NOME as nomeTitolare, persona.COGNOME as cognomeTitolare, pratica.NUMERO_ALBO as numeroAlbo, pratica.DATA_ISCRIZIONE_ALBO as iscrizioneAlbo, pratica.ID_PRATICA as idPratica, sede.ISTAT_COMUNE as istatComuneSede, storicoStatoPratica.FK_STATO_PRATICA as idStatoPratica, statoPratica.STATO_PRATICA_ITA as dsStatoPraticaIta, statoPratica.STATO_PRATICA_FRA as dsStatoPraticaFra, soggettoGestore.DENOMINAZIONE_BREVE as dsAlboAppartenenza, azienda.N_SIRET as nSiret, azienda.N_TVA as nTva, sede.COMUNE_ESTERO as comuneSedeEstero, azienda.CCIAA_SIGLA_PROV as siglaProvincia, azienda.CCIAA_NUMERO as numeroCciaa, azienda.DESCR_ALTRA_FORMA_GIURIDICA as altraFormaGiuridica, azienda.PEC as pecAzienda, azienda.EMAIL as mailAzienda, azienda.SITO_WEB as sitoWeb, pratica.FLG_SEZIONE as sezione, pratica.FK_SOGGETTO_GESTORE as idSoggettoGestore, sede.INDIRIZZO as indirizzo, sede.CIVICO as civico, sede.CAP as cap, sede.TELEFONO as telefono, azienda.N_MARCA_BOLLO as numeroBollo, azienda.ANNO_INIZIO as annoInizio, azienda.FATTURATO as fatturato, azienda.FK_ATTIVITA_PRIMARIA as attivitaPrimaria, azienda.FK_ATTIVITA_SECONDARIA as attivitaSecondaria, azienda.NBRE_SALARIES_FRA as numeroSalaries, azienda.TEMPS_PLEIN_FRA as tempoIndeterminato");

		sql.append(
				" FROM TAIF_T_AZIENDA azienda, TAIF_T_PRATICA pratica, TAIF_T_PERSONA persona, TAIF_T_SEDE_AZIENDA sede, TAIF_R_PERSONA_AZIENDA persAzienda, TAIF_T_STORICO_STATO storicoStatoPratica, TAIF_D_STATO_PRATICA statoPratica, TAIF_T_SOGGETTO_GESTORE soggettoGestore");

		sql.append(" WHERE ");

		sql.append(
				"azienda.ID_AZIENDA = pratica.FK_AZIENDA AND azienda.ID_AZIENDA = persAzienda.ID_AZIENDA AND azienda.ID_AZIENDA = sede.FK_AZIENDA AND persAzienda.ID_PERSONA = persona.ID_PERSONA AND pratica.ID_PRATICA = storicoStatoPratica.ID_PRATICA AND storicoStatoPratica.FK_STATO_PRATICA = statoPratica.ID_STATO_PRATICA AND pratica.FK_SOGGETTO_GESTORE = soggettoGestore.ID_SOGGETTO_GESTORE");

		sql.append(" AND ");

		sql.append(
				"sede.fk_tipo_sede=:idSede and persAzienda.fk_ruolo=:idRuolo and  storicoStatoPratica.data_fine_stato is null ");
		/*PROTECTED REGION ID(R1282709257) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		/*		if (ConvertUtil.checkIntIsNullOrZero(input.getTipoSede())) {
					sql.append(" AND ");
					sql.append("sede.fk_tipo_sede=:idSede");
					paramMap.addValue("idSede", input.getTipoSede());
				}
				if (ConvertUtil.checkIntIsNullOrZero(input.getIdRuolo())) {
					sql.append(" AND ");
					sql.append("persAzienda.fk_ruolo=:idRuolo");
					paramMap.addValue("idRuolo", input.getIdRuolo());
				}*/
		LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] idSede = " 	+input.getTipoSede());
		LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] idRuolo = " 	+input.getIdRuolo());
		paramMap.addValue("idSede", input.getTipoSede());
		paramMap.addValue("idRuolo", input.getIdRuolo());

		if (ConvertUtil.checkListIsNullOrEmpty(input.getAlboAppartenenza())) {
			sql.append(" AND ");
			sql.append("pratica.fk_soggetto_gestore IN (:stringAlboAppartenenza)");
			List<Integer> listAlboAppartenenza = new ArrayList<Integer>();
			for(String albo: input.getAlboAppartenenza()) {
				listAlboAppartenenza.add(ConvertUtil.convertToInteger(albo));
			}
			paramMap.addValue("stringAlboAppartenenza", listAlboAppartenenza);

		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getNumeroAlbo())) {
			sql.append(" AND ");
			sql.append("pratica.numero_albo = :numeroAlbo");
			paramMap.addValue("numeroAlbo", input.getNumeroAlbo());
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getDenominazioneAzienda())) {
			sql.append(" AND ");
			sql.append(" upper(azienda.ragione_sociale) like upper(:denominazione)");
			String denominazione = "%" + input.getDenominazioneAzienda() + "%";
			paramMap.addValue("denominazione", denominazione);
		} 
		
		if (ConvertUtil.checkIsNullOrEmpty(input.getCodiceFiscaleAzienda())) {
			sql.append(" AND ");
			sql.append("( upper(azienda.codice_fiscale) like upper(:codFiscalePiva)");
			sql.append(" OR ");
			sql.append(" upper(azienda.partita_iva) like upper(:codFiscalePiva)");
			sql.append(" OR ");
			sql.append("upper(azienda.n_siret) like upper(:codFiscalePiva)");
			sql.append(" OR ");
			sql.append("upper(azienda.n_tva) like upper(:codFiscalePiva)");
			sql.append(")");
			String codFiscalePiva = "%" + input.getCodiceFiscaleAzienda() + "%";
			paramMap.addValue("codFiscalePiva", codFiscalePiva);
		}
		if (ConvertUtil.checkIsNullOrEmpty(input.getTitolare())) {
			sql.append(" AND ");
			sql.append("upper(persona.cognome) like upper(:titolare)");
			String titolare ="%" + input.getTitolare() + "%";
			paramMap.addValue("titolare", titolare);
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getIstatComune())) {
			sql.append(" AND ");
			sql.append("sede.istat_comune = :istatComune");
			String istatComune = input.getIstatComune();
			paramMap.addValue("istatComune", istatComune);
			
		} else if (ConvertUtil.checkIsNullOrEmpty(input.getIstatProvincia())) {
			sql.append(" AND ");
			sql.append("LEFT(sede.istat_comune,3) = :istatProvincia");
			String istatProvincia = input.getIstatProvincia();
			paramMap.addValue("istatProvincia", istatProvincia);
		}

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		if (input.getDataDa() != null && !input.getDataDa().equals(Constants.blank)) {
			sql.append(" AND ");
			if (input.getDataA() != null && !input.getDataA().equals(Constants.blank)) {
				sql.append("pratica.data_iscrizione_albo BETWEEN  to_date(:dataDa,'dd/mm/yyyy')  and   to_date(:dataA ,'dd/mm/yyyy')");
				paramMap.addValue("dataA", df.format(input.getDataA()));
			} else {
				sql.append("pratica.data_iscrizione_albo  > to_date(:dataDa,'dd/mm/yyyy')");
			}
			paramMap.addValue("dataDa", df.format(input.getDataDa()));

		} else {
			if (input.getDataA() != null && !input.getDataA().equals(Constants.blank)) {
				sql.append("pratica.data_iscrizione_albo  < to_date(:dataA,'dd/mm/yyyy')");
				paramMap.addValue("dataA", df.format(input.getDataA()));
			}
		}

		if (input.getStatoPratica() != 0 && !input.isRicercaLibera()) {
			sql.append(" AND ");
			if (input.getStatoPratica() == 4) { //ISCRITTA	
				sql.append("storicoStatoPratica.fk_stato_pratica IN (4,8,9)");
			} else if (input.getStatoPratica() == 5) { // SOSPESA
				sql.append("storicoStatoPratica.fk_stato_pratica IN (5,10)");
			} else {
				sql.append("storicoStatoPratica.fk_stato_pratica = :statoPratica");
			}
			paramMap.addValue("statoPratica",input.getStatoPratica());

		} else if (input.isRicercaLibera()) {
			sql.append(" AND ");
			sql.append("storicoStatoPratica.fk_stato_pratica IN (4,8,9)");
		}

		if (ConvertUtil.checkListIsNullOrEmpty(input.getSezione())) {
			sql.append(" AND ");
			sql.append("pratica.flg_sezione IN (:stringSezione)");
//			String stringSezione = ConvertUtil.createStringForQueryWithParamMap(input.getSezione());
//			LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] stringSezione " + stringSezione);
			paramMap.addValue("stringSezione", input.getSezione());
		}

		if (ConvertUtil.checkListIsNullOrEmpty(input.getListaCategoriaImpresa())) {
			sql.append(" AND ");
			sql.append(
					" azienda.id_azienda IN( select categ.id_azienda from  taif_r_azienda_categimpresa categ , taif_d_categoria_impresa imp "
							+ "where categ.id_categoria=imp.id_categoria ");
			sql.append(" and categ.id_categoria IN (:categoriaImpresaList)");
			sql.append(")");
			//String stringCategoriaImpresa = ConvertUtil.createStringForQueryWithInt(input.getListaCategoriaImpresa());
			//LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] stringCategoriaImpresa " + stringCategoriaImpresa);
			List<Integer> categoriaImpresaList = new ArrayList<Integer>();
			for(int i=0;i<input.getListaCategoriaImpresa().size();i++) {
				LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] input.getListaCategoriaImpresa().get(" + i + ") " + input.getListaCategoriaImpresa().get(i));
				categoriaImpresaList.add(ConvertUtil.convertToInteger(input.getListaCategoriaImpresa().get(i)));
			}
			LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] categoriaImpresaList size " + categoriaImpresaList.size());

			paramMap.addValue("categoriaImpresaList", categoriaImpresaList);
		}

		if (input.getAttivitaSvolteList() != null) {
			sql.append(" AND ");
			sql.append(
					" azienda.id_azienda IN( select azienda.id_azienda from  taif_t_attivita_svolta attivita, taif_t_azienda  azienda "
							+ "where azienda.id_azienda =attivita.fk_azienda ");
			sql.append(" and attivita.fk_tipo_attivita IN (:listAttivitaSvolte))");
//			String stringAttivitaSvolte = ConvertUtil.createStringForQueryWithAttivita(input.getAttivitaSvolteList());
//			LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] stringAttivitaSvolte " + stringAttivitaSvolte);
			List<Integer> listAttivitaSvolte = new ArrayList<Integer>();
			for(int i=0;i<input.getAttivitaSvolteList().size();i++) {
				LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] getIdAttivita() " +input.getAttivitaSvolteList().get(i).getIdAttivita());

				listAttivitaSvolte.add(input.getAttivitaSvolteList().get(i).getIdAttivita());
			}
			LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] listAttivitaSvolte size " + listAttivitaSvolte.size());

			paramMap.addValue("listAttivitaSvolte", listAttivitaSvolte);
		}
		if (ConvertUtil.checkIsNullOrEmpty(input.getAppartenenzaCertificazioni())) {
			sql.append(" AND ");
			sql.append(" azienda.id_azienda IN (SELECT DISTINCT FK_AZIENDA FROM TAIF_T_CERTIFICAZIONE)");
		}
		if (ConvertUtil.checkIsNullOrEmpty(input.getAppartenenzaAltriAlbi())) {
			sql.append(" AND ");
			sql.append(
					" azienda.id_azienda IN (SELECT fk_AZIENDA FROM (SELECT fk_azienda, count (*) N FROM  TAIF_T_PRATICA group by fk_azienda) as N WHERE N > 1)");
		}

		sql.append(" ORDER BY azienda.RAGIONE_SOCIALE ASC");
		
		LOG.info("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] QUERY = " 	+sql.toString());
		/*PROTECTED REGION END*/

		List<TaifTAziendaRicercaAziendaAvanzataDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ricercaAziendaAvanzataRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findRicercaAziendaAvanzata", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findRicercaAziendaAvanzata] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder ricercaAziendaExport con Qdef
		 * @generated
		 */

	public List<TaifTAziendaRicercaAziendaExportDto> findRicercaAziendaExport(
			it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter input)
			throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findRicercaAziendaExport] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as idAzienda, pratica.FK_SOGGETTO_GESTORE as idAlboAppartenenza, azienda.RAGIONE_SOCIALE as denominazioneAzienda, azienda.CODICE_FISCALE as codiceFiscaleAzienda, azienda.PARTITA_IVA as pivaAzienda, pratica.NUMERO_ALBO as numeroAlbo, pratica.DATA_ISCRIZIONE_ALBO as iscrizioneAlbo, pratica.ID_PRATICA as idPratica, sede.ISTAT_COMUNE as istatComuneSede, azienda.CCIAA_SIGLA_PROV as siglaProvincia, azienda.CCIAA_NUMERO as numeroCciaa, azienda.DESCR_ALTRA_FORMA_GIURIDICA as altraFormaGiuridica, azienda.NBRE_SALARIES_FRA as numeroSalaries, azienda.TEMPS_PLEIN_FRA as tempoIndeterminato, azienda.PEC as pecAzienda, azienda.EMAIL as mailAzienda, azienda.SITO_WEB as sitoWeb, pratica.FLG_SEZIONE as sezione, pratica.DATA_ISCRIZIONE_ALBO as dataIscrizioneAlbo, sede.ISTAT_COMUNE as istatComune, sede.INDIRIZZO as indirizzo, sede.CIVICO as civico, sede.CAP as cap, sede.TELEFONO as telefono, azienda.FK_ATTIVITA_PRIMARIA as attivitaPrimaria, azienda.FK_ATTIVITA_SECONDARIA as attivitaSecondaria, azienda.N_MARCA_BOLLO as numeroBollo, azienda.ANNO_INIZIO as annoInizio, azienda.FATTURATO as fatturato");

		sql.append(
				" FROM TAIF_T_AZIENDA azienda, TAIF_T_PRATICA pratica, TAIF_T_PERSONA persona, TAIF_T_SEDE_AZIENDA sede, TAIF_R_PERSONA_AZIENDA persAzienda");

		sql.append(" WHERE ");

		sql.append(
				"azienda.ID_AZIENDA = pratica.FK_AZIENDA AND azienda.ID_AZIENDA = persAzienda.ID_AZIENDA AND azienda.ID_AZIENDA = sede.FK_AZIENDA AND persAzienda.ID_PERSONA = persona.ID_PERSONA");

		sql.append(" AND ");

		sql.append("sede.fk_tipo_sede=:idSede and persAzienda.fk_ruolo=:idRuolo");
		/*PROTECTED REGION ID(R323357131) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idSede", input.getTipoSede());
		paramMap.addValue("idRuolo", input.getIdRuolo());

		if (input.getAlboAppartenenza().size() != 0 && input.getAlboAppartenenza().size() > 0) {
			sql.append(" AND ");
			sql.append("pratica.fk_soggetto_gestore=:idSoggettoGestore");
			paramMap.addValue("idSoggettoGestore" , input.getAlboAppartenenza());
		}

		if (input.getTitolare() != null && !input.getTitolare().contentEquals(Constants.blank)) {
			sql.append(" AND ");
			sql.append("persona.cognome ilike :titolare");
			String titolare = "%" +  input.getTitolare() + "%";
			paramMap.addValue("titolare" , titolare);
		}

		if (input.getCodiceFiscaleAzienda() != null && !input.getCodiceFiscaleAzienda().equals(Constants.blank)) {
			sql.append(" AND ");
			sql.append("azienda.codice_fiscale like :codiceFiscaleAzienda");
			String codiceFiscaleAzienda = "%" + input.getCodiceFiscaleAzienda() + "%";
			paramMap.addValue("codiceFiscaleAzienda", codiceFiscaleAzienda );

		}

		if (input.getNumeroAlbo() != null && !input.getNumeroAlbo().equals(Constants.blank)) {
			sql.append(" AND ");
			sql.append("pratica.numero_albo = :numeroAlbo");
			paramMap.addValue("numeroAlbo" , input.getNumeroAlbo());

		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		if (input.getDataDa() != null && !input.getDataDa().equals(Constants.blank)) {
			sql.append(" AND ");
			if (input.getDataA() != null && !input.getDataA().equals(Constants.blank)) {
				sql.append("pratica.data_iscrizione_albo BETWEEN  to_date(:dataDa,'dd/mm/yyyy')  AND   to_date(:dataA ,'dd/mm/yyyy')");
				paramMap.addValue("dataA" , df.format(input.getDataA()));

			} else {
				sql.append("pratica.data_iscrizione_albo  > to_date(:dataDa,'dd/mm/yyyy')");
			}
			
			paramMap.addValue("dataDa" , df.format(input.getDataDa()));

		} else {
			if (input.getDataA() != null && !input.getDataA().equals(Constants.blank)) {
				sql.append("pratica.data_iscrizione_albo  < to_date(:dataA,'dd/mm/yyyy')");
				paramMap.addValue("dataA" , df.format(input.getDataA()));

			}
		}

		if (input.getIstatComune() != null && !input.getIstatComune().equals(Constants.blank)) {
			sql.append(" AND ");
			sql.append("sede.istat_comune = :istatComune");
			paramMap.addValue("istatComune", input.getIstatComune());
		}

		if (input.getSezione() != null && !input.getSezione().equals(Constants.blank)) {
			sql.append(" AND ");
			sql.append("pratica.flg_sezione = :sezione");
			paramMap.addValue("sezione", input.getSezione());

		}

		if (input.getListaCategoriaImpresa() != null && input.getListaCategoriaImpresa().size() > 0) {
			Object[] categoriaArray = input.getListaCategoriaImpresa().toArray();
			sql.append(" AND ");
			sql.append(
					" azienda.id_azienda IN( select categ.id_azienda from  taif_r_azienda_categimpresa categ , taif_d_categoria_impresa imp "
							+ "where categ.id_categoria=imp.id_categoria ");
			for (Object categoria : categoriaArray) {
				sql.append(" and categ.id_categoria = :idCategoria");
				paramMap.addValue("idCategoria", categoria.toString());
			}
			sql.append(")");

		}

		if (input.getAttivitaSvolteList() != null) {
			Object[] attivitaArray = input.getAttivitaSvolteList().toArray();
			sql.append(" AND ");
			sql.append(
					" azienda.id_azienda IN( select categ.id_azienda from  taif_t_attivita_svolta attivita , taif_t_azienda  azienda "
							+ "where azienda.id_azienda=attivita.id_azienda ");
			for (Object attivita : attivitaArray) {
				sql.append(" and attivita.id_attivita = :attivita");
				paramMap.addValue("attivita", attivita.toString());

			}
			sql.append(")");

		}

		/*PROTECTED REGION END*/

		List<TaifTAziendaRicercaAziendaExportDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ricercaAziendaExportRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findRicercaAziendaExport] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findRicercaAziendaExport", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findRicercaAziendaExport] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder elencoDomandaByLegaleRapp con Qdef
		 * @generated
		 */

	public List<TaifTAziendaElencoDomandaByLegaleRappDto> findElencoDomandaByLegaleRapp(java.lang.String input)
			throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findElencoDomandaByLegaleRapp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as idAzienda, azienda.RAGIONE_SOCIALE as ragioneSociale, pratica.ID_PRATICA as idPratica, pratica.NUMERO_ALBO as numeroAlbo, pratica.DATA_ISCRIZIONE_ALBO as iscrizioneAlbo, pratica.FK_SOGGETTO_GESTORE as idSogettoGestore, statoPratica.STATO_PRATICA_ITA as statoPraticaItalia, storicoStato.FK_STATO_PRATICA as idStatoPratica, soggettoGestore.CODICE as codiceAlbo");

		sql.append(
				" FROM TAIF_T_AZIENDA azienda, TAIF_T_PRATICA pratica, TAIF_R_PERSONA_AZIENDA personaAzienda, TAIF_T_PERSONA persona, TAIF_T_STORICO_STATO storicoStato, TAIF_T_SOGGETTO_GESTORE soggettoGestore, TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append(
				"azienda.ID_AZIENDA = pratica.FK_AZIENDA AND personaAzienda.ID_PERSONA = persona.ID_PERSONA AND azienda.ID_AZIENDA = personaAzienda.ID_AZIENDA AND pratica.ID_PRATICA = storicoStato.ID_PRATICA AND pratica.FK_SOGGETTO_GESTORE = soggettoGestore.ID_SOGGETTO_GESTORE AND storicoStato.FK_STATO_PRATICA = statoPratica.ID_STATO_PRATICA");

		sql.append(" AND ");

		sql.append(
				"personaAzienda.fk_ruolo=1 and storicoStato.data_fine_stato is null  and persona.codice_fiscale=:codiceFiscale ");
		/*PROTECTED REGION ID(R149442416) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/

		List<TaifTAziendaElencoDomandaByLegaleRappDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, elencoDomandaByLegaleRappRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findElencoDomandaByLegaleRapp] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findElencoDomandaByLegaleRapp", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findElencoDomandaByLegaleRapp] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder intestazioneRiepilogo con Qdef
		 * @generated
		 */

	public List<TaifTAziendaIntestazioneRiepilogoDto> findIntestazioneRiepilogo(java.lang.Integer idAzienda,
			java.lang.Integer input) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findIntestazioneRiepilogo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.RAGIONE_SOCIALE as ragioneSocialeAzienda, azienda.CODICE_FISCALE as codiceFiscaleAzienda, azienda.PARTITA_IVA as pivaAzienda, pratica.DATA_AGGIORNAMENTO as dataAggiornamento, statoPraticaTab.STATO_PRATICA_ITA as statoPraticaItalia, statoPraticaTab.STATO_PRATICA_FRA as statoPraticaFrance");

		sql.append(
				" FROM TAIF_T_AZIENDA aziendaTab, TAIF_T_PRATICA praticaTab, TAIF_D_STATO_PRATICA statoPraticaTab, TAIF_T_STORICO_STATO storicoStatoTab");

		sql.append(" WHERE ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-452558227) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		//paramMap.addValue("param", input);

		/*PROTECTED REGION END*/

		List<TaifTAziendaIntestazioneRiepilogoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, intestazioneRiepilogoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findIntestazioneRiepilogo] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findIntestazioneRiepilogo", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findIntestazioneRiepilogo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder intestazioneRiepilogoByPratica con Qdef
		 * @generated
		 */

	public List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> findIntestazioneRiepilogoByPratica(
			java.lang.Integer input) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findIntestazioneRiepilogoByPratica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT aziendaTab.ID_AZIENDA as idAzienda, aziendaTab.RAGIONE_SOCIALE as ragioneSocialeAzienda, aziendaTab.CODICE_FISCALE as codiceFiscaleAzienda, aziendaTab.PARTITA_IVA as pivaAzienda, aziendaTab.N_SIRET as nSiret, aziendaTab.DATA_AGGIORNAMENTO as dataAggiornamento, statoPraticaTab.STATO_PRATICA_ITA as statoPraticaItalia, statoPraticaTab.STATO_PRATICA_FRA as statoPraticaFrance, praticaTab.ID_PRATICA as idPratica, praticaTab.DATA_AGGIORNAMENTO as dataAggiornamentoPratica, praticaTab.FK_SOGGETTO_GESTORE as idSoggettoGestore, storicoStatoTab.FK_STATO_PRATICA as idStatoPratica, personaTab.COGNOME as operatoreCognome, personaTab.NOME as operatoreNome, praticaTab.DATA_ISCRIZIONE_ALBO as dataIscrizioneAlbo, praticaTab.NUMERO_ALBO as numeroIscrizioneAlbo, storicoStatoAvvioTab.NUMERO_PROTOCOLLO as numeroProtocollo, storicoStatoAvvioTab.DATA_PROTOCOLLO as dataProtocollo");

		sql.append(
				" FROM TAIF_T_AZIENDA aziendaTab, TAIF_T_PRATICA praticaTab, TAIF_D_STATO_PRATICA statoPraticaTab, TAIF_T_STORICO_STATO storicoStatoTab, TAIF_CNF_CONFIG_UTENTE configTab, TAIF_T_PERSONA personaTab, TAIF_T_STORICO_STATO storicoStatoAvvioTab");

		sql.append(" WHERE ");

		sql.append(
				"aziendaTab.ID_AZIENDA = praticaTab.FK_AZIENDA AND praticaTab.ID_PRATICA = storicoStatoTab.ID_PRATICA AND storicoStatoTab.FK_STATO_PRATICA = statoPraticaTab.ID_STATO_PRATICA AND aziendaTab.FK_CONFIG_UTENTE = configTab.ID_CONFIG_UTENTE AND configTab.FK_PERSONA = personaTab.ID_PERSONA AND praticaTab.ID_PRATICA = storicoStatoAvvioTab.ID_PRATICA");

		sql.append(" AND ");

		sql.append("praticaTab.ID_PRATICA  = :idPratica and storicoStatoTab.DATA_FINE_STATO is null");
		/*PROTECTED REGION ID(R1437310312) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPratica", input);

		/*PROTECTED REGION END*/

		List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, intestazioneRiepilogoByPraticaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findIntestazioneRiepilogoByPratica] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findIntestazioneRiepilogoByPratica", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findIntestazioneRiepilogoByPratica] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder dettaglioAziendaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAziendaDettaglioAziendaByIdAziendaDto> findDettaglioAziendaByIdAzienda(java.lang.Integer input)
			throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findDettaglioAziendaByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as id, pratica.FK_SOGGETTO_GESTORE as idAlboAppartenenza, azienda.RAGIONE_SOCIALE as denominazioneAzienda, azienda.CODICE_FISCALE as codiceFiscaleAzienda, azienda.PARTITA_IVA as pivaAzienda, persona.NOME as nomeTitolare, persona.COGNOME as cognomeTitolare, pratica.NUMERO_ALBO as numeroAlbo, pratica.DATA_ISCRIZIONE_ALBO as iscrizioneAlbo, pratica.ID_PRATICA as idPratica, sede.ISTAT_COMUNE as istatComuneSede, storicoStatoPratica.FK_STATO_PRATICA as idStatoPratica, statoPratica.STATO_PRATICA_ITA as dsStatoPraticaIta, statoPratica.STATO_PRATICA_FRA as dsStatoPraticaFra, soggettoGestore.DENOMINAZIONE_BREVE as dsAlboAppartenenza, azienda.N_SIRET as nSiret, azienda.N_TVA as nTva, sede.COMUNE_ESTERO as comuneSedeEstero, formagiuridicaita.FORMA_GIURIDICA as formagiuridicaita, formagiuridicafra.FORMA_GIURIDICA as formagiuridicafra, azienda.EMAIL as email, azienda.SITO_WEB as sitoWeb, azienda.NBRE_SALARIES_FRA as nbreSalariesFra, azienda.TEMPS_PLEIN_FRA as tempsPleinFra, sede.INDIRIZZO as indirizzo, sede.CIVICO as civico, sede.CAP as cap, pratica.FLG_SEZIONE as sezione, sede.TELEFONO as telefono");

		sql.append(
				" FROM TAIF_T_AZIENDA azienda, TAIF_T_PRATICA pratica, TAIF_T_PERSONA persona, TAIF_T_SEDE_AZIENDA sede, TAIF_R_PERSONA_AZIENDA persAzienda, TAIF_T_STORICO_STATO storicoStatoPratica, TAIF_D_STATO_PRATICA statoPratica, TAIF_T_SOGGETTO_GESTORE soggettoGestore, TAIF_D_FORMA_GIURIDICA formagiuridicaita, TAIF_D_FORMA_GIURIDICA formagiuridicafra");

		sql.append(" WHERE ");

		sql.append(
				"azienda.ID_AZIENDA = pratica.FK_AZIENDA AND azienda.ID_AZIENDA = persAzienda.ID_AZIENDA AND azienda.ID_AZIENDA = sede.FK_AZIENDA AND persAzienda.ID_PERSONA = persona.ID_PERSONA AND pratica.ID_PRATICA = storicoStatoPratica.ID_PRATICA AND storicoStatoPratica.FK_STATO_PRATICA = statoPratica.ID_STATO_PRATICA AND pratica.FK_SOGGETTO_GESTORE = soggettoGestore.ID_SOGGETTO_GESTORE AND azienda.FK_FORMA_GIURIDICA_ITA = formagiuridicaita.ID_FORMA_GIURIDICA AND azienda.FK_FORMA_GIURIDICA_FRA = formagiuridicafra.ID_FORMA_GIURIDICA");

		sql.append(" AND ");

		sql.append(
				"sede.fk_tipo_sede=1 and persAzienda.fk_ruolo=1 and  storicoStatoPratica.data_fine_stato is null and azienda.id_azienda = :idAziendaSelezionata");
		/*PROTECTED REGION ID(R1003370681) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAziendaSelezionata", input);

		/*PROTECTED REGION END*/

		List<TaifTAziendaDettaglioAziendaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, dettaglioAziendaByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findDettaglioAziendaByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findDettaglioAziendaByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findDettaglioAziendaByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder elencoDomandaByLegaleRappAndProf con Qdef
		 * @generated
		 */

	public List<TaifTAziendaElencoDomandaByLegaleRappAndProfDto> findElencoDomandaByLegaleRappAndProf(
			java.lang.String input) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findElencoDomandaByLegaleRappAndProf] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azienda.ID_AZIENDA as idAzienda, azienda.RAGIONE_SOCIALE as ragioneSociale, pratica.ID_PRATICA as idPratica, pratica.NUMERO_ALBO as numeroAlbo, pratica.DATA_ISCRIZIONE_ALBO as iscrizioneAlbo, pratica.FK_SOGGETTO_GESTORE as idSogettoGestore, statoPratica.STATO_PRATICA_ITA as statoPraticaItalia, statoPratica.STATO_PRATICA_FRA as statoPraticaFrancia, storicoStato.FK_STATO_PRATICA as idStatoPratica, soggettoGestore.CODICE as codiceAlbo, persona.CODICE_FISCALE as codiceFiscalePersona, persona2.CODICE_FISCALE as codiceFiscalePersona2");

		sql.append(
				" FROM TAIF_T_AZIENDA azienda, TAIF_T_PRATICA pratica, TAIF_R_PERSONA_AZIENDA personaAzienda, TAIF_T_PERSONA persona, TAIF_T_STORICO_STATO storicoStato, TAIF_T_SOGGETTO_GESTORE soggettoGestore, TAIF_D_STATO_PRATICA statoPratica, TAIF_T_STORICO_STATO storicoStato2, TAIF_CNF_CONFIG_UTENTE configUtente, TAIF_T_PERSONA persona2");

		sql.append(" WHERE ");

		sql.append(
				"azienda.ID_AZIENDA = pratica.FK_AZIENDA AND personaAzienda.ID_PERSONA = persona.ID_PERSONA AND azienda.ID_AZIENDA = personaAzienda.ID_AZIENDA AND pratica.ID_PRATICA = storicoStato.ID_PRATICA AND pratica.FK_SOGGETTO_GESTORE = soggettoGestore.ID_SOGGETTO_GESTORE AND storicoStato.FK_STATO_PRATICA = statoPratica.ID_STATO_PRATICA AND pratica.ID_PRATICA = storicoStato2.ID_PRATICA AND storicoStato2.FK_CONFIG_UTENTE = configUtente.ID_CONFIG_UTENTE AND configUtente.FK_PERSONA = persona2.ID_PERSONA");

		sql.append(" AND ");

		sql.append(
				"personaAzienda.fk_ruolo=1 and storicoStato.data_fine_stato is null  and storicoStato2.data_fine_stato is null  ");
		/*PROTECTED REGION ID(R900545904) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (input != null && !input.equals(Constants.blank)) {
			sql.append(" AND ");
			sql.append(" ( ");
			sql.append("persona.codice_fiscale like :input");
			sql.append(" OR ");
			sql.append("persona.n_rsi_msa like :input");
			sql.append(" OR ");
			sql.append("persona2.codice_fiscale like :input");
			sql.append(" OR ");
			sql.append("persona2.n_rsi_msa like :input");
			sql.append(" ) ");
			
			String codiceFiscale = "%" + input +"%";
			paramMap.addValue("input", codiceFiscale);

		}

		/*PROTECTED REGION END*/

		List<TaifTAziendaElencoDomandaByLegaleRappAndProfDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, elencoDomandaByLegaleRappAndProfRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findElencoDomandaByLegaleRappAndProf] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findElencoDomandaByLegaleRappAndProf", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findElencoDomandaByLegaleRappAndProf] END");
		}
		return list;
	}

}
