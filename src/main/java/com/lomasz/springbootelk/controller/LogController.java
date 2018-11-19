package com.lomasz.springbootelk.controller;

import com.lomasz.springbootelk.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.time.ZoneOffset.UTC;

@RestController
@RequiredArgsConstructor
@CommonsLog
public class LogController {

    private final LogService logService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/api/log")
    public void log(){
        log.error("This is error in the controller");
        log.warn("This is warning in the controller");
        log.info("This is info in the controller");
        log.debug("This is debug in the controller");
        log.trace("This is trace in the controller");
        logService.log();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/api/log")
    public LocalDateTime log(@RequestBody String message){
        log.error("error message in the controller: " + message);
        log.warn("warning message in the controller: " + message);
        log.info("info message in the controller: " + message);
        log.debug("debug message in the controller: " + message);
        log.trace("trace message in the controller: " + message);
        logService.log(message);
        return now(UTC);
    }
}

