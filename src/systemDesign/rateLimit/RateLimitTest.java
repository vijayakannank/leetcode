package systemDesign.rateLimit;

import systemDesign.rateLimit.exception.CoolDownPeriodException;

import java.util.concurrent.TimeUnit;

public class RateLimitTest {

    public static void main(String[] args) throws RateLimitExceeded, InterruptedException, CoolDownPeriodException {
        Configuration configuration = new BasicConfiguration(
                3, 1, TimeUnit.SECONDS, 1);

        RateLimit rateLimit  = new RateLimit();
        rateLimit.configure("abc", configuration);
        try {
            rateLimit.isRateLimited("abc");
            rateLimit.isRateLimited("abc");
            rateLimit.isRateLimited("abc");
            rateLimit.isRateLimited("abc");

        }  catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        // wait for cooldown period
        try {
            Thread.sleep(1000);
            rateLimit.isRateLimited("abc");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Thread.sleep(1000);
        rateLimit.isRateLimited("abc");

    }
}
