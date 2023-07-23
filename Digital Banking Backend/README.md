<h1 align="center">Partie Backend de l'application web Digital Banking</h1>
<br>
<hr>

Ce rapport présente la partie backend d'une application web de gestion des comptes bancaires appelée "Digital Banking". L'application est développée en utilisant le framework Spring Boot, qui offre une structure robuste et facilite le développement d'applications Java.

L'objectif principal de l'application est de permettre la gestion des comptes bancaires pour les clients. Chaque compte bancaire appartient à un client et peut subir plusieurs opérations de type "Débit" ou "Crédit". Il existe deux types de comptes : les comptes courants et les comptes épargne.

<hr>

## Architecture Backend
La partie backend de l'application Digital Banking suit une architecture en couches, ce qui permet une séparation claire des responsabilités et facilite la maintenance et l'évolutivité de l'application. Les principales couches de l'application backend sont les suivantes :

1. Couche DAO : Cette couche gère l'accès aux données et comprend les interfaces JPA Repository basées sur Spring Data. Ces interfaces fournissent les opérations de base pour interagir avec les entités persistantes.

2. Entités JPA : Les entités JPA représentent les objets métier de l'application et sont mappées aux tables de la base de données. Les entités de l'application Digital Banking sont les suivantes :
   - Customer : Représente un client de la banque.
   - BankAccount : Classe abstraite représentant un compte bancaire. Les sous-classes de BankAccount sont CurrentAccount et SavingAccount.
   - CurrentAccount : Représente un compte courant avec une autorisation de découvert.
   - SavingAccount : Représente un compte épargne avec un taux d'intérêt.
   - AccountOperation : Représente une opération effectuée sur un compte bancaire.

3. Couche service : Cette couche contient la logique métier de l'application et offre des services pour effectuer des opérations sur les comptes bancaires. Elle utilise les interfaces DAO pour accéder aux données et les mappers pour convertir les entités en DTO (Data Transfer Object) et vice versa.

4. DTOs : Les DTOs sont des objets utilisés pour transférer des données entre les différentes couches de l'application. Ils permettent de définir les informations à envoyer ou à recevoir lors des appels API.

5. RestController : Les RestControllers sont des composants qui exposent les services de l'application via des API REST. Ils reçoivent les requêtes HTTP, appellent les services appropriés et renvoient les réponses aux clients.

6. Exceptions métier : Ces exceptions sont utilisées pour gérer les erreurs spécifiques à l'application. Dans l'application Digital Banking, nous avons les exceptions suivantes :
   - CustomerNotFoundException : Lancée lorsque le client n'est pas trouvé.
   - BankAccountNotFoundException : Lancée lorsque le compte bancaire n'est pas trouvé.
   - BalanceNotSufficientException : Lancée lorsque le solde du compte n'est pas suffisant pour effectuer une opération.

7. Sécurité JWT avec Spring Security : L'application utilise Spring Security avec l'authentification basée sur JWT (JSON Web Token). Deux utilisateurs sont configurés en mémoire (user et admin) avec des mots de passe encodés de type BCrypt. Les utilisateurs authentifiés reçoivent un token JWT qui doit être inclus dans les en-têtes des requêtes pour accéder aux API sécurisées. Le serveur vérifie la validité du token avant de permettre l'accès aux ressources protégées.


<br>
<hr>
<h2><center>Ce fichier contient les trois parties du backend</center></h2>
<h4><center>( 1. Creation du projet )  <br>
( 2. Couche service, DTOs et RestController ) <br>
( 3. Sécurité "JWT" )</center></h4>
<hr>
<br>
<br>
<h3><center>Partie 1 : Creation du projet</center></h3>
<br>
<h4>- Use Case Diagram</h4>
<img src="captures/UseCase.PNG" alt="">
<br>
<br>    
<h4>- Le Test</h4>
<img src="captures/DB1.PNG" alt="">
<img src="captures/DB2.PNG" alt="">
<br>
<br>

