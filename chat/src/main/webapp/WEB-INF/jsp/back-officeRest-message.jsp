<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>Message</title>
</head>
<body>
    <h1 style="text-align: center;color: blue;">Chatons.org</h1>
    <hr>

    <div class="chat" style="width: 500px;margin: 40px auto;background: #FFF;border-radius: 10px;text-align: center;">
        <h2>Message du salon: ${salon}</h2>

        ${message}
        <br>
        <a href="/tpAjax/test/back-officeRest">Retour à l'accueil du back office</a>
    </div>
</body>
</html>
