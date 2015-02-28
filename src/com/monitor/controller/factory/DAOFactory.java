package com.monitor.controller.factory;


import com.monitor.dao.MySqlDAO;
import com.monitor.dao.OracleDAO;
import com.monitor.dao.SqlServerDAO;
import com.monitor.dao.StatusBaseDAO;


public class DAOFactory
{

    public static StatusBaseDAO getDAO(String osType , String dbType)
    {
        if(dbType.equalsIgnoreCase("mysql") )
        {
            return (StatusBaseDAO)new MySqlDAO();
        }
        else if(dbType.equalsIgnoreCase("oracle") )
        {
            return (StatusBaseDAO)new OracleDAO();
        }
        else if(dbType.equalsIgnoreCase("sqlserver") )
        {
            return (StatusBaseDAO)new SqlServerDAO();
        }
        
        return null;
    }
}
