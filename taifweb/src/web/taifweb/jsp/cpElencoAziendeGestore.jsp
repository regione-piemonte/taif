#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/gestore/CpElencoAziendeGestoreAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestore -->
<!-- pageId:cpElencoAziendeGestore -->

<s:form id="cpElencoAziendeGestore" action="cpElencoAziendeGestore" namespace="/base/gestore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpElencoAziendeGestoreUserInfo" class="formPanelBlock"><!-- startFragment:p_fpElencoAziendeGestoreUserInfo -->

	
	

	
	
			
	
	<div id="p_uipElencoAziendeGestore" class="userInfoPanelBlock"><!-- startFragment:p_uipElencoAziendeGestore -->
	
	
<div class="userInfoPanel" id="uipElencoAziendeGestore">
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

	<!-- endFragment:p_uipElencoAziendeGestore --></div>

	

	<!-- endFragment:p_fpElencoAziendeGestoreUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpElencoAziendeGestoreBody" class="formPanelBlock"><!-- startFragment:p_fpElencoAziendeGestoreBody -->

	
	

	
	
			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_wpElencoAziendeGestore" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAziendeGestore -->
	
	
<h4 class="wpLabel"><s:text name="cpElencoAziendeGestore.wpElencoAziendeGestore.label" /> </h4>
<div class="widgetsPanel" id="wpElencoAziendeGestore">
	

	
	
<s:if test="isWidgetVisible('cpElencoAziendeGestore','tblElencoAziendeGestore')" >

	
<div class="tableWidget">


<!-- widget tblElencoAziendeGestore -->
	<csiuicore:ajaxify id="p_wpElencoAziendeGestore" 
		widgetType="table"		
		pageId="cpElencoAziendeGestore"
		javascriptDetection="false">
<s:set name="cpElencoAziendeGestore_tblElencoAziendeGestore_clearStatus" value="isTableClearStatus('cpElencoAziendeGestore_tblElencoAziendeGestore')" />
<s:url id="cpElencoAziendeGestoreViewUrl"						   
					   action="cpElencoAziendeGestore"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoRisultatiRicercaAziendaGestore"  				
			   excludedParams="*"			   export="false"
               id="widg_tblElencoAziendeGestore"
               pagesize="50"
               keepStatus="true"
               requestURI="${cpElencoAziendeGestoreViewUrl}"  
               clearStatus="${cpElencoAziendeGestore_tblElencoAziendeGestore_clearStatus}"
               uid="row_tblElencoAziendeGestore"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.gestore.CpElencoAziendeGestoreTblElencoAziendeGestoreCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="cpElencoAziendeGestore.tblElencoAziendeGestore.dsAlbo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAziendeGestore!handleTblElencoAziendeGestore_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeGestore.idPratica}"/>
				<s:param name="idColonna">dsAlbo</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeGestore.dsAlbo}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAziendeGestore.tblElencoAziendeGestore.numeroAlbo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAziendeGestore!handleTblElencoAziendeGestore_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeGestore.idPratica}"/>
				<s:param name="idColonna">numeroAlbo</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeGestore.numeroAlbo}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAziendeGestore.tblElencoAziendeGestore.codiceFiscale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAziendeGestore!handleTblElencoAziendeGestore_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeGestore.idPratica}"/>
				<s:param name="idColonna">codiceFiscale</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeGestore.codiceFiscale}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAziendeGestore.tblElencoAziendeGestore.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAziendeGestore!handleTblElencoAziendeGestore_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeGestore.idPratica}"/>
				<s:param name="idColonna">denominazione</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeGestore.denominazione}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAziendeGestore.tblElencoAziendeGestore.titolare.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAziendeGestore!handleTblElencoAziendeGestore_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeGestore.idPratica}"/>
				<s:param name="idColonna">titolare</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeGestore.titolare}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAziendeGestore.tblElencoAziendeGestore.comune.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAziendeGestore!handleTblElencoAziendeGestore_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeGestore.idPratica}"/>
				<s:param name="idColonna">comune</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeGestore.comune}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAziendeGestore.tblElencoAziendeGestore.dsStato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAziendeGestore!handleTblElencoAziendeGestore_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeGestore.idPratica}"/>
				<s:param name="idColonna">dsStato</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeGestore.dsStato}"/>
			</s:a>
			
		</display:column>
		<display:column property="iconaCancella" titleKey="cpElencoAziendeGestore.tblElencoAziendeGestore.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAziendeGestore --></div>

			
	
	<div id="p_cpElencoAziendeGestoreFun" class="commandPanelBlock"><!-- startFragment:p_cpElencoAziendeGestoreFun -->
	
	
<div class="commandPanel functional" id="cpElencoAziendeGestoreFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAziendeGestore','btnElencoAziendeGestoreExport')" >

	



<!-- widget btnElencoAziendeGestoreExport -->
<s:submit name="widg_btnElencoAziendeGestoreExport" id="widg_btnElencoAziendeGestoreExport" method="handleBtnElencoAziendeGestoreExport_CLICKED"
	key="cpElencoAziendeGestore.btnElencoAziendeGestoreExport.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoAziendeGestore','btnElencoAziendeGestoreExport')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAziendeGestore','btnElencoAziendeNuovaRicerca')" >

	



<!-- widget btnElencoAziendeNuovaRicerca -->
<s:submit name="widg_btnElencoAziendeNuovaRicerca" id="widg_btnElencoAziendeNuovaRicerca" method="handleBtnElencoAziendeNuovaRicerca_CLICKED"
	key="cpElencoAziendeGestore.btnElencoAziendeNuovaRicerca.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpElencoAziendeGestore','btnElencoAziendeNuovaRicerca')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpElencoAziendeGestoreFun --></div>

			
	
	<div id="p_cpElencoAziendeGestoreNav" class="commandPanelBlock"><!-- startFragment:p_cpElencoAziendeGestoreNav -->
	
	
<div class="commandPanel navigation" id="cpElencoAziendeGestoreNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAziendeGestore','btnElencoAziendeGestoreIndietro')" >

	



<!-- widget btnElencoAziendeGestoreIndietro -->
<s:submit name="widg_btnElencoAziendeGestoreIndietro" id="widg_btnElencoAziendeGestoreIndietro" method="handleBtnElencoAziendeGestoreIndietro_CLICKED"
	key="cpElencoAziendeGestore.btnElencoAziendeGestoreIndietro.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('cpElencoAziendeGestore','btnElencoAziendeGestoreIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpElencoAziendeGestoreNav --></div>

	

	<!-- endFragment:p_fpElencoAziendeGestoreBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
