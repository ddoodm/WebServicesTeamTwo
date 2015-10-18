		<div>
			<%
				if (author == null) {
			%>

			<div style="background: #eee; text-align: middle; width: 100%;">
				Certified authors, please <a href="login.jsp">log in here</a>.
			</div>

			<%
				} else {
			%>

			<div
				style="background: #eee; border: solid 1px #333; text-align: middle; width: 100%;">
				You are logged in as <%=author.getName()%> &lt;<%=author.getEmail()%>&gt;
			</div>
			<div style="text-align: middle;">
				<a href="logout.jsp">Log out</a>
			</div>

			<%
				}
			%>
		</div>