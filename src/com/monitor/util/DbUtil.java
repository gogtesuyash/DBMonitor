package com.monitor.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.monitor.model.Database;

public class DbUtil
{
    private static Connection connection = null;
    
    private static final String SQLSERVER_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    private static final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    private static final String ORACLE_JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    public static Connection getConnection()
    {
        if (connection != null)
            return connection;
        else
        {
            try
            {
                Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return connection;
        }

    }
    
    public static String trim(String str)
    {
        String output = "";
        str = str.trim();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='0' && str.charAt(i)<='9')
            {
                output = output + str.charAt(i);
            }
        }
        return output;
    }
    public static Connection getConnection(Database db)
    {
        Connection con = null;
        if (db.getDbType().equalsIgnoreCase("mysql"))
        {
            String driver = MYSQL_JDBC_DRIVER;
            String url = "jdbc:mysql://" + db.getHostName() + ":" + db.getPort() + "/" + db.getDbName();
            try
            {
                Class.forName(driver);
                con = DriverManager.getConnection(url, db.getUserName(), db.getPassword());
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
        }
        else if(db.getDbType().equalsIgnoreCase("SqlServer"))
        {
            String driver = SQLSERVER_JDBC_DRIVER;
            String url = "jdbc:sqlserver://" + db.getHostName() + ":" + db.getPort() + ";databaseName=" + db.getDbName();
            try
            {
                Class.forName(driver);
                con = DriverManager.getConnection(url, db.getUserName(), db.getPassword());
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(db.getDbType().equalsIgnoreCase("Oracle"))
        {
            String driver = ORACLE_JDBC_DRIVER;
            String url = "jdbc:oracle:thin:@" + db.getHostName() + ":" + db.getPort() + ":" + db.getDbName();
            try
            {
                Class.forName(driver);
                con = DriverManager.getConnection(url, db.getUserName(), db.getPassword());
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return con;
    }
}
