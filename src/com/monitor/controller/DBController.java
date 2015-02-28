package com.monitor.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monitor.dao.DBDetailsDAO;
import com.monitor.model.Database;




public class DBController  extends HttpServlet 
{
        private static final long serialVersionUID = 1L;
        private static String INSERT_OR_EDIT = "/database.jsp";
        private static String LIST_DATABASE = "/listDatabase.jsp";
        private DBDetailsDAO dao;
        public DBController() {
            super();
            dao = new DBDetailsDAO();
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String forward="";
            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("delete")){
                int dbId = Integer.parseInt(request.getParameter("id"));
                dao.deleteDatabase(dbId);
                forward = LIST_DATABASE;
                request.setAttribute("databases", dao.getAllDatabases()); 
            } else if (action.equalsIgnoreCase("edit")){
                forward = INSERT_OR_EDIT;
                int dbId = Integer.parseInt(request.getParameter("id"));
                Database db = dao.getDatabaseById(dbId);
                request.setAttribute("database", db);
            } else if (action.equalsIgnoreCase("listDatabase")){
                forward = LIST_DATABASE;
                request.setAttribute("databases", dao.getAllDatabases());
            } else {
                forward = INSERT_OR_EDIT;
            }

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        
        }
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Database db = new Database();
            db.setHostName(request.getParameter("hostName"));
            db.setDbName(request.getParameter("dbName"));
            db.setPort(Integer.parseInt(request.getParameter("port")));
            db.setUserName(request.getParameter("userName"));
            db.setPassword(request.getParameter("password"));
            db.setPlatform(request.getParameter("platform"));
            db.setDbType(request.getParameter("dbType"));
            String dbid = request.getParameter("id");
            if(dbid == null || dbid.isEmpty())
            {
                dao.addDatabase(db);
            }
            else
            {
                db.setId(Integer.parseInt(dbid));
                dao.updateDatabase(db);
            }
            RequestDispatcher view = request.getRequestDispatcher(LIST_DATABASE);
            request.setAttribute("databases", dao.getAllDatabases());
            view.forward(request, response);
        }

}
