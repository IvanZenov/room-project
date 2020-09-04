<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Add new room">
    <div class="row justify-content-md-center">
        <div class="card" style="border: 1px;">

            <form method="post" action="${pageContext.request.contextPath}/admin/rooms/addNewRoom">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="city">City</label>
                        <input type="text" class="form-control" name="city" id="city" required>
                        <div class="invalid-feedback">
                            Please provide a valid city.
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="street">Street</label>
                        <input type="text" class="form-control" name="street" id="street" required>
                        <div class="invalid-feedback">
                            Please provide a valid street.
                        </div>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="streetNumber">Street Number</label>
                        <input type="text" class="form-control" name="streetNumber" id="streetNumber">
                    </div>
                </div>

                <div class="mb-3">
                    <label for="description">Textarea</label>
                    <textarea class="form-control" name="description" id="description"
                              placeholder="Description"></textarea>
                </div>
                <div class="mb-3">
                    <label for="name">Name</label>
                    <input class="form-control" name="name" id="name" placeholder="Name" required/>
                    <div class="invalid-feedback">
                        Please provide a valid name.
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="places">Places</label>
                        <input type="number" class="form-control" name="places" id="places" required>
                        <div class="invalid-feedback">
                            Please provide a valid places.
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="pricePerNight">Price (per night)</label>
                        <input type="number" step="0.01" class="form-control" name="pricePerNight" id="pricePerNight"
                               required>
                        <div class="invalid-feedback">
                            Please provide a valid price.
                        </div>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="imageUrl">Image</label>
                        <input type="text" class="form-control" name="imageUrl" id="imageUrl">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Add new room</button>
            </form>

        </div>
    </div>
</tags:master>
