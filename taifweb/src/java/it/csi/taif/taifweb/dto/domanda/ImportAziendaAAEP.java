/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

import java.io.Serializable;
import java.util.ArrayList;

public class ImportAziendaAAEP implements Serializable {
	
	private static final long serialVersionUID = -5994861783815154959L;
	
	private AnagraficaAziendale anagraficaAziendale;
	private Sede sedeLegale;
	private ArrayList<Sede> sediOperative;
	private TitolareRappresentanteLegale titolareRappresentanteLegale;
	
	/**
	 * @return the anagraficaAziendale
	 */
	public AnagraficaAziendale getAnagraficaAziendale() {
		return anagraficaAziendale;
	}
	/**
	 * @param anagraficaAziendale the anagraficaAziendale to set
	 */
	public void setAnagraficaAziendale(AnagraficaAziendale anagraficaAziendale) {
		this.anagraficaAziendale = anagraficaAziendale;
	}
	/**
	 * @return the sedeLegale
	 */
	public Sede getSedeLegale() {
		return sedeLegale;
	}
	/**
	 * @param sedeLegale the sedeLegale to set
	 */
	public void setSedeLegale(Sede sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	/**
	 * @return the sediOperative
	 */
	public ArrayList<Sede> getSediOperative() {
		return sediOperative;
	}
	/**
	 * @param sediOperative the sediOperative to set
	 */
	public void setSediOperative(ArrayList<Sede> sediOperative) {
		this.sediOperative = sediOperative;
	}
	/**
	 * @return the titolareRappresentanteLegale
	 */
	public TitolareRappresentanteLegale getTitolareRappresentanteLegale() {
		return titolareRappresentanteLegale;
	}
	/**
	 * @param titolareRappresentanteLegale the titolareRappresentanteLegale to set
	 */
	public void setTitolareRappresentanteLegale(TitolareRappresentanteLegale titolareRappresentanteLegale) {
		this.titolareRappresentanteLegale = titolareRappresentanteLegale;
	}
	
	
}
