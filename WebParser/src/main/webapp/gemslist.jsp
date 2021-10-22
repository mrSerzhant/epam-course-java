<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Parsing Page</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<jsp:useBean id="gems" scope="request" type="java.util.List"/>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h1>${typeParse}</h1>
        </div>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">ID</th>
                <th scope="col">Mining Method</th>
                <th scope="col">Date of Creation</th>
                <th scope="col">Origin</th>
                <th scope="col">Preciousness</th>
                <th scope="col">Color</th>
                <th scope="col">Transparency</th>
                <th scope="col">Facet</th>
                <th scope="col">Weight</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="gem" items="${gems}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${gem.name}</td>
                    <td>${gem.ID}</td>
                    <td>${gem.miningMethod}</td>
                    <td>${gem.creationDate}</td>
                    <td>${gem.origin}</td>
                    <td>${gem.preciousness}</td>
                    <td>${gem.color}</td>
                    <td>${gem.transparency}</td>
                    <td>${gem.facet}</td>
                    <td>${gem.weight}</td>
                    <td>${gem.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <a href="/webparser" style="width:200px" class="btn btn-outline-secondary">Back</a>
    </div>
</div>
</body>
</html>
