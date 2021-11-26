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
 * RowMapper specifico del DAO TaifTStrutturaDao
 * @generated
 */
public class TaifTStrutturaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTStrutturaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTStrutturaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTStrutturaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTStrutturaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTStrutturaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTStrutturaDto) {
			return mapRow_internal((TaifTStrutturaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTStrutturaFindByAziendaDto) {
			return mapRow_internal((TaifTStrutturaFindByAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTStrutturaByAziendaFunzioneDto) {
			return mapRow_internal((TaifTStrutturaByAziendaFunzioneDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto) {
			return mapRow_internal((TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTStrutturaDto mapRow_internal(TaifTStrutturaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTStrutturaDto dto = objectToFill;

		// colonna [ID_STRUTTURA]
		if (mapAllColumns || columnsToReadMap.get("ID_STRUTTURA") != null)
			dto.setIdStruttura((Integer) rs.getObject("ID_STRUTTURA"));

		// colonna [FK_FUNZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_FUNZIONE") != null)
			dto.setFkFunzione((Integer) rs.getObject("FK_FUNZIONE"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [DIMENSIONE]
		if (mapAllColumns || columnsToReadMap.get("DIMENSIONE") != null)
			dto.setDimensione((Integer) rs.getObject("DIMENSIONE"));

		// colonna [ANNO]
		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("ANNO"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTStrutturaFindByAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTStrutturaFindByAziendaDto
	 * @generated
	 */

	public TaifTStrutturaFindByAziendaDto mapRow_internal(TaifTStrutturaFindByAziendaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTStrutturaFindByAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("FUNZ") != null)
			dto.setFunz((Integer) rs.getObject("funz"));

		if (mapAllColumns || columnsToReadMap.get("DIM") != null)
			dto.setDim((Integer) rs.getObject("dim"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("DATA") != null)
			dto.setData(rs.getTimestamp("data"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTStrutturaByAziendaFunzioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTStrutturaByAziendaFunzioneDto
	 * @generated
	 */

	public TaifTStrutturaByAziendaFunzioneDto mapRow_internal(TaifTStrutturaByAziendaFunzioneDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTStrutturaByAziendaFunzioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("FUNZ") != null)
			dto.setFunz((Integer) rs.getObject("funz"));

		if (mapAllColumns || columnsToReadMap.get("DIM") != null)
			dto.setDim((Integer) rs.getObject("dim"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("DATA") != null)
			dto.setData(rs.getTimestamp("data"));

		if (mapAllColumns || columnsToReadMap.get("AZIENDA") != null)
			dto.setAzienda((Integer) rs.getObject("azienda"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto
	 * @generated
	 */

	public TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto mapRow_internal(
			TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSTRUTTURA") != null)
			dto.setIdStruttura((Integer) rs.getObject("idStruttura"));

		if (mapAllColumns || columnsToReadMap.get("DIMENSIONESTRUTTURA") != null)
			dto.setDimensioneStruttura((Integer) rs.getObject("dimensioneStruttura"));

		if (mapAllColumns || columnsToReadMap.get("ANNOSTRUTTURA") != null)
			dto.setAnnoStruttura(rs.getBigDecimal("annoStruttura"));

		if (mapAllColumns || columnsToReadMap.get("TIPOSTRUTTURA") != null)
			dto.setTipoStruttura(rs.getString("tipoStruttura"));

		if (mapAllColumns || columnsToReadMap.get("FUNZIONESTRUTTURA") != null)
			dto.setFunzioneStruttura(rs.getString("funzioneStruttura"));

		return dto;
	}

}
