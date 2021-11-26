#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/topforweb/presentation/topforweb/action/gestore/CpOperatoreDettaglioAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestore -->
<!-- pageId:cpOperatoreDettaglio -->

<s:form id="cpOperatoreDettaglio" action="cpOperatoreDettaglio" namespace="/base/gestore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpDettaglioOperatoreUserInfo" class="formPanelBlock"><!-- startFragment:p_fpDettaglioOperatoreUserInfo -->

	
	

	
	
			
	
	<div id="p_uipDettaglioOperatore" class="userInfoPanelBlock"><!-- startFragment:p_uipDettaglioOperatore -->
	
	
<div class="userInfoPanel" id="uipDettaglioOperatore">
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

	<!-- endFragment:p_uipDettaglioOperatore --></div>

	

	<!-- endFragment:p_fpDettaglioOperatoreUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpDettaglioOperatoreBody" class="formPanelBlock"><!-- startFragment:p_fpDettaglioOperatoreBody -->

	
	

	
	
			
	
	<div id="p_stdMessage" class="stdMessagePanelBlock"><!-- startFragment:p_stdMessage -->
	
	
<div class="stdMessagePanel" id="stdMessage">
	<customtag:stdMessagePanel id="stdMessage" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMessage --></div>

			
	
	<div id="p_wpSchedaOperatoreForestale" class="widgetsPanelBlock"><!-- startFragment:p_wpSchedaOperatoreForestale -->
	
	
<h4 class="wpLabel"><s:text name="cpOperatoreDettaglio.wpSchedaOperatoreForestale.label" /> <span id="toggle_wpSchedaOperatoreForestale"></span></h4>
<div class="widgetsPanel" id="wpSchedaOperatoreForestale">
	
	<customtag:widgetsPanel id="wpSchedaOperatoreForestaleTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptStatoOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptStatoOperatore.label')}" labelFor="widg_ptStatoOperatore" errorFor="appDatadettaglioOperatoreSelezionato.statoOperatore" labelId="ptStatoOperatoreLbl"  position="first" >


<!-- widget ptStatoOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.statoOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptStatoScheda')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptStatoScheda.label')}" labelFor="widg_ptStatoScheda" errorFor="appDatadettaglioOperatoreSelezionato.statoScheda" labelId="ptStatoSchedaLbl"  position="last" >


<!-- widget ptStatoScheda -->
<s:property value="appDatadettaglioOperatoreSelezionato.statoScheda" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptElencoAppartenenza')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptElencoAppartenenza.label')}" labelFor="widg_ptElencoAppartenenza" errorFor="appDatadettaglioOperatoreSelezionato.elencoAppartenenzaOperatore" labelId="ptElencoAppartenenzaLbl"  position="first" >


<!-- widget ptElencoAppartenenza -->
<s:property value="appDatadettaglioOperatoreSelezionato.elencoAppartenenzaOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','wpSchedaOperatoreForestale_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSchedaOperatoreForestale_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpSchedaOperatoreForestale --></div>

			
	
	<div id="p_wpDatiIdentificativiOperatore" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiIdentificativiOperatore -->
	
	
<h4 class="wpLabel"><s:text name="cpOperatoreDettaglio.wpDatiIdentificativiOperatore.label" /> <span id="toggle_wpDatiIdentificativiOperatore"></span></h4>
<div class="widgetsPanel" id="wpDatiIdentificativiOperatore">
	
	<customtag:widgetsPanel id="wpDatiIdentificativiOperatoreTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptNomeOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptNomeOperatore.label')}" labelFor="widg_ptNomeOperatore" errorFor="appDatadettaglioOperatoreSelezionato.cognomeNomeOperatore" labelId="ptNomeOperatoreLbl"  position="first" >


<!-- widget ptNomeOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.cognomeNomeOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptCodiceFiscaleOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptCodiceFiscaleOperatore.label')}" labelFor="widg_ptCodiceFiscaleOperatore" errorFor="appDatadettaglioOperatoreSelezionato.codiceFiscaleOperatore" labelId="ptCodiceFiscaleOperatoreLbl"  position="last" >


<!-- widget ptCodiceFiscaleOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.codiceFiscaleOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptDataNascitaOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptDataNascitaOperatore.label')}" labelFor="widg_ptDataNascitaOperatore" errorFor="appDatadettaglioOperatoreSelezionato.dataNascitaOperatore" labelId="ptDataNascitaOperatoreLbl"  position="first" >


<!-- widget ptDataNascitaOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.dataNascitaOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptStatoNascitaOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptStatoNascitaOperatore.label')}" labelFor="widg_ptStatoNascitaOperatore" errorFor="appDatadettaglioOperatoreSelezionato.dsStatoNascitaOperatore" labelId="ptStatoNascitaOperatoreLbl"  position="last" >


