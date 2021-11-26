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

		if (dtoInstance instanceof TaifTQualificaByIdPersonaDto) {
			return mapRow_internal((TaifTQualificaByIdPersonaDto) dtoInstance, rs, row);
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
	 * Metodo specifico di mapping relativo al DTO custom TaifTQualificaByIdPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTQualificaByIdPersonaDto
	 * @generated
	 */

	public TaifTQualificaByIdPersonaDto mapRow_internal(TaifTQualificaByIdPersonaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTQualificaByIdPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDQUALIFICA") != null)
			dto.setIdQualifica((Integer) rs.getObject("idQualifica"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOQUALIFICA") != null)
			dto.setIdTipoQualifica((Integer) rs.getObject("idTipoQualifica"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALE") != null)
			dto.setRagioneSociale(rs.getString("ragioneSociale"));

		if (mapAllColumns || columnsToReadMap.get("DATARILASCIO") != null)
			dto.setDataRilascio(rs.getDate("dataRilascio"));

		if (mapAllColumns || columnsToReadMap.get("TIPOQUALIFICA") != null)
			dto.setTipoQualifica(rs.getString("tipoQualifica"));

		return dto;
	}

}
