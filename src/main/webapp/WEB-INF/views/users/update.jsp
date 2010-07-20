<%@ include file="/WEB-INF/views/includes.jsp" %>

<c:url var="url" value="/users" />
<form:form action="${url}" modelAttribute="user" method="PUT">

	<form:errors path="*">
		<div class="alert-error">
			<h2>This is error heading</h2>
			<ol>
			<c:forEach items="${messages}" var="message">
				<li>${message}</li>
			</c:forEach>
			</ol>
		</div>
	</form:errors>
	
	<div class="formContainer">
		<ol>
			<li><label for="email">Email</label></li>
			<li><form:input path="email" cssErrorClass="input-error" /></li>
			<li><form:errors path="email" cssClass="error" /></li>
		</ol>
		<ol>
			<li><label for="nick">Nick</label></li>
			<li><form:input path="nick" cssErrorClass="input-error" /></li>
			<li><form:errors path="nick" cssClass="error" /></li>
		</ol>
		<ol>
			<li><label for="acceptedTerms">Terms</label></li>
			<li><form:checkbox path="acceptedTerms" /></li>
			<li><form:errors path="acceptedTerms" cssClass="error" /></li>
		</ol>
		<div class="submit-container">
			<form:hidden path="id" />
			<input id="addButton" type="submit" value="Update" />
		</div>
	</div>
</form:form>
