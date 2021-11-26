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
<!-- pageId:cpAziendaDettaglio -->

<s:form id="cpAziendaDettaglio" action="cpAziendaDettaglio" namespace="/base/libero" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpDettaglioAziendaUserInfo" class="formPanelBlock"><!-- startFragment:p_fpDettaglioAziendaUserInfo -->

	
	

	
	
			
	
	<div id="p_uipDettaglioAzienda" class="userInfoPanelBlock"><!-- startFragment:p_uipDettaglioAzienda -->
	
	
<div class="userInfoPanel" id="uipDettaglioAzienda">
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

	<!-- endFragment:p_uipDettaglioAzienda --></div>

	

	<!-- endFragment:p_fpDettaglioAziendaUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpDettaglioAziendaBody" class="formPanelBlock"><!-- startFragment:p_fpDettaglioAziendaBody -->

	
	

	
	
			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_wpDettaglioAzienda" class="widgetsPanelBlock"><!-- startFragment:p_wpDettaglioAzienda -->
	
	
<h4 class="wpLabel"><s:text name="cpAziendaDettaglio.wpDettaglioAzienda.label" /> </h4>
<div class="widgetsPanel" id="wpDettaglioAzienda">
	
	<customtag:widgetsPanel id="wpDettaglioAziendaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptAlbo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptAlbo.label')}" labelFor="widg_ptAlbo" errorFor="appDatadettaglioAziendaSelezionata.dsAlbo" labelId="ptAlboLbl"  position="first" >


<!-- widget ptAlbo -->
<s:property value="appDatadettaglioAziendaSelezionata.dsAlbo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptNumeroAlbo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptNumeroAlbo.label')}" labelFor="widg_ptNumeroAlbo" errorFor="appDatadettaglioAziendaSelezionata.numeroAlbo" labelId="ptNumeroAlboLbl"  position="last" >


<!-- widget ptNumeroAlbo -->
<s:property value="appDatadettaglioAziendaSelezionata.numeroAlbo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptDataIscrizione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptDataIscrizione.label')}" labelFor="widg_ptDataIscrizione" errorFor="appDatadettaglioAziendaSelezionata.dataIscrizioneAlbo" labelId="ptDataIscrizioneLbl"  position="first" >


<!-- widget ptDataIscrizione -->
<s:property value="appDatadettaglioAziendaSelezionata.dataIscrizioneAlbo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptSezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptSezione.label')}" labelFor="widg_ptSezione" errorFor="appDatadettaglioAziendaSelezionata.sezione" labelId="ptSezioneLbl"  position="last" >


<!-- widget ptSezione -->
<s:property value="appDatadettaglioAziendaSelezionata.sezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptBlank')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptBlank" errorFor="widg_ptBlank" labelId="ptBlankLbl"  position="first" >


<!-- widget ptBlank -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','wpDettaglioAzienda_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettaglioAzienda_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptDenominazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptDenominazione.label')}" labelFor="widg_ptDenominazione" errorFor="appDatadettaglioAziendaSelezionata.denominazione" labelId="ptDenominazioneLbl"  position="first" >


<!-- widget ptDenominazione -->
<s:property value="appDatadettaglioAziendaSelezionata.denominazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','wpDettaglioAzienda_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettaglioAzienda_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptPartitaIva')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptPartitaIva.label')}" labelFor="widg_ptPartitaIva" errorFor="appDatadettaglioAziendaSelezionata.partitaIva" labelId="ptPartitaIvaLbl"  position="first" >


<!-- widget ptPartitaIva -->
<s:property value="appDatadettaglioAziendaSelezionata.partitaIva" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','wpDettaglioAzienda_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettaglioAzienda_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptNsiret')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptNsiret.label')}" labelFor="widg_ptNsiret" errorFor="appDatadettaglioAziendaSelezionata.nTva" labelId="ptNsiretLbl"  position="first" >


<!-- widget ptNsiret -->
<s:property value="appDatadettaglioAziendaSelezionata.nTva" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptNtva')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptNtva.label')}" labelFor="widg_ptNtva" errorFor="appDatadettaglioAziendaSelezionata.nSiret" labelId="ptNtvaLbl"  position="last" >


<!-- widget ptNtva -->
<s:property value="appDatadettaglioAziendaSelezionata.nSiret" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptFormaGiuridica')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptFormaGiuridica.label')}" labelFor="widg_ptFormaGiuridica" errorFor="appDatadettaglioAziendaSelezionata.formaGiuridica" labelId="ptFormaGiuridicaLbl"  position="first" >


<!-- widget ptFormaGiuridica -->
<s:property value="appDatadettaglioAziendaSelezionata.formaGiuridica" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptTitolare')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptTitolare.label')}" labelFor="widg_ptTitolare" errorFor="appDatadettaglioAziendaSelezionata.titolare" labelId="ptTitolareLbl"  position="last" >


<!-- widget ptTitolare -->
<s:property value="appDatadettaglioAziendaSelezionata.titolare" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptTelefono')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptTelefono.label')}" labelFor="widg_ptTelefono" errorFor="appDatadettaglioAziendaSelezionata.telefono" labelId="ptTelefonoLbl"  position="first" >


