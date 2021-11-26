/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util;

import java.util.ArrayList;

import it.csi.taif.topforweb.dto.common.CodeDescription;




public class ListUtils {
	
	public static ArrayList<CodeDescription> createGenericListOfCodeDescription(String ...elements ){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if(elements!=null) {
			for (int i = 0; i < elements.length; i++) {
				CodeDescription obj = new CodeDescription();
				obj.setCode(ConvertUtil.convertToString(i));
				obj.setDescription(elements[i]);
				result.add(obj);
			}
		}
		return result;
	}
	
	public static ArrayList<CodeDescription> createGenericListOfCodeDescriptionSameCode(String ...elements ){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if(elements!=null) {
			for (int i = 0; i < elements.length; i++) {
				CodeDescription obj = new CodeDescription();
				obj.setCode(elements[i]);
				obj.setDescription(elements[i]);
				result.add(obj);
			}
		}
		return result;
	}
	
	public static ArrayList<CodeDescription> createListOfCodeDescription(String ...elements ){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if(elements!=null) {
			for (int i = 0; i < elements.length; i++) {
				CodeDescription obj = new CodeDescription();
				obj.setCode(elements[i]);
				obj.setDescription(elements[i]);
				result.add(obj);
			}
		}
		return result;
	}
	
	public static ArrayList<CodeDescription> addFirstEmptyElement(String code, String description, ArrayList<CodeDescription> list){
		if(list!=null) {
			CodeDescription empty = new CodeDescription();
			empty.setCode(code);
			empty.setDescription(description);
			
			list.add(0, empty);
		}
		return list; 
	}
	 
	
}
