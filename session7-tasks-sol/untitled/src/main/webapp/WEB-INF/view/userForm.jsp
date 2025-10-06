<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
 </head>
<body >
   <section>
    <div class="container mt-3">
        <form action="submitForm">
          <div class="mb-3">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" class="form-control" name="firstName" id="firstName" aria-describedby="YearHelp">
          </div>
          <div class="mb-3">
            <label for="lastName" class="form-label">Last Name</label>
            <input type="text" class="form-control" name="lastName" id="lastName">
          </div>

          <div class="mb-3">
           <label for="email" class="form-label">Email Address</label>
           <input type="text" class="form-control" name="email" id="email">
          </div>
                    <div class="mb-3">
                         <label for="dateOfBirth" class="form-label">Date of Birth</label>
                         <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth">
                     </div>

                            <div class="mb-3">
                                                     <label for="city" class="form-label">City</label>
                                                     <input type="text" class="form-control" name="city" id="city">
                                                 </div>


          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
     </div>

    </section>
</body>
</html>
