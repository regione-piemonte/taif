#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/libero -->
<!-- pageId:cpRicercaAccessoLibero -->

<s:form id="cpRicercaAccessoLibero" action="cpRicercaAccessoLibero" namespace="/base/libero" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpRicercaAccessoLiberoUserInfo" class="formPanelBlock"><!-- startFragment:p_fpRicercaAccessoLiberoUserInfo -->

	
	

	
	
			
	
	<div id="p_uipRicercaAccessoLibero" class="userInfoPanelBlock"><!-- startFragment:p_uipRicercaAccessoLibero -->
	
	
<div class="userInfoPanel" id="uipRicercaAccessoLibero">
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

	<!-- endFragment:p_uipRicercaAccessoLibero --></div>

	

	<!-- endFragment:p_fpRicercaAccessoLiberoUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpAccessoLiberoBody" class="formPanelBlock"><!-- startFragment:p_fpAccessoLiberoBody -->

	
	

	
	
			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione -->
	
	
<h4 class="wpLabel"><s:text name="cpRicercaAccessoLibero.wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione.label" /> </h4>
<div class="widgetsPanel" id="wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione">
	
	<customtag:widgetsPanel id="wpRicercaAccessoLiberoDatiAnagraficiLocalizzazioneTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','cbRicercaAccessoLiberoAlboAppartenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.cbRicercaAccessoLiberoAlboAppartenza.label')}" labelFor="widg_cbRicercaAccessoLiberoAlboAppartenza" errorFor="appDataelencoAlbiSelezionatiRicercaAccessoLibero" labelId="cbRicercaAccessoLiberoAlboAppartenzaLbl"
	position="first"  >


<!-- widget cbRicercaAccessoLiberoAlboAppartenza -->
<s:select name="appDataelencoAlbiSelezionatiRicercaAccessoLibero" id="widg_cbRicercaAccessoLiberoAlboAppartenza"
	 
	
		title=""
			
	   
	  list="appDataelencoAlbiRicercaAccessoLibero"
	  disabled="isWidgetDisabled('cpRicercaAccessoLibero','cbRicercaAccessoLiberoAlboAppartenza')"
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


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','tRicercaAccessoLiberoNumeroAlbo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.tRicercaAccessoLiberoNumeroAlbo.label')}" labelFor="widg_tRicercaAccessoLiberoNumeroAlbo" errorFor="appDatanumeroAlboAzienda" labelId="tRicercaAccessoLiberoNumeroAlboLbl"
	  >


<!-- widget tRicercaAccessoLiberoNumeroAlbo -->
<s:textfield 
	
	
	name="appDatanumeroAlboAzienda" id="widg_tRicercaAccessoLiberoNumeroAlbo"
	disabled="isWidgetDisabled('cpRicercaAccessoLibero','tRicercaAccessoLiberoNumeroAlbo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','tRicercaAccessoLiberoDenominazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.tRicercaAccessoLiberoDenominazione.label')}" labelFor="widg_tRicercaAccessoLiberoDenominazione" errorFor="appDatadenominazioneAzienda" labelId="tRicercaAccessoLiberoDenominazioneLbl"
	position="first" colSpan="3" >


<!-- widget tRicercaAccessoLiberoDenominazione -->
<s:textfield 
	
	
	name="appDatadenominazioneAzienda" id="widg_tRicercaAccessoLiberoDenominazione"
	disabled="isWidgetDisabled('cpRicercaAccessoLibero','tRicercaAccessoLiberoDenominazione')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','tRicercaAccessoLiberoTitolareRappresentanteLegale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.tRicercaAccessoLiberoTitolareRappresentanteLegale.label')}" labelFor="widg_tRicercaAccessoLiberoTitolareRappresentanteLegale" errorFor="appDatatitolareLegaleRappresentanteAzienda" labelId="tRicercaAccessoLiberoTitolareRappresentanteLegaleLbl"
	position="last" colSpan="3" >


<!-- widget tRicercaAccessoLiberoTitolareRappresentanteLegale -->
<s:textfield 
	
	
	name="appDatatitolareLegaleRappresentanteAzienda" id="widg_tRicercaAccessoLiberoTitolareRappresentanteLegale"
	disabled="isWidgetDisabled('cpRicercaAccessoLibero','tRicercaAccessoLiberoTitolareRappresentanteLegale')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','tRicercaAccessoLiberoCodFiscalePIva')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.tRicercaAccessoLiberoCodFiscalePIva.label')}" labelFor="widg_tRicercaAccessoLiberoCodFiscalePIva" errorFor="appDatacodFisPivaAzienda" labelId="tRicercaAccessoLiberoCodFiscalePIvaLbl"
	position="first" colSpan="3" >


