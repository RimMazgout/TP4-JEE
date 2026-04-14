<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Produits</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body { font-family: Arial, sans-serif; background: #f4f6f8; padding: 30px; }
        h1 { text-align: center; color: #2c3e50; margin-bottom: 20px; }
        h2 { color: #2c3e50; margin-bottom: 15px; }

        /* Navbar */
        .navbar {
            background: #2c3e50; color: #fff;
            padding: 12px 20px; display: flex;
            justify-content: space-between; align-items: center;
            border-radius: 8px; margin-bottom: 25px;
        }
        .navbar span { font-size: 14px; }
        .badge-role {
            background: #27ae60; padding: 3px 10px;
            border-radius: 4px; font-size: 13px;
        }
        .badge-role.user { background: #2980b9; }
        .btn-logout {
            color: #fff; background: #e74c3c;
            padding: 6px 14px; border-radius: 4px;
            text-decoration: none; font-size: 13px;
        }
        .btn-logout:hover { background: #c0392b; }

        /* Table */
        table {
            width: 100%; border-collapse: collapse; background: #fff;
            border-radius: 8px; overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,.1);
        }
        th {
            background: #2c3e50; color: #fff;
            padding: 12px 15px; text-align: left;
        }
        td { padding: 11px 15px; border-bottom: 1px solid #eee; }
        tr:last-child td { border-bottom: none; }
        tr:hover td { background: #f0f4f8; }

        /* Boutons */
        .btn {
            padding: 6px 12px; border: none; border-radius: 4px;
            cursor: pointer; font-size: 13px;
            text-decoration: none; display: inline-block;
        }
        .btn-danger  { background: #e74c3c; color: #fff; }
        .btn-warning { background: #f39c12; color: #fff; }
        .btn-success { background: #27ae60; color: #fff; }
        .btn:hover   { opacity: .85; }
        .lecture-seule { color: #aaa; font-size: 13px; font-style: italic; }

        /* Formulaires */
        .form-container {
            background: #fff; padding: 25px; border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,.1); margin-top: 25px;
        }
        .form-group { margin-bottom: 15px; }
        .form-group label {
            display: block; margin-bottom: 5px;
            font-weight: bold; color: #555;
        }
        .form-group input, .form-group textarea {
            width: 100%; padding: 9px 12px;
            border: 1px solid #ccc; border-radius: 4px; font-size: 14px;
        }
        .form-group textarea { height: 80px; resize: vertical; }

        /* Alerte rôle */
        .alert-info {
            background: #d6eaf8; color: #1a5276;
            padding: 12px 18px; border-radius: 6px;
            margin-top: 25px; font-size: 14px;
            border-left: 4px solid #2980b9;
        }
    </style>
</head>
<body>

<!-- ============================================================ -->
<!--   NAVBAR                                                     -->
<!-- ============================================================ -->
<div class="navbar">
    <span>
        👤 <strong>${utilisateurConnecte.login}</strong>
        &nbsp;|&nbsp; Rôle :
        <span class="badge-role ${role == 'USER' ? 'user' : ''}">
            ${role}
        </span>
    </span>
    <a href="${pageContext.request.contextPath}/logout" class="btn-logout">
        🚪 Déconnexion
    </a>
</div>

<h1>🛒 Gestion des Produits</h1>

<!-- ============================================================ -->
<!--   SECTION 1 : Tableau liste des produits                     -->
<!-- ============================================================ -->
<c:if test="${not empty listeProduits}">
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Prix (MAD)</th>
                <!-- Colonne Actions visible seulement pour ADMIN -->
                <c:if test="${role == 'ADMIN'}">
                    <th>Actions</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${listeProduits}">
                <tr>
                    <td>${p.idProduit}</td>
                    <td>${p.nom}</td>
                    <td>${p.description}</td>
                    <td>${p.prix} MAD</td>

                    <!-- Boutons uniquement pour ADMIN -->
                    <c:if test="${role == 'ADMIN'}">
                        <td>
                            <a href="${pageContext.request.contextPath}/editProduit?id=${p.idProduit}"
                               class="btn btn-warning">✏️ Modifier</a>
                            <a href="${pageContext.request.contextPath}/deleteProduit?id=${p.idProduit}"
                               class="btn btn-danger"
                               onclick="return confirm('Supprimer ce produit ?')">
                               🗑️ Supprimer
                            </a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty listeProduits}">
    <p style="text-align:center; color:#888; margin-top:20px;">
        Aucun produit disponible.
    </p>
</c:if>

<!-- ============================================================ -->
<!--   MESSAGE pour USER : lecture seule                          -->
<!-- ============================================================ -->
<c:if test="${role == 'USER'}">
    <div class="alert-info">
        ℹ️ Vous êtes connecté en mode <strong>lecture seule</strong>.
        Les opérations d'ajout, modification et suppression
        sont réservées aux administrateurs.
    </div>
</c:if>

<!-- ============================================================ -->
<!--   SECTION 2 : Formulaire Modifier (ADMIN seulement)          -->
<!-- ============================================================ -->
<c:if test="${not empty produit and role == 'ADMIN'}">
    <div class="form-container">
        <h2>✏️ Modifier le produit</h2>
        <form action="${pageContext.request.contextPath}/updateProduit"
              method="post">
            <input type="hidden" name="idProduit"
                   value="${produit.idProduit}" />
            <div class="form-group">
                <label>Nom</label>
                <input type="text" name="nom"
                       value="${produit.nom}" required />
            </div>
            <div class="form-group">
                <label>Description</label>
                <textarea name="description">${produit.description}</textarea>
            </div>
            <div class="form-group">
                <label>Prix (MAD)</label>
                <input type="number" step="0.01" name="prix"
                       value="${produit.prix}" required />
            </div>
            <button type="submit" class="btn btn-success">
                💾 Enregistrer
            </button>
            <a href="${pageContext.request.contextPath}/produits"
               class="btn btn-warning" style="margin-left:10px;">
               Annuler
            </a>
        </form>
    </div>
</c:if>

<!-- ============================================================ -->
<!--   SECTION 3 : Formulaire Ajouter (ADMIN seulement)           -->
<!-- ============================================================ -->
<c:if test="${empty produit and role == 'ADMIN'}">
    <div class="form-container">
        <h2>➕ Ajouter un produit</h2>
        <form action="${pageContext.request.contextPath}/addProduit"
              method="post">
            <div class="form-group">
                <label>Nom</label>
                <input type="text" name="nom"
                       placeholder="Nom du produit" required />
            </div>
            <div class="form-group">
                <label>Description</label>
                <textarea name="description"
                          placeholder="Description du produit"></textarea>
            </div>
            <div class="form-group">
                <label>Prix (MAD)</label>
                <input type="number" step="0.01" name="prix"
                       placeholder="0.00" required />
            </div>
            <button type="submit" class="btn btn-success">
                ➕ Ajouter
            </button>
        </form>
    </div>
</c:if>

</body>
</html>