<%@ include file="/WEB-INF/views/includes.jsp" %>

<%-- ACTIVE MAIN MENU ITEM --%>
<c:set var="activeMainMenu">
	<tiles:getAsString name="activeMainMenu"/>
</c:set>

<%-- IS LOGGED IN--%>
<sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')">
	<c:set var="isLoggedIn" value="1"/>
</sec:authorize>


<ol id="logInMenu">
	<c:choose>
		<c:when test="${isLoggedIn == 1}">
			<li>
				Welcome <b><sec:authentication property="principal.nick"/></b>				
			</li>
			<li>|</li>
			<li><a href="<c:url value="/account/logout" />">Log out</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<c:url value="/users/new" />">Join</a></li>
			<li>|</li>
			<li><a href="<c:url value="/account/login" />" style="">Log in</a></li>
			<li>|</li>
		</c:otherwise>
	</c:choose>	
</ol>
<div id="menuContainer">
	<ol class="menu">
		<li><a id="home" href="<c:url value="/" />" class="ajaxLink <c:if test="${activeMainMenu == 'home'}">active </c:if>">Home</a></li>
		<li><a href="<c:url value="/users" />" class="<c:if test="${activeMainMenu == 'users'}">active </c:if>">Users</a></li>
		<li><a id="secure_page" href="<c:url value="/admin/secure_page" />" class="ajaxLink <c:if test="${activeMainMenu == 'secure_page'}">active </c:if>">Secure page</a></li>
		<li><a id="secure_page_2" href="<c:url value="/admin/secure_page" />" class="ajaxLink <c:if test="${activeMainMenu == 'secure_page'}">active </c:if>">Secure page 2</a></li>
		
		<li><a href="<c:url value="/admin/very_secure_page" />" class="very_secure_page<c:if test="${activeMainMenu == 'very_secure_page'}">active </c:if>">Very secure page</a></li>
	</ol>
</div>
