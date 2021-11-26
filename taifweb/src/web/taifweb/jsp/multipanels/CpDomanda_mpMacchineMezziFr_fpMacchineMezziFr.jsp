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

	
	<div id="p_fpMacchineMezziFr" class="formPanelBlock"><!-- startFragment:p_fpMacchineMezziFr -->
		
	


	
	

	
	
			
	
	<div id="p_wpAttrezzatureMacchineSpecialiFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineSpecialiFr -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineSpecialiFr">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineSpecialiFrTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchineSpecialiFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchineSpecialiFr.label')}" labelFor="widg_chbAttrezzatureMacchineSpecialiFr" errorFor="widg_chbAttrezzatureMacchineSpecialiFr" labelId="chbAttrezzatureMacchineSpecialiFrLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchineSpecialiFr -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchineSpecialiFr" id="widg_chbAttrezzatureMacchineSpecialiFr"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineSpecialiFr')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchineSpecialiFr_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineSpecialiFr')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchineSpecialiFr" id="__checkbox_widg_chbAttrezzatureMacchineSpecialiFr" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchineSpecialiFr')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchineSpecialiFr -->
<s:text name="CpDomanda.ptAttrezzatureMacchineSpecialiFr.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineSpecialiFr --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineSpecialiFr" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineSpecialiFr -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineSpecialiFr_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineSpecialiFr_fpAttrezzatureMacchineSpecialiFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineSpecialiFr_fpAttrezzatureMacchineSpecialiFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineSpecialiFr --></div>

			
	
	<div id="p_wpAttrezzatureMacchineMovimentoATerraFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineMovimentoATerraFr -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineMovimentoATerraFr">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineMovimentoATerraFrTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchineMovimentoATerraFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchineMovimentoATerraFr.label')}" labelFor="widg_chbAttrezzatureMacchineMovimentoATerraFr" errorFor="widg_chbAttrezzatureMacchineMovimentoATerraFr" labelId="chbAttrezzatureMacchineMovimentoATerraFrLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchineMovimentoATerraFr -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchineMovimentoATerraFr" id="widg_chbAttrezzatureMacchineMovimentoATerraFr"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineMovimentoATerraFr')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchineMovimentoATerraFr_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineMovimentoATerraFr')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchineMovimentoATerraFr" id="__checkbox_widg_chbAttrezzatureMacchineMovimentoATerraFr" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchineMovimentoATerraFr')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchineMovimentoATerraFr -->
<s:text name="CpDomanda.ptAttrezzatureMacchineMovimentoATerraFr.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineMovimentoATerraFr --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineMovimentoATerraFr" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineMovimentoATerraFr -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineMovimentoATerraFr_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineMovimentoATerraFr_fpAttrezzatureMacchineMovimentoATerraFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineMovimentoATerraFr_fpAttrezzatureMacchineMovimentoATerraFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineMovimentoATerraFr --></div>

			
	
	<div id="p_wpAttrezzatureMacchineGrumier" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineGrumier -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineGrumier">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineGrumierTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchinaGrumier')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchinaGrumier.label')}" labelFor="widg_chbAttrezzatureMacchinaGrumier" errorFor="widg_chbAttrezzatureMacchinaGrumier" labelId="chbAttrezzatureMacchinaGrumierLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchinaGrumier -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchinaGrumier" id="widg_chbAttrezzatureMacchinaGrumier"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaGrumier')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchinaGrumier_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaGrumier')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchinaGrumier" id="__checkbox_widg_chbAttrezzatureMacchinaGrumier" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchinaGrumier')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchinaGrumier -->
<s:text name="CpDomanda.ptAttrezzatureMacchinaGrumier.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineGrumier --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineGrumier" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineGrumier -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineGrumier_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineGrumier_fpAttrezzatureMacchinaElencoGrumier'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineGrumier_fpAttrezzatureMacchinaElencoGrumier.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineGrumier --></div>

			
	
	<div id="p_wpAttrezzatureMacchineRimorchiFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineRimorchiFr -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineRimorchiFr">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineRimorchiFrTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchinaRimorchiFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchinaRimorchiFr.label')}" labelFor="widg_chbAttrezzatureMacchinaRimorchiFr" errorFor="widg_chbAttrezzatureMacchinaRimorchiFr" labelId="chbAttrezzatureMacchinaRimorchiFrLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchinaRimorchiFr -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchinaRimorchiFr" id="widg_chbAttrezzatureMacchinaRimorchiFr"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaRimorchiFr')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchinaRimorchiFr_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaRimorchiFr')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchinaRimorchiFr" id="__checkbox_widg_chbAttrezzatureMacchinaRimorchiFr" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchinaRimorchiFr')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchinaRimorchiFr -->
<s:text name="CpDomanda.ptAttrezzatureMacchinaRimorchiFr.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineRimorchiFr --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineRimorchiFr" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineRimorchiFr -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineRimorchiFr_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineRimorchiFr_fpAttrezzatureMacchinaElencoRimorchiFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineRimorchiFr_fpAttrezzatureMacchinaElencoRimorchiFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineRimorchiFr --></div>

			
	
	<div id="p_wpAttrezzatureMacchineSemi" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineSemi -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineSemi">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineSemiTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchinaSemi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchinaSemi.label')}" labelFor="widg_chbAttrezzatureMacchinaSemi" errorFor="widg_chbAttrezzatureMacchinaSemi" labelId="chbAttrezzatureMacchinaSemiLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchinaSemi -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchinaSemi" id="widg_chbAttrezzatureMacchinaSemi"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaSemi')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchinaSemi_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaSemi')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchinaSemi" id="__checkbox_widg_chbAttrezzatureMacchinaSemi" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchinaSemi')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchinaSemi -->
<s:text name="CpDomanda.ptAttrezzatureMacchinaSemi.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineSemi --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineSemi" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineSemi -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineSemi_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineSemi_fpAttrezzatureMacchinaElencoSemi'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineSemi_fpAttrezzatureMacchinaElencoSemi.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineSemi --></div>

	

		
	

	<!-- endFragment:p_fpMacchineMezziFr --></div>
