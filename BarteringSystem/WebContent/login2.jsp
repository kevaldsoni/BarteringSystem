<html>
<head>
<script type="text/javascript">

function submitForm(){
	document.getElementById("loginform").submit();
}
</script>
</head>
<body>
<form id="registerUser"  method="post" action="registerUser" name="registerUser">
<input type="text" name="name" >
<input type="password" name="password" >
<button type="submit" onclick="submitForm()">Login</button>
</form>

</body>

</html>