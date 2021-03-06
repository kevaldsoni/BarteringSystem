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

    <link href="/barter/css/socialmedia.css" rel="stylesheet">
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%

/** response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
 */
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
       				 
                        <% 
              				if(session.getAttribute("name")!=null){
								String email = (String)session.getAttribute("email");
								String name = (String)session.getAttribute("name");
						%>
							<li>
                        	<a href="/barter/pages/newBarterForm.jsp">New Barter</a>
                    	</li>
						<%
							}
						%>
       				
    				<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                        	<li>
                                <a href="/barter/pages/barteringposts.jsp">All Barter Posts</a>
                            </li>
                            <li>
                                <a href="/barter/pages/barteringposts.jsp">Food Products</a>
                            </li>
                            <li>
                                <a href="/barter/pages/barteringposts.jsp">Automotive</a>
                            </li>
                            <li>
                                <a href="/barter/pages/barteringposts.jsp">Clothes</a>
                            </li>
                            <li>
                                <a href="/barter/pages/barteringposts.jsp">Furniture</a>
                            </li>
                            <li>
                                <a href="/barter/pages/barteringposts.jsp">Services</a>
                            </li>
                            <li>
                                <a href="/barter/pages/barteringposts.jsp">Electronics</a>
                            </li>
                            
                        </ul>
                    </li>
    				<li>
                        <a href="/barter/pages/bartertips.jsp">Barter Tips</a>
                    </li>
                    <li>
                         <a href="/barter/pages/faq.jsp">FAQ</a>
                    </li>
                	<li>
                        <a href="/barter/pages/about.jsp">About</a>
                    </li>
                 	<li>   
                    	<a href="/barter/pages/contactUs.jsp">Contact</a>
                    </li>
                   <li class="dropdown" class="active">
                        
                        
                        <% 
              				if(session.getAttribute("name")!=null){
								String email = (String)session.getAttribute("email");
								String name = (String)session.getAttribute("name");
						%>
							
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome <%=name%> <b class="caret"></b></a>
                       		<ul class="dropdown-menu">
                       		<li>
                                <a href="/barter/pages/newBarterForm.jsp">New Barter Request</a>
                            </li>
                            <li>
                                <a href="/barter/pages/myAccount.jsp">My Account</a>
                            </li>
                            <li>
                                <a href="/barter/pages/logout.jsp">Sign Out</a>
                            </li>
                            
                       		 </ul>
						<%
							}else{
						%>
                        	<a href="/barter/pages/login/login.jsp">Login</a>
                     	<%
				     		}
                      	%>
                        
                        
                        
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
<!-- Bootstrap Core JavaScript -->
    <!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
    <script src="/barter/js/jquery.js"></script>
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