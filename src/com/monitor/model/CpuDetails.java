package com.monitor.model;

public class CpuDetails
{

    String hostName;
    
    String utilisation;

    public String getHostName()
    {
        return hostName;
    }

    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    public String getUtilisation()
    {
        return utilisation;
    }

    public void setUtilisation(String utilisation)
    {
        this.utilisation = utilisation;
    }
}
