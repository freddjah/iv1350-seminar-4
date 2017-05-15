package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.util.Time;

/**
 * Created by fredrik on 15/05/17.
 */
public class ErrorMessageHandler {
    void displayErrorMessage(String msg, Time time){
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append(time.getCurrentTime());
        errorMessage.append(" - Error Has Occurred: ");
        errorMessage.append("\"");
        errorMessage.append(msg);
        errorMessage.append("\"\n");
        System.out.println(errorMessage);
    }
}
