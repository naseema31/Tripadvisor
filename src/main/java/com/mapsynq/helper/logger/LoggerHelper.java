package com.mapsynq.helper.logger;

import com.mapsynq.helper.resource.ResourceHelper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {

    private static boolean root=false;

    public static Logger getLogger(Class cls){
        if(root){
            return Logger.getLogger(cls);
        }
       // PropertyConfigurator.configure(ResourceHelper.getResourcePath("src/main/java/com/mapsynq/helper/resource/log4j.properties"));
      //  PropertyConfigurator.configure(ResourceHelper.getResourcePath("src\\test\\log4j.xml"));
        root = true;
        return Logger.getLogger(cls);
    }

}
