package systemDesign.rateLimit;

import systemDesign.rateLimit.exception.CoolDownPeriodException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RateLimit {

    private Map<String, List<Long>> windowMap = new ConcurrentHashMap<>();
    private Map<String, Configuration> configurationMap = new HashMap<>();

    private Map<String, Long> windowStartTime = new ConcurrentHashMap<>();



    void configure(String url, Configuration configuration){
        configurationMap.put(url, configuration);
        windowMap.put(configuration.getKey(url), new ArrayList<>());
        windowStartTime.put(configuration.getKey(url), System.currentTimeMillis());

    }

    boolean isRateLimited(String url) throws RateLimitExceeded, CoolDownPeriodException{
        Configuration configuration = configurationMap.get(url);

        long currentMillis = System.currentTimeMillis();


        Long expiredMillis = System.currentTimeMillis()-configuration.getExpiredTimeInMillis();
        updateWindowStartedPeriod(configuration, url, currentMillis);
        if(isUrlInCoolDownPeriod(configuration, currentMillis, url)){
            throw new CoolDownPeriodException("User does not allowed to Hit the Api in the cooldown Period");
        }


        boolean isExceeded  =  windowMap.get(configuration.getKey(url)).stream()
                .filter(it -> it > expiredMillis)
                .count() >= configuration.getMaxAllowedHit() ;

        if(isExceeded)
            throw new RateLimitExceeded("User not allow to access this API");
        List<Long> window = windowMap.get(configuration.getKey(url));
        window.add(System.currentTimeMillis());
        windowMap.put(configuration.getKey(url),window);
        return false;
    }

    boolean isUrlInCoolDownPeriod(Configuration configuration, long currentMillis, String url){
        Long windowStarted = windowStartTime.get(configuration.getKey(url));

        return windowStarted +configuration.getExpiredTimeInMillis() <= currentMillis ||
                windowStarted +configuration.getExpiredTimeInMillis()+configuration .coolTownPeriodEndMillis() >= currentMillis;

    }

    void updateWindowStartedPeriod(Configuration configuration, String url, long currentMillis){
        long updateWindowStarted = windowStartTime.get(configuration.getKey(url))
                +configuration.getExpiredTimeInMillis()+ configuration.coolTownPeriodEndMillis();
        if(currentMillis >= updateWindowStarted)
            windowStartTime.put(configuration.getKey(url), updateWindowStarted);

    }
}
