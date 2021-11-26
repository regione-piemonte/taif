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
 * RowMapper specifico del DAO TaifTRiconoscimentoDao
 * @generated
 */
public class TaifTRiconoscimentoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTRiconoscimentoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTRiconoscimentoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTRiconoscimentoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTRiconoscimentoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTRiconoscimentoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTRiconoscimentoDto) {
			return mapRow_internal((TaifTRiconoscimentoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTRiconoscimentoByIdPersonaDto) {
			return mapRow_internal((TaifTRiconoscimentoByIdPersonaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTRiconoscimentoDto mapRow_internal(TaifTRiconoscimentoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTRiconoscimentoDto dto = objectToFill;

		// colonna [ID_RICONOSCIMENTO]
		if (mapAllColumns || columnsToReadMap.get("ID_RICONOSCIMENTO") != null)
			dto.setIdRiconoscimento((Integer) rs.getObject("ID_RICONOSCIMENTO"));

		// colonna [FK_UNITA_FORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("FK_UNITA_FORMATIVA") != null)
			dto.setFkUnitaFormativa((Integer) rs.getObject("FK_UNITA_FORMATIVA"));

		// colonna [FK_AGENZIA_FORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("FK_AGENZIA_FORMATIVA") != null)
			dto.setFkAgenziaFormativa((Integer) rs.getObject("FK_AGENZIA_FORMATIVA"));

		// colonna [FK_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA") != null)
			dto.setFkPersona((Integer) rs.getObject("FK_PERSONA"));

		// colonna [DATA_RICONOSCIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_RICONOSCIMENTO") != null)
			dto.setDataRiconoscimento(rs.getDate("DATA_RICONOSCIMENTO"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTRiconoscimentoByIdPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTRiconoscimentoByIdPersonaDto
	 * @generated
	 */

	public TaifTRiconoscimentoByIdPersonaDto mapRow_internal(TaifTRiconoscimentoByIdPersonaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTRiconoscimentoByIdPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDRICONOSCIMENTO") != null)
			dto.setIdRiconoscimento((Integer) rs.getObject("idRiconoscimento"));

		if (mapAllColumns || columnsToReadMap.get("UNITAFORMATIVA") != null)
			dto.setUnitaFormativa(rs.getString("unitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALE") != null)
			dto.setRagioneSociale(rs.getString("ragioneSociale"));

		if (mapAllColumns || columnsToReadMap.get("DATARILASCIO") != null)
			dto.setDataRilascio(rs.getDate("dataRilascio"));

		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("note"));

		return dto;
	}

}
