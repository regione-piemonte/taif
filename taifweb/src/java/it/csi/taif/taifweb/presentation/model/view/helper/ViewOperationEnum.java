/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.model.view.helper;

public enum ViewOperationEnum {
	
	CLEAN("C"),
	ACTIVATE("A"),
	DEACTIVATE("D"),
	ON("N"),
	OFF("F"),
	HIDE("H"),
	SHOW("S")
	;
	
	
	private String name;
	
	public String getName(){
		return name;
	}
	
	ViewOperationEnum(String name){
		this.name = name;
	}
	
	
}
