package ua.com.method.error_log;

import org.springframework.stereotype.Component;
import ua.com.controllers.controllers_bet.RestControllerBet;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Logs {
    private static final Logger logger = Logger.getLogger(RestControllerBet.class.getName());

    private FileHandler fileHandler;

    public void logError (Exception error){
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
                        +"log");
        } catch (IOException e) {
            logger.info(e.toString());

        }
    }
        logger.addHandler(fileHandler);
        logger.log( Level.ALL, error.toString(), error );
    }
}
