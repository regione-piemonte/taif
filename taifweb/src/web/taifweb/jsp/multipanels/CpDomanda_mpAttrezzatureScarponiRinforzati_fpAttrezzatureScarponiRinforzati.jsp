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

	
	<div id="p_fpAttrezzatureScarponiRinforzati" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureScarponiRinforzati -->
		
	
<div class="formPanel" id="fpAttrezzatureScarponiRinforzati">


	
	

	
	
			
	
	<div id="p_wpElencoAttrezzatureScarponiRinforzati" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAttrezzatureScarponiRinforzati -->
	
	

<div class="widgetsPanel" id="wpElencoAttrezzatureScarponiRinforzati">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAttrezzatureScarponiRinforzati')" >

	
<div class="tableWidget">


<!-- widget tblAttrezzatureScarponiRinforzati -->
<s:set name="CpDomanda_tblAttrezzatureScarponiRinforzati_clearStatus" value="isTableClearStatus('CpDomanda_tblAttrezzatureScarponiRinforzati')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoScarponiRinforzatiAttrezzature"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttrezzatureScarponiRinforzati"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAttrezzatureScarponiRinforzati_clearStatus}"
               uid="row_tblAttrezzatureScarponiRinforzati"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblAttrezzatureScarponiRinforzatiCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblAttrezzatureScarponiRinforzati.quantita.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoScarponiRinforzatiAttrezzature['+(#attr.row_tblAttrezzatureScarponiRinforzati_rowNum - 1)+'].quantita'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttrezzatureScarponiRinforzati.annoScadenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoScarponiRinforzatiAttrezzature['+(#attr.row_tblAttrezzatureScarponiRinforzati_rowNum - 1)+'].annoScadenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttrezzatureScarponiRinforzati.tipologia.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoScarponiRinforzatiAttrezzature['+(#attr.row_tblAttrezzatureScarponiRinforzati_rowNum - 1)+'].tipologia'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblAttrezzatureScarponiRinforzati.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAttrezzatureScarponiRinforzati --></div>

			
	
	<div id="p_cmdAggiungAttrezzaturaScarponiRinforzati" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungAttrezzaturaScarponiRinforzati -->
	
	
<div class="commandPanel functional" id="cmdAggiungAttrezzaturaScarponiRinforzati">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaScarponiRinforzati')" >

	



<!-- widget btnAddAttrezzaturaScarponiRinforzati -->
<s:submit name="widg_btnAddAttrezzaturaScarponiRinforzati" id="widg_btnAddAttrezzaturaScarponiRinforzati" method="handleBtnAddAttrezzaturaScarponiRinforzati_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaScarponiRinforzati.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaScarponiRinforzati')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungAttrezzaturaScarponiRinforzati --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureScarponiRinforzati --></div>
