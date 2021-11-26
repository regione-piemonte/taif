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

	
	<div id="p_fpStrutturePiazzaliStoccaggio" class="formPanelBlock"><!-- startFragment:p_fpStrutturePiazzaliStoccaggio -->
		
	
<div class="formPanel" id="fpStrutturePiazzaliStoccaggio">


	
	

	
	
			
	
	<div id="p_wpElencoPiazzaliStoccaggio" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoPiazzaliStoccaggio -->
	
	

<div class="widgetsPanel" id="wpElencoPiazzaliStoccaggio">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblStrutturePiazzaliStoccaggio')" >

	
<div class="tableWidget">


<!-- widget tblStrutturePiazzaliStoccaggio -->
<s:set name="CpDomanda_tblStrutturePiazzaliStoccaggio_clearStatus" value="isTableClearStatus('CpDomanda_tblStrutturePiazzaliStoccaggio')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoPiazzaliStoccaggio"  				
			   excludedParams="*"			   export="false"
               id="widg_tblStrutturePiazzaliStoccaggio"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblStrutturePiazzaliStoccaggio_clearStatus}"
               uid="row_tblStrutturePiazzaliStoccaggio"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblStrutturePiazzaliStoccaggioCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblStrutturePiazzaliStoccaggio.dimensionePiazzale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPiazzaliStoccaggio['+(#attr.row_tblStrutturePiazzaliStoccaggio_rowNum - 1)+'].dimensionePiazzale'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblStrutturePiazzaliStoccaggio.annoCostruzioneORiattamentoPiazzale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPiazzaliStoccaggio['+(#attr.row_tblStrutturePiazzaliStoccaggio_rowNum - 1)+'].annoCostruzioneORiattamentoPiazzale'}"   theme="csi-tableinput-rem" maxlength="4" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblStrutturePiazzaliStoccaggio.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoPiazzaliStoccaggio --></div>

			
	
	<div id="p_cmdAggiungiPiazzaliStoccaggio" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiPiazzaliStoccaggio -->
	
	
<div class="commandPanel functional" id="cmdAggiungiPiazzaliStoccaggio">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddPiazzaleStoccaggio')" >

	



<!-- widget btnAddPiazzaleStoccaggio -->
<s:submit name="widg_btnAddPiazzaleStoccaggio" id="widg_btnAddPiazzaleStoccaggio" method="handleBtnAddPiazzaleStoccaggio_CLICKED"
	key="CpDomanda.btnAddPiazzaleStoccaggio.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddPiazzaleStoccaggio')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiPiazzaliStoccaggio --></div>

	

		
	
</div>

	<!-- endFragment:p_fpStrutturePiazzaliStoccaggio --></div>
