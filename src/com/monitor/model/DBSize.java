package com.monitor.model;

public class DBSize
{
    private float dbSize;
    private String dbName;
    private String hostName;
    
    public float getDbSize()
    {
        return dbSize;
    }
    public void setDbSize(float dbSize)
    {
        this.dbSize = dbSize;
    }
    public String getDbName()
    {
        return dbName;
    }
    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }
    public String getHostName()
    {
        return hostName;
    }
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }   
}
