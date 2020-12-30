<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/22
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@page import="main.Java.entity.*"%>
<%@page import="main.Java.service.*"%>
<%@page import="main.Java.daoImpl.*"%>
<%@page import="main.Java.service.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    {
    "name": "${user.name}",
    "birthday": "${user.birthday}",
    "sex": "${user.sex}",
    "address": "${user.address}"
    }

