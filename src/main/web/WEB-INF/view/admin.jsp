<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 22-Jun-16
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>Administrator Page</h1>

            <p class="lead">This is the administrator page!</p>

        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome: ${pageContext.request.userPrincipal.name} |
            <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
        </h2>

        </c:if>

        <h3><a href="<c:url value="/admin/productInventory" />"> Product Inventory</a></h3>


        <br><br>
        <h3><a href="<c:url value="/admin/productInventory" />"> Product Inventory</a></h3>
        <br><br>

        <p>Here You Can View And Modify Information!</p>


<%@include file="/WEB-INF/view/template/footer.jsp" %>