package com.mapsynq.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mapsynq.basest.baseUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import com.mapsynq.basest.baseclass;

public class utility extends baseUtil {

    private baseUtil base;

    public utility(baseUtil base){
        this.base=base;
    }

    @Rule
    public TestRule Listen=  new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            try {
                takeScreenshotAtEndOfTest (description.getClassName()+","+description.getMethodName());
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    };

    public  void takeScreenshotAtEndOfTest(String name) throws IOException {
        String DateName=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
        File scrFile = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.FILE);
        String Destination=System.getProperty("G:\\Mapsynq\\Mapsynq\\src\\main\\java\\com\\mapsynq\\screenshot")+name+DateName+".png";
        FileUtils.copyFile(scrFile, new File(Destination));
    }


    }

