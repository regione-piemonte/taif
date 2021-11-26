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
<!-- pageId:cpRicercaAziendaGestore -->

<s:form id="cpRicercaAziendaGestore" action="cpRicercaAziendaGestore" namespace="/base/gestore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpRicercaAziendaGestoreUserInfo" class="formPanelBlock"><!-- startFragment:p_fpRicercaAziendaGestoreUserInfo -->

	
	

	
	
			
	
	<div id="p_uipRicercaAziendaGestore" class="userInfoPanelBlock"><!-- startFragment:p_uipRicercaAziendaGestore -->
	
	
<div class="userInfoPanel" id="uipRicercaAziendaGestore">
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

	<!-- endFragment:p_uipRicercaAziendaGestore --></div>

			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','menuView')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpRicercaAziendaGestoreUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpRicercaAziendaGestoreBody" class="formPanelBlock"><!-- startFragment:p_fpRicercaAziendaGestoreBody -->

	
	

	
	
			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione" class="widgetsPanelBlock scroll"><!-- startFragment:p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione -->
	
	
<h4 class="wpLabel"><s:text name="cpRicercaAziendaGestore.wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione.label" /> </h4>
<div class="widgetsPanel" id="wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione">
	
	<customtag:widgetsPanel id="wpRicercaAziendaGestoreDatiAnagraficiLocalizzazioneTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbRicercaAziendaGestoreAlboAppartenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbRicercaAziendaGestoreAlboAppartenza.label')}" labelFor="widg_cbRicercaAziendaGestoreAlboAppartenza" errorFor="appDataelencoAlbiSelezionatiRicercaAzienda" labelId="cbRicercaAziendaGestoreAlboAppartenzaLbl"
	position="first"  >


<!-- widget cbRicercaAziendaGestoreAlboAppartenza -->
<s:select name="appDataelencoAlbiSelezionatiRicercaAzienda" id="widg_cbRicercaAziendaGestoreAlboAppartenza"
	 
	
		title=""
			
	   
	  list="appDataelencoAlbiRicercaAzienda"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbRicercaAziendaGestoreAlboAppartenza')"
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


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','tRicercaAziendaGestoreNumeroAlbo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.tRicercaAziendaGestoreNumeroAlbo.label')}" labelFor="widg_tRicercaAziendaGestoreNumeroAlbo" errorFor="appDatanumeroAlboAzienda" labelId="tRicercaAziendaGestoreNumeroAlboLbl"
	  >


<!-- widget tRicercaAziendaGestoreNumeroAlbo -->
<s:textfield 
	
title=""	
	name="appDatanumeroAlboAzienda" id="widg_tRicercaAziendaGestoreNumeroAlbo"
	disabled="isWidgetDisabled('cpRicercaAziendaGestore','tRicercaAziendaGestoreNumeroAlbo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','tRicercaAziendaGestoreDenominazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.tRicercaAziendaGestoreDenominazione.label')}" labelFor="widg_tRicercaAziendaGestoreDenominazione" errorFor="appDatadenominazioneAzienda" labelId="tRicercaAziendaGestoreDenominazioneLbl"
	position="first" colSpan="3" >


<!-- widget tRicercaAziendaGestoreDenominazione -->
<s:textfield 
	
title=""	
	name="appDatadenominazioneAzienda" id="widg_tRicercaAziendaGestoreDenominazione"
	disabled="isWidgetDisabled('cpRicercaAziendaGestore','tRicercaAziendaGestoreDenominazione')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','tRicercaAziendaGestoreTitolareRappresentanteLegale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.tRicercaAziendaGestoreTitolareRappresentanteLegale.label')}" labelFor="widg_tRicercaAziendaGestoreTitolareRappresentanteLegale" errorFor="appDatatitolareLegaleRappresentanteAzienda" labelId="tRicercaAziendaGestoreTitolareRappresentanteLegaleLbl"
	position="last" colSpan="3" >


