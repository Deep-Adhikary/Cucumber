package codeEnv.managers;
import codeEnv.utils.Enums.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private  WebDriver driver;
    public  void launchBrowser(Browser browser) {
        switch (browser){
            case Firefox:
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\src\\test\\java\\exes\\geckodriver.exe");
                FirefoxProfile ffprofile = new FirefoxProfile();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                ffprofile.setPreference("dom.webnotifications.enabled", false);
                firefoxOptions.setProfile(ffprofile);
                driver=new FirefoxDriver(firefoxOptions);
                 break;
            case IE:
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"\\src\\test\\java\\exes\\IEDriverServer.exe");
                driver=new InternetExplorerDriver();
                break;
            case Chrome:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\java\\exes\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver=new ChromeDriver(options);
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    public WebDriver getDriver(){
        return driver;
    }

}
