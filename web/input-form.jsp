<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input form</title>
</head>
<body>
    <h1>Form</h1>

    <form name="loginForm" method="post" action="/producer/producer-servlet">
        Number: <input type="number" name="inputNumber"/> <br/>
        Text:
        <select id="texts" name="inputText">
            <option value="text_0">Text_0</option>
            <option value="text_1">Text_1</option>
            <option value="text_2">Text_2</option>
            <option value="text_3">Text_3</option>
            <option value="text_4">Text_4</option>
            <option value="text_5">Text_5</option>
            <option value="text_6">Text_6</option>
            <option value="text_7">Text_7</option>
            <option value="text_8">Text_8</option>
            <option value="text_9">Text_9</option>
        </select>
        Date: <input type="date" name="inputDate">
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
