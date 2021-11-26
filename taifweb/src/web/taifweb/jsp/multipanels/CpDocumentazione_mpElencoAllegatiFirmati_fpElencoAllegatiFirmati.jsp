#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/common/CpDocumentazioneAction" />

	
	<div id="p_fpElencoAllegatiFirmati" class="formPanelBlock"><!-- startFragment:p_fpElencoAllegatiFirmati -->
		
	
<div class="formPanel" id="fpElencoAllegatiFirmati">


	
	

	
	
			
	
	<div id="p_wpElencoAllegatiFirmati" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAllegatiFirmati -->
	
	
<h4 class="wpLabel"><s:text name="CpDocumentazione.wpElencoAllegatiFirmati.label" /> </h4>
<div class="widgetsPanel" id="wpElencoAllegatiFirmati">
	

	
	
<s:if test="isWidgetVisible('CpDocumentazione','tElencoAllegati')" >

	
<div class="tableWidget">


<!-- widget tElencoAllegati -->
<s:set name="CpDocumentazione_tElencoAllegati_clearStatus" value="isTableClearStatus('CpDocumentazione_tElencoAllegati')" />
<s:url id="CpDocumentazioneViewUrl"						   
					   action="CpDocumentazione"
					   namespace="/base/common"/>
<display:table name="appDataelencoAllegati"  				
			   excludedParams="*"			   export="false"
               id="widg_tElencoAllegati"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDocumentazioneViewUrl}"  
               clearStatus="${CpDocumentazione_tElencoAllegati_clearStatus}"
               uid="row_tElencoAllegati"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.common.CpDocumentazioneTElencoAllegatiCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="CpDocumentazione.tElencoAllegati.tipoAllegato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="CpDocumentazione!handleTElencoAllegati_CLICKED"
					namespace="/base/common"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoAllegati.idAllegato}"/>
				<s:param name="idColonna">tipoAllegato</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoAllegati.tipoAllegato}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="CpDocumentazione.tElencoAllegati.nomeFile.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="CpDocumentazione!handleTElencoAllegati_CLICKED"
					namespace="/base/common"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoAllegati.idAllegato}"/>
				<s:param name="idColonna">nomeFile</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoAllegati.nomeFile}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="CpDocumentazione.tElencoAllegati.dimensioneFileKb.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="CpDocumentazione!handleTElencoAllegati_CLICKED"
					namespace="/base/common"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoAllegati.idAllegato}"/>
				<s:param name="idColonna">dimensioneFileKb</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoAllegati.dimensioneFileKb}"/>
			</s:a>
			
		</display:column>
		<display:column property="iconaDownload" titleKey="CpDocumentazione.tElencoAllegati.iconaDownload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaCancella" titleKey="CpDocumentazione.tElencoAllegati.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAllegatiFirmati --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoAllegatiFirmati --></div>
