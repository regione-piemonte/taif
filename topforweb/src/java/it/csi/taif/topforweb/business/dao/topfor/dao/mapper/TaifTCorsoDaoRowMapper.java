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
 * RowMapper specifico del DAO TaifTCorsoDao
 * @generated
 */
public class TaifTCorsoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTCorsoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTCorsoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTCorsoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTCorsoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCorsoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTCorsoDto) {
			return mapRow_internal((TaifTCorsoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTCorsoByFilterUnitaFormativaDto) {
			return mapRow_internal((TaifTCorsoByFilterUnitaFormativaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCorsoByFilterVisibleDto) {
			return mapRow_internal((TaifTCorsoByFilterVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCorsoCorsiPerAgenziaUnitaDto) {
			return mapRow_internal((TaifTCorsoCorsiPerAgenziaUnitaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTCorsoDto mapRow_internal(TaifTCorsoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTCorsoDto dto = objectToFill;

		// colonna [ID_CORSO]
		if (mapAllColumns || columnsToReadMap.get("ID_CORSO") != null)
			dto.setIdCorso((Integer) rs.getObject("ID_CORSO"));

		// colonna [FK_AGENZIA_FORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("FK_AGENZIA_FORMATIVA") != null)
			dto.setFkAgenziaFormativa((Integer) rs.getObject("FK_AGENZIA_FORMATIVA"));

		// colonna [FK_UNITA_FORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("FK_UNITA_FORMATIVA") != null)
			dto.setFkUnitaFormativa((Integer) rs.getObject("FK_UNITA_FORMATIVA"));

		// colonna [CORSO]
		if (mapAllColumns || columnsToReadMap.get("CORSO") != null)
			dto.setCorso(rs.getString("CORSO"));

		// colonna [CODICE_PSR]
		if (mapAllColumns || columnsToReadMap.get("CODICE_PSR") != null)
			dto.setCodicePsr(rs.getBigDecimal("CODICE_PSR"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDataInizio(rs.getTimestamp("DATA_INIZIO"));

		// colonna [DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDataFine(rs.getTimestamp("DATA_FINE"));

		// colonna [NRO_ORE]
		if (mapAllColumns || columnsToReadMap.get("NRO_ORE") != null)
			dto.setNroOre(rs.getBigDecimal("NRO_ORE"));

		// colonna [ISTAT_SEDE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_SEDE") != null)
			dto.setIstatSede(rs.getString("ISTAT_SEDE"));

		// colonna [COMUNE_ESTERO_SEDE]
		if (mapAllColumns || columnsToReadMap.get("COMUNE_ESTERO_SEDE") != null)
			dto.setComuneEsteroSede(rs.getString("COMUNE_ESTERO_SEDE"));

		// colonna [INDIRIZZO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("INDIRIZZO"));

		// colonna [FLG_ALTRO_CORSO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ALTRO_CORSO") != null)
			dto.setFlgAltroCorso(rs.getBigDecimal("FLG_ALTRO_CORSO"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		// colonna [MTD_FLG_ITA_FRA]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_ITA_FRA") != null)
			dto.setMtdFlgItaFra(rs.getString("MTD_FLG_ITA_FRA"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCorsoByFilterUnitaFormativaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCorsoByFilterUnitaFormativaDto
	 * @generated
	 */

	public TaifTCorsoByFilterUnitaFormativaDto mapRow_internal(TaifTCorsoByFilterUnitaFormativaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTCorsoByFilterUnitaFormativaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdCorso((Integer) rs.getObject("idCorso"));

		if (mapAllColumns || columnsToReadMap.get("DSCORSO") != null)
			dto.setDsCorso(rs.getString("dsCorso"));

		if (mapAllColumns || columnsToReadMap.get("DATAINIZIOCORSO") != null)
			dto.setDataInizioCorso(rs.getTimestamp("dataInizioCorso"));

		if (mapAllColumns || columnsToReadMap.get("DATAFINECORSO") != null)
			dto.setDataFineCorso(rs.getTimestamp("dataFineCorso"));

		if (mapAllColumns || columnsToReadMap.get("SEDECORSO") != null)
			dto.setSedeCorso(rs.getString("sedeCorso"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTEROSEDE") != null)
			dto.setComuneEsteroSede(rs.getString("comuneEsteroSede"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZOSEDE") != null)
			dto.setIndirizzoSede(rs.getString("indirizzoSede"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROORE") != null)
			dto.setNumeroOre(rs.getBigDecimal("numeroOre"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCorsoByFilterVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCorsoByFilterVisibleDto
	 * @generated
	 */

	public TaifTCorsoByFilterVisibleDto mapRow_internal(TaifTCorsoByFilterVisibleDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTCorsoByFilterVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdCorso((Integer) rs.getObject("idCorso"));

		if (mapAllColumns || columnsToReadMap.get("DSCORSO") != null)
			dto.setDsCorso(rs.getString("dsCorso"));

		if (mapAllColumns || columnsToReadMap.get("FLGALTROCORSO") != null)
			dto.setFlgAltroCorso(rs.getBigDecimal("flgAltroCorso"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCorsoCorsiPerAgenziaUnitaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCorsoCorsiPerAgenziaUnitaDto
	 * @generated
	 */

	public TaifTCorsoCorsiPerAgenziaUnitaDto mapRow_internal(TaifTCorsoCorsiPerAgenziaUnitaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTCorsoCorsiPerAgenziaUnitaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdCorso((Integer) rs.getObject("idCorso"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONECORSOCORSO") != null)
			dto.setDescrizioneCorsoCorso(rs.getString("descrizioneCorsoCorso"));

		if (mapAllColumns || columnsToReadMap.get("DATAINIZIOCORSO") != null)
			dto.setDataInizioCorso(rs.getTimestamp("dataInizioCorso"));

		if (mapAllColumns || columnsToReadMap.get("DATAFINECORSO") != null)
			dto.setDataFineCorso(rs.getTimestamp("dataFineCorso"));

		if (mapAllColumns || columnsToReadMap.get("SEDECORSO") != null)
			dto.setSedeCorso(rs.getString("sedeCorso"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTEROSEDE") != null)
			dto.setComuneEsteroSede(rs.getString("comuneEsteroSede"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZOSEDE") != null)
			dto.setIndirizzoSede(rs.getString("indirizzoSede"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROORE") != null)
			dto.setNumeroOre(rs.getBigDecimal("numeroOre"));

		if (mapAllColumns || columnsToReadMap.get("IDAGENZIAFORMATIVA") != null)
			dto.setIdAgenziaFormativa((Integer) rs.getObject("idAgenziaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("IDUNITAFORMATIVA") != null)
			dto.setIdUnitaFormativa((Integer) rs.getObject("idUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("FLAGVISIBILE") != null)
			dto.setFlagVisibile(rs.getBigDecimal("flagVisibile"));

		if (mapAllColumns || columnsToReadMap.get("FLAGITAFR") != null)
			dto.setFlagItaFr(rs.getString("flagItaFr"));

		if (mapAllColumns || columnsToReadMap.get("ORDINAMENTO") != null)
			dto.setOrdinamento(rs.getBigDecimal("ordinamento"));

		return dto;
	}

}
