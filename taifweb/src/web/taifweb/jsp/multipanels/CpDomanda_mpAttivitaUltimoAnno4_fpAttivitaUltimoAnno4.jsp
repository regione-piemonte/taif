#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/domanda/CpDomandaAction" />

	
	<div id="p_fpAttivitaUltimoAnno4" class="formPanelBlock"><!-- startFragment:p_fpAttivitaUltimoAnno4 -->
		
	
<div class="formPanel" id="fpAttivitaUltimoAnno4">


	
	

	
	
			
	
	<div id="p_wpAttivitaUltimoAnno4" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno4 -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpAttivitaUltimoAnno4.label" /> </h4>
<div class="widgetsPanel" id="wpAttivitaUltimoAnno4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAttivitaUltimoAnno4')" >

	
<div class="tableWidget">


<!-- widget tblAttivitaUltimoAnno4 -->
<s:set name="CpDomanda_tblAttivitaUltimoAnno4_clearStatus" value="isTableClearStatus('CpDomanda_tblAttivitaUltimoAnno4')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMaterialePropagazione"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttivitaUltimoAnno4"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAttivitaUltimoAnno4_clearStatus}"
               uid="row_tblAttivitaUltimoAnno4"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblAttivitaUltimoAnno4CustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tblAttivitaUltimoAnno4.idMaterialePropagazione}" name="appDataidMaterialiPropagazione" id="%{'tblAttivitaUltimoAnno4-editcell-'+ (#attr.row_tblAttivitaUltimoAnno4_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="dsMaterialePropagazione" titleKey="CpDomanda.tblAttivitaUltimoAnno4.dsMaterialePropagazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="altro" titleKey="CpDomanda.tblAttivitaUltimoAnno4.altro.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>

<s:hidden name="__tableselectionempty_appDataidMaterialiPropagazione" id="__tableselectionempty_widg_tblAttivitaUltimoAnno4" />




	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','hiddenAttivitaUltimoAnno4Altro')" >

	
<div class="hidden">


<!-- widget hiddenAttivitaUltimoAnno4Altro -->
<s:hidden name="appDataelencoMaterialePropagazione.altro" id="widg_hiddenAttivitaUltimoAnno4Altro" />

	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno4 --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaUltimoAnno4 --></div>
