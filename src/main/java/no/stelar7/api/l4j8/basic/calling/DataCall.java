package no.stelar7.api.l4j8.basic.calling;


import no.stelar7.api.l4j8.basic.APICredentials;
import no.stelar7.api.l4j8.basic.cache.CacheProvider;
import no.stelar7.api.l4j8.basic.constants.api.*;
import no.stelar7.api.l4j8.basic.ratelimiting.RateLimiter;

import javax.annotation.Nullable;
import java.util.*;

public final class DataCall
{
    
    private static final Map<Enum, Map<Enum, RateLimiter>>           limiter  = new HashMap<>();
    private static final Map<Enum, Map<Enum, Map<Integer, Integer>>> callData = new HashMap<>();
    
    private static APICredentials creds;
    private static CacheProvider cache          = CacheProvider.EmptyProvider.INSTANCE;
    private static LogLevel      logLevel       = LogLevel.NONE;
    private static int           callStackSkip  = 5;
    private static int           callStackLimit = 5;
    
    private final Map<String, String> urlParams  = new TreeMap<>();
    private final Map<String, String> urlData    = new TreeMap<>();
    private final Map<String, String> urlHeaders = new TreeMap<>();
    
    private Enum        platform;
    private URLEndpoint endpoint;
    private static String urlProxy = Constants.REQUEST_URL;
    
    
    public static Map<Enum, Map<Enum, RateLimiter>> getLimiter()
    {
        return limiter;
    }
    
    public static Map<Enum, Map<Enum, Map<Integer, Integer>>> getCallData()
    {
        return callData;
        
    }
    
    public Map<String, String> getUrlParams()
    {
        return urlParams;
    }
    
    public Map<String, String> getUrlData()
    {
        return urlData;
    }
    
    public Map<String, String> getUrlHeaders()
    {
        return urlHeaders;
    }
    
    public Enum getPlatform()
    {
        return platform;
    }
    
    public URLEndpoint getEndpoint()
    {
        return endpoint;
    }
    
    public void setPlatform(Enum platform)
    {
        this.platform = platform;
    }
    
    public void setEndpoint(URLEndpoint endpoint)
    {
        this.endpoint = endpoint;
    }
    
    public static void setLogLevel(LogLevel level)
    {
        DataCall.logLevel = level;
    }
    
    public static LogLevel getLogLevel()
    {
        return DataCall.logLevel;
    }
    
    public static DataCallBuilder builder()
    {
        return new DataCallBuilder();
    }
    
    public static APICredentials getCredentials()
    {
        return DataCall.creds;
    }
    
    public static CacheProvider getCacheProvider()
    {
        return cache;
    }
    
    /**
     * Takes in a proxy for the api.
     * The URL should contain the parts:
     * {platform}
     * {game}
     * {service}
     * {version}
     * {resource}
     * <p>
     * The default is https://{platform}.api.riotgames.com/{game}/{service}/{version}/{resource}
     *
     * @param proxy the url
     */
    public static void setProxy(@Nullable String proxy)
    {
        urlProxy = proxy == null ? Constants.REQUEST_URL : proxy;
    }
    
    public static void setCacheProvider(@Nullable CacheProvider provider)
    {
        cache = provider == null ? CacheProvider.EmptyProvider.INSTANCE : provider;
    }
    
    public static void setCredentials(final APICredentials creds)
    {
        DataCall.creds = creds;
    }
    
    public String getProxy()
    {
        return urlProxy;
    }
    
    
    public static int getCallStackSkip()
    {
        return callStackSkip;
    }
    
    public static void setCallStackSkip(int callStackSkip)
    {
        DataCall.callStackSkip = callStackSkip;
    }
    
    public static int getCallStackLimit()
    {
        return callStackLimit;
    }
    
    public static void setCallStackLimit(int callStackLimit)
    {
        DataCall.callStackLimit = callStackLimit;
    }
}
