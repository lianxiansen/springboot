package com.kamfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Box;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedList;
import com.kamfu.model.PagedResponse;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/box")
public class BoxController extends BaseController{
	private String PREFIX = "box/";
    @RequestMapping("index")
    public String index() {
        return PREFIX + "index.html";
    }

    @RequestMapping(value = "/pagedList")
    @ResponseBody
    public BaseResponse pagedList(int page,int limit,String cabinetName) {
    	 PagedList<Box> pagedList=boxService.selectPagedList(cabinetName,page, limit);
    	 return PagedResponse.success("成功",pagedList.getData(),pagedList.getCount());
    }
    
}