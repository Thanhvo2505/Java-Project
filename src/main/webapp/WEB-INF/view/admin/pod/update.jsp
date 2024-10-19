<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Phạm An K22 UTH - POD Booking System" />
    <meta name="author" content="Phạm An K22 UTH" />
    <title>Update Pod - Phạm An K22 UTH</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(() => {
            const imgFileUpdate = $("#imgFileUpdate");
            imgFileUpdate.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#imgPreviewUpdate").attr("src", imgURL);
                $("#imgPreviewUpdate").css({ "display": "block" });
            });
        });
    </script>
</head>

<body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="../layout/sidebar.jsp" />
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Manage Pods</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                        <li class="breadcrumb-item active">Pods</li>
                    </ol>
                    <div class=" mt-5">
                        <div class="row">
                            <div class="col-md-6 col-12 mx-auto">
                                <h3>Update Pod Information</h3>
                                <hr />
                                <form:form method="post" action="/admin/pod/update"
                                    enctype="multipart/form-data"
                                    modelAttribute="pod">

                                    <div class="mb-3" style="display: none;">
                                        <label class="form-label">Id:</label>
                                        <form:input type="text" class="form-control" path="id" />
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Name:</label>
                                        <form:input type="text" class="form-control" path="name" />
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Location:</label>
                                        <form:textarea class="form-control" path="location" rows="3" />
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Price Per Hour:</label>
                                        <form:input type="number" class="form-control" path="pricePerHour" step="0.01" />
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Capacity:</label>
                                        <form:input type="number" class="form-control" path="capacity" />
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Available:</label>
                                        <form:select path="isAvailable" class="form-control">
                                            <form:option value="true">Available</form:option>
                                            <form:option value="false">Not Available</form:option>
                                        </form:select>
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Description:</label>
                                        <form:textarea class="form-control" path="description" rows="5" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label for="imgFileUpdate" class="form-label">Image:</label>
                                        <input class="form-control" type="file" id="imgFileUpdate"
                                            accept=".png, .jpg, .jpeg" name="imgFileUpdate" />
                                    </div>

                                    <div class="col-12 mb-3">
                                        <img style="max-height: 250px; display: none;" alt="image preview"
                                            id="imgPreviewUpdate" />
                                    </div>

                                    <button type="submit" class="btn btn-warning">Update Pod</button>
                                </form:form>
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
