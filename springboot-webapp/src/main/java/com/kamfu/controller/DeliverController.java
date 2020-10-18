package com.kamfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Deliver;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedList;
import com.kamfu.model.PagedResponse;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/deliver")
public class DeliverController extends BaseController{
	private String PREFIX = "deliver/";
    @RequestMapping("index")
    public String index() {
        return PREFIX + "index.html";
    }

    @RequestMapping(value = "/pagedList")
    @ResponseBody
    public BaseResponse pagedList(int page,int limit) {
    	 PagedList<Deliver> pagedList=deliverService.selectPagedList(page, limit);
    	 return PagedResponse.success("成功",pagedList.getData(),pagedList.getCount());
    }
    
}
