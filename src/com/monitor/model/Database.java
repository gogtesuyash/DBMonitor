package com.monitor.model;

public class Database
{

    private int id;
    private String hostName;
    private String dbName;
    private String userName;
    private String password;
    private int port;
    private String dbType;
    private String platform;
    
    public String getPlatform()
    {
        return platform;
    }
    
    public void setPlatform(String platform)
    {
        this.platform=platform; 
    }
    
    public String getDbType()
    {
        return dbType;
    }
    
    public void setDbType(String dbType)
    {
        this.dbType = dbType;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getHostName()
    {
        return hostName;
    }
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }
    public String getDbName()
    {
        return dbName;
    }
    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public int getPort()
    {
        return port;
    }
    public void setPort(int port)
    {
        this.port = port;
    }
    
    
}
