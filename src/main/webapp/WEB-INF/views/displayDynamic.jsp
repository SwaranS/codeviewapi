<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 15/07/2014
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Bar Chart</title>
    <script src="resources/js/Chart.js"></script>
    <script type="text/javascript" src="resources/js/jquery-2.1.1.js"></script>
</head>
<body>
<div style="width: 50%">
    <canvas id="canvas" height="450" width="600"></canvas>
</div>


<script>


    var response = $.ajax({ type: "GET",
        url: "http://localhost:8080/barChartData?url=https://github.com/SwaranS/codeviewapi.git",
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

</body>
</html>

