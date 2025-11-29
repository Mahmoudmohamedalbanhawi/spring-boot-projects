<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--        import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

</head>
<body>
<h1>Products Data</h1>
<div class="tbl-div">
    <form action="search" method="get" class="form-inline mb-3">
        <input type="text" name="query" class="form-control mr-2" placeholder="Search by product name"
               value="${searchQuery != null ? searchQuery : ''}">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Show Details</th>
            <th scope="col">Add/Update</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productsList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.productName}</td>
                <td>
                    <form:form action="showProductDetails">
                          <input type="hidden" name="id" value="${item.id}" />
                        <input type="submit" class="btn btn-primary" value="View Details"/>
                    </form:form>
                </td>
                <td>
                    <form:form action="editProduct">
                        <input type="hidden" name="id" value="${item.id}" />

                        <input type="submit" class="btn btn-warning" value="Add/update Details"/>
                    </form:form>
                </td>
               <td>
                   <form:form action="deleteProduct" method="post" id="deleteForm-${item.id}">
                       <input type="hidden" name="id" value="${item.id}" />

                       <!-- Delete button triggers modal -->
                       <button type="button"
                               class="btn btn-danger"
                               data-bs-toggle="modal"
                               data-bs-target="#deleteModal-${item.id}">
                           Delete
                       </button>
                   </form:form>

                   <!-- Bootstrap Delete Confirmation Modal -->
                   <div class="modal fade" id="deleteModal-${item.id}" tabindex="-1">
                       <div class="modal-dialog modal-dialog-centered">
                           <div class="modal-content">

                               <div class="modal-header bg-danger text-white">
                                   <h5 class="modal-title">Confirm Delete</h5>
                                   <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                               </div>

                               <div class="modal-body">
                                   <p>❗ Are you sure you want to delete <strong>${item.productName}</strong>?</p>
                               </div>

                               <div class="modal-footer">
                                   <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                       Cancel
                                   </button>

                                   <!-- When clicked: submits form -->
                                   <button type="button" class="btn btn-danger"
                                           onclick="document.getElementById('deleteForm-${item.id}').submit()">
                                       Yes, Delete
                                   </button>
                               </div>

                           </div>
                       </div>
                   </div>
               </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form:form action="addProduct">
        <input type="submit" class="btn btn-success" value="Add new Product"/>
    </form:form>
</div>
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title">Confirm Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                <p>Are you sure you want to delete this product?</p>
            </div>

            <div class="modal-footer">
                <button class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>

                <form id="deleteForm" action="deleteProduct" method="post">
                    <input type="hidden" name="id" id="deleteId" />
                    <button type="submit" class="btn btn-danger">Yes, Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</html>