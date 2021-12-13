<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container"> <!-- Beginning of Container -->
        <h1>${dojo.name}</h1>

        <table border="2" bordercolor="black" minwidth="300">
            <thead>
                <tr>
                    <th> First Name </th>
                    <th> Last Name </th>
                    <th> Age </th>
                </tr>
            <tbody>
                <c:forEach var="i" items="${dojo.ninjas}">
                <tr>
                    <td> <c:out value="${i.firstName }"></c:out> </td>
                    <td> <c:out value="${i.lastName }"></c:out> </td>
                    <td> <c:out value="${i.age }"></c:out> </td>
                </tr>
                </c:forEach>
            </tbody>


        </table>
    </div> <!-- End of Container -->
</body>
</html>