<%@ include file="/WEB-INF/views/includes.jsp" %>

<h1 style="margin-bottom:10px;">Log in</h1>
<form name="f" action="<c:url value="/j_spring_security_check" />" method="post">

	<c:if test="${not empty param.login_error}">
		<div class="alert-error">
			<h2>Login failed</h2>
			<p>The username/password you entered is incorrect.</p>
		</div>
	</c:if>
	
	<div class="formContainer">	
		<ol>
			<li><label for="j_username">Username</label></li>
			<li><input type="text" name="j_username" id="j_username" /></li>
		</ol>
		<ol>
			<li><label for="j_password">Password</label></li>
			<li><input type="password" name="j_password" id="j_password" /></li>
		</ol>
		<ol>
			<li><label for="remember_me">Remember me</label></li>
			<li><input type="checkbox" name="_spring_security_remember_me" id="remember_me" /></li>
		</ol>
		<div class="submit-container">
	       <input name="submit" id="submit" type="submit" value="Login" />	
	    </div>
	</div>
</form>