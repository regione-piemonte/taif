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
 * RowMapper specifico del DAO TaifTAziendaDao
 * @generated
 */
public class TaifTAziendaExtDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTAziendaExtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTAziendaExtDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTAziendaExtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTAziendaExtDaoImpl) dao;
	}
	
	
	
	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAziendaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTAziendaDto) {
			return mapRow_internal((TaifTAziendaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTAziendaByCodiceFiscaleDto) {
			return mapRow_internal((TaifTAziendaByCodiceFiscaleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAziendaByPivaDto) {
			return mapRow_internal((TaifTAziendaByPivaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAziendaDomandaByCodiceFiscaleDto) {
			return mapRow_internal((TaifTAziendaDomandaByCodiceFiscaleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAziendaDomandaAziendaPraticaDto) {
			return mapRow_internal((TaifTAziendaDomandaAziendaPraticaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAziendaRicercaAziendaAvanzataDto) {
			return mapRow_internal((TaifTAziendaRicercaAziendaAvanzataDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAziendaRicercaAziendaExportDto) {
			return mapRow_internal((TaifTAziendaRicercaAziendaExportDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTAziendaIntestazioneRiepilogoDto) {
			return mapRow_internal((TaifTAziendaIntestazioneRiepilogoDto) dtoInstance, rs, row);
		}
		
		if (dtoInstance instanceof TaifTAziendaIntestazioneRiepilogoByPraticaDto) {
			return mapRow_internal((TaifTAziendaIntestazioneRiepilogoByPraticaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTAziendaDto mapRow_internal(TaifTAziendaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAziendaDto dto = objectToFill;

		// colonna [ID_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		// colonna [FK_ATTIVITA_PRIMARIA]
		if (mapAllColumns || columnsToReadMap.get("FK_ATTIVITA_PRIMARIA") != null)
			dto.setFkAttivitaPrimaria((Integer) rs.getObject("FK_ATTIVITA_PRIMARIA"));

		// colonna [FK_ATTIVITA_SECONDARIA]
		if (mapAllColumns || columnsToReadMap.get("FK_ATTIVITA_SECONDARIA") != null)
			dto.setFkAttivitaSecondaria((Integer) rs.getObject("FK_ATTIVITA_SECONDARIA"));

		// colonna [FK_ATTIVITA_APE]
		if (mapAllColumns || columnsToReadMap.get("FK_ATTIVITA_APE") != null)
			dto.setFkAttivitaApe((Integer) rs.getObject("FK_ATTIVITA_APE"));

		// colonna [FK_FORMA_GIURIDICA_ITA]
		if (mapAllColumns || columnsToReadMap.get("FK_FORMA_GIURIDICA_ITA") != null)
			dto.setFkFormaGiuridicaIta((Integer) rs.getObject("FK_FORMA_GIURIDICA_ITA"));

		// colonna [FK_FORMA_GIURIDICA_FRA]
		if (mapAllColumns || columnsToReadMap.get("FK_FORMA_GIURIDICA_FRA") != null)
			dto.setFkFormaGiuridicaFra((Integer) rs.getObject("FK_FORMA_GIURIDICA_FRA"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [N_SIRET]
		if (mapAllColumns || columnsToReadMap.get("N_SIRET") != null)
			dto.setNSiret(rs.getString("N_SIRET"));

		// colonna [PARTITA_IVA]
		if (mapAllColumns || columnsToReadMap.get("PARTITA_IVA") != null)
			dto.setPartitaIva(rs.getString("PARTITA_IVA"));

		// colonna [N_TVA]
		if (mapAllColumns || columnsToReadMap.get("N_TVA") != null)
			dto.setNTva(rs.getString("N_TVA"));

		// colonna [CCIAA_NUMERO]
		if (mapAllColumns || columnsToReadMap.get("CCIAA_NUMERO") != null)
			dto.setCciaaNumero(rs.getString("CCIAA_NUMERO"));

		// colonna [CCIAA_SIGLA_PROV]
		if (mapAllColumns || columnsToReadMap.get("CCIAA_SIGLA_PROV") != null)
			dto.setCciaaSiglaProv(rs.getString("CCIAA_SIGLA_PROV"));

		// colonna [RAGIONE_SOCIALE]
		if (mapAllColumns || columnsToReadMap.get("RAGIONE_SOCIALE") != null)
			dto.setRagioneSociale(rs.getString("RAGIONE_SOCIALE"));

		// colonna [N_MARCA_BOLLO]
		if (mapAllColumns || columnsToReadMap.get("N_MARCA_BOLLO") != null)
			dto.setNMarcaBollo(rs.getString("N_MARCA_BOLLO"));

		// colonna [DESCR_ALTRA_FORMA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("DESCR_ALTRA_FORMA_GIURIDICA") != null)
			dto.setDescrAltraFormaGiuridica(rs.getString("DESCR_ALTRA_FORMA_GIURIDICA"));

		// colonna [EMAIL]
		if (mapAllColumns || columnsToReadMap.get("EMAIL") != null)
			dto.setEmail(rs.getString("EMAIL"));

		// colonna [PEC]
		if (mapAllColumns || columnsToReadMap.get("PEC") != null)
			dto.setPec(rs.getString("PEC"));

		// colonna [SITO_WEB]
		if (mapAllColumns || columnsToReadMap.get("SITO_WEB") != null)
			dto.setSitoWeb(rs.getString("SITO_WEB"));

		// colonna [ANNO_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("ANNO_INIZIO") != null)
			dto.setAnnoInizio(rs.getBigDecimal("ANNO_INIZIO"));

		// colonna [FATTURATO]
		if (mapAllColumns || columnsToReadMap.get("FATTURATO") != null)
			dto.setFatturato(rs.getBigDecimal("FATTURATO"));

		// colonna [PERC_COMMERCIO_FRA]
		if (mapAllColumns || columnsToReadMap.get("PERC_COMMERCIO_FRA") != null)
			dto.setPercCommercioFra(rs.getBigDecimal("PERC_COMMERCIO_FRA"));

		// colonna [CLIENT1_FRA]
		if (mapAllColumns || columnsToReadMap.get("CLIENT1_FRA") != null)
			dto.setClient1Fra(rs.getString("CLIENT1_FRA"));

		// colonna [CLIENT2_FRA]
		if (mapAllColumns || columnsToReadMap.get("CLIENT2_FRA") != null)
			dto.setClient2Fra(rs.getString("CLIENT2_FRA"));

		// colonna [CLIENT3_FRA]
		if (mapAllColumns || columnsToReadMap.get("CLIENT3_FRA") != null)
			dto.setClient3Fra(rs.getString("CLIENT3_FRA"));

		// colonna [NBRE_SALARIES_FRA]
		if (mapAllColumns || columnsToReadMap.get("NBRE_SALARIES_FRA") != null)
			dto.setNbreSalariesFra((Integer) rs.getObject("NBRE_SALARIES_FRA"));

		// colonna [TEMPS_PLEIN_FRA]
		if (mapAllColumns || columnsToReadMap.get("TEMPS_PLEIN_FRA") != null)
			dto.setTempsPleinFra( rs.getBigDecimal("TEMPS_PLEIN_FRA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTAziendaByCodiceFiscaleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAziendaByCodiceFiscaleDto
	 * @generated
	 */

	public TaifTAziendaByCodiceFiscaleDto mapRow_internal(TaifTAziendaByCodiceFiscaleDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTAziendaByCodiceFiscaleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("PRIM") != null)
			dto.setPrim((Integer) rs.getObject("prim"));

		if (mapAllColumns || columnsToReadMap.get("SEC") != null)
			dto.setSec((Integer) rs.getObject("sec"));

		if (mapAllColumns || columnsToReadMap.get("CD") != null)
			dto.setCd(rs.getString("cd"));

		if (mapAllColumns || columnsToReadMap.get("RS") != null)
			dto.setRs(rs.getString("rs"));

		if (mapAllColumns || columnsToReadMap.get("DESC") != null)
			dto.setDesc(rs.getString("desc"));

		if (mapAllColumns || columnsToReadMap.get("PIVA") != null)
			dto.setPiva(rs.getString("piva"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAziendaByPivaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAziendaByPivaDto
	 * @generated
	 */

	public TaifTAziendaByPivaDto mapRow_internal(TaifTAziendaByPivaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTAziendaByPivaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("PRIM") != null)
			dto.setPrim((Integer) rs.getObject("prim"));

		if (mapAllColumns || columnsToReadMap.get("SEC") != null)
			dto.setSec((Integer) rs.getObject("sec"));

		if (mapAllColumns || columnsToReadMap.get("CD") != null)
			dto.setCd(rs.getString("cd"));

		if (mapAllColumns || columnsToReadMap.get("RS") != null)
			dto.setRs(rs.getString("rs"));

		if (mapAllColumns || columnsToReadMap.get("DESC") != null)
			dto.setDesc(rs.getString("desc"));

		if (mapAllColumns || columnsToReadMap.get("PIVA") != null)
			dto.setPiva(rs.getString("piva"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAziendaDomandaByCodiceFiscaleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAziendaDomandaByCodiceFiscaleDto
	 * @generated
	 */

	public TaifTAziendaDomandaByCodiceFiscaleDto mapRow_internal(TaifTAziendaDomandaByCodiceFiscaleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTAziendaDomandaByCodiceFiscaleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALE") != null)
			dto.setRagioneSociale(rs.getString("ragioneSociale"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONE") != null)
			dto.setDescrizione(rs.getString("descrizione"));

		if (mapAllColumns || columnsToReadMap.get("PIVA") != null)
			dto.setPiva(rs.getString("piva"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROALBO") != null)
			dto.setNumeroAlbo(rs.getString("numeroAlbo"));

		if (mapAllColumns || columnsToReadMap.get("ISCRIZIONEALBO") != null)
			dto.setIscrizioneAlbo(rs.getDate("iscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGETTOGESTORE") != null)
			dto.setIdSogettoGestore((Integer) rs.getObject("idSogettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAziendaDomandaAziendaPraticaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAziendaDomandaAziendaPraticaDto
	 * @generated
	 */

	public TaifTAziendaDomandaAziendaPraticaDto mapRow_internal(TaifTAziendaDomandaAziendaPraticaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTAziendaDomandaAziendaPraticaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALE") != null)
			dto.setRagioneSociale(rs.getString("ragioneSociale"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONE") != null)
			dto.setDescrizione(rs.getString("descrizione"));

		if (mapAllColumns || columnsToReadMap.get("PIVA") != null)
			dto.setPiva(rs.getString("piva"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROALBO") != null)
			dto.setNumeroAlbo(rs.getString("numeroAlbo"));

		if (mapAllColumns || columnsToReadMap.get("ISCRIZIONEALBO") != null)
			dto.setIscrizioneAlbo(rs.getDate("iscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGETTOGESTORE") != null)
			dto.setIdSogettoGestore((Integer) rs.getObject("idSogettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAziendaRicercaAziendaAvanzataDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAziendaRicercaAziendaAvanzataDto
	 * @generated
	 */

	public TaifTAziendaRicercaAziendaAvanzataDto mapRow_internal(TaifTAziendaRicercaAziendaAvanzataDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTAziendaRicercaAziendaAvanzataDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDALBOAPPARTENENZA") != null)
			dto.setIdAlboAppartenenza((Integer) rs.getObject("idAlboAppartenenza"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEAZIENDA") != null)
			dto.setDenominazioneAzienda(rs.getString("denominazioneAzienda"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALEAZIENDA") != null)
			dto.setCodiceFiscaleAzienda(rs.getString("codiceFiscaleAzienda"));

		if (mapAllColumns || columnsToReadMap.get("PIVAAZIENDA") != null)
			dto.setPivaAzienda(rs.getString("pivaAzienda"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROALBO") != null)
			dto.setNumeroAlbo(rs.getString("numeroAlbo"));

		if (mapAllColumns || columnsToReadMap.get("ISCRIZIONEALBO") != null)
			dto.setIscrizioneAlbo(rs.getDate("iscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNESEDE") != null)
			dto.setIstatComuneSede(rs.getString("istatComuneSede"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAziendaRicercaAziendaExportDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAziendaRicercaAziendaExportDto
	 * @generated
	 */

	public TaifTAziendaRicercaAziendaExportDto mapRow_internal(TaifTAziendaRicercaAziendaExportDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTAziendaRicercaAziendaExportDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDALBOAPPARTENENZA") != null)
			dto.setIdAlboAppartenenza((Integer) rs.getObject("idAlboAppartenenza"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEAZIENDA") != null)
			dto.setDenominazioneAzienda(rs.getString("denominazioneAzienda"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALEAZIENDA") != null)
			dto.setCodiceFiscaleAzienda(rs.getString("codiceFiscaleAzienda"));

		if (mapAllColumns || columnsToReadMap.get("PIVAAZIENDA") != null)
			dto.setPivaAzienda(rs.getString("pivaAzienda"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROALBO") != null)
			dto.setNumeroAlbo(rs.getString("numeroAlbo"));

		if (mapAllColumns || columnsToReadMap.get("ISCRIZIONEALBO") != null)
			dto.setIscrizioneAlbo(rs.getDate("iscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNESEDE") != null)
			dto.setIstatComuneSede(rs.getString("istatComuneSede"));

		if (mapAllColumns || columnsToReadMap.get("SIGLAPROVINCIA") != null)
			dto.setSiglaProvincia(rs.getString("siglaProvincia"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROCCIAA") != null)
			dto.setNumeroCciaa(rs.getString("numeroCciaa"));

		if (mapAllColumns || columnsToReadMap.get("ALTRAFORMAGIURIDICA") != null)
			dto.setAltraFormaGiuridica(rs.getString("altraFormaGiuridica"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROSALARIES") != null)
			dto.setNumeroSalaries((Integer) rs.getObject("numeroSalaries"));

		if (mapAllColumns || columnsToReadMap.get("TEMPOINDETERMINATO") != null)
			dto.setTempoIndeterminato(rs.getBigDecimal("tempoIndeterminato"));

		if (mapAllColumns || columnsToReadMap.get("PECAZIENDA") != null)
			dto.setPecAzienda(rs.getString("pecAzienda"));

		if (mapAllColumns || columnsToReadMap.get("MAILAZIENDA") != null)
			dto.setMailAzienda(rs.getString("mailAzienda"));

		if (mapAllColumns || columnsToReadMap.get("SITOWEB") != null)
			dto.setSitoWeb(rs.getString("sitoWeb"));

		if (mapAllColumns || columnsToReadMap.get("SEZIONE") != null)
			dto.setSezione(rs.getString("sezione"));

		if (mapAllColumns || columnsToReadMap.get("DATAISCRIZIONEALBO") != null)
			dto.setDataIscrizioneAlbo(rs.getDate("dataIscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNE") != null)
			dto.setIstatComune(rs.getString("istatComune"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("indirizzo"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("ATTIVITAPRIMARIA") != null)
			dto.setAttivitaPrimaria((Integer) rs.getObject("attivitaPrimaria"));

		if (mapAllColumns || columnsToReadMap.get("ATTIVITASECONDARIA") != null)
			dto.setAttivitaSecondaria((Integer) rs.getObject("attivitaSecondaria"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROBOLLO") != null)
			dto.setNumeroBollo(rs.getString("numeroBollo"));

		if (mapAllColumns || columnsToReadMap.get("ANNOINIZIO") != null)
			dto.setAnnoInizio(rs.getBigDecimal("annoInizio"));

		if (mapAllColumns || columnsToReadMap.get("FATTURATO") != null)
			dto.setFatturato(rs.getBigDecimal("fatturato"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTAziendaIntestazioneRiepilogoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTAziendaIntestazioneRiepilogoDto
	 * @generated
	 */

	public TaifTAziendaIntestazioneRiepilogoDto mapRow_internal(TaifTAziendaIntestazioneRiepilogoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTAziendaIntestazioneRiepilogoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("RAGIONE_SOCIALE") != null)
			dto.setRagioneSocialeAzienda(rs.getString("RAGIONE_SOCIALE"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscaleAzienda(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("PARTITA_IVA") != null)
			dto.setPivaAzienda(rs.getString("PARTITA_IVA"));

		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		if (mapAllColumns || columnsToReadMap.get("STATO_PRATICA_ITA") != null)
			dto.setStatoPraticaItalia(rs.getString("STATO_PRATICA_ITA"));

		if (mapAllColumns || columnsToReadMap.get("STATO_PRATICA_FRA") != null)
			dto.setStatoPraticaFrance(rs.getString("STATO_PRATICA_FRA"));

		return dto;
	}
	
	public TaifTAziendaIntestazioneRiepilogoByPraticaDto mapRow_internal(
			TaifTAziendaIntestazioneRiepilogoByPraticaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTAziendaIntestazioneRiepilogoByPraticaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONESOCIALEAZIENDA") != null)
			dto.setRagioneSocialeAzienda(rs.getString("ragioneSocialeAzienda"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALEAZIENDA") != null)
			dto.setCodiceFiscaleAzienda(rs.getString("codiceFiscaleAzienda"));

		if (mapAllColumns || columnsToReadMap.get("PIVAAZIENDA") != null)
			dto.setPivaAzienda(rs.getString("pivaAzienda"));

		if (mapAllColumns || columnsToReadMap.get("NSIRET") != null)
			dto.setNSiret(rs.getString("nSiret"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICAITALIA") != null)
			dto.setStatoPraticaItalia(rs.getString("statoPraticaItalia"));

		if (mapAllColumns || columnsToReadMap.get("STATOPRATICAFRANCE") != null)
			dto.setStatoPraticaFrance(rs.getString("statoPraticaFrance"));

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTOPRATICA") != null)
			dto.setDataAggiornamentoPratica(rs.getTimestamp("dataAggiornamentoPratica"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("IDSTATOPRATICA") != null)
			dto.setIdStatoPratica((Integer) rs.getObject("idStatoPratica"));

		if (mapAllColumns || columnsToReadMap.get("OPERATORECOGNOME") != null)
			dto.setOperatoreCognome(rs.getString("operatoreCognome"));

		if (mapAllColumns || columnsToReadMap.get("OPERATORENOME") != null)
			dto.setOperatoreNome(rs.getString("operatoreNome"));

		if (mapAllColumns || columnsToReadMap.get("DATAISCRIZIONEALBO") != null)
			dto.setDataIscrizioneAlbo(rs.getDate("dataIscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROISCRIZIONEALBO") != null)
			dto.setNumeroIscrizioneAlbo(rs.getString("numeroIscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROPROTOCOLLO") != null)
			dto.setNumeroProtocollo(rs.getString("numeroProtocollo"));

		if (mapAllColumns || columnsToReadMap.get("DATAPROTOCOLLO") != null)
			dto.setDataProtocollo(rs.getDate("dataProtocollo"));

		return dto;
	}

}
