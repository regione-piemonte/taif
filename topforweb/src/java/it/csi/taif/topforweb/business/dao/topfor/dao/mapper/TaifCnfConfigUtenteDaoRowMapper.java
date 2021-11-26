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
 * RowMapper specifico del DAO TaifCnfConfigUtenteDao
 * @generated
 */
public class TaifCnfConfigUtenteDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfConfigUtenteDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfConfigUtenteDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfConfigUtenteDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfConfigUtenteDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfConfigUtenteDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfConfigUtenteDto) {
			return mapRow_internal((TaifCnfConfigUtenteDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifCnfConfigUtenteByFilterDto) {
			return mapRow_internal((TaifCnfConfigUtenteByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifCnfConfigUtenteProfiloByCodiceFiscaleDto) {
			return mapRow_internal((TaifCnfConfigUtenteProfiloByCodiceFiscaleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto) {
			return mapRow_internal((TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto) {
			return mapRow_internal((TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfConfigUtenteDto mapRow_internal(TaifCnfConfigUtenteDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfConfigUtenteDto dto = objectToFill;

		// colonna [ID_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_CONFIG_UTENTE") != null)
			dto.setIdConfigUtente((Integer) rs.getObject("ID_CONFIG_UTENTE"));

		// colonna [FK_PROFILO_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_PROFILO_UTENTE") != null)
			dto.setFkProfiloUtente((Integer) rs.getObject("FK_PROFILO_UTENTE"));

		// colonna [FK_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA") != null)
			dto.setFkPersona((Integer) rs.getObject("FK_PERSONA"));

		// colonna [FK_SOGGETTO_GESTORE]
		if (mapAllColumns || columnsToReadMap.get("FK_SOGGETTO_GESTORE") != null)
			dto.setFkSoggettoGestore((Integer) rs.getObject("FK_SOGGETTO_GESTORE"));

		// colonna [NR_ACCESSI]
		if (mapAllColumns || columnsToReadMap.get("NR_ACCESSI") != null)
			dto.setNrAccessi((Integer) rs.getObject("NR_ACCESSI"));

		// colonna [DATA_PRIMO_ACCESSO]
		if (mapAllColumns || columnsToReadMap.get("DATA_PRIMO_ACCESSO") != null)
			dto.setDataPrimoAccesso(rs.getTimestamp("DATA_PRIMO_ACCESSO"));

		// colonna [DATA_ULTIMO_ACCESSO]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULTIMO_ACCESSO") != null)
			dto.setDataUltimoAccesso(rs.getTimestamp("DATA_ULTIMO_ACCESSO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfConfigUtenteByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfConfigUtenteByFilterDto
	 * @generated
	 */

	public TaifCnfConfigUtenteByFilterDto mapRow_internal(TaifCnfConfigUtenteByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifCnfConfigUtenteByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDPROF") != null)
			dto.setIdProf((Integer) rs.getObject("idProf"));

		if (mapAllColumns || columnsToReadMap.get("IDPERS") != null)
			dto.setIdPers((Integer) rs.getObject("idPers"));

		if (mapAllColumns || columnsToReadMap.get("IDGESTORE") != null)
			dto.setIdGestore((Integer) rs.getObject("idGestore"));

		if (mapAllColumns || columnsToReadMap.get("ACCESSI") != null)
			dto.setAccessi((Integer) rs.getObject("accessi"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfConfigUtenteProfiloByCodiceFiscaleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfConfigUtenteProfiloByCodiceFiscaleDto
	 * @generated
	 */

	public TaifCnfConfigUtenteProfiloByCodiceFiscaleDto mapRow_internal(
			TaifCnfConfigUtenteProfiloByCodiceFiscaleDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifCnfConfigUtenteProfiloByCodiceFiscaleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCONFIGUTENTE") != null)
			dto.setIdConfigUtente((Integer) rs.getObject("idConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDPROFILOUTENTE") != null)
			dto.setIdProfiloUtente((Integer) rs.getObject("idProfiloUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("ACCESSI") != null)
			dto.setAccessi((Integer) rs.getObject("accessi"));

		if (mapAllColumns || columnsToReadMap.get("PROFILOUTENTE") != null)
			dto.setProfiloUtente(rs.getString("profiloUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto
	 * @generated
	 */

	public TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto mapRow_internal(
			TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDCONFIGUTENTE") != null)
			dto.setIdConfigUtente((Integer) rs.getObject("idConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("IDPROFILOUTENTE") != null)
			dto.setIdProfiloUtente((Integer) rs.getObject("idProfiloUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto
	 * @generated
	 */

	public TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto mapRow_internal(
			TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCONFIGUTENTE") != null)
			dto.setIdConfigUtente((Integer) rs.getObject("idConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDPROFILOUTENTE") != null)
			dto.setIdProfiloUtente((Integer) rs.getObject("idProfiloUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("ACCESSI") != null)
			dto.setAccessi((Integer) rs.getObject("accessi"));

		if (mapAllColumns || columnsToReadMap.get("PROFILOUTENTE") != null)
			dto.setProfiloUtente(rs.getString("profiloUtente"));

		return dto;
	}

}
