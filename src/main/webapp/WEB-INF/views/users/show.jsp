<%@ include file="/WEB-INF/views/includes.jsp" %>

<p>PathVariable : ${PathVariable}</p>
	
<p>ID : ${user.id}</p>
<p>NICK : ${user.nick}</p>

<c:url var="url" value="/users/${user.id}" />
<form:form action="${url}" method="delete">
	<input id="deleteButton_${user.id}" type="submit" value="Delete" />
</form:form>
