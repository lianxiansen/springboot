package com.kamfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Deliver;
import com.kamfu.mapper.DeliverMapper;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedList;
import com.kamfu.model.PagedResponse;
import com.kamfu.model.param.DeliverParam;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/deliver")
public class DeliverController extends BaseController{
	private String PREFIX = "deliver/";
	@Autowired
	private DeliverMapper deliverMapper;
    @RequestMapping("index")
    public String index() {
        return PREFIX + "index.html";
    }

    @RequestMapping(value = "/pagedList")
    @ResponseBody
    public BaseResponse pagedList(int page,int limit,String addr,Integer packgeStatu,String pickupPhone) {
    	DeliverParam param=new DeliverParam()
    			.setStart((page-1)*pagesize).setPage(page)
    			.setLimit(pagesize)
    			.setAddr(addr).setPackgeStatu(packgeStatu).setPickupPhone(pickupPhone);
    	 PagedList<Deliver> pagedList=deliverService.selectPagedList(param);
    	 return PagedResponse.success("成功",pagedList.getData(),pagedList.getCount());
    }
    
}
