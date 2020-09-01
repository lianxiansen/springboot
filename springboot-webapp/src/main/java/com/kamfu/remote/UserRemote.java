package com.kamfu.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kamfu.model.AjaxResponse;

@FeignClient(name ="springboot-web")
public interface UserRemote {

    @GetMapping("/test/getUser")
    String getUser(@RequestParam(value = "username") String name);

}