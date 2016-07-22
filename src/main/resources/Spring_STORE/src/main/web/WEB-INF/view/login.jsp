<%--
  Created by IntelliJ IDEA.
  User: MahfuzCSE'11
  Date: 23-Jun-16
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/view/template/header.jsp" %>
<div class="container">


    <form class="form-signin" action="<c:url value="/j_spring_security_check" />" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>

        <c:if test="${not empty error}">
            <div class="error" style="color: #ff0000;"><h4>${error}</h4></div>
        </c:if>

        <c:if test="${not empty msg}">
            <div class="msg" style="color: #269abc;"><h4>${msg}</h4></div>
        </c:if>

        <label for="username" class="sr-only">User name</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="User Name" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>

        <input type="submit" value="Submit" class="btn btn-lg btn-primary btn-block">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>


    <!-- /container -->


    <%@include file="/WEB-INF/view/template/footer.jsp" %>

