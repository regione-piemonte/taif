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

	
	<div id="p_fpMacchineMezziIt" class="formPanelBlock"><!-- startFragment:p_fpMacchineMezziIt -->
		
	


	
	

	
	
			
	
	<div id="p_wpAttrezzatureMacchineTrattrici" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineTrattrici -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineTrattrici">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineTrattriciTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchinaTrattrici')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchinaTrattrici.label')}" labelFor="widg_chbAttrezzatureMacchinaTrattrici" errorFor="widg_chbAttrezzatureMacchinaTrattrici" labelId="chbAttrezzatureMacchinaTrattriciLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchinaTrattrici -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchinaTrattrici" id="widg_chbAttrezzatureMacchinaTrattrici"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaTrattrici')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchinaTrattrici_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaTrattrici')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchinaTrattrici" id="__checkbox_widg_chbAttrezzatureMacchinaTrattrici" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchinaTrattrici')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchinaTrattrici -->
<s:text name="CpDomanda.ptAttrezzatureMacchinaTrattrici.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineTrattrici --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineTrattrici" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineTrattrici -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineTrattrici_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineTrattrici_fpAttrezzatureMacchinaElencoTrattrici'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineTrattrici_fpAttrezzatureMacchinaElencoTrattrici.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineTrattrici --></div>

			
	
	<div id="p_wpAttrezzatureMacchineSpeciali" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineSpeciali -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineSpeciali">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineSpecialiTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchineSpeciali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchineSpeciali.label')}" labelFor="widg_chbAttrezzatureMacchineSpeciali" errorFor="widg_chbAttrezzatureMacchineSpeciali" labelId="chbAttrezzatureMacchineSpecialiLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchineSpeciali -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchineSpeciali" id="widg_chbAttrezzatureMacchineSpeciali"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineSpeciali')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchineSpeciali_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineSpeciali')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchineSpeciali" id="__checkbox_widg_chbAttrezzatureMacchineSpeciali" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchineSpeciali')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchineSpeciali -->
<s:text name="CpDomanda.ptAttrezzatureMacchineSpeciali.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineSpeciali --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineSpeciali" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineSpeciali -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineSpeciali_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineSpeciali_fpAttrezzatureMacchineSpeciali'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineSpeciali_fpAttrezzatureMacchineSpeciali.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineSpeciali --></div>

			
	
	<div id="p_wpAttrezzatureMacchineMovimentoATerra" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineMovimentoATerra -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineMovimentoATerra">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineMovimentoATerraTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchineMovimentoATerra')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchineMovimentoATerra.label')}" labelFor="widg_chbAttrezzatureMacchineMovimentoATerra" errorFor="widg_chbAttrezzatureMacchineMovimentoATerra" labelId="chbAttrezzatureMacchineMovimentoATerraLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchineMovimentoATerra -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchineMovimentoATerra" id="widg_chbAttrezzatureMacchineMovimentoATerra"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineMovimentoATerra')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchineMovimentoATerra_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineMovimentoATerra')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchineMovimentoATerra" id="__checkbox_widg_chbAttrezzatureMacchineMovimentoATerra" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchineMovimentoATerra')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchineMovimentoATerra -->
<s:text name="CpDomanda.ptAttrezzatureMacchineMovimentoATerra.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineMovimentoATerra --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineMovimentoATerra" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineMovimentoATerra -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineMovimentoATerra_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineMovimentoATerra_fpAttrezzatureMacchineMovimentoATerra'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineMovimentoATerra_fpAttrezzatureMacchineMovimentoATerra.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineMovimentoATerra --></div>

			
	
	<div id="p_wpAttrezzatureMacchineRimorchi" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineRimorchi -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineRimorchi">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineRimorchiTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchinaRimorchi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchinaRimorchi.label')}" labelFor="widg_chbAttrezzatureMacchinaRimorchi" errorFor="widg_chbAttrezzatureMacchinaRimorchi" labelId="chbAttrezzatureMacchinaRimorchiLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchinaRimorchi -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchinaRimorchi" id="widg_chbAttrezzatureMacchinaRimorchi"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaRimorchi')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchinaRimorchi_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaRimorchi')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchinaRimorchi" id="__checkbox_widg_chbAttrezzatureMacchinaRimorchi" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchinaRimorchi')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchinaRimorchi -->
<s:text name="CpDomanda.ptAttrezzatureMacchinaRimorchi.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineRimorchi --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineRimorchi" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineRimorchi -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineRimorchi_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineRimorchi_fpAttrezzatureMacchinaElencoRimorchi'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineRimorchi_fpAttrezzatureMacchinaElencoRimorchi.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineRimorchi --></div>

			
	
	<div id="p_wpAttrezzatureMacchineVerricelli" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineVerricelli -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineVerricelli">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineVerricelliTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchinaVerricelli')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchinaVerricelli.label')}" labelFor="widg_chbAttrezzatureMacchinaVerricelli" errorFor="widg_chbAttrezzatureMacchinaVerricelli" labelId="chbAttrezzatureMacchinaVerricelliLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchinaVerricelli -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchinaVerricelli" id="widg_chbAttrezzatureMacchinaVerricelli"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaVerricelli')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchinaVerricelli_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaVerricelli')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchinaVerricelli" id="__checkbox_widg_chbAttrezzatureMacchinaVerricelli" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchinaVerricelli')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchinaVerricelli -->
