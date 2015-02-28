package com.monitor.staf;

import java.util.List;
import java.util.Map;

import com.ibm.staf.STAFException;
import com.ibm.staf.STAFHandle;
import com.ibm.staf.STAFResult;
import com.ibm.staf.STAFUtil;

public class STAFHandler
{
    public String executeRemoteCommand(String command , String machine)
    {
        try
        {
            // Create a STAFHandle

            STAFHandle handle = new STAFHandle("MyApplication");
            

            try
            {
                // Submit a request to the PROCESS service to run a command on
                // a machine and wait for it to complete and returns its stdout
                // and stderr. Note that the result from this request returns
                // a marshalled map so we'll use STAFResult's resultObj variable
                // to access the map root object

                String service = "PROCESS";
                String request = "START SHELL COMMAND " + STAFUtil.wrapData(command)
                    + " WAIT RETURNSTDOUT STDERRTOSTDOUT";

                STAFResult result = handle.submit2(machine, service, request);

                if (result.rc != 0)
                {
                    System.out.println("ERROR: STAF " + machine + " " + service + " " + request + " RC: "
                        + result.rc + ", Result: " + result.result);
                  //  System.exit(1);
                }

                // The command was started successfully. Check the process
                // return code and if non-zero, also print an error message

                Map resultMap = (Map)result.resultObj;
                String processRC = (String)resultMap.get("rc");

                if (!processRC.equals("0"))
                {
                    System.out.println("ERROR: Process RC is not 0.\n" + result.resultContext);
                   // System.exit(1);
                }

                // Print the stdout/stderr data for the command

                List returnedFileList = (List)resultMap.get("fileList");
                Map stdoutMap = (Map)returnedFileList.get(0);
                String stdoutData = (String)stdoutMap.get("data");

                return stdoutData;
            }
            finally
            {
                handle.unRegister();
            }
        }
        catch (STAFException e)
        {
            System.out.println("Error (un)registering with STAF, RC:" + e.rc);
           // System.exit(1);
        }
        return null;
    } // End of main()

} // End of STAFTest

