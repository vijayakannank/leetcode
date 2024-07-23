package executors;

import sun.util.resources.LocaleData;

import java.time.*;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledEx {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService =  Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("fixed rate"),
                computeNextDelay(0, 1,0),
                1,
                TimeUnit.MINUTES);
    }
    static long computeNextDelay(int targetHour, int targetMin, int targetSec)
    {
        LocalDateTime localNow = LocalDateTime.now(ZoneOffset.UTC);
        ZoneId currentZone = ZoneId.of("GMT");
        ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
        ZonedDateTime zonedNextTarget = zonedNow.withHour(targetHour).withMinute(targetMin).withSecond(targetSec);
        if(zonedNow.compareTo(zonedNextTarget) > 0)
            zonedNextTarget = zonedNextTarget.plusDays(1);

        Duration duration = Duration.between(zonedNow, zonedNextTarget);
        return duration.toMillis();
    }
}
