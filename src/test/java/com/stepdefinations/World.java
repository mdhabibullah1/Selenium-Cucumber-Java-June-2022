package com.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class World {
    public String Habibullah;
    public WebDriver driver;
    public int timeOut = 60;

//    public WebElement driverWait(String xpath){
//        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
//        WebElement firstResult = new WebDriverWait(this.driver, Duration.ofSeconds(120))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//        return firstResult;
//    }

    public WebElement driverWait(String xpath) {
        // Initialize and wait till element(link) became clickable - timeout in 10 seconds

        WebElement firstResult = new WebDriverWait(this.driver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement sResult = new WebDriverWait(this.driver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return sResult;
    }
}
