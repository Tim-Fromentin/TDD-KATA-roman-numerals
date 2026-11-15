# Chiffres romains en TDD

Kata de conversion de nombres en chiffres romains, réalisé en **Test-Driven Development** (TDD), en Java avec JUnit et AssertJ.

Comme pour tout kata, l'objectif n'est pas seulement le résultat mais la **démarche** : partir de cas très simples, laisser les tests imposer la généralisation, puis laisser les refactos faire émerger la bonne solution.

## Les règles

| Symbole | I | V | X | L | C | D | M |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Valeur | 1 | 5 | 10 | 50 | 100 | 500 | 1000 |

- Les symboles s'**additionnent**, du plus grand au plus petit : `VI` = 6, `XXII` = 22.
- Un symbole n'est jamais répété plus de 3 fois. On utilise alors une **notation soustractive** : `IV` (4), `IX` (9), `XL` (40), `XC` (90), `CD` (400), `CM` (900).
- Seuls les nombres de **1 à 3999** sont acceptés. Tout autre nombre lève une `IllegalArgumentException` avec un message qui indique la valeur reçue.

Exemples : `1994` → `MCMXCIV`, `2026` → `MMXXVI`, `3999` → `MMMCMXCIX`.

## La démarche TDD

Chaque étape suit le cycle rouge → vert → refacto, avec **un commit par étape** :

1. 🔴 **Rouge** : un test pour un comportement qui n'existe pas encore.
2. 🟢 **Vert** : le minimum de code pour le faire passer.
3. 🔵 **Refacto** : améliorer le code sans changer son comportement, tests toujours au vert.

Le chemin suivi :

1. **1, 2, 3** : répéter des `I`.
2. **5 à 8** : un `V`, puis des `I` pour le reste.
3. **10, 20, 30** : des `X` répétés avec une boucle.
4. **4 et 9** : d'abord des cas spéciaux, puis traités comme des « symboles » à part entière (`IV` vaut 4, `IX` vaut 9), placés au bon endroit dans l'ordre.
5. **Refacto clé** : tous les blocs avaient la même forme (« tant qu'il reste au moins *valeur*, ajouter *symbole* et soustraire *valeur* »). Ils ont été remplacés par une **liste ordonnée de paires (valeur, symbole)**, sous forme de `record`, parcourue par une seule boucle.
6. **Les autres symboles** (L, XL, C, XC, D, CD, M, CM) : à partir de là, chaque nouveau symbole ne demande plus qu'un test et une ligne dans la liste.
7. **Grands nombres** (1994, 2026, 3999) : ils passent directement, ce qui confirme que la solution est bien généralisée.
8. **Validation** : refus des nombres hors de la plage, avec des constantes nommées et une méthode de validation dédiée.

L'historique Git permet de suivre chaque étape :

```bash
git log --oneline --reverse
```

## Stack

- Java (version définie dans le `pom.xml`)
- Maven (via le wrapper inclus)
- JUnit Jupiter pour les tests
- AssertJ pour les assertions (`assertThat`, `assertThatThrownBy`)

## Lancer les tests

Sous Linux / macOS :

```bash
./mvnw test
```

Sous Windows :

```bash
mvnw.cmd test
```

## Ce que ce kata m'a appris

- **L'erreur de décalage d'un** (*off-by-one*) : bien vérifier les bornes d'une boucle ou d'une condition (`<` ou `<=`) en déroulant les valeurs à la main.
- **La boucle infinie** : dans un `while`, le corps doit toujours finir par rendre la condition fausse.
- **L'ordre compte** : en traitant les symboles du plus grand au plus petit, comme pour rendre la monnaie, les cas soustractifs deviennent des symboles comme les autres.
- **Remplacer du code répété par des données** : quand plusieurs blocs ont exactement la même forme, une liste et une boucle suffisent.
- **Un vrai refacto ne casse aucun test** : si un test passe au rouge pendant un refacto, c'est que le comportement a changé.
- **Tester les valeurs limites** (1, 3999, 0, 4000) : ce sont elles qui révèlent les erreurs de bornes.
- **Vérifier les valeurs attendues avec une source extérieure** : une faute recopiée à la fois dans le test et dans le code passe inaperçue.

## Pistes d'amélioration

- Utiliser des tests paramétrés (`@ParameterizedTest` avec `@CsvSource`) pour regrouper les nombreux cas.
- Implémenter la conversion inverse (chiffres romains → nombre), en TDD également.