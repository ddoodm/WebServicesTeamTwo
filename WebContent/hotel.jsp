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

<%
	int hotelId = Integer.parseInt(request.getParameter("id"));
	Hotel hotel = hotelApp.getHotel(hotelId);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
		<link rel="stylesheet" type="text/css" href="style/main.css" >
		<title>Hotel Service 33</title>
	</head>
<body>

	<div id="head">
		<img src="style/Hotels33Logo.png"/>
	</div>

	<div id="wrapper">
		<p id="crumbs"><a href="index.jsp">Home</a> > Hotel</p>
		<h1><%= hotel.getName() %></h1>
		<img id="bigHotelImage" src="images/hotels/TheShiodome.jpg" />
		<p><%= hotel.getDescription() %></p>
	</div>

	<div id="trailer">
		<p>
			Hotel Service 33 is Copyright &copy; 2015 UTS Web Services Spring 2015 Team 33
		</p>
	</div>

</body>
</html>