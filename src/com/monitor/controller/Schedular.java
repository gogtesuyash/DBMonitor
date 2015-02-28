package com.monitor.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Schedular extends HttpServlet
{

    private String SCHEDULAR = "schedular.jsp";
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException
    {

        RequestDispatcher view = request.getRequestDispatcher(SCHEDULAR);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException
    {
        String isEnable = request.getParameter("schedular");
        String command = null;
        if (isEnable == null)
        {
            command = "cmd /c move \"C:\\windows\\System32\\Tasks\\Schedular\" \"C:\\windows\\System32\\Tasks\\Schedular.bak\"";
        }
        else
        {
            command = "cmd /c move \"C:\\windows\\System32\\Tasks\\Schedular.bak\" \"C:\\windows\\System32\\Tasks\\Schedular\"";
        }
        executeCommand(command);
    }

    public static void executeCommand(String command)
    {
        String s = null;

        try
        {
            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null)
            {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null)
            {
                System.out.println(s);
            }
        }
        catch (IOException e)
        {
            System.out.println("exception happened");
            e.printStackTrace();
        }
    }
}
