<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>Menú</h1>
<sec:authorize access="!isAuthenticated()">
    Por favor, inicia sesión.
</sec:authorize>
<sec:authorize access="isRememberMe()">
    Se ha iniciado sesión como:
    <sec:authentication property="principal" var="principal"/>
    <c:set var="username" value="${principal.username}"></c:set>
    <c:out value="${username}"></c:out>
    <a href="<c:url value='/logout'></c:url>">cerrar sesión</a>
    <a href="<c:url value='/usuario'></c:url>">agregar usuario</a>
</sec:authorize>
<sec:authorize access="isFullyAuthenticated()">
    Se ha iniciado sesión como:
    <sec:authentication property="principal" var="principal"/>
    <c:set var="username" value="${principal}"></c:set>
    <c:out value="${username}"></c:out>
    <a href="<c:url value='/logout'></c:url>">cerrar sesión</a>
    <a href="<c:url value='/usuario'></c:url>">agregar usuario</a>
</sec:authorize>

