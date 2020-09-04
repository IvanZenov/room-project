
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header style="margin-bottom: 30px;">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/rooms">UNION</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/rooms">Home <span
                            class="sr-only">(current)</span></a>
                    <a class="nav-link" href="#">Reservations</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/profile">Account</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/rooms">Room Manage</a>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a class="nav-link" href="#">Reservations Manage</a>
                    </sec:authorize>

                </div>
            </div>
        </div>
    </nav>
</header>
