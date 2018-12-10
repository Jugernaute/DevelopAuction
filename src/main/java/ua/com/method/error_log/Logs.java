package ua.com.method.error_log;

import jdk.nashorn.internal.objects.Global;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;


@Component
public class Logs {
//    private static final Logger logger = Logger.getLogger(Global.class.getName());

    private FileHandler fileHandler;

    public void logError (Logger logger, Exception error){
    {
        try {
            fileHandler = new FileHandler("%h"
                        +File.separator
                        +"IdeaProjects"
                        +File.separator
                        +"DevelopAuction1"
                        +File.separator
                        +"src"
                        +File.separator
                        +"main"
                        +File.separator
                        +"resources"
                        +File.separator
                        + "logError"
                        +File.separator
                        +"log.log");
        } catch (IOException e) {
            logger.info(e.toString());
        }
    }
//        logger.addHandler(fileHandler);
        logger.log( Level.ALL,"getLocalizedMessage",error);
//        logger.log( Level.INFO,"getMessage",error.getMessage());
//        logger.log( Level.INFO,"toString",error.toString());
//        logger.info( error.toString());
    }
}
