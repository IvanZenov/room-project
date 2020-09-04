<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Room Editor">
    <div class="container">
        <div class="card text-center">
            <div class="card-body">
                <h5 class="card-title">Admin list of rooms</h5>
                <a href="${pageContext.request.contextPath}/admin/rooms/addNewRoom" class="btn btn-primary">Add Room</a>
            </div>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th >Image</th>
                <th scope="col">City</th>
                <th scope="col">Street</th>
                <th scope="col">Street Number</th>
                <th scope="col">Description</th>
                <th scope="col">Places</th>
                <th scope="col">Price per night</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
                    <th scope="row">${room.id}</th>
                    <td><img src="${room.imageUrl}" class="img-thumbnail" alt="${room.name}"></td>
                    <td>${room.address.city}</td>
                    <td>${room.address.street}</td>
                    <td>${room.address.numberOfStreet}</td>
                    <td>${room.description}</td>
                    <td>${room.places}</td>
                    <td>${room.pricePerNight}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/rooms/delete?id=${room.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

</tags:master>
