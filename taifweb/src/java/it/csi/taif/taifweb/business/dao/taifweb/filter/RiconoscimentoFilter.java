/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;
import java.util.Date;

public class RiconoscimentoFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idUnitaFormativa;
	private int idAgenziaFormativa;
	private int idPersona;
	private Date dataRiconoscimento;
	
	
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
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public Date getDataRiconoscimento() {
		return dataRiconoscimento;
	}
	public void setDataRiconoscimento(Date dataRiconoscimento) {
		this.dataRiconoscimento = dataRiconoscimento;
	}
	
	
	
	

}
