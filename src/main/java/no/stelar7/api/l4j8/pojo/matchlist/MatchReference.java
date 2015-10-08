package no.stelar7.api.l4j8.pojo.matchlist;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.stelar7.api.l4j8.basic.APIObject;
import no.stelar7.api.l4j8.basic.Platform;
import no.stelar7.api.l4j8.basic.Server;
import no.stelar7.api.l4j8.basic.constants.Lane;
import no.stelar7.api.l4j8.basic.constants.RankedQueue;
import no.stelar7.api.l4j8.basic.constants.Role;
import no.stelar7.api.l4j8.basic.constants.Season;

public class MatchReference implements APIObject
{
    private Long   champion;
    private String lane;
    private Long   matchId;
    private String platformId;
    private String queue;
    private String region;
    private String role;
    private String season;
    private Long   timestamp;

    /**
     * Champion ID associated with game.
     * 
     * @return Long
     */
    public Long getChampion()
    {
        return this.champion;
    }

    /**
     * Lane associated with game
     * 
     * @return String
     */
    public String getLane()
    {
        return this.lane;
    }

    /**
     * the lane represented as a Lane
     * 
     * @return Lane
     */
    public Lane getLaneAsLane()
    {
        return Lane.getFromCode(this.lane);
    }

    /**
     * Match ID.
     * 
     * @return Long
     */
    public Long getMatchId()
    {
        return this.matchId;
    }

    /**
     * Platform ID.
     * 
     * @return String
     */
    public String getPlatformId()
    {
        return this.platformId;
    }

    /**
     * the platformId represented as a Platform
     * 
     * @return Platform
     */
    public Platform getPlatform()
    {
        return Platform.getFromCode(this.platformId);
    }

    /**
     * Queue.
     * 
     * @return String
     */
    public String getQueue()
    {
        return this.queue;
    }

    /**
     * the queue represented as a RankedQueue
     * 
     * @return RankedQueue
     */
    public RankedQueue getQueueAsRankedQueue()
    {
        return RankedQueue.getFromCode(this.queue);
    }

    /**
     * Region
     * 
     * @return String
     */
    public String getRegion()
    {
        return this.region;
    }

    /**
     * the region represented as a Server
     * 
     * @return Server
     */
    public Server getFromCode()
    {
        return Server.getFromCode(this.region);
    }

    /**
     * Role
     * 
     * @return String
     */
    public String getRole()
    {
        return this.role;
    }

    /**
     * the role represented as a Role
     * 
     * @return Role
     */
    public Role getRoleAsRole()
    {
        return Role.getFromCode(this.role);
    }

    /**
     * Season
     * 
     * @return String
     */
    public String getSeason()
    {
        return this.season;
    }

    /**
     * the season represented as a Season
     * 
     * @return Season
     */
    public Season getSeasonAsSeason()
    {
        return Season.getFromCode(this.season);
    }

    /**
     * Timestamp
     * 
     * @return Long
     */
    public Long getTimestamp()
    {
        return this.timestamp;
    }

    public ZonedDateTime getTimestampAsDate()
    {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(this.timestamp), ZoneOffset.UTC);
    }

    @Override
    public String toString()
    {
        return "MatchReference [champion=" + this.champion + ", lane=" + this.lane + ", matchId=" + this.matchId + ", platformId=" + this.platformId + ", queue=" + this.queue + ", role=" + this.role + ", season=" + this.season + ", timestamp=" + this.timestamp + "]";
    }

    public static List<MatchReference> createFromString(String json) throws Exception
    {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        final JsonNode node = mapper.readTree(json);
        final List<MatchReference> matches = new ArrayList<>();

        if (node.get("totalGames").asLong() == 0)
        {
            return matches;
        }

        node.get("matches").forEach(n -> {
            try
            {
                final MatchReference match = mapper.readValue(n.toString(), MatchReference.class);
                matches.add(match);
            } catch (final Exception e)
            {
                e.printStackTrace();
            }
        });
        return matches;
    }
}