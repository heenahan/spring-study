package com.spring.mvcbasic.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "spring";

        log.trace("trace level = {}", name);
        log.debug("debug level = {}", name);
        log.info("info level = {}", name);
        log.warn("warn level = {}", name);
        log.error("error level = {}", name);

        return "ok";
    }

}
