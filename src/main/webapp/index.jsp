<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>

<%!
    private String getFormattedDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать, JSP!</title>
</head>
<body>
<h1>Добро пожаловать!</h1>
<i>Сегодня <%= getFormattedDate() %>
</i>
<br>
<i><%= request.getRemoteHost() %>
</i>
<% System.out.println(request.getSession()); %>
<br>
<i><%= 3 + 3 %>
</i>
<%@include file="subPage.jsp" %>

<jsp:useBean id="mybean" class="by.itacademy.jd2.servlet.User"/>
<jsp:setProperty name="mybean" property="userName" value="Sergey"/>

<jsp:getProperty name="mybean" property="userName"/>

<%--<jsp:forward page="subPage.jsp"/>--%>
</body>
</html>