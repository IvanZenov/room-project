<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Room Editor">
    <div class="card text-center" style="margin: 30px;">
        <div class="card-body">
            <h5 class="card-title">Admin list of rooms</h5>
            <a href="${pageContext.request.contextPath}/rooms/newRoom" class="btn btn-primary">Add Room</a>
        </div>
    </div>

    <table class="table" style="border: 1px;">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Image</th>
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
                <th scope="row"><img src="${room.imageUrl}" class="card-img" alt="..."></th>
                <th scope="row">${room.address.city}</th>
                <th scope="row">${room.address.street}</th>
                <th scope="row">${room.address.numberOfStreet}</th>
                <th scope="row">${room.description}</th>
                <th scope="row">${room.places}</th>
                <th scope="row">${room.pricePerNight}</th>
                <th scope="row">
                    <a href="${pageContext.request.contextPath}/rooms/delete?id=${room.id}">Delete</a>
                    <a href="#">Delete</a>
                </th>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</tags:master>
