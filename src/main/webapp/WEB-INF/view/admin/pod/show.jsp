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
    <title>Dashboard - Phạm An K22 UTH</title>
    <link href="/css/styles.css" rel="stylesheet" />
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
                                <li class="breadcrumb-item active">pods</li>
                            </ol>
                            <div class="mt-5">
                                <div class="row">
                                    <div class="col-12 mx-auto">
                                        <div class="d-flex justify-content-between">
                                            <h3>Table pods</h3>
                                            <a href="/admin/pod/create" class="btn btn-primary">Create a pod</a>
                                        </div>

                                        <hr />
                                        <table class=" table table-bordered table-hover">
                                            <thead  style="text-align: center;">
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Name</th>
                                                    <th>Image</th>
                                                    <th>
                                                        capacity
                                                    </th>
                                                    <th>available</th>
                                                    <th>Price / H</th>
                                                    <th>Location</th>                                      
                                                </tr>
                                            </thead>
                                            <tbody  style="text-align: center;">
                                                <c:forEach var="pod" items="${pods}">
                                                    <tr>
                                                        <th>${pod.id}</th>
                                                        <td>${pod.name}</td>
                                                        <td>
                                                            <img src="/images/pod/${pod.img}" alt="" width="150">
                                                        </td>
                                                        <td>${pod.capacity}</td>
                                                        <!-- active or not   -->
                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${pod.isAvailable}">
                                                                    <button class="btn btn-success">Available</button>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <button class="btn btn-danger">Not Available</button>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        
                                                        <td>                                                     
                                                            <fmt:formatNumber value="${pod.pricePerHour}" type="number" groupingUsed="true" maxFractionDigits="0"/>vnđ/hour
                                                        </td>

                                                        <td>${pod.location}</td>
                                                        <td>
                                                            <a href="/admin/pod/${pod.id}"
                                                                class="btn btn-success">View</a>
                                                            <a href="/admin/pod/update/${pod.id}"
                                                                class="btn btn-warning  mx-2">Update</a>
                                                            <a href="/admin/pod/delete/${pod.id}"
                                                                class="btn btn-danger">Delete</a>
                                                        </td>
                                                    </tr>

                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </main>
                   
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
            <script src="/js/scripts.js"></script>

        </body>

        </html>