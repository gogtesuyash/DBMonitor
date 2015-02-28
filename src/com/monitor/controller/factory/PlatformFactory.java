package com.monitor.controller.factory;

import com.monitor.controller.Handler;
import com.monitor.controller.LinuxHandler;
import com.monitor.controller.WindowsHandler;



public class PlatformFactory
{

    public static Handler getHandler(String osType)
    {
        if(osType.equalsIgnoreCase("windows"))
        {
            return (Handler)new WindowsHandler();
        }
        else if(osType.equalsIgnoreCase("linux"))
        {
            return (Handler)new LinuxHandler();
        }
        return null;
    }
}
