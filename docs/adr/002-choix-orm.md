# ADR 001 – Choix de JPA / Hibernate comme solution ORM

## Statut

Accepté

## Contexte

Pour aider l'intégration de la base de données avec les entités de l'application, ainsi que gérer la persistance des données de manière efficace et cohérente. L'utilisation d'un **ORM (Object-Relational Mapping)** permet de mapper les objets Java aux tables d'une base de données relationnelle, et de simplifier considérablement les opérations CRUD (Create, Read, Update, Delete).

La solution doit être bien intégrée à Spring Boot et facile à utiliser.

## Décision

J'ai décidé d’utiliser **JPA (Java Persistence API)** avec **Hibernate** comme implémentation ORM.

## Justification

- **Intégration native avec Spring Boot** : Spring Data JPA est officiellement supporté et se configure automatiquement.
- **Productivité** : permet d’écrire moins de code grâce aux interfaces `JpaRepository` et aux requêtes dérivées des noms de méthodes.
- **Fonctionnalités avancées** : gestion du cache, transactions, lazy loading, pagination, etc.
- **Évolution du modèle** : le mapping objet-relation facilite les modifications du modèle de données.

## Conséquences

- Nécessite une compréhension correcte de l’ORM pour éviter les pièges liés aux performances.
- Nécessite une configuration et une validation rigoureuses du modèle d'entités.

## Alternatives
1. **MyBatis**
2. **jOOQ**
3. **JDBC Template**
4. **JDBI**

## Date de la décision

25 mai 2025
