package com.kamfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Dictionary;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedList;
import com.kamfu.model.PagedResponse;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController{
	private String PREFIX = "system/";
    @RequestMapping("index")
    public String index() {
        return PREFIX + "dictionary.html";
    }

    @RequestMapping(value = "/pagedList")
    @ResponseBody
    public BaseResponse pagedList(int page,int limit,Long dictionaryClassId) {
    	 PagedList<Dictionary> pagedList=dictionaryService.selectPagedList(dictionaryClassId,page, limit);
    	 return PagedResponse.success("成功",pagedList.getData(),pagedList.getCount());
    }
    
}
