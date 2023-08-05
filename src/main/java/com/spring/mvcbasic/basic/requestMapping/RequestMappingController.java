package com.spring.mvcbasic.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestMappingController {

    @RequestMapping({"hello-basic", "hello-go"})
    public String hello() {
        log.info("data = {}", "hello");
        return "ok";
    }

    @RequestMapping(value = "mapping-get-v1", method = RequestMethod.GET)
    public String getV1() {
        log.info("mapping-get-v1");
        return "ok";
    }

    @GetMapping("mapping-get-v2")
    public String getV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    // 변수명 같을 시 생략 가능
    @GetMapping("/user/{userId}")
    public String user(@PathVariable("userId") String data) {
        log.info("data = {}", data);
        return "ok";
    }

    @GetMapping("/user/{userId}/order/{orderId}")
    public String order(@PathVariable("orderId") String userId, @PathVariable String orderId) {
        log.info("userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    // 특정 파라미터로 매핑
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String param() {
        return "ok";
    }

    // 특정 헤더로 매핑
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String header() {
        return "ok";
    }

    // 미디어 타입
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String consume() {
        return "ok";
    }

    @GetMapping(value = "/mapping-produce", produces = MediaType.TEXT_PLAIN_VALUE)
    public String produce() {
        return "ok";
    }

}