# - les entités et les interfaces JPA

## Détails techniques
Voici quelques détails techniques importants concernant l'implémentation de l'application Digital Banking :

### @Entity JPA Entities
Les entités JPA de l'application sont annotées avec `@Entity` pour les identifier comme entités persistantes. La classe abstraite `BankAccount` utilise l'annotation `@Inheritance(strategy = InheritanceType.JOINED)` pour spécifier une stratégie d'héritage de type "JOINED". Cela signifie que les sous-classes `CurrentAccount` et `SavingAccount` auront leurs propres tables distinctes, mais seront liées à la table de la classe `BankAccount` par une clé étrangère.

### @Repository
Les interfaces DAO de l'application utilisent l'annotation `@Repository` pour indiquer à Spring qu'il s'agit de composants de persistance qui gèrent l'accès aux données. Ces interfaces étendent les interfaces JPA Repository de Spring Data, telles que `JpaRepository` ou `CrudRepository`, et fournissent des méthodes pour effectuer des opérations de base sur les entités.

<img src="captures/packages.PNG" alt="">
<br>
<br>
<br>
<hr>
<br>
<h3><center>Partie 2 : Couche service, DTOs et RestController</center></h3>
<br>
<br>

# - Les couches (dtos, mappers, services, web)

### @Service
Les classes de service de l'application utilisent l'annotation `@Service` pour indiquer qu'elles contiennent la logique métier de l'application. Ces classes utilisent les interfaces DAO pour accéder aux données et effectuer des opérations sur les entités. Elles peuvent également utiliser des mappers pour convertir les entités en DTOs et vice versa.

### @RestController
Les RestControllers de l'application utilisent l'annotation `@RestController` pour indiquer qu'ils sont des composants qui exposent les services de l'application via des API REST. Les méthodes de ces classes sont annotées avec des annotations telles que `@GetMapping`, `@PostMapping`, `@PutMapping`, etc., pour spécifier les points de terminaison des API et les opérations HTTP correspondantes.

### @ExceptionHandler
Les RestControllers utilisent également l'annotation `@ExceptionHandler` pour gérer les exceptions spécifiques à l'application. Ces méthodes sont annotées avec des types d'exception spécifiques, tels que `@ExceptionHandler(CustomerNotFoundException.class)`, et renvoient les réponses d'erreur appropriées aux clients.

<img src="captures/ClassInter.PNG" alt="">
<br>
<br>
<h4>- BankAccountService.java</h4>
<img src="captures/BankAccountService.PNG" alt="">
<br>
<br>
<h4>- CustomerRestController.java</h4>
<img src="captures/CustomerRestController.PNG" alt="">
<br>
<br>
<h4>- Le Test de la couche web (Customer) :</h4>
<img src="captures/WebTest.PNG" alt="">
<br>
<br>
<h4>- Liste des clients</h4>
<img src="captures/CustomerGet.PNG" alt="">
<br>
<br>
<h4>- Creer un client</h4>
<img src="captures/PostCustomer.PNG" alt="">
<br>
<br>
<h4>- Modifier un client</h4>
<img src="captures/UpdateCustomer.PNG" alt="">
<br>
<br>
<h4>- Supprimer un client</h4>
<img src="captures/DeleteCustomer.PNG" alt="">
<br>
<br>
<h4>- BankAccountRestAPI.java</h4>
<img src="captures/BankAccountAPI_Class.PNG" alt="">
<br>
<br>
<h4>- Le Test de la couche web (BankAccount) :</h4>
<img src="captures/BankAccountAPI.PNG" alt="">
<br>
<br>
<h4>- Afficher les clients</h4>
<img src="captures/GetAccounts.PNG" alt="">
<br>
<br>
<h4>- Afficher les operations pour chaque compte</h4>
<img src="captures/GetOperations.PNG" alt="">
<br>
<br>
<h4>- Afficher les operations pour chaque compte avec la pagination</h4>
<img src="captures/GetAccounts&Pagination.PNG" alt="">

