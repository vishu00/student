<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student Records</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="/SaveServlet" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="name" pattern="[A-Za-z]{1,15}" title="Enter the Student name" required /></td></tr>

        <tr><td>FatherName:</td><td><input type="text" name="fatherName" pattern="[A-Za-z]{1,15}" title="Enter the Father name" required /></td></tr>

        <tr><td>Age:</td><td><input type="number" name="age" pattern="[0-9]+" title="please enter number only" required /></td></tr>

        <tr><td>Standard:</td><td><input type="number" name="standard" pattern="[0-9]+" title="please enter number only" required /></td></tr>

        </td></tr>

        <tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>

    </table>
</form>

<br/>


<a href="/ViewServlet">view employees</a>
</body>

