package com.mapsynq.helper.screenshot;

import com.mapsynq.basest.baseUtil;
import com.mapsynq.helper.resource.ResourceHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class getScreenshot extends baseUtil {

    private baseUtil base;
    public getScreenshot(baseUtil base){
        this.base=base;
    }


    public  void getscreeshot1(WebElement element) throws IOException {
        File screenshot = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Get the location of element on the page
        org.openqa.selenium.Point point = element.getLocation();
        // Get width and height of the element
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        // Copy the element screenshot to disk
        File screenshotLocation = new File(ResourceHelper.getResourcePath("\\src\\main\\java\\com\\mapsynq\\Screenshot")); //+ System.currentTimeMillis()+ ".png");
        FileUtils.copyFile(screenshot, screenshotLocation);

    }
}