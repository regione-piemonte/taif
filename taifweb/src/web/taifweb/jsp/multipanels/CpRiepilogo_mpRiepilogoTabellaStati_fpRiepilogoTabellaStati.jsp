#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/common/CpRiepilogoAction" />

	
	<div id="p_fpRiepilogoTabellaStati" class="formPanelBlock"><!-- startFragment:p_fpRiepilogoTabellaStati -->
		
	
<div class="formPanel" id="fpRiepilogoTabellaStati">


	
	

	
	
			
	
	<div id="p_wpRiepilogoTabellaStati" class="widgetsPanelBlock"><!-- startFragment:p_wpRiepilogoTabellaStati -->
	
	

<div class="widgetsPanel" id="wpRiepilogoTabellaStati">
	

	
	
<s:if test="isWidgetVisible('CpRiepilogo','tblElencoStatiDomanda')" >

	
<div class="tableWidget">


<!-- widget tblElencoStatiDomanda -->
	<csiuicore:ajaxify id="p_wpRiepilogoStatoDomanda,p_fpRiepilogoStatoDomanda,p_wpRiepilogoTabellaStati" 
		widgetType="table"		
		pageId="CpRiepilogo"
		javascriptDetection="false">
<s:set name="CpRiepilogo_tblElencoStatiDomanda_clearStatus" value="isTableClearStatus('CpRiepilogo_tblElencoStatiDomanda')" />
<s:url id="CpRiepilogoViewUrl"						   
					   action="CpRiepilogo"
					   namespace="/base/common"/>
<display:table name="appDataelencoGestioneStatiRiepilogo"  				
			   excludedParams="*"			   export="false"
               id="widg_tblElencoStatiDomanda"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpRiepilogoViewUrl}"  
               clearStatus="${CpRiepilogo_tblElencoStatiDomanda_clearStatus}"
               uid="row_tblElencoStatiDomanda"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.common.CpRiepilogoTblElencoStatiDomandaCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpRiepilogo.tblElencoStatiDomanda.idStatoDomanda.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoGestioneStatiRiepilogo['+(#attr.row_tblElencoStatiDomanda_rowNum - 1)+'].idStatoDomanda'}" headerKey="" headerValue=""  list= "appDataelencoGestioneStatiRiepilogo[(#attr.row_tblElencoStatiDomanda_rowNum - 1)].elencoStatiDomanda"  disabled="%{!appDataelencoGestioneStatiRiepilogo[(#attr.row_tblElencoStatiDomanda_rowNum - 1)].statoEditabile}"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpRiepilogo.tblElencoStatiDomanda.numeroProtocollo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoGestioneStatiRiepilogo['+(#attr.row_tblElencoStatiDomanda_rowNum - 1)+'].numeroProtocollo'}"  disabled="%{!appDataelencoGestioneStatiRiepilogo[(#attr.row_tblElencoStatiDomanda_rowNum - 1)].numeroProtocolloEditabile}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpRiepilogo.tblElencoStatiDomanda.dataProtocollo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoGestioneStatiRiepilogo['+(#attr.row_tblElencoStatiDomanda_rowNum - 1)+'].dataProtocollo'}"  disabled="%{!appDataelencoGestioneStatiRiepilogo[(#attr.row_tblElencoStatiDomanda_rowNum - 1)].dataProtocolloEditabile}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="dataUltimaModifica" titleKey="CpRiepilogo.tblElencoStatiDomanda.dataUltimaModifica.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="operatoreUltimaModifica" titleKey="CpRiepilogo.tblElencoStatiDomanda.operatoreUltimaModifica.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="CpRiepilogo.tblElencoStatiDomanda.note.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoGestioneStatiRiepilogo['+(#attr.row_tblElencoStatiDomanda_rowNum - 1)+'].note'}"  disabled="%{!appDataelencoGestioneStatiRiepilogo[(#attr.row_tblElencoStatiDomanda_rowNum - 1)].noteEditabile}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaModifica" titleKey="CpRiepilogo.tblElencoStatiDomanda.iconaModifica.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaSalva" titleKey="CpRiepilogo.tblElencoStatiDomanda.iconaSalva.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaCancella" titleKey="CpRiepilogo.tblElencoStatiDomanda.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRiepilogoTabellaStati --></div>

			
	
	<div id="p_cmdAggiungiStato" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiStato -->
	
	
<div class="commandPanel functional" id="cmdAggiungiStato">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpRiepilogo','btnChiudiSezioneStato')" >

	



<!-- widget btnChiudiSezioneStato -->
<s:submit name="widg_btnChiudiSezioneStato" id="widg_btnChiudiSezioneStato" method="handleBtnChiudiSezioneStato_CLICKED"
	key="CpRiepilogo.btnChiudiSezioneStato.label" cssClass="buttonWidget deleteItem"
	disabled="isWidgetDisabled('CpRiepilogo','btnChiudiSezioneStato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('CpRiepilogo','btnAddStato')" >

	



<!-- widget btnAddStato -->
<s:submit name="widg_btnAddStato" id="widg_btnAddStato" method="handleBtnAddStato_CLICKED"
	key="CpRiepilogo.btnAddStato.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpRiepilogo','btnAddStato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiStato --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRiepilogoTabellaStati --></div>
