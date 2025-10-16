<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
 </head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg w-100" style="max-width: 500px;">
        <div class="card-body text-center">
            <!-- Success Alert -->
            <div class="alert alert-success" role="alert">
                <h4 class="alert-heading mb-0"> ${message}</h4>
            </div>


            <h5 class="card-title mb-3">Your Information</h5>
            <ul class="list-group text-start mb-4">
                <li class="list-group-item"><strong>Name:</strong> ${user.firstName} ${user.lastName}</li>
                <li class="list-group-item"><strong>Email:</strong> ${user.email}</li>
                <li class="list-group-item"><strong>Date of Birth:</strong> ${user.dateOfBirth}</li>
                <li class="list-group-item"><strong>City:</strong> ${user.city}</li>
            </ul>


            <a href="${pageContext.request.contextPath}/" class="btn btn-primary w-100">
                Go to Home
            </a>
        </div>
    </div>
</div>

</body>
</html>
<html>
