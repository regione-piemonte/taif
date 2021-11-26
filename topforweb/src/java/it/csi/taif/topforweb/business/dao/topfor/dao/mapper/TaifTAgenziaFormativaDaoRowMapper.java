/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.mapper;

import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.impl.BaseDaoRowMapper;
import it.csi.taif.topforweb.business.dao.topfor.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO TaifTAgenziaFormativaDao
 * @generated
 */
public class TaifTAgenziaFormativaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTAgenziaFormativaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTAgenziaFormativaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTAgenziaFormativaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTAgenziaFormativaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAgenziaFormativaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTAgenziaFormativaDto) {
			return mapRow_internal((TaifTAgenziaFormativaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTAgenziaFormativaByFilterVisibleDto) {
			return mapRow_internal((TaifTAgenziaFormativaByFilterVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAgenziaFormativaByFilterSoggettoGestoreDto) {
			return mapRow_internal((TaifTAgenziaFormativaByFilterSoggettoGestoreDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAgenziaFormativaByUnitaFormativaPersonaDto) {
			return mapRow_internal((TaifTAgenziaFormativaByUnitaFormativaPersonaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTAgenziaFormativaDto mapRow_internal(TaifTAgenziaFormativaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTAgenziaFormativaDto dto = objectToFill;

		// colonna [ID_AGENZIA_FORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("ID_AGENZIA_FORMATIVA") != null)
			dto.setIdAgenziaFormativa((Integer) rs.getObject("ID_AGENZIA_FORMATIVA"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [PARTITA_IVA]
		if (mapAllColumns || columnsToReadMap.get("PARTITA_IVA") != null)
			dto.setPartitaIva(rs.getString("PARTITA_IVA"));

		// colonna [RAGIONE_SOCIALE]
		if (mapAllColumns || columnsToReadMap.get("RAGIONE_SOCIALE") != null)
			dto.setRagioneSociale(rs.getString("RAGIONE_SOCIALE"));

		// colonna [CODICE_PSR]
		if (mapAllColumns || columnsToReadMap.get("CODICE_PSR") != null)
			dto.setCodicePsr(rs.getString("CODICE_PSR"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [ISTAT_SEDE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_SEDE") != null)
			dto.setIstatSede(rs.getString("ISTAT_SEDE"));

		// colonna [COMUNE_ESTERO]
		if (mapAllColumns || columnsToReadMap.get("COMUNE_ESTERO") != null)
			dto.setComuneEstero(rs.getString("COMUNE_ESTERO"));

		// colonna [INDIRIZZO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("INDIRIZZO"));

		// colonna [CAP]
		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("CAP"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		// colonna [FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("FLG_VISIBILE") != null)
			dto.setFlgVisibile(rs.getBigDecimal("FLG_VISIBILE"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAgenziaFormativaByFilterVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAgenziaFormativaByFilterVisibleDto
	 * @generated
	 */

	public TaifTAgenziaFormativaByFilterVisibleDto mapRow_internal(TaifTAgenziaFormativaByFilterVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTAgenziaFormativaByFilterVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAGENZIAFORMATIVA") != null)
			dto.setIdAgenziaFormativa((Integer) rs.getObject("idAgenziaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEAGENZIAFORMATIVA") != null)
			dto.setDenominazioneAgenziaFormativa(rs.getString("denominazioneAgenziaFormativa"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAgenziaFormativaByFilterSoggettoGestoreDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAgenziaFormativaByFilterSoggettoGestoreDto
	 * @generated
	 */

	public TaifTAgenziaFormativaByFilterSoggettoGestoreDto mapRow_internal(
			TaifTAgenziaFormativaByFilterSoggettoGestoreDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAgenziaFormativaByFilterSoggettoGestoreDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAGENZIA") != null)
			dto.setIdAgenzia((Integer) rs.getObject("idAgenzia"));

		if (mapAllColumns || columnsToReadMap.get("DSAGENZIAFORMATIVA") != null)
			dto.setDsAgenziaFormativa(rs.getString("dsAgenziaFormativa"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAgenziaFormativaByUnitaFormativaPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAgenziaFormativaByUnitaFormativaPersonaDto
	 * @generated
	 */

	public TaifTAgenziaFormativaByUnitaFormativaPersonaDto mapRow_internal(
			TaifTAgenziaFormativaByUnitaFormativaPersonaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAgenziaFormativaByUnitaFormativaPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALE") != null)
			dto.setRagioneSociale(rs.getString("ragioneSociale"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("indirizzo"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("ISTATSEDE") != null)
			dto.setIstatSede(rs.getString("istatSede"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEBREVE") != null)
			dto.setDenominazioneBreve(rs.getString("denominazioneBreve"));

		if (mapAllColumns || columnsToReadMap.get("COGNOMEPERSONA") != null)
			dto.setCognomePersona(rs.getString("cognomePersona"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("NOMEPERSONA") != null)
			dto.setNomePersona(rs.getString("nomePersona"));

		if (mapAllColumns || columnsToReadMap.get("CORSO") != null)
			dto.setCorso(rs.getString("corso"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA") != null)
			dto.setSigla(rs.getString("sigla"));

		if (mapAllColumns || columnsToReadMap.get("DATAINIZIOCORSO") != null)
			dto.setDataInizioCorso(rs.getTimestamp("dataInizioCorso"));

		if (mapAllColumns || columnsToReadMap.get("DATAFINECORSO") != null)
			dto.setDataFineCorso(rs.getTimestamp("dataFineCorso"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROORE") != null)
			dto.setNumeroOre(rs.getBigDecimal("numeroOre"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setDenominazione(rs.getString("denominazione"));

		if (mapAllColumns || columnsToReadMap.get("FLAGESITO") != null)
			dto.setFlagEsito(rs.getString("flagEsito"));

		if (mapAllColumns || columnsToReadMap.get("REFERENTE") != null)
			dto.setReferente(rs.getString("referente"));

		if (mapAllColumns || columnsToReadMap.get("UNITAFORMATIVA") != null)
			dto.setUnitaFormativa(rs.getString("unitaFormativa"));

		return dto;
	}

}
