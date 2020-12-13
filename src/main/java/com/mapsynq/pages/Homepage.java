package com.mapsynq.pages;


import com.mapsynq.basest.baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends baseclass {

    @FindBy(xpath = "//input[@placeholder='Where to?']")
     private WebElement searchBox;


    public Homepage() {
        PageFactory.initElements(driver, this);
    }
    public String ValidatePageTitle() {
        return driver.getTitle();
    }

    public void searchItem(String Name) throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Where to?']")).click();
        //searchBox.click();
       Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Where to?']")).sendKeys(Name);
       // searchBox.sendKeys(Name);
       // searchBox.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@placeholder='Where to?']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Club Mahindra Madikeri, Coorg')]")).click();
        Thread.sleep(5000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
       // executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        executor.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='component_4']/div/div[1]/div[2]/div/div[1]/div[1]/div/div/span")).sendKeys(Keys.ESCAPE);
        WebElement review = driver.findElement(By.xpath("//*[@id='COMMUNITYCONTENT']/div/div[2]/div/div[1]/a"));
         executor.executeScript("arguments[0].click();", review);
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id='bubble_rating']")).click();

    }



}
