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

	
	<div id="p_fpDatiSocioEconomiciCertificazioniQualitaProcesso" class="formPanelBlock"><!-- startFragment:p_fpDatiSocioEconomiciCertificazioniQualitaProcesso -->
		
	
<div class="formPanel" id="fpDatiSocioEconomiciCertificazioniQualitaProcesso">


	
	

	
	
			
	
	<div id="p_wpDatiSocioEconomiciCertificazioni" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomiciCertificazioni -->
	
	

<div class="widgetsPanel" id="wpDatiSocioEconomiciCertificazioni">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tbDatiSocioEconomiciCertificazioni')" >

	
<div class="tableWidget">


<!-- widget tbDatiSocioEconomiciCertificazioni -->
<s:set name="CpDomanda_tbDatiSocioEconomiciCertificazioni_clearStatus" value="isTableClearStatus('CpDomanda_tbDatiSocioEconomiciCertificazioni')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoCertificazioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tbDatiSocioEconomiciCertificazioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tbDatiSocioEconomiciCertificazioni_clearStatus}"
               uid="row_tbDatiSocioEconomiciCertificazioni"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTbDatiSocioEconomiciCertificazioniCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciCertificazioni.idTipoCertificazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoCertificazioni['+(#attr.row_tbDatiSocioEconomiciCertificazioni_rowNum - 1)+'].idTipoCertificazione'}" headerKey="" headerValue=""  list= "appDataelencoCertificazioni[(#attr.row_tbDatiSocioEconomiciCertificazioni_rowNum - 1)].elencoTipoCertificazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciCertificazioni.numero.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCertificazioni['+(#attr.row_tbDatiSocioEconomiciCertificazioni_rowNum - 1)+'].numero'}"   theme="csi-tableinput-rem" maxlength="15" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciCertificazioni.enteCertificatore.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCertificazioni['+(#attr.row_tbDatiSocioEconomiciCertificazioni_rowNum - 1)+'].enteCertificatore'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciCertificazioni.annoRilascio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCertificazioni['+(#attr.row_tbDatiSocioEconomiciCertificazioni_rowNum - 1)+'].annoRilascio'}"   theme="csi-tableinput-rem" maxlength="4" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciCertificazioni.dataScadenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCertificazioni['+(#attr.row_tbDatiSocioEconomiciCertificazioni_rowNum - 1)+'].dataScadenza'}"   theme="csi-tableinput-rem" maxlength="10" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciCertificazioni.altro.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCertificazioni['+(#attr.row_tbDatiSocioEconomiciCertificazioni_rowNum - 1)+'].altro'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tbDatiSocioEconomiciCertificazioni.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomiciCertificazioni --></div>

			
	
	<div id="p_cmdAggiungiCertificazioneQualitaProcesso" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiCertificazioneQualitaProcesso -->
	
	
<div class="commandPanel functional" id="cmdAggiungiCertificazioneQualitaProcesso">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddCertificazioneQualitaProcesso')" >

	



<!-- widget btnAddCertificazioneQualitaProcesso -->
<s:submit name="widg_btnAddCertificazioneQualitaProcesso" id="widg_btnAddCertificazioneQualitaProcesso" method="handleBtnAddCertificazioneQualitaProcesso_CLICKED"
	key="CpDomanda.btnAddCertificazioneQualitaProcesso.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddCertificazioneQualitaProcesso')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiCertificazioneQualitaProcesso --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiSocioEconomiciCertificazioniQualitaProcesso --></div>
