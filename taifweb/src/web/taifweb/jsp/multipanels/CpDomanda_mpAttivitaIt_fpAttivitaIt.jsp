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

	
	<div id="p_fpAttivitaIt" class="formPanelBlock"><!-- startFragment:p_fpAttivitaIt -->
		
	


	
	

	
	
			
	
	<div id="p_wpAttivitaUltimoAnno" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAttivitaUltimoAnno')" >

	
<div class="tableWidget">


<!-- widget tblAttivitaUltimoAnno -->
<s:set name="CpDomanda_tblAttivitaUltimoAnno_clearStatus" value="isTableClearStatus('CpDomanda_tblAttivitaUltimoAnno')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoAttivitaUltimoAnno"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttivitaUltimoAnno"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAttivitaUltimoAnno_clearStatus}"
               uid="row_tblAttivitaUltimoAnno"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblAttivitaUltimoAnnoCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tblAttivitaUltimoAnno.idAttivita}" name="appDataattivitaUltimoAnnoSelezionate" id="%{'tblAttivitaUltimoAnno-editcell-'+ (#attr.row_tblAttivitaUltimoAnno_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="dsAttivita" titleKey="CpDomanda.tblAttivitaUltimoAnno.dsAttivita.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="altro" titleKey="CpDomanda.tblAttivitaUltimoAnno.altro.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="CpDomanda.tblAttivitaUltimoAnno.fatturato.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAttivitaUltimoAnno['+(#attr.row_tblAttivitaUltimoAnno_rowNum - 1)+'].fatturato'}"   theme="csi-tableinput-rem" maxlength="10" />
		</display:column>
		
		<display:column property="iconaDettaglio" titleKey="CpDomanda.tblAttivitaUltimoAnno.iconaDettaglio.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>

<s:hidden name="__tableselectionempty_appDataattivitaUltimoAnnoSelezionate" id="__tableselectionempty_widg_tblAttivitaUltimoAnno" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno1" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno1 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno1">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno1Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,90,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno1')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno1.label')}" labelFor="widg_chbAttivitaUltimoAnno1" errorFor="widg_chbAttivitaUltimoAnno1" labelId="chbAttivitaUltimoAnno1Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno1 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno1" id="widg_chbAttivitaUltimoAnno1"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno1')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttivitaUltimoAnno1_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno1')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno1" id="__checkbox_widg_chbAttivitaUltimoAnno1" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno1')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno1 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno1.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno1')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno1.label')}" labelFor="widg_tfAttivitaUltimoAnno1" errorFor="appDatagestioneAttivitaUltimoAnno.attivita1.percentuale" labelId="tfAttivitaUltimoAnno1Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno1 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita1.percentuale" id="widg_tfAttivitaUltimoAnno1"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno1')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno1 --></div>

			
	
	
	<div id="p_mpAttivitaUltimoAnno1" class="panelBlock"><!-- startFragment:p_mpAttivitaUltimoAnno1 -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaUltimoAnno1_selectedMultiPanel == 'CpDomanda_mpAttivitaUltimoAnno1_fpAttivitaUltimoAnno1'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaUltimoAnno1_fpAttivitaUltimoAnno1.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaUltimoAnno1 --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno2" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno2 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno2">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno2Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,90,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno2.label')}" labelFor="widg_chbAttivitaUltimoAnno2" errorFor="widg_chbAttivitaUltimoAnno2" labelId="chbAttivitaUltimoAnno2Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno2 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno2" id="widg_chbAttivitaUltimoAnno2"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno2')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttivitaUltimoAnno2_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno2')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno2" id="__checkbox_widg_chbAttivitaUltimoAnno2" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno2')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno2 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno2.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno2.label')}" labelFor="widg_tfAttivitaUltimoAnno2" errorFor="appDatagestioneAttivitaUltimoAnno.attivita2.percentuale" labelId="tfAttivitaUltimoAnno2Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno2 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita2.percentuale" id="widg_tfAttivitaUltimoAnno2"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno2')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno2 --></div>

			
	
	
	<div id="p_mpAttivitaUltimoAnno2" class="panelBlock"><!-- startFragment:p_mpAttivitaUltimoAnno2 -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaUltimoAnno2_selectedMultiPanel == 'CpDomanda_mpAttivitaUltimoAnno2_fpAttivitaUltimoAnno2'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaUltimoAnno2_fpAttivitaUltimoAnno2.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaUltimoAnno2 --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno3" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno3 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno3">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno3Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,90,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno3.label')}" labelFor="widg_chbAttivitaUltimoAnno3" errorFor="widg_chbAttivitaUltimoAnno3" labelId="chbAttivitaUltimoAnno3Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno3 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno3" id="widg_chbAttivitaUltimoAnno3"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno3')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttivitaUltimoAnno3_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno3')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno3" id="__checkbox_widg_chbAttivitaUltimoAnno3" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno3')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno3 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno3.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno3.label')}" labelFor="widg_tfAttivitaUltimoAnno3" errorFor="appDatagestioneAttivitaUltimoAnno.attivita3.percentuale" labelId="tfAttivitaUltimoAnno3Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno3 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita3.percentuale" id="widg_tfAttivitaUltimoAnno3"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno3')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno3 --></div>

			
	
	
	<div id="p_mpAttivitaUltimoAnno3" class="panelBlock"><!-- startFragment:p_mpAttivitaUltimoAnno3 -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaUltimoAnno3_selectedMultiPanel == 'CpDomanda_mpAttivitaUltimoAnno3_fpAttivitaUltimoAnno3'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaUltimoAnno3_fpAttivitaUltimoAnno3.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaUltimoAnno3 --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno4" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno4 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno4">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno4Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,90,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno4')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno4.label')}" labelFor="widg_chbAttivitaUltimoAnno4" errorFor="widg_chbAttivitaUltimoAnno4" labelId="chbAttivitaUltimoAnno4Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno4 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno4" id="widg_chbAttivitaUltimoAnno4"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno4')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttivitaUltimoAnno4_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno4')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno4" id="__checkbox_widg_chbAttivitaUltimoAnno4" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno4')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno4 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno4.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno4')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno4.label')}" labelFor="widg_tfAttivitaUltimoAnno4" errorFor="appDatagestioneAttivitaUltimoAnno.attivita4.percentuale" labelId="tfAttivitaUltimoAnno4Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno4 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita4.percentuale" id="widg_tfAttivitaUltimoAnno4"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno4')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno4 --></div>

			
	
	
	<div id="p_mpAttivitaUltimoAnno4" class="panelBlock"><!-- startFragment:p_mpAttivitaUltimoAnno4 -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaUltimoAnno4_selectedMultiPanel == 'CpDomanda_mpAttivitaUltimoAnno4_fpAttivitaUltimoAnno4'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaUltimoAnno4_fpAttivitaUltimoAnno4.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaUltimoAnno4 --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno5" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno5 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno5">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno5Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,90,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno5')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno5.label')}" labelFor="widg_chbAttivitaUltimoAnno5" errorFor="widg_chbAttivitaUltimoAnno5" labelId="chbAttivitaUltimoAnno5Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno5 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno5" id="widg_chbAttivitaUltimoAnno5"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno5')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbAttivitaUltimoAnno5_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno5')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno5" id="__checkbox_widg_chbAttivitaUltimoAnno5" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno5')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno5 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno5.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno5')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno5.label')}" labelFor="widg_tfAttivitaUltimoAnno5" errorFor="appDatagestioneAttivitaUltimoAnno.attivita5.percentuale" labelId="tfAttivitaUltimoAnno5Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno5 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita5.percentuale" id="widg_tfAttivitaUltimoAnno5"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno5')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno5 --></div>

			
	
	
	<div id="p_mpAttivitaUltimoAnno5" class="panelBlock"><!-- startFragment:p_mpAttivitaUltimoAnno5 -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaUltimoAnno5_selectedMultiPanel == 'CpDomanda_mpAttivitaUltimoAnno5_fpAttivitaUltimoAnno5'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaUltimoAnno5_fpAttivitaUltimoAnno5.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaUltimoAnno5 --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno6" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno6 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno6">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno6Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,90,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno6')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno6.label')}" labelFor="widg_chbAttivitaUltimoAnno6" errorFor="widg_chbAttivitaUltimoAnno6" labelId="chbAttivitaUltimoAnno6Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno6 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno6" id="widg_chbAttivitaUltimoAnno6"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno6')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno6')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno6" id="__checkbox_widg_chbAttivitaUltimoAnno6" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno6')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno6 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno6.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno6')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno6.label')}" labelFor="widg_tfAttivitaUltimoAnno6" errorFor="appDatagestioneAttivitaUltimoAnno.attivita6.percentuale" labelId="tfAttivitaUltimoAnno6Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno6 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita6.percentuale" id="widg_tfAttivitaUltimoAnno6"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno6')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno6 --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno7" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno7 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno7">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno7Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,90,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno7')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno7.label')}" labelFor="widg_chbAttivitaUltimoAnno7" errorFor="widg_chbAttivitaUltimoAnno7" labelId="chbAttivitaUltimoAnno7Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno7 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno7" id="widg_chbAttivitaUltimoAnno7"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno7')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno7')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno7" id="__checkbox_widg_chbAttivitaUltimoAnno7" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno7')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno7 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno7.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno7')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno7.label')}" labelFor="widg_tfAttivitaUltimoAnno7" errorFor="appDatagestioneAttivitaUltimoAnno.attivita7.percentuale" labelId="tfAttivitaUltimoAnno7Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno7 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita7.percentuale" id="widg_tfAttivitaUltimoAnno7"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno7')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno7 --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno8" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno8 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno8">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno8Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,30,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno8')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno8.label')}" labelFor="widg_chbAttivitaUltimoAnno8" errorFor="widg_chbAttivitaUltimoAnno8" labelId="chbAttivitaUltimoAnno8Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno8 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno8" id="widg_chbAttivitaUltimoAnno8"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno8')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno8')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno8" id="__checkbox_widg_chbAttivitaUltimoAnno8" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno8')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno8 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno8.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno8')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno8.label')}" labelFor="widg_tfAttivitaUltimoAnno8" errorFor="appDatagestioneAttivitaUltimoAnno.attivita8.percentuale" labelId="tfAttivitaUltimoAnno8Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno8 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita8.percentuale" id="widg_tfAttivitaUltimoAnno8"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno8')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno8 --></div>

			
	
	<div id="p_wpAttivitaUltimoAnno9" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno9 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno9">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno9Tbl" columns="8" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,60,1,30,2,4">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbAttivitaUltimoAnno9')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbAttivitaUltimoAnno9.label')}" labelFor="widg_chbAttivitaUltimoAnno9" errorFor="widg_chbAttivitaUltimoAnno9" labelId="chbAttivitaUltimoAnno9Lbl"
	position="first"  >


