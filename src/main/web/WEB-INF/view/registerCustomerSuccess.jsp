<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 25-Jun-16
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">


                    <h1>Customer Registered Successfully!</h1>


                </div>


            </div>

        </section>

        <section class="container">

            <p>

                <a href="<c:url value="/product/productList"/>" class="btn btn-default">Products</a>

            </p>

        </section>


        <%@include file="/WEB-INF/view/template/footer.jsp" %>
