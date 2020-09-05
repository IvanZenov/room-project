<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Reservations Manage">
    <div class="container">
        <form method="post" action="${pageContext.request.contextPath}/admin/reservations">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th>Username</th>
                    <th scope="col">User email</th>
                    <th scope="col">Room name</th>
                    <th scope="col">Room Address</th>
                    <th scope="col">Arrival Date</th>
                    <th scope="col">Checkout date</th>
                    <th scope="col">Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="reservation" items="${reservations}">
                    <tr>
                        <th scope="row">${reservation.id}</th>
                        <td>${reservation.user.firstName} ${reservation.user.secondName}</td>
                        <td>${reservation.user.email}</td>
                        <td>${reservation.room.name}</td>
                        <td>${reservation.room.address}</td>
                        <td>${reservation.arrivalDate}</td>
                        <td>${reservation.checkoutDate}</td>
                        <td>
                            <select name="status" class="form-control">
                                <option value="NOT_CONSIDERED">Not considered</option>
                                <option value="CONFIRMED">Confirmed</option>
                                <option value="CANCELED">Canceled</option>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button lass="btn btn-primary" type="submit">Update</button>
        </form>
    </div>

</tags:master>
