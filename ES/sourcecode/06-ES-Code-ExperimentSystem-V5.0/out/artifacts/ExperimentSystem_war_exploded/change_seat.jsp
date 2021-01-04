<%@page import="main.Java.entity.*"%>
<%@page import="main.Java.service.*"%>
<%@page import="main.Java.daoImpl.*"%>
<%@page import="main.Java.service.*"%>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

{
"okRooms": [
<c:forEach items="${cptList}"  var="cpt" varStatus="i">
        ${cpt}
    <c:if test="${cptList.size()-1!=i.index&&cpt!=0}">
        ,
    </c:if>
</c:forEach>

]
}


