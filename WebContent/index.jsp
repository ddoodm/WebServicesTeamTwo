<%@page import="uts.wsd.teamtwo.*"%>
<%@page import="uts.wsd.teamtwo.JAXB.*"%>
<%@page import="uts.wsd.teamtwo.translator.TranslatorClient"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String
		realHotelDbPath = application.getRealPath(HotelApplication.HOTELS_DOCUMENT_PATH);
%>
<jsp:useBean id="hotelApp" class="uts.wsd.teamtwo.HotelApplication" scope="application">
    <jsp:setProperty name="hotelApp" property="filePath" value="<%=realHotelDbPath%>"/>
</jsp:useBean>

<%
	// Obtain hotel filter string from parameters
	String hotelSearch = request.getParameter("search");

	// The list of hotels to display
	Hotels hotels = hotelApp.getHotels();
	
	// If a search string is supplied, filter the result
	if(hotelSearch != null && !hotelSearch.isEmpty())
		hotels = hotels.filterByName(hotelSearch);
%>

<%@include file="include_header.jsp" %>

	<div id="wrapper">
	
		<p id="crumbs">Home</p>
	
		<h1>WELCOME TO <i>HOTEL SERVICE 33</i></h1>
		<p>Hotel Service 33 is a centralized database of tens of hotels
			across the globe. Our certified reviewers take vacation seriously.
			Start your search for the hotel of your dreams... now!</p>

		<p>We provide REST and SOAP services so that your own applications
			may access our vast database of hotel listings and comprehensive
			reviews.</p>
			
		<p>If you happen to be one of our fine authors, please make yourself
		known to our friendly JSP server by <b>logging in at the bottom of the page</b>.</p>

		<br />

		<c:set var="xmltext">
			<%=
				// Marshal the hotel list into XML
				hotelApp.produceXMLFor(hotels)
			%>
		</c:set>

		<c:import url="hotelList.xsl" var="xslt" />
		<x:transform xml="${xmltext}" xslt="${xslt}" />
	</div>

<%@include file="include_footer.jsp" %>