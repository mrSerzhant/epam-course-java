<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
            crossorigin="anonymous"></script>

    <title>Main Page</title>
</head>
<body>

<div class="container">

    <div style="text-align:center">
        <h1>Parsing Page</h1>
    </div>

    <div>
        <form method="post" action="parse" enctype="multipart/form-data">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td>Download xml file</td>
                    <td>
                        <input type="file" name="filename" class="form-control-file" id="exampleFormControlFile1">
                    </td>
                </tr>
                <tr>
                    <td>Type of parser</td>
                    <td>
                        <select class="form-select" name="typeParse" aria-label="Default select example">
                            <option selected="selected" value="DOM">DOM parser</option>
                            <option value="SAX">SAX parser</option>
                            <option value="StAX">StAX parser</option>
                        </select>
                    </td>
                </tr>
                </tbody>
            </table>

            <div class="row">
                <div class="col-2">
                    <input type="submit" value="Go Parse" style="width:200px" class="btn btn-outline-secondary"/>
                </div>
                <div class="col-10">
                    <c:if test="${response != null}">
                        <input  style="width: 150px;" class="form-control" type="text" placeholder="${response}" readonly>
                    </c:if>
                </div>
            </div>
        </form>
    </div>


</div>
</div>
</body>

</html>