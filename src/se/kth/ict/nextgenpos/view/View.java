package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.ItemNotFoundInCatalogException;
import se.kth.ict.nextgenpos.model.ProductSpecification;
import se.kth.ict.nextgenpos.model.SaleObserver;
import se.kth.ict.nextgenpos.util.Time;

import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * A placeholder for the view.
 */
public class View {
    private Controller cont;
    private ErrorMessageHandler errMsgHandler;
    private LogHandler logHandler;
    private Time time = new Time();

    /**
     * Creates a new <code>view</code>.
     * @param cont           The controller of the application.
     */
    public View(Controller cont) {
        try {
            this.cont = cont;
            this.errMsgHandler = new ErrorMessageHandler();
            this.logHandler = new LogHandler(time);
        } catch(IOException ex){
            errMsgHandler.displayErrorMessage("File for logging was not found.", time);
        }
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() {
        cont.makeNewSale();
        cont.addSaleObserver(new SaleList());
        enterItem(1);
        enterItem(2);
        enterItem(3);
        enterItem(10);
        System.out.println(cont.makePayment(100).toString());
    }

    private void enterItem(int itemId) {
        try {
            int quantity = 1;
            System.out.println("");
            System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
            System.out.println("");
        } catch (ItemNotFoundInCatalogException ex){
            handleException("Item with id " + ex.getItemId() + " was not found in catalog. Please make sure that you've entered the correct id.", ex);
        } catch (InvalidParameterException ex){
            handleException(ex.getMessage(), ex);
        }
    }

    private void handleException(String messageForUserInterface, Exception ex){
        errMsgHandler.displayErrorMessage(messageForUserInterface, time);
        logHandler.logException(ex);
    }

}
