<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<tr>
		<th>Column 1 Heading</th>
	</tr>

	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.name}</td>
		</tr>
	</c:forEach>

</table>

