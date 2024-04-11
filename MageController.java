package org.example;

import java.util.Optional;

public class MageController {
    private MageRepository repository;

    public MageController()
    {
        repository = new MageRepository();
    }
    public MageController(MageRepository rep)
    {
        this.repository = rep;
    }

    public String find(String name) {
        Optional<Mage> foundMage = repository.find(name);
        if (foundMage.isPresent())
        {
            return foundMage.get().toString();
        }
        else
        {
            return "not found";
        }
    }

    public String delete(String name) {
        try {
            repository.delete(name);
            return "done";
        } catch (IllegalArgumentException e)
        {
            return "not found";
        }
    }

    public String save(String name, int level) {
        if (repository.find(name).isPresent())
        {
            return "bad request";
        } else
        {
            repository.save(new Mage(name, level));
           return "done";
        }

    }
}
