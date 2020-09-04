<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Registration">
    <div class="row justify-content-md-center">
        <div class="card">
            <form method="post" action="${pageContext.request.contextPath}/registration">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="firstName">First name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="secondName">Second name</label>
                        <input type="text" class="form-control" id="secondName" name="secondName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Phone number</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
                </div>
                <button type="submit" class="btn btn-primary">Registration</button>
            </form>
        </div>
    </div>
</tags:master>
