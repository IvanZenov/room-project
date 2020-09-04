<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<tags:master pageTitle="Profile">
    <jsp:include page="header.jsp"/>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Room address</th>
                <th scope="col">Room name</th>
                <th scope="col">Arrival date</th>
                <th scope="col">Checkout date</th>
                <th scope="col">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="reservation" items="${reservations}">
            <tr>
                    <th scope="row">${reservation.id}</th>
                    <td>${reservation.id}</td>
                    <td>${reservation.id}</td>
                    <td>${reservation.arrivalDate}</td>
                    <td>${reservation.checkoutDate}</td>
                    <td>${reservation.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</tags:master>
