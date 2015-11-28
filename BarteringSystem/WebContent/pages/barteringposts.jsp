<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Lets Barter</title>


    <!-- Custom CSS -->
    <link href="/barter/css/barter.css" rel="stylesheet">
	

</head>

<body>

    <!-- Navigation -->
    <jsp:include page="/header/header.jsp"></jsp:include>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Browwse Categories</p>
                <div class="list-group">
                    <a href="#" class="list-group-item">Category 1</a>
                    <a href="#" class="list-group-item">Category 2</a>
                    <a href="#" class="list-group-item">Category 3</a>
                </div>
            </div>

            <div class="col-md-9">
                <div class="row">
                <div id="barter_post_results"></div>
				</div>
			</div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

	<jsp:include page="/footer/footer.jsp"></jsp:include>
    </div>
<script type="text/javascript" src="/barter/js/barterDetailData.js"></script>
</body>

</html>
