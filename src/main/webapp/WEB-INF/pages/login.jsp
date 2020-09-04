<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Login">

    <div class="row justify-content-md-center">
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                <div class="invalid-feedback">
                    Please provide a valid email.
                </div>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password">
                <div class="invalid-feedback">
                    Please provide a valid password.
                </div>
            </div>
            <div class="form-group">
                <a href="${pageContext.request.contextPath}/registration">Registration page</a>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
</tags:master>
