package no.stelar7.api.l4j8.pojo.tournament;

import java.util.HashSet;
import java.util.Set;

public class SummonerIdParams
{
    Set<Number> participants;

    public SummonerIdParams()
    {
        this.participants = new HashSet<>();
    }

    public SummonerIdParams(final Set<Long> set)
    {
        this.participants = new HashSet<Number>();
        for (final Number id : set)
        {
            this.participants.add(id);
        }
    }

    public void addParticipant(final Number id)
    {
        this.participants.add(id);
    }

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
        final SummonerIdParams other = (SummonerIdParams) obj;
        if (this.participants == null)
        {
            if (other.participants != null)
            {
                return false;
            }
        } else if (!this.participants.equals(other.participants))
        {
            return false;
        }
        return true;
    }

    public Set<Number> getParticipants()
    {
        return this.participants;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.participants == null) ? 0 : this.participants.hashCode());
        return result;
    }
}