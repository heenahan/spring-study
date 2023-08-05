package com.spring.mvcbasic.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestTextController {

    @GetMapping("/request-text-v1")
    public void requestTextV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("message body = {}", body);
        response.getWriter().write("ok");
    }

    @GetMapping("/request-text-v2")
    public void requestTextV2(InputStream inputStream, Writer response) throws IOException {
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("message body = {}", body);
        response.write("ok");
    }

    @GetMapping("/request-text-v3")
    public HttpEntity<String> requestTextV3(HttpEntity<String> httpEntity){
        String body = httpEntity.getBody();
        log.info("message body = {}", body);
        return new HttpEntity<>("ok");
    }

    @ResponseBody
    @GetMapping("/request-text-v4")
    public String requestTextV4(@RequestBody String body) {
        log.info("message body = {}", body);
        return "ok";
    }
}