package codeEnv.global;

import codeEnv.managers.DriverManager;

import java.util.Stack;

public class Global {
    private DriverManager driverManager;
    public Global(){
        driverManager=new DriverManager();
    }
    public DriverManager getDriverManager() {
        return driverManager;
    }
}
