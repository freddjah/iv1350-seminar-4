package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.util.Time;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fredrik on 15/05/17.
 */
public class LogHandler {
    private static final String LOG_FILE_NAME_IN_DIRECTORY = "nextgenpos-log.txt";
    private PrintWriter logFile;
    private Time time;

    public LogHandler(Time time) throws IOException {
        this.logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME_IN_DIRECTORY), true);
        this.time = time;
    }

    /**
     * Writes to log with a given exception
     * @param ex The exception that should be logged.
     */
    public void logException(Exception ex){
        StringBuilder logMessage = new StringBuilder();
        logMessage.append(time.getCurrentTime());
        logMessage.append(" - Error Has Occurred:");
        logMessage.append("\n");
        logMessage.append(ex.getMessage());
        logMessage.append("\n");
        logFile.println(logMessage);
        ex.printStackTrace(logFile);
    }
}