<s:text name="CpDomanda.ptAttrezzatureMacchinaVerricelli.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineVerricelli --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineVerricelli" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineVerricelli -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineVerricelli_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineVerricelli_fpAttrezzatureMacchinaElencoVerricelli'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineVerricelli_fpAttrezzatureMacchinaElencoVerricelli.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineVerricelli --></div>

			
	
	<div id="p_wpAttrezzatureMacchinePle" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchinePle -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchinePle">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchinePleTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchinaPle')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchinaPle.label')}" labelFor="widg_chbAttrezzatureMacchinaPle" errorFor="widg_chbAttrezzatureMacchinaPle" labelId="chbAttrezzatureMacchinaPleLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchinaPle -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchinaPle" id="widg_chbAttrezzatureMacchinaPle"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaPle')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchinaPle_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaPle')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchinaPle" id="__checkbox_widg_chbAttrezzatureMacchinaPle" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchinaPle')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchinaPle -->
<s:text name="CpDomanda.ptAttrezzatureMacchinaPle.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchinePle --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchinePle" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchinePle -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchinePle_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchinePle_fpAttrezzatureMacchinaElencoPle'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchinePle_fpAttrezzatureMacchinaElencoPle.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchinePle --></div>

			
	
	<div id="p_wpAttrezzatureMacchineTrinciaForestale" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineTrinciaForestale -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineTrinciaForestale">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineTrinciaForestaleTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchinaTrinciaForestale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchinaTrinciaForestale.label')}" labelFor="widg_chbAttrezzatureMacchinaTrinciaForestale" errorFor="widg_chbAttrezzatureMacchinaTrinciaForestale" labelId="chbAttrezzatureMacchinaTrinciaForestaleLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchinaTrinciaForestale -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchinaTrinciaForestale" id="widg_chbAttrezzatureMacchinaTrinciaForestale"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaTrinciaForestale')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchinaTrinciaForestale_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchinaTrinciaForestale')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchinaTrinciaForestale" id="__checkbox_widg_chbAttrezzatureMacchinaTrinciaForestale" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchinaTrinciaForestale')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchinaTrinciaForestale -->
<s:text name="CpDomanda.ptAttrezzatureMacchinaTrinciaForestale.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineTrinciaForestale --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineTrinciaForestale" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineTrinciaForestale -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineTrinciaForestale_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineTrinciaForestale_fpAttrezzatureMacchinaElencoTrinciaForestale'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineTrinciaForestale_fpAttrezzatureMacchinaElencoTrinciaForestale.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineTrinciaForestale --></div>

			
	
	<div id="p_wpAttrezzatureMacchineSegherieMobili" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineSegherieMobili -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineSegherieMobili">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineSegherieMobiliTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchineSegherieMobili')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchineSegherieMobili.label')}" labelFor="widg_chbAttrezzatureMacchineSegherieMobili" errorFor="widg_chbAttrezzatureMacchineSegherieMobili" labelId="chbAttrezzatureMacchineSegherieMobiliLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchineSegherieMobili -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchineSegherieMobili" id="widg_chbAttrezzatureMacchineSegherieMobili"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineSegherieMobili')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchineSegherieMobili_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineSegherieMobili')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchineSegherieMobili" id="__checkbox_widg_chbAttrezzatureMacchineSegherieMobili" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchineSegherieMobili')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchineSegherieMobili -->
<s:text name="CpDomanda.ptAttrezzatureMacchineSegherieMobili.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineSegherieMobili --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineSegherieMobili" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineSegherieMobili -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineSegherieMobili_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineSegherieMobili_fpAttrezzatureMacchineSegherieMobili'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineSegherieMobili_fpAttrezzatureMacchineSegherieMobili.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineSegherieMobili --></div>

			
	
	<div id="p_wpAttrezzatureMacchineGruACavo" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineGruACavo -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineGruACavo">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineGruACavoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchineGruACavo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchineGruACavo.label')}" labelFor="widg_chbAttrezzatureMacchineGruACavo" errorFor="widg_chbAttrezzatureMacchineGruACavo" labelId="chbAttrezzatureMacchineGruACavoLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchineGruACavo -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchineGruACavo" id="widg_chbAttrezzatureMacchineGruACavo"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineGruACavo')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchineGruACavo_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineGruACavo')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchineGruACavo" id="__checkbox_widg_chbAttrezzatureMacchineGruACavo" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchineGruACavo')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchineGruACavo -->
