/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

public class BeFormaOrganizzativaDto {
	
	
		private int idFormaOrganizzativa ;
		private java.lang.String dsFormaOrganizzativa ;
		private java.lang.String altro ;
		private int rownum ;
		private boolean altroVisibile = false ;
		
		public int getIdFormaOrganizzativa() {
			return idFormaOrganizzativa;
		}
		public void setIdFormaOrganizzativa(int idFormaOrganizzativa) {
			this.idFormaOrganizzativa = idFormaOrganizzativa;
		}
		public java.lang.String getDsFormaOrganizzativa() {
			return dsFormaOrganizzativa;
		}
		public void setDsFormaOrganizzativa(java.lang.String dsFormaOrganizzativa) {
			this.dsFormaOrganizzativa = dsFormaOrganizzativa;
		}
		public java.lang.String getAltro() {
			return altro;
		}
		public void setAltro(java.lang.String altro) {
			this.altro = altro;
		}
		public int getRownum() {
			return rownum;
		}
		public void setRownum(int rownum) {
			this.rownum = rownum;
		}
		public boolean isAltroVisibile() {
			return altroVisibile;
		}
		public void setAltroVisibile(boolean altroVisibile) {
			this.altroVisibile = altroVisibile;
		}


}
