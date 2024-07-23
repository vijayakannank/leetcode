package systemDesign.rateLimit;

public class RateLimitExceeded extends Exception{

    RateLimitExceeded(String msg){
        super(msg);
    }
}
