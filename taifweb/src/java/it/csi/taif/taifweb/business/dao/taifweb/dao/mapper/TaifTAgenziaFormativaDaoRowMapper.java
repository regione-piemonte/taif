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

		if (dtoInstance instanceof TaifTAgenziaFormativaByFilterDto) {
			return mapRow_internal((TaifTAgenziaFormativaByFilterDto) dtoInstance, rs, row);
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
	 * Metodo specifico di mapping relativo al DTO custom TaifTAgenziaFormativaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAgenziaFormativaByFilterDto
	 * @generated
	 */

	public TaifTAgenziaFormativaByFilterDto mapRow_internal(TaifTAgenziaFormativaByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTAgenziaFormativaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISC") != null)
			dto.setCodiceFisc(rs.getString("codiceFisc"));

		if (mapAllColumns || columnsToReadMap.get("PIVA") != null)
			dto.setPiva(rs.getString("piva"));

		if (mapAllColumns || columnsToReadMap.get("RAGSOC") != null)
			dto.setRagSoc(rs.getString("ragSoc"));

		if (mapAllColumns || columnsToReadMap.get("PSR") != null)
			dto.setPsr(rs.getString("psr"));

		if (mapAllColumns || columnsToReadMap.get("ISTATSEDE") != null)
			dto.setIstatSede(rs.getString("istatSede"));

		if (mapAllColumns || columnsToReadMap.get("ESTERO") != null)
			dto.setEstero(rs.getString("estero"));

		return dto;
	}

}
