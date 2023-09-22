<html>
    <head>
        <title>Login page</title>
    </head>
    <body>

        <form name="loginForm" id="loginForm" action="/login.htm" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            Username : <input type="text" name="username" id="username"/></br>
            Password : <input type="password" name="password" id="password"></br></br>
            <input type="submit" name="submit" id="submit" value="Login"/>
        </form>
    </body>
</html>

