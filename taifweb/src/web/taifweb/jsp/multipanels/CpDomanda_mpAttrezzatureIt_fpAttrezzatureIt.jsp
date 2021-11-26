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

	
	<div id="p_fpAttrezzatureIt" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureIt -->
		
	


	
	

	
	
			
	
	<div id="p_wpAttrezzatureCascoForestale" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureCascoForestale -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureCascoForestale">
	
	<customtag:widgetsPanel id="wpAttrezzatureCascoForestaleTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureCascoForestale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureCascoForestale.label')}" labelFor="widg_chbAttrezzatureCascoForestale" errorFor="widg_chbAttrezzatureCascoForestale" labelId="chbAttrezzatureCascoForestaleLbl"
	position="first"  >


<!-- widget chbAttrezzatureCascoForestale -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureCascoForestale" id="widg_chbAttrezzatureCascoForestale"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureCascoForestale')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureCascoForestale_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureCascoForestale')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureCascoForestale" id="__checkbox_widg_chbAttrezzatureCascoForestale" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureCascoForestale')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureCascoForestale -->
<s:text name="CpDomanda.ptAttrezzatureCascoForestale.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureCascoForestale --></div>

			
	
	
	<div id="p_mpAttrezzatureCascoForestale" class="panelBlock"><!-- startFragment:p_mpAttrezzatureCascoForestale -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureCascoForestale_selectedMultiPanel == 'CpDomanda_mpAttrezzatureCascoForestale_fpAttrezzatureCascoForestale'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureCascoForestale_fpAttrezzatureCascoForestale.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureCascoForestale --></div>

			
	
	<div id="p_wpAttrezzatureScarponiRinforzati" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureScarponiRinforzati -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureScarponiRinforzati">
	
	<customtag:widgetsPanel id="wpAttrezzatureScarponiRinforzatiTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureScarponiRinforzati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureScarponiRinforzati.label')}" labelFor="widg_chbAttrezzatureScarponiRinforzati" errorFor="widg_chbAttrezzatureScarponiRinforzati" labelId="chbAttrezzatureScarponiRinforzatiLbl"
	position="first"  >


<!-- widget chbAttrezzatureScarponiRinforzati -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureScarponiRinforzati" id="widg_chbAttrezzatureScarponiRinforzati"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureScarponiRinforzati')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureScarponiRinforzati_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureScarponiRinforzati')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureScarponiRinforzati" id="__checkbox_widg_chbAttrezzatureScarponiRinforzati" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureScarponiRinforzati')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureScarponiRinforzati -->
<s:text name="CpDomanda.ptAttrezzatureScarponiRinforzati.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureScarponiRinforzati --></div>

			
	
	
	<div id="p_mpAttrezzatureScarponiRinforzati" class="panelBlock"><!-- startFragment:p_mpAttrezzatureScarponiRinforzati -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureScarponiRinforzati_selectedMultiPanel == 'CpDomanda_mpAttrezzatureScarponiRinforzati_fpAttrezzatureScarponiRinforzati'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureScarponiRinforzati_fpAttrezzatureScarponiRinforzati.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureScarponiRinforzati --></div>

			
	
	<div id="p_wpAttrezzaturePantaloniAntitaglio" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzaturePantaloniAntitaglio -->
	
	

<div class="widgetsPanel" id="wpAttrezzaturePantaloniAntitaglio">
	
	<customtag:widgetsPanel id="wpAttrezzaturePantaloniAntitaglioTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzaturePantaloniAntitaglio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzaturePantaloniAntitaglio.label')}" labelFor="widg_chbAttrezzaturePantaloniAntitaglio" errorFor="widg_chbAttrezzaturePantaloniAntitaglio" labelId="chbAttrezzaturePantaloniAntitaglioLbl"
	position="first"  >


<!-- widget chbAttrezzaturePantaloniAntitaglio -->
<s:checkbox 
	
	
	name="widg_chbAttrezzaturePantaloniAntitaglio" id="widg_chbAttrezzaturePantaloniAntitaglio"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzaturePantaloniAntitaglio')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzaturePantaloniAntitaglio_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzaturePantaloniAntitaglio')" >
	<s:hidden name="__checkbox_widg_chbAttrezzaturePantaloniAntitaglio" id="__checkbox_widg_chbAttrezzaturePantaloniAntitaglio" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzaturePantaloniAntitaglio')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzaturePantaloniAntitaglio -->
<s:text name="CpDomanda.ptAttrezzaturePantaloniAntitaglio.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzaturePantaloniAntitaglio --></div>

			
	
	
	<div id="p_mpAttrezzaturePantaloniAntitaglio" class="panelBlock"><!-- startFragment:p_mpAttrezzaturePantaloniAntitaglio -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzaturePantaloniAntitaglio_selectedMultiPanel == 'CpDomanda_mpAttrezzaturePantaloniAntitaglio_fpAttrezzaturePantaloniAntitaglio'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzaturePantaloniAntitaglio_fpAttrezzaturePantaloniAntitaglio.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzaturePantaloniAntitaglio --></div>

	

		
	

	<!-- endFragment:p_fpAttrezzatureIt --></div>
