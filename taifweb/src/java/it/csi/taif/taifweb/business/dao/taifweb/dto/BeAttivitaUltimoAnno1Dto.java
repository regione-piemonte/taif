/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import it.csi.taif.taifweb.dto.domanda.Intervento;

public class BeAttivitaUltimoAnno1Dto {

	
	
		private Intervento interventoInRegione ;
	
		private Intervento interventoFuoriRegione ;

		public Intervento getInterventoInRegione() {
			return interventoInRegione;
		}

		public void setInterventoInRegione(Intervento interventoInRegione) {
			this.interventoInRegione = interventoInRegione;
		}

		public Intervento getInterventoFuoriRegione() {
			return interventoFuoriRegione;
		}

		public void setInterventoFuoriRegione(Intervento interventoFuoriRegione) {
			this.interventoFuoriRegione = interventoFuoriRegione;
		}
		
		

}
