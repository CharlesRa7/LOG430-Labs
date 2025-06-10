# LOG430-Lab3

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

5. Après le build et l'exécution, l'application est accessible sur localhost:{port} et le Swagger UI est accessible à la route `/swagger-ui/index.html`
6. Pour l'authentification, utiliser les identifiants suivants :
   - **Username**: sigle du cours en minuscules
   - **Password**: sigle du cours en minuscules