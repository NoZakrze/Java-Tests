package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class KonTest {

    private MageController mageController;

    @Mock
    private MageRepository mockRepository = new MageRepository();



    @Test
    public void testFindExistingMage() {
        MockitoAnnotations.openMocks(this);
        mageController = new MageController(mockRepository);
        Mage mage = new Mage("Mag1", 50);
        when(mockRepository.find("Mag1")).thenReturn(Optional.of(mage));

        String result = mageController.find("Mag1");

        assertEquals(mage.toString(), result);
    }

    @Test
    public void testFindNonExistingMage() {
        MockitoAnnotations.openMocks(this);
        mageController = new MageController(mockRepository);
        when(mockRepository.find("Mag2")).thenReturn(Optional.empty());

        String result = mageController.find("Mag2");

        assertEquals("not found", result);
    }

    @Test
    public void testDeleteExistingMage()
    {
        MockitoAnnotations.openMocks(this);
        mageController = new MageController(mockRepository);
        Mage mage = new Mage("Mag3", 50);
        when(mockRepository.find("Mag3")).thenReturn(Optional.of(mage));
        String result = mageController.delete("Mag3");

        verify(mockRepository).delete("Mag3");
        assertEquals("done", result);
    }

    @Test
    public void testDeleteNonExistingMage() {
        MockitoAnnotations.openMocks(this);
        mageController = new MageController(mockRepository);
        doThrow(IllegalArgumentException.class).when(mockRepository).delete("Mag4");

        String result = mageController.delete("Mag4");

        assertEquals("not found", result);
    }

    @Test
    public void testSaveNewMage() {
        MockitoAnnotations.openMocks(this);
        mageController = new MageController(mockRepository);
        String name = "Mag5";
        int level = 20;
        when(mockRepository.find(name)).thenReturn(Optional.empty());

        String result = mageController.save(name, level);

        assertEquals("done", result);
    }



    @Test
    public void testSaveExistingMage()
    {
        Mage m1 = new Mage("Mag1",10);
        MageRepository mockRepository = Mockito.mock(MageRepository.class);
        MockitoAnnotations.openMocks(this);
        when(mockRepository.find("Mag1")).thenReturn(Optional.of(m1));
        mageController = new MageController(mockRepository);

        String result = mageController.save("Mag1", 10);

        assertEquals("bad request", result);
    }

}