<!-- widget ptStatoNascitaOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.dsStatoNascitaOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptNRsiMsa')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptNRsiMsa.label')}" labelFor="widg_ptNRsiMsa" errorFor="appDatadettaglioOperatoreSelezionato.nRsiMsa" labelId="ptNRsiMsaLbl"  position="first" >


<!-- widget ptNRsiMsa -->
<s:property value="appDatadettaglioOperatoreSelezionato.nRsiMsa" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptLuogoNascitaOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptLuogoNascitaOperatore.label')}" labelFor="widg_ptLuogoNascitaOperatore" errorFor="appDatadettaglioOperatoreSelezionato.luogoNascitaOperatore" labelId="ptLuogoNascitaOperatoreLbl"  position="last" >


<!-- widget ptLuogoNascitaOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.luogoNascitaOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptComuneNascitaOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptComuneNascitaOperatore.label')}" labelFor="widg_ptComuneNascitaOperatore" errorFor="appDatadettaglioOperatoreSelezionato.comuneNascitaOperatore" labelId="ptComuneNascitaOperatoreLbl"  position="first" >


<!-- widget ptComuneNascitaOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.comuneNascitaOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','wpDatiIdentificativiOperatore_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiIdentificativiOperatore_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptIndirizzoResidenzaOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptIndirizzoResidenzaOperatore.label')}" labelFor="widg_ptIndirizzoResidenzaOperatore" errorFor="appDatadettaglioOperatoreSelezionato.indirizzoResidenzaOperatore" labelId="ptIndirizzoResidenzaOperatoreLbl"  position="first" >


<!-- widget ptIndirizzoResidenzaOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.indirizzoResidenzaOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptTelefonoCellulareOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptTelefonoCellulareOperatore.label')}" labelFor="widg_ptTelefonoCellulareOperatore" errorFor="appDatadettaglioOperatoreSelezionato.telefonoOperatore" labelId="ptTelefonoCellulareOperatoreLbl"  position="last" >


<!-- widget ptTelefonoCellulareOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.telefonoOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptEmailOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptEmailOperatore.label')}" labelFor="widg_ptEmailOperatore" errorFor="appDatadettaglioOperatoreSelezionato.emailOperatore" labelId="ptEmailOperatoreLbl"  position="first" >


<!-- widget ptEmailOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.emailOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptTitoloStudioOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptTitoloStudioOperatore.label')}" labelFor="widg_ptTitoloStudioOperatore" errorFor="appDatadettaglioOperatoreSelezionato.titoloStudioOperatore" labelId="ptTitoloStudioOperatoreLbl"  position="last" >


<!-- widget ptTitoloStudioOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.titoloStudioOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptAltriTitoloStudioOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptAltriTitoloStudioOperatore.label')}" labelFor="widg_ptAltriTitoloStudioOperatore" errorFor="appDatadettaglioOperatoreSelezionato.altriStudiCorsiOperatore" labelId="ptAltriTitoloStudioOperatoreLbl"  position="first" >


<!-- widget ptAltriTitoloStudioOperatore -->
<s:property value="appDatadettaglioOperatoreSelezionato.altriStudiCorsiOperatore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','wpDatiIdentificativiOperatore_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiIdentificativiOperatore_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','ptAssociatoAziendaIscrittaAlboForestale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpOperatoreDettaglio.ptAssociatoAziendaIscrittaAlboForestale.label')}" labelFor="widg_ptAssociatoAziendaIscrittaAlboForestale" errorFor="appDatadettaglioOperatoreSelezionato.associatoAziendaIscrittaAlboForestaleENumeroAlbo" labelId="ptAssociatoAziendaIscrittaAlboForestaleLbl"  position="first" >


<!-- widget ptAssociatoAziendaIscrittaAlboForestale -->
<s:property value="appDatadettaglioOperatoreSelezionato.associatoAziendaIscrittaAlboForestaleENumeroAlbo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','wpDatiIdentificativiOperatore_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiIdentificativiOperatore_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiIdentificativiOperatore --></div>

			
	
	<div id="p_wpCorsiFinanziatiRegione" class="widgetsPanelBlock"><!-- startFragment:p_wpCorsiFinanziatiRegione -->
	
	
<h4 class="wpLabel"><s:text name="cpOperatoreDettaglio.wpCorsiFinanziatiRegione.label" /> <span id="toggle_wpCorsiFinanziatiRegione"></span></h4>
<div class="widgetsPanel" id="wpCorsiFinanziatiRegione">
	

	
	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','tblCorsiProfessionaliFinanziatiRegione')" >

	
<div class="tableWidget">


