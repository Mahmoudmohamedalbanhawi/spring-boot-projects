<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Information</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    <!-- Optional custom CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body class="bg-light">

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8">
            <div class="card shadow-lg border-0 rounded-4">
                <div class="card-header bg-primary text-white text-center">
                    <h3 class="mb-0"> User Information Summary</h3>
                </div>
                <div class="card-body bg-white">
                    <div class="mb-3">
                        <strong> Username:</strong>
                        <span class="text-muted">${userData.userName}</span>
                    </div>
                    <div class="mb-3">
                        <strong> Password:</strong>
                        <span class="text-muted">${userData.password}</span>
                    </div>
                    <div class="mb-3">
                        <strong>Country:</strong>
                        <span class="badge bg-success">${userData.country}</span>
                    </div>
                    <div class="mb-3">
                        <strong> Programming Language:</strong>
                        <span class="badge bg-info text-dark">${userData.programmingLanguage}</span>
                    </div>
                    <div class="mb-3">
                        <strong> Selected Operating Systems:</strong>
                        <ul class="list-group mt-2">
                            <c:forEach var="os" items="${userData.operatingSystem}">
                                <li class="list-group-item d-flex align-items-center">
                                     ${os}
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="card-footer text-center bg-light">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-primary">
                         Back to Form
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
