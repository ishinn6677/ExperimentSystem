<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/20
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@page import="main.Java.entity.*"%>
<%@page import="main.Java.service.*"%>
<%@page import="main.Java.daoImpl.*"%>
<%@page import="main.Java.service.*"%>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

{"code": 0
,"msg": ""
,"count": ${count}
,"data": [
<c:forEach items="${selectexList}"  var="selectex" varStatus="i">
    {
    "id": ${selectex.stu_id},
    "studentName":"${selectex.stu_name}",
    "score":${selectex.grade}
    }
    <c:if test="${selectexList.size()-1!=i.index}">
        ,
    </c:if>
</c:forEach>

]
}



