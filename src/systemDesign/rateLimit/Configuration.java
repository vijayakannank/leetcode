package systemDesign.rateLimit;

import java.util.concurrent.TimeUnit;

public abstract class Configuration {

    private int count;

    private int duration;

    private TimeUnit unit;

    private int coolDownPeriod;


    Configuration(int count,  int duration, TimeUnit unit, int coolDownPeriod){
        this.count = count;
        this.duration = duration;
        this.unit = unit;
        this.coolDownPeriod = coolDownPeriod;
    }

    abstract String getKey(String url);

    public int getMaxAllowedHit() {
        return count;
    }

    public Long getExpiredTimeInMillis() {
        return converTimeUnitsIntoMillis(duration, unit);
    }

   public long coolTownPeriodEndMillis(){
        return converTimeUnitsIntoMillis(coolDownPeriod, unit);

   }

    private long converTimeUnitsIntoMillis(int duration, TimeUnit unit){
        long millis = 0l;
        switch (unit) {
            case MINUTES:
                millis = TimeUnit.MINUTES.toMillis(duration);
                break;
            case SECONDS:
                millis = TimeUnit.SECONDS.toMillis(duration);
                break;
            case HOURS:
                millis  = TimeUnit.HOURS.toMillis(duration);
                break;
            default:
                millis = duration* 1000L;
        }
        return millis;
    }

}
