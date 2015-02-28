package com.schedular;

import java.util.List;

import com.monitor.controller.Handler;
import com.monitor.controller.factory.DAOFactory;
import com.monitor.controller.factory.PlatformFactory;
import com.monitor.dao.DBDetailsDAO;
import com.monitor.dao.ReportsDAO;
import com.monitor.dao.StatusBaseDAO;
import com.monitor.model.CpuDetails;
import com.monitor.model.DBSize;
import com.monitor.model.Database;
import com.monitor.model.MemoryDetails;
import com.monitor.model.Report;

public class Schedular
{

    public static void main(String[] args)
    {
        execute();
    }

    public static void execute()
    {
        DBDetailsDAO dao = new DBDetailsDAO();
        List<Database> list = dao.getAllDatabases();
        if (list != null && !list.isEmpty())
        {
            for (Database db : list)
            {
                    Handler handle = PlatformFactory.getHandler(db.getPlatform());
                    CpuDetails cpu = handle.getCpuUtilisation(db);
                    MemoryDetails mem = handle.getMemoryUtilisation(db);
                    StatusBaseDAO statusDao = DAOFactory.getDAO(db.getPlatform(), db.getDbType());
                    DBSize size = statusDao.getDatabaseSize(db.getId());
                    Report report = new Report();
                    report.setDbid(db.getId());
                    report.setCpu(cpu.getUtilisation());
                    report.setTotalMemory(mem.getTotal());
                    report.setAvailMemory(mem.getAvailable());
                    report.setSize(String.valueOf(size.getDbSize()));
                    ReportsDAO reportDao = new ReportsDAO();
                    reportDao.addRecord(report);
            }
        }
    }
}
