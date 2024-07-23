package systemDesign.rateLimit.exception;

public class CoolDownPeriodException extends Exception{

    public CoolDownPeriodException(String msg){
        super(msg);
    }
}
