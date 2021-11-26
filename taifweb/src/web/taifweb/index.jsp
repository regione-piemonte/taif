#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<% 
	if (request.getQueryString()==null||request.getQueryString().length()==0){
  		response.sendRedirect(request.getContextPath() + "/secure/HomePage.do");
	}
	else{
		response.sendRedirect(request.getContextPath() + "/secure/HomePage.do?"+request.getQueryString());
	}
%>
