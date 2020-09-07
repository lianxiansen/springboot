package com.kamfu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kamfu.entity.User;
import com.kamfu.model.BaseResponse;
import com.kamfu.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserService userService;
	
	@Value("${config.producer.instance:0}")
	private int instance;
	@GetMapping("/getUser")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request,String username){
    	return "[instance：" + instance + "]"+BaseResponse.success("成功",getUser(username)).toJSONString();
    }
    private User getUser(String username) {
    	return userService.getByUsername(username);
    }
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = discoveryClient.getServices(); //发现eureka中的微服务列表
        System.out.println("eureka中所有的微服务的name列表" + list);

        //从eureka中获取指定name的微服务的信息(yml文件中配置的 spring.application.name)
        List<ServiceInstance> instances = discoveryClient.getInstances(list.get(0));
        for(ServiceInstance instance : instances)
        {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t"
            + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
