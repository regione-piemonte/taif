#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestore -->
<!-- pageId:cpRicercaOperatoreForestaleGestore -->

<s:form id="cpRicercaOperatoreForestaleGestore" action="cpRicercaOperatoreForestaleGestore" namespace="/base/gestore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpRicercaOperatoreForestaleGestoreUserInfo" class="formPanelBlock"><!-- startFragment:p_fpRicercaOperatoreForestaleGestoreUserInfo -->

	
	

	
	
			
	
	<div id="p_uipRicercaOperatoreForestaleGestore" class="userInfoPanelBlock"><!-- startFragment:p_uipRicercaOperatoreForestaleGestore -->
	
	
<div class="userInfoPanel" id="uipRicercaOperatoreForestaleGestore">
	<div class="userData">
		<span class="user">Utente: <span class="value"><s:property value="appDatacurrentUser.nome" /> <s:property value="appDatacurrentUser.cognome" /></span></span>
		<span class="organization">Ente: <span class="value"><s:property value="appDatacurrentUser.ente" /></span></span>
		<span class="role">Ruolo: <span class="value"><s:property value="appDatacurrentUser.ruolo" /></span></span>
	</div>
	<div class="userInfoActions">
		<!-- uscita dal servizio e/o cambio ruolo -->
		<s:url id="logoutUrl" action="Logout" namespace="/secure" method="confirmLogout" />
		<s:a href="%{logoutUrl}" title="chiudi: questo link fa uscire dal servizio">esci</s:a>
	</div>
</div>

	<!-- endFragment:p_uipRicercaOperatoreForestaleGestore --></div>

	

	<!-- endFragment:p_fpRicercaOperatoreForestaleGestoreUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpRicercaOperatoreForestaleGestore.fpRicercaOperatoreForestaleGestore.label" /></h3>

					
	
	<div id="p_fpRicercaOperatoreForestaleGestoreBody" class="formPanelBlock"><!-- startFragment:p_fpRicercaOperatoreForestaleGestoreBody -->

	
	

	
	
			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_wpRicercaOperatoreForestaleGestore" class="widgetsPanelBlock scroll"><!-- startFragment:p_wpRicercaOperatoreForestaleGestore -->
	
	

<div class="widgetsPanel" id="wpRicercaOperatoreForestaleGestore">
	
	<customtag:widgetsPanel id="wpRicercaOperatoreForestaleGestoreTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','cbAlboAppartenenzaOperatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.cbAlboAppartenenzaOperatore.label')}" labelFor="widg_cbAlboAppartenenzaOperatore" errorFor="appDataelencoAlbiSelezionatiRicercaOperatore" labelId="cbAlboAppartenenzaOperatoreLbl"
	position="first"  >


<!-- widget cbAlboAppartenenzaOperatore -->
<s:select name="appDataelencoAlbiSelezionatiRicercaOperatore" id="widg_cbAlboAppartenenzaOperatore"
	 
	
		title=""
			
	   
	  list="appDataelencoAlbiRicercaOperatore"
	  disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','cbAlboAppartenenzaOperatore')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaOperatoreForestaleGestore_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','cbAmbitoFormativo')" >

	
<customtag:widgetsPanelColumn  tooltip="description" labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.cbAmbitoFormativo.label')}" labelFor="widg_cbAmbitoFormativo" errorFor="appDataidAmbitoFormativoSelezionato" labelId="cbAmbitoFormativoLbl"
	position="first" colSpan="3" >


<!-- widget cbAmbitoFormativo -->

<s:url id="widg_cbAmbitoFormativourlComboBoxValueChange"
   action="/topforweb/cpRicercaOperatoreForestaleGestore!handleCbAmbitoFormativo_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidAmbitoFormativoSelezionato" id="widg_cbAmbitoFormativo"
	 
	

		title="description - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	   
	  list="appDataelencoAmbitoFormativoRicercaOperatore"
	  disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','cbAmbitoFormativo')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbAmbitoFormativo','conferma','%{widg_cbAmbitoFormativourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbAmbitoFormativo','conferma','%{widg_cbAmbitoFormativourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','cbUnitaFormativa')" >

	
<customtag:widgetsPanelColumn  tooltip="description" labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.cbUnitaFormativa.label')}" labelFor="widg_cbUnitaFormativa" errorFor="appDataidUnitaFormativaSelezionata" labelId="cbUnitaFormativaLbl"
	position="last" colSpan="3" >


