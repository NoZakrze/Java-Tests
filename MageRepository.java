package org.example;

import java.util.*;

public class MageRepository {

    private Map<String, Mage> collection;

    public MageRepository()
    {
        collection = new HashMap<String, Mage>();
    }

    public Optional<Mage> find(String name)
    {
        Mage mage = collection.get(name);
        return Optional.ofNullable(mage);
    }

    public Optional<Mage> delete(String name)
    {
        if (!collection.containsKey(name))
        {
            throw new IllegalArgumentException("Nie można usunąć nieistniejącego obiektu");
        }
        else
            return Optional.of(collection.remove(name));
    }

    public String save(Mage mage) {
        String name = mage.getName();
        if (collection.containsKey(name))
        {
            throw new IllegalArgumentException("Obiekt o podanym kluczu głównym już istnieje w repozytorium");
        }
        else
        {
            collection.put(name, mage);
            return "done";
        }

    }
}
