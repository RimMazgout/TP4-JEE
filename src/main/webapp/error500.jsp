<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Erreur serveur</title>
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
        .detail { background: #fdecea; color: #c0392b; padding: 10px;
                  border-radius: 5px; font-size: 12px;
                  margin-bottom: 20px; text-align: left; }
        a  { padding: 10px 20px; background: #2c3e50; color: #fff;
             border-radius: 5px; text-decoration: none; }
        a:hover { background: #1a252f; }
    </style>
</head>
<body>
<div class="box">
    <h1>⚠️</h1>
    <h2>Erreur Serveur (500)</h2>
    <p>Une erreur interne s'est produite. Veuillez réessayer.</p>
    <% if (exception != null) { %>
        <div class="detail"><%= exception.getMessage() %></div>
    <% } %>
    <a href="${pageContext.request.contextPath}/produits">
        ← Retour à l'accueil
    </a>
</div>
</body>
</html>