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
 * RowMapper specifico del DAO TaifDCategoriaImpresaDao
 * @generated
 */
public class TaifDCategoriaImpresaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDCategoriaImpresaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDCategoriaImpresaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDCategoriaImpresaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDCategoriaImpresaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDCategoriaImpresaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDCategoriaImpresaDto) {
			return mapRow_internal((TaifDCategoriaImpresaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDCategoriaImpresaCategoriaImpresaVisibleDto) {
			return mapRow_internal((TaifDCategoriaImpresaCategoriaImpresaVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDCategoriaImpresaDto mapRow_internal(TaifDCategoriaImpresaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDCategoriaImpresaDto dto = objectToFill;

		// colonna [ID_CATEGORIA]
		if (mapAllColumns || columnsToReadMap.get("ID_CATEGORIA") != null)
			dto.setIdCategoria((Integer) rs.getObject("ID_CATEGORIA"));

		// colonna [CATEGORIA_IMPRESA]
		if (mapAllColumns || columnsToReadMap.get("CATEGORIA_IMPRESA") != null)
			dto.setCategoriaImpresa(rs.getString("CATEGORIA_IMPRESA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDCategoriaImpresaCategoriaImpresaVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDCategoriaImpresaCategoriaImpresaVisibleDto
	 * @generated
	 */

	public TaifDCategoriaImpresaCategoriaImpresaVisibleDto mapRow_internal(
			TaifDCategoriaImpresaCategoriaImpresaVisibleDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDCategoriaImpresaCategoriaImpresaVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CATEGORIA") != null)
			dto.setCategoria(rs.getString("categoria"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("FLAGVIS") != null)
			dto.setFlagVis(rs.getBigDecimal("flagVis"));

		if (mapAllColumns || columnsToReadMap.get("FLAGITA") != null)
			dto.setFlagIta(rs.getString("flagIta"));

		return dto;
	}

}