<!-- widget cbUnitaFormativa -->
<s:select name="appDataidUnitaFormativaSelezionata" id="widg_cbUnitaFormativa"
	 
	
		title="description"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaFormativaRicercaOperatore"
	  disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','cbUnitaFormativa')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','tRicercaCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.tRicercaCognome.label')}" labelFor="widg_tRicercaCognome" errorFor="appDatacognomeRicercaOperatore" labelId="tRicercaCognomeLbl"
	position="first"  >


<!-- widget tRicercaCognome -->
<s:textfield 
	
	
	name="appDatacognomeRicercaOperatore" id="widg_tRicercaCognome"
	disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','tRicercaCognome')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','cbAgenziaFormativa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.cbAgenziaFormativa.label')}" labelFor="widg_cbAgenziaFormativa" errorFor="appDataidAgenziaFormativaSelezionata" labelId="cbAgenziaFormativaLbl"
	  >


<!-- widget cbAgenziaFormativa -->
<s:select name="appDataidAgenziaFormativaSelezionata" id="widg_cbAgenziaFormativa"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAgenziaFormativaRicercaOperatore"
	  disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','cbAgenziaFormativa')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_3_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaOperatoreForestaleGestore_3_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','calPeriodoSvolgimentoRicercaOperatoreDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.calPeriodoSvolgimentoRicercaOperatoreDa.label')}" labelFor="widg_calPeriodoSvolgimentoRicercaOperatoreDa" errorFor="appDatadataPeriodoSvolgimentoDa" labelId="calPeriodoSvolgimentoRicercaOperatoreDaLbl"
	position="first"  >


<!-- widget calPeriodoSvolgimentoRicercaOperatoreDa -->
<s:textfield 
	
	
	name="appDatadataPeriodoSvolgimentoDa" id="widg_calPeriodoSvolgimentoRicercaOperatoreDa"
	disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','calPeriodoSvolgimentoRicercaOperatoreDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','calPeriodoSvolgimentoRicercaOperatoreA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.calPeriodoSvolgimentoRicercaOperatoreA.label')}" labelFor="widg_calPeriodoSvolgimentoRicercaOperatoreA" errorFor="appDatadataPeriodoSvolgimentoA" labelId="calPeriodoSvolgimentoRicercaOperatoreALbl"
	  >


<!-- widget calPeriodoSvolgimentoRicercaOperatoreA -->
<s:textfield 
	
	
	name="appDatadataPeriodoSvolgimentoA" id="widg_calPeriodoSvolgimentoRicercaOperatoreA"
	disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','calPeriodoSvolgimentoRicercaOperatoreA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_4_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaOperatoreForestaleGestore_4_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','chbConQualificaRicercaOperatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.chbConQualificaRicercaOperatore.label')}" labelFor="widg_chbConQualificaRicercaOperatore" errorFor="appDataisOperatoreConQualifica" labelId="chbConQualificaRicercaOperatoreLbl"
	position="first"  >


<!-- widget chbConQualificaRicercaOperatore -->
<s:checkbox 
	
	
	name="appDataisOperatoreConQualifica" id="widg_chbConQualificaRicercaOperatore"
	disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','chbConQualificaRicercaOperatore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaOperatoreForestaleGestore','chbConQualificaRicercaOperatore')" >
	<s:hidden name="__checkbox_appDataisOperatoreConQualifica" id="__checkbox_widg_chbConQualificaRicercaOperatore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','chbIstruttoreRicercaOperatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.chbIstruttoreRicercaOperatore.label')}" labelFor="widg_chbIstruttoreRicercaOperatore" errorFor="appDataisIstruttoreOperatore" labelId="chbIstruttoreRicercaOperatoreLbl"
	  >


<!-- widget chbIstruttoreRicercaOperatore -->
<s:checkbox 
	
	
	name="appDataisIstruttoreOperatore" id="widg_chbIstruttoreRicercaOperatore"
	disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','chbIstruttoreRicercaOperatore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaOperatoreForestaleGestore','chbIstruttoreRicercaOperatore')" >
	<s:hidden name="__checkbox_appDataisIstruttoreOperatore" id="__checkbox_widg_chbIstruttoreRicercaOperatore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_5_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaOperatoreForestaleGestore_5_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','cbStatoOperatoreRicerca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.cbStatoOperatoreRicerca.label')}" labelFor="widg_cbStatoOperatoreRicerca" errorFor="appDataidStatoOperatoreSelezionato" labelId="cbStatoOperatoreRicercaLbl"
	position="first"  >


