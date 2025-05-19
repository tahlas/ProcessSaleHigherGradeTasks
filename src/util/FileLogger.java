package util;

import java.awt.event.WindowStateListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileLogger implements Logger {
    private PrintWriter logStream;
    private static final FileLogger INSTANCE = new FileLogger();

    //singleton
    public static FileLogger getLogger(){
        return INSTANCE;
    }

    /**
     *Creates a new instance and also creates a new log fil. An existing log file will be overwritten.
     */
    private FileLogger (){
        try{
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException e) {
            System.out.println("CANNOT LOG");
            e.printStackTrace();
        }
    }

    /**
     *Prints the specified message to the log file.
     *
     * @param message The message that will be logged.
     */
    @Override
    public void log(String message){
        logStream.println(createDate() + " " + createTime() + ", " + message);
    }


    private String createDate(){
        LocalDate now = LocalDate.now();
        return now.toString();
    }

    private String createTime(){
        LocalTime now = LocalTime.now();
        return now.toString();
    }

    
}
