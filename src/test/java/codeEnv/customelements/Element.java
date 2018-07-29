package codeEnv.customelements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Element {
    private static final  Logger logger=Logger.getLogger(Element.class);
    private WebElement element;
    private WebDriver driver;
    private WebDriverWait wait;

    private enum ElementStatus {
        VISIBLE,
        NOTVISIBLE,
        ENABLED,
        DISABLED,
        PRESENT,
        NOTPESENT,
        INVALID
    }
    public Element(WebElement elem, WebDriver driver) {
        this.element = elem;
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }
    public void click() {
        if (isDisplayed() ) {
            if(isEnabled()){
                element = wait.until(ExpectedConditions.elementToBeClickable(element));
                if (element != null) {
                    element.click();
                } else {
                    logger.info("Element is not clickable");
                }
            }else{
                logger.info("Element is not enabled");
            }
        } else {
            logger.info("Element is not displayed");
        }
    }

    public void submit() {
        element.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        if (isDisplayed()) {
            // element=wait.until( ExpectedConditions.visibilityOf(element));
            if (isEnabled()) {
                element.sendKeys(keysToSend);
            } else {
                logger.info("Element is not enabled displayed");
            }
        } else {
            logger.info("Element is not displayed");
        }
    }

    public void clear() {
        if(isDisplayed()){
            if(isEnabled()){
                element.clear();
            }else{
                logger.info("Element is not Enabled");
            }
        }else{
            logger.info("Element is not Displayed");
        }
    }

    public String getTagName() {
        if(isPresent())
            return element.getTagName();
        else {
            logger.info("Element is not enabled not Present");
            return "";
        }
    }

    public String getText() {
        if(isPresent()) {
            return element.getText();
        }else {
            logger.info("Element is not enabled not Present");
            return "";
        }
    }

    public String getAttribute(String name) {
        if(isPresent()) {
            logger.info("Element is Present");
            return element.getAttribute(name);
        }else {
            logger.info("Element is not enabled not Present");
            return "";
        }
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return getStatus(ElementStatus.ENABLED).equals(ElementStatus.ENABLED);
    }

    public boolean isDisplayed() {
        return getStatus(ElementStatus.VISIBLE).equals(ElementStatus.VISIBLE);
    }
    public boolean isPresent(){
        return getStatus(ElementStatus.PRESENT).equals(ElementStatus.PRESENT);
    }
    public Element findElement(By by) {
        return new Element(element.findElement(by), driver);
    }

    public List<Element> findElements(By by) {
        return convertElement(element.findElements(by));
    }

    private List<Element> convertElement(List<WebElement> webElements) {
        ArrayList<Element> elements = new ArrayList<>();
        webElements.forEach(webElement ->  elements.add(new Element(webElement, driver)));
        return elements;
    }

    public Point getLocation() {
        return element.getLocation();
    }

    public Dimension getSize() {
        return element.getSize();
    }

    public Rectangle getRect() {
        return element.getRect();
    }

    public String getCssValue(String propertyName) {
        if(isPresent())
            return element.getCssValue(propertyName);
        else {
            logger.info("Element is not enabled not Present");
            return "";
        }
    }

    private ElementStatus getStatus(ElementStatus status) {
        ElementStatus stat=ElementStatus.INVALID;
        try {
            switch (status) {
                case ENABLED:
                    if (element.isEnabled()) {
                        stat= ElementStatus.ENABLED;
                    } else {
                        stat= ElementStatus.DISABLED;
                    }
                    break;
                case PRESENT:
                    if (element.isDisplayed()) {
                        stat= ElementStatus.PRESENT;
                    }
                    break;
                case VISIBLE:
                    if (element.isDisplayed()) {
                        stat= ElementStatus.VISIBLE;
                    } else {
                        stat= ElementStatus.NOTVISIBLE;
                    }
                    break;
                default:
                    stat= ElementStatus.INVALID;
            }
        } catch (Exception e) {
            stat= ElementStatus.NOTPESENT;
        }
        return  stat;
    }
}
