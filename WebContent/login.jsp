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

<%@include file="include_header.jsp"%>

<div id="wrapper">

	<p id="crumbs">
		<a href="index.jsp">Home</a> &gt; Login
	</p>

	<h1>Log In</h1>

	<%
		// If the user has not attempted to log in yet, show the form:
		if (email == null) {
	%>

	<FORM NAME="form1" METHOD="POST" Action="login.jsp">
		<table>
			<tbody>
				<tr>
					<td><label for="Email">E-Mail</label></td>
					<td><input value="" name="Email" type="text"></td>
				</tr>
				<tr>
					<td><label for="Password">Password</label></td>
					<td><input value="" name="Password" type="password"></td>
				</tr>
				<tr>
					<td><label for=""></label></td>
					<td><input value="Login" name="" type="submit"></td>
				</tr>
			</tbody>
		</table>
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