<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Age Calculator App</title>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">

                <div class="card shadow-lg rounded-4">
                    <div class="card-body text-center p-4">
                        <h1 class="mb-3 text-primary"> Age Calculator App</h1>
                        <h5 class="text-secondary mb-4">
                            Here are your age details:
                        </h5>

                        <div class="alert alert-success fs-5" role="alert">
                            <strong>Your Age:</strong><br>
                            ${year} years, ${month} months, ${day} days
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>

</body>
</html>
