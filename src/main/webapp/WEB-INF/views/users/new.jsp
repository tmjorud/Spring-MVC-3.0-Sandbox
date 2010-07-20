<%@ include file="/WEB-INF/views/includes.jsp" %>
 
<c:url var="url" value="/users" /> 
<form:form action="${url}" modelAttribute="user" method="POST">

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
			<li><label for="nick">Nick</label></li>
			<li><form:input path="nick" cssErrorClass="input-error" /></li>
			<li><form:errors path="nick" cssClass="error" /></li>
		</ol>
		<ol>
			<li><label for="username">Email</label></li>
			<li><form:input path="username" cssErrorClass="input-error" /></li>
			<li><form:errors path="username" cssClass="error" /></li>
		</ol>
		<ol>
			<li><label for="password">Password</label></li>
			<li><form:password path="password" cssErrorClass="input-error" /></li>
			<li><form:errors path="password" cssClass="error" /></li>
		</ol>
		<ol>
			<li><label for="acceptedTerms">Terms</label></li>
			<li><form:checkbox path="acceptedTerms" /></li>
			<li><form:errors path="acceptedTerms" cssClass="error" /></li>
		</ol>
		<div class="submit-container">
	       <input id="addButton" type="submit" value="Join" /> or <a href="<c:url value="/users"/>">Cancel</a>
	    </div>
	</div>
</form:form>
