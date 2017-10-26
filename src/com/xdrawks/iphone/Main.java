package com.xdrawks.iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiendong on 26/10/17.
 */
public class Main {
    public static void main(String[] args) {
        int count = 0;
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 40);

        while(true) {
            try {
                driver.get("https://www.apple.com/sg/shop/buy-iphone/iphone-x/5.8-inch-display-256gb-silver#00,10,21");
//                driver.get("https://www.apple.com/sg/shop/buy-iphone/iphone-8/5.5-inch-display-256gb-gold#01,11,21");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("rs-purchasesummary-container")));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.as-button-large.as-button-block")));

                if (element.isEnabled()) {
                    element.click();
                    break;
                } else {
                    System.out.println(count++);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }


        }
    }
}
