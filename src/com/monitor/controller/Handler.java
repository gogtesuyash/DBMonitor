package com.monitor.controller;

import com.monitor.model.CpuDetails;
import com.monitor.model.Database;
import com.monitor.model.MemoryDetails;

public interface Handler
{

    public CpuDetails getCpuUtilisation(Integer dbId);
    
    public CpuDetails getCpuUtilisation(Database db);
    
    public MemoryDetails getMemoryUtilisation(Integer dbId);
    
    public MemoryDetails getMemoryUtilisation(Database db);
}
