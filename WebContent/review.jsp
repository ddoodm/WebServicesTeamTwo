<%@page import="uts.wsd.teamtwo.AuthorApplicaion"%>
<%@page import="uts.wsd.teamtwo.ReviewsApplication"%>
<%@page import="uts.wsd.teamtwo.HotelApplication"%>
<%@ page import="uts.wsd.teamtwo.JAXB.*" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String
		realHotelDbPath = application.getRealPath(HotelApplication.HOTELS_DOCUMENT_PATH),
		realReviewsDbPath = application.getRealPath(ReviewsApplication.REVIEWS_DOCUMENT_PATH),
		realAuthorDbPath = application.getRealPath(AuthorApplicaion.AUTHORS_DOCUMENT_PATH);
%>
<jsp:useBean id="hotelApp" class="uts.wsd.teamtwo.HotelApplication" scope="application">
    <jsp:setProperty name="hotelApp" property="filePath" value="<%=realHotelDbPath%>"/>
</jsp:useBean>
<jsp:useBean id="reviewApp" class="uts.wsd.teamtwo.ReviewsApplication" scope="application">
    <jsp:setProperty name="reviewApp" property="filePath" value="<%=realReviewsDbPath%>"/>
</jsp:useBean>
<jsp:useBean id="authorApp" class="uts.wsd.teamtwo.AuthorApplicaion" scope="application">
    <jsp:setProperty name="authorApp" property="filePath" value="<%=realAuthorDbPath%>"/>
</jsp:useBean>

<%
	int reviewId = Integer.parseInt(request.getParameter("id"));
	Review review = reviewApp.getReview(reviewId);
	
	// If the review is not defined, redirect to the 404 document
	if(review == null)
		%><c:redirect url="/404.jsp"/><%
	
	// Find the associated hotel and author
	Hotel hotel = hotelApp.getHotel(review.getHotelId());
	Author reviewAuthor = authorApp.getAuthor(review.getAuthorId());
	
	// Get requested language translation
	String languageRequest = request.getParameter("language");
	
	// Prepare a single-entry Reviews list to transform via XSLT
	Reviews reviewCollection = reviewApp.filterById(reviewId);
	
	// Make the request to the translator SOAP client only if required
	if(languageRequest != null && !languageRequest.isEmpty() && !languageRequest.equals("en"))
		reviewCollection = reviewCollection.translateTo(languageRequest);
%>

<%@include file="include_header.jsp" %>

	<div id="wrapper">
		<p id="crumbs">
			<a href="index.jsp">Home</a> &gt; 
			<a href="hotel.jsp?id=<%= hotel.getId() %>">Hotel</a> &gt; 
			Review
		</p>
		
		<h1><%= review.getTitle() %></h1>
		
		<div>
			Composed by <%= reviewAuthor.getName() %> (<a href="mailto:<%= reviewAuthor.getEmail() %>"><%= reviewAuthor.getEmail() %></a>)<br />
			Posted on <%= review.getDate() %>
		</div>

		<c:set var="reviewXml">
			<%= reviewApp.produceXMLFor(reviewCollection) %>
		</c:set>
		<c:import url="review.xsl" var="reviewXslt" />
		<x:transform xml="${reviewXml}" xslt="${reviewXslt}" />
		
		<!-- Translation form -->
		<div>
			<form method="get" action="review.jsp">
				<select name="language">
					<option value="en">English</option>
					<option value="de">Deutsche</option>
					<option value="ja">日本語</option>
					<option value="es">Español</option>
					<option value="it">Italiana</option>
				</select>
				<input type="submit" value="Translate" />
				<input type="hidden" name="id" value="<%= review.getId() %>" />
			</form>
		</div>
		
		<!-- Provide functionality to Authors to delete their own reviews -->
		<% if(author != null && reviewAuthor.getId() == author.getId()) { %>
			<form method="post" action="reviewServlet">
				<input type="submit" value="Delete Review" />
				<input type="hidden" name="operation" value="deleteReview" />
				<input type="hidden" name="reviewId" value="<%= review.getId() %>" />
			</form>
		<% } %>

	</div>

<%@include file="include_footer.jsp" %>