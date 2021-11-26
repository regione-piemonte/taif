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
 * RowMapper specifico del DAO TaifCnfProfiloUtenteDao
 * @generated
 */
public class TaifCnfProfiloUtenteDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfProfiloUtenteDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfProfiloUtenteDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfProfiloUtenteDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfProfiloUtenteDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfProfiloUtenteDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfProfiloUtenteDto) {
			return mapRow_internal((TaifCnfProfiloUtenteDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifCnfProfiloUtenteByProfiloUtenteDto) {
			return mapRow_internal((TaifCnfProfiloUtenteByProfiloUtenteDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfProfiloUtenteDto mapRow_internal(TaifCnfProfiloUtenteDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfProfiloUtenteDto dto = objectToFill;

		// colonna [ID_PROFILO_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_PROFILO_UTENTE") != null)
			dto.setIdProfiloUtente((Integer) rs.getObject("ID_PROFILO_UTENTE"));

		// colonna [PROFILO_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("PROFILO_UTENTE") != null)
			dto.setProfiloUtente(rs.getString("PROFILO_UTENTE"));

		// colonna [MTD_FLG_ATTIVO]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_ATTIVO") != null)
			dto.setMtdFlgAttivo(rs.getBigDecimal("MTD_FLG_ATTIVO"));

		// colonna [FK_PROCEDURA]
		if (mapAllColumns || columnsToReadMap.get("FK_PROCEDURA") != null)
			dto.setFkProcedura((Integer) rs.getObject("FK_PROCEDURA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfProfiloUtenteByProfiloUtenteDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfProfiloUtenteByProfiloUtenteDto
	 * @generated
	 */

	public TaifCnfProfiloUtenteByProfiloUtenteDto mapRow_internal(TaifCnfProfiloUtenteByProfiloUtenteDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifCnfProfiloUtenteByProfiloUtenteDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPROFILO") != null)
			dto.setIdProfilo((Integer) rs.getObject("idProfilo"));

		if (mapAllColumns || columnsToReadMap.get("PROFILOUTENTE") != null)
			dto.setProfiloUtente(rs.getString("profiloUtente"));

		if (mapAllColumns || columnsToReadMap.get("PROCEDURA") != null)
			dto.setProcedura((Integer) rs.getObject("procedura"));

		return dto;
	}

}
