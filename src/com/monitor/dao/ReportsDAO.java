package com.monitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.monitor.model.Report;
import com.monitor.util.DbUtil;
public class ReportsDAO
{
    Connection con;
    public ReportsDAO() {
        con = DbUtil.getConnection();
    }

    public void addRecord(Report report) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("insert into reports(dbid,cpu,memory,available,size,date,time,year) values (?, ?, ?, ?, ?, now() ,now() , now() );");
            // Parameters start with 1
            preparedStatement.setLong(1, report.getDbid());
            preparedStatement.setString(2, DbUtil.trim(report.getCpu()));
            if(report.getTotalMemory().indexOf("MB") >= 0)
            {
                preparedStatement.setString(3,report.getTotalMemory().substring(0,report.getTotalMemory().indexOf("MB")).trim().replaceAll(",",""));
                preparedStatement.setString(4,report.getAvailMemory().substring(0,report.getAvailMemory().indexOf("MB")).trim().replaceAll(",",""));
            }
            else
            {
                preparedStatement.setString(3,report.getTotalMemory().trim().replaceAll(",",""));
                preparedStatement.setString(4,report.getAvailMemory().trim().replaceAll(",",""));
            }
            preparedStatement.setString(5, report.getSize());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
}
