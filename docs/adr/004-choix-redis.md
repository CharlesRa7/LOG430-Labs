# ADR 004 – Utilisation de Redis comme Cache

## Statut
Accepté

## Contexte
Pour améliorer la performance et la scalabilité du système, une solution de mise en cache est nécessaire pour :
- Réduire la charge sur la base de données
- Réduire la latence de réponse
- Améliorer l'expérience utilisateur
- Servir des données peu volatiles de manière efficace

## Décision
J'ai choisi d'utiliser **Redis** comme système de cache distribué :

- Données stockées en mémoire
- Support de TTL (expiration par clé)
- Utilisation des structures de données Redis : chaînes, maps, listes, etc.
- Mode standalone ou clusterisé selon l’environnement
- Intégration avec Spring via `spring-data-redis`

## Justification

### 1. Technique
- Temps de réponse très rapide (stockage en RAM)
- Compatible avec les applications Spring Boot
- Permet la persistance en option
- Facile à configurer et à surveiller
- Supporte des opérations atomiques utiles (incrément, expire, etc.)

### 2. Organisationnel
- Solution mature et largement adoptée
- Documentation abondante
- Supportée par les plateformes cloud (ex : AWS ElastiCache, Azure Cache for Redis)

## Conséquences

### Avantages
- Amélioration significative des performances
- Soulage la base de données des requêtes redondantes
- Fiable et éprouvé en production

### Inconvénients
- Redis devient un point central (à surveiller)
- Gestion de l’invalidation du cache nécessaire
- Nécessite une infrastructure supplémentaire (réseau, supervision)

## Alternatives considérées

1. **Cache local en mémoire**
    - Trop limité dans un environnement distribué (pas partagé)

2. **Memcached**
    - Moins de fonctionnalités (pas de persistance, structures limitées)

## Date de la décision
16 juillet 2025