<!-- widget chbAttivitaUltimoAnno9 -->
<s:checkbox 
	
	
	name="widg_chbAttivitaUltimoAnno9" id="widg_chbAttivitaUltimoAnno9"
	disabled="isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno9')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbAttivitaUltimoAnno9')" >
	<s:hidden name="__checkbox_widg_chbAttivitaUltimoAnno9" id="__checkbox_widg_chbAttivitaUltimoAnno9" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptAttivitaUltimoAnno9')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptAttivitaUltimoAnno9 -->
<s:text name="CpDomanda.ptAttivitaUltimoAnno9.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnnoAltro9')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfAttivitaUltimoAnnoAltro9" errorFor="appDatagestioneAttivitaUltimoAnno.attivita9.altro" labelId="tfAttivitaUltimoAnnoAltro9Lbl"
	  >


<!-- widget tfAttivitaUltimoAnnoAltro9 -->
<s:textfield 
	
title=""	
	name="appDatagestioneAttivitaUltimoAnno.attivita9.altro" id="widg_tfAttivitaUltimoAnnoAltro9"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnnoAltro9')"
	size="75" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno9')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno9.label')}" labelFor="widg_tfAttivitaUltimoAnno9" errorFor="appDatagestioneAttivitaUltimoAnno.attivita9.percentuale" labelId="tfAttivitaUltimoAnno9Lbl"
	position="last"  >


<!-- widget tfAttivitaUltimoAnno9 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita9.percentuale" id="widg_tfAttivitaUltimoAnno9"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno9')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno9 --></div>

	

		
	

	<!-- endFragment:p_fpAttivitaIt --></div>
