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

	
	<div id="p_fpWizardDatiSocioEconomiciSub2" class="formPanelBlock"><!-- startFragment:p_fpWizardDatiSocioEconomiciSub2 -->
		
	


	
	

	
	
			
	
	<div id="p_smpDomanda2.2" class="stdMessagePanelBlock"><!-- startFragment:p_smpDomanda2.2 -->
	
	
<div class="stdMessagePanel" id="smpDomanda2.2">
	<customtag:stdMessagePanel id="smpDomanda2.2" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpDomanda2.2 --></div>

			
	
	<div id="p_wpDatiSocioEconomici2.2" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomici2.2 -->
	
	

<div class="widgetsPanel" id="wpDatiSocioEconomici2.2">
	
	<customtag:widgetsPanel id="wpDatiSocioEconomici2.2Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="100">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwDatiSocioEconomiciSezione1.2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwDatiSocioEconomiciSezione1.2" errorFor="widg_udwDatiSocioEconomiciSezione1.2" labelId="udwDatiSocioEconomiciSezione1.2Lbl"
	  >


<s:include value="/jsp/userwidgets/CpDomanda_udwDatiSocioEconomiciSezione1.2.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomici2.2 --></div>

			
	
	<div id="p_wpDatiSocioEconomiciAltriAlbi" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomiciAltriAlbi -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiSocioEconomiciAltriAlbi.label" /> </h4>
<div class="widgetsPanel" id="wpDatiSocioEconomiciAltriAlbi">
	
	<customtag:widgetsPanel id="wpDatiSocioEconomiciAltriAlbiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','rbsDatiSocioEconomiciAltriAlbi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.rbsDatiSocioEconomiciAltriAlbi.label')}" labelFor="widg_rbsDatiSocioEconomiciAltriAlbi" errorFor="widg_rbsDatiSocioEconomiciAltriAlbi" labelId="rbsDatiSocioEconomiciAltriAlbiLbl"
	  >


<!-- widget rbsDatiSocioEconomiciAltriAlbi -->

	
<div id="widg_rbsDatiSocioEconomiciAltriAlbi" class="radiobuttons horizontal">





<div>

<s:url id="widg_rbsDatiSocioEconomiciAltriAlbiurlRadioButtonValueChange"
   action="/taifweb/CpDomanda!handleRbsDatiSocioEconomiciAltriAlbi_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbDatiSocioEconomiciAltriAlbiSi" name="widg_rbsDatiSocioEconomiciAltriAlbi"
	list="#{'SI':'Si'}"
	disabled="isWidgetDisabled('CpDomanda','rbsDatiSocioEconomiciAltriAlbi')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsDatiSocioEconomiciAltriAlbiurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbDatiSocioEconomiciAltriAlbiSiSI"><s:text name="CpDomanda.rbsDatiSocioEconomiciAltriAlbi.rbDatiSocioEconomiciAltriAlbiSi.label" /></label>
</div>





<div>

<s:radio
	
	
	id="widg_rbDatiSocioEconomiciAltriAlbiNo" name="widg_rbsDatiSocioEconomiciAltriAlbi"
	list="#{'NO':'No'}"
	disabled="isWidgetDisabled('CpDomanda','rbsDatiSocioEconomiciAltriAlbi')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsDatiSocioEconomiciAltriAlbiurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbDatiSocioEconomiciAltriAlbiNoNO"><s:text name="CpDomanda.rbsDatiSocioEconomiciAltriAlbi.rbDatiSocioEconomiciAltriAlbiNo.label" /></label>
</div>




	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomiciAltriAlbi --></div>

			
	
	
	<div id="p_mpDatiSocioEconomiciAltriAlbi" class="panelBlock"><!-- startFragment:p_mpDatiSocioEconomiciAltriAlbi -->
		

		
<s:if test="#session.CpDomanda_mpDatiSocioEconomiciAltriAlbi_selectedMultiPanel == 'CpDomanda_mpDatiSocioEconomiciAltriAlbi_fpDatiSocioEconomiciAltriAlbi'">
	<s:include value="/jsp/multipanels/CpDomanda_mpDatiSocioEconomiciAltriAlbi_fpDatiSocioEconomiciAltriAlbi.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiSocioEconomiciAltriAlbi --></div>

			
	
	<div id="p_wpDatiSocioEconomiciFormeOrganizzative" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomiciFormeOrganizzative -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiSocioEconomiciFormeOrganizzative.label" /> </h4>
<div class="widgetsPanel" id="wpDatiSocioEconomiciFormeOrganizzative">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblDatiSocioeconomiciFormaOrganizzativa')" >

	
<div class="tableWidget">


