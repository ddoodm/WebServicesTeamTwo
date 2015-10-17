		<%
			// Obtain the error from the request attributes (if it exists)
			ComposeReviewErrorFields errors = (ComposeReviewErrorFields)request.getAttribute("composeReviewError");
			
			// Working variable
			String s;
		%>
		<h1>Compose a New Review</h1>
		<form id="composeReviewForm" method="post" action="reviewServlet">
			<table>
				<tr>
					<td width="150">Title</td>
					<td width="225">
						<input type="text" name="title" value="<% if((s = request.getParameter("title")) != null) out.print(s); %>">
					</td>
					<td class="errorText">
						<% if(errors == ComposeReviewErrorFields.TITLE_MISSING) { %>
						Please supply a title
						<% } if(errors == ComposeReviewErrorFields.TITLE_FORMAT) { %>
						Words must begin upper-case
						<% } %>
					</td>
				</tr>
				<tr>
					<td width="150">Rating</td>
					<td width="225">
						<input type="text" name="rating" value="<% if((s = request.getParameter("rating")) != null) out.print(s); %>"> / 10
					</td>
					<td class="errorText">
						<% if(errors == ComposeReviewErrorFields.RATING_MISSING) { %>
						Please supply a rating
						<% } if(errors == ComposeReviewErrorFields.RATING_FORMAT) { %>
						Supply an integer between 1 - 10
						<% } %>
					</td>
				</tr>
				<tr>
					<td width="150">Message</td>
					<td width="225">
						<textarea name="message" rows="4" cols="40"><% if((s = request.getParameter("message")) != null) out.print(s); %></textarea>
					</td>
					<td class="errorText">
						<% if(errors == ComposeReviewErrorFields.MESSAGE_MISSING) { %>
						Please supply a message
						<% } %>
					</td>
				</tr>
				<tr>
					<td width="150"></td>
					<td width="225"><input type="submit" value="Post Review"></td>
					<td class="errorText"></td>
				</tr>
			</table>
			
			<input type="hidden" name="operation" value="postReview" />
			<input type="hidden" name="hotelId" value="<%= hotelId %>" />
		</form>