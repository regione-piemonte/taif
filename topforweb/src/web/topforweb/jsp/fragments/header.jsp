#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://www.csi.it/taglibs/remincl-1.0" prefix="r"%>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

			
			
<!DOCTYPE html> 
<html  lang="it" xml:lang="it">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>Operatori Forestali</title>
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV2/css/globalPortal.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV2/css/xhtmlStructureUniversal.css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV2/css/general/theme.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="/ris/utheme/general/topforweb/css/topforweb.css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV2/css/corner/corner.css" media="screen" />
		<!--[if lte IE 6]>
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV2/css/ie6.css" media="screen" />
		<![endif]-->
		<!--[if IE 7]>
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV2/css/ie7.css" media="screen" />
		<![endif]-->
		<!-- funzioni e definizioni javascript -->
		<script type="text/javascript" src="<%=request.getContextPath()%>/ris/js/jsFunctions.js"></script>
			
		


	<csiuicore:header />

	</head>
	<body>
		
		<noscript>
			<meta http-equiv="refresh" content="0;url=<%=request.getContextPath()%>/base/javascriptError.do"  />
		</noscript>

		<!-- PAGE (OBBLIGATORIO) -->
		<div id="page">

			<!-- HEADER di PORTALE (con remincl) (facoltativo) -->
			
<r:include url="/ris/utheme/global/themes/xstructureV2/include/portal_header.html" resourceProvider="sp" />

			<!-- fine HEADER di PORTALE (con remincl) (facoltativo) -->

			<!-- APPICATION AREA (OBBLIGATORIO) -->
			<div id="applicationArea">

				<!-- HEADER di APPLICATIVO (con remincl) (facoltativo) -->
				
<r:include url="/ris/utheme/general/topforweb/include/application_header.html" resourceProvider="sp" />

				<!-- fine HEADER di APPLICATIVO (con remincl) (facoltativo) -->

<!-- FINE HEADER -->


