/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.service.integration.acta;

import it.csi.taif.taifweb.util.GenericUtil;

public enum ActaStatoPraticaEnum {
	
	DOMANDA(1, 1, 3),
	CONFERMA(2,8,10),
	ISCRIZIONE(3,4, 4),
	RINUNCE(4, 0, 0),
	SOSPENSIONE(5,5,5),
	CANCELLAZIONE(6,6,6),
	CONTROLLI(7,0,0),
	COMUNICAZIONI(8,0,0)
	
	;
	
	private int nrSottoFasciolo;
	private int idStatoPraticaDa;
	private int idStatoPraticaA;
	
	private ActaStatoPraticaEnum(int nrSottoFasciolo, int idStatoPraticaDa, int idStatoPraticaA) {
		this.nrSottoFasciolo = nrSottoFasciolo;
		this.idStatoPraticaDa = idStatoPraticaDa;
		this.idStatoPraticaA = idStatoPraticaA;
	}
	
	
	public static ActaStatoPraticaEnum getSottoFascicoloByIdStatoPratica(int idStatoPratica) {
		for (ActaStatoPraticaEnum aspe : values()) {
			if(GenericUtil.between(idStatoPratica, aspe.getIdStatoPraticaDa(), aspe.getIdStatoPraticaA())) {
				return aspe;
			}
		}
		return DOMANDA;
	}
	

	/**
	 * @return the nrSottoFasciolo
	 */
	public int getNrSottoFasciolo() {
		return nrSottoFasciolo;
	}

	/**
	 * @param nrSottoFasciolo the nrSottoFasciolo to set
	 */
	public void setNrSottoFasciolo(int nrSottoFasciolo) {
		this.nrSottoFasciolo = nrSottoFasciolo;
	}

	/**
	 * @return the idStatoPraticaDa
	 */
	public int getIdStatoPraticaDa() {
		return idStatoPraticaDa;
	}

	/**
	 * @param idStatoPraticaDa the idStatoPraticaDa to set
	 */
	public void setIdStatoPraticaDa(int idStatoPraticaDa) {
		this.idStatoPraticaDa = idStatoPraticaDa;
	}

	/**
	 * @return the idStatoPraticaA
	 */
	public int getIdStatoPraticaA() {
		return idStatoPraticaA;
	}

	/**
	 * @param idStatoPraticaA the idStatoPraticaA to set
	 */
	public void setIdStatoPraticaA(int idStatoPraticaA) {
		this.idStatoPraticaA = idStatoPraticaA;
	}
	
		
	
}
