package se.kth.ict.nextgenpos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ict.nextgenpos.controller.Controller;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 15/05/17.
 */
class ItemNotFoundInCatalogExceptionTest {
    private ProductCatalog catalog;
    private Controller cont;
    @BeforeEach
    void setUp() {
        cont = new Controller();
    }

    @AfterEach
    void tearDown() {
        cont = null;
    }

    /**
     * Testing that the message is the correct one with a given input and that the correct item id is passed into exception.
     */
    @Test
    public void testItemIsNotFoundInCatalog() throws ItemNotFoundInCatalogException {
        cont.makeNewSale();
        try{
            cont.enterItem(12, 1);
        } catch(ItemNotFoundInCatalogException ex){
            assertEquals(12, ex.getItemId());
            assertEquals("Item with id 12 was not found in catalog. User must enter a VALID id OR item needs to be added to catalog.", ex.getMessage());
        }
    }

}