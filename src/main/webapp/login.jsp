<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-box {
            background: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            width: 360px;
        }
        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 25px;
        }
        .form-group {
            margin-bottom: 18px;
        }
        .form-group label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #555;
        }
        .form-group input {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        .btn-login {
            width: 100%;
            padding: 11px;
            background: #2c3e50;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 15px;
            cursor: pointer;
        }
        .btn-login:hover { background: #1a252f; }
        .erreur {
            background: #fdecea;
            color: #c0392b;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 15px;
            text-align: center;
            font-size: 14px;
        }
        .comptes {
            margin-top: 20px;
            font-size: 12px;
            color: #888;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h2>🔐 Connexion</h2>

    <c:if test="${not empty erreurLogin}">
        <div class="erreur">${erreurLogin}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label>Login</label>
            <input type="text" name="login" 
                   placeholder="Entrez votre login" required />
        </div>
        <div class="form-group">
            <label>Mot de passe</label>
            <input type="password" name="motDePasse" 
                   placeholder="Entrez votre mot de passe" required />
        </div>
        <button type="submit" class="btn-login">Se connecter</button>
    </form>

    <div class="comptes">
        👤 admin / admin123 &nbsp;|&nbsp; 👤 user / user123
    </div>
</div>
</body>
</html>