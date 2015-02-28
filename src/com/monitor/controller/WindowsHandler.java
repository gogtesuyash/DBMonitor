package com.monitor.controller;

import com.monitor.dao.DBDetailsDAO;
import com.monitor.model.CpuDetails;
import com.monitor.model.Database;
import com.monitor.model.MemoryDetails;
import com.monitor.staf.STAFHandler;


public class WindowsHandler implements Handler
{

    @Override
    public CpuDetails getCpuUtilisation(Integer dbId)
    {
        DBDetailsDAO dao = new DBDetailsDAO();
        Database db =dao.getDatabaseById(dbId);
        return getCpuUtilisation(db);
    }

    @Override
    public CpuDetails getCpuUtilisation(Database db)
    {
        STAFHandler staf = new STAFHandler();
        CpuDetails cpuDetails = new CpuDetails();
        cpuDetails.setHostName(db.getHostName());
        String res = staf.executeRemoteCommand("wmic cpu get loadpercentage",db.getHostName());
        res = res.split("\n")[1];
        cpuDetails.setUtilisation(res);
        return cpuDetails;
    }
    
    @Override
    public MemoryDetails getMemoryUtilisation(Integer dbId)
    {
        DBDetailsDAO dao = new DBDetailsDAO();
        Database db =dao.getDatabaseById(dbId);
        return getMemoryUtilisation(db); 
    }

    @Override
    public MemoryDetails getMemoryUtilisation(Database db)
    {
        STAFHandler staf = new STAFHandler();
        MemoryDetails memDetails = new MemoryDetails();
        memDetails.setHostName(db.getHostName());
        String availableMemory = staf.executeRemoteCommand("systeminfo | find \"Available Physical Memory\"",db.getHostName());
        availableMemory = availableMemory.split(":")[1];
        memDetails.setAvailable(availableMemory);
        
        String totalMemory = staf.executeRemoteCommand("systeminfo | find \"Total Physical Memory\"",db.getHostName());
        totalMemory = totalMemory.split(":")[1];
        memDetails.setTotal(totalMemory);
        return memDetails;
    }
}
