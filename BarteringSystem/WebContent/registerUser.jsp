<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Barter World</title>
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

    </head>
    <body>
        <h1>Hello World!</h1>
<c:if test="${empty message}">
<div>message is empty</div>
</c:if>
<c:if test="${not empty message}">
<div id="msg_txt" class="errorBox">
<div>message is not empty</div>
<c:out value="${value}" /><br/>
</div>
</c:if>

        
         <div class="row">
            <div class="col-md-8">
                <h3>Register New User</h3>
                <form name="registerUser" id="registerUser" novalidate method="post" action="registerUser">
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>First Name:</label>
                           <input type="text" class="form-control" id="name" name="name" required data-validation-required-message="Please enter your name.">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Phone Number:</label>
                            <input type="tel" class="form-control" id="phone" name="phone" required data-validation-required-message="Please enter your phone number.">
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Email Address:</label>
                            <input type="email" class="form-control" id="email" name="email" required data-validation-required-message="Please enter your email address.">
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Message:</label>
                            <textarea rows="10" cols="100" class="form-control" id="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button type="submit" class="btn btn-primary">Send Message</button>
                </form>
            </div>

        </div>
        
    <!-- jQuery -->
    <script src="/barter/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/barter/js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <script src="/barter/js/jqBootstrapValidation.js"></script>
    <script src="/barter/js/contact_me.js"></script>
    </body>
</html>
