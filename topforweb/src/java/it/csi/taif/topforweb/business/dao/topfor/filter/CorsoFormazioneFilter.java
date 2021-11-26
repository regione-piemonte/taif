/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.filter;

public class CorsoFormazioneFilter {

    
        private int idUnitaFormativa;
	private int idAgenziaFormativa;
	private int flagVisibile;
	private String flagItaFr;
	
	
	
	public int getIdUnitaFormativa() {
	    return idUnitaFormativa;
	}
	public void setIdUnitaFormativa(int idUnitaFormativa) {
	    this.idUnitaFormativa = idUnitaFormativa;
	}
	public int getIdAgenziaFormativa() {
	    return idAgenziaFormativa;
	}
	public void setIdAgenziaFormativa(int idAgenziaFormativa) {
	    this.idAgenziaFormativa = idAgenziaFormativa;
	}
	public int getFlagVisibile() {
	    return flagVisibile;
	}
	public void setFlagVisibile(int flagVisibile) {
	    this.flagVisibile = flagVisibile;
	}
	public String getFlagItaFr() {
	    return flagItaFr;
	}
	public void setFlagItaFr(String flagItaFr) {
	    this.flagItaFr = flagItaFr;
	}
	
	
	
	
	
}
