<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>Acceso a usuario</h1>
<c:if test="${param.error != null}">
    <span style="color: red">¡Error de credenciales!</span>
</c:if>
<form name='f' action="j_spring_security_check" method='POST'>
    <table>
        <tr>
            <td>Usuario:</td>
            <td><input type='text' name='user' value=''></td>
        </tr>
        <tr>
            <td>Contraseña:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td>Recordar:</td>
            <td><input type='checkbox' name='_spring_security_remember_me' checked='checked' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Acceder"/></td>
        </tr>
    </table>
</form>
</body>
</html>
