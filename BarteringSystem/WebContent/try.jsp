<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
        
<title>keval special try</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  
</head>
<body>
<form>

	<div class="control-group form-group">
		<label for="emailField">Email address</label>
		<div class="controls">
		<input type="email" class="form-control" id="emailField" placeholder="Enter email"  data-validation-required-message="Enter valid email address">
		<p class="help-block"></p>
		</div>
	</div>
	
	<div class="control-group form-group">
	<label for="passwordField">Password</label>
	<div class="controls">
	<input type="password" class="form-control" id="passwordField" placeholder="Enter password"  data-validation-required-message="Enter password">
	</div>
	</div> 
	<div class="checkbox">
	<label>
		<input type="checkbox"> Checkbox label here
	</label>
	</div>

	
	<button type="submit" class="btn btn-success">Login</button>	
</form>

    <!-- jQuery -->
    <script src="/barter/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
    <script src="/barter/js/bootstrap.min.js"></script>
    <script src="/barter/js/jqBootstrapValidation.js"></script>
    <script src="/barter/js/contact_me.js"></script>
</body>
</html>