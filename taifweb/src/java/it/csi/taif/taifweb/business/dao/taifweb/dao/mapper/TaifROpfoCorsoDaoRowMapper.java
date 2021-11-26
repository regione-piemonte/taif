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
 * RowMapper specifico del DAO TaifROpfoCorsoDao
 * @generated
 */
public class TaifROpfoCorsoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifROpfoCorsoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifROpfoCorsoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifROpfoCorsoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifROpfoCorsoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifROpfoCorsoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifROpfoCorsoDto) {
			return mapRow_internal((TaifROpfoCorsoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifROpfoCorsoByIdPersonaDto) {
			return mapRow_internal((TaifROpfoCorsoByIdPersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifROpfoCorsoByIdCorsoDto) {
			return mapRow_internal((TaifROpfoCorsoByIdCorsoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifROpfoCorsoDto mapRow_internal(TaifROpfoCorsoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifROpfoCorsoDto dto = objectToFill;

		// colonna [ID_CORSO]
		if (mapAllColumns || columnsToReadMap.get("ID_CORSO") != null)
			dto.setIdCorso((Integer) rs.getObject("ID_CORSO"));

		// colonna [ID_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("ID_PERSONA"));

		// colonna [FLG_ESITO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ESITO") != null)
			dto.setFlgEsito(rs.getString("FLG_ESITO"));

		// colonna [DESCRIZIONE_ALTRO]
		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONE_ALTRO") != null)
			dto.setDescrizioneAltro(rs.getString("DESCRIZIONE_ALTRO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifROpfoCorsoByIdPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifROpfoCorsoByIdPersonaDto
	 * @generated
	 */

	public TaifROpfoCorsoByIdPersonaDto mapRow_internal(TaifROpfoCorsoByIdPersonaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifROpfoCorsoByIdPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdcorso((Integer) rs.getObject("idcorso"));

		if (mapAllColumns || columnsToReadMap.get("IDPERS") != null)
			dto.setIdpers((Integer) rs.getObject("idpers"));

		if (mapAllColumns || columnsToReadMap.get("DESC") != null)
			dto.setDesc(rs.getString("desc"));

		if (mapAllColumns || columnsToReadMap.get("ESITO") != null)
			dto.setEsito(rs.getString("esito"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifROpfoCorsoByIdCorsoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifROpfoCorsoByIdCorsoDto
	 * @generated
	 */

	public TaifROpfoCorsoByIdCorsoDto mapRow_internal(TaifROpfoCorsoByIdCorsoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifROpfoCorsoByIdCorsoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdcorso((Integer) rs.getObject("idcorso"));

		if (mapAllColumns || columnsToReadMap.get("IDPERS") != null)
			dto.setIdpers((Integer) rs.getObject("idpers"));

		if (mapAllColumns || columnsToReadMap.get("DESC") != null)
			dto.setDesc(rs.getString("desc"));

		if (mapAllColumns || columnsToReadMap.get("ESITO") != null)
			dto.setEsito(rs.getString("esito"));

		return dto;
	}

}
