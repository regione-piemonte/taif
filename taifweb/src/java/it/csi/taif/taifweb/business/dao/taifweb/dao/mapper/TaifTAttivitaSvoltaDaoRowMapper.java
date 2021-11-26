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
 * RowMapper specifico del DAO TaifTAttivitaSvoltaDao
 * @generated
 */
public class TaifTAttivitaSvoltaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTAttivitaSvoltaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTAttivitaSvoltaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTAttivitaSvoltaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTAttivitaSvoltaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTAttivitaSvoltaDto) {
			return mapRow_internal((TaifTAttivitaSvoltaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTAttivitaSvoltaByIdAziendaDto) {
			return mapRow_internal((TaifTAttivitaSvoltaByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto) {
			return mapRow_internal((TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto) {
			return mapRow_internal((TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto) {
			return mapRow_internal((TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTAttivitaSvoltaDto mapRow_internal(TaifTAttivitaSvoltaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTAttivitaSvoltaDto dto = objectToFill;

		// colonna [ID_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("ID_ATTIVITA") != null)
			dto.setIdAttivita((Integer) rs.getObject("ID_ATTIVITA"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [FK_TIPO_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_ATTIVITA") != null)
			dto.setFkTipoAttivita((Integer) rs.getObject("FK_TIPO_ATTIVITA"));

		// colonna [DESCR_ALTRE_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("DESCR_ALTRE_ATTIVITA") != null)
			dto.setDescrAltreAttivita(rs.getString("DESCR_ALTRE_ATTIVITA"));

		// colonna [PERC_FATTURATO]
		if (mapAllColumns || columnsToReadMap.get("PERC_FATTURATO") != null)
			dto.setPercFatturato(rs.getBigDecimal("PERC_FATTURATO"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTAttivitaSvoltaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaByIdAziendaDto
	 * @generated
	 */

	public TaifTAttivitaSvoltaByIdAziendaDto mapRow_internal(TaifTAttivitaSvoltaByIdAziendaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTAttivitaSvoltaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOATTIVITA") != null)
			dto.setTipoAttivita(rs.getString("tipoAttivita"));

		if (mapAllColumns || columnsToReadMap.get("FATTURATO") != null)
			dto.setFatturato(rs.getBigDecimal("fatturato"));

		if (mapAllColumns || columnsToReadMap.get("ALTRE") != null)
			dto.setAltre(rs.getString("altre"));

		if (mapAllColumns || columnsToReadMap.get("DATAINS") != null)
			dto.setDataIns(rs.getTimestamp("dataIns"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOATTIVITA") != null)
			dto.setIdTipoAttivita((Integer) rs.getObject("idTipoAttivita"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto
	 * @generated
	 */

	public TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto mapRow_internal(
			TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOATTIVITA") != null)
			dto.setTipoAttivita(rs.getString("tipoAttivita"));

		if (mapAllColumns || columnsToReadMap.get("FATTURATO") != null)
			dto.setFatturato(rs.getBigDecimal("fatturato"));

		if (mapAllColumns || columnsToReadMap.get("ALTREATTIVITA") != null)
			dto.setAltreAttivita(rs.getString("altreAttivita"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto
	 * @generated
	 */

	public TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto mapRow_internal(
			TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOATTIVITA") != null)
			dto.setTipoAttivita(rs.getString("tipoAttivita"));

		if (mapAllColumns || columnsToReadMap.get("FATTURATO") != null)
			dto.setFatturato(rs.getBigDecimal("fatturato"));

		if (mapAllColumns || columnsToReadMap.get("ALTREATTIVITA") != null)
			dto.setAltreAttivita(rs.getString("altreAttivita"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVODETTAGLIO") != null)
			dto.setProgressivoDettaglio((Integer) rs.getObject("progressivoDettaglio"));

		if (mapAllColumns || columnsToReadMap.get("VALORE1DETTAGLIO") != null)
			dto.setValore1Dettaglio(rs.getBigDecimal("valore1Dettaglio"));

		if (mapAllColumns || columnsToReadMap.get("VALORE2DETTAGLIO") != null)
			dto.setValore2Dettaglio(rs.getBigDecimal("valore2Dettaglio"));

		if (mapAllColumns || columnsToReadMap.get("VALORE3DETTAGLIO") != null)
			dto.setValore3Dettaglio(rs.getBigDecimal("valore3Dettaglio"));

		if (mapAllColumns || columnsToReadMap.get("PERCENTUALECONTOTERZI") != null)
			dto.setPercentualeContoTerzi(rs.getBigDecimal("percentualeContoTerzi"));

		if (mapAllColumns || columnsToReadMap.get("UNITAMISURADETTAGLIO") != null)
			dto.setUnitaMisuraDettaglio((Integer) rs.getObject("unitaMisuraDettaglio"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOATTIVITA") != null)
			dto.setIdTipoAttivita((Integer) rs.getObject("idTipoAttivita"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto
	 * @generated
	 */

	public TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto mapRow_internal(
			TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("TIPOATTIVITA") != null)
			dto.setTipoAttivita(rs.getString("tipoAttivita"));

		if (mapAllColumns || columnsToReadMap.get("FATTURATO") != null)
			dto.setFatturato(rs.getBigDecimal("fatturato"));

		return dto;
	}

}
