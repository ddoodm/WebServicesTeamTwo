<%@page import="uts.wsd.teamtwo.*"%>
<%@page import="uts.wsd.teamtwo.JAXB.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	if(session != null)
	{
		session.invalidate();
		%><jsp:forward page="index.jsp" /><%
	}
%>

<%@include file="include_header.jsp"%>

<div id="wrapper">

	<p id="crumbs">
		<a href="index.jsp">Home</a> &gt; Logout
	</p>

	<h1>Log Out</h1>

<p>You have been logged out. Click <a href="index.jsp">here</a> to return to the main page.</p>

</div>

<%@include file="include_footer.jsp"%>