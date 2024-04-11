package org.example;

public class Main {
    public static void main(String[] args)
    {
        MageRepository rep = new MageRepository();
        MageController con = new MageController();

        System.out.println(con.save("mag1",15));
        System.out.println(con.find("mag1"));
        System.out.println(con.find("mag2"));
        System.out.println(con.delete("mag1"));
        System.out.println(con.delete("mag2"));

    }
}