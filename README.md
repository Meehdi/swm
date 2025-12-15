Système d'auto-diagnostic pour cabine médicale hospitalière.

## Description

Analyse l'index de santé d'un patient et redirige vers les unités médicales appropriées :
- Multiple de 3 → Cardiologie
- Multiple de 5 → Traumatologie
- Multiple de 3 et 5 → Les deux unités

## Technologies

- Java 25
- Gradle
- JUnit 5
- Mockito
- AssertJ
- Approche DDD

## Choix de conception

### Validation de l'index de santé

Les valeurs ≤ 0 sont considérées comme invalides et lèvent une `InvalidHealthIndexException`.

**Justification** : Les spécifications ne mentionnent pas explicitement ces cas limites. En situation réelle, cette décision serait validée avec le Product Owner pour clarifier :
- La valeur 0 représente-t-elle "aucune lecture" (invalide) ou un cas légitime ?
- Les valeurs négatives peuvent-elles exister dans le système du capteur ?

### Architecture

Rich Domain Model (DDD) :
- `HealthIndex` : Value Object contenant la logique métier
- `Pathology` : Enum avec mapping vers les unités médicales
- `DiagnosisFormatter` : Service pour le formatage de sortie

Pas de service de diagnostic dédié : la logique est portée par les objets du domaine eux-mêmes.

## Utilisation
```bash
./gradlew test
```

## Exemples
```
Index 33 → Cardiologie
Index 55 → Traumatologie
Index 15 → Cardiologie, Traumatologie
```
