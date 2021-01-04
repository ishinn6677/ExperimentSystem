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
    "appointmentId": ${appoint.id},
    "experimentId":"${appoint.ex_id}",
    "experimentName":"${appoint.ex_name}",
    "room": ${appoint.appoint_room},
    "week":"${appoint.week_th}",
    "weekDay":${appoint.day_th},
    "dayOrder":${appoint.course_th}
    }
    <c:if test="${appointList.size()-1!=i.index}">
        ,
    </c:if>
</c:forEach>

]
}



