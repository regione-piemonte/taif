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
 * RowMapper specifico del DAO TaifTPersonaDao
 * @generated
 */
public class TaifTPersonaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTPersonaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTPersonaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTPersonaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTPersonaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTPersonaDto) {
			return mapRow_internal((TaifTPersonaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTPersonaDatiIdentificativiOperatoreDto) {
			return mapRow_internal((TaifTPersonaDatiIdentificativiOperatoreDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaProfiloUtenteByCodiceFiscaleDto) {
			return mapRow_internal((TaifTPersonaProfiloUtenteByCodiceFiscaleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaByCodiceFiscalePersonaDto) {
			return mapRow_internal((TaifTPersonaByCodiceFiscalePersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaByFilterDto) {
			return mapRow_internal((TaifTPersonaByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaAnagraficaOperatoreByIdOperatoreDto) {
			return mapRow_internal((TaifTPersonaAnagraficaOperatoreByIdOperatoreDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaOperatoriCorsiPerPersonaDto) {
			return mapRow_internal((TaifTPersonaOperatoriCorsiPerPersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaQualifichePerPersonaDto) {
			return mapRow_internal((TaifTPersonaQualifichePerPersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaRiconoscimentiPerPersonaDto) {
			return mapRow_internal((TaifTPersonaRiconoscimentiPerPersonaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTPersonaDto mapRow_internal(TaifTPersonaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPersonaDto dto = objectToFill;

		// colonna [ID_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("ID_PERSONA"));

		// colonna [FK_TITOLO_STUDIO]
		if (mapAllColumns || columnsToReadMap.get("FK_TITOLO_STUDIO") != null)
			dto.setFkTitoloStudio((Integer) rs.getObject("FK_TITOLO_STUDIO"));

		// colonna [FK_TITOLO_STUDIO_FRA]
		if (mapAllColumns || columnsToReadMap.get("FK_TITOLO_STUDIO_FRA") != null)
			dto.setFkTitoloStudioFra((Integer) rs.getObject("FK_TITOLO_STUDIO_FRA"));

		// colonna [FK_NAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_NAZIONE") != null)
			dto.setFkNazione((Integer) rs.getObject("FK_NAZIONE"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [N_RSI_MSA]
		if (mapAllColumns || columnsToReadMap.get("N_RSI_MSA") != null)
			dto.setNRsiMsa(rs.getString("N_RSI_MSA"));

		// colonna [COGNOME]
		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("COGNOME"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [FLG_SESSO]
		if (mapAllColumns || columnsToReadMap.get("FLG_SESSO") != null)
			dto.setFlgSesso(rs.getString("FLG_SESSO"));

		// colonna [DATA_NASCITA]
		if (mapAllColumns || columnsToReadMap.get("DATA_NASCITA") != null)
			dto.setDataNascita(rs.getDate("DATA_NASCITA"));

		// colonna [ISTAT_COMUNE_NASCITA]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE_NASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("ISTAT_COMUNE_NASCITA"));

		// colonna [COMUNE_ESTERO_NASCITA]
		if (mapAllColumns || columnsToReadMap.get("COMUNE_ESTERO_NASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("COMUNE_ESTERO_NASCITA"));

		// colonna [ISTAT_COMUNE_RES]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE_RES") != null)
			dto.setIstatComuneRes(rs.getString("ISTAT_COMUNE_RES"));

		// colonna [COMUNE_ESTERO_RES]
		if (mapAllColumns || columnsToReadMap.get("COMUNE_ESTERO_RES") != null)
			dto.setComuneEsteroRes(rs.getString("COMUNE_ESTERO_RES"));

		// colonna [INDIRIZZO_RES]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_RES") != null)
			dto.setIndirizzoRes(rs.getString("INDIRIZZO_RES"));

		// colonna [CIVICO_RES]
		if (mapAllColumns || columnsToReadMap.get("CIVICO_RES") != null)
			dto.setCivicoRes(rs.getString("CIVICO_RES"));

		// colonna [CAP_RES]
		if (mapAllColumns || columnsToReadMap.get("CAP_RES") != null)
			dto.setCapRes(rs.getString("CAP_RES"));

		// colonna [TELEFONO]
		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("TELEFONO"));

		// colonna [CELLULARE]
		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("CELLULARE"));

		// colonna [MAIL]
		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("MAIL"));

		// colonna [ALTRI_STUDI]
		if (mapAllColumns || columnsToReadMap.get("ALTRI_STUDI") != null)
			dto.setAltriStudi(rs.getString("ALTRI_STUDI"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		// colonna [PWD]
		if (mapAllColumns || columnsToReadMap.get("PWD") != null)
			dto.setPwd(rs.getString("PWD"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaDatiIdentificativiOperatoreDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaDatiIdentificativiOperatoreDto
	 * @generated
	 */

	public TaifTPersonaDatiIdentificativiOperatoreDto mapRow_internal(
			TaifTPersonaDatiIdentificativiOperatoreDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPersonaDatiIdentificativiOperatoreDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("PUBBLICO") != null)
			dto.setPubblico(rs.getBigDecimal("pubblico"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLOSTUDIO") != null)
			dto.setIdTitoloStudio((Integer) rs.getObject("idTitoloStudio"));

		if (mapAllColumns || columnsToReadMap.get("TITOLOSTUDIOITA") != null)
			dto.setTitoloStudioIta(rs.getString("titoloStudioIta"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLOSTUDIOFRA") != null)
			dto.setIdTitoloStudioFra((Integer) rs.getObject("idTitoloStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("TITOLOSTUDIOFRA") != null)
			dto.setTitoloStudioFra(rs.getString("titoloStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("NRSIMSA") != null)
			dto.setNRsiMsa(rs.getString("nRsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERORESIDENZA") != null)
			dto.setComuneEsteroResidenza(rs.getString("comuneEsteroResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICORESIDENZA") != null)
			dto.setCivicoResidenza(rs.getString("civicoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CAPRESIDENZA") != null)
			dto.setCapResidenza(rs.getString("capResidenza"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("EMAILPERSONALE") != null)
			dto.setEmailPersonale(rs.getString("emailPersonale"));

		if (mapAllColumns || columnsToReadMap.get("ALTRISTUDI") != null)
			dto.setAltriStudi(rs.getString("altriStudi"));

		if (mapAllColumns || columnsToReadMap.get("ELENCOAPPARTENENZA") != null)
			dto.setElencoAppartenenza(rs.getString("elencoAppartenenza"));

		if (mapAllColumns || columnsToReadMap.get("STATOSCHEDAITA") != null)
			dto.setStatoSchedaIta(rs.getString("statoSchedaIta"));

		if (mapAllColumns || columnsToReadMap.get("STATOSCHEDAFRA") != null)
			dto.setStatoSchedaFra(rs.getString("statoSchedaFra"));

		if (mapAllColumns || columnsToReadMap.get("NAZIONENASCITAITA") != null)
			dto.setNazioneNascitaIta(rs.getString("nazioneNascitaIta"));

		if (mapAllColumns || columnsToReadMap.get("NAZIONENASCITAFRA") != null)
			dto.setNazioneNascitaFra(rs.getString("nazioneNascitaFra"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("URLPRIVACY") != null)
			dto.setUrlPrivacy(rs.getString("urlPrivacy"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaProfiloUtenteByCodiceFiscaleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaProfiloUtenteByCodiceFiscaleDto
	 * @generated
	 */

	public TaifTPersonaProfiloUtenteByCodiceFiscaleDto mapRow_internal(
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLOFRA") != null)
			dto.setIdTitoloFra((Integer) rs.getObject("idTitoloFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("RSIMSA") != null)
			dto.setRsiMsa(rs.getString("rsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERORESIDENZA") != null)
			dto.setComuneEsteroResidenza(rs.getString("comuneEsteroResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICORESIDENZA") != null)
			dto.setCivicoResidenza(rs.getString("civicoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFON") != null)
			dto.setTelefon(rs.getString("telefon"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ALTRISTUDI") != null)
			dto.setAltriStudi(rs.getString("altriStudi"));

		if (mapAllColumns || columnsToReadMap.get("IDPROFILOUTENTE") != null)
			dto.setIdProfiloUtente((Integer) rs.getObject("idProfiloUtente"));

		if (mapAllColumns || columnsToReadMap.get("PROFILOUTENTE") != null)
			dto.setProfiloUtente(rs.getString("profiloUtente"));

		if (mapAllColumns || columnsToReadMap.get("FLAGUTENTEATTIVO") != null)
			dto.setFlagUtenteAttivo(rs.getBigDecimal("flagUtenteAttivo"));

		if (mapAllColumns || columnsToReadMap.get("IDPROCEDURAUTENTE") != null)
			dto.setIdProceduraUtente((Integer) rs.getObject("idProceduraUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDCONFIGUTENTE") != null)
			dto.setIdConfigUtente((Integer) rs.getObject("idConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByCodiceFiscalePersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByCodiceFiscalePersonaDto
	 * @generated
	 */

	public TaifTPersonaByCodiceFiscalePersonaDto mapRow_internal(TaifTPersonaByCodiceFiscalePersonaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPersonaByCodiceFiscalePersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLOSTUDIO") != null)
			dto.setIdTitoloStudio((Integer) rs.getObject("idTitoloStudio"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLOFRA") != null)
			dto.setIdTitoloFra((Integer) rs.getObject("idTitoloFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("NSIMSA") != null)
			dto.setNsiMsa(rs.getString("nsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERORESIDENZA") != null)
			dto.setComuneEsteroResidenza(rs.getString("comuneEsteroResidenza"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICORESIDENZA") != null)
			dto.setCivicoResidenza(rs.getString("civicoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("EMAIL") != null)
			dto.setEMail(rs.getString("eMail"));

		if (mapAllColumns || columnsToReadMap.get("ALTRISTUDI") != null)
			dto.setAltriStudi(rs.getString("altriStudi"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByFilterDto
	 * @generated
	 */

	public TaifTPersonaByFilterDto mapRow_internal(TaifTPersonaByFilterDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPersonaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLOSTUDIO") != null)
			dto.setIdTitoloStudio((Integer) rs.getObject("idTitoloStudio"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLOFRA") != null)
			dto.setIdTitoloFra((Integer) rs.getObject("idTitoloFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("NSIMSA") != null)
			dto.setNsiMsa(rs.getString("nsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICORESIDENZA") != null)
			dto.setCivicoResidenza(rs.getString("civicoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("EMAIL") != null)
			dto.setEMail(rs.getString("eMail"));

		if (mapAllColumns || columnsToReadMap.get("ALTRISTUDI") != null)
			dto.setAltriStudi(rs.getString("altriStudi"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaAnagraficaOperatoreByIdOperatoreDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaAnagraficaOperatoreByIdOperatoreDto
	 * @generated
	 */

	public TaifTPersonaAnagraficaOperatoreByIdOperatoreDto mapRow_internal(
			TaifTPersonaAnagraficaOperatoreByIdOperatoreDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPersonaAnagraficaOperatoreByIdOperatoreDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONESOGGETTOGESTORE") != null)
			dto.setDenominazioneSoggettoGestore(rs.getString("denominazioneSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALEPERSONA") != null)
			dto.setCodiceFiscalePersona(rs.getString("codiceFiscalePersona"));

		if (mapAllColumns || columnsToReadMap.get("NRSIMSA") != null)
			dto.setNRsiMsa(rs.getString("nRsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOMEPERSONA") != null)
			dto.setCognomePersona(rs.getString("cognomePersona"));

		if (mapAllColumns || columnsToReadMap.get("NOMEPERSONA") != null)
			dto.setNomePersona(rs.getString("nomePersona"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERORESIDENZA") != null)
			dto.setComuneEsteroResidenza(rs.getString("comuneEsteroResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICORESIDENZA") != null)
			dto.setCivicoResidenza(rs.getString("civicoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CAPRESIDENZA") != null)
			dto.setCapResidenza(rs.getString("capResidenza"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("MAILPERSONALE") != null)
			dto.setMailPersonale(rs.getString("mailPersonale"));

		if (mapAllColumns || columnsToReadMap.get("FLAGPUBBLICO") != null)
			dto.setFlagPubblico(rs.getBigDecimal("flagPubblico"));

		if (mapAllColumns || columnsToReadMap.get("STATOOPFOITA") != null)
			dto.setStatoOpfoIta(rs.getString("statoOpfoIta"));

		if (mapAllColumns || columnsToReadMap.get("URLPRIVACY") != null)
			dto.setUrlPrivacy(rs.getString("urlPrivacy"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaOperatoriCorsiPerPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaOperatoriCorsiPerPersonaDto
	 * @generated
	 */

	public TaifTPersonaOperatoriCorsiPerPersonaDto mapRow_internal(TaifTPersonaOperatoriCorsiPerPersonaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPersonaOperatoriCorsiPerPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALEPERSONA") != null)
			dto.setCodiceFiscalePersona(rs.getString("codiceFiscalePersona"));

		if (mapAllColumns || columnsToReadMap.get("NRSIMSA") != null)
			dto.setNRsiMsa(rs.getString("nRsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOMEPERSONA") != null)
			dto.setCognomePersona(rs.getString("cognomePersona"));

		if (mapAllColumns || columnsToReadMap.get("NOMEPERSONA") != null)
			dto.setNomePersona(rs.getString("nomePersona"));

		if (mapAllColumns || columnsToReadMap.get("CORSO") != null)
			dto.setCorso(rs.getString("corso"));

		if (mapAllColumns || columnsToReadMap.get("DATAINIZIOCORSO") != null)
			dto.setDataInizioCorso(rs.getTimestamp("dataInizioCorso"));

		if (mapAllColumns || columnsToReadMap.get("DATAFINECORSO") != null)
			dto.setDataFineCorso(rs.getTimestamp("dataFineCorso"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROORECORSO") != null)
			dto.setNumeroOreCorso(rs.getBigDecimal("numeroOreCorso"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALEAGENZIA") != null)
			dto.setRagioneSocialeAgenzia(rs.getString("ragioneSocialeAgenzia"));

		if (mapAllColumns || columnsToReadMap.get("SIGLAUNITAFORMATIVA") != null)
			dto.setSiglaUnitaFormativa(rs.getString("siglaUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("UNITAFORMATIVA") != null)
			dto.setUnitaFormativa(rs.getString("unitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("ALTRODESCRIZIONE") != null)
			dto.setAltroDescrizione(rs.getString("altroDescrizione"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaQualifichePerPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaQualifichePerPersonaDto
	 * @generated
	 */

	public TaifTPersonaQualifichePerPersonaDto mapRow_internal(TaifTPersonaQualifichePerPersonaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPersonaQualifichePerPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALEPERSONA") != null)
			dto.setCodiceFiscalePersona(rs.getString("codiceFiscalePersona"));

		if (mapAllColumns || columnsToReadMap.get("NRSIMSA") != null)
			dto.setNRsiMsa(rs.getString("nRsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOMEPERSONA") != null)
			dto.setCognomePersona(rs.getString("cognomePersona"));

		if (mapAllColumns || columnsToReadMap.get("NOMEPERSONA") != null)
			dto.setNomePersona(rs.getString("nomePersona"));

		if (mapAllColumns || columnsToReadMap.get("TIPOQUALIFICA") != null)
			dto.setTipoQualifica(rs.getString("tipoQualifica"));

		if (mapAllColumns || columnsToReadMap.get("DATARILASCIO") != null)
			dto.setDataRilascio(rs.getDate("dataRilascio"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALEAGENZIA") != null)
			dto.setRagioneSocialeAgenzia(rs.getString("ragioneSocialeAgenzia"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaRiconoscimentiPerPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaRiconoscimentiPerPersonaDto
	 * @generated
	 */

	public TaifTPersonaRiconoscimentiPerPersonaDto mapRow_internal(TaifTPersonaRiconoscimentiPerPersonaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPersonaRiconoscimentiPerPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALEPERSONA") != null)
			dto.setCodiceFiscalePersona(rs.getString("codiceFiscalePersona"));

		if (mapAllColumns || columnsToReadMap.get("NRSIMSA") != null)
			dto.setNRsiMsa(rs.getString("nRsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOMEPERSONA") != null)
			dto.setCognomePersona(rs.getString("cognomePersona"));

		if (mapAllColumns || columnsToReadMap.get("NOMEPERSONA") != null)
			dto.setNomePersona(rs.getString("nomePersona"));

		if (mapAllColumns || columnsToReadMap.get("SIGLAUNITAFORMATIVA") != null)
			dto.setSiglaUnitaFormativa(rs.getString("siglaUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("DATARICONOSCIMENTO") != null)
			dto.setDataRiconoscimento(rs.getDate("dataRiconoscimento"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALEAGENZIA") != null)
			dto.setRagioneSocialeAgenzia(rs.getString("ragioneSocialeAgenzia"));

		if (mapAllColumns || columnsToReadMap.get("UNITAFORMATIVA") != null)
			dto.setUnitaFormativa(rs.getString("unitaFormativa"));

		return dto;
	}

}
