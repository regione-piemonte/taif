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
 * RowMapper specifico del DAO TaifTSedeAziendaDao
 * @generated
 */
public class TaifTSedeAziendaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTSedeAziendaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTSedeAziendaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTSedeAziendaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTSedeAziendaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTSedeAziendaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTSedeAziendaDto) {
			return mapRow_internal((TaifTSedeAziendaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTSedeAziendaByIdAziendaDto) {
			return mapRow_internal((TaifTSedeAziendaByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTSedeAziendaIdMaxValueDto) {
			return mapRow_internal((TaifTSedeAziendaIdMaxValueDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTSedeAziendaDto mapRow_internal(TaifTSedeAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTSedeAziendaDto dto = objectToFill;

		// colonna [ID_SEDE]
		if (mapAllColumns || columnsToReadMap.get("ID_SEDE") != null)
			dto.setIdSede((Integer) rs.getObject("ID_SEDE"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [FK_TIPO_SEDE]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_SEDE") != null)
			dto.setFkTipoSede((Integer) rs.getObject("FK_TIPO_SEDE"));

		// colonna [ISTAT_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setIstatComune(rs.getString("ISTAT_COMUNE"));

		// colonna [COMUNE_ESTERO]
		if (mapAllColumns || columnsToReadMap.get("COMUNE_ESTERO") != null)
			dto.setComuneEstero(rs.getString("COMUNE_ESTERO"));

		// colonna [INDIRIZZO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("INDIRIZZO"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [CAP]
		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("CAP"));

		// colonna [TELEFONO]
		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("TELEFONO"));

		// colonna [CELLULARE]
		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("CELLULARE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTSedeAziendaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTSedeAziendaByIdAziendaDto
	 * @generated
	 */

	public TaifTSedeAziendaByIdAziendaDto mapRow_internal(TaifTSedeAziendaByIdAziendaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTSedeAziendaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPO") != null)
			dto.setIdTipo((Integer) rs.getObject("idTipo"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNE") != null)
			dto.setIstatComune(rs.getString("istatComune"));

		if (mapAllColumns || columnsToReadMap.get("ESTERO") != null)
			dto.setEstero(rs.getString("estero"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("indirizzo"));

		if (mapAllColumns || columnsToReadMap.get("TIPOSEDE") != null)
			dto.setTipoSede(rs.getString("tipoSede"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFON") != null)
			dto.setTelefon(rs.getString("telefon"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONETIPOSEDE") != null)
			dto.setDescrizioneTipoSede(rs.getString("descrizioneTipoSede"));

		if (mapAllColumns || columnsToReadMap.get("COMUNE") != null)
			dto.setComune(rs.getString("comune"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTSedeAziendaIdMaxValueDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTSedeAziendaIdMaxValueDto
	 * @generated
	 */

	public TaifTSedeAziendaIdMaxValueDto mapRow_internal(TaifTSedeAziendaIdMaxValueDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTSedeAziendaIdMaxValueDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("MAX") != null)
			dto.setMax((Integer) rs.getObject("max"));

		return dto;
	}

}