<!-- widget cbStatoOperatoreRicerca -->
<s:select name="appDataidStatoOperatoreSelezionato" id="widg_cbStatoOperatoreRicerca"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoOperatoreRicerca"
	  disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','cbStatoOperatoreRicerca')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','cbStatoSchedaRicerca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.cbStatoSchedaRicerca.label')}" labelFor="widg_cbStatoSchedaRicerca" errorFor="appDataidStatoSchedaSelezionatoRicercaOperatore" labelId="cbStatoSchedaRicercaLbl"
	  >


<!-- widget cbStatoSchedaRicerca -->
<s:select name="appDataidStatoSchedaSelezionatoRicercaOperatore" id="widg_cbStatoSchedaRicerca"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoSchedaRicerca"
	  disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','cbStatoSchedaRicerca')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_6_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaOperatoreForestaleGestore_6_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','cbProvinciaRicerca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.cbProvinciaRicerca.label')}" labelFor="widg_cbProvinciaRicerca" errorFor="appDataidProvinciaSelezionatoRicercaOperatoreGestore" labelId="cbProvinciaRicercaLbl"
	position="first"  >


<!-- widget cbProvinciaRicerca -->
	<csiuicore:ajaxify id="p_wpRicercaOperatoreForestaleGestore" 
		widgetType="combo" 
		requestUri="/topforweb/base/gestore/cpRicercaOperatoreForestaleGestore!handleCbProvinciaRicerca_VALUE_CHANGED.do"
		pageId="cpRicercaOperatoreForestaleGestore"
		formName="cpRicercaOperatoreForestaleGestore"
		javascriptDetection="false"
		nameSpace="/base/gestore">

<s:url id="widg_cbProvinciaRicercaurlComboBoxValueChange"
   action="/topforweb/cpRicercaOperatoreForestaleGestore!handleCbProvinciaRicerca_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidProvinciaSelezionatoRicercaOperatoreGestore" id="widg_cbProvinciaRicerca"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	   
	  list="appDataelencoProvinceRicercaOperatoreGestore"
	  disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','cbProvinciaRicerca')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvinciaRicerca','conferma','%{widg_cbProvinciaRicercaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvinciaRicerca','conferma','%{widg_cbProvinciaRicercaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','cbComuniRicerca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaOperatoreForestaleGestore.cbComuniRicerca.label')}" labelFor="widg_cbComuniRicerca" errorFor="appDataidComuneSelezionatoRicercaOperatoreGestore" labelId="cbComuniRicercaLbl"
	  >


<!-- widget cbComuniRicerca -->
<s:select name="appDataidComuneSelezionatoRicercaOperatoreGestore" id="widg_cbComuniRicerca"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniRicercaOperatoreGestore"
	  disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','cbComuniRicerca')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_7_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaOperatoreForestaleGestore_7_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_8_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpRicercaOperatoreForestaleGestore_8_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_8_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaOperatoreForestaleGestore_8_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','wpRicercaOperatoreForestaleGestore_8_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaOperatoreForestaleGestore_8_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaOperatoreForestaleGestore --></div>

			
	
	<div id="p_cpRicercaOperatoreForestaleGestore" class="commandPanelBlock"><!-- startFragment:p_cpRicercaOperatoreForestaleGestore -->
	
	
<div class="commandPanel functional" id="cpRicercaOperatoreForestaleGestore">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','btnWizardIndietroHome')" >

	



<!-- widget btnWizardIndietroHome -->
<s:submit name="widg_btnWizardIndietroHome" id="widg_btnWizardIndietroHome" method="handleBtnWizardIndietroHome_CLICKED"
	key="cpRicercaOperatoreForestaleGestore.btnWizardIndietroHome.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','btnWizardIndietroHome')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicercaOperatoreForestaleGestore','btnRicercaOperatoreForestaleGestore')" >

	



<!-- widget btnRicercaOperatoreForestaleGestore -->
<s:submit name="widg_btnRicercaOperatoreForestaleGestore" id="widg_btnRicercaOperatoreForestaleGestore" method="handleBtnRicercaOperatoreForestaleGestore_CLICKED"
	key="cpRicercaOperatoreForestaleGestore.btnRicercaOperatoreForestaleGestore.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpRicercaOperatoreForestaleGestore','btnRicercaOperatoreForestaleGestore')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpRicercaOperatoreForestaleGestore --></div>

	

	<!-- endFragment:p_fpRicercaOperatoreForestaleGestoreBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
