package codeEnv.global;

import codeEnv.managers.DriverManager;
import org.apache.log4j.Logger;

import java.util.Stack;

public class Global {
    private final  Logger logger;
    private DriverManager driverManager;
    public Global(){
        driverManager=new DriverManager();
        logger= Logger.getLogger(Global.class);
    }
    public DriverManager getDriverManager() {
        logger.info("Driver Maneger Returned");
        return driverManager;
    }
    public Logger getLogger(){
        return logger;
    }
}
