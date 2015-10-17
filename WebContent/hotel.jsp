<%@page import="uts.wsd.teamtwo.ReviewsApplication"%>
<%@page import="uts.wsd.teamtwo.HotelApplication"%>
<%@ page import="uts.wsd.teamtwo.JAXB.*" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String
		realHotelDbPath = application.getRealPath(HotelApplication.HOTELS_DOCUMENT_PATH),
		realReviewsDbPath = application.getRealPath(ReviewsApplication.REVIEWS_DOCUMENT_PATH);
%>
<jsp:useBean id="hotelApp" class="uts.wsd.teamtwo.HotelApplication" scope="application">
    <jsp:setProperty name="hotelApp" property="filePath" value="<%=realHotelDbPath%>"/>
</jsp:useBean>
<jsp:useBean id="reviewApp" class="uts.wsd.teamtwo.ReviewsApplication" scope="application">
    <jsp:setProperty name="reviewApp" property="filePath" value="<%=realReviewsDbPath%>"/>
</jsp:useBean>

<%
	int hotelId = Integer.parseInt(request.getParameter("id"));
	Hotel hotel = hotelApp.getHotel(hotelId);
	Reviews reviews = reviewApp.getReviewsForHotel(hotel);
%>

<%@include file="include_header.jsp" %>

	<div id="wrapper">
		<p id="crumbs"><a href="index.jsp">Home</a> &gt; Hotel</p>
		
		<c:set var="hotelXml">
			<%= hotelApp.produceXMLFor(hotelApp.getHotels().filterById(hotelId)) %>
		</c:set>
		<c:import url="hotelDetail.xsl" var="hotelXslt" />
		<x:transform xml="${hotelXml}" xslt="${hotelXslt}" />
		
		<c:set var="reviewListXml">
			<%= 
				// Marshal the review list into XML
				reviewApp.produceXMLFor(reviews)
			%>
		</c:set>
		<c:import url="reviewList.xsl" var="reviewListXslt" />
		<x:transform xml="${reviewListXml}" xslt="${reviewListXslt}" />
		
		<!-- Provide review composition UI to registered reviewers -->
		<% if(author != null) { %>
		<h1>Compose a New Review</h1>
		<form id="composeReviewForm" method="post" action="reviewServlet">
			<table>
				<tr>
					<td width="150">Title</td>
					<td width="300"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td width="150">Rating</td>
					<td width="300"><input type="text" name="rating"> / 10</td>
				</tr>
				<tr>
					<td width="150">Message</td>
					<td width="300"><textarea name="message" rows="4" cols="50"></textarea></td>
				</tr>
				<tr>
					<td width="150"></td>
					<td width="300"><input type="submit" value="Post Review"></td>
				</tr>
			</table>
			
			<input type="hidden" name="operation" value="postReview" />
			<input type="hidden" name="hotelId" value="<%= hotelId %>" />
		</form>
		<% } // End if(author != null) %>
		
	</div>

<%@include file="include_footer.jsp" %>