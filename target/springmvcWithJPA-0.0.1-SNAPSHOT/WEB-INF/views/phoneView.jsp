<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
    <title>Phone Management</title>
    <style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    #listOfEmployees tr:first-child{
        font-weight: bold;
    }
    </style>
</head>
 
<body>
     
    
     
    
 
    <h2><spring:message code="lbl.page" text="Add New Phone" /></h2>
    <br/>
    <form:form method="post" modelAttribute="phone">
        <table>
            <tr>
                <td><spring:message code="lbl.phoneId" text="phoneId" /></td>
                <td><form:input path="phoneId" /></td>
                <td><form:errors path="phoneId" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.description" text="description" /></td>
                <td><form:input path="description" /></td>
                <td><form:errors path="description" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.number" text="number" /></td>
                <td><form:input path="number" /></td>
                <td><form:errors path="number" cssClass="error" /></td>
            </tr>
            
            <tr>
                <td><spring:message code="lbl.city" text="address.city" /></td>
                <td><form:input path="address.city" /></td>
                <td><form:errors path="address.city" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.street" text="address.street" /></td>
                <td><form:input path="address.street" /></td>
                <td><form:errors path="address.street" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.state" text="address.state" /></td>
                <td><form:input path="address.state" /></td>
                <td><form:errors path="address.state" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.zip" text="address.zip" /></td>
                <td><form:input path="address.zip" /></td>
                <td><form:errors path="address.zip" cssClass="error" /></td>
            </tr>
            
            
            <tr>
                <td colspan="3"><input type="submit" name="Add" value="Add Phone"/></td>
            </tr>
        </table>
    </form:form>
    
</body>
</html>