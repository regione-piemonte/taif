/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.gestore;

public enum WizardDomandaStatus {

	
	WIZARD_VAL_1("CpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore",1),
	WIZARD_VAL_2("CpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore",2),
	WIZARD_VAL_3("CpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore",3),
	WIZARD_VAL_4("CpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore",4),
	WIZARD_VAL_5("CpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore",5), 
	;
	
	private String name;
	private Integer position;
	
	private WizardDomandaStatus(String name, Integer position) {
		this.name = name;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPosition() {
		return position;
	}
	
	public static WizardDomandaStatus getByName(String name) {
		for (WizardDomandaStatus wizard : values()) {
			System.out.println(name);
			System.out.println(wizard.getName());
			System.out.println("-");
			if(wizard.getName().equalsIgnoreCase(name)) {
				return wizard;
			}
		}
		return WIZARD_VAL_1;
	}
	
	public static String getNextElement(String name) {
		Integer pos = getByName(name).getPosition();
		if(pos!=null) {
			WizardDomandaStatus status = getByPosition(pos+1);
			if(status!=null) {
				return status.getName();
			}
		}
		return null;
	}
	
	public static String getPreviousElement(String name) {
		Integer pos = getByName(name).getPosition();
		if(pos!=null) {
			WizardDomandaStatus status = getByPosition(pos-1);
			if(status!=null) {
				return status.getName();
			}
		}
		return null;
	}
	
	private static WizardDomandaStatus getByPosition(int position) {
		for (WizardDomandaStatus wizard : values()) {
			if(wizard.getPosition()!=null && wizard.getPosition()==position) {
				return wizard;
			}
		}
		return null;
	}

	
		
}
