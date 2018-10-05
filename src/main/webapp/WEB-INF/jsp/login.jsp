<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>SDPS</title>

<link href="${css}/bootstrap.min.css" rel="stylesheet" />
<link href="${css}/form.login.css" rel="stylesheet">

<script type="text/javascript" src="${js}/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${js}/bootstrap.min.js"></script>

</head>
<body>
<%-- <div class="container">
    <div class="row justify-content-md-center">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img" src="${images}/logo.png"
                    alt="">
                
                
                <form:form name="login" lass="form-signin" method="post" action="/akademik/login">
                <input name="username" type="text" class="form-control" placeholder="Email" required autofocus />
                <input name="password" type="password" class="form-control" placeholder="Password" required />
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Login</button>
                <!-- <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    Remember me
                </label> 
                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span> -->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                </form:form>
            </div>
            <c:if test="${not empty error}"><div>${error}</div></c:if>
            <c:if test="${not empty message}"><div>${message}</div></c:if>
            <!-- <a href="#" class="text-center new-account">Create an account </a> -->
        </div>
    </div>
</div> --%>

<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img" src="${images}/logo.png" alt="SMK Averus">
                <form:form class="form-signin" method="post" action="/akademik/login">
                <input type="text" name="username" class="form-control" placeholder="Username" required autofocus>
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-info btn-block" type="submit">
                    Login</button>
                <label class="checkbox pull-left">
                </label>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>