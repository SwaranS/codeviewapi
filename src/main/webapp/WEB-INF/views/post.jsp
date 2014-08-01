<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script src="resources/js/jquery-2.1.1.js" type="text/javascript"></script>

</head>
<body>
<center>
    <script>
        function doAjaxPost() {
            var urlList = $('#urlList').val();
            $.ajax({
                type: "Get",
                url: "receiveUrlList",
                data: "name=" + urlList,
                success: function (returnData) {
                    alert("First: "+returnData.firstValue +" Second: "+ returnData.secondValue);
                },
                error: function (e) {
                    alert('Error: ' + e);
                }
            });
        }
    </script>
    <div id="form">
        <form method="get">
            <table>
                <tr>
                    <td>Name :</td>
                    <td><input type="text" id="urlList"/></td>
                </tr>

                <tr>
                    <td> </td>
                    <td><input type="button" value="Save" onclick="doAjaxPost();"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</center>
</body>
</html>
