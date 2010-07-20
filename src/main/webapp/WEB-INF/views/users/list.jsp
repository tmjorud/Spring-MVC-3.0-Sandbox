<%@ include file="/WEB-INF/views/includes.jsp" %>

${successMessage}
<c:choose>
	<c:when test="${successMessage != ''}">
		<div class="alert-success">
			<h2>${successMessage}</h2>
		</div>
	</c:when>
</c:choose>


<table class="table" width="100%">
	<thead>
		<tr>
			<th>ID</th>
			<th>EMAIL</th>
			<th>NICK</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="5">The above data were fictional and made up, please do not sue me</td>
		</tr>
	</tfoot>
	<tbody>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.id}</td>
				<td>${user.email}</td>
				<td>${user.nick}</td>
				<td><a href="<c:url value="/users/" />${user.id}">Show</a></td>
				<td><a href="<c:url value="/users/" />${user.id}/edit">Edit</a></td>
				<td>
					<c:url var="url" value="/users/${user.id}" /> 
					<form:form action="${url}" method="delete">
						<input id="deleteButton_${user.id}" type="submit" value="Delete" />
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
