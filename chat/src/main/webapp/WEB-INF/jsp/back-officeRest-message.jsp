<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>Message</title>
</head>
<body>
    <h1>Chatons.org</h1>
    <hr>
    <h2>Message du salon: ${salon}</h2>

    ${message}
    <br>
    <a href="/tpAjax/test/back-officeRest">Retour à l'accueil du back office</a>
</body>
</html>
