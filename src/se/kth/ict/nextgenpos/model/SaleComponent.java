package se.kth.ict.nextgenpos.model;

/**
 * Created by fredrik on 15/05/17.
 */

/**
 * Used for implementing the Composition Pattern, where every SaleComponent has a cost, whether it is Sale or SalesLineItem.
 */
public interface SaleComponent {
    /**
     * Returns the cost of the component.
     * @return Cost as <code>Int</code>.
     */
    int getCost();
}
