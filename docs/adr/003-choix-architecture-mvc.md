# ADR 003 – Choix de l'Architecture MVC au lieu de l'Architecture Hexagonale

## Statut

Accepté

## Contexte

Pour la conception de l'application de gestion de magasin, je devais choisir une architecture adaptée qui :
- Permet une séparation claire des responsabilités
- Facilite la maintenance et l'évolution
- S'intègre bien avec Spring Boot

## Décision

J'ai choisi d'utiliser l'architecture MVC (Modèle-Vue-Contrôleur) en couches plutôt que l'architecture hexagonale :

- **Couche Présentation** : Contrôleurs Spring MVC
- **Couche Service** : Logique métier
- **Couche Modèle** : Entités JPA et DTOs
- **Couche Repository** : Accès aux données

## Justification

1. **Technique** :
    - Intégration naturelle avec Spring Boot et ses composants
    - Structure claire et bien comprise
    - Simplicité de mise en œuvre
    - Facilite les tests unitaires par couche

2. **Organisationnel** :
    - Architecture standard largement documentée
    - Courbe d'apprentissage plus douce que l'hexagonale

## Conséquences

### Avantages
- Structure projet claire et intuitive
- Séparation des responsabilités efficace
- Développement et maintenance simplifiés
- Bonne intégration avec Spring Boot

### Inconvénients
- Couplage plus fort entre les couches
- Moins flexible pour changer d'infrastructure
- Dépendance directe avec les frameworks

## Alternatives considérées

1. **Architecture Hexagonale**
    - Plus flexible mais plus complexe
    - Meilleure isolation du domaine
    - Nécessite plus de code boilerplate

## Date de la décision

27 mai 2025