<!-- widget tRicercaAziendaGestoreTitolareRappresentanteLegale -->
<s:textfield 
	
title=""	
	name="appDatatitolareLegaleRappresentanteAzienda" id="widg_tRicercaAziendaGestoreTitolareRappresentanteLegale"
	disabled="isWidgetDisabled('cpRicercaAziendaGestore','tRicercaAziendaGestoreTitolareRappresentanteLegale')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','tRicercaAziendaGestoreCodFiscalePIva')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.tRicercaAziendaGestoreCodFiscalePIva.label')}" labelFor="widg_tRicercaAziendaGestoreCodFiscalePIva" errorFor="appDatacodFisPivaAzienda" labelId="tRicercaAziendaGestoreCodFiscalePIvaLbl"
	position="first" colSpan="3" >


<!-- widget tRicercaAziendaGestoreCodFiscalePIva -->
<s:textfield 
	
title=""	
	name="appDatacodFisPivaAzienda" id="widg_tRicercaAziendaGestoreCodFiscalePIva"
	disabled="isWidgetDisabled('cpRicercaAziendaGestore','tRicercaAziendaGestoreCodFiscalePIva')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbtRicercaAziendaGestoreProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbtRicercaAziendaGestoreProvincia.label')}" labelFor="widg_cbtRicercaAziendaGestoreProvincia" errorFor="appDataidProvinciaSelezionatoRicercaAziendaGestore" labelId="cbtRicercaAziendaGestoreProvinciaLbl"
	position="first" colSpan="3" >


<!-- widget cbtRicercaAziendaGestoreProvincia -->
	<csiuicore:ajaxify id="p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione" 
		widgetType="combo" 
		requestUri="/taifweb/base/gestore/cpRicercaAziendaGestore!handleCbtRicercaAziendaGestoreProvincia_VALUE_CHANGED.do"
		pageId="cpRicercaAziendaGestore"
		formName="cpRicercaAziendaGestore"
		javascriptDetection="false"
		nameSpace="/base/gestore">

