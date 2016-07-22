<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 22-Jun-16
  Time: 2:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 22-Jun-16
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>All Information</h1>

            <p class="lead">Check All Product Information Here! </p>

        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">

                    <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="IMG"
                         style="width:100%; height:300px "/>

                </div>
                <div class="col-md-5">
                    <h3>Product Info</h3>

                    <p><strong>Product Name</strong>:${product.productName}</p>
                    <p><strong>Descrption</strong>:${product.productDescription}</p>
                    <p><strong>Manufacture</strong>:${product.productManufacturer}</p>
                    <p><strong>Catagory</strong>:${product.productCategory}</p>
                    <p><strong>Condation</strong>:${product.productCondition}</p>
                    <p><strong>Price </strong>:${product.productPrice}USD</p>

                    <br>

                    <c:set var="role" scope="page" value="${param.role}"/>
                    <c:set var="url" scope="page" value="/product/productList"/>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value = "${url}" />" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"><span
                                class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                        <a href="<spring:url value="/customer/cart" />" class="btn btn-default"> <span
                                class="glyphicon glyphicon-hand-right"></span> View Cart</a>

                    </p>


                </div>

            </div>


        </div>


        <script src="<c:url value="/resources/js/controller.js" /> "></script>
        <%@include file="/WEB-INF/view/template/footer.jsp" %>
