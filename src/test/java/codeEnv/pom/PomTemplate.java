package codeEnv.pom;

import codeEnv.customelements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

public class PomTemplate {
    protected  WebDriver driver;
    PomTemplate(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    PomTemplate(WebDriver driver,int timeOut){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOut), this);
    }
    protected Element $(WebElement ele){
        return new Element(ele,driver);
    }
    protected Element $(By by){
       return new Element(driver.findElement(by),driver);

    }
    protected List<Element> $$(List<WebElement> elements){
        return convertElement(elements);
    }
    protected List<Element> $$(By by){
        return (convertElement( driver.findElements(by)));
    }
    private List<Element> convertElement(List<WebElement> webElements) {
        ArrayList<Element> elements = new ArrayList<>();
        webElements.forEach(webElement -> elements.add(new Element(webElement, driver)));
        return elements;
    }
}
