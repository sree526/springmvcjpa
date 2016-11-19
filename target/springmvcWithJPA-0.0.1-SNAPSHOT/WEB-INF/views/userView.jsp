	<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
    <title>User Management</title>
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
     <script type="text/javascript">
 fields = 1;
 function addInput() {
      document.getElementById('text').innerHTML += "<input type='number' name ='phones["+ fields++ +"].number'/><br />";
 }
 </script>
    <%!

		public void test(){
		System.out.println("test suc");
	}
    %>   
    <h2><spring:message code="lbl.page.list" text="lbl.page.list" /></h2>
    <br/>
     
    
 
    <h2><spring:message code="lbl.page" text="Add New User" /></h2>
    <br/>
    <form:form method="post" modelAttribute="user">
        <table>
            <tr>
                <td><spring:message code="lbl.userId" text="userId" /></td>
                <td><form:input path="userId" /></td>
                <td><form:errors path="userId" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.firstname" text="firstname" /></td>
                <td><form:input path="firstname" /></td>
                <td><form:errors path="firstname" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.lastname" text="lastname" /></td>
                <td><form:input path="lastname" /></td>
                <td><form:errors path="lastname" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.title" text="title" /></td>
                <td><form:input path="title" /></td>
                <td><form:errors path="title" cssClass="error" /></td>
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
                <td><spring:message code="lbl.state" text="state" /></td>
                <td><form:input path="address.state" /></td>
                <td><form:errors path="address.state" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.zip" text="zip" /></td>
                <td><form:input path="address.zip" /></td>
                <td><form:errors path="address.zip" cssClass="error" /></td>
            </tr>
            <tr>
            
                <td><spring:message code="lbl.number" text="number" /></td>
                <td>
                <div id="text">
                <form:input path="phones[0].number" />
                <form:errors path="phones[0].number" cssClass="error" />                          
   				 <input type="button" value="add Phone" onclick="addInput()"/>
   				 </div></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Add Employee"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>