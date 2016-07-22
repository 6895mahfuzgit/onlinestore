<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 25-Jun-16
  Time: 2:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill the information to create an account</p>

        </div>

        <form:form action="${pageContext.request.contextPath}/register" method="post"
                   commandName="customer"
        >
        <h3>Basic Information</h3>


        <div class="form-group">
            <label class="control-label" for="customerName">Customer Name</label>
            <form:errors path="customerName" cssStyle="color: #ff0000" />
            <form:input path="customerName" id="customerName" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="customerEmail">Eamil</label>
            <span style="color: #ff0000">${emailMsg}</span>
            <form:errors path="customerEmail" cssStyle="color: #ff0000" />
            <form:input path="customerEmail" id="customerEmail" class="form-control"/>
        </div>


        <div class="form-group">
            <label class="control-label" for="customerPhone">Phone</label>
            <form:input path="customerPhone" id="customerPhone" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="username">User Name</label>
            <span style="color: #ff0000">${usernameMsg}</span>
            <form:errors path="username" cssStyle="color: #ff0000" />
            <form:input path="username" id="username" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for=" password">Password</label>
            <form:errors path="password" cssStyle="color: #ff0000" />
            <form:input path="password" id=" password" class="form-control"/>
        </div>


        <h3>Billing Address</h3>

        <div class="form-group">
            <label class="control-label" for="streetName">Street name</label>
            <form:input path="billingAddress.streetName" id="streetName" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="apartmentNumber">Apartment number</label>
            <form:input path="billingAddress.apartmentNumber" id="apartmentNumber" class="form-control"/>
        </div>


        <div class="form-group">
            <label class="control-label" for="city">City</label>
            <form:input path="billingAddress.city" id="city" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="state">State</label>
            <form:input path="billingAddress.state" id="state" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="country">Country</label>
            <form:input path="billingAddress.country" id="country" class="form-control"/>
        </div>


        <div class="form-group">
            <label class="control-label" for="zipCode">ZipCode</label>
            <form:input path="billingAddress.zipCode" id="zipCode" class="form-control"/>
        </div>


        <h3>Shipping Address </h3>


        <div class="form-group">
            <label class="control-label" for="streetName">Street name</label>
            <form:input path="shippingAddress.streetName" id="streetName" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="apartmentNumber">Apartment number</label>
            <form:input path="shippingAddress.apartmentNumber" id="apartmentNumber" class="form-control"/>
        </div>


        <div class="form-group">
            <label class="control-label" for="city">City</label>
            <form:input path="shippingAddress.city" id="city" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="state">State</label>
            <form:input path="shippingAddress.state" id="state" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="country">Country</label>
            <form:input path="shippingAddress.country" id="country" class="form-control"/>
        </div>


        <div class="form-group">
            <label class="control-label" for="zipCode">ZipCode</label>
            <form:input path="shippingAddress.zipCode" id="zipCode" class="form-control"/>
        </div>


        <br/><br/>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>


        </form:form>


        <%@include file="/WEB-INF/view/template/footer.jsp" %>
