/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.common;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import it.csi.taif.topforweb.business.dao.util.Constants;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.manager.db.DbMgr;
import it.csi.taif.topforweb.business.manager.service.ServiceMgr;
import it.csi.taif.topforweb.business.report.PdfDbManager;
import it.csi.taif.topforweb.business.report.beans.AnagraficaOperatoriBean;
import it.csi.taif.topforweb.business.report.beans.CorsiOperatoriBean;
import it.csi.taif.topforweb.business.report.beans.QualificaOperatoreBean;
import it.csi.taif.topforweb.business.report.beans.RiconoscimentiOperatoreBean;
import it.csi.taif.topforweb.exception.ManagerException;



public class ExportElencoOperatoriToExcel {

    @Autowired
    private TopForMgr topForMgr;
    
    @Autowired
    private DbMgr dbMgr;
  
    @Autowired
    private ServiceMgr serviceMgr;
    
    @Autowired
    private PdfDbManager pdfDbManager;
   
    public ByteArrayOutputStream   exportToExcel(List<Integer> listIdOperatori, String tracciato ) throws IOException, ManagerException {
   
	final String[] columnsAnagraficaOperatori = {"Codice Fiscale", "Cognome", "Nome",
		"Data di nascita", "Stato Nascita ", "Comune di nascita", "Comune di Residenza", "Indirizzo di residenza",
		"Civico", "Cap ", "Telefono o Cellulare ", "E-mail personale",
		"Associato ad azienda iscritta ad un albo forestale (SI/NO)", "Pubblicabilità" };
	final String[] columnsCorsiOperatori = {"Codice Fiscale", "Data inizio", "Data fine",
		"Numero ore", "Agenzia formativa ", "Descrizione corso", "Unita formativa", "Sigla unita formativa" };
	final String[] columnsRiconoscimenti = {"Codice Fiscale", "Data riconoscimento",  "Unita formativa equivalente", "Agenzia formativa " };
	final String[] columnsQualifiche = {"Codice Fiscale", "Tipo qualifica", "Agenzia formativa ", "Data qualifica" };

	Workbook workbook = new XSSFWorkbook();
	CreationHelper createHelper = workbook.getCreationHelper();

	makeAnagraficaOperatori(listIdOperatori, columnsAnagraficaOperatori, workbook, createHelper, "Dati Generali", tracciato, false);
	makeCorsiOperatori(listIdOperatori, columnsCorsiOperatori, workbook, createHelper, "Operatori corsi", tracciato, false);
	makeRiconoscimentiOperatori(listIdOperatori, columnsRiconoscimenti, workbook, createHelper, "Riconoscimenti", tracciato, false);
	makeQualificaOperatori(listIdOperatori, columnsQualifiche, workbook, createHelper, "Qualifiche", tracciato, false);
	
	
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
    
    public ByteArrayOutputStream   exportToExcelRidotto(List<Integer> listIdOperatori, String tracciato ) throws IOException, ManagerException {
    	   
    	final String[] columnsAnagraficaOperatori = {"Cognome", "Nome",
    		"Data di nascita", "Stato Nascita ", "Comune di nascita", "Comune di Residenza", "Indirizzo di residenza",
    		"Civico", "Cap ", "Telefono o Cellulare ", "E-mail personale",
    		"Associato ad azienda iscritta ad un albo forestale (SI/NO)", "Pubblicabilità" };
    	final String[] columnsCorsiOperatori = {"Cognome", "Nome","Data inizio", "Data fine",
    		"Numero ore", "Agenzia formativa ", "Descrizione corso", "Unita formativa", "Sigla unita formativa" };
    	final String[] columnsRiconoscimenti = {"Cognome", "Nome","Data riconoscimento",  "Unita formativa equivalente", "Agenzia formativa " };
    	final String[] columnsQualifiche = {"Cognome", "Nome","Tipo qualifica", "Agenzia formativa ", "Data qualifica" };

    	Workbook workbook = new XSSFWorkbook();
    	CreationHelper createHelper = workbook.getCreationHelper();

    	makeAnagraficaOperatori(listIdOperatori, columnsAnagraficaOperatori, workbook, createHelper, "Dati Generali", tracciato, true);
    	makeCorsiOperatori(listIdOperatori, columnsCorsiOperatori, workbook, createHelper, "Operatori corsi", tracciato, true);
    	makeRiconoscimentiOperatori(listIdOperatori, columnsRiconoscimenti, workbook, createHelper, "Riconoscimenti", tracciato, true);
    	makeQualificaOperatori(listIdOperatori, columnsQualifiche, workbook, createHelper, "Qualifiche", tracciato, true);
    	
    	
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

    private void makeAnagraficaOperatori(List<Integer> listIdOperatori, final String[] columns, Workbook workbook,
	    CreationHelper createHelper, String sheetName, String tracciato, boolean ridotto) throws ManagerException {
	Sheet sheet = workbook.createSheet(sheetName);
	org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
	headerFont.setBoldweight((short) 1);
	headerFont.setFontHeightInPoints((short) 14);
	headerFont.setColor(IndexedColors.RED.getIndex());

	CellStyle headerCellStyle = workbook.createCellStyle();
	headerCellStyle.setFont(headerFont);

	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf = new SimpleDateFormat(it.csi.taif.topforweb.util.Constants.FIRMA_FORMAT_DATA);

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

	for (Integer idOperatore : listIdOperatori) {
	    
	    AnagraficaOperatoriBean  anagraficaOperatore = topForMgr.findAnagraficaOperatoreByIdOperatore(idOperatore, tracciato) ;
	    
	    int i = 0;
	    Row row = sheet.createRow(rowNum++);
	    if(!ridotto) {
		    if (anagraficaOperatore.getCodiceFiscale() != null) {
			 row.createCell(i++).setCellValue(anagraficaOperatore.getCodiceFiscale());
		    }else {
		    	row.createCell(i++).setCellValue(Constants.blank);
		    }
	    }
	    row.createCell(i++).setCellValue(anagraficaOperatore.getCognome());
	    row.createCell(i++).setCellValue(anagraficaOperatore.getNome());
	    if (anagraficaOperatore.getDataNascita() != null) {
		row.createCell(i++).setCellValue(sdf.format(anagraficaOperatore.getDataNascita()));
	    } else {
		row.createCell(i++).setCellValue(Constants.blank);
	    }
	    if (anagraficaOperatore.getStatoNascita() != null) {
		row.createCell(i++).setCellValue(anagraficaOperatore.getStatoNascita());
	    } else {
		row.createCell(i++).setCellValue(Constants.blank);
	    }
	    if (anagraficaOperatore.getComuneNascita() != null && !anagraficaOperatore.getComuneNascita().equals(Constants.blank)) {
		row.createCell(i++).setCellValue(anagraficaOperatore.getComuneNascita());
	    } else {
		if(anagraficaOperatore.getComuneNascitaEstero()!=null && !anagraficaOperatore.getComuneNascitaEstero().equals(Constants.blank)) {
		    row.createCell(i++).setCellValue(anagraficaOperatore.getComuneNascitaEstero());  
		}else {
		    row.createCell(i++).setCellValue(Constants.blank);
		}
	    }
	    if (anagraficaOperatore.getComuneResidenza() != null && !anagraficaOperatore.getComuneResidenza().equals(Constants.blank)) {
		row.createCell(i++).setCellValue(anagraficaOperatore.getComuneResidenza());
	    } else {
		if(anagraficaOperatore.getComuneResidenza()!=null && !anagraficaOperatore.getComuneResidenza().equals(Constants.blank)) {
		    row.createCell(i++).setCellValue(anagraficaOperatore.getComuneResidenzaEstero());  
		}else {
		    row.createCell(i++).setCellValue(Constants.blank);
		}
	    }

	    if (anagraficaOperatore.getIndirizzoResidenza() != null) {
		row.createCell(i++).setCellValue(anagraficaOperatore.getIndirizzoResidenza());
	    } else {
		row.createCell(i++).setCellValue(Constants.blank);
	    }

	    if (anagraficaOperatore.getCivicoResidenza() != null) {
		row.createCell(i++).setCellValue(anagraficaOperatore.getCivicoResidenza());
	    } else {
		row.createCell(i++).setCellValue(Constants.blank);
	    }
	    if (anagraficaOperatore.getCapResidenza() != null) {
	  		row.createCell(i++).setCellValue(anagraficaOperatore.getCapResidenza());
	  	    } else {
	  		row.createCell(i++).setCellValue(Constants.blank);
	  	    }
	    if (anagraficaOperatore.getTelCellulare() != null) {
  		row.createCell(i++).setCellValue(anagraficaOperatore.getTelCellulare());
  	    } else {
  		row.createCell(i++).setCellValue(Constants.blank);
  	    } 
	    if (anagraficaOperatore.geteMail()!= null) {
  		row.createCell(i++).setCellValue(anagraficaOperatore.geteMail());
  	    } else {
  		row.createCell(i++).setCellValue(Constants.blank);
  	    } 
	    
	    if (anagraficaOperatore.getAziendaAssociata()!= null) {
  		row.createCell(i++).setCellValue(anagraficaOperatore.getAziendaAssociata());
  	    } else {
  		row.createCell(i++).setCellValue(Constants.blank);
  	    } 
	    
	    if (anagraficaOperatore.getPublicabilita()!= null) {
  		row.createCell(i++).setCellValue(anagraficaOperatore.getPublicabilita());
  	    } else {
  		row.createCell(i++).setCellValue(Constants.blank);
  	    } 
	}
    }

  
    private void makeCorsiOperatori(List<Integer> listIdOperatori, final String[] columns, Workbook workbook,
	    CreationHelper createHelper, String sheetName, String tracciato, boolean ridotto) throws ManagerException {

	Sheet sheet = workbook.createSheet(sheetName);
	org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
	headerFont.setBoldweight((short) 1);
	headerFont.setFontHeightInPoints((short) 14);
	headerFont.setColor(IndexedColors.RED.getIndex());

	CellStyle headerCellStyle = workbook.createCellStyle();
	headerCellStyle.setFont(headerFont);

	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf = new SimpleDateFormat(it.csi.taif.topforweb.util.Constants.FIRMA_FORMAT_DATA);
	
	Row headerRow = sheet.createRow(0);

	// Create cells
	for (int i = 0; i < columns.length; i++) {
	    Cell cell = headerRow.createCell(i);
	    cell.setCellValue(columns[i]);
	    cell.setCellStyle(headerCellStyle);
	}
	int rowNum = 1;

	for (Integer idOperatore : listIdOperatori) {
	    
	    System.out.println(" idOperatoreCorsi  : " + idOperatore);
	    
	    List<CorsiOperatoriBean> corsiOperatoreList = topForMgr.findCorsiPerOperatori(idOperatore, tracciato);
	    
	    System.out.println(" corsiOperatoreList   : " + corsiOperatoreList.size());
	    
	    
	    for (CorsiOperatoriBean corsiOperatoriBean : corsiOperatoreList) {
		int k = 0;
		Row row = sheet.createRow(rowNum++);
		if(!ridotto) {
			if (corsiOperatoriBean.getCodiceFiscale() != null) {
			    row.createCell(k++).setCellValue(corsiOperatoriBean.getCodiceFiscale());
			} else {
			    row.createCell(k++).setCellValue(Constants.blank);
			}
		}
		row.createCell(k++).setCellValue(corsiOperatoriBean.getCognome());
		row.createCell(k++).setCellValue(corsiOperatoriBean.getNome());
		if (corsiOperatoriBean.getDataInizio() != null) {
		    row.createCell(k++).setCellValue(sdf.format(corsiOperatoriBean.getDataInizio()));
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (corsiOperatoriBean.getDataFine() != null) {
		    row.createCell(k++).setCellValue(sdf.format(corsiOperatoriBean.getDataFine()));
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (corsiOperatoriBean.getNumeroOre() != 0) {
		    row.createCell(k++).setCellValue(corsiOperatoriBean.getNumeroOre());
		} else {
		    row.createCell(k++).setCellValue(Constants.zeroInt);
		}
		if (corsiOperatoriBean.getAgenziaFormazione() != null) {
		    row.createCell(k++).setCellValue(corsiOperatoriBean.getAgenziaFormazione());
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (corsiOperatoriBean.getDescrizioneCorso() != null) {
		    row.createCell(k++).setCellValue(corsiOperatoriBean.getDescrizioneCorso());
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (corsiOperatoriBean.getUnitaFormativa() != null) {
		    row.createCell(k++).setCellValue(corsiOperatoriBean.getUnitaFormativa());
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (corsiOperatoriBean.getSiglaUnitaFormativa() != null) {
		    row.createCell(k++).setCellValue(corsiOperatoriBean.getSiglaUnitaFormativa());
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		k++;
	    }
	}
    }
    
    private void makeRiconoscimentiOperatori(List<Integer> listIdOperatori, final String[] columns, Workbook workbook,
	    CreationHelper createHelper, String sheetName, String tracciato, boolean ridotto) throws ManagerException {

	Sheet sheet = workbook.createSheet(sheetName);
	org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
	headerFont.setBoldweight((short) 1);
	headerFont.setFontHeightInPoints((short) 14);
	headerFont.setColor(IndexedColors.RED.getIndex());

	CellStyle headerCellStyle = workbook.createCellStyle();
	headerCellStyle.setFont(headerFont);

	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf = new SimpleDateFormat(it.csi.taif.topforweb.util.Constants.FIRMA_FORMAT_DATA);
	
	Row headerRow = sheet.createRow(0);

	// Create cells
	for (int i = 0; i < columns.length; i++) {
	    Cell cell = headerRow.createCell(i);
	    cell.setCellValue(columns[i]);
	    cell.setCellStyle(headerCellStyle);
	}
	int rowNum = 1;

	for (Integer idOperatore : listIdOperatori) {
	    List<RiconoscimentiOperatoreBean> riconoscimentiList = topForMgr.findRiconoscimentiPerPersona(idOperatore, tracciato);
	    for (RiconoscimentiOperatoreBean riconoscimenti : riconoscimentiList) {
		int k = 0;
		Row row = sheet.createRow(rowNum++);
		if(!ridotto) {
			if (riconoscimenti.getCodiceFiscale() != null) {
			    row.createCell(k++).setCellValue(riconoscimenti.getCodiceFiscale());
			} else {
			    row.createCell(k++).setCellValue(Constants.blank);
			}
		}
		row.createCell(k++).setCellValue(riconoscimenti.getCognome());
		row.createCell(k++).setCellValue(riconoscimenti.getNome());
		if (riconoscimenti.getDataRiconoscimento() != null) {
		    row.createCell(k++).setCellValue(sdf.format(riconoscimenti.getDataRiconoscimento()));
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (riconoscimenti.getUnitaFormativaEquivalente() != null) {
		    row.createCell(k++).setCellValue(riconoscimenti.getUnitaFormativaEquivalente());
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (riconoscimenti.getAgenziaFormazione() != null) {
		    row.createCell(k++).setCellValue(riconoscimenti.getAgenziaFormazione());
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		k++;
	    }
	}
    }
    
    private void makeQualificaOperatori(List<Integer> listIdOperatori, final String[] columns, Workbook workbook,
	    CreationHelper createHelper, String sheetName, String tracciato, boolean ridotto) throws ManagerException {

	Sheet sheet = workbook.createSheet(sheetName);
	org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
	headerFont.setBoldweight((short) 1);
	headerFont.setFontHeightInPoints((short) 14);
	headerFont.setColor(IndexedColors.RED.getIndex());

	CellStyle headerCellStyle = workbook.createCellStyle();
	headerCellStyle.setFont(headerFont);

	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf = new SimpleDateFormat(it.csi.taif.topforweb.util.Constants.FIRMA_FORMAT_DATA);
	
	Row headerRow = sheet.createRow(0);

	// Create cells
	for (int i = 0; i < columns.length; i++) {
	    Cell cell = headerRow.createCell(i);
	    cell.setCellValue(columns[i]);
	    cell.setCellStyle(headerCellStyle);
	}
	int rowNum = 1;

	for (Integer idOperatore : listIdOperatori) {
	    List<QualificaOperatoreBean> qulificheList = topForMgr.findQualifichePerPersona(idOperatore, tracciato);
	    for (QualificaOperatoreBean qualifiche : qulificheList) {
		int k = 0;
		Row row = sheet.createRow(rowNum++);
		if(!ridotto) {
			if (qualifiche.getCodiceFiscale() != null) {
			    row.createCell(k++).setCellValue(qualifiche.getCodiceFiscale());
			} else {
			    row.createCell(k++).setCellValue(Constants.blank);
			}
		}
		row.createCell(k++).setCellValue(qualifiche.getCognome());
		row.createCell(k++).setCellValue(qualifiche.getNome());
		if (qualifiche.getTipoQualifica() != null) {
		    row.createCell(k++).setCellValue(qualifiche.getTipoQualifica());
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (qualifiche.getAgenziaFormativa() != null) {
		    row.createCell(k++).setCellValue(qualifiche.getAgenziaFormativa());
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		if (qualifiche.getDataQualifica() != null) {
		    row.createCell(k++).setCellValue(sdf.format(qualifiche.getDataQualifica() ));
		} else {
		    row.createCell(k++).setCellValue(Constants.blank);
		}
		
		k++;
	    }
	}
    }
  

    public TopForMgr getTopForMgr() {
        return topForMgr;
    }

    public void setTopForMgr(TopForMgr topForMgr) {
        this.topForMgr = topForMgr;
    }

    public PdfDbManager getPdfDbManager() {
        return pdfDbManager;
    }

    public void setPdfDbManager(PdfDbManager pdfDbManager) {
        this.pdfDbManager = pdfDbManager;
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