<!-- widget tblCorsiProfessionaliFinanziatiRegione -->
<s:set name="cpOperatoreDettaglio_tblCorsiProfessionaliFinanziatiRegione_clearStatus" value="isTableClearStatus('cpOperatoreDettaglio_tblCorsiProfessionaliFinanziatiRegione')" />
<s:url id="cpOperatoreDettaglioViewUrl"						   
					   action="cpOperatoreDettaglio"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoCorsiProfessionaliFinanziatiDaRegione"  				
			   excludedParams="*"			   export="false"
               id="widg_tblCorsiProfessionaliFinanziatiRegione"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpOperatoreDettaglioViewUrl}"  
               clearStatus="${cpOperatoreDettaglio_tblCorsiProfessionaliFinanziatiRegione_clearStatus}"
               uid="row_tblCorsiProfessionaliFinanziatiRegione"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpOperatoreDettaglioTblCorsiProfessionaliFinanziatiRegioneCustomDecorator"               class="dataTable">
	
		<display:column property="dsAgenziaFormativa" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.dsAgenziaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dsUnitaFormativa" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.dsUnitaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="titoloCorso" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.titoloCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="sedeCorso" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.sedeCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="periodoSvolgimento" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.periodoSvolgimento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="numeroOre" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.numeroOre.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dsEsitoCorso" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.dsEsitoCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaAttestato" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.iconaAttestato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaAllegato" titleKey="cpOperatoreDettaglio.tblCorsiProfessionaliFinanziatiRegione.iconaAllegato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpCorsiFinanziatiRegione --></div>

			
	
	<div id="p_wpAltriCorsi" class="widgetsPanelBlock"><!-- startFragment:p_wpAltriCorsi -->
	
	
<h4 class="wpLabel"><s:text name="cpOperatoreDettaglio.wpAltriCorsi.label" /> <span id="toggle_wpAltriCorsi"></span></h4>
<div class="widgetsPanel" id="wpAltriCorsi">
	

	
	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','tblAltriCorsi')" >

	
<div class="tableWidget">


<!-- widget tblAltriCorsi -->
<s:set name="cpOperatoreDettaglio_tblAltriCorsi_clearStatus" value="isTableClearStatus('cpOperatoreDettaglio_tblAltriCorsi')" />
<s:url id="cpOperatoreDettaglioViewUrl"						   
					   action="cpOperatoreDettaglio"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoAltriCorsi"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAltriCorsi"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpOperatoreDettaglioViewUrl}"  
               clearStatus="${cpOperatoreDettaglio_tblAltriCorsi_clearStatus}"
               uid="row_tblAltriCorsi"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpOperatoreDettaglioTblAltriCorsiCustomDecorator"               class="dataTable">
	
		<display:column property="titoloCorso" titleKey="cpOperatoreDettaglio.tblAltriCorsi.titoloCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dsEsitoCorso" titleKey="cpOperatoreDettaglio.tblAltriCorsi.dsEsitoCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dsAttestatoConScadenza" titleKey="cpOperatoreDettaglio.tblAltriCorsi.dsAttestatoConScadenza.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaAllegato" titleKey="cpOperatoreDettaglio.tblAltriCorsi.iconaAllegato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAltriCorsi --></div>

			
	
	<div id="p_wpQualifiche" class="widgetsPanelBlock"><!-- startFragment:p_wpQualifiche -->
	
	
<h4 class="wpLabel"><s:text name="cpOperatoreDettaglio.wpQualifiche.label" /> <span id="toggle_wpQualifiche"></span></h4>
<div class="widgetsPanel" id="wpQualifiche">
	

	
	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','tblQualifiche')" >

	
<div class="tableWidget">


<!-- widget tblQualifiche -->
	<csiuicore:ajaxify id="p_wpQualifiche" 
		widgetType="table"		
		pageId="cpOperatoreDettaglio"
		javascriptDetection="false">
<s:set name="cpOperatoreDettaglio_tblQualifiche_clearStatus" value="isTableClearStatus('cpOperatoreDettaglio_tblQualifiche')" />
<s:url id="cpOperatoreDettaglioViewUrl"						   
					   action="cpOperatoreDettaglio"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoQualifiche"  				
			   excludedParams="*"			   export="false"
               id="widg_tblQualifiche"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpOperatoreDettaglioViewUrl}"  
               clearStatus="${cpOperatoreDettaglio_tblQualifiche_clearStatus}"
               uid="row_tblQualifiche"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpOperatoreDettaglioTblQualificheCustomDecorator"               class="dataTable">
	
		<display:column property="agenziaFormativa" titleKey="cpOperatoreDettaglio.tblQualifiche.agenziaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipoQualifica" titleKey="cpOperatoreDettaglio.tblQualifiche.tipoQualifica.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataQualifica" titleKey="cpOperatoreDettaglio.tblQualifiche.dataQualifica.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpQualifiche --></div>

			
	
	<div id="p_wpRiconoscimenti" class="widgetsPanelBlock"><!-- startFragment:p_wpRiconoscimenti -->
	
	
