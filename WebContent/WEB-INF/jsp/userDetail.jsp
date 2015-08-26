<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	User Id:${user.id}
	<br> User Name:${user.name}
	<br>


<!-- 	<!-- Button trigger modal --> -->
<!-- 	<button type="button" class="btn btn-primary btn-lg" -->
<!-- 		data-toggle="modal" data-target="#myModal">New blog -->
<!-- 	</button> -->
<%-- 	<form:form commandName="blog" cssClass="form-horizontal"> --%>
<!-- 		<!-- Modal --> -->
<!-- 		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" -->
<!-- 			aria-labelledby="myModalLabel"> -->
<!-- 			<div class="modal-dialog" role="document"> -->
<!-- 				<div class="modal-content"> -->
<!-- 					<div class="modal-header"> -->
<!-- 						<button type="button" class="close" data-dismiss="modal" -->
<!-- 							aria-label="Close"> -->
<!-- 							<span aria-hidden="true">&times;</span> -->
<!-- 						</button> -->
<!-- 						<h4 class="modal-title" id="myModalLabel">Add blog</h4> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body"> -->
<!-- 						<div class="form-group"> -->
<!-- 							<label for="name" class="col-sm-2 control-label">Name:</label> -->
<!-- 							<div class="col-sm-10"> -->
<%-- 								<form:input path="name" cssClass="form-control" /> --%>
<%-- 								<form:errors path="name"/> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="form-group"> -->
<!-- 							<label for="url" class="col-sm-2 control-label">Url:</label> -->
<!-- 							<div class="col-sm-10"> -->
<%-- 								<form:input path="url" cssClass="form-control" /> --%>
<%-- 								<form:errors path="url"/> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
<!-- 						<input type="submit" class="btn btn-default" value="Save" /> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<%-- 	</form:form> --%>
<!-- 	<br> -->
	<strong>Blogs</strong>
	<br>
	<br>
<script type="text/javascript">
$(document).ready(function(){
	$('.nav-tabs a:first').tab('show');
	$('.triggerRemove').click(function(e){
		e.preventDefault();
		$('#modalRemove .removeBtn').attr("href",$(this).attr("href"));
		$('#modalRemove').modal();
	});
});
</script>
	<div>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" >
			<c:forEach items="${user.blogs}" var="blog">
				<li role="presentation">
				<a href="#blog_${blog.id}"
					aria-controls="home" role="tab" data-toggle="tab">${blog.name}</a></li>
			</c:forEach>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<c:forEach items="${user.blogs}" var="blog">
				<div  class="tab-pane active" id="blog_${blog.id}"><a href='<spring:url value="/account/remove/${blog.id}.html"/>' class="btn btn-danger triggerRemove">Remove</a><br>
					Blog Name:${blog.name}<br> Blog Url:${blog.url}<br>
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Title</th>
								<th>Link</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${blog.items}" var="item">

								<tr>
									<td>${item.title}</td>
									<td>${item.link}</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Remove</h4>
					</div>
					<div class="modal-body">
						Really remove?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<a href="" class="btn btn-danger removeBtn">Remove</a>
					</div>
				</div>
			</div>
		</div>
</body>
</html>