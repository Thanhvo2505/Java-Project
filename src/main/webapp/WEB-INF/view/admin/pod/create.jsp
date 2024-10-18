<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Phạm An K22 UTH - Dự án laptopshop" />
    <meta name="author" content="Phạm An K22 UTH" />
    <title>Create a pod - Phạm An K22 UTH</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(document).ready(() => {
            const avatarFile = $("#avatarFile");
            avatarFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#avatarPreview").attr("src", imgURL);
                $("#avatarPreview").css({ "display": "block" });
            });
        });
    </script>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

    <body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="../layout/sidebar.jsp" />
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Pod</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                        <li class="breadcrumb-item active">Pod</li>
                    </ol>
                    <div class="mt-5">
                        <div class="row">
                            <div class="col-md-6 col-12 mx-auto">
                                <h3>Create a pod</h3>
                                <hr />
                                <form:form method="post" action="/admin/pod/create" class="row"
                                    enctype="multipart/form-data" modelAttribute="newPod">

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">name:</label>
                                        <form:input type="name" class="form-control" path="name" />
                                    </div>
                                    
                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">description:</label>
                                        <form:input type="description" class="form-control" path="description" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Location</label>
                                        <form:input type="text" class="form-control" path="location" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">capacity:</label>
                                        <form:input type="number" class="form-control" path="capacity" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Available</label>
                                        <form:select path="isAvailable" class="form-control">
                                            <form:option value="true">Yes</form:option>
                                            <form:option value="false">No</form:option>
                                        </form:select>
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">pricePerHour</label>
                                        <form:input type="number" class="form-control" path="capacity" />
                                    </div>
                                     
                                    <div class="mb-3 col-12 col-md-6">
                                        <label for="avatarFile" class="form-label">Img:</label>
                                        <input class="form-control" type="file" id="avatarFile"
                                            accept=".png, .jpg, .jpeg" name="podImg" />
                                    </div>
                                    
                                    <div class="col-12 mb-3">
                                        <img style="max-height: 250px; display: none;" alt="avatar preview"
                                            id="avatarPreview" />
                                    </div>
                            
                                    <div class="col-12 mb-5">
                                        <button type="submit" class="btn btn-primary">Create</button>
                                    </div>
                                </form:form>
                            </div>

                        </div>
                    </div>
                </div>
            </main>
            <jsp:include page="../layout/footer.jsp" />
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="/js/scripts.js"></script>

</body>

</html>