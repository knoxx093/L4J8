package no.stelar7.api.l4j8.pojo.tournament;

import java.io.Serializable;
import java.util.List;

public class LobbyEventWrapper implements Serializable
{
    private static final long serialVersionUID = 536995135599115414L;
    
    private List<LobbyEvent> eventList;
    
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        final LobbyEventWrapper other = (LobbyEventWrapper) obj;
        if (this.eventList == null)
        {
            if (other.eventList != null)
            {
                return false;
            }
        } else if (!this.eventList.equals(other.eventList))
        {
            return false;
        }
        return true;
    }
    
    /**
     * A list of the lobby events
     *
     * @return event list
     */
    public List<LobbyEvent> getEventList()
    {
        return this.eventList;
    }
    
    @Override
    public int hashCode()
    {
        final int prime  = 31;
        int       result = 1;
        result = (prime * result) + ((this.eventList == null) ? 0 : this.eventList.hashCode());
        return result;
    }
    
    @Override
    public String toString()
    {
        return "LobbyEventWrapper [eventList=" + this.eventList + "]";
    }
}
