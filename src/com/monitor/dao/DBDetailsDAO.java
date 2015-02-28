package com.monitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.monitor.model.Database;
import com.monitor.util.DbUtil;

public class DBDetailsDAO
{

    private Connection connection;

    public DBDetailsDAO() {
        connection = DbUtil.getConnection();
    }

    public void addDatabase(Database db) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into db_details(hostname,dbname,port,username,password,platform,dbtype) values (?, ?, ?, ? , ? ,? , ? )");
            // Parameters start with 1
            preparedStatement.setString(1, db.getHostName());
            preparedStatement.setString(2, db.getDbName());
            preparedStatement.setInt(3, db.getPort() );
            preparedStatement.setString(4, db.getUserName());
            preparedStatement.setString(5, db.getPassword());
            preparedStatement.setString(6, db.getPlatform());
            preparedStatement.setString(7, db.getDbType());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteDatabase(int dbId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from db_details where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, dbId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateDatabase(Database database) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update db_details set hostname=?, dbname=?, port=?, username=?,password=?,platform=?,dbtype= ?" +
                            "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, database.getHostName());
            preparedStatement.setString(2, database.getDbName());
            preparedStatement.setInt(3, database.getPort());
            preparedStatement.setString(4,database.getUserName());
            preparedStatement.setString(5, database.getPassword());
            preparedStatement.setString(6, database.getPlatform());
            preparedStatement.setString(7, database.getDbType());
            preparedStatement.setInt(8, database.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Database> getAllDatabases() {
        List<Database> databases = new ArrayList<Database>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from db_details");
            while (rs.next()) {
                Database db = new Database();
                db.setId(rs.getInt("id"));
                db.setHostName(rs.getString("hostname"));
                db.setDbName(rs.getString("dbname"));
                db.setPort(rs.getInt("port"));
                db.setUserName(rs.getString("username"));
                db.setPassword(rs.getString("password"));
                db.setPlatform(rs.getString("platform"));
                db.setDbType(rs.getString("dbtype"));
                databases.add(db);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return databases;
    }
    
    public Database getDatabaseById(int dbId) {
        Database db = new Database();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from db_details where id=?");
            preparedStatement.setInt(1, dbId);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                db.setId(rs.getInt("id"));
                db.setHostName(rs.getString("hostname"));
                db.setDbName(rs.getString("dbname"));
                db.setUserName(rs.getString("username"));
                db.setPassword(rs.getString("password"));
                db.setPort(rs.getInt("port"));
                db.setPlatform(rs.getString("platform"));
                db.setDbType(rs.getString("dbtype"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return db;
    }
    
}
