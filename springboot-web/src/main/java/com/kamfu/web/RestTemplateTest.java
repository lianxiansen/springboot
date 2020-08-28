package com.kamfu.web;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
    public static void main(String[] args) {
        RestTemplate restT = new RestTemplate();
        //通过Jackson JSON processing library直接将返回值绑定到对象
        Object quote = restT.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Object.class);
        String quoteString = restT.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
        System.out.println(quoteString);
    }
}