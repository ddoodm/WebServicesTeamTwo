<%@page import="uts.wsd.teamtwo.HotelApplication"%>
<%@ page import="uts.wsd.teamtwo.JAXB.*" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% String filePath = application.getRealPath(HotelApplication.HOTELS_DOCUMENT_PATH); %>
<jsp:useBean id="hotelApp" class="uts.wsd.teamtwo.HotelApplication" scope="application">
    <jsp:setProperty name="hotelApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
		<link rel="stylesheet" type="text/css" href="style/main.css" >
		<title>Hotel Service</title>
	</head>
<body>

	<div id="head">
		<img src="style/Hotels33Logo.png"/>
	</div>

	<div id="wrapper">
		<h1>WELCOME TO <i>HOTEL SERVICE 33</i></h1>
		<p>Hotel Service 33 is a centralized database of tens of hotels
			across the globe. Our certified reviewers take vacation seriously.
			Start your search for the hotel of your dreams... now!</p>

		<p>We provide REST and SOAP services so that your own applications
			may access our vast database of hotel listings and comprehensive
			reviews.</p>

		<br />

		<c:set var="xmltext">
			<%= 
				// Marshal the hotel list into XML
				hotelApp.produceXML()
			%>
		</c:set>

		<c:import url="index.xsl" var="xslt" />
		<x:transform xml="${xmltext}" xslt="${xslt}" />
	</div>

	<div id="trailer">
		<p>
			Hotel Service 33 is Copyright &copy; 2015 UTS Web Services Spring 2015 Team 33
		</p>
	</div>

</body>
</html>