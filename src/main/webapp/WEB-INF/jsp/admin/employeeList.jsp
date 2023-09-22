<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <sec:authentication property="principal" var="curUser" scope="request" />
    <h1>Hello : ${curUser.username}</h1>
    <h1>${curUser.authorities}</h1>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <th>Edit</th>
                    </sec:authorize>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employeeList}" var="e">
                    <tr>
                        <td><a href="/index?employeeId=${e.employeeId}">${e.employeeId}</a></td>
                        <td>${e.name}</td>
                        <td>${e.gender}</td>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <td><a href="/editEmployee.htm?employeeId=${e.employeeId}">Edit</a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="card">
            <div class="container">
                ${user}
            </div>
        </div>
        <br/><br/>
        <a href="/addEmployee.htm">Add user</a>
        <br/>
        <a href="/logout">Logout</a>
    </body>
</html>