<hr>
<br>
<h3><center>Partie 3 : Sécurité "JWT" <br>
(Configuration et Test)</center></h3>
<br>
<br>

<img src="captures/SecurityPackage.PNG">
<br>
<br>

## 1- La configuration
### Configuration de la sécurité :

<h4>
Dans cette partie on configure un système d'authentification en mémoire avec deux utilisateurs (un utilisateur normal et un administrateur) ayant des mots de passe encodés en BCrypt.</h4>

<img src="captures/SecurityConfig1.PNG">
<br>
<br>
<h4>Ce code configure la sécurité d'une application Spring avec une gestion de sessions sans état, la désactivation de la protection CSRF, la configuration CORS par défaut, l'autorisation de l'URL "/auth/login/**" pour tous, et l'authentification via JWT en utilisant les beans JwtEncoder et JwtDecoder. Il crée également un gestionnaire d'authentification personnalisé avec l'objet DaoAuthenticationProvider et un gestionnaire d'authentification global avec le ProviderManager.</h4>
<img src="captures/SecurityConfig2.PNG">
<br>
<br>
<h4>Ce code configure la source de configuration CORS pour permettre les requêtes cross-origin (CORS) depuis n'importe quelle origine, avec toutes les en-têtes et méthodes autorisées. Il expose également l'en-tête "x-auth-token" dans la réponse.</h4>
<img src="captures/SecurityConfig3.PNG">
<br>
<br>


### Genérer le Token

<br>
<h4>Pour génrer le token on fait :</h4>
<img src="captures/LoginMethod.PNG">
<br>
<br>

## 2- Le Test

<br>
<h4> -Tester la methode Login pour avoir le token en tant qu'ADMIN :</h4>
<img src="captures/RESTLogin.PNG">
<br>
<br>
<h4> -Voir les details du profil :</h4>
<img src="captures/LoginDetails.PNG">
<br>
<br>
<h4> -Tester la methode GET pour voir le comptes bancaires</h4>
<img src="captures/RESTGETAccount.PNG">


## Conclusion
L'architecture backend de l'application Digital Banking repose sur Spring Boot et suit une approche en couches pour une meilleure séparation des responsabilités. Les couches DAO, service et RestController travaillent ensemble pour permettre la gestion des comptes bancaires et la manipulation des données. Les entités JPA représentent les objets métier et sont mappées aux tables de la base de données. Les DTOs sont utilisés pour transférer les données entre les différentes couches de l'application.

L'utilisation de Spring Boot facilite le développement, la configuration et la gestion de l'application. De plus, l'utilisation des annotations telles que `@Entity`, `@Repository`, `@Service` et `@RestController` permet de définir clairement le rôle des différents composants de l'application.

De plus, la sécurité de l'application est assurée grâce à l'utilisation de JSON Web Tokens (JWT). Les tokens JWT sont utilisés pour l'authentification et l'autorisation des utilisateurs, permettant ainsi de sécuriser les ressources sensibles de l'application. Le code inclut la configuration d'un filtre de sécurité qui utilise un encodeur et un décodeur JWT pour gérer les tokens. L'authentification est également prise en charge en utilisant l'interface UserDetailsService pour récupérer les informations d'utilisateur à partir de la couche DAO. Grâce à cette approche de sécurité, l'application garantit l'accès sécurisé aux données bancaires des utilisateurs. En somme, l'architecture backend du projet Digital Banking allie à la fois la flexibilité, la sécurité et la modularité pour offrir une expérience bancaire fluide et sécurisée aux utilisateurs.

En utilisant cette architecture, il est possible d'étendre l'application Digital Banking avec de nouvelles fonctionnalités et de maintenir un code clair et modulaire.
