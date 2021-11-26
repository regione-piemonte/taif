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
 * RowMapper specifico del DAO TaifTCommercializzazioneDao
 * @generated
 */
public class TaifTCommercializzazioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTCommercializzazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTCommercializzazioneDaoRowMapper(String[] columnsToRead, Class dtoClass,
			TaifTCommercializzazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTCommercializzazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCommercializzazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTCommercializzazioneDto) {
			return mapRow_internal((TaifTCommercializzazioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTCommercializzazioneByFilterDto) {
			return mapRow_internal((TaifTCommercializzazioneByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCommercializzazioneByAziendaDto) {
			return mapRow_internal((TaifTCommercializzazioneByAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCommercializzazioneSpecieByIdSpecieVisibleDto) {
			return mapRow_internal((TaifTCommercializzazioneSpecieByIdSpecieVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto) {
			return mapRow_internal((TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto) {
			return mapRow_internal((TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto) dtoInstance, rs,
					row);
		}
		if (dtoInstance instanceof TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto) {
			return mapRow_internal((TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTCommercializzazioneDto mapRow_internal(TaifTCommercializzazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTCommercializzazioneDto dto = objectToFill;

		// colonna [ID_COMMERCIALIZZAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_COMMERCIALIZZAZIONE") != null)
			dto.setIdCommercializzazione((Integer) rs.getObject("ID_COMMERCIALIZZAZIONE"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [FK_SPECIE]
		if (mapAllColumns || columnsToReadMap.get("FK_SPECIE") != null)
			dto.setFkSpecie((Integer) rs.getObject("FK_SPECIE"));

		// colonna [FK_PROVENIENZA]
		if (mapAllColumns || columnsToReadMap.get("FK_PROVENIENZA") != null)
			dto.setFkProvenienza((Integer) rs.getObject("FK_PROVENIENZA"));

		// colonna [FK_DESTINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_DESTINAZIONE") != null)
			dto.setFkDestinazione((Integer) rs.getObject("FK_DESTINAZIONE"));

		// colonna [FK_ASSORTIMENTO]
		if (mapAllColumns || columnsToReadMap.get("FK_ASSORTIMENTO") != null)
			dto.setFkAssortimento((Integer) rs.getObject("FK_ASSORTIMENTO"));

		// colonna [FK_UNITA_DI_MISURA]
		if (mapAllColumns || columnsToReadMap.get("FK_UNITA_DI_MISURA") != null)
			dto.setFkUnitaDiMisura((Integer) rs.getObject("FK_UNITA_DI_MISURA"));

		// colonna [VENDUTO_MEDIO]
		if (mapAllColumns || columnsToReadMap.get("VENDUTO_MEDIO") != null)
			dto.setVendutoMedio(rs.getBigDecimal("VENDUTO_MEDIO"));

		// colonna [FLG_TAGLIATO_ACQUISTATO]
		if (mapAllColumns || columnsToReadMap.get("FLG_TAGLIATO_ACQUISTATO") != null)
			dto.setFlgTagliatoAcquistato(rs.getString("FLG_TAGLIATO_ACQUISTATO"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCommercializzazioneByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCommercializzazioneByFilterDto
	 * @generated
	 */

	public TaifTCommercializzazioneByFilterDto mapRow_internal(TaifTCommercializzazioneByFilterDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTCommercializzazioneByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("VENDUTO") != null)
			dto.setVenduto(rs.getBigDecimal("venduto"));

		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("note"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCommercializzazioneByAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCommercializzazioneByAziendaDto
	 * @generated
	 */

	public TaifTCommercializzazioneByAziendaDto mapRow_internal(TaifTCommercializzazioneByAziendaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTCommercializzazioneByAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("VENDUTO") != null)
			dto.setVenduto(rs.getBigDecimal("venduto"));

		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("note"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDSPECIE") != null)
			dto.setIdSpecie((Integer) rs.getObject("idSpecie"));

		if (mapAllColumns || columnsToReadMap.get("IDPROVENIENZA") != null)
			dto.setIdProvenienza((Integer) rs.getObject("idProvenienza"));

		if (mapAllColumns || columnsToReadMap.get("IDDESTINAZIONE") != null)
			dto.setIdDestinazione((Integer) rs.getObject("idDestinazione"));

		if (mapAllColumns || columnsToReadMap.get("IDASSORTIMENTO") != null)
			dto.setIdAssortimento((Integer) rs.getObject("idAssortimento"));

		if (mapAllColumns || columnsToReadMap.get("IDUNMIS") != null)
			dto.setIdUnMis((Integer) rs.getObject("idUnMis"));

		if (mapAllColumns || columnsToReadMap.get("VENDUTOMEDIO") != null)
			dto.setVendutoMedio(rs.getBigDecimal("vendutoMedio"));

		if (mapAllColumns || columnsToReadMap.get("FLGTAGLIATO") != null)
			dto.setFlgTagliato(rs.getString("flgTagliato"));

		if (mapAllColumns || columnsToReadMap.get("IDUTENTE") != null)
			dto.setIdUtente((Integer) rs.getObject("idUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCommercializzazioneSpecieByIdSpecieVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCommercializzazioneSpecieByIdSpecieVisibleDto
	 * @generated
	 */

	public TaifTCommercializzazioneSpecieByIdSpecieVisibleDto mapRow_internal(
			TaifTCommercializzazioneSpecieByIdSpecieVisibleDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTCommercializzazioneSpecieByIdSpecieVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("NOMESPECIE") != null)
			dto.setNomeSpecie(rs.getString("nomeSpecie"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto
	 * @generated
	 */

	public TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto mapRow_internal(
			TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("PROVENIENZA") != null)
			dto.setProvenienza(rs.getString("provenienza"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto
	 * @generated
	 */

	public TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto mapRow_internal(
			TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ASSORTIMENTO") != null)
			dto.setAssortimento(rs.getString("assortimento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto
	 * @generated
	 */

	public TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto mapRow_internal(
			TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("UNITAMISURA") != null)
			dto.setUnitaMisura(rs.getString("unitaMisura"));

		return dto;
	}

}
