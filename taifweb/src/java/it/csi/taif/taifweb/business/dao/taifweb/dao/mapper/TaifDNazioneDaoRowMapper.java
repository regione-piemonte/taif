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
 * RowMapper specifico del DAO TaifDNazioneDao
 * @generated
 */
public class TaifDNazioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDNazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDNazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDNazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDNazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDNazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDNazioneDto) {
			return mapRow_internal((TaifDNazioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDNazioneByNazioneItaVisibleDto) {
			return mapRow_internal((TaifDNazioneByNazioneItaVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDNazioneByNazioneFraVisibleDto) {
			return mapRow_internal((TaifDNazioneByNazioneFraVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDNazioneDto mapRow_internal(TaifDNazioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDNazioneDto dto = objectToFill;

		// colonna [ID_NAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_NAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("ID_NAZIONE"));

		// colonna [NAZIONE_ITA]
		if (mapAllColumns || columnsToReadMap.get("NAZIONE_ITA") != null)
			dto.setNazioneIta(rs.getString("NAZIONE_ITA"));

		// colonna [NAZIONE_FRA]
		if (mapAllColumns || columnsToReadMap.get("NAZIONE_FRA") != null)
			dto.setNazioneFra(rs.getString("NAZIONE_FRA"));

		// colonna [MTD_ORDINAMENTO_ITA]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO_ITA") != null)
			dto.setMtdOrdinamentoIta(rs.getBigDecimal("MTD_ORDINAMENTO_ITA"));

		// colonna [MTD_ORDINAMENTO_FRA]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO_FRA") != null)
			dto.setMtdOrdinamentoFra(rs.getBigDecimal("MTD_ORDINAMENTO_FRA"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDNazioneByNazioneItaVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDNazioneByNazioneItaVisibleDto
	 * @generated
	 */

	public TaifDNazioneByNazioneItaVisibleDto mapRow_internal(TaifDNazioneByNazioneItaVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDNazioneByNazioneItaVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IT") != null)
			dto.setIt(rs.getString("it"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDNazioneByNazioneFraVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDNazioneByNazioneFraVisibleDto
	 * @generated
	 */

	public TaifDNazioneByNazioneFraVisibleDto mapRow_internal(TaifDNazioneByNazioneFraVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDNazioneByNazioneFraVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IT") != null)
			dto.setIt(rs.getString("it"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