<s:url id="widg_cbtRicercaAziendaGestoreProvinciaurlComboBoxValueChange"
   action="/taifweb/cpRicercaAziendaGestore!handleCbtRicercaAziendaGestoreProvincia_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidProvinciaSelezionatoRicercaAziendaGestore" id="widg_cbtRicercaAziendaGestoreProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	   
	  list="appDataelencoProvinciaRicercaAziendaGestore"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbtRicercaAziendaGestoreProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbtRicercaAziendaGestoreProvincia','conferma','%{widg_cbtRicercaAziendaGestoreProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbtRicercaAziendaGestoreProvincia','conferma','%{widg_cbtRicercaAziendaGestoreProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbtRicercaAziendaGestoreComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbtRicercaAziendaGestoreComune.label')}" labelFor="widg_cbtRicercaAziendaGestoreComune" errorFor="appDataidComuneSelezionatoRicercaAziendaGestore" labelId="cbtRicercaAziendaGestoreComuneLbl"
	position="last" colSpan="3" >


<!-- widget cbtRicercaAziendaGestoreComune -->
<s:select name="appDataidComuneSelezionatoRicercaAziendaGestore" id="widg_cbtRicercaAziendaGestoreComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniRicercaAziendaGestore"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbtRicercaAziendaGestoreComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','calRicercaAziendaGestoreDataIscrizioneAlboDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.calRicercaAziendaGestoreDataIscrizioneAlboDa.label')}" labelFor="widg_calRicercaAziendaGestoreDataIscrizioneAlboDa" errorFor="appDatadataIscrizioneAlboAziendaDa" labelId="calRicercaAziendaGestoreDataIscrizioneAlboDaLbl"
	position="first" colSpan="3" >


<!-- widget calRicercaAziendaGestoreDataIscrizioneAlboDa -->
<s:textfield 
	
	
	name="appDatadataIscrizioneAlboAziendaDa" id="widg_calRicercaAziendaGestoreDataIscrizioneAlboDa"
	disabled="isWidgetDisabled('cpRicercaAziendaGestore','calRicercaAziendaGestoreDataIscrizioneAlboDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','calRicercaAziendaGestoreDataIscrizioneAlboA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.calRicercaAziendaGestoreDataIscrizioneAlboA.label')}" labelFor="widg_calRicercaAziendaGestoreDataIscrizioneAlboA" errorFor="appDatadataIscrizioneAlboAziendaA" labelId="calRicercaAziendaGestoreDataIscrizioneAlboALbl"
	 colSpan="3" >


<!-- widget calRicercaAziendaGestoreDataIscrizioneAlboA -->
<s:textfield 
	
	
	name="appDatadataIscrizioneAlboAziendaA" id="widg_calRicercaAziendaGestoreDataIscrizioneAlboA"
	disabled="isWidgetDisabled('cpRicercaAziendaGestore','calRicercaAziendaGestoreDataIscrizioneAlboA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbRicercaAziendaGestoreStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbRicercaAziendaGestoreStato.label')}" labelFor="widg_cbRicercaAziendaGestoreStato" errorFor="appDataidStatoPraticaSelezionatoRicercaAziendaGestore" labelId="cbRicercaAziendaGestoreStatoLbl"
	position="first" colSpan="3" >


<!-- widget cbRicercaAziendaGestoreStato -->

<s:url id="widg_cbRicercaAziendaGestoreStatourlComboBoxValueChange"
   action="/taifweb/cpRicercaAziendaGestore!handleCbRicercaAziendaGestoreStato_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidStatoPraticaSelezionatoRicercaAziendaGestore" id="widg_cbRicercaAziendaGestoreStato"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatiRicercaAzienda"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbRicercaAziendaGestoreStato')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbRicercaAziendaGestoreStato','conferma','%{widg_cbRicercaAziendaGestoreStatourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRicercaAziendaGestoreStato','conferma','%{widg_cbRicercaAziendaGestoreStatourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbRicercaAziendaGestoreSottostato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbRicercaAziendaGestoreSottostato.label')}" labelFor="widg_cbRicercaAziendaGestoreSottostato" errorFor="appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore" labelId="cbRicercaAziendaGestoreSottostatoLbl"
	position="last" colSpan="3" >


<!-- widget cbRicercaAziendaGestoreSottostato -->
<s:select name="appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore" id="widg_cbRicercaAziendaGestoreSottostato"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSottostatiRicercaAzienda"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbRicercaAziendaGestoreSottostato')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAziendaGestoreDatiAnagraficiLocalizzazione --></div>

			
	
	<div id="p_wpRicercaAziendaGestoreDatiSocioEconomici" class="widgetsPanelBlock scroll"><!-- startFragment:p_wpRicercaAziendaGestoreDatiSocioEconomici -->
	
	
<h4 class="wpLabel"><s:text name="cpRicercaAziendaGestore.wpRicercaAziendaGestoreDatiSocioEconomici.label" /> <span id="toggle_wpRicercaAziendaGestoreDatiSocioEconomici"></span></h4>
<div class="widgetsPanel" id="wpRicercaAziendaGestoreDatiSocioEconomici">
	
	<customtag:widgetsPanel id="wpRicercaAziendaGestoreDatiSocioEconomiciTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbRicercaAziendaGestoreSezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbRicercaAziendaGestoreSezione.label')}" labelFor="widg_cbRicercaAziendaGestoreSezione" errorFor="appDataelencoSezioniSelezionatiRicercaAzienda" labelId="cbRicercaAziendaGestoreSezioneLbl"
	position="first"  >


<!-- widget cbRicercaAziendaGestoreSezione -->
<s:select name="appDataelencoSezioniSelezionatiRicercaAzienda" id="widg_cbRicercaAziendaGestoreSezione"
	 
	
		title=""
			
	   
	  list="appDataelencoSezioniRicercaAzienda"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbRicercaAziendaGestoreSezione')"
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


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','wpRicercaAziendaGestoreDatiSocioEconomici_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaAziendaGestoreDatiSocioEconomici_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbRicercaAziendaGestoreCategoriaImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbRicercaAziendaGestoreCategoriaImpresa.label')}" labelFor="widg_cbRicercaAziendaGestoreCategoriaImpresa" errorFor="appDataelencoCategorieImpresaSelezionatiRicercaAzienda" labelId="cbRicercaAziendaGestoreCategoriaImpresaLbl"
	position="last"  >


<!-- widget cbRicercaAziendaGestoreCategoriaImpresa -->
<s:select name="appDataelencoCategorieImpresaSelezionatiRicercaAzienda" id="widg_cbRicercaAziendaGestoreCategoriaImpresa"
	 
	
		title=""
			
	   
	  list="appDataelencoCategorieImpresaRicercaAzienda"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbRicercaAziendaGestoreCategoriaImpresa')"
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


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbRicercaAziendaGestoreAssociazioneCertificazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbRicercaAziendaGestoreAssociazioneCertificazione.label')}" labelFor="widg_cbRicercaAziendaGestoreAssociazioneCertificazione" errorFor="appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda" labelId="cbRicercaAziendaGestoreAssociazioneCertificazioneLbl"
	position="first"  >


<!-- widget cbRicercaAziendaGestoreAssociazioneCertificazione -->
<s:select name="appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda" id="widg_cbRicercaAziendaGestoreAssociazioneCertificazione"
	 
	
		title=""
			
	   
	  list="appDataelencoAssociazioniCertificazioneRicercaAzienda"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbRicercaAziendaGestoreAssociazioneCertificazione')"
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


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','wpRicercaAziendaGestoreDatiSocioEconomici_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRicercaAziendaGestoreDatiSocioEconomici_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','cbRicercaAziendaGestoreAttivitaSvolte')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAziendaGestore.cbRicercaAziendaGestoreAttivitaSvolte.label')}" labelFor="widg_cbRicercaAziendaGestoreAttivitaSvolte" errorFor="appDataelencoAttivitaSvolteSelezionatiRicercaAzienda" labelId="cbRicercaAziendaGestoreAttivitaSvolteLbl"
	position="last"  >


