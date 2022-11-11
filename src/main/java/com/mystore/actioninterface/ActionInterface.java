package com.mystore.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {

    //Added all user actions abstract methods to achieve Abstraction
    public abstract void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
    public abstract void click(WebDriver ldriver, WebElement ele);
    public abstract boolean isDisplayed(WebDriver ldriver, WebElement ele);
    public abstract boolean findElement(WebDriver ldriver, WebElement ele);
    public abstract boolean isSelected(WebDriver ldriver, WebElement ele);
    public abstract boolean isEnabled(WebDriver ldriver, WebElement ele);
    public abstract boolean selectBySendkeys(String value,WebElement ele);
    public abstract boolean selectByIndex(WebElement element, int index);
    public abstract boolean selectByValue(WebElement element,String value);
    public abstract boolean selectByVisibleText(String visibletext, WebElement ele);
    public abstract boolean mouseHoverByJavaScript(WebElement locator);
    public abstract boolean JSClick(WebDriver driver, WebElement ele);
    public abstract boolean switchToFrameByIndex(WebDriver driver,int index);
    public abstract boolean switchToFrameById(WebDriver driver,String idValue);
    public abstract boolean switchToFrameByName(WebDriver driver,String nameValue);
    public abstract boolean switchToDefaultFrame(WebDriver driver);
    public abstract void mouseOverElement(WebDriver driver,WebElement element);
    public abstract boolean moveToElement(WebDriver driver, WebElement ele);
    public abstract boolean mouseover(WebDriver driver, WebElement ele);
    public abstract boolean draggable(WebDriver driver,WebElement source, int x, int y);
    public abstract boolean draganddrop(WebDriver driver,WebElement source, WebElement target);
    public abstract boolean slider(WebDriver driver,WebElement ele, int x, int y);
    public abstract boolean rightclick(WebDriver driver,WebElement ele);
    public abstract boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count);
    public abstract boolean switchToNewWindow(WebDriver driver);
    public abstract boolean switchToOldWindow(WebDriver driver);
    public abstract int getColumncount(WebElement row);
    public abstract int getRowCount(WebElement table);
    public abstract boolean Alert(WebDriver driver);
    public abstract boolean launchUrl(WebDriver driver,String url);
    public abstract boolean isAlertPresent(WebDriver driver);
    public abstract String getCurrentURL(WebDriver driver);
    public abstract String getTitle(WebDriver driver);
    public abstract boolean click1(WebElement locator, String locatorName);
    public abstract void fluentWait(WebDriver driver,WebElement element, int timeOut);
    public abstract void implicitWait(WebDriver driver, int timeOut);
    public abstract void explicitWait(WebDriver driver, WebElement element, int timeOut);
    public abstract void pageLoadTimeOut(WebDriver driver, int timeOut);
    public abstract String screenShot(WebDriver driver, String filename);
    public abstract String getCurrentTime();
    public abstract boolean type(WebElement ele, String text);


}