<!-- widget tblDatiSocioeconomiciFormaOrganizzativa -->
<s:set name="CpDomanda_tblDatiSocioeconomiciFormaOrganizzativa_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiSocioeconomiciFormaOrganizzativa')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoFormeOrganizzative"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiSocioeconomiciFormaOrganizzativa"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiSocioeconomiciFormaOrganizzativa_clearStatus}"
               uid="row_tblDatiSocioeconomiciFormaOrganizzativa"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblDatiSocioeconomiciFormaOrganizzativaCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tblDatiSocioeconomiciFormaOrganizzativa.idFormaOrganizzativa}" name="appDataidFormeOrganizzative" id="%{'tblDatiSocioeconomiciFormaOrganizzativa-editcell-'+ (#attr.row_tblDatiSocioeconomiciFormaOrganizzativa_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="dsFormaOrganizzativa" titleKey="CpDomanda.tblDatiSocioeconomiciFormaOrganizzativa.dsFormaOrganizzativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="altro" titleKey="CpDomanda.tblDatiSocioeconomiciFormaOrganizzativa.altro.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>

<s:hidden name="__tableselectionempty_appDataidFormeOrganizzative" id="__tableselectionempty_widg_tblDatiSocioeconomiciFormaOrganizzativa" />




	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','hiddenFormeOrganizzativeAltro4')" >

	
<div class="hidden">


<!-- widget hiddenFormeOrganizzativeAltro4 -->
<s:hidden name="appDataassociazioniECertificazioni.altro4" id="widg_hiddenFormeOrganizzativeAltro4" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','hiddenFormeOrganizzativeAltro5')" >

	
<div class="hidden">


<!-- widget hiddenFormeOrganizzativeAltro5 -->
<s:hidden name="appDataassociazioniECertificazioni.altro5" id="widg_hiddenFormeOrganizzativeAltro5" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','hiddenFormeOrganizzativeAltro6')" >

	
<div class="hidden">


<!-- widget hiddenFormeOrganizzativeAltro6 -->
<s:hidden name="appDataassociazioniECertificazioni.altro6" id="widg_hiddenFormeOrganizzativeAltro6" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','hiddenFormeOrganizzativeAltroTest')" >

	
<div class="hidden">


<!-- widget hiddenFormeOrganizzativeAltroTest -->
<s:hidden name="appDatafatturatoCategorieDiImpresa.altro" id="widg_hiddenFormeOrganizzativeAltroTest" />

	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomiciFormeOrganizzative --></div>

			
	
	<div id="p_wpDatiSocioEconomiciCertificazioniQualitaProcesso" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomiciCertificazioniQualitaProcesso -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiSocioEconomiciCertificazioniQualitaProcesso.label" /> </h4>
<div class="widgetsPanel" id="wpDatiSocioEconomiciCertificazioniQualitaProcesso">
	
	<customtag:widgetsPanel id="wpDatiSocioEconomiciCertificazioniQualitaProcessoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','rbsDatiSocioEconomiciCertificazioniQualitaProcesso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.rbsDatiSocioEconomiciCertificazioniQualitaProcesso.label')}" labelFor="widg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso" errorFor="widg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso" labelId="rbsDatiSocioEconomiciCertificazioniQualitaProcessoLbl"
	  >


<!-- widget rbsDatiSocioEconomiciCertificazioniQualitaProcesso -->

	
<div id="widg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso" class="radiobuttons horizontal">





<div>

<s:url id="widg_rbsDatiSocioEconomiciCertificazioniQualitaProcessourlRadioButtonValueChange"
   action="/taifweb/CpDomanda!handleRbsDatiSocioEconomiciCertificazioniQualitaProcesso_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbDatiSocioEconomiciCertificazioniSi" name="widg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso"
	list="#{'SI':'Si'}"
	disabled="isWidgetDisabled('CpDomanda','rbsDatiSocioEconomiciCertificazioniQualitaProcesso')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsDatiSocioEconomiciCertificazioniQualitaProcessourlRadioButtonValueChange}')" 
	/> <label  for="widg_rbDatiSocioEconomiciCertificazioniSiSI"><s:text name="CpDomanda.rbsDatiSocioEconomiciCertificazioniQualitaProcesso.rbDatiSocioEconomiciCertificazioniSi.label" /></label>
</div>





<div>

<s:radio
	
	
	id="widg_rbDatiSocioEconomiciCertificazioniNo" name="widg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso"
	list="#{'NO':'No'}"
	disabled="isWidgetDisabled('CpDomanda','rbsDatiSocioEconomiciCertificazioniQualitaProcesso')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsDatiSocioEconomiciCertificazioniQualitaProcessourlRadioButtonValueChange}')" 
	/> <label  for="widg_rbDatiSocioEconomiciCertificazioniNoNO"><s:text name="CpDomanda.rbsDatiSocioEconomiciCertificazioniQualitaProcesso.rbDatiSocioEconomiciCertificazioniNo.label" /></label>
</div>




	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomiciCertificazioniQualitaProcesso --></div>

			
	
	
	<div id="p_mpDatiSocioEconomiciCertificazioniQualitaProcesso" class="panelBlock"><!-- startFragment:p_mpDatiSocioEconomiciCertificazioniQualitaProcesso -->
		

		
<s:if test="#session.CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_selectedMultiPanel == 'CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_fpDatiSocioEconomiciCertificazioniQualitaProcesso'">
	<s:include value="/jsp/multipanels/CpDomanda_mpDatiSocioEconomiciCertificazioniQualitaProcesso_fpDatiSocioEconomiciCertificazioniQualitaProcesso.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiSocioEconomiciCertificazioniQualitaProcesso --></div>

	

		
	

	<!-- endFragment:p_fpWizardDatiSocioEconomiciSub2 --></div>
