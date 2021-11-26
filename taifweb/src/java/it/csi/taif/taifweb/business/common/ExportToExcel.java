/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.common;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDCategoriaMezzoByIdTipoMezzoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaConteggioPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazioneFindCertificazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCommercializzazioneByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTDpiDpiByAziendaVisibileDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTLavoroPaLavoroPaByAziendaVisibileDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSedeAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStrutturaFindByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AssortimentoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ProvenienzaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SpecieFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaMisuraFilter;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.business.report.PdfDbManager;
import it.csi.taif.taifweb.exception.ManagerException;

public class ExportToExcel {

	@Autowired
	private TaifMgr taifMgr;

	@Autowired
	private AziendaVisibleFilter aziendaVisibleFilter;

	@Autowired
	private SpecieFilter specieFilter;

	@Autowired
	private ProvenienzaFilter provenienzaFilter;

	@Autowired
	private AssortimentoFilter assortimentoFilter;

	@Autowired
	private UnitaMisuraFilter unitaMisuraFilter;

	@Autowired
	private TipoMezzoFilter tipoMezzoFilter;

	@Autowired
	private DbMgr dbMgr;

	@Autowired
	private ServiceMgr serviceMgr;

	@Autowired
	private PdfDbManager pdfDbManager;

	public ByteArrayOutputStream exportToExcel(List<Integer> listIdAzienda) throws IOException, ManagerException {
		// public void exportToExcel(List<Integer> listIdAzienda) throws IOException,
		// ManagerException {

		final String[] columnsDatiGen = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione", "Partita IVA",
				"Data Iscrizione Albo", "Stato Pratica ", "Sigla Provincia", "Numero CCIAA", "Forma Giuridica",
				"Descrizione Altra Forma Giuridica", "Totale addetti", "Totale addetti a tempo indeterminato", "Pec",
				"E-mail di contatto", "Sito Internet", "Attività primaria", "Attività secondaria",
				"Numero identificativo marca da bollo", "Anno inizio attività", "Fatturato", "Comune Sede Legale",
				"Indirizzo Sede Legale", "Civico Sede Legale", "Cap Sede Legale", "Telefono", "Sezione",
				"Codice Fiscale Titolare", "Cognome Titolare", "Nome Titolare", "Data nascita Titolare",
				" Comune di residenza Titolare", "Indirizzo Titolare ", "Civico", "Cap", "Telefono", "Cellulare",
				"eMail Titolare", "Titolo di Studio", " Altri titoli ", "Formazione forestale Titolare", "Qualifiche Titolare","Riconoscimenti Titolare",
				"Codice fiscale Conduttore", "Cognome Conduttore", "Nome Conduttore", "Data nascita Conduttore",
				"Comune nascita Conduttore", "Indirizzo", "Numero civico", "Cap", "Telefono Conduttore",
				"Cellulare Conduttore", "eMail", "Titolo studio", "Altri titoli studio", "Formazione forestale","Qualifiche","Riconoscimenti" };

