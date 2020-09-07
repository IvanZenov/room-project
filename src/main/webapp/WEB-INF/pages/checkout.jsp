<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>


<tags:master pageTitle="Checkout page">
    <jsp:include page="header.jsp"/>

    <div class="container">
    <div class="row">

        <div class="col-8">
            <div class="container">
                <div class="card mb-3">
                    <img src="${reservation.room.imageUrl}" class="card-img-top" alt="${reservation.room.name}">
                    <div class="card-body">
                        <h5 class="card-title">${reservation.room.name}</h5>

                        <p class="card-text"><small class="text-muted">${reservation.room.address}</small></p>

                        <p class="card-text">${reservation.room.description}</p>
                        <p class="card-text">
                            Places: ${reservation.room.description}
                        </p>
                        <p class="card-text">
                            Price per-night: ${reservation.room.pricePerNight}
                        </p>
                        <p class="card-text">${reservation.room.description}</p>

                    </div>
                </div>
            </div>
        </div>


        <form method="post" action="${pageContext.request.contextPath}/payment">
            <input type="hidden" name="reservationId" value="${reservation.id}">
            <div class="col">
                <!--Left column -->
                <div class="card" style="width: 16rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Payment form</li>

                        <li class="list-group-item">
                            <p>Arrival date: ${reservation.arrivalDate}</p>
                        </li>

                        <li class="list-group-item">
                            <p>Checkout date: ${reservation.checkoutDate}</p>
                        </li>

                        <li class="list-group-item">
                            <p>Total day: ${reservation.totalDay}</p>
                        </li>

                        <li class="list-group-item">
                            <p>Per night: ${reservation.room.pricePerNight}</p>
                        </li>

                        <li class="list-group-item">
                            <p>Total price: ${reservation.totalPrice}</p>
                        </li>

                    </ul>
                </div>
                <button type="submit" class="btn btn-primary btn-bg">Pay</button>

        </form>
    </div>

</tags:master>
