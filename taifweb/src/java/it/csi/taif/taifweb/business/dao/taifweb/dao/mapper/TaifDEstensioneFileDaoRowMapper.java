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
 * RowMapper specifico del DAO TaifDEstensioneFileDao
 * @generated
 */
public class TaifDEstensioneFileDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDEstensioneFileDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDEstensioneFileDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDEstensioneFileDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDEstensioneFileDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDEstensioneFileDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDEstensioneFileDto) {
			return mapRow_internal((TaifDEstensioneFileDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDEstensioneFileEstensioneFileVisibleDto) {
			return mapRow_internal((TaifDEstensioneFileEstensioneFileVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDEstensioneFileEstensioneFileAmmDto) {
			return mapRow_internal((TaifDEstensioneFileEstensioneFileAmmDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto) {
			return mapRow_internal((TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDEstensioneFileDto mapRow_internal(TaifDEstensioneFileDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDEstensioneFileDto dto = objectToFill;

		// colonna [ID_ESTENSIONE_FILE]
		if (mapAllColumns || columnsToReadMap.get("ID_ESTENSIONE_FILE") != null)
			dto.setIdEstensioneFile((Integer) rs.getObject("ID_ESTENSIONE_FILE"));

		// colonna [ESTENSIONE]
		if (mapAllColumns || columnsToReadMap.get("ESTENSIONE") != null)
			dto.setEstensione(rs.getString("ESTENSIONE"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDEstensioneFileEstensioneFileVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDEstensioneFileEstensioneFileVisibleDto
	 * @generated
	 */

	public TaifDEstensioneFileEstensioneFileVisibleDto mapRow_internal(
			TaifDEstensioneFileEstensioneFileVisibleDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDEstensioneFileEstensioneFileVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("EXTENS") != null)
			dto.setExtens(rs.getString("extens"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDEstensioneFileEstensioneFileAmmDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDEstensioneFileEstensioneFileAmmDto
	 * @generated
	 */

	public TaifDEstensioneFileEstensioneFileAmmDto mapRow_internal(TaifDEstensioneFileEstensioneFileAmmDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDEstensioneFileEstensioneFileAmmDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_ALLEGATO") != null)
			dto.setId_tipo_allegato((Integer) rs.getObject("id_tipo_allegato"));

		if (mapAllColumns || columnsToReadMap.get("ESTENSIONE") != null)
			dto.setEstensione(rs.getString("estensione"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto
	 * @generated
	 */

	public TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto mapRow_internal(
			TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ESTENSIONE") != null)
			dto.setEstensione(rs.getString("estensione"));

		return dto;
	}

}
