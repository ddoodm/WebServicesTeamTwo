<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="uts.wsd.teamtwo.*"%>
<% String filePath = application.getRealPath("WEB-INF/authors.xml"); %>
<jsp:useBean id="hotelApp2" class="uts.wsd.teamtwo.HotelApplication"
	scope="application">
	<jsp:setProperty name="hotelApp2" property="filePath"
		value="<%=filePath%>" />
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");

		Authors authors = hotelApp2.getAuthors();
		Author author = authors.login(email, password);
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
	%>

</body>
</html>