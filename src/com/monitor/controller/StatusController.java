package com.monitor.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monitor.controller.factory.DAOFactory;
import com.monitor.controller.factory.PlatformFactory;
import com.monitor.dao.DBDetailsDAO;
import com.monitor.dao.StatusBaseDAO;
import com.monitor.model.DBStatus;
import com.monitor.model.Database;
import com.monitor.util.DbUtil;

public class StatusController extends HttpServlet 
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static String DATABASE_STATUS_DETAILS = "/databaseStatusDetails.jsp";
    private static String DATABASE_DETAILS = "/databaseDetails.jsp";
    private static String DATABASE_STATUS = "/dbStatusDetails.jsp";
    private static String MEM_DETAILS = "/memoryDetails.jsp";
    private static String CPU_DETAILS = "/cpuDetails.jsp";
    private static String DATABASE_SIZE = "/dbsize.jsp";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBDetailsDAO dao = new DBDetailsDAO();
        request.setAttribute("databases", dao.getAllDatabases());
        RequestDispatcher view = request.getRequestDispatcher(DATABASE_STATUS_DETAILS);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String osType = request.getParameter("platform");
        String dbType = request.getParameter("dbType");
        Integer opId = Integer.parseInt(request.getParameter("operations"));
        Integer dbId = Integer.parseInt(request.getParameter("hostname"));
        Handler handle = null;
        RequestDispatcher view = null;
        switch(opId)
        {
            case 1 :       
                StatusBaseDAO dao = DAOFactory.getDAO(osType, dbType);
                request.setAttribute("details", dao.getDetails(dbId));
                view = request.getRequestDispatcher(DATABASE_DETAILS);
                view.forward(request, response);
                break;
            case 2 :
                DBDetailsDAO detailsDAO = new DBDetailsDAO();
                Database db =detailsDAO.getDatabaseById(dbId);
                Connection con = DbUtil.getConnection(db);
                DBStatus status = new DBStatus();
                status.setHostName(db.getHostName());
                if(con == null)
                    status.setStatus("OFF");
                else
                    status.setStatus("ON");
                request.setAttribute("dbstatus", status);
                view = request.getRequestDispatcher(DATABASE_STATUS);
                view.forward(request, response);
                break;
            case 3 :
                dao = DAOFactory.getDAO(osType, dbType);
                request.setAttribute("dbSize", dao.getDatabaseSize(dbId));
                view = request.getRequestDispatcher(DATABASE_SIZE);
                view.forward(request, response);
                break;
            case 4 :
                break;
            case 7 :
                handle = PlatformFactory.getHandler(osType);
                request.setAttribute("cpuDetails", handle.getCpuUtilisation(dbId));
                view = request.getRequestDispatcher(CPU_DETAILS);
                view.forward(request, response);
                break;
            case 8 :
                handle = PlatformFactory.getHandler(osType);
                request.setAttribute("memDetails", handle.getMemoryUtilisation(dbId));
                view = request.getRequestDispatcher(MEM_DETAILS);
                view.forward(request, response);
                break;
        }
     }
}
