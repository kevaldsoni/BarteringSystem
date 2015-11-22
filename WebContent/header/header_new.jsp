<!DOCTYPE html>
<html lang="en">
<%@page import="facebook.FBConnection"%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Lets Barter</title>
	<link rel="icon" href="/barter/favicon/favicon.ico" type="image/x-icon">
    
    <!-- Bootstrap Core CSS -->
    <link href="/barter/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/barter/css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/barter/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	 <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>  
  <script src="/barter/js/bootstrap.min.js"></script>
  <script src="/barter/js/loginvalidation.js"></script>
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
  <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>
</head>

<body>
<%
FBConnection fbConnection = new FBConnection();
%>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/barter/index.jsp">Lets Barter</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/barter/pages/login/login.jsp">Login</a>
                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#loginModal">Login</button>
                    </li>
    
    
                    <li class="active">
                        <a href="/barter/pages/about.html">About</a>
                    </li>
                    <li>
                        <a href="/barter/pages/bartertips.html">Barter Tips</a>
                    </li>
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="portfolio-1-col.html">Jewelry</a>
                            </li>
                            <li>
                                <a href="portfolio-2-col.html">Appliance</a>
                            </li>
                            <li>
                                <a href="portfolio-3-col.html">Clothes</a>
                            </li>
                            <li>
                                <a href="portfolio-4-col.html">Furniture</a>
                            </li>
                            <li>
                                <a href="portfolio-3-col.html">Artifacts</a>
                            </li>
                            <li>
                                <a href="portfolio-4-col.html">Technology</a>
                            </li>
                            
                        </ul>
                    </li>
                    
                    <li>
                         <a href="/barter/pages/faq.html">FAQ</a>
                            </li>
                    <li>
                        <a href="/barter/pages/contact.html">Contact</a>
                    </li>
                    
                         </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
  <!-- Modal -->
  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
     		
           <form id="loginform" class="form-horizontal" role="form" method="post" action="userLogin">
                           <%
								String message=(String)request.getAttribute("message");
								if(message!=null && message.length()>0){
							%>
							<div class="alert alert-danger">
  							<strong>Authentication Failed</strong>
							</div>
							   <%
								}
							   %>
   		                   <div style="margin-bottom: 25px" class="form-group">
   		                   <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                               <input id="login-username" type="text" class="form-control" name="email"  placeholder="email" />  
        					</div>
        					<div class="messageContainer"></div>
                            </div>
        					                        
                            <div style="margin-bottom: 25px" class="form-group">
                            <div class="input-group">
                                 <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                               	 <input id="login-password" type="password" class="form-control" name="password" placeholder="password"/>
                            </div>
                            
                            </div>
                            
                            <div class="input-group">
                               <div class="checkbox">
                               <label><input id="login-remember" type="checkbox" name="remember" value="1"> Remember me </label>
                               </div>
                            </div>
 							
 							
                            <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->
                                    <div class="col-sm-12 controls">
                                      <button id="btn-login" type="submit" class="btn btn-success">Login </button>
                                      <a id="btn-fblogin" href="<%=fbConnection.getFBAuthUrl()%>" class="btn btn-primary">Login with Facebook</a>
                                    </div>
                            </div>
							<input type="hidden" name="formtype" value="login">
                            <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Don't have an account! 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Sign Up Here
                                        </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     
 		
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>Not a member? <a href="#">Sign Up</a></p>
          <p>Forgot <a href="#">Password?</a></p>
        </div>
      </div>
      
    </div>
  </div> 
 <script src="/barter/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/barter/js/bootstrap.min.js"></script>

 <script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>
 
</body>
</html>