# AssetHandler

## Introduction

Ce projet utilise le concept de polymorphisme pour gérer différentes classes d'entrées d'actifs (AssetEntry) de manière propre et modulaire. Chaque type d'actif (comme Event, Project, Participation, etc.) a un gestionnaire spécifique qui sait comment traiter ce type particulier d'actif et produire un objet JSON en conséquence.

## Comment ça marche ?

### Structure

1. **Interface `AssetHandler`** : Déclare une méthode `handleAsset` qui est implémentée par chaque gestionnaire spécifique à un type d'actif.
2. **Classe `AssetHandlerFactory`** : Fournit un moyen centralisé de récupérer le gestionnaire approprié pour chaque type d'actif.
3. **Classes de gestionnaires spécifiques** : Chaque type d'actif a une classe qui implémente l'interface `AssetHandler` et définit la logique de traitement pour ce type.

### Interface `AssetHandler`

```java
public interface AssetHandler {
    void handleAsset(JSONObject jsonResponse, AssetEntry assetEntry, String locale, ThemeDisplay themeDisplay, String publikUserId, ConfigAffichage configAffichage, int descriptionMaxLength);
}
```

### Exemple de gestionnaire spécifique

```java
public class EventHandler implements AssetHandler {
    @Override
    public void handleAsset(JSONObject jsonResponse, AssetEntry assetEntry, String locale, ThemeDisplay themeDisplay, String publikUserId, ConfigAffichage configAffichage, int descriptionMaxLength) {
        Event event = EventLocalServiceUtil.getEvent(assetEntry.getClassPK());
        JSONObject jsonEvent = JSONSearchHelper.createEventSearchJson(event, getImageURL(event.getImageId()), locale, themeDisplay, publikUserId, configAffichage, descriptionMaxLength);
        jsonEvent = JSONSearchHelper.createAssetEntrySearchJson(jsonEvent, assetEntry);
        jsonResponse.put(jsonEvent);
    }
}
```

### Classe `AssetHandlerFactory`

```java
public class AssetHandlerFactory {
    private static final Map<String, AssetHandler> handlers = new HashMap<>();

    static {
        handlers.put(Event.class.getName(), new EventHandler());
        handlers.put(Project.class.getName(), new ProjectHandler());
        // Ajouter d'autres gestionnaires ici...
    }

    public static AssetHandler getHandler(String className) {
        return handlers.get(className);
    }
}
```

### Utilisation des gestionnaires

```java
// Dans votre méthode principale :
AssetHandler handler = AssetHandlerFactory.getHandler(assetClassName);
if (handler != null) {
    handler.handleAsset(jsonResponse, assetEntry, locale, themeDisplay, publikUserId, configAffichage, descriptionMaxLength);
} else {
    // Gérer le cas où aucun gestionnaire n'est trouvé, si nécessaire
}
```

## Comment ajouter une nouvelle classe d'actifs ?

Pour ajouter une nouvelle classe d'actifs, suivez les étapes suivantes :

1. **Créer un nouveau gestionnaire** : Implémentez l'interface `AssetHandler` pour votre nouvelle classe d'actifs.

```java
public class NewAssetHandler implements AssetHandler {
    @Override
    public void handleAsset(JSONObject jsonResponse, AssetEntry assetEntry, String locale, ThemeDisplay themeDisplay, String publikUserId, ConfigAffichage configAffichage, int descriptionMaxLength) {
        // Logique de traitement pour le nouvel actif
        NewAsset newAsset = NewAssetLocalServiceUtil.getNewAsset(assetEntry.getClassPK());
        JSONObject jsonNewAsset = JSONSearchHelper.createNewAssetSearchJson(newAsset, getImageURL(newAsset.getImageId()), locale, themeDisplay, configAffichage);
        jsonNewAsset = JSONSearchHelper.createAssetEntrySearchJson(jsonNewAsset, assetEntry);
        jsonResponse.put(jsonNewAsset);
    }
}
```

2. **Enregistrer le nouveau gestionnaire dans `AssetHandlerFactory`** :

```java
public class AssetHandlerFactory {
    private static final Map<String, AssetHandler> handlers = new HashMap<>();

    static {
        handlers.put(Event.class.getName(), new EventHandler());
        handlers.put(Project.class.getName(), new ProjectHandler());
        handlers.put(NewAsset.class.getName(), new NewAssetHandler()); // Ajouter ici
        // Ajouter d'autres gestionnaires ici...
    }

    public static AssetHandler getHandler(String className) {
        return handlers.get(className);
    }
}
```

3. **Utilisation** : Le reste du code reste inchangé. Le gestionnaire approprié sera automatiquement utilisé lorsque la nouvelle classe d'actifs est rencontrée.

## Conclusion

Ce modèle basé sur le polymorphisme permet d'ajouter et de maintenir facilement de nouveaux types d'actifs sans modifier le flux principal de l'application. Chaque gestionnaire est responsable de la logique spécifique à un type d'actif, ce qui rend le code plus modulaire et plus facile à comprendre et à étendre.