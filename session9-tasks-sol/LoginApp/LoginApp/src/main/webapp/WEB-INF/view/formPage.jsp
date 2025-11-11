<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Styled Form</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-4">User Form</h2>

            <form:form action="processForm" modelAttribute="userModel" class="p-4 border rounded bg-white shadow-sm">


                <div class="form-group mb-3">
                    <form:input type="text" placeholder="Username" path="userName" class="form-control" />
                    <form:errors path="userName" cssClass="alert-danger"/>
                </div>




                <div class="form-group mb-3">
                    <form:input type="text" placeholder="email" path="email" class="form-control" />
                    <form:errors path="email" cssClass="alert-danger"/>
                </div>


                <div class="form-group mb-3">
                    <form:input type="password" placeholder="Password" path="password" class="form-control" />
                    <form:errors path="password" cssClass="alert-danger"/>
                </div>

                <div class="form-group mb-3">
                    <form:input type="password" placeholder="ConfirmPassword" path="confirmPassword" class="form-control" />
                    <form:errors path="confirmPassword" cssClass="alert-danger"/>
                </div>








                <div class="form-group">
                    <input type="submit" class="btn btn-primary btn-block" />
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