		final String[] columnsDatiGenRistretto = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Sigla Provincaia", "Numero CCIAA", "Descrizione Altra Forma Giuridica", "Totale addetti",
				"Totale addetti a tempo indeterminato", "Pec", "E-mail di contatto", "Sito Internet",
				"Comune Sede Legale", "Indirizzo Sede Legale", "Civico Sede Legale", "Cap Sede Legale", "Telefono",
				"Sezione", "Data Iscrizione Albo" };

		final String[] columnsSedeOperativa = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Indirizzo Sede Operativa", "Civico Sede Operativa", "Cap Sede Operativa", "Comune Sede Operativa" };

		final String[] columnsCategoriaImpresa = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Categoria", "Descrizione altra categoria" };

		final String[] columnsAltriAlbi = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione", "Nome altro Albo",
				"Numero", " Data iscrizione" };

		final String[] columnsAssociazioni = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Tipo Associazione", "Nome Associazione" };

		final String[] columnsCertificazioni = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Tipo Certificazione", "Numero ", "Ente certificatore", "Anno rilascio", "Data Scadenza",
				"Descrizione altra certificazione" };

		final String[] columnsAttivitaSvolta = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Attività svolta", "Percentuale su fatturato totale" };

		final String[] columnsLavoriPa = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione", "Committente",
				"Interventi", "Importo lavori" };

		final String[] columnsCommercio = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione", "Specie",
				"Provenienza", "Destinazione", "Assortimento", "T/A", "Venduto medio annuo", "UdM" };

		final String[] columnsStrutture = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione", "Tipo struttura",
				"Funzione", "Dimensione", "Anno construzione" };

		final String[] columnsDPI = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione", "DPI", "Tipologia",
				"Quantita", "Anno scadenza" };

		final String[] columnsMacchineRidotta = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Categoria Macchina", "Tipo macchina" };

		final String[] columnsMacchine = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Categoria Macchina", "Tipo macchina", "Anno immatriculazione", "Potenza", "Trazione", "Alimentazione",
				"Portata", "Carrello", "Commandato a distanza", "Di proprieta" };

		final String[] columnsPersonale = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Codice fiscale Addetto", "Nome Addetto", "Cognome Addetto ", "Tipologia personale Addetto ",
				"Mansione", "Contratto", "Durata Contratto", "GG/AAAA det", "Inquadramento", "Altri studi",
				"Formazione forestale","Qualifiche","Riconoscimenti" };

		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();

		makeDatiGenerali(listIdAzienda, columnsDatiGen, workbook, createHelper, "Dati Generali");
		makeSedeOperativa(listIdAzienda, columnsSedeOperativa, workbook, createHelper, "Sedi Operative");
		makeCategorieImpresa(listIdAzienda, columnsCategoriaImpresa, workbook, createHelper, "Categorie di impresa");
		makeAltriAlbi(listIdAzienda, columnsAltriAlbi, workbook, createHelper, "Altri Albi");
		makeAssociazioni(listIdAzienda, columnsAssociazioni, workbook, createHelper, "Associazioni");
		makeCertificazioni(listIdAzienda, columnsCertificazioni, workbook, createHelper, "Certificazioni");
		makeAttivitaSvolte(listIdAzienda, columnsAttivitaSvolta, workbook, createHelper, "Attivita Svolte");
		makeLavoroPublicaAdmin(listIdAzienda, columnsLavoriPa, workbook, createHelper, "Lavori PA");
		makeCommercio(listIdAzienda, columnsCommercio, workbook, createHelper, "Commercio");
		makeStrutture(listIdAzienda, columnsStrutture, workbook, createHelper, "Strutture");
		makeDpi(listIdAzienda, columnsDPI, workbook, createHelper, "DPI");
		makeMacchine(listIdAzienda, columnsMacchine, workbook, createHelper, "Macchine");
		makePersonale(listIdAzienda, columnsPersonale, workbook, createHelper, "Personale");

		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			workbook.write(baos);
			baos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");

		return baos;
		/*
		 * try { FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
		 * workbook.write(outputStream); outputStream.close(); } catch
		 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
		 * e.printStackTrace(); } System.out.println("Done");
		 */
	}

	private void makeDatiGenerali(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {
		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);

		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy"));
		// Create Other rows and cells with employees data
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {

			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			String statoPraticaDto = taifMgr.getStatoPratica(pratichePerAzienda.getIdPratica());
			TaifTSedeAziendaByIdAziendaDto sedeLegale = taifMgr.getSedeLegalePerIdAzienda(idAzienda);
			TaifTPersonaByIdAziendaDto rappLegale = taifMgr.getLegaleRappresentanteConduttore(idAzienda, 1);
			List<TaifRPersonaAziendaConteggioPersonaDto> conteggioPersonePerAzienda = taifMgr
					.conteggioNumeroAddettiByIdAzienda(String.valueOf(idAzienda));
			int personeTempoDett = pdfDbManager.getPersoneLavoroDettPerIdAzienda(idAzienda);
			String formazioneF = null;
			String qualificaF = null;
			String riconiscimentiF = null;
			if (rappLegale != null) {
				formazioneF = pdfDbManager.findCorsiPerPersona(rappLegale.getIdPersona());
				qualificaF = pdfDbManager.findQualifichePerPersona(rappLegale.getIdPersona());
				riconiscimentiF = pdfDbManager.findRiconoscimentiPerPersona(rappLegale.getIdPersona());
			}

			TaifTPersonaByIdAziendaDto rappLegaleC = taifMgr.getLegaleRappresentanteConduttore(idAzienda, 2);

			int i = 0;
			Row row = sheet.createRow(rowNum++);
			row.createCell(i++).setCellValue(String
					.valueOf((taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore())).getCodice()));
			row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
			row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
			row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
			if ((taifTAziendaDto.getPartitaIva() != null)) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getPartitaIva());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if ((pratichePerAzienda.getDataInscrizioneAlbo() != null)) {
				row.createCell(i++).setCellValue(sdf.format(pratichePerAzienda.getDataInscrizioneAlbo()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if ((statoPraticaDto != null)) {
				row.createCell(i++).setCellValue(statoPraticaDto);
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if ((pratichePerAzienda.getIdSoggettoGestore() != null)) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getCciaaSiglaProv());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (taifTAziendaDto.getCciaaNumero() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getCciaaNumero());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getFkFormaGiuridicaIta() != null) {
				row.createCell(i++)
						.setCellValue(pdfDbManager.getFormaGiuridica(taifTAziendaDto.getFkFormaGiuridicaIta()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getDescrAltraFormaGiuridica() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getDescrAltraFormaGiuridica());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (conteggioPersonePerAzienda != null) {
				row.createCell(i++).setCellValue(String.valueOf(conteggioPersonePerAzienda.get(0).getConteggio()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			row.createCell(i++).setCellValue(String.valueOf(personeTempoDett));
			if (taifTAziendaDto.getPec() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getPec());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getEmail() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getEmail());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getSitoWeb() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getSitoWeb());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getFkAttivitaPrimaria() != null) {
				row.createCell(i++).setCellValue(taifMgr.getAttivitaAteco(taifTAziendaDto.getFkAttivitaPrimaria()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getFkAttivitaSecondaria() != null) {
				row.createCell(i++).setCellValue(taifMgr.getAttivitaAteco(taifTAziendaDto.getFkAttivitaSecondaria()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (taifTAziendaDto.getNMarcaBollo() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getNMarcaBollo());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getAnnoInizio() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getAnnoInizio().toString());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getFatturato() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getFatturato().toString());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (sedeLegale.getIstatComune() != null) {
				row.createCell(i++).setCellValue(taifMgr.getComuneByIstat(sedeLegale.getIstatComune()).getNome());
				// row.createCell(i++).setCellValue(sedeLegale.getIstatComune());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (sedeLegale.getIndirizzo() != null) {
				row.createCell(i++).setCellValue(sedeLegale.getIndirizzo());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (sedeLegale.getCivico() != null) {
				row.createCell(i++).setCellValue(sedeLegale.getCivico());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (sedeLegale.getCap() != null) {
				row.createCell(i++).setCellValue(sedeLegale.getCap());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (sedeLegale.getTelefon() != null) {
				row.createCell(i++).setCellValue(sedeLegale.getTelefon());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (pratichePerAzienda.getFlagSezione() != null) {
				row.createCell(i++).setCellValue(pratichePerAzienda.getFlagSezione());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			// rappLegale

			if (rappLegale.getCodiceFiscale() != null) {
				row.createCell(i++).setCellValue(rappLegale.getCodiceFiscale());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getCognome() != null) {
				row.createCell(i++).setCellValue(rappLegale.getCognome());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getNome() != null) {
				row.createCell(i++).setCellValue(rappLegale.getNome());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getDataNascita() != null) {
				row.createCell(i++).setCellValue(sdf.format(rappLegale.getDataNascita()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getIstatComuneresidenza() != null) {
				row.createCell(i++)
						.setCellValue(taifMgr.getComuneByIstat(rappLegale.getIstatComuneresidenza()).getNome());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getIndirizzoResidenza() != null) {
				row.createCell(i++).setCellValue(rappLegale.getIndirizzoResidenza());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getCivico() != null) {
				row.createCell(i++).setCellValue(rappLegale.getCivico());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getCap() != null) {
				row.createCell(i++).setCellValue(rappLegale.getCap());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getTelefono() != null) {
				row.createCell(i++).setCellValue(rappLegale.getTelefono());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getCellulare() != null) {
				row.createCell(i++).setCellValue(rappLegale.getCellulare());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getMail() != null) {
				row.createCell(i++).setCellValue(rappLegale.getMail());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (rappLegale.getIdTitolo() != null) {
				row.createCell(i++).setCellValue(pdfDbManager.getTitoloStudio(rappLegale.getIdTitolo()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (rappLegale.getAStudi() != null) {
				row.createCell(i++).setCellValue(rappLegale.getAStudi());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (StringUtils.isNotEmpty(formazioneF)) {
				row.createCell(i++).setCellValue(formazioneF);
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (StringUtils.isNotEmpty(qualificaF)) {
				row.createCell(i++).setCellValue(qualificaF);
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (StringUtils.isNotEmpty(riconiscimentiF)) {
				row.createCell(i++).setCellValue(riconiscimentiF);
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			// conduttore
			// rappLegale
			if (rappLegaleC.getCodiceFiscale() != null) {

				String formazioneFC = pdfDbManager.findCorsiPerPersona(rappLegaleC.getIdPersona());
				String qualificaFC = pdfDbManager.findQualifichePerPersona(rappLegaleC.getIdPersona());
				String riconoscimentiFC = pdfDbManager.findRiconoscimentiPerPersona(rappLegaleC.getIdPersona());

				if (rappLegaleC.getCodiceFiscale() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getCodiceFiscale());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getCognome() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getCognome());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getNome() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getNome());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getDataNascita() != null) {
					row.createCell(i++).setCellValue(sdf.format(rappLegaleC.getDataNascita()));
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getIstatComuneresidenza() != null) {
					row.createCell(i++).setCellValue(
							pdfDbManager.getComuneFromIstat(rappLegaleC.getIstatComuneresidenza()).getNome());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getIndirizzoResidenza() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getIndirizzoResidenza());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getCivico() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getCivico());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getCap() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getCap());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getTelefono() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getTelefono());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getCellulare() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getCellulare());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getMail() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getMail());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}

				if (rappLegaleC.getIdTitolo() != null) {
					row.createCell(i++).setCellValue(pdfDbManager.getTitoloStudio(rappLegaleC.getIdTitolo()));
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getAStudi() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getAStudi());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (StringUtils.isNotEmpty(formazioneFC)) {
					row.createCell(i++).setCellValue(formazioneFC);
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (StringUtils.isNotEmpty(qualificaFC)) {
					row.createCell(i++).setCellValue(qualificaFC);
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (StringUtils.isNotEmpty(riconoscimentiFC)) {
					row.createCell(i++).setCellValue(riconoscimentiFC);
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
			}

		}
	}

	private void makeSedeOperativa(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {

			List<TaifTSedeAziendaByIdAziendaDto> sedeAzienda = taifMgr.getSedePerIdAzienda(idAzienda);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			for (TaifTSedeAziendaByIdAziendaDto sedeOperativa : sedeAzienda) {
				int k = 0;
				Row row = sheet.createRow(rowNum++);

				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(k++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(k++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(k++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(k++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(k++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(k++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(k++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(k++).setCellValue(Constants.blank);
				}
				if (sedeOperativa.getIndirizzo() != null) {
					row.createCell(k++).setCellValue(sedeOperativa.getIndirizzo());
				} else {
					row.createCell(k++).setCellValue(Constants.blank);
				}
				if (sedeOperativa.getCivico() != null) {
					row.createCell(k++).setCellValue(sedeOperativa.getCivico());
				} else {
					row.createCell(k++).setCellValue(Constants.blank);
				}
				if (sedeOperativa.getCap() != null) {
					row.createCell(k++).setCellValue(sedeOperativa.getCap());
				} else {
					row.createCell(k++).setCellValue(Constants.blank);
				}
				if (sedeOperativa.getIstatComune() != null) {
					row.createCell(k++)
							.setCellValue(pdfDbManager.getComuneFromIstat(sedeOperativa.getIstatComune()).getNome());
					// row.createCell(k++).setCellValue(sedeOperativa.getIstatComune());
				} else {
					row.createCell(k++).setCellValue(Constants.blank);
				}
				k++;
			}
		}

	}

	private void makeCategorieImpresa(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		AziendaVisibleFilter aziendaVisibleFilter = setAziendaVisibleFilter();

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			aziendaVisibleFilter.setIdAzienda(idAzienda);
			List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> aziendaCategoria = taifMgr
					.findCategoriaImpresaByIdAzienda(aziendaVisibleFilter);
			if (aziendaCategoria.size() > 0) {
				for (TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto taifRAziendaCategImpresa : aziendaCategoria) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);
					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					row.createCell(i++).setCellValue(taifRAziendaCategImpresa.getCategoriaImpresa());
					if (taifRAziendaCategImpresa.getAziendaCategImpresa() != null) {
						row.createCell(i++).setCellValue(taifRAziendaCategImpresa.getAziendaCategImpresa());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
			}
		}

	}

	private void makeAltriAlbi(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int i = 0;
			Row row = sheet.createRow(rowNum++);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTPraticaByIdAziendaDto altrePratichePerAzienda = taifMgr.altrePratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);
			if (pratichePerAzienda.getIdSoggettoGestore() != null) {
				row.createCell(i++).setCellValue(String.valueOf(
						taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (pratichePerAzienda.getNrAlbo() != null) {
				row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getCodiceFiscale() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getRagioneSociale() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (altrePratichePerAzienda != null) {
				if (altrePratichePerAzienda.getDenominazioneAltroAlbo() != null) {
					row.createCell(i++).setCellValue(altrePratichePerAzienda.getDenominazioneAltroAlbo());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (altrePratichePerAzienda.getNrAlbo() != null) {
					row.createCell(i++).setCellValue(altrePratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}

				if (altrePratichePerAzienda.getDataInscrizioneAlbo() != null) {
					row.createCell(i++).setCellValue(sdf.format(altrePratichePerAzienda.getDataInscrizioneAlbo()));
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
			}
		}
	}

	private void makeAssociazioni(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;
		AziendaVisibleFilter aziendaVisibleFilter = setAziendaVisibleFilter();
		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			aziendaVisibleFilter.setIdAzienda(idAzienda);
			List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> associazioniList = taifMgr
					.findAssociazioneByIdAzienda(aziendaVisibleFilter);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			if (associazioniList.size() > 0) {
				for (TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto associazione : associazioniList) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);

					aziendaVisibleFilter.setIdAzienda(taifTAziendaDto.getIdAzienda());

					SimpleDateFormat sdf = new SimpleDateFormat();
					sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);

					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (associazione.getIdAssociazione() != null) {
						row.createCell(i++).setCellValue(
								pdfDbManager.getDescrizioneAssociazioneImpresa(associazione.getIdAssociazione()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (associazione.getNomeAltraAssociazione() != null) {
						row.createCell(i++).setCellValue(associazione.getNomeAltraAssociazione());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
			}
		}
	}

	private void makeCertificazioni(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		AziendaVisibleFilter aziendaVisibleFilter = setAziendaVisibleFilter();
		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			aziendaVisibleFilter.setIdAzienda(idAzienda);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> certificazioniList = taifMgr
					.findCertificazioniByIdAzienda(aziendaVisibleFilter);
			if (certificazioniList.size() > 0) {
				for (TaifTCertificazioneFindCertificazioniByIdAziendaDto certificazione : certificazioniList) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);

					SimpleDateFormat sdf = new SimpleDateFormat();
					sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);

					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (certificazione.getTipoCertificazione() != null) {
						row.createCell(i++).setCellValue(certificazione.getTipoCertificazione());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (certificazione.getNumeroCertificazione() != null) {
						row.createCell(i++).setCellValue(certificazione.getNumeroCertificazione());
						;
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (certificazione.getEnteCertificatore() != null) {
						row.createCell(i++).setCellValue(certificazione.getEnteCertificatore());
						;
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (certificazione.getAnnoCertificazione() != null) {
						row.createCell(i++).setCellValue(String.valueOf(certificazione.getAnnoCertificazione()));
						;
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (certificazione.getDataScadenza() != null) {
						row.createCell(i++).setCellValue(sdf.format(certificazione.getDataScadenza()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (certificazione.getAltraCertificazione() != null) {
						row.createCell(i++).setCellValue(certificazione.getAltraCertificazione());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
			}
		}
	}

	private void makeAttivitaSvolte(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		AziendaVisibleFilter aziendaVisibleFilter = setAziendaVisibleFilter();
		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			aziendaVisibleFilter.setIdAzienda(idAzienda);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaSvoltaList = taifMgr
					.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
			if (attivitaSvoltaList.size() > 0) {
				for (TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto attivitaSvolta : attivitaSvoltaList) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);
					SimpleDateFormat sdf = new SimpleDateFormat();
					sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);

					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (attivitaSvolta.getTipoAttivita() != null) {
						row.createCell(i++).setCellValue(attivitaSvolta.getTipoAttivita());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (attivitaSvolta.getFatturato() != null) {
						row.createCell(i++).setCellValue(String.valueOf(attivitaSvolta.getFatturato()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
			}
		}
	}

	private void makeLavoroPublicaAdmin(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		AziendaVisibleFilter aziendaVisibleFilter = setAziendaVisibleFilter();
		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			aziendaVisibleFilter.setIdAzienda(idAzienda);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			List<TaifTLavoroPaLavoroPaByAziendaVisibileDto> lavoriPAList = taifMgr
					.findLavoroPaByIdAzienda(aziendaVisibleFilter);
			if (lavoriPAList.size() > 0) {
				for (TaifTLavoroPaLavoroPaByAziendaVisibileDto lavoroPA : lavoriPAList) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);
					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (lavoroPA.getCommitente() != null) {
						row.createCell(i++).setCellValue(lavoroPA.getCommitente());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (lavoroPA.getTipoLavoro() != null) {
						row.createCell(i++).setCellValue(lavoroPA.getTipoLavoro());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (lavoroPA.getImporto() != null) {
						row.createCell(i++).setCellValue(lavoroPA.getImporto().floatValue());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}

			}
		}
	}

	private void makeCommercio(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		aziendaVisibleFilter = setAziendaVisibleFilter();
		specieFilter = setSpecieFilter();
		assortimentoFilter = setAssortimentoFilter();
		provenienzaFilter = setProvenienzaFilter();
		unitaMisuraFilter = setUnitaMisuraFilter();

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			aziendaVisibleFilter.setIdAzienda(idAzienda);

			List<TaifTCommercializzazioneByAziendaDto> commercioList = taifMgr
					.findCommerciallizazioneByIdAzienda(idAzienda);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			if (commercioList.size() > 0) {
				for (TaifTCommercializzazioneByAziendaDto commercio : commercioList) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);

					specieFilter.setIdSpecie(commercio.getIdSpecie());
					assortimentoFilter.setIdAssortimento(commercio.getIdAssortimento());
					unitaMisuraFilter.setIdUnitaMisura(commercio.getIdUnMis());

					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (commercio.getIdSpecie() != null) {
						row.createCell(i++).setCellValue(taifMgr.findSpecieByIdSpecieVisible(specieFilter));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					provenienzaFilter.setIdProvenienza(commercio.getIdProvenienza());
					if (commercio.getIdProvenienza() != null) {
						row.createCell(i++)
								.setCellValue(taifMgr.findProvenienzaByIdProvenienzaVisible(provenienzaFilter));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					provenienzaFilter.setIdProvenienza(commercio.getIdDestinazione());
					if (commercio.getIdDestinazione() != null) {
						row.createCell(i++)
								.setCellValue(taifMgr.findProvenienzaByIdProvenienzaVisible(provenienzaFilter));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (commercio.getIdAssortimento() != null) {
						row.createCell(i++)
								.setCellValue(taifMgr.findAssortimentoByIdAssortimentoVisible(assortimentoFilter));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (commercio.getFlgTagliato() != null) {
						row.createCell(i++).setCellValue(commercio.getFlgTagliato());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (commercio.getVendutoMedio() != null) {
						row.createCell(i++).setCellValue(commercio.getVendutoMedio().floatValue());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifMgr.findCommUmByIdUnitaMisuraVisible(unitaMisuraFilter) != null) {
						row.createCell(i++).setCellValue(taifMgr.findCommUmByIdUnitaMisuraVisible(unitaMisuraFilter));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}

			}
		}
	}

	private void makeStrutture(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		aziendaVisibleFilter = setAziendaVisibleFilter();

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			aziendaVisibleFilter.setIdAzienda(idAzienda);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			// List<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto> struttureList =
			// taifMgr
			// .findFindFunzioneTipoStrutturaByIdAzienda(aziendaVisibleFilter);
			List<TaifTStrutturaFindByAziendaDto> allStruttureByAzienda = pdfDbManager
					.getStrutture(taifTAziendaDto.getIdAzienda());
			if (allStruttureByAzienda.size() > 0) {
				for (TaifTStrutturaFindByAziendaDto struttura : allStruttureByAzienda) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);

					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (struttura.getId() != null) {
						row.createCell(i++)
								.setCellValue(pdfDbManager.getTipoStruttureFromFunzioneStruttura(struttura.getFunz()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (struttura.getFunz() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getFunzioneCapannone(struttura.getFunz()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (struttura.getDim() != null) {
						row.createCell(i++).setCellValue(struttura.getDim());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (struttura.getAnno() != null) {
						row.createCell(i++).setCellValue(String.valueOf(struttura.getAnno()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}

			}
		}
	}

	private void makeDpi(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		aziendaVisibleFilter = setAziendaVisibleFilter();

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			aziendaVisibleFilter.setIdAzienda(idAzienda);

			// List<TaifTDpiDpiByAziendaVisibileDto> dpiList =
			// taifMgr.findDpiByAziendaVisibile(aziendaVisibleFilter);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			List<TaifTDpiDpiByAziendaVisibileDto> allDispositiviByAzienda = pdfDbManager
					.getDispositiviProtezione(aziendaVisibleFilter);
			if (!(allDispositiviByAzienda.isEmpty())) {
				for (TaifTDpiDpiByAziendaVisibileDto dispositivi : allDispositiviByAzienda) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);

					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (dispositivi.getTipoDpi() != null) {
						row.createCell(i++).setCellValue(dispositivi.getTipoDpi());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (dispositivi.getTipologia() != null) {
						row.createCell(i++).setCellValue(dispositivi.getTipologia());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (dispositivi.getQuantita() != null) {
						row.createCell(i++).setCellValue(dispositivi.getQuantita());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (dispositivi.getAnnoScadenza() != null) {
						row.createCell(i++).setCellValue(String.valueOf(dispositivi.getAnnoScadenza()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}

			}
		}
	}

	private void makeMacchine(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		tipoMezzoFilter = setTipoMezzoFilter();

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			tipoMezzoFilter.setIdAzienda(idAzienda);
			List<TaifTMezzoByIdAziendaDto> allMacchineMezziByAzienda = pdfDbManager.getMacchineMezzi(idAzienda);
			// List<TaifTMezzoByTipoMezzoAziendaVisibileDto> mezziList = taifMgr
			// .findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			if (allMacchineMezziByAzienda.size() > 0) {
				for (TaifTMezzoByIdAziendaDto mezzoUsato : allMacchineMezziByAzienda) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);

					tipoMezzoFilter.setIdTipoMezzo(mezzoUsato.getIdTipoMezzo());

					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					List<TaifDCategoriaMezzoByIdTipoMezzoDto> categoriaMezzoByIdMezzo = taifMgr
							.findTipoECategoriaByIdTipoMezzo(tipoMezzoFilter);
					if (categoriaMezzoByIdMezzo != null) {
						row.createCell(i++).setCellValue(categoriaMezzoByIdMezzo.get(0).getCat());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (mezzoUsato.getIdTipoMezzo() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getTipoMezzoById(mezzoUsato.getIdTipoMezzo()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (mezzoUsato.getAnno() != null) {
						row.createCell(i++).setCellValue(String.valueOf(mezzoUsato.getAnno()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (mezzoUsato.getPotenza() != null) {
						row.createCell(i++).setCellValue(String.valueOf(mezzoUsato.getPotenza()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (mezzoUsato.getIdTipoTrazione() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getTipoTrazione(mezzoUsato.getIdTipoTrazione()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (mezzoUsato.getIdAlimentazione() != null) {
						row.createCell(i++).setCellValue(
								pdfDbManager.getTipoAllimentazioneMezzoById(mezzoUsato.getIdAlimentazione()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (mezzoUsato.getPortata() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getTipoCarelloById(mezzoUsato.getPortata()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (mezzoUsato.getIdTipoCarrel() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getTipoCarelloById(mezzoUsato.getIdTipoCarrel()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (mezzoUsato.getComando() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getNoleggio(mezzoUsato.getComando().intValue()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (mezzoUsato.getNoleggio() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getNoleggio(mezzoUsato.getNoleggio().intValue()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}

			}
		}
	}

	private void makePersonale(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		tipoMezzoFilter = setTipoMezzoFilter();

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;
		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			// List<TaifRPersonaAziendaByIdAziendaDto> listPersonePerIdAzienda = taifMgr
			// .getPersonePerIdAzienda(idAzienda);
			List<TaifTPersonaByIdAziendaDto> alPersonePerAzienda = pdfDbManager
					.getPersonePerAzienda(taifTAziendaDto.getIdAzienda());
			if (alPersonePerAzienda.size() > 0) {
				for (TaifTPersonaByIdAziendaDto personeAzienda : alPersonePerAzienda) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);
					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					// persone non rappLegale e non conduttore

					if (personeAzienda.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(personeAzienda.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (personeAzienda.getNome() != null) {
						row.createCell(i++).setCellValue(personeAzienda.getNome());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (personeAzienda.getCognome() != null) {
						row.createCell(i++).setCellValue(personeAzienda.getCognome());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (personeAzienda.getIdRuoloPersona() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getRuolo(personeAzienda.getIdRuoloPersona()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (personeAzienda.getIdTipoMansione() != null) {
						row.createCell(i++)
								.setCellValue(pdfDbManager.getTipoMansione(personeAzienda.getIdTipoMansione()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (personeAzienda.getIdTipoContratto() != null) {
						row.createCell(i++)
								.setCellValue(pdfDbManager.getTipoContratto(personeAzienda.getIdTipoContratto()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (personeAzienda.getFlagTenpoDeterminato() != null) {
						row.createCell(i++).setCellValue(
								pdfDbManager.getFlagTempoDett(personeAzienda.getFlagTenpoDeterminato().intValue()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (personeAzienda.getGiorniTempoDeterminato() != null) {
						row.createCell(i++).setCellValue(personeAzienda.getGiorniTempoDeterminato());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (personeAzienda.getIdTipoInquadramento() != null) {
						row.createCell(i++).setCellValue(
								pdfDbManager.getTipoInquadramento(personeAzienda.getIdTipoInquadramento()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (personeAzienda.getAStudi() != null) {
						row.createCell(i++).setCellValue(personeAzienda.getAStudi());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					String formazioneF = pdfDbManager.findCorsiPerPersona(personeAzienda.getIdPersona());
					if (formazioneF != null) {
						row.createCell(i++).setCellValue(formazioneF);
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}

			}
		}
	}

	public ByteArrayOutputStream exportToExcelRidotto(List<Integer> listIdAzienda)
			throws IOException, ManagerException {
		// public void exportToExcel(List<Integer> listIdAzienda) throws IOException,
		// ManagerException {

		final String[] columnsDatiGenRidotti = { "Albo", "Numero Albo", "Denominazione", "Partita IVA",
				"Data Iscrizione Albo", "Stato Pratica ", "Forma Giuridica", "Descrizione Altra Forma Giuridica",
				"Totale addetti", "Totale addetti a tempo indeterminato", "Pec", "E-mail di contatto", "Sito Internet",
				"Comune Sede Legale", "Indirizzo Sede Legale", "Civico Sede Legale", "Cap Sede Legale", "Telefono",
				"Sezione", "Cognome Titolare", "Nome Titolare", "Formazione forestale Titolare" ,"Qualifiche Titolare","Riconoscimenti Titolare", "Cognome Conduttore",
				"Nome Conduttore", "Formazione forestale","Qualifiche","Riconoscimenti" };

		final String[] columnsSedeOperativa = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Indirizzo Sede Operativa", "Civico Sede Operativa", "Cap Sede Operativa", "Comune Sede Operativa" };

		final String[] columnsCategoriaImpresa = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Categoria", "Descrizione altra categoria" };

		final String[] columnsAltriAlbi = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione", "Nome altro Albo",
				"Numero", " Data iscrizione" };

		final String[] columnsCertificazioni = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Tipo Certificazione", "Numero ", "Ente certificatore", "Anno rilascio", "Data Scadenza",
				"Descrizione altra certificazione" };

		final String[] columnsAttivitaSvolta = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Attività svolta", "Percentuale su fatturato totale" };

		final String[] columnsMacchineRidotta = { "Albo", "Numero Albo", "Codice Fiscale", "Denominazione",
				"Categoria Macchina", "Tipo macchina" };

		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();

		makeDatiGeneraliRidotti(listIdAzienda, columnsDatiGenRidotti, workbook, createHelper, "Dati Generali");
		makeSedeOperativa(listIdAzienda, columnsSedeOperativa, workbook, createHelper, "Sedi Operative");
		makeCategorieImpresa(listIdAzienda, columnsCategoriaImpresa, workbook, createHelper, "Categorie di impresa");
		makeAltriAlbi(listIdAzienda, columnsAltriAlbi, workbook, createHelper, "Altri Albi");
		makeCertificazioni(listIdAzienda, columnsCertificazioni, workbook, createHelper, "Certificazioni");
		makeAttivitaSvolte(listIdAzienda, columnsAttivitaSvolta, workbook, createHelper, "Attivita Svolte");
		makeMacchineRidotte(listIdAzienda, columnsMacchineRidotta, workbook, createHelper, "Macchine");

		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			workbook.write(baos);
			baos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");

		return baos;

	}
	
	private void makeDatiGeneraliRidotti(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {
		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);

		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy"));
		// Create Other rows and cells with employees data
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {

			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			String statoPraticaDto = taifMgr.getStatoPratica(pratichePerAzienda.getIdPratica());
			TaifTSedeAziendaByIdAziendaDto sedeLegale = taifMgr.getSedeLegalePerIdAzienda(idAzienda);
			TaifTPersonaByIdAziendaDto rappLegale = taifMgr.getLegaleRappresentanteConduttore(idAzienda, 1);
			List<TaifRPersonaAziendaConteggioPersonaDto> conteggioPersonePerAzienda = taifMgr
					.conteggioNumeroAddettiByIdAzienda(String.valueOf(idAzienda));
			int personeTempoDett = pdfDbManager.getPersoneLavoroDettPerIdAzienda(idAzienda);
			String formazioneF = null;
			String qualificaF = null;
			String riconiscimentiF = null;
			if (rappLegale != null) {
				formazioneF = pdfDbManager.findCorsiPerPersona(rappLegale.getIdPersona());
				qualificaF = pdfDbManager.findQualifichePerPersona(rappLegale.getIdPersona());
				riconiscimentiF = pdfDbManager.findRiconoscimentiPerPersona(rappLegale.getIdPersona());
			}
			TaifTPersonaByIdAziendaDto rappLegaleC = taifMgr.getLegaleRappresentanteConduttore(idAzienda, 2);

			int i = 0;
			Row row = sheet.createRow(rowNum++);
			row.createCell(i++).setCellValue(String
					.valueOf((taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore())).getCodice()));
			row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
			//row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
			row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
			if ((taifTAziendaDto.getPartitaIva() != null)) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getPartitaIva());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if ((pratichePerAzienda.getDataInscrizioneAlbo() != null)) {
				row.createCell(i++).setCellValue(sdf.format(pratichePerAzienda.getDataInscrizioneAlbo()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if ((statoPraticaDto != null)) {
				row.createCell(i++).setCellValue(statoPraticaDto);
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

//			if ((pratichePerAzienda.getIdSoggettoGestore() != null)) {
//				row.createCell(i++).setCellValue(taifTAziendaDto.getCciaaSiglaProv());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}

//			if (taifTAziendaDto.getCciaaNumero() != null) {
//				row.createCell(i++).setCellValue(taifTAziendaDto.getCciaaNumero());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
			if (taifTAziendaDto.getFkFormaGiuridicaIta() != null) {
				row.createCell(i++)
						.setCellValue(pdfDbManager.getFormaGiuridica(taifTAziendaDto.getFkFormaGiuridicaIta()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getDescrAltraFormaGiuridica() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getDescrAltraFormaGiuridica());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (conteggioPersonePerAzienda != null) {
				row.createCell(i++).setCellValue(String.valueOf(conteggioPersonePerAzienda.get(0).getConteggio()));
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			row.createCell(i++).setCellValue(String.valueOf(personeTempoDett));
			if (taifTAziendaDto.getPec() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getPec());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getEmail() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getEmail());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (taifTAziendaDto.getSitoWeb() != null) {
				row.createCell(i++).setCellValue(taifTAziendaDto.getSitoWeb());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
//			if (taifTAziendaDto.getFkAttivitaPrimaria() != null) {
//				row.createCell(i++).setCellValue(taifMgr.getAttivitaAteco(taifTAziendaDto.getFkAttivitaPrimaria()));
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (taifTAziendaDto.getFkAttivitaSecondaria() != null) {
//				row.createCell(i++).setCellValue(taifMgr.getAttivitaAteco(taifTAziendaDto.getFkAttivitaSecondaria()));
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//
//			if (taifTAziendaDto.getNMarcaBollo() != null) {
//				row.createCell(i++).setCellValue(taifTAziendaDto.getNMarcaBollo());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (taifTAziendaDto.getAnnoInizio() != null) {
//				row.createCell(i++).setCellValue(taifTAziendaDto.getAnnoInizio().toString());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (taifTAziendaDto.getFatturato() != null) {
//				row.createCell(i++).setCellValue(taifTAziendaDto.getFatturato().toString());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}

			if (sedeLegale.getIstatComune() != null) {
				row.createCell(i++).setCellValue(taifMgr.getComuneByIstat(sedeLegale.getIstatComune()).getNome());
				// row.createCell(i++).setCellValue(sedeLegale.getIstatComune());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			if (sedeLegale.getIndirizzo() != null) {
				row.createCell(i++).setCellValue(sedeLegale.getIndirizzo());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (sedeLegale.getCivico() != null) {
				row.createCell(i++).setCellValue(sedeLegale.getCivico());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (sedeLegale.getCap() != null) {
				row.createCell(i++).setCellValue(sedeLegale.getCap());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (sedeLegale.getTelefon() != null) {
				row.createCell(i++).setCellValue(sedeLegale.getTelefon());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (pratichePerAzienda.getFlagSezione() != null) {
				row.createCell(i++).setCellValue(pratichePerAzienda.getFlagSezione());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}

			// rappLegale

//			if (rappLegale.getCodiceFiscale() != null) {
//				row.createCell(i++).setCellValue(rappLegale.getCodiceFiscale());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
			if (rappLegale.getCognome() != null) {
				row.createCell(i++).setCellValue(rappLegale.getCognome());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (rappLegale.getNome() != null) {
				row.createCell(i++).setCellValue(rappLegale.getNome());
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
//			if (rappLegale.getDataNascita() != null) {
//				row.createCell(i++).setCellValue(sdf.format(rappLegale.getDataNascita()));
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (rappLegale.getIstatComuneresidenza() != null) {
//				row.createCell(i++)
//						.setCellValue(taifMgr.getComuneByIstat(rappLegale.getIstatComuneresidenza()).getNome());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (rappLegale.getIndirizzoResidenza() != null) {
//				row.createCell(i++).setCellValue(rappLegale.getIndirizzoResidenza());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (rappLegale.getCivico() != null) {
//				row.createCell(i++).setCellValue(rappLegale.getCivico());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (rappLegale.getCap() != null) {
//				row.createCell(i++).setCellValue(rappLegale.getCap());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (rappLegale.getTelefono() != null) {
//				row.createCell(i++).setCellValue(rappLegale.getTelefono());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (rappLegale.getCellulare() != null) {
//				row.createCell(i++).setCellValue(rappLegale.getCellulare());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//			if (rappLegale.getMail() != null) {
//				row.createCell(i++).setCellValue(rappLegale.getMail());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//
//			if (rappLegale.getIdTitolo() != null) {
//				row.createCell(i++).setCellValue(pdfDbManager.getTitoloStudio(rappLegale.getIdTitolo()));
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
//
//			if (rappLegale.getAStudi() != null) {
//				row.createCell(i++).setCellValue(rappLegale.getAStudi());
//			} else {
//				row.createCell(i++).setCellValue(Constants.blank);
//			}
			if (StringUtils.isNotEmpty(formazioneF)) {
				row.createCell(i++).setCellValue(formazioneF);
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (StringUtils.isNotEmpty(qualificaF)) {
				row.createCell(i++).setCellValue(qualificaF);
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			if (StringUtils.isNotEmpty(riconiscimentiF)) {
				row.createCell(i++).setCellValue(riconiscimentiF);
			} else {
				row.createCell(i++).setCellValue(Constants.blank);
			}
			// conduttore
			// rappLegale
			if (rappLegaleC.getCodiceFiscale() != null) {

				String formazioneFC = pdfDbManager.findCorsiPerPersona(rappLegaleC.getIdPersona());
				String qualificaFC = pdfDbManager.findQualifichePerPersona(rappLegaleC.getIdPersona());
				String riconoscimentiFC = pdfDbManager.findRiconoscimentiPerPersona(rappLegaleC.getIdPersona());

//				if (rappLegaleC.getCodiceFiscale() != null) {
//					row.createCell(i++).setCellValue(rappLegaleC.getCodiceFiscale());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
				if (rappLegaleC.getCognome() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getCognome());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (rappLegaleC.getNome() != null) {
					row.createCell(i++).setCellValue(rappLegaleC.getNome());
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
//				if (rappLegaleC.getDataNascita() != null) {
//					row.createCell(i++).setCellValue(sdf.format(rappLegaleC.getDataNascita()));
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//				if (rappLegaleC.getIstatComuneresidenza() != null) {
//					row.createCell(i++).setCellValue(
//							pdfDbManager.getComuneFromIstat(rappLegaleC.getIstatComuneresidenza()).getNome());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//				if (rappLegaleC.getIndirizzoResidenza() != null) {
//					row.createCell(i++).setCellValue(rappLegaleC.getIndirizzoResidenza());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//				if (rappLegaleC.getCivico() != null) {
//					row.createCell(i++).setCellValue(rappLegaleC.getCivico());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//				if (rappLegaleC.getCap() != null) {
//					row.createCell(i++).setCellValue(rappLegaleC.getCap());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//				if (rappLegaleC.getTelefono() != null) {
//					row.createCell(i++).setCellValue(rappLegaleC.getTelefono());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//				if (rappLegaleC.getCellulare() != null) {
//					row.createCell(i++).setCellValue(rappLegaleC.getCellulare());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//				if (rappLegaleC.getMail() != null) {
//					row.createCell(i++).setCellValue(rappLegaleC.getMail());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//
//				if (rappLegaleC.getIdTitolo() != null) {
//					row.createCell(i++).setCellValue(pdfDbManager.getTitoloStudio(rappLegaleC.getIdTitolo()));
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
//				if (rappLegaleC.getAStudi() != null) {
//					row.createCell(i++).setCellValue(rappLegaleC.getAStudi());
//				} else {
//					row.createCell(i++).setCellValue(Constants.blank);
//				}
				if (StringUtils.isNotEmpty(formazioneFC)) {
					row.createCell(i++).setCellValue(formazioneFC);
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (StringUtils.isNotEmpty(qualificaFC)) {
					row.createCell(i++).setCellValue(qualificaFC);
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
				if (StringUtils.isNotEmpty(riconoscimentiFC)) {
					row.createCell(i++).setCellValue(riconoscimentiFC);
				} else {
					row.createCell(i++).setCellValue(Constants.blank);
				}
			}

		}
	}
	
	private void makeMacchineRidotte(List<Integer> listIdAziende, final String[] columns, Workbook workbook,
			CreationHelper createHelper, String sheetName) throws ManagerException {

		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 1);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);
		tipoMezzoFilter = setTipoMezzoFilter();

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;

		for (Integer idAzienda : listIdAziende) {
			int j = 0;
			tipoMezzoFilter.setIdAzienda(idAzienda);
			List<TaifTMezzoByIdAziendaDto> allMacchineMezziByAzienda = pdfDbManager.getMacchineMezzi(idAzienda);
			// List<TaifTMezzoByTipoMezzoAziendaVisibileDto> mezziList = taifMgr
			// .findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(idAzienda);
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			if (allMacchineMezziByAzienda.size() > 0) {
				for (TaifTMezzoByIdAziendaDto mezzoUsato : allMacchineMezziByAzienda) {
					int i = 0;
					Row row = sheet.createRow(rowNum++);

					tipoMezzoFilter.setIdTipoMezzo(mezzoUsato.getIdTipoMezzo());

					if (pratichePerAzienda.getIdSoggettoGestore() != null) {
						row.createCell(i++).setCellValue(String.valueOf(
								taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (pratichePerAzienda.getNrAlbo() != null) {
						row.createCell(i++).setCellValue(pratichePerAzienda.getNrAlbo());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getCodiceFiscale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getCodiceFiscale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}
					if (taifTAziendaDto.getRagioneSociale() != null) {
						row.createCell(i++).setCellValue(taifTAziendaDto.getRagioneSociale());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					List<TaifDCategoriaMezzoByIdTipoMezzoDto> categoriaMezzoByIdMezzo = taifMgr
							.findTipoECategoriaByIdTipoMezzo(tipoMezzoFilter);
					if (categoriaMezzoByIdMezzo != null) {
						row.createCell(i++).setCellValue(categoriaMezzoByIdMezzo.get(0).getCat());
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

					if (mezzoUsato.getIdTipoMezzo() != null) {
						row.createCell(i++).setCellValue(pdfDbManager.getTipoMezzoById(mezzoUsato.getIdTipoMezzo()));
					} else {
						row.createCell(i++).setCellValue(Constants.blank);
					}

//					if (mezzoUsato.getAnno() != null) {
//						row.createCell(i++).setCellValue(String.valueOf(mezzoUsato.getAnno()));
//					} else {
//						row.createCell(i++).setCellValue(Constants.blank);
//					}
//					if (mezzoUsato.getPotenza() != null) {
//						row.createCell(i++).setCellValue(String.valueOf(mezzoUsato.getPotenza()));
//					} else {
//						row.createCell(i++).setCellValue(Constants.blank);
//					}
//					if (mezzoUsato.getIdTipoTrazione() != null) {
//						row.createCell(i++).setCellValue(pdfDbManager.getTipoTrazione(mezzoUsato.getIdTipoTrazione()));
//					} else {
//						row.createCell(i++).setCellValue(Constants.blank);
//					}
//					if (mezzoUsato.getIdAlimentazione() != null) {
//						row.createCell(i++).setCellValue(
//								pdfDbManager.getTipoAllimentazioneMezzoById(mezzoUsato.getIdAlimentazione()));
//					} else {
//						row.createCell(i++).setCellValue(Constants.blank);
//					}
//
//					if (mezzoUsato.getPortata() != null) {
//						row.createCell(i++).setCellValue(pdfDbManager.getTipoCarelloById(mezzoUsato.getPortata()));
//					} else {
//						row.createCell(i++).setCellValue(Constants.blank);
//					}
//
//					if (mezzoUsato.getIdTipoCarrel() != null) {
//						row.createCell(i++).setCellValue(pdfDbManager.getTipoCarelloById(mezzoUsato.getIdTipoCarrel()));
//					} else {
//						row.createCell(i++).setCellValue(Constants.blank);
//					}
//
//					if (mezzoUsato.getComando() != null) {
//						row.createCell(i++).setCellValue(pdfDbManager.getNoleggio(mezzoUsato.getComando().intValue()));
//					} else {
//						row.createCell(i++).setCellValue(Constants.blank);
//					}
//
//					if (mezzoUsato.getNoleggio() != null) {
//						row.createCell(i++).setCellValue(pdfDbManager.getNoleggio(mezzoUsato.getNoleggio().intValue()));
//					} else {
//						row.createCell(i++).setCellValue(Constants.blank);
//					}

				}
			} else {
				Row row = sheet.createRow(rowNum++);
				if (pratichePerAzienda.getIdSoggettoGestore() != null) {
					row.createCell(j++).setCellValue(String.valueOf(
							taifMgr.getSoggettoGestoreById(pratichePerAzienda.getIdSoggettoGestore()).getCodice()));
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (pratichePerAzienda.getNrAlbo() != null) {
					row.createCell(j++).setCellValue(pratichePerAzienda.getNrAlbo());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getCodiceFiscale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getCodiceFiscale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}
				if (taifTAziendaDto.getRagioneSociale() != null) {
					row.createCell(j++).setCellValue(taifTAziendaDto.getRagioneSociale());
				} else {
					row.createCell(j++).setCellValue(Constants.blank);
				}

			}
		}
	}

	private TipoMezzoFilter setTipoMezzoFilter() {
		tipoMezzoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		tipoMezzoFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
		return tipoMezzoFilter;
	}

	private AziendaVisibleFilter setAziendaVisibleFilter() {
		aziendaVisibleFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		aziendaVisibleFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
		return aziendaVisibleFilter;
	}

	private SpecieFilter setSpecieFilter() {
		specieFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		specieFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
		return specieFilter;
	}

	private AssortimentoFilter setAssortimentoFilter() {
		assortimentoFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		assortimentoFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
		return assortimentoFilter;
	}

	private ProvenienzaFilter setProvenienzaFilter() {
		provenienzaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		provenienzaFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
		return provenienzaFilter;
	}

	private UnitaMisuraFilter setUnitaMisuraFilter() {
		unitaMisuraFilter.setFlagVisible(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		return unitaMisuraFilter;
	}

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	public void setAziendaVisibleFilter(AziendaVisibleFilter aziendaVisibleFilter) {
		this.aziendaVisibleFilter = aziendaVisibleFilter;
	}

	public void setSpecieFilter(SpecieFilter specieFilter) {
		this.specieFilter = specieFilter;
	}

	public void setProvenienzaFilter(ProvenienzaFilter provenienzaFilter) {
		this.provenienzaFilter = provenienzaFilter;
	}

	public void setAssortimentoFilter(AssortimentoFilter assortimentoFilter) {
		this.assortimentoFilter = assortimentoFilter;
	}

	public void setUnitaMisuraFilter(UnitaMisuraFilter unitaMisuraFilter) {
		this.unitaMisuraFilter = unitaMisuraFilter;
	}

	public void setTipoMezzoFilter(TipoMezzoFilter tipoMezzoFilter) {
		this.tipoMezzoFilter = tipoMezzoFilter;
	}

	public PdfDbManager getPdfDbManager() {
		return pdfDbManager;
	}

	public void setPdfDbManager(PdfDbManager pdfDbManager) {
		this.pdfDbManager = pdfDbManager;
	}

	public AziendaVisibleFilter getAziendaVisibleFilter() {
		return aziendaVisibleFilter;
	}

	public SpecieFilter getSpecieFilter() {
		return specieFilter;
	}

	public ProvenienzaFilter getProvenienzaFilter() {
		return provenienzaFilter;
	}

	public AssortimentoFilter getAssortimentoFilter() {
		return assortimentoFilter;
	}

	public UnitaMisuraFilter getUnitaMisuraFilter() {
		return unitaMisuraFilter;
	}

	public TipoMezzoFilter getTipoMezzoFilter() {
		return tipoMezzoFilter;
	}

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	public ServiceMgr getServiceMgr() {
		return serviceMgr;
	}

	public void setServiceMgr(ServiceMgr serviceMgr) {
		this.serviceMgr = serviceMgr;
	}

}
