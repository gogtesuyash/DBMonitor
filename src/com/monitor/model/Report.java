package com.monitor.model;

public class Report
{

    private int id;
    private int dbid;
    private String date;
    private String time;
    private String year;
    private String cpu;
    private String availMemory;
    private String size;
    private String totalMemory;
    public String getAvailMemory()
    {
        return availMemory;
    }
    public void setAvailMemory(String availMemory)
    {
        this.availMemory = availMemory;
    }
    public String getTotalMemory()
    {
        return totalMemory;
    }
    public void setTotalMemory(String totalMemory)
    {
        this.totalMemory = totalMemory;
    }
    public int getDbid()
    {
        return dbid;
    }
    public void setDbid(int dbid)
    {
        this.dbid = dbid;
    }
    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public String getTime()
    {
        return time;
    }
    public void setTime(String time)
    {
        this.time = time;
    }
    public String getYear()
    {
        return year;
    }
    public void setYear(String year)
    {
        this.year = year;
    }
  
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getCpu()
    {
        return cpu;
    }
    public void setCpu(String cpu)
    {
        this.cpu = cpu;
    }
    public String getSize()
    {
        return size;
    }
    public void setSize(String size)
    {
        this.size = size;
    }
    
}
