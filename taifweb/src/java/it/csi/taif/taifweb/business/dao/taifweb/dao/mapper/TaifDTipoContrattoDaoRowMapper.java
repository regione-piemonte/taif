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
 * RowMapper specifico del DAO TaifDTipoContrattoDao
 * @generated
 */
public class TaifDTipoContrattoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoContrattoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoContrattoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoContrattoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoContrattoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoContrattoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoContrattoDto) {
			return mapRow_internal((TaifDTipoContrattoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoContrattoByVisibleOrdinDto) {
			return mapRow_internal((TaifDTipoContrattoByVisibleOrdinDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoContrattoByTipoContrattoDto) {
			return mapRow_internal((TaifDTipoContrattoByTipoContrattoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoContrattoByIdContrattoDto) {
			return mapRow_internal((TaifDTipoContrattoByIdContrattoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoContrattoDto mapRow_internal(TaifDTipoContrattoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoContrattoDto dto = objectToFill;

		// colonna [ID_TIPO_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CONTRATTO") != null)
			dto.setIdTipoContratto((Integer) rs.getObject("ID_TIPO_CONTRATTO"));

		// colonna [TIPO_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("TIPO_CONTRATTO") != null)
			dto.setTipoContratto(rs.getString("TIPO_CONTRATTO"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		// colonna [MTD_FLG_ITA_FRA]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_ITA_FRA") != null)
			dto.setMtdFlgItaFra(rs.getString("MTD_FLG_ITA_FRA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoContrattoByVisibleOrdinDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoContrattoByVisibleOrdinDto
	 * @generated
	 */

	public TaifDTipoContrattoByVisibleOrdinDto mapRow_internal(TaifDTipoContrattoByVisibleOrdinDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoContrattoByVisibleOrdinDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoContrattoByTipoContrattoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoContrattoByTipoContrattoDto
	 * @generated
	 */

	public TaifDTipoContrattoByTipoContrattoDto mapRow_internal(TaifDTipoContrattoByTipoContrattoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoContrattoByTipoContrattoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCONTRATTO") != null)
			dto.setTipoContratto(rs.getString("tipoContratto"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("FLAGLANG") != null)
			dto.setFlaglang(rs.getString("flaglang"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoContrattoByIdContrattoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoContrattoByIdContrattoDto
	 * @generated
	 */

	public TaifDTipoContrattoByIdContrattoDto mapRow_internal(TaifDTipoContrattoByIdContrattoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoContrattoByIdContrattoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCONTRATTO") != null)
			dto.setTipoContratto(rs.getString("tipoContratto"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("FLAGLANG") != null)
			dto.setFlaglang(rs.getString("flaglang"));

		return dto;
	}

}
