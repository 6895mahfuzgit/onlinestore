<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 27-Jun-16
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1> Customer</h1>

            <p class="lead">Customer Details</p>

        </div>

        <form:form commandName="order" class="form-horizaontal">


        <h3>Basic Information</h3>


        <div class="form-group">
            <label class="control-label" for="customerName">Customer Name</label>
            <form:input path="cart.customer.customerName" id="customerName" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="customerEmail">Eamil</label>
            <form:input path="cart.customer.customerEmail" id="customerEmail" class="form-control"/>
        </div>


        <div class="form-group">
            <label class="control-label" for="customerPhone">Phone</label>
            <form:input path="cart.customer.customerPhone" id="customerPhone" class="form-control"/>
        </div>


        <h3>Billing Address</h3>

        <div class="form-group">
            <label class="control-label" for="streetName">Street name</label>
            <form:input path="cart.customer.billingAddress.streetName" id="streetName" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="apartmentNumber">Apartment number</label>
            <form:input path="cart.customer.billingAddress.apartmentNumber" id="apartmentNumber" class="form-control"/>
        </div>


        <div class="form-group">
            <label class="control-label" for="city">City</label>
            <form:input path="cart.customer.billingAddress.city" id="city" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="state">State</label>
            <form:input path="cart.customer.billingAddress.state" id="state" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="country">Country</label>
            <form:input path="cart.customer.billingAddress.country" id="country" class="form-control"/>
        </div>


        <div class="form-group">
            <label class="control-label" for="zipCode">ZipCode</label>
            <form:input path="cart.customer.billingAddress.zipCode" id="zipCode" class="form-control"/>
        </div>

        <input type="hidden" name="_flowExecutionKey"/>


        <br/><br/>

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected">
        <button name="_eventId_cancel" class="btn btn-default">Cancel</button>

        </form:form>


        <%@include file="/WEB-INF/view/template/footer.jsp" %>
