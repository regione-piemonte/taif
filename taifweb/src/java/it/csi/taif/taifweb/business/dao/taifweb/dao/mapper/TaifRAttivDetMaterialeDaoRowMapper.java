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
 * RowMapper specifico del DAO TaifRAttivDetMaterialeDao
 * @generated
 */
public class TaifRAttivDetMaterialeDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifRAttivDetMaterialeDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifRAttivDetMaterialeDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifRAttivDetMaterialeDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifRAttivDetMaterialeDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAttivDetMaterialeDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifRAttivDetMaterialeDto) {
			return mapRow_internal((TaifRAttivDetMaterialeDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifRAttivDetMaterialeByIdMaterialeDto) {
			return mapRow_internal((TaifRAttivDetMaterialeByIdMaterialeDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAttivDetMaterialeByIdAttivitaDto) {
			return mapRow_internal((TaifRAttivDetMaterialeByIdAttivitaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAttivDetMaterialeByIdAttivitaProgressivoDto) {
			return mapRow_internal((TaifRAttivDetMaterialeByIdAttivitaProgressivoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifRAttivDetMaterialeDto mapRow_internal(TaifRAttivDetMaterialeDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRAttivDetMaterialeDto dto = objectToFill;

		// colonna [ID_MATERIALE]
		if (mapAllColumns || columnsToReadMap.get("ID_MATERIALE") != null)
			dto.setIdMateriale((Integer) rs.getObject("ID_MATERIALE"));

		// colonna [ID_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("ID_ATTIVITA") != null)
			dto.setIdAttivita((Integer) rs.getObject("ID_ATTIVITA"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo((Integer) rs.getObject("PROGRESSIVO"));

		// colonna [DESCR_ALTRO_MATERIALE]
		if (mapAllColumns || columnsToReadMap.get("DESCR_ALTRO_MATERIALE") != null)
			dto.setDescrAltroMateriale(rs.getString("DESCR_ALTRO_MATERIALE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifRAttivDetMaterialeByIdMaterialeDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAttivDetMaterialeByIdMaterialeDto
	 * @generated
	 */

	public TaifRAttivDetMaterialeByIdMaterialeDto mapRow_internal(TaifRAttivDetMaterialeByIdMaterialeDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifRAttivDetMaterialeByIdMaterialeDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDMATT") != null)
			dto.setIdMatt((Integer) rs.getObject("idMatt"));

		if (mapAllColumns || columnsToReadMap.get("MATERIALE") != null)
			dto.setMateriale(rs.getString("materiale"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAttivDetMaterialeByIdAttivitaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAttivDetMaterialeByIdAttivitaDto
	 * @generated
	 */

	public TaifRAttivDetMaterialeByIdAttivitaDto mapRow_internal(TaifRAttivDetMaterialeByIdAttivitaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifRAttivDetMaterialeByIdAttivitaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDATT") != null)
			dto.setIdAtt((Integer) rs.getObject("idAtt"));

		if (mapAllColumns || columnsToReadMap.get("MATERIALE") != null)
			dto.setMateriale(rs.getString("materiale"));

		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo((Integer) rs.getObject("progressivo"));

		if (mapAllColumns || columnsToReadMap.get("DATA") != null)
			dto.setData(rs.getTimestamp("data"));

		if (mapAllColumns || columnsToReadMap.get("IDMATERIALE") != null)
			dto.setIdMateriale((Integer) rs.getObject("idMateriale"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAttivDetMaterialeByIdAttivitaProgressivoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAttivDetMaterialeByIdAttivitaProgressivoDto
	 * @generated
	 */

	public TaifRAttivDetMaterialeByIdAttivitaProgressivoDto mapRow_internal(
			TaifRAttivDetMaterialeByIdAttivitaProgressivoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAttivDetMaterialeByIdAttivitaProgressivoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDMATERIALE") != null)
			dto.setIdMateriale((Integer) rs.getObject("idMateriale"));

		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo((Integer) rs.getObject("progressivo"));

		if (mapAllColumns || columnsToReadMap.get("IDATTIVITA") != null)
			dto.setIdAttivita((Integer) rs.getObject("idAttivita"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONEALTROMATERIALE") != null)
			dto.setDescrizioneAltroMateriale(rs.getString("descrizioneAltroMateriale"));

		return dto;
	}

}
