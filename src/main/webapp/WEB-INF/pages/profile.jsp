<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<tags:master pageTitle="Profile">
    <jsp:include page="header.jsp"/>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Room address</th>
                <th scope="col">Room name</th>
                <th scope="col">Arrival date</th>
                <th scope="col">Checkout date</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="reservation" items="${reservations}">
            <tr>
                    <td>${reservation.room.address}</td>
                    <td>${reservation.room.name}</td>
                    <td>${reservation.arrivalDate}</td>
                    <td>${reservation.checkoutDate}</td>
                    <td>${reservation.status}</td>
                    <td>
                        <c:if test="${reservation.status.name()=='CONFIRMED'}">
                            <a href="${pageContext.request.contextPath}/payment/${reservation.id}">Pay</a>
                        </c:if>
                    </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</tags:master>
