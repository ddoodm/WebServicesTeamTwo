<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/main.css">
<title>Hotel Service</title>
</head>
<body>

	<div id="head">
	<div>
			<jsp:useBean id="author" class="uts.wsd.teamtwo.Author"
				scope="session" />

			<%
				if (author.getName() == null) {
			%>

			<div
				style="background: #eee; text-align: right; width: 100%;">You
				are not logged in</div>
			<div style="text-align: right;">
				<a href="login.jsp">Longin</a>
			</div>

			<%
				} else {
			%>

			<div
				style="background: #eee; border: solid 1px #333; text-align: right; width: 100%;">
				You are logged in as
				<jsp:getProperty property="name" name="author" />
				&lt;<jsp:getProperty property="email" name="author" />&gt;
			</div>
			<div style="text-align: right;">
				<a href="logout.jsp">Logout</a>
			</div>

			<%
				}
			%>
		</div>
		<img src="style/Hotels33Logo.png" />
		
	</div>

	<div id="wrapper">
		<h1>
			WELCOME TO <i>HOTEL SERVICE 33</i>
		</h1>
		<p>Hotel Service 33 is a centralized database of tens of hotels
			across the globe. Our certified reviewers take vacation seriously.
			Start your search for the hotel of your dreams... now!</p>

		<p>We provide REST and SOAP services so that your own applications
			may access our vast database of hotel listings and comprehensive
			reviews.</p>

		<br />

		<h1>HOTEL LISTING</h1>
		<div id="hotelListing">
			<div class="hotelListItem">
				<img class="hotelListIcon" src="images/hotels/TheShiodome.jpg" />
				<h2>The Shiodome</h2>
				<p>Tokyo, Japan</p>
				<p>Average Rating: 8 / 10</p>
				<p>This is a sample review. The hotel is pretty alright.</p>
			</div>
			<div class="hotelListItem">
				<img class="hotelListIcon"
					src="images/hotels/ShinjukuKabukichoTower.jpg" />
				<h2>Shinjuku Kabukicho Tower</h2>
				<p>Tokyo, Japan</p>
				<p>Average Rating: 7 / 10</p>
				<p>Another sample review. The hotel is nice, but not quite as
					good as others in the local area. I don't actually know what this
					hotel is like, I'm just going off the picture.</p>
			</div>
		</div>

	</div>

	<div id="trailer">
		<p>Hotel Service 33 is Copyright &copy; 2015 UTS Web Services
			Spring 2015 Team 33</p>
	</div>

</body>
</html>
