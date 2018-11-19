package com.lomasz.springbootelk.service;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
public class LogService {

    public void log(){
        log.error("This is error in the service");
        log.warn("This is warning in the service");
        log.info("This is info in the service");
        log.debug("This is debug in the service");
        log.trace("This is trace in the service");
    }

    public void log(String message){
        log.error("error message in the service: " + message);
        log.warn("warning message in the service: " + message);
        log.info("info message in the service: " + message);
        log.debug("debug message in the service: " + message);
        log.trace("trace message in the service: " + message);
    }
}

