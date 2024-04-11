package org.example;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepTest {

    private MageRepository mageRepository = new MageRepository();



    @Test
    public void testFindExistingMage()
    {
        Mage mage = new Mage("Mag1", 50);
        mageRepository.save(mage);

        Optional<Mage> foundMage = mageRepository.find("Mag1");

        assertEquals(mage, foundMage.get());
    }

    @Test
    public void testFindNonExistingMage() {
        Optional<Mage> foundMage = mageRepository.find("Mag2");

        assertEquals(Optional.empty(), foundMage);
    }

    @Test
    public void testDeleteExistingMage() {
        Mage mage = new Mage("Mag3", 50);
        mageRepository.save(mage);

        mageRepository.delete("Mag3");

        assertEquals(Optional.empty(), mageRepository.find("Mag3"));
    }

    @Test
    public void testDeleteNonExistingMage() {
        assertThrows(IllegalArgumentException.class, () -> mageRepository.delete("nieMag"));
    }

    @Test
    public void testSaveNewMage() {
        Mage mage = new Mage("Mag4", 50);
        mageRepository.save(mage);

        Optional<Mage> savedMage = mageRepository.find("Mag4");

        assertEquals(mage, savedMage.get());
    }

    @Test
    public void testSaveExistingMage() {
        Mage mage = new Mage("Mag5", 50);
        mageRepository.save(mage);

        assertThrows(IllegalArgumentException.class, () -> mageRepository.save(new Mage("Mag5", 100)));
    }
}
