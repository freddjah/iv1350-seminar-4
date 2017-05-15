package se.kth.ict.nextgenpos.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a single sale to one customer. This is also the Composite in the SaleComponent -> Sale -> SalesLineItem tree structure.
 */
public class Sale implements SaleComponent{
    private List<SalesLineItem> lineItems;
    private int payedAmount;
    private int iterator;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * Instantiates a new <code>Sale</code>.
     */
    public Sale() {
        lineItems = new ArrayList<SalesLineItem>();
    }

    /**
     * Adds new items to the current <code>Sale</code>.
     *
     * @param spec            The specification of the items that is added.
     * @param quantity        The number of items.
     */

    public void addItem(ProductSpecification spec, int quantity) {
        SalesLineItem lineItem = new SalesLineItem(spec, quantity);
        lineItems.add(lineItem);
        notifyObservers(spec);
    }

    /**
     * Returns the total cost of all products registered so far.
     * Calculates cost of the sale by iterating the "leaf objects" in <code>lineItems</code> in the current composite
     * <code>Sale</code> instance.
     *
     * @return Cost as <code>Int</code>.
     */
    public int getCost(){
        int cost = 0;
        for (SaleComponent component : lineItems){
            cost = cost + component.getCost();
        }
        return cost;
    }

    /**
     * Calculates change and returns all information needed for the receipt.
     *
     * @return All information needed for the receipt.
     */
    public Receipt createReceipt(int payedAmount) {
        this.payedAmount = payedAmount;
        return new Receipt(this);
    }

    void resetLineItemIterator() {
        iterator = 0;
    }

    SalesLineItem nextLineItem() {
        return lineItems.get(iterator++);
    }

    boolean hasMoreLineItems() {
        return iterator < lineItems.size();
    }

    int getPayedAmount() {
        return payedAmount;
    }

    /**
     * Adds an observer of the products that is being sold.
     * @param obs Observer of type <code>SaleObserver</code>.
     */
    public void addObserver(SaleObserver obs){
        this.saleObservers.add(obs);
    }

    /**
     * Notifies the observers about the product that is currently being added to sale.
     * @param spec The <code>ProductSpecification</code> of the product that is being added.
     */
    private void notifyObservers(ProductSpecification spec){
        for (SaleObserver obs : this.saleObservers)
            obs.addProduct(spec);
    }



}
