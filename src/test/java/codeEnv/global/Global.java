package codeEnv.global;

import codeEnv.managers.DriverManager;
import codeEnv.managers.PageManager;
import codeEnv.pom.PomTemplate;
import org.apache.log4j.Logger;


public class Global {
    private final  Logger logger;
    private DriverManager driverManager;
    private PageManager pageManager;
    public Global(){
        driverManager=new DriverManager();
        pageManager=new PageManager();
        logger= Logger.getLogger(Global.class);
    }
    public DriverManager getDriverManager() {
        logger.info("Driver Maneger Returned");
        return driverManager;
    }
    public PageManager getPageManager() {
        return pageManager;
    }

    public Logger getLogger(){
        return logger;
    }
}