<!-- widget tRicercaAccessoLiberoCodFiscalePIva -->
<s:textfield 
	
	
	name="appDatacodFisPivaAzienda" id="widg_tRicercaAccessoLiberoCodFiscalePIva"
	disabled="isWidgetDisabled('cpRicercaAccessoLibero','tRicercaAccessoLiberoCodFiscalePIva')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','cbtRicercaAccessoLiberoProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.cbtRicercaAccessoLiberoProvincia.label')}" labelFor="widg_cbtRicercaAccessoLiberoProvincia" errorFor="appDataidProvinciaSelezionatoRicercaAccessoLibero" labelId="cbtRicercaAccessoLiberoProvinciaLbl"
	position="first" colSpan="3" >


<!-- widget cbtRicercaAccessoLiberoProvincia -->
	<csiuicore:ajaxify id="p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione" 
		widgetType="combo" 
		requestUri="/taifweb/base/libero/cpRicercaAccessoLibero!handleCbtRicercaAccessoLiberoProvincia_VALUE_CHANGED.do"
		pageId="cpRicercaAccessoLibero"
		formName="cpRicercaAccessoLibero"
		javascriptDetection="false"
		nameSpace="/base/libero">

<s:url id="widg_cbtRicercaAccessoLiberoProvinciaurlComboBoxValueChange"
   action="/taifweb/cpRicercaAccessoLibero!handleCbtRicercaAccessoLiberoProvincia_VALUE_CHANGED" namespace="/base/libero"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidProvinciaSelezionatoRicercaAccessoLibero" id="widg_cbtRicercaAccessoLiberoProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	   
	  list="appDataelencoProvinceRicercaAccessoLibero"
	  disabled="isWidgetDisabled('cpRicercaAccessoLibero','cbtRicercaAccessoLiberoProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbtRicercaAccessoLiberoProvincia','conferma','%{widg_cbtRicercaAccessoLiberoProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbtRicercaAccessoLiberoProvincia','conferma','%{widg_cbtRicercaAccessoLiberoProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','cbtRicercaAccessoLiberoComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.cbtRicercaAccessoLiberoComune.label')}" labelFor="widg_cbtRicercaAccessoLiberoComune" errorFor="appDataidComuneSelezionatoRicercaAccessoLibero" labelId="cbtRicercaAccessoLiberoComuneLbl"
	position="last" colSpan="3" >


<!-- widget cbtRicercaAccessoLiberoComune -->
<s:select name="appDataidComuneSelezionatoRicercaAccessoLibero" id="widg_cbtRicercaAccessoLiberoComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniRicercaAccessoLibero"
	  disabled="isWidgetDisabled('cpRicercaAccessoLibero','cbtRicercaAccessoLiberoComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','calRicercaAccessoLiberoDataIscrizioneAlboDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.calRicercaAccessoLiberoDataIscrizioneAlboDa.label')}" labelFor="widg_calRicercaAccessoLiberoDataIscrizioneAlboDa" errorFor="appDatadataIscrizioneAlboAziendaDa" labelId="calRicercaAccessoLiberoDataIscrizioneAlboDaLbl"
	position="first" colSpan="3" >


<!-- widget calRicercaAccessoLiberoDataIscrizioneAlboDa -->
<s:textfield 
	
	
	name="appDatadataIscrizioneAlboAziendaDa" id="widg_calRicercaAccessoLiberoDataIscrizioneAlboDa"
	disabled="isWidgetDisabled('cpRicercaAccessoLibero','calRicercaAccessoLiberoDataIscrizioneAlboDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','calRicercaAccessoLiberoDataIscrizioneAlboA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.calRicercaAccessoLiberoDataIscrizioneAlboA.label')}" labelFor="widg_calRicercaAccessoLiberoDataIscrizioneAlboA" errorFor="appDatadataIscrizioneAlboAziendaA" labelId="calRicercaAccessoLiberoDataIscrizioneAlboALbl"
	 colSpan="3" >


<!-- widget calRicercaAccessoLiberoDataIscrizioneAlboA -->
<s:textfield 
	
	
	name="appDatadataIscrizioneAlboAziendaA" id="widg_calRicercaAccessoLiberoDataIscrizioneAlboA"
	disabled="isWidgetDisabled('cpRicercaAccessoLibero','calRicercaAccessoLiberoDataIscrizioneAlboA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" />
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAccessoLiberoDatiAnagraficiLocalizzazione --></div>

			
	
	<div id="p_wpRicercaAccessoLiberoDatiSocioEconomici" class="widgetsPanelBlock scroll"><!-- startFragment:p_wpRicercaAccessoLiberoDatiSocioEconomici -->
	
	
