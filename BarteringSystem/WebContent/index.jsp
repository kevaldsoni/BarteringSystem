<!DOCTYPE html>
<html lang="en">

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

</head>

<body>

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
              			<% 
              				if(session.getAttribute("name")!=null){
								String email = (String)session.getAttribute("email");
								String name = (String)session.getAttribute("name");
						%>
							<a href="#">Welcome <%=name%></a>
						<%
							}else{
						%>
                        	<a href="/barter/pages/login/login.jsp">Login</a>
                     	<%
				     		}
                      	%>
                    </li>
                    <li>
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
                    <!-- <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="blog-home-1.html">Blog Home 1</a>
                            </li>
                            <li>
                                <a href="blog-home-2.html">Blog Home 2</a>
                            </li>
                            <li>
                                <a href="blog-post.html">Blog Post</a>
                            </li>
                        </ul>
                    </li>-->
                    
                          
                    <!-- <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="full-width.html">Full Width Page</a>
                            </li>
                            <li>
                                <a href="sidebar.html">Sidebar Page</a>
                            </li>
                            <li>
                                <a href="faq.html">FAQ</a>
                            </li>
                            <li>
                                <a href="404.html">404</a>
                            </li>
                            <li>
                                <a href="pricing.html">Pricing Table</a>
                            </li>
                        </ul>
                    </li> -->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Header Carousel -->
    
    <header class="main-header" role="banner">
  <img src="/barter/images/wsj_extremes_bartering_820.jpg" class="img-responsive" alt="Banner Image" style="width: 1200px;height: 250px;"/>
    <!--  <header id="myCarousel" class="carousel slide"> -->
        <!-- Indicators -->
       <!--  <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol> -->

        <!-- Wrapper for slides -->
        <!-- <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide One');"></div>
                <div class="carousel-caption">
                    <h2>Caption 1</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Two');"></div>
                <div class="carousel-caption">
                    <h2>Caption 2</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Three');"></div>
                <div class="carousel-caption">
                    <h2>Caption 3</h2>
                </div>
            </div>
        </div> -->

        <!-- Controls -->
        <!-- <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a> -->
    </header>

    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Welcome to LetsBarter.com
                </h1>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-check"></i> Easy to Use</h4>
                    </div>
                    <div class="panel-body">
                        <p>Take a look at our simple to use web-site, browse through the categories. Once you like something send in your offer by filling in our simple barter form and there you are, part of a sustainable future.</p>
                       <!--  <a href="#" class="btn btn-default">Learn More</a>  -->
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-gift"></i> Buy without money, save on shipping</h4>
                    </div>
                    <div class="panel-body">
                        <p>You can pay for the items with your own items. You can save on shipping and not wait for the UPS guy, by picking up the items on the agreed time which is freedom.</p>
                       <!--  <a href="#" class="btn btn-default">Learn More</a>  -->
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-compass"></i> Local Market</h4>
                    </div>
                    <div class="panel-body">
                        <p> The concept of local market has its advantages, like fresh produce or services which are available and accessible locally to all the users. Neighborhood markets are the future of how societies function.</p>
                        <!-- <a href="#" class="btn btn-default">Learn More</a>  -->
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->

        <!-- Portfolio Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Categories</h2>
            </div>
            </div>
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="images/1.catg_jewelery.jpg"  alt="" height="700" width="450">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="images/2.catg_appliance.jpg" alt="" height="700" width="450">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="images/3.catg_clothes.jpg" alt="" height="700" width="450">
                </a>
            </div>
          </div>
          <div class="row">
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="images/4.catg_furniture.jpg" alt="" height="700" width="450">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="images/5.catg_collectables.jpg" alt="" height="700" width="450">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="images/6.catg_tech.jpg" alt="" height="700" width="450">
                </a>
            </div>
        </div>
        <!-- /.row -->

        <!-- Features Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Why Barter?</h2>
            </div>
            <div class="col-md-6">
                <p><strong>Lets walkthrough.</strong> You might be thinking, well i'll just put the item on a classified page online or on an auction website. The statistics behind used items that are sold on those sites are only about 25% to 50% of the original price. 
                Again, barter values are generally higher than most means of reallocating your treasures.
                </p>
                <p>Another idea to consider about bartering is that there is no sales tax on items.  If someone were to set up a "bartering store", they would not have to pay sales tax reports with the state. Bartering can be fun and profitable. We promise you that once you get started, you wont want to quit whether you are doing it as a hobby or a business.
                LetsBarter lets you explore the endless possibilities of trading.</p>
            </div>
            <div class="col-md-6">
                <img class="img-responsive" src="http://placehold.it/700x450" alt="">
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Call to Action Section -->
       <!--  <div class="well">
            <div class="row">
                <div class="col-md-8">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-lg btn-default btn-block" href="#">Call to Action</a>
                </div>
            </div>
        </div> -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Letsbarter.com 2015</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="/barter/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/barter/js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
