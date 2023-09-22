<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head></head>
    <body>
        <h2>Training - Edit User</h2>
        <form:form name="form1" id="form1" method="POST" modelAttribute="employeeObject">
            <table border="1">
                <tr>
                    <td>Employee Id</td>
                    <td><form:input type="text" path="employeeId" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><form:input type="text" path="name"/></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <form:select path="gender">
                            <form:option value="M" label="M"/>
                            <form:option value="F" label="F"/>
                        </form:select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="submit" value="Submit"/>
        </form:form>
        <br/><br/>
        <input type="button" value=" << Back" onclick="history.back();"/>
    </body>
</html>