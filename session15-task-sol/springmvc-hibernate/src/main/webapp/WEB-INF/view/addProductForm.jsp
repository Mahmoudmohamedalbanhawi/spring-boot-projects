<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>
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
            background-color: #28a745;
            color: white;
            font-size: 1.5rem;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .btn-submit {
            margin-top: 15px;
        }
    </style>
</head>
<body>
<div class="card shadow">
    <div class="card-header text-center">
        Add New Product
    </div>
    <div class="card-body">
        <form:form modelAttribute="product" action="saveProduct" method="post">
           <form:hidden path="id" />
            <div class="form-group">
                <label for="productName">Product Name:</label>
                <form:input path="productName" cssClass="form-control" id="productName"/>
                 <form:errors path="productName" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                            <label for="Name">Name:</label>
                            <form:input path="productDetails.name" cssClass="form-control" id="Name"/>
                            <form:errors path="productDetails.name" cssClass="text-danger"/>
                        </div>
            <div class="form-group">
                <label for="manufacturer">Manufacturer:</label>
                <form:input path="productDetails.manufacturer" cssClass="form-control" id="manufacturer"/>
                 <form:errors path="productDetails.manufacturer" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <form:input path="productDetails.price" cssClass="form-control" id="price"/>
                <form:errors path="productDetails.price" cssClass="text-danger"/>

            </div>
            <div class="form-group">
                <label for="expirationDate">Expiration Date:</label>
                <form:input path="productDetails.expirationDate" type="date" cssClass="form-control" id="expirationDate"/>
                <form:errors path="productDetails.expirationDate" cssClass="text-danger"/>

            </div>
            <div class="form-group">
                <label for="available">Available:</label>
                <form:checkbox path="productDetails.available" id="available"/>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success btn-submit">Save Product</button>
                <a href="<c:url value='/'/>" class="btn btn-secondary btn-submit">Cancel</a>
            </div>
        </form:form>
    </div>
</div>

<!-- Optional Bootstrap JS -->
</body>
</html>