<h4 class="wpLabel"><s:text name="cpOperatoreDettaglio.wpRiconoscimenti.label" /> <span id="toggle_wpRiconoscimenti"></span></h4>
<div class="widgetsPanel" id="wpRiconoscimenti">
	

	
	
<s:if test="isWidgetVisible('cpOperatoreDettaglio','tblRiconoscimenti')" >

	
<div class="tableWidget">


<!-- widget tblRiconoscimenti -->
	<csiuicore:ajaxify id="p_wpRiconoscimenti" 
		widgetType="table"		
		pageId="cpOperatoreDettaglio"
		javascriptDetection="false">
<s:set name="cpOperatoreDettaglio_tblRiconoscimenti_clearStatus" value="isTableClearStatus('cpOperatoreDettaglio_tblRiconoscimenti')" />
<s:url id="cpOperatoreDettaglioViewUrl"						   
					   action="cpOperatoreDettaglio"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoRiconoscimento"  				
			   excludedParams="*"			   export="false"
               id="widg_tblRiconoscimenti"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpOperatoreDettaglioViewUrl}"  
               clearStatus="${cpOperatoreDettaglio_tblRiconoscimenti_clearStatus}"
               uid="row_tblRiconoscimenti"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpOperatoreDettaglioTblRiconoscimentiCustomDecorator"               class="dataTable">
	
		<display:column property="agenziaFormativa" titleKey="cpOperatoreDettaglio.tblRiconoscimenti.agenziaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="unitaFormativa" titleKey="cpOperatoreDettaglio.tblRiconoscimenti.unitaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataRiconoscimento" titleKey="cpOperatoreDettaglio.tblRiconoscimenti.dataRiconoscimento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="note" titleKey="cpOperatoreDettaglio.tblRiconoscimenti.note.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRiconoscimenti --></div>

			
	
	<div id="p_cpDettaglioOperatoreNavigaApplicazione" class="commandPanelBlock"><!-- startFragment:p_cpDettaglioOperatoreNavigaApplicazione -->
	
	
<div class="commandPanel functional" id="cpDettaglioOperatoreNavigaApplicazione">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('cpOperatoreDettaglio','btnModificaSchedaOperatore')" >

	



<!-- widget btnModificaSchedaOperatore -->
<s:submit name="widg_btnModificaSchedaOperatore" id="widg_btnModificaSchedaOperatore" method="handleBtnModificaSchedaOperatore_CLICKED"
	key="cpOperatoreDettaglio.btnModificaSchedaOperatore.label" cssClass="buttonWidget editItem"
	disabled="isWidgetDisabled('cpOperatoreDettaglio','btnModificaSchedaOperatore')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpOperatoreDettaglio','btnEliminaSchedaOperatore')" >

	



<!-- widget btnEliminaSchedaOperatore -->
<s:submit name="widg_btnEliminaSchedaOperatore" id="widg_btnEliminaSchedaOperatore" method="handleBtnEliminaSchedaOperatore_CLICKED"
	key="cpOperatoreDettaglio.btnEliminaSchedaOperatore.label" cssClass="buttonWidget deleteItem"
	disabled="isWidgetDisabled('cpOperatoreDettaglio','btnEliminaSchedaOperatore')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDettaglioOperatoreNavigaApplicazione --></div>

			
	
	<div id="p_cpDettaglioOperatore" class="commandPanelBlock"><!-- startFragment:p_cpDettaglioOperatore -->
	
	
<div class="commandPanel navigation" id="cpDettaglioOperatore">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('cpOperatoreDettaglio','btnIndietroSchedaOperatore')" >

	



<!-- widget btnIndietroSchedaOperatore -->
<s:submit name="widg_btnIndietroSchedaOperatore" id="widg_btnIndietroSchedaOperatore" method="handleBtnIndietroSchedaOperatore_CLICKED"
	key="cpOperatoreDettaglio.btnIndietroSchedaOperatore.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('cpOperatoreDettaglio','btnIndietroSchedaOperatore')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpOperatoreDettaglio','btnDettaglioOperatoreNuovaRicerca')" >

	



<!-- widget btnDettaglioOperatoreNuovaRicerca -->
<s:submit name="widg_btnDettaglioOperatoreNuovaRicerca" id="widg_btnDettaglioOperatoreNuovaRicerca" method="handleBtnDettaglioOperatoreNuovaRicerca_CLICKED"
	key="cpOperatoreDettaglio.btnDettaglioOperatoreNuovaRicerca.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpOperatoreDettaglio','btnDettaglioOperatoreNuovaRicerca')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDettaglioOperatore --></div>

	

	<!-- endFragment:p_fpDettaglioOperatoreBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
