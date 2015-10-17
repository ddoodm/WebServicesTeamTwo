<%@page import="uts.wsd.teamtwo.*"%>
<%@page import="uts.wsd.teamtwo.JAXB.*"%>

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

		<br />

		<c:set var="xmltext">
			<%= 
				// Marshal the hotel list into XML
				hotelApp.produceXML()
			%>
		</c:set>

		<c:import url="hotelList.xsl" var="xslt" />
		<x:transform xml="${xmltext}" xslt="${xslt}" />
	</div>

<%@include file="include_footer.jsp" %>