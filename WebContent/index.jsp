<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
			<d:hotels xmlns:d="http://www.uts.edu.au/31284/team2/wsd-hotels"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://www.uts.edu.au/31284/team2/wsd-hotels hotels.xsd ">
				<d:hotel id="1">
					<d:name>Placeholder Hotel</d:name>
					<d:country>Australia</d:country>
					<d:state>New South Wales</d:state>
					<d:city>Sydney</d:city>
					<d:address>24-42 Fiction Ln.</d:address>
					<d:telephone>+61 (02) 9909 2441</d:telephone>
					<d:email>contact@placehotel.com.au</d:email>
					<d:image-url>TheShiodome.jpg</d:image-url>
					<d:description>Placeholder description, lorem ipsum dolar sit amen whatever.</d:description>
				</d:hotel>
				<d:hotel id="2">
					<d:name>Brilliant Inn</d:name>
					<d:country>USA</d:country>
					<d:state>New York</d:state>
					<d:city>New York City</d:city>
					<d:address>28 3rd Ave.</d:address>
					<d:telephone>+01 (01) 5823 4253</d:telephone>
					<d:email>contact@brillinn.com</d:email>
					<d:image-url>ShinjukuKabukichoTower.jpg</d:image-url>
					<d:description>An incredible inn in NYC.</d:description>
				</d:hotel>
			</d:hotels>
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