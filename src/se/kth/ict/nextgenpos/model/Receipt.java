package se.kth.ict.nextgenpos.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Holds all information needed by the receipt.
 */
public class Receipt {
    private int payedAmount;
    private int totalCost;
    private List<SalesLineItem> receiptLines = new ArrayList<SalesLineItem>();

    /**
     * Creates a new receipt and saves all information it needs.
     *
     * @param sale      The <code>Sale</code> for wich the receipt shall be created.
     */
    Receipt(Sale sale) {
        totalCost = sale.getCost();
        payedAmount = sale.getPayedAmount();
        createReceiptLines(sale);
    }

    private void createReceiptLines(Sale sale) {
        sale.resetLineItemIterator();
        while (sale.hasMoreLineItems()) {
            receiptLines.add(sale.nextLineItem());
        }
    }

    /**
     * Returns the amount of change the customer should have.
     *
     * @return The amount of change the customer should have.
     */
    public int getChange() {
        return payedAmount - totalCost;
    }

    /**
     * Returns a well-formatted string with all receipt information.
     *
     * @return A well-formatted string with all receipt information.
     */
    public String toString() {
        String string = "RECEIPT: \n";
        string += "Total Cost: " + totalCost + "\n";
        string += "Paid: " + payedAmount + "\n";
        string += "Change: " + getChange() + "\n";
        return string; //Sould return the string created above.
    }

}
