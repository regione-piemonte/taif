/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.business.manager.TopForMgr;

public class ExportToExcel {


	private TopForMgr topForMgr;
	
	
	
	public TopForMgr getTopForMgr() {
		return topForMgr;
	}

	public void setTopForMgr(TopForMgr topForMgr) {
		this.topForMgr = topForMgr;
	}
	

}
