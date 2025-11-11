<html>
<head>

    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>
<body class="bg-light d-flex flex-column align-items-center justify-content-center vh-100">

    <div class="card shadow-lg p-4" style="max-width: 400px; width: 100%;">
        <div class="text-center mb-3">
            <h1 class="h3 text-primary fw-bold">User Info </h1>
        </div>

        <div class="border-top pt-3">
            <p class="mb-2"><strong>Username:</strong> <span class="text-secondary">${userModel.userName}</span></p>
            <p class="mb-0"><strong>Email:</strong> <span class="text-secondary">${userModel.email}</span></p>
        </div>

        <div class="mt-4 text-center">
            <a href="${pageContext.request.contextPath}/" class="btn btn-primary w-100">Go to Dashboard</a>
        </div>
    </div>

</body>
</html>


