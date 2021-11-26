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

	
	<div id="p_fpWizardDatiSocioEconomiciSub1" class="formPanelBlock"><!-- startFragment:p_fpWizardDatiSocioEconomiciSub1 -->
		
	
<div class="formPanel" id="fpWizardDatiSocioEconomiciSub1">


	
	

	
	
			
	
	<div id="p_smpDomanda2.1" class="stdMessagePanelBlock"><!-- startFragment:p_smpDomanda2.1 -->
	
	
<div class="stdMessagePanel" id="smpDomanda2.1">
	<customtag:stdMessagePanel id="smpDomanda2.1" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpDomanda2.1 --></div>

			
	
	<div id="p_wpDatiSocioEconomici2.1" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomici2.1 -->
	
	

<div class="widgetsPanel" id="wpDatiSocioEconomici2.1">
	
	<customtag:widgetsPanel id="wpDatiSocioEconomici2.1Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="100">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwDatiSocioEconomiciSezione1.1')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwDatiSocioEconomiciSezione1.1" errorFor="widg_udwDatiSocioEconomiciSezione1.1" labelId="udwDatiSocioEconomiciSezione1.1Lbl"
	  >


<s:include value="/jsp/userwidgets/CpDomanda_udwDatiSocioEconomiciSezione1.1.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomici2.1 --></div>

			
	
	<div id="p_wpDatiSocioEconomiciFatturato" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomiciFatturato -->
	
	

<div class="widgetsPanel" id="wpDatiSocioEconomiciFatturato">
	
	<customtag:widgetsPanel id="wpDatiSocioEconomiciFatturatoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfDatiSocioEconomiciFatturatoAnnoInizioAttivita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiSocioEconomiciFatturatoAnnoInizioAttivita.label')}" labelFor="widg_tfDatiSocioEconomiciFatturatoAnnoInizioAttivita" errorFor="appDatafatturatoCategorieDiImpresa.annoInizioAttivita" labelId="tfDatiSocioEconomiciFatturatoAnnoInizioAttivitaLbl"
	position="first"  >


<!-- widget tfDatiSocioEconomiciFatturatoAnnoInizioAttivita -->
<s:textfield 
	
	
	name="appDatafatturatoCategorieDiImpresa.annoInizioAttivita" id="widg_tfDatiSocioEconomiciFatturatoAnnoInizioAttivita"
maxlength="4"	disabled="isWidgetDisabled('CpDomanda','tfDatiSocioEconomiciFatturatoAnnoInizioAttivita')"
	size="6" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiSocioEconomiciFatturatoUltimoAnno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiSocioEconomiciFatturatoUltimoAnno.label')}" labelFor="widg_tfDatiSocioEconomiciFatturatoUltimoAnno" errorFor="appDatafatturatoCategorieDiImpresa.fatturatoUltimoAnno" labelId="tfDatiSocioEconomiciFatturatoUltimoAnnoLbl"
	position="last"  >


<!-- widget tfDatiSocioEconomiciFatturatoUltimoAnno -->
<s:textfield 
	
	
	name="appDatafatturatoCategorieDiImpresa.fatturatoUltimoAnno" id="widg_tfDatiSocioEconomiciFatturatoUltimoAnno"
maxlength="20"	disabled="isWidgetDisabled('CpDomanda','tfDatiSocioEconomiciFatturatoUltimoAnno')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomiciFatturato --></div>

			
	
	<div id="p_wpDatiSocioEconomiciCategorieDiImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomiciCategorieDiImpresa -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiSocioEconomiciCategorieDiImpresa.label" /> </h4>
<div class="widgetsPanel" id="wpDatiSocioEconomiciCategorieDiImpresa">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblDatiSocioeconomiciCategorieImpresa')" >

	
<div class="tableWidget">


<!-- widget tblDatiSocioeconomiciCategorieImpresa -->
<s:set name="CpDomanda_tblDatiSocioeconomiciCategorieImpresa_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiSocioeconomiciCategorieImpresa')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoCategorieImpresa"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiSocioeconomiciCategorieImpresa"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiSocioeconomiciCategorieImpresa_clearStatus}"
               uid="row_tblDatiSocioeconomiciCategorieImpresa"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblDatiSocioeconomiciCategorieImpresaCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblDatiSocioeconomiciCategorieImpresa.idCategoria}" name="appDataidCategorieImpresaSelezionato" id="%{'tblDatiSocioeconomiciCategorieImpresa-editcell-'+ (#attr.row_tblDatiSocioeconomiciCategorieImpresa_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="dsCategoria" titleKey="CpDomanda.tblDatiSocioeconomiciCategorieImpresa.dsCategoria.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nomeCategoria" titleKey="CpDomanda.tblDatiSocioeconomiciCategorieImpresa.nomeCategoria.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="altro" titleKey="CpDomanda.tblDatiSocioeconomiciCategorieImpresa.altro.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','hiddenCategoriaAltro4')" >

	
<div class="hidden">


<!-- widget hiddenCategoriaAltro4 -->
<s:hidden name="appDatafatturatoCategorieDiImpresa.altro" id="widg_hiddenCategoriaAltro4" />

	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomiciCategorieDiImpresa --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardDatiSocioEconomiciSub1 --></div>
