package org.example;

public class Mage
{
    private String name;
    private int level;
    public Mage(String name, int level)
    {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
