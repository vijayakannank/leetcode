package systemDesign.rateLimit;

import java.util.concurrent.TimeUnit;

public class UserIdUrlConfiguration extends Configuration{


    private String userId;
    private int count;

    private int duration;

    private TimeUnit unit;


    UserIdUrlConfiguration(String userId, int count,  int duration, TimeUnit unit, int coolDownPeriod){
        super(count, duration, unit, coolDownPeriod);
        this.count = count;
        this.duration = duration;
        this.unit = unit;
        this.userId = userId;
    }


    @Override
    String getKey(String url) {

        return this.userId+"-"+url;
    }
}
