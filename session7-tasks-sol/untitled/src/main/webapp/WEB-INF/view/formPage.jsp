<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
 </head>
<body >
   <section>
    <div class="container mt-3">
        <form action="ageForm">
          <div class="mb-3">
            <label for="Year" class="form-label">Year</label>
            <input type="text" class="form-control" name="year" id="Year" aria-describedby="YearHelp">
          </div>
          <div class="mb-3">
            <label for="Month" class="form-label">Month</label>
            <input type="text" class="form-control" name="month" id="Month">
          </div>

          <div class="mb-3">
                      <label for="Day" class="form-label">Day</label>
                      <input type="text" class="form-control" name="day" id="Day">
                    </div>

          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
     </div>

    </section>
</body>
</html>
