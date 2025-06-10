# LOG430-Lab1

## Instructions d'exécution

**Cloner le projet**

1. Se rendre dans le dossier où on désire cloner le projet
2. Exécuter la commande suivante :
    ```
    git clone https://github.com/CharlesRa7/LOG430-Labs.git
    ```

**Build et Exécution**

1. Après avoir cloner le projet, se rendre à la racine du projet avec la commande suivante :
    ```
    cd LOG430-Labs
    ```
2. Exécuter la commande suivante pour télécharger les dépendances :
    ```
    ./mvnw clean install
    ```
   
3. S'assurer que le serveur PostgreSQL est en cours d'exécution
   - Pour voir si le serveur est en cours d'exécution, exécuter la commande suivante :
      ```
      sudo systemctl status postgresql
      ```
   - Si le serveur n'est pas en cours d'exécution, exécuter la commande suivante :
       ```
       sudo systemctl start postgresql
       ```
     
4. Exécuter la commande suivante à la racine du projet (on peut spécifier le port pour tester la concurrence) :
    ```
    ./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8080"
    ```

5. Après le build et l'exécution, l'application est accessible sur localhost:{port} et le UI est accessible à la route `/products`

## 1. Introduction et Objectifs

### 1.1 Aperçu des Exigences

L'application cible est un système de caisse conçu 
pour répondre aux besoins d'un petit commerce de proximité.
L'architecture est pensée pour permettre des évolutions 
futures, notamment l'extension vers une gestion multi-magasins 
et le développement d'une plateforme de commerce électronique distribuée.

### Exigences Fonctionnelles

1. Gestion des Ventes
   - Enregistrer des transactions de vente
   - Calculer automatiquement les taxes
   - Gérer plusieurs modes de paiement (espèces, carte)
   - Émettre des reçus

2. Gestion des Produits
   - Ajouter/modifier/supprimer des produits
   - Gérer les catégories de produits
   - Suivre l'inventaire en temps réel

3. Gestion des Utilisateurs
   - Authentification des utilisateurs
   - Gestion des rôles (caissier, gérant, client)

### 1.2 Objectifs de Qualité

1. Performance
   - Temps de réponse < 1 seconde pour les opérations courantes
   - Optimisation des requêtes base de données

2. Utilisabilité
   - Interface intuitive pour formation rapide
   - Messages d'erreur clairs

3. Maintenabilité
   - Architecture modulaire pour évolutions futures
   - Documentation technique complète

### 1.3 Parties Prenantes

| Rôle                      | Nom                | Attentes                        |
|---------------------------|--------------------|---------------------------------|
| Développeur et Architecte | Charles Racette | Qualité du code, maintenabilité |

---

## 2. Contraintes d'Architecture

Voici la liste des contraintes d'architecture :
- **architecture à deux niveaux** : le client communique directement avec le serveur.
- **persistance des données** : utilisation d'une couche de persistance abstraite pour interagir avec la base de données.

---

## 3. Portée et Contexte du Système

### 3.1 Contexte Métier
- **Caissiers** : Utilisent le système pour enregistrer les ventes et gérer les transactions
- **Clients** : Achètent des produits et reçoivent des reçus

### 3.2 Contexte Technique

#### Interfaces Système
- **Interface Web** : Application web Spring Boot avec Thymeleaf pour le rendu des pages
- **Base de données** : PostgreSQL en production, H2 en test
- **Navigation** : Communication via requêtes HTTP et rendu de pages HTML
- 
#### Protocoles et Communications
- **HTTP/HTTPS** : Communication client-serveur
- **JDBC** : Communication avec la base de données
- **TCP/IP** : Protocol réseau pour les communications

#### Infrastructure Technique
- **Backend** : Java 21 + Spring Boot
- **ORM** : Hibernate/JPA
- **Frontend** : Thymeleaf + HTML/CSS/JavaScript

#### Format des Données
- Format SQL pour la persistance

---

## 4. Stratégie de la Solution

### Framweworks et Librairies

- **Spring Boot** : pour la création rapide d'applications Java
- **Spring Data JPA / Hibernate** : pour la gestion de la persistance
- **Thymeleaf** : pour le rendu des pages web intégrées à Spring
- **JUnit** : pour les tests unitaires

