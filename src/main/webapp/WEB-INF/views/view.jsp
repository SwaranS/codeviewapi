<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Views</title>
	  <script type="text/javascript">
  window.onload = function () {
    var chart = new CanvasJS.Chart("chartContainer", {

      title:{
        text: "Fruits sold in First Quarter"              
      },
      data: [//array of dataSeries              
        { //dataSeries object

         /*** Change type "column" to "bar", "area", "line" or "pie"***/
         type: "bar",
         dataPoints: [
         { label: "banana", y: 18 },
         { label: "orange", y: 29 },
         { label: "apple", y: 40 },                                    
         { label: "mango", y: 34 },
         { label: "grape", y: 24 }
         ]
       }
       ]
     });

    chart.render();
  }
  </script>
  <script type="text/javascript" src="resources/js/canvasjs.min.js"></script>
	
</head>
<body>
 <div id="chartContainer" style="height: 300px; width: 100%;">
  </div>
</body>
</html>
