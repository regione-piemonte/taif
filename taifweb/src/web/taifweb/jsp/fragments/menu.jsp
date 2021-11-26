#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib prefix="s" uri="/struts-tags" %>

	
<div id="mainMenu">
	<h3>Menu di navigazione</h3>
	<ul>
		
<s:if test="isMenuVisible('menuNuovaDomanda')">
	<s:if test="isMenuEnabled('menuNuovaDomanda')">
		<s:url id="targetUrlMenuNuovaDomanda" action="goToMenuNuovaDomandaFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuNuovaDomanda')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuNuovaDomanda}" id="menu_items_menuNuovaDomanda">
				<s:text name="menuNuovaDomanda.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuNuovaDomanda.label" /></li>
	</s:else>
	

</s:if>

		
		
<s:if test="isMenuVisible('menuTueDomande')">
	<s:if test="isMenuEnabled('menuTueDomande')">
		<s:url id="targetUrlMenuTueDomande" action="goToMenuTueDomandeFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuTueDomande')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuTueDomande}" id="menu_items_menuTueDomande">
				<s:text name="menuTueDomande.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuTueDomande.label" /></li>
	</s:else>
	

</s:if>

		

	</ul>
</div>


