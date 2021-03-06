package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.model.SaleObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fredrik on 15/05/17.
 */

/**
 * Implements SaleObserver to get functionality needed to observe for an example products added to sale.
 */
public class SaleList implements SaleObserver {
    private List<String> productList;

    public SaleList(){
        productList = new ArrayList<>();
    }

    /**
     * Adds an item to internal productList.
     * @param item The product specification of an item that should be added to the list.
     */
    @Override
    public void addProduct(String item) {
        productList.add(item);
        printProductList();
    }

    /**
     * Prints the products in <code>productList</code>.
     */
    private void printProductList(){
        int numberInList = 1;

        System.out.println("-------------------------- LIST OF PRODUCTS ADDED TO SALE -------------------------");
        for (String product : productList) {
            System.out.println(
                    ":::: SALE ITEM #" + numberInList++ + " ::::\n" +
                    product
            );
        }
        System.out.println("------------------------------------------------------------------------------------\n");
    }
}
