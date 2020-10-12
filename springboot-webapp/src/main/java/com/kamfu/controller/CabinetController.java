package com.kamfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Cabinet;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedList;
import com.kamfu.model.PagedResponse;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/cabinet")
public class CabinetController extends BaseController{
	private String PREFIX = "cabinet/";
    @RequestMapping("index")
    public String index() {
        return PREFIX + "index.html";
    }

    @RequestMapping(value = "/pagedList")
    @ResponseBody
    public BaseResponse pagedList(Long deptId,int page,int limit) {
    	if(null==deptId) {
    		deptId=getUser().getDeptId();
    	}
    	 PagedList<Cabinet> pagedList=cabinetService.selectPagedList(deptId, page, limit);
    	 return PagedResponse.success("成功",pagedList.getData(),pagedList.getCount());
    }
    
}
