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
 * RowMapper specifico del DAO TaifTAttivitaSvoltaDettDao
 * @generated
 */
public class TaifTAttivitaSvoltaDettDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTAttivitaSvoltaDettDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTAttivitaSvoltaDettDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTAttivitaSvoltaDettDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTAttivitaSvoltaDettDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaDettDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTAttivitaSvoltaDettDto) {
			return mapRow_internal((TaifTAttivitaSvoltaDettDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTAttivitaSvoltaDettByFilterDto) {
			return mapRow_internal((TaifTAttivitaSvoltaDettByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAttivitaSvoltaDettByFilterAttivitaDto) {
			return mapRow_internal((TaifTAttivitaSvoltaDettByFilterAttivitaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAttivitaSvoltaDettByAttivitaProgressivoDto) {
			return mapRow_internal((TaifTAttivitaSvoltaDettByAttivitaProgressivoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTAttivitaSvoltaDettDto mapRow_internal(TaifTAttivitaSvoltaDettDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTAttivitaSvoltaDettDto dto = objectToFill;

		// colonna [ID_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("ID_ATTIVITA") != null)
			dto.setIdAttivita((Integer) rs.getObject("ID_ATTIVITA"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo((Integer) rs.getObject("PROGRESSIVO"));

		// colonna [FK_UNITA_DI_MISURA]
		if (mapAllColumns || columnsToReadMap.get("FK_UNITA_DI_MISURA") != null)
			dto.setFkUnitaDiMisura((Integer) rs.getObject("FK_UNITA_DI_MISURA"));

		// colonna [VALORE1]
		if (mapAllColumns || columnsToReadMap.get("VALORE1") != null)
			dto.setValore1(rs.getBigDecimal("VALORE1"));

		// colonna [VALORE2]
		if (mapAllColumns || columnsToReadMap.get("VALORE2") != null)
			dto.setValore2(rs.getBigDecimal("VALORE2"));

		// colonna [VALORE3]
		if (mapAllColumns || columnsToReadMap.get("VALORE3") != null)
			dto.setValore3(rs.getBigDecimal("VALORE3"));

		// colonna [PERC_CONTO_TERZI]
		if (mapAllColumns || columnsToReadMap.get("PERC_CONTO_TERZI") != null)
			dto.setPercContoTerzi(rs.getBigDecimal("PERC_CONTO_TERZI"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTAttivitaSvoltaDettByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaDettByFilterDto
	 * @generated
	 */

	public TaifTAttivitaSvoltaDettByFilterDto mapRow_internal(TaifTAttivitaSvoltaDettByFilterDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTAttivitaSvoltaDettByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("VAL1") != null)
			dto.setVal1(rs.getBigDecimal("val1"));

		if (mapAllColumns || columnsToReadMap.get("VAL2") != null)
			dto.setVal2(rs.getBigDecimal("val2"));

		if (mapAllColumns || columnsToReadMap.get("VAL3") != null)
			dto.setVal3(rs.getBigDecimal("val3"));

		if (mapAllColumns || columnsToReadMap.get("PERCENT") != null)
			dto.setPercent(rs.getBigDecimal("percent"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAttivitaSvoltaDettByFilterAttivitaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaDettByFilterAttivitaDto
	 * @generated
	 */

	public TaifTAttivitaSvoltaDettByFilterAttivitaDto mapRow_internal(
			TaifTAttivitaSvoltaDettByFilterAttivitaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAttivitaSvoltaDettByFilterAttivitaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("VAL1") != null)
			dto.setVal1(rs.getBigDecimal("val1"));

		if (mapAllColumns || columnsToReadMap.get("VAL2") != null)
			dto.setVal2(rs.getBigDecimal("val2"));

		if (mapAllColumns || columnsToReadMap.get("VAL3") != null)
			dto.setVal3(rs.getBigDecimal("val3"));

		if (mapAllColumns || columnsToReadMap.get("PERCENT") != null)
			dto.setPercent(rs.getBigDecimal("percent"));

		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo((Integer) rs.getObject("progressivo"));

		if (mapAllColumns || columnsToReadMap.get("UNITAMISURA") != null)
			dto.setUnitaMisura((Integer) rs.getObject("unitaMisura"));

		if (mapAllColumns || columnsToReadMap.get("CONFIGUTENTE") != null)
			dto.setConfigUtente((Integer) rs.getObject("configUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAttivitaSvoltaDettByAttivitaProgressivoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaDettByAttivitaProgressivoDto
	 * @generated
	 */

	public TaifTAttivitaSvoltaDettByAttivitaProgressivoDto mapRow_internal(
			TaifTAttivitaSvoltaDettByAttivitaProgressivoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAttivitaSvoltaDettByAttivitaProgressivoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDATTIVITA") != null)
			dto.setIdAttivita((Integer) rs.getObject("idAttivita"));

		if (mapAllColumns || columnsToReadMap.get("VALORE1") != null)
			dto.setValore1(rs.getBigDecimal("valore1"));

		if (mapAllColumns || columnsToReadMap.get("VALORE2") != null)
			dto.setValore2(rs.getBigDecimal("valore2"));

		if (mapAllColumns || columnsToReadMap.get("VALORE3") != null)
			dto.setValore3(rs.getBigDecimal("valore3"));

		if (mapAllColumns || columnsToReadMap.get("PERCENTUALE") != null)
			dto.setPercentuale(rs.getBigDecimal("percentuale"));

		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVODETT") != null)
			dto.setProgressivoDett((Integer) rs.getObject("progressivoDett"));

		if (mapAllColumns || columnsToReadMap.get("UNITAMISURADETT") != null)
			dto.setUnitaMisuraDett((Integer) rs.getObject("unitaMisuraDett"));

		if (mapAllColumns || columnsToReadMap.get("CONFIGUTENTEDETT") != null)
			dto.setConfigUtenteDett((Integer) rs.getObject("configUtenteDett"));

		if (mapAllColumns || columnsToReadMap.get("IDMATERIALE") != null)
			dto.setIdMateriale((Integer) rs.getObject("idMateriale"));

		if (mapAllColumns || columnsToReadMap.get("ALTROMATERIALE") != null)
			dto.setAltroMateriale(rs.getString("altroMateriale"));

		return dto;
	}

}
