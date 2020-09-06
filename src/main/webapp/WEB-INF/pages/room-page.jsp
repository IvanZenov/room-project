<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>


<tags:master pageTitle="Rooms">
    <jsp:include page="header.jsp"/>

    <div class="container">
    <div class="row">

    <div class="col-8">
        <div class="container">
            <div class="card mb-3">
                <img src="${room.imageUrl}" class="card-img-top" alt="${room.name}">
                <div class="card-body">
                    <h5 class="card-title">${room.name}</h5>

                    <p class="card-text"><small class="text-muted">${room.address}</small></p>

                    <p class="card-text">${room.description}</p>
                    <p class="card-text">
                        Places: ${room.description}
                    </p>
                    <p class="card-text">
                        Price per-night: ${room.pricePerNight}
                    </p>
                    <p class="card-text">${room.description}</p>

                </div>
            </div>
        </div>
    </div>

    <form method="post" action="${pageContext.request.contextPath}/rooms/${room.id}">

        <div class="col">
            <!--Left column -->
            <div class="card" style="width: 16rem;">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Order Form</li>

                    <li class="list-group-item">
                        <label>
                            <p>Check In:</p>
                            <input name="arrivalDate" type="date">
                            <div class="invalid-feedback">
                                Please provide a valid date.
                            </div>
                        </label>
                    </li>

                    <li class="list-group-item">
                        <label>
                            <p>Check Out:</p>
                            <input name="checkoutDate" type="date">
                            <div class="invalid-feedback">
                                Please provide a valid date.
                            </div>
                        </label>
                    </li>


                </ul>
            </div>
            <button type="submit" class="btn btn-primary btn-bg">Reserve</button>
        </div>
    </form>

</tags:master>
