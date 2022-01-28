<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            jQuery(".confirm").on("click", function () {
                return confirm("Va a elimininar un registro. ¿Continuar?");
            });
        });
    </script>
    <title>Admin</title>
</head>
<body>
<c:import url="/WEB-INF/views/menu.jsp"></c:import>
<h1>usuario.jsp</h1>
<form:form action="${pageContext.request.contextPath}/usuario/save" method="post" modelAttribute="usuario">
    <table>
        <tr>
            <td>Nombre</td>
            <td><form:input path="usuario" type="text"/></td>
        </tr>
        <tr>
            <td>Contraseña</td>
            <td><form:input path="clave" type="password"/></td>
        </tr>
        <tr>
            <td>Permisos</td>
            <td><form:input path="permiso" type="text"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Guardar cambios"></td>
        </tr>
    </table>
</form:form>
<br/>
<c:out value="${resultado}"></c:out>
<br/>
<br/>
<c:forEach items="${usuarios}" var="usuario">
    <c:out value="${usuario}"></c:out>
    <br />
</c:forEach>
</body>
</html>
