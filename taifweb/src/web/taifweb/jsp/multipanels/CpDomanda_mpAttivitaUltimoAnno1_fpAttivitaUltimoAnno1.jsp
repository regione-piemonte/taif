#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAttivitaUltimoAnno1" class="formPanelBlock"><!-- startFragment:p_fpAttivitaUltimoAnno1 -->
		
	
<div class="formPanel" id="fpAttivitaUltimoAnno1">


	
	

	
	
			
	
	<div id="p_wpAttivitaUltimoAnno1InRegione" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno1InRegione -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpAttivitaUltimoAnno1InRegione.label" /> </h4>
<div class="widgetsPanel" id="wpAttivitaUltimoAnno1InRegione">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno1InRegioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="100">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','ptConsultaIstanzaTaglioPresentate')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptConsultaIstanzaTaglioPresentate" errorFor="widg_ptConsultaIstanzaTaglioPresentate" labelId="ptConsultaIstanzaTaglioPresentateLbl" colSpan="5" position="first" >


<!-- widget ptConsultaIstanzaTaglioPresentate -->
<s:text name="CpDomanda.ptConsultaIstanzaTaglioPresentate.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="6" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','btnConsultaIstanzaTaglioPresenti')" >

	
<customtag:widgetsPanelColumn colSpan="6" position="first">


<!-- widget btnConsultaIstanzaTaglioPresenti -->
<s:submit name="widg_btnConsultaIstanzaTaglioPresenti" id="widg_btnConsultaIstanzaTaglioPresenti" method="handleBtnConsultaIstanzaTaglioPresenti_CLICKED"
	key="CpDomanda.btnConsultaIstanzaTaglioPresenti.label" cssClass="buttonWidget detail"
	disabled="isWidgetDisabled('CpDomanda','btnConsultaIstanzaTaglioPresenti')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="6" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno1InRegione --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno1ElencoInRegione" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno1ElencoInRegione -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno1ElencoInRegione">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno1ElencoInRegioneTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione.label')}" labelFor="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTagliDiUtilizzazione" labelId="tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazioneLbl"
	position="first"  >


<!-- widget tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTagliDiUtilizzazione" id="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazione')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbUnitaMisuraTagliUtilizzazioneInRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbUnitaMisuraTagliUtilizzazioneInRegione.label')}" labelFor="widg_cbUnitaMisuraTagliUtilizzazioneInRegione" errorFor="appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato" labelId="cbUnitaMisuraTagliUtilizzazioneInRegioneLbl"
	  >


<!-- widget cbUnitaMisuraTagliUtilizzazioneInRegione -->
<s:select name="appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato" id="widg_cbUnitaMisuraTagliUtilizzazioneInRegione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaMisura"
	  disabled="isWidgetDisabled('CpDomanda','cbUnitaMisuraTagliUtilizzazioneInRegione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale.label')}" labelFor="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTagliDiUtilizzazioneContoTerzi" labelId="tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentualeLbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTagliDiUtilizzazioneContoTerzi" id="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliUtilizzazionePercentuale')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti.label')}" labelFor="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTaglioPioppeti" labelId="tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiLbl"
	position="first"  >


<!-- widget tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTaglioPioppeti" id="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppeti')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbUnitaMisuraTaglioPioppetoInRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbUnitaMisuraTaglioPioppetoInRegione.label')}" labelFor="widg_cbUnitaMisuraTaglioPioppetoInRegione" errorFor="appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato" labelId="cbUnitaMisuraTaglioPioppetoInRegioneLbl"
	  >


<!-- widget cbUnitaMisuraTaglioPioppetoInRegione -->
<s:select name="appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato" id="widg_cbUnitaMisuraTaglioPioppetoInRegione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaMisura"
	  disabled="isWidgetDisabled('CpDomanda','cbUnitaMisuraTaglioPioppetoInRegione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale.label')}" labelFor="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTaglioPioppetiContoTerzi" labelId="tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentualeLbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTaglioPioppetiContoTerzi" id="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTaglioPioppetiPercentuale')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari.label')}" labelFor="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTagliIntercalari" labelId="tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariLbl"
	position="first"  >


<!-- widget tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.totaleVolumiTagliIntercalari" id="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalari')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbUnitaMisuraTagliIntercalariInRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbUnitaMisuraTagliIntercalariInRegione.label')}" labelFor="widg_cbUnitaMisuraTagliIntercalariInRegione" errorFor="appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato" labelId="cbUnitaMisuraTagliIntercalariInRegioneLbl"
	  >


