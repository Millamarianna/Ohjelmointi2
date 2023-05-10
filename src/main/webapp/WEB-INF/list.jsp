<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Shopping list</title>
	<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
</head>

<body>

<form method="post">
    <input name="title" type="text" required placeholder="type item here..." autofocus />
    <input type="submit" value="Add to list" />
</form>


<table>
    <thead>
        <tr><th>Product</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${ items }" var="ShoppingListItem">
        <tr><td><c:out value="${ ShoppingListItem.getTitle() }" /></td></tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
