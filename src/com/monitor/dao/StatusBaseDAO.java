package com.monitor.dao;

import com.monitor.model.DBDetails;
import com.monitor.model.DBSize;

public interface StatusBaseDAO
{

    public DBDetails getDetails(Integer dbId);
    
    public DBSize getDatabaseSize(Integer dbId);
}
