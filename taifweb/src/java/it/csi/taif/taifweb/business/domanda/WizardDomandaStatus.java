/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.domanda;

public enum WizardDomandaStatus {

	WIZARD_SEL_1("CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel",null),
	WIZARD_VAL_1("CpDomanda_wzpDomanda_fpWizard1DatiAnagrafici",null),
	WIZARD_VAL_1_1("CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1", 1),
	WIZARD_VAL_1_2("CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2",2),
	WIZARD_SEL_2("CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel",null),
	WIZARD_VAL_2("CpDomanda_wzpDomanda_fpWizard2DatiSocioEconomici",null),
	WIZARD_VAL_2_1("CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1",3),
	WIZARD_VAL_2_2("CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2",4),
	WIZARD_SEL_3("CpDomanda_wzpDomandaAttivita_selectedMultiPanel",null),
	WIZARD_VAL_3("CpDomanda_wzpDomanda_fpWizard3Attivita",null),
	WIZARD_VAL_3_1("CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1",5),
	WIZARD_VAL_3_2("CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2",6),
	WIZARD_VAL_3_3("CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3",7),
	WIZARD_VAL_4("CpDomanda_wzpDomanda_fpWizard4Strutture",8),
	WIZARD_SEL_5("CpDomanda_wzpDomandaAttrezzature_selectedMultiPanel",null),
	WIZARD_VAL_5("CpDomanda_wzpDomanda_fpWizard5Attrezzature",null),
	WIZARD_VAL_5_1("CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub1",9),
	WIZARD_VAL_5_2("CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2",10),
	WIZARD_VAL_6("CpDomanda_wzpDomanda_fpWizard6Personale",11)
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
			if(wizard.getName().equals(name)) {
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

	public static String getSelected(WizardDomandaStatus domanda) {
		switch (domanda) {
		case WIZARD_VAL_1:
			return WIZARD_SEL_1.getName();
		case WIZARD_VAL_2:
			return WIZARD_SEL_2.getName();
		case WIZARD_VAL_3:
			return WIZARD_SEL_3.getName();
		case WIZARD_VAL_5:
			return WIZARD_SEL_5.getName();
		default:
			return WIZARD_SEL_1.getName();
		}
		
	}
		
}
