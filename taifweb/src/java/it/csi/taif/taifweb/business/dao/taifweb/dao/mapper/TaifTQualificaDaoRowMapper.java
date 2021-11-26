/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dao.mapper;

import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.impl.BaseDaoRowMapper;
import it.csi.taif.taifweb.business.dao.taifweb.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO TaifTQualificaDao
 * @generated
 */
public class TaifTQualificaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTQualificaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTQualificaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTQualificaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTQualificaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTQualificaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTQualificaDto) {
			return mapRow_internal((TaifTQualificaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTQualificaByPersonaDto) {
			return mapRow_internal((TaifTQualificaByPersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTQualificaByAgenziaFormativaDto) {
			return mapRow_internal((TaifTQualificaByAgenziaFormativaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTQualificaFindQualificaElencoOperatoriDto) {
			return mapRow_internal((TaifTQualificaFindQualificaElencoOperatoriDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTQualificaDto mapRow_internal(TaifTQualificaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTQualificaDto dto = objectToFill;

		// colonna [ID_QUALIFICA]
		if (mapAllColumns || columnsToReadMap.get("ID_QUALIFICA") != null)
			dto.setIdQualifica((Integer) rs.getObject("ID_QUALIFICA"));

		// colonna [FK_TIPO_QUALIFICA]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_QUALIFICA") != null)
			dto.setFkTipoQualifica((Integer) rs.getObject("FK_TIPO_QUALIFICA"));

		// colonna [FK_AGENZIA_FORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("FK_AGENZIA_FORMATIVA") != null)
			dto.setFkAgenziaFormativa((Integer) rs.getObject("FK_AGENZIA_FORMATIVA"));

		// colonna [FK_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA") != null)
			dto.setFkPersona((Integer) rs.getObject("FK_PERSONA"));

		// colonna [DATA_RILASCIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_RILASCIO") != null)
			dto.setDataRilascio(rs.getDate("DATA_RILASCIO"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTQualificaByPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTQualificaByPersonaDto
	 * @generated
	 */

	public TaifTQualificaByPersonaDto mapRow_internal(TaifTQualificaByPersonaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTQualificaByPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOQUAL") != null)
			dto.setIdTipoQual((Integer) rs.getObject("idTipoQual"));

		if (mapAllColumns || columnsToReadMap.get("AGFORM") != null)
			dto.setAgForm((Integer) rs.getObject("agForm"));

		if (mapAllColumns || columnsToReadMap.get("PERS") != null)
			dto.setPers((Integer) rs.getObject("pers"));

		if (mapAllColumns || columnsToReadMap.get("RIL") != null)
			dto.setRil(rs.getDate("ril"));

		if (mapAllColumns || columnsToReadMap.get("INSER") != null)
			dto.setInser(rs.getTimestamp("inser"));

		if (mapAllColumns || columnsToReadMap.get("QUALIFICA") != null)
			dto.setQualifica(rs.getString("qualifica"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTQualificaByAgenziaFormativaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTQualificaByAgenziaFormativaDto
	 * @generated
	 */

	public TaifTQualificaByAgenziaFormativaDto mapRow_internal(TaifTQualificaByAgenziaFormativaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTQualificaByAgenziaFormativaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOQUAL") != null)
			dto.setIdTipoQual((Integer) rs.getObject("idTipoQual"));

		if (mapAllColumns || columnsToReadMap.get("AGFORM") != null)
			dto.setAgForm((Integer) rs.getObject("agForm"));

		if (mapAllColumns || columnsToReadMap.get("PERS") != null)
			dto.setPers((Integer) rs.getObject("pers"));

		if (mapAllColumns || columnsToReadMap.get("RIL") != null)
			dto.setRil(rs.getDate("ril"));

		if (mapAllColumns || columnsToReadMap.get("INSER") != null)
			dto.setInser(rs.getTimestamp("inser"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTQualificaFindQualificaElencoOperatoriDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTQualificaFindQualificaElencoOperatoriDto
	 * @generated
	 */

	public TaifTQualificaFindQualificaElencoOperatoriDto mapRow_internal(
			TaifTQualificaFindQualificaElencoOperatoriDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTQualificaFindQualificaElencoOperatoriDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDQUALIFICA") != null)
			dto.setIdQualifica((Integer) rs.getObject("idQualifica"));

		if (mapAllColumns || columnsToReadMap.get("TIPOQUALIFICA") != null)
			dto.setTipoQualifica(rs.getString("tipoQualifica"));

		if (mapAllColumns || columnsToReadMap.get("ORDINAMENTO") != null)
			dto.setOrdinamento(rs.getBigDecimal("ordinamento"));

		return dto;
	}

}
