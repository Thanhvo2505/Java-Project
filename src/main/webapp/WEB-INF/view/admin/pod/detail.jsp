<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Phạm An K22 UTH - Dự án " />
    <meta name="author" content="Phạm An K22 UTH" />
    <title>Detail pod - Phạm An K22 UTH</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="../layout/sidebar.jsp" />
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Manage pods</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                        <li class="breadcrumb-item active">Pods</li>
                    </ol>
                    <div class="container mt-5">
                        <div class="row">
                            <div class="col-12 mx-auto">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h3>Pod Detail <span class="badge bg-primary">${id}</span></h3>
                                </div>

                                <hr />

                                <div class="card shadow-sm" style="width: 60%; margin: auto;">
                                    <div class="card-header bg-info text-white">
                                        <strong>Pod Information</strong>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">ID: <strong>${pod.id}</strong></li>
                                        <li class="list-group-item">Name: <strong>${pod.name}</strong></li>
                                        <li class="list-group-item">Description: <strong>${pod.description}</strong></li>
                                        <li class="list-group-item">Location: <strong>${pod.location}</strong></li>
                                        <li class="list-group-item">Availability: <strong>${pod.isAvailable}</strong></li>  
                                        <li class="list-group-item">
                                            <p id="pricePerHour" class="text-dark fs-5 fw-bold mb-0"> Price:
                                                <fmt:formatNumber value="${pod.pricePerHour}" type="number" groupingUsed="true" maxFractionDigits="0"/>vnđ/hour
                                            </p>
                                           
                                        </li> 
                                        <li class="list-group-item text-center">
                                            <img src="/images/pod/${pod.img}" alt="Pod Image" width="100%" class="img-fluid rounded">
                                        </li>
                                    </ul>
                                </div>
                                <a href="/admin/pod" class="btn btn-success mt-3">Back</a>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <jsp:include page="../layout/footer.jsp" />
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="/js/scripts.js"></script>
</body>

</html>
