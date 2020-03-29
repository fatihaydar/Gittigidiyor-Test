package com.gittigidiyor.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BasePage {

    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public List<WebElement> findElements (By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);

    }


    public void captureScreenshot(String screenshotName)
    {
        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("properties/screen_shots/"+screenshotName+".png"));
            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); //
        return driver.findElement(by);
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void clickElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void selectOption(By by, String text) {
        Select select = new Select(findElement(by));
        select.selectByVisibleText(text);
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public String getText(By by) {
        return findElement(by).getText();
    }
    public void navigateToUrl(String url){
        driver.navigate().to(url);
    }
}