<s:text name="CpDomanda.ptAttrezzatureMacchineGruACavo.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineGruACavo --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineGruACavo" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineGruACavo -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineGruACavo_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineGruACavo_fpAttrezzatureMacchineGruACavo'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineGruACavo_fpAttrezzatureMacchineGruACavo.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineGruACavo --></div>

			
	
	<div id="p_wpAttrezzatureMacchineCippatrici" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMacchineCippatrici -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMacchineCippatrici">
	
	<customtag:widgetsPanel id="wpAttrezzatureMacchineCippatriciTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMacchineCippatrici')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMacchineCippatrici.label')}" labelFor="widg_chbAttrezzatureMacchineCippatrici" errorFor="widg_chbAttrezzatureMacchineCippatrici" labelId="chbAttrezzatureMacchineCippatriciLbl"
	position="first"  >


<!-- widget chbAttrezzatureMacchineCippatrici -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMacchineCippatrici" id="widg_chbAttrezzatureMacchineCippatrici"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineCippatrici')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMacchineCippatrici_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMacchineCippatrici')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMacchineCippatrici" id="__checkbox_widg_chbAttrezzatureMacchineCippatrici" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMacchineCippatrici')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMacchineCippatrici -->
<s:text name="CpDomanda.ptAttrezzatureMacchineCippatrici.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMacchineCippatrici --></div>

			
	
	
	<div id="p_mpAttrezzatureMacchineCippatrici" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMacchineCippatrici -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMacchineCippatrici_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMacchineCippatrici_fpAttrezzatureMacchineCippatrici'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMacchineCippatrici_fpAttrezzatureMacchineCippatrici.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMacchineCippatrici --></div>

			
	
	<div id="p_wpAttrezzatureMezziDiTrasporto" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureMezziDiTrasporto -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureMezziDiTrasporto">
	
	<customtag:widgetsPanel id="wpAttrezzatureMezziDiTrasportoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureMezziDiTrasporto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureMezziDiTrasporto.label')}" labelFor="widg_chbAttrezzatureMezziDiTrasporto" errorFor="widg_chbAttrezzatureMezziDiTrasporto" labelId="chbAttrezzatureMezziDiTrasportoLbl"
	position="first"  >


<!-- widget chbAttrezzatureMezziDiTrasporto -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureMezziDiTrasporto" id="widg_chbAttrezzatureMezziDiTrasporto"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureMezziDiTrasporto')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureMezziDiTrasporto_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureMezziDiTrasporto')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureMezziDiTrasporto" id="__checkbox_widg_chbAttrezzatureMezziDiTrasporto" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureMezziDiTrasporto')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureMezziDiTrasporto -->
<s:text name="CpDomanda.ptAttrezzatureMezziDiTrasporto.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureMezziDiTrasporto --></div>

			
	
	
	<div id="p_mpAttrezzatureMezziDiTrasporto" class="panelBlock"><!-- startFragment:p_mpAttrezzatureMezziDiTrasporto -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureMezziDiTrasporto_selectedMultiPanel == 'CpDomanda_mpAttrezzatureMezziDiTrasporto_fpAttrezzatureMezziDiTrasporto'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureMezziDiTrasporto_fpAttrezzatureMezziDiTrasporto.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureMezziDiTrasporto --></div>

			
	
	<div id="p_wpAttrezzatureAltriMezzi" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureAltriMezzi -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureAltriMezzi">
	
	<customtag:widgetsPanel id="wpAttrezzatureAltriMezziTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttrezzatureAltriMezzi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttrezzatureAltriMezzi.label')}" labelFor="widg_chbAttrezzatureAltriMezzi" errorFor="widg_chbAttrezzatureAltriMezzi" labelId="chbAttrezzatureAltriMezziLbl"
	position="first"  >


<!-- widget chbAttrezzatureAltriMezzi -->
<s:checkbox 
	
	
	name="widg_chbAttrezzatureAltriMezzi" id="widg_chbAttrezzatureAltriMezzi"
	disabled="isWidgetDisabled('CpDomanda','chbAttrezzatureAltriMezzi')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttrezzatureAltriMezzi_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttrezzatureAltriMezzi')" >
	<s:hidden name="__checkbox_widg_chbAttrezzatureAltriMezzi" id="__checkbox_widg_chbAttrezzatureAltriMezzi" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttrezzatureAltriMezzi')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptAttrezzatureAltriMezzi -->
<s:text name="CpDomanda.ptAttrezzatureAltriMezzi.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureAltriMezzi --></div>

			
	
	
	<div id="p_mpAttrezzatureAltriMezzi" class="panelBlock"><!-- startFragment:p_mpAttrezzatureAltriMezzi -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureAltriMezzi_selectedMultiPanel == 'CpDomanda_mpAttrezzatureAltriMezzi_fpAttrezzatureAltriMezzi'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureAltriMezzi_fpAttrezzatureAltriMezzi.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureAltriMezzi --></div>

	

		
	

	<!-- endFragment:p_fpMacchineMezziIt --></div>
