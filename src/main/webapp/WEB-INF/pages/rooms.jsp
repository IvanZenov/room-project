<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Rooms">
    <jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col">
            <!--Left column -->
            <form method="get" action="${pageContext.request.contextPath}/rooms">
                <div class="card" style="width: 16rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Search param</li>
                        <li class="list-group-item">
                            <label>
                                <input type="text" name="query" value="${param.query}" placeholder="Input here">
                            </label>
                        </li>
                        <li class="list-group-item">
                            <label>
                                <p>Checkout date:</p>
                                <input name="checkoutDate" type="date">
                            </label>
                        </li>

                        <li class="list-group-item">
                            <label>
                                <p>Arrival date:</p>
                                <input name="arrivalDate" type="date">
                            </label>
                        </li>
                        <li class="list-group-item">
                            <label>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="priceFrom">Price from</label>
                                        <input type="number" step="0.01" class="form-control" name="priceFrom" id="priceFrom" >
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="priceTo">Price to</label>
                                        <input type="number" step="0.01" class="form-control" name="priceTo" id="priceTo" >
                                    </div>
                                </div>
                            </label>
                        </li>
                    </ul>
                    <button type="submit" class="btn btn-primary btn-bg">Search</button>
                </div>
            </form>

        </div>
        <!-- Right column -->
        <div class="col-8" style="margin-bottom: 50px;" >
            <c:forEach var="room" items="${rooms}">
            <div class="container">
                <div class="card" style="padding: 10px">
                    <div class="row">
                        <div class="col">
                            <img src="${room.imageUrl}" class="card-img" alt="${room.name}">
                        </div>
                        <div class="col-5">
                            <h4 class="card-title">${room.name}</h4>
                            <h5 class="card-text"><small class="text-muted">${room.address}</small></h5>
                            <p class="custom-text">${room.description}</p>
                        </div>
                        <div class="col">
                            <p>${room.pricePerNight} $/per night</p>
                            <p>Places: ${room.places}</p>
                            <a href="${pageContext.request.contextPath}/rooms/${room.id}">
                                <button type="button" class="btn btn btn-outline-primary btn-sm">More</button>
                            </a>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
</tags:master>
