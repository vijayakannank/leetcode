package systemDesign.rateLimit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasicConfiguration extends Configuration{




    BasicConfiguration(int count,  int duration, TimeUnit unit, int coolDownPeriod){
        super(count, duration, unit,coolDownPeriod );

    }

    @Override
    public String getKey(String url) {
        // user/1/vidoes
        return url;
    }
}
