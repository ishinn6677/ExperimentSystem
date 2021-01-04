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
<c:forEach items="${appointList}"  var="appoint" varStatus="i">
    {
    "id": ${appoint.ex_id},
    "exName":"${appoint.ex_name}",
    "teacher":"${appoint.stu_name}",
    "room": ${appoint.appoint_room},
    "year":"${appoint.week_th}",
    "term":${appoint.day_th},
    "ddl":${appoint.course_th},
    "score":${appoint.course_th}
    }
    <c:if test="${appointList.size()-1!=i.index}">
        ,
    </c:if>
</c:forEach>

]
}



