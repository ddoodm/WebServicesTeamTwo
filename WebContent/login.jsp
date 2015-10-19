<%@page import="uts.wsd.teamtwo.*"%>
<%@page import="uts.wsd.teamtwo.JAXB.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String filePath = application.getRealPath(AuthorApplicaion.AUTHORS_DOCUMENT_PATH);
%>
<jsp:useBean id="authorApp" class="uts.wsd.teamtwo.AuthorApplicaion"
	scope="application">
	<jsp:setProperty name="authorApp" property="filePath"
		value="<%=filePath%>" />
</jsp:useBean>

<%
	// Get POST parameters from a log-in attempt
	String email = request.getParameter("Email");
	String password = request.getParameter("Password");
%>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="style/login.css">
<%@include file="include_header.jsp"%>

<div id="wrapper">

	<p id="crumbs">
		<a href="index.jsp">Home</a> &gt; Login
	</p>

	<h1></h1>

	<%
		// If the user has not attempted to log in yet, show the form:
		if (email == null) {
	%>

	<FORM NAME="form1" METHOD="POST" Action="login.jsp" onsubmit="return CheckLogin();">
		<div class="logo"></div>
		<div class="login-block">
			<h1>Login</h1>
			<input type="text" value="" placeholder="Email" id="Email"
				name="Email" /> <input type="password" value=""
				placeholder="Password" id="Password" name="Password" />
			<button value="Login" name="" type="submit">Submit</button>
		</div>
	</form>

	<%
		} // End if email == null
		else {
			Authors authors = authorApp.getAuthors();
			author = authors.login(email, password);
			if (author != null) { // the login was successful
				session.setAttribute("author", author);
	%>
	<p>
		Login successful. Click <a href="index.jsp">here</a> to return to the
		main page.
	</p>
	<%
		} else {
	%>
	<p>
		Password incorrect. Click <a href="login.jsp">here</a> to try again.
	</p>
	<%
		}
		}
	%>
</div>

<%@include file="include_footer.jsp"%>
<script type="text/javascript">

	function CheckLogin() {
		var email = document.getElementById('Email');
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email.value)) {
			alert('Please provide a valid email address');
			email.focus;
			return false;
		}
	}
</script>