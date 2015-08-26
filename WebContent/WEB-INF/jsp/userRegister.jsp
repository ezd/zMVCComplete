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

	<c:if test="${param.success eq true }">
		<div class="alert alert-success">Registration successful</div>
	</c:if>
	<form:form commandName="user"
		cssClass="form-horizontal regisrtationForm">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-10">
				<form:errors path="name" />
				<form:input path="name" cssClass="form-control" />

			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email:</label>
			<div class="col-sm-10">
				<form:errors path="email" />
				<form:input path="email" cssClass="form-control" />

			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password:</label>
			<div class="col-sm-10">
				<form:errors path="password" />
				<form:password path="password" cssClass="form-control" />

			</div>
		</div>
		<div class="form-group">
			
			<label for="password" class="col-sm-2 control-label">Password again:</label> 
			<div class="col-sm-10">
					<input type="password" name="password_again" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<input type="submit" class="btn btn-default" value="Register" />
			</div>
		</div>

	</form:form>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$(".regisrtationForm").validate(
							{
								rules : {
									name : {
										required : true,
										minlength : 3
									},
									email : {
										required : true,
										email : true
									},
									password : {
										required : true,
										minlength : 6

									},
									password_again : {
										required : true,
										minlength : 6,
										equalTo : "#password"
									}

								},
								highlight: function(element) {
									$(element).closest('.form-group')
											.removeClass('.has-success')
											.addClass('.has-error');
								},
								unhighlight: function(element) {
									$(element).closest('.form-group')
											.removeClass('.has-error')
											.addClass('.has-success');
								}
							});
				});
	</script>
</body>
</html>