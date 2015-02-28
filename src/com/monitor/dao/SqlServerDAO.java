package com.monitor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.monitor.model.DBDetails;
import com.monitor.model.DBSize;
import com.monitor.model.Database;
import com.monitor.util.DbUtil;

public class SqlServerDAO implements StatusBaseDAO
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
                    
            
            ResultSet rs = stmt.executeQuery("SELECT @@version as value");
            
            if (rs.next()) {
                details.setVersion(rs.getString("Value"));
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
        
        String query = "EXEC sp_helpdb @dbname= '" + db.getDbName() + "'";
        
        Connection con =DbUtil.getConnection(db);
        DBSize dbSize = new DBSize();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query); 
            while (rs.next()) {
                    dbSize.setHostName(db.getHostName());
                    dbSize.setDbName(db.getDbName());
                    String size = rs.getString("db_size");
                    dbSize.setDbSize(Float.parseFloat(size.substring(0,size.indexOf("MB")).trim()));
            }
            return dbSize;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
