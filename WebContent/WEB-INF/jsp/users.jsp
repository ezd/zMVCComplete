
<%@ include file="../layouts/taglib.jsp" %>

<table class="table table-striped table-hover table-bordered">
	<tr>
		<th>Users List</th>
	</tr>

	<c:forEach items="${users}" var="user">
		<tr>
			<td><a href='<spring:url value="/users/${user.id}.html" />'> ${user.name}</a></td>
		</tr>
	</c:forEach>

</table>

