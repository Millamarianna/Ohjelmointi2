<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Until Day -countdown</title>
	<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
</head>

<body>

    <form action="/daysUntil" method="post">
        <fieldset>
            <legend>Count days between today and any other date:</legend>
            <label>Year:  <input type="number" name="year" max="9999" required></label>
            <label>Month: <input type="number" name="month" min="1" max="12" required></label>
            <label>Day:   <input type="number" name="day" min="1" max="31" required></label>
            <input type="submit" value="Submit">
        </fieldset>
    </form>
    <p><h3>Days until ${ inputDate }: ${ untilDate }</h3></p>
</body>
</html>
	

</body>
</html>