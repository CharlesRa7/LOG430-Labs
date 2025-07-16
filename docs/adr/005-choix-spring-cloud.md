# ADR 005 – Utilisation de Spring Cloud Gateway comme API Gateway

## Statut
Accepté

## Contexte
Dans le cadre de la migration vers une architecture microservices, un point d’entrée unique est nécessaire pour :
- Centraliser les appels API
- Appliquer des règles transversales (authentification, logging, quotas…)
- Gérer le routage vers les services internes

## Décision
J'ai choisi d’utiliser **Spring Cloud Gateway** comme API Gateway principal de la plateforme :

- Routage basé sur URI, méthode HTTP, headers, etc.
- Filtres personnalisés pour pré/post traitement
- Intégration native avec Eureka, Spring Security et Resilience4j
- Configuration en Java ou YAML

## Justification

### 1. Technique
- Intégration fluide avec Spring Boot / Spring Cloud
- Supporte les transformations de requêtes et réponses
- Prise en charge d’OAuth2, JWT, CORS, rate limiting
- Reactive et non bloquant (WebFlux)

### 2. Organisationnel
- Évite l'introduction d’un composant externe complexe à maintenir
- Réduction de la dette technique en restant dans l’écosystème Spring
- Courbe d’apprentissage plus douce que Kong, Istio ou Traefik

## Conséquences

### Avantages
- Centralisation du trafic et des règles de sécurité
- Extensible avec des filtres personnalisés
- Facilement scalable horizontalement

### Inconvénients
- Nécessite de maîtriser WebFlux pour les filtres personnalisés
- Ajoute une couche de latence (faible, mais présente)
- Gateway unique à surveiller pour éviter les SPOF (Single Point of Failure)

## Alternatives considérées

1. **Kong**
    - Robuste mais plus lourd à configurer, dépend de plugins Lua

2. **NGINX**
    - Très performant mais configuration moins dynamique

3. **Traefik**
    - Simple mais moins intégré à Spring

4. **Istio**
    - Complet mais trop complexe pour les besoins actuels

## Date de la décision
16 juillet 2025
