package com.monitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.monitor.model.DBDetails;
import com.monitor.model.DBSize;
import com.monitor.model.Database;
import com.monitor.util.DbUtil;

public class MySqlDAO implements StatusBaseDAO
{

    @Override
    public DBDetails getDetails(Integer dbId)
    {
        {
            DBDetails details = new DBDetails();
            DBDetailsDAO dao = new DBDetailsDAO();
            Database db =dao.getDatabaseById(dbId);
            getVersionDetails(db,details);
            return details; 
        }
    }
    
    public void getVersionDetails(Database db,DBDetails details)
    {
        Connection con =DbUtil.getConnection(db);
        try {
            Statement stmt = con.createStatement();
                    
            
            ResultSet rs = stmt.executeQuery(" SHOW VARIABLES LIKE \"version\";");
            
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

  public DBSize getDatabaseSize(Integer dbId)
  {
      DBDetailsDAO dao = new DBDetailsDAO();
      Database db =dao.getDatabaseById(dbId);
      
      String query = "SELECT table_schema \"Name\",sum( data_length + index_length ) / 1024 / 1024 \"Size\" FROM information_schema.TABLES GROUP BY table_schema ;"; 
      
      Connection con =DbUtil.getConnection(db);
      DBSize dbSize = new DBSize();
      try {
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          
          
          while (rs.next()) {
              if(rs.getString("Name").equalsIgnoreCase(db.getDbName()))
              {
                  dbSize.setDbName(db.getDbName());
                  dbSize.setDbSize(rs.getFloat("Size"));
                  dbSize.setHostName(db.getHostName());
                  break;
              }
          }
          return dbSize;
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;
  }
}
