<%@ include file="/WEB-INF/views/includes.jsp" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
	
	<%-- FAVICON --%>
	<link rel="shortcut icon" href="<c:url value="/favicon.ico"/>" type="image/x-icon" />
	
	<%-- JAVASCRIPT--%>
	
	<script type="text/javascript" src="<c:url value="/scripts/dojo/dojo.js" />"></script>
	<script type="text/javascript" src="<c:url value="/scripts/Spring.js" />"></script>
	<script type="text/javascript" src="<c:url value="/scripts/Spring-Dojo.js" />"></script>
	
	<%--
	<script type="text/javascript" src="<c:url value="/scripts/jquery-1.4.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/scripts/Spring.js" />"></script>
	<script type="text/javascript" src="<c:url value="/scripts/Spring-jquery.js" />"></script>
	--%>
	<script type="text/javascript" src="<c:url value="/scripts/utils.js" />"></script>
	
	
	<%-- STYLE --%>
	<link rel="stylesheet" type="text/css" href="<c:url value="/styles/screen.css"/>" />
	
	<title><tiles:insertAttribute name="title" /></title>
</head>
<body>

	<c:set var="activeMainMenu">
		<tiles:getAsString name="activeMainMenu"/>
	</c:set>

	<div id="logo">
		<img src="<c:url value="/images/logo.png" />" width="558" height="98" />
	</div>
	<div id="page">
	
			
		<div id="header">
			<tiles:insertAttribute name="header">
				<tiles:putAttribute name="activeMainMenu" value="${activeMainMenu}" />
			</tiles:insertAttribute>
		</div>
		<div id="content" class="">
			<tiles:insertAttribute name="content" />
		</div>
		<div id="footer" class="">
			<tiles:insertAttribute name="footer" />
		</div>
	
	</div>
	<SCRIPT type="text/javascript">
	dojo.query(".ajaxLink").forEach(function(element) {
        Spring.addDecoration(new Spring.AjaxEventDecoration({
            elementId: element.id,
            event: 'onclick',
			params: { fragments: 'content' }
        }));
    });
	</SCRIPT>
</body>
</html>