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
 * RowMapper specifico del DAO TaifRPersonaAziendaDao
 * @generated
 */
public class TaifRPersonaAziendaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifRPersonaAziendaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifRPersonaAziendaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifRPersonaAziendaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifRPersonaAziendaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifRPersonaAziendaDto) {
			return mapRow_internal((TaifRPersonaAziendaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifRPersonaAziendaByIdAziendaDto) {
			return mapRow_internal((TaifRPersonaAziendaByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaContrattoByIdPersonaDto) {
			return mapRow_internal((TaifRPersonaAziendaContrattoByIdPersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaByFkUtenteDto) {
			return mapRow_internal((TaifRPersonaAziendaByFkUtenteDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaByAziendaUtenteDto) {
			return mapRow_internal((TaifRPersonaAziendaByAziendaUtenteDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto) {
			return mapRow_internal((TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto) dtoInstance, rs,
					row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaRuoloByIdRuoloVisibileDto) {
			return mapRow_internal((TaifRPersonaAziendaRuoloByIdRuoloVisibileDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaContrattoByIdContrattoVisibileDto) {
			return mapRow_internal((TaifRPersonaAziendaContrattoByIdContrattoVisibileDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaMansioneByIdMansioneVisibileDto) {
			return mapRow_internal((TaifRPersonaAziendaMansioneByIdMansioneVisibileDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaConteggioPersonaDto) {
			return mapRow_internal((TaifRPersonaAziendaConteggioPersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRPersonaAziendaRappresentanteLegaleAziendaDto) {
			return mapRow_internal((TaifRPersonaAziendaRappresentanteLegaleAziendaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifRPersonaAziendaDto mapRow_internal(TaifRPersonaAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRPersonaAziendaDto dto = objectToFill;

		// colonna [ID_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("ID_PERSONA"));

		// colonna [ID_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		// colonna [FK_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("FK_RUOLO") != null)
			dto.setFkRuolo((Integer) rs.getObject("FK_RUOLO"));

		// colonna [FK_TIPO_MANSIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_MANSIONE") != null)
			dto.setFkTipoMansione((Integer) rs.getObject("FK_TIPO_MANSIONE"));

		// colonna [FK_TIPO_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_CONTRATTO") != null)
			dto.setFkTipoContratto((Integer) rs.getObject("FK_TIPO_CONTRATTO"));

		// colonna [FK_TIPO_INQUADRAMENTO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_INQUADRAMENTO") != null)
			dto.setFkTipoInquadramento((Integer) rs.getObject("FK_TIPO_INQUADRAMENTO"));

		// colonna [FLG_TEMPO_DETERMINATO]
		if (mapAllColumns || columnsToReadMap.get("FLG_TEMPO_DETERMINATO") != null)
			dto.setFlgTempoDeterminato(rs.getBigDecimal("FLG_TEMPO_DETERMINATO"));

		// colonna [GG_TEMPO_DETERMINATO]
		if (mapAllColumns || columnsToReadMap.get("GG_TEMPO_DETERMINATO") != null)
			dto.setGgTempoDeterminato((Integer) rs.getObject("GG_TEMPO_DETERMINATO"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaByIdAziendaDto
	 * @generated
	 */

	public TaifRPersonaAziendaByIdAziendaDto mapRow_internal(TaifRPersonaAziendaByIdAziendaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifRPersonaAziendaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDAZ") != null)
			dto.setIdAz((Integer) rs.getObject("idAz"));

		if (mapAllColumns || columnsToReadMap.get("IDRUOLO") != null)
			dto.setIdRuolo((Integer) rs.getObject("idRuolo"));

		if (mapAllColumns || columnsToReadMap.get("IDMANSIONE") != null)
			dto.setIdMansione((Integer) rs.getObject("idMansione"));

		if (mapAllColumns || columnsToReadMap.get("IDCONTRATTO") != null)
			dto.setIdContratto((Integer) rs.getObject("idContratto"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("FLIND") != null)
			dto.setFlInd(rs.getBigDecimal("flInd"));

		if (mapAllColumns || columnsToReadMap.get("DET") != null)
			dto.setDet((Integer) rs.getObject("det"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaContrattoByIdPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaContrattoByIdPersonaDto
	 * @generated
	 */

	public TaifRPersonaAziendaContrattoByIdPersonaDto mapRow_internal(
			TaifRPersonaAziendaContrattoByIdPersonaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRPersonaAziendaContrattoByIdPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDAZ") != null)
			dto.setIdAz((Integer) rs.getObject("idAz"));

		if (mapAllColumns || columnsToReadMap.get("IDRUOLO") != null)
			dto.setIdRuolo((Integer) rs.getObject("idRuolo"));

		if (mapAllColumns || columnsToReadMap.get("IDMANSIONE") != null)
			dto.setIdMansione((Integer) rs.getObject("idMansione"));

		if (mapAllColumns || columnsToReadMap.get("IDCONTRATTO") != null)
			dto.setIdContratto((Integer) rs.getObject("idContratto"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("FLIND") != null)
			dto.setFlInd(rs.getBigDecimal("flInd"));

		if (mapAllColumns || columnsToReadMap.get("DET") != null)
			dto.setDet((Integer) rs.getObject("det"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCONTRATTO") != null)
			dto.setTipoContratto(rs.getString("tipoContratto"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaByFkUtenteDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaByFkUtenteDto
	 * @generated
	 */

	public TaifRPersonaAziendaByFkUtenteDto mapRow_internal(TaifRPersonaAziendaByFkUtenteDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifRPersonaAziendaByFkUtenteDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDAZ") != null)
			dto.setIdAz((Integer) rs.getObject("idAz"));

		if (mapAllColumns || columnsToReadMap.get("IDRUOLO") != null)
			dto.setIdRuolo((Integer) rs.getObject("idRuolo"));

		if (mapAllColumns || columnsToReadMap.get("IDMANSIONE") != null)
			dto.setIdMansione((Integer) rs.getObject("idMansione"));

		if (mapAllColumns || columnsToReadMap.get("IDCONTRATTO") != null)
			dto.setIdContratto((Integer) rs.getObject("idContratto"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("FLIND") != null)
			dto.setFlInd(rs.getBigDecimal("flInd"));

		if (mapAllColumns || columnsToReadMap.get("DET") != null)
			dto.setDet((Integer) rs.getObject("det"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaByAziendaUtenteDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaByAziendaUtenteDto
	 * @generated
	 */

	public TaifRPersonaAziendaByAziendaUtenteDto mapRow_internal(TaifRPersonaAziendaByAziendaUtenteDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifRPersonaAziendaByAziendaUtenteDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDRUOLO") != null)
			dto.setIdRuolo((Integer) rs.getObject("idRuolo"));

		if (mapAllColumns || columnsToReadMap.get("IDMANSIONE") != null)
			dto.setIdMansione((Integer) rs.getObject("idMansione"));

		if (mapAllColumns || columnsToReadMap.get("IDCONTRATTO") != null)
			dto.setIdContratto((Integer) rs.getObject("idContratto"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("FLAGINDETERMINATO") != null)
			dto.setFlagIndeterminato(rs.getBigDecimal("flagIndeterminato"));

		if (mapAllColumns || columnsToReadMap.get("GGDETERMINATO") != null)
			dto.setGgDeterminato((Integer) rs.getObject("ggDeterminato"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto
	 * @generated
	 */

	public TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto mapRow_internal(
			TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("TIPOINQUADRAMENTO") != null)
			dto.setTipoInquadramento(rs.getString("tipoInquadramento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaRuoloByIdRuoloVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaRuoloByIdRuoloVisibileDto
	 * @generated
	 */

	public TaifRPersonaAziendaRuoloByIdRuoloVisibileDto mapRow_internal(
			TaifRPersonaAziendaRuoloByIdRuoloVisibileDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRPersonaAziendaRuoloByIdRuoloVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("RUOLOPERSONA") != null)
			dto.setRuoloPersona(rs.getString("ruoloPersona"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaContrattoByIdContrattoVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaContrattoByIdContrattoVisibileDto
	 * @generated
	 */

	public TaifRPersonaAziendaContrattoByIdContrattoVisibileDto mapRow_internal(
			TaifRPersonaAziendaContrattoByIdContrattoVisibileDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRPersonaAziendaContrattoByIdContrattoVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("RUOLOPERSONA") != null)
			dto.setRuoloPersona(rs.getString("ruoloPersona"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaMansioneByIdMansioneVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaMansioneByIdMansioneVisibileDto
	 * @generated
	 */

	public TaifRPersonaAziendaMansioneByIdMansioneVisibileDto mapRow_internal(
			TaifRPersonaAziendaMansioneByIdMansioneVisibileDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRPersonaAziendaMansioneByIdMansioneVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("RUOLOPERSONA") != null)
			dto.setRuoloPersona(rs.getString("ruoloPersona"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaConteggioPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaConteggioPersonaDto
	 * @generated
	 */

	public TaifRPersonaAziendaConteggioPersonaDto mapRow_internal(TaifRPersonaAziendaConteggioPersonaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifRPersonaAziendaConteggioPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("CONTEGGIO") != null)
			dto.setConteggio((Long) rs.getObject("conteggio"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRPersonaAziendaRappresentanteLegaleAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRPersonaAziendaRappresentanteLegaleAziendaDto
	 * @generated
	 */

	public TaifRPersonaAziendaRappresentanteLegaleAziendaDto mapRow_internal(
			TaifRPersonaAziendaRappresentanteLegaleAziendaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRPersonaAziendaRappresentanteLegaleAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDRUOLO") != null)
			dto.setIdRuolo((Integer) rs.getObject("idRuolo"));

		if (mapAllColumns || columnsToReadMap.get("IDMANSIONE") != null)
			dto.setIdMansione((Integer) rs.getObject("idMansione"));

		if (mapAllColumns || columnsToReadMap.get("IDCONTRATTO") != null)
			dto.setIdContratto((Integer) rs.getObject("idContratto"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUAD") != null)
			dto.setIdInquad((Integer) rs.getObject("idInquad"));

		if (mapAllColumns || columnsToReadMap.get("FLAGINDETERMINATO") != null)
			dto.setFlagIndeterminato(rs.getBigDecimal("flagIndeterminato"));

		if (mapAllColumns || columnsToReadMap.get("GGDETERMINATO") != null)
			dto.setGgDeterminato((Integer) rs.getObject("ggDeterminato"));

		return dto;
	}

}