<!-- widget ptTelefono -->
<s:property value="appDatadettaglioAziendaSelezionata.telefono" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptEmail')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptEmail.label')}" labelFor="widg_ptEmail" errorFor="appDatadettaglioAziendaSelezionata.email" labelId="ptEmailLbl"  position="last" >


<!-- widget ptEmail -->
<s:property value="appDatadettaglioAziendaSelezionata.email" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptSitoWeb')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptSitoWeb.label')}" labelFor="widg_ptSitoWeb" errorFor="appDatadettaglioAziendaSelezionata.sitoWeb" labelId="ptSitoWebLbl"  position="first" >


<!-- widget ptSitoWeb -->
<s:property value="appDatadettaglioAziendaSelezionata.sitoWeb" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptSedeLegale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptSedeLegale.label')}" labelFor="widg_ptSedeLegale" errorFor="appDatadettaglioAziendaSelezionata.sedeLegale" labelId="ptSedeLegaleLbl"  position="last" >


<!-- widget ptSedeLegale -->
<s:property value="appDatadettaglioAziendaSelezionata.sedeLegale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptBlank2')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptBlank2" errorFor="widg_ptBlank2" labelId="ptBlank2Lbl"  position="first" >


<!-- widget ptBlank2 -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','wpDettaglioAzienda_10_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettaglioAzienda_10_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptNumeroAddetti')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptNumeroAddetti.label')}" labelFor="widg_ptNumeroAddetti" errorFor="appDatadettaglioAziendaSelezionata.numeroAddetti" labelId="ptNumeroAddettiLbl"  position="first" >


<!-- widget ptNumeroAddetti -->
<s:property value="appDatadettaglioAziendaSelezionata.numeroAddetti" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','wpDettaglioAzienda_11_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettaglioAzienda_11_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptNbreSalaries')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptNbreSalaries.label')}" labelFor="widg_ptNbreSalaries" errorFor="appDatadettaglioAziendaSelezionata.nbreSalaries" labelId="ptNbreSalariesLbl"  position="first" >


<!-- widget ptNbreSalaries -->
<s:property value="appDatadettaglioAziendaSelezionata.nbreSalaries" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','wpDettaglioAzienda_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettaglioAzienda_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptBlank3')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptBlank3" errorFor="widg_ptBlank3" labelId="ptBlank3Lbl"  position="first" >


<!-- widget ptBlank3 -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','wpDettaglioAzienda_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettaglioAzienda_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptCategorie')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptCategorie.label')}" labelFor="widg_ptCategorie" errorFor="appDatadettaglioAziendaSelezionata.categorie" labelId="ptCategorieLbl"  position="first" >


<!-- widget ptCategorie -->
<s:property value="appDatadettaglioAziendaSelezionata.categorie" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptAltriAlbi')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptAltriAlbi.label')}" labelFor="widg_ptAltriAlbi" errorFor="appDatadettaglioAziendaSelezionata.altriAlbi" labelId="ptAltriAlbiLbl"  position="last" >


<!-- widget ptAltriAlbi -->
<s:property value="appDatadettaglioAziendaSelezionata.altriAlbi" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptCertificazioni')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptCertificazioni.label')}" labelFor="widg_ptCertificazioni" errorFor="appDatadettaglioAziendaSelezionata.certificazioni" labelId="ptCertificazioniLbl"  position="first" >


<!-- widget ptCertificazioni -->
<s:property value="appDatadettaglioAziendaSelezionata.certificazioni" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptAttivita')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptAttivita.label')}" labelFor="widg_ptAttivita" errorFor="appDatadettaglioAziendaSelezionata.attivita" labelId="ptAttivitaLbl"  position="last" >


<!-- widget ptAttivita -->
<s:property value="appDatadettaglioAziendaSelezionata.attivita" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','ptMezzi')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAziendaDettaglio.ptMezzi.label')}" labelFor="widg_ptMezzi" errorFor="appDatadettaglioAziendaSelezionata.mezzi" labelId="ptMezziLbl"  position="first" >


<!-- widget ptMezzi -->
<s:property value="appDatadettaglioAziendaSelezionata.mezzi" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAziendaDettaglio','wpDettaglioAzienda_16_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettaglioAzienda_16_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettaglioAzienda --></div>

			
	
	<div id="p_commandDettaglioAzienda" class="commandPanelBlock"><!-- startFragment:p_commandDettaglioAzienda -->
	
	
<div class="commandPanel functional" id="commandDettaglioAzienda">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAziendaDettaglio','btnIndietroDettaglioAzienda')" >

	



<!-- widget btnIndietroDettaglioAzienda -->
<s:submit name="widg_btnIndietroDettaglioAzienda" id="widg_btnIndietroDettaglioAzienda" method="handleBtnIndietroDettaglioAzienda_CLICKED"
	key="cpAziendaDettaglio.btnIndietroDettaglioAzienda.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('cpAziendaDettaglio','btnIndietroDettaglioAzienda')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_commandDettaglioAzienda --></div>

	

	<!-- endFragment:p_fpDettaglioAziendaBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
