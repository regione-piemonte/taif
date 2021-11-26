#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setBundle basename="globalMessages" />

	<jsp:include page="/jsp/fragments/headerNoStruts.jsp" />

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="wrapper">
<h3><fmt:message key="error.sessionexpired.title" /></h3>
<!-- appmoduleId:base -->
<!-- pageId:sessionExpired -->
<div id="applicationError">
	<fmt:message key="error.sessionexpired.warning" />
	<br />
	<fmt:message key="error.sessionexpired.timeout" />
	<br />
	<br />
	<fmt:message key="error.sessionexpired.datanotsaved" />
	<br />
	<fmt:message key="error.sessionexpired.authentication" />
</div>
<div id="applicationError_links" class="commandPanel navigation">
	<div class="button left">
		<a href="<c:out value='${initParam["portal.home"]}' />" class="buttonWidget"><fmt:message key="error.sessionexpired.btnmsgportalhome" /></a>
	</div>
	<div class="button right">
		<a href="<%=request.getContextPath()%>/secure/HomePage.do" class="buttonWidget"><fmt:message key="error.sessionexpired.btnmsgservicehome" /></a>
	</div>
</div>
				</div>
			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

	<jsp:include page="/jsp/fragments/footer.jsp" />

