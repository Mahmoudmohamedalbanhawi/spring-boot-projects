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
            <form:form action="formData" modelAttribute="userModel" class="p-4 border rounded bg-white shadow-sm">


                <div class="form-group mb-3">
                    <form:input type="text" placeholder="enter your userName" path="userName" class="form-control" />
                </div>


                <div class="form-group my-3">
                    <form:input type="password" placeholder="enter your password" path="password" class="form-control" />
                </div>


                <div class="form-group my-3">
                    <form:select path="country" class="form-control">
                        <form:option value="Egypt" label="Egypt" />
                        <form:option value="Brazil" label="Brazil" />
                        <form:option value="Saudia Arabia" label="KSA" />
                    </form:select>
                </div>


                <div class="form-group mb-3">
                    <label>Preferred Programming Language</label><br>
                    <label> Java</label>
                    <form:radiobutton path="programmingLanguage" value="Java" />
                    <label>C# </label>
                    <form:radiobutton path="programmingLanguage" value="C#" />
                    <label> PHP</label>
                     <form:radiobutton path="programmingLanguage" value="PHP" />
                     <label>Ruby </label>
                     <form:radiobutton path="programmingLanguage" value="Ruby" />
                </div>


                <div class="form-group mb-3">
                    <label>Preferred Operating System</label><br>
                     <label>Linux </label>
                     <form:checkbox path="operatingSystem" value="Linux" />
                    <label>Mac OS  </label>
                    <form:checkbox path="operatingSystem" value="Mac OS" />
                    <label> MS Windows  </label>
                   <form:checkbox path="operatingSystem" value="MS Windows" />
                </div>

                <!-- Submit Button -->
                <div class="form-group">
                    <input type="submit" class="btn btn-danger btn-block" />
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
