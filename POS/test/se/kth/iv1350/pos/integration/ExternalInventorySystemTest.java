package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * This class tests that the ExternalInventorySystem class works as intended.
 */
class ExternalInventorySystemTest {
    ExternalInventorySystem inventory;


    @BeforeEach
    void setUp() {
        inventory = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        inventory = null;
    }

    @Test
    public void testItemDoesNotExist() {
        int WrongItemIdentifier = 00000;
        boolean expected = false;
        boolean actual = inventory.checkIfItemExists(WrongItemIdentifier);
        assertEquals(expected, actual, "Did not find absence of specified item!");
    }

    @Test
    public void testItemExists() {
        int itemIdentifier = 3006;
        boolean expected = true;
        boolean actual = inventory.checkIfItemExists(itemIdentifier);
        assertEquals(expected, actual, "Did not find the specified item correctly!");
    }

    @Test
    public void testRetrievedItemNameMatches() {
        String expectedItemName = "Cinnamon bun";
        String actualItemName = inventory.retrieveItem(6880).getItemName();
        assertEquals(expectedItemName, actualItemName, "Found item name didn't match!");
    }

    @Test
    public void testRetrievedItemNameDoesNotMatch() {
        String expectedItemName = "Nothing";
        String actualItemName = inventory.retrieveItem(6880).getItemName();
        assertNotEquals(expectedItemName, actualItemName, "Found item did match, which it shouldn't!");
    }
}