<h1 align="center">Partie Frontend de l'application web Digital Banking</h1>
<br>
<hr>
Ce rapport décrit la partie frontend de l'application web Digital Banking développée en utilisant le framework Angular. L'application propose différentes fonctionnalités pour gérer les opérations bancaires en ligne, y compris la consultation des comptes, la gestion des clients et les opérations financières telles que le débit, le crédit et le transfert.
<hr>

# Interface Home

Cette section d'accueil présente un titre de bienvenue et deux boutons. Le premier bouton redirige vers la page de consultation des comptes bancaires, tandis que le deuxième bouton permet de vérifier les clients enregistrés.

<br>
<h1></h1>
<img src="caps/Home.PNG">
<br>

L'interface principale de l'application est représentée par une section avec la classe CSS "home". Elle comprend les éléments suivants :

```html
<section class="home">
  <div class="container">
    <h2 class="title">Welcome to the Digital Banking App</h2>
    <div class="cta-buttons">
      <a class="btn btn-primary animated-button" routerLink="/accounts">
        <span class="button-text">Consult Your Bank Account</span>
        <span class="button-background"></span>
      </a>
      <a class="btn btn-secondary animated-button" routerLink="/customers">
        <span class="button-text">Check Customers</span>
        <span class="button-background"></span>
      </a>
    </div>
  </div>
</section>

```
# Partie Customers

La partie "Customers" est divisée en deux sections : la consultation des clients existants et l'ajout de nouveaux clients.

## 1.1- Consultation des clients

Cette section affiche la liste des clients existants. Elle comporte un champ de recherche permettant de filtrer les clients par mot clé. Chaque client est affiché dans un tableau avec les informations telles que l'ID, le nom et l'e-mail. Deux boutons sont disponibles pour supprimer le client ou accéder à ses comptes.

<br>

<img src="caps/client.PNG">

<br>

## 1.2- Recherche des clients par mot clé

<img src="caps/clientkw.PNG" alt="le client Mohammed">

<br>

## 1.3- Supprimer le client

<img src="caps/supp.PNG">

<br>


## 1.4- Modifier le client

<img src="caps/edit.PNG">
<img src="caps/editCustomer.PNG">

<br>


## 1.5- Ajout de nouveaux clients

Cette section permet d'ajouter de nouveaux clients à l'application. Un formulaire est affiché avec les champs requis tels que le nom et l'e-mail. Des validations sont effectuées sur les champs pour s'assurer que les données saisies sont correctes. L'utilisateur peut enregistrer le nouveau client en cliquant sur le bouton "Save".


<br>

### 1.1- les requis

<img src="caps/ajoutTerms.PNG">

<br>

### 1-2- l'ajout

<img src="caps/ajout.PNG">

<br>

# Comptes bancaires et opérations

La section des comptes bancaires permet de consulter les informations d'un compte spécifique et d'effectuer des opérations financières.


<img src="caps/accId.PNG">

<br>


Cette section est divisée en deux parties :

- La première partie affiche les détails du compte bancaire spécifié, y compris l'ID du compte et le solde actuel. Elle liste également les opérations effectuées sur le compte, affichant leur ID, la date, le type et le montant.

- La deuxième partie permet à l'utilisateur d'effectuer des opérations financières sur le compte sélectionné. Il peut choisir entre les options de débit, de crédit et de transfert. Si l'option de transfert est sélectionnée, un champ supplémentaire pour spécifier le compte de destination s'affiche. L'utilisateur doit également saisir le montant et une description de l'opération. Ensuite, il peut enregistrer l'opération en cliquant sur le bouton correspondant.


<img src="caps/accHisOps.PNG">

<br>

## 1.1- DEBIT

<img src="caps/DEBIT.PNG">

<br>

## 1.2- CREDIT

<img src="caps/credit.PNG">

<br>

## 1.3- TRANSFER

<img src="caps/transfer.PNG">

<br>

### - Nouvelle Historique des operations

<img src="caps/dest.PNG">

<br>

# La base de donées

<img src="caps/db.PNG">

<br>

# Conclusion

Ce rapport a décrit la partie frontend de l'application web Digital Banking développée en utilisant le framework Angular. L'interface utilisateur permet aux utilisateurs de consulter les clients enregistrés, d'ajouter de nouveaux clients, de consulter les détails des comptes bancaires, d'afficher les opérations effectuées et d'effectuer de nouvelles opérations financières telles que le débit, le crédit et le transfert. L'application offre une expérience conviviale pour gérer les opérations bancaires en ligne de manière efficace et sécurisée.