### Outils

- **Maven** : pour la gestion des dépendances et la construction du projet
- **H2** : pour les tests en mémoire
- **PostgreSQL** : pour la base de données relationnelle
- **Git** : pour le contrôle de version

### Patrons de Conception

- **MVC (Modèle-Vue-Contrôleur)** : pour séparer la logique métier de la présentation
- **Client-Serveur** : pour la communication entre le frontend et le backend
- **Two-Tier** : pour la séparation des préoccupations entre le client et le serveur
- **Mapper** : pour la conversion entre entités et DTO
- **Repository Pattern** : pour l'accès aux données
- **Service Layer** : pour encapsuler la logique métier
- **DTO (Data Transfer Object)** : pour le transfert de données entre les couches
- **DAO (Data Access Object)** : pour l'accès aux données

### Langages
- **Java 21** : pour le développement backend
- **HTML/CSS/JavaScript** : pour le développement frontend
- **SQL** : pour les requêtes de base de données
- **JSON** : pour les échanges de données entre le client et le serveur
- **PlantUML** : pour la modélisation des diagrammes

---

## 5. Vue des Blocs de Construction

### 5.1 Vue Globale du Système

Le système suit une architecture à deux niveaux (two-tier):

![](/docs/uml/class-diagrams/class-diagram.svg)

---

## 6. Vue d'Exécution

- Comment le système se comporte pendant l'exécution.

![](/docs/uml/sequence-diagrams/add-product.svg)
![](/docs/uml/sequence-diagrams/delete-product.svg)
![](/docs/uml/sequence-diagrams/search-products.svg)
![](/docs/uml/sequence-diagrams/view-product.svg)

---

## 7. Vue de Déploiement

![](/docs/uml/deployment-diagrams/deployment-diagram.svg)

---

## 8. Concepts Transversaux

- Description des aspects système :
   - Sécurité
   - Gestion des erreurs
   - Journalisation et surveillance
   - Mise en cache
   - Configuration

---

## 9. Décisions Architecturales

[Liste des ADR](docs/adr/)

---

## 10. Scénarios de Qualité

Description de la façon dont l'architecture répond aux objectifs de qualité.

| Attribut de Qualité | Scénario              | Réponse/Stratégie                                                           |
|---------------------|-----------------------|-----------------------------------------------------------------------------|
| Performance         | Rapidité des requêtes | Utilisation des indexes dans la base de données                             |
| Évolutivité         | Évolution du schéma   | Utilisation d'une base de données Postgres compatible avec des outils d'ORM |

---

## 11. Risques et Dette Technique

### Risques

1. **Base de données**
   - Goulot d'étranglement possible sous forte charge
   - Risque de verrouillage avec transactions longues
   - Perte de données en cas de crash

2. **Architecture Two-Tier**
   - Limitations de scalabilité horizontale
   - Couplage fort client-serveur
   - Points uniques de défaillance

### Dette Technique
1. **Code**
   - Tests automatisés incomplets
   - Validation des entrées à renforcer


---

## 12. Glossaire

| Terme | Définition |
|-------|------------|
| API | Interface de Programmation d'Application |
| ACID | Atomicité, Cohérence, Isolation et Durabilité (propriétés des transactions) |
| CRUD | Create, Read, Update, Delete (opérations basiques de persistance) |
| DAO | Data Access Object (patron de conception pour l'accès aux données) |
| DTO | Data Transfer Object (objet de transfert de données entre couches) |
| H2 | Base de données relationnelle en mémoire utilisée pour les tests |
| HTTP/HTTPS | HyperText Transfer Protocol (Secure) - protocole de communication web |
| JDBC | Java Database Connectivity (API pour connexion aux bases de données) |
| JPA | Java Persistence API (spécification Java pour la persistance) |
| MVC | Modèle-Vue-Contrôleur (patron architectural) |
| ORM | Object-Relational Mapping (mapping objet-relationnel) |
| TCP/IP | Transmission Control Protocol/Internet Protocol |
| Two-Tier | Architecture à deux niveaux (client-serveur) |

---

## 13. Annexe
