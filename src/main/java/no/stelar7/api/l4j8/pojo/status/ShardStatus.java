package no.stelar7.api.l4j8.pojo.status;

import java.io.Serializable;
import java.util.List;

public class ShardStatus implements Serializable
{
    private static final long serialVersionUID = -409392794592018967L;
    
    private String        hostname;
    private List<String>  locales;
    private String        name;
    private String        region_tag;
    private List<Service> services;
    private String        slug;
    
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
        final ShardStatus other = (ShardStatus) obj;
        if (this.hostname == null)
        {
            if (other.hostname != null)
            {
                return false;
            }
        } else if (!this.hostname.equals(other.hostname))
        {
            return false;
        }
        if (this.locales == null)
        {
            if (other.locales != null)
            {
                return false;
            }
        } else if (!this.locales.equals(other.locales))
        {
            return false;
        }
        if (this.name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        } else if (!this.name.equals(other.name))
        {
            return false;
        }
        if (this.region_tag == null)
        {
            if (other.region_tag != null)
            {
                return false;
            }
        } else if (!this.region_tag.equals(other.region_tag))
        {
            return false;
        }
        if (this.services == null)
        {
            if (other.services != null)
            {
                return false;
            }
        } else if (!this.services.equals(other.services))
        {
            return false;
        }
        if (this.slug == null)
        {
            if (other.slug != null)
            {
                return false;
            }
        } else if (!this.slug.equals(other.slug))
        {
            return false;
        }
        return true;
    }
    
    /**
     * Gets the hostname.
     *
     * @return the hostname
     */
    public String getHostname()
    {
        return this.hostname;
    }
    
    /**
     * Gets the locales.
     *
     * @return the locales
     */
    public List<String> getLocales()
    {
        return this.locales;
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Gets the region_tag.
     *
     * @return the region_tag
     */
    public String getRegionTag()
    {
        return this.region_tag;
    }
    
    /**
     * Gets the services.
     *
     * @return the services
     */
    public List<Service> getServices()
    {
        return this.services;
    }
    
    /**
     * Gets the slug.
     *
     * @return the slug
     */
    public String getSlug()
    {
        return this.slug;
    }
    
    @Override
    public int hashCode()
    {
        final int prime  = 31;
        int       result = 1;
        result = (prime * result) + ((this.hostname == null) ? 0 : this.hostname.hashCode());
        result = (prime * result) + ((this.locales == null) ? 0 : this.locales.hashCode());
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((this.region_tag == null) ? 0 : this.region_tag.hashCode());
        result = (prime * result) + ((this.services == null) ? 0 : this.services.hashCode());
        result = (prime * result) + ((this.slug == null) ? 0 : this.slug.hashCode());
        return result;
    }
    
    @Override
    public String toString()
    {
        return "ShardStatus{" +
               "hostname='" + hostname + '\'' +
               ", locales=" + locales +
               ", name='" + name + '\'' +
               ", regionTag='" + region_tag + '\'' +
               ", services=" + services +
               ", slug='" + slug + '\'' +
               '}';
    }
}
