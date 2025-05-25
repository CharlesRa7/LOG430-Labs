# ADR-001: Choix de PostgreSQL comme Base de Données

## Statut
Acceptée

## Contexte
Le système de caisse nécessite une base de données relationnelle pour:
- Stocker les données des transactions
- Gérer les produits et l'inventaire
- Maintenir les informations utilisateurs
- Supporter les futures évolutions (multi-magasins)

## Décision
J'ai choisi PostgreSQL comme système de gestion de base de données avec:
- Version: PostgreSQL 16+
- Configuration:
    - Port: 5432
    - Authentification: utilisateur/mot de passe
    - Variables d'environnement pour la configuration

## Justification
1. **Techniquement**:
    - Support complet des transactions ACID
    - Excellente intégration avec Spring Data JPA
    - Performances élevées pour les opérations CRUD

2. **Stratégiquement**:
    - Open source et gratuit
    - Large communauté active
    - Documentation extensive
    - Compatible avec les tests (H2 en développement)

## Conséquences
- Nécessite une installation locale pour le développement
- Configuration initiale requise (`.env`, `application.properties`)
- Coût de maintenance opérationnelle

## Alternatives
- **MySQL/MariaDB**
- **Oracle Database**
- **Microsoft SQL Server**

## Date de la décision

25 mai 2025