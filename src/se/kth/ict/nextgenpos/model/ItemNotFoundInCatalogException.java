package se.kth.ict.nextgenpos.model;

/**
 * Created by fredrik on 14/05/17.
 */

/**
 * Thrown when a specified item id was not found in the product catalog.
 */
public class ItemNotFoundInCatalogException extends RuntimeException{
    private int itemId;

    /**
     * Creates a new instance of the exception with information that the item could not be found.
     * @param itemId The id of the item searched for given as <code>Int</code>.
     */
    public ItemNotFoundInCatalogException(int itemId){
        super("Item with id " + itemId + " was not found in catalog. User must enter a VALID id OR item needs to be added to catalog.");
        this.itemId = itemId;
    }

    public int getItemId(){
        return this.itemId;
    }
}
