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
 * RowMapper specifico del DAO TaifTAllegatoDao
 * @generated
 */
public class TaifTAllegatoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTAllegatoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTAllegatoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTAllegatoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTAllegatoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAllegatoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTAllegatoDto) {
			return mapRow_internal((TaifTAllegatoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTAllegatoByCorsoPersonaDto) {
			return mapRow_internal((TaifTAllegatoByCorsoPersonaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTAllegatoDto mapRow_internal(TaifTAllegatoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAllegatoDto dto = objectToFill;

		// colonna [ID_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato((Integer) rs.getObject("ID_ALLEGATO"));

		// colonna [FK_PRATICA]
		if (mapAllColumns || columnsToReadMap.get("FK_PRATICA") != null)
			dto.setFkPratica((Integer) rs.getObject("FK_PRATICA"));

		// colonna [FK_CORSO]
		if (mapAllColumns || columnsToReadMap.get("FK_CORSO") != null)
			dto.setFkCorso((Integer) rs.getObject("FK_CORSO"));

		// colonna [FK_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA") != null)
			dto.setFkPersona((Integer) rs.getObject("FK_PERSONA"));

		// colonna [FK_ESTENSIONE_FILE]
		if (mapAllColumns || columnsToReadMap.get("FK_ESTENSIONE_FILE") != null)
			dto.setFkEstensioneFile((Integer) rs.getObject("FK_ESTENSIONE_FILE"));

		// colonna [FK_TIPO_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_ALLEGATO") != null)
			dto.setFkTipoAllegato((Integer) rs.getObject("FK_TIPO_ALLEGATO"));

		// colonna [NOME_FILE]
		if (mapAllColumns || columnsToReadMap.get("NOME_FILE") != null)
			dto.setNomeFile(rs.getString("NOME_FILE"));

		// colonna [DIMENSIONE_FILE_KB]
		if (mapAllColumns || columnsToReadMap.get("DIMENSIONE_FILE_KB") != null)
			dto.setDimensioneFileKb((Integer) rs.getObject("DIMENSIONE_FILE_KB"));

		// colonna [FLG_TIPO_INVIO]
		if (mapAllColumns || columnsToReadMap.get("FLG_TIPO_INVIO") != null)
			dto.setFlgTipoInvio(rs.getString("FLG_TIPO_INVIO"));

		// colonna [FLG_SCADENZA]
		if (mapAllColumns || columnsToReadMap.get("FLG_SCADENZA") != null)
			dto.setFlgScadenza(rs.getBigDecimal("FLG_SCADENZA"));

		// colonna [DATA_UPLOAD]
		if (mapAllColumns || columnsToReadMap.get("DATA_UPLOAD") != null)
			dto.setDataUpload(rs.getTimestamp("DATA_UPLOAD"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [ESTENSIONE_FILE]
		if (mapAllColumns || columnsToReadMap.get("ESTENSIONE_FILE") != null)
			dto.setEstensioneFile(rs.getString("ESTENSIONE_FILE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTAllegatoByCorsoPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAllegatoByCorsoPersonaDto
	 * @generated
	 */

	public TaifTAllegatoByCorsoPersonaDto mapRow_internal(TaifTAllegatoByCorsoPersonaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTAllegatoByCorsoPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDALLEGATO") != null)
			dto.setIdAllegato((Integer) rs.getObject("idAllegato"));

		if (mapAllColumns || columnsToReadMap.get("FKCORSO") != null)
			dto.setFkCorso((Integer) rs.getObject("fkCorso"));

		if (mapAllColumns || columnsToReadMap.get("FKPERSONA") != null)
			dto.setFkPersona((Integer) rs.getObject("fkPersona"));

		return dto;
	}

}
