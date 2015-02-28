package com.monitor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.monitor.model.DBDetails;
import com.monitor.model.DBSize;
import com.monitor.model.Database;
import com.monitor.util.DbUtil;

public class OracleDAO implements StatusBaseDAO
{
    @Override
    public DBDetails getDetails(Integer dbId)
    {
        DBDetails details = new DBDetails();
        DBDetailsDAO dao = new DBDetailsDAO();
        Database db =dao.getDatabaseById(dbId);
        getVersionDetails(db,details);
        return details; 
    }

    public void getVersionDetails(Database db,DBDetails details)
    {
        Connection con =DbUtil.getConnection(db);
        try {
            Statement stmt = con.createStatement();
                    
            
            ResultSet rs = stmt.executeQuery("select * from v$version");
            
            if (rs.next()) {
                details.setVersion(rs.getString("BANNER"));
                details.setDbName(db.getDbName());
                details.setDbType(db.getDbType());
                details.setHostName(db.getHostName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public DBSize getDatabaseSize(Integer dbId)
    {
        DBDetailsDAO dao = new DBDetailsDAO();
        Database db =dao.getDatabaseById(dbId);
        String query = "select sum(bytes)/1024/1024 MB from ( select sum (bytes) bytes from v$datafile union select sum (bytes) from v$tempfile union select sum (bytes * members) from v$log)";
        Connection con =DbUtil.getConnection(db);
        DBSize dbSize = new DBSize();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query); 
            while (rs.next()) {
              
                    dbSize.setDbName(db.getDbName());
                    dbSize.setDbSize(rs.getFloat("MB"));
                    dbSize.setHostName(db.getHostName());
            }
            return dbSize;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        // TODO Auto-generated method stu
    }

}
