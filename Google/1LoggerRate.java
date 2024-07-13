package Google;

import java.util.HashMap;
import java.util.Map;

public class LoggerRate {
    class Logger {

    public Logger() {
        
    }
    Map<String, Integer> log= new HashMap<>();
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(log.get(message)== null){
            log.put(message, timestamp);
            return true;
        } else {
            int preTime = log.get(message);
        if(preTime <= timestamp - 10){
            log.put(message, timestamp);
            return true;
        }
        }
        return false;
    }   
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
}
