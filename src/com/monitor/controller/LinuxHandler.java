package com.monitor.controller;

import com.monitor.dao.DBDetailsDAO;
import com.monitor.model.CpuDetails;
import com.monitor.model.Database;
import com.monitor.model.MemoryDetails;
import com.monitor.staf.STAFHandler;

public class LinuxHandler implements Handler
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
        String command = "top -b -n2 -p 1 | fgrep \"Cpu(s)\" | tail -1 | awk -F'id,' -v prefix=\"$prefix\" \'{ split($1, vs, \",\"); v=vs[length(vs)]; sub(\"%\", \"\", v); printf \"%s%.1f%%\\n\", prefix, 100 - v }\'";
        cpuDetails.setUtilisation(staf.executeRemoteCommand(command,db.getHostName()));
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
        String totalMemory = staf.executeRemoteCommand("cat /proc/meminfo | grep \"MemTotal\"",db.getHostName());
        totalMemory = totalMemory.split(":")[1].trim();
        totalMemory = totalMemory.substring(0,totalMemory.indexOf("kB")).trim();
        memDetails.setTotal(String.valueOf(Integer.parseInt(totalMemory)/1024));
        
        String availableMemory = staf.executeRemoteCommand("cat /proc/meminfo | grep \"MemFree\"",db.getHostName());
        availableMemory = availableMemory.split(":")[1].trim();
        availableMemory = availableMemory.substring(0,availableMemory.indexOf("kB")).trim();
        memDetails.setAvailable(String.valueOf(Integer.parseInt(availableMemory)/1024));
        return memDetails;
    }

}
