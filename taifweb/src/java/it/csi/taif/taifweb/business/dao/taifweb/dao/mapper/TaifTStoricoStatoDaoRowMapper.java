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
 * RowMapper specifico del DAO TaifTStoricoStatoDao
 * @generated
 */
public class TaifTStoricoStatoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTStoricoStatoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTStoricoStatoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTStoricoStatoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTStoricoStatoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTStoricoStatoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTStoricoStatoDto) {
			return mapRow_internal((TaifTStoricoStatoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTStoricoStatoByStatoPraticaDto) {
			return mapRow_internal((TaifTStoricoStatoByStatoPraticaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTStoricoStatoByidPraticaITDto) {
			return mapRow_internal((TaifTStoricoStatoByidPraticaITDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTStoricoStatoByidPraticaFRDto) {
			return mapRow_internal((TaifTStoricoStatoByidPraticaFRDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTStoricoStatoDto mapRow_internal(TaifTStoricoStatoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTStoricoStatoDto dto = objectToFill;

		// colonna [ID_PRATICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("ID_PRATICA"));

		// colonna [DATA_INSERIMENTO_STATO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO_STATO") != null)
			dto.setDataInserimentoStato(rs.getTimestamp("DATA_INSERIMENTO_STATO"));

		// colonna [FK_STATO_PRATICA]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_PRATICA") != null)
			dto.setFkStatoPratica((Integer) rs.getObject("FK_STATO_PRATICA"));

		// colonna [NUMERO_PROTOCOLLO]
		if (mapAllColumns || columnsToReadMap.get("NUMERO_PROTOCOLLO") != null)
			dto.setNumeroProtocollo(rs.getString("NUMERO_PROTOCOLLO"));

		// colonna [DATA_PROTOCOLLO]
		if (mapAllColumns || columnsToReadMap.get("DATA_PROTOCOLLO") != null)
			dto.setDataProtocollo(rs.getDate("DATA_PROTOCOLLO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		// colonna [DATA_FINE_STATO]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_STATO") != null)
			dto.setDataFineStato(rs.getDate("DATA_FINE_STATO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTStoricoStatoByStatoPraticaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTStoricoStatoByStatoPraticaDto
	 * @generated
	 */

	public TaifTStoricoStatoByStatoPraticaDto mapRow_internal(TaifTStoricoStatoByStatoPraticaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTStoricoStatoByStatoPraticaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTOSTATO") != null)
			dto.setDataInserimentoStato(rs.getTimestamp("dataInserimentoStato"));

		if (mapAllColumns || columnsToReadMap.get("IDSTATOPRATICA") != null)
			dto.setIdStatoPratica((Integer) rs.getObject("idStatoPratica"));

		if (mapAllColumns || columnsToReadMap.get("NUMPROTOCOLLO") != null)
			dto.setNumProtocollo(rs.getString("numProtocollo"));

		if (mapAllColumns || columnsToReadMap.get("DATAPROT") != null)
			dto.setDataProt(rs.getDate("dataProt"));

		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("note"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTStoricoStatoByidPraticaITDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTStoricoStatoByidPraticaITDto
	 * @generated
	 */

	public TaifTStoricoStatoByidPraticaITDto mapRow_internal(TaifTStoricoStatoByidPraticaITDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTStoricoStatoByidPraticaITDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("IDSTATOPRATICA") != null)
			dto.setIdStatoPratica((Integer) rs.getObject("idStatoPratica"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTOSTATO") != null)
			dto.setDataInserimentoStato(rs.getTimestamp("dataInserimentoStato"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROPROTOCOLLO") != null)
			dto.setNumeroProtocollo(rs.getString("numeroProtocollo"));

		if (mapAllColumns || columnsToReadMap.get("DATAPROTOCOLLO") != null)
			dto.setDataProtocollo(rs.getDate("dataProtocollo"));

		if (mapAllColumns || columnsToReadMap.get("DATAULTIMAMODIFICA") != null)
			dto.setDataUltimaModifica(rs.getTimestamp("dataUltimaModifica"));

		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("note"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICA") != null)
			dto.setStatoPratica(rs.getString("statoPratica"));

		if (mapAllColumns || columnsToReadMap.get("OPERATORECOGNOME") != null)
			dto.setOperatoreCognome(rs.getString("operatoreCognome"));

		if (mapAllColumns || columnsToReadMap.get("OPERATORENOME") != null)
			dto.setOperatoreNome(rs.getString("operatoreNome"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTStoricoStatoByidPraticaFRDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTStoricoStatoByidPraticaFRDto
	 * @generated
	 */

	public TaifTStoricoStatoByidPraticaFRDto mapRow_internal(TaifTStoricoStatoByidPraticaFRDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTStoricoStatoByidPraticaFRDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICA") != null)
			dto.setStatoPratica(rs.getString("statoPratica"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTOSTATO") != null)
			dto.setDataInserimentoStato(rs.getTimestamp("dataInserimentoStato"));

		if (mapAllColumns || columnsToReadMap.get("IDSTATOPRATICA") != null)
			dto.setIdStatoPratica((Integer) rs.getObject("idStatoPratica"));

		return dto;
	}

}
