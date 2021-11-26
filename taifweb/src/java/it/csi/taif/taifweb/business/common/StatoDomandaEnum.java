/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.common;

public enum StatoDomandaEnum {

	BOZZA(1,2),
	PRESENTATA(2,null),
	PRESA_IN_CARICO(3, null),
	ISCRITTA(4,null),
	SOSPESA(5,null),
	CANCELLATA(6,null),
	NON_ACCOLTA(7,null),
	ISCRITTA_DA_CONFERMARE(8,9),
	ISCRITTA_CONFERMATA(9,null),
	SOSPESA_PER_MANCATA_CONFERMA(10,9)
	
	;
	
	private int name;
	private Integer next;
	
	private StatoDomandaEnum(int name, Integer next) {
		this.name = name;
		this.next = next;
	}
	
	public int getName() {
		return name;
	}
	
	public Integer getNext() {
		return next;
	}
	
	public static StatoDomandaEnum getByName(int name) {
		for (StatoDomandaEnum wizard : values()) {
			if(wizard.getName()==name) {
				return wizard;
			}
		}
		return BOZZA;
	}
	
	public static Integer getNextElement(int name) {
		
		return getByName(name).getNext();
		
	}
	
	
	
	

	
		
}