<!-- widget cbUnitaMisuraTagliIntercalariInRegione -->
<s:select name="appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato" id="widg_cbUnitaMisuraTagliIntercalariInRegione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaMisura"
	  disabled="isWidgetDisabled('CpDomanda','cbUnitaMisuraTagliIntercalariInRegione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale.label')}" labelFor="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTagliIntercalariContoTerzi" labelId="tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentualeLbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoInRegione.percentualeVolumiTagliIntercalariContoTerzi" id="widg_tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1InRegioneTotaliVolumiTagliIntercalariPercentuale')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno1ElencoInRegione --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno1ElencoFuoriRegione" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno1ElencoFuoriRegione -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpAttivitaUltimoAnno1ElencoFuoriRegione.label" /> </h4>
<div class="widgetsPanel" id="wpAttivitaUltimoAnno1ElencoFuoriRegione">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno1ElencoFuoriRegioneTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione.label')}" labelFor="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTagliDiUtilizzazione" labelId="tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazioneLbl"
	position="first"  >


<!-- widget tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTagliDiUtilizzazione" id="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazione')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbUnitaMisuraTagliUtilizzazioneFuoriRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbUnitaMisuraTagliUtilizzazioneFuoriRegione.label')}" labelFor="widg_cbUnitaMisuraTagliUtilizzazioneFuoriRegione" errorFor="appDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato" labelId="cbUnitaMisuraTagliUtilizzazioneFuoriRegioneLbl"
	  >


<!-- widget cbUnitaMisuraTagliUtilizzazioneFuoriRegione -->
<s:select name="appDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato" id="widg_cbUnitaMisuraTagliUtilizzazioneFuoriRegione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaMisura"
	  disabled="isWidgetDisabled('CpDomanda','cbUnitaMisuraTagliUtilizzazioneFuoriRegione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale.label')}" labelFor="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTagliDiUtilizzazioneContoTerzi" labelId="tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentualeLbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTagliDiUtilizzazioneContoTerzi" id="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliUtilizzazionePercentuale')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti.label')}" labelFor="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTaglioPioppeti" labelId="tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiLbl"
	position="first"  >


<!-- widget tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTaglioPioppeti" id="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppeti')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbUnitaMisuraTaglioPioppetoFuoriRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbUnitaMisuraTaglioPioppetoFuoriRegione.label')}" labelFor="widg_cbUnitaMisuraTaglioPioppetoFuoriRegione" errorFor="appDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato" labelId="cbUnitaMisuraTaglioPioppetoFuoriRegioneLbl"
	  >


<!-- widget cbUnitaMisuraTaglioPioppetoFuoriRegione -->
<s:select name="appDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato" id="widg_cbUnitaMisuraTaglioPioppetoFuoriRegione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaMisura"
	  disabled="isWidgetDisabled('CpDomanda','cbUnitaMisuraTaglioPioppetoFuoriRegione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale.label')}" labelFor="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTaglioPioppetiContoTerzi" labelId="tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentualeLbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTaglioPioppetiContoTerzi" id="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTaglioPioppetiPercentuale')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari.label')}" labelFor="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTagliIntercalari" labelId="tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariLbl"
	position="first"  >


<!-- widget tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.totaleVolumiTagliIntercalari" id="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalari')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbUnitaMisuraTagliIntercalariFuoriRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbUnitaMisuraTagliIntercalariFuoriRegione.label')}" labelFor="widg_cbUnitaMisuraTagliIntercalariFuoriRegione" errorFor="appDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato" labelId="cbUnitaMisuraTagliIntercalariFuoriRegioneLbl"
	  >


<!-- widget cbUnitaMisuraTagliIntercalariFuoriRegione -->
<s:select name="appDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato" id="widg_cbUnitaMisuraTagliIntercalariFuoriRegione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaMisura"
	  disabled="isWidgetDisabled('CpDomanda','cbUnitaMisuraTagliIntercalariFuoriRegione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale.label')}" labelFor="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTagliIntercalariContoTerzi" labelId="tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentualeLbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.interventoFuoriRegione.percentualeVolumiTagliIntercalariContoTerzi" id="widg_tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale"
	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1FuoriRegioneTotaliVolumiTagliIntercalariPercentuale')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno1ElencoFuoriRegione --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaUltimoAnno1 --></div>
