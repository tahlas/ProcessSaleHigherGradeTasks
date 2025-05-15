package view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ErrorMessageHandler {
    public void showErrorMessage(String message){
        String errorMsg = createDate() + " " + createTime() + ", ERROR: " + message;
        System.out.println(errorMsg);
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
