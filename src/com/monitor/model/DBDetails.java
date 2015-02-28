package com.monitor.model;

public class DBDetails
{
    public String dbName;
    public String version;
    public String dbType;
    public String hostName;

    public String getDbName()
    {
        return dbName;
    }

    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getDbType()
    {
        return dbType;
    }

    public void setDbType(String dbType)
    {
        this.dbType = dbType;
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
