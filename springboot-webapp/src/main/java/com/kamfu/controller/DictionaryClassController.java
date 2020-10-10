package com.kamfu.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.DictionaryClass;
import com.kamfu.entity.User;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedList;
import com.kamfu.model.PagedResponse;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/dictionaryClass")
public class DictionaryClassController extends BaseController{


    @RequestMapping(value = "/pagedList")
    @ResponseBody
    public BaseResponse pagedList(int page,int limit) {
    	 PagedList<DictionaryClass> pagedList=dictionaryClassService.selectPagedList(page, limit);
    	 return PagedResponse.success("成功",pagedList.getData(),pagedList.getCount());
    }
    
}
