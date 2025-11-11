<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Details</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 30px;
        }
        .card {
            max-width: 600px;
            margin: 0 auto;
        }
        .card-header {
            background-color: #007bff;
            color: white;
            font-size: 1.5rem;
        }
        .back-btn {
            margin-top: 20px;
        }
        .table th {
            width: 30%;
        }
    </style>
</head>
<body>
<div class="card shadow">
    <div class="card-header text-center">
        Product Details
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <tbody>
            <tr>
                <th>ID</th>
                <td>${product.id}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${product.productName}</td>

            </tr>
            <c:if test="${product.productDetails != null}">
                <tr>
                    <th>Manufacturer</th>
                    <td>${product.productDetails.manufacturer}</td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td>${product.productDetails.price}</td>
                </tr>
                <tr>
                    <th>Expiration Date</th>
                    <td>${product.productDetails.expirationDate}</td>
                </tr>
                <tr>
                    <th>Available</th>
                    <td>${product.productDetails.available}</td>
                </tr>
            </c:if>
            </tbody>
        </table>
        <div class="text-center back-btn">
            <a href="<c:url value='/'/>" class="btn btn-primary">Back to Products List</a>
        </div>
    </div>
</div>

</body>
</html>
