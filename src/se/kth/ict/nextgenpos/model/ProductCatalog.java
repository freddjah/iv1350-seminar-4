package se.kth.ict.nextgenpos.model;

import java.util.Map;
import java.util.HashMap;

/**
 * This class is responsible for all access to the product database.
 */
public class ProductCatalog {
    private final static ProductCatalog CATALOG = new ProductCatalog();

    private Map<Integer, ProductSpecification> products =
            new HashMap<Integer, ProductSpecification>();

    /**
     * Fills the catalog with some dummy items.
     */
    private ProductCatalog() {
        products.put(1, new ProductSpecification(1, "low fat milk",
                "a very long description, a very long description, a very long description", 10));
        products.put(2, new ProductSpecification(2, "butter",
                "a very long description, a very long description, a very long description", 10));
        products.put(3, new ProductSpecification(3, "bread",
                "a very long description, a very long description, a very long description", 10));
    }

    /**
     * Returns the one and only instance of ProductCatalog.
     * @return Instance of <code>ProductCatalog</code>.
     */
    public static ProductCatalog getInstance(){
        return CATALOG;
    }

    /**
     * Search for an item in the product catalog.
     *
     * @param    itemId The item to look for
     * @return          The specification for the found item or null if no item was found.
     */
    public ProductSpecification findSpecification(int itemId) throws ItemNotFoundInCatalogException {
        if (products.containsKey(itemId))
            return products.get(itemId);
        throw new ItemNotFoundInCatalogException(itemId);
    }
}
