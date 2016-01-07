<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <title>View devices</title>

    <%@ include file="fragment/headerContent.jspf" %>
</head>

<body>

<div id="wrapper">

    <%@ include file="fragment/menu.jspf" %>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row hidden-sm hidden-xs">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Devices list
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> Admin
                        </li>
                        <li class="active">
                            <i class="fa fa-table"></i> Devices
                        </li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h2>My devices</h2>
                    <div class="table-responsive">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>MAC address</th>
                                <th class="hidden-sm hidden-xs" >Edit</th>
                                <th class="hidden-sm hidden-xs">Remove</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${devices}" var="device">
                                <tr>
                                    <td>${device.name}</td>
                                    <td>${device.macaddress}</td>
                                    <td class="hidden-sm hidden-xs">
                                        <button type="submit" class="btn btn-default">Edit</button>
                                    </td>
                                    <td class="hidden-sm hidden-xs">
                                        <button type="submit" class="btn btn-default">Remove</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
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
