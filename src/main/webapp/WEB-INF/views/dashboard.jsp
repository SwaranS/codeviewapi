<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>View Metric Data for Project</title>

    <script src="resources/js/Chart.js"></script>
    <script type="text/javascript" src="resources/js/jquery-2.1.1.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/bootstrap/css/starter-template.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="resources/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="resources/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="resources/assets/js/ie10-viewport-bug-workaround.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">More Charts</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a id = "linesOfCodeButton" href="#">Lines Of Code</a></li>
                <li><a id = "linesOfCommentsButton" href="#">Lines Of Comments</a></li>
                <li><a id = "numberOfClasses" href="#">Number of Classes</a></li>
                <li><a id = "cyclomatic" href="#">Cyclomatic</a></li>
                <li><a id = "ratio" href="#">Ratio</a></li>
                <li><a id = "interaction" href="#">Interaction</a></li>
                <li><a id = "volume" href="#">Volume</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div >

    <div class="container" style="width: 65%">
        <canvas id="canvas" height="600" width="800"></canvas>
    </div>


    <script>
        var response = $.ajax({ type: "GET",
            url: "http://localhost:8080/compareLinesOfCode?urlList=${url}",
            async: false
        }).responseText;

        var barChartData = jQuery.parseJSON(response);
        window.onload = function(){
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myBar = new Chart(ctx).Bar(barChartData, {
                responsive : true
            });
        }

    </script>

    <script>
        $(document).ready(function() {
            $("#linesOfCodeButton").click(function(){
                loadCanvas(returnData("http://localhost:8080/compareLinesOfCode?urlList=${url}"));
            });
            $("#ratio").click(function(){
                loadCanvas(returnData("http://localhost:8080/compareRatio?urlList=${url}"));
            });
            $("#linesOfCommentsButton").click(function(){
                loadCanvas(returnData("http://localhost:8080/compareLinesOfComments?urlList=${url}"));
            });
            $("#numberOfClasses").click(function(){
                loadCanvas(returnData("http://localhost:8080/compareNumberOfClasses?urlList=${url}"));
            });
            $("#cyclomatic").click(function(){
                loadCanvas(returnData("http://localhost:8080/compareCyclomatic?urlList=${url}"));
            });
            $("#interaction").click(function(){
                loadCanvas(returnData("http://localhost:8080/compareInteraction?urlList=${url}"));
            });
            $("#volume").click(function(){
                loadCanvas(returnData("http://localhost:8080/compareVolume?urlList=${url}"));
            });
        });

        function returnData(urlIn){
            var response = $.ajax({ type: "GET",
                url: urlIn,
                async: false
            }).responseText;

            return  jQuery.parseJSON(response);
        }
        function loadCanvas(barChartData){
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myBar = new Chart(ctx).Bar(barChartData, {
                responsive : true
            });
        }

    </script>


</div>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
