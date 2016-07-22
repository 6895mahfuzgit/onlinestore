<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 23-Jun-16
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="<c:url value="/resources/js/controller.js" /> "></script>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">

                    <h3>Cart</h3>

                    <p>All selected item are here!</p>


                </div>


            </div>

        </section>

        <section class="container" ng-app="cartApp">
            <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
                <div>

                    <a class="btn btn-danger pull-left" ng-click="clearCart()"><span
                            class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>



                    <a href="<spring:url value="/order/${cartId}"/>" class="btn btn-success pull-right"><span
                            class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
                </div>

                <table class="table table-hover">

                    <tr>
                        <td>Product</td>
                        <td>Unit Price</td>
                        <td>Quantity</td>

                        <td>Price</td>
                        <td>Action</td>


                    </tr>
                    <tr ng-repeat="item in cart.cartItems">

                        <td>{{item.product.productName}}</td>
                        <td>{{item.product.productPrice}}</td>
                        <td>{{item.quantity}}</td>

                        <td>{{item.totalPrice}}</td>
                        <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                            <span class="glyphicon glyphicon-remove"></span>Remove</a></td>


                    </tr>
                    <tr>

                        <td></td>
                        <td></td>
                        <td>GrandTotal</td>

                        <td>{{calGrandTotal()}}</td>
                        <td></td>


                    </tr>

                </table>

                <a href="<c:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
            </div>


        </section>


        <%@include file="/WEB-INF/view/template/footer.jsp" %>
