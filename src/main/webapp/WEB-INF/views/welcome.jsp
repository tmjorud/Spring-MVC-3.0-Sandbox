<%@ include file="/WEB-INF/views/includes.jsp" %>

<h1>
	Congratulations! You're running Spring!
</h1>

<br />

<h2>What's this project about?</h2>
<p>
This project aims to provide a sample application based on Spring 3.0.
</p>
<br />
<h2>What's inside:</h2>
<ol>
	<li>Spring 3.0.1.RELEASE</li>
	<li>Spring Security 3.0.2.RELEASE</li>
	<li>Tiles 2.1.2</li>
	<li>UrlRewriteFilter 3.1.0</li>
	<li>log4j 1.2.15</li>
</ol>
<br />
<h2>Spring Security</h2>
<ol>
	<li>URI "/account/secure_page" is only accessible for users with authority set to ROLE_USER or ROLE_ADMIN</li>
	<li>URI "/account/very_secure_page" is only accessible for users with authority set to ROLE_ADMIN</li>
	<li>Deleting an user is only accessible for ROLE_ADMIN through @PreAuthorize set in UserDaoImpl on deleteUser(long id).</li>
</ol>