<!-- widget cbRicercaAziendaGestoreAttivitaSvolte -->
<s:select name="appDataelencoAttivitaSvolteSelezionatiRicercaAzienda" id="widg_cbRicercaAziendaGestoreAttivitaSvolte"
	 
	
		title=""
			
	   
	  list="appDataelencoAttivitaSvolteRicercaAzienda"
	  disabled="isWidgetDisabled('cpRicercaAziendaGestore','cbRicercaAziendaGestoreAttivitaSvolte')"
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

	<!-- endFragment:p_wpRicercaAziendaGestoreDatiSocioEconomici --></div>

			
	
	<div id="p_cpRicercaAziendaGestore" class="commandPanelBlock"><!-- startFragment:p_cpRicercaAziendaGestore -->
	
	
<div class="commandPanel functional" id="cpRicercaAziendaGestore">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAziendaGestore','btnRicercaAziendaGestore')" >

	



<!-- widget btnRicercaAziendaGestore -->
<s:submit name="widg_btnRicercaAziendaGestore" id="widg_btnRicercaAziendaGestore" method="handleBtnRicercaAziendaGestore_CLICKED"
	key="cpRicercaAziendaGestore.btnRicercaAziendaGestore.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpRicercaAziendaGestore','btnRicercaAziendaGestore')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpRicercaAziendaGestore --></div>

	

	<!-- endFragment:p_fpRicercaAziendaGestoreBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
