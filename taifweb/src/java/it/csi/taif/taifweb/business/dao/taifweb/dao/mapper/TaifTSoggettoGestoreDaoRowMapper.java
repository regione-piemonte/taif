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
 * RowMapper specifico del DAO TaifTSoggettoGestoreDao
 * @generated
 */
public class TaifTSoggettoGestoreDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTSoggettoGestoreDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTSoggettoGestoreDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTSoggettoGestoreDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTSoggettoGestoreDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTSoggettoGestoreDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTSoggettoGestoreDto) {
			return mapRow_internal((TaifTSoggettoGestoreDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTSoggettoGestoreByFilterDto) {
			return mapRow_internal((TaifTSoggettoGestoreByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTSoggettoGestoreByFilterVisibleDto) {
			return mapRow_internal((TaifTSoggettoGestoreByFilterVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTSoggettoGestoreDto mapRow_internal(TaifTSoggettoGestoreDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTSoggettoGestoreDto dto = objectToFill;

		// colonna [ID_SOGGETTO_GESTORE]
		if (mapAllColumns || columnsToReadMap.get("ID_SOGGETTO_GESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("ID_SOGGETTO_GESTORE"));

		// colonna [CODICE]
		if (mapAllColumns || columnsToReadMap.get("CODICE") != null)
			dto.setCodice(rs.getString("CODICE"));

		// colonna [DENOMINAZIONE_BREVE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_BREVE") != null)
			dto.setDenominazioneBreve(rs.getString("DENOMINAZIONE_BREVE"));

		// colonna [DENOMINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setDenominazione(rs.getString("DENOMINAZIONE"));

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

		// colonna [MAIL]
		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("MAIL"));

		// colonna [PEC]
		if (mapAllColumns || columnsToReadMap.get("PEC") != null)
			dto.setPec(rs.getString("PEC"));

		// colonna [REFERENTE]
		if (mapAllColumns || columnsToReadMap.get("REFERENTE") != null)
			dto.setReferente(rs.getString("REFERENTE"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [URL_DOC_PRIVACY]
		if (mapAllColumns || columnsToReadMap.get("URL_DOC_PRIVACY") != null)
			dto.setUrlDocPrivacy(rs.getString("URL_DOC_PRIVACY"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTSoggettoGestoreByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTSoggettoGestoreByFilterDto
	 * @generated
	 */

	public TaifTSoggettoGestoreByFilterDto mapRow_internal(TaifTSoggettoGestoreByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTSoggettoGestoreByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("CODICEGESTORE") != null)
			dto.setCodiceGestore(rs.getString("codiceGestore"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEBREVE") != null)
			dto.setDenominazionebreve(rs.getString("denominazionebreve"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setDenominazione(rs.getString("denominazione"));

		if (mapAllColumns || columnsToReadMap.get("REFERENTE") != null)
			dto.setReferente(rs.getString("referente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTSoggettoGestoreByFilterVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTSoggettoGestoreByFilterVisibleDto
	 * @generated
	 */

	public TaifTSoggettoGestoreByFilterVisibleDto mapRow_internal(TaifTSoggettoGestoreByFilterVisibleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTSoggettoGestoreByFilterVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("CODICEGESTORE") != null)
			dto.setCodiceGestore(rs.getString("codiceGestore"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEBREVE") != null)
			dto.setDenominazionebreve(rs.getString("denominazionebreve"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setDenominazione(rs.getString("denominazione"));

		if (mapAllColumns || columnsToReadMap.get("REFERENTE") != null)
			dto.setReferente(rs.getString("referente"));

		return dto;
	}

}
