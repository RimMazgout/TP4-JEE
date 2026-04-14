<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accès refusé</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8;
               display: flex; justify-content: center;
               align-items: center; height: 100vh; }
        .box { background: #fff; padding: 40px; border-radius: 10px;
               box-shadow: 0 4px 15px rgba(0,0,0,0.1);
               text-align: center; width: 400px; }
        h1 { color: #e74c3c; font-size: 60px; margin-bottom: 10px; }
        h2 { color: #2c3e50; margin-bottom: 15px; }
        p  { color: #777; margin-bottom: 25px; }
        a  { padding: 10px 20px; background: #2c3e50; color: #fff;
             border-radius: 5px; text-decoration: none; }
        a:hover { background: #1a252f; }
    </style>
</head>
<body>
<div class="box">
    <h1>🚫</h1>
    <h2>Accès Refusé (403)</h2>
    <p>Vous n'avez pas les droits nécessaires pour accéder à cette page.<br>
       Cette action est réservée aux administrateurs.</p>
    <a href="${pageContext.request.contextPath}/produits">
        ← Retour à l'accueil
    </a>
</div>
</body>
</html>