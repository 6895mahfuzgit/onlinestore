<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 22-Jun-16
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>Product Inventory</h1>

            <p class="lead">Product can be modifed,added and deletd! </p>

        </div>
        <table class="table table-striped table-hover">

            <thead>
            <tr class="big-success">
                <th><h3>Product Image</h3></th>
                <th><h3>Product name</h3></th>
                <th><h3>Catagory</h3></th>
                <th><h3>Condition</h3></th>
                <th><h3>Price</h3></th>
                <th></th>

            </tr>

            </thead>

            <c:forEach items="${products}" var="products">
                <tr>
                    <td><img src="<c:url value="/resources/images/${products.productId}.jpg"  /> " alt="IMG"
                             style="width:80%;hight:100%"/></td>
                    <td>${products.productName}</td>
                    <td>${products.productCategory}</td>
                    <td>${products.productCondition}</td>
                    <td>${products.productPrice}</td>
                    <td><a href="/product/viewProduct/${products.productId}"><span
                            class="glyphicon glyphicon-info-sign"> </span></a>
                        <a href="/admin/product/deleteProduct/${products.productId}"><span
                                class="glyphicon glyphicon-remove"> </span></a>
                        <a href="/admin/product/editProduct/${products.productId}"><span
                                class="glyphicon glyphicon-pencil"> </span></a>


                    </td>
                </tr>

            </c:forEach>

        </table>

        <a href="<c:url value="/admin/product/addProduct"/>" class="btn btn-primary">Add Product</a>
        <%@include file="/WEB-INF/view/template/footer.jsp" %>
