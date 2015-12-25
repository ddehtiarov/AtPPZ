<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <title>Outlets status</title>

    <%@ include file="fragment/headerContent.jspf" %>
</head>

<body>

<div id="wrapper">

    <%@ include file="fragment/menu.jspf" %>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Outlet Status
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> Admin
                        </li>
                        <li class="active">
                            <i class="fa fa-table"></i> Status
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <h2>Contextual Classes</h2>
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Outlet name</th>
                                <th>Outlet location</th>
                                <th>STATUS</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${outlets}" var="outlet">
                            <c:if test="${outlet.status.value eq 'PAUSED'}">
                            <tr class="warning">
                                <td>${outlet.name}</td>
                                <td>${outlet.location}</td>
                                <td>${outlet.status.value}</td>
                            </tr>
                            </c:if>
                            <c:if test="${outlet.status.value eq 'OFFLINE'}">
                            <tr class="danger">
                                <td>${outlet.name}</td>
                                <td>${outlet.location}</td>
                                <td>${outlet.status.value}</td>
                            </tr>
                            </c:if>
                            <c:if test="${outlet.status.value eq 'ONLINE'}">
                            <tr class="success">
                                <td>${outlet.name}</td>
                                <td>${outlet.location}</td>
                                <td>${outlet.status.value}</td>
                            </tr>
                            </c:if>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</div>


</body>

</html>