<h4 class="wpLabel"><s:text name="cpRicercaAccessoLibero.wpRicercaAccessoLiberoDatiSocioEconomici.label" /> <span id="toggle_wpRicercaAccessoLiberoDatiSocioEconomici"></span></h4>
<div class="widgetsPanel" id="wpRicercaAccessoLiberoDatiSocioEconomici">
	
	<customtag:widgetsPanel id="wpRicercaAccessoLiberoDatiSocioEconomiciTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','cbRicercaAccessoLiberoSezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.cbRicercaAccessoLiberoSezione.label')}" labelFor="widg_cbRicercaAccessoLiberoSezione" errorFor="appDataelencoSezioniSelezionatiRicercaAccessoLibero" labelId="cbRicercaAccessoLiberoSezioneLbl"
	position="first"  >


<!-- widget cbRicercaAccessoLiberoSezione -->
<s:select name="appDataelencoSezioniSelezionatiRicercaAccessoLibero" id="widg_cbRicercaAccessoLiberoSezione"
	 
	
		title=""
			
	   
	  list="appDataelencoSezioniRicercaAccessoLibero"
	  disabled="isWidgetDisabled('cpRicercaAccessoLibero','cbRicercaAccessoLiberoSezione')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="2"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','wpRicercaAccessoLiberoDatiSocioEconomici_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaAccessoLiberoDatiSocioEconomici_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','cbRicercaAccessoLiberoCategoriaImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.cbRicercaAccessoLiberoCategoriaImpresa.label')}" labelFor="widg_cbRicercaAccessoLiberoCategoriaImpresa" errorFor="appDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero" labelId="cbRicercaAccessoLiberoCategoriaImpresaLbl"
	position="last"  >


<!-- widget cbRicercaAccessoLiberoCategoriaImpresa -->
<s:select name="appDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero" id="widg_cbRicercaAccessoLiberoCategoriaImpresa"
	 
	
		title=""
			
	   
	  list="appDataelencoCategorieImpresaRicercaAccessoLibero"
	  disabled="isWidgetDisabled('cpRicercaAccessoLibero','cbRicercaAccessoLiberoCategoriaImpresa')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="12"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','cbRicercaAccessoLiberoAssociazioneCertificazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.cbRicercaAccessoLiberoAssociazioneCertificazione.label')}" labelFor="widg_cbRicercaAccessoLiberoAssociazioneCertificazione" errorFor="appDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero" labelId="cbRicercaAccessoLiberoAssociazioneCertificazioneLbl"
	position="first"  >


<!-- widget cbRicercaAccessoLiberoAssociazioneCertificazione -->
<s:select name="appDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero" id="widg_cbRicercaAccessoLiberoAssociazioneCertificazione"
	 
	
		title=""
			
	   
	  list="appDataelencoAssociazioniCertificazioneRicercaAccessoLibero"
	  disabled="isWidgetDisabled('cpRicercaAccessoLibero','cbRicercaAccessoLiberoAssociazioneCertificazione')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="2"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','wpRicercaAccessoLiberoDatiSocioEconomici_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaAccessoLiberoDatiSocioEconomici_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','cbRicercaAccessoLiberoAttivitaSvolte')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccessoLibero.cbRicercaAccessoLiberoAttivitaSvolte.label')}" labelFor="widg_cbRicercaAccessoLiberoAttivitaSvolte" errorFor="appDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero" labelId="cbRicercaAccessoLiberoAttivitaSvolteLbl"
	position="last"  >


<!-- widget cbRicercaAccessoLiberoAttivitaSvolte -->
<s:select name="appDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero" id="widg_cbRicercaAccessoLiberoAttivitaSvolte"
	 
	
		title=""
			
	   
	  list="appDataelencoAttivitaSvolteRicercaAccessoLibero"
	  disabled="isWidgetDisabled('cpRicercaAccessoLibero','cbRicercaAccessoLiberoAttivitaSvolte')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="15"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAccessoLiberoDatiSocioEconomici --></div>

			
	
	<div id="p_cpRicercaAccessoLibero" class="commandPanelBlock"><!-- startFragment:p_cpRicercaAccessoLibero -->
	
	
<div class="commandPanel functional" id="cpRicercaAccessoLibero">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAccessoLibero','btnRicercaAccessoLibero')" >

	



<!-- widget btnRicercaAccessoLibero -->
<s:submit name="widg_btnRicercaAccessoLibero" id="widg_btnRicercaAccessoLibero" method="handleBtnRicercaAccessoLibero_CLICKED"
	key="cpRicercaAccessoLibero.btnRicercaAccessoLibero.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpRicercaAccessoLibero','btnRicercaAccessoLibero')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpRicercaAccessoLibero --></div>

	

	<!-- endFragment:p_fpAccessoLiberoBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
