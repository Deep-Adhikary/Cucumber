package codeEnv.managers;

import codeEnv.pom.*;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class PageManager{
    Map <String,PomTemplate> pageMap;
    public PageManager(){
        pageMap=new HashMap<>();
    }
    public <T extends PomTemplate> T getPage(Class<T> classContext , WebDriver driver){
        try{
            if(pageMap.containsKey(classContext.getName())){
                return (T) pageMap.get(classContext.getName());
            }else{
                T t=classContext.getConstructor(WebDriver.class).newInstance(driver);
                pageMap.put(classContext.getName(),t);
                return (T) pageMap.get(classContext.getName());
            }
        }catch(Exception e){
            return null;
        }
    }
    public <T extends PomTemplate>  T getPage(Class<T> classContext , WebDriver driver, int timeOut){
        try{
            String className=classContext.getName().concat("_Ajax");
            if(pageMap.containsKey(className)){
                return  (T)pageMap.get(className);
            }else{
                T t=classContext.getConstructor(WebDriver.class,int.class).newInstance(driver,timeOut);
                pageMap.put(className,t);
                return (T) pageMap.get(className);
            }
        }catch(Exception e){
            return null;
        }
    }


}
/*class Test{
    public static void main(String[] args) {
        WebDriver driver;
        PageManager<PomTemplate> pgManager=new PageManager<>();
       LoginPage lpage=  pgManager.getPage(LoginPage.class, driver);
    }
}*/
