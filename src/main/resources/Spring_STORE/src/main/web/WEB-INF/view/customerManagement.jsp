<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 27-Jun-16
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>Customer Management Page</h1>

            <p class="lead">This is the customer manager page!</p>

        </div>
        <table class="table table-inverse">

            <thead class="thead-inverse">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Enable</th>

            </tr>

            </thead>

            <c:forEach items="${customerList}" var="customerList">
                <tr>

                    <td>${customerList.customerName}</td>
                    <td>${customerList.customerEmail}</td>
                    <td>${customerList.customerPhone}</td>
                    <td>${customerList.username}</td>
                    <td>${customerList.enabled}</td>


                    <td><a href="/product/viewProduct/${products.productId}"><span
                            class="glyphicon glyphicon-info-sign"> </span></a></td>
                </tr>

            </c:forEach>

        </table>


<%@include file="/WEB-INF/view/template/footer.jsp" %>