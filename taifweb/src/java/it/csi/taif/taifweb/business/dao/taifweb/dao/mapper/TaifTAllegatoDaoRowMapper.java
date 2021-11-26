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
 * RowMapper specifico del DAO TaifTAllegatoDao
 * @generated
 */
public class TaifTAllegatoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTAllegatoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTAllegatoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTAllegatoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTAllegatoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAllegatoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTAllegatoDto) {
			return mapRow_internal((TaifTAllegatoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTAllegatoByFilterDto) {
			return mapRow_internal((TaifTAllegatoByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAllegatoByIdPraticaDto) {
			return mapRow_internal((TaifTAllegatoByIdPraticaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAllegatoByIdPraticaAllDto) {
			return mapRow_internal((TaifTAllegatoByIdPraticaAllDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTAllegatoDto mapRow_internal(TaifTAllegatoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAllegatoDto dto = objectToFill;

		// colonna [ID_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato((Integer) rs.getObject("ID_ALLEGATO"));

		// colonna [FK_PRATICA]
		if (mapAllColumns || columnsToReadMap.get("FK_PRATICA") != null)
			dto.setFkPratica((Integer) rs.getObject("FK_PRATICA"));

		// colonna [FK_CORSO]
		if (mapAllColumns || columnsToReadMap.get("FK_CORSO") != null)
			dto.setFkCorso((Integer) rs.getObject("FK_CORSO"));

		// colonna [FK_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA") != null)
			dto.setFkPersona((Integer) rs.getObject("FK_PERSONA"));

		// colonna [FK_ESTENSIONE_FILE]
		if (mapAllColumns || columnsToReadMap.get("FK_ESTENSIONE_FILE") != null)
			dto.setFkEstensioneFile((Integer) rs.getObject("FK_ESTENSIONE_FILE"));

		// colonna [FK_TIPO_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_ALLEGATO") != null)
			dto.setFkTipoAllegato((Integer) rs.getObject("FK_TIPO_ALLEGATO"));

		// colonna [NOME_FILE]
		if (mapAllColumns || columnsToReadMap.get("NOME_FILE") != null)
			dto.setNomeFile(rs.getString("NOME_FILE"));

		// colonna [DIMENSIONE_FILE_KB]
		if (mapAllColumns || columnsToReadMap.get("DIMENSIONE_FILE_KB") != null)
			dto.setDimensioneFileKb((Integer) rs.getObject("DIMENSIONE_FILE_KB"));

		// colonna [FLG_TIPO_INVIO]
		if (mapAllColumns || columnsToReadMap.get("FLG_TIPO_INVIO") != null)
			dto.setFlgTipoInvio(rs.getString("FLG_TIPO_INVIO"));

		// colonna [FLG_SCADENZA]
		if (mapAllColumns || columnsToReadMap.get("FLG_SCADENZA") != null)
			dto.setFlgScadenza(rs.getBigDecimal("FLG_SCADENZA"));

		// colonna [DATA_UPLOAD]
		if (mapAllColumns || columnsToReadMap.get("DATA_UPLOAD") != null)
			dto.setDataUpload(rs.getTimestamp("DATA_UPLOAD"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [ESTENSIONE_FILE]
		if (mapAllColumns || columnsToReadMap.get("ESTENSIONE_FILE") != null)
			dto.setEstensioneFile(rs.getString("ESTENSIONE_FILE"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		// colonna [ID_DOC_DOQUI]
		if (mapAllColumns || columnsToReadMap.get("ID_DOC_DOQUI") != null)
			dto.setIdDocDoqui(rs.getString("ID_DOC_DOQUI"));

		// colonna [ID_CLASSIFICAZIONE_DOQUI]
		if (mapAllColumns || columnsToReadMap.get("ID_CLASSIFICAZIONE_DOQUI") != null)
			dto.setIdClassificazioneDoqui(rs.getString("ID_CLASSIFICAZIONE_DOQUI"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAllegatoByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAllegatoByFilterDto
	 * @generated
	 */

	public TaifTAllegatoByFilterDto mapRow_internal(TaifTAllegatoByFilterDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTAllegatoByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdCorso((Integer) rs.getObject("idCorso"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOALL") != null)
			dto.setIdTipoAll((Integer) rs.getObject("idTipoAll"));

		if (mapAllColumns || columnsToReadMap.get("TIPOINVIO") != null)
			dto.setTipoInvio(rs.getString("tipoInvio"));

		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("note"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAllegatoByIdPraticaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAllegatoByIdPraticaDto
	 * @generated
	 */

	public TaifTAllegatoByIdPraticaDto mapRow_internal(TaifTAllegatoByIdPraticaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTAllegatoByIdPraticaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDALLEGATO") != null)
			dto.setIdAllegato((Integer) rs.getObject("idAllegato"));

		if (mapAllColumns || columnsToReadMap.get("NOMEALLEGATO") != null)
			dto.setNomeAllegato(rs.getString("nomeAllegato"));

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdCorso((Integer) rs.getObject("idCorso"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOALL") != null)
			dto.setIdTipoAll((Integer) rs.getObject("idTipoAll"));

		if (mapAllColumns || columnsToReadMap.get("TIPOINVIO") != null)
			dto.setTipoInvio(rs.getString("tipoInvio"));

		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("note"));

		if (mapAllColumns || columnsToReadMap.get("DIMENSIONE_FILE_KB") != null)
			dto.setAllegatoDimensioneFileKb((Integer) rs.getObject("DIMENSIONE_FILE_KB"));

		if (mapAllColumns || columnsToReadMap.get("ID_DOC_DOQUI") != null)
			dto.setAllegatoIdDocDoqui(rs.getString("ID_DOC_DOQUI"));

		if (mapAllColumns || columnsToReadMap.get("ID_CLASSIFICAZIONE_DOQUI") != null)
			dto.setAllegatoIdClassificazioneDoqui(rs.getString("ID_CLASSIFICAZIONE_DOQUI"));

		if (mapAllColumns || columnsToReadMap.get("TIPO_ALLEGATO") != null)
			dto.setTipoallegatoTipoAllegato(rs.getString("TIPO_ALLEGATO"));

		if (mapAllColumns || columnsToReadMap.get("FLG_FIRMA") != null)
			dto.setTipoallegatoFlgFirma(rs.getString("FLG_FIRMA"));

		if (mapAllColumns || columnsToReadMap.get("ACTA_OGGETTO") != null)
			dto.setTipoallegatoActaOggetto(rs.getString("ACTA_OGGETTO"));

		if (mapAllColumns || columnsToReadMap.get("ACTA_FLG_ALLEGATI") != null)
			dto.setTipoallegatoActaFlgAllegati(rs.getString("ACTA_FLG_ALLEGATI"));

		if (mapAllColumns || columnsToReadMap.get("ACTA_STATO_DI_EFFICACIA") != null)
			dto.setTipoallegatoActaStatoDiEfficacia(rs.getString("ACTA_STATO_DI_EFFICACIA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAllegatoByIdPraticaAllDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAllegatoByIdPraticaAllDto
	 * @generated
	 */

	public TaifTAllegatoByIdPraticaAllDto mapRow_internal(TaifTAllegatoByIdPraticaAllDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTAllegatoByIdPraticaAllDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDALLEGATO") != null)
			dto.setIdAllegato((Integer) rs.getObject("idAllegato"));

		if (mapAllColumns || columnsToReadMap.get("NOMEALLEGATO") != null)
			dto.setNomeAllegato(rs.getString("nomeAllegato"));

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdCorso((Integer) rs.getObject("idCorso"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOALL") != null)
			dto.setIdTipoAll((Integer) rs.getObject("idTipoAll"));

		if (mapAllColumns || columnsToReadMap.get("TIPOINVIO") != null)
			dto.setTipoInvio(rs.getString("tipoInvio"));

		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("note"));

		if (mapAllColumns || columnsToReadMap.get("DIMENSIONE_FILE_KB") != null)
			dto.setAllegatoDimensioneFileKb((Integer) rs.getObject("DIMENSIONE_FILE_KB"));

		if (mapAllColumns || columnsToReadMap.get("ID_DOC_DOQUI") != null)
			dto.setAllegatoIdDocDoqui(rs.getString("ID_DOC_DOQUI"));

		if (mapAllColumns || columnsToReadMap.get("ID_CLASSIFICAZIONE_DOQUI") != null)
			dto.setAllegatoIdClassificazioneDoqui(rs.getString("ID_CLASSIFICAZIONE_DOQUI"));

		if (mapAllColumns || columnsToReadMap.get("TIPO_ALLEGATO") != null)
			dto.setTipoallegatoTipoAllegato(rs.getString("TIPO_ALLEGATO"));

		if (mapAllColumns || columnsToReadMap.get("FLG_FIRMA") != null)
			dto.setTipoallegatoFlgFirma(rs.getString("FLG_FIRMA"));

		if (mapAllColumns || columnsToReadMap.get("ACTA_OGGETTO") != null)
			dto.setTipoallegatoActaOggetto(rs.getString("ACTA_OGGETTO"));

		if (mapAllColumns || columnsToReadMap.get("ACTA_FLG_ALLEGATI") != null)
			dto.setTipoallegatoActaFlgAllegati(rs.getString("ACTA_FLG_ALLEGATI"));

		if (mapAllColumns || columnsToReadMap.get("ACTA_STATO_DI_EFFICACIA") != null)
			dto.setTipoallegatoActaStatoDiEfficacia(rs.getString("ACTA_STATO_DI_EFFICACIA"));

		return dto;
	}

}
