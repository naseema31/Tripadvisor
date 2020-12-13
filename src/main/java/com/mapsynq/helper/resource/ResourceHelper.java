package com.mapsynq.helper.resource;

import com.mapsynq.helper.alert.AlertHelper;
import com.mapsynq.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;

/**
 * Created by asit.singh on 18-01-2019.
 */
public class ResourceHelper  {

    public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        return basePath +"/"+ path;
    }
